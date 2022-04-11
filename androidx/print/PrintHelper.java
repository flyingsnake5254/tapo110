package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

public final class PrintHelper
{
  @SuppressLint({"InlinedApi"})
  public static final int COLOR_MODE_COLOR = 2;
  @SuppressLint({"InlinedApi"})
  public static final int COLOR_MODE_MONOCHROME = 1;
  static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
  private static final String LOG_TAG = "PrintHelper";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    if ((i >= 20) && (i <= 23)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    PRINT_ACTIVITY_RESPECTS_ORIENTATION = bool2;
    boolean bool2 = bool1;
    if (i != 23) {
      bool2 = true;
    }
    IS_MIN_MARGINS_HANDLING_CORRECT = bool2;
  }
  
  public PrintHelper(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  static Bitmap convertBitmapForColorMode(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 1) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }
  
  @RequiresApi(19)
  private static PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder().setMediaSize(paramPrintAttributes.getMediaSize()).setResolution(paramPrintAttributes.getResolution()).setMinMargins(paramPrintAttributes.getMinMargins());
    if (paramPrintAttributes.getColorMode() != 0) {
      localBuilder.setColorMode(paramPrintAttributes.getColorMode());
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramPrintAttributes.getDuplexMode() != 0)) {
      localBuilder.setDuplexMode(paramPrintAttributes.getDuplexMode());
    }
    return localBuilder;
  }
  
  static Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramRectF.width();
    float f2 = paramInt1;
    f1 /= f2;
    if (paramInt3 == 2) {
      f1 = Math.max(f1, paramRectF.height() / paramInt2);
    } else {
      f1 = Math.min(f1, paramRectF.height() / paramInt2);
    }
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate((paramRectF.width() - f2 * f1) / 2.0F, (paramRectF.height() - paramInt2 * f1) / 2.0F);
    return localMatrix;
  }
  
  static boolean isPortrait(Bitmap paramBitmap)
  {
    boolean bool;
    if (paramBitmap.getWidth() <= paramBitmap.getHeight()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +87 -> 88
    //   4: aload_0
    //   5: getfield 78	androidx/print/PrintHelper:mContext	Landroid/content/Context;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +78 -> 88
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_3
    //   17: invokevirtual 222	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: aload_1
    //   21: invokevirtual 228	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   24: astore_3
    //   25: aload_3
    //   26: aconst_null
    //   27: aload_2
    //   28: invokestatic 234	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   31: astore_1
    //   32: aload_3
    //   33: ifnull +20 -> 53
    //   36: aload_3
    //   37: invokevirtual 239	java/io/InputStream:close	()V
    //   40: goto +13 -> 53
    //   43: astore_2
    //   44: ldc 33
    //   46: ldc -15
    //   48: aload_2
    //   49: invokestatic 247	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   52: pop
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: goto +7 -> 65
    //   61: astore_1
    //   62: aload 4
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +20 -> 86
    //   69: aload_2
    //   70: invokevirtual 239	java/io/InputStream:close	()V
    //   73: goto +13 -> 86
    //   76: astore_2
    //   77: ldc 33
    //   79: ldc -15
    //   81: aload_2
    //   82: invokestatic 247	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   85: pop
    //   86: aload_1
    //   87: athrow
    //   88: new 249	java/lang/IllegalArgumentException
    //   91: dup
    //   92: ldc -5
    //   94: invokespecial 254	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	PrintHelper
    //   0	98	1	paramUri	Uri
    //   0	98	2	paramOptions	BitmapFactory.Options
    //   8	49	3	localObject1	Object
    //   14	49	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	40	43	java/io/IOException
    //   25	32	55	finally
    //   16	25	61	finally
    //   69	73	76	java/io/IOException
  }
  
  public static boolean systemSupportsPrint()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.mOrientation == 0)) {
      return 1;
    }
    return this.mOrientation;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  /* Error */
  Bitmap loadConstrainedBitmap(Uri arg1)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +203 -> 204
    //   4: aload_0
    //   5: getfield 78	androidx/print/PrintHelper:mContext	Landroid/content/Context;
    //   8: ifnull +196 -> 204
    //   11: new 263	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 264	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore_2
    //   19: aload_2
    //   20: iconst_1
    //   21: putfield 267	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 269	androidx/print/PrintHelper:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   30: pop
    //   31: aload_2
    //   32: getfield 272	android/graphics/BitmapFactory$Options:outWidth	I
    //   35: istore_3
    //   36: aload_2
    //   37: getfield 275	android/graphics/BitmapFactory$Options:outHeight	I
    //   40: istore 4
    //   42: iload_3
    //   43: ifle +159 -> 202
    //   46: iload 4
    //   48: ifgt +6 -> 54
    //   51: goto +151 -> 202
    //   54: iload_3
    //   55: iload 4
    //   57: invokestatic 278	java/lang/Math:max	(II)I
    //   60: istore 5
    //   62: iconst_1
    //   63: istore 6
    //   65: iload 5
    //   67: sipush 3500
    //   70: if_icmple +18 -> 88
    //   73: iload 5
    //   75: iconst_1
    //   76: iushr
    //   77: istore 5
    //   79: iload 6
    //   81: iconst_1
    //   82: ishl
    //   83: istore 6
    //   85: goto -20 -> 65
    //   88: iload 6
    //   90: ifle +112 -> 202
    //   93: iload_3
    //   94: iload 4
    //   96: invokestatic 280	java/lang/Math:min	(II)I
    //   99: iload 6
    //   101: idiv
    //   102: ifgt +6 -> 108
    //   105: goto +97 -> 202
    //   108: aload_0
    //   109: getfield 70	androidx/print/PrintHelper:mLock	Ljava/lang/Object;
    //   112: astore_2
    //   113: aload_2
    //   114: monitorenter
    //   115: new 263	android/graphics/BitmapFactory$Options
    //   118: astore 7
    //   120: aload 7
    //   122: invokespecial 264	android/graphics/BitmapFactory$Options:<init>	()V
    //   125: aload_0
    //   126: aload 7
    //   128: putfield 68	androidx/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   131: aload 7
    //   133: iconst_1
    //   134: putfield 283	android/graphics/BitmapFactory$Options:inMutable	Z
    //   137: aload 7
    //   139: iload 6
    //   141: putfield 286	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   144: aload_2
    //   145: monitorexit
    //   146: aload_0
    //   147: aload_1
    //   148: aload 7
    //   150: invokespecial 269	androidx/print/PrintHelper:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   153: astore_2
    //   154: aload_0
    //   155: getfield 70	androidx/print/PrintHelper:mLock	Ljava/lang/Object;
    //   158: astore_1
    //   159: aload_1
    //   160: monitorenter
    //   161: aload_0
    //   162: aconst_null
    //   163: putfield 68	androidx/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   166: aload_1
    //   167: monitorexit
    //   168: aload_2
    //   169: areturn
    //   170: astore_2
    //   171: aload_1
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    //   175: astore_2
    //   176: aload_0
    //   177: getfield 70	androidx/print/PrintHelper:mLock	Ljava/lang/Object;
    //   180: astore_1
    //   181: aload_1
    //   182: monitorenter
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 68	androidx/print/PrintHelper:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   188: aload_1
    //   189: monitorexit
    //   190: aload_2
    //   191: athrow
    //   192: astore_2
    //   193: aload_1
    //   194: monitorexit
    //   195: aload_2
    //   196: athrow
    //   197: astore_1
    //   198: aload_2
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    //   202: aconst_null
    //   203: areturn
    //   204: new 249	java/lang/IllegalArgumentException
    //   207: dup
    //   208: ldc_w 288
    //   211: invokespecial 254	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	PrintHelper
    //   18	151	2	localObject1	Object
    //   170	4	2	localObject2	Object
    //   175	16	2	localObject3	Object
    //   192	7	2	localObject4	Object
    //   35	59	3	i	int
    //   40	55	4	j	int
    //   60	18	5	k	int
    //   63	77	6	m	int
    //   118	31	7	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   161	168	170	finally
    //   171	173	170	finally
    //   146	154	175	finally
    //   183	190	192	finally
    //   193	195	192	finally
    //   115	146	197	finally
    //   198	200	197	finally
  }
  
  public void printBitmap(@NonNull String paramString, @NonNull Bitmap paramBitmap)
  {
    printBitmap(paramString, paramBitmap, null);
  }
  
  public void printBitmap(@NonNull String paramString, @NonNull Bitmap paramBitmap, @Nullable OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (paramBitmap != null))
    {
      PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
      if (isPortrait(paramBitmap)) {
        localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
      } else {
        localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
      }
      Object localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintBitmapAdapter(paramString, this.mScaleMode, paramBitmap, paramOnPrintFinishCallback), (PrintAttributes)localObject);
    }
  }
  
  public void printBitmap(@NonNull String paramString, @NonNull Uri paramUri)
    throws FileNotFoundException
  {
    printBitmap(paramString, paramUri, null);
  }
  
  public void printBitmap(@NonNull String paramString, @NonNull Uri paramUri, @Nullable OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    paramOnPrintFinishCallback = new PrintUriAdapter(paramString, paramUri, paramOnPrintFinishCallback, this.mScaleMode);
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    paramUri = new PrintAttributes.Builder();
    paramUri.setColorMode(this.mColorMode);
    int i = this.mOrientation;
    if ((i != 1) && (i != 0))
    {
      if (i == 2) {
        paramUri.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
    else {
      paramUri.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    localPrintManager.print(paramString, paramOnPrintFinishCallback, paramUri.build());
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
  
  @RequiresApi(19)
  void writeBitmap(final PrintAttributes paramPrintAttributes, final int paramInt, final Bitmap paramBitmap, final ParcelFileDescriptor paramParcelFileDescriptor, final CancellationSignal paramCancellationSignal, final PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    final PrintAttributes localPrintAttributes;
    if (IS_MIN_MARGINS_HANDLING_CORRECT) {
      localPrintAttributes = paramPrintAttributes;
    } else {
      localPrintAttributes = copyAttributes(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
    }
    new AsyncTask()
    {
      /* Error */
      protected Throwable doInBackground(Void... paramAnonymousVarArgs)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 31	androidx/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
        //   4: invokevirtual 62	android/os/CancellationSignal:isCanceled	()Z
        //   7: ifeq +5 -> 12
        //   10: aconst_null
        //   11: areturn
        //   12: new 64	android/print/pdf/PrintedPdfDocument
        //   15: astore_2
        //   16: aload_2
        //   17: aload_0
        //   18: getfield 29	androidx/print/PrintHelper$1:this$0	Landroidx/print/PrintHelper;
        //   21: getfield 68	androidx/print/PrintHelper:mContext	Landroid/content/Context;
        //   24: aload_0
        //   25: getfield 33	androidx/print/PrintHelper$1:val$pdfAttributes	Landroid/print/PrintAttributes;
        //   28: invokespecial 71	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   31: aload_0
        //   32: getfield 35	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
        //   35: aload_0
        //   36: getfield 33	androidx/print/PrintHelper$1:val$pdfAttributes	Landroid/print/PrintAttributes;
        //   39: invokevirtual 77	android/print/PrintAttributes:getColorMode	()I
        //   42: invokestatic 81	androidx/print/PrintHelper:convertBitmapForColorMode	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   45: astore_3
        //   46: aload_0
        //   47: getfield 31	androidx/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
        //   50: invokevirtual 62	android/os/CancellationSignal:isCanceled	()Z
        //   53: istore 4
        //   55: iload 4
        //   57: ifeq +5 -> 62
        //   60: aconst_null
        //   61: areturn
        //   62: aload_2
        //   63: iconst_1
        //   64: invokevirtual 85	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   67: astore 5
        //   69: getstatic 89	androidx/print/PrintHelper:IS_MIN_MARGINS_HANDLING_CORRECT	Z
        //   72: istore 4
        //   74: iload 4
        //   76: ifeq +22 -> 98
        //   79: new 91	android/graphics/RectF
        //   82: astore_1
        //   83: aload_1
        //   84: aload 5
        //   86: invokevirtual 97	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   89: invokevirtual 103	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   92: invokespecial 106	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   95: goto +60 -> 155
        //   98: new 64	android/print/pdf/PrintedPdfDocument
        //   101: astore 6
        //   103: aload 6
        //   105: aload_0
        //   106: getfield 29	androidx/print/PrintHelper$1:this$0	Landroidx/print/PrintHelper;
        //   109: getfield 68	androidx/print/PrintHelper:mContext	Landroid/content/Context;
        //   112: aload_0
        //   113: getfield 37	androidx/print/PrintHelper$1:val$attributes	Landroid/print/PrintAttributes;
        //   116: invokespecial 71	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   119: aload 6
        //   121: iconst_1
        //   122: invokevirtual 85	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   125: astore 7
        //   127: new 91	android/graphics/RectF
        //   130: astore_1
        //   131: aload_1
        //   132: aload 7
        //   134: invokevirtual 97	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   137: invokevirtual 103	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   140: invokespecial 106	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   143: aload 6
        //   145: aload 7
        //   147: invokevirtual 110	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   150: aload 6
        //   152: invokevirtual 113	android/print/pdf/PrintedPdfDocument:close	()V
        //   155: aload_3
        //   156: invokevirtual 118	android/graphics/Bitmap:getWidth	()I
        //   159: aload_3
        //   160: invokevirtual 121	android/graphics/Bitmap:getHeight	()I
        //   163: aload_1
        //   164: aload_0
        //   165: getfield 39	androidx/print/PrintHelper$1:val$fittingMode	I
        //   168: invokestatic 125	androidx/print/PrintHelper:getMatrix	(IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
        //   171: astore 6
        //   173: iload 4
        //   175: ifeq +6 -> 181
        //   178: goto +27 -> 205
        //   181: aload 6
        //   183: aload_1
        //   184: getfield 129	android/graphics/RectF:left	F
        //   187: aload_1
        //   188: getfield 132	android/graphics/RectF:top	F
        //   191: invokevirtual 138	android/graphics/Matrix:postTranslate	(FF)Z
        //   194: pop
        //   195: aload 5
        //   197: invokevirtual 142	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   200: aload_1
        //   201: invokevirtual 148	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
        //   204: pop
        //   205: aload 5
        //   207: invokevirtual 142	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   210: aload_3
        //   211: aload 6
        //   213: aconst_null
        //   214: invokevirtual 152	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
        //   217: aload_2
        //   218: aload 5
        //   220: invokevirtual 110	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   223: aload_0
        //   224: getfield 31	androidx/print/PrintHelper$1:val$cancellationSignal	Landroid/os/CancellationSignal;
        //   227: invokevirtual 62	android/os/CancellationSignal:isCanceled	()Z
        //   230: istore 4
        //   232: iload 4
        //   234: ifeq +34 -> 268
        //   237: aload_2
        //   238: invokevirtual 113	android/print/pdf/PrintedPdfDocument:close	()V
        //   241: aload_0
        //   242: getfield 41	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
        //   245: astore_1
        //   246: aload_1
        //   247: ifnull +7 -> 254
        //   250: aload_1
        //   251: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
        //   254: aload_3
        //   255: aload_0
        //   256: getfield 35	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
        //   259: if_acmpeq +7 -> 266
        //   262: aload_3
        //   263: invokevirtual 158	android/graphics/Bitmap:recycle	()V
        //   266: aconst_null
        //   267: areturn
        //   268: new 160	java/io/FileOutputStream
        //   271: astore_1
        //   272: aload_1
        //   273: aload_0
        //   274: getfield 41	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
        //   277: invokevirtual 164	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   280: invokespecial 167	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
        //   283: aload_2
        //   284: aload_1
        //   285: invokevirtual 171	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
        //   288: aload_2
        //   289: invokevirtual 113	android/print/pdf/PrintedPdfDocument:close	()V
        //   292: aload_0
        //   293: getfield 41	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
        //   296: astore_1
        //   297: aload_1
        //   298: ifnull +7 -> 305
        //   301: aload_1
        //   302: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
        //   305: aload_3
        //   306: aload_0
        //   307: getfield 35	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
        //   310: if_acmpeq +7 -> 317
        //   313: aload_3
        //   314: invokevirtual 158	android/graphics/Bitmap:recycle	()V
        //   317: aconst_null
        //   318: areturn
        //   319: astore_1
        //   320: aload_2
        //   321: invokevirtual 113	android/print/pdf/PrintedPdfDocument:close	()V
        //   324: aload_0
        //   325: getfield 41	androidx/print/PrintHelper$1:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
        //   328: astore_2
        //   329: aload_2
        //   330: ifnull +7 -> 337
        //   333: aload_2
        //   334: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
        //   337: aload_3
        //   338: aload_0
        //   339: getfield 35	androidx/print/PrintHelper$1:val$bitmap	Landroid/graphics/Bitmap;
        //   342: if_acmpeq +7 -> 349
        //   345: aload_3
        //   346: invokevirtual 158	android/graphics/Bitmap:recycle	()V
        //   349: aload_1
        //   350: athrow
        //   351: astore_1
        //   352: aload_1
        //   353: areturn
        //   354: astore_1
        //   355: goto -101 -> 254
        //   358: astore_1
        //   359: goto -54 -> 305
        //   362: astore_2
        //   363: goto -26 -> 337
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	366	0	this	1
        //   0	366	1	paramAnonymousVarArgs	Void[]
        //   15	319	2	localObject1	Object
        //   362	1	2	localIOException	java.io.IOException
        //   45	301	3	localBitmap	Bitmap
        //   53	180	4	bool	boolean
        //   67	152	5	localPage1	android.graphics.pdf.PdfDocument.Page
        //   101	111	6	localObject2	Object
        //   125	21	7	localPage2	android.graphics.pdf.PdfDocument.Page
        // Exception table:
        //   from	to	target	type
        //   62	74	319	finally
        //   79	95	319	finally
        //   98	155	319	finally
        //   155	173	319	finally
        //   181	205	319	finally
        //   205	232	319	finally
        //   268	288	319	finally
        //   0	10	351	finally
        //   12	55	351	finally
        //   237	246	351	finally
        //   250	254	351	finally
        //   254	266	351	finally
        //   288	297	351	finally
        //   301	305	351	finally
        //   305	317	351	finally
        //   320	329	351	finally
        //   333	337	351	finally
        //   337	349	351	finally
        //   349	351	351	finally
        //   250	254	354	java/io/IOException
        //   301	305	358	java/io/IOException
        //   333	337	362	java/io/IOException
      }
      
      protected void onPostExecute(Throwable paramAnonymousThrowable)
      {
        if (paramCancellationSignal.isCanceled())
        {
          paramWriteResultCallback.onWriteCancelled();
        }
        else if (paramAnonymousThrowable == null)
        {
          paramWriteResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
        }
        else
        {
          Log.e("PrintHelper", "Error writing printed content", paramAnonymousThrowable);
          paramWriteResultCallback.onWriteFailed(null);
        }
      }
    }.execute(new Void[0]);
  }
  
  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
  
  @RequiresApi(19)
  private class PrintBitmapAdapter
    extends PrintDocumentAdapter
  {
    private PrintAttributes mAttributes;
    private final Bitmap mBitmap;
    private final PrintHelper.OnPrintFinishCallback mCallback;
    private final int mFittingMode;
    private final String mJobName;
    
    PrintBitmapAdapter(String paramString, int paramInt, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
    {
      this.mJobName = paramString;
      this.mFittingMode = paramInt;
      this.mBitmap = paramBitmap;
      this.mCallback = paramOnPrintFinishCallback;
    }
    
    public void onFinish()
    {
      PrintHelper.OnPrintFinishCallback localOnPrintFinishCallback = this.mCallback;
      if (localOnPrintFinishCallback != null) {
        localOnPrintFinishCallback.onFinish();
      }
    }
    
    public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
    {
      this.mAttributes = paramPrintAttributes2;
      paramLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), paramPrintAttributes2.equals(paramPrintAttributes1) ^ true);
    }
    
    public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
    {
      PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
    }
  }
  
  @RequiresApi(19)
  private class PrintUriAdapter
    extends PrintDocumentAdapter
  {
    PrintAttributes mAttributes;
    Bitmap mBitmap;
    final PrintHelper.OnPrintFinishCallback mCallback;
    final int mFittingMode;
    final Uri mImageFile;
    final String mJobName;
    AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
    
    PrintUriAdapter(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback, int paramInt)
    {
      this.mJobName = paramString;
      this.mImageFile = paramUri;
      this.mCallback = paramOnPrintFinishCallback;
      this.mFittingMode = paramInt;
      this.mBitmap = null;
    }
    
    void cancelLoad()
    {
      synchronized (PrintHelper.this.mLock)
      {
        BitmapFactory.Options localOptions = PrintHelper.this.mDecodeOptions;
        if (localOptions != null)
        {
          if (Build.VERSION.SDK_INT < 24) {
            localOptions.requestCancelDecode();
          }
          PrintHelper.this.mDecodeOptions = null;
        }
        return;
      }
    }
    
    public void onFinish()
    {
      super.onFinish();
      cancelLoad();
      Object localObject = this.mLoadBitmap;
      if (localObject != null) {
        ((AsyncTask)localObject).cancel(true);
      }
      localObject = this.mCallback;
      if (localObject != null) {
        ((PrintHelper.OnPrintFinishCallback)localObject).onFinish();
      }
      localObject = this.mBitmap;
      if (localObject != null)
      {
        ((Bitmap)localObject).recycle();
        this.mBitmap = null;
      }
    }
    
    public void onLayout(final PrintAttributes paramPrintAttributes1, final PrintAttributes paramPrintAttributes2, final CancellationSignal paramCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
    {
      try
      {
        this.mAttributes = paramPrintAttributes2;
        if (paramCancellationSignal.isCanceled())
        {
          paramLayoutResultCallback.onLayoutCancelled();
          return;
        }
        if (this.mBitmap != null)
        {
          paramLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), paramPrintAttributes2.equals(paramPrintAttributes1) ^ true);
          return;
        }
        this.mLoadBitmap = new AsyncTask()
        {
          protected Bitmap doInBackground(Uri... paramAnonymousVarArgs)
          {
            try
            {
              paramAnonymousVarArgs = PrintHelper.PrintUriAdapter.this;
              paramAnonymousVarArgs = paramAnonymousVarArgs.this$0.loadConstrainedBitmap(paramAnonymousVarArgs.mImageFile);
              return paramAnonymousVarArgs;
            }
            catch (FileNotFoundException paramAnonymousVarArgs) {}
            return null;
          }
          
          protected void onCancelled(Bitmap paramAnonymousBitmap)
          {
            paramLayoutResultCallback.onLayoutCancelled();
            PrintHelper.PrintUriAdapter.this.mLoadBitmap = null;
          }
          
          protected void onPostExecute(Bitmap paramAnonymousBitmap)
          {
            super.onPostExecute(paramAnonymousBitmap);
            Object localObject = paramAnonymousBitmap;
            if (paramAnonymousBitmap != null) {
              if (PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION)
              {
                localObject = paramAnonymousBitmap;
                if (PrintHelper.this.mOrientation != 0) {}
              }
              else
              {
                try
                {
                  PrintAttributes.MediaSize localMediaSize = PrintHelper.PrintUriAdapter.this.mAttributes.getMediaSize();
                  localObject = paramAnonymousBitmap;
                  if (localMediaSize != null)
                  {
                    localObject = paramAnonymousBitmap;
                    if (localMediaSize.isPortrait() != PrintHelper.isPortrait(paramAnonymousBitmap))
                    {
                      localObject = new Matrix();
                      ((Matrix)localObject).postRotate(90.0F);
                      localObject = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight(), (Matrix)localObject, true);
                    }
                  }
                }
                finally {}
              }
            }
            PrintHelper.PrintUriAdapter.this.mBitmap = ((Bitmap)localObject);
            if (localObject != null)
            {
              paramAnonymousBitmap = new PrintDocumentInfo.Builder(PrintHelper.PrintUriAdapter.this.mJobName).setContentType(1).setPageCount(1).build();
              boolean bool = paramPrintAttributes2.equals(paramPrintAttributes1);
              paramLayoutResultCallback.onLayoutFinished(paramAnonymousBitmap, true ^ bool);
            }
            else
            {
              paramLayoutResultCallback.onLayoutFailed(null);
            }
            PrintHelper.PrintUriAdapter.this.mLoadBitmap = null;
          }
          
          protected void onPreExecute()
          {
            paramCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
            {
              public void onCancel()
              {
                PrintHelper.PrintUriAdapter.this.cancelLoad();
                PrintHelper.PrintUriAdapter.1.this.cancel(false);
              }
            });
          }
        }.execute(new Uri[0]);
        return;
      }
      finally {}
    }
    
    public void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
    {
      PrintHelper.this.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, paramParcelFileDescriptor, paramCancellationSignal, paramWriteResultCallback);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\print\PrintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
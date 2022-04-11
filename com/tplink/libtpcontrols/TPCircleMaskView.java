package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TPCircleMaskView
  extends AppCompatImageView
{
  private static final Xfermode c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  private static final Xfermode d = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
  private static ExecutorService f = Executors.newFixedThreadPool(4);
  private float p0;
  private e p1;
  private Paint q = null;
  private int x;
  private float y;
  private int z;
  
  public TPCircleMaskView(Context paramContext)
  {
    super(paramContext);
    this.x = -1;
    this.y = 0.0F;
    this.z = 0;
  }
  
  public TPCircleMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TPCircleMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x0.TPCircleMaskView);
    this.x = paramContext.getColor(x0.TPCircleMaskView_tp_strokeColor, -1);
    float f1 = paramContext.getDimension(x0.TPCircleMaskView_tp_strokeWidth, 0.0F);
    this.y = f1;
    this.z = ((int)(2.0F * f1));
    this.p0 = f1;
    paramContext.recycle();
  }
  
  private Bitmap a()
  {
    Object localObject = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = Bitmap.createBitmap(getWidth() - this.z, getHeight() - this.z, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas(localBitmap);
    localObject = new Paint(1);
    localCanvas.drawOval(new RectF(0.0F, 0.0F, getWidth() - this.z, getHeight() - this.z), (Paint)localObject);
    return localBitmap;
  }
  
  private Bitmap b()
  {
    Object localObject = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas(localBitmap);
    localObject = new Paint(1);
    ((Paint)localObject).setColor(this.x);
    localCanvas.drawOval(new RectF(0.0F, 0.0F, getWidth(), getHeight()), (Paint)localObject);
    return localBitmap;
  }
  
  private Bitmap c(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if ((paramDrawable instanceof StateListDrawable)) {
      localDrawable = ((StateListDrawable)paramDrawable).getCurrent();
    }
    return Bitmap.createScaledBitmap(((BitmapDrawable)localDrawable).getBitmap(), getWidth() - this.z, getHeight() - this.z, true);
  }
  
  private void f(b paramb, int paramInt)
  {
    if (paramInt != -1) {
      setImageResource(paramInt);
    }
    e locale = this.p1;
    if (locale != null)
    {
      locale.a();
      this.p1 = null;
    }
    paramb = new e(getContext(), paramb, new d(new n(this, paramInt)));
    this.p1 = paramb;
    f.execute(paramb);
  }
  
  private void setImage(b paramb)
  {
    f(paramb, -1);
  }
  
  public void g(String paramString, int paramInt)
  {
    f(new b(paramString), paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.q == null) {
      this.q = new Paint();
    }
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    Bitmap localBitmap = c(getDrawable());
    float f1 = this.y;
    paramCanvas.drawBitmap(localBitmap, f1, f1, this.q);
    if (localBitmap != null) {
      localBitmap.isRecycled();
    }
    this.q.setXfermode(c);
    localBitmap = a();
    f1 = this.y;
    paramCanvas.drawBitmap(localBitmap, f1, f1, this.q);
    if (localBitmap != null) {
      localBitmap.isRecycled();
    }
    if (this.y != 0.0F)
    {
      this.q.setXfermode(d);
      localBitmap = b();
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.q);
      if (localBitmap != null) {
        localBitmap.isRecycled();
      }
    }
    this.q.setXfermode(null);
    paramCanvas.restore();
  }
  
  public void setImageUrl(String paramString)
  {
    setImage(new b(paramString));
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.x = paramInt;
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.y = paramFloat;
    this.z = ((int)(paramFloat * 2.0F));
    invalidate();
  }
  
  static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap);
  }
  
  public static class b
  {
    private static volatile TPCircleMaskView.c a;
    private String b;
    
    b(String paramString)
    {
      this.b = paramString;
    }
    
    /* Error */
    private Bitmap b(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: new 25	java/net/URL
      //   7: astore 4
      //   9: aload 4
      //   11: aload_1
      //   12: invokespecial 27	java/net/URL:<init>	(Ljava/lang/String;)V
      //   15: aload 4
      //   17: invokevirtual 31	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   20: checkcast 33	java/net/HttpURLConnection
      //   23: astore 4
      //   25: aload 4
      //   27: sipush 10000
      //   30: invokevirtual 37	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   33: aload 4
      //   35: sipush 30000
      //   38: invokevirtual 40	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   41: aload 4
      //   43: invokevirtual 44	java/net/HttpURLConnection:getResponseCode	()I
      //   46: sipush 200
      //   49: if_icmpne +260 -> 309
      //   52: new 46	java/io/BufferedInputStream
      //   55: astore_1
      //   56: aload_1
      //   57: aload 4
      //   59: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   62: invokespecial 53	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   65: aload_1
      //   66: astore_3
      //   67: aload 4
      //   69: astore 5
      //   71: sipush 4096
      //   74: newarray <illegal type>
      //   76: astore 6
      //   78: aconst_null
      //   79: astore 7
      //   81: aload_1
      //   82: astore_3
      //   83: aload 4
      //   85: astore 5
      //   87: aload_1
      //   88: aload 6
      //   90: invokevirtual 57	java/io/BufferedInputStream:read	([B)I
      //   93: istore 8
      //   95: iload 8
      //   97: iconst_m1
      //   98: if_icmpne +100 -> 198
      //   101: aload 7
      //   103: ifnull +23 -> 126
      //   106: aload_1
      //   107: astore_3
      //   108: aload 4
      //   110: astore 5
      //   112: aload 7
      //   114: iconst_0
      //   115: aload 7
      //   117: arraylength
      //   118: invokestatic 63	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
      //   121: astore 7
      //   123: goto +6 -> 129
      //   126: aconst_null
      //   127: astore 7
      //   129: aload_1
      //   130: astore_3
      //   131: aload 4
      //   133: astore 5
      //   135: new 65	java/lang/StringBuilder
      //   138: astore 9
      //   140: aload_1
      //   141: astore_3
      //   142: aload 4
      //   144: astore 5
      //   146: aload 9
      //   148: invokespecial 66	java/lang/StringBuilder:<init>	()V
      //   151: aload_1
      //   152: astore_3
      //   153: aload 4
      //   155: astore 5
      //   157: aload 9
      //   159: ldc 68
      //   161: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   164: pop
      //   165: aload_1
      //   166: astore_3
      //   167: aload 4
      //   169: astore 5
      //   171: aload 9
      //   173: aload 7
      //   175: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   178: pop
      //   179: aload_1
      //   180: astore_3
      //   181: aload 4
      //   183: astore 5
      //   185: ldc 77
      //   187: aload 9
      //   189: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   192: invokestatic 87	b/d/w/c/a:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   195: goto +119 -> 314
      //   198: aload 7
      //   200: ifnonnull +9 -> 209
      //   203: iconst_0
      //   204: istore 10
      //   206: goto +14 -> 220
      //   209: aload_1
      //   210: astore_3
      //   211: aload 4
      //   213: astore 5
      //   215: aload 7
      //   217: arraylength
      //   218: istore 10
      //   220: aload_1
      //   221: astore_3
      //   222: aload 4
      //   224: astore 5
      //   226: iload 10
      //   228: iload 8
      //   230: iadd
      //   231: newarray <illegal type>
      //   233: astore 9
      //   235: aload 7
      //   237: ifnull +43 -> 280
      //   240: aload_1
      //   241: astore_3
      //   242: aload 4
      //   244: astore 5
      //   246: aload 7
      //   248: iconst_0
      //   249: aload 9
      //   251: iconst_0
      //   252: aload 7
      //   254: arraylength
      //   255: invokestatic 93	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   258: aload_1
      //   259: astore_3
      //   260: aload 4
      //   262: astore 5
      //   264: aload 6
      //   266: iconst_0
      //   267: aload 9
      //   269: aload 7
      //   271: arraylength
      //   272: iload 8
      //   274: invokestatic 93	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   277: goto +20 -> 297
      //   280: aload_1
      //   281: astore_3
      //   282: aload 4
      //   284: astore 5
      //   286: aload 6
      //   288: iconst_0
      //   289: aload 9
      //   291: iconst_0
      //   292: iload 8
      //   294: invokestatic 93	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   297: aload 9
      //   299: astore 7
      //   301: goto -220 -> 81
      //   304: astore 7
      //   306: goto +65 -> 371
      //   309: aconst_null
      //   310: astore 7
      //   312: aload_3
      //   313: astore_1
      //   314: aload_1
      //   315: ifnull +15 -> 330
      //   318: aload_1
      //   319: invokevirtual 96	java/io/BufferedInputStream:close	()V
      //   322: goto +8 -> 330
      //   325: astore_1
      //   326: aload_1
      //   327: invokevirtual 99	java/io/IOException:printStackTrace	()V
      //   330: aload 4
      //   332: invokevirtual 102	java/net/HttpURLConnection:disconnect	()V
      //   335: aload 7
      //   337: astore_1
      //   338: goto +74 -> 412
      //   341: astore_1
      //   342: aconst_null
      //   343: astore_3
      //   344: goto +75 -> 419
      //   347: astore 7
      //   349: aconst_null
      //   350: astore_1
      //   351: goto +20 -> 371
      //   354: astore_1
      //   355: aconst_null
      //   356: astore_3
      //   357: aload_3
      //   358: astore 4
      //   360: goto +59 -> 419
      //   363: astore 7
      //   365: aconst_null
      //   366: astore 4
      //   368: aload 4
      //   370: astore_1
      //   371: aload_1
      //   372: astore_3
      //   373: aload 4
      //   375: astore 5
      //   377: aload 7
      //   379: invokevirtual 103	java/lang/Exception:printStackTrace	()V
      //   382: aload_1
      //   383: ifnull +15 -> 398
      //   386: aload_1
      //   387: invokevirtual 96	java/io/BufferedInputStream:close	()V
      //   390: goto +8 -> 398
      //   393: astore_1
      //   394: aload_1
      //   395: invokevirtual 99	java/io/IOException:printStackTrace	()V
      //   398: aload_2
      //   399: astore_1
      //   400: aload 4
      //   402: ifnull +10 -> 412
      //   405: aload 4
      //   407: invokevirtual 102	java/net/HttpURLConnection:disconnect	()V
      //   410: aload_2
      //   411: astore_1
      //   412: aload_1
      //   413: areturn
      //   414: astore_1
      //   415: aload 5
      //   417: astore 4
      //   419: aload_3
      //   420: ifnull +15 -> 435
      //   423: aload_3
      //   424: invokevirtual 96	java/io/BufferedInputStream:close	()V
      //   427: goto +8 -> 435
      //   430: astore_3
      //   431: aload_3
      //   432: invokevirtual 99	java/io/IOException:printStackTrace	()V
      //   435: aload 4
      //   437: ifnull +8 -> 445
      //   440: aload 4
      //   442: invokevirtual 102	java/net/HttpURLConnection:disconnect	()V
      //   445: aload_1
      //   446: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	447	0	this	b
      //   0	447	1	paramString	String
      //   1	410	2	localObject1	Object
      //   3	421	3	str	String
      //   430	2	3	localIOException	java.io.IOException
      //   7	434	4	localObject2	Object
      //   69	347	5	localObject3	Object
      //   76	211	6	arrayOfByte	byte[]
      //   79	221	7	localObject4	Object
      //   304	1	7	localException1	Exception
      //   310	26	7	localObject5	Object
      //   347	1	7	localException2	Exception
      //   363	15	7	localException3	Exception
      //   93	200	8	i	int
      //   138	160	9	localObject6	Object
      //   204	27	10	j	int
      // Exception table:
      //   from	to	target	type
      //   71	78	304	java/lang/Exception
      //   87	95	304	java/lang/Exception
      //   112	123	304	java/lang/Exception
      //   135	140	304	java/lang/Exception
      //   146	151	304	java/lang/Exception
      //   157	165	304	java/lang/Exception
      //   171	179	304	java/lang/Exception
      //   185	195	304	java/lang/Exception
      //   215	220	304	java/lang/Exception
      //   226	235	304	java/lang/Exception
      //   246	258	304	java/lang/Exception
      //   264	277	304	java/lang/Exception
      //   286	297	304	java/lang/Exception
      //   318	322	325	java/io/IOException
      //   25	65	341	finally
      //   25	65	347	java/lang/Exception
      //   4	25	354	finally
      //   4	25	363	java/lang/Exception
      //   386	390	393	java/io/IOException
      //   71	78	414	finally
      //   87	95	414	finally
      //   112	123	414	finally
      //   135	140	414	finally
      //   146	151	414	finally
      //   157	165	414	finally
      //   171	179	414	finally
      //   185	195	414	finally
      //   215	220	414	finally
      //   226	235	414	finally
      //   246	258	414	finally
      //   264	277	414	finally
      //   286	297	414	finally
      //   377	382	414	finally
      //   423	427	430	java/io/IOException
    }
    
    public Bitmap a(Context paramContext)
    {
      if (a == null) {
        try
        {
          if (a == null)
          {
            localObject = new com/tplink/libtpcontrols/TPCircleMaskView$c;
            ((TPCircleMaskView.c)localObject).<init>(paramContext);
            a = (TPCircleMaskView.c)localObject;
          }
        }
        finally {}
      }
      Object localObject = null;
      String str = this.b;
      paramContext = (Context)localObject;
      if (str != null)
      {
        paramContext = (Context)localObject;
        if (!str.isEmpty())
        {
          localObject = a.f(this.b);
          paramContext = (Context)localObject;
          if (localObject == null)
          {
            localObject = b(this.b);
            paramContext = (Context)localObject;
            if (localObject != null)
            {
              a.k(this.b, (Bitmap)localObject);
              paramContext = (Context)localObject;
            }
          }
        }
      }
      return paramContext;
    }
  }
  
  public static class c
  {
    private ConcurrentHashMap<String, SoftReference<Bitmap>> a = new ConcurrentHashMap();
    private String b;
    private boolean c;
    private ExecutorService d;
    
    c(Context paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationContext().getCacheDir().getAbsolutePath());
      localStringBuilder.append("/image_cache/");
      this.b = localStringBuilder.toString();
      paramContext = new File(this.b);
      paramContext.mkdirs();
      this.c = paramContext.exists();
      this.d = Executors.newSingleThreadExecutor();
    }
    
    private void d(final String paramString, final Bitmap paramBitmap)
    {
      this.d.execute(new a(paramString, paramBitmap));
    }
    
    private void e(String paramString, Bitmap paramBitmap)
    {
      this.a.put(i(paramString), new SoftReference(paramBitmap));
    }
    
    private Bitmap g(String paramString)
    {
      if (this.c)
      {
        paramString = j(paramString);
        if (new File(paramString).exists()) {
          return BitmapFactory.decodeFile(paramString);
        }
      }
      paramString = null;
      return paramString;
    }
    
    private Bitmap h(String paramString)
    {
      paramString = (SoftReference)this.a.get(i(paramString));
      if (paramString != null) {
        paramString = (Bitmap)paramString.get();
      } else {
        paramString = null;
      }
      return paramString;
    }
    
    private String i(String paramString)
    {
      if (paramString != null) {
        return paramString.substring(paramString.lastIndexOf("/") + 1);
      }
      throw new RuntimeException("Null url passed in");
    }
    
    private String j(String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(i(paramString));
      return localStringBuilder.toString();
    }
    
    public Bitmap f(String paramString)
    {
      Bitmap localBitmap1 = h(paramString);
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        localBitmap1 = g(paramString);
        localBitmap2 = localBitmap1;
        if (localBitmap1 != null)
        {
          e(paramString, localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
      return localBitmap2;
    }
    
    public void k(String paramString, Bitmap paramBitmap)
    {
      e(paramString, paramBitmap);
      d(paramString, paramBitmap);
    }
    
    class a
      implements Runnable
    {
      a(String paramString, Bitmap paramBitmap) {}
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 22	com/tplink/libtpcontrols/TPCircleMaskView$c$a:f	Lcom/tplink/libtpcontrols/TPCircleMaskView$c;
        //   4: invokestatic 39	com/tplink/libtpcontrols/TPCircleMaskView$c:a	(Lcom/tplink/libtpcontrols/TPCircleMaskView$c;)Z
        //   7: ifeq +146 -> 153
        //   10: new 41	java/io/BufferedOutputStream
        //   13: astore_1
        //   14: new 43	java/io/FileOutputStream
        //   17: astore_2
        //   18: new 45	java/io/File
        //   21: astore_3
        //   22: aload_3
        //   23: aload_0
        //   24: getfield 22	com/tplink/libtpcontrols/TPCircleMaskView$c$a:f	Lcom/tplink/libtpcontrols/TPCircleMaskView$c;
        //   27: invokestatic 49	com/tplink/libtpcontrols/TPCircleMaskView$c:b	(Lcom/tplink/libtpcontrols/TPCircleMaskView$c;)Ljava/lang/String;
        //   30: aload_0
        //   31: getfield 22	com/tplink/libtpcontrols/TPCircleMaskView$c$a:f	Lcom/tplink/libtpcontrols/TPCircleMaskView$c;
        //   34: aload_0
        //   35: getfield 24	com/tplink/libtpcontrols/TPCircleMaskView$c$a:c	Ljava/lang/String;
        //   38: invokestatic 52	com/tplink/libtpcontrols/TPCircleMaskView$c:c	(Lcom/tplink/libtpcontrols/TPCircleMaskView$c;Ljava/lang/String;)Ljava/lang/String;
        //   41: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   44: aload_2
        //   45: aload_3
        //   46: invokespecial 58	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   49: aload_1
        //   50: aload_2
        //   51: sipush 2048
        //   54: invokespecial 61	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
        //   57: aload_1
        //   58: astore_3
        //   59: aload_0
        //   60: getfield 26	com/tplink/libtpcontrols/TPCircleMaskView$c$a:d	Landroid/graphics/Bitmap;
        //   63: getstatic 67	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   66: bipush 100
        //   68: aload_1
        //   69: invokevirtual 73	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   72: pop
        //   73: aload_1
        //   74: invokevirtual 76	java/io/BufferedOutputStream:flush	()V
        //   77: aload_1
        //   78: invokevirtual 79	java/io/BufferedOutputStream:close	()V
        //   81: goto +72 -> 153
        //   84: astore_2
        //   85: goto +12 -> 97
        //   88: astore_3
        //   89: aconst_null
        //   90: astore_1
        //   91: goto +40 -> 131
        //   94: astore_2
        //   95: aconst_null
        //   96: astore_1
        //   97: aload_1
        //   98: astore_3
        //   99: aload_2
        //   100: invokevirtual 82	java/io/FileNotFoundException:printStackTrace	()V
        //   103: aload_1
        //   104: ifnull +49 -> 153
        //   107: aload_1
        //   108: invokevirtual 76	java/io/BufferedOutputStream:flush	()V
        //   111: aload_1
        //   112: invokevirtual 79	java/io/BufferedOutputStream:close	()V
        //   115: goto +38 -> 153
        //   118: astore_3
        //   119: aload_3
        //   120: invokevirtual 83	java/io/IOException:printStackTrace	()V
        //   123: goto +30 -> 153
        //   126: astore_2
        //   127: aload_3
        //   128: astore_1
        //   129: aload_2
        //   130: astore_3
        //   131: aload_1
        //   132: ifnull +19 -> 151
        //   135: aload_1
        //   136: invokevirtual 76	java/io/BufferedOutputStream:flush	()V
        //   139: aload_1
        //   140: invokevirtual 79	java/io/BufferedOutputStream:close	()V
        //   143: goto +8 -> 151
        //   146: astore_1
        //   147: aload_1
        //   148: invokevirtual 83	java/io/IOException:printStackTrace	()V
        //   151: aload_3
        //   152: athrow
        //   153: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	154	0	this	a
        //   13	127	1	localObject1	Object
        //   146	2	1	localIOException1	java.io.IOException
        //   17	34	2	localFileOutputStream	java.io.FileOutputStream
        //   84	1	2	localFileNotFoundException1	java.io.FileNotFoundException
        //   94	6	2	localFileNotFoundException2	java.io.FileNotFoundException
        //   126	4	2	localObject2	Object
        //   21	38	3	localObject3	Object
        //   88	1	3	localObject4	Object
        //   98	1	3	localObject5	Object
        //   118	10	3	localIOException2	java.io.IOException
        //   130	22	3	localObject6	Object
        // Exception table:
        //   from	to	target	type
        //   59	73	84	java/io/FileNotFoundException
        //   10	57	88	finally
        //   10	57	94	java/io/FileNotFoundException
        //   73	81	118	java/io/IOException
        //   107	115	118	java/io/IOException
        //   59	73	126	finally
        //   99	103	126	finally
        //   135	143	146	java/io/IOException
      }
    }
  }
  
  public static class d
    extends Handler
  {
    private TPCircleMaskView.a a;
    
    d(TPCircleMaskView.a parama)
    {
      this.a = parama;
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.a(paramMessage);
      if (paramMessage != null) {
        paramMessage.isRecycled();
      }
    }
  }
  
  public static class e
    implements Runnable
  {
    private boolean c = false;
    private TPCircleMaskView.d d;
    private TPCircleMaskView.b f;
    private Context q;
    
    e(Context paramContext, TPCircleMaskView.b paramb, TPCircleMaskView.d paramd)
    {
      this.f = paramb;
      this.q = paramContext;
      this.d = paramd;
    }
    
    public void a()
    {
      this.c = true;
    }
    
    public void run()
    {
      TPCircleMaskView.b localb = this.f;
      if (localb != null)
      {
        TPCircleMaskView.d locald = this.d;
        if ((locald != null) && (!this.c)) {
          locald.sendMessage(locald.obtainMessage(0, localb.a(this.q)));
        }
        this.q = null;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPCircleMaskView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
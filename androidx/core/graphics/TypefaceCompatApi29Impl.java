package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat.FontInfo;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(29)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl
  extends TypefaceCompatBaseImpl
{
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    FontResourcesParserCompat.FontFileResourceEntry[] arrayOfFontFileResourceEntry = paramFontFamilyFilesResourceEntry.getEntries();
    int i = arrayOfFontFileResourceEntry.length;
    int j = 0;
    paramContext = null;
    int k = 0;
    for (;;)
    {
      int m = 1;
      if (k >= i) {
        break;
      }
      paramFontFamilyFilesResourceEntry = arrayOfFontFileResourceEntry[k];
      try
      {
        Object localObject = new android/graphics/fonts/Font$Builder;
        ((Font.Builder)localObject).<init>(paramResources, paramFontFamilyFilesResourceEntry.getResourceId());
        localObject = ((Font.Builder)localObject).setWeight(paramFontFamilyFilesResourceEntry.getWeight());
        if (!paramFontFamilyFilesResourceEntry.isItalic()) {
          m = 0;
        }
        localObject = ((Font.Builder)localObject).setSlant(m).setTtcIndex(paramFontFamilyFilesResourceEntry.getTtcIndex()).setFontVariationSettings(paramFontFamilyFilesResourceEntry.getVariationSettings()).build();
        if (paramContext == null)
        {
          paramFontFamilyFilesResourceEntry = new android/graphics/fonts/FontFamily$Builder;
          paramFontFamilyFilesResourceEntry.<init>((Font)localObject);
          paramContext = paramFontFamilyFilesResourceEntry;
        }
        else
        {
          paramContext.addFont((Font)localObject);
        }
        k++;
      }
      catch (IOException paramFontFamilyFilesResourceEntry)
      {
        for (;;) {}
      }
    }
    if (paramContext == null) {
      return null;
    }
    if ((paramInt & 0x1) != 0) {
      k = 700;
    } else {
      k = 400;
    }
    m = j;
    if ((paramInt & 0x2) != 0) {
      m = 1;
    }
    paramFontFamilyFilesResourceEntry = new FontStyle(k, m);
    return new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramFontFamilyFilesResourceEntry).build();
  }
  
  /* Error */
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable android.os.CancellationSignal paramCancellationSignal, @androidx.annotation.NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 108	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: aload_3
    //   7: arraylength
    //   8: istore 6
    //   10: iconst_0
    //   11: istore 7
    //   13: aconst_null
    //   14: astore_1
    //   15: iconst_0
    //   16: istore 8
    //   18: iconst_1
    //   19: istore 9
    //   21: iload 8
    //   23: iload 6
    //   25: if_icmpge +180 -> 205
    //   28: aload_3
    //   29: iload 8
    //   31: aaload
    //   32: astore 10
    //   34: aload_1
    //   35: astore 11
    //   37: aload 5
    //   39: aload 10
    //   41: invokevirtual 114	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   44: ldc 116
    //   46: aload_2
    //   47: invokevirtual 122	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   50: astore 12
    //   52: aload 12
    //   54: ifnonnull +25 -> 79
    //   57: aload_1
    //   58: astore 11
    //   60: aload 12
    //   62: ifnull +134 -> 196
    //   65: aload_1
    //   66: astore 11
    //   68: aload 12
    //   70: invokevirtual 127	android/os/ParcelFileDescriptor:close	()V
    //   73: aload_1
    //   74: astore 11
    //   76: goto +120 -> 196
    //   79: new 28	android/graphics/fonts/Font$Builder
    //   82: astore 11
    //   84: aload 11
    //   86: aload 12
    //   88: invokespecial 130	android/graphics/fonts/Font$Builder:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   91: aload 11
    //   93: aload 10
    //   95: invokevirtual 131	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   98: invokevirtual 44	android/graphics/fonts/Font$Builder:setWeight	(I)Landroid/graphics/fonts/Font$Builder;
    //   101: astore 11
    //   103: aload 10
    //   105: invokevirtual 132	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   108: ifeq +6 -> 114
    //   111: goto +6 -> 117
    //   114: iconst_0
    //   115: istore 9
    //   117: aload 11
    //   119: iload 9
    //   121: invokevirtual 51	android/graphics/fonts/Font$Builder:setSlant	(I)Landroid/graphics/fonts/Font$Builder;
    //   124: aload 10
    //   126: invokevirtual 133	androidx/core/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   129: invokevirtual 57	android/graphics/fonts/Font$Builder:setTtcIndex	(I)Landroid/graphics/fonts/Font$Builder;
    //   132: invokevirtual 69	android/graphics/fonts/Font$Builder:build	()Landroid/graphics/fonts/Font;
    //   135: astore 11
    //   137: aload_1
    //   138: ifnonnull +20 -> 158
    //   141: new 71	android/graphics/fonts/FontFamily$Builder
    //   144: dup
    //   145: aload 11
    //   147: invokespecial 74	android/graphics/fonts/FontFamily$Builder:<init>	(Landroid/graphics/fonts/Font;)V
    //   150: astore 11
    //   152: aload 11
    //   154: astore_1
    //   155: goto -90 -> 65
    //   158: aload_1
    //   159: aload 11
    //   161: invokevirtual 78	android/graphics/fonts/FontFamily$Builder:addFont	(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   164: pop
    //   165: goto -100 -> 65
    //   168: astore 10
    //   170: aload 12
    //   172: invokevirtual 127	android/os/ParcelFileDescriptor:close	()V
    //   175: goto +15 -> 190
    //   178: astore 12
    //   180: aload_1
    //   181: astore 11
    //   183: aload 10
    //   185: aload 12
    //   187: invokevirtual 139	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   190: aload_1
    //   191: astore 11
    //   193: aload 10
    //   195: athrow
    //   196: iinc 8 1
    //   199: aload 11
    //   201: astore_1
    //   202: goto -184 -> 18
    //   205: aload_1
    //   206: ifnonnull +5 -> 211
    //   209: aconst_null
    //   210: areturn
    //   211: iload 4
    //   213: iconst_1
    //   214: iand
    //   215: ifeq +11 -> 226
    //   218: sipush 700
    //   221: istore 8
    //   223: goto +8 -> 231
    //   226: sipush 400
    //   229: istore 8
    //   231: iload 7
    //   233: istore 9
    //   235: iload 4
    //   237: iconst_2
    //   238: iand
    //   239: ifeq +6 -> 245
    //   242: iconst_1
    //   243: istore 9
    //   245: new 80	android/graphics/fonts/FontStyle
    //   248: dup
    //   249: iload 8
    //   251: iload 9
    //   253: invokespecial 83	android/graphics/fonts/FontStyle:<init>	(II)V
    //   256: astore_2
    //   257: new 85	android/graphics/Typeface$CustomFallbackBuilder
    //   260: dup
    //   261: aload_1
    //   262: invokevirtual 88	android/graphics/fonts/FontFamily$Builder:build	()Landroid/graphics/fonts/FontFamily;
    //   265: invokespecial 91	android/graphics/Typeface$CustomFallbackBuilder:<init>	(Landroid/graphics/fonts/FontFamily;)V
    //   268: aload_2
    //   269: invokevirtual 95	android/graphics/Typeface$CustomFallbackBuilder:setStyle	(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   272: invokevirtual 98	android/graphics/Typeface$CustomFallbackBuilder:build	()Landroid/graphics/Typeface;
    //   275: areturn
    //   276: astore_1
    //   277: goto -81 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	TypefaceCompatApi29Impl
    //   0	280	1	paramContext	Context
    //   0	280	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	280	3	paramArrayOfFontInfo	FontsContractCompat.FontInfo[]
    //   0	280	4	paramInt	int
    //   4	34	5	localContentResolver	android.content.ContentResolver
    //   8	18	6	i	int
    //   11	221	7	j	int
    //   16	234	8	k	int
    //   19	233	9	m	int
    //   32	93	10	localFontInfo	FontsContractCompat.FontInfo
    //   168	26	10	localObject1	Object
    //   35	165	11	localObject2	Object
    //   50	121	12	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   178	8	12	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   79	111	168	finally
    //   117	137	168	finally
    //   141	152	168	finally
    //   158	165	168	finally
    //   170	175	178	finally
    //   37	52	276	java/io/IOException
    //   68	73	276	java/io/IOException
    //   183	190	276	java/io/IOException
    //   193	196	276	java/io/IOException
  }
  
  protected Typeface createFromInputStream(Context paramContext, InputStream paramInputStream)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramContext = new android/graphics/fonts/Font$Builder;
      paramContext.<init>(paramResources, paramInt1);
      paramContext = paramContext.build();
      paramResources = new android/graphics/fonts/FontFamily$Builder;
      paramResources.<init>(paramContext);
      paramResources = paramResources.build();
      return new Typeface.CustomFallbackBuilder(paramResources).setStyle(paramContext.getStyle()).build();
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\TypefaceCompatApi29Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
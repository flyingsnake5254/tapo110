package androidx.core.graphics;

import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi21Impl
  extends TypefaceCompatBaseImpl
{
  private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String TAG = "TypefaceCompatApi21Impl";
  private static Method sAddFontWeightStyle;
  private static Method sCreateFromFamiliesWithDefault;
  private static Class<?> sFontFamily;
  private static Constructor<?> sFontFamilyCtor;
  private static boolean sHasInitBeenCalled = false;
  
  private static boolean addFontWeightStyle(Object paramObject, String paramString, int paramInt, boolean paramBoolean)
  {
    
    try
    {
      paramBoolean = ((Boolean)sAddFontWeightStyle.invoke(paramObject, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException((Throwable)paramObject);
  }
  
  private static Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    
    try
    {
      Object localObject = Array.newInstance(sFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)sCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject });
      return (Typeface)paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException((Throwable)paramObject);
  }
  
  private File getFile(@NonNull ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("/proc/self/fd/");
      localStringBuilder.append(paramParcelFileDescriptor.getFd());
      paramParcelFileDescriptor = Os.readlink(localStringBuilder.toString());
      if (OsConstants.S_ISREG(Os.stat(paramParcelFileDescriptor).st_mode))
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
    }
    catch (ErrnoException paramParcelFileDescriptor)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static void init()
  {
    if (sHasInitBeenCalled) {
      return;
    }
    sHasInitBeenCalled = true;
    Object localObject1 = null;
    try
    {
      Class localClass = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor = localClass.getConstructor(new Class[0]);
      localObject3 = localClass.getMethod("addFontWeightStyle", new Class[] { String.class, Integer.TYPE, Boolean.TYPE });
      localMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      localObject1 = localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi21Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Method localMethod = null;
    Object localObject2 = localMethod;
    Object localObject3 = localObject2;
    sFontFamilyCtor = (Constructor)localObject1;
    sFontFamily = (Class)localObject2;
    sAddFontWeightStyle = (Method)localObject3;
    sCreateFromFamiliesWithDefault = localMethod;
  }
  
  private static Object newFamily()
  {
    
    try
    {
      Object localObject = sFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new RuntimeException(localIllegalAccessException);
  }
  
  /* Error */
  public Typeface createFromFontFamilyFilesResourceEntry(android.content.Context paramContext, androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, android.content.res.Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 205	androidx/core/graphics/TypefaceCompatApi21Impl:newFamily	()Ljava/lang/Object;
    //   3: astore 5
    //   5: aload_2
    //   6: invokevirtual 211	androidx/core/content/res/FontResourcesParserCompat$FontFamilyFilesResourceEntry:getEntries	()[Landroidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry;
    //   9: astore 6
    //   11: aload 6
    //   13: arraylength
    //   14: istore 7
    //   16: iconst_0
    //   17: istore 4
    //   19: iload 4
    //   21: iload 7
    //   23: if_icmpge +105 -> 128
    //   26: aload 6
    //   28: iload 4
    //   30: aaload
    //   31: astore 8
    //   33: aload_1
    //   34: invokestatic 217	androidx/core/graphics/TypefaceCompatUtil:getTempFile	(Landroid/content/Context;)Ljava/io/File;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnonnull +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: aload_2
    //   45: aload_3
    //   46: aload 8
    //   48: invokevirtual 222	androidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry:getResourceId	()I
    //   51: invokestatic 226	androidx/core/graphics/TypefaceCompatUtil:copyToFile	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   54: istore 9
    //   56: iload 9
    //   58: ifne +10 -> 68
    //   61: aload_2
    //   62: invokevirtual 229	java/io/File:delete	()Z
    //   65: pop
    //   66: aconst_null
    //   67: areturn
    //   68: aload 5
    //   70: aload_2
    //   71: invokevirtual 232	java/io/File:getPath	()Ljava/lang/String;
    //   74: aload 8
    //   76: invokevirtual 235	androidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry:getWeight	()I
    //   79: aload 8
    //   81: invokevirtual 238	androidx/core/content/res/FontResourcesParserCompat$FontFileResourceEntry:isItalic	()Z
    //   84: invokestatic 240	androidx/core/graphics/TypefaceCompatApi21Impl:addFontWeightStyle	(Ljava/lang/Object;Ljava/lang/String;IZ)Z
    //   87: istore 9
    //   89: iload 9
    //   91: ifne +10 -> 101
    //   94: aload_2
    //   95: invokevirtual 229	java/io/File:delete	()Z
    //   98: pop
    //   99: aconst_null
    //   100: areturn
    //   101: aload_2
    //   102: invokevirtual 229	java/io/File:delete	()Z
    //   105: pop
    //   106: iinc 4 1
    //   109: goto -90 -> 19
    //   112: astore_1
    //   113: aload_2
    //   114: invokevirtual 229	java/io/File:delete	()Z
    //   117: pop
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_2
    //   122: invokevirtual 229	java/io/File:delete	()Z
    //   125: pop
    //   126: aconst_null
    //   127: areturn
    //   128: aload 5
    //   130: invokestatic 242	androidx/core/graphics/TypefaceCompatApi21Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   133: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	TypefaceCompatApi21Impl
    //   0	134	1	paramContext	android.content.Context
    //   0	134	2	paramFontFamilyFilesResourceEntry	androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry
    //   0	134	3	paramResources	android.content.res.Resources
    //   0	134	4	paramInt	int
    //   3	126	5	localObject	Object
    //   9	18	6	arrayOfFontFileResourceEntry	androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry[]
    //   14	10	7	i	int
    //   31	49	8	localFontFileResourceEntry	androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry
    //   54	36	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   44	56	112	finally
    //   68	89	112	finally
    //   44	56	120	java/lang/RuntimeException
    //   68	89	120	java/lang/RuntimeException
  }
  
  /* Error */
  public Typeface createFromFontInfo(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, @NonNull androidx.core.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 250	androidx/core/graphics/TypefaceCompatBaseImpl:findBestInfo	([Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   15: astore 5
    //   17: aload_1
    //   18: invokevirtual 256	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: astore_3
    //   22: aload_3
    //   23: aload 5
    //   25: invokevirtual 262	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   28: ldc_w 264
    //   31: aload_2
    //   32: invokevirtual 270	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnonnull +13 -> 50
    //   40: aload_2
    //   41: ifnull +7 -> 48
    //   44: aload_2
    //   45: invokevirtual 273	android/os/ParcelFileDescriptor:close	()V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_0
    //   51: aload_2
    //   52: invokespecial 275	androidx/core/graphics/TypefaceCompatApi21Impl:getFile	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   55: astore_3
    //   56: aload_3
    //   57: ifnull +24 -> 81
    //   60: aload_3
    //   61: invokevirtual 278	java/io/File:canRead	()Z
    //   64: ifne +6 -> 70
    //   67: goto +14 -> 81
    //   70: aload_3
    //   71: invokestatic 282	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 273	android/os/ParcelFileDescriptor:close	()V
    //   79: aload_1
    //   80: areturn
    //   81: new 284	java/io/FileInputStream
    //   84: astore_3
    //   85: aload_3
    //   86: aload_2
    //   87: invokevirtual 288	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   90: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   93: aload_0
    //   94: aload_1
    //   95: aload_3
    //   96: invokespecial 295	androidx/core/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   99: astore_1
    //   100: aload_3
    //   101: invokevirtual 296	java/io/FileInputStream:close	()V
    //   104: aload_2
    //   105: invokevirtual 273	android/os/ParcelFileDescriptor:close	()V
    //   108: aload_1
    //   109: areturn
    //   110: astore_1
    //   111: aload_3
    //   112: invokevirtual 296	java/io/FileInputStream:close	()V
    //   115: goto +9 -> 124
    //   118: astore_3
    //   119: aload_1
    //   120: aload_3
    //   121: invokevirtual 301	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_2
    //   128: invokevirtual 273	android/os/ParcelFileDescriptor:close	()V
    //   131: goto +9 -> 140
    //   134: astore_2
    //   135: aload_1
    //   136: aload_2
    //   137: invokevirtual 301	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: aconst_null
    //   144: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	TypefaceCompatApi21Impl
    //   0	145	1	paramContext	android.content.Context
    //   0	145	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	145	3	paramArrayOfFontInfo	androidx.core.provider.FontsContractCompat.FontInfo[]
    //   0	145	4	paramInt	int
    //   15	9	5	localFontInfo	androidx.core.provider.FontsContractCompat.FontInfo
    // Exception table:
    //   from	to	target	type
    //   93	100	110	finally
    //   111	115	118	finally
    //   50	56	126	finally
    //   60	67	126	finally
    //   70	75	126	finally
    //   81	93	126	finally
    //   100	104	126	finally
    //   119	124	126	finally
    //   124	126	126	finally
    //   127	131	134	finally
    //   22	36	142	java/io/IOException
    //   44	48	142	java/io/IOException
    //   75	79	142	java/io/IOException
    //   104	108	142	java/io/IOException
    //   135	140	142	java/io/IOException
    //   140	142	142	java/io/IOException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\TypefaceCompatApi21Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
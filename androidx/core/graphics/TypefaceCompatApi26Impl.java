package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi26Impl
  extends TypefaceCompatApi21Impl
{
  private static final String ABORT_CREATION_METHOD = "abortCreation";
  private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
  private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String FREEZE_METHOD = "freeze";
  private static final int RESOLVE_BY_FONT_TABLE = -1;
  private static final String TAG = "TypefaceCompatApi26Impl";
  protected final Method mAbortCreation;
  protected final Method mAddFontFromAssetManager;
  protected final Method mAddFontFromBuffer;
  protected final Method mCreateFromFamiliesWithDefault;
  protected final Class<?> mFontFamily;
  protected final Constructor<?> mFontFamilyCtor;
  protected final Method mFreeze;
  
  public TypefaceCompatApi26Impl()
  {
    Object localObject1 = null;
    try
    {
      Class localClass = obtainFontFamily();
      localObject3 = obtainFontFamilyCtor(localClass);
      localObject4 = obtainAddFontFromAssetManagerMethod(localClass);
      localObject5 = obtainAddFontFromBufferMethod(localClass);
      localObject6 = obtainFreezeMethod(localClass);
      localObject7 = obtainAbortCreationMethod(localClass);
      localMethod = obtainCreateFromFamiliesWithDefaultMethod(localClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("Unable to collect necessary methods for class ");
    ((StringBuilder)localObject4).append(localClassNotFoundException.getClass().getName());
    Log.e("TypefaceCompatApi26Impl", ((StringBuilder)localObject4).toString(), localClassNotFoundException);
    Method localMethod = null;
    Object localObject2 = localMethod;
    localObject4 = localObject2;
    Object localObject5 = localObject4;
    Object localObject3 = localObject5;
    Object localObject7 = localObject3;
    Object localObject6 = localObject3;
    localObject3 = localObject2;
    localObject2 = localObject1;
    this.mFontFamily = ((Class)localObject2);
    this.mFontFamilyCtor = ((Constructor)localObject3);
    this.mAddFontFromAssetManager = ((Method)localObject4);
    this.mAddFontFromBuffer = ((Method)localObject5);
    this.mFreeze = ((Method)localObject6);
    this.mAbortCreation = ((Method)localObject7);
    this.mCreateFromFamiliesWithDefault = localMethod;
  }
  
  private void abortCreation(Object paramObject)
  {
    try
    {
      this.mAbortCreation.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject)
    {
      for (;;) {}
    }
  }
  
  private boolean addFontFromAssetManager(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      boolean bool = ((Boolean)this.mAddFontFromAssetManager.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.FALSE, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramContext) {}
    return false;
  }
  
  private boolean addFontFromBuffer(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)this.mAddFontFromBuffer.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return false;
  }
  
  private boolean freeze(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.mFreeze.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return false;
  }
  
  private boolean isFontFamilyPrivateAPIAvailable()
  {
    if (this.mAddFontFromAssetManager == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    }
    boolean bool;
    if (this.mAddFontFromAssetManager != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  private Object newFamily()
  {
    try
    {
      Object localObject = this.mFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException|InstantiationException|InvocationTargetException localIllegalAccessException) {}
    return null;
  }
  
  @Nullable
  protected Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.mFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.mCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return (Typeface)paramObject;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return null;
  }
  
  @Nullable
  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromFontFamilyFilesResourceEntry(paramContext, paramFontFamilyFilesResourceEntry, paramResources, paramInt);
    }
    paramResources = newFamily();
    if (paramResources == null) {
      return null;
    }
    for (paramFontFamilyFilesResourceEntry : paramFontFamilyFilesResourceEntry.getEntries()) {
      if (!addFontFromAssetManager(paramContext, paramResources, paramFontFamilyFilesResourceEntry.getFileName(), paramFontFamilyFilesResourceEntry.getTtcIndex(), paramFontFamilyFilesResourceEntry.getWeight(), paramFontFamilyFilesResourceEntry.isItalic(), FontVariationAxis.fromFontVariationSettings(paramFontFamilyFilesResourceEntry.getVariationSettings())))
      {
        abortCreation(paramResources);
        return null;
      }
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
  
  /* Error */
  @Nullable
  public Typeface createFromFontInfo(Context paramContext, @Nullable android.os.CancellationSignal paramCancellationSignal, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: invokespecial 195	androidx/core/graphics/TypefaceCompatApi26Impl:isFontFamilyPrivateAPIAvailable	()Z
    //   12: ifne +99 -> 111
    //   15: aload_0
    //   16: aload_3
    //   17: iload 4
    //   19: invokevirtual 248	androidx/core/graphics/TypefaceCompatBaseImpl:findBestInfo	([Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   22: astore_3
    //   23: aload_1
    //   24: invokevirtual 252	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: astore_1
    //   28: aload_1
    //   29: aload_3
    //   30: invokevirtual 258	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   33: ldc_w 260
    //   36: aload_2
    //   37: invokevirtual 266	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +13 -> 55
    //   45: aload_1
    //   46: ifnull +7 -> 53
    //   49: aload_1
    //   50: invokevirtual 271	android/os/ParcelFileDescriptor:close	()V
    //   53: aconst_null
    //   54: areturn
    //   55: new 273	android/graphics/Typeface$Builder
    //   58: astore_2
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 277	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   64: invokespecial 280	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   67: aload_2
    //   68: aload_3
    //   69: invokevirtual 281	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   72: invokevirtual 285	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   75: aload_3
    //   76: invokevirtual 286	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   79: invokevirtual 290	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   82: invokevirtual 294	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   85: astore_2
    //   86: aload_1
    //   87: invokevirtual 271	android/os/ParcelFileDescriptor:close	()V
    //   90: aload_2
    //   91: areturn
    //   92: astore_2
    //   93: aload_1
    //   94: invokevirtual 271	android/os/ParcelFileDescriptor:close	()V
    //   97: goto +9 -> 106
    //   100: astore_1
    //   101: aload_2
    //   102: aload_1
    //   103: invokevirtual 300	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: aconst_null
    //   110: areturn
    //   111: aload_1
    //   112: aload_3
    //   113: aload_2
    //   114: invokestatic 306	androidx/core/provider/FontsContractCompat:prepareFontData	(Landroid/content/Context;[Landroidx/core/provider/FontsContractCompat$FontInfo;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   117: astore 5
    //   119: aload_0
    //   120: invokespecial 199	androidx/core/graphics/TypefaceCompatApi26Impl:newFamily	()Ljava/lang/Object;
    //   123: astore_2
    //   124: aload_2
    //   125: ifnonnull +5 -> 130
    //   128: aconst_null
    //   129: areturn
    //   130: aload_3
    //   131: arraylength
    //   132: istore 6
    //   134: iconst_0
    //   135: istore 7
    //   137: iconst_0
    //   138: istore 8
    //   140: iload 8
    //   142: iload 6
    //   144: if_icmpge +70 -> 214
    //   147: aload_3
    //   148: iload 8
    //   150: aaload
    //   151: astore_1
    //   152: aload 5
    //   154: aload_1
    //   155: invokevirtual 258	androidx/core/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   158: invokeinterface 312 2 0
    //   163: checkcast 314	java/nio/ByteBuffer
    //   166: astore 9
    //   168: aload 9
    //   170: ifnonnull +6 -> 176
    //   173: goto +35 -> 208
    //   176: aload_0
    //   177: aload_2
    //   178: aload 9
    //   180: aload_1
    //   181: invokevirtual 315	androidx/core/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   184: aload_1
    //   185: invokevirtual 281	androidx/core/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   188: aload_1
    //   189: invokevirtual 286	androidx/core/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   192: invokespecial 317	androidx/core/graphics/TypefaceCompatApi26Impl:addFontFromBuffer	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   195: ifne +10 -> 205
    //   198: aload_0
    //   199: aload_2
    //   200: invokespecial 233	androidx/core/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   203: aconst_null
    //   204: areturn
    //   205: iconst_1
    //   206: istore 7
    //   208: iinc 8 1
    //   211: goto -71 -> 140
    //   214: iload 7
    //   216: ifne +10 -> 226
    //   219: aload_0
    //   220: aload_2
    //   221: invokespecial 233	androidx/core/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   224: aconst_null
    //   225: areturn
    //   226: aload_0
    //   227: aload_2
    //   228: invokespecial 235	androidx/core/graphics/TypefaceCompatApi26Impl:freeze	(Ljava/lang/Object;)Z
    //   231: ifne +5 -> 236
    //   234: aconst_null
    //   235: areturn
    //   236: aload_0
    //   237: aload_2
    //   238: invokevirtual 237	androidx/core/graphics/TypefaceCompatApi26Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   241: astore_1
    //   242: aload_1
    //   243: ifnonnull +5 -> 248
    //   246: aconst_null
    //   247: areturn
    //   248: aload_1
    //   249: iload 4
    //   251: invokestatic 321	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   254: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	TypefaceCompatApi26Impl
    //   0	255	1	paramContext	Context
    //   0	255	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	255	3	paramArrayOfFontInfo	androidx.core.provider.FontsContractCompat.FontInfo[]
    //   0	255	4	paramInt	int
    //   117	36	5	localMap	java.util.Map
    //   132	13	6	i	int
    //   135	80	7	j	int
    //   138	71	8	k	int
    //   166	13	9	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   55	86	92	finally
    //   93	97	100	finally
    //   28	41	108	java/io/IOException
    //   49	53	108	java/io/IOException
    //   86	90	108	java/io/IOException
    //   101	106	108	java/io/IOException
    //   106	108	108	java/io/IOException
  }
  
  @Nullable
  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    if (!isFontFamilyPrivateAPIAvailable()) {
      return super.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    paramResources = newFamily();
    if (paramResources == null) {
      return null;
    }
    if (!addFontFromAssetManager(paramContext, paramResources, paramString, 0, -1, -1, null))
    {
      abortCreation(paramResources);
      return null;
    }
    if (!freeze(paramResources)) {
      return null;
    }
    return createFromFamiliesWithDefault(paramResources);
  }
  
  protected Method obtainAbortCreationMethod(Class<?> paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("abortCreation", new Class[0]);
  }
  
  protected Method obtainAddFontFromAssetManagerMethod(Class<?> paramClass)
    throws NoSuchMethodException
  {
    Class localClass = Integer.TYPE;
    return paramClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, localClass, Boolean.TYPE, localClass, localClass, localClass, FontVariationAxis[].class });
  }
  
  protected Method obtainAddFontFromBufferMethod(Class<?> paramClass)
    throws NoSuchMethodException
  {
    Class localClass = Integer.TYPE;
    return paramClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, localClass, FontVariationAxis[].class, localClass, localClass });
  }
  
  protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> paramClass)
    throws NoSuchMethodException
  {
    paramClass = Array.newInstance(paramClass, 1).getClass();
    Class localClass = Integer.TYPE;
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { paramClass, localClass, localClass });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  protected Class<?> obtainFontFamily()
    throws ClassNotFoundException
  {
    return Class.forName("android.graphics.FontFamily");
  }
  
  protected Constructor<?> obtainFontFamilyCtor(Class<?> paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getConstructor(new Class[0]);
  }
  
  protected Method obtainFreezeMethod(Class<?> paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("freeze", new Class[0]);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\TypefaceCompatApi26Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
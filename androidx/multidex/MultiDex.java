package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

public final class MultiDex
{
  private static final String CODE_CACHE_NAME = "code_cache";
  private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
  private static final boolean IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
  private static final int MAX_SUPPORTED_SDK_VERSION = 20;
  private static final int MIN_SDK_VERSION = 4;
  private static final String NO_KEY_PREFIX = "";
  private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
  static final String TAG = "MultiDex";
  private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
  private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
  private static final Set<File> installedApk = new HashSet();
  
  private static void clearOldDexDir(Context paramContext)
    throws Exception
  {
    paramContext = new File(paramContext.getFilesDir(), "secondary-dexes");
    if (paramContext.isDirectory())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Clearing old secondary dex dir (");
      ((StringBuilder)localObject1).append(paramContext.getPath());
      ((StringBuilder)localObject1).append(").");
      Log.i("MultiDex", ((StringBuilder)localObject1).toString());
      localObject1 = paramContext.listFiles();
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Failed to list secondary dex dir content (");
        ((StringBuilder)localObject1).append(paramContext.getPath());
        ((StringBuilder)localObject1).append(").");
        Log.w("MultiDex", ((StringBuilder)localObject1).toString());
        return;
      }
      int i = localObject1.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject2 = localObject1[j];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Trying to delete old file ");
        localStringBuilder.append(((File)localObject2).getPath());
        localStringBuilder.append(" of size ");
        localStringBuilder.append(((File)localObject2).length());
        Log.i("MultiDex", localStringBuilder.toString());
        if (!((File)localObject2).delete())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to delete old file ");
          localStringBuilder.append(((File)localObject2).getPath());
          Log.w("MultiDex", localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Deleted old file ");
          localStringBuilder.append(((File)localObject2).getPath());
          Log.i("MultiDex", localStringBuilder.toString());
        }
      }
      if (!paramContext.delete())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Failed to delete secondary dex dir ");
        ((StringBuilder)localObject1).append(paramContext.getPath());
        Log.w("MultiDex", ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Deleted old secondary dex dir ");
        ((StringBuilder)localObject1).append(paramContext.getPath());
        Log.i("MultiDex", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  /* Error */
  private static void doInstallation(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2, boolean paramBoolean)
    throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException
  {
    // Byte code:
    //   0: getstatic 62	androidx/multidex/MultiDex:installedApk	Ljava/util/Set;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: aload 6
    //   10: aload_1
    //   11: invokeinterface 194 2 0
    //   16: ifeq +7 -> 23
    //   19: aload 6
    //   21: monitorexit
    //   22: return
    //   23: aload 6
    //   25: aload_1
    //   26: invokeinterface 197 2 0
    //   31: pop
    //   32: getstatic 202	android/os/Build$VERSION:SDK_INT	I
    //   35: istore 7
    //   37: iload 7
    //   39: bipush 20
    //   41: if_icmple +99 -> 140
    //   44: new 123	java/lang/StringBuilder
    //   47: astore 8
    //   49: aload 8
    //   51: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   54: aload 8
    //   56: ldc -52
    //   58: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 8
    //   64: iload 7
    //   66: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 8
    //   72: ldc -47
    //   74: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 8
    //   80: bipush 20
    //   82: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 8
    //   88: ldc -45
    //   90: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 8
    //   96: ldc -43
    //   98: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 8
    //   104: ldc -41
    //   106: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 8
    //   112: ldc 64
    //   114: invokestatic 70	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   117: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 8
    //   123: ldc -39
    //   125: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: ldc 46
    //   131: aload 8
    //   133: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 154	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   139: pop
    //   140: aload_0
    //   141: invokestatic 221	androidx/multidex/MultiDex:getDexClassloader	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   144: astore 8
    //   146: aload 8
    //   148: ifnonnull +7 -> 155
    //   151: aload 6
    //   153: monitorexit
    //   154: return
    //   155: aload_0
    //   156: invokestatic 223	androidx/multidex/MultiDex:clearOldDexDir	(Landroid/content/Context;)V
    //   159: goto +15 -> 174
    //   162: astore 9
    //   164: ldc 46
    //   166: ldc -31
    //   168: aload 9
    //   170: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   173: pop
    //   174: aload_0
    //   175: aload_2
    //   176: aload_3
    //   177: invokestatic 232	androidx/multidex/MultiDex:getDexDir	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   180: astore_3
    //   181: new 234	androidx/multidex/MultiDexExtractor
    //   184: astore_2
    //   185: aload_2
    //   186: aload_1
    //   187: aload_3
    //   188: invokespecial 237	androidx/multidex/MultiDexExtractor:<init>	(Ljava/io/File;Ljava/io/File;)V
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_2
    //   194: aload_0
    //   195: aload 4
    //   197: iconst_0
    //   198: invokevirtual 241	androidx/multidex/MultiDexExtractor:load	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   201: astore 9
    //   203: aload 8
    //   205: aload_3
    //   206: aload 9
    //   208: invokestatic 245	androidx/multidex/MultiDex:installSecondaryDexes	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   211: goto +34 -> 245
    //   214: astore 9
    //   216: iload 5
    //   218: ifeq +47 -> 265
    //   221: ldc 46
    //   223: ldc -9
    //   225: aload 9
    //   227: invokestatic 228	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   230: pop
    //   231: aload 8
    //   233: aload_3
    //   234: aload_2
    //   235: aload_0
    //   236: aload 4
    //   238: iconst_1
    //   239: invokevirtual 241	androidx/multidex/MultiDexExtractor:load	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   242: invokestatic 245	androidx/multidex/MultiDex:installSecondaryDexes	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   245: aload_2
    //   246: invokevirtual 250	androidx/multidex/MultiDexExtractor:close	()V
    //   249: aload_1
    //   250: astore_0
    //   251: goto +4 -> 255
    //   254: astore_0
    //   255: aload_0
    //   256: ifnonnull +7 -> 263
    //   259: aload 6
    //   261: monitorexit
    //   262: return
    //   263: aload_0
    //   264: athrow
    //   265: aload 9
    //   267: athrow
    //   268: astore_0
    //   269: aload_2
    //   270: invokevirtual 250	androidx/multidex/MultiDexExtractor:close	()V
    //   273: aload_0
    //   274: athrow
    //   275: astore_0
    //   276: aload 6
    //   278: monitorexit
    //   279: aload_0
    //   280: athrow
    //   281: astore_1
    //   282: goto -9 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramContext	Context
    //   0	285	1	paramFile1	File
    //   0	285	2	paramFile2	File
    //   0	285	3	paramString1	String
    //   0	285	4	paramString2	String
    //   0	285	5	paramBoolean	boolean
    //   3	274	6	localSet	Set
    //   35	30	7	i	int
    //   47	185	8	localObject	Object
    //   162	7	9	localThrowable	Throwable
    //   201	6	9	localList	List
    //   214	52	9	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   155	159	162	finally
    //   203	211	214	java/io/IOException
    //   245	249	254	java/io/IOException
    //   193	203	268	finally
    //   203	211	268	finally
    //   221	245	268	finally
    //   265	268	268	finally
    //   8	22	275	finally
    //   23	37	275	finally
    //   44	140	275	finally
    //   140	146	275	finally
    //   151	154	275	finally
    //   164	174	275	finally
    //   174	191	275	finally
    //   245	249	275	finally
    //   259	262	275	finally
    //   263	265	275	finally
    //   269	273	275	finally
    //   273	275	275	finally
    //   276	279	275	finally
    //   269	273	281	java/io/IOException
  }
  
  private static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramString = findField(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, arrayOfObject1.length, paramArrayOfObject.length);
    paramString.set(paramObject, arrayOfObject2);
  }
  
  private static Field findField(Object paramObject, String paramString)
    throws NoSuchFieldException
  {
    Object localObject = paramObject.getClass();
    while (localObject != null) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new NoSuchFieldException(((StringBuilder)localObject).toString());
  }
  
  private static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
    throws NoSuchMethodException
  {
    Object localObject = paramObject.getClass();
    while (localObject != null) {
      try
      {
        Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject = ((Class)localObject).getSuperclass();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Method ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new NoSuchMethodException(((StringBuilder)localObject).toString());
  }
  
  private static ApplicationInfo getApplicationInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationInfo();
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", paramContext);
    }
    return null;
  }
  
  private static ClassLoader getDexClassloader(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader();
      if (Build.VERSION.SDK_INT >= 14)
      {
        if ((paramContext instanceof BaseDexClassLoader)) {
          return paramContext;
        }
      }
      else {
        if (((paramContext instanceof DexClassLoader)) || ((paramContext instanceof PathClassLoader))) {
          break label50;
        }
      }
      Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
      return null;
      label50:
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", paramContext);
    }
    return null;
  }
  
  private static File getDexDir(Context paramContext, File paramFile, String paramString)
    throws IOException
  {
    paramFile = new File(paramFile, "code_cache");
    try
    {
      mkdirChecked(paramFile);
      paramContext = paramFile;
    }
    catch (IOException paramFile)
    {
      paramContext = new File(paramContext.getFilesDir(), "code_cache");
      mkdirChecked(paramContext);
    }
    paramContext = new File(paramContext, paramString);
    mkdirChecked(paramContext);
    return paramContext;
  }
  
  public static void install(Context paramContext)
  {
    Log.i("MultiDex", "Installing application");
    if (IS_VM_MULTIDEX_CAPABLE)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    int i = Build.VERSION.SDK_INT;
    if (i >= 4) {
      try
      {
        ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext);
        if (localApplicationInfo == null)
        {
          Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        }
        localObject = new java/io/File;
        ((File)localObject).<init>(localApplicationInfo.sourceDir);
        File localFile = new java/io/File;
        localFile.<init>(localApplicationInfo.dataDir);
        doInstallation(paramContext, (File)localObject, localFile, "secondary-dexes", "", true);
        Log.i("MultiDex", "install done");
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("MultiDex", "MultiDex installation failure", paramContext);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MultiDex installation failed (");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        ((StringBuilder)localObject).append(").");
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("MultiDex installation failed. SDK ");
    paramContext.append(i);
    paramContext.append(" is unsupported. Min SDK version is ");
    paramContext.append(4);
    paramContext.append(".");
    throw new RuntimeException(paramContext.toString());
  }
  
  public static void installInstrumentation(Context paramContext1, Context paramContext2)
  {
    Log.i("MultiDex", "Installing instrumentation");
    if (IS_VM_MULTIDEX_CAPABLE)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    int i = Build.VERSION.SDK_INT;
    if (i >= 4) {
      try
      {
        Object localObject1 = getApplicationInfo(paramContext1);
        if (localObject1 == null)
        {
          Log.i("MultiDex", "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        }
        ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext2);
        if (localApplicationInfo == null)
        {
          Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        }
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append(paramContext1.getPackageName());
        ((StringBuilder)localObject2).append(".");
        String str = ((StringBuilder)localObject2).toString();
        paramContext1 = new java/io/File;
        paramContext1.<init>(localApplicationInfo.dataDir);
        localObject2 = new java/io/File;
        ((File)localObject2).<init>(((ApplicationInfo)localObject1).sourceDir);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("secondary-dexes");
        doInstallation(paramContext2, (File)localObject2, paramContext1, ((StringBuilder)localObject1).toString(), str, false);
        localObject1 = new java/io/File;
        ((File)localObject1).<init>(localApplicationInfo.sourceDir);
        doInstallation(paramContext2, (File)localObject1, paramContext1, "secondary-dexes", "", false);
        Log.i("MultiDex", "Installation done");
        return;
      }
      catch (Exception paramContext2)
      {
        Log.e("MultiDex", "MultiDex installation failure", paramContext2);
        paramContext1 = new StringBuilder();
        paramContext1.append("MultiDex installation failed (");
        paramContext1.append(paramContext2.getMessage());
        paramContext1.append(").");
        throw new RuntimeException(paramContext1.toString());
      }
    }
    paramContext1 = new StringBuilder();
    paramContext1.append("MultiDex installation failed. SDK ");
    paramContext1.append(i);
    paramContext1.append(" is unsupported. Min SDK version is ");
    paramContext1.append(4);
    paramContext1.append(".");
    throw new RuntimeException(paramContext1.toString());
  }
  
  private static void installSecondaryDexes(ClassLoader paramClassLoader, File paramFile, List<? extends File> paramList)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException
  {
    if (!paramList.isEmpty())
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 19) {
        V19.install(paramClassLoader, paramList, paramFile);
      } else if (i >= 14) {
        V14.install(paramClassLoader, paramList);
      } else {
        V4.install(paramClassLoader, paramList);
      }
    }
  }
  
  static boolean isVMMultidexCapable(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ".");
      bool2 = localStringTokenizer.hasMoreTokens();
      String str1 = null;
      String str2;
      if (bool2) {
        str2 = localStringTokenizer.nextToken();
      } else {
        str2 = null;
      }
      if (localStringTokenizer.hasMoreTokens()) {
        str1 = localStringTokenizer.nextToken();
      }
      bool2 = bool1;
      if (str2 != null)
      {
        bool2 = bool1;
        if (str1 != null) {
          try
          {
            int i = Integer.parseInt(str2);
            int j = Integer.parseInt(str1);
            if (i <= 2)
            {
              bool2 = bool1;
              if (i == 2)
              {
                bool2 = bool1;
                if (j < 1) {}
              }
            }
            else
            {
              bool2 = true;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            bool2 = bool1;
          }
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VM with version ");
    localStringBuilder.append(paramString);
    if (bool2) {
      paramString = " has multidex support";
    } else {
      paramString = " does not have multidex support";
    }
    localStringBuilder.append(paramString);
    Log.i("MultiDex", localStringBuilder.toString());
    return bool2;
  }
  
  private static void mkdirChecked(File paramFile)
    throws IOException
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      File localFile = paramFile.getParentFile();
      if (localFile == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to create dir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(". Parent file is null.");
        Log.e("MultiDex", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to create dir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(". parent file is a dir ");
        localStringBuilder.append(localFile.isDirectory());
        localStringBuilder.append(", a file ");
        localStringBuilder.append(localFile.isFile());
        localStringBuilder.append(", exists ");
        localStringBuilder.append(localFile.exists());
        localStringBuilder.append(", readable ");
        localStringBuilder.append(localFile.canRead());
        localStringBuilder.append(", writable ");
        localStringBuilder.append(localFile.canWrite());
        Log.e("MultiDex", localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to create directory ");
      localStringBuilder.append(paramFile.getPath());
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  private static final class V14
  {
    private static final int EXTRACTED_SUFFIX_LENGTH = 4;
    private final ElementConstructor elementConstructor;
    
    private V14()
      throws ClassNotFoundException, SecurityException, NoSuchMethodException
    {
      Class localClass = Class.forName("dalvik.system.DexPathList$Element");
      JBMR2ElementConstructor localJBMR2ElementConstructor;
      try
      {
        ICSElementConstructor localICSElementConstructor = new androidx/multidex/MultiDex$V14$ICSElementConstructor;
        localICSElementConstructor.<init>(localClass);
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        try
        {
          JBMR11ElementConstructor localJBMR11ElementConstructor = new androidx/multidex/MultiDex$V14$JBMR11ElementConstructor;
          localJBMR11ElementConstructor.<init>(localClass);
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localJBMR2ElementConstructor = new JBMR2ElementConstructor(localClass);
        }
      }
      this.elementConstructor = localJBMR2ElementConstructor;
    }
    
    static void install(ClassLoader paramClassLoader, List<? extends File> paramList)
      throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException
    {
      paramClassLoader = MultiDex.findField(paramClassLoader, "pathList").get(paramClassLoader);
      paramList = new V14().makeDexElements(paramList);
      try
      {
        MultiDex.expandFieldArray(paramClassLoader, "dexElements", paramList);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", localNoSuchFieldException);
        MultiDex.expandFieldArray(paramClassLoader, "pathElements", paramList);
      }
    }
    
    private Object[] makeDexElements(List<? extends File> paramList)
      throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
      int i = paramList.size();
      Object[] arrayOfObject = new Object[i];
      for (int j = 0; j < i; j++)
      {
        File localFile = (File)paramList.get(j);
        arrayOfObject[j] = this.elementConstructor.newInstance(localFile, DexFile.loadDex(localFile.getPath(), optimizedPathFor(localFile), 0));
      }
      return arrayOfObject;
    }
    
    private static String optimizedPathFor(File paramFile)
    {
      File localFile = paramFile.getParentFile();
      paramFile = paramFile.getName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile.substring(0, paramFile.length() - EXTRACTED_SUFFIX_LENGTH));
      localStringBuilder.append(".dex");
      return new File(localFile, localStringBuilder.toString()).getPath();
    }
    
    private static abstract interface ElementConstructor
    {
      public abstract Object newInstance(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
    }
    
    private static class ICSElementConstructor
      implements MultiDex.V14.ElementConstructor
    {
      private final Constructor<?> elementConstructor;
      
      ICSElementConstructor(Class<?> paramClass)
        throws SecurityException, NoSuchMethodException
      {
        paramClass = paramClass.getConstructor(new Class[] { File.class, ZipFile.class, DexFile.class });
        this.elementConstructor = paramClass;
        paramClass.setAccessible(true);
      }
      
      public Object newInstance(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException
      {
        return this.elementConstructor.newInstance(new Object[] { paramFile, new ZipFile(paramFile), paramDexFile });
      }
    }
    
    private static class JBMR11ElementConstructor
      implements MultiDex.V14.ElementConstructor
    {
      private final Constructor<?> elementConstructor;
      
      JBMR11ElementConstructor(Class<?> paramClass)
        throws SecurityException, NoSuchMethodException
      {
        paramClass = paramClass.getConstructor(new Class[] { File.class, File.class, DexFile.class });
        this.elementConstructor = paramClass;
        paramClass.setAccessible(true);
      }
      
      public Object newInstance(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
      {
        return this.elementConstructor.newInstance(new Object[] { paramFile, paramFile, paramDexFile });
      }
    }
    
    private static class JBMR2ElementConstructor
      implements MultiDex.V14.ElementConstructor
    {
      private final Constructor<?> elementConstructor;
      
      JBMR2ElementConstructor(Class<?> paramClass)
        throws SecurityException, NoSuchMethodException
      {
        paramClass = paramClass.getConstructor(new Class[] { File.class, Boolean.TYPE, File.class, DexFile.class });
        this.elementConstructor = paramClass;
        paramClass.setAccessible(true);
      }
      
      public Object newInstance(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
      {
        return this.elementConstructor.newInstance(new Object[] { paramFile, Boolean.FALSE, paramFile, paramDexFile });
      }
    }
  }
  
  private static final class V19
  {
    static void install(ClassLoader paramClassLoader, List<? extends File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException
    {
      Object localObject = MultiDex.findField(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      MultiDex.expandFieldArray(localObject, "dexElements", makeDexElements(localObject, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        while (paramClassLoader.hasNext()) {
          Log.w("MultiDex", "Exception in makeDexElement", (IOException)paramClassLoader.next());
        }
        paramList = MultiDex.findField(localObject, "dexElementsSuppressedExceptions");
        paramFile = (IOException[])paramList.get(localObject);
        if (paramFile == null)
        {
          paramClassLoader = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
        }
        else
        {
          paramClassLoader = new IOException[localArrayList.size() + paramFile.length];
          localArrayList.toArray(paramClassLoader);
          System.arraycopy(paramFile, 0, paramClassLoader, localArrayList.size(), paramFile.length);
        }
        paramList.set(localObject, paramClassLoader);
        paramClassLoader = new IOException("I/O exception during makeDexElement");
        paramClassLoader.initCause((Throwable)localArrayList.get(0));
        throw paramClassLoader;
      }
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])MultiDex.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
    }
  }
  
  private static final class V4
  {
    static void install(ClassLoader paramClassLoader, List<? extends File> paramList)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException
    {
      int i = paramList.size();
      Field localField = MultiDex.findField(paramClassLoader, "path");
      StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      ListIterator localListIterator = paramList.listIterator();
      while (localListIterator.hasNext())
      {
        Object localObject = (File)localListIterator.next();
        paramList = ((File)localObject).getAbsolutePath();
        localStringBuilder.append(':');
        localStringBuilder.append(paramList);
        i = localListIterator.previousIndex();
        arrayOfString[i] = paramList;
        arrayOfFile[i] = localObject;
        arrayOfZipFile[i] = new ZipFile((File)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append(".dex");
        arrayOfDexFile[i] = DexFile.loadDex(paramList, ((StringBuilder)localObject).toString(), 0);
      }
      localField.set(paramClassLoader, localStringBuilder.toString());
      MultiDex.expandFieldArray(paramClassLoader, "mPaths", arrayOfString);
      MultiDex.expandFieldArray(paramClassLoader, "mFiles", arrayOfFile);
      MultiDex.expandFieldArray(paramClassLoader, "mZips", arrayOfZipFile);
      MultiDex.expandFieldArray(paramClassLoader, "mDexs", arrayOfDexFile);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\multidex\MultiDex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
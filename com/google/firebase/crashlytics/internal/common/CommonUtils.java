package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CommonUtils
{
  static final int BYTES_IN_A_GIGABYTE = 1073741824;
  static final int BYTES_IN_A_KILOBYTE = 1024;
  static final int BYTES_IN_A_MEGABYTE = 1048576;
  public static final int DEVICE_STATE_BETAOS = 8;
  public static final int DEVICE_STATE_COMPROMISEDLIBRARIES = 32;
  public static final int DEVICE_STATE_DEBUGGERATTACHED = 4;
  public static final int DEVICE_STATE_ISSIMULATOR = 1;
  public static final int DEVICE_STATE_JAILBROKEN = 2;
  public static final int DEVICE_STATE_VENDORINTERNAL = 16;
  private static final String GOLDFISH = "goldfish";
  private static final char[] HEX_VALUES = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final String LEGACY_MAPPING_FILE_ID_RESOURCE_NAME = "com.crashlytics.android.build_id";
  public static final String LEGACY_SHARED_PREFS_NAME = "com.crashlytics.prefs";
  static final String MAPPING_FILE_ID_RESOURCE_NAME = "com.google.firebase.crashlytics.mapping_file_id";
  private static final String RANCHU = "ranchu";
  private static final String SDK = "sdk";
  private static final String SHA1_INSTANCE = "SHA-1";
  public static final String SHARED_PREFS_NAME = "com.google.firebase.crashlytics";
  private static final long UNCALCULATED_TOTAL_RAM = -1L;
  private static final String UNITY_EDITOR_VERSION = "com.google.firebase.crashlytics.unity_version";
  private static long totalRamInBytes = -1L;
  
  public static long calculateFreeRamInBytes(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  public static long calculateUsedDiskSpaceInBytes(String paramString)
  {
    paramString = new StatFs(paramString);
    long l = paramString.getBlockSize();
    return paramString.getBlockCount() * l - l * paramString.getAvailableBlocks();
  }
  
  @SuppressLint({"MissingPermission"})
  public static boolean canTryConnection(Context paramContext)
  {
    boolean bool1 = checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    boolean bool2 = true;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
    }
    return bool3;
  }
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    boolean bool;
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void closeOrLog(Closeable paramCloseable, String paramString)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
      }
      catch (IOException paramCloseable)
      {
        Logger.getLogger().e(paramString, paramCloseable);
      }
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      try
      {
        paramCloseable.close();
      }
      catch (RuntimeException paramCloseable)
      {
        throw paramCloseable;
      }
      return;
    }
    catch (Exception paramCloseable)
    {
      for (;;) {}
    }
  }
  
  static long convertMemInfoToBytes(String paramString1, String paramString2, int paramInt)
  {
    return Long.parseLong(paramString1.split(paramString2)[0].trim()) * paramInt;
  }
  
  public static String createInstanceIdFrom(String... paramVarArgs)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramVarArgs != null) {
      if (paramVarArgs.length == 0)
      {
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = new ArrayList();
        int i = paramVarArgs.length;
        for (int j = 0; j < i; j++)
        {
          String str = paramVarArgs[j];
          if (str != null) {
            ((List)localObject2).add(str.replace("-", "").toLowerCase(Locale.US));
          }
        }
        Collections.sort((List)localObject2);
        paramVarArgs = new StringBuilder();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramVarArgs.append((String)((Iterator)localObject2).next());
        }
        paramVarArgs = paramVarArgs.toString();
        localObject2 = localObject1;
        if (paramVarArgs.length() > 0) {
          localObject2 = sha1(paramVarArgs);
        }
      }
    }
    return (String)localObject2;
  }
  
  /* Error */
  public static String extractFieldFromSystemFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 270	java/io/File:exists	()Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: iload_2
    //   14: ifeq +213 -> 227
    //   17: new 272	java/io/BufferedReader
    //   20: astore 6
    //   22: new 274	java/io/FileReader
    //   25: astore 4
    //   27: aload 4
    //   29: aload_0
    //   30: invokespecial 277	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   33: aload 6
    //   35: aload 4
    //   37: sipush 1024
    //   40: invokespecial 280	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   43: aload 6
    //   45: astore 4
    //   47: aload 6
    //   49: invokevirtual 283	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 7
    //   54: aload 6
    //   56: astore_3
    //   57: aload 5
    //   59: astore 4
    //   61: aload 7
    //   63: ifnull +52 -> 115
    //   66: aload 6
    //   68: astore 4
    //   70: ldc_w 285
    //   73: invokestatic 291	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   76: aload 7
    //   78: iconst_2
    //   79: invokevirtual 294	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;I)[Ljava/lang/String;
    //   82: astore_3
    //   83: aload 6
    //   85: astore 4
    //   87: aload_3
    //   88: arraylength
    //   89: iconst_1
    //   90: if_icmple -47 -> 43
    //   93: aload 6
    //   95: astore 4
    //   97: aload_3
    //   98: iconst_0
    //   99: aaload
    //   100: aload_1
    //   101: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: ifeq -61 -> 43
    //   107: aload_3
    //   108: iconst_1
    //   109: aaload
    //   110: astore 4
    //   112: aload 6
    //   114: astore_3
    //   115: aload_3
    //   116: ldc_w 299
    //   119: invokestatic 301	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   122: goto +105 -> 227
    //   125: astore 4
    //   127: aload 6
    //   129: astore_1
    //   130: aload 4
    //   132: astore 6
    //   134: goto +14 -> 148
    //   137: astore_0
    //   138: aload_3
    //   139: astore 4
    //   141: goto +76 -> 217
    //   144: astore 6
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: astore 4
    //   151: invokestatic 171	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   154: astore_3
    //   155: aload_1
    //   156: astore 4
    //   158: new 235	java/lang/StringBuilder
    //   161: astore 7
    //   163: aload_1
    //   164: astore 4
    //   166: aload 7
    //   168: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   171: aload_1
    //   172: astore 4
    //   174: aload 7
    //   176: ldc_w 303
    //   179: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: astore 4
    //   186: aload 7
    //   188: aload_0
    //   189: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: astore 4
    //   196: aload_3
    //   197: aload 7
    //   199: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload 6
    //   204: invokevirtual 175	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   207: aload_1
    //   208: astore_3
    //   209: aload 5
    //   211: astore 4
    //   213: goto -98 -> 115
    //   216: astore_0
    //   217: aload 4
    //   219: ldc_w 299
    //   222: invokestatic 301	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   225: aload_0
    //   226: athrow
    //   227: aload 4
    //   229: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramFile	File
    //   0	230	1	paramString	String
    //   4	10	2	bool	boolean
    //   6	203	3	localObject1	Object
    //   8	103	4	localObject2	Object
    //   125	6	4	localException1	Exception
    //   139	89	4	localObject3	Object
    //   11	199	5	localObject4	Object
    //   20	113	6	localObject5	Object
    //   144	59	6	localException2	Exception
    //   52	146	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   47	54	125	java/lang/Exception
    //   70	83	125	java/lang/Exception
    //   87	93	125	java/lang/Exception
    //   97	107	125	java/lang/Exception
    //   17	43	137	finally
    //   17	43	144	java/lang/Exception
    //   47	54	216	finally
    //   70	83	216	finally
    //   87	93	216	finally
    //   97	107	216	finally
    //   151	155	216	finally
    //   158	163	216	finally
    //   166	171	216	finally
    //   174	183	216	finally
    //   186	193	216	finally
    //   196	207	216	finally
  }
  
  public static ActivityManager.RunningAppProcessInfo getAppProcessInfo(String paramString, Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      Iterator localIterator = paramContext.iterator();
      while (localIterator.hasNext())
      {
        paramContext = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (paramContext.processName.equals(paramString)) {
          return paramContext;
        }
      }
    }
    paramString = null;
    return paramString;
  }
  
  public static boolean getBooleanResourceValue(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      if (localResources != null)
      {
        int i = getResourcesIdentifier(paramContext, paramString, "bool");
        if (i > 0) {
          return localResources.getBoolean(i);
        }
        i = getResourcesIdentifier(paramContext, paramString, "string");
        if (i > 0) {
          return Boolean.parseBoolean(paramContext.getString(i));
        }
      }
    }
    return paramBoolean;
  }
  
  public static int getCpuArchitectureInt()
  {
    return Architecture.getValue().ordinal();
  }
  
  public static int getDeviceState(Context paramContext)
  {
    if (isEmulator(paramContext)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (isRooted(paramContext)) {
      j = i | 0x2;
    }
    int i = j;
    if (isDebuggerAttached()) {
      i = j | 0x4;
    }
    return i;
  }
  
  public static SharedPreferences getLegacySharedPrefs(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.crashlytics.prefs", 0);
  }
  
  public static String getMappingFileId(Context paramContext)
  {
    int i = getResourcesIdentifier(paramContext, "com.google.firebase.crashlytics.mapping_file_id", "string");
    int j = i;
    if (i == 0) {
      j = getResourcesIdentifier(paramContext, "com.crashlytics.android.build_id", "string");
    }
    if (j != 0) {
      paramContext = paramContext.getResources().getString(j);
    } else {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static boolean getProximitySensorEnabled(Context paramContext)
  {
    boolean bool1 = isEmulator(paramContext);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8) != null) {
      bool2 = true;
    }
    return bool2;
  }
  
  public static String getResourcePackageName(Context paramContext)
  {
    int i = paramContext.getApplicationContext().getApplicationInfo().icon;
    String str3;
    if (i > 0) {
      try
      {
        String str1 = paramContext.getResources().getResourcePackageName(i);
        String str2 = str1;
        if (!"android".equals(str1)) {
          return str2;
        }
        str2 = paramContext.getPackageName();
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        str3 = paramContext.getPackageName();
      }
    } else {
      str3 = paramContext.getPackageName();
    }
    return str3;
  }
  
  public static int getResourcesIdentifier(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, getResourcePackageName(paramContext));
  }
  
  public static SharedPreferences getSharedPrefs(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.google.firebase.crashlytics", 0);
  }
  
  public static String getStringsFileValue(Context paramContext, String paramString)
  {
    int i = getResourcesIdentifier(paramContext, paramString, "string");
    if (i > 0) {
      return paramContext.getString(i);
    }
    return "";
  }
  
  public static long getTotalRamInBytes()
  {
    try
    {
      if (totalRamInBytes == -1L)
      {
        long l1 = 0L;
        Object localObject1 = new java/io/File;
        ((File)localObject1).<init>("/proc/meminfo");
        localObject1 = extractFieldFromSystemFile((File)localObject1, "MemTotal");
        l2 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).toUpperCase(Locale.US);
          try
          {
            if (((String)localObject1).endsWith("KB"))
            {
              l2 = convertMemInfoToBytes((String)localObject1, "KB", 1024);
            }
            else if (((String)localObject1).endsWith("MB"))
            {
              l2 = convertMemInfoToBytes((String)localObject1, "MB", 1048576);
            }
            else if (((String)localObject1).endsWith("GB"))
            {
              l2 = convertMemInfoToBytes((String)localObject1, "GB", 1073741824);
            }
            else
            {
              localObject3 = Logger.getLogger();
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localStringBuilder.append("Unexpected meminfo format while computing RAM: ");
              localStringBuilder.append((String)localObject1);
              ((Logger)localObject3).w(localStringBuilder.toString());
              l2 = l1;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Logger localLogger = Logger.getLogger();
            Object localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            ((StringBuilder)localObject3).append("Unexpected meminfo format while computing RAM: ");
            ((StringBuilder)localObject3).append((String)localObject1);
            localLogger.e(((StringBuilder)localObject3).toString(), localNumberFormatException);
            l2 = l1;
          }
        }
        totalRamInBytes = l2;
      }
      long l2 = totalRamInBytes;
      return l2;
    }
    finally {}
  }
  
  private static String hash(String paramString1, String paramString2)
  {
    return hash(paramString1.getBytes(), paramString2);
  }
  
  private static String hash(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      localObject = MessageDigest.getInstance(paramString);
      ((MessageDigest)localObject).update(paramArrayOfByte);
      return hexify(((MessageDigest)localObject).digest());
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      paramArrayOfByte = Logger.getLogger();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not create hashing algorithm: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", returning empty string.");
      paramArrayOfByte.e(((StringBuilder)localObject).toString(), localNoSuchAlgorithmException);
    }
    return "";
  }
  
  public static String hexify(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar2 = HEX_VALUES;
      arrayOfChar1[k] = ((char)arrayOfChar2[(j >>> 4)]);
      arrayOfChar1[(k + 1)] = ((char)arrayOfChar2[(j & 0xF)]);
    }
    return new String(arrayOfChar1);
  }
  
  public static boolean isAppDebuggable(Context paramContext)
  {
    boolean bool;
    if ((paramContext.getApplicationInfo().flags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isDebuggerAttached()
  {
    boolean bool;
    if ((!Debug.isDebuggerConnected()) && (!Debug.waitingForDebugger())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isEmulator(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (!Build.PRODUCT.contains("sdk"))
    {
      paramContext = Build.HARDWARE;
      if ((!paramContext.contains("goldfish")) && (!paramContext.contains("ranchu")) && (str != null)) {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  @Deprecated
  public static boolean isLoggingEnabled(Context paramContext)
  {
    return false;
  }
  
  public static boolean isRooted(Context paramContext)
  {
    boolean bool = isEmulator(paramContext);
    paramContext = Build.TAGS;
    if ((!bool) && (paramContext != null) && (paramContext.contains("test-keys"))) {
      return true;
    }
    if (new File("/system/app/Superuser.apk").exists()) {
      return true;
    }
    paramContext = new File("/system/xbin/su");
    return (!bool) && (paramContext.exists());
  }
  
  public static String padWithZerosToMaxIntWidth(int paramInt)
  {
    if (paramInt >= 0) {
      return String.format(Locale.US, "%1$10s", new Object[] { Integer.valueOf(paramInt) }).replace(' ', '0');
    }
    throw new IllegalArgumentException("value must be zero or greater");
  }
  
  public static String resolveUnityEditorVersion(Context paramContext)
  {
    int i = getResourcesIdentifier(paramContext, "com.google.firebase.crashlytics.unity_version", "string");
    if (i != 0)
    {
      paramContext = paramContext.getResources().getString(i);
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unity Editor version is: ");
      localStringBuilder.append(paramContext);
      localLogger.v(localStringBuilder.toString());
    }
    else
    {
      paramContext = null;
    }
    return paramContext;
  }
  
  public static String sha1(String paramString)
  {
    return hash(paramString, "SHA-1");
  }
  
  public static String streamToString(InputStream paramInputStream)
  {
    paramInputStream = new Scanner(paramInputStream).useDelimiter("\\A");
    if (paramInputStream.hasNext()) {
      paramInputStream = paramInputStream.next();
    } else {
      paramInputStream = "";
    }
    return paramInputStream;
  }
  
  static enum Architecture
  {
    private static final Map<String, Architecture> matcher;
    
    static
    {
      Architecture localArchitecture1 = new Architecture("X86_32", 0);
      X86_32 = localArchitecture1;
      Architecture localArchitecture2 = new Architecture("X86_64", 1);
      X86_64 = localArchitecture2;
      Architecture localArchitecture3 = new Architecture("ARM_UNKNOWN", 2);
      ARM_UNKNOWN = localArchitecture3;
      Object localObject = new Architecture("PPC", 3);
      PPC = (Architecture)localObject;
      Architecture localArchitecture4 = new Architecture("PPC64", 4);
      PPC64 = localArchitecture4;
      Architecture localArchitecture5 = new Architecture("ARMV6", 5);
      ARMV6 = localArchitecture5;
      Architecture localArchitecture6 = new Architecture("ARMV7", 6);
      ARMV7 = localArchitecture6;
      Architecture localArchitecture7 = new Architecture("UNKNOWN", 7);
      UNKNOWN = localArchitecture7;
      Architecture localArchitecture8 = new Architecture("ARMV7S", 8);
      ARMV7S = localArchitecture8;
      Architecture localArchitecture9 = new Architecture("ARM64", 9);
      ARM64 = localArchitecture9;
      $VALUES = new Architecture[] { localArchitecture1, localArchitecture2, localArchitecture3, localObject, localArchitecture4, localArchitecture5, localArchitecture6, localArchitecture7, localArchitecture8, localArchitecture9 };
      localObject = new HashMap(4);
      matcher = (Map)localObject;
      ((Map)localObject).put("armeabi-v7a", localArchitecture6);
      ((Map)localObject).put("armeabi", localArchitecture5);
      ((Map)localObject).put("arm64-v8a", localArchitecture9);
      ((Map)localObject).put("x86", localArchitecture1);
    }
    
    static Architecture getValue()
    {
      Object localObject = Build.CPU_ABI;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Logger.getLogger().v("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        return UNKNOWN;
      }
      localObject = ((String)localObject).toLowerCase(Locale.US);
      Architecture localArchitecture = (Architecture)matcher.get(localObject);
      localObject = localArchitecture;
      if (localArchitecture == null) {
        localObject = UNKNOWN;
      }
      return (Architecture)localObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
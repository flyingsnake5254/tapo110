package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.Build;
import java.io.File;

public final class zzbe
{
  /* Error */
  private static zzbf zza(File paramFile)
  {
    // Byte code:
    //   0: new 15	java/io/BufferedReader
    //   3: astore_1
    //   4: new 17	java/io/InputStreamReader
    //   7: astore_2
    //   8: new 19	java/io/FileInputStream
    //   11: astore_3
    //   12: aload_3
    //   13: aload_0
    //   14: invokespecial 22	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: aload_2
    //   18: aload_3
    //   19: invokespecial 25	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: aload_1
    //   23: aload_2
    //   24: invokespecial 28	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: new 30	java/util/HashMap
    //   30: astore_3
    //   31: aload_3
    //   32: invokespecial 31	java/util/HashMap:<init>	()V
    //   35: aload_1
    //   36: invokevirtual 35	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +134 -> 175
    //   44: aload_2
    //   45: ldc 37
    //   47: iconst_3
    //   48: invokevirtual 43	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   51: astore 4
    //   53: aload 4
    //   55: arraylength
    //   56: iconst_3
    //   57: if_icmpeq +40 -> 97
    //   60: aload_2
    //   61: invokevirtual 47	java/lang/String:length	()I
    //   64: ifeq +13 -> 77
    //   67: ldc 49
    //   69: aload_2
    //   70: invokevirtual 53	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_2
    //   74: goto +13 -> 87
    //   77: new 39	java/lang/String
    //   80: dup
    //   81: ldc 49
    //   83: invokespecial 56	java/lang/String:<init>	(Ljava/lang/String;)V
    //   86: astore_2
    //   87: ldc 58
    //   89: aload_2
    //   90: invokestatic 64	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: goto -59 -> 35
    //   97: aload 4
    //   99: iconst_0
    //   100: aaload
    //   101: astore 5
    //   103: aload 4
    //   105: iconst_1
    //   106: aaload
    //   107: invokestatic 69	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_2
    //   111: aload 4
    //   113: iconst_2
    //   114: aaload
    //   115: invokestatic 69	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 4
    //   120: aload_3
    //   121: aload 5
    //   123: invokeinterface 75 2 0
    //   128: ifne +24 -> 152
    //   131: new 30	java/util/HashMap
    //   134: astore 6
    //   136: aload 6
    //   138: invokespecial 31	java/util/HashMap:<init>	()V
    //   141: aload_3
    //   142: aload 5
    //   144: aload 6
    //   146: invokeinterface 79 3 0
    //   151: pop
    //   152: aload_3
    //   153: aload 5
    //   155: invokeinterface 83 2 0
    //   160: checkcast 71	java/util/Map
    //   163: aload_2
    //   164: aload 4
    //   166: invokeinterface 79 3 0
    //   171: pop
    //   172: goto -137 -> 35
    //   175: aload_0
    //   176: invokestatic 87	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   179: astore_2
    //   180: aload_2
    //   181: invokevirtual 47	java/lang/String:length	()I
    //   184: istore 7
    //   186: new 89	java/lang/StringBuilder
    //   189: astore_0
    //   190: aload_0
    //   191: iload 7
    //   193: bipush 7
    //   195: iadd
    //   196: invokespecial 92	java/lang/StringBuilder:<init>	(I)V
    //   199: aload_0
    //   200: ldc 94
    //   202: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_0
    //   207: aload_2
    //   208: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 58
    //   214: aload_0
    //   215: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 104	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: new 106	com/google/android/gms/internal/vision/zzbf
    //   225: dup
    //   226: aload_3
    //   227: invokespecial 109	com/google/android/gms/internal/vision/zzbf:<init>	(Ljava/util/Map;)V
    //   230: astore_0
    //   231: aload_1
    //   232: invokevirtual 112	java/io/BufferedReader:close	()V
    //   235: aload_0
    //   236: areturn
    //   237: astore_0
    //   238: aload_1
    //   239: invokevirtual 112	java/io/BufferedReader:close	()V
    //   242: goto +9 -> 251
    //   245: astore_2
    //   246: aload_0
    //   247: aload_2
    //   248: invokestatic 117	com/google/android/gms/internal/vision/zzdx:zza	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   251: aload_0
    //   252: athrow
    //   253: astore_0
    //   254: new 119	java/lang/RuntimeException
    //   257: dup
    //   258: aload_0
    //   259: invokespecial 122	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFile	File
    //   3	236	1	localBufferedReader	java.io.BufferedReader
    //   7	201	2	localObject1	Object
    //   245	3	2	localThrowable	Throwable
    //   11	216	3	localObject2	Object
    //   51	114	4	localObject3	Object
    //   101	53	5	localObject4	Object
    //   134	11	6	localHashMap	java.util.HashMap
    //   184	12	7	i	int
    // Exception table:
    //   from	to	target	type
    //   27	35	237	finally
    //   35	40	237	finally
    //   44	74	237	finally
    //   77	87	237	finally
    //   87	94	237	finally
    //   103	152	237	finally
    //   152	172	237	finally
    //   175	231	237	finally
    //   238	242	245	finally
    //   0	27	253	java/io/IOException
    //   231	235	253	java/io/IOException
    //   246	251	253	java/io/IOException
    //   251	253	253	java/io/IOException
  }
  
  public static zzcs<zzbf> zzf(Context paramContext)
  {
    Object localObject = Build.TYPE;
    String str = Build.TAGS;
    boolean bool = ((String)localObject).equals("eng");
    int i = 0;
    if (((bool) || (((String)localObject).equals("userdebug"))) && ((str.contains("dev-keys")) || (str.contains("test-keys")))) {
      i = 1;
    }
    if (i == 0) {
      return zzcs.zzby();
    }
    localObject = paramContext;
    if (zzas.zzt()) {
      if (paramContext.isDeviceProtectedStorage()) {
        localObject = paramContext;
      } else {
        localObject = paramContext.createDeviceProtectedStorageContext();
      }
    }
    paramContext = zzg((Context)localObject);
    if (paramContext.isPresent()) {
      return zzcs.zzc(zza((File)paramContext.get()));
    }
    return zzcs.zzby();
  }
  
  /* Error */
  private static zzcs<File> zzg(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 194	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_1
    //   4: invokestatic 197	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   7: pop
    //   8: new 180	java/io/File
    //   11: astore_2
    //   12: aload_2
    //   13: aload_0
    //   14: ldc -57
    //   16: iconst_0
    //   17: invokevirtual 203	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   20: ldc -51
    //   22: invokespecial 208	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   25: aload_2
    //   26: invokevirtual 211	java/io/File:exists	()Z
    //   29: ifeq +11 -> 40
    //   32: aload_2
    //   33: invokestatic 186	com/google/android/gms/internal/vision/zzcs:zzc	(Ljava/lang/Object;)Lcom/google/android/gms/internal/vision/zzcs;
    //   36: astore_0
    //   37: goto +7 -> 44
    //   40: invokestatic 154	com/google/android/gms/internal/vision/zzcs:zzby	()Lcom/google/android/gms/internal/vision/zzcs;
    //   43: astore_0
    //   44: aload_1
    //   45: invokestatic 215	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: ldc 58
    //   53: ldc -39
    //   55: aload_0
    //   56: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   59: pop
    //   60: invokestatic 154	com/google/android/gms/internal/vision/zzcs:zzby	()Lcom/google/android/gms/internal/vision/zzcs;
    //   63: astore_0
    //   64: aload_1
    //   65: invokestatic 215	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   68: aload_0
    //   69: areturn
    //   70: astore_0
    //   71: aload_1
    //   72: invokestatic 215	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramContext	Context
    //   3	69	1	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   11	22	2	localFile	File
    // Exception table:
    //   from	to	target	type
    //   8	25	50	java/lang/RuntimeException
    //   4	8	70	finally
    //   8	25	70	finally
    //   25	37	70	finally
    //   40	44	70	finally
    //   51	64	70	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
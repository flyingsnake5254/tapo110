package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
public class ProcessUtils
{
  private static String zzhf;
  private static int zzhg;
  
  @Nullable
  @KeepForSdk
  public static String getMyProcessName()
  {
    if (zzhf == null)
    {
      if (zzhg == 0) {
        zzhg = Process.myPid();
      }
      zzhf = zzd(zzhg);
    }
    return zzhf;
  }
  
  /* Error */
  @Nullable
  private static String zzd(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: iload_0
    //   3: ifgt +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: new 38	java/lang/StringBuilder
    //   11: astore_2
    //   12: aload_2
    //   13: bipush 25
    //   15: invokespecial 41	java/lang/StringBuilder:<init>	(I)V
    //   18: aload_2
    //   19: ldc 43
    //   21: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_2
    //   26: iload_0
    //   27: invokevirtual 50	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: ldc 52
    //   34: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 59	com/google/android/gms/common/util/ProcessUtils:zzk	(Ljava/lang/String;)Ljava/io/BufferedReader;
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 64	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: invokevirtual 69	java/lang/String:trim	()Ljava/lang/String;
    //   53: astore_3
    //   54: aload_2
    //   55: invokestatic 75	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   58: aload_3
    //   59: astore_2
    //   60: goto +29 -> 89
    //   63: astore_1
    //   64: aload_2
    //   65: astore_3
    //   66: goto +8 -> 74
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_3
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: invokestatic 75	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   78: aload_1
    //   79: athrow
    //   80: astore_2
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: invokestatic 75	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   87: aload_1
    //   88: astore_2
    //   89: aload_2
    //   90: areturn
    //   91: astore_3
    //   92: goto -9 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramInt	int
    //   1	1	1	localObject1	Object
    //   63	1	1	localObject2	Object
    //   73	15	1	localObject3	Object
    //   11	54	2	localObject4	Object
    //   69	4	2	localObject5	Object
    //   80	1	2	localIOException1	IOException
    //   82	8	2	localObject6	Object
    //   53	22	3	localObject7	Object
    //   91	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   46	54	63	finally
    //   8	46	69	finally
    //   8	46	80	java/io/IOException
    //   46	54	91	java/io/IOException
  }
  
  private static BufferedReader zzk(String paramString)
    throws IOException
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      FileReader localFileReader = new java/io/FileReader;
      localFileReader.<init>(paramString);
      paramString = new BufferedReader(localFileReader);
      return paramString;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\ProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
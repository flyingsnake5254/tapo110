package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WorkerThread
final class zzhz
  implements Runnable
{
  private final URL zzb;
  private final String zzc;
  private final zzfs zzd;
  
  public zzhz(String paramString, URL paramURL, byte[] paramArrayOfByte, Map<String, String> paramMap, zzfs paramzzfs)
  {
    Preconditions.checkNotEmpty(paramURL);
    Preconditions.checkNotNull(paramArrayOfByte);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zzb = paramArrayOfByte;
    this.zzd = ((zzfs)localObject);
    this.zzc = paramURL;
  }
  
  private final void zzb(int paramInt, Exception paramException, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    this.zza.zzs.zzav().zzh(new zzhy(this, paramInt, paramException, paramArrayOfByte, paramMap));
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzia;
    //   4: invokevirtual 72	com/google/android/gms/measurement/internal/zzgn:zzaw	()V
    //   7: aload_0
    //   8: getfield 19	com/google/android/gms/measurement/internal/zzhz:zza	Lcom/google/android/gms/measurement/internal/zzia;
    //   11: aload_0
    //   12: getfield 34	com/google/android/gms/measurement/internal/zzhz:zzb	Ljava/net/URL;
    //   15: invokevirtual 77	com/google/android/gms/measurement/internal/zzia:zzd	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 83	java/net/HttpURLConnection:getResponseCode	()I
    //   23: istore_2
    //   24: aload_1
    //   25: invokevirtual 87	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   28: astore_3
    //   29: new 89	java/io/ByteArrayOutputStream
    //   32: astore 4
    //   34: aload 4
    //   36: invokespecial 90	java/io/ByteArrayOutputStream:<init>	()V
    //   39: aload_1
    //   40: invokevirtual 94	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   43: astore 5
    //   45: sipush 1024
    //   48: newarray <illegal type>
    //   50: astore 6
    //   52: aload 5
    //   54: aload 6
    //   56: invokevirtual 100	java/io/InputStream:read	([B)I
    //   59: istore 7
    //   61: iload 7
    //   63: ifle +16 -> 79
    //   66: aload 4
    //   68: aload 6
    //   70: iconst_0
    //   71: iload 7
    //   73: invokevirtual 104	java/io/ByteArrayOutputStream:write	([BII)V
    //   76: goto -24 -> 52
    //   79: aload 4
    //   81: invokevirtual 108	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   84: astore 6
    //   86: aload 5
    //   88: invokevirtual 111	java/io/InputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 114	java/net/HttpURLConnection:disconnect	()V
    //   95: aload_0
    //   96: iload_2
    //   97: aconst_null
    //   98: aload 6
    //   100: aload_3
    //   101: invokespecial 116	com/google/android/gms/measurement/internal/zzhz:zzb	(ILjava/lang/Exception;[BLjava/util/Map;)V
    //   104: return
    //   105: astore 6
    //   107: goto +8 -> 115
    //   110: astore 6
    //   112: aconst_null
    //   113: astore 5
    //   115: aload 5
    //   117: ifnull +8 -> 125
    //   120: aload 5
    //   122: invokevirtual 111	java/io/InputStream:close	()V
    //   125: aload 6
    //   127: athrow
    //   128: astore 6
    //   130: aload_1
    //   131: astore 5
    //   133: aload_3
    //   134: astore_1
    //   135: goto +74 -> 209
    //   138: astore 6
    //   140: aload_1
    //   141: astore 5
    //   143: aload_3
    //   144: astore_1
    //   145: goto +94 -> 239
    //   148: astore 6
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_1
    //   153: astore 5
    //   155: aload_3
    //   156: astore_1
    //   157: goto +52 -> 209
    //   160: astore 6
    //   162: aconst_null
    //   163: astore_3
    //   164: aload_1
    //   165: astore 5
    //   167: aload_3
    //   168: astore_1
    //   169: goto +70 -> 239
    //   172: astore 6
    //   174: aconst_null
    //   175: astore_3
    //   176: iconst_0
    //   177: istore_2
    //   178: aload_1
    //   179: astore 5
    //   181: aload_3
    //   182: astore_1
    //   183: goto +26 -> 209
    //   186: astore 6
    //   188: aconst_null
    //   189: astore_3
    //   190: iconst_0
    //   191: istore_2
    //   192: aload_1
    //   193: astore 5
    //   195: aload_3
    //   196: astore_1
    //   197: goto +42 -> 239
    //   200: astore 6
    //   202: aconst_null
    //   203: astore_1
    //   204: iconst_0
    //   205: istore_2
    //   206: aload_1
    //   207: astore 5
    //   209: aload 5
    //   211: ifnull +8 -> 219
    //   214: aload 5
    //   216: invokevirtual 114	java/net/HttpURLConnection:disconnect	()V
    //   219: aload_0
    //   220: iload_2
    //   221: aconst_null
    //   222: aconst_null
    //   223: aload_1
    //   224: invokespecial 116	com/google/android/gms/measurement/internal/zzhz:zzb	(ILjava/lang/Exception;[BLjava/util/Map;)V
    //   227: aload 6
    //   229: athrow
    //   230: astore 6
    //   232: aconst_null
    //   233: astore_1
    //   234: iconst_0
    //   235: istore_2
    //   236: aload_1
    //   237: astore 5
    //   239: aload 5
    //   241: ifnull +8 -> 249
    //   244: aload 5
    //   246: invokevirtual 114	java/net/HttpURLConnection:disconnect	()V
    //   249: aload_0
    //   250: iload_2
    //   251: aload 6
    //   253: aconst_null
    //   254: aload_1
    //   255: invokespecial 116	com/google/android/gms/measurement/internal/zzhz:zzb	(ILjava/lang/Exception;[BLjava/util/Map;)V
    //   258: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	zzhz
    //   18	237	1	localObject1	Object
    //   23	228	2	i	int
    //   28	168	3	localMap	Map
    //   32	48	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   43	202	5	localObject2	Object
    //   50	49	6	arrayOfByte	byte[]
    //   105	1	6	localObject3	Object
    //   110	16	6	localObject4	Object
    //   128	1	6	localObject5	Object
    //   138	1	6	localIOException1	java.io.IOException
    //   148	1	6	localObject6	Object
    //   160	1	6	localIOException2	java.io.IOException
    //   172	1	6	localObject7	Object
    //   186	1	6	localIOException3	java.io.IOException
    //   200	28	6	localObject8	Object
    //   230	22	6	localIOException4	java.io.IOException
    //   59	13	7	j	int
    // Exception table:
    //   from	to	target	type
    //   45	52	105	finally
    //   52	61	105	finally
    //   66	76	105	finally
    //   79	86	105	finally
    //   29	45	110	finally
    //   86	91	128	finally
    //   120	125	128	finally
    //   125	128	128	finally
    //   86	91	138	java/io/IOException
    //   120	125	138	java/io/IOException
    //   125	128	138	java/io/IOException
    //   24	29	148	finally
    //   24	29	160	java/io/IOException
    //   19	24	172	finally
    //   19	24	186	java/io/IOException
    //   7	19	200	finally
    //   7	19	230	java/io/IOException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzhz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
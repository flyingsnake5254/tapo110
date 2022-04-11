package b.d.t.e;

import android.text.TextUtils;
import b.d.p.d;
import com.tplink.libtpstreampreconnect.bean.Status;
import io.reactivex.q;
import java.util.HashMap;
import java.util.Map;

public class e
{
  public static Status a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "multipart/mixed; boundary=--client-stream-boundary--");
    String str = d(paramString);
    int i = e(paramString);
    paramString = new StringBuilder();
    paramString.append("ip ");
    paramString.append(str);
    paramString.append(" ---------port ");
    paramString.append(i);
    d.a("UpnpUtils", paramString.toString());
    if ((!TextUtils.isEmpty(str)) && (i >= 0))
    {
      i = m(c(str, i), "POST", localHashMap);
      paramString = new StringBuilder();
      paramString.append("is connection success ");
      paramString.append(i);
      d.a("UpnpUtils", paramString.toString());
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return Status.unknown;
          }
          return Status.unknown;
        }
        return Status.failed;
      }
      return Status.success;
    }
    return Status.unknown;
  }
  
  public static void b(String paramString, Runnable paramRunnable)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    q.f0(Integer.valueOf(1)).E(new a(paramString, paramRunnable)).C(b.c).L0(io.reactivex.l0.a.c()).F0();
  }
  
  private static String c(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/stream");
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramString = b.d.d.j.b.b.getUpnpIp(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (!"null".equals(paramString))) {
      return paramString;
    }
    return "";
  }
  
  public static int e(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return b.d.d.j.b.b.getUpnpPort(paramString);
  }
  
  public static int f(String paramString)
  {
    return b.d.d.j.b.b.getUpnpTimestamp(paramString);
  }
  
  public static boolean g(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return b.d.d.j.b.b.isUpnpEnabled(paramString);
  }
  
  public static boolean h(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = b.d.d.j.b.b.getUpnpStatus(paramString);
    return Status.success.name().equals(paramString);
  }
  
  public static boolean i(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = b.d.d.j.b.b.getUpnpStatus(paramString);
    return Status.unknown.name().equals(paramString);
  }
  
  public static q k(String paramString)
  {
    return b.d.d.j.b.b.renewUpnpPsk(paramString);
  }
  
  public static void l(String paramString, Status paramStatus)
  {
    if (paramStatus != null) {
      b.d.d.j.b.b.updateUpnpCommStatus(paramString, paramStatus.name());
    }
  }
  
  /* Error */
  private static int m(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload 5
    //   10: astore 6
    //   12: new 207	java/net/URL
    //   15: astore 7
    //   17: aload 5
    //   19: astore 6
    //   21: aload 7
    //   23: aload_0
    //   24: invokespecial 210	java/net/URL:<init>	(Ljava/lang/String;)V
    //   27: aload 5
    //   29: astore 6
    //   31: aload 7
    //   33: invokevirtual 214	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   36: checkcast 216	java/net/HttpURLConnection
    //   39: astore_0
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 219	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: sipush 30000
    //   49: invokevirtual 223	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   52: aload_0
    //   53: sipush 15000
    //   56: invokevirtual 226	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   59: aload_2
    //   60: ifnull +64 -> 124
    //   63: aload_2
    //   64: invokeinterface 229 1 0
    //   69: ifne +55 -> 124
    //   72: aload_2
    //   73: invokeinterface 233 1 0
    //   78: invokeinterface 239 1 0
    //   83: astore 6
    //   85: aload 6
    //   87: invokeinterface 244 1 0
    //   92: ifeq +32 -> 124
    //   95: aload 6
    //   97: invokeinterface 248 1 0
    //   102: checkcast 151	java/lang/String
    //   105: astore_1
    //   106: aload_0
    //   107: aload_1
    //   108: aload_2
    //   109: aload_1
    //   110: invokeinterface 252 2 0
    //   115: checkcast 151	java/lang/String
    //   118: invokevirtual 255	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: goto -36 -> 85
    //   124: aload_0
    //   125: invokevirtual 258	java/net/HttpURLConnection:connect	()V
    //   128: aload_0
    //   129: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: astore_1
    //   135: aload_0
    //   136: astore 6
    //   138: aload_1
    //   139: astore_0
    //   140: goto +156 -> 296
    //   143: astore_1
    //   144: goto +14 -> 158
    //   147: astore_1
    //   148: goto +77 -> 225
    //   151: astore_0
    //   152: goto +144 -> 296
    //   155: astore_1
    //   156: aload_3
    //   157: astore_0
    //   158: aload_0
    //   159: astore 6
    //   161: new 32	java/lang/StringBuilder
    //   164: astore_2
    //   165: aload_0
    //   166: astore 6
    //   168: aload_2
    //   169: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   172: aload_0
    //   173: astore 6
    //   175: aload_2
    //   176: ldc_w 263
    //   179: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_0
    //   184: astore 6
    //   186: aload_2
    //   187: aload_1
    //   188: invokevirtual 266	java/io/IOException:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_0
    //   196: astore 6
    //   198: ldc 46
    //   200: aload_2
    //   201: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 55	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_0
    //   208: ifnull +7 -> 215
    //   211: aload_0
    //   212: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
    //   215: iconst_2
    //   216: istore 8
    //   218: goto +75 -> 293
    //   221: astore_1
    //   222: aload 4
    //   224: astore_0
    //   225: aload_0
    //   226: astore 6
    //   228: new 32	java/lang/StringBuilder
    //   231: astore_2
    //   232: aload_0
    //   233: astore 6
    //   235: aload_2
    //   236: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   239: aload_0
    //   240: astore 6
    //   242: aload_2
    //   243: ldc_w 268
    //   246: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_0
    //   251: astore 6
    //   253: aload_2
    //   254: aload_1
    //   255: invokevirtual 269	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_0
    //   263: astore 6
    //   265: ldc 46
    //   267: aload_2
    //   268: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 55	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: iconst_1
    //   275: istore 9
    //   277: iload 9
    //   279: istore 8
    //   281: aload_0
    //   282: ifnull +11 -> 293
    //   285: aload_0
    //   286: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
    //   289: iload 9
    //   291: istore 8
    //   293: iload 8
    //   295: ireturn
    //   296: aload 6
    //   298: ifnull +8 -> 306
    //   301: aload 6
    //   303: invokevirtual 261	java/net/HttpURLConnection:disconnect	()V
    //   306: aload_0
    //   307: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramString1	String
    //   0	308	1	paramString2	String
    //   0	308	2	paramMap	Map<String, String>
    //   1	156	3	localObject1	Object
    //   3	220	4	localObject2	Object
    //   6	22	5	localObject3	Object
    //   10	292	6	localObject4	Object
    //   15	17	7	localURL	java.net.URL
    //   216	78	8	i	int
    //   275	15	9	j	int
    // Exception table:
    //   from	to	target	type
    //   40	59	134	finally
    //   63	85	134	finally
    //   85	121	134	finally
    //   124	128	134	finally
    //   40	59	143	java/io/IOException
    //   63	85	143	java/io/IOException
    //   85	121	143	java/io/IOException
    //   124	128	143	java/io/IOException
    //   40	59	147	java/net/SocketTimeoutException
    //   63	85	147	java/net/SocketTimeoutException
    //   85	121	147	java/net/SocketTimeoutException
    //   124	128	147	java/net/SocketTimeoutException
    //   12	17	151	finally
    //   21	27	151	finally
    //   31	40	151	finally
    //   161	165	151	finally
    //   168	172	151	finally
    //   175	183	151	finally
    //   186	195	151	finally
    //   198	207	151	finally
    //   228	232	151	finally
    //   235	239	151	finally
    //   242	250	151	finally
    //   253	262	151	finally
    //   265	274	151	finally
    //   12	17	155	java/io/IOException
    //   21	27	155	java/io/IOException
    //   31	40	155	java/io/IOException
    //   12	17	221	java/net/SocketTimeoutException
    //   21	27	221	java/net/SocketTimeoutException
    //   31	40	221	java/net/SocketTimeoutException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
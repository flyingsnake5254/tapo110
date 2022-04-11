package com.tplink.libtpmediastatistics;

import androidx.annotation.NonNull;
import io.reactivex.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FeedbackUploadManager
{
  private static final String TAG = "FeedbackUploadManager";
  private static final int TIME_SEC = 200;
  private String clientType;
  private boolean debug = false;
  private ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory()
  {
    private final AtomicInteger count = new AtomicInteger(0);
    
    public Thread newThread(@NonNull Runnable paramAnonymousRunnable)
    {
      Thread localThread = new Thread(paramAnonymousRunnable);
      paramAnonymousRunnable = new StringBuilder();
      paramAnonymousRunnable.append("pool-FeedbackUpload.executorService-");
      paramAnonymousRunnable.append(this.count.incrementAndGet());
      localThread.setName(paramAnonymousRunnable.toString());
      return localThread;
    }
  });
  private LinkedBlockingQueue<String> feedbackQueue = new LinkedBlockingQueue();
  private String host;
  private io.reactivex.e0.c payloadUploadDisposable;
  private int port;
  private String token;
  
  public static FeedbackUploadManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  /* Error */
  private void uploadAsync(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_3
    //   5: astore 4
    //   7: new 110	com/tplink/libtpmediastatistics/SSLClient
    //   10: astore 5
    //   12: aload_3
    //   13: astore 4
    //   15: aload 5
    //   17: aload_0
    //   18: getfield 112	com/tplink/libtpmediastatistics/FeedbackUploadManager:host	Ljava/lang/String;
    //   21: aload_0
    //   22: getfield 114	com/tplink/libtpmediastatistics/FeedbackUploadManager:port	I
    //   25: invokespecial 117	com/tplink/libtpmediastatistics/SSLClient:<init>	(Ljava/lang/String;I)V
    //   28: aload 5
    //   30: aload_0
    //   31: getfield 119	com/tplink/libtpmediastatistics/FeedbackUploadManager:clientType	Ljava/lang/String;
    //   34: invokevirtual 122	com/tplink/libtpmediastatistics/SSLClient:setClientType	(Ljava/lang/String;)V
    //   37: aload 5
    //   39: aload_0
    //   40: getfield 124	com/tplink/libtpmediastatistics/FeedbackUploadManager:token	Ljava/lang/String;
    //   43: invokevirtual 127	com/tplink/libtpmediastatistics/SSLClient:setLoginToken	(Ljava/lang/String;)V
    //   46: aload 5
    //   48: invokevirtual 130	com/tplink/libtpmediastatistics/SSLClient:isSocketAvailable	()Z
    //   51: ifne +8 -> 59
    //   54: aload 5
    //   56: invokevirtual 133	com/tplink/libtpmediastatistics/SSLClient:renewSocket	()V
    //   59: aload 5
    //   61: invokevirtual 137	com/tplink/libtpmediastatistics/SSLClient:connect	()Lcom/tplink/libtpmediastatistics/SSLClient;
    //   64: pop
    //   65: aload 5
    //   67: aload_1
    //   68: invokevirtual 140	com/tplink/libtpmediastatistics/SSLClient:sendPayload	(Ljava/lang/String;)V
    //   71: aload 5
    //   73: invokevirtual 144	com/tplink/libtpmediastatistics/SSLClient:getRespondCode	()I
    //   76: istore 6
    //   78: new 146	java/lang/StringBuilder
    //   81: astore_1
    //   82: aload_1
    //   83: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   86: aload_1
    //   87: ldc -107
    //   89: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: iload 6
    //   96: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 13
    //   102: aload_1
    //   103: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 166	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: iload 6
    //   111: sipush 200
    //   114: if_icmpne +162 -> 276
    //   117: aload 5
    //   119: invokevirtual 170	com/tplink/libtpmediastatistics/SSLClient:getRespondHeader	()Ljava/util/Map;
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 35	com/tplink/libtpmediastatistics/FeedbackUploadManager:debug	Z
    //   127: ifeq +103 -> 230
    //   130: aload_1
    //   131: invokeinterface 176 1 0
    //   136: invokeinterface 182 1 0
    //   141: astore 4
    //   143: aload 4
    //   145: invokeinterface 187 1 0
    //   150: ifeq +80 -> 230
    //   153: aload 4
    //   155: invokeinterface 190 1 0
    //   160: checkcast 192	java/util/Map$Entry
    //   163: astore_2
    //   164: aload_2
    //   165: invokeinterface 195 1 0
    //   170: checkcast 85	java/lang/String
    //   173: astore_1
    //   174: aload_2
    //   175: invokeinterface 198 1 0
    //   180: checkcast 85	java/lang/String
    //   183: astore_3
    //   184: new 146	java/lang/StringBuilder
    //   187: astore_2
    //   188: aload_2
    //   189: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   192: aload_2
    //   193: ldc -56
    //   195: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: aload_1
    //   201: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc -54
    //   208: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: aload_3
    //   214: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc 13
    //   220: aload_2
    //   221: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 166	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: goto -84 -> 143
    //   230: new 85	java/lang/String
    //   233: astore 4
    //   235: aload 4
    //   237: aload 5
    //   239: invokevirtual 206	com/tplink/libtpmediastatistics/SSLClient:getRaw	()[B
    //   242: invokespecial 209	java/lang/String:<init>	([B)V
    //   245: new 146	java/lang/StringBuilder
    //   248: astore_1
    //   249: aload_1
    //   250: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   253: aload_1
    //   254: ldc -45
    //   256: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: aload 4
    //   263: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: ldc 13
    //   269: aload_1
    //   270: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 166	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 5
    //   278: invokevirtual 214	com/tplink/libtpmediastatistics/SSLClient:disconnect	()V
    //   281: goto +96 -> 377
    //   284: astore_1
    //   285: aload 5
    //   287: astore 4
    //   289: goto +89 -> 378
    //   292: astore 4
    //   294: aload 5
    //   296: astore_1
    //   297: aload 4
    //   299: astore 5
    //   301: goto +11 -> 312
    //   304: astore_1
    //   305: goto +73 -> 378
    //   308: astore 5
    //   310: aload_2
    //   311: astore_1
    //   312: aload_1
    //   313: astore 4
    //   315: aload 5
    //   317: invokevirtual 217	java/io/IOException:printStackTrace	()V
    //   320: aload_1
    //   321: astore 4
    //   323: new 146	java/lang/StringBuilder
    //   326: astore_2
    //   327: aload_1
    //   328: astore 4
    //   330: aload_2
    //   331: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   334: aload_1
    //   335: astore 4
    //   337: aload_2
    //   338: ldc -37
    //   340: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: astore 4
    //   347: aload_2
    //   348: aload 5
    //   350: invokevirtual 220	java/io/IOException:toString	()Ljava/lang/String;
    //   353: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_1
    //   358: astore 4
    //   360: ldc 13
    //   362: aload_2
    //   363: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 166	b/d/p/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 214	com/tplink/libtpmediastatistics/SSLClient:disconnect	()V
    //   377: return
    //   378: aload 4
    //   380: ifnull +8 -> 388
    //   383: aload 4
    //   385: invokevirtual 214	com/tplink/libtpmediastatistics/SSLClient:disconnect	()V
    //   388: aload_1
    //   389: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	FeedbackUploadManager
    //   0	390	1	paramString	String
    //   1	362	2	localObject1	Object
    //   3	211	3	str1	String
    //   5	283	4	localObject2	Object
    //   292	6	4	localIOException1	java.io.IOException
    //   313	71	4	str2	String
    //   10	290	5	localObject3	Object
    //   308	41	5	localIOException2	java.io.IOException
    //   76	39	6	i	int
    // Exception table:
    //   from	to	target	type
    //   28	59	284	finally
    //   59	109	284	finally
    //   117	143	284	finally
    //   143	227	284	finally
    //   230	276	284	finally
    //   28	59	292	java/io/IOException
    //   59	109	292	java/io/IOException
    //   117	143	292	java/io/IOException
    //   143	227	292	java/io/IOException
    //   230	276	292	java/io/IOException
    //   7	12	304	finally
    //   15	28	304	finally
    //   315	320	304	finally
    //   323	327	304	finally
    //   330	334	304	finally
    //   337	344	304	finally
    //   347	357	304	finally
    //   360	369	304	finally
    //   7	12	308	java/io/IOException
    //   15	28	308	java/io/IOException
  }
  
  private q<Boolean> uploadPayload(String paramString)
  {
    return q.f0(paramString).L(a.c).N(new c(this)).L0(io.reactivex.l0.a.b(this.executorService));
  }
  
  public void destroy()
  {
    io.reactivex.e0.c localc = this.payloadUploadDisposable;
    if (localc != null)
    {
      localc.dispose();
      this.payloadUploadDisposable = null;
    }
    this.feedbackQueue.clear();
  }
  
  public void initSSLClient(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.host = paramString1;
    this.port = paramInt;
    this.clientType = paramString2;
    this.token = paramString3;
    if (this.payloadUploadDisposable == null) {
      this.payloadUploadDisposable = q.c0(200L, TimeUnit.MILLISECONDS).N(new b(this)).L0(io.reactivex.l0.a.c()).F0();
    }
  }
  
  public void offerFeedbackPayload(String paramString)
  {
    this.feedbackQueue.offer(paramString);
  }
  
  private static class SingletonHolder
  {
    private static final FeedbackUploadManager INSTANCE = new FeedbackUploadManager(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\FeedbackUploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
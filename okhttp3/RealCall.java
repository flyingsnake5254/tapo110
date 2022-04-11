package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

final class RealCall
  implements Call
{
  final OkHttpClient client;
  @Nullable
  private EventListener eventListener;
  private boolean executed;
  final boolean forWebSocket;
  final Request originalRequest;
  final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
  final AsyncTimeout timeout;
  
  private RealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
    this.forWebSocket = paramBoolean;
    this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(paramOkHttpClient, paramBoolean);
    paramRequest = new AsyncTimeout()
    {
      protected void timedOut()
      {
        RealCall.this.cancel();
      }
    };
    this.timeout = paramRequest;
    paramRequest.timeout(paramOkHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
  }
  
  private void captureCallStackTrace()
  {
    Object localObject = Platform.get().getStackTraceForCloseable("response.body().close()");
    this.retryAndFollowUpInterceptor.setCallStackTrace(localObject);
  }
  
  static RealCall newRealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    paramRequest = new RealCall(paramOkHttpClient, paramRequest, paramBoolean);
    paramRequest.eventListener = paramOkHttpClient.eventListenerFactory().create(paramRequest);
    return paramRequest;
  }
  
  public void cancel()
  {
    this.retryAndFollowUpInterceptor.cancel();
  }
  
  public RealCall clone()
  {
    return newRealCall(this.client, this.originalRequest, this.forWebSocket);
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      if (!this.executed)
      {
        this.executed = true;
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new AsyncCall(paramCallback));
        return;
      }
      paramCallback = new java/lang/IllegalStateException;
      paramCallback.<init>("Already Executed");
      throw paramCallback;
    }
    finally {}
  }
  
  /* Error */
  public Response execute()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 119	okhttp3/RealCall:executed	Z
    //   6: ifne +109 -> 115
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 119	okhttp3/RealCall:executed	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: invokespecial 121	okhttp3/RealCall:captureCallStackTrace	()V
    //   20: aload_0
    //   21: getfield 48	okhttp3/RealCall:timeout	Lokio/AsyncTimeout;
    //   24: invokevirtual 155	okio/AsyncTimeout:enter	()V
    //   27: aload_0
    //   28: getfield 70	okhttp3/RealCall:eventListener	Lokhttp3/EventListener;
    //   31: aload_0
    //   32: invokevirtual 127	okhttp3/EventListener:callStart	(Lokhttp3/Call;)V
    //   35: aload_0
    //   36: getfield 32	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   39: invokevirtual 131	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   42: aload_0
    //   43: invokevirtual 157	okhttp3/Dispatcher:executed	(Lokhttp3/RealCall;)V
    //   46: aload_0
    //   47: invokevirtual 160	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +16 -> 68
    //   55: aload_0
    //   56: getfield 32	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   59: invokevirtual 131	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   62: aload_0
    //   63: invokevirtual 163	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall;)V
    //   66: aload_1
    //   67: areturn
    //   68: new 150	java/io/IOException
    //   71: astore_1
    //   72: aload_1
    //   73: ldc -91
    //   75: invokespecial 166	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: goto +21 -> 102
    //   84: astore_1
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 170	okhttp3/RealCall:timeoutExit	(Ljava/io/IOException;)Ljava/io/IOException;
    //   90: astore_1
    //   91: aload_0
    //   92: getfield 70	okhttp3/RealCall:eventListener	Lokhttp3/EventListener;
    //   95: aload_0
    //   96: aload_1
    //   97: invokevirtual 174	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
    //   100: aload_1
    //   101: athrow
    //   102: aload_0
    //   103: getfield 32	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
    //   106: invokevirtual 131	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
    //   109: aload_0
    //   110: invokevirtual 163	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall;)V
    //   113: aload_1
    //   114: athrow
    //   115: new 141	java/lang/IllegalStateException
    //   118: astore_1
    //   119: aload_1
    //   120: ldc -113
    //   122: invokespecial 146	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	RealCall
    //   50	29	1	localObject1	Object
    //   80	1	1	localObject2	Object
    //   84	3	1	localIOException	IOException
    //   90	36	1	localObject3	Object
    //   127	4	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   35	51	80	finally
    //   68	80	80	finally
    //   85	102	80	finally
    //   35	51	84	java/io/IOException
    //   68	80	84	java/io/IOException
    //   2	16	127	finally
    //   115	127	127	finally
    //   128	130	127	finally
  }
  
  Response getResponseWithInterceptorChain()
    throws IOException
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.client.interceptors());
    ((List)localObject).add(this.retryAndFollowUpInterceptor);
    ((List)localObject).add(new BridgeInterceptor(this.client.cookieJar()));
    ((List)localObject).add(new CacheInterceptor(this.client.internalCache()));
    ((List)localObject).add(new ConnectInterceptor(this.client));
    if (!this.forWebSocket) {
      ((List)localObject).addAll(this.client.networkInterceptors());
    }
    ((List)localObject).add(new CallServerInterceptor(this.forWebSocket));
    localObject = new RealInterceptorChain((List)localObject, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
    if (!this.retryAndFollowUpInterceptor.isCanceled()) {
      return (Response)localObject;
    }
    Util.closeQuietly((Closeable)localObject);
    throw new IOException("Canceled");
  }
  
  public boolean isCanceled()
  {
    return this.retryAndFollowUpInterceptor.isCanceled();
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  String redactedUrl()
  {
    return this.originalRequest.url().redact();
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  StreamAllocation streamAllocation()
  {
    return this.retryAndFollowUpInterceptor.streamAllocation();
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  @Nullable
  IOException timeoutExit(@Nullable IOException paramIOException)
  {
    if (!this.timeout.exit()) {
      return paramIOException;
    }
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  String toLoggableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (isCanceled()) {
      str = "canceled ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    if (this.forWebSocket) {
      str = "web socket";
    } else {
      str = "call";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" to ");
    localStringBuilder.append(redactedUrl());
    return localStringBuilder.toString();
  }
  
  final class AsyncCall
    extends NamedRunnable
  {
    private final Callback responseCallback;
    
    AsyncCall(Callback paramCallback)
    {
      super(new Object[] { RealCall.this.redactedUrl() });
      this.responseCallback = paramCallback;
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   4: getfield 41	okhttp3/RealCall:timeout	Lokio/AsyncTimeout;
      //   7: invokevirtual 46	okio/AsyncTimeout:enter	()V
      //   10: aload_0
      //   11: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   14: invokevirtual 50	okhttp3/RealCall:getResponseWithInterceptorChain	()Lokhttp3/Response;
      //   17: astore_1
      //   18: iconst_1
      //   19: istore_2
      //   20: iconst_1
      //   21: istore_3
      //   22: aload_0
      //   23: getfield 34	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   26: aload_0
      //   27: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   30: aload_1
      //   31: invokeinterface 56 3 0
      //   36: aload_0
      //   37: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   40: getfield 60	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   43: invokevirtual 66	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   46: aload_0
      //   47: invokevirtual 72	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   50: goto +182 -> 232
      //   53: astore_1
      //   54: goto +12 -> 66
      //   57: astore_1
      //   58: iload_2
      //   59: istore_3
      //   60: goto +77 -> 137
      //   63: astore_1
      //   64: iconst_0
      //   65: istore_3
      //   66: aload_0
      //   67: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   70: invokevirtual 75	okhttp3/RealCall:cancel	()V
      //   73: iload_3
      //   74: ifne +58 -> 132
      //   77: new 37	java/io/IOException
      //   80: astore 4
      //   82: new 77	java/lang/StringBuilder
      //   85: astore 5
      //   87: aload 5
      //   89: invokespecial 79	java/lang/StringBuilder:<init>	()V
      //   92: aload 5
      //   94: ldc 81
      //   96: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: pop
      //   100: aload 5
      //   102: aload_1
      //   103: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   106: pop
      //   107: aload 4
      //   109: aload 5
      //   111: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   114: invokespecial 94	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   117: aload_0
      //   118: getfield 34	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   121: aload_0
      //   122: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   125: aload 4
      //   127: invokeinterface 98 3 0
      //   132: aload_1
      //   133: athrow
      //   134: astore_1
      //   135: iconst_0
      //   136: istore_3
      //   137: aload_0
      //   138: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   141: aload_1
      //   142: invokevirtual 102	okhttp3/RealCall:timeoutExit	(Ljava/io/IOException;)Ljava/io/IOException;
      //   145: astore 5
      //   147: iload_3
      //   148: ifeq +50 -> 198
      //   151: invokestatic 108	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
      //   154: astore 4
      //   156: new 77	java/lang/StringBuilder
      //   159: astore_1
      //   160: aload_1
      //   161: invokespecial 79	java/lang/StringBuilder:<init>	()V
      //   164: aload_1
      //   165: ldc 110
      //   167: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: pop
      //   171: aload_1
      //   172: aload_0
      //   173: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   176: invokevirtual 113	okhttp3/RealCall:toLoggableString	()Ljava/lang/String;
      //   179: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   182: pop
      //   183: aload 4
      //   185: iconst_4
      //   186: aload_1
      //   187: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   190: aload 5
      //   192: invokevirtual 117	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   195: goto -159 -> 36
      //   198: aload_0
      //   199: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   202: invokestatic 121	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
      //   205: aload_0
      //   206: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   209: aload 5
      //   211: invokevirtual 126	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
      //   214: aload_0
      //   215: getfield 34	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   218: aload_0
      //   219: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   222: aload 5
      //   224: invokeinterface 98 3 0
      //   229: goto -193 -> 36
      //   232: return
      //   233: astore_1
      //   234: aload_0
      //   235: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   238: getfield 60	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   241: invokevirtual 66	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   244: aload_0
      //   245: invokevirtual 72	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   248: aload_1
      //   249: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	250	0	this	AsyncCall
      //   17	14	1	localResponse	Response
      //   53	1	1	localObject1	Object
      //   57	1	1	localIOException1	IOException
      //   63	70	1	localObject2	Object
      //   134	8	1	localIOException2	IOException
      //   159	28	1	localStringBuilder	StringBuilder
      //   233	16	1	localObject3	Object
      //   19	40	2	i	int
      //   21	127	3	j	int
      //   80	104	4	localObject4	Object
      //   85	138	5	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   22	36	53	finally
      //   22	36	57	java/io/IOException
      //   10	18	63	finally
      //   10	18	134	java/io/IOException
      //   66	73	233	finally
      //   77	132	233	finally
      //   132	134	233	finally
      //   137	147	233	finally
      //   151	195	233	finally
      //   198	229	233	finally
    }
    
    /* Error */
    void executeOn(java.util.concurrent.ExecutorService paramExecutorService)
    {
      // Byte code:
      //   0: aload_1
      //   1: aload_0
      //   2: invokeinterface 135 2 0
      //   7: goto +67 -> 74
      //   10: astore_1
      //   11: goto +64 -> 75
      //   14: astore_2
      //   15: new 137	java/io/InterruptedIOException
      //   18: astore_1
      //   19: aload_1
      //   20: ldc -117
      //   22: invokespecial 140	java/io/InterruptedIOException:<init>	(Ljava/lang/String;)V
      //   25: aload_1
      //   26: aload_2
      //   27: invokevirtual 144	java/io/InterruptedIOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
      //   30: pop
      //   31: aload_0
      //   32: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   35: invokestatic 121	okhttp3/RealCall:access$000	(Lokhttp3/RealCall;)Lokhttp3/EventListener;
      //   38: aload_0
      //   39: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   42: aload_1
      //   43: invokevirtual 126	okhttp3/EventListener:callFailed	(Lokhttp3/Call;Ljava/io/IOException;)V
      //   46: aload_0
      //   47: getfield 34	okhttp3/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   50: aload_0
      //   51: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   54: aload_1
      //   55: invokeinterface 98 3 0
      //   60: aload_0
      //   61: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   64: getfield 60	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   67: invokevirtual 66	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   70: aload_0
      //   71: invokevirtual 72	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   74: return
      //   75: aload_0
      //   76: getfield 21	okhttp3/RealCall$AsyncCall:this$0	Lokhttp3/RealCall;
      //   79: getfield 60	okhttp3/RealCall:client	Lokhttp3/OkHttpClient;
      //   82: invokevirtual 66	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   85: aload_0
      //   86: invokevirtual 72	okhttp3/Dispatcher:finished	(Lokhttp3/RealCall$AsyncCall;)V
      //   89: aload_1
      //   90: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	AsyncCall
      //   0	91	1	paramExecutorService	java.util.concurrent.ExecutorService
      //   14	13	2	localRejectedExecutionException	java.util.concurrent.RejectedExecutionException
      // Exception table:
      //   from	to	target	type
      //   0	7	10	finally
      //   15	60	10	finally
      //   0	7	14	java/util/concurrent/RejectedExecutionException
    }
    
    RealCall get()
    {
      return RealCall.this;
    }
    
    String host()
    {
      return RealCall.this.originalRequest.url().host();
    }
    
    Request request()
    {
      return RealCall.this.originalRequest;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\RealCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
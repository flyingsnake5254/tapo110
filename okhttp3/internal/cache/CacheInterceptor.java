package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class CacheInterceptor
  implements Interceptor
{
  final InternalCache cache;
  
  public CacheInterceptor(InternalCache paramInternalCache)
  {
    this.cache = paramInternalCache;
  }
  
  private Response cacheWritingResponse(final CacheRequest paramCacheRequest, Response paramResponse)
    throws IOException
  {
    if (paramCacheRequest == null) {
      return paramResponse;
    }
    Object localObject = paramCacheRequest.body();
    if (localObject == null) {
      return paramResponse;
    }
    paramCacheRequest = new Source()
    {
      boolean cacheRequestClosed;
      
      public void close()
        throws IOException
      {
        if ((!this.cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.cacheRequestClosed = true;
          paramCacheRequest.abort();
        }
        this.val$source.close();
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        try
        {
          paramAnonymousLong = this.val$source.read(paramAnonymousBuffer, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.cacheRequestClosed)
            {
              this.cacheRequestClosed = true;
              this.val$cacheBody.close();
            }
            return -1L;
          }
          paramAnonymousBuffer.copyTo(this.val$cacheBody.buffer(), paramAnonymousBuffer.size() - paramAnonymousLong, paramAnonymousLong);
          this.val$cacheBody.emitCompleteSegments();
          return paramAnonymousLong;
        }
        catch (IOException paramAnonymousBuffer)
        {
          if (!this.cacheRequestClosed)
          {
            this.cacheRequestClosed = true;
            paramCacheRequest.abort();
          }
          throw paramAnonymousBuffer;
        }
      }
      
      public Timeout timeout()
      {
        return this.val$source.timeout();
      }
    };
    localObject = paramResponse.header("Content-Type");
    long l = paramResponse.body().contentLength();
    return paramResponse.newBuilder().body(new RealResponseBody((String)localObject, l, Okio.buffer(paramCacheRequest))).build();
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int i = paramHeaders1.size();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      String str1 = paramHeaders1.name(k);
      String str2 = paramHeaders1.value(k);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((isContentSpecificHeader(str1)) || (!isEndToEnd(str1)) || (paramHeaders2.get(str1) == null))) {
        Internal.instance.addLenient(localBuilder, str1, str2);
      }
    }
    i = paramHeaders2.size();
    for (k = j; k < i; k++)
    {
      paramHeaders1 = paramHeaders2.name(k);
      if ((!isContentSpecificHeader(paramHeaders1)) && (isEndToEnd(paramHeaders1))) {
        Internal.instance.addLenient(localBuilder, paramHeaders1, paramHeaders2.value(k));
      }
    }
    return localBuilder.build();
  }
  
  static boolean isContentSpecificHeader(String paramString)
  {
    boolean bool;
    if ((!"Content-Length".equalsIgnoreCase(paramString)) && (!"Content-Encoding".equalsIgnoreCase(paramString)) && (!"Content-Type".equalsIgnoreCase(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  static boolean isEndToEnd(String paramString)
  {
    boolean bool;
    if ((!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static Response stripBody(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.body() != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
    }
    return localResponse;
  }
  
  /* Error */
  public Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +19 -> 25
    //   9: aload_2
    //   10: aload_1
    //   11: invokeinterface 163 1 0
    //   16: invokeinterface 168 2 0
    //   21: astore_2
    //   22: goto +5 -> 27
    //   25: aconst_null
    //   26: astore_2
    //   27: new 170	okhttp3/internal/cache/CacheStrategy$Factory
    //   30: dup
    //   31: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   34: aload_1
    //   35: invokeinterface 163 1 0
    //   40: aload_2
    //   41: invokespecial 178	okhttp3/internal/cache/CacheStrategy$Factory:<init>	(JLokhttp3/Request;Lokhttp3/Response;)V
    //   44: invokevirtual 181	okhttp3/internal/cache/CacheStrategy$Factory:get	()Lokhttp3/internal/cache/CacheStrategy;
    //   47: astore_3
    //   48: aload_3
    //   49: getfield 187	okhttp3/internal/cache/CacheStrategy:networkRequest	Lokhttp3/Request;
    //   52: astore 4
    //   54: aload_3
    //   55: getfield 191	okhttp3/internal/cache/CacheStrategy:cacheResponse	Lokhttp3/Response;
    //   58: astore 5
    //   60: aload_0
    //   61: getfield 17	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +11 -> 79
    //   71: aload 6
    //   73: aload_3
    //   74: invokeinterface 195 2 0
    //   79: aload_2
    //   80: ifnull +15 -> 95
    //   83: aload 5
    //   85: ifnonnull +10 -> 95
    //   88: aload_2
    //   89: invokevirtual 33	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   92: invokestatic 201	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   95: aload 4
    //   97: ifnonnull +63 -> 160
    //   100: aload 5
    //   102: ifnonnull +58 -> 160
    //   105: new 72	okhttp3/Response$Builder
    //   108: dup
    //   109: invokespecial 202	okhttp3/Response$Builder:<init>	()V
    //   112: aload_1
    //   113: invokeinterface 163 1 0
    //   118: invokevirtual 205	okhttp3/Response$Builder:request	(Lokhttp3/Request;)Lokhttp3/Response$Builder;
    //   121: getstatic 211	okhttp3/Protocol:HTTP_1_1	Lokhttp3/Protocol;
    //   124: invokevirtual 215	okhttp3/Response$Builder:protocol	(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;
    //   127: sipush 504
    //   130: invokevirtual 219	okhttp3/Response$Builder:code	(I)Lokhttp3/Response$Builder;
    //   133: ldc -35
    //   135: invokevirtual 225	okhttp3/Response$Builder:message	(Ljava/lang/String;)Lokhttp3/Response$Builder;
    //   138: getstatic 229	okhttp3/internal/Util:EMPTY_RESPONSE	Lokhttp3/ResponseBody;
    //   141: invokevirtual 75	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   144: ldc2_w 230
    //   147: invokevirtual 235	okhttp3/Response$Builder:sentRequestAtMillis	(J)Lokhttp3/Response$Builder;
    //   150: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   153: invokevirtual 238	okhttp3/Response$Builder:receivedResponseAtMillis	(J)Lokhttp3/Response$Builder;
    //   156: invokevirtual 79	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   159: areturn
    //   160: aload 4
    //   162: ifnonnull +20 -> 182
    //   165: aload 5
    //   167: invokevirtual 62	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   170: aload 5
    //   172: invokestatic 240	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   175: invokevirtual 243	okhttp3/Response$Builder:cacheResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   178: invokevirtual 79	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   181: areturn
    //   182: aload_1
    //   183: aload 4
    //   185: invokeinterface 246 2 0
    //   190: astore_1
    //   191: aload_1
    //   192: ifnonnull +14 -> 206
    //   195: aload_2
    //   196: ifnull +10 -> 206
    //   199: aload_2
    //   200: invokevirtual 33	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   203: invokestatic 201	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   206: aload 5
    //   208: ifnull +104 -> 312
    //   211: aload_1
    //   212: invokevirtual 248	okhttp3/Response:code	()I
    //   215: sipush 304
    //   218: if_icmpne +86 -> 304
    //   221: aload 5
    //   223: invokevirtual 62	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   226: aload 5
    //   228: invokevirtual 251	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   231: aload_1
    //   232: invokevirtual 251	okhttp3/Response:headers	()Lokhttp3/Headers;
    //   235: invokestatic 253	okhttp3/internal/cache/CacheInterceptor:combine	(Lokhttp3/Headers;Lokhttp3/Headers;)Lokhttp3/Headers;
    //   238: invokevirtual 256	okhttp3/Response$Builder:headers	(Lokhttp3/Headers;)Lokhttp3/Response$Builder;
    //   241: aload_1
    //   242: invokevirtual 258	okhttp3/Response:sentRequestAtMillis	()J
    //   245: invokevirtual 235	okhttp3/Response$Builder:sentRequestAtMillis	(J)Lokhttp3/Response$Builder;
    //   248: aload_1
    //   249: invokevirtual 260	okhttp3/Response:receivedResponseAtMillis	()J
    //   252: invokevirtual 238	okhttp3/Response$Builder:receivedResponseAtMillis	(J)Lokhttp3/Response$Builder;
    //   255: aload 5
    //   257: invokestatic 240	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   260: invokevirtual 243	okhttp3/Response$Builder:cacheResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   263: aload_1
    //   264: invokestatic 240	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   267: invokevirtual 263	okhttp3/Response$Builder:networkResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   270: invokevirtual 79	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   273: astore_2
    //   274: aload_1
    //   275: invokevirtual 33	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   278: invokevirtual 266	okhttp3/ResponseBody:close	()V
    //   281: aload_0
    //   282: getfield 17	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   285: invokeinterface 269 1 0
    //   290: aload_0
    //   291: getfield 17	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   294: aload 5
    //   296: aload_2
    //   297: invokeinterface 273 3 0
    //   302: aload_2
    //   303: areturn
    //   304: aload 5
    //   306: invokevirtual 33	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   309: invokestatic 201	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   312: aload_1
    //   313: invokevirtual 62	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   316: aload 5
    //   318: invokestatic 240	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   321: invokevirtual 243	okhttp3/Response$Builder:cacheResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   324: aload_1
    //   325: invokestatic 240	okhttp3/internal/cache/CacheInterceptor:stripBody	(Lokhttp3/Response;)Lokhttp3/Response;
    //   328: invokevirtual 263	okhttp3/Response$Builder:networkResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   331: invokevirtual 79	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   334: astore_1
    //   335: aload_0
    //   336: getfield 17	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   339: ifnull +57 -> 396
    //   342: aload_1
    //   343: invokestatic 279	okhttp3/internal/http/HttpHeaders:hasBody	(Lokhttp3/Response;)Z
    //   346: ifeq +28 -> 374
    //   349: aload_1
    //   350: aload 4
    //   352: invokestatic 283	okhttp3/internal/cache/CacheStrategy:isCacheable	(Lokhttp3/Response;Lokhttp3/Request;)Z
    //   355: ifeq +19 -> 374
    //   358: aload_0
    //   359: aload_0
    //   360: getfield 17	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   363: aload_1
    //   364: invokeinterface 287 2 0
    //   369: aload_1
    //   370: invokespecial 289	okhttp3/internal/cache/CacheInterceptor:cacheWritingResponse	(Lokhttp3/internal/cache/CacheRequest;Lokhttp3/Response;)Lokhttp3/Response;
    //   373: areturn
    //   374: aload 4
    //   376: invokevirtual 295	okhttp3/Request:method	()Ljava/lang/String;
    //   379: invokestatic 300	okhttp3/internal/http/HttpMethod:invalidatesCache	(Ljava/lang/String;)Z
    //   382: ifeq +14 -> 396
    //   385: aload_0
    //   386: getfield 17	okhttp3/internal/cache/CacheInterceptor:cache	Lokhttp3/internal/cache/InternalCache;
    //   389: aload 4
    //   391: invokeinterface 304 2 0
    //   396: aload_1
    //   397: areturn
    //   398: astore_1
    //   399: aload_2
    //   400: ifnull +10 -> 410
    //   403: aload_2
    //   404: invokevirtual 33	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   407: invokestatic 201	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   410: aload_1
    //   411: athrow
    //   412: astore_2
    //   413: goto -17 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	CacheInterceptor
    //   0	416	1	paramChain	okhttp3.Interceptor.Chain
    //   4	400	2	localObject	Object
    //   412	1	2	localIOException	IOException
    //   47	27	3	localCacheStrategy	CacheStrategy
    //   52	338	4	localRequest	okhttp3.Request
    //   58	259	5	localResponse	Response
    //   64	8	6	localInternalCache	InternalCache
    // Exception table:
    //   from	to	target	type
    //   182	191	398	finally
    //   385	396	412	java/io/IOException
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\cache\CacheInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
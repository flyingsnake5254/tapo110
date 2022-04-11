package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache
  implements Closeable, Flushable
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new InternalCache()
  {
    public Response get(Request paramAnonymousRequest)
      throws IOException
    {
      return Cache.this.get(paramAnonymousRequest);
    }
    
    public CacheRequest put(Response paramAnonymousResponse)
      throws IOException
    {
      return Cache.this.put(paramAnonymousResponse);
    }
    
    public void remove(Request paramAnonymousRequest)
      throws IOException
    {
      Cache.this.remove(paramAnonymousRequest);
    }
    
    public void trackConditionalCacheHit()
    {
      Cache.this.trackConditionalCacheHit();
    }
    
    public void trackResponse(CacheStrategy paramAnonymousCacheStrategy)
    {
      Cache.this.trackResponse(paramAnonymousCacheStrategy);
    }
    
    public void update(Response paramAnonymousResponse1, Response paramAnonymousResponse2)
    {
      Cache.this.update(paramAnonymousResponse1, paramAnonymousResponse2);
    }
  };
  private int networkCount;
  private int requestCount;
  int writeAbortCount;
  int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(@Nullable DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor)
    {
      for (;;) {}
    }
  }
  
  public static String key(HttpUrl paramHttpUrl)
  {
    return ByteString.encodeUtf8(paramHttpUrl.toString()).md5().hex();
  }
  
  static int readInt(BufferedSource paramBufferedSource)
    throws IOException
  {
    try
    {
      long l = paramBufferedSource.readDecimalLong();
      String str = paramBufferedSource.readUtf8LineStrict();
      if ((l >= 0L) && (l <= 2147483647L) && (str.isEmpty())) {
        return (int)l;
      }
      IOException localIOException = new java/io/IOException;
      paramBufferedSource = new java/lang/StringBuilder;
      paramBufferedSource.<init>();
      paramBufferedSource.append("expected an int but was \"");
      paramBufferedSource.append(l);
      paramBufferedSource.append(str);
      paramBufferedSource.append("\"");
      localIOException.<init>(paramBufferedSource.toString());
      throw localIOException;
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
  }
  
  public void close()
    throws IOException
  {
    this.cache.close();
  }
  
  public void delete()
    throws IOException
  {
    this.cache.delete();
  }
  
  public File directory()
  {
    return this.cache.getDirectory();
  }
  
  public void evictAll()
    throws IOException
  {
    this.cache.evictAll();
  }
  
  public void flush()
    throws IOException
  {
    this.cache.flush();
  }
  
  @Nullable
  Response get(Request paramRequest)
  {
    Object localObject = key(paramRequest.url());
    try
    {
      localObject = this.cache.get((String)localObject);
      if (localObject == null) {
        return null;
      }
      try
      {
        Entry localEntry = new Entry(((DiskLruCache.Snapshot)localObject).getSource(0));
        localObject = localEntry.response((DiskLruCache.Snapshot)localObject);
        if (!localEntry.matches(paramRequest, (Response)localObject))
        {
          Util.closeQuietly(((Response)localObject).body());
          return null;
        }
        return (Response)localObject;
      }
      catch (IOException paramRequest)
      {
        Util.closeQuietly((Closeable)localObject);
      }
    }
    catch (IOException paramRequest)
    {
      for (;;) {}
    }
    return null;
  }
  
  public int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void initialize()
    throws IOException
  {
    this.cache.initialize();
  }
  
  public boolean isClosed()
  {
    return this.cache.isClosed();
  }
  
  public long maxSize()
  {
    return this.cache.getMaxSize();
  }
  
  public int networkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  CacheRequest put(Response paramResponse)
  {
    Object localObject = paramResponse.request().method();
    if (HttpMethod.invalidatesCache(paramResponse.request().method())) {}
    try
    {
      remove(paramResponse.request());
      return null;
      if (!((String)localObject).equals("GET")) {
        return null;
      }
      if (HttpHeaders.hasVaryAll(paramResponse)) {
        return null;
      }
      localObject = new Entry(paramResponse);
      try
      {
        paramResponse = this.cache.edit(key(paramResponse.request().url()));
        if (paramResponse == null) {
          return null;
        }
        abortQuietly(paramResponse);
      }
      catch (IOException paramResponse)
      {
        try
        {
          ((Entry)localObject).writeTo(paramResponse);
          localObject = new CacheRequestImpl(paramResponse);
          return (CacheRequest)localObject;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
        paramResponse = paramResponse;
        paramResponse = null;
      }
      return null;
    }
    catch (IOException paramResponse)
    {
      for (;;) {}
    }
  }
  
  void remove(Request paramRequest)
    throws IOException
  {
    this.cache.remove(key(paramRequest.url()));
  }
  
  public int requestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long size()
    throws IOException
  {
    return this.cache.size();
  }
  
  void trackConditionalCacheHit()
  {
    try
    {
      this.hitCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void trackResponse(CacheStrategy paramCacheStrategy)
  {
    try
    {
      this.requestCount += 1;
      if (paramCacheStrategy.networkRequest != null) {
        this.networkCount += 1;
      } else if (paramCacheStrategy.cacheResponse != null) {
        this.hitCount += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  void update(Response paramResponse1, Response paramResponse2)
  {
    // Byte code:
    //   0: new 24	okhttp3/Cache$Entry
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 255	okhttp3/Cache$Entry:<init>	(Lokhttp3/Response;)V
    //   8: astore_2
    //   9: aload_1
    //   10: invokevirtual 199	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   13: checkcast 19	okhttp3/Cache$CacheResponseBody
    //   16: getfield 293	okhttp3/Cache$CacheResponseBody:snapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 296	okhttp3/internal/cache/DiskLruCache$Snapshot:edit	()Lokhttp3/internal/cache/DiskLruCache$Editor;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +23 -> 49
    //   29: aload_2
    //   30: aload_1
    //   31: invokevirtual 262	okhttp3/Cache$Entry:writeTo	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   34: aload_1
    //   35: invokevirtual 299	okhttp3/internal/cache/DiskLruCache$Editor:commit	()V
    //   38: goto +11 -> 49
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_0
    //   45: aload_1
    //   46: invokespecial 267	okhttp3/Cache:abortQuietly	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   49: return
    //   50: astore_2
    //   51: goto -7 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	Cache
    //   0	54	1	paramResponse1	Response
    //   0	54	2	paramResponse2	Response
    // Exception table:
    //   from	to	target	type
    //   20	25	41	java/io/IOException
    //   29	38	50	java/io/IOException
  }
  
  public Iterator<String> urls()
    throws IOException
  {
    new Iterator()
    {
      boolean canRemove;
      final Iterator<DiskLruCache.Snapshot> delegate = Cache.this.cache.snapshots();
      @Nullable
      String nextUrl;
      
      /* Error */
      public boolean hasNext()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 48	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
        //   4: ifnull +5 -> 9
        //   7: iconst_1
        //   8: ireturn
        //   9: aload_0
        //   10: iconst_0
        //   11: putfield 50	okhttp3/Cache$2:canRemove	Z
        //   14: aload_0
        //   15: getfield 42	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
        //   18: invokeinterface 52 1 0
        //   23: ifeq +54 -> 77
        //   26: aload_0
        //   27: getfield 42	okhttp3/Cache$2:delegate	Ljava/util/Iterator;
        //   30: invokeinterface 56 1 0
        //   35: checkcast 58	okhttp3/internal/cache/DiskLruCache$Snapshot
        //   38: astore_1
        //   39: aload_0
        //   40: aload_1
        //   41: iconst_0
        //   42: invokevirtual 62	okhttp3/internal/cache/DiskLruCache$Snapshot:getSource	(I)Lokio/Source;
        //   45: invokestatic 68	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
        //   48: invokeinterface 74 1 0
        //   53: putfield 48	okhttp3/Cache$2:nextUrl	Ljava/lang/String;
        //   56: aload_1
        //   57: invokevirtual 77	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   60: iconst_1
        //   61: ireturn
        //   62: astore_2
        //   63: aload_1
        //   64: invokevirtual 77	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   67: aload_2
        //   68: athrow
        //   69: astore_2
        //   70: aload_1
        //   71: invokevirtual 77	okhttp3/internal/cache/DiskLruCache$Snapshot:close	()V
        //   74: goto -60 -> 14
        //   77: iconst_0
        //   78: ireturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	2
        //   38	33	1	localSnapshot	DiskLruCache.Snapshot
        //   62	6	2	localObject	Object
        //   69	1	2	localIOException	IOException
        // Exception table:
        //   from	to	target	type
        //   39	56	62	finally
        //   39	56	69	java/io/IOException
      }
      
      public String next()
      {
        if (hasNext())
        {
          String str = this.nextUrl;
          this.nextUrl = null;
          this.canRemove = true;
          return str;
        }
        throw new NoSuchElementException();
      }
      
      public void remove()
      {
        if (this.canRemove)
        {
          this.delegate.remove();
          return;
        }
        throw new IllegalStateException("remove() before next()");
      }
    };
  }
  
  public int writeAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int writeSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final class CacheRequestImpl
    implements CacheRequest
  {
    private Sink body;
    private Sink cacheOut;
    boolean done;
    private final DiskLruCache.Editor editor;
    
    CacheRequestImpl(final DiskLruCache.Editor paramEditor)
    {
      this.editor = paramEditor;
      Sink localSink = paramEditor.newSink(1);
      this.cacheOut = localSink;
      this.body = new ForwardingSink(localSink)
      {
        public void close()
          throws IOException
        {
          synchronized (Cache.this)
          {
            Object localObject1 = Cache.CacheRequestImpl.this;
            if (((Cache.CacheRequestImpl)localObject1).done) {
              return;
            }
            ((Cache.CacheRequestImpl)localObject1).done = true;
            localObject1 = ((Cache.CacheRequestImpl)localObject1).this$0;
            ((Cache)localObject1).writeSuccessCount += 1;
            super.close();
            paramEditor.commit();
            return;
          }
        }
      };
    }
    
    public void abort()
    {
      synchronized (Cache.this)
      {
        if (this.done) {
          return;
        }
        this.done = true;
        Cache localCache2 = Cache.this;
        localCache2.writeAbortCount += 1;
        Util.closeQuietly(this.cacheOut);
      }
      try
      {
        this.editor.abort();
        return;
        localObject = finally;
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    public Sink body()
    {
      return this.body;
    }
  }
  
  private static class CacheResponseBody
    extends ResponseBody
  {
    private final BufferedSource bodySource;
    @Nullable
    private final String contentLength;
    @Nullable
    private final String contentType;
    final DiskLruCache.Snapshot snapshot;
    
    CacheResponseBody(final DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      this.snapshot = paramSnapshot;
      this.contentType = paramString1;
      this.contentLength = paramString2;
      this.bodySource = Okio.buffer(new ForwardingSource(paramSnapshot.getSource(1))
      {
        public void close()
          throws IOException
        {
          paramSnapshot.close();
          super.close();
        }
      });
    }
    
    public long contentLength()
    {
      l1 = -1L;
      try
      {
        String str = this.contentLength;
        l2 = l1;
        if (str != null) {
          l2 = Long.parseLong(str);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          long l2 = l1;
        }
      }
      return l2;
    }
    
    public MediaType contentType()
    {
      Object localObject = this.contentType;
      if (localObject != null) {
        localObject = MediaType.parse((String)localObject);
      } else {
        localObject = null;
      }
      return (MediaType)localObject;
    }
    
    public BufferedSource source()
    {
      return this.bodySource;
    }
  }
  
  private static final class Entry
  {
    private static final String RECEIVED_MILLIS;
    private static final String SENT_MILLIS;
    private final int code;
    @Nullable
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final long receivedResponseMillis;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final long sentRequestMillis;
    private final String url;
    private final Headers varyHeaders;
    
    static
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Platform.get().getPrefix());
      localStringBuilder.append("-Sent-Millis");
      SENT_MILLIS = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Platform.get().getPrefix());
      localStringBuilder.append("-Received-Millis");
      RECEIVED_MILLIS = localStringBuilder.toString();
    }
    
    Entry(Response paramResponse)
    {
      this.url = paramResponse.request().url().toString();
      this.varyHeaders = HttpHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
      this.sentRequestMillis = paramResponse.sentRequestAtMillis();
      this.receivedResponseMillis = paramResponse.receivedResponseAtMillis();
    }
    
    Entry(Source paramSource)
      throws IOException
    {
      try
      {
        Object localObject1 = Okio.buffer(paramSource);
        this.url = ((BufferedSource)localObject1).readUtf8LineStrict();
        this.requestMethod = ((BufferedSource)localObject1).readUtf8LineStrict();
        Object localObject3 = new okhttp3/Headers$Builder;
        ((Headers.Builder)localObject3).<init>();
        int i = Cache.readInt((BufferedSource)localObject1);
        int j = 0;
        for (int k = 0; k < i; k++) {
          ((Headers.Builder)localObject3).addLenient(((BufferedSource)localObject1).readUtf8LineStrict());
        }
        this.varyHeaders = ((Headers.Builder)localObject3).build();
        localObject3 = StatusLine.parse(((BufferedSource)localObject1).readUtf8LineStrict());
        this.protocol = ((StatusLine)localObject3).protocol;
        this.code = ((StatusLine)localObject3).code;
        this.message = ((StatusLine)localObject3).message;
        Headers.Builder localBuilder = new okhttp3/Headers$Builder;
        localBuilder.<init>();
        i = Cache.readInt((BufferedSource)localObject1);
        for (k = j; k < i; k++) {
          localBuilder.addLenient(((BufferedSource)localObject1).readUtf8LineStrict());
        }
        Object localObject4 = SENT_MILLIS;
        String str = localBuilder.get((String)localObject4);
        localObject3 = RECEIVED_MILLIS;
        Object localObject5 = localBuilder.get((String)localObject3);
        localBuilder.removeAll((String)localObject4);
        localBuilder.removeAll((String)localObject3);
        long l1 = 0L;
        if (str != null) {
          l2 = Long.parseLong(str);
        } else {
          l2 = 0L;
        }
        this.sentRequestMillis = l2;
        long l2 = l1;
        if (localObject5 != null) {
          l2 = Long.parseLong((String)localObject5);
        }
        this.receivedResponseMillis = l2;
        this.responseHeaders = localBuilder.build();
        if (isHttps())
        {
          localObject3 = ((BufferedSource)localObject1).readUtf8LineStrict();
          if (((String)localObject3).length() <= 0)
          {
            localObject4 = CipherSuite.forJavaName(((BufferedSource)localObject1).readUtf8LineStrict());
            localObject5 = readCertificateList((BufferedSource)localObject1);
            localObject3 = readCertificateList((BufferedSource)localObject1);
            if (!((BufferedSource)localObject1).exhausted()) {
              localObject1 = TlsVersion.forJavaName(((BufferedSource)localObject1).readUtf8LineStrict());
            } else {
              localObject1 = TlsVersion.SSL_3_0;
            }
            this.handshake = Handshake.get((TlsVersion)localObject1, (CipherSuite)localObject4, (List)localObject5, (List)localObject3);
          }
          else
          {
            localObject1 = new java/io/IOException;
            localObject4 = new java/lang/StringBuilder;
            ((StringBuilder)localObject4).<init>();
            ((StringBuilder)localObject4).append("expected \"\" but was \"");
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("\"");
            ((IOException)localObject1).<init>(((StringBuilder)localObject4).toString());
            throw ((Throwable)localObject1);
          }
        }
        else
        {
          this.handshake = null;
        }
        return;
      }
      finally
      {
        paramSource.close();
      }
    }
    
    private boolean isHttps()
    {
      return this.url.startsWith("https://");
    }
    
    private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
      throws IOException
    {
      int i = Cache.readInt(paramBufferedSource);
      if (i == -1) {
        return Collections.emptyList();
      }
      try
      {
        CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>(i);
        for (int j = 0; j < i; j++)
        {
          String str = paramBufferedSource.readUtf8LineStrict();
          Buffer localBuffer = new okio/Buffer;
          localBuffer.<init>();
          localBuffer.write(ByteString.decodeBase64(str));
          localArrayList.add(localCertificateFactory.generateCertificate(localBuffer.inputStream()));
        }
        return localArrayList;
      }
      catch (CertificateException paramBufferedSource)
      {
        throw new IOException(paramBufferedSource.getMessage());
      }
    }
    
    private void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramBufferedSink.writeDecimalLong(paramList.size()).writeByte(10);
        int i = 0;
        int j = paramList.size();
        while (i < j)
        {
          paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64()).writeByte(10);
          i++;
        }
        return;
      }
      catch (CertificateEncodingException paramBufferedSink)
      {
        throw new IOException(paramBufferedSink.getMessage());
      }
    }
    
    public boolean matches(Request paramRequest, Response paramResponse)
    {
      boolean bool;
      if ((this.url.equals(paramRequest.url().toString())) && (this.requestMethod.equals(paramRequest.method())) && (HttpHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Response response(DiskLruCache.Snapshot paramSnapshot)
    {
      String str1 = this.responseHeaders.get("Content-Type");
      String str2 = this.responseHeaders.get("Content-Length");
      Request localRequest = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
      return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, str1, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
    }
    
    public void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      int i = 0;
      paramEditor = Okio.buffer(paramEditor.newSink(0));
      paramEditor.writeUtf8(this.url).writeByte(10);
      paramEditor.writeUtf8(this.requestMethod).writeByte(10);
      paramEditor.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
      int j = this.varyHeaders.size();
      for (int k = 0; k < j; k++) {
        paramEditor.writeUtf8(this.varyHeaders.name(k)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(k)).writeByte(10);
      }
      paramEditor.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
      paramEditor.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
      j = this.responseHeaders.size();
      for (k = i; k < j; k++) {
        paramEditor.writeUtf8(this.responseHeaders.name(k)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(k)).writeByte(10);
      }
      paramEditor.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
      paramEditor.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
      if (isHttps())
      {
        paramEditor.writeByte(10);
        paramEditor.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
        writeCertList(paramEditor, this.handshake.peerCertificates());
        writeCertList(paramEditor, this.handshake.localCertificates());
        paramEditor.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
      }
      paramEditor.close();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

final class k<T>
  implements b<T>
{
  private final p c;
  private final Object[] d;
  private final Call.Factory f;
  @GuardedBy("this")
  private boolean p0;
  private final f<ResponseBody, T> q;
  private volatile boolean x;
  @Nullable
  @GuardedBy("this")
  private Call y;
  @Nullable
  @GuardedBy("this")
  private Throwable z;
  
  k(p paramp, Object[] paramArrayOfObject, Call.Factory paramFactory, f<ResponseBody, T> paramf)
  {
    this.c = paramp;
    this.d = paramArrayOfObject;
    this.f = paramFactory;
    this.q = paramf;
  }
  
  private Call b()
    throws IOException
  {
    Call localCall = this.f.newCall(this.c.a(this.d));
    Objects.requireNonNull(localCall, "Call.Factory returned null.");
    return localCall;
  }
  
  public k<T> a()
  {
    return new k(this.c, this.d, this.f, this.q);
  }
  
  q<T> c(Response paramResponse)
    throws IOException
  {
    Object localObject = paramResponse.body();
    Response localResponse = paramResponse.newBuilder().body(new c(((ResponseBody)localObject).contentType(), ((ResponseBody)localObject).contentLength())).build();
    int i = localResponse.code();
    if ((i >= 200) && (i < 300))
    {
      if ((i != 204) && (i != 205))
      {
        paramResponse = new b((ResponseBody)localObject);
        try
        {
          localObject = q.g(this.q.convert(paramResponse), localResponse);
          return (q<T>)localObject;
        }
        catch (RuntimeException localRuntimeException)
        {
          paramResponse.a();
          throw localRuntimeException;
        }
      }
      localRuntimeException.close();
      return q.g(null, localResponse);
    }
    try
    {
      paramResponse = q.c(v.a(localRuntimeException), localResponse);
      return paramResponse;
    }
    finally
    {
      localRuntimeException.close();
    }
  }
  
  public void cancel()
  {
    this.x = true;
    try
    {
      Call localCall = this.y;
      if (localCall != null) {
        localCall.cancel();
      }
      return;
    }
    finally {}
  }
  
  public q<T> execute()
    throws IOException
  {
    try
    {
      if (!this.p0)
      {
        this.p0 = true;
        Object localObject1 = this.z;
        if (localObject1 != null)
        {
          if (!(localObject1 instanceof IOException))
          {
            if ((localObject1 instanceof RuntimeException)) {
              throw ((RuntimeException)localObject1);
            }
            throw ((Error)localObject1);
          }
          throw ((IOException)localObject1);
        }
        Call localCall = this.y;
        localObject1 = localCall;
        if (localCall == null)
        {
          try
          {
            localObject1 = b();
            this.y = ((Call)localObject1);
          }
          catch (Error localError) {}catch (RuntimeException localRuntimeException) {}catch (IOException localIOException) {}
          v.t(localIOException);
          this.z = localIOException;
          throw localIOException;
        }
        if (this.x) {
          localIOException.cancel();
        }
        return c(localIOException.execute());
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("Already executed.");
      throw localIllegalStateException;
    }
    finally {}
  }
  
  /* Error */
  public void i(final d<T> paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -62
    //   3: invokestatic 196	retrofit2/v:b	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 170	retrofit2/k:p0	Z
    //   13: ifne +120 -> 133
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 170	retrofit2/k:p0	Z
    //   21: aload_0
    //   22: getfield 153	retrofit2/k:y	Lokhttp3/Call;
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 172	retrofit2/k:z	Ljava/lang/Throwable;
    //   30: astore_3
    //   31: aload_2
    //   32: astore 4
    //   34: aload_3
    //   35: astore 5
    //   37: aload_2
    //   38: ifnonnull +47 -> 85
    //   41: aload_2
    //   42: astore 4
    //   44: aload_3
    //   45: astore 5
    //   47: aload_3
    //   48: ifnonnull +37 -> 85
    //   51: aload_0
    //   52: invokespecial 174	retrofit2/k:b	()Lokhttp3/Call;
    //   55: astore 4
    //   57: aload_0
    //   58: aload 4
    //   60: putfield 153	retrofit2/k:y	Lokhttp3/Call;
    //   63: aload_3
    //   64: astore 5
    //   66: goto +19 -> 85
    //   69: astore 5
    //   71: aload 5
    //   73: invokestatic 178	retrofit2/v:t	(Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: aload 5
    //   79: putfield 172	retrofit2/k:z	Ljava/lang/Throwable;
    //   82: aload_2
    //   83: astore 4
    //   85: aload_0
    //   86: monitorexit
    //   87: aload 5
    //   89: ifnull +13 -> 102
    //   92: aload_1
    //   93: aload_0
    //   94: aload 5
    //   96: invokeinterface 201 3 0
    //   101: return
    //   102: aload_0
    //   103: getfield 151	retrofit2/k:x	Z
    //   106: ifeq +10 -> 116
    //   109: aload 4
    //   111: invokeinterface 157 1 0
    //   116: aload 4
    //   118: new 9	retrofit2/k$a
    //   121: dup
    //   122: aload_0
    //   123: aload_1
    //   124: invokespecial 204	retrofit2/k$a:<init>	(Lretrofit2/k;Lretrofit2/d;)V
    //   127: invokeinterface 208 2 0
    //   132: return
    //   133: new 184	java/lang/IllegalStateException
    //   136: astore_1
    //   137: aload_1
    //   138: ldc -70
    //   140: invokespecial 189	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	k
    //   0	150	1	paramd	d<T>
    //   25	58	2	localCall1	Call
    //   30	34	3	localThrowable1	Throwable
    //   32	85	4	localCall2	Call
    //   35	30	5	localThrowable2	Throwable
    //   69	26	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   51	63	69	finally
    //   9	31	145	finally
    //   71	82	145	finally
    //   85	87	145	finally
    //   133	145	145	finally
    //   146	148	145	finally
  }
  
  public boolean isCanceled()
  {
    boolean bool1 = this.x;
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    try
    {
      Call localCall = this.y;
      if ((localCall == null) || (!localCall.isCanceled())) {
        bool2 = false;
      }
      return bool2;
    }
    finally {}
  }
  
  public Request request()
  {
    try
    {
      Object localObject1 = this.y;
      if (localObject1 != null)
      {
        localObject1 = ((Call)localObject1).request();
        return (Request)localObject1;
      }
      localObject1 = this.z;
      if (localObject1 != null)
      {
        if (!(localObject1 instanceof IOException))
        {
          if ((localObject1 instanceof RuntimeException)) {
            throw ((RuntimeException)localObject1);
          }
          throw ((Error)localObject1);
        }
        localObject1 = new java/lang/RuntimeException;
        ((RuntimeException)localObject1).<init>("Unable to create request.", this.z);
        throw ((Throwable)localObject1);
      }
      try
      {
        localObject1 = b();
        this.y = ((Call)localObject1);
        localObject1 = ((Call)localObject1).request();
        return (Request)localObject1;
      }
      catch (IOException localIOException)
      {
        this.z = localIOException;
        localObject1 = new java/lang/RuntimeException;
        ((RuntimeException)localObject1).<init>("Unable to create request.", localIOException);
        throw ((Throwable)localObject1);
      }
      catch (Error localError) {}catch (RuntimeException localRuntimeException) {}
      v.t(localRuntimeException);
      this.z = localRuntimeException;
      throw localRuntimeException;
    }
    finally {}
  }
  
  class a
    implements Callback
  {
    a(d paramd) {}
    
    /* Error */
    private void a(Throwable paramThrowable)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	retrofit2/k$a:a	Lretrofit2/d;
      //   4: aload_0
      //   5: getfield 19	retrofit2/k$a:b	Lretrofit2/k;
      //   8: aload_1
      //   9: invokeinterface 31 3 0
      //   14: goto +12 -> 26
      //   17: astore_1
      //   18: aload_1
      //   19: invokestatic 36	retrofit2/v:t	(Ljava/lang/Throwable;)V
      //   22: aload_1
      //   23: invokevirtual 41	java/lang/Throwable:printStackTrace	()V
      //   26: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	27	0	this	a
      //   0	27	1	paramThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   0	14	17	finally
    }
    
    public void onFailure(Call paramCall, IOException paramIOException)
    {
      a(paramIOException);
    }
    
    /* Error */
    public void onResponse(Call paramCall, Response paramResponse)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	retrofit2/k$a:b	Lretrofit2/k;
      //   4: aload_2
      //   5: invokevirtual 51	retrofit2/k:c	(Lokhttp3/Response;)Lretrofit2/q;
      //   8: astore_1
      //   9: aload_0
      //   10: getfield 21	retrofit2/k$a:a	Lretrofit2/d;
      //   13: aload_0
      //   14: getfield 19	retrofit2/k$a:b	Lretrofit2/k;
      //   17: aload_1
      //   18: invokeinterface 54 3 0
      //   23: goto +12 -> 35
      //   26: astore_1
      //   27: aload_1
      //   28: invokestatic 36	retrofit2/v:t	(Ljava/lang/Throwable;)V
      //   31: aload_1
      //   32: invokevirtual 41	java/lang/Throwable:printStackTrace	()V
      //   35: return
      //   36: astore_1
      //   37: aload_1
      //   38: invokestatic 36	retrofit2/v:t	(Ljava/lang/Throwable;)V
      //   41: aload_0
      //   42: aload_1
      //   43: invokespecial 45	retrofit2/k$a:a	(Ljava/lang/Throwable;)V
      //   46: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	47	0	this	a
      //   0	47	1	paramCall	Call
      //   0	47	2	paramResponse	Response
      // Exception table:
      //   from	to	target	type
      //   9	23	26	finally
      //   0	9	36	finally
    }
  }
  
  static final class b
    extends ResponseBody
  {
    private final ResponseBody c;
    private final BufferedSource d;
    @Nullable
    IOException f;
    
    b(ResponseBody paramResponseBody)
    {
      this.c = paramResponseBody;
      this.d = Okio.buffer(new a(paramResponseBody.source()));
    }
    
    void a()
      throws IOException
    {
      IOException localIOException = this.f;
      if (localIOException == null) {
        return;
      }
      throw localIOException;
    }
    
    public void close()
    {
      this.c.close();
    }
    
    public long contentLength()
    {
      return this.c.contentLength();
    }
    
    public MediaType contentType()
    {
      return this.c.contentType();
    }
    
    public BufferedSource source()
    {
      return this.d;
    }
    
    class a
      extends ForwardingSource
    {
      a(Source paramSource)
      {
        super();
      }
      
      public long read(Buffer paramBuffer, long paramLong)
        throws IOException
      {
        try
        {
          paramLong = super.read(paramBuffer, paramLong);
          return paramLong;
        }
        catch (IOException paramBuffer)
        {
          k.b.this.f = paramBuffer;
          throw paramBuffer;
        }
      }
    }
  }
  
  static final class c
    extends ResponseBody
  {
    @Nullable
    private final MediaType c;
    private final long d;
    
    c(@Nullable MediaType paramMediaType, long paramLong)
    {
      this.c = paramMediaType;
      this.d = paramLong;
    }
    
    public long contentLength()
    {
      return this.d;
    }
    
    public MediaType contentType()
    {
      return this.c;
    }
    
    public BufferedSource source()
    {
      throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
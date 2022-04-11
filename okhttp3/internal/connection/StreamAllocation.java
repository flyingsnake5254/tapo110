package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class StreamAllocation
{
  public final Address address;
  public final Call call;
  private final Object callStackTrace;
  private boolean canceled;
  private HttpCodec codec;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  public final EventListener eventListener;
  private int refusedStreamCount;
  private boolean released;
  private boolean reportedAcquired;
  private Route route;
  private RouteSelector.Selection routeSelection;
  private final RouteSelector routeSelector;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress, Call paramCall, EventListener paramEventListener, Object paramObject)
  {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    this.routeSelector = new RouteSelector(paramAddress, routeDatabase(), paramCall, paramEventListener);
    this.callStackTrace = paramObject;
  }
  
  private Socket deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = null;
    if (paramBoolean3) {
      this.codec = null;
    }
    if (paramBoolean2) {
      this.released = true;
    }
    RealConnection localRealConnection = this.connection;
    Object localObject2 = localObject1;
    if (localRealConnection != null)
    {
      if (paramBoolean1) {
        localRealConnection.noNewStreams = true;
      }
      localObject2 = localObject1;
      if (this.codec == null) {
        if (!this.released)
        {
          localObject2 = localObject1;
          if (!localRealConnection.noNewStreams) {}
        }
        else
        {
          release(localRealConnection);
          if (this.connection.allocations.isEmpty())
          {
            this.connection.idleAtNanos = System.nanoTime();
            if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection))
            {
              localObject2 = this.connection.socket();
              break label139;
            }
          }
          localObject2 = null;
          label139:
          this.connection = null;
        }
      }
    }
    return (Socket)localObject2;
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    throws IOException
  {
    synchronized (this.connectionPool)
    {
      if (!this.released)
      {
        if (this.codec == null)
        {
          if (!this.canceled)
          {
            Object localObject1 = this.connection;
            Object localObject6 = releaseIfNoNewStreams();
            Object localObject7 = this.connection;
            Object localObject8 = null;
            if (localObject7 != null) {
              localObject1 = null;
            } else {
              localObject7 = null;
            }
            Object localObject9 = localObject1;
            if (!this.reportedAcquired) {
              localObject9 = null;
            }
            if (localObject7 == null)
            {
              Internal.instance.get(this.connectionPool, this.address, this, null);
              localObject1 = this.connection;
              if (localObject1 != null)
              {
                localObject7 = localObject1;
                i = 1;
                localObject1 = null;
                break label140;
              }
              localObject1 = this.route;
            }
            else
            {
              localObject1 = null;
            }
            int i = 0;
            label140:
            Util.closeQuietly((Socket)localObject6);
            if (localObject9 != null) {
              this.eventListener.connectionReleased(this.call, (Connection)localObject9);
            }
            if (i != 0) {
              this.eventListener.connectionAcquired(this.call, (Connection)localObject7);
            }
            if (localObject7 != null)
            {
              this.route = this.connection.route();
              return (RealConnection)localObject7;
            }
            if (localObject1 == null)
            {
              localObject9 = this.routeSelection;
              if ((localObject9 == null) || (!((RouteSelector.Selection)localObject9).hasNext()))
              {
                this.routeSelection = this.routeSelector.next();
                j = 1;
                break label247;
              }
            }
            int j = 0;
            label247:
            synchronized (this.connectionPool)
            {
              if (!this.canceled)
              {
                localObject9 = localObject7;
                int k = i;
                if (j != 0)
                {
                  localObject6 = this.routeSelection.getAll();
                  int m = ((List)localObject6).size();
                  for (j = 0;; j++)
                  {
                    localObject9 = localObject7;
                    k = i;
                    if (j >= m) {
                      break;
                    }
                    Route localRoute = (Route)((List)localObject6).get(j);
                    Internal.instance.get(this.connectionPool, this.address, this, localRoute);
                    localObject9 = this.connection;
                    if (localObject9 != null)
                    {
                      this.route = localRoute;
                      k = 1;
                      break;
                    }
                  }
                }
                localObject7 = localObject9;
                if (k == 0)
                {
                  localObject7 = localObject1;
                  if (localObject1 == null) {
                    localObject7 = this.routeSelection.next();
                  }
                  this.route = ((Route)localObject7);
                  this.refusedStreamCount = 0;
                  localObject1 = new okhttp3/internal/connection/RealConnection;
                  ((RealConnection)localObject1).<init>(this.connectionPool, (Route)localObject7);
                  acquire((RealConnection)localObject1, false);
                  localObject7 = localObject1;
                }
                if (k != 0)
                {
                  this.eventListener.connectionAcquired(this.call, (Connection)localObject7);
                  return (RealConnection)localObject7;
                }
                ((RealConnection)localObject7).connect(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.call, this.eventListener);
                routeDatabase().connected(((RealConnection)localObject7).route());
                synchronized (this.connectionPool)
                {
                  this.reportedAcquired = true;
                  Internal.instance.put(this.connectionPool, (RealConnection)localObject7);
                  localObject1 = localObject7;
                  localObject9 = localObject8;
                  if (((RealConnection)localObject7).isMultiplexed())
                  {
                    localObject9 = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                    localObject1 = this.connection;
                  }
                  Util.closeQuietly((Socket)localObject9);
                  this.eventListener.connectionAcquired(this.call, (Connection)localObject1);
                  return (RealConnection)localObject1;
                }
              }
              IOException localIOException = new java/io/IOException;
              localIOException.<init>("Canceled");
              throw localIOException;
            }
          }
          localObject4 = new java/io/IOException;
          ((IOException)localObject4).<init>("Canceled");
          throw ((Throwable)localObject4);
        }
        localObject4 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject4).<init>("codec != null");
        throw ((Throwable)localObject4);
      }
      Object localObject4 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject4).<init>("released");
      throw ((Throwable)localObject4);
    }
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    for (;;)
    {
      RealConnection localRealConnection = findConnection(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.connectionPool)
      {
        if ((localRealConnection.successCount == 0) && (!localRealConnection.isMultiplexed())) {
          return localRealConnection;
        }
        if (!localRealConnection.isHealthy(paramBoolean2))
        {
          noNewStreams();
          continue;
        }
        return localRealConnection;
      }
    }
  }
  
  private void release(RealConnection paramRealConnection)
  {
    int i = paramRealConnection.allocations.size();
    for (int j = 0; j < i; j++) {
      if (((Reference)paramRealConnection.allocations.get(j)).get() == this)
      {
        paramRealConnection.allocations.remove(j);
        return;
      }
    }
    throw new IllegalStateException();
  }
  
  private Socket releaseIfNoNewStreams()
  {
    RealConnection localRealConnection = this.connection;
    if ((localRealConnection != null) && (localRealConnection.noNewStreams)) {
      return deallocate(false, false, true);
    }
    return null;
  }
  
  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(this.connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection, boolean paramBoolean)
  {
    if (this.connection == null)
    {
      this.connection = paramRealConnection;
      this.reportedAcquired = paramBoolean;
      paramRealConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
      return;
    }
    throw new IllegalStateException();
  }
  
  public void cancel()
  {
    synchronized (this.connectionPool)
    {
      this.canceled = true;
      HttpCodec localHttpCodec = this.codec;
      RealConnection localRealConnection = this.connection;
      if (localHttpCodec != null) {
        localHttpCodec.cancel();
      } else if (localRealConnection != null) {
        localRealConnection.cancel();
      }
      return;
    }
  }
  
  public HttpCodec codec()
  {
    synchronized (this.connectionPool)
    {
      HttpCodec localHttpCodec = this.codec;
      return localHttpCodec;
    }
  }
  
  public RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = this.connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean hasMoreRoutes()
  {
    if (this.route == null)
    {
      RouteSelector.Selection localSelection = this.routeSelection;
      if (((localSelection == null) || (!localSelection.hasNext())) && (!this.routeSelector.hasNext())) {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  /* Error */
  public HttpCodec newStream(okhttp3.OkHttpClient arg1, okhttp3.Interceptor.Chain paramChain, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 268 1 0
    //   6: istore 4
    //   8: aload_2
    //   9: invokeinterface 271 1 0
    //   14: istore 5
    //   16: aload_2
    //   17: invokeinterface 274 1 0
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 279	okhttp3/OkHttpClient:pingIntervalMillis	()I
    //   28: istore 7
    //   30: aload_1
    //   31: invokevirtual 282	okhttp3/OkHttpClient:retryOnConnectionFailure	()Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 284	okhttp3/internal/connection/StreamAllocation:findHealthyConnection	(IIIIZZ)Lokhttp3/internal/connection/RealConnection;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 288	okhttp3/internal/connection/RealConnection:newCodec	(Lokhttp3/OkHttpClient;Lokhttp3/Interceptor$Chain;Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/http/HttpCodec;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 44	okhttp3/internal/connection/StreamAllocation:connectionPool	Lokhttp3/ConnectionPool;
    //   62: astore_1
    //   63: aload_1
    //   64: monitorenter
    //   65: aload_0
    //   66: aload_2
    //   67: putfield 67	okhttp3/internal/connection/StreamAllocation:codec	Lokhttp3/internal/http/HttpCodec;
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload_1
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: astore_1
    //   80: new 290	okhttp3/internal/connection/RouteException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 293	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	StreamAllocation
    //   0	89	2	paramChain	okhttp3.Interceptor.Chain
    //   0	89	3	paramBoolean	boolean
    //   6	32	4	i	int
    //   14	26	5	j	int
    //   22	20	6	k	int
    //   28	16	7	m	int
    //   34	12	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	72	74	finally
    //   75	77	74	finally
    //   36	65	79	java/io/IOException
    //   77	79	79	java/io/IOException
  }
  
  public void noNewStreams()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(true, false, false);
      if (this.connection != null) {
        localRealConnection = null;
      }
      Util.closeQuietly(localSocket);
      if (localRealConnection != null) {
        this.eventListener.connectionReleased(this.call, localRealConnection);
      }
      return;
    }
  }
  
  public void release()
  {
    synchronized (this.connectionPool)
    {
      RealConnection localRealConnection = this.connection;
      Socket localSocket = deallocate(false, true, false);
      if (this.connection != null) {
        localRealConnection = null;
      }
      Util.closeQuietly(localSocket);
      if (localRealConnection != null)
      {
        Internal.instance.timeoutExit(this.call, null);
        this.eventListener.connectionReleased(this.call, localRealConnection);
        this.eventListener.callEnd(this.call);
      }
      return;
    }
  }
  
  public Socket releaseAndAcquire(RealConnection paramRealConnection)
  {
    if ((this.codec == null) && (this.connection.allocations.size() == 1))
    {
      Reference localReference = (Reference)this.connection.allocations.get(0);
      Socket localSocket = deallocate(true, false, false);
      this.connection = paramRealConnection;
      paramRealConnection.allocations.add(localReference);
      return localSocket;
    }
    throw new IllegalStateException();
  }
  
  public Route route()
  {
    return this.route;
  }
  
  public void streamFailed(IOException paramIOException)
  {
    synchronized (this.connectionPool)
    {
      boolean bool = paramIOException instanceof StreamResetException;
      Object localObject1 = null;
      if (bool)
      {
        paramIOException = ((StreamResetException)paramIOException).errorCode;
        if (paramIOException == ErrorCode.REFUSED_STREAM)
        {
          int i = this.refusedStreamCount + 1;
          this.refusedStreamCount = i;
          if (i <= 1) {
            break label148;
          }
          this.route = null;
        }
        else
        {
          if (paramIOException == ErrorCode.CANCEL) {
            break label148;
          }
          this.route = null;
        }
      }
      else
      {
        localObject2 = this.connection;
        if ((localObject2 == null) || ((((RealConnection)localObject2).isMultiplexed()) && (!(paramIOException instanceof ConnectionShutdownException)))) {
          break label148;
        }
        if (this.connection.successCount == 0)
        {
          localObject2 = this.route;
          if ((localObject2 != null) && (paramIOException != null)) {
            this.routeSelector.connectFailed((Route)localObject2, paramIOException);
          }
          this.route = null;
        }
      }
      bool = true;
      break label150;
      label148:
      bool = false;
      label150:
      Object localObject2 = this.connection;
      Socket localSocket = deallocate(bool, false, true);
      paramIOException = (IOException)localObject1;
      if (this.connection == null) {
        if (!this.reportedAcquired) {
          paramIOException = (IOException)localObject1;
        } else {
          paramIOException = (IOException)localObject2;
        }
      }
      Util.closeQuietly(localSocket);
      if (paramIOException != null) {
        this.eventListener.connectionReleased(this.call, paramIOException);
      }
      return;
    }
  }
  
  public void streamFinished(boolean paramBoolean, HttpCodec paramHttpCodec, long paramLong, IOException paramIOException)
  {
    this.eventListener.responseBodyEnd(this.call, paramLong);
    ConnectionPool localConnectionPool = this.connectionPool;
    if (paramHttpCodec != null) {}
    try
    {
      if (paramHttpCodec == this.codec)
      {
        if (!paramBoolean)
        {
          paramHttpCodec = this.connection;
          paramHttpCodec.successCount += 1;
        }
        paramHttpCodec = this.connection;
        localObject = deallocate(paramBoolean, false, true);
        if (this.connection != null) {
          paramHttpCodec = null;
        }
        paramBoolean = this.released;
        Util.closeQuietly((Socket)localObject);
        if (paramHttpCodec != null) {
          this.eventListener.connectionReleased(this.call, paramHttpCodec);
        }
        if (paramIOException != null)
        {
          paramHttpCodec = Internal.instance.timeoutExit(this.call, paramIOException);
          this.eventListener.callFailed(this.call, paramHttpCodec);
        }
        else if (paramBoolean)
        {
          Internal.instance.timeoutExit(this.call, null);
          this.eventListener.callEnd(this.call);
        }
        return;
      }
      paramIOException = new java/lang/IllegalStateException;
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("expected ");
      ((StringBuilder)localObject).append(this.codec);
      ((StringBuilder)localObject).append(" but was ");
      ((StringBuilder)localObject).append(paramHttpCodec);
      paramIOException.<init>(((StringBuilder)localObject).toString());
      throw paramIOException;
    }
    finally {}
  }
  
  public String toString()
  {
    Object localObject = connection();
    if (localObject != null) {
      localObject = ((RealConnection)localObject).toString();
    } else {
      localObject = this.address.toString();
    }
    return (String)localObject;
  }
  
  public static final class StreamAllocationReference
    extends WeakReference<StreamAllocation>
  {
    public final Object callStackTrace;
    
    StreamAllocationReference(StreamAllocation paramStreamAllocation, Object paramObject)
    {
      super();
      this.callStackTrace = paramObject;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\connection\StreamAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
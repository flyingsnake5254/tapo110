package okhttp3;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.connection.StreamAllocation.StreamAllocationReference;
import okhttp3.internal.platform.Platform;

public final class ConnectionPool
{
  private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      for (;;)
      {
        long l1 = ConnectionPool.this.cleanup(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
        long l2;
        if (l1 > 0L) {
          l2 = l1 / 1000000L;
        }
        try
        {
          synchronized (ConnectionPool.this)
          {
            ConnectionPool.this.wait(l2, (int)(l1 - 1000000L * l2));
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
      throw ((Throwable)localObject);
    }
  };
  boolean cleanupRunning;
  private final Deque<RealConnection> connections = new ArrayDeque();
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  public ConnectionPool()
  {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong > 0L) {
      return;
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("keepAliveDuration <= 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong)
  {
    List localList = paramRealConnection.allocations;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject1 = (Reference)localList.get(i);
      if (((Reference)localObject1).get() != null)
      {
        i++;
      }
      else
      {
        localObject1 = (StreamAllocation.StreamAllocationReference)localObject1;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("A connection to ");
        ((StringBuilder)localObject2).append(paramRealConnection.route().address().url());
        ((StringBuilder)localObject2).append(" was leaked. Did you forget to close a response body?");
        localObject2 = ((StringBuilder)localObject2).toString();
        Platform.get().logCloseableLeak((String)localObject2, ((StreamAllocation.StreamAllocationReference)localObject1).callStackTrace);
        localList.remove(i);
        paramRealConnection.noNewStreams = true;
        if (localList.isEmpty())
        {
          paramRealConnection.idleAtNanos = (paramLong - this.keepAliveDurationNs);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  long cleanup(long paramLong)
  {
    try
    {
      Iterator localIterator = this.connections.iterator();
      Object localObject1 = null;
      long l1 = Long.MIN_VALUE;
      int i = 0;
      int j = 0;
      while (localIterator.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator.next();
        if (pruneAndGetAllocationCount(localRealConnection, paramLong) > 0)
        {
          j++;
        }
        else
        {
          int k = i + 1;
          long l2 = paramLong - localRealConnection.idleAtNanos;
          i = k;
          if (l2 > l1)
          {
            localObject1 = localRealConnection;
            l1 = l2;
            i = k;
          }
        }
      }
      paramLong = this.keepAliveDurationNs;
      if ((l1 < paramLong) && (i <= this.maxIdleConnections))
      {
        if (i > 0) {
          return paramLong - l1;
        }
        if (j > 0) {
          return paramLong;
        }
        this.cleanupRunning = false;
        return -1L;
      }
      this.connections.remove(localObject1);
      Util.closeQuietly(((RealConnection)localObject1).socket());
      return 0L;
    }
    finally {}
  }
  
  boolean connectionBecameIdle(RealConnection paramRealConnection)
  {
    if ((!paramRealConnection.noNewStreams) && (this.maxIdleConnections != 0))
    {
      notifyAll();
      return false;
    }
    this.connections.remove(paramRealConnection);
    return true;
  }
  
  public int connectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  Socket deduplicate(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if ((localRealConnection.isEligible(paramAddress, null)) && (localRealConnection.isMultiplexed()) && (localRealConnection != paramStreamAllocation.connection())) {
        return paramStreamAllocation.releaseAndAcquire(localRealConnection);
      }
    }
    return null;
  }
  
  public void evictAll()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator.next();
        if (localRealConnection.allocations.isEmpty())
        {
          localRealConnection.noNewStreams = true;
          localArrayList.add(localRealConnection);
          localIterator.remove();
        }
      }
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        Util.closeQuietly(((RealConnection)localIterator.next()).socket());
      }
      return;
    }
    finally {}
  }
  
  @Nullable
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation, Route paramRoute)
  {
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if (localRealConnection.isEligible(paramAddress, paramRoute))
      {
        paramStreamAllocation.acquire(localRealConnection, true);
        return localRealConnection;
      }
    }
    return null;
  }
  
  public int idleConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((RealConnection)localIterator.next()).allocations.isEmpty();
        if (bool) {
          i++;
        }
      }
      return i;
    }
    finally {}
  }
  
  void put(RealConnection paramRealConnection)
  {
    if (!this.cleanupRunning)
    {
      this.cleanupRunning = true;
      executor.execute(this.cleanupRunnable);
    }
    this.connections.add(paramRealConnection);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
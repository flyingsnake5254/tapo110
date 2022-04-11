package io.netty.channel.pool;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractChannelPoolMap<K, P extends ChannelPool>
  implements ChannelPoolMap<K, P>, Iterable<Map.Entry<K, P>>, Closeable
{
  private final ConcurrentMap<K, P> map = PlatformDependent.newConcurrentHashMap();
  
  private static Future<Void> poolCloseAsyncIfSupported(ChannelPool paramChannelPool)
  {
    if ((paramChannelPool instanceof SimpleChannelPool)) {
      return ((SimpleChannelPool)paramChannelPool).closeAsync();
    }
    try
    {
      paramChannelPool.close();
      paramChannelPool = GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
      return paramChannelPool;
    }
    catch (Exception paramChannelPool) {}
    return GlobalEventExecutor.INSTANCE.newFailedFuture(paramChannelPool);
  }
  
  private Future<Boolean> removeAsyncIfSupported(final K paramK)
  {
    ChannelPool localChannelPool = (ChannelPool)this.map.remove(ObjectUtil.checkNotNull(paramK, "key"));
    if (localChannelPool != null)
    {
      paramK = GlobalEventExecutor.INSTANCE.newPromise();
      poolCloseAsyncIfSupported(localChannelPool).addListener(new GenericFutureListener()
      {
        public void operationComplete(Future<? super Void> paramAnonymousFuture)
          throws Exception
        {
          if (paramAnonymousFuture.isSuccess()) {
            paramK.setSuccess(Boolean.TRUE);
          } else {
            paramK.setFailure(paramAnonymousFuture.cause());
          }
        }
      });
      return paramK;
    }
    return GlobalEventExecutor.INSTANCE.newSucceededFuture(Boolean.FALSE);
  }
  
  public final void close()
  {
    Iterator localIterator = this.map.keySet().iterator();
    while (localIterator.hasNext()) {
      removeAsyncIfSupported(localIterator.next()).syncUninterruptibly();
    }
  }
  
  public final boolean contains(K paramK)
  {
    return this.map.containsKey(ObjectUtil.checkNotNull(paramK, "key"));
  }
  
  public final P get(K paramK)
  {
    ChannelPool localChannelPool = (ChannelPool)this.map.get(ObjectUtil.checkNotNull(paramK, "key"));
    Object localObject = localChannelPool;
    if (localChannelPool == null)
    {
      localChannelPool = newPool(paramK);
      paramK = (ChannelPool)this.map.putIfAbsent(paramK, localChannelPool);
      localObject = localChannelPool;
      if (paramK != null)
      {
        poolCloseAsyncIfSupported(localChannelPool);
        localObject = paramK;
      }
    }
    return (P)localObject;
  }
  
  public final boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  public final Iterator<Map.Entry<K, P>> iterator()
  {
    return new ReadOnlyIterator(this.map.entrySet().iterator());
  }
  
  protected abstract P newPool(K paramK);
  
  public final boolean remove(K paramK)
  {
    paramK = (ChannelPool)this.map.remove(ObjectUtil.checkNotNull(paramK, "key"));
    if (paramK != null)
    {
      poolCloseAsyncIfSupported(paramK);
      return true;
    }
    return false;
  }
  
  public final int size()
  {
    return this.map.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\pool\AbstractChannelPoolMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
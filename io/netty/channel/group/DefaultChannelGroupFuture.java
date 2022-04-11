package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.BlockingOperationException;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateEventExecutor;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class DefaultChannelGroupFuture
  extends DefaultPromise<Void>
  implements ChannelGroupFuture
{
  private final ChannelFutureListener childListener = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
      throws Exception
    {
      boolean bool = paramAnonymousChannelFuture.isSuccess();
      paramAnonymousChannelFuture = DefaultChannelGroupFuture.this;
      if (bool) {}
      try
      {
        DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
        break label37;
        DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
        label37:
        int i;
        if (DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size()) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          if (DefaultChannelGroupFuture.this.failureCount > 0)
          {
            ArrayList localArrayList = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
            Iterator localIterator = DefaultChannelGroupFuture.this.futures.values().iterator();
            while (localIterator.hasNext())
            {
              paramAnonymousChannelFuture = (ChannelFuture)localIterator.next();
              if (!paramAnonymousChannelFuture.isSuccess()) {
                localArrayList.add(new DefaultChannelGroupFuture.DefaultEntry(paramAnonymousChannelFuture.channel(), paramAnonymousChannelFuture.cause()));
              }
            }
            DefaultChannelGroupFuture.this.setFailure0(new ChannelGroupException(localArrayList));
          }
          else
          {
            DefaultChannelGroupFuture.this.setSuccess0();
          }
        }
        return;
      }
      finally {}
    }
  };
  private int failureCount;
  private final Map<Channel, ChannelFuture> futures;
  private final ChannelGroup group;
  private int successCount;
  
  DefaultChannelGroupFuture(ChannelGroup paramChannelGroup, Collection<ChannelFuture> paramCollection, EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
    this.group = ((ChannelGroup)ObjectUtil.checkNotNull(paramChannelGroup, "group"));
    ObjectUtil.checkNotNull(paramCollection, "futures");
    paramChannelGroup = new LinkedHashMap();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramEventExecutor = (ChannelFuture)paramCollection.next();
      paramChannelGroup.put(paramEventExecutor.channel(), paramEventExecutor);
    }
    paramChannelGroup = Collections.unmodifiableMap(paramChannelGroup);
    this.futures = paramChannelGroup;
    paramChannelGroup = paramChannelGroup.values().iterator();
    while (paramChannelGroup.hasNext()) {
      ((ChannelFuture)paramChannelGroup.next()).addListener(this.childListener);
    }
    if (this.futures.isEmpty()) {
      setSuccess0();
    }
  }
  
  DefaultChannelGroupFuture(ChannelGroup paramChannelGroup, Map<Channel, ChannelFuture> paramMap, EventExecutor paramEventExecutor)
  {
    super(paramEventExecutor);
    this.group = paramChannelGroup;
    paramChannelGroup = Collections.unmodifiableMap(paramMap);
    this.futures = paramChannelGroup;
    paramChannelGroup = paramChannelGroup.values().iterator();
    while (paramChannelGroup.hasNext()) {
      ((ChannelFuture)paramChannelGroup.next()).addListener(this.childListener);
    }
    if (this.futures.isEmpty()) {
      setSuccess0();
    }
  }
  
  private void setFailure0(ChannelGroupException paramChannelGroupException)
  {
    super.setFailure(paramChannelGroupException);
  }
  
  private void setSuccess0()
  {
    super.setSuccess(null);
  }
  
  public DefaultChannelGroupFuture addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.addListener(paramGenericFutureListener);
    return this;
  }
  
  public DefaultChannelGroupFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.addListeners(paramVarArgs);
    return this;
  }
  
  public DefaultChannelGroupFuture await()
    throws InterruptedException
  {
    super.await();
    return this;
  }
  
  public DefaultChannelGroupFuture awaitUninterruptibly()
  {
    super.awaitUninterruptibly();
    return this;
  }
  
  public ChannelGroupException cause()
  {
    return (ChannelGroupException)super.cause();
  }
  
  protected void checkDeadLock()
  {
    EventExecutor localEventExecutor = executor();
    if ((localEventExecutor != null) && (localEventExecutor != ImmediateEventExecutor.INSTANCE) && (localEventExecutor.inEventLoop())) {
      throw new BlockingOperationException();
    }
  }
  
  public ChannelFuture find(Channel paramChannel)
  {
    return (ChannelFuture)this.futures.get(paramChannel);
  }
  
  public ChannelGroup group()
  {
    return this.group;
  }
  
  public boolean isPartialFailure()
  {
    try
    {
      int i = this.failureCount;
      if (i != 0)
      {
        int j = this.futures.size();
        if (i != j)
        {
          bool = true;
          break label33;
        }
      }
      boolean bool = false;
      label33:
      return bool;
    }
    finally {}
  }
  
  public boolean isPartialSuccess()
  {
    try
    {
      int i = this.successCount;
      if (i != 0)
      {
        int j = this.futures.size();
        if (i != j)
        {
          bool = true;
          break label33;
        }
      }
      boolean bool = false;
      label33:
      return bool;
    }
    finally {}
  }
  
  public Iterator<ChannelFuture> iterator()
  {
    return this.futures.values().iterator();
  }
  
  public DefaultChannelGroupFuture removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener)
  {
    super.removeListener(paramGenericFutureListener);
    return this;
  }
  
  public DefaultChannelGroupFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs)
  {
    super.removeListeners(paramVarArgs);
    return this;
  }
  
  public DefaultChannelGroupFuture setFailure(Throwable paramThrowable)
  {
    throw new IllegalStateException();
  }
  
  public DefaultChannelGroupFuture setSuccess(Void paramVoid)
  {
    throw new IllegalStateException();
  }
  
  public DefaultChannelGroupFuture sync()
    throws InterruptedException
  {
    super.sync();
    return this;
  }
  
  public DefaultChannelGroupFuture syncUninterruptibly()
  {
    super.syncUninterruptibly();
    return this;
  }
  
  public boolean tryFailure(Throwable paramThrowable)
  {
    throw new IllegalStateException();
  }
  
  public boolean trySuccess(Void paramVoid)
  {
    throw new IllegalStateException();
  }
  
  private static final class DefaultEntry<K, V>
    implements Map.Entry<K, V>
  {
    private final K key;
    private final V value;
    
    DefaultEntry(K paramK, V paramV)
    {
      this.key = paramK;
      this.value = paramV;
    }
    
    public K getKey()
    {
      return (K)this.key;
    }
    
    public V getValue()
    {
      return (V)this.value;
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException("read-only");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\group\DefaultChannelGroupFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
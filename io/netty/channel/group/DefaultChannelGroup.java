package io.netty.channel.group;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.a;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultChannelGroup
  extends AbstractSet<Channel>
  implements ChannelGroup
{
  private static final AtomicInteger nextId = new AtomicInteger();
  private volatile boolean closed;
  private final EventExecutor executor;
  private final String name;
  private final ConcurrentMap<ChannelId, Channel> nonServerChannels = PlatformDependent.newConcurrentHashMap();
  private final ChannelFutureListener remover = new ChannelFutureListener()
  {
    public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
      throws Exception
    {
      DefaultChannelGroup.this.remove(paramAnonymousChannelFuture.channel());
    }
  };
  private final ConcurrentMap<ChannelId, Channel> serverChannels = PlatformDependent.newConcurrentHashMap();
  private final boolean stayClosed;
  private final VoidChannelGroupFuture voidFuture = new VoidChannelGroupFuture(this);
  
  public DefaultChannelGroup(EventExecutor paramEventExecutor)
  {
    this(paramEventExecutor, false);
  }
  
  public DefaultChannelGroup(EventExecutor paramEventExecutor, boolean paramBoolean)
  {
    this(localStringBuilder.toString(), paramEventExecutor, paramBoolean);
  }
  
  public DefaultChannelGroup(String paramString, EventExecutor paramEventExecutor)
  {
    this(paramString, paramEventExecutor, false);
  }
  
  public DefaultChannelGroup(String paramString, EventExecutor paramEventExecutor, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramString, "name");
    this.name = paramString;
    this.executor = paramEventExecutor;
    this.stayClosed = paramBoolean;
  }
  
  private static Object safeDuplicate(Object paramObject)
  {
    if ((paramObject instanceof ByteBuf)) {
      return ((ByteBuf)paramObject).retainedDuplicate();
    }
    if ((paramObject instanceof ByteBufHolder)) {
      return ((ByteBufHolder)paramObject).retainedDuplicate();
    }
    return ReferenceCountUtil.retain(paramObject);
  }
  
  public boolean add(Channel paramChannel)
  {
    ConcurrentMap localConcurrentMap;
    if ((paramChannel instanceof a)) {
      localConcurrentMap = this.serverChannels;
    } else {
      localConcurrentMap = this.nonServerChannels;
    }
    boolean bool;
    if (localConcurrentMap.putIfAbsent(paramChannel.id(), paramChannel) == null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      paramChannel.closeFuture().addListener(this.remover);
    }
    if ((this.stayClosed) && (this.closed)) {
      paramChannel.close();
    }
    return bool;
  }
  
  public void clear()
  {
    this.nonServerChannels.clear();
    this.serverChannels.clear();
  }
  
  public ChannelGroupFuture close()
  {
    return close(ChannelMatchers.all());
  }
  
  public ChannelGroupFuture close(ChannelMatcher paramChannelMatcher)
  {
    ObjectUtil.checkNotNull(paramChannelMatcher, "matcher");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(size());
    if (this.stayClosed) {
      this.closed = true;
    }
    Iterator localIterator = this.serverChannels.values().iterator();
    Channel localChannel;
    while (localIterator.hasNext())
    {
      localChannel = (Channel)localIterator.next();
      if (paramChannelMatcher.matches(localChannel)) {
        localLinkedHashMap.put(localChannel, localChannel.close());
      }
    }
    localIterator = this.nonServerChannels.values().iterator();
    while (localIterator.hasNext())
    {
      localChannel = (Channel)localIterator.next();
      if (paramChannelMatcher.matches(localChannel)) {
        localLinkedHashMap.put(localChannel, localChannel.close());
      }
    }
    return new DefaultChannelGroupFuture(this, localLinkedHashMap, this.executor);
  }
  
  public int compareTo(ChannelGroup paramChannelGroup)
  {
    int i = name().compareTo(paramChannelGroup.name());
    if (i != 0) {
      return i;
    }
    return System.identityHashCode(this) - System.identityHashCode(paramChannelGroup);
  }
  
  public boolean contains(Object paramObject)
  {
    if ((paramObject instanceof a)) {
      return this.serverChannels.containsValue(paramObject);
    }
    if ((paramObject instanceof Channel)) {
      return this.nonServerChannels.containsValue(paramObject);
    }
    return false;
  }
  
  public ChannelGroupFuture deregister()
  {
    return deregister(ChannelMatchers.all());
  }
  
  public ChannelGroupFuture deregister(ChannelMatcher paramChannelMatcher)
  {
    ObjectUtil.checkNotNull(paramChannelMatcher, "matcher");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(size());
    Iterator localIterator = this.serverChannels.values().iterator();
    Channel localChannel;
    while (localIterator.hasNext())
    {
      localChannel = (Channel)localIterator.next();
      if (paramChannelMatcher.matches(localChannel)) {
        localLinkedHashMap.put(localChannel, localChannel.deregister());
      }
    }
    localIterator = this.nonServerChannels.values().iterator();
    while (localIterator.hasNext())
    {
      localChannel = (Channel)localIterator.next();
      if (paramChannelMatcher.matches(localChannel)) {
        localLinkedHashMap.put(localChannel, localChannel.deregister());
      }
    }
    return new DefaultChannelGroupFuture(this, localLinkedHashMap, this.executor);
  }
  
  public ChannelGroupFuture disconnect()
  {
    return disconnect(ChannelMatchers.all());
  }
  
  public ChannelGroupFuture disconnect(ChannelMatcher paramChannelMatcher)
  {
    ObjectUtil.checkNotNull(paramChannelMatcher, "matcher");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(size());
    Object localObject1 = this.serverChannels.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Channel)((Iterator)localObject1).next();
      if (paramChannelMatcher.matches((Channel)localObject2)) {
        localLinkedHashMap.put(localObject2, ((ChannelOutboundInvoker)localObject2).disconnect());
      }
    }
    Object localObject2 = this.nonServerChannels.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Channel)((Iterator)localObject2).next();
      if (paramChannelMatcher.matches((Channel)localObject1)) {
        localLinkedHashMap.put(localObject1, ((ChannelOutboundInvoker)localObject1).disconnect());
      }
    }
    return new DefaultChannelGroupFuture(this, localLinkedHashMap, this.executor);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Channel find(ChannelId paramChannelId)
  {
    Channel localChannel = (Channel)this.nonServerChannels.get(paramChannelId);
    if (localChannel != null) {
      return localChannel;
    }
    return (Channel)this.serverChannels.get(paramChannelId);
  }
  
  public ChannelGroup flush()
  {
    return flush(ChannelMatchers.all());
  }
  
  public ChannelGroup flush(ChannelMatcher paramChannelMatcher)
  {
    Iterator localIterator = this.nonServerChannels.values().iterator();
    while (localIterator.hasNext())
    {
      Channel localChannel = (Channel)localIterator.next();
      if (paramChannelMatcher.matches(localChannel)) {
        localChannel.flush();
      }
    }
    return this;
  }
  
  public ChannelGroupFuture flushAndWrite(Object paramObject)
  {
    return writeAndFlush(paramObject);
  }
  
  public ChannelGroupFuture flushAndWrite(Object paramObject, ChannelMatcher paramChannelMatcher)
  {
    return writeAndFlush(paramObject, paramChannelMatcher);
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this);
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if ((this.nonServerChannels.isEmpty()) && (this.serverChannels.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<Channel> iterator()
  {
    return new CombinedIterator(this.serverChannels.values().iterator(), this.nonServerChannels.values().iterator());
  }
  
  public String name()
  {
    return this.name;
  }
  
  public ChannelGroupFuture newCloseFuture()
  {
    return newCloseFuture(ChannelMatchers.all());
  }
  
  public ChannelGroupFuture newCloseFuture(ChannelMatcher paramChannelMatcher)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(size());
    Object localObject1 = this.serverChannels.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Channel)((Iterator)localObject1).next();
      if (paramChannelMatcher.matches((Channel)localObject2)) {
        localLinkedHashMap.put(localObject2, ((Channel)localObject2).closeFuture());
      }
    }
    Object localObject2 = this.nonServerChannels.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Channel)((Iterator)localObject2).next();
      if (paramChannelMatcher.matches((Channel)localObject1)) {
        localLinkedHashMap.put(localObject1, ((Channel)localObject1).closeFuture());
      }
    }
    return new DefaultChannelGroupFuture(this, localLinkedHashMap, this.executor);
  }
  
  public boolean remove(Object paramObject)
  {
    Channel localChannel2;
    if ((paramObject instanceof ChannelId))
    {
      Channel localChannel1 = (Channel)this.nonServerChannels.remove(paramObject);
      localChannel2 = localChannel1;
      if (localChannel1 == null) {
        localChannel2 = (Channel)this.serverChannels.remove(paramObject);
      }
    }
    else if ((paramObject instanceof Channel))
    {
      paramObject = (Channel)paramObject;
      if ((paramObject instanceof a)) {
        localChannel2 = (Channel)this.serverChannels.remove(((Channel)paramObject).id());
      } else {
        localChannel2 = (Channel)this.nonServerChannels.remove(((Channel)paramObject).id());
      }
    }
    else
    {
      localChannel2 = null;
    }
    if (localChannel2 == null) {
      return false;
    }
    localChannel2.closeFuture().removeListener(this.remover);
    return true;
  }
  
  public int size()
  {
    return this.nonServerChannels.size() + this.serverChannels.size();
  }
  
  public Object[] toArray()
  {
    ArrayList localArrayList = new ArrayList(size());
    localArrayList.addAll(this.serverChannels.values());
    localArrayList.addAll(this.nonServerChannels.values());
    return localArrayList.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ArrayList localArrayList = new ArrayList(size());
    localArrayList.addAll(this.serverChannels.values());
    localArrayList.addAll(this.nonServerChannels.values());
    return localArrayList.toArray(paramArrayOfT);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(name: ");
    localStringBuilder.append(name());
    localStringBuilder.append(", size: ");
    localStringBuilder.append(size());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public ChannelGroupFuture write(Object paramObject)
  {
    return write(paramObject, ChannelMatchers.all());
  }
  
  public ChannelGroupFuture write(Object paramObject, ChannelMatcher paramChannelMatcher)
  {
    return write(paramObject, paramChannelMatcher, false);
  }
  
  public ChannelGroupFuture write(Object paramObject, ChannelMatcher paramChannelMatcher, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramObject, "message");
    ObjectUtil.checkNotNull(paramChannelMatcher, "matcher");
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = this.nonServerChannels.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Channel)((Iterator)localObject1).next();
        if (paramChannelMatcher.matches((Channel)localObject2)) {
          ((ChannelOutboundInvoker)localObject2).write(safeDuplicate(paramObject), ((ChannelOutboundInvoker)localObject2).voidPromise());
        }
      }
      paramChannelMatcher = this.voidFuture;
    }
    else
    {
      localObject2 = new LinkedHashMap(this.nonServerChannels.size());
      Iterator localIterator = this.nonServerChannels.values().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Channel)localIterator.next();
        if (paramChannelMatcher.matches((Channel)localObject1)) {
          ((Map)localObject2).put(localObject1, ((ChannelOutboundInvoker)localObject1).write(safeDuplicate(paramObject)));
        }
      }
      paramChannelMatcher = new DefaultChannelGroupFuture(this, (Map)localObject2, this.executor);
    }
    ReferenceCountUtil.release(paramObject);
    return paramChannelMatcher;
  }
  
  public ChannelGroupFuture writeAndFlush(Object paramObject)
  {
    return writeAndFlush(paramObject, ChannelMatchers.all());
  }
  
  public ChannelGroupFuture writeAndFlush(Object paramObject, ChannelMatcher paramChannelMatcher)
  {
    return writeAndFlush(paramObject, paramChannelMatcher, false);
  }
  
  public ChannelGroupFuture writeAndFlush(Object paramObject, ChannelMatcher paramChannelMatcher, boolean paramBoolean)
  {
    ObjectUtil.checkNotNull(paramObject, "message");
    Iterator localIterator;
    Channel localChannel;
    if (paramBoolean)
    {
      localIterator = this.nonServerChannels.values().iterator();
      while (localIterator.hasNext())
      {
        localChannel = (Channel)localIterator.next();
        if (paramChannelMatcher.matches(localChannel)) {
          localChannel.writeAndFlush(safeDuplicate(paramObject), localChannel.voidPromise());
        }
      }
      paramChannelMatcher = this.voidFuture;
    }
    else
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.nonServerChannels.size());
      localIterator = this.nonServerChannels.values().iterator();
      while (localIterator.hasNext())
      {
        localChannel = (Channel)localIterator.next();
        if (paramChannelMatcher.matches(localChannel)) {
          localLinkedHashMap.put(localChannel, localChannel.writeAndFlush(safeDuplicate(paramObject)));
        }
      }
      paramChannelMatcher = new DefaultChannelGroupFuture(this, localLinkedHashMap, this.executor);
    }
    ReferenceCountUtil.release(paramObject);
    return paramChannelMatcher;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\group\DefaultChannelGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
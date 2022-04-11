package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

public abstract class AbstractCoalescingBufferQueue
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractCoalescingBufferQueue.class);
  private final ArrayDeque<Object> bufAndListenerPairs;
  private int readableBytes;
  private final PendingBytesTracker tracker;
  
  protected AbstractCoalescingBufferQueue(Channel paramChannel, int paramInt)
  {
    this.bufAndListenerPairs = new ArrayDeque(paramInt);
    if (paramChannel == null) {
      paramChannel = null;
    } else {
      paramChannel = PendingBytesTracker.newTracker(paramChannel);
    }
    this.tracker = paramChannel;
  }
  
  private void addFirst(ByteBuf paramByteBuf, ChannelFutureListener paramChannelFutureListener)
  {
    if (paramChannelFutureListener != null) {
      this.bufAndListenerPairs.addFirst(paramChannelFutureListener);
    }
    this.bufAndListenerPairs.addFirst(paramByteBuf);
    incrementReadableBytes(paramByteBuf.readableBytes());
  }
  
  private void decrementReadableBytes(int paramInt)
  {
    this.readableBytes -= paramInt;
    PendingBytesTracker localPendingBytesTracker = this.tracker;
    if (localPendingBytesTracker != null) {
      localPendingBytesTracker.decrementPendingOutboundBytes(paramInt);
    }
  }
  
  private void incrementReadableBytes(int paramInt)
  {
    int i = this.readableBytes;
    int j = i + paramInt;
    if (j >= i)
    {
      this.readableBytes = j;
      localObject = this.tracker;
      if (localObject != null) {
        ((PendingBytesTracker)localObject).incrementPendingOutboundBytes(paramInt);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buffer queue length overflow: ");
    ((StringBuilder)localObject).append(this.readableBytes);
    ((StringBuilder)localObject).append(" + ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private void releaseAndCompleteAll(ChannelFuture paramChannelFuture)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2 = this.bufAndListenerPairs.poll();
      if (localObject2 == null)
      {
        if (localObject1 == null) {
          return;
        }
        throw new IllegalStateException((Throwable)localObject1);
      }
      try
      {
        if ((localObject2 instanceof ByteBuf))
        {
          localObject2 = (ByteBuf)localObject2;
          decrementReadableBytes(((ByteBuf)localObject2).readableBytes());
          ReferenceCountUtil.safeRelease(localObject2);
        }
        else
        {
          ((ChannelFutureListener)localObject2).operationComplete(paramChannelFuture);
        }
      }
      finally
      {
        if (localObject1 == null) {
          localObject1 = localObject3;
        } else {
          logger.info("Throwable being suppressed because Throwable {} is already pending", localObject1, localObject3);
        }
      }
    }
  }
  
  private static ChannelFutureListener toChannelFutureListener(ChannelPromise paramChannelPromise)
  {
    if (paramChannelPromise.isVoid()) {
      paramChannelPromise = null;
    } else {
      paramChannelPromise = new DelegatingChannelPromiseNotifier(paramChannelPromise);
    }
    return paramChannelPromise;
  }
  
  public final void add(ByteBuf paramByteBuf)
  {
    add(paramByteBuf, null);
  }
  
  public final void add(ByteBuf paramByteBuf, ChannelFutureListener paramChannelFutureListener)
  {
    this.bufAndListenerPairs.add(paramByteBuf);
    if (paramChannelFutureListener != null) {
      this.bufAndListenerPairs.add(paramChannelFutureListener);
    }
    incrementReadableBytes(paramByteBuf.readableBytes());
  }
  
  public final void add(ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    add(paramByteBuf, toChannelFutureListener(paramChannelPromise));
  }
  
  public final void addFirst(ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    addFirst(paramByteBuf, toChannelFutureListener(paramChannelPromise));
  }
  
  protected abstract ByteBuf compose(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2);
  
  protected ByteBuf composeFirst(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf)
  {
    return paramByteBuf;
  }
  
  /* Error */
  protected final ByteBuf composeIntoComposite(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: invokevirtual 157	io/netty/channel/AbstractCoalescingBufferQueue:size	()I
    //   5: iconst_2
    //   6: iadd
    //   7: invokeinterface 163 2 0
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_1
    //   15: aload_2
    //   16: invokevirtual 169	io/netty/buffer/CompositeByteBuf:addComponent	(ZLio/netty/buffer/ByteBuf;)Lio/netty/buffer/CompositeByteBuf;
    //   19: pop
    //   20: aload_1
    //   21: iconst_1
    //   22: aload_3
    //   23: invokevirtual 169	io/netty/buffer/CompositeByteBuf:addComponent	(ZLio/netty/buffer/ByteBuf;)Lio/netty/buffer/CompositeByteBuf;
    //   26: pop
    //   27: goto +17 -> 44
    //   30: astore_2
    //   31: aload_1
    //   32: invokevirtual 174	io/netty/buffer/AbstractReferenceCountedByteBuf:release	()Z
    //   35: pop
    //   36: aload_3
    //   37: invokestatic 108	io/netty/util/ReferenceCountUtil:safeRelease	(Ljava/lang/Object;)V
    //   40: aload_2
    //   41: invokestatic 179	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   44: aload_1
    //   45: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	AbstractCoalescingBufferQueue
    //   0	46	1	paramByteBufAllocator	ByteBufAllocator
    //   0	46	2	paramByteBuf1	ByteBuf
    //   0	46	3	paramByteBuf2	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   13	27	30	finally
  }
  
  /* Error */
  protected final ByteBuf copyAndCompose(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokevirtual 56	io/netty/buffer/ByteBuf:readableBytes	()I
    //   5: aload_3
    //   6: invokevirtual 56	io/netty/buffer/ByteBuf:readableBytes	()I
    //   9: iadd
    //   10: invokeinterface 184 2 0
    //   15: astore_1
    //   16: aload_1
    //   17: aload_2
    //   18: invokevirtual 188	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   21: aload_3
    //   22: invokevirtual 188	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   25: pop
    //   26: goto +21 -> 47
    //   29: astore 4
    //   31: aload_1
    //   32: invokeinterface 191 1 0
    //   37: pop
    //   38: aload_3
    //   39: invokestatic 108	io/netty/util/ReferenceCountUtil:safeRelease	(Ljava/lang/Object;)V
    //   42: aload 4
    //   44: invokestatic 179	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   47: aload_2
    //   48: invokeinterface 191 1 0
    //   53: pop
    //   54: aload_3
    //   55: invokeinterface 191 1 0
    //   60: pop
    //   61: aload_1
    //   62: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	AbstractCoalescingBufferQueue
    //   0	63	1	paramByteBufAllocator	ByteBufAllocator
    //   0	63	2	paramByteBuf1	ByteBuf
    //   0	63	3	paramByteBuf2	ByteBuf
    //   29	14	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   16	26	29	finally
  }
  
  public final void copyTo(AbstractCoalescingBufferQueue paramAbstractCoalescingBufferQueue)
  {
    paramAbstractCoalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
    paramAbstractCoalescingBufferQueue.incrementReadableBytes(this.readableBytes);
  }
  
  public final boolean isEmpty()
  {
    return this.bufAndListenerPairs.isEmpty();
  }
  
  public final int readableBytes()
  {
    return this.readableBytes;
  }
  
  public final void releaseAndFailAll(ChannelOutboundInvoker paramChannelOutboundInvoker, Throwable paramThrowable)
  {
    releaseAndCompleteAll(paramChannelOutboundInvoker.newFailedFuture(paramThrowable));
  }
  
  public final ByteBuf remove(ByteBufAllocator paramByteBufAllocator, int paramInt, ChannelPromise paramChannelPromise)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "bytes");
    ObjectUtil.checkNotNull(paramChannelPromise, "aggregatePromise");
    if (this.bufAndListenerPairs.isEmpty()) {
      return removeEmptyValue();
    }
    int i = Math.min(paramInt, this.readableBytes);
    ByteBuf localByteBuf = null;
    paramInt = i;
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = localByteBuf;
      try
      {
        Object localObject3 = this.bufAndListenerPairs.poll();
        if (localObject3 == null)
        {
          j = paramInt;
          localObject1 = localObject2;
          break label304;
        }
        localObject1 = localByteBuf;
        if ((localObject3 instanceof ChannelFutureListener))
        {
          localObject1 = localByteBuf;
          paramChannelPromise.addListener((ChannelFutureListener)localObject3);
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localByteBuf;
          localObject3 = (ByteBuf)localObject3;
          j = paramInt;
          try
          {
            if (((ByteBuf)localObject3).readableBytes() > paramInt)
            {
              j = paramInt;
              this.bufAndListenerPairs.addFirst(localObject3);
              j = paramInt;
              localObject1 = localObject2;
              if (paramInt <= 0) {
                break label304;
              }
              j = paramInt;
              localByteBuf = ((ByteBuf)localObject3).readRetainedSlice(paramInt);
              if (localObject2 == null)
              {
                localObject1 = localByteBuf;
                paramByteBufAllocator = composeFirst(paramByteBufAllocator, localByteBuf);
              }
              else
              {
                localObject1 = localByteBuf;
                paramByteBufAllocator = compose(paramByteBufAllocator, (ByteBuf)localObject2, localByteBuf);
              }
              j = 0;
              localObject1 = paramByteBufAllocator;
              break label304;
            }
            j = paramInt;
            paramInt -= ((ByteBuf)localObject3).readableBytes();
            if (localObject2 == null)
            {
              j = paramInt;
              localObject1 = composeFirst(paramByteBufAllocator, (ByteBuf)localObject3);
              continue;
            }
            j = paramInt;
            localObject1 = compose(paramByteBufAllocator, (ByteBuf)localObject2, (ByteBuf)localObject3);
            continue;
          }
          finally
          {
            localObject1 = localObject3;
            paramInt = j;
          }
          ReferenceCountUtil.safeRelease(localObject1);
        }
      }
      finally {}
    }
    ReferenceCountUtil.safeRelease(localObject2);
    paramChannelPromise.setFailure(paramByteBufAllocator);
    PlatformDependent.throwException(paramByteBufAllocator);
    localObject1 = localObject2;
    int j = paramInt;
    label304:
    decrementReadableBytes(i - j);
    return (ByteBuf)localObject1;
  }
  
  protected abstract ByteBuf removeEmptyValue();
  
  public final ByteBuf removeFirst(ChannelPromise paramChannelPromise)
  {
    Object localObject = this.bufAndListenerPairs.poll();
    if (localObject == null) {
      return null;
    }
    ByteBuf localByteBuf = (ByteBuf)localObject;
    decrementReadableBytes(localByteBuf.readableBytes());
    localObject = this.bufAndListenerPairs.peek();
    if ((localObject instanceof ChannelFutureListener))
    {
      paramChannelPromise.addListener((ChannelFutureListener)localObject);
      this.bufAndListenerPairs.poll();
    }
    return localByteBuf;
  }
  
  protected final int size()
  {
    return this.bufAndListenerPairs.size();
  }
  
  public final void writeAndRemoveAll(ChannelHandlerContext paramChannelHandlerContext)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      Object localObject3 = this.bufAndListenerPairs.poll();
      if ((localObject3 != null) || (localObject1 != null)) {}
      try
      {
        decrementReadableBytes(((ByteBuf)localObject1).readableBytes());
        paramChannelHandlerContext.write(localObject1, paramChannelHandlerContext.voidPromise());
        if (localObject2 == null) {
          return;
        }
        throw new IllegalStateException((Throwable)localObject2);
        if ((localObject3 instanceof ByteBuf))
        {
          if (localObject1 != null)
          {
            decrementReadableBytes(((ByteBuf)localObject1).readableBytes());
            paramChannelHandlerContext.write(localObject1, paramChannelHandlerContext.voidPromise());
          }
          localObject3 = (ByteBuf)localObject3;
          localObject1 = localObject3;
        }
        else
        {
          if ((localObject3 instanceof ChannelPromise))
          {
            decrementReadableBytes(((ByteBuf)localObject1).readableBytes());
            paramChannelHandlerContext.write(localObject1, (ChannelPromise)localObject3);
          }
          for (;;)
          {
            localObject1 = null;
            break;
            decrementReadableBytes(((ByteBuf)localObject1).readableBytes());
            paramChannelHandlerContext.write(localObject1).addListener((ChannelFutureListener)localObject3);
          }
        }
      }
      finally
      {
        if (localObject2 == null) {
          localObject2 = localObject4;
        } else {
          logger.info("Throwable being suppressed because Throwable {} is already pending", localObject2, localObject4);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\AbstractCoalescingBufferQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
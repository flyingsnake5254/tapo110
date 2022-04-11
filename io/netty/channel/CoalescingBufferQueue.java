package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

public final class CoalescingBufferQueue
  extends AbstractCoalescingBufferQueue
{
  private final Channel channel;
  
  public CoalescingBufferQueue(Channel paramChannel)
  {
    this(paramChannel, 4);
  }
  
  public CoalescingBufferQueue(Channel paramChannel, int paramInt)
  {
    this(paramChannel, paramInt, false);
  }
  
  public CoalescingBufferQueue(Channel paramChannel, int paramInt, boolean paramBoolean)
  {
    super(localChannel, paramInt);
    this.channel = ((Channel)ObjectUtil.checkNotNull(paramChannel, "channel"));
  }
  
  protected ByteBuf compose(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    if ((paramByteBuf1 instanceof CompositeByteBuf))
    {
      paramByteBufAllocator = (CompositeByteBuf)paramByteBuf1;
      paramByteBufAllocator.addComponent(true, paramByteBuf2);
      return paramByteBufAllocator;
    }
    return composeIntoComposite(paramByteBufAllocator, paramByteBuf1, paramByteBuf2);
  }
  
  public void releaseAndFailAll(Throwable paramThrowable)
  {
    releaseAndFailAll(this.channel, paramThrowable);
  }
  
  public ByteBuf remove(int paramInt, ChannelPromise paramChannelPromise)
  {
    return remove(this.channel.alloc(), paramInt, paramChannelPromise);
  }
  
  protected ByteBuf removeEmptyValue()
  {
    return Unpooled.EMPTY_BUFFER;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\CoalescingBufferQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
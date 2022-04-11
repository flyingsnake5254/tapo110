package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

public class FixedRecvByteBufAllocator
  extends DefaultMaxMessagesRecvByteBufAllocator
{
  private final int bufferSize;
  
  public FixedRecvByteBufAllocator(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "bufferSize");
    this.bufferSize = paramInt;
  }
  
  public RecvByteBufAllocator.Handle newHandle()
  {
    return new HandleImpl(this.bufferSize);
  }
  
  public FixedRecvByteBufAllocator respectMaybeMoreData(boolean paramBoolean)
  {
    super.respectMaybeMoreData(paramBoolean);
    return this;
  }
  
  private final class HandleImpl
    extends DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle
  {
    private final int bufferSize;
    
    HandleImpl(int paramInt)
    {
      super();
      this.bufferSize = paramInt;
    }
    
    public int guess()
    {
      return this.bufferSize;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\FixedRecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
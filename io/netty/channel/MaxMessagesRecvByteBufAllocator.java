package io.netty.channel;

public abstract interface MaxMessagesRecvByteBufAllocator
  extends RecvByteBufAllocator
{
  public abstract int maxMessagesPerRead();
  
  public abstract MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\MaxMessagesRecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
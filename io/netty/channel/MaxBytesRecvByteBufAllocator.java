package io.netty.channel;

import java.util.Map.Entry;

public abstract interface MaxBytesRecvByteBufAllocator
  extends RecvByteBufAllocator
{
  public abstract int maxBytesPerIndividualRead();
  
  public abstract MaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int paramInt);
  
  public abstract int maxBytesPerRead();
  
  public abstract MaxBytesRecvByteBufAllocator maxBytesPerRead(int paramInt);
  
  public abstract MaxBytesRecvByteBufAllocator maxBytesPerReadPair(int paramInt1, int paramInt2);
  
  public abstract Map.Entry<Integer, Integer> maxBytesPerReadPair();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\MaxBytesRecvByteBufAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

public final class ChannelMetadata
{
  private final int defaultMaxMessagesPerRead;
  private final boolean hasDisconnect;
  
  public ChannelMetadata(boolean paramBoolean)
  {
    this(paramBoolean, 1);
  }
  
  public ChannelMetadata(boolean paramBoolean, int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "defaultMaxMessagesPerRead");
    this.hasDisconnect = paramBoolean;
    this.defaultMaxMessagesPerRead = paramInt;
  }
  
  public int defaultMaxMessagesPerRead()
  {
    return this.defaultMaxMessagesPerRead;
  }
  
  public boolean hasDisconnect()
  {
    return this.hasDisconnect;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
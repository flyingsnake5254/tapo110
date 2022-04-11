package io.netty.channel;

import java.io.Serializable;

public abstract interface ChannelId
  extends Serializable, Comparable<ChannelId>
{
  public abstract String asLongText();
  
  public abstract String asShortText();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\ChannelId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
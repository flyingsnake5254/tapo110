package io.netty.channel.embedded;

import io.netty.channel.ChannelId;

final class EmbeddedChannelId
  implements ChannelId
{
  static final ChannelId INSTANCE = new EmbeddedChannelId();
  private static final long serialVersionUID = -251711922203466130L;
  
  public String asLongText()
  {
    return toString();
  }
  
  public String asShortText()
  {
    return toString();
  }
  
  public int compareTo(ChannelId paramChannelId)
  {
    if ((paramChannelId instanceof EmbeddedChannelId)) {
      return 0;
    }
    return asLongText().compareTo(paramChannelId.asLongText());
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject instanceof EmbeddedChannelId;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return "embedded";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\embedded\EmbeddedChannelId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
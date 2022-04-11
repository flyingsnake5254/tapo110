package io.netty.handler.codec.http2;

import io.netty.channel.ChannelId;

final class Http2StreamChannelId
  implements ChannelId
{
  private static final long serialVersionUID = -6642338822166867585L;
  private final int id;
  private final ChannelId parentId;
  
  Http2StreamChannelId(ChannelId paramChannelId, int paramInt)
  {
    this.parentId = paramChannelId;
    this.id = paramInt;
  }
  
  public String asLongText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.parentId.asLongText());
    localStringBuilder.append('/');
    localStringBuilder.append(this.id);
    return localStringBuilder.toString();
  }
  
  public String asShortText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.parentId.asShortText());
    localStringBuilder.append('/');
    localStringBuilder.append(this.id);
    return localStringBuilder.toString();
  }
  
  public int compareTo(ChannelId paramChannelId)
  {
    if ((paramChannelId instanceof Http2StreamChannelId))
    {
      paramChannelId = (Http2StreamChannelId)paramChannelId;
      int i = this.parentId.compareTo(paramChannelId.parentId);
      int j = i;
      if (i == 0) {
        j = this.id - paramChannelId.id;
      }
      return j;
    }
    return this.parentId.compareTo(paramChannelId);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Http2StreamChannelId;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Http2StreamChannelId)paramObject;
    bool1 = bool2;
    if (this.id == ((Http2StreamChannelId)paramObject).id)
    {
      bool1 = bool2;
      if (this.parentId.equals(((Http2StreamChannelId)paramObject).parentId)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.id * 31 + this.parentId.hashCode();
  }
  
  public String toString()
  {
    return asShortText();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2StreamChannelId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
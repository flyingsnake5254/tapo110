package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSpdySynStreamFrame
  extends DefaultSpdyHeadersFrame
  implements SpdySynStreamFrame
{
  private int associatedStreamId;
  private byte priority;
  private boolean unidirectional;
  
  public DefaultSpdySynStreamFrame(int paramInt1, int paramInt2, byte paramByte)
  {
    this(paramInt1, paramInt2, paramByte, true);
  }
  
  public DefaultSpdySynStreamFrame(int paramInt1, int paramInt2, byte paramByte, boolean paramBoolean)
  {
    super(paramInt1, paramBoolean);
    setAssociatedStreamId(paramInt2);
    setPriority(paramByte);
  }
  
  public int associatedStreamId()
  {
    return this.associatedStreamId;
  }
  
  public boolean isUnidirectional()
  {
    return this.unidirectional;
  }
  
  public byte priority()
  {
    return this.priority;
  }
  
  public SpdySynStreamFrame setAssociatedStreamId(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "associatedStreamId");
    this.associatedStreamId = paramInt;
    return this;
  }
  
  public SpdySynStreamFrame setInvalid()
  {
    super.setInvalid();
    return this;
  }
  
  public SpdySynStreamFrame setLast(boolean paramBoolean)
  {
    super.setLast(paramBoolean);
    return this;
  }
  
  public SpdySynStreamFrame setPriority(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte <= 7))
    {
      this.priority = ((byte)paramByte);
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Priority must be between 0 and 7 inclusive: ");
    localStringBuilder.append(paramByte);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public SpdySynStreamFrame setStreamId(int paramInt)
  {
    super.setStreamId(paramInt);
    return this;
  }
  
  public SpdySynStreamFrame setUnidirectional(boolean paramBoolean)
  {
    this.unidirectional = paramBoolean;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(last: ");
    localStringBuilder.append(isLast());
    localStringBuilder.append("; unidirectional: ");
    localStringBuilder.append(isUnidirectional());
    localStringBuilder.append(')');
    String str = StringUtil.NEWLINE;
    localStringBuilder.append(str);
    localStringBuilder.append("--> Stream-ID = ");
    localStringBuilder.append(streamId());
    localStringBuilder.append(str);
    if (this.associatedStreamId != 0)
    {
      localStringBuilder.append("--> Associated-To-Stream-ID = ");
      localStringBuilder.append(associatedStreamId());
      localStringBuilder.append(str);
    }
    localStringBuilder.append("--> Priority = ");
    localStringBuilder.append(priority());
    localStringBuilder.append(str);
    localStringBuilder.append("--> Headers:");
    localStringBuilder.append(str);
    appendHeaders(localStringBuilder);
    localStringBuilder.setLength(localStringBuilder.length() - str.length());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\DefaultSpdySynStreamFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
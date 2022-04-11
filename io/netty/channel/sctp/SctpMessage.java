package io.netty.channel.sctp;

import com.sun.nio.sctp.MessageInfo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.ObjectUtil;

public final class SctpMessage
  extends DefaultByteBufHolder
{
  private final MessageInfo msgInfo;
  private final int protocolIdentifier;
  private final int streamIdentifier;
  private final boolean unordered;
  
  public SctpMessage(int paramInt1, int paramInt2, ByteBuf paramByteBuf)
  {
    this(paramInt1, paramInt2, false, paramByteBuf);
  }
  
  public SctpMessage(int paramInt1, int paramInt2, boolean paramBoolean, ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
    this.protocolIdentifier = paramInt1;
    this.streamIdentifier = paramInt2;
    this.unordered = paramBoolean;
    this.msgInfo = null;
  }
  
  public SctpMessage(MessageInfo paramMessageInfo, ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
    this.msgInfo = ((MessageInfo)ObjectUtil.checkNotNull(paramMessageInfo, "msgInfo"));
    this.streamIdentifier = paramMessageInfo.streamNumber();
    this.protocolIdentifier = paramMessageInfo.payloadProtocolID();
    this.unordered = paramMessageInfo.isUnordered();
  }
  
  public SctpMessage copy()
  {
    return (SctpMessage)super.copy();
  }
  
  public SctpMessage duplicate()
  {
    return (SctpMessage)super.duplicate();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (SctpMessage.class == paramObject.getClass()))
    {
      paramObject = (SctpMessage)paramObject;
      if (this.protocolIdentifier != ((SctpMessage)paramObject).protocolIdentifier) {
        return false;
      }
      if (this.streamIdentifier != ((SctpMessage)paramObject).streamIdentifier) {
        return false;
      }
      if (this.unordered != ((SctpMessage)paramObject).unordered) {
        return false;
      }
      return content().equals(((DefaultByteBufHolder)paramObject).content());
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.streamIdentifier;
    int j = this.protocolIdentifier;
    int k;
    if (this.unordered) {
      k = 1231;
    } else {
      k = 1237;
    }
    return ((i * 31 + j) * 31 + k) * 31 + content().hashCode();
  }
  
  public boolean isComplete()
  {
    MessageInfo localMessageInfo = this.msgInfo;
    if (localMessageInfo != null) {
      return localMessageInfo.isComplete();
    }
    return true;
  }
  
  public boolean isUnordered()
  {
    return this.unordered;
  }
  
  public MessageInfo messageInfo()
  {
    return this.msgInfo;
  }
  
  public int protocolIdentifier()
  {
    return this.protocolIdentifier;
  }
  
  public SctpMessage replace(ByteBuf paramByteBuf)
  {
    MessageInfo localMessageInfo = this.msgInfo;
    if (localMessageInfo == null) {
      return new SctpMessage(this.protocolIdentifier, this.streamIdentifier, this.unordered, paramByteBuf);
    }
    return new SctpMessage(localMessageInfo, paramByteBuf);
  }
  
  public SctpMessage retain()
  {
    super.retain();
    return this;
  }
  
  public SctpMessage retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public SctpMessage retainedDuplicate()
  {
    return (SctpMessage)super.retainedDuplicate();
  }
  
  public int streamIdentifier()
  {
    return this.streamIdentifier;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SctpFrame{streamIdentifier=");
    localStringBuilder.append(this.streamIdentifier);
    localStringBuilder.append(", protocolIdentifier=");
    localStringBuilder.append(this.protocolIdentifier);
    localStringBuilder.append(", unordered=");
    localStringBuilder.append(this.unordered);
    localStringBuilder.append(", data=");
    localStringBuilder.append(contentToString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public SctpMessage touch()
  {
    super.touch();
    return this;
  }
  
  public SctpMessage touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\SctpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
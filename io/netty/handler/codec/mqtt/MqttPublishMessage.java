package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;

public class MqttPublishMessage
  extends MqttMessage
  implements ByteBufHolder
{
  public MqttPublishMessage(MqttFixedHeader paramMqttFixedHeader, MqttPublishVariableHeader paramMqttPublishVariableHeader, ByteBuf paramByteBuf)
  {
    super(paramMqttFixedHeader, paramMqttPublishVariableHeader, paramByteBuf);
  }
  
  public ByteBuf content()
  {
    ByteBuf localByteBuf = (ByteBuf)super.payload();
    if (localByteBuf.refCnt() > 0) {
      return localByteBuf;
    }
    throw new IllegalReferenceCountException(localByteBuf.refCnt());
  }
  
  public MqttPublishMessage copy()
  {
    return replace(content().copy());
  }
  
  public MqttPublishMessage duplicate()
  {
    return replace(content().duplicate());
  }
  
  public ByteBuf payload()
  {
    return content();
  }
  
  public int refCnt()
  {
    return content().refCnt();
  }
  
  public boolean release()
  {
    return content().release();
  }
  
  public boolean release(int paramInt)
  {
    return content().release(paramInt);
  }
  
  public MqttPublishMessage replace(ByteBuf paramByteBuf)
  {
    return new MqttPublishMessage(fixedHeader(), variableHeader(), paramByteBuf);
  }
  
  public MqttPublishMessage retain()
  {
    content().retain();
    return this;
  }
  
  public MqttPublishMessage retain(int paramInt)
  {
    content().retain(paramInt);
    return this;
  }
  
  public MqttPublishMessage retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public MqttPublishMessage touch()
  {
    content().touch();
    return this;
  }
  
  public MqttPublishMessage touch(Object paramObject)
  {
    content().touch(paramObject);
    return this;
  }
  
  public MqttPublishVariableHeader variableHeader()
  {
    return (MqttPublishVariableHeader)super.variableHeader();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttPublishMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
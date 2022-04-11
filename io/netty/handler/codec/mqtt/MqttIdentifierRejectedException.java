package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

public final class MqttIdentifierRejectedException
  extends DecoderException
{
  private static final long serialVersionUID = -1323503322689614981L;
  
  public MqttIdentifierRejectedException() {}
  
  public MqttIdentifierRejectedException(String paramString)
  {
    super(paramString);
  }
  
  public MqttIdentifierRejectedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MqttIdentifierRejectedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttIdentifierRejectedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
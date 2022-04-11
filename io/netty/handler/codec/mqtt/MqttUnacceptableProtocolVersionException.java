package io.netty.handler.codec.mqtt;

import io.netty.handler.codec.DecoderException;

public final class MqttUnacceptableProtocolVersionException
  extends DecoderException
{
  private static final long serialVersionUID = 4914652213232455749L;
  
  public MqttUnacceptableProtocolVersionException() {}
  
  public MqttUnacceptableProtocolVersionException(String paramString)
  {
    super(paramString);
  }
  
  public MqttUnacceptableProtocolVersionException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MqttUnacceptableProtocolVersionException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\mqtt\MqttUnacceptableProtocolVersionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
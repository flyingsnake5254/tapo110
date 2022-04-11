package org.eclipse.paho.client.mqttv3;

public class MqttPersistenceException
  extends MqttException
{
  public static final short REASON_CODE_PERSISTENCE_IN_USE = 32200;
  private static final long serialVersionUID = 300L;
  
  public MqttPersistenceException()
  {
    super(0);
  }
  
  public MqttPersistenceException(int paramInt)
  {
    super(paramInt);
  }
  
  public MqttPersistenceException(int paramInt, Throwable paramThrowable)
  {
    super(paramInt, paramThrowable);
  }
  
  public MqttPersistenceException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttPersistenceException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
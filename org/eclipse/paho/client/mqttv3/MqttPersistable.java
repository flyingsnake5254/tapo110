package org.eclipse.paho.client.mqttv3;

public abstract interface MqttPersistable
{
  public abstract byte[] getHeaderBytes()
    throws MqttPersistenceException;
  
  public abstract int getHeaderLength()
    throws MqttPersistenceException;
  
  public abstract int getHeaderOffset()
    throws MqttPersistenceException;
  
  public abstract byte[] getPayloadBytes()
    throws MqttPersistenceException;
  
  public abstract int getPayloadLength()
    throws MqttPersistenceException;
  
  public abstract int getPayloadOffset()
    throws MqttPersistenceException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttPersistable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
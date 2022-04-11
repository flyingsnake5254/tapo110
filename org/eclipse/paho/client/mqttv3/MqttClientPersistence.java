package org.eclipse.paho.client.mqttv3;

import java.util.Enumeration;

public abstract interface MqttClientPersistence
  extends AutoCloseable
{
  public abstract void clear()
    throws MqttPersistenceException;
  
  public abstract void close()
    throws MqttPersistenceException;
  
  public abstract boolean containsKey(String paramString)
    throws MqttPersistenceException;
  
  public abstract MqttPersistable get(String paramString)
    throws MqttPersistenceException;
  
  public abstract Enumeration keys()
    throws MqttPersistenceException;
  
  public abstract void open(String paramString1, String paramString2)
    throws MqttPersistenceException;
  
  public abstract void put(String paramString, MqttPersistable paramMqttPersistable)
    throws MqttPersistenceException;
  
  public abstract void remove(String paramString)
    throws MqttPersistenceException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttClientPersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
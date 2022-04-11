package org.eclipse.paho.client.mqttv3;

import org.eclipse.paho.client.mqttv3.internal.ClientComms;

public abstract interface MqttPingSender
{
  public abstract void init(ClientComms paramClientComms);
  
  public abstract void schedule(long paramLong);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttPingSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.eclipse.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;

public abstract interface NetworkModule
{
  public abstract InputStream getInputStream()
    throws IOException;
  
  public abstract OutputStream getOutputStream()
    throws IOException;
  
  public abstract String getServerURI();
  
  public abstract void start()
    throws IOException, MqttException;
  
  public abstract void stop()
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\NetworkModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
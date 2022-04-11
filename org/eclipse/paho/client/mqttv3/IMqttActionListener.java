package org.eclipse.paho.client.mqttv3;

public abstract interface IMqttActionListener
{
  public abstract void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable);
  
  public abstract void onSuccess(IMqttToken paramIMqttToken);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\IMqttActionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
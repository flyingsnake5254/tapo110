package org.eclipse.paho.client.mqttv3;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public abstract interface IMqttToken
{
  public abstract IMqttActionListener getActionCallback();
  
  public abstract IMqttAsyncClient getClient();
  
  public abstract MqttException getException();
  
  public abstract int[] getGrantedQos();
  
  public abstract int getMessageId();
  
  public abstract MqttWireMessage getResponse();
  
  public abstract boolean getSessionPresent();
  
  public abstract String[] getTopics();
  
  public abstract Object getUserContext();
  
  public abstract boolean isComplete();
  
  public abstract void setActionCallback(IMqttActionListener paramIMqttActionListener);
  
  public abstract void setUserContext(Object paramObject);
  
  public abstract void waitForCompletion()
    throws MqttException;
  
  public abstract void waitForCompletion(long paramLong)
    throws MqttException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\IMqttToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
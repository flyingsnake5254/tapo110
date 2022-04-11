package org.eclipse.paho.client.mqttv3;

public abstract interface IMqttClient
  extends AutoCloseable
{
  public abstract void close()
    throws MqttException;
  
  public abstract void connect()
    throws MqttSecurityException, MqttException;
  
  public abstract void connect(MqttConnectOptions paramMqttConnectOptions)
    throws MqttSecurityException, MqttException;
  
  public abstract IMqttToken connectWithResult(MqttConnectOptions paramMqttConnectOptions)
    throws MqttSecurityException, MqttException;
  
  public abstract void disconnect()
    throws MqttException;
  
  public abstract void disconnect(long paramLong)
    throws MqttException;
  
  public abstract void disconnectForcibly()
    throws MqttException;
  
  public abstract void disconnectForcibly(long paramLong)
    throws MqttException;
  
  public abstract void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException;
  
  public abstract String getClientId();
  
  public abstract IMqttDeliveryToken[] getPendingDeliveryTokens();
  
  public abstract String getServerURI();
  
  public abstract MqttTopic getTopic(String paramString);
  
  public abstract boolean isConnected();
  
  public abstract void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException;
  
  public abstract void publish(String paramString, MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException;
  
  public abstract void publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException;
  
  public abstract void reconnect()
    throws MqttException;
  
  public abstract void setCallback(MqttCallback paramMqttCallback);
  
  public abstract void setManualAcks(boolean paramBoolean);
  
  public abstract void subscribe(String paramString)
    throws MqttException, MqttSecurityException;
  
  public abstract void subscribe(String paramString, int paramInt)
    throws MqttException;
  
  public abstract void subscribe(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException;
  
  public abstract void subscribe(String paramString, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException, MqttSecurityException;
  
  public abstract void subscribe(String[] paramArrayOfString)
    throws MqttException;
  
  public abstract void subscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException;
  
  public abstract void subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract void subscribe(String[] paramArrayOfString, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String paramString)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String paramString, int paramInt)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String paramString, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String[] paramArrayOfString)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribeWithResponse(String[] paramArrayOfString, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract void unsubscribe(String paramString)
    throws MqttException;
  
  public abstract void unsubscribe(String[] paramArrayOfString)
    throws MqttException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\IMqttClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
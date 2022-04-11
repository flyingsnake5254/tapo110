package org.eclipse.paho.client.mqttv3;

public abstract interface IMqttAsyncClient
  extends AutoCloseable
{
  public abstract void close()
    throws MqttException;
  
  public abstract IMqttToken connect()
    throws MqttException, MqttSecurityException;
  
  public abstract IMqttToken connect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException;
  
  public abstract IMqttToken connect(MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException;
  
  public abstract IMqttToken connect(MqttConnectOptions paramMqttConnectOptions, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException;
  
  public abstract void deleteBufferedMessage(int paramInt);
  
  public abstract IMqttToken disconnect()
    throws MqttException;
  
  public abstract IMqttToken disconnect(long paramLong)
    throws MqttException;
  
  public abstract IMqttToken disconnect(long paramLong, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken disconnect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract void disconnectForcibly()
    throws MqttException;
  
  public abstract void disconnectForcibly(long paramLong)
    throws MqttException;
  
  public abstract void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException;
  
  public abstract MqttMessage getBufferedMessage(int paramInt);
  
  public abstract int getBufferedMessageCount();
  
  public abstract String getClientId();
  
  public abstract int getInFlightMessageCount();
  
  public abstract IMqttDeliveryToken[] getPendingDeliveryTokens();
  
  public abstract String getServerURI();
  
  public abstract boolean isConnected();
  
  public abstract void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException;
  
  public abstract IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException;
  
  public abstract IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException;
  
  public abstract IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException;
  
  public abstract IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException;
  
  public abstract void reconnect()
    throws MqttException;
  
  public abstract boolean removeMessage(IMqttDeliveryToken paramIMqttDeliveryToken)
    throws MqttException;
  
  public abstract void setBufferOpts(DisconnectedBufferOptions paramDisconnectedBufferOptions);
  
  public abstract void setCallback(MqttCallback paramMqttCallback);
  
  public abstract void setManualAcks(boolean paramBoolean);
  
  public abstract IMqttToken subscribe(String paramString, int paramInt)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String paramString)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String paramString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String[] paramArrayOfString)
    throws MqttException;
  
  public abstract IMqttToken unsubscribe(String[] paramArrayOfString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\IMqttAsyncClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
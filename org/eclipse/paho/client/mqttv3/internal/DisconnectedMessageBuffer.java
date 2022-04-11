package org.eclipse.paho.client.mqttv3.internal;

import java.util.ArrayList;
import org.eclipse.paho.client.mqttv3.BufferedMessage;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class DisconnectedMessageBuffer
  implements Runnable
{
  private final String CLASS_NAME;
  private final Object bufLock;
  private ArrayList<BufferedMessage> buffer;
  private DisconnectedBufferOptions bufferOpts;
  private IDisconnectedBufferCallback callback;
  private Logger log;
  private IDiscardedBufferMessageCallback messageDiscardedCallBack;
  private int mycount;
  
  public DisconnectedMessageBuffer(DisconnectedBufferOptions paramDisconnectedBufferOptions)
  {
    String str = DisconnectedMessageBuffer.class.getName();
    this.CLASS_NAME = str;
    this.log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", str);
    this.bufLock = new Object();
    this.mycount = 0;
    this.bufferOpts = paramDisconnectedBufferOptions;
    this.buffer = new ArrayList();
  }
  
  public void deleteMessage(int paramInt)
  {
    synchronized (this.bufLock)
    {
      this.buffer.remove(paramInt);
      return;
    }
  }
  
  public BufferedMessage getMessage(int paramInt)
  {
    synchronized (this.bufLock)
    {
      BufferedMessage localBufferedMessage = (BufferedMessage)this.buffer.get(paramInt);
      return localBufferedMessage;
    }
  }
  
  public int getMessageCount()
  {
    synchronized (this.bufLock)
    {
      int i = this.buffer.size();
      return i;
    }
  }
  
  public boolean isPersistBuffer()
  {
    return this.bufferOpts.isPersistBuffer();
  }
  
  public void putMessage(MqttWireMessage arg1, MqttToken paramMqttToken)
    throws MqttException
  {
    if (paramMqttToken != null)
    {
      ???.setToken(paramMqttToken);
      paramMqttToken.internalTok.setMessageID(???.getMessageId());
    }
    paramMqttToken = new BufferedMessage(???, paramMqttToken);
    synchronized (this.bufLock)
    {
      if (this.buffer.size() < this.bufferOpts.getBufferSize())
      {
        this.buffer.add(paramMqttToken);
      }
      else
      {
        if (!this.bufferOpts.isDeleteOldestMessages()) {
          break label129;
        }
        if (this.messageDiscardedCallBack != null)
        {
          BufferedMessage localBufferedMessage = (BufferedMessage)this.buffer.get(0);
          this.messageDiscardedCallBack.messageDiscarded(localBufferedMessage.getMessage());
        }
        this.buffer.remove(0);
        this.buffer.add(paramMqttToken);
      }
      return;
      label129:
      paramMqttToken = new org/eclipse/paho/client/mqttv3/MqttException;
      paramMqttToken.<init>(32203);
      throw paramMqttToken;
    }
  }
  
  public void run()
  {
    this.log.fine(this.CLASS_NAME, "run", "516");
    for (;;)
    {
      if (getMessageCount() > 0) {
        try
        {
          BufferedMessage localBufferedMessage = getMessage(0);
          this.callback.publishBufferedMessage(localBufferedMessage);
          deleteMessage(0);
        }
        catch (MqttException localMqttException)
        {
          if (localMqttException.getReasonCode() == 32202) {
            try
            {
              Thread.sleep(100L);
            }
            catch (Exception localException) {}
          } else {
            this.log.severe(this.CLASS_NAME, "run", "519", new Object[] { Integer.valueOf(localException.getReasonCode()), localException.getMessage() });
          }
        }
      }
    }
  }
  
  public void setMessageDiscardedCallBack(IDiscardedBufferMessageCallback paramIDiscardedBufferMessageCallback)
  {
    this.messageDiscardedCallBack = paramIDiscardedBufferMessageCallback;
  }
  
  public void setPublishCallback(IDisconnectedBufferCallback paramIDisconnectedBufferCallback)
  {
    this.callback = paramIDisconnectedBufferCallback;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\DisconnectedMessageBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnack;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSuback;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class Token
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.Token";
  private IMqttActionListener callback = null;
  private IMqttAsyncClient client = null;
  private volatile boolean completed = false;
  private MqttException exception = null;
  private String key;
  private Logger log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
  protected MqttMessage message = null;
  private int messageID = 0;
  private boolean notified = false;
  private boolean pendingComplete = false;
  private MqttWireMessage response = null;
  private final Object responseLock = new Object();
  private boolean sent = false;
  private final Object sentLock = new Object();
  private String[] topics = null;
  private Object userContext = null;
  
  public Token(String paramString)
  {
    this.log.setResourceName(paramString);
  }
  
  public boolean checkResult()
    throws MqttException
  {
    if (getException() == null) {
      return true;
    }
    throw getException();
  }
  
  public IMqttActionListener getActionCallback()
  {
    return this.callback;
  }
  
  public IMqttAsyncClient getClient()
  {
    return this.client;
  }
  
  public MqttException getException()
  {
    return this.exception;
  }
  
  public int[] getGrantedQos()
  {
    int[] arrayOfInt = new int[0];
    MqttWireMessage localMqttWireMessage = this.response;
    if ((localMqttWireMessage instanceof MqttSuback)) {
      arrayOfInt = ((MqttSuback)localMqttWireMessage).getGrantedQos();
    }
    return arrayOfInt;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public MqttMessage getMessage()
  {
    return this.message;
  }
  
  public int getMessageID()
  {
    return this.messageID;
  }
  
  public MqttWireMessage getResponse()
  {
    return this.response;
  }
  
  public boolean getSessionPresent()
  {
    MqttWireMessage localMqttWireMessage = this.response;
    boolean bool;
    if ((localMqttWireMessage instanceof MqttConnack)) {
      bool = ((MqttConnack)localMqttWireMessage).getSessionPresent();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String[] getTopics()
  {
    return this.topics;
  }
  
  public Object getUserContext()
  {
    return this.userContext;
  }
  
  public MqttWireMessage getWireMessage()
  {
    return this.response;
  }
  
  public boolean isComplete()
  {
    return this.completed;
  }
  
  protected boolean isCompletePending()
  {
    return this.pendingComplete;
  }
  
  protected boolean isInUse()
  {
    return (getClient() != null) && (!isComplete());
  }
  
  public boolean isNotified()
  {
    return this.notified;
  }
  
  protected void markComplete(MqttWireMessage paramMqttWireMessage, MqttException paramMqttException)
  {
    this.log.fine(CLASS_NAME, "markComplete", "404", new Object[] { getKey(), paramMqttWireMessage, paramMqttException });
    synchronized (this.responseLock)
    {
      if ((paramMqttWireMessage instanceof MqttAck)) {
        this.message = null;
      }
      this.pendingComplete = true;
      this.response = paramMqttWireMessage;
      this.exception = paramMqttException;
      return;
    }
  }
  
  protected void notifyComplete()
  {
    this.log.fine(CLASS_NAME, "notifyComplete", "404", new Object[] { getKey(), this.response, this.exception });
    synchronized (this.responseLock)
    {
      if ((this.exception == null) && (this.pendingComplete))
      {
        this.completed = true;
        this.pendingComplete = false;
      }
      else
      {
        this.pendingComplete = false;
      }
      this.responseLock.notifyAll();
      synchronized (this.sentLock)
      {
        this.sent = true;
        this.sentLock.notifyAll();
        return;
      }
    }
  }
  
  protected void notifySent()
  {
    this.log.fine(CLASS_NAME, "notifySent", "403", new Object[] { getKey() });
    synchronized (this.responseLock)
    {
      this.response = null;
      this.completed = false;
      synchronized (this.sentLock)
      {
        this.sent = true;
        this.sentLock.notifyAll();
        return;
      }
    }
  }
  
  public void reset()
    throws MqttException
  {
    if (!isInUse())
    {
      this.log.fine(CLASS_NAME, "reset", "410", new Object[] { getKey() });
      this.client = null;
      this.completed = false;
      this.response = null;
      this.sent = false;
      this.exception = null;
      this.userContext = null;
      return;
    }
    throw new MqttException(32201);
  }
  
  public void setActionCallback(IMqttActionListener paramIMqttActionListener)
  {
    this.callback = paramIMqttActionListener;
  }
  
  protected void setClient(IMqttAsyncClient paramIMqttAsyncClient)
  {
    this.client = paramIMqttAsyncClient;
  }
  
  public void setException(MqttException paramMqttException)
  {
    synchronized (this.responseLock)
    {
      this.exception = paramMqttException;
      return;
    }
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setMessage(MqttMessage paramMqttMessage)
  {
    this.message = paramMqttMessage;
  }
  
  public void setMessageID(int paramInt)
  {
    this.messageID = paramInt;
  }
  
  public void setNotified(boolean paramBoolean)
  {
    this.notified = paramBoolean;
  }
  
  public void setTopics(String[] paramArrayOfString)
  {
    this.topics = ((String[])paramArrayOfString.clone());
  }
  
  public void setUserContext(Object paramObject)
  {
    this.userContext = paramObject;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("key=");
    localStringBuffer.append(getKey());
    localStringBuffer.append(" ,topics=");
    if (getTopics() != null) {
      for (int i = 0; i < getTopics().length; i++)
      {
        localStringBuffer.append(getTopics()[i]);
        localStringBuffer.append(", ");
      }
    }
    localStringBuffer.append(" ,usercontext=");
    localStringBuffer.append(getUserContext());
    localStringBuffer.append(" ,isComplete=");
    localStringBuffer.append(isComplete());
    localStringBuffer.append(" ,isNotified=");
    localStringBuffer.append(isNotified());
    localStringBuffer.append(" ,exception=");
    localStringBuffer.append(getException());
    localStringBuffer.append(" ,actioncallback=");
    localStringBuffer.append(getActionCallback());
    return localStringBuffer.toString();
  }
  
  public void waitForCompletion()
    throws MqttException
  {
    waitForCompletion(-1L);
  }
  
  public void waitForCompletion(long paramLong)
    throws MqttException
  {
    Object localObject = this.log;
    String str = CLASS_NAME;
    ((Logger)localObject).fine(str, "waitForCompletion", "407", new Object[] { getKey(), Long.valueOf(paramLong), this });
    if ((waitForResponse(paramLong) == null) && (!this.completed))
    {
      this.log.fine(str, "waitForCompletion", "406", new Object[] { getKey(), this });
      localObject = new MqttException(32000);
      this.exception = ((MqttException)localObject);
      throw ((Throwable)localObject);
    }
    checkResult();
  }
  
  protected MqttWireMessage waitForResponse()
    throws MqttException
  {
    return waitForResponse(-1L);
  }
  
  protected MqttWireMessage waitForResponse(long paramLong)
    throws MqttException
  {
    synchronized (this.responseLock)
    {
      Logger localLogger = this.log;
      String str1 = CLASS_NAME;
      String str2 = getKey();
      boolean bool1 = this.sent;
      boolean bool2 = this.completed;
      MqttException localMqttException1 = this.exception;
      Object localObject2;
      if (localMqttException1 == null) {
        localObject2 = "false";
      } else {
        localObject2 = "true";
      }
      localLogger.fine(str1, "waitForResponse", "400", new Object[] { str2, Long.valueOf(paramLong), Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject2, this.response, this }, localMqttException1);
      MqttException localMqttException2;
      do
      {
        do
        {
          if (this.completed) {
            break;
          }
          localObject2 = this.exception;
          if (localObject2 == null) {
            try
            {
              this.log.fine(CLASS_NAME, "waitForResponse", "408", new Object[] { getKey(), Long.valueOf(paramLong) });
              if (paramLong <= 0L) {
                this.responseLock.wait();
              } else {
                this.responseLock.wait(paramLong);
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              localMqttException1 = new org/eclipse/paho/client/mqttv3/MqttException;
              localMqttException1.<init>(localInterruptedException);
              this.exception = localMqttException1;
            }
          }
        } while (this.completed);
        localMqttException2 = this.exception;
        if (localMqttException2 != null) {
          break label293;
        }
      } while (paramLong <= 0L);
      this.log.fine(CLASS_NAME, "waitForResponse", "402", new Object[] { getKey(), this.response });
      return this.response;
      label293:
      this.log.fine(CLASS_NAME, "waitForResponse", "401", null, localMqttException2);
      throw this.exception;
    }
  }
  
  public void waitUntilSent()
    throws MqttException
  {
    for (;;)
    {
      synchronized (this.sentLock)
      {
        synchronized (this.responseLock)
        {
          MqttException localMqttException = this.exception;
          if (localMqttException == null)
          {
            boolean bool = this.sent;
            if (bool)
            {
              if (!bool)
              {
                ??? = this.exception;
                if (??? == null) {
                  throw ExceptionHelper.createMqttException(6);
                }
                throw ((Throwable)???);
              }
              return;
            }
          }
          try
          {
            this.log.fine(CLASS_NAME, "waitUntilSent", "409", new Object[] { getKey() });
            this.sentLock.wait();
          }
          catch (InterruptedException localInterruptedException) {}
          throw localMqttException;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
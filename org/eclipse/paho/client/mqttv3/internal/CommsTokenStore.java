package org.eclipse.paho.client.mqttv3.internal;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class CommsTokenStore
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.CommsTokenStore";
  private MqttException closedResponse;
  private Logger log;
  private String logContext;
  private final Hashtable tokens;
  
  public CommsTokenStore(String paramString)
  {
    String str = CLASS_NAME;
    Logger localLogger = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", str);
    this.log = localLogger;
    this.closedResponse = null;
    localLogger.setResourceName(paramString);
    this.tokens = new Hashtable();
    this.logContext = paramString;
    this.log.fine(str, "<Init>", "308");
  }
  
  public void clear()
  {
    this.log.fine(CLASS_NAME, "clear", "305", new Object[] { Integer.valueOf(this.tokens.size()) });
    synchronized (this.tokens)
    {
      this.tokens.clear();
      return;
    }
  }
  
  public int count()
  {
    synchronized (this.tokens)
    {
      int i = this.tokens.size();
      return i;
    }
  }
  
  public MqttDeliveryToken[] getOutstandingDelTokens()
  {
    synchronized (this.tokens)
    {
      this.log.fine(CLASS_NAME, "getOutstandingDelTokens", "311");
      Vector localVector = new java/util/Vector;
      localVector.<init>();
      Object localObject1 = this.tokens.elements();
      MqttToken localMqttToken;
      do
      {
        if (!((Enumeration)localObject1).hasMoreElements())
        {
          localObject1 = (MqttDeliveryToken[])localVector.toArray(new MqttDeliveryToken[localVector.size()]);
          return (MqttDeliveryToken[])localObject1;
        }
        localMqttToken = (MqttToken)((Enumeration)localObject1).nextElement();
      } while ((localMqttToken == null) || (!(localMqttToken instanceof MqttDeliveryToken)) || (localMqttToken.internalTok.isNotified()));
      localVector.addElement(localMqttToken);
    }
  }
  
  public Vector getOutstandingTokens()
  {
    synchronized (this.tokens)
    {
      this.log.fine(CLASS_NAME, "getOutstandingTokens", "312");
      Vector localVector = new java/util/Vector;
      localVector.<init>();
      Enumeration localEnumeration = this.tokens.elements();
      MqttToken localMqttToken;
      do
      {
        if (!localEnumeration.hasMoreElements()) {
          return localVector;
        }
        localMqttToken = (MqttToken)localEnumeration.nextElement();
      } while (localMqttToken == null);
      localVector.addElement(localMqttToken);
    }
  }
  
  public MqttToken getToken(String paramString)
  {
    return (MqttToken)this.tokens.get(paramString);
  }
  
  public MqttToken getToken(MqttWireMessage paramMqttWireMessage)
  {
    paramMqttWireMessage = paramMqttWireMessage.getKey();
    return (MqttToken)this.tokens.get(paramMqttWireMessage);
  }
  
  public void open()
  {
    synchronized (this.tokens)
    {
      this.log.fine(CLASS_NAME, "open", "310");
      this.closedResponse = null;
      return;
    }
  }
  
  protected void quiesce(MqttException paramMqttException)
  {
    synchronized (this.tokens)
    {
      this.log.fine(CLASS_NAME, "quiesce", "309", new Object[] { paramMqttException });
      this.closedResponse = paramMqttException;
      return;
    }
  }
  
  public MqttToken removeToken(String paramString)
  {
    this.log.fine(CLASS_NAME, "removeToken", "306", new Object[] { paramString });
    if (paramString != null) {
      return (MqttToken)this.tokens.remove(paramString);
    }
    return null;
  }
  
  public MqttToken removeToken(MqttWireMessage paramMqttWireMessage)
  {
    if (paramMqttWireMessage != null) {
      return removeToken(paramMqttWireMessage.getKey());
    }
    return null;
  }
  
  protected MqttDeliveryToken restoreToken(MqttPublish paramMqttPublish)
  {
    synchronized (this.tokens)
    {
      String str = Integer.toString(paramMqttPublish.getMessageId());
      MqttDeliveryToken localMqttDeliveryToken;
      if (this.tokens.containsKey(str))
      {
        localMqttDeliveryToken = (MqttDeliveryToken)this.tokens.get(str);
        this.log.fine(CLASS_NAME, "restoreToken", "302", new Object[] { str, paramMqttPublish, localMqttDeliveryToken });
        paramMqttPublish = localMqttDeliveryToken;
      }
      else
      {
        localMqttDeliveryToken = new org/eclipse/paho/client/mqttv3/MqttDeliveryToken;
        localMqttDeliveryToken.<init>(this.logContext);
        localMqttDeliveryToken.internalTok.setKey(str);
        this.tokens.put(str, localMqttDeliveryToken);
        this.log.fine(CLASS_NAME, "restoreToken", "303", new Object[] { str, paramMqttPublish, localMqttDeliveryToken });
        paramMqttPublish = localMqttDeliveryToken;
      }
      return paramMqttPublish;
    }
  }
  
  protected void saveToken(MqttToken paramMqttToken, String paramString)
  {
    synchronized (this.tokens)
    {
      this.log.fine(CLASS_NAME, "saveToken", "307", new Object[] { paramString, paramMqttToken.toString() });
      paramMqttToken.internalTok.setKey(paramString);
      this.tokens.put(paramString, paramMqttToken);
      return;
    }
  }
  
  protected void saveToken(MqttToken paramMqttToken, MqttWireMessage paramMqttWireMessage)
    throws MqttException
  {
    synchronized (this.tokens)
    {
      Object localObject = this.closedResponse;
      if (localObject == null)
      {
        localObject = paramMqttWireMessage.getKey();
        this.log.fine(CLASS_NAME, "saveToken", "300", new Object[] { localObject, paramMqttWireMessage });
        saveToken(paramMqttToken, (String)localObject);
        return;
      }
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    String str = System.getProperty("line.separator", "\n");
    StringBuffer localStringBuffer = new StringBuffer();
    synchronized (this.tokens)
    {
      Enumeration localEnumeration = this.tokens.elements();
      if (!localEnumeration.hasMoreElements())
      {
        localObject1 = localStringBuffer.toString();
        return (String)localObject1;
      }
      MqttToken localMqttToken = (MqttToken)localEnumeration.nextElement();
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("{");
      ((StringBuilder)localObject1).append(localMqttToken.internalTok);
      ((StringBuilder)localObject1).append("}");
      ((StringBuilder)localObject1).append(str);
      localStringBuffer.append(((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\CommsTokenStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
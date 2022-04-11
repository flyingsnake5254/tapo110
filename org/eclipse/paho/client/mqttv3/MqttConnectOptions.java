package org.eclipse.paho.client.mqttv3;

import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import org.eclipse.paho.client.mqttv3.internal.NetworkModuleService;
import org.eclipse.paho.client.mqttv3.util.Debug;

public class MqttConnectOptions
{
  public static final boolean CLEAN_SESSION_DEFAULT = true;
  public static final int CONNECTION_TIMEOUT_DEFAULT = 30;
  public static final int KEEP_ALIVE_INTERVAL_DEFAULT = 60;
  public static final int MAX_INFLIGHT_DEFAULT = 10;
  public static final int MQTT_VERSION_3_1 = 3;
  public static final int MQTT_VERSION_3_1_1 = 4;
  public static final int MQTT_VERSION_DEFAULT = 0;
  private boolean automaticReconnect = false;
  private boolean cleanSession = true;
  private int connectionTimeout = 30;
  private Properties customWebSocketHeaders = null;
  private int executorServiceTimeout = 1;
  private boolean httpsHostnameVerificationEnabled = true;
  private int keepAliveInterval = 60;
  private int maxInflight = 10;
  private int maxReconnectDelay = 128000;
  private int mqttVersion = 0;
  private char[] password;
  private String[] serverURIs = null;
  private SocketFactory socketFactory;
  private Properties sslClientProps = null;
  private HostnameVerifier sslHostnameVerifier = null;
  private String userName;
  private String willDestination = null;
  private MqttMessage willMessage = null;
  
  private void validateWill(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null))
    {
      MqttTopic.validate(paramString, false);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public int getConnectionTimeout()
  {
    return this.connectionTimeout;
  }
  
  public Properties getCustomWebSocketHeaders()
  {
    return this.customWebSocketHeaders;
  }
  
  public Properties getDebug()
  {
    Properties localProperties = new Properties();
    localProperties.put("MqttVersion", Integer.valueOf(getMqttVersion()));
    localProperties.put("CleanSession", Boolean.valueOf(isCleanSession()));
    localProperties.put("ConTimeout", Integer.valueOf(getConnectionTimeout()));
    localProperties.put("KeepAliveInterval", Integer.valueOf(getKeepAliveInterval()));
    String str;
    if (getUserName() == null) {
      str = "null";
    } else {
      str = getUserName();
    }
    localProperties.put("UserName", str);
    if (getWillDestination() == null) {
      str = "null";
    } else {
      str = getWillDestination();
    }
    localProperties.put("WillDestination", str);
    if (getSocketFactory() == null) {
      localProperties.put("SocketFactory", "null");
    } else {
      localProperties.put("SocketFactory", getSocketFactory());
    }
    if (getSSLProperties() == null) {
      localProperties.put("SSLProperties", "null");
    } else {
      localProperties.put("SSLProperties", getSSLProperties());
    }
    return localProperties;
  }
  
  public int getExecutorServiceTimeout()
  {
    return this.executorServiceTimeout;
  }
  
  public int getKeepAliveInterval()
  {
    return this.keepAliveInterval;
  }
  
  public int getMaxInflight()
  {
    return this.maxInflight;
  }
  
  public int getMaxReconnectDelay()
  {
    return this.maxReconnectDelay;
  }
  
  public int getMqttVersion()
  {
    return this.mqttVersion;
  }
  
  public char[] getPassword()
  {
    return this.password;
  }
  
  public HostnameVerifier getSSLHostnameVerifier()
  {
    return this.sslHostnameVerifier;
  }
  
  public Properties getSSLProperties()
  {
    return this.sslClientProps;
  }
  
  public String[] getServerURIs()
  {
    return this.serverURIs;
  }
  
  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public String getWillDestination()
  {
    return this.willDestination;
  }
  
  public MqttMessage getWillMessage()
  {
    return this.willMessage;
  }
  
  public boolean isAutomaticReconnect()
  {
    return this.automaticReconnect;
  }
  
  public boolean isCleanSession()
  {
    return this.cleanSession;
  }
  
  public boolean isHttpsHostnameVerificationEnabled()
  {
    return this.httpsHostnameVerificationEnabled;
  }
  
  public void setAutomaticReconnect(boolean paramBoolean)
  {
    this.automaticReconnect = paramBoolean;
  }
  
  public void setCleanSession(boolean paramBoolean)
  {
    this.cleanSession = paramBoolean;
  }
  
  public void setConnectionTimeout(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.connectionTimeout = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void setCustomWebSocketHeaders(Properties paramProperties)
  {
    this.customWebSocketHeaders = paramProperties;
  }
  
  public void setExecutorServiceTimeout(int paramInt)
  {
    this.executorServiceTimeout = paramInt;
  }
  
  public void setHttpsHostnameVerificationEnabled(boolean paramBoolean)
  {
    this.httpsHostnameVerificationEnabled = paramBoolean;
  }
  
  public void setKeepAliveInterval(int paramInt)
    throws IllegalArgumentException
  {
    if (paramInt >= 0)
    {
      this.keepAliveInterval = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void setMaxInflight(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.maxInflight = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void setMaxReconnectDelay(int paramInt)
  {
    this.maxReconnectDelay = paramInt;
  }
  
  public void setMqttVersion(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt != 0) && (paramInt != 3) && (paramInt != 4))
    {
      StringBuilder localStringBuilder = new StringBuilder("An incorrect version was used \"");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("\". Acceptable version options are ");
      localStringBuilder.append(0);
      localStringBuilder.append(", ");
      localStringBuilder.append(3);
      localStringBuilder.append(" and ");
      localStringBuilder.append(4);
      localStringBuilder.append(".");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.mqttVersion = paramInt;
  }
  
  public void setPassword(char[] paramArrayOfChar)
  {
    this.password = ((char[])paramArrayOfChar.clone());
  }
  
  public void setSSLHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.sslHostnameVerifier = paramHostnameVerifier;
  }
  
  public void setSSLProperties(Properties paramProperties)
  {
    this.sslClientProps = paramProperties;
  }
  
  public void setServerURIs(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        this.serverURIs = ((String[])paramArrayOfString.clone());
        return;
      }
      NetworkModuleService.validateURI(paramArrayOfString[j]);
    }
  }
  
  public void setSocketFactory(SocketFactory paramSocketFactory)
  {
    this.socketFactory = paramSocketFactory;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
  
  protected void setWill(String paramString, MqttMessage paramMqttMessage, int paramInt, boolean paramBoolean)
  {
    this.willDestination = paramString;
    this.willMessage = paramMqttMessage;
    paramMqttMessage.setQos(paramInt);
    this.willMessage.setRetained(paramBoolean);
    this.willMessage.setMutable(false);
  }
  
  public void setWill(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    validateWill(paramString, paramArrayOfByte);
    setWill(paramString, new MqttMessage(paramArrayOfByte), paramInt, paramBoolean);
  }
  
  public void setWill(MqttTopic paramMqttTopic, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramMqttTopic = paramMqttTopic.getName();
    validateWill(paramMqttTopic, paramArrayOfByte);
    setWill(paramMqttTopic, new MqttMessage(paramArrayOfByte), paramInt, paramBoolean);
  }
  
  public String toString()
  {
    return Debug.dumpProperties(getDebug(), "Connection options");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttConnectOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
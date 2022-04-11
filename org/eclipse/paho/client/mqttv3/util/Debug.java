package org.eclipse.paho.client.mqttv3.util;

import java.util.Enumeration;
import java.util.Properties;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.internal.ClientState;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class Debug
{
  private static final String CLASS_NAME = ClientComms.class.getName();
  private static final String lineSep = System.getProperty("line.separator", "\n");
  private static final String separator = "==============";
  private String clientID;
  private ClientComms comms;
  private Logger log;
  
  public Debug(String paramString, ClientComms paramClientComms)
  {
    Logger localLogger = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
    this.log = localLogger;
    this.clientID = paramString;
    this.comms = paramClientComms;
    localLogger.setResourceName(paramString);
  }
  
  public static String dumpProperties(Properties paramProperties, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Enumeration localEnumeration = paramProperties.propertyNames();
    String str = lineSep;
    Object localObject = new StringBuilder(String.valueOf(str));
    ((StringBuilder)localObject).append("==============");
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append("==============");
    ((StringBuilder)localObject).append(str);
    localStringBuffer.append(((StringBuilder)localObject).toString());
    for (;;)
    {
      if (!localEnumeration.hasMoreElements())
      {
        paramProperties = new StringBuilder("==========================================");
        paramProperties.append(lineSep);
        localStringBuffer.append(paramProperties.toString());
        return localStringBuffer.toString();
      }
      localObject = (String)localEnumeration.nextElement();
      paramString = new StringBuilder(String.valueOf(left((String)localObject, 28, ' ')));
      paramString.append(":  ");
      paramString.append(paramProperties.get(localObject));
      paramString.append(lineSep);
      localStringBuffer.append(paramString.toString());
    }
  }
  
  public static String left(String paramString, int paramInt, char paramChar)
  {
    if (paramString.length() >= paramInt) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    localStringBuffer.append(paramString);
    paramInt -= paramString.length();
    for (;;)
    {
      paramInt--;
      if (paramInt < 0) {
        return localStringBuffer.toString();
      }
      localStringBuffer.append(paramChar);
    }
  }
  
  public void dumpBaseDebug()
  {
    dumpVersion();
    dumpSystemProperties();
    dumpMemoryTrace();
  }
  
  public void dumpClientComms()
  {
    Object localObject = this.comms;
    if (localObject != null)
    {
      localObject = ((ClientComms)localObject).getDebug();
      Logger localLogger = this.log;
      String str = CLASS_NAME;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.clientID));
      localStringBuilder.append(" : ClientComms");
      localLogger.fine(str, "dumpClientComms", dumpProperties((Properties)localObject, localStringBuilder.toString()).toString());
    }
  }
  
  public void dumpClientDebug()
  {
    dumpClientComms();
    dumpConOptions();
    dumpClientState();
    dumpBaseDebug();
  }
  
  public void dumpClientState()
  {
    Object localObject = this.comms;
    if ((localObject != null) && (((ClientComms)localObject).getClientState() != null))
    {
      Properties localProperties = this.comms.getClientState().getDebug();
      localObject = this.log;
      String str = CLASS_NAME;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.clientID));
      localStringBuilder.append(" : ClientState");
      ((Logger)localObject).fine(str, "dumpClientState", dumpProperties(localProperties, localStringBuilder.toString()).toString());
    }
  }
  
  public void dumpConOptions()
  {
    Object localObject = this.comms;
    if (localObject != null)
    {
      Properties localProperties = ((ClientComms)localObject).getConOptions().getDebug();
      Logger localLogger = this.log;
      localObject = CLASS_NAME;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.clientID));
      localStringBuilder.append(" : Connect Options");
      localLogger.fine((String)localObject, "dumpConOptions", dumpProperties(localProperties, localStringBuilder.toString()).toString());
    }
  }
  
  protected void dumpMemoryTrace()
  {
    this.log.dumpTrace();
  }
  
  public void dumpSystemProperties()
  {
    Properties localProperties = System.getProperties();
    this.log.fine(CLASS_NAME, "dumpSystemProperties", dumpProperties(localProperties, "SystemProperties").toString());
  }
  
  protected void dumpVersion()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = lineSep;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str));
    localStringBuilder.append("==============");
    localStringBuilder.append(" Version Info ");
    localStringBuilder.append("==============");
    localStringBuilder.append(str);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder(String.valueOf(left("Version", 20, ' ')));
    localStringBuilder.append(":  ");
    localStringBuilder.append(ClientComms.VERSION);
    localStringBuilder.append(str);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder(String.valueOf(left("Build Level", 20, ' ')));
    localStringBuilder.append(":  ");
    localStringBuilder.append(ClientComms.BUILD_LEVEL);
    localStringBuilder.append(str);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder("==========================================");
    localStringBuilder.append(str);
    localStringBuffer.append(localStringBuilder.toString());
    this.log.fine(CLASS_NAME, "dumpVersion", localStringBuffer.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\util\Debug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
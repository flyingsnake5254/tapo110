package org.eclipse.paho.client.mqttv3.logging;

import java.lang.reflect.Method;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LoggerFactory
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.logging.LoggerFactory";
  public static final String MQTT_CLIENT_MSG_CAT = "org.eclipse.paho.client.mqttv3.internal.nls.logcat";
  private static String jsr47LoggerClassName = JSR47Logger.class.getName();
  private static String overrideloggerClassName;
  
  public static Logger getLogger(String paramString1, String paramString2)
  {
    String str1 = overrideloggerClassName;
    String str2 = str1;
    if (str1 == null) {
      str2 = jsr47LoggerClassName;
    }
    paramString1 = getLogger(str2, ResourceBundle.getBundle(paramString1), paramString2, null);
    if (paramString1 != null) {
      return paramString1;
    }
    throw new MissingResourceException("Error locating the logging class", CLASS_NAME, paramString2);
  }
  
  private static Logger getLogger(String paramString1, ResourceBundle paramResourceBundle, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = Class.forName(paramString1);
      paramString1 = (Logger)paramString1.newInstance();
      paramString1.initialise(paramResourceBundle, paramString2, paramString3);
      return paramString1;
    }
    catch (NoClassDefFoundError|ClassNotFoundException|IllegalAccessException|InstantiationException|ExceptionInInitializerError|SecurityException paramString1) {}
    return null;
  }
  
  public static String getLoggingProperty(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Class localClass = Class.forName("java.util.logging.LogManager");
      Object localObject2 = localClass.getMethod("getLogManager", new Class[0]).invoke(null, null);
      paramString = (String)localClass.getMethod("getProperty", new Class[] { String.class }).invoke(localObject2, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
  }
  
  public static void setLogger(String paramString)
  {
    overrideloggerClassName = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\logging\LoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
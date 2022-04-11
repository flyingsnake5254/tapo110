package org.eclipse.paho.client.mqttv3;

import java.io.UnsupportedEncodingException;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.internal.Token;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.util.Strings;

public class MqttTopic
{
  private static final int MAX_TOPIC_LEN = 65535;
  private static final int MIN_TOPIC_LEN = 1;
  public static final String MULTI_LEVEL_WILDCARD = "#";
  public static final String MULTI_LEVEL_WILDCARD_PATTERN = "/#";
  private static final char NUL = '\000';
  public static final String SINGLE_LEVEL_WILDCARD = "+";
  public static final String TOPIC_LEVEL_SEPARATOR = "/";
  public static final String TOPIC_WILDCARDS = "#+";
  private ClientComms comms;
  private String name;
  
  public MqttTopic(String paramString, ClientComms paramClientComms)
  {
    this.comms = paramClientComms;
    this.name = paramString;
  }
  
  private MqttPublish createPublish(MqttMessage paramMqttMessage)
  {
    return new MqttPublish(getName(), paramMqttMessage);
  }
  
  public static boolean isMatched(String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    int i = paramString2.length();
    int j = paramString1.length();
    validate(paramString1, true);
    validate(paramString2, false);
    if (paramString1.equals(paramString2)) {
      return true;
    }
    int k = 0;
    int n;
    int i1;
    for (int m = 0;; m = n + 1)
    {
      n = k;
      i1 = m;
      if (k >= j) {
        break;
      }
      if (m >= i)
      {
        n = k;
        i1 = m;
        break;
      }
      if (paramString1.charAt(k) == '#')
      {
        i1 = i;
        n = j;
        break;
      }
      if ((paramString2.charAt(m) == '/') && (paramString1.charAt(k) != '/'))
      {
        n = k;
        i1 = m;
        break;
      }
      if ((paramString1.charAt(k) != '+') && (paramString1.charAt(k) != '#') && (paramString1.charAt(k) != paramString2.charAt(m)))
      {
        n = k;
        i1 = m;
        break;
      }
      n = m;
      if (paramString1.charAt(k) == '+') {
        for (;;)
        {
          i1 = m + 1;
          n = m;
          if (i1 >= i) {
            break;
          }
          if (paramString2.charAt(i1) == '/')
          {
            n = m;
            break;
          }
          m++;
        }
      }
      k++;
    }
    if ((i1 == i) && (n == j)) {
      return true;
    }
    if ((paramString1.length() - n > 0) && (i1 == i))
    {
      if ((paramString2.charAt(i1 - 1) == '/') && (paramString1.charAt(n) == '#')) {
        return true;
      }
      if ((paramString1.length() - n > 1) && (paramString1.substring(n, n + 2).equals("/#"))) {
        return true;
      }
    }
    return false;
  }
  
  public static void validate(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      if ((i >= 1) && (i <= 65535))
      {
        if (paramBoolean)
        {
          if (Strings.equalsAny(paramString, new String[] { "#", "+" })) {
            return;
          }
          if ((Strings.countMatches(paramString, "#") <= 1) && ((!paramString.contains("#")) || (paramString.endsWith("/#"))))
          {
            validateSingleLevelWildcard(paramString);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder("Invalid usage of multi-level wildcard in topic string: ");
          localStringBuilder.append(paramString);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        if (!Strings.containsAny(paramString, "#+")) {
          return;
        }
        throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
      }
      throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Object[] { Integer.valueOf(1), Integer.valueOf(65535) }));
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException(paramString.getMessage());
    }
  }
  
  private static void validateSingleLevelWildcard(String paramString)
  {
    int i = "+".charAt(0);
    int j = "/".charAt(0);
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length;
    int i1;
    for (int m = 0;; m = i1)
    {
      if (m >= k) {
        return;
      }
      int n = m - 1;
      if (n >= 0) {
        n = arrayOfChar[n];
      } else {
        n = 0;
      }
      i1 = m + 1;
      int i2;
      if (i1 < k) {
        i2 = arrayOfChar[i1];
      } else {
        i2 = 0;
      }
      if ((arrayOfChar[m] == i) && (((n != j) && (n != 0)) || ((i2 != j) && (i2 != 0)))) {
        throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", new Object[] { paramString }));
      }
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public MqttDeliveryToken publish(MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException
  {
    MqttDeliveryToken localMqttDeliveryToken = new MqttDeliveryToken(this.comms.getClient().getClientId());
    localMqttDeliveryToken.setMessage(paramMqttMessage);
    this.comms.sendNoWait(createPublish(paramMqttMessage), localMqttDeliveryToken);
    localMqttDeliveryToken.internalTok.waitUntilSent();
    return localMqttDeliveryToken;
  }
  
  public MqttDeliveryToken publish(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException
  {
    paramArrayOfByte = new MqttMessage(paramArrayOfByte);
    paramArrayOfByte.setQos(paramInt);
    paramArrayOfByte.setRetained(paramBoolean);
    return publish(paramArrayOfByte);
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttTopic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.eclipse.paho.client.mqttv3.internal.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.logging.Logger;

public class SSLSocketFactoryFactory
{
  public static final String CIPHERSUITES = "com.ibm.ssl.enabledCipherSuites";
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory";
  public static final String CLIENTAUTH = "com.ibm.ssl.clientAuthentication";
  public static final String DEFAULT_PROTOCOL = "TLS";
  public static final String JSSEPROVIDER = "com.ibm.ssl.contextProvider";
  public static final String KEYSTORE = "com.ibm.ssl.keyStore";
  public static final String KEYSTOREMGR = "com.ibm.ssl.keyManager";
  public static final String KEYSTOREPROVIDER = "com.ibm.ssl.keyStoreProvider";
  public static final String KEYSTOREPWD = "com.ibm.ssl.keyStorePassword";
  public static final String KEYSTORETYPE = "com.ibm.ssl.keyStoreType";
  public static final String SSLPROTOCOL = "com.ibm.ssl.protocol";
  public static final String SYSKEYMGRALGO = "ssl.KeyManagerFactory.algorithm";
  public static final String SYSKEYSTORE = "javax.net.ssl.keyStore";
  public static final String SYSKEYSTOREPWD = "javax.net.ssl.keyStorePassword";
  public static final String SYSKEYSTORETYPE = "javax.net.ssl.keyStoreType";
  public static final String SYSTRUSTMGRALGO = "ssl.TrustManagerFactory.algorithm";
  public static final String SYSTRUSTSTORE = "javax.net.ssl.trustStore";
  public static final String SYSTRUSTSTOREPWD = "javax.net.ssl.trustStorePassword";
  public static final String SYSTRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
  public static final String TRUSTSTORE = "com.ibm.ssl.trustStore";
  public static final String TRUSTSTOREMGR = "com.ibm.ssl.trustManager";
  public static final String TRUSTSTOREPROVIDER = "com.ibm.ssl.trustStoreProvider";
  public static final String TRUSTSTOREPWD = "com.ibm.ssl.trustStorePassword";
  public static final String TRUSTSTORETYPE = "com.ibm.ssl.trustStoreType";
  private static final byte[] key = { -99, -89, -39, -128, 5, -72, -119, -100 };
  private static final String[] propertyKeys = { "com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication" };
  private static final String xorTag = "{xor}";
  private Hashtable configs = new Hashtable();
  private Properties defaultProperties;
  private Logger logger = null;
  
  public SSLSocketFactoryFactory() {}
  
  public SSLSocketFactoryFactory(Logger paramLogger)
  {
    this();
  }
  
  private void checkPropertyKeys(Properties paramProperties)
    throws IllegalArgumentException
  {
    paramProperties = paramProperties.keySet().iterator();
    String str;
    do
    {
      if (!paramProperties.hasNext()) {
        return;
      }
      str = (String)paramProperties.next();
    } while (keyValid(str));
    paramProperties = new StringBuilder(String.valueOf(str));
    paramProperties.append(" is not a valid IBM SSL property key.");
    throw new IllegalArgumentException(paramProperties.toString());
  }
  
  private void convertPassword(Properties paramProperties)
  {
    String str = paramProperties.getProperty("com.ibm.ssl.keyStorePassword");
    if ((str != null) && (!str.startsWith("{xor}"))) {
      paramProperties.put("com.ibm.ssl.keyStorePassword", obfuscate(str.toCharArray()));
    }
    str = paramProperties.getProperty("com.ibm.ssl.trustStorePassword");
    if ((str != null) && (!str.startsWith("{xor}"))) {
      paramProperties.put("com.ibm.ssl.trustStorePassword", obfuscate(str.toCharArray()));
    }
  }
  
  public static char[] deObfuscate(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = SimpleBase64Encoder.decode(paramString.substring(5));
      for (int i = 0;; i++)
      {
        if (i >= paramString.length) {
          return toChar(paramString);
        }
        int j = paramString[i];
        byte[] arrayOfByte = key;
        paramString[i] = ((byte)(byte)((j ^ arrayOfByte[(i % arrayOfByte.length)]) & 0xFF));
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  private String getProperty(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getPropertyFromConfig(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1;
    }
    if (paramString3 != null) {
      paramString1 = System.getProperty(paramString3);
    }
    return paramString1;
  }
  
  private String getPropertyFromConfig(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    if (paramString1 != null) {
      localObject2 = (Properties)this.configs.get(paramString1);
    } else {
      localObject2 = null;
    }
    paramString1 = (String)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((Properties)localObject2).getProperty(paramString2);
      paramString1 = (String)localObject2;
      if (localObject2 != null) {
        return (String)localObject2;
      }
    }
    Object localObject2 = this.defaultProperties;
    if (localObject2 != null)
    {
      paramString2 = ((Properties)localObject2).getProperty(paramString2);
      paramString1 = paramString2;
      if (paramString2 == null) {}
    }
    return paramString1;
  }
  
  private SSLContext getSSLContext(String paramString)
    throws MqttSecurityException
  {
    Object localObject1 = paramString;
    Object localObject2 = getSSLProtocol(paramString);
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = "TLS";
    }
    Object localObject4 = this.logger;
    if (localObject4 != null)
    {
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = "null (broker defaults)";
      }
      ((Logger)localObject4).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12000", new Object[] { localObject2, localObject3 });
    }
    localObject2 = getJSSEProvider(paramString);
    if (localObject2 == null) {}
    try
    {
      localObject4 = SSLContext.getInstance((String)localObject3);
      break label96;
      localObject4 = SSLContext.getInstance((String)localObject3, (String)localObject2);
      label96:
      localObject2 = this.logger;
      if (localObject2 != null)
      {
        if (localObject1 != null) {
          localObject3 = localObject1;
        } else {
          localObject3 = "null (broker defaults)";
        }
        ((Logger)localObject2).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12001", new Object[] { localObject3, ((SSLContext)localObject4).getProvider().getName() });
      }
      localObject2 = getProperty((String)localObject1, "com.ibm.ssl.keyStore", null);
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = getProperty((String)localObject1, "com.ibm.ssl.keyStore", "javax.net.ssl.keyStore");
      }
      Object localObject5 = this.logger;
      Object localObject6 = "null";
      if (localObject5 != null)
      {
        if (localObject1 != null) {
          localObject2 = localObject1;
        } else {
          localObject2 = "null (broker defaults)";
        }
        if (localObject3 != null) {
          localObject7 = localObject3;
        } else {
          localObject7 = "null";
        }
        ((Logger)localObject5).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12004", new Object[] { localObject2, localObject7 });
      }
      Object localObject8 = getKeyStorePassword(paramString);
      localObject5 = this.logger;
      if (localObject5 != null)
      {
        if (localObject1 != null) {
          localObject2 = localObject1;
        } else {
          localObject2 = "null (broker defaults)";
        }
        if (localObject8 != null) {
          localObject7 = obfuscate((char[])localObject8);
        } else {
          localObject7 = "null";
        }
        ((Logger)localObject5).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12005", new Object[] { localObject2, localObject7 });
      }
      Object localObject7 = getKeyStoreType(paramString);
      localObject2 = localObject7;
      if (localObject7 == null) {
        localObject2 = KeyStore.getDefaultType();
      }
      Object localObject9 = this.logger;
      if (localObject9 != null)
      {
        if (localObject1 != null) {
          localObject7 = localObject1;
        } else {
          localObject7 = "null (broker defaults)";
        }
        if (localObject2 != null) {
          localObject5 = localObject2;
        } else {
          localObject5 = "null";
        }
        ((Logger)localObject9).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12006", new Object[] { localObject7, localObject5 });
      }
      localObject7 = KeyManagerFactory.getDefaultAlgorithm();
      localObject9 = getKeyStoreProvider(paramString);
      localObject5 = getKeyManager(paramString);
      if (localObject5 != null) {
        localObject7 = localObject5;
      }
      if ((localObject3 != null) && (localObject2 != null) && (localObject7 != null)) {
        try
        {
          localObject5 = KeyStore.getInstance((String)localObject2);
          localObject2 = new java/io/FileInputStream;
          ((FileInputStream)localObject2).<init>((String)localObject3);
          ((KeyStore)localObject5).load((InputStream)localObject2, (char[])localObject8);
          if (localObject9 != null) {
            localObject3 = KeyManagerFactory.getInstance((String)localObject7, (String)localObject9);
          } else {
            localObject3 = KeyManagerFactory.getInstance((String)localObject7);
          }
          localObject9 = this.logger;
          if (localObject9 != null)
          {
            if (localObject1 != null) {
              localObject2 = localObject1;
            } else {
              localObject2 = "null (broker defaults)";
            }
            ((Logger)localObject9).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12010", new Object[] { localObject2, localObject7 });
            localObject7 = this.logger;
            if (localObject1 != null) {
              localObject2 = localObject1;
            } else {
              localObject2 = "null (broker defaults)";
            }
            ((Logger)localObject7).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12009", new Object[] { localObject2, ((KeyManagerFactory)localObject3).getProvider().getName() });
          }
          ((KeyManagerFactory)localObject3).init((KeyStore)localObject5, (char[])localObject8);
          localObject2 = ((KeyManagerFactory)localObject3).getKeyManagers();
        }
        catch (UnrecoverableKeyException paramString)
        {
          localObject1 = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          ((MqttSecurityException)localObject1).<init>(paramString);
          throw ((Throwable)localObject1);
        }
        catch (IOException localIOException1)
        {
          paramString = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          paramString.<init>(localIOException1);
          throw paramString;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          paramString = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          paramString.<init>(localFileNotFoundException);
          throw paramString;
        }
        catch (CertificateException paramString)
        {
          MqttSecurityException localMqttSecurityException1 = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          localMqttSecurityException1.<init>(paramString);
          throw localMqttSecurityException1;
        }
        catch (KeyStoreException localKeyStoreException)
        {
          paramString = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          paramString.<init>(localKeyStoreException);
          throw paramString;
        }
      }
      localObject2 = null;
      localObject8 = getTrustStore(paramString);
      localObject5 = this.logger;
      if (localObject5 != null)
      {
        if (localKeyStoreException != null) {
          localObject3 = localKeyStoreException;
        } else {
          localObject3 = "null (broker defaults)";
        }
        if (localObject8 != null) {
          localObject7 = localObject8;
        } else {
          localObject7 = "null";
        }
        ((Logger)localObject5).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12011", new Object[] { localObject3, localObject7 });
      }
      localObject9 = getTrustStorePassword(paramString);
      localObject5 = this.logger;
      if (localObject5 != null)
      {
        if (localKeyStoreException != null) {
          localObject3 = localKeyStoreException;
        } else {
          localObject3 = "null (broker defaults)";
        }
        if (localObject9 != null) {
          localObject7 = obfuscate((char[])localObject9);
        } else {
          localObject7 = "null";
        }
        ((Logger)localObject5).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12012", new Object[] { localObject3, localObject7 });
      }
      localObject7 = getTrustStoreType(paramString);
      localObject3 = localObject7;
      if (localObject7 == null) {
        localObject3 = KeyStore.getDefaultType();
      }
      Logger localLogger = this.logger;
      if (localLogger != null)
      {
        if (localKeyStoreException != null) {
          localObject7 = localKeyStoreException;
        } else {
          localObject7 = "null (broker defaults)";
        }
        localObject5 = localObject6;
        if (localObject3 != null) {
          localObject5 = localObject3;
        }
        localLogger.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12013", new Object[] { localObject7, localObject5 });
      }
      localObject5 = TrustManagerFactory.getDefaultAlgorithm();
      localObject6 = getTrustStoreProvider(paramString);
      localObject7 = getTrustManager(paramString);
      paramString = (String)localObject5;
      if (localObject7 != null) {
        paramString = (String)localObject7;
      }
      if ((localObject8 != null) && (localObject3 != null) && (paramString != null)) {
        try
        {
          localObject5 = KeyStore.getInstance((String)localObject3);
          localObject3 = new java/io/FileInputStream;
          ((FileInputStream)localObject3).<init>((String)localObject8);
          ((KeyStore)localObject5).load((InputStream)localObject3, (char[])localObject9);
          if (localObject6 != null) {
            localObject3 = TrustManagerFactory.getInstance(paramString, (String)localObject6);
          } else {
            localObject3 = TrustManagerFactory.getInstance(paramString);
          }
          localObject6 = this.logger;
          if (localObject6 != null)
          {
            if (localKeyStoreException != null) {
              localObject7 = localKeyStoreException;
            } else {
              localObject7 = "null (broker defaults)";
            }
            ((Logger)localObject6).fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12017", new Object[] { localObject7, paramString });
            paramString = this.logger;
            String str;
            if (localKeyStoreException == null) {
              str = "null (broker defaults)";
            }
            paramString.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "getSSLContext", "12016", new Object[] { str, ((TrustManagerFactory)localObject3).getProvider().getName() });
          }
          ((TrustManagerFactory)localObject3).init((KeyStore)localObject5);
          paramString = ((TrustManagerFactory)localObject3).getTrustManagers();
        }
        catch (IOException localIOException2)
        {
          paramString = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          paramString.<init>(localIOException2);
          throw paramString;
        }
        catch (FileNotFoundException paramString)
        {
          localMqttSecurityException2 = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          localMqttSecurityException2.<init>(paramString);
          throw localMqttSecurityException2;
        }
        catch (CertificateException paramString)
        {
          localMqttSecurityException2 = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          localMqttSecurityException2.<init>(paramString);
          throw localMqttSecurityException2;
        }
        catch (KeyStoreException paramString)
        {
          MqttSecurityException localMqttSecurityException2 = new org/eclipse/paho/client/mqttv3/MqttSecurityException;
          localMqttSecurityException2.<init>(paramString);
          throw localMqttSecurityException2;
        }
      }
      paramString = null;
      ((SSLContext)localObject4).init((KeyManager[])localObject2, paramString, null);
      return (SSLContext)localObject4;
    }
    catch (KeyManagementException paramString)
    {
      throw new MqttSecurityException(paramString);
    }
    catch (NoSuchProviderException paramString)
    {
      throw new MqttSecurityException(paramString);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new MqttSecurityException(paramString);
    }
  }
  
  public static boolean isSupportedOnJVM()
    throws LinkageError, ExceptionInInitializerError
  {
    try
    {
      Class.forName("javax.net.ssl.SSLServerSocketFactory");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private boolean keyValid(String paramString)
  {
    for (int i = 0;; i++)
    {
      String[] arrayOfString = propertyKeys;
      if ((i >= arrayOfString.length) || (arrayOfString[i].equals(paramString))) {
        return i < arrayOfString.length;
      }
    }
  }
  
  public static String obfuscate(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    paramArrayOfChar = toByte(paramArrayOfChar);
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfChar.length)
      {
        localObject = new StringBuilder("{xor}");
        ((StringBuilder)localObject).append(new String(SimpleBase64Encoder.encode(paramArrayOfChar)));
        return ((StringBuilder)localObject).toString();
      }
      int j = paramArrayOfChar[i];
      Object localObject = key;
      paramArrayOfChar[i] = ((byte)(byte)((j ^ localObject[(i % localObject.length)]) & 0xFF));
    }
  }
  
  public static String packCipherSuites(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0;; i++)
      {
        if (i >= paramArrayOfString.length)
        {
          paramArrayOfString = localStringBuffer.toString();
          break;
        }
        localStringBuffer.append(paramArrayOfString[i]);
        if (i < paramArrayOfString.length - 1) {
          localStringBuffer.append(',');
        }
      }
    }
    paramArrayOfString = null;
    return paramArrayOfString;
  }
  
  public static byte[] toByte(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfChar.length * 2];
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramArrayOfChar.length) {
        return arrayOfByte;
      }
      int k = j + 1;
      arrayOfByte[j] = ((byte)(byte)(paramArrayOfChar[i] & 0xFF));
      j = k + 1;
      arrayOfByte[k] = ((byte)(byte)(paramArrayOfChar[i] >> '\b' & 0xFF));
      i++;
    }
  }
  
  public static char[] toChar(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length / 2];
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return arrayOfChar;
      }
      int k = i + 1;
      arrayOfChar[j] = ((char)(char)((paramArrayOfByte[i] & 0xFF) + ((paramArrayOfByte[k] & 0xFF) << 8)));
      j++;
      i = k + 1;
    }
  }
  
  public static String[] unpackCipherSuites(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Vector localVector = new Vector();
    int i = paramString.indexOf(',');
    int j = 0;
    for (;;)
    {
      if (i <= -1)
      {
        localVector.add(paramString.substring(j));
        paramString = new String[localVector.size()];
        localVector.toArray(paramString);
        return paramString;
      }
      localVector.add(paramString.substring(j, i));
      j = i + 1;
      i = paramString.indexOf(',', j);
    }
  }
  
  public SSLSocketFactory createSocketFactory(String paramString)
    throws MqttSecurityException
  {
    SSLContext localSSLContext = getSSLContext(paramString);
    Logger localLogger = this.logger;
    if (localLogger != null)
    {
      String str;
      if (paramString != null) {
        str = paramString;
      } else {
        str = "null (broker defaults)";
      }
      if (getEnabledCipherSuites(paramString) != null) {
        paramString = getProperty(paramString, "com.ibm.ssl.enabledCipherSuites", null);
      } else {
        paramString = "null (using platform-enabled cipher suites)";
      }
      localLogger.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "createSocketFactory", "12020", new Object[] { str, paramString });
    }
    return localSSLContext.getSocketFactory();
  }
  
  public boolean getClientAuthentication(String paramString)
  {
    paramString = getProperty(paramString, "com.ibm.ssl.clientAuthentication", null);
    boolean bool;
    if (paramString != null) {
      bool = Boolean.valueOf(paramString).booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Properties getConfiguration(String paramString)
  {
    if (paramString == null) {
      paramString = this.defaultProperties;
    } else {
      paramString = this.configs.get(paramString);
    }
    return (Properties)paramString;
  }
  
  public String[] getEnabledCipherSuites(String paramString)
  {
    return unpackCipherSuites(getProperty(paramString, "com.ibm.ssl.enabledCipherSuites", null));
  }
  
  public String getJSSEProvider(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.contextProvider", null);
  }
  
  public String getKeyManager(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.keyManager", "ssl.KeyManagerFactory.algorithm");
  }
  
  public String getKeyStore(String paramString)
  {
    paramString = getPropertyFromConfig(paramString, "com.ibm.ssl.keyStore");
    if (paramString != null) {
      return paramString;
    }
    return System.getProperty("javax.net.ssl.keyStore");
  }
  
  public char[] getKeyStorePassword(String paramString)
  {
    paramString = getProperty(paramString, "com.ibm.ssl.keyStorePassword", "javax.net.ssl.keyStorePassword");
    if (paramString != null)
    {
      if (paramString.startsWith("{xor}")) {
        paramString = deObfuscate(paramString);
      } else {
        paramString = paramString.toCharArray();
      }
    }
    else {
      paramString = null;
    }
    return paramString;
  }
  
  public String getKeyStoreProvider(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.keyStoreProvider", null);
  }
  
  public String getKeyStoreType(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.keyStoreType", "javax.net.ssl.keyStoreType");
  }
  
  public String getSSLProtocol(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.protocol", null);
  }
  
  public String getTrustManager(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.trustManager", "ssl.TrustManagerFactory.algorithm");
  }
  
  public String getTrustStore(String paramString)
  {
    paramString = getProperty(paramString, "com.ibm.ssl.trustStore", "javax.net.ssl.trustStore");
    try
    {
      String str = URLDecoder.decode(paramString, StandardCharsets.UTF_8.name());
      paramString = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return paramString;
  }
  
  public char[] getTrustStorePassword(String paramString)
  {
    paramString = getProperty(paramString, "com.ibm.ssl.trustStorePassword", "javax.net.ssl.trustStorePassword");
    if (paramString != null)
    {
      if (paramString.startsWith("{xor}")) {
        paramString = deObfuscate(paramString);
      } else {
        paramString = paramString.toCharArray();
      }
    }
    else {
      paramString = null;
    }
    return paramString;
  }
  
  public String getTrustStoreProvider(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.trustStoreProvider", null);
  }
  
  public String getTrustStoreType(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.trustStoreType", null);
  }
  
  public void initialize(Properties paramProperties, String paramString)
    throws IllegalArgumentException
  {
    checkPropertyKeys(paramProperties);
    Properties localProperties = new Properties();
    localProperties.putAll(paramProperties);
    convertPassword(localProperties);
    if (paramString != null) {
      this.configs.put(paramString, localProperties);
    } else {
      this.defaultProperties = localProperties;
    }
  }
  
  public void merge(Properties paramProperties, String paramString)
    throws IllegalArgumentException
  {
    checkPropertyKeys(paramProperties);
    Properties localProperties1 = this.defaultProperties;
    if (paramString != null) {
      localProperties1 = (Properties)this.configs.get(paramString);
    }
    Properties localProperties2 = localProperties1;
    if (localProperties1 == null) {
      localProperties2 = new Properties();
    }
    convertPassword(paramProperties);
    localProperties2.putAll(paramProperties);
    if (paramString != null) {
      this.configs.put(paramString, localProperties2);
    } else {
      this.defaultProperties = localProperties2;
    }
  }
  
  public boolean remove(String paramString)
  {
    boolean bool = true;
    if (paramString != null)
    {
      if (this.configs.remove(paramString) != null) {
        return bool;
      }
    }
    else if (this.defaultProperties != null)
    {
      this.defaultProperties = null;
      return bool;
    }
    bool = false;
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\security\SSLSocketFactoryFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
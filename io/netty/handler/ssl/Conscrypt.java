package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

final class Conscrypt
{
  private static final boolean CAN_INSTANCE_PROVIDER = canInstanceProvider();
  private static final Method IS_CONSCRYPT_SSLENGINE = ;
  
  private static boolean canInstanceProvider()
  {
    try
    {
      Class.forName("org.conscrypt.OpenSSLProvider", true, ConscryptAlpnSslEngine.class.getClassLoader()).newInstance();
      return true;
    }
    finally {}
    return false;
  }
  
  static boolean isAvailable()
  {
    boolean bool;
    if ((CAN_INSTANCE_PROVIDER) && (IS_CONSCRYPT_SSLENGINE != null) && (((PlatformDependent.javaVersion() >= 8) && (PlatformDependent.javaVersion() < 15)) || (PlatformDependent.isAndroid()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isConscryptEngine(SSLEngine paramSSLEngine)
  {
    try
    {
      boolean bool = ((Boolean)IS_CONSCRYPT_SSLENGINE.invoke(null, new Object[] { paramSSLEngine })).booleanValue();
      return bool;
    }
    catch (InvocationTargetException paramSSLEngine)
    {
      throw new RuntimeException(paramSSLEngine);
    }
    catch (IllegalAccessException paramSSLEngine) {}
    return false;
  }
  
  static boolean isEngineSupported(SSLEngine paramSSLEngine)
  {
    boolean bool;
    if ((isAvailable()) && (isConscryptEngine(paramSSLEngine))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static Method loadIsConscryptEngine()
  {
    try
    {
      Method localMethod = Class.forName("org.conscrypt.Conscrypt", true, ConscryptAlpnSslEngine.class.getClassLoader()).getMethod("isConscrypt", new Class[] { SSLEngine.class });
      return localMethod;
    }
    finally {}
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\Conscrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
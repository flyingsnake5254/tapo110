package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

public class Base64
{
  private static final Base64Encoder encoder;
  private static final Base64 instance;
  
  static
  {
    Base64 localBase64 = new Base64();
    instance = localBase64;
    encoder = new Base64Encoder();
  }
  
  public static String encode(String paramString)
  {
    Base64Encoder localBase64Encoder = encoder;
    localBase64Encoder.putByteArray("akey", paramString.getBytes());
    return localBase64Encoder.getBase64String();
  }
  
  public static String encodeBytes(byte[] paramArrayOfByte)
  {
    Base64Encoder localBase64Encoder = encoder;
    localBase64Encoder.putByteArray("aKey", paramArrayOfByte);
    return localBase64Encoder.getBase64String();
  }
  
  public class Base64Encoder
    extends AbstractPreferences
  {
    private String base64String = null;
    
    public Base64Encoder()
    {
      super("");
    }
    
    protected AbstractPreferences childSpi(String paramString)
    {
      return null;
    }
    
    protected String[] childrenNamesSpi()
      throws BackingStoreException
    {
      return null;
    }
    
    protected void flushSpi()
      throws BackingStoreException
    {}
    
    public String getBase64String()
    {
      return this.base64String;
    }
    
    protected String getSpi(String paramString)
    {
      return null;
    }
    
    protected String[] keysSpi()
      throws BackingStoreException
    {
      return null;
    }
    
    protected void putSpi(String paramString1, String paramString2)
    {
      this.base64String = paramString2;
    }
    
    protected void removeNodeSpi()
      throws BackingStoreException
    {}
    
    protected void removeSpi(String paramString) {}
    
    protected void syncSpi()
      throws BackingStoreException
    {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package okhttp3;

import java.io.IOException;

public enum Protocol
{
  private final String protocol;
  
  static
  {
    Protocol localProtocol1 = new Protocol("HTTP_1_0", 0, "http/1.0");
    HTTP_1_0 = localProtocol1;
    Protocol localProtocol2 = new Protocol("HTTP_1_1", 1, "http/1.1");
    HTTP_1_1 = localProtocol2;
    Protocol localProtocol3 = new Protocol("SPDY_3", 2, "spdy/3.1");
    SPDY_3 = localProtocol3;
    Protocol localProtocol4 = new Protocol("HTTP_2", 3, "h2");
    HTTP_2 = localProtocol4;
    Protocol localProtocol5 = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
    H2_PRIOR_KNOWLEDGE = localProtocol5;
    Protocol localProtocol6 = new Protocol("QUIC", 5, "quic");
    QUIC = localProtocol6;
    $VALUES = new Protocol[] { localProtocol1, localProtocol2, localProtocol3, localProtocol4, localProtocol5, localProtocol6 };
  }
  
  private Protocol(String paramString)
  {
    this.protocol = paramString;
  }
  
  public static Protocol get(String paramString)
    throws IOException
  {
    Object localObject = HTTP_1_0;
    if (paramString.equals(((Protocol)localObject).protocol)) {
      return (Protocol)localObject;
    }
    localObject = HTTP_1_1;
    if (paramString.equals(((Protocol)localObject).protocol)) {
      return (Protocol)localObject;
    }
    localObject = H2_PRIOR_KNOWLEDGE;
    if (paramString.equals(((Protocol)localObject).protocol)) {
      return (Protocol)localObject;
    }
    localObject = HTTP_2;
    if (paramString.equals(((Protocol)localObject).protocol)) {
      return (Protocol)localObject;
    }
    localObject = SPDY_3;
    if (paramString.equals(((Protocol)localObject).protocol)) {
      return (Protocol)localObject;
    }
    localObject = QUIC;
    if (paramString.equals(((Protocol)localObject).protocol)) {
      return (Protocol)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected protocol: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    return this.protocol;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
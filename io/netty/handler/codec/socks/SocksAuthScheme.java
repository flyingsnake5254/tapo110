package io.netty.handler.codec.socks;

public enum SocksAuthScheme
{
  private final byte b;
  
  static
  {
    SocksAuthScheme localSocksAuthScheme1 = new SocksAuthScheme("NO_AUTH", 0, (byte)0);
    NO_AUTH = localSocksAuthScheme1;
    SocksAuthScheme localSocksAuthScheme2 = new SocksAuthScheme("AUTH_GSSAPI", 1, (byte)1);
    AUTH_GSSAPI = localSocksAuthScheme2;
    SocksAuthScheme localSocksAuthScheme3 = new SocksAuthScheme("AUTH_PASSWORD", 2, (byte)2);
    AUTH_PASSWORD = localSocksAuthScheme3;
    SocksAuthScheme localSocksAuthScheme4 = new SocksAuthScheme("UNKNOWN", 3, (byte)-1);
    UNKNOWN = localSocksAuthScheme4;
    $VALUES = new SocksAuthScheme[] { localSocksAuthScheme1, localSocksAuthScheme2, localSocksAuthScheme3, localSocksAuthScheme4 };
  }
  
  private SocksAuthScheme(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  @Deprecated
  public static SocksAuthScheme fromByte(byte paramByte)
  {
    return valueOf(paramByte);
  }
  
  public static SocksAuthScheme valueOf(byte paramByte)
  {
    for (SocksAuthScheme localSocksAuthScheme : ) {
      if (localSocksAuthScheme.b == paramByte) {
        return localSocksAuthScheme;
      }
    }
    return UNKNOWN;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksAuthScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.handler.codec.socks;

public enum SocksSubnegotiationVersion
{
  private final byte b;
  
  static
  {
    SocksSubnegotiationVersion localSocksSubnegotiationVersion1 = new SocksSubnegotiationVersion("AUTH_PASSWORD", 0, (byte)1);
    AUTH_PASSWORD = localSocksSubnegotiationVersion1;
    SocksSubnegotiationVersion localSocksSubnegotiationVersion2 = new SocksSubnegotiationVersion("UNKNOWN", 1, (byte)-1);
    UNKNOWN = localSocksSubnegotiationVersion2;
    $VALUES = new SocksSubnegotiationVersion[] { localSocksSubnegotiationVersion1, localSocksSubnegotiationVersion2 };
  }
  
  private SocksSubnegotiationVersion(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  @Deprecated
  public static SocksSubnegotiationVersion fromByte(byte paramByte)
  {
    return valueOf(paramByte);
  }
  
  public static SocksSubnegotiationVersion valueOf(byte paramByte)
  {
    for (SocksSubnegotiationVersion localSocksSubnegotiationVersion : ) {
      if (localSocksSubnegotiationVersion.b == paramByte) {
        return localSocksSubnegotiationVersion;
      }
    }
    return UNKNOWN;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksSubnegotiationVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
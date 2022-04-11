package io.netty.handler.codec.socks;

public enum SocksProtocolVersion
{
  private final byte b;
  
  static
  {
    SocksProtocolVersion localSocksProtocolVersion1 = new SocksProtocolVersion("SOCKS4a", 0, (byte)4);
    SOCKS4a = localSocksProtocolVersion1;
    SocksProtocolVersion localSocksProtocolVersion2 = new SocksProtocolVersion("SOCKS5", 1, (byte)5);
    SOCKS5 = localSocksProtocolVersion2;
    SocksProtocolVersion localSocksProtocolVersion3 = new SocksProtocolVersion("UNKNOWN", 2, (byte)-1);
    UNKNOWN = localSocksProtocolVersion3;
    $VALUES = new SocksProtocolVersion[] { localSocksProtocolVersion1, localSocksProtocolVersion2, localSocksProtocolVersion3 };
  }
  
  private SocksProtocolVersion(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  @Deprecated
  public static SocksProtocolVersion fromByte(byte paramByte)
  {
    return valueOf(paramByte);
  }
  
  public static SocksProtocolVersion valueOf(byte paramByte)
  {
    for (SocksProtocolVersion localSocksProtocolVersion : ) {
      if (localSocksProtocolVersion.b == paramByte) {
        return localSocksProtocolVersion;
      }
    }
    return UNKNOWN;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksProtocolVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
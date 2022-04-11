package io.netty.handler.codec.socksx;

public enum SocksVersion
{
  private final byte b;
  
  static
  {
    SocksVersion localSocksVersion1 = new SocksVersion("SOCKS4a", 0, (byte)4);
    SOCKS4a = localSocksVersion1;
    SocksVersion localSocksVersion2 = new SocksVersion("SOCKS5", 1, (byte)5);
    SOCKS5 = localSocksVersion2;
    SocksVersion localSocksVersion3 = new SocksVersion("UNKNOWN", 2, (byte)-1);
    UNKNOWN = localSocksVersion3;
    $VALUES = new SocksVersion[] { localSocksVersion1, localSocksVersion2, localSocksVersion3 };
  }
  
  private SocksVersion(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  public static SocksVersion valueOf(byte paramByte)
  {
    SocksVersion localSocksVersion = SOCKS4a;
    if (paramByte == localSocksVersion.byteValue()) {
      return localSocksVersion;
    }
    localSocksVersion = SOCKS5;
    if (paramByte == localSocksVersion.byteValue()) {
      return localSocksVersion;
    }
    return UNKNOWN;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\SocksVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
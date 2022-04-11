package io.netty.handler.codec.socks;

public enum SocksAddressType
{
  private final byte b;
  
  static
  {
    SocksAddressType localSocksAddressType1 = new SocksAddressType("IPv4", 0, (byte)1);
    IPv4 = localSocksAddressType1;
    SocksAddressType localSocksAddressType2 = new SocksAddressType("DOMAIN", 1, (byte)3);
    DOMAIN = localSocksAddressType2;
    SocksAddressType localSocksAddressType3 = new SocksAddressType("IPv6", 2, (byte)4);
    IPv6 = localSocksAddressType3;
    SocksAddressType localSocksAddressType4 = new SocksAddressType("UNKNOWN", 3, (byte)-1);
    UNKNOWN = localSocksAddressType4;
    $VALUES = new SocksAddressType[] { localSocksAddressType1, localSocksAddressType2, localSocksAddressType3, localSocksAddressType4 };
  }
  
  private SocksAddressType(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  @Deprecated
  public static SocksAddressType fromByte(byte paramByte)
  {
    return valueOf(paramByte);
  }
  
  public static SocksAddressType valueOf(byte paramByte)
  {
    for (SocksAddressType localSocksAddressType : ) {
      if (localSocksAddressType.b == paramByte) {
        return localSocksAddressType;
      }
    }
    return UNKNOWN;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksAddressType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
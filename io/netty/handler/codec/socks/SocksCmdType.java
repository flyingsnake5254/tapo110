package io.netty.handler.codec.socks;

public enum SocksCmdType
{
  private final byte b;
  
  static
  {
    SocksCmdType localSocksCmdType1 = new SocksCmdType("CONNECT", 0, (byte)1);
    CONNECT = localSocksCmdType1;
    SocksCmdType localSocksCmdType2 = new SocksCmdType("BIND", 1, (byte)2);
    BIND = localSocksCmdType2;
    SocksCmdType localSocksCmdType3 = new SocksCmdType("UDP", 2, (byte)3);
    UDP = localSocksCmdType3;
    SocksCmdType localSocksCmdType4 = new SocksCmdType("UNKNOWN", 3, (byte)-1);
    UNKNOWN = localSocksCmdType4;
    $VALUES = new SocksCmdType[] { localSocksCmdType1, localSocksCmdType2, localSocksCmdType3, localSocksCmdType4 };
  }
  
  private SocksCmdType(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  @Deprecated
  public static SocksCmdType fromByte(byte paramByte)
  {
    return valueOf(paramByte);
  }
  
  public static SocksCmdType valueOf(byte paramByte)
  {
    for (SocksCmdType localSocksCmdType : ) {
      if (localSocksCmdType.b == paramByte) {
        return localSocksCmdType;
      }
    }
    return UNKNOWN;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksCmdType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
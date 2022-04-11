package io.netty.handler.codec.socks;

public enum SocksCmdStatus
{
  private final byte b;
  
  static
  {
    SocksCmdStatus localSocksCmdStatus1 = new SocksCmdStatus("SUCCESS", 0, (byte)0);
    SUCCESS = localSocksCmdStatus1;
    SocksCmdStatus localSocksCmdStatus2 = new SocksCmdStatus("FAILURE", 1, (byte)1);
    FAILURE = localSocksCmdStatus2;
    SocksCmdStatus localSocksCmdStatus3 = new SocksCmdStatus("FORBIDDEN", 2, (byte)2);
    FORBIDDEN = localSocksCmdStatus3;
    SocksCmdStatus localSocksCmdStatus4 = new SocksCmdStatus("NETWORK_UNREACHABLE", 3, (byte)3);
    NETWORK_UNREACHABLE = localSocksCmdStatus4;
    SocksCmdStatus localSocksCmdStatus5 = new SocksCmdStatus("HOST_UNREACHABLE", 4, (byte)4);
    HOST_UNREACHABLE = localSocksCmdStatus5;
    SocksCmdStatus localSocksCmdStatus6 = new SocksCmdStatus("REFUSED", 5, (byte)5);
    REFUSED = localSocksCmdStatus6;
    SocksCmdStatus localSocksCmdStatus7 = new SocksCmdStatus("TTL_EXPIRED", 6, (byte)6);
    TTL_EXPIRED = localSocksCmdStatus7;
    SocksCmdStatus localSocksCmdStatus8 = new SocksCmdStatus("COMMAND_NOT_SUPPORTED", 7, (byte)7);
    COMMAND_NOT_SUPPORTED = localSocksCmdStatus8;
    SocksCmdStatus localSocksCmdStatus9 = new SocksCmdStatus("ADDRESS_NOT_SUPPORTED", 8, (byte)8);
    ADDRESS_NOT_SUPPORTED = localSocksCmdStatus9;
    SocksCmdStatus localSocksCmdStatus10 = new SocksCmdStatus("UNASSIGNED", 9, (byte)-1);
    UNASSIGNED = localSocksCmdStatus10;
    $VALUES = new SocksCmdStatus[] { localSocksCmdStatus1, localSocksCmdStatus2, localSocksCmdStatus3, localSocksCmdStatus4, localSocksCmdStatus5, localSocksCmdStatus6, localSocksCmdStatus7, localSocksCmdStatus8, localSocksCmdStatus9, localSocksCmdStatus10 };
  }
  
  private SocksCmdStatus(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  @Deprecated
  public static SocksCmdStatus fromByte(byte paramByte)
  {
    return valueOf(paramByte);
  }
  
  public static SocksCmdStatus valueOf(byte paramByte)
  {
    for (SocksCmdStatus localSocksCmdStatus : ) {
      if (localSocksCmdStatus.b == paramByte) {
        return localSocksCmdStatus;
      }
    }
    return UNASSIGNED;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksCmdStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
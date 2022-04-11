package io.netty.handler.codec.socks;

public enum SocksAuthStatus
{
  private final byte b;
  
  static
  {
    SocksAuthStatus localSocksAuthStatus1 = new SocksAuthStatus("SUCCESS", 0, (byte)0);
    SUCCESS = localSocksAuthStatus1;
    SocksAuthStatus localSocksAuthStatus2 = new SocksAuthStatus("FAILURE", 1, (byte)-1);
    FAILURE = localSocksAuthStatus2;
    $VALUES = new SocksAuthStatus[] { localSocksAuthStatus1, localSocksAuthStatus2 };
  }
  
  private SocksAuthStatus(byte paramByte)
  {
    this.b = ((byte)paramByte);
  }
  
  @Deprecated
  public static SocksAuthStatus fromByte(byte paramByte)
  {
    return valueOf(paramByte);
  }
  
  public static SocksAuthStatus valueOf(byte paramByte)
  {
    for (SocksAuthStatus localSocksAuthStatus : ) {
      if (localSocksAuthStatus.b == paramByte) {
        return localSocksAuthStatus;
      }
    }
    return FAILURE;
  }
  
  public byte byteValue()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksAuthStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
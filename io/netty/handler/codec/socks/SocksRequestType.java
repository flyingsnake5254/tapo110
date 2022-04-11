package io.netty.handler.codec.socks;

public enum SocksRequestType
{
  static
  {
    SocksRequestType localSocksRequestType1 = new SocksRequestType("INIT", 0);
    INIT = localSocksRequestType1;
    SocksRequestType localSocksRequestType2 = new SocksRequestType("AUTH", 1);
    AUTH = localSocksRequestType2;
    SocksRequestType localSocksRequestType3 = new SocksRequestType("CMD", 2);
    CMD = localSocksRequestType3;
    SocksRequestType localSocksRequestType4 = new SocksRequestType("UNKNOWN", 3);
    UNKNOWN = localSocksRequestType4;
    $VALUES = new SocksRequestType[] { localSocksRequestType1, localSocksRequestType2, localSocksRequestType3, localSocksRequestType4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksRequestType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
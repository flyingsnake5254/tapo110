package io.netty.handler.codec.socks;

public enum SocksResponseType
{
  static
  {
    SocksResponseType localSocksResponseType1 = new SocksResponseType("INIT", 0);
    INIT = localSocksResponseType1;
    SocksResponseType localSocksResponseType2 = new SocksResponseType("AUTH", 1);
    AUTH = localSocksResponseType2;
    SocksResponseType localSocksResponseType3 = new SocksResponseType("CMD", 2);
    CMD = localSocksResponseType3;
    SocksResponseType localSocksResponseType4 = new SocksResponseType("UNKNOWN", 3);
    UNKNOWN = localSocksResponseType4;
    $VALUES = new SocksResponseType[] { localSocksResponseType1, localSocksResponseType2, localSocksResponseType3, localSocksResponseType4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksResponseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
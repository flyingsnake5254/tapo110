package io.netty.handler.codec.socks;

public enum SocksMessageType
{
  static
  {
    SocksMessageType localSocksMessageType1 = new SocksMessageType("REQUEST", 0);
    REQUEST = localSocksMessageType1;
    SocksMessageType localSocksMessageType2 = new SocksMessageType("RESPONSE", 1);
    RESPONSE = localSocksMessageType2;
    SocksMessageType localSocksMessageType3 = new SocksMessageType("UNKNOWN", 2);
    UNKNOWN = localSocksMessageType3;
    $VALUES = new SocksMessageType[] { localSocksMessageType1, localSocksMessageType2, localSocksMessageType3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksMessageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
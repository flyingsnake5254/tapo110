package io.netty.handler.ssl;

public enum ClientAuth
{
  static
  {
    ClientAuth localClientAuth1 = new ClientAuth("NONE", 0);
    NONE = localClientAuth1;
    ClientAuth localClientAuth2 = new ClientAuth("OPTIONAL", 1);
    OPTIONAL = localClientAuth2;
    ClientAuth localClientAuth3 = new ClientAuth("REQUIRE", 2);
    REQUIRE = localClientAuth3;
    $VALUES = new ClientAuth[] { localClientAuth1, localClientAuth2, localClientAuth3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\ClientAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
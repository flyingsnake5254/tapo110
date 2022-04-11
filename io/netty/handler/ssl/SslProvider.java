package io.netty.handler.ssl;

public enum SslProvider
{
  static
  {
    SslProvider localSslProvider1 = new SslProvider("JDK", 0);
    JDK = localSslProvider1;
    SslProvider localSslProvider2 = new SslProvider("OPENSSL", 1);
    OPENSSL = localSslProvider2;
    SslProvider localSslProvider3 = new SslProvider("OPENSSL_REFCNT", 2);
    OPENSSL_REFCNT = localSslProvider3;
    $VALUES = new SslProvider[] { localSslProvider1, localSslProvider2, localSslProvider3 };
  }
  
  public static boolean isAlpnSupported(SslProvider paramSslProvider)
  {
    int i = 1.$SwitchMap$io$netty$handler$ssl$SslProvider[paramSslProvider.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown SslProvider: ");
        localStringBuilder.append(paramSslProvider);
        throw new Error(localStringBuilder.toString());
      }
      return OpenSsl.isAlpnSupported();
    }
    return JdkAlpnApplicationProtocolNegotiator.isAlpnSupported();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\SslProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
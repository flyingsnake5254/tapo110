package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import java.net.InetSocketAddress;

public final class DnsNameResolverTimeoutException
  extends DnsNameResolverException
{
  private static final long serialVersionUID = -8826717969627131854L;
  
  public DnsNameResolverTimeoutException(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, String paramString)
  {
    super(paramInetSocketAddress, paramDnsQuestion, paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsNameResolverTimeoutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
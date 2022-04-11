package io.netty.resolver.dns.macos;

import io.netty.channel.unix.NativeInetAddress;
import java.net.InetSocketAddress;

final class DnsResolver
{
  private final String domain;
  private final InetSocketAddress[] nameservers;
  private final String options;
  private final int port;
  private final int searchOrder;
  private final String[] searches;
  private final int timeout;
  
  DnsResolver(String paramString1, byte[][] paramArrayOfByte, int paramInt1, String[] paramArrayOfString, String paramString2, int paramInt2, int paramInt3)
  {
    this.domain = paramString1;
    if (paramArrayOfByte == null)
    {
      this.nameservers = new InetSocketAddress[0];
    }
    else
    {
      this.nameservers = new InetSocketAddress[paramArrayOfByte.length];
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        paramString1 = paramArrayOfByte[i];
        this.nameservers[i] = NativeInetAddress.address(paramString1, 0, paramString1.length);
      }
    }
    this.port = paramInt1;
    this.searches = paramArrayOfString;
    this.options = paramString2;
    this.timeout = paramInt2;
    this.searchOrder = paramInt3;
  }
  
  String domain()
  {
    return this.domain;
  }
  
  InetSocketAddress[] nameservers()
  {
    return this.nameservers;
  }
  
  String options()
  {
    return this.options;
  }
  
  int port()
  {
    return this.port;
  }
  
  int searchOrder()
  {
    return this.searchOrder;
  }
  
  String[] searches()
  {
    return this.searches;
  }
  
  int timeout()
  {
    return this.timeout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\macos\DnsResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
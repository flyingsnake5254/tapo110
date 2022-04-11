package io.netty.channel.socket;

import io.netty.util.NetUtil;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public enum InternetProtocolFamily
{
  private final int addressNumber;
  private final Class<? extends InetAddress> addressType;
  private final InetAddress localHost;
  
  static
  {
    InternetProtocolFamily localInternetProtocolFamily1 = new InternetProtocolFamily("IPv4", 0, Inet4Address.class, 1, NetUtil.LOCALHOST4);
    IPv4 = localInternetProtocolFamily1;
    InternetProtocolFamily localInternetProtocolFamily2 = new InternetProtocolFamily("IPv6", 1, Inet6Address.class, 2, NetUtil.LOCALHOST6);
    IPv6 = localInternetProtocolFamily2;
    $VALUES = new InternetProtocolFamily[] { localInternetProtocolFamily1, localInternetProtocolFamily2 };
  }
  
  private InternetProtocolFamily(Class<? extends InetAddress> paramClass, int paramInt, InetAddress paramInetAddress)
  {
    this.addressType = paramClass;
    this.addressNumber = paramInt;
    this.localHost = paramInetAddress;
  }
  
  public static InternetProtocolFamily of(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet4Address)) {
      return IPv4;
    }
    if ((paramInetAddress instanceof Inet6Address)) {
      return IPv6;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("address ");
    localStringBuilder.append(paramInetAddress);
    localStringBuilder.append(" not supported");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int addressNumber()
  {
    return this.addressNumber;
  }
  
  public Class<? extends InetAddress> addressType()
  {
    return this.addressType;
  }
  
  public InetAddress localhost()
  {
    return this.localHost;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\InternetProtocolFamily.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
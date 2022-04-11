package io.netty.handler.proxy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

public final class ProxyConnectionEvent
{
  private final String authScheme;
  private final SocketAddress destinationAddress;
  private final String protocol;
  private final SocketAddress proxyAddress;
  private String strVal;
  
  public ProxyConnectionEvent(String paramString1, String paramString2, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
  {
    this.protocol = ((String)ObjectUtil.checkNotNull(paramString1, "protocol"));
    this.authScheme = ((String)ObjectUtil.checkNotNull(paramString2, "authScheme"));
    this.proxyAddress = ((SocketAddress)ObjectUtil.checkNotNull(paramSocketAddress1, "proxyAddress"));
    this.destinationAddress = ((SocketAddress)ObjectUtil.checkNotNull(paramSocketAddress2, "destinationAddress"));
  }
  
  public String authScheme()
  {
    return this.authScheme;
  }
  
  public <T extends SocketAddress> T destinationAddress()
  {
    return this.destinationAddress;
  }
  
  public String protocol()
  {
    return this.protocol;
  }
  
  public <T extends SocketAddress> T proxyAddress()
  {
    return this.proxyAddress;
  }
  
  public String toString()
  {
    Object localObject = this.strVal;
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = new StringBuilder(128);
    ((StringBuilder)localObject).append(StringUtil.simpleClassName(this));
    ((StringBuilder)localObject).append('(');
    ((StringBuilder)localObject).append(this.protocol);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.authScheme);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.proxyAddress);
    ((StringBuilder)localObject).append(" => ");
    ((StringBuilder)localObject).append(this.destinationAddress);
    ((StringBuilder)localObject).append(')');
    localObject = ((StringBuilder)localObject).toString();
    this.strVal = ((String)localObject);
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\proxy\ProxyConnectionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.resolver;

import java.net.InetAddress;

public abstract interface HostsFileEntriesResolver
{
  public static final HostsFileEntriesResolver DEFAULT = new DefaultHostsFileEntriesResolver();
  
  public abstract InetAddress address(String paramString, ResolvedAddressTypes paramResolvedAddressTypes);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\HostsFileEntriesResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
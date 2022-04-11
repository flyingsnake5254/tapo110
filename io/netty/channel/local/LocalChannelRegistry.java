package io.netty.channel.local;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.concurrent.ConcurrentMap;

final class LocalChannelRegistry
{
  private static final ConcurrentMap<LocalAddress, Channel> boundChannels = ;
  
  static Channel get(SocketAddress paramSocketAddress)
  {
    return (Channel)boundChannels.get(paramSocketAddress);
  }
  
  static LocalAddress register(Channel paramChannel, LocalAddress paramLocalAddress, SocketAddress paramSocketAddress)
  {
    if (paramLocalAddress == null)
    {
      if ((paramSocketAddress instanceof LocalAddress))
      {
        paramSocketAddress = (LocalAddress)paramSocketAddress;
        paramLocalAddress = paramSocketAddress;
        if (LocalAddress.ANY.equals(paramSocketAddress)) {
          paramLocalAddress = new LocalAddress(paramChannel);
        }
        paramChannel = (Channel)boundChannels.putIfAbsent(paramLocalAddress, paramChannel);
        if (paramChannel == null) {
          return paramLocalAddress;
        }
        paramLocalAddress = new StringBuilder();
        paramLocalAddress.append("address already in use by: ");
        paramLocalAddress.append(paramChannel);
        throw new ChannelException(paramLocalAddress.toString());
      }
      paramChannel = new StringBuilder();
      paramChannel.append("unsupported address type: ");
      paramChannel.append(StringUtil.simpleClassName(paramSocketAddress));
      throw new ChannelException(paramChannel.toString());
    }
    throw new ChannelException("already bound");
  }
  
  static void unregister(LocalAddress paramLocalAddress)
  {
    boundChannels.remove(paramLocalAddress);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\local\LocalChannelRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
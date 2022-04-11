package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressJava6Requirement(reason="Usage explicit by the user")
public final class NioChannelOption<T>
  extends ChannelOption<T>
{
  private final SocketOption<T> option;
  
  private NioChannelOption(SocketOption<T> paramSocketOption)
  {
    super(paramSocketOption.name());
    this.option = paramSocketOption;
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  static <T> T getOption(Channel paramChannel, NioChannelOption<T> paramNioChannelOption)
  {
    paramChannel = (NetworkChannel)paramChannel;
    if (!paramChannel.supportedOptions().contains(paramNioChannelOption.option)) {
      return null;
    }
    if (((paramChannel instanceof ServerSocketChannel)) && (paramNioChannelOption.option == StandardSocketOptions.IP_TOS)) {
      return null;
    }
    try
    {
      paramChannel = paramChannel.getOption(paramNioChannelOption.option);
      return paramChannel;
    }
    catch (IOException paramChannel)
    {
      throw new ChannelException(paramChannel);
    }
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  static ChannelOption[] getOptions(Channel paramChannel)
  {
    paramChannel = (NetworkChannel)paramChannel;
    Object localObject = paramChannel.supportedOptions();
    boolean bool = paramChannel instanceof ServerSocketChannel;
    int i = 0;
    if (bool)
    {
      paramChannel = new ArrayList(((Set)localObject).size());
      Iterator localIterator = ((Set)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (SocketOption)localIterator.next();
        if (localObject != StandardSocketOptions.IP_TOS) {
          paramChannel.add(new NioChannelOption((SocketOption)localObject));
        }
      }
      return (ChannelOption[])paramChannel.toArray(new ChannelOption[0]);
    }
    paramChannel = new ChannelOption[((Set)localObject).size()];
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramChannel[i] = new NioChannelOption((SocketOption)((Iterator)localObject).next());
      i++;
    }
    return paramChannel;
  }
  
  public static <T> ChannelOption<T> of(SocketOption<T> paramSocketOption)
  {
    return new NioChannelOption(paramSocketOption);
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  static <T> boolean setOption(Channel paramChannel, NioChannelOption<T> paramNioChannelOption, T paramT)
  {
    paramChannel = (NetworkChannel)paramChannel;
    if (!paramChannel.supportedOptions().contains(paramNioChannelOption.option)) {
      return false;
    }
    if (((paramChannel instanceof ServerSocketChannel)) && (paramNioChannelOption.option == StandardSocketOptions.IP_TOS)) {
      return false;
    }
    try
    {
      paramChannel.setOption(paramNioChannelOption.option, paramT);
      return true;
    }
    catch (IOException paramChannel)
    {
      throw new ChannelException(paramChannel);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\nio\NioChannelOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
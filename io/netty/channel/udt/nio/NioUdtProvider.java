package io.netty.channel.udt.nio;

import com.barchart.udt.SocketUDT;
import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.ChannelUDT;
import com.barchart.udt.nio.KindUDT;
import com.barchart.udt.nio.RendezvousChannelUDT;
import com.barchart.udt.nio.SelectorProviderUDT;
import com.barchart.udt.nio.ServerSocketChannelUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFactory;
import io.netty.channel.udt.UdtChannel;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;

@Deprecated
public final class NioUdtProvider<T extends UdtChannel>
  implements ChannelFactory<T>
{
  public static final ChannelFactory<?> BYTE_ACCEPTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.ACCEPTOR);
  public static final ChannelFactory<UdtChannel> BYTE_CONNECTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.CONNECTOR);
  public static final SelectorProvider BYTE_PROVIDER = SelectorProviderUDT.STREAM;
  public static final ChannelFactory<UdtChannel> BYTE_RENDEZVOUS = new NioUdtProvider(TypeUDT.STREAM, KindUDT.RENDEZVOUS);
  public static final ChannelFactory<?> MESSAGE_ACCEPTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.ACCEPTOR);
  public static final ChannelFactory<UdtChannel> MESSAGE_CONNECTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.CONNECTOR);
  public static final SelectorProvider MESSAGE_PROVIDER = SelectorProviderUDT.DATAGRAM;
  public static final ChannelFactory<UdtChannel> MESSAGE_RENDEZVOUS = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.RENDEZVOUS);
  private final KindUDT kind;
  private final TypeUDT type;
  
  private NioUdtProvider(TypeUDT paramTypeUDT, KindUDT paramKindUDT)
  {
    this.type = paramTypeUDT;
    this.kind = paramKindUDT;
  }
  
  public static ChannelUDT channelUDT(Channel paramChannel)
  {
    if ((paramChannel instanceof NioUdtByteAcceptorChannel)) {
      return ((NioUdtByteAcceptorChannel)paramChannel).javaChannel();
    }
    if ((paramChannel instanceof NioUdtByteRendezvousChannel)) {
      return ((NioUdtByteRendezvousChannel)paramChannel).javaChannel();
    }
    if ((paramChannel instanceof NioUdtByteConnectorChannel)) {
      return ((NioUdtByteConnectorChannel)paramChannel).javaChannel();
    }
    if ((paramChannel instanceof NioUdtMessageAcceptorChannel)) {
      return ((NioUdtMessageAcceptorChannel)paramChannel).javaChannel();
    }
    if ((paramChannel instanceof NioUdtMessageRendezvousChannel)) {
      return ((NioUdtMessageRendezvousChannel)paramChannel).javaChannel();
    }
    if ((paramChannel instanceof NioUdtMessageConnectorChannel)) {
      return ((NioUdtMessageConnectorChannel)paramChannel).javaChannel();
    }
    return null;
  }
  
  static ServerSocketChannelUDT newAcceptorChannelUDT(TypeUDT paramTypeUDT)
  {
    try
    {
      paramTypeUDT = SelectorProviderUDT.from(paramTypeUDT).openServerSocketChannel();
      return paramTypeUDT;
    }
    catch (IOException paramTypeUDT)
    {
      throw new ChannelException("failed to open a server socket channel", paramTypeUDT);
    }
  }
  
  static SocketChannelUDT newConnectorChannelUDT(TypeUDT paramTypeUDT)
  {
    try
    {
      paramTypeUDT = SelectorProviderUDT.from(paramTypeUDT).openSocketChannel();
      return paramTypeUDT;
    }
    catch (IOException paramTypeUDT)
    {
      throw new ChannelException("failed to open a socket channel", paramTypeUDT);
    }
  }
  
  static RendezvousChannelUDT newRendezvousChannelUDT(TypeUDT paramTypeUDT)
  {
    try
    {
      paramTypeUDT = SelectorProviderUDT.from(paramTypeUDT).openRendezvousChannel();
      return paramTypeUDT;
    }
    catch (IOException paramTypeUDT)
    {
      throw new ChannelException("failed to open a rendezvous channel", paramTypeUDT);
    }
  }
  
  public static SocketUDT socketUDT(Channel paramChannel)
  {
    paramChannel = channelUDT(paramChannel);
    if (paramChannel == null) {
      return null;
    }
    return paramChannel.socketUDT();
  }
  
  public KindUDT kind()
  {
    return this.kind;
  }
  
  public T newChannel()
  {
    int i = 1.$SwitchMap$com$barchart$udt$nio$KindUDT[this.kind.ordinal()];
    StringBuilder localStringBuilder;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          i = 1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
          if (i != 1)
          {
            if (i == 2) {
              return new NioUdtByteRendezvousChannel();
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("wrong type=");
            localStringBuilder.append(this.type);
            throw new IllegalStateException(localStringBuilder.toString());
          }
          return new NioUdtMessageRendezvousChannel();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("wrong kind=");
        localStringBuilder.append(this.kind);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      i = 1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return new NioUdtByteConnectorChannel();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("wrong type=");
        localStringBuilder.append(this.type);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      return new NioUdtMessageConnectorChannel();
    }
    i = 1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return new NioUdtByteAcceptorChannel();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("wrong type=");
      localStringBuilder.append(this.type);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return new NioUdtMessageAcceptorChannel();
  }
  
  public TypeUDT type()
  {
    return this.type;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\nio\NioUdtProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
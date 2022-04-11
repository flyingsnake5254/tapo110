package io.netty.channel.epoll;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.Socket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public final class EpollServerSocketChannel
  extends AbstractEpollServerChannel
  implements ServerSocketChannel
{
  private final EpollServerSocketChannelConfig config = new EpollServerSocketChannelConfig(this);
  private volatile Collection<InetAddress> tcpMd5SigAddresses = Collections.emptyList();
  
  public EpollServerSocketChannel()
  {
    super(LinuxSocket.newSocketStream(), false);
  }
  
  public EpollServerSocketChannel(int paramInt)
  {
    this(new LinuxSocket(paramInt));
  }
  
  EpollServerSocketChannel(LinuxSocket paramLinuxSocket)
  {
    super(paramLinuxSocket);
  }
  
  EpollServerSocketChannel(LinuxSocket paramLinuxSocket, boolean paramBoolean)
  {
    super(paramLinuxSocket, paramBoolean);
  }
  
  public EpollServerSocketChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    super.doBind(paramSocketAddress);
    if ((Native.IS_SUPPORTING_TCP_FASTOPEN) && (this.config.getTcpFastopen() > 0)) {
      this.socket.setTcpFastOpen(this.config.getTcpFastopen());
    }
    this.socket.listen(this.config.getBacklog());
    this.active = true;
  }
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof EpollEventLoop;
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected Channel newChildChannel(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws Exception
  {
    return new EpollSocketChannel(this, new LinuxSocket(paramInt1), NativeInetAddress.address(paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  void setTcpMd5Sig(Map<InetAddress, byte[]> paramMap)
    throws IOException
  {
    this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, paramMap);
  }
  
  Collection<InetAddress> tcpMd5SigAddresses()
  {
    return this.tcpMd5SigAddresses;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\epoll\EpollServerSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.channel.kqueue;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.Socket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class KQueueServerSocketChannel
  extends AbstractKQueueServerChannel
  implements ServerSocketChannel
{
  private final KQueueServerSocketChannelConfig config = new KQueueServerSocketChannelConfig(this);
  
  public KQueueServerSocketChannel()
  {
    super(BsdSocket.newSocketStream(), false);
  }
  
  public KQueueServerSocketChannel(int paramInt)
  {
    this(new BsdSocket(paramInt));
  }
  
  KQueueServerSocketChannel(BsdSocket paramBsdSocket)
  {
    super(paramBsdSocket);
  }
  
  KQueueServerSocketChannel(BsdSocket paramBsdSocket, boolean paramBoolean)
  {
    super(paramBsdSocket, paramBoolean);
  }
  
  public KQueueServerSocketChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    super.doBind(paramSocketAddress);
    this.socket.listen(this.config.getBacklog());
    this.active = true;
  }
  
  protected boolean isCompatible(EventLoop paramEventLoop)
  {
    return paramEventLoop instanceof KQueueEventLoop;
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected Channel newChildChannel(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws Exception
  {
    return new KQueueSocketChannel(this, new BsdSocket(paramInt1), NativeInetAddress.address(paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\kqueue\KQueueServerSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
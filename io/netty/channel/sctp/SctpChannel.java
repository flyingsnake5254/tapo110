package io.netty.channel.sctp;

import com.sun.nio.sctp.Association;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Set;

public abstract interface SctpChannel
  extends Channel
{
  public abstract Set<InetSocketAddress> allLocalAddresses();
  
  public abstract Set<InetSocketAddress> allRemoteAddresses();
  
  public abstract Association association();
  
  public abstract ChannelFuture bindAddress(InetAddress paramInetAddress);
  
  public abstract ChannelFuture bindAddress(InetAddress paramInetAddress, ChannelPromise paramChannelPromise);
  
  public abstract SctpChannelConfig config();
  
  public abstract InetSocketAddress localAddress();
  
  public abstract SctpServerChannel parent();
  
  public abstract InetSocketAddress remoteAddress();
  
  public abstract ChannelFuture unbindAddress(InetAddress paramInetAddress);
  
  public abstract ChannelFuture unbindAddress(InetAddress paramInetAddress, ChannelPromise paramChannelPromise);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\SctpChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
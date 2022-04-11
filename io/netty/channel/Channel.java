package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.AttributeMap;
import java.net.SocketAddress;

public abstract interface Channel
  extends AttributeMap, ChannelOutboundInvoker, Comparable<Channel>
{
  public abstract ByteBufAllocator alloc();
  
  public abstract long bytesBeforeUnwritable();
  
  public abstract long bytesBeforeWritable();
  
  public abstract ChannelFuture closeFuture();
  
  public abstract ChannelConfig config();
  
  public abstract EventLoop eventLoop();
  
  public abstract Channel flush();
  
  public abstract ChannelId id();
  
  public abstract boolean isActive();
  
  public abstract boolean isOpen();
  
  public abstract boolean isRegistered();
  
  public abstract boolean isWritable();
  
  public abstract SocketAddress localAddress();
  
  public abstract ChannelMetadata metadata();
  
  public abstract Channel parent();
  
  public abstract ChannelPipeline pipeline();
  
  public abstract Channel read();
  
  public abstract SocketAddress remoteAddress();
  
  public abstract Unsafe unsafe();
  
  public static abstract interface Unsafe
  {
    public abstract void beginRead();
    
    public abstract void bind(SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise);
    
    public abstract void close(ChannelPromise paramChannelPromise);
    
    public abstract void closeForcibly();
    
    public abstract void connect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise);
    
    public abstract void deregister(ChannelPromise paramChannelPromise);
    
    public abstract void disconnect(ChannelPromise paramChannelPromise);
    
    public abstract void flush();
    
    public abstract SocketAddress localAddress();
    
    public abstract ChannelOutboundBuffer outboundBuffer();
    
    public abstract RecvByteBufAllocator.Handle recvBufAllocHandle();
    
    public abstract void register(EventLoop paramEventLoop, ChannelPromise paramChannelPromise);
    
    public abstract SocketAddress remoteAddress();
    
    public abstract ChannelPromise voidPromise();
    
    public abstract void write(Object paramObject, ChannelPromise paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\Channel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
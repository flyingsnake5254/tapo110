package io.netty.channel.sctp.nio;

import com.sun.nio.sctp.SctpChannel;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.sctp.DefaultSctpServerChannelConfig;
import io.netty.channel.sctp.SctpServerChannelConfig;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NioSctpServerChannel
  extends AbstractNioMessageChannel
  implements io.netty.channel.sctp.SctpServerChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  private final SctpServerChannelConfig config = new NioSctpServerChannelConfig(this, javaChannel(), null);
  
  public NioSctpServerChannel()
  {
    super(null, newSocket(), 16);
  }
  
  private static com.sun.nio.sctp.SctpServerChannel newSocket()
  {
    try
    {
      com.sun.nio.sctp.SctpServerChannel localSctpServerChannel = com.sun.nio.sctp.SctpServerChannel.open();
      return localSctpServerChannel;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException("Failed to open a server socket.", localIOException);
    }
  }
  
  public Set<InetSocketAddress> allLocalAddresses()
  {
    try
    {
      Object localObject1 = javaChannel().getAllLocalAddresses();
      LinkedHashSet localLinkedHashSet = new java/util/LinkedHashSet;
      localLinkedHashSet.<init>(((Set)localObject1).size());
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localLinkedHashSet.add((InetSocketAddress)((Iterator)localObject1).next());
      }
      return localLinkedHashSet;
    }
    finally {}
    return Collections.emptySet();
  }
  
  public ChannelFuture bindAddress(InetAddress paramInetAddress)
  {
    return bindAddress(paramInetAddress, newPromise());
  }
  
  /* Error */
  public ChannelFuture bindAddress(final InetAddress paramInetAddress, final ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 124	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   4: invokevirtual 129	io/netty/util/concurrent/AbstractEventExecutor:inEventLoop	()Z
    //   7: ifeq +34 -> 41
    //   10: aload_0
    //   11: invokevirtual 38	io/netty/channel/sctp/nio/NioSctpServerChannel:javaChannel	()Lcom/sun/nio/sctp/SctpServerChannel;
    //   14: aload_1
    //   15: invokevirtual 132	com/sun/nio/sctp/SctpServerChannel:bindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpServerChannel;
    //   18: pop
    //   19: aload_2
    //   20: invokeinterface 137 1 0
    //   25: pop
    //   26: goto +32 -> 58
    //   29: astore_1
    //   30: aload_2
    //   31: aload_1
    //   32: invokeinterface 141 2 0
    //   37: pop
    //   38: goto +20 -> 58
    //   41: aload_0
    //   42: invokevirtual 124	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   45: new 8	io/netty/channel/sctp/nio/NioSctpServerChannel$1
    //   48: dup
    //   49: aload_0
    //   50: aload_1
    //   51: aload_2
    //   52: invokespecial 144	io/netty/channel/sctp/nio/NioSctpServerChannel$1:<init>	(Lio/netty/channel/sctp/nio/NioSctpServerChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   55: invokevirtual 150	io/netty/util/concurrent/SingleThreadEventExecutor:execute	(Ljava/lang/Runnable;)V
    //   58: aload_2
    //   59: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	NioSctpServerChannel
    //   0	60	1	paramInetAddress	InetAddress
    //   0	60	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   10	26	29	finally
  }
  
  public SctpServerChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    javaChannel().bind(paramSocketAddress, this.config.getBacklog());
  }
  
  protected void doClose()
    throws Exception
  {
    javaChannel().close();
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doDisconnect()
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doFinishConnect()
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected int doReadMessages(List<Object> paramList)
    throws Exception
  {
    SctpChannel localSctpChannel = javaChannel().accept();
    if (localSctpChannel == null) {
      return 0;
    }
    paramList.add(new NioSctpChannel(this, localSctpChannel));
    return 1;
  }
  
  protected boolean doWriteMessage(Object paramObject, ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected Object filterOutboundMessage(Object paramObject)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((isOpen()) && (!allLocalAddresses().isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected com.sun.nio.sctp.SctpServerChannel javaChannel()
  {
    return (com.sun.nio.sctp.SctpServerChannel)super.javaChannel();
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    try
    {
      Object localObject = javaChannel().getAllLocalAddresses().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (SocketAddress)((Iterator)localObject).next();
        return (SocketAddress)localObject;
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  public InetSocketAddress remoteAddress()
  {
    return null;
  }
  
  protected SocketAddress remoteAddress0()
  {
    return null;
  }
  
  public ChannelFuture unbindAddress(InetAddress paramInetAddress)
  {
    return unbindAddress(paramInetAddress, newPromise());
  }
  
  /* Error */
  public ChannelFuture unbindAddress(final InetAddress paramInetAddress, final ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 124	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   4: invokevirtual 129	io/netty/util/concurrent/AbstractEventExecutor:inEventLoop	()Z
    //   7: ifeq +34 -> 41
    //   10: aload_0
    //   11: invokevirtual 38	io/netty/channel/sctp/nio/NioSctpServerChannel:javaChannel	()Lcom/sun/nio/sctp/SctpServerChannel;
    //   14: aload_1
    //   15: invokevirtual 230	com/sun/nio/sctp/SctpServerChannel:unbindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpServerChannel;
    //   18: pop
    //   19: aload_2
    //   20: invokeinterface 137 1 0
    //   25: pop
    //   26: goto +32 -> 58
    //   29: astore_1
    //   30: aload_2
    //   31: aload_1
    //   32: invokeinterface 141 2 0
    //   37: pop
    //   38: goto +20 -> 58
    //   41: aload_0
    //   42: invokevirtual 124	io/netty/channel/nio/AbstractNioChannel:eventLoop	()Lio/netty/channel/nio/NioEventLoop;
    //   45: new 10	io/netty/channel/sctp/nio/NioSctpServerChannel$2
    //   48: dup
    //   49: aload_0
    //   50: aload_1
    //   51: aload_2
    //   52: invokespecial 231	io/netty/channel/sctp/nio/NioSctpServerChannel$2:<init>	(Lio/netty/channel/sctp/nio/NioSctpServerChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   55: invokevirtual 150	io/netty/util/concurrent/SingleThreadEventExecutor:execute	(Ljava/lang/Runnable;)V
    //   58: aload_2
    //   59: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	NioSctpServerChannel
    //   0	60	1	paramInetAddress	InetAddress
    //   0	60	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   10	26	29	finally
  }
  
  private final class NioSctpServerChannelConfig
    extends DefaultSctpServerChannelConfig
  {
    private NioSctpServerChannelConfig(NioSctpServerChannel paramNioSctpServerChannel, com.sun.nio.sctp.SctpServerChannel paramSctpServerChannel)
    {
      super(paramSctpServerChannel);
    }
    
    protected void autoReadCleared()
    {
      NioSctpServerChannel.this.clearReadPending();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\nio\NioSctpServerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
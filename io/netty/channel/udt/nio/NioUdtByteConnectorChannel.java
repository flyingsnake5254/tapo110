package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.NioSocketUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.udt.DefaultUdtChannelConfig;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtChannelConfig;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

@Deprecated
public class NioUdtByteConnectorChannel
  extends AbstractNioByteChannel
  implements UdtChannel
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioUdtByteConnectorChannel.class);
  private final UdtChannelConfig config;
  
  public NioUdtByteConnectorChannel()
  {
    this(TypeUDT.STREAM);
  }
  
  public NioUdtByteConnectorChannel(TypeUDT paramTypeUDT)
  {
    this(NioUdtProvider.newConnectorChannelUDT(paramTypeUDT));
  }
  
  public NioUdtByteConnectorChannel(SocketChannelUDT paramSocketChannelUDT)
  {
    this(null, paramSocketChannelUDT);
  }
  
  public NioUdtByteConnectorChannel(Channel paramChannel, SocketChannelUDT paramSocketChannelUDT)
  {
    super(paramChannel, paramSocketChannelUDT);
    try
    {
      paramSocketChannelUDT.configureBlocking(false);
      int i = 2.$SwitchMap$com$barchart$udt$StatusUDT[paramSocketChannelUDT.socketUDT().status().ordinal()];
      if ((i != 1) && (i != 2))
      {
        paramChannel = new io/netty/channel/udt/DefaultUdtChannelConfig;
        paramChannel.<init>(this, paramSocketChannelUDT, false);
        this.config = paramChannel;
      }
      else
      {
        paramChannel = new io/netty/channel/udt/DefaultUdtChannelConfig;
        paramChannel.<init>(this, paramSocketChannelUDT, true);
        this.config = paramChannel;
      }
      return;
    }
    catch (Exception paramChannel)
    {
      try
      {
        paramSocketChannelUDT.close();
      }
      catch (Exception paramSocketChannelUDT)
      {
        if (logger.isWarnEnabled()) {
          logger.warn("Failed to close channel.", paramSocketChannelUDT);
        }
      }
      throw new ChannelException("Failed to configure channel.", paramChannel);
    }
  }
  
  private static void privilegedBind(SocketChannelUDT paramSocketChannelUDT, SocketAddress paramSocketAddress)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local1 = new io/netty/channel/udt/nio/NioUdtByteConnectorChannel$1;
      local1.<init>(paramSocketChannelUDT, paramSocketAddress);
      AccessController.doPrivileged(local1);
      return;
    }
    catch (PrivilegedActionException paramSocketChannelUDT)
    {
      throw ((IOException)paramSocketChannelUDT.getCause());
    }
  }
  
  public UdtChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    privilegedBind(javaChannel(), paramSocketAddress);
  }
  
  protected void doClose()
    throws Exception
  {
    javaChannel().close();
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    if (paramSocketAddress2 == null) {
      paramSocketAddress2 = new InetSocketAddress(0);
    }
    doBind(paramSocketAddress2);
    try
    {
      boolean bool = SocketUtils.connect(javaChannel(), paramSocketAddress1);
      if (!bool) {
        selectionKey().interestOps(selectionKey().interestOps() | 0x8);
      }
      return bool;
    }
    finally
    {
      doClose();
    }
  }
  
  protected void doDisconnect()
    throws Exception
  {
    doClose();
  }
  
  protected void doFinishConnect()
    throws Exception
  {
    if (javaChannel().finishConnect())
    {
      selectionKey().interestOps(selectionKey().interestOps() & 0xFFFFFFF7);
      return;
    }
    throw new Error("Provider error: failed to finish connect. Provider library should be upgraded.");
  }
  
  protected int doReadBytes(ByteBuf paramByteBuf)
    throws Exception
  {
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    localHandle.attemptedBytesRead(paramByteBuf.writableBytes());
    return paramByteBuf.writeBytes(javaChannel(), localHandle.attemptedBytesRead());
  }
  
  protected int doWriteBytes(ByteBuf paramByteBuf)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    return paramByteBuf.readBytes(javaChannel(), i);
  }
  
  protected long doWriteFileRegion(FileRegion paramFileRegion)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isActive()
  {
    SocketChannelUDT localSocketChannelUDT = javaChannel();
    boolean bool;
    if ((localSocketChannelUDT.isOpen()) && (localSocketChannelUDT.isConnectFinished())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected SocketChannelUDT javaChannel()
  {
    return (SocketChannelUDT)super.javaChannel();
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return javaChannel().socket().getLocalSocketAddress();
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  protected SocketAddress remoteAddress0()
  {
    return javaChannel().socket().getRemoteSocketAddress();
  }
  
  protected ChannelFuture shutdownInput()
  {
    return newFailedFuture(new UnsupportedOperationException("shutdownInput"));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\nio\NioUdtByteConnectorChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
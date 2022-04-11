package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.NioSocketUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.udt.DefaultUdtChannelConfig;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtChannelConfig;
import io.netty.channel.udt.UdtMessage;
import io.netty.util.ReferenceCounted;
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
import java.util.List;

@Deprecated
public class NioUdtMessageConnectorChannel
  extends AbstractNioMessageChannel
  implements UdtChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioUdtMessageConnectorChannel.class);
  private final UdtChannelConfig config;
  
  public NioUdtMessageConnectorChannel()
  {
    this(TypeUDT.DATAGRAM);
  }
  
  public NioUdtMessageConnectorChannel(TypeUDT paramTypeUDT)
  {
    this(NioUdtProvider.newConnectorChannelUDT(paramTypeUDT));
  }
  
  public NioUdtMessageConnectorChannel(SocketChannelUDT paramSocketChannelUDT)
  {
    this(null, paramSocketChannelUDT);
  }
  
  public NioUdtMessageConnectorChannel(Channel paramChannel, SocketChannelUDT paramSocketChannelUDT)
  {
    super(paramChannel, paramSocketChannelUDT, 1);
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
        logger.warn("Failed to close channel.", paramSocketChannelUDT);
      }
      throw new ChannelException("Failed to configure channel.", paramChannel);
    }
  }
  
  private static void privilegedBind(SocketChannelUDT paramSocketChannelUDT, SocketAddress paramSocketAddress)
    throws IOException
  {
    try
    {
      PrivilegedExceptionAction local1 = new io/netty/channel/udt/nio/NioUdtMessageConnectorChannel$1;
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
  
  protected int doReadMessages(List<Object> paramList)
    throws Exception
  {
    int i = this.config.getReceiveBufferSize();
    ByteBuf localByteBuf = this.config.getAllocator().directBuffer(i);
    int j = localByteBuf.writeBytes(javaChannel(), i);
    if (j <= 0)
    {
      localByteBuf.release();
      return 0;
    }
    if (j < i)
    {
      paramList.add(new UdtMessage(localByteBuf));
      return 1;
    }
    javaChannel().close();
    throw new ChannelException("Invalid config : increase receive buffer size to avoid message truncation");
  }
  
  protected boolean doWriteMessage(Object paramObject, ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    paramObject = ((UdtMessage)paramObject).content();
    int i = ((ByteBuf)paramObject).readableBytes();
    boolean bool1 = true;
    if (i == 0) {
      return true;
    }
    long l;
    if (((ByteBuf)paramObject).nioBufferCount() == 1) {
      l = javaChannel().write(((ByteBuf)paramObject).nioBuffer());
    } else {
      l = javaChannel().write(((ByteBuf)paramObject).nioBuffers());
    }
    boolean bool2 = l < 0L;
    if ((bool2) && (l != i)) {
      throw new Error("Provider error: failed to write message. Provider library should be upgraded.");
    }
    if (!bool2) {
      bool1 = false;
    }
    return bool1;
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
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  protected SocketAddress remoteAddress0()
  {
    return javaChannel().socket().getRemoteSocketAddress();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\udt\nio\NioUdtMessageConnectorChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
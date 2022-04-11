package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.Channel.Unsafe;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.AbstractNioChannel.AbstractNioUnsafe;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.spi.SelectorProvider;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public class NioSocketChannel
  extends AbstractNioByteChannel
  implements io.netty.channel.socket.SocketChannel
{
  private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioSocketChannel.class);
  private final SocketChannelConfig config;
  
  public NioSocketChannel()
  {
    this(DEFAULT_SELECTOR_PROVIDER);
  }
  
  public NioSocketChannel(Channel paramChannel, java.nio.channels.SocketChannel paramSocketChannel)
  {
    super(paramChannel, paramSocketChannel);
    this.config = new NioSocketChannelConfig(this, paramSocketChannel.socket(), null);
  }
  
  public NioSocketChannel(java.nio.channels.SocketChannel paramSocketChannel)
  {
    this(null, paramSocketChannel);
  }
  
  public NioSocketChannel(SelectorProvider paramSelectorProvider)
  {
    this(newSocket(paramSelectorProvider));
  }
  
  private void adjustMaxBytesPerGatheringWrite(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == paramInt2)
    {
      paramInt1 <<= 1;
      if (paramInt1 > paramInt3) {
        ((NioSocketChannelConfig)this.config).setMaxBytesPerGatheringWrite(paramInt1);
      }
    }
    else if (paramInt1 > 4096)
    {
      paramInt1 >>>= 1;
      if (paramInt2 < paramInt1) {
        ((NioSocketChannelConfig)this.config).setMaxBytesPerGatheringWrite(paramInt1);
      }
    }
  }
  
  private void doBind0(SocketAddress paramSocketAddress)
    throws Exception
  {
    if (PlatformDependent.javaVersion() >= 7) {
      SocketUtils.bind(javaChannel(), paramSocketAddress);
    } else {
      SocketUtils.bind(javaChannel().socket(), paramSocketAddress);
    }
  }
  
  private static java.nio.channels.SocketChannel newSocket(SelectorProvider paramSelectorProvider)
  {
    try
    {
      paramSelectorProvider = paramSelectorProvider.openSocketChannel();
      return paramSelectorProvider;
    }
    catch (IOException paramSelectorProvider)
    {
      throw new ChannelException("Failed to open a socket.", paramSelectorProvider);
    }
  }
  
  private static void shutdownDone(ChannelFuture paramChannelFuture1, ChannelFuture paramChannelFuture2, ChannelPromise paramChannelPromise)
  {
    paramChannelFuture1 = paramChannelFuture1.cause();
    paramChannelFuture2 = paramChannelFuture2.cause();
    if (paramChannelFuture1 != null)
    {
      if (paramChannelFuture2 != null) {
        logger.debug("Exception suppressed because a previous exception occurred.", paramChannelFuture2);
      }
      paramChannelPromise.setFailure(paramChannelFuture1);
    }
    else if (paramChannelFuture2 != null)
    {
      paramChannelPromise.setFailure(paramChannelFuture2);
    }
    else
    {
      paramChannelPromise.setSuccess();
    }
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  private void shutdownInput0()
    throws Exception
  {
    if (PlatformDependent.javaVersion() >= 7) {
      javaChannel().shutdownInput();
    } else {
      javaChannel().socket().shutdownInput();
    }
  }
  
  /* Error */
  private void shutdownInput0(ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 179	io/netty/channel/socket/nio/NioSocketChannel:shutdownInput0	()V
    //   4: aload_1
    //   5: invokeinterface 166 1 0
    //   10: pop
    //   11: goto +12 -> 23
    //   14: astore_2
    //   15: aload_1
    //   16: aload_2
    //   17: invokeinterface 162 2 0
    //   22: pop
    //   23: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	NioSocketChannel
    //   0	24	1	paramChannelPromise	ChannelPromise
    //   14	3	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	11	14	finally
  }
  
  private void shutdownOutputDone(final ChannelFuture paramChannelFuture, final ChannelPromise paramChannelPromise)
  {
    ChannelFuture localChannelFuture = shutdownInput();
    if (localChannelFuture.isDone()) {
      shutdownDone(paramChannelFuture, localChannelFuture, paramChannelPromise);
    } else {
      localChannelFuture.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          NioSocketChannel.shutdownDone(paramChannelFuture, paramAnonymousChannelFuture, paramChannelPromise);
        }
      });
    }
  }
  
  public SocketChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    doBind0(paramSocketAddress);
  }
  
  protected void doClose()
    throws Exception
  {
    super.doClose();
    javaChannel().close();
  }
  
  protected boolean doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    if (paramSocketAddress2 != null) {
      doBind0(paramSocketAddress2);
    }
    try
    {
      boolean bool = SocketUtils.connect(javaChannel(), paramSocketAddress1);
      if (!bool) {
        selectionKey().interestOps(8);
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
    if (javaChannel().finishConnect()) {
      return;
    }
    throw new Error();
  }
  
  protected int doReadBytes(ByteBuf paramByteBuf)
    throws Exception
  {
    RecvByteBufAllocator.Handle localHandle = unsafe().recvBufAllocHandle();
    localHandle.attemptedBytesRead(paramByteBuf.writableBytes());
    return paramByteBuf.writeBytes(javaChannel(), localHandle.attemptedBytesRead());
  }
  
  @SuppressJava6Requirement(reason="Usage guarded by java version check")
  protected final void doShutdownOutput()
    throws Exception
  {
    if (PlatformDependent.javaVersion() >= 7) {
      javaChannel().shutdownOutput();
    } else {
      javaChannel().socket().shutdownOutput();
    }
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    java.nio.channels.SocketChannel localSocketChannel = javaChannel();
    int i = config().getWriteSpinCount();
    int j;
    boolean bool;
    do
    {
      if (paramChannelOutboundBuffer.isEmpty())
      {
        clearOpWrite();
        return;
      }
      j = ((NioSocketChannelConfig)this.config).getMaxBytesPerGatheringWrite();
      Object localObject = paramChannelOutboundBuffer.nioBuffers(1024, j);
      int k = paramChannelOutboundBuffer.nioBufferCount();
      bool = false;
      if (k != 0)
      {
        if (k != 1)
        {
          long l1 = paramChannelOutboundBuffer.nioBufferSize();
          long l2 = localSocketChannel.write((ByteBuffer[])localObject, 0, k);
          if (l2 <= 0L)
          {
            incompleteWrite(true);
            return;
          }
          adjustMaxBytesPerGatheringWrite((int)l1, (int)l2, j);
          paramChannelOutboundBuffer.removeBytes(l2);
        }
        else
        {
          localObject = localObject[0];
          int m = ((ByteBuffer)localObject).remaining();
          k = localSocketChannel.write((ByteBuffer)localObject);
          if (k <= 0)
          {
            incompleteWrite(true);
            return;
          }
          adjustMaxBytesPerGatheringWrite(m, k, j);
          paramChannelOutboundBuffer.removeBytes(k);
        }
        j = i - 1;
      }
      else
      {
        j = i - doWrite0(paramChannelOutboundBuffer);
      }
      i = j;
    } while (j > 0);
    if (j < 0) {
      bool = true;
    }
    incompleteWrite(bool);
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
    long l = paramFileRegion.transferred();
    return paramFileRegion.transferTo(javaChannel(), l);
  }
  
  public boolean isActive()
  {
    java.nio.channels.SocketChannel localSocketChannel = javaChannel();
    boolean bool;
    if ((localSocketChannel.isOpen()) && (localSocketChannel.isConnected())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInputShutdown()
  {
    boolean bool;
    if ((!javaChannel().socket().isInputShutdown()) && (isActive())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected boolean isInputShutdown0()
  {
    return isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    boolean bool;
    if ((!javaChannel().socket().isOutputShutdown()) && (isActive())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isShutdown()
  {
    Socket localSocket = javaChannel().socket();
    boolean bool;
    if (((localSocket.isInputShutdown()) && (localSocket.isOutputShutdown())) || (!isActive())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected java.nio.channels.SocketChannel javaChannel()
  {
    return (java.nio.channels.SocketChannel)super.javaChannel();
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return javaChannel().socket().getLocalSocketAddress();
  }
  
  protected AbstractNioChannel.AbstractNioUnsafe newUnsafe()
  {
    return new NioSocketChannelUnsafe(null);
  }
  
  public ServerSocketChannel parent()
  {
    return (ServerSocketChannel)super.parent();
  }
  
  public InetSocketAddress remoteAddress()
  {
    return (InetSocketAddress)super.remoteAddress();
  }
  
  protected SocketAddress remoteAddress0()
  {
    return javaChannel().socket().getRemoteSocketAddress();
  }
  
  public ChannelFuture shutdown()
  {
    return shutdown(newPromise());
  }
  
  public ChannelFuture shutdown(final ChannelPromise paramChannelPromise)
  {
    ChannelFuture localChannelFuture = shutdownOutput();
    if (localChannelFuture.isDone()) {
      shutdownOutputDone(localChannelFuture, paramChannelPromise);
    } else {
      localChannelFuture.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          NioSocketChannel.this.shutdownOutputDone(paramAnonymousChannelFuture, paramChannelPromise);
        }
      });
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture shutdownInput()
  {
    return shutdownInput(newPromise());
  }
  
  public ChannelFuture shutdownInput(final ChannelPromise paramChannelPromise)
  {
    NioEventLoop localNioEventLoop = eventLoop();
    if (localNioEventLoop.inEventLoop()) {
      shutdownInput0(paramChannelPromise);
    } else {
      localNioEventLoop.execute(new Runnable()
      {
        public void run()
        {
          NioSocketChannel.this.shutdownInput0(paramChannelPromise);
        }
      });
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture shutdownOutput()
  {
    return shutdownOutput(newPromise());
  }
  
  public ChannelFuture shutdownOutput(final ChannelPromise paramChannelPromise)
  {
    NioEventLoop localNioEventLoop = eventLoop();
    if (localNioEventLoop.inEventLoop()) {
      ((AbstractChannel.AbstractUnsafe)unsafe()).shutdownOutput(paramChannelPromise);
    } else {
      localNioEventLoop.execute(new Runnable()
      {
        public void run()
        {
          ((AbstractChannel.AbstractUnsafe)NioSocketChannel.this.unsafe()).shutdownOutput(paramChannelPromise);
        }
      });
    }
    return paramChannelPromise;
  }
  
  private final class NioSocketChannelConfig
    extends DefaultSocketChannelConfig
  {
    private volatile int maxBytesPerGatheringWrite = Integer.MAX_VALUE;
    
    private NioSocketChannelConfig(NioSocketChannel paramNioSocketChannel, Socket paramSocket)
    {
      super(paramSocket);
      calculateMaxBytesPerGatheringWrite();
    }
    
    private void calculateMaxBytesPerGatheringWrite()
    {
      int i = getSendBufferSize() << 1;
      if (i > 0) {
        setMaxBytesPerGatheringWrite(i);
      }
    }
    
    private java.nio.channels.SocketChannel jdkChannel()
    {
      return ((NioSocketChannel)this.channel).javaChannel();
    }
    
    protected void autoReadCleared()
    {
      NioSocketChannel.this.clearReadPending();
    }
    
    int getMaxBytesPerGatheringWrite()
    {
      return this.maxBytesPerGatheringWrite;
    }
    
    public <T> T getOption(ChannelOption<T> paramChannelOption)
    {
      if ((PlatformDependent.javaVersion() >= 7) && ((paramChannelOption instanceof NioChannelOption))) {
        return (T)NioChannelOption.getOption(jdkChannel(), (NioChannelOption)paramChannelOption);
      }
      return (T)super.getOption(paramChannelOption);
    }
    
    public Map<ChannelOption<?>, Object> getOptions()
    {
      if (PlatformDependent.javaVersion() >= 7) {
        return getOptions(super.getOptions(), NioChannelOption.getOptions(jdkChannel()));
      }
      return super.getOptions();
    }
    
    void setMaxBytesPerGatheringWrite(int paramInt)
    {
      this.maxBytesPerGatheringWrite = paramInt;
    }
    
    public <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT)
    {
      if ((PlatformDependent.javaVersion() >= 7) && ((paramChannelOption instanceof NioChannelOption))) {
        return NioChannelOption.setOption(jdkChannel(), (NioChannelOption)paramChannelOption, paramT);
      }
      return super.setOption(paramChannelOption, paramT);
    }
    
    public NioSocketChannelConfig setSendBufferSize(int paramInt)
    {
      super.setSendBufferSize(paramInt);
      calculateMaxBytesPerGatheringWrite();
      return this;
    }
  }
  
  private final class NioSocketChannelUnsafe
    extends AbstractNioByteChannel.NioByteUnsafe
  {
    private NioSocketChannelUnsafe()
    {
      super();
    }
    
    protected Executor prepareToClose()
    {
      try
      {
        if ((NioSocketChannel.this.javaChannel().isOpen()) && (NioSocketChannel.this.config().getSoLinger() > 0))
        {
          NioSocketChannel.this.doDeregister();
          GlobalEventExecutor localGlobalEventExecutor = GlobalEventExecutor.INSTANCE;
          return localGlobalEventExecutor;
        }
      }
      finally
      {
        for (;;) {}
      }
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\nio\NioSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
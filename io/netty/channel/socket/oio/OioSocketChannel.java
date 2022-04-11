package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.oio.AbstractOioChannel;
import io.netty.channel.oio.OioByteStreamChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.concurrent.ScheduledExecutorService;

@Deprecated
public class OioSocketChannel
  extends OioByteStreamChannel
  implements SocketChannel
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioSocketChannel.class);
  private final OioSocketChannelConfig config;
  private final Socket socket;
  
  public OioSocketChannel()
  {
    this(new Socket());
  }
  
  /* Error */
  public OioSocketChannel(io.netty.channel.Channel paramChannel, Socket paramSocket)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 48	io/netty/channel/oio/OioByteStreamChannel:<init>	(Lio/netty/channel/Channel;)V
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 50	io/netty/channel/socket/oio/OioSocketChannel:socket	Ljava/net/Socket;
    //   10: aload_0
    //   11: new 52	io/netty/channel/socket/oio/DefaultOioSocketChannelConfig
    //   14: dup
    //   15: aload_0
    //   16: aload_2
    //   17: invokespecial 55	io/netty/channel/socket/oio/DefaultOioSocketChannelConfig:<init>	(Lio/netty/channel/socket/oio/OioSocketChannel;Ljava/net/Socket;)V
    //   20: putfield 57	io/netty/channel/socket/oio/OioSocketChannel:config	Lio/netty/channel/socket/oio/OioSocketChannelConfig;
    //   23: aload_2
    //   24: invokevirtual 61	java/net/Socket:isConnected	()Z
    //   27: ifeq +15 -> 42
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 65	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   35: aload_2
    //   36: invokevirtual 69	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   39: invokevirtual 73	io/netty/channel/oio/OioByteStreamChannel:activate	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   42: aload_2
    //   43: sipush 1000
    //   46: invokevirtual 77	java/net/Socket:setSoTimeout	(I)V
    //   49: return
    //   50: astore_1
    //   51: goto +17 -> 68
    //   54: astore_1
    //   55: new 79	io/netty/channel/ChannelException
    //   58: astore_3
    //   59: aload_3
    //   60: ldc 81
    //   62: aload_1
    //   63: invokespecial 84	io/netty/channel/ChannelException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload_3
    //   67: athrow
    //   68: aload_2
    //   69: invokevirtual 87	java/net/Socket:close	()V
    //   72: goto +15 -> 87
    //   75: astore_2
    //   76: getstatic 31	io/netty/channel/socket/oio/OioSocketChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   79: ldc 89
    //   81: aload_2
    //   82: invokeinterface 94 3 0
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	OioSocketChannel
    //   0	89	1	paramChannel	io.netty.channel.Channel
    //   0	89	2	paramSocket	Socket
    //   58	9	3	localChannelException	io.netty.channel.ChannelException
    // Exception table:
    //   from	to	target	type
    //   23	42	50	finally
    //   42	49	50	finally
    //   55	68	50	finally
    //   23	42	54	java/lang/Exception
    //   42	49	54	java/lang/Exception
    //   68	72	75	java/io/IOException
  }
  
  public OioSocketChannel(Socket paramSocket)
  {
    this(null, paramSocket);
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
  
  /* Error */
  private void shutdownInput0(ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	io/netty/channel/socket/oio/OioSocketChannel:socket	Ljava/net/Socket;
    //   4: invokevirtual 141	java/net/Socket:shutdownInput	()V
    //   7: aload_1
    //   8: invokeinterface 138 1 0
    //   13: pop
    //   14: goto +12 -> 26
    //   17: astore_2
    //   18: aload_1
    //   19: aload_2
    //   20: invokeinterface 134 2 0
    //   25: pop
    //   26: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	OioSocketChannel
    //   0	27	1	paramChannelPromise	ChannelPromise
    //   17	3	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	14	17	finally
  }
  
  private void shutdownOutput0()
    throws IOException
  {
    this.socket.shutdownOutput();
  }
  
  /* Error */
  private void shutdownOutput0(ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 147	io/netty/channel/socket/oio/OioSocketChannel:shutdownOutput0	()V
    //   4: aload_1
    //   5: invokeinterface 138 1 0
    //   10: pop
    //   11: goto +12 -> 23
    //   14: astore_2
    //   15: aload_1
    //   16: aload_2
    //   17: invokeinterface 134 2 0
    //   22: pop
    //   23: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	OioSocketChannel
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
          OioSocketChannel.shutdownDone(paramChannelFuture, paramAnonymousChannelFuture, paramChannelPromise);
        }
      });
    }
  }
  
  protected boolean checkInputShutdown()
  {
    if (isInputShutdown()) {}
    try
    {
      Thread.sleep(config().getSoTimeout());
      return true;
      return false;
    }
    finally
    {
      for (;;) {}
    }
  }
  
  final void clearReadPending0()
  {
    clearReadPending();
  }
  
  public OioSocketChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    SocketUtils.bind(this.socket, paramSocketAddress);
  }
  
  protected void doClose()
    throws Exception
  {
    this.socket.close();
  }
  
  /* Error */
  protected void doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +11 -> 12
    //   4: aload_0
    //   5: getfield 50	io/netty/channel/socket/oio/OioSocketChannel:socket	Ljava/net/Socket;
    //   8: aload_2
    //   9: invokestatic 198	io/netty/util/internal/SocketUtils:bind	(Ljava/net/Socket;Ljava/net/SocketAddress;)V
    //   12: aload_0
    //   13: getfield 50	io/netty/channel/socket/oio/OioSocketChannel:socket	Ljava/net/Socket;
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 170	io/netty/channel/socket/oio/OioSocketChannel:config	()Lio/netty/channel/socket/oio/OioSocketChannelConfig;
    //   21: invokeinterface 208 1 0
    //   26: invokestatic 212	io/netty/util/internal/SocketUtils:connect	(Ljava/net/Socket;Ljava/net/SocketAddress;I)V
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 50	io/netty/channel/socket/oio/OioSocketChannel:socket	Ljava/net/Socket;
    //   34: invokevirtual 65	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   37: aload_0
    //   38: getfield 50	io/netty/channel/socket/oio/OioSocketChannel:socket	Ljava/net/Socket;
    //   41: invokevirtual 69	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   44: invokevirtual 73	io/netty/channel/oio/OioByteStreamChannel:activate	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   47: return
    //   48: astore_1
    //   49: goto +52 -> 101
    //   52: astore_2
    //   53: new 214	io/netty/channel/ConnectTimeoutException
    //   56: astore_3
    //   57: new 216	java/lang/StringBuilder
    //   60: astore 4
    //   62: aload 4
    //   64: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   67: aload 4
    //   69: ldc -37
    //   71: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 4
    //   77: aload_1
    //   78: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: aload 4
    //   85: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 233	io/netty/channel/ConnectTimeoutException:<init>	(Ljava/lang/String;)V
    //   91: aload_3
    //   92: aload_2
    //   93: invokevirtual 237	java/net/SocketTimeoutException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   96: invokevirtual 243	java/net/ConnectException:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   99: aload_3
    //   100: athrow
    //   101: aload_0
    //   102: invokevirtual 245	io/netty/channel/socket/oio/OioSocketChannel:doClose	()V
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	OioSocketChannel
    //   0	107	1	paramSocketAddress1	SocketAddress
    //   0	107	2	paramSocketAddress2	SocketAddress
    //   56	44	3	localConnectTimeoutException	io.netty.channel.ConnectTimeoutException
    //   60	24	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	47	48	finally
    //   53	101	48	finally
    //   12	47	52	java/net/SocketTimeoutException
  }
  
  protected void doDisconnect()
    throws Exception
  {
    doClose();
  }
  
  protected int doReadBytes(ByteBuf paramByteBuf)
    throws Exception
  {
    if (this.socket.isClosed()) {
      return -1;
    }
    try
    {
      int i = super.doReadBytes(paramByteBuf);
      return i;
    }
    catch (SocketTimeoutException paramByteBuf) {}
    return 0;
  }
  
  protected final void doShutdownOutput()
    throws Exception
  {
    shutdownOutput0();
  }
  
  public boolean isActive()
  {
    boolean bool;
    if ((!this.socket.isClosed()) && (this.socket.isConnected())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInputShutdown()
  {
    boolean bool;
    if ((!this.socket.isInputShutdown()) && (isActive())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isOpen()
  {
    return this.socket.isClosed() ^ true;
  }
  
  public boolean isOutputShutdown()
  {
    boolean bool;
    if ((!this.socket.isOutputShutdown()) && (isActive())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isShutdown()
  {
    boolean bool;
    if (((this.socket.isInputShutdown()) && (this.socket.isOutputShutdown())) || (!isActive())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    return this.socket.getLocalSocketAddress();
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
    return this.socket.getRemoteSocketAddress();
  }
  
  @Deprecated
  protected void setReadPending(boolean paramBoolean)
  {
    super.setReadPending(paramBoolean);
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
          OioSocketChannel.this.shutdownOutputDone(paramAnonymousChannelFuture, paramChannelPromise);
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
    EventLoop localEventLoop = eventLoop();
    if (localEventLoop.inEventLoop()) {
      shutdownInput0(paramChannelPromise);
    } else {
      localEventLoop.execute(new Runnable()
      {
        public void run()
        {
          OioSocketChannel.this.shutdownInput0(paramChannelPromise);
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
    EventLoop localEventLoop = eventLoop();
    if (localEventLoop.inEventLoop()) {
      shutdownOutput0(paramChannelPromise);
    } else {
      localEventLoop.execute(new Runnable()
      {
        public void run()
        {
          OioSocketChannel.this.shutdownOutput0(paramChannelPromise);
        }
      });
    }
    return paramChannelPromise;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\socket\oio\OioSocketChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
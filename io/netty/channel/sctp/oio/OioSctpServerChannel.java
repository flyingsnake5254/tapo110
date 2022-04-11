package io.netty.channel.sctp.oio;

import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.sctp.DefaultSctpServerChannelConfig;
import io.netty.channel.sctp.SctpServerChannelConfig;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Deprecated
public class OioSctpServerChannel
  extends AbstractOioMessageChannel
  implements io.netty.channel.sctp.SctpServerChannel
{
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 1);
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioSctpServerChannel.class);
  private final SctpServerChannelConfig config;
  private final com.sun.nio.sctp.SctpServerChannel sch;
  private final Selector selector;
  
  public OioSctpServerChannel()
  {
    this(newServerSocket());
  }
  
  /* Error */
  public OioSctpServerChannel(com.sun.nio.sctp.SctpServerChannel paramSctpServerChannel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: invokespecial 57	io/netty/channel/oio/AbstractOioMessageChannel:<init>	(Lio/netty/channel/Channel;)V
    //   5: aload_0
    //   6: aload_1
    //   7: ldc 59
    //   9: invokestatic 65	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 67	com/sun/nio/sctp/SctpServerChannel
    //   15: putfield 69	io/netty/channel/sctp/oio/OioSctpServerChannel:sch	Lcom/sun/nio/sctp/SctpServerChannel;
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 73	com/sun/nio/sctp/SctpServerChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   23: pop
    //   24: invokestatic 79	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   27: astore_2
    //   28: aload_0
    //   29: aload_2
    //   30: putfield 81	io/netty/channel/sctp/oio/OioSctpServerChannel:selector	Ljava/nio/channels/Selector;
    //   33: aload_1
    //   34: aload_2
    //   35: bipush 16
    //   37: invokevirtual 85	com/sun/nio/sctp/SctpServerChannel:register	(Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   40: pop
    //   41: new 12	io/netty/channel/sctp/oio/OioSctpServerChannel$OioSctpServerChannelConfig
    //   44: astore_2
    //   45: aload_2
    //   46: aload_0
    //   47: aload_0
    //   48: aload_1
    //   49: aconst_null
    //   50: invokespecial 88	io/netty/channel/sctp/oio/OioSctpServerChannel$OioSctpServerChannelConfig:<init>	(Lio/netty/channel/sctp/oio/OioSctpServerChannel;Lio/netty/channel/sctp/oio/OioSctpServerChannel;Lcom/sun/nio/sctp/SctpServerChannel;Lio/netty/channel/sctp/oio/OioSctpServerChannel$1;)V
    //   53: aload_0
    //   54: aload_2
    //   55: putfield 90	io/netty/channel/sctp/oio/OioSctpServerChannel:config	Lio/netty/channel/sctp/SctpServerChannelConfig;
    //   58: return
    //   59: astore_2
    //   60: goto +17 -> 77
    //   63: astore_3
    //   64: new 92	io/netty/channel/ChannelException
    //   67: astore_2
    //   68: aload_2
    //   69: ldc 94
    //   71: aload_3
    //   72: invokespecial 97	io/netty/channel/ChannelException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_2
    //   76: athrow
    //   77: aload_1
    //   78: invokevirtual 100	com/sun/nio/sctp/SctpServerChannel:close	()V
    //   81: goto +15 -> 96
    //   84: astore_1
    //   85: getstatic 34	io/netty/channel/sctp/oio/OioSctpServerChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   88: ldc 102
    //   90: aload_1
    //   91: invokeinterface 107 3 0
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	OioSctpServerChannel
    //   0	98	1	paramSctpServerChannel	com.sun.nio.sctp.SctpServerChannel
    //   27	28	2	localObject1	Object
    //   59	1	2	localObject2	Object
    //   67	30	2	localChannelException	ChannelException
    //   63	9	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	58	59	finally
    //   64	77	59	finally
    //   18	58	63	java/lang/Exception
    //   77	81	84	java/io/IOException
  }
  
  private static com.sun.nio.sctp.SctpServerChannel newServerSocket()
  {
    try
    {
      com.sun.nio.sctp.SctpServerChannel localSctpServerChannel = com.sun.nio.sctp.SctpServerChannel.open();
      return localSctpServerChannel;
    }
    catch (IOException localIOException)
    {
      throw new ChannelException("failed to create a sctp server channel", localIOException);
    }
  }
  
  public Set<InetSocketAddress> allLocalAddresses()
  {
    try
    {
      Object localObject1 = this.sch.getAllLocalAddresses();
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
    //   1: invokevirtual 178	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   4: invokeinterface 183 1 0
    //   9: ifeq +34 -> 43
    //   12: aload_0
    //   13: getfield 69	io/netty/channel/sctp/oio/OioSctpServerChannel:sch	Lcom/sun/nio/sctp/SctpServerChannel;
    //   16: aload_1
    //   17: invokevirtual 186	com/sun/nio/sctp/SctpServerChannel:bindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpServerChannel;
    //   20: pop
    //   21: aload_2
    //   22: invokeinterface 191 1 0
    //   27: pop
    //   28: goto +34 -> 62
    //   31: astore_1
    //   32: aload_2
    //   33: aload_1
    //   34: invokeinterface 195 2 0
    //   39: pop
    //   40: goto +22 -> 62
    //   43: aload_0
    //   44: invokevirtual 178	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   47: new 8	io/netty/channel/sctp/oio/OioSctpServerChannel$1
    //   50: dup
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 198	io/netty/channel/sctp/oio/OioSctpServerChannel$1:<init>	(Lio/netty/channel/sctp/oio/OioSctpServerChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   57: invokeinterface 204 2 0
    //   62: aload_2
    //   63: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	OioSctpServerChannel
    //   0	64	1	paramInetAddress	InetAddress
    //   0	64	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   12	28	31	finally
  }
  
  public SctpServerChannelConfig config()
  {
    return this.config;
  }
  
  protected void doBind(SocketAddress paramSocketAddress)
    throws Exception
  {
    this.sch.bind(paramSocketAddress, this.config.getBacklog());
  }
  
  protected void doClose()
    throws Exception
  {
    try
    {
      this.selector.close();
    }
    catch (IOException localIOException)
    {
      logger.warn("Failed to close a selector.", localIOException);
    }
    this.sch.close();
  }
  
  protected void doConnect(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2)
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  protected void doDisconnect()
    throws Exception
  {
    throw new UnsupportedOperationException();
  }
  
  /* Error */
  protected int doReadMessages(java.util.List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 236	io/netty/channel/sctp/oio/OioSctpServerChannel:isActive	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: iconst_0
    //   14: istore 4
    //   16: iconst_0
    //   17: istore 5
    //   19: iconst_0
    //   20: istore 6
    //   22: aload_2
    //   23: astore 7
    //   25: iload 4
    //   27: istore 8
    //   29: aload_0
    //   30: getfield 81	io/netty/channel/sctp/oio/OioSctpServerChannel:selector	Ljava/nio/channels/Selector;
    //   33: ldc2_w 237
    //   36: invokevirtual 242	java/nio/channels/Selector:select	(J)I
    //   39: ifle +235 -> 274
    //   42: aload_2
    //   43: astore 7
    //   45: iload 4
    //   47: istore 8
    //   49: aload_0
    //   50: getfield 81	io/netty/channel/sctp/oio/OioSctpServerChannel:selector	Ljava/nio/channels/Selector;
    //   53: invokevirtual 245	java/nio/channels/Selector:selectedKeys	()Ljava/util/Set;
    //   56: invokeinterface 138 1 0
    //   61: astore 9
    //   63: iload 6
    //   65: istore 5
    //   67: aload_3
    //   68: astore 7
    //   70: iload 5
    //   72: istore 8
    //   74: aload 9
    //   76: invokeinterface 148 1 0
    //   81: checkcast 247	java/nio/channels/SelectionKey
    //   84: astore 10
    //   86: aload_3
    //   87: astore 7
    //   89: iload 5
    //   91: istore 8
    //   93: aload 9
    //   95: invokeinterface 250 1 0
    //   100: aload_3
    //   101: astore_2
    //   102: iload 5
    //   104: istore 6
    //   106: aload_3
    //   107: astore 7
    //   109: iload 5
    //   111: istore 8
    //   113: aload 10
    //   115: invokevirtual 253	java/nio/channels/SelectionKey:isAcceptable	()Z
    //   118: ifeq +75 -> 193
    //   121: aload_3
    //   122: astore 7
    //   124: iload 5
    //   126: istore 8
    //   128: aload_0
    //   129: getfield 69	io/netty/channel/sctp/oio/OioSctpServerChannel:sch	Lcom/sun/nio/sctp/SctpServerChannel;
    //   132: invokevirtual 257	com/sun/nio/sctp/SctpServerChannel:accept	()Lcom/sun/nio/sctp/SctpChannel;
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: iload 5
    //   140: istore 6
    //   142: aload_3
    //   143: ifnull +50 -> 193
    //   146: aload_3
    //   147: astore 7
    //   149: iload 5
    //   151: istore 8
    //   153: new 259	io/netty/channel/sctp/oio/OioSctpChannel
    //   156: astore_2
    //   157: aload_3
    //   158: astore 7
    //   160: iload 5
    //   162: istore 8
    //   164: aload_2
    //   165: aload_0
    //   166: aload_3
    //   167: invokespecial 262	io/netty/channel/sctp/oio/OioSctpChannel:<init>	(Lio/netty/channel/Channel;Lcom/sun/nio/sctp/SctpChannel;)V
    //   170: aload_3
    //   171: astore 7
    //   173: iload 5
    //   175: istore 8
    //   177: aload_1
    //   178: aload_2
    //   179: invokeinterface 265 2 0
    //   184: pop
    //   185: iload 5
    //   187: iconst_1
    //   188: iadd
    //   189: istore 6
    //   191: aload_3
    //   192: astore_2
    //   193: aload_2
    //   194: astore 7
    //   196: iload 6
    //   198: istore 8
    //   200: aload 9
    //   202: invokeinterface 144 1 0
    //   207: istore 11
    //   209: aload_2
    //   210: astore_3
    //   211: iload 6
    //   213: istore 5
    //   215: iload 11
    //   217: ifne -150 -> 67
    //   220: iload 6
    //   222: ireturn
    //   223: astore_1
    //   224: getstatic 34	io/netty/channel/sctp/oio/OioSctpServerChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   227: ldc_w 267
    //   230: aload_1
    //   231: invokeinterface 107 3 0
    //   236: iload 8
    //   238: istore 5
    //   240: aload 7
    //   242: ifnull +32 -> 274
    //   245: aload 7
    //   247: invokevirtual 270	com/sun/nio/sctp/SctpChannel:close	()V
    //   250: iload 8
    //   252: istore 5
    //   254: goto +20 -> 274
    //   257: astore_1
    //   258: getstatic 34	io/netty/channel/sctp/oio/OioSctpServerChannel:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   261: ldc_w 272
    //   264: aload_1
    //   265: invokeinterface 107 3 0
    //   270: iload 8
    //   272: istore 5
    //   274: iload 5
    //   276: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	OioSctpServerChannel
    //   0	277	1	paramList	java.util.List<Object>
    //   10	200	2	localObject1	Object
    //   12	199	3	localObject2	Object
    //   14	32	4	i	int
    //   17	258	5	j	int
    //   20	201	6	k	int
    //   23	223	7	localObject3	Object
    //   27	244	8	m	int
    //   61	140	9	localIterator	Iterator
    //   84	30	10	localSelectionKey	java.nio.channels.SelectionKey
    //   207	9	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	42	223	finally
    //   49	63	223	finally
    //   74	86	223	finally
    //   93	100	223	finally
    //   113	121	223	finally
    //   128	136	223	finally
    //   153	157	223	finally
    //   164	170	223	finally
    //   177	185	223	finally
    //   200	209	223	finally
    //   245	250	257	finally
  }
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
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
    if ((isOpen()) && (localAddress0() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isOpen()
  {
    return this.sch.isOpen();
  }
  
  public InetSocketAddress localAddress()
  {
    return (InetSocketAddress)super.localAddress();
  }
  
  protected SocketAddress localAddress0()
  {
    try
    {
      Object localObject = this.sch.getAllLocalAddresses().iterator();
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
    //   1: invokevirtual 178	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   4: invokeinterface 183 1 0
    //   9: ifeq +34 -> 43
    //   12: aload_0
    //   13: getfield 69	io/netty/channel/sctp/oio/OioSctpServerChannel:sch	Lcom/sun/nio/sctp/SctpServerChannel;
    //   16: aload_1
    //   17: invokevirtual 302	com/sun/nio/sctp/SctpServerChannel:unbindAddress	(Ljava/net/InetAddress;)Lcom/sun/nio/sctp/SctpServerChannel;
    //   20: pop
    //   21: aload_2
    //   22: invokeinterface 191 1 0
    //   27: pop
    //   28: goto +34 -> 62
    //   31: astore_1
    //   32: aload_2
    //   33: aload_1
    //   34: invokeinterface 195 2 0
    //   39: pop
    //   40: goto +22 -> 62
    //   43: aload_0
    //   44: invokevirtual 178	io/netty/channel/AbstractChannel:eventLoop	()Lio/netty/channel/EventLoop;
    //   47: new 10	io/netty/channel/sctp/oio/OioSctpServerChannel$2
    //   50: dup
    //   51: aload_0
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 303	io/netty/channel/sctp/oio/OioSctpServerChannel$2:<init>	(Lio/netty/channel/sctp/oio/OioSctpServerChannel;Ljava/net/InetAddress;Lio/netty/channel/ChannelPromise;)V
    //   57: invokeinterface 204 2 0
    //   62: aload_2
    //   63: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	OioSctpServerChannel
    //   0	64	1	paramInetAddress	InetAddress
    //   0	64	2	paramChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   12	28	31	finally
  }
  
  private final class OioSctpServerChannelConfig
    extends DefaultSctpServerChannelConfig
  {
    private OioSctpServerChannelConfig(OioSctpServerChannel paramOioSctpServerChannel, com.sun.nio.sctp.SctpServerChannel paramSctpServerChannel)
    {
      super(paramSctpServerChannel);
    }
    
    protected void autoReadCleared()
    {
      OioSctpServerChannel.this.clearReadPending();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\sctp\oio\OioSctpServerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
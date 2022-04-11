package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Deque;

public class DefaultHttp2RemoteFlowController
  implements Http2RemoteFlowController
{
  private static final int MIN_WRITABLE_CHUNK = 32768;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultHttp2RemoteFlowController.class);
  private final Http2Connection connection;
  private final FlowState connectionState;
  private ChannelHandlerContext ctx;
  private int initialWindowSize = 65535;
  private WritabilityMonitor monitor;
  private final Http2Connection.a stateKey;
  private final StreamByteDistributor streamByteDistributor;
  
  public DefaultHttp2RemoteFlowController(Http2Connection paramHttp2Connection)
  {
    this(paramHttp2Connection, null);
  }
  
  public DefaultHttp2RemoteFlowController(Http2Connection paramHttp2Connection, Http2RemoteFlowController.Listener paramListener)
  {
    this(paramHttp2Connection, new WeightedFairQueueByteDistributor(paramHttp2Connection), paramListener);
  }
  
  public DefaultHttp2RemoteFlowController(Http2Connection paramHttp2Connection, StreamByteDistributor paramStreamByteDistributor)
  {
    this(paramHttp2Connection, paramStreamByteDistributor, null);
  }
  
  public DefaultHttp2RemoteFlowController(Http2Connection paramHttp2Connection, StreamByteDistributor paramStreamByteDistributor, Http2RemoteFlowController.Listener paramListener)
  {
    this.connection = ((Http2Connection)ObjectUtil.checkNotNull(paramHttp2Connection, "connection"));
    this.streamByteDistributor = ((StreamByteDistributor)ObjectUtil.checkNotNull(paramStreamByteDistributor, "streamWriteDistributor"));
    Http2Connection.a locala = paramHttp2Connection.newKey();
    this.stateKey = locala;
    paramStreamByteDistributor = new FlowState(paramHttp2Connection.connectionStream());
    this.connectionState = paramStreamByteDistributor;
    paramHttp2Connection.connectionStream().setProperty(locala, paramStreamByteDistributor);
    listener(paramListener);
    this.monitor.windowSize(paramStreamByteDistributor, this.initialWindowSize);
    paramHttp2Connection.addListener(new Http2ConnectionAdapter()
    {
      public void onStreamActive(Http2Stream paramAnonymousHttp2Stream)
      {
        DefaultHttp2RemoteFlowController.this.monitor.windowSize(DefaultHttp2RemoteFlowController.this.state(paramAnonymousHttp2Stream), DefaultHttp2RemoteFlowController.this.initialWindowSize);
      }
      
      public void onStreamAdded(Http2Stream paramAnonymousHttp2Stream)
      {
        paramAnonymousHttp2Stream.setProperty(DefaultHttp2RemoteFlowController.this.stateKey, new DefaultHttp2RemoteFlowController.FlowState(DefaultHttp2RemoteFlowController.this, paramAnonymousHttp2Stream));
      }
      
      public void onStreamClosed(Http2Stream paramAnonymousHttp2Stream)
      {
        DefaultHttp2RemoteFlowController.this.state(paramAnonymousHttp2Stream).cancel(Http2Error.STREAM_CLOSED, null);
      }
      
      public void onStreamHalfClosed(Http2Stream paramAnonymousHttp2Stream)
      {
        if (Http2Stream.State.HALF_CLOSED_LOCAL == paramAnonymousHttp2Stream.state()) {
          DefaultHttp2RemoteFlowController.this.state(paramAnonymousHttp2Stream).cancel(Http2Error.STREAM_CLOSED, null);
        }
      }
    });
  }
  
  private int connectionWindowSize()
  {
    return this.connectionState.windowSize();
  }
  
  private boolean isChannelWritable()
  {
    boolean bool;
    if ((this.ctx != null) && (isChannelWritable0())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isChannelWritable0()
  {
    return this.ctx.channel().isWritable();
  }
  
  private int maxUsableChannelBytes()
  {
    int i = (int)Math.min(2147483647L, this.ctx.channel().bytesBeforeUnwritable());
    if (i > 0) {
      i = Math.max(i, minUsableChannelBytes());
    } else {
      i = 0;
    }
    return Math.min(this.connectionState.windowSize(), i);
  }
  
  private int minUsableChannelBytes()
  {
    return Math.max(this.ctx.channel().config().getWriteBufferLowWaterMark(), 32768);
  }
  
  private FlowState state(Http2Stream paramHttp2Stream)
  {
    return (FlowState)paramHttp2Stream.getProperty(this.stateKey);
  }
  
  private int writableBytes()
  {
    return Math.min(connectionWindowSize(), maxUsableChannelBytes());
  }
  
  /* Error */
  public void addFlowControlled(Http2Stream paramHttp2Stream, Http2RemoteFlowController.FlowControlled paramFlowControlled)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc -33
    //   3: invokestatic 76	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 113	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController:monitor	Lio/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$WritabilityMonitor;
    //   11: aload_0
    //   12: aload_1
    //   13: invokespecial 132	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController:state	(Lio/netty/handler/codec/http2/Http2Stream;)Lio/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState;
    //   16: aload_2
    //   17: invokevirtual 227	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$WritabilityMonitor:enqueueFrame	(Lio/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState;Lio/netty/handler/codec/http2/Http2RemoteFlowController$FlowControlled;)V
    //   20: goto +15 -> 35
    //   23: astore_1
    //   24: aload_2
    //   25: aload_0
    //   26: getfield 156	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController:ctx	Lio/netty/channel/ChannelHandlerContext;
    //   29: aload_1
    //   30: invokeinterface 233 3 0
    //   35: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	DefaultHttp2RemoteFlowController
    //   0	36	1	paramHttp2Stream	Http2Stream
    //   0	36	2	paramFlowControlled	Http2RemoteFlowController.FlowControlled
    // Exception table:
    //   from	to	target	type
    //   7	20	23	finally
  }
  
  public ChannelHandlerContext channelHandlerContext()
  {
    return this.ctx;
  }
  
  public void channelHandlerContext(ChannelHandlerContext paramChannelHandlerContext)
    throws Http2Exception
  {
    this.ctx = ((ChannelHandlerContext)ObjectUtil.checkNotNull(paramChannelHandlerContext, "ctx"));
    channelWritabilityChanged();
    if (isChannelWritable()) {
      writePendingBytes();
    }
  }
  
  public void channelWritabilityChanged()
    throws Http2Exception
  {
    this.monitor.channelWritabilityChange();
  }
  
  public boolean hasFlowControlled(Http2Stream paramHttp2Stream)
  {
    return state(paramHttp2Stream).hasFrame();
  }
  
  public void incrementWindowSize(Http2Stream paramHttp2Stream, int paramInt)
    throws Http2Exception
  {
    this.monitor.incrementWindowSize(state(paramHttp2Stream), paramInt);
  }
  
  public int initialWindowSize()
  {
    return this.initialWindowSize;
  }
  
  public void initialWindowSize(int paramInt)
    throws Http2Exception
  {
    this.monitor.initialWindowSize(paramInt);
  }
  
  public boolean isWritable(Http2Stream paramHttp2Stream)
  {
    return this.monitor.isWritable(state(paramHttp2Stream));
  }
  
  public void listener(Http2RemoteFlowController.Listener paramListener)
  {
    if (paramListener == null) {
      paramListener = new WritabilityMonitor(null);
    } else {
      paramListener = new ListenerWritabilityMonitor(paramListener);
    }
    this.monitor = paramListener;
  }
  
  public void updateDependencyTree(int paramInt1, int paramInt2, short paramShort, boolean paramBoolean)
  {
    this.streamByteDistributor.updateDependencyTree(paramInt1, paramInt2, paramShort, paramBoolean);
  }
  
  public int windowSize(Http2Stream paramHttp2Stream)
  {
    return state(paramHttp2Stream).windowSize();
  }
  
  public void writePendingBytes()
    throws Http2Exception
  {
    this.monitor.writePendingBytes();
  }
  
  private final class FlowState
    implements StreamByteDistributor.StreamState
  {
    private boolean cancelled;
    private boolean markedWritable;
    private long pendingBytes;
    private final Deque<Http2RemoteFlowController.FlowControlled> pendingWriteQueue;
    private final Http2Stream stream;
    private int window;
    private boolean writing;
    
    FlowState(Http2Stream paramHttp2Stream)
    {
      this.stream = paramHttp2Stream;
      this.pendingWriteQueue = new ArrayDeque(2);
    }
    
    private void decrementFlowControlWindow(int paramInt)
    {
      paramInt = -paramInt;
      try
      {
        DefaultHttp2RemoteFlowController.this.connectionState.incrementStreamWindow(paramInt);
        incrementStreamWindow(paramInt);
        return;
      }
      catch (Http2Exception localHttp2Exception)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid window state when writing frame: ");
        localStringBuilder.append(localHttp2Exception.getMessage());
        throw new IllegalStateException(localStringBuilder.toString(), localHttp2Exception);
      }
    }
    
    private void decrementPendingBytes(int paramInt, boolean paramBoolean)
    {
      incrementPendingBytes(-paramInt, paramBoolean);
    }
    
    private void enqueueFrameWithoutMerge(Http2RemoteFlowController.FlowControlled paramFlowControlled)
    {
      this.pendingWriteQueue.offer(paramFlowControlled);
      incrementPendingBytes(paramFlowControlled.size(), true);
    }
    
    private void incrementPendingBytes(int paramInt, boolean paramBoolean)
    {
      this.pendingBytes += paramInt;
      DefaultHttp2RemoteFlowController.this.monitor.incrementPendingBytes(paramInt);
      if (paramBoolean) {
        DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
      }
    }
    
    private Http2RemoteFlowController.FlowControlled peek()
    {
      return (Http2RemoteFlowController.FlowControlled)this.pendingWriteQueue.peek();
    }
    
    private int writableWindow()
    {
      return Math.min(this.window, DefaultHttp2RemoteFlowController.this.connectionWindowSize());
    }
    
    private void writeError(Http2RemoteFlowController.FlowControlled paramFlowControlled, Http2Exception paramHttp2Exception)
    {
      decrementPendingBytes(paramFlowControlled.size(), true);
      paramFlowControlled.error(DefaultHttp2RemoteFlowController.this.ctx, paramHttp2Exception);
    }
    
    void cancel(Http2Error paramHttp2Error, Throwable paramThrowable)
    {
      this.cancelled = true;
      if (this.writing) {
        return;
      }
      Http2RemoteFlowController.FlowControlled localFlowControlled = (Http2RemoteFlowController.FlowControlled)this.pendingWriteQueue.poll();
      if (localFlowControlled != null)
      {
        Http2Exception localHttp2Exception = Http2Exception.streamError(this.stream.id(), paramHttp2Error, paramThrowable, "Stream closed before write could take place", new Object[0]);
        paramHttp2Error = localFlowControlled;
        do
        {
          writeError(paramHttp2Error, localHttp2Exception);
          paramThrowable = (Http2RemoteFlowController.FlowControlled)this.pendingWriteQueue.poll();
          paramHttp2Error = paramThrowable;
        } while (paramThrowable != null);
      }
      DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
      DefaultHttp2RemoteFlowController.this.monitor.stateCancelled(this);
    }
    
    void enqueueFrame(Http2RemoteFlowController.FlowControlled paramFlowControlled)
    {
      Http2RemoteFlowController.FlowControlled localFlowControlled = (Http2RemoteFlowController.FlowControlled)this.pendingWriteQueue.peekLast();
      if (localFlowControlled == null)
      {
        enqueueFrameWithoutMerge(paramFlowControlled);
        return;
      }
      int i = localFlowControlled.size();
      if (localFlowControlled.merge(DefaultHttp2RemoteFlowController.this.ctx, paramFlowControlled))
      {
        incrementPendingBytes(localFlowControlled.size() - i, true);
        return;
      }
      enqueueFrameWithoutMerge(paramFlowControlled);
    }
    
    public boolean hasFrame()
    {
      return this.pendingWriteQueue.isEmpty() ^ true;
    }
    
    int incrementStreamWindow(int paramInt)
      throws Http2Exception
    {
      if ((paramInt > 0) && (Integer.MAX_VALUE - paramInt < this.window)) {
        throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Window size overflow for stream: %d", new Object[] { Integer.valueOf(this.stream.id()) });
      }
      this.window += paramInt;
      DefaultHttp2RemoteFlowController.this.streamByteDistributor.updateStreamableBytes(this);
      return this.window;
    }
    
    boolean isWritable()
    {
      boolean bool;
      if ((windowSize() > pendingBytes()) && (!this.cancelled)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void markedWritability(boolean paramBoolean)
    {
      this.markedWritable = paramBoolean;
    }
    
    boolean markedWritability()
    {
      return this.markedWritable;
    }
    
    public long pendingBytes()
    {
      return this.pendingBytes;
    }
    
    public Http2Stream stream()
    {
      return this.stream;
    }
    
    public int windowSize()
    {
      return this.window;
    }
    
    void windowSize(int paramInt)
    {
      this.window = paramInt;
    }
    
    /* Error */
    int writeAllocatedBytes(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_1
      //   2: putfield 155	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:writing	Z
      //   5: iload_1
      //   6: istore_2
      //   7: iconst_0
      //   8: istore_3
      //   9: iload_2
      //   10: istore 4
      //   12: aload_0
      //   13: getfield 153	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancelled	Z
      //   16: ifne +152 -> 168
      //   19: iload_2
      //   20: istore 4
      //   22: aload_0
      //   23: invokespecial 224	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:peek	()Lio/netty/handler/codec/http2/Http2RemoteFlowController$FlowControlled;
      //   26: astore 5
      //   28: aload 5
      //   30: ifnull +138 -> 168
      //   33: iload_2
      //   34: istore 4
      //   36: iload_2
      //   37: aload_0
      //   38: invokespecial 226	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:writableWindow	()I
      //   41: invokestatic 137	java/lang/Math:min	(II)I
      //   44: istore 6
      //   46: iload 6
      //   48: ifgt +19 -> 67
      //   51: iload_2
      //   52: istore 4
      //   54: aload 5
      //   56: invokeinterface 99 1 0
      //   61: ifle +6 -> 67
      //   64: goto +104 -> 168
      //   67: iload_2
      //   68: istore 4
      //   70: aload 5
      //   72: invokeinterface 99 1 0
      //   77: istore_3
      //   78: aload 5
      //   80: aload_0
      //   81: getfield 33	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:this$0	Lio/netty/handler/codec/http2/DefaultHttp2RemoteFlowController;
      //   84: invokestatic 145	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController:access$500	(Lio/netty/handler/codec/http2/DefaultHttp2RemoteFlowController;)Lio/netty/channel/ChannelHandlerContext;
      //   87: iconst_0
      //   88: iload 6
      //   90: invokestatic 229	java/lang/Math:max	(II)I
      //   93: invokeinterface 233 3 0
      //   98: aload 5
      //   100: invokeinterface 99 1 0
      //   105: ifne +20 -> 125
      //   108: aload_0
      //   109: getfield 44	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:pendingWriteQueue	Ljava/util/Deque;
      //   112: invokeinterface 236 1 0
      //   117: pop
      //   118: aload 5
      //   120: invokeinterface 239 1 0
      //   125: iload_2
      //   126: istore 4
      //   128: iload_2
      //   129: iload_3
      //   130: aload 5
      //   132: invokeinterface 99 1 0
      //   137: isub
      //   138: isub
      //   139: istore_2
      //   140: iconst_1
      //   141: istore_3
      //   142: goto -133 -> 9
      //   145: astore 7
      //   147: iload_2
      //   148: istore 4
      //   150: iload_2
      //   151: iload_3
      //   152: aload 5
      //   154: invokeinterface 99 1 0
      //   159: isub
      //   160: isub
      //   161: istore_2
      //   162: iload_2
      //   163: istore 4
      //   165: aload 7
      //   167: athrow
      //   168: iload_3
      //   169: ifne +40 -> 209
      //   172: aload_0
      //   173: iconst_0
      //   174: putfield 155	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:writing	Z
      //   177: iload_1
      //   178: iload_2
      //   179: isub
      //   180: istore_1
      //   181: aload_0
      //   182: iload_1
      //   183: iconst_0
      //   184: invokespecial 141	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementPendingBytes	(IZ)V
      //   187: aload_0
      //   188: iload_1
      //   189: invokespecial 241	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementFlowControlWindow	(I)V
      //   192: aload_0
      //   193: getfield 153	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancelled	Z
      //   196: ifeq +11 -> 207
      //   199: aload_0
      //   200: getstatic 244	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   203: aconst_null
      //   204: invokevirtual 246	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancel	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;)V
      //   207: iconst_m1
      //   208: ireturn
      //   209: aload_0
      //   210: iconst_0
      //   211: putfield 155	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:writing	Z
      //   214: iload_1
      //   215: iload_2
      //   216: isub
      //   217: istore 4
      //   219: aload_0
      //   220: iload 4
      //   222: iconst_0
      //   223: invokespecial 141	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementPendingBytes	(IZ)V
      //   226: aload_0
      //   227: iload 4
      //   229: invokespecial 241	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementFlowControlWindow	(I)V
      //   232: iload 4
      //   234: istore_1
      //   235: aload_0
      //   236: getfield 153	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancelled	Z
      //   239: ifeq +78 -> 317
      //   242: aload_0
      //   243: getstatic 244	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   246: aconst_null
      //   247: invokevirtual 246	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancel	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;)V
      //   250: iload 4
      //   252: istore_1
      //   253: goto +64 -> 317
      //   256: astore 7
      //   258: goto +8 -> 266
      //   261: astore 7
      //   263: iload_1
      //   264: istore 4
      //   266: aload_0
      //   267: iconst_1
      //   268: putfield 153	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancelled	Z
      //   271: aload_0
      //   272: iconst_0
      //   273: putfield 155	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:writing	Z
      //   276: iload_1
      //   277: iload 4
      //   279: isub
      //   280: istore 4
      //   282: aload_0
      //   283: iload 4
      //   285: iconst_0
      //   286: invokespecial 141	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementPendingBytes	(IZ)V
      //   289: aload_0
      //   290: iload 4
      //   292: invokespecial 241	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementFlowControlWindow	(I)V
      //   295: iload 4
      //   297: istore_1
      //   298: aload_0
      //   299: getfield 153	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancelled	Z
      //   302: ifeq +15 -> 317
      //   305: aload_0
      //   306: getstatic 244	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   309: aload 7
      //   311: invokevirtual 246	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancel	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;)V
      //   314: iload 4
      //   316: istore_1
      //   317: iload_1
      //   318: ireturn
      //   319: astore 7
      //   321: aload_0
      //   322: iconst_0
      //   323: putfield 155	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:writing	Z
      //   326: iload_1
      //   327: iload 4
      //   329: isub
      //   330: istore_1
      //   331: aload_0
      //   332: iload_1
      //   333: iconst_0
      //   334: invokespecial 141	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementPendingBytes	(IZ)V
      //   337: aload_0
      //   338: iload_1
      //   339: invokespecial 241	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:decrementFlowControlWindow	(I)V
      //   342: aload_0
      //   343: getfield 153	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancelled	Z
      //   346: ifeq +11 -> 357
      //   349: aload_0
      //   350: getstatic 244	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   353: aconst_null
      //   354: invokevirtual 246	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:cancel	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;)V
      //   357: aload 7
      //   359: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	360	0	this	FlowState
      //   0	360	1	paramInt	int
      //   6	211	2	i	int
      //   8	161	3	j	int
      //   10	320	4	k	int
      //   26	127	5	localFlowControlled	Http2RemoteFlowController.FlowControlled
      //   44	45	6	m	int
      //   145	21	7	localObject1	Object
      //   256	1	7	localObject2	Object
      //   261	49	7	localThrowable	Throwable
      //   319	39	7	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   78	125	145	finally
      //   12	19	256	finally
      //   22	28	256	finally
      //   36	46	256	finally
      //   54	64	256	finally
      //   70	78	256	finally
      //   128	140	256	finally
      //   150	162	256	finally
      //   165	168	256	finally
      //   0	5	261	finally
      //   266	271	319	finally
    }
  }
  
  private final class ListenerWritabilityMonitor
    extends DefaultHttp2RemoteFlowController.WritabilityMonitor
    implements Http2StreamVisitor
  {
    private final Http2RemoteFlowController.Listener listener;
    
    ListenerWritabilityMonitor(Http2RemoteFlowController.Listener paramListener)
    {
      super(null);
      this.listener = paramListener;
    }
    
    private void checkAllWritabilityChanged()
      throws Http2Exception
    {
      DefaultHttp2RemoteFlowController.this.connectionState.markedWritability(isWritableConnection());
      DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(this);
    }
    
    private void checkConnectionThenStreamWritabilityChanged(DefaultHttp2RemoteFlowController.FlowState paramFlowState)
      throws Http2Exception
    {
      if (isWritableConnection() != DefaultHttp2RemoteFlowController.this.connectionState.markedWritability()) {
        checkAllWritabilityChanged();
      } else if (isWritable(paramFlowState) != paramFlowState.markedWritability()) {
        notifyWritabilityChanged(paramFlowState);
      }
    }
    
    private void checkStateWritability(DefaultHttp2RemoteFlowController.FlowState paramFlowState)
      throws Http2Exception
    {
      if (isWritable(paramFlowState) != paramFlowState.markedWritability()) {
        if (paramFlowState == DefaultHttp2RemoteFlowController.this.connectionState) {
          checkAllWritabilityChanged();
        } else {
          notifyWritabilityChanged(paramFlowState);
        }
      }
    }
    
    /* Error */
    private void notifyWritabilityChanged(DefaultHttp2RemoteFlowController.FlowState paramFlowState)
    {
      // Byte code:
      //   0: aload_1
      //   1: aload_1
      //   2: invokevirtual 56	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:markedWritability	()Z
      //   5: iconst_1
      //   6: ixor
      //   7: invokevirtual 41	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:markedWritability	(Z)V
      //   10: aload_0
      //   11: getfield 22	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$ListenerWritabilityMonitor:listener	Lio/netty/handler/codec/http2/Http2RemoteFlowController$Listener;
      //   14: aload_1
      //   15: invokestatic 70	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState:access$1300	(Lio/netty/handler/codec/http2/DefaultHttp2RemoteFlowController$FlowState;)Lio/netty/handler/codec/http2/Http2Stream;
      //   18: invokeinterface 76 2 0
      //   23: goto +15 -> 38
      //   26: astore_1
      //   27: invokestatic 80	io/netty/handler/codec/http2/DefaultHttp2RemoteFlowController:access$1400	()Lio/netty/util/internal/logging/InternalLogger;
      //   30: ldc 82
      //   32: aload_1
      //   33: invokeinterface 88 3 0
      //   38: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	ListenerWritabilityMonitor
      //   0	39	1	paramFlowState	DefaultHttp2RemoteFlowController.FlowState
      // Exception table:
      //   from	to	target	type
      //   10	23	26	finally
    }
    
    void channelWritabilityChange()
      throws Http2Exception
    {
      if (DefaultHttp2RemoteFlowController.this.connectionState.markedWritability() != DefaultHttp2RemoteFlowController.this.isChannelWritable()) {
        checkAllWritabilityChanged();
      }
    }
    
    void enqueueFrame(DefaultHttp2RemoteFlowController.FlowState paramFlowState, Http2RemoteFlowController.FlowControlled paramFlowControlled)
      throws Http2Exception
    {
      super.enqueueFrame(paramFlowState, paramFlowControlled);
      checkConnectionThenStreamWritabilityChanged(paramFlowState);
    }
    
    void incrementWindowSize(DefaultHttp2RemoteFlowController.FlowState paramFlowState, int paramInt)
      throws Http2Exception
    {
      super.incrementWindowSize(paramFlowState, paramInt);
      checkStateWritability(paramFlowState);
    }
    
    void initialWindowSize(int paramInt)
      throws Http2Exception
    {
      super.initialWindowSize(paramInt);
      if (isWritableConnection()) {
        checkAllWritabilityChanged();
      }
    }
    
    void stateCancelled(DefaultHttp2RemoteFlowController.FlowState paramFlowState)
    {
      try
      {
        checkConnectionThenStreamWritabilityChanged(paramFlowState);
        return;
      }
      catch (Http2Exception paramFlowState)
      {
        throw new RuntimeException("Caught unexpected exception from checkAllWritabilityChanged", paramFlowState);
      }
    }
    
    public boolean visit(Http2Stream paramHttp2Stream)
      throws Http2Exception
    {
      paramHttp2Stream = DefaultHttp2RemoteFlowController.this.state(paramHttp2Stream);
      if (isWritable(paramHttp2Stream) != paramHttp2Stream.markedWritability()) {
        notifyWritabilityChanged(paramHttp2Stream);
      }
      return true;
    }
    
    void windowSize(DefaultHttp2RemoteFlowController.FlowState paramFlowState, int paramInt)
    {
      super.windowSize(paramFlowState, paramInt);
      try
      {
        checkStateWritability(paramFlowState);
        return;
      }
      catch (Http2Exception paramFlowState)
      {
        throw new RuntimeException("Caught unexpected exception from window", paramFlowState);
      }
    }
  }
  
  private class WritabilityMonitor
    implements StreamByteDistributor.Writer
  {
    private boolean inWritePendingBytes;
    private long totalPendingBytes;
    
    private WritabilityMonitor() {}
    
    void channelWritabilityChange()
      throws Http2Exception
    {}
    
    void enqueueFrame(DefaultHttp2RemoteFlowController.FlowState paramFlowState, Http2RemoteFlowController.FlowControlled paramFlowControlled)
      throws Http2Exception
    {
      paramFlowState.enqueueFrame(paramFlowControlled);
    }
    
    final void incrementPendingBytes(int paramInt)
    {
      this.totalPendingBytes += paramInt;
    }
    
    void incrementWindowSize(DefaultHttp2RemoteFlowController.FlowState paramFlowState, int paramInt)
      throws Http2Exception
    {
      paramFlowState.incrementStreamWindow(paramInt);
    }
    
    void initialWindowSize(int paramInt)
      throws Http2Exception
    {
      ObjectUtil.checkPositiveOrZero(paramInt, "newWindowSize");
      final int i = paramInt - DefaultHttp2RemoteFlowController.this.initialWindowSize;
      DefaultHttp2RemoteFlowController.access$202(DefaultHttp2RemoteFlowController.this, paramInt);
      DefaultHttp2RemoteFlowController.this.connection.forEachActiveStream(new Http2StreamVisitor()
      {
        public boolean visit(Http2Stream paramAnonymousHttp2Stream)
          throws Http2Exception
        {
          DefaultHttp2RemoteFlowController.this.state(paramAnonymousHttp2Stream).incrementStreamWindow(i);
          return true;
        }
      });
      if ((i > 0) && (DefaultHttp2RemoteFlowController.this.isChannelWritable())) {
        writePendingBytes();
      }
    }
    
    final boolean isWritable(DefaultHttp2RemoteFlowController.FlowState paramFlowState)
    {
      boolean bool;
      if ((isWritableConnection()) && (paramFlowState.isWritable())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    final boolean isWritableConnection()
    {
      boolean bool;
      if ((DefaultHttp2RemoteFlowController.this.connectionState.windowSize() - this.totalPendingBytes > 0L) && (DefaultHttp2RemoteFlowController.this.isChannelWritable())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    void stateCancelled(DefaultHttp2RemoteFlowController.FlowState paramFlowState) {}
    
    void windowSize(DefaultHttp2RemoteFlowController.FlowState paramFlowState, int paramInt)
    {
      paramFlowState.windowSize(paramInt);
    }
    
    public final void write(Http2Stream paramHttp2Stream, int paramInt)
    {
      DefaultHttp2RemoteFlowController.this.state(paramHttp2Stream).writeAllocatedBytes(paramInt);
    }
    
    final void writePendingBytes()
      throws Http2Exception
    {
      if (this.inWritePendingBytes) {
        return;
      }
      this.inWritePendingBytes = true;
      try
      {
        int i = DefaultHttp2RemoteFlowController.this.writableBytes();
        boolean bool;
        do
        {
          if (!DefaultHttp2RemoteFlowController.this.streamByteDistributor.distribute(i, this)) {
            break;
          }
          i = DefaultHttp2RemoteFlowController.this.writableBytes();
          if (i <= 0) {
            break;
          }
          bool = DefaultHttp2RemoteFlowController.this.isChannelWritable0();
        } while (bool);
        return;
      }
      finally
      {
        this.inWritePendingBytes = false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2RemoteFlowController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
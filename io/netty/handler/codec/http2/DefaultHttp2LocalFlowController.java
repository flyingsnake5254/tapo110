package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.util.internal.ObjectUtil;

public class DefaultHttp2LocalFlowController
  implements Http2LocalFlowController
{
  public static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5F;
  private static final FlowState REDUCED_FLOW_STATE = new FlowState()
  {
    public boolean consumeBytes(int paramAnonymousInt)
      throws Http2Exception
    {
      return false;
    }
    
    public void endOfStream(boolean paramAnonymousBoolean)
    {
      throw new UnsupportedOperationException();
    }
    
    public void incrementFlowControlWindows(int paramAnonymousInt)
      throws Http2Exception
    {}
    
    public void incrementInitialStreamWindow(int paramAnonymousInt) {}
    
    public int initialWindowSize()
    {
      return 0;
    }
    
    public void receiveFlowControlledFrame(int paramAnonymousInt)
      throws Http2Exception
    {
      throw new UnsupportedOperationException();
    }
    
    public int unconsumedBytes()
    {
      return 0;
    }
    
    public void window(int paramAnonymousInt)
    {
      throw new UnsupportedOperationException();
    }
    
    public int windowSize()
    {
      return 0;
    }
    
    public float windowUpdateRatio()
    {
      throw new UnsupportedOperationException();
    }
    
    public void windowUpdateRatio(float paramAnonymousFloat)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean writeWindowUpdateIfNeeded()
      throws Http2Exception
    {
      throw new UnsupportedOperationException();
    }
  };
  private final Http2Connection connection;
  private ChannelHandlerContext ctx;
  private Http2FrameWriter frameWriter;
  private int initialWindowSize = 65535;
  private final Http2Connection.a stateKey;
  private float windowUpdateRatio;
  
  public DefaultHttp2LocalFlowController(Http2Connection paramHttp2Connection)
  {
    this(paramHttp2Connection, 0.5F, false);
  }
  
  public DefaultHttp2LocalFlowController(Http2Connection paramHttp2Connection, float paramFloat, boolean paramBoolean)
  {
    this.connection = ((Http2Connection)ObjectUtil.checkNotNull(paramHttp2Connection, "connection"));
    windowUpdateRatio(paramFloat);
    Http2Connection.a locala = paramHttp2Connection.newKey();
    this.stateKey = locala;
    Object localObject;
    if (paramBoolean) {
      localObject = new AutoRefillState(paramHttp2Connection.connectionStream(), this.initialWindowSize);
    } else {
      localObject = new DefaultState(paramHttp2Connection.connectionStream(), this.initialWindowSize);
    }
    paramHttp2Connection.connectionStream().setProperty(locala, localObject);
    paramHttp2Connection.addListener(new Http2ConnectionAdapter()
    {
      public void onStreamActive(Http2Stream paramAnonymousHttp2Stream)
      {
        Http2Connection.a locala = DefaultHttp2LocalFlowController.this.stateKey;
        DefaultHttp2LocalFlowController localDefaultHttp2LocalFlowController = DefaultHttp2LocalFlowController.this;
        paramAnonymousHttp2Stream.setProperty(locala, new DefaultHttp2LocalFlowController.DefaultState(localDefaultHttp2LocalFlowController, paramAnonymousHttp2Stream, localDefaultHttp2LocalFlowController.initialWindowSize));
      }
      
      public void onStreamAdded(Http2Stream paramAnonymousHttp2Stream)
      {
        paramAnonymousHttp2Stream.setProperty(DefaultHttp2LocalFlowController.this.stateKey, DefaultHttp2LocalFlowController.REDUCED_FLOW_STATE);
      }
      
      /* Error */
      public void onStreamClosed(Http2Stream paramAnonymousHttp2Stream)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 14	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController$1:this$0	Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;
        //   4: aload_1
        //   5: invokestatic 51	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$300	(Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;Lio/netty/handler/codec/http2/Http2Stream;)Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController$FlowState;
        //   8: astore_2
        //   9: aload_2
        //   10: invokeinterface 57 1 0
        //   15: istore_3
        //   16: aload_0
        //   17: getfield 14	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController$1:this$0	Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;
        //   20: invokestatic 61	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$400	(Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;)Lio/netty/channel/ChannelHandlerContext;
        //   23: ifnull +44 -> 67
        //   26: iload_3
        //   27: ifle +40 -> 67
        //   30: aload_0
        //   31: getfield 14	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController$1:this$0	Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;
        //   34: aload_2
        //   35: iload_3
        //   36: invokestatic 65	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$500	(Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController$FlowState;I)Z
        //   39: ifeq +28 -> 67
        //   42: aload_0
        //   43: getfield 14	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController$1:this$0	Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;
        //   46: invokestatic 61	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$400	(Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;)Lio/netty/channel/ChannelHandlerContext;
        //   49: invokeinterface 71 1 0
        //   54: pop
        //   55: goto +12 -> 67
        //   58: astore_2
        //   59: goto +26 -> 85
        //   62: astore_2
        //   63: aload_2
        //   64: invokestatic 77	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
        //   67: aload_1
        //   68: aload_0
        //   69: getfield 14	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController$1:this$0	Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;
        //   72: invokestatic 24	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$000	(Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;)Lio/netty/handler/codec/http2/Http2Connection$a;
        //   75: invokestatic 44	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$100	()Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController$FlowState;
        //   78: invokeinterface 39 3 0
        //   83: pop
        //   84: return
        //   85: aload_1
        //   86: aload_0
        //   87: getfield 14	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController$1:this$0	Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;
        //   90: invokestatic 24	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$000	(Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController;)Lio/netty/handler/codec/http2/Http2Connection$a;
        //   93: invokestatic 44	io/netty/handler/codec/http2/DefaultHttp2LocalFlowController:access$100	()Lio/netty/handler/codec/http2/DefaultHttp2LocalFlowController$FlowState;
        //   96: invokeinterface 39 3 0
        //   101: pop
        //   102: aload_2
        //   103: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	104	0	this	1
        //   0	104	1	paramAnonymousHttp2Stream	Http2Stream
        //   8	27	2	localFlowState	DefaultHttp2LocalFlowController.FlowState
        //   58	1	2	localObject	Object
        //   62	41	2	localHttp2Exception	Http2Exception
        //   15	21	3	i	int
        // Exception table:
        //   from	to	target	type
        //   0	26	58	finally
        //   30	55	58	finally
        //   63	67	58	finally
        //   0	26	62	io/netty/handler/codec/http2/Http2Exception
        //   30	55	62	io/netty/handler/codec/http2/Http2Exception
      }
    });
  }
  
  private static void checkValidRatio(float paramFloat)
  {
    double d = paramFloat;
    if ((Double.compare(d, 0.0D) > 0) && (Double.compare(d, 1.0D) < 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid ratio: ");
    localStringBuilder.append(paramFloat);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private FlowState connectionState()
  {
    return (FlowState)this.connection.connectionStream().getProperty(this.stateKey);
  }
  
  private boolean consumeAllBytes(FlowState paramFlowState, int paramInt)
    throws Http2Exception
  {
    boolean bool = connectionState().consumeBytes(paramInt);
    return paramFlowState.consumeBytes(paramInt) | bool;
  }
  
  private static boolean isClosed(Http2Stream paramHttp2Stream)
  {
    boolean bool;
    if (paramHttp2Stream.state() == Http2Stream.State.CLOSED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private FlowState state(Http2Stream paramHttp2Stream)
  {
    return (FlowState)paramHttp2Stream.getProperty(this.stateKey);
  }
  
  public void channelHandlerContext(ChannelHandlerContext paramChannelHandlerContext)
  {
    this.ctx = ((ChannelHandlerContext)ObjectUtil.checkNotNull(paramChannelHandlerContext, "ctx"));
  }
  
  public boolean consumeBytes(Http2Stream paramHttp2Stream, int paramInt)
    throws Http2Exception
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "numBytes");
    if (paramInt == 0) {
      return false;
    }
    if ((paramHttp2Stream != null) && (!isClosed(paramHttp2Stream)))
    {
      if (paramHttp2Stream.id() != 0) {
        return consumeAllBytes(state(paramHttp2Stream), paramInt);
      }
      throw new UnsupportedOperationException("Returning bytes for the connection window is not supported");
    }
    return false;
  }
  
  public DefaultHttp2LocalFlowController frameWriter(Http2FrameWriter paramHttp2FrameWriter)
  {
    this.frameWriter = ((Http2FrameWriter)ObjectUtil.checkNotNull(paramHttp2FrameWriter, "frameWriter"));
    return this;
  }
  
  public void incrementWindowSize(Http2Stream paramHttp2Stream, int paramInt)
    throws Http2Exception
  {
    paramHttp2Stream = state(paramHttp2Stream);
    paramHttp2Stream.incrementInitialStreamWindow(paramInt);
    paramHttp2Stream.writeWindowUpdateIfNeeded();
  }
  
  public int initialWindowSize()
  {
    return this.initialWindowSize;
  }
  
  public int initialWindowSize(Http2Stream paramHttp2Stream)
  {
    return state(paramHttp2Stream).initialWindowSize();
  }
  
  public void initialWindowSize(int paramInt)
    throws Http2Exception
  {
    int i = this.initialWindowSize;
    this.initialWindowSize = paramInt;
    WindowUpdateVisitor localWindowUpdateVisitor = new WindowUpdateVisitor(paramInt - i);
    this.connection.forEachActiveStream(localWindowUpdateVisitor);
    localWindowUpdateVisitor.throwIfError();
  }
  
  public void receiveFlowControlledFrame(Http2Stream paramHttp2Stream, ByteBuf paramByteBuf, int paramInt, boolean paramBoolean)
    throws Http2Exception
  {
    paramInt = paramByteBuf.readableBytes() + paramInt;
    paramByteBuf = connectionState();
    paramByteBuf.receiveFlowControlledFrame(paramInt);
    if ((paramHttp2Stream != null) && (!isClosed(paramHttp2Stream)))
    {
      paramHttp2Stream = state(paramHttp2Stream);
      paramHttp2Stream.endOfStream(paramBoolean);
      paramHttp2Stream.receiveFlowControlledFrame(paramInt);
    }
    else if (paramInt > 0)
    {
      paramByteBuf.consumeBytes(paramInt);
    }
  }
  
  public int unconsumedBytes(Http2Stream paramHttp2Stream)
  {
    return state(paramHttp2Stream).unconsumedBytes();
  }
  
  public int windowSize(Http2Stream paramHttp2Stream)
  {
    return state(paramHttp2Stream).windowSize();
  }
  
  public float windowUpdateRatio()
  {
    return this.windowUpdateRatio;
  }
  
  public float windowUpdateRatio(Http2Stream paramHttp2Stream)
    throws Http2Exception
  {
    return state(paramHttp2Stream).windowUpdateRatio();
  }
  
  public void windowUpdateRatio(float paramFloat)
  {
    checkValidRatio(paramFloat);
    this.windowUpdateRatio = paramFloat;
  }
  
  public void windowUpdateRatio(Http2Stream paramHttp2Stream, float paramFloat)
    throws Http2Exception
  {
    checkValidRatio(paramFloat);
    paramHttp2Stream = state(paramHttp2Stream);
    paramHttp2Stream.windowUpdateRatio(paramFloat);
    paramHttp2Stream.writeWindowUpdateIfNeeded();
  }
  
  private final class AutoRefillState
    extends DefaultHttp2LocalFlowController.DefaultState
  {
    AutoRefillState(Http2Stream paramHttp2Stream, int paramInt)
    {
      super(paramHttp2Stream, paramInt);
    }
    
    public boolean consumeBytes(int paramInt)
      throws Http2Exception
    {
      return false;
    }
    
    public void receiveFlowControlledFrame(int paramInt)
      throws Http2Exception
    {
      super.receiveFlowControlledFrame(paramInt);
      super.consumeBytes(paramInt);
    }
  }
  
  private class DefaultState
    implements DefaultHttp2LocalFlowController.FlowState
  {
    private boolean endOfStream;
    private int initialStreamWindowSize;
    private int lowerBound;
    private int processedWindow;
    private final Http2Stream stream;
    private float streamWindowUpdateRatio;
    private int window;
    
    DefaultState(Http2Stream paramHttp2Stream, int paramInt)
    {
      this.stream = paramHttp2Stream;
      window(paramInt);
      this.streamWindowUpdateRatio = DefaultHttp2LocalFlowController.this.windowUpdateRatio;
    }
    
    private void returnProcessedBytes(int paramInt)
      throws Http2Exception
    {
      int i = this.processedWindow;
      if (i - paramInt >= this.window)
      {
        this.processedWindow = (i - paramInt);
        return;
      }
      throw Http2Exception.streamError(this.stream.id(), Http2Error.INTERNAL_ERROR, "Attempting to return too many bytes for stream %d", new Object[] { Integer.valueOf(this.stream.id()) });
    }
    
    private void writeWindowUpdate()
      throws Http2Exception
    {
      int i = this.initialStreamWindowSize - this.processedWindow;
      try
      {
        incrementFlowControlWindows(i);
        DefaultHttp2LocalFlowController.this.frameWriter.writeWindowUpdate(DefaultHttp2LocalFlowController.this.ctx, this.stream.id(), i, DefaultHttp2LocalFlowController.this.ctx.newPromise());
        return;
      }
      finally {}
    }
    
    public boolean consumeBytes(int paramInt)
      throws Http2Exception
    {
      returnProcessedBytes(paramInt);
      return writeWindowUpdateIfNeeded();
    }
    
    public void endOfStream(boolean paramBoolean)
    {
      this.endOfStream = paramBoolean;
    }
    
    public void incrementFlowControlWindows(int paramInt)
      throws Http2Exception
    {
      if ((paramInt > 0) && (this.window > Integer.MAX_VALUE - paramInt)) {
        throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window overflowed for stream: %d", new Object[] { Integer.valueOf(this.stream.id()) });
      }
      this.window += paramInt;
      this.processedWindow += paramInt;
      if (paramInt >= 0) {
        paramInt = 0;
      }
      this.lowerBound = paramInt;
    }
    
    public void incrementInitialStreamWindow(int paramInt)
    {
      paramInt = (int)Math.min(2147483647L, Math.max(0L, this.initialStreamWindowSize + paramInt));
      int i = this.initialStreamWindowSize;
      this.initialStreamWindowSize = (i + (paramInt - i));
    }
    
    public int initialWindowSize()
    {
      return this.initialStreamWindowSize;
    }
    
    public void receiveFlowControlledFrame(int paramInt)
      throws Http2Exception
    {
      paramInt = this.window - paramInt;
      this.window = paramInt;
      if (paramInt >= this.lowerBound) {
        return;
      }
      throw Http2Exception.streamError(this.stream.id(), Http2Error.FLOW_CONTROL_ERROR, "Flow control window exceeded for stream: %d", new Object[] { Integer.valueOf(this.stream.id()) });
    }
    
    public int unconsumedBytes()
    {
      return this.processedWindow - this.window;
    }
    
    public void window(int paramInt)
    {
      this.initialStreamWindowSize = paramInt;
      this.processedWindow = paramInt;
      this.window = paramInt;
    }
    
    public int windowSize()
    {
      return this.window;
    }
    
    public float windowUpdateRatio()
    {
      return this.streamWindowUpdateRatio;
    }
    
    public void windowUpdateRatio(float paramFloat)
    {
      this.streamWindowUpdateRatio = paramFloat;
    }
    
    public boolean writeWindowUpdateIfNeeded()
      throws Http2Exception
    {
      if ((!this.endOfStream) && (this.initialStreamWindowSize > 0) && (!DefaultHttp2LocalFlowController.isClosed(this.stream)))
      {
        int i = (int)(this.initialStreamWindowSize * this.streamWindowUpdateRatio);
        if (this.processedWindow <= i)
        {
          writeWindowUpdate();
          return true;
        }
      }
      return false;
    }
  }
  
  private static abstract interface FlowState
  {
    public abstract boolean consumeBytes(int paramInt)
      throws Http2Exception;
    
    public abstract void endOfStream(boolean paramBoolean);
    
    public abstract void incrementFlowControlWindows(int paramInt)
      throws Http2Exception;
    
    public abstract void incrementInitialStreamWindow(int paramInt);
    
    public abstract int initialWindowSize();
    
    public abstract void receiveFlowControlledFrame(int paramInt)
      throws Http2Exception;
    
    public abstract int unconsumedBytes();
    
    public abstract void window(int paramInt);
    
    public abstract int windowSize();
    
    public abstract float windowUpdateRatio();
    
    public abstract void windowUpdateRatio(float paramFloat);
    
    public abstract boolean writeWindowUpdateIfNeeded()
      throws Http2Exception;
  }
  
  private final class WindowUpdateVisitor
    implements Http2StreamVisitor
  {
    private Http2Exception.CompositeStreamException compositeException;
    private final int delta;
    
    WindowUpdateVisitor(int paramInt)
    {
      this.delta = paramInt;
    }
    
    public void throwIfError()
      throws Http2Exception.CompositeStreamException
    {
      Http2Exception.CompositeStreamException localCompositeStreamException = this.compositeException;
      if (localCompositeStreamException == null) {
        return;
      }
      throw localCompositeStreamException;
    }
    
    public boolean visit(Http2Stream paramHttp2Stream)
      throws Http2Exception
    {
      try
      {
        paramHttp2Stream = DefaultHttp2LocalFlowController.this.state(paramHttp2Stream);
        paramHttp2Stream.incrementFlowControlWindows(this.delta);
        paramHttp2Stream.incrementInitialStreamWindow(this.delta);
      }
      catch (Http2Exception.StreamException paramHttp2Stream)
      {
        if (this.compositeException == null) {
          this.compositeException = new Http2Exception.CompositeStreamException(paramHttp2Stream.error(), 4);
        }
        this.compositeException.add(paramHttp2Stream);
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2LocalFlowController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
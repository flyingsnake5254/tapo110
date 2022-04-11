package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpServerUpgradeHandler.UpgradeEvent;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class Http2FrameCodec
  extends Http2ConnectionHandler
{
  private static final InternalLogger LOG = InternalLoggerFactory.getInstance(Http2FrameCodec.class);
  ChannelHandlerContext ctx;
  private final IntObjectMap<DefaultHttp2FrameStream> frameStreamToInitializeMap = new IntObjectHashMap(8);
  private final Integer initialFlowControlWindowSize;
  private int numBufferedStreams;
  protected final Http2Connection.a streamKey;
  private final Http2Connection.a upgradeKey;
  
  Http2FrameCodec(Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2Settings paramHttp2Settings, boolean paramBoolean)
  {
    super(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder, paramHttp2Settings, paramBoolean);
    paramHttp2ConnectionDecoder.frameListener(new FrameListener(null));
    connection().addListener(new ConnectionListener(null));
    ((Http2RemoteFlowController)connection().remote().flowController()).listener(new Http2RemoteFlowControllerListener(null));
    this.streamKey = connection().newKey();
    this.upgradeKey = connection().newKey();
    this.initialFlowControlWindowSize = paramHttp2Settings.initialWindowSize();
  }
  
  private void handleHeaderFuture(ChannelFuture paramChannelFuture, int paramInt)
  {
    if (!paramChannelFuture.isSuccess()) {
      this.frameStreamToInitializeMap.remove(paramInt);
    }
  }
  
  private void increaseInitialConnectionWindow(int paramInt)
    throws Http2Exception
  {
    ((Http2LocalFlowController)connection().local().flowController()).incrementWindowSize(connection().connectionStream(), paramInt);
  }
  
  private void onHttp2StreamWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext, DefaultHttp2FrameStream paramDefaultHttp2FrameStream, boolean paramBoolean)
  {
    paramChannelHandlerContext.fireUserEventTriggered(paramDefaultHttp2FrameStream.writabilityChanged);
  }
  
  private void onHttp2UnknownStreamError(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable, Http2Exception.StreamException paramStreamException)
  {
    if (paramStreamException.error() == Http2Error.STREAM_CLOSED) {
      paramChannelHandlerContext = InternalLogLevel.DEBUG;
    } else {
      paramChannelHandlerContext = InternalLogLevel.WARN;
    }
    LOG.log(paramChannelHandlerContext, "Stream exception thrown for unknown stream {}.", Integer.valueOf(paramStreamException.streamId()), paramThrowable);
  }
  
  private void onStreamActive0(Http2Stream paramHttp2Stream)
  {
    if ((paramHttp2Stream.id() != 1) && (connection().local().isValidStreamId(paramHttp2Stream.id()))) {
      return;
    }
    paramHttp2Stream = newStream().setStreamAndProperty(this.streamKey, paramHttp2Stream);
    onHttp2StreamStateChanged(this.ctx, paramHttp2Stream);
  }
  
  private void onUpgradeEvent(ChannelHandlerContext paramChannelHandlerContext, HttpServerUpgradeHandler.UpgradeEvent paramUpgradeEvent)
  {
    paramChannelHandlerContext.fireUserEventTriggered(paramUpgradeEvent);
  }
  
  private void tryExpandConnectionFlowControlWindow(Http2Connection paramHttp2Connection)
    throws Http2Exception
  {
    if (this.initialFlowControlWindowSize != null)
    {
      Http2Stream localHttp2Stream = paramHttp2Connection.connectionStream();
      paramHttp2Connection = (Http2LocalFlowController)paramHttp2Connection.local().flowController();
      int i = this.initialFlowControlWindowSize.intValue() - paramHttp2Connection.initialWindowSize(localHttp2Stream);
      if (i > 0)
      {
        paramHttp2Connection.incrementWindowSize(localHttp2Stream, Math.max(i << 1, i));
        flush(this.ctx);
      }
    }
  }
  
  private void writeGoAwayFrame(ChannelHandlerContext paramChannelHandlerContext, Http2GoAwayFrame paramHttp2GoAwayFrame, ChannelPromise paramChannelPromise)
  {
    if (paramHttp2GoAwayFrame.lastStreamId() <= -1)
    {
      long l1 = connection().remote().lastStreamCreated() + paramHttp2GoAwayFrame.extraStreamIds() * 2L;
      long l2 = l1;
      if (l1 > 2147483647L) {
        l2 = 2147483647L;
      }
      goAway(paramChannelHandlerContext, (int)l2, paramHttp2GoAwayFrame.errorCode(), paramHttp2GoAwayFrame.content(), paramChannelPromise);
      return;
    }
    paramHttp2GoAwayFrame.release();
    throw new IllegalArgumentException("Last stream id must not be set on GOAWAY frame");
  }
  
  private void writeHeadersFrame(ChannelHandlerContext paramChannelHandlerContext, Http2HeadersFrame paramHttp2HeadersFrame, ChannelPromise paramChannelPromise)
  {
    if (Http2CodecUtil.isStreamIdValid(paramHttp2HeadersFrame.stream().id()))
    {
      encoder().writeHeaders(paramChannelHandlerContext, paramHttp2HeadersFrame.stream().id(), paramHttp2HeadersFrame.headers(), paramHttp2HeadersFrame.padding(), paramHttp2HeadersFrame.isEndStream(), paramChannelPromise);
    }
    else
    {
      DefaultHttp2FrameStream localDefaultHttp2FrameStream = (DefaultHttp2FrameStream)paramHttp2HeadersFrame.stream();
      Http2Connection localHttp2Connection = connection();
      final int i = localHttp2Connection.local().incrementAndGetNextStreamId();
      if (i < 0)
      {
        paramChannelPromise.setFailure(new Http2NoMoreStreamIdsException());
        if (localHttp2Connection.isServer()) {
          i = Integer.MAX_VALUE;
        } else {
          i = 2147483646;
        }
        onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2GoAwayFrame(i, Http2Error.NO_ERROR.code(), ByteBufUtil.writeAscii(paramChannelHandlerContext.alloc(), "Stream IDs exhausted on local stream creation")));
        return;
      }
      DefaultHttp2FrameStream.access$302(localDefaultHttp2FrameStream, i);
      this.frameStreamToInitializeMap.put(i, localDefaultHttp2FrameStream);
      encoder().writeHeaders(paramChannelHandlerContext, i, paramHttp2HeadersFrame.headers(), paramHttp2HeadersFrame.padding(), paramHttp2HeadersFrame.isEndStream(), paramChannelPromise);
      if (!paramChannelPromise.isDone())
      {
        this.numBufferedStreams += 1;
        paramChannelPromise.addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          {
            Http2FrameCodec.access$410(Http2FrameCodec.this);
            Http2FrameCodec.this.handleHeaderFuture(paramAnonymousChannelFuture, i);
          }
        });
      }
      else
      {
        handleHeaderFuture(paramChannelPromise, i);
      }
    }
  }
  
  final boolean consumeBytes(int paramInt1, int paramInt2)
    throws Http2Exception
  {
    Http2Stream localHttp2Stream = connection().stream(paramInt1);
    if ((localHttp2Stream != null) && (paramInt1 == 1))
    {
      Boolean localBoolean = (Boolean)localHttp2Stream.getProperty(this.upgradeKey);
      if (Boolean.TRUE.equals(localBoolean)) {
        return false;
      }
    }
    return ((Http2LocalFlowController)connection().local().flowController()).consumeBytes(localHttp2Stream, paramInt2);
  }
  
  final void forEachActiveStream(final Http2FrameStreamVisitor paramHttp2FrameStreamVisitor)
    throws Http2Exception
  {
    if (connection().numActiveStreams() > 0) {
      connection().forEachActiveStream(new Http2StreamVisitor()
      {
        public boolean visit(Http2Stream paramAnonymousHttp2Stream)
        {
          try
          {
            boolean bool = paramHttp2FrameStreamVisitor.visit((Http2FrameStream)paramAnonymousHttp2Stream.getProperty(Http2FrameCodec.this.streamKey));
            return bool;
          }
          finally
          {
            Http2FrameCodec localHttp2FrameCodec = Http2FrameCodec.this;
            localHttp2FrameCodec.onError(localHttp2FrameCodec.ctx, false, paramAnonymousHttp2Stream);
          }
          return false;
        }
      });
    }
  }
  
  public final void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
    super.handlerAdded(paramChannelHandlerContext);
    handlerAdded0(paramChannelHandlerContext);
    paramChannelHandlerContext = connection();
    if (paramChannelHandlerContext.isServer()) {
      tryExpandConnectionFlowControlWindow(paramChannelHandlerContext);
    }
  }
  
  void handlerAdded0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {}
  
  protected final boolean isGracefulShutdownComplete()
  {
    boolean bool;
    if ((super.isGracefulShutdownComplete()) && (this.numBufferedStreams == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  DefaultHttp2FrameStream newStream()
  {
    return new DefaultHttp2FrameStream();
  }
  
  int numInitializingStreams()
  {
    return this.frameStreamToInitializeMap.size();
  }
  
  protected void onConnectionError(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, Throwable paramThrowable, Http2Exception paramHttp2Exception)
  {
    if (!paramBoolean) {
      paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
    }
    super.onConnectionError(paramChannelHandlerContext, paramBoolean, paramThrowable, paramHttp2Exception);
  }
  
  void onHttp2Frame(ChannelHandlerContext paramChannelHandlerContext, Http2Frame paramHttp2Frame)
  {
    paramChannelHandlerContext.fireChannelRead(paramHttp2Frame);
  }
  
  void onHttp2FrameStreamException(ChannelHandlerContext paramChannelHandlerContext, Http2FrameStreamException paramHttp2FrameStreamException)
  {
    paramChannelHandlerContext.fireExceptionCaught(paramHttp2FrameStreamException);
  }
  
  void onHttp2StreamStateChanged(ChannelHandlerContext paramChannelHandlerContext, DefaultHttp2FrameStream paramDefaultHttp2FrameStream)
  {
    paramChannelHandlerContext.fireUserEventTriggered(paramDefaultHttp2FrameStream.stateChanged);
  }
  
  protected final void onStreamError(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, Throwable paramThrowable, Http2Exception.StreamException paramStreamException)
  {
    int i = paramStreamException.streamId();
    Object localObject = connection().stream(i);
    if (localObject == null)
    {
      onHttp2UnknownStreamError(paramChannelHandlerContext, paramThrowable, paramStreamException);
      super.onStreamError(paramChannelHandlerContext, paramBoolean, paramThrowable, paramStreamException);
      return;
    }
    localObject = (Http2FrameStream)((Http2Stream)localObject).getProperty(this.streamKey);
    if (localObject == null)
    {
      LOG.warn("Stream exception thrown without stream object attached.", paramThrowable);
      super.onStreamError(paramChannelHandlerContext, paramBoolean, paramThrowable, paramStreamException);
      return;
    }
    if (!paramBoolean) {
      onHttp2FrameStreamException(paramChannelHandlerContext, new Http2FrameStreamException((Http2FrameStream)localObject, paramStreamException.error(), paramThrowable));
    }
  }
  
  public final void userEventTriggered(final ChannelHandlerContext paramChannelHandlerContext, final Object paramObject)
    throws Exception
  {
    if (paramObject == Http2ConnectionPrefaceAndSettingsFrameWrittenEvent.INSTANCE)
    {
      tryExpandConnectionFlowControlWindow(connection());
      paramChannelHandlerContext.executor().execute(new Runnable()
      {
        public void run()
        {
          paramChannelHandlerContext.fireUserEventTriggered(paramObject);
        }
      });
    }
    else if ((paramObject instanceof HttpServerUpgradeHandler.UpgradeEvent))
    {
      paramObject = (HttpServerUpgradeHandler.UpgradeEvent)paramObject;
      try
      {
        onUpgradeEvent(paramChannelHandlerContext, ((HttpServerUpgradeHandler.UpgradeEvent)paramObject).retain());
        Http2Stream localHttp2Stream = connection().stream(1);
        if (localHttp2Stream.getProperty(this.streamKey) == null) {
          onStreamActive0(localHttp2Stream);
        }
        ((HttpServerUpgradeHandler.UpgradeEvent)paramObject).upgradeRequest().headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), 1);
        localHttp2Stream.setProperty(this.upgradeKey, Boolean.TRUE);
        InboundHttpToHttp2Adapter.handle(paramChannelHandlerContext, connection(), decoder().frameListener(), ((HttpServerUpgradeHandler.UpgradeEvent)paramObject).upgradeRequest().retain());
      }
      finally
      {
        ((HttpServerUpgradeHandler.UpgradeEvent)paramObject).release();
      }
    }
    else
    {
      paramChannelHandlerContext.fireUserEventTriggered(paramObject);
    }
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
  {
    if ((paramObject instanceof Http2DataFrame))
    {
      paramObject = (Http2DataFrame)paramObject;
      encoder().writeData(paramChannelHandlerContext, ((Http2StreamFrame)paramObject).stream().id(), ((Http2DataFrame)paramObject).content(), ((Http2DataFrame)paramObject).padding(), ((Http2DataFrame)paramObject).isEndStream(), paramChannelPromise);
    }
    else if ((paramObject instanceof Http2HeadersFrame))
    {
      writeHeadersFrame(paramChannelHandlerContext, (Http2HeadersFrame)paramObject, paramChannelPromise);
    }
    else
    {
      if ((paramObject instanceof Http2WindowUpdateFrame))
      {
        paramChannelHandlerContext = (Http2WindowUpdateFrame)paramObject;
        paramObject = paramChannelHandlerContext.stream();
        if (paramObject == null) {}
        try
        {
          increaseInitialConnectionWindow(paramChannelHandlerContext.windowSizeIncrement());
          break label129;
          consumeBytes(((Http2FrameStream)paramObject).id(), paramChannelHandlerContext.windowSizeIncrement());
          label129:
          paramChannelPromise.setSuccess();
        }
        finally
        {
          paramChannelPromise.setFailure(paramChannelHandlerContext);
          break label445;
        }
      }
      if ((paramObject instanceof Http2ResetFrame))
      {
        paramObject = (Http2ResetFrame)paramObject;
        int i = ((Http2StreamFrame)paramObject).stream().id();
        if (connection().streamMayHaveExisted(i))
        {
          encoder().writeRstStream(paramChannelHandlerContext, ((Http2StreamFrame)paramObject).stream().id(), ((Http2ResetFrame)paramObject).errorCode(), paramChannelPromise);
        }
        else
        {
          ReferenceCountUtil.release(paramObject);
          paramChannelPromise.setFailure(Http2Exception.streamError(((Http2StreamFrame)paramObject).stream().id(), Http2Error.PROTOCOL_ERROR, "Stream never existed", new Object[0]));
        }
      }
      else if ((paramObject instanceof Http2PingFrame))
      {
        paramObject = (Http2PingFrame)paramObject;
        encoder().writePing(paramChannelHandlerContext, ((Http2PingFrame)paramObject).ack(), ((Http2PingFrame)paramObject).content(), paramChannelPromise);
      }
      else if ((paramObject instanceof Http2SettingsFrame))
      {
        encoder().writeSettings(paramChannelHandlerContext, ((Http2SettingsFrame)paramObject).settings(), paramChannelPromise);
      }
      else if ((paramObject instanceof Http2SettingsAckFrame))
      {
        encoder().writeSettingsAck(paramChannelHandlerContext, paramChannelPromise);
      }
      else if ((paramObject instanceof Http2GoAwayFrame))
      {
        writeGoAwayFrame(paramChannelHandlerContext, (Http2GoAwayFrame)paramObject, paramChannelPromise);
      }
      else if ((paramObject instanceof Http2UnknownFrame))
      {
        paramObject = (Http2UnknownFrame)paramObject;
        encoder().writeFrame(paramChannelHandlerContext, ((Http2UnknownFrame)paramObject).frameType(), ((Http2UnknownFrame)paramObject).stream().id(), ((Http2UnknownFrame)paramObject).flags(), ((ByteBufHolder)paramObject).content(), paramChannelPromise);
      }
      else
      {
        if ((paramObject instanceof Http2Frame)) {
          break label446;
        }
        paramChannelHandlerContext.write(paramObject, paramChannelPromise);
      }
    }
    label445:
    return;
    label446:
    ReferenceCountUtil.release(paramObject);
    throw new UnsupportedMessageTypeException(paramObject, new Class[0]);
  }
  
  private final class ConnectionListener
    extends Http2ConnectionAdapter
  {
    private ConnectionListener() {}
    
    private void onHttp2StreamStateChanged0(Http2Stream paramHttp2Stream)
    {
      paramHttp2Stream = (Http2FrameCodec.DefaultHttp2FrameStream)paramHttp2Stream.getProperty(Http2FrameCodec.this.streamKey);
      if (paramHttp2Stream != null)
      {
        Http2FrameCodec localHttp2FrameCodec = Http2FrameCodec.this;
        localHttp2FrameCodec.onHttp2StreamStateChanged(localHttp2FrameCodec.ctx, paramHttp2Stream);
      }
    }
    
    public void onStreamActive(Http2Stream paramHttp2Stream)
    {
      Http2FrameCodec.this.onStreamActive0(paramHttp2Stream);
    }
    
    public void onStreamAdded(Http2Stream paramHttp2Stream)
    {
      Http2FrameCodec.DefaultHttp2FrameStream localDefaultHttp2FrameStream = (Http2FrameCodec.DefaultHttp2FrameStream)Http2FrameCodec.this.frameStreamToInitializeMap.remove(paramHttp2Stream.id());
      if (localDefaultHttp2FrameStream != null) {
        localDefaultHttp2FrameStream.setStreamAndProperty(Http2FrameCodec.this.streamKey, paramHttp2Stream);
      }
    }
    
    public void onStreamClosed(Http2Stream paramHttp2Stream)
    {
      onHttp2StreamStateChanged0(paramHttp2Stream);
    }
    
    public void onStreamHalfClosed(Http2Stream paramHttp2Stream)
    {
      onHttp2StreamStateChanged0(paramHttp2Stream);
    }
  }
  
  static class DefaultHttp2FrameStream
    implements Http2FrameStream
  {
    Channel attachment;
    private volatile int id = -1;
    final Http2FrameStreamEvent stateChanged = Http2FrameStreamEvent.stateChanged(this);
    volatile Http2Stream stream;
    final Http2FrameStreamEvent writabilityChanged = Http2FrameStreamEvent.writabilityChanged(this);
    
    public int id()
    {
      Http2Stream localHttp2Stream = this.stream;
      int i;
      if (localHttp2Stream == null) {
        i = this.id;
      } else {
        i = localHttp2Stream.id();
      }
      return i;
    }
    
    DefaultHttp2FrameStream setStreamAndProperty(Http2Connection.a parama, Http2Stream paramHttp2Stream)
    {
      this.stream = paramHttp2Stream;
      paramHttp2Stream.setProperty(parama, this);
      return this;
    }
    
    public Http2Stream.State state()
    {
      Object localObject = this.stream;
      if (localObject == null) {
        localObject = Http2Stream.State.IDLE;
      } else {
        localObject = ((Http2Stream)localObject).state();
      }
      return (Http2Stream.State)localObject;
    }
    
    public String toString()
    {
      return String.valueOf(id());
    }
  }
  
  private final class FrameListener
    implements Http2FrameListener
  {
    private FrameListener() {}
    
    private Http2FrameStream requireStream(int paramInt)
    {
      Object localObject = (Http2FrameStream)Http2FrameCodec.this.connection().stream(paramInt).getProperty(Http2FrameCodec.this.streamKey);
      if (localObject != null) {
        return (Http2FrameStream)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Stream object required for identifier: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    
    public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2DataFrame(paramByteBuf, paramBoolean, paramInt2).stream(requireStream(paramInt1)).retain());
      return 0;
    }
    
    public void onGoAwayRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2GoAwayFrame(paramInt, paramLong, paramByteBuf).retain());
    }
    
    public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
    {
      onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt3, paramBoolean2);
    }
    
    public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2HeadersFrame(paramHttp2Headers, paramBoolean, paramInt2).stream(requireStream(paramInt1)));
    }
    
    public void onPingAckRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2PingFrame(paramLong, true));
    }
    
    public void onPingRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2PingFrame(paramLong, false));
    }
    
    public void onPriorityRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean) {}
    
    public void onPushPromiseRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3) {}
    
    public void onRstStreamRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2ResetFrame(paramLong).stream(requireStream(paramInt)));
    }
    
    public void onSettingsAckRead(ChannelHandlerContext paramChannelHandlerContext)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, Http2SettingsAckFrame.INSTANCE);
    }
    
    public void onSettingsRead(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2SettingsFrame(paramHttp2Settings));
    }
    
    public void onUnknownFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
    {
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2UnknownFrame(paramByte, paramHttp2Flags, paramByteBuf).stream(requireStream(paramInt)).retain());
    }
    
    public void onWindowUpdateRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0) {
        return;
      }
      Http2FrameCodec.this.onHttp2Frame(paramChannelHandlerContext, new DefaultHttp2WindowUpdateFrame(paramInt2).stream(requireStream(paramInt1)));
    }
  }
  
  private final class Http2RemoteFlowControllerListener
    implements Http2RemoteFlowController.Listener
  {
    private Http2RemoteFlowControllerListener() {}
    
    public void writabilityChanged(Http2Stream paramHttp2Stream)
    {
      Http2FrameCodec.DefaultHttp2FrameStream localDefaultHttp2FrameStream = (Http2FrameCodec.DefaultHttp2FrameStream)paramHttp2Stream.getProperty(Http2FrameCodec.this.streamKey);
      if (localDefaultHttp2FrameStream == null) {
        return;
      }
      Http2FrameCodec localHttp2FrameCodec = Http2FrameCodec.this;
      localHttp2FrameCodec.onHttp2StreamWritabilityChanged(localHttp2FrameCodec.ctx, localDefaultHttp2FrameStream, ((Http2RemoteFlowController)localHttp2FrameCodec.connection().remote().flowController()).isWritable(paramHttp2Stream));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2FrameCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
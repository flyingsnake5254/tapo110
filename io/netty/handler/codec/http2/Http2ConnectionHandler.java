package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.c;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Http2ConnectionHandler
  extends ByteToMessageDecoder
  implements Http2LifecycleManager, ChannelOutboundHandler
{
  private static final Http2Headers HEADERS_TOO_LARGE_HEADERS = ReadOnlyHttp2Headers.serverHeaders(false, HttpResponseStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.codeAsText(), new AsciiString[0]);
  private static final ByteBuf HTTP_1_X_BUF = Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(new byte[] { 72, 84, 84, 80, 47, 49, 46 })).asReadOnly();
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2ConnectionHandler.class);
  private BaseDecoder byteDecoder;
  private ChannelFutureListener closeListener;
  private final Http2ConnectionDecoder decoder;
  private final boolean decoupleCloseAndGoAway;
  private final Http2ConnectionEncoder encoder;
  private long gracefulShutdownTimeoutMillis;
  private final Http2Settings initialSettings;
  
  protected Http2ConnectionHandler(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings)
  {
    this(paramHttp2ConnectionDecoder, paramHttp2ConnectionEncoder, paramHttp2Settings, false);
  }
  
  protected Http2ConnectionHandler(Http2ConnectionDecoder paramHttp2ConnectionDecoder, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2Settings paramHttp2Settings, boolean paramBoolean)
  {
    this.initialSettings = ((Http2Settings)ObjectUtil.checkNotNull(paramHttp2Settings, "initialSettings"));
    this.decoder = ((Http2ConnectionDecoder)ObjectUtil.checkNotNull(paramHttp2ConnectionDecoder, "decoder"));
    this.encoder = ((Http2ConnectionEncoder)ObjectUtil.checkNotNull(paramHttp2ConnectionEncoder, "encoder"));
    this.decoupleCloseAndGoAway = paramBoolean;
    if (paramHttp2ConnectionEncoder.connection() == paramHttp2ConnectionDecoder.connection()) {
      return;
    }
    throw new IllegalArgumentException("Encoder and Decoder do not share the same connection object");
  }
  
  private void checkCloseConnection(ChannelFuture paramChannelFuture)
  {
    if ((this.closeListener != null) && (isGracefulShutdownComplete()))
    {
      ChannelFutureListener localChannelFutureListener = this.closeListener;
      this.closeListener = null;
      try
      {
        localChannelFutureListener.operationComplete(paramChannelFuture);
      }
      catch (Exception paramChannelFuture)
      {
        throw new IllegalStateException("Close listener threw an unexpected exception", paramChannelFuture);
      }
    }
  }
  
  private static ByteBuf clientPrefaceString(Http2Connection paramHttp2Connection)
  {
    if (paramHttp2Connection.isServer()) {
      paramHttp2Connection = Http2CodecUtil.connectionPrefaceBuf();
    } else {
      paramHttp2Connection = null;
    }
    return paramHttp2Connection;
  }
  
  private void closeConnectionOnError(ChannelHandlerContext paramChannelHandlerContext, ChannelFuture paramChannelFuture)
  {
    if (!paramChannelFuture.isSuccess()) {
      onConnectionError(paramChannelHandlerContext, true, paramChannelFuture.cause(), null);
    }
  }
  
  private void doGracefulShutdown(final ChannelHandlerContext paramChannelHandlerContext, final ChannelFuture paramChannelFuture, ChannelPromise paramChannelPromise)
  {
    paramChannelHandlerContext = newClosingChannelFutureListener(paramChannelHandlerContext, paramChannelPromise);
    if (isGracefulShutdownComplete())
    {
      paramChannelFuture.addListener(paramChannelHandlerContext);
    }
    else
    {
      paramChannelFuture = this.closeListener;
      if (paramChannelFuture == null) {
        this.closeListener = paramChannelHandlerContext;
      } else if (paramChannelPromise != null) {
        this.closeListener = new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            throws Exception
          {
            try
            {
              paramChannelFuture.operationComplete(paramAnonymousChannelFuture);
              return;
            }
            finally
            {
              paramChannelHandlerContext.operationComplete(paramAnonymousChannelFuture);
            }
          }
        };
      }
    }
  }
  
  private ChannelFuture goAway(ChannelHandlerContext paramChannelHandlerContext, Http2Exception paramHttp2Exception, ChannelPromise paramChannelPromise)
  {
    Http2Error localHttp2Error;
    if (paramHttp2Exception != null) {
      localHttp2Error = paramHttp2Exception.error();
    } else {
      localHttp2Error = Http2Error.NO_ERROR;
    }
    long l = localHttp2Error.code();
    return goAway(paramChannelHandlerContext, connection().remote().lastStreamCreated(), l, Http2CodecUtil.toByteBuf(paramChannelHandlerContext, paramHttp2Exception), paramChannelPromise);
  }
  
  private ChannelFutureListener newClosingChannelFutureListener(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    long l = this.gracefulShutdownTimeoutMillis;
    if (l < 0L) {
      paramChannelHandlerContext = new ClosingChannelFutureListener(paramChannelHandlerContext, paramChannelPromise);
    } else {
      paramChannelHandlerContext = new ClosingChannelFutureListener(paramChannelHandlerContext, paramChannelPromise, l, TimeUnit.MILLISECONDS);
    }
    return paramChannelHandlerContext;
  }
  
  private boolean prefaceSent()
  {
    BaseDecoder localBaseDecoder = this.byteDecoder;
    boolean bool;
    if ((localBaseDecoder != null) && (localBaseDecoder.prefaceSent())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static void processGoAwayWriteResult(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf, ChannelFuture paramChannelFuture)
  {
    try
    {
      InternalLogger localInternalLogger;
      if (paramChannelFuture.isSuccess())
      {
        if (paramLong != Http2Error.NO_ERROR.code())
        {
          localInternalLogger = logger;
          if (localInternalLogger.isDebugEnabled()) {
            localInternalLogger.debug("{} Sent GOAWAY: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", new Object[] { paramChannelHandlerContext.channel(), Integer.valueOf(paramInt), Long.valueOf(paramLong), paramByteBuf.toString(CharsetUtil.UTF_8), paramChannelFuture.cause() });
          }
          paramChannelHandlerContext.close();
        }
      }
      else
      {
        localInternalLogger = logger;
        if (localInternalLogger.isDebugEnabled()) {
          localInternalLogger.debug("{} Sending GOAWAY failed: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", new Object[] { paramChannelHandlerContext.channel(), Integer.valueOf(paramInt), Long.valueOf(paramLong), paramByteBuf.toString(CharsetUtil.UTF_8), paramChannelFuture.cause() });
        }
        paramChannelHandlerContext.close();
      }
      return;
    }
    finally
    {
      paramByteBuf.release();
    }
  }
  
  private void processRstStreamWriteResult(ChannelHandlerContext paramChannelHandlerContext, Http2Stream paramHttp2Stream, ChannelFuture paramChannelFuture)
  {
    if (paramChannelFuture.isSuccess()) {
      closeStream(paramHttp2Stream, paramChannelFuture);
    } else {
      onConnectionError(paramChannelHandlerContext, true, paramChannelFuture.cause(), null);
    }
  }
  
  private ChannelFuture resetStream(final ChannelHandlerContext paramChannelHandlerContext, final Http2Stream paramHttp2Stream, long paramLong, ChannelPromise paramChannelPromise)
  {
    paramChannelPromise = paramChannelPromise.unvoid();
    if (paramHttp2Stream.isResetSent()) {
      return paramChannelPromise.setSuccess();
    }
    paramHttp2Stream.resetSent();
    if ((paramHttp2Stream.state() != Http2Stream.State.IDLE) && ((!connection().local().created(paramHttp2Stream)) || (paramHttp2Stream.isHeadersSent()) || (paramHttp2Stream.isPushPromiseSent()))) {
      paramChannelPromise = frameWriter().writeRstStream(paramChannelHandlerContext, paramHttp2Stream.id(), paramLong, paramChannelPromise);
    } else {
      paramChannelPromise = paramChannelPromise.setSuccess();
    }
    if (paramChannelPromise.isDone()) {
      processRstStreamWriteResult(paramChannelHandlerContext, paramHttp2Stream, paramChannelPromise);
    } else {
      paramChannelPromise.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          Http2ConnectionHandler.this.processRstStreamWriteResult(paramChannelHandlerContext, paramHttp2Stream, paramAnonymousChannelFuture);
        }
      });
    }
    return paramChannelPromise;
  }
  
  private ChannelFuture resetUnknownStream(final ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    paramChannelPromise = frameWriter().writeRstStream(paramChannelHandlerContext, paramInt, paramLong, paramChannelPromise);
    if (paramChannelPromise.isDone()) {
      closeConnectionOnError(paramChannelHandlerContext, paramChannelPromise);
    } else {
      paramChannelPromise.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          Http2ConnectionHandler.this.closeConnectionOnError(paramChannelHandlerContext, paramAnonymousChannelFuture);
        }
      });
    }
    return paramChannelPromise;
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.byteDecoder == null) {
      this.byteDecoder = new PrefaceDecoder(paramChannelHandlerContext);
    }
    this.byteDecoder.channelActive(paramChannelHandlerContext);
    super.channelActive(paramChannelHandlerContext);
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.channelInactive(paramChannelHandlerContext);
    BaseDecoder localBaseDecoder = this.byteDecoder;
    if (localBaseDecoder != null)
    {
      localBaseDecoder.channelInactive(paramChannelHandlerContext);
      this.byteDecoder = null;
    }
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      channelReadComplete0(paramChannelHandlerContext);
      return;
    }
    finally
    {
      flush(paramChannelHandlerContext);
    }
  }
  
  final void channelReadComplete0(ChannelHandlerContext paramChannelHandlerContext)
  {
    discardSomeReadBytes();
    if (!paramChannelHandlerContext.channel().config().isAutoRead()) {
      paramChannelHandlerContext.read();
    }
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      if (paramChannelHandlerContext.channel().isWritable()) {
        flush(paramChannelHandlerContext);
      }
      this.encoder.flowController().channelWritabilityChanged();
      return;
    }
    finally
    {
      super.channelWritabilityChanged(paramChannelHandlerContext);
    }
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.decoupleCloseAndGoAway)
    {
      paramChannelHandlerContext.close(paramChannelPromise);
      return;
    }
    ChannelPromise localChannelPromise = paramChannelPromise.unvoid();
    if (!paramChannelHandlerContext.channel().isActive())
    {
      paramChannelHandlerContext.close(localChannelPromise);
      return;
    }
    if (connection().goAwaySent()) {
      paramChannelPromise = paramChannelHandlerContext.write(Unpooled.EMPTY_BUFFER);
    } else {
      paramChannelPromise = goAway(paramChannelHandlerContext, null, paramChannelHandlerContext.newPromise());
    }
    paramChannelHandlerContext.flush();
    doGracefulShutdown(paramChannelHandlerContext, paramChannelPromise, localChannelPromise);
  }
  
  public void closeStream(Http2Stream paramHttp2Stream, ChannelFuture paramChannelFuture)
  {
    paramHttp2Stream.close();
    if (paramChannelFuture.isDone()) {
      checkCloseConnection(paramChannelFuture);
    } else {
      paramChannelFuture.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
          throws Exception
        {
          Http2ConnectionHandler.this.checkCloseConnection(paramAnonymousChannelFuture);
        }
      });
    }
  }
  
  public void closeStreamLocal(Http2Stream paramHttp2Stream, ChannelFuture paramChannelFuture)
  {
    int i = 6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[paramHttp2Stream.state().ordinal()];
    if ((i != 1) && (i != 2)) {
      closeStream(paramHttp2Stream, paramChannelFuture);
    } else {
      paramHttp2Stream.closeLocalSide();
    }
  }
  
  public void closeStreamRemote(Http2Stream paramHttp2Stream, ChannelFuture paramChannelFuture)
  {
    int i = 6.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[paramHttp2Stream.state().ordinal()];
    if ((i != 2) && (i != 3)) {
      closeStream(paramHttp2Stream, paramChannelFuture);
    } else {
      paramHttp2Stream.closeRemoteSide();
    }
  }
  
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  public Http2Connection connection()
  {
    return this.encoder.connection();
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    this.byteDecoder.decode(paramChannelHandlerContext, paramByteBuf, paramList);
  }
  
  public Http2ConnectionDecoder decoder()
  {
    return this.decoder;
  }
  
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.deregister(paramChannelPromise);
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.disconnect(paramChannelPromise);
  }
  
  public Http2ConnectionEncoder encoder()
  {
    return this.encoder;
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if (Http2CodecUtil.getEmbeddedHttp2Exception(paramThrowable) != null) {
      onError(paramChannelHandlerContext, false, paramThrowable);
    } else {
      super.exceptionCaught(paramChannelHandlerContext, paramThrowable);
    }
  }
  
  /* Error */
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 137	io/netty/handler/codec/http2/Http2ConnectionHandler:encoder	Lio/netty/handler/codec/http2/Http2ConnectionEncoder;
    //   4: invokeinterface 483 1 0
    //   9: invokeinterface 570 1 0
    //   14: aload_1
    //   15: invokeinterface 512 1 0
    //   20: pop
    //   21: goto +35 -> 56
    //   24: astore_2
    //   25: aload_0
    //   26: aload_1
    //   27: iconst_1
    //   28: getstatic 573	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   31: aload_2
    //   32: ldc_w 575
    //   35: iconst_0
    //   36: anewarray 313	java/lang/Object
    //   39: invokestatic 579	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   42: invokevirtual 565	io/netty/handler/codec/http2/Http2ConnectionHandler:onError	(Lio/netty/channel/ChannelHandlerContext;ZLjava/lang/Throwable;)V
    //   45: goto +11 -> 56
    //   48: astore_2
    //   49: aload_0
    //   50: aload_1
    //   51: iconst_1
    //   52: aload_2
    //   53: invokevirtual 565	io/netty/handler/codec/http2/Http2ConnectionHandler:onError	(Lio/netty/channel/ChannelHandlerContext;ZLjava/lang/Throwable;)V
    //   56: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Http2ConnectionHandler
    //   0	57	1	paramChannelHandlerContext	ChannelHandlerContext
    //   24	8	2	localThrowable	Throwable
    //   48	5	2	localHttp2Exception	Http2Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	24	finally
    //   0	21	48	io/netty/handler/codec/http2/Http2Exception
  }
  
  protected Http2FrameWriter frameWriter()
  {
    return encoder().frameWriter();
  }
  
  public ChannelFuture goAway(final ChannelHandlerContext paramChannelHandlerContext, final int paramInt, final long paramLong, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    paramChannelPromise = paramChannelPromise.unvoid();
    Http2Connection localHttp2Connection = connection();
    try
    {
      if (!localHttp2Connection.goAwaySent(paramInt, paramLong, paramByteBuf)) {
        return paramChannelPromise;
      }
      paramByteBuf.retain();
      paramChannelPromise = frameWriter().writeGoAway(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf, paramChannelPromise);
      if (paramChannelPromise.isDone()) {
        processGoAwayWriteResult(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf, paramChannelPromise);
      } else {
        paramChannelPromise.addListener(new ChannelFutureListener()
        {
          public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
            throws Exception
          {
            Http2ConnectionHandler.processGoAwayWriteResult(paramChannelHandlerContext, paramInt, paramLong, this.val$debugData, paramAnonymousChannelFuture);
          }
        });
      }
      return paramChannelPromise;
    }
    finally
    {
      paramByteBuf.release();
      paramChannelPromise.tryFailure(paramChannelHandlerContext);
    }
    return paramChannelPromise;
  }
  
  public long gracefulShutdownTimeoutMillis()
  {
    return this.gracefulShutdownTimeoutMillis;
  }
  
  public void gracefulShutdownTimeoutMillis(long paramLong)
  {
    if (paramLong >= -1L)
    {
      this.gracefulShutdownTimeoutMillis = paramLong;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gracefulShutdownTimeoutMillis: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" (expected: -1 for indefinite or >= 0)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected void handleServerHeaderDecodeSizeError(ChannelHandlerContext paramChannelHandlerContext, Http2Stream paramHttp2Stream)
  {
    encoder().writeHeaders(paramChannelHandlerContext, paramHttp2Stream.id(), HEADERS_TOO_LARGE_HEADERS, 0, true, paramChannelHandlerContext.newPromise());
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.encoder.lifecycleManager(this);
    this.decoder.lifecycleManager(this);
    this.encoder.flowController().channelHandlerContext(paramChannelHandlerContext);
    this.decoder.flowController().channelHandlerContext(paramChannelHandlerContext);
    this.byteDecoder = new PrefaceDecoder(paramChannelHandlerContext);
  }
  
  protected void handlerRemoved0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    BaseDecoder localBaseDecoder = this.byteDecoder;
    if (localBaseDecoder != null)
    {
      localBaseDecoder.handlerRemoved(paramChannelHandlerContext);
      this.byteDecoder = null;
    }
  }
  
  protected boolean isGracefulShutdownComplete()
  {
    boolean bool;
    if (connection().numActiveStreams() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void onConnectionError(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, Throwable paramThrowable, Http2Exception paramHttp2Exception)
  {
    Http2Exception localHttp2Exception = paramHttp2Exception;
    if (paramHttp2Exception == null) {
      localHttp2Exception = new Http2Exception(Http2Error.INTERNAL_ERROR, paramThrowable.getMessage(), paramThrowable);
    }
    paramThrowable = paramChannelHandlerContext.newPromise();
    paramHttp2Exception = goAway(paramChannelHandlerContext, localHttp2Exception, paramChannelHandlerContext.newPromise());
    if (localHttp2Exception.shutdownHint() == Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN) {
      doGracefulShutdown(paramChannelHandlerContext, paramHttp2Exception, paramThrowable);
    } else {
      paramHttp2Exception.addListener(newClosingChannelFutureListener(paramChannelHandlerContext, paramThrowable));
    }
  }
  
  public void onError(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, Throwable paramThrowable)
  {
    Object localObject = Http2CodecUtil.getEmbeddedHttp2Exception(paramThrowable);
    if (Http2Exception.isStreamError((Http2Exception)localObject))
    {
      onStreamError(paramChannelHandlerContext, paramBoolean, paramThrowable, (Http2Exception.StreamException)localObject);
    }
    else
    {
      if ((localObject instanceof Http2Exception.CompositeStreamException))
      {
        localObject = ((Http2Exception.CompositeStreamException)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          onStreamError(paramChannelHandlerContext, paramBoolean, paramThrowable, (Http2Exception.StreamException)((Iterator)localObject).next());
        }
      }
      onConnectionError(paramChannelHandlerContext, paramBoolean, paramThrowable, (Http2Exception)localObject);
    }
    paramChannelHandlerContext.flush();
  }
  
  public void onHttpClientUpgrade()
    throws Http2Exception
  {
    if (!connection().isServer())
    {
      if (prefaceSent())
      {
        if (!this.decoder.prefaceReceived())
        {
          connection().local().createStream(1, true);
          return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
      }
      throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client-side HTTP upgrade requested for a server", new Object[0]);
  }
  
  public void onHttpServerUpgrade(Http2Settings paramHttp2Settings)
    throws Http2Exception
  {
    if (connection().isServer())
    {
      if (prefaceSent())
      {
        if (!this.decoder.prefaceReceived())
        {
          this.encoder.remoteSettings(paramHttp2Settings);
          connection().remote().createStream(1, true);
          return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is received", new Object[0]);
      }
      throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "HTTP upgrade must occur after preface was sent", new Object[0]);
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server-side HTTP upgrade requested for a client", new Object[0]);
  }
  
  /* Error */
  protected void onStreamError(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, Throwable paramThrowable, Http2Exception.StreamException paramStreamException)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokevirtual 724	io/netty/handler/codec/http2/Http2Exception$StreamException:streamId	()I
    //   5: istore 5
    //   7: aload_0
    //   8: invokevirtual 270	io/netty/handler/codec/http2/Http2ConnectionHandler:connection	()Lio/netty/handler/codec/http2/Http2Connection;
    //   11: iload 5
    //   13: invokeinterface 728 2 0
    //   18: astore 6
    //   20: aload 6
    //   22: astore 7
    //   24: aload 4
    //   26: instanceof 730
    //   29: ifeq +149 -> 178
    //   32: aload 6
    //   34: astore 7
    //   36: aload 4
    //   38: checkcast 730	io/netty/handler/codec/http2/Http2Exception$HeaderListSizeException
    //   41: invokevirtual 733	io/netty/handler/codec/http2/Http2Exception$HeaderListSizeException:duringDecode	()Z
    //   44: ifeq +134 -> 178
    //   47: aload 6
    //   49: astore 7
    //   51: aload_0
    //   52: invokevirtual 270	io/netty/handler/codec/http2/Http2ConnectionHandler:connection	()Lio/netty/handler/codec/http2/Http2Connection;
    //   55: invokeinterface 218 1 0
    //   60: ifeq +118 -> 178
    //   63: aload 6
    //   65: astore_3
    //   66: aload 6
    //   68: ifnonnull +53 -> 121
    //   71: aload_0
    //   72: getfield 137	io/netty/handler/codec/http2/Http2ConnectionHandler:encoder	Lio/netty/handler/codec/http2/Http2ConnectionEncoder;
    //   75: invokeinterface 143 1 0
    //   80: invokeinterface 274 1 0
    //   85: iload 5
    //   87: iconst_1
    //   88: invokeinterface 702 3 0
    //   93: astore_3
    //   94: goto +27 -> 121
    //   97: astore_3
    //   98: aload_0
    //   99: aload_1
    //   100: iload 5
    //   102: aload 4
    //   104: invokevirtual 259	io/netty/handler/codec/http2/Http2Exception:error	()Lio/netty/handler/codec/http2/Http2Error;
    //   107: invokevirtual 269	io/netty/handler/codec/http2/Http2Error:code	()J
    //   110: aload_1
    //   111: invokeinterface 508 1 0
    //   116: invokespecial 735	io/netty/handler/codec/http2/Http2ConnectionHandler:resetUnknownStream	(Lio/netty/channel/ChannelHandlerContext;IJLio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   119: pop
    //   120: return
    //   121: aload_3
    //   122: astore 7
    //   124: aload_3
    //   125: ifnull +53 -> 178
    //   128: aload_3
    //   129: astore 7
    //   131: aload_3
    //   132: invokeinterface 401 1 0
    //   137: ifne +41 -> 178
    //   140: aload_0
    //   141: aload_1
    //   142: aload_3
    //   143: invokevirtual 737	io/netty/handler/codec/http2/Http2ConnectionHandler:handleServerHeaderDecodeSizeError	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/http2/Http2Stream;)V
    //   146: aload_3
    //   147: astore 7
    //   149: goto +29 -> 178
    //   152: astore 7
    //   154: aload_0
    //   155: aload_1
    //   156: iload_2
    //   157: getstatic 573	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   160: aload 7
    //   162: ldc_w 739
    //   165: iconst_0
    //   166: anewarray 313	java/lang/Object
    //   169: invokestatic 579	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   172: invokevirtual 565	io/netty/handler/codec/http2/Http2ConnectionHandler:onError	(Lio/netty/channel/ChannelHandlerContext;ZLjava/lang/Throwable;)V
    //   175: aload_3
    //   176: astore 7
    //   178: aload 7
    //   180: ifnonnull +51 -> 231
    //   183: iload_2
    //   184: ifeq +22 -> 206
    //   187: aload_0
    //   188: invokevirtual 270	io/netty/handler/codec/http2/Http2ConnectionHandler:connection	()Lio/netty/handler/codec/http2/Http2Connection;
    //   191: invokeinterface 394 1 0
    //   196: iload 5
    //   198: invokeinterface 743 2 0
    //   203: ifeq +50 -> 253
    //   206: aload_0
    //   207: aload_1
    //   208: iload 5
    //   210: aload 4
    //   212: invokevirtual 259	io/netty/handler/codec/http2/Http2Exception:error	()Lio/netty/handler/codec/http2/Http2Error;
    //   215: invokevirtual 269	io/netty/handler/codec/http2/Http2Error:code	()J
    //   218: aload_1
    //   219: invokeinterface 508 1 0
    //   224: invokespecial 735	io/netty/handler/codec/http2/Http2ConnectionHandler:resetUnknownStream	(Lio/netty/channel/ChannelHandlerContext;IJLio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   227: pop
    //   228: goto +25 -> 253
    //   231: aload_0
    //   232: aload_1
    //   233: aload 7
    //   235: aload 4
    //   237: invokevirtual 259	io/netty/handler/codec/http2/Http2Exception:error	()Lio/netty/handler/codec/http2/Http2Error;
    //   240: invokevirtual 269	io/netty/handler/codec/http2/Http2Error:code	()J
    //   243: aload_1
    //   244: invokeinterface 508 1 0
    //   249: invokespecial 745	io/netty/handler/codec/http2/Http2ConnectionHandler:resetStream	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/http2/Http2Stream;JLio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   252: pop
    //   253: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	Http2ConnectionHandler
    //   0	254	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	254	2	paramBoolean	boolean
    //   0	254	3	paramThrowable	Throwable
    //   0	254	4	paramStreamException	Http2Exception.StreamException
    //   5	204	5	i	int
    //   18	49	6	localHttp2Stream	Http2Stream
    //   22	126	7	localObject	Object
    //   152	9	7	localThrowable1	Throwable
    //   176	58	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   71	94	97	io/netty/handler/codec/http2/Http2Exception
    //   140	146	152	finally
  }
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.read();
  }
  
  public ChannelFuture resetStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    Http2Stream localHttp2Stream = connection().stream(paramInt);
    if (localHttp2Stream == null) {
      return resetUnknownStream(paramChannelHandlerContext, paramInt, paramLong, paramChannelPromise.unvoid());
    }
    return resetStream(paramChannelHandlerContext, localHttp2Stream, paramLong, paramChannelPromise);
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.write(paramObject, paramChannelPromise);
  }
  
  private abstract class BaseDecoder
  {
    private BaseDecoder() {}
    
    public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {}
    
    public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      Http2ConnectionHandler.this.encoder().close();
      Http2ConnectionHandler.this.decoder().close();
      Http2ConnectionHandler.this.connection().close(paramChannelHandlerContext.voidPromise());
    }
    
    public abstract void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
      throws Exception;
    
    public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {}
    
    public boolean prefaceSent()
    {
      return true;
    }
  }
  
  private static final class ClosingChannelFutureListener
    implements ChannelFutureListener
  {
    private boolean closed;
    private final ChannelHandlerContext ctx;
    private final ChannelPromise promise;
    private final c<?> timeoutTask;
    
    ClosingChannelFutureListener(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    {
      this.ctx = paramChannelHandlerContext;
      this.promise = paramChannelPromise;
      this.timeoutTask = null;
    }
    
    ClosingChannelFutureListener(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise, long paramLong, TimeUnit paramTimeUnit)
    {
      this.ctx = paramChannelHandlerContext;
      this.promise = paramChannelPromise;
      this.timeoutTask = paramChannelHandlerContext.executor().schedule(new Runnable()
      {
        public void run()
        {
          Http2ConnectionHandler.ClosingChannelFutureListener.this.doClose();
        }
      }, paramLong, paramTimeUnit);
    }
    
    private void doClose()
    {
      if (this.closed) {
        return;
      }
      this.closed = true;
      ChannelPromise localChannelPromise = this.promise;
      if (localChannelPromise == null) {
        this.ctx.close();
      } else {
        this.ctx.close(localChannelPromise);
      }
    }
    
    public void operationComplete(ChannelFuture paramChannelFuture)
    {
      paramChannelFuture = this.timeoutTask;
      if (paramChannelFuture != null) {
        paramChannelFuture.cancel(false);
      }
      doClose();
    }
  }
  
  private final class FrameDecoder
    extends Http2ConnectionHandler.BaseDecoder
  {
    private FrameDecoder()
    {
      super(null);
    }
    
    /* Error */
    public void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
      throws Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	io/netty/handler/codec/http2/Http2ConnectionHandler$FrameDecoder:this$0	Lio/netty/handler/codec/http2/Http2ConnectionHandler;
      //   4: invokestatic 27	io/netty/handler/codec/http2/Http2ConnectionHandler:access$700	(Lio/netty/handler/codec/http2/Http2ConnectionHandler;)Lio/netty/handler/codec/http2/Http2ConnectionDecoder;
      //   7: aload_1
      //   8: aload_2
      //   9: aload_3
      //   10: invokeinterface 32 4 0
      //   15: goto +14 -> 29
      //   18: astore_2
      //   19: aload_0
      //   20: getfield 13	io/netty/handler/codec/http2/Http2ConnectionHandler$FrameDecoder:this$0	Lio/netty/handler/codec/http2/Http2ConnectionHandler;
      //   23: aload_1
      //   24: iconst_0
      //   25: aload_2
      //   26: invokevirtual 36	io/netty/handler/codec/http2/Http2ConnectionHandler:onError	(Lio/netty/channel/ChannelHandlerContext;ZLjava/lang/Throwable;)V
      //   29: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	30	0	this	FrameDecoder
      //   0	30	1	paramChannelHandlerContext	ChannelHandlerContext
      //   0	30	2	paramByteBuf	ByteBuf
      //   0	30	3	paramList	List<Object>
      // Exception table:
      //   from	to	target	type
      //   0	15	18	finally
    }
  }
  
  private final class PrefaceDecoder
    extends Http2ConnectionHandler.BaseDecoder
  {
    private ByteBuf clientPrefaceString = Http2ConnectionHandler.clientPrefaceString(Http2ConnectionHandler.this.encoder.connection());
    private boolean prefaceSent;
    
    PrefaceDecoder(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      super(null);
      sendPreface(paramChannelHandlerContext);
    }
    
    private void cleanup()
    {
      ByteBuf localByteBuf = this.clientPrefaceString;
      if (localByteBuf != null)
      {
        localByteBuf.release();
        this.clientPrefaceString = null;
      }
    }
    
    private boolean readClientPrefaceString(ByteBuf paramByteBuf)
      throws Http2Exception
    {
      ByteBuf localByteBuf = this.clientPrefaceString;
      if (localByteBuf == null) {
        return true;
      }
      int i = localByteBuf.readableBytes();
      i = Math.min(paramByteBuf.readableBytes(), i);
      if (i != 0)
      {
        int j = paramByteBuf.readerIndex();
        localByteBuf = this.clientPrefaceString;
        if (ByteBufUtil.equals(paramByteBuf, j, localByteBuf, localByteBuf.readerIndex(), i))
        {
          paramByteBuf.skipBytes(i);
          this.clientPrefaceString.skipBytes(i);
          if (!this.clientPrefaceString.isReadable())
          {
            this.clientPrefaceString.release();
            this.clientPrefaceString = null;
            return true;
          }
          return false;
        }
      }
      i = ByteBufUtil.indexOf(Http2ConnectionHandler.HTTP_1_X_BUF, paramByteBuf.slice(paramByteBuf.readerIndex(), Math.min(paramByteBuf.readableBytes(), 1024)));
      if (i != -1)
      {
        paramByteBuf = paramByteBuf.toString(paramByteBuf.readerIndex(), i - paramByteBuf.readerIndex(), CharsetUtil.US_ASCII);
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Unexpected HTTP/1.x request: %s", new Object[] { paramByteBuf });
      }
      paramByteBuf = ByteBufUtil.hexDump(paramByteBuf, paramByteBuf.readerIndex(), Math.min(paramByteBuf.readableBytes(), this.clientPrefaceString.readableBytes()));
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP/2 client preface string missing or corrupt. Hex dump for received bytes: %s", new Object[] { paramByteBuf });
    }
    
    private void sendPreface(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      if ((!this.prefaceSent) && (paramChannelHandlerContext.channel().isActive()))
      {
        this.prefaceSent = true;
        boolean bool = true ^ Http2ConnectionHandler.this.connection().isServer();
        if (bool) {
          paramChannelHandlerContext.write(Http2CodecUtil.connectionPrefaceBuf()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        }
        Http2ConnectionHandler.this.encoder.writeSettings(paramChannelHandlerContext, Http2ConnectionHandler.this.initialSettings, paramChannelHandlerContext.newPromise()).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        if (bool) {
          Http2ConnectionHandler.this.userEventTriggered(paramChannelHandlerContext, Http2ConnectionPrefaceAndSettingsFrameWrittenEvent.INSTANCE);
        }
      }
    }
    
    private boolean verifyFirstFrameIsSettings(ByteBuf paramByteBuf)
      throws Http2Exception
    {
      if (paramByteBuf.readableBytes() < 5) {
        return false;
      }
      int i = paramByteBuf.getUnsignedByte(paramByteBuf.readerIndex() + 3);
      int j = paramByteBuf.getUnsignedByte(paramByteBuf.readerIndex() + 4);
      if ((i == 4) && ((j & 0x1) == 0)) {
        return true;
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "First received frame was not SETTINGS. Hex dump for first 5 bytes: %s", new Object[] { ByteBufUtil.hexDump(paramByteBuf, paramByteBuf.readerIndex(), 5) });
    }
    
    public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      sendPreface(paramChannelHandlerContext);
    }
    
    public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      cleanup();
      super.channelInactive(paramChannelHandlerContext);
    }
    
    /* Error */
    public void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
      throws Exception
    {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface 134 1 0
      //   6: invokeinterface 139 1 0
      //   11: ifeq +73 -> 84
      //   14: aload_0
      //   15: aload_2
      //   16: invokespecial 211	io/netty/handler/codec/http2/Http2ConnectionHandler$PrefaceDecoder:readClientPrefaceString	(Lio/netty/buffer/ByteBuf;)Z
      //   19: ifeq +65 -> 84
      //   22: aload_0
      //   23: aload_2
      //   24: invokespecial 213	io/netty/handler/codec/http2/Http2ConnectionHandler$PrefaceDecoder:verifyFirstFrameIsSettings	(Lio/netty/buffer/ByteBuf;)Z
      //   27: ifeq +57 -> 84
      //   30: aload_0
      //   31: getfield 19	io/netty/handler/codec/http2/Http2ConnectionHandler$PrefaceDecoder:this$0	Lio/netty/handler/codec/http2/Http2ConnectionHandler;
      //   34: astore 4
      //   36: new 215	io/netty/handler/codec/http2/Http2ConnectionHandler$FrameDecoder
      //   39: astore 5
      //   41: aload 5
      //   43: aload 4
      //   45: aconst_null
      //   46: invokespecial 216	io/netty/handler/codec/http2/Http2ConnectionHandler$FrameDecoder:<init>	(Lio/netty/handler/codec/http2/Http2ConnectionHandler;Lio/netty/handler/codec/http2/Http2ConnectionHandler$1;)V
      //   49: aload 4
      //   51: aload 5
      //   53: invokestatic 220	io/netty/handler/codec/http2/Http2ConnectionHandler:access$302	(Lio/netty/handler/codec/http2/Http2ConnectionHandler;Lio/netty/handler/codec/http2/Http2ConnectionHandler$BaseDecoder;)Lio/netty/handler/codec/http2/Http2ConnectionHandler$BaseDecoder;
      //   56: pop
      //   57: aload_0
      //   58: getfield 19	io/netty/handler/codec/http2/Http2ConnectionHandler$PrefaceDecoder:this$0	Lio/netty/handler/codec/http2/Http2ConnectionHandler;
      //   61: invokestatic 224	io/netty/handler/codec/http2/Http2ConnectionHandler:access$300	(Lio/netty/handler/codec/http2/Http2ConnectionHandler;)Lio/netty/handler/codec/http2/Http2ConnectionHandler$BaseDecoder;
      //   64: aload_1
      //   65: aload_2
      //   66: aload_3
      //   67: invokevirtual 226	io/netty/handler/codec/http2/Http2ConnectionHandler$BaseDecoder:decode	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Ljava/util/List;)V
      //   70: goto +14 -> 84
      //   73: astore_2
      //   74: aload_0
      //   75: getfield 19	io/netty/handler/codec/http2/Http2ConnectionHandler$PrefaceDecoder:this$0	Lio/netty/handler/codec/http2/Http2ConnectionHandler;
      //   78: aload_1
      //   79: iconst_0
      //   80: aload_2
      //   81: invokevirtual 230	io/netty/handler/codec/http2/Http2ConnectionHandler:onError	(Lio/netty/channel/ChannelHandlerContext;ZLjava/lang/Throwable;)V
      //   84: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	85	0	this	PrefaceDecoder
      //   0	85	1	paramChannelHandlerContext	ChannelHandlerContext
      //   0	85	2	paramByteBuf	ByteBuf
      //   0	85	3	paramList	List<Object>
      //   34	16	4	localHttp2ConnectionHandler	Http2ConnectionHandler
      //   39	13	5	localFrameDecoder	Http2ConnectionHandler.FrameDecoder
      // Exception table:
      //   from	to	target	type
      //   0	70	73	finally
    }
    
    public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
      throws Exception
    {
      cleanup();
    }
    
    public boolean prefaceSent()
    {
      return this.prefaceSent;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2ConnectionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
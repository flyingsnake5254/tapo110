package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

public class DefaultHttp2ConnectionDecoder
  implements Http2ConnectionDecoder
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultHttp2ConnectionDecoder.class);
  private final boolean autoAckPing;
  private final Http2Connection connection;
  private final Http2ConnectionEncoder encoder;
  private final Http2FrameReader frameReader;
  private Http2FrameListener internalFrameListener = new PrefaceFrameListener(null);
  private Http2LifecycleManager lifecycleManager;
  private Http2FrameListener listener;
  private final Http2PromisedRequestVerifier requestVerifier;
  private final Http2SettingsReceivedConsumer settingsReceivedConsumer;
  
  public DefaultHttp2ConnectionDecoder(Http2Connection paramHttp2Connection, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2FrameReader paramHttp2FrameReader)
  {
    this(paramHttp2Connection, paramHttp2ConnectionEncoder, paramHttp2FrameReader, Http2PromisedRequestVerifier.ALWAYS_VERIFY);
  }
  
  public DefaultHttp2ConnectionDecoder(Http2Connection paramHttp2Connection, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2FrameReader paramHttp2FrameReader, Http2PromisedRequestVerifier paramHttp2PromisedRequestVerifier)
  {
    this(paramHttp2Connection, paramHttp2ConnectionEncoder, paramHttp2FrameReader, paramHttp2PromisedRequestVerifier, true);
  }
  
  public DefaultHttp2ConnectionDecoder(Http2Connection paramHttp2Connection, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2FrameReader paramHttp2FrameReader, Http2PromisedRequestVerifier paramHttp2PromisedRequestVerifier, boolean paramBoolean)
  {
    this(paramHttp2Connection, paramHttp2ConnectionEncoder, paramHttp2FrameReader, paramHttp2PromisedRequestVerifier, paramBoolean, true);
  }
  
  public DefaultHttp2ConnectionDecoder(Http2Connection paramHttp2Connection, Http2ConnectionEncoder paramHttp2ConnectionEncoder, Http2FrameReader paramHttp2FrameReader, Http2PromisedRequestVerifier paramHttp2PromisedRequestVerifier, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.autoAckPing = paramBoolean2;
    if (paramBoolean1)
    {
      this.settingsReceivedConsumer = null;
    }
    else
    {
      if (!(paramHttp2ConnectionEncoder instanceof Http2SettingsReceivedConsumer)) {
        break label164;
      }
      this.settingsReceivedConsumer = ((Http2SettingsReceivedConsumer)paramHttp2ConnectionEncoder);
    }
    this.connection = ((Http2Connection)ObjectUtil.checkNotNull(paramHttp2Connection, "connection"));
    this.frameReader = ((Http2FrameReader)ObjectUtil.checkNotNull(paramHttp2FrameReader, "frameReader"));
    this.encoder = ((Http2ConnectionEncoder)ObjectUtil.checkNotNull(paramHttp2ConnectionEncoder, "encoder"));
    this.requestVerifier = ((Http2PromisedRequestVerifier)ObjectUtil.checkNotNull(paramHttp2PromisedRequestVerifier, "requestVerifier"));
    if (paramHttp2Connection.local().flowController() == null) {
      paramHttp2Connection.local().flowController(new DefaultHttp2LocalFlowController(paramHttp2Connection));
    }
    ((Http2LocalFlowController)paramHttp2Connection.local().flowController()).frameWriter(paramHttp2ConnectionEncoder.frameWriter());
    return;
    label164:
    paramHttp2Connection = new StringBuilder();
    paramHttp2Connection.append("disabling autoAckSettings requires the encoder to be a ");
    paramHttp2Connection.append(Http2SettingsReceivedConsumer.class);
    throw new IllegalArgumentException(paramHttp2Connection.toString());
  }
  
  private int unconsumedBytes(Http2Stream paramHttp2Stream)
  {
    return flowController().unconsumedBytes(paramHttp2Stream);
  }
  
  protected long calculateMaxHeaderListSizeGoAway(long paramLong)
  {
    return Http2CodecUtil.calculateMaxHeaderListSizeGoAway(paramLong);
  }
  
  public void close()
  {
    this.frameReader.close();
  }
  
  public Http2Connection connection()
  {
    return this.connection;
  }
  
  public void decodeFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Http2Exception
  {
    this.frameReader.readFrame(paramChannelHandlerContext, paramByteBuf, this.internalFrameListener);
  }
  
  public final Http2LocalFlowController flowController()
  {
    return (Http2LocalFlowController)this.connection.local().flowController();
  }
  
  public Http2FrameListener frameListener()
  {
    return this.listener;
  }
  
  public void frameListener(Http2FrameListener paramHttp2FrameListener)
  {
    this.listener = ((Http2FrameListener)ObjectUtil.checkNotNull(paramHttp2FrameListener, "listener"));
  }
  
  Http2FrameListener internalFrameListener()
  {
    return this.internalFrameListener;
  }
  
  public void lifecycleManager(Http2LifecycleManager paramHttp2LifecycleManager)
  {
    this.lifecycleManager = ((Http2LifecycleManager)ObjectUtil.checkNotNull(paramHttp2LifecycleManager, "lifecycleManager"));
  }
  
  public Http2Settings localSettings()
  {
    Http2Settings localHttp2Settings = new Http2Settings();
    Object localObject = this.frameReader.configuration();
    Http2HeadersDecoder.Configuration localConfiguration = ((Http2FrameReader.Configuration)localObject).headersConfiguration();
    localObject = ((Http2FrameReader.Configuration)localObject).frameSizePolicy();
    localHttp2Settings.initialWindowSize(flowController().initialWindowSize());
    localHttp2Settings.maxConcurrentStreams(this.connection.remote().maxActiveStreams());
    localHttp2Settings.headerTableSize(localConfiguration.maxHeaderTableSize());
    localHttp2Settings.maxFrameSize(((Http2FrameSizePolicy)localObject).maxFrameSize());
    localHttp2Settings.maxHeaderListSize(localConfiguration.maxHeaderListSize());
    if (!this.connection.isServer()) {
      localHttp2Settings.pushEnabled(this.connection.local().allowPushTo());
    }
    return localHttp2Settings;
  }
  
  void onGoAwayRead0(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf)
    throws Http2Exception
  {
    this.listener.onGoAwayRead(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf);
    this.connection.goAwayReceived(paramInt, paramLong, paramByteBuf);
  }
  
  void onUnknownFrame0(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
    throws Http2Exception
  {
    this.listener.onUnknownFrame(paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf);
  }
  
  public boolean prefaceReceived()
  {
    boolean bool;
    if (FrameReadListener.class == this.internalFrameListener.getClass()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private final class FrameReadListener
    implements Http2FrameListener
  {
    private FrameReadListener() {}
    
    private void applyLocalSettings(Http2Settings paramHttp2Settings)
      throws Http2Exception
    {
      Object localObject1 = paramHttp2Settings.pushEnabled();
      Object localObject2 = DefaultHttp2ConnectionDecoder.this.frameReader.configuration();
      Object localObject3 = ((Http2FrameReader.Configuration)localObject2).headersConfiguration();
      localObject2 = ((Http2FrameReader.Configuration)localObject2).frameSizePolicy();
      if (localObject1 != null) {
        if (!DefaultHttp2ConnectionDecoder.this.connection.isServer()) {
          DefaultHttp2ConnectionDecoder.this.connection.local().allowPushTo(((Boolean)localObject1).booleanValue());
        } else {
          throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
        }
      }
      localObject1 = paramHttp2Settings.maxConcurrentStreams();
      if (localObject1 != null) {
        DefaultHttp2ConnectionDecoder.this.connection.remote().maxActiveStreams((int)Math.min(((Long)localObject1).longValue(), 2147483647L));
      }
      localObject1 = paramHttp2Settings.headerTableSize();
      if (localObject1 != null) {
        ((Http2HeadersDecoder.Configuration)localObject3).maxHeaderTableSize(((Long)localObject1).longValue());
      }
      localObject1 = paramHttp2Settings.maxHeaderListSize();
      if (localObject1 != null) {
        ((Http2HeadersDecoder.Configuration)localObject3).maxHeaderListSize(((Long)localObject1).longValue(), DefaultHttp2ConnectionDecoder.this.calculateMaxHeaderListSizeGoAway(((Long)localObject1).longValue()));
      }
      localObject3 = paramHttp2Settings.maxFrameSize();
      if (localObject3 != null) {
        ((Http2FrameSizePolicy)localObject2).maxFrameSize(((Integer)localObject3).intValue());
      }
      paramHttp2Settings = paramHttp2Settings.initialWindowSize();
      if (paramHttp2Settings != null) {
        DefaultHttp2ConnectionDecoder.this.flowController().initialWindowSize(paramHttp2Settings.intValue());
      }
    }
    
    private boolean shouldIgnoreHeadersOrDataFrame(ChannelHandlerContext paramChannelHandlerContext, int paramInt, Http2Stream paramHttp2Stream, String paramString)
      throws Http2Exception
    {
      if (paramHttp2Stream == null)
      {
        if (streamCreatedAfterGoAwaySent(paramInt))
        {
          DefaultHttp2ConnectionDecoder.logger.info("{} ignoring {} frame for stream {}. Stream sent after GOAWAY sent", new Object[] { paramChannelHandlerContext.channel(), paramString, Integer.valueOf(paramInt) });
          return true;
        }
        verifyStreamMayHaveExisted(paramInt);
        throw Http2Exception.streamError(paramInt, Http2Error.STREAM_CLOSED, "Received %s frame for an unknown stream %d", new Object[] { paramString, Integer.valueOf(paramInt) });
      }
      if ((!paramHttp2Stream.isResetSent()) && (!streamCreatedAfterGoAwaySent(paramInt))) {
        return false;
      }
      if (DefaultHttp2ConnectionDecoder.logger.isInfoEnabled())
      {
        InternalLogger localInternalLogger = DefaultHttp2ConnectionDecoder.logger;
        Channel localChannel = paramChannelHandlerContext.channel();
        if (paramHttp2Stream.isResetSent())
        {
          paramChannelHandlerContext = "RST_STREAM sent.";
        }
        else
        {
          paramChannelHandlerContext = new StringBuilder();
          paramChannelHandlerContext.append("Stream created after GOAWAY sent. Last known stream by peer ");
          paramChannelHandlerContext.append(DefaultHttp2ConnectionDecoder.this.connection.remote().lastStreamKnownByPeer());
          paramChannelHandlerContext = paramChannelHandlerContext.toString();
        }
        localInternalLogger.info("{} ignoring {} frame for stream {}", new Object[] { localChannel, paramString, paramChannelHandlerContext });
      }
      return true;
    }
    
    private boolean streamCreatedAfterGoAwaySent(int paramInt)
    {
      Http2Connection.Endpoint localEndpoint = DefaultHttp2ConnectionDecoder.this.connection.remote();
      boolean bool;
      if ((DefaultHttp2ConnectionDecoder.this.connection.goAwaySent()) && (localEndpoint.isValidStreamId(paramInt)) && (paramInt > localEndpoint.lastStreamKnownByPeer())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private void verifyStreamMayHaveExisted(int paramInt)
      throws Http2Exception
    {
      if (DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(paramInt)) {
        return;
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", new Object[] { Integer.valueOf(paramInt) });
    }
    
    /* Error */
    public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
      throws Http2Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   4: invokestatic 56	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$100	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;)Lio/netty/handler/codec/http2/Http2Connection;
      //   7: iload_2
      //   8: invokeinterface 249 2 0
      //   13: astore 6
      //   15: aload_0
      //   16: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   19: invokevirtual 154	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:flowController	()Lio/netty/handler/codec/http2/Http2LocalFlowController;
      //   22: astore 7
      //   24: aload_3
      //   25: invokevirtual 254	io/netty/buffer/ByteBuf:readableBytes	()I
      //   28: iload 4
      //   30: iadd
      //   31: istore 8
      //   33: aload_0
      //   34: aload_1
      //   35: iload_2
      //   36: aload 6
      //   38: ldc_w 256
      //   41: invokespecial 258	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:shouldIgnoreHeadersOrDataFrame	(Lio/netty/channel/ChannelHandlerContext;ILio/netty/handler/codec/http2/Http2Stream;Ljava/lang/String;)Z
      //   44: istore 9
      //   46: iload 9
      //   48: ifeq +37 -> 85
      //   51: aload 7
      //   53: aload 6
      //   55: aload_3
      //   56: iload 4
      //   58: iload 5
      //   60: invokeinterface 264 5 0
      //   65: aload 7
      //   67: aload 6
      //   69: iload 8
      //   71: invokeinterface 268 3 0
      //   76: pop
      //   77: aload_0
      //   78: iload_2
      //   79: invokespecial 190	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:verifyStreamMayHaveExisted	(I)V
      //   82: iload 8
      //   84: ireturn
      //   85: aconst_null
      //   86: astore 10
      //   88: getstatic 274	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$1:$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State	[I
      //   91: aload 6
      //   93: invokeinterface 278 1 0
      //   98: invokevirtual 283	java/lang/Enum:ordinal	()I
      //   101: iaload
      //   102: istore 11
      //   104: aload 10
      //   106: astore 12
      //   108: iload 11
      //   110: iconst_1
      //   111: if_icmpeq +118 -> 229
      //   114: aload 10
      //   116: astore 12
      //   118: iload 11
      //   120: iconst_2
      //   121: if_icmpeq +108 -> 229
      //   124: iload 11
      //   126: iconst_3
      //   127: if_icmpeq +57 -> 184
      //   130: iload 11
      //   132: iconst_4
      //   133: if_icmpeq +51 -> 184
      //   136: aload 6
      //   138: invokeinterface 286 1 0
      //   143: getstatic 83	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   146: ldc_w 288
      //   149: iconst_2
      //   150: anewarray 4	java/lang/Object
      //   153: dup
      //   154: iconst_0
      //   155: aload 6
      //   157: invokeinterface 286 1 0
      //   162: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   165: aastore
      //   166: dup
      //   167: iconst_1
      //   168: aload 6
      //   170: invokeinterface 278 1 0
      //   175: aastore
      //   176: invokestatic 199	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   179: astore 12
      //   181: goto +48 -> 229
      //   184: aload 6
      //   186: invokeinterface 286 1 0
      //   191: getstatic 193	io/netty/handler/codec/http2/Http2Error:STREAM_CLOSED	Lio/netty/handler/codec/http2/Http2Error;
      //   194: ldc_w 288
      //   197: iconst_2
      //   198: anewarray 4	java/lang/Object
      //   201: dup
      //   202: iconst_0
      //   203: aload 6
      //   205: invokeinterface 286 1 0
      //   210: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   213: aastore
      //   214: dup
      //   215: iconst_1
      //   216: aload 6
      //   218: invokeinterface 278 1 0
      //   223: aastore
      //   224: invokestatic 199	io/netty/handler/codec/http2/Http2Exception:streamError	(ILio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   227: astore 12
      //   229: aload_0
      //   230: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   233: aload 6
      //   235: invokestatic 292	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$200	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;Lio/netty/handler/codec/http2/Http2Stream;)I
      //   238: istore 13
      //   240: iload 8
      //   242: istore 11
      //   244: aload 7
      //   246: aload 6
      //   248: aload_3
      //   249: iload 4
      //   251: iload 5
      //   253: invokeinterface 264 5 0
      //   258: iload 8
      //   260: istore 11
      //   262: aload_0
      //   263: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   266: aload 6
      //   268: invokestatic 292	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$200	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;Lio/netty/handler/codec/http2/Http2Stream;)I
      //   271: istore 14
      //   273: aload 12
      //   275: ifnonnull +81 -> 356
      //   278: iload 8
      //   280: istore 11
      //   282: aload_0
      //   283: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   286: invokestatic 296	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$300	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;)Lio/netty/handler/codec/http2/Http2FrameListener;
      //   289: aload_1
      //   290: iload_2
      //   291: aload_3
      //   292: iload 4
      //   294: iload 5
      //   296: invokeinterface 298 6 0
      //   301: istore_2
      //   302: aload 7
      //   304: aload 6
      //   306: iload_2
      //   307: invokeinterface 268 3 0
      //   312: pop
      //   313: iload 5
      //   315: ifeq +23 -> 338
      //   318: aload_0
      //   319: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   322: invokestatic 302	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$400	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;)Lio/netty/handler/codec/http2/Http2LifecycleManager;
      //   325: aload 6
      //   327: aload_1
      //   328: invokeinterface 308 1 0
      //   333: invokeinterface 314 3 0
      //   338: iload_2
      //   339: ireturn
      //   340: astore_3
      //   341: iload 14
      //   343: istore 13
      //   345: goto +23 -> 368
      //   348: astore_3
      //   349: iload 14
      //   351: istore 13
      //   353: goto +41 -> 394
      //   356: iload 8
      //   358: istore 11
      //   360: aload 12
      //   362: athrow
      //   363: astore_3
      //   364: goto +55 -> 419
      //   367: astore_3
      //   368: iload 8
      //   370: istore 11
      //   372: iload 8
      //   374: iload 13
      //   376: aload_0
      //   377: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   380: aload 6
      //   382: invokestatic 292	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$200	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;Lio/netty/handler/codec/http2/Http2Stream;)I
      //   385: isub
      //   386: isub
      //   387: istore_2
      //   388: iload_2
      //   389: istore 11
      //   391: aload_3
      //   392: athrow
      //   393: astore_3
      //   394: iload 8
      //   396: istore 11
      //   398: iload 8
      //   400: iload 13
      //   402: aload_0
      //   403: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   406: aload 6
      //   408: invokestatic 292	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$200	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;Lio/netty/handler/codec/http2/Http2Stream;)I
      //   411: isub
      //   412: isub
      //   413: istore_2
      //   414: iload_2
      //   415: istore 11
      //   417: aload_3
      //   418: athrow
      //   419: aload 7
      //   421: aload 6
      //   423: iload 11
      //   425: invokeinterface 268 3 0
      //   430: pop
      //   431: iload 5
      //   433: ifeq +23 -> 456
      //   436: aload_0
      //   437: getfield 15	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder$FrameReadListener:this$0	Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;
      //   440: invokestatic 302	io/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder:access$400	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionDecoder;)Lio/netty/handler/codec/http2/Http2LifecycleManager;
      //   443: aload 6
      //   445: aload_1
      //   446: invokeinterface 308 1 0
      //   451: invokeinterface 314 3 0
      //   456: aload_3
      //   457: athrow
      //   458: astore_1
      //   459: getstatic 317	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   462: aload_1
      //   463: ldc_w 319
      //   466: iconst_1
      //   467: anewarray 4	java/lang/Object
      //   470: dup
      //   471: iconst_0
      //   472: iload_2
      //   473: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   476: aastore
      //   477: invokestatic 322	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   480: athrow
      //   481: astore_1
      //   482: aload 7
      //   484: aload 6
      //   486: aload_3
      //   487: iload 4
      //   489: iload 5
      //   491: invokeinterface 264 5 0
      //   496: aload 7
      //   498: aload 6
      //   500: iload 8
      //   502: invokeinterface 268 3 0
      //   507: pop
      //   508: aload_1
      //   509: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	510	0	this	FrameReadListener
      //   0	510	1	paramChannelHandlerContext	ChannelHandlerContext
      //   0	510	2	paramInt1	int
      //   0	510	3	paramByteBuf	ByteBuf
      //   0	510	4	paramInt2	int
      //   0	510	5	paramBoolean	boolean
      //   13	486	6	localHttp2Stream	Http2Stream
      //   22	475	7	localHttp2LocalFlowController	Http2LocalFlowController
      //   31	470	8	i	int
      //   44	3	9	bool	boolean
      //   86	29	10	localObject1	Object
      //   102	322	11	j	int
      //   106	255	12	localObject2	Object
      //   238	174	13	k	int
      //   271	79	14	m	int
      // Exception table:
      //   from	to	target	type
      //   282	302	340	java/lang/RuntimeException
      //   360	363	340	java/lang/RuntimeException
      //   282	302	348	io/netty/handler/codec/http2/Http2Exception
      //   360	363	348	io/netty/handler/codec/http2/Http2Exception
      //   244	258	363	finally
      //   262	273	363	finally
      //   282	302	363	finally
      //   360	363	363	finally
      //   372	388	363	finally
      //   391	393	363	finally
      //   398	414	363	finally
      //   417	419	363	finally
      //   244	258	367	java/lang/RuntimeException
      //   262	273	367	java/lang/RuntimeException
      //   244	258	393	io/netty/handler/codec/http2/Http2Exception
      //   262	273	393	io/netty/handler/codec/http2/Http2Exception
      //   33	46	458	finally
      //   33	46	481	io/netty/handler/codec/http2/Http2Exception
    }
    
    public void onGoAwayRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf)
      throws Http2Exception
    {
      DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf);
    }
    
    public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
      throws Http2Exception
    {
      Http2Stream localHttp2Stream = DefaultHttp2ConnectionDecoder.this.connection.stream(paramInt1);
      int i;
      if ((localHttp2Stream == null) && (!DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(paramInt1)))
      {
        localHttp2Stream = DefaultHttp2ConnectionDecoder.this.connection.remote().createStream(paramInt1, paramBoolean2);
        if (localHttp2Stream.state() == Http2Stream.State.HALF_CLOSED_REMOTE) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else
      {
        i = 0;
      }
      if (shouldIgnoreHeadersOrDataFrame(paramChannelHandlerContext, paramInt1, localHttp2Stream, "HEADERS")) {
        return;
      }
      boolean bool;
      if ((!DefaultHttp2ConnectionDecoder.this.connection.isServer()) && (HttpStatusClass.valueOf(paramHttp2Headers.status()) == HttpStatusClass.INFORMATIONAL)) {
        bool = true;
      } else {
        bool = false;
      }
      if (((!bool) && (paramBoolean2)) || ((!localHttp2Stream.isHeadersReceived()) && (!localHttp2Stream.isTrailersReceived())))
      {
        int j = DefaultHttp2ConnectionDecoder.1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[localHttp2Stream.state().ordinal()];
        if ((j != 1) && (j != 2)) {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5) {
                localHttp2Stream.open(paramBoolean2);
              } else {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", new Object[] { Integer.valueOf(localHttp2Stream.id()), localHttp2Stream.state() });
              }
            }
            else {
              throw Http2Exception.streamError(localHttp2Stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", new Object[] { Integer.valueOf(localHttp2Stream.id()), localHttp2Stream.state() });
            }
          }
          else if (i == 0) {
            throw Http2Exception.streamError(localHttp2Stream.id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", new Object[] { Integer.valueOf(localHttp2Stream.id()), localHttp2Stream.state() });
          }
        }
        localHttp2Stream.headersReceived(bool);
        DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(paramInt1, paramInt2, paramShort, paramBoolean1);
        DefaultHttp2ConnectionDecoder.this.listener.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2);
        if (paramBoolean2) {
          DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(localHttp2Stream, paramChannelHandlerContext.newSucceededFuture());
        }
        return;
      }
      throw Http2Exception.streamError(paramInt1, Http2Error.PROTOCOL_ERROR, "Stream %d received too many headers EOS: %s state: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean2), localHttp2Stream.state() });
    }
    
    public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
      throws Http2Exception
    {
      onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, 0, (short)16, false, paramInt2, paramBoolean);
    }
    
    public void onPingAckRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
      throws Http2Exception
    {
      DefaultHttp2ConnectionDecoder.this.listener.onPingAckRead(paramChannelHandlerContext, paramLong);
    }
    
    public void onPingRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
      throws Http2Exception
    {
      if (DefaultHttp2ConnectionDecoder.this.autoAckPing) {
        DefaultHttp2ConnectionDecoder.this.encoder.writePing(paramChannelHandlerContext, true, paramLong, paramChannelHandlerContext.newPromise());
      }
      DefaultHttp2ConnectionDecoder.this.listener.onPingRead(paramChannelHandlerContext, paramLong);
    }
    
    public void onPriorityRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean)
      throws Http2Exception
    {
      DefaultHttp2ConnectionDecoder.this.encoder.flowController().updateDependencyTree(paramInt1, paramInt2, paramShort, paramBoolean);
      DefaultHttp2ConnectionDecoder.this.listener.onPriorityRead(paramChannelHandlerContext, paramInt1, paramInt2, paramShort, paramBoolean);
    }
    
    public void onPushPromiseRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3)
      throws Http2Exception
    {
      if (!DefaultHttp2ConnectionDecoder.this.connection().isServer())
      {
        Http2Stream localHttp2Stream = DefaultHttp2ConnectionDecoder.this.connection.stream(paramInt1);
        if (shouldIgnoreHeadersOrDataFrame(paramChannelHandlerContext, paramInt1, localHttp2Stream, "PUSH_PROMISE")) {
          return;
        }
        if (localHttp2Stream != null)
        {
          int i = DefaultHttp2ConnectionDecoder.1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[localHttp2Stream.state().ordinal()];
          if ((i != 1) && (i != 2)) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state for receiving push promise: %s", new Object[] { Integer.valueOf(localHttp2Stream.id()), localHttp2Stream.state() });
          }
          if (DefaultHttp2ConnectionDecoder.this.requestVerifier.isAuthoritative(paramChannelHandlerContext, paramHttp2Headers))
          {
            if (DefaultHttp2ConnectionDecoder.this.requestVerifier.isCacheable(paramHttp2Headers))
            {
              if (DefaultHttp2ConnectionDecoder.this.requestVerifier.isSafe(paramHttp2Headers))
              {
                DefaultHttp2ConnectionDecoder.this.connection.remote().reservePushStream(paramInt2, localHttp2Stream);
                DefaultHttp2ConnectionDecoder.this.listener.onPushPromiseRead(paramChannelHandlerContext, paramInt1, paramInt2, paramHttp2Headers, paramInt3);
                return;
              }
              throw Http2Exception.streamError(paramInt2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be safe", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            }
            throw Http2Exception.streamError(paramInt2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be cacheable", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
          throw Http2Exception.streamError(paramInt2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not authoritative", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", new Object[] { Integer.valueOf(paramInt1) });
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A client cannot push.", new Object[0]);
    }
    
    public void onRstStreamRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong)
      throws Http2Exception
    {
      Http2Stream localHttp2Stream = DefaultHttp2ConnectionDecoder.this.connection.stream(paramInt);
      if (localHttp2Stream == null)
      {
        verifyStreamMayHaveExisted(paramInt);
        return;
      }
      int i = DefaultHttp2ConnectionDecoder.1.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[localHttp2Stream.state().ordinal()];
      if (i != 4)
      {
        if (i != 6)
        {
          DefaultHttp2ConnectionDecoder.this.listener.onRstStreamRead(paramChannelHandlerContext, paramInt, paramLong);
          DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStream(localHttp2Stream, paramChannelHandlerContext.newSucceededFuture());
          return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "RST_STREAM received for IDLE stream %d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    
    public void onSettingsAckRead(ChannelHandlerContext paramChannelHandlerContext)
      throws Http2Exception
    {
      Http2Settings localHttp2Settings = DefaultHttp2ConnectionDecoder.this.encoder.pollSentSettings();
      if (localHttp2Settings != null) {
        applyLocalSettings(localHttp2Settings);
      }
      DefaultHttp2ConnectionDecoder.this.listener.onSettingsAckRead(paramChannelHandlerContext);
    }
    
    public void onSettingsRead(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings)
      throws Http2Exception
    {
      if (DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer == null)
      {
        DefaultHttp2ConnectionDecoder.this.encoder.writeSettingsAck(paramChannelHandlerContext, paramChannelHandlerContext.newPromise());
        DefaultHttp2ConnectionDecoder.this.encoder.remoteSettings(paramHttp2Settings);
      }
      else
      {
        DefaultHttp2ConnectionDecoder.this.settingsReceivedConsumer.consumeReceivedSettings(paramHttp2Settings);
      }
      DefaultHttp2ConnectionDecoder.this.listener.onSettingsRead(paramChannelHandlerContext, paramHttp2Settings);
    }
    
    public void onUnknownFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
      throws Http2Exception
    {
      DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf);
    }
    
    public void onWindowUpdateRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2)
      throws Http2Exception
    {
      Http2Stream localHttp2Stream = DefaultHttp2ConnectionDecoder.this.connection.stream(paramInt1);
      if ((localHttp2Stream != null) && (localHttp2Stream.state() != Http2Stream.State.CLOSED) && (!streamCreatedAfterGoAwaySent(paramInt1)))
      {
        DefaultHttp2ConnectionDecoder.this.encoder.flowController().incrementWindowSize(localHttp2Stream, paramInt2);
        DefaultHttp2ConnectionDecoder.this.listener.onWindowUpdateRead(paramChannelHandlerContext, paramInt1, paramInt2);
        return;
      }
      verifyStreamMayHaveExisted(paramInt1);
    }
  }
  
  private final class PrefaceFrameListener
    implements Http2FrameListener
  {
    private PrefaceFrameListener() {}
    
    private void verifyPrefaceReceived()
      throws Http2Exception
    {
      if (DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
        return;
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received non-SETTINGS as first frame.", new Object[0]);
    }
    
    public int onDataRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      return DefaultHttp2ConnectionDecoder.this.internalFrameListener.onDataRead(paramChannelHandlerContext, paramInt1, paramByteBuf, paramInt2, paramBoolean);
    }
    
    public void onGoAwayRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf)
      throws Http2Exception
    {
      DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf);
    }
    
    public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2);
    }
    
    public void onHeadersRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean);
    }
    
    public void onPingAckRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingAckRead(paramChannelHandlerContext, paramLong);
    }
    
    public void onPingRead(ChannelHandlerContext paramChannelHandlerContext, long paramLong)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingRead(paramChannelHandlerContext, paramLong);
    }
    
    public void onPriorityRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPriorityRead(paramChannelHandlerContext, paramInt1, paramInt2, paramShort, paramBoolean);
    }
    
    public void onPushPromiseRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPushPromiseRead(paramChannelHandlerContext, paramInt1, paramInt2, paramHttp2Headers, paramInt3);
    }
    
    public void onRstStreamRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onRstStreamRead(paramChannelHandlerContext, paramInt, paramLong);
    }
    
    public void onSettingsAckRead(ChannelHandlerContext paramChannelHandlerContext)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsAckRead(paramChannelHandlerContext);
    }
    
    public void onSettingsRead(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings)
      throws Http2Exception
    {
      if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived())
      {
        DefaultHttp2ConnectionDecoder localDefaultHttp2ConnectionDecoder = DefaultHttp2ConnectionDecoder.this;
        DefaultHttp2ConnectionDecoder.access$1102(localDefaultHttp2ConnectionDecoder, new DefaultHttp2ConnectionDecoder.FrameReadListener(localDefaultHttp2ConnectionDecoder, null));
      }
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsRead(paramChannelHandlerContext, paramHttp2Settings);
    }
    
    public void onUnknownFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf)
      throws Http2Exception
    {
      DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf);
    }
    
    public void onWindowUpdateRead(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2)
      throws Http2Exception
    {
      verifyPrefaceReceived();
      DefaultHttp2ConnectionDecoder.this.internalFrameListener.onWindowUpdateRead(paramChannelHandlerContext, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2ConnectionDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
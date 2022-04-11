package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractCoalescingBufferQueue;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.CoalescingBufferQueue;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

public class DefaultHttp2ConnectionEncoder
  implements Http2ConnectionEncoder, Http2SettingsReceivedConsumer
{
  private final Http2Connection connection;
  private final Http2FrameWriter frameWriter;
  private Http2LifecycleManager lifecycleManager;
  private final Queue<Http2Settings> outstandingLocalSettingsQueue = new ArrayDeque(4);
  private Queue<Http2Settings> outstandingRemoteSettingsQueue;
  
  public DefaultHttp2ConnectionEncoder(Http2Connection paramHttp2Connection, Http2FrameWriter paramHttp2FrameWriter)
  {
    this.connection = ((Http2Connection)ObjectUtil.checkNotNull(paramHttp2Connection, "connection"));
    this.frameWriter = ((Http2FrameWriter)ObjectUtil.checkNotNull(paramHttp2FrameWriter, "frameWriter"));
    if (paramHttp2Connection.remote().flowController() == null) {
      paramHttp2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(paramHttp2Connection));
    }
  }
  
  private void notifyLifecycleManagerOnError(ChannelFuture paramChannelFuture, final ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelFuture.addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        paramAnonymousChannelFuture = paramAnonymousChannelFuture.cause();
        if (paramAnonymousChannelFuture != null) {
          DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(paramChannelHandlerContext, true, paramAnonymousChannelFuture);
        }
      }
    });
  }
  
  private Http2Stream requireStream(int paramInt)
  {
    Object localObject = this.connection.stream(paramInt);
    if (localObject == null)
    {
      if (this.connection.streamMayHaveExisted(paramInt))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Stream no longer exists: ");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Stream does not exist: ");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      throw new IllegalArgumentException((String)localObject);
    }
    return (Http2Stream)localObject;
  }
  
  private static ChannelFuture sendHeaders(Http2FrameWriter paramHttp2FrameWriter, ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, boolean paramBoolean1, int paramInt2, short paramShort, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, ChannelPromise paramChannelPromise)
  {
    if (paramBoolean1) {
      return paramHttp2FrameWriter.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean2, paramInt3, paramBoolean3, paramChannelPromise);
    }
    return paramHttp2FrameWriter.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt3, paramBoolean3, paramChannelPromise);
  }
  
  private static boolean validateHeadersSentState(Http2Stream paramHttp2Stream, Http2Headers paramHttp2Headers, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (HttpStatusClass.valueOf(paramHttp2Headers.status()) == HttpStatusClass.INFORMATIONAL)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    if (((!paramBoolean1) && (paramBoolean2)) || ((!paramHttp2Stream.isHeadersSent()) && (!paramHttp2Stream.isTrailersSent()))) {
      return paramBoolean1;
    }
    paramHttp2Headers = new StringBuilder();
    paramHttp2Headers.append("Stream ");
    paramHttp2Headers.append(paramHttp2Stream.id());
    paramHttp2Headers.append(" sent too many headers EOS: ");
    paramHttp2Headers.append(paramBoolean2);
    throw new IllegalStateException(paramHttp2Headers.toString());
  }
  
  /* Error */
  private ChannelFuture writeHeaders0(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, boolean paramBoolean1, int paramInt2, short paramShort, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload 10
    //   2: astore 11
    //   4: aload_0
    //   5: getfield 54	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:connection	Lio/netty/handler/codec/http2/Http2Connection;
    //   8: iload_2
    //   9: invokeinterface 112 2 0
    //   14: astore 12
    //   16: aload 12
    //   18: ifnonnull +97 -> 115
    //   21: aload_0
    //   22: getfield 54	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:connection	Lio/netty/handler/codec/http2/Http2Connection;
    //   25: invokeinterface 192 1 0
    //   30: iload_2
    //   31: iconst_0
    //   32: invokeinterface 196 3 0
    //   37: astore 13
    //   39: goto +202 -> 241
    //   42: astore 12
    //   44: aload_0
    //   45: getfield 54	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:connection	Lio/netty/handler/codec/http2/Http2Connection;
    //   48: invokeinterface 63 1 0
    //   53: iload_2
    //   54: invokeinterface 199 2 0
    //   59: ifeq +53 -> 112
    //   62: new 184	java/lang/IllegalStateException
    //   65: astore 10
    //   67: new 118	java/lang/StringBuilder
    //   70: astore_3
    //   71: aload_3
    //   72: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   75: aload_3
    //   76: ldc 121
    //   78: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: iload_2
    //   84: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 10
    //   90: aload_3
    //   91: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: aload 12
    //   96: invokespecial 202	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload 11
    //   101: aload 10
    //   103: invokeinterface 208 2 0
    //   108: pop
    //   109: aload 11
    //   111: areturn
    //   112: aload 12
    //   114: athrow
    //   115: getstatic 212	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder$2:$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State	[I
    //   118: aload 12
    //   120: invokeinterface 216 1 0
    //   125: invokevirtual 221	java/lang/Enum:ordinal	()I
    //   128: iaload
    //   129: istore 14
    //   131: aload 12
    //   133: astore 13
    //   135: iload 14
    //   137: iconst_1
    //   138: if_icmpeq -99 -> 39
    //   141: aload 12
    //   143: astore 13
    //   145: iload 14
    //   147: iconst_2
    //   148: if_icmpeq -109 -> 39
    //   151: iload 14
    //   153: iconst_3
    //   154: if_icmpne +20 -> 174
    //   157: aload 12
    //   159: iload 9
    //   161: invokeinterface 225 2 0
    //   166: pop
    //   167: aload 12
    //   169: astore 13
    //   171: goto -132 -> 39
    //   174: new 184	java/lang/IllegalStateException
    //   177: astore_3
    //   178: new 118	java/lang/StringBuilder
    //   181: astore 10
    //   183: aload 10
    //   185: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   188: aload 10
    //   190: ldc -83
    //   192: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 10
    //   198: aload 12
    //   200: invokeinterface 177 1 0
    //   205: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 10
    //   211: ldc -29
    //   213: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 10
    //   219: aload 12
    //   221: invokeinterface 216 1 0
    //   226: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_3
    //   231: aload 10
    //   233: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 185	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   239: aload_3
    //   240: athrow
    //   241: aload_0
    //   242: invokevirtual 233	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:flowController	()Lio/netty/handler/codec/http2/Http2RemoteFlowController;
    //   245: astore 15
    //   247: iload 9
    //   249: ifeq +75 -> 324
    //   252: aload 11
    //   254: astore 12
    //   256: aload 15
    //   258: aload 13
    //   260: invokeinterface 239 2 0
    //   265: ifne +6 -> 271
    //   268: goto +56 -> 324
    //   271: aload 11
    //   273: astore 12
    //   275: new 20	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder$FlowControlledHeaders
    //   278: astore 16
    //   280: aload 11
    //   282: astore 12
    //   284: aload 16
    //   286: aload_0
    //   287: aload 13
    //   289: aload_3
    //   290: iload 4
    //   292: iload 5
    //   294: iload 6
    //   296: iload 7
    //   298: iload 8
    //   300: iconst_1
    //   301: aload 10
    //   303: invokespecial 242	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder$FlowControlledHeaders:<init>	(Lio/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder;Lio/netty/handler/codec/http2/Http2Stream;Lio/netty/handler/codec/http2/Http2Headers;ZISZIZLio/netty/channel/ChannelPromise;)V
    //   306: aload 11
    //   308: astore 12
    //   310: aload 15
    //   312: aload 13
    //   314: aload 16
    //   316: invokeinterface 246 3 0
    //   321: aload 11
    //   323: areturn
    //   324: aload 11
    //   326: astore 12
    //   328: aload 10
    //   330: invokeinterface 252 1 0
    //   335: astore 11
    //   337: aload 11
    //   339: astore 12
    //   341: aload 13
    //   343: aload_3
    //   344: aload_0
    //   345: getfield 54	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:connection	Lio/netty/handler/codec/http2/Http2Connection;
    //   348: invokeinterface 255 1 0
    //   353: iload 9
    //   355: invokestatic 89	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:validateHeadersSentState	(Lio/netty/handler/codec/http2/Http2Stream;Lio/netty/handler/codec/http2/Http2Headers;ZZ)Z
    //   358: istore 17
    //   360: aload 11
    //   362: astore 12
    //   364: aload_0
    //   365: getfield 59	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:frameWriter	Lio/netty/handler/codec/http2/Http2FrameWriter;
    //   368: aload_1
    //   369: iload_2
    //   370: aload_3
    //   371: iload 4
    //   373: iload 5
    //   375: iload 6
    //   377: iload 7
    //   379: iload 8
    //   381: iload 9
    //   383: aload 11
    //   385: invokestatic 96	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:sendHeaders	(Lio/netty/handler/codec/http2/Http2FrameWriter;Lio/netty/channel/ChannelHandlerContext;ILio/netty/handler/codec/http2/Http2Headers;ZISZIZLio/netty/channel/ChannelPromise;)Lio/netty/channel/ChannelFuture;
    //   388: astore_3
    //   389: aload 11
    //   391: astore 12
    //   393: aload_3
    //   394: invokeinterface 261 1 0
    //   399: astore 10
    //   401: aload 10
    //   403: ifnonnull +46 -> 449
    //   406: aload 11
    //   408: astore 12
    //   410: aload 13
    //   412: iload 17
    //   414: invokeinterface 264 2 0
    //   419: pop
    //   420: aload 11
    //   422: astore 12
    //   424: aload_3
    //   425: invokeinterface 267 1 0
    //   430: istore 4
    //   432: iload 4
    //   434: ifne +12 -> 446
    //   437: aload_0
    //   438: aload_3
    //   439: aload_1
    //   440: invokespecial 269	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:notifyLifecycleManagerOnError	(Lio/netty/channel/ChannelFuture;Lio/netty/channel/ChannelHandlerContext;)V
    //   443: goto +19 -> 462
    //   446: goto +16 -> 462
    //   449: aload_0
    //   450: getfield 82	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:lifecycleManager	Lio/netty/handler/codec/http2/Http2LifecycleManager;
    //   453: aload_1
    //   454: iconst_1
    //   455: aload 10
    //   457: invokeinterface 275 4 0
    //   462: iload 9
    //   464: ifeq +15 -> 479
    //   467: aload_0
    //   468: getfield 82	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:lifecycleManager	Lio/netty/handler/codec/http2/Http2LifecycleManager;
    //   471: aload 13
    //   473: aload_3
    //   474: invokeinterface 279 3 0
    //   479: aload_3
    //   480: areturn
    //   481: astore_3
    //   482: goto +12 -> 494
    //   485: astore_3
    //   486: aload 12
    //   488: astore 11
    //   490: goto +4 -> 494
    //   493: astore_3
    //   494: aload_0
    //   495: getfield 82	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:lifecycleManager	Lio/netty/handler/codec/http2/Http2LifecycleManager;
    //   498: aload_1
    //   499: iconst_1
    //   500: aload_3
    //   501: invokeinterface 275 4 0
    //   506: aload 11
    //   508: aload_3
    //   509: invokeinterface 208 2 0
    //   514: pop
    //   515: aload 11
    //   517: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	518	0	this	DefaultHttp2ConnectionEncoder
    //   0	518	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	518	2	paramInt1	int
    //   0	518	3	paramHttp2Headers	Http2Headers
    //   0	518	4	paramBoolean1	boolean
    //   0	518	5	paramInt2	int
    //   0	518	6	paramShort	short
    //   0	518	7	paramBoolean2	boolean
    //   0	518	8	paramInt3	int
    //   0	518	9	paramBoolean3	boolean
    //   0	518	10	paramChannelPromise	ChannelPromise
    //   2	514	11	localObject1	Object
    //   14	3	12	localHttp2Stream	Http2Stream
    //   42	178	12	localHttp2Exception	Http2Exception
    //   254	233	12	localObject2	Object
    //   37	435	13	localObject3	Object
    //   129	26	14	i	int
    //   245	66	15	localHttp2RemoteFlowController	Http2RemoteFlowController
    //   278	37	16	localFlowControlledHeaders	FlowControlledHeaders
    //   358	55	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	39	42	io/netty/handler/codec/http2/Http2Exception
    //   437	443	481	finally
    //   449	462	481	finally
    //   467	479	481	finally
    //   256	268	485	finally
    //   275	280	485	finally
    //   284	306	485	finally
    //   310	321	485	finally
    //   328	337	485	finally
    //   341	360	485	finally
    //   364	389	485	finally
    //   393	401	485	finally
    //   410	420	485	finally
    //   424	432	485	finally
    //   4	16	493	finally
    //   21	39	493	finally
    //   44	109	493	finally
    //   112	115	493	finally
    //   115	131	493	finally
    //   157	167	493	finally
    //   174	241	493	finally
    //   241	247	493	finally
  }
  
  public void close()
  {
    this.frameWriter.close();
  }
  
  public Http2FrameWriter.Configuration configuration()
  {
    return this.frameWriter.configuration();
  }
  
  public Http2Connection connection()
  {
    return this.connection;
  }
  
  public void consumeReceivedSettings(Http2Settings paramHttp2Settings)
  {
    if (this.outstandingRemoteSettingsQueue == null) {
      this.outstandingRemoteSettingsQueue = new ArrayDeque(2);
    }
    this.outstandingRemoteSettingsQueue.add(paramHttp2Settings);
  }
  
  public final Http2RemoteFlowController flowController()
  {
    return (Http2RemoteFlowController)connection().remote().flowController();
  }
  
  public Http2FrameWriter frameWriter()
  {
    return this.frameWriter;
  }
  
  public void lifecycleManager(Http2LifecycleManager paramHttp2LifecycleManager)
  {
    this.lifecycleManager = ((Http2LifecycleManager)ObjectUtil.checkNotNull(paramHttp2LifecycleManager, "lifecycleManager"));
  }
  
  public Http2Settings pollSentSettings()
  {
    return (Http2Settings)this.outstandingLocalSettingsQueue.poll();
  }
  
  public void remoteSettings(Http2Settings paramHttp2Settings)
    throws Http2Exception
  {
    Object localObject1 = paramHttp2Settings.pushEnabled();
    Object localObject2 = configuration();
    Object localObject3 = ((Http2FrameWriter.Configuration)localObject2).headersConfiguration();
    localObject2 = ((Http2FrameWriter.Configuration)localObject2).frameSizePolicy();
    if (localObject1 != null)
    {
      if ((!this.connection.isServer()) && (((Boolean)localObject1).booleanValue())) {
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client received a value of ENABLE_PUSH specified to other than 0", new Object[0]);
      }
      this.connection.remote().allowPushTo(((Boolean)localObject1).booleanValue());
    }
    localObject1 = paramHttp2Settings.maxConcurrentStreams();
    if (localObject1 != null) {
      this.connection.local().maxActiveStreams((int)Math.min(((Long)localObject1).longValue(), 2147483647L));
    }
    localObject1 = paramHttp2Settings.headerTableSize();
    if (localObject1 != null) {
      ((Http2HeadersEncoder.Configuration)localObject3).maxHeaderTableSize((int)Math.min(((Long)localObject1).longValue(), 2147483647L));
    }
    localObject1 = paramHttp2Settings.maxHeaderListSize();
    if (localObject1 != null) {
      ((Http2HeadersEncoder.Configuration)localObject3).maxHeaderListSize(((Long)localObject1).longValue());
    }
    localObject3 = paramHttp2Settings.maxFrameSize();
    if (localObject3 != null) {
      ((Http2FrameSizePolicy)localObject2).maxFrameSize(((Integer)localObject3).intValue());
    }
    paramHttp2Settings = paramHttp2Settings.initialWindowSize();
    if (paramHttp2Settings != null) {
      flowController().initialWindowSize(paramHttp2Settings.intValue());
    }
  }
  
  public ChannelFuture writeData(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    try
    {
      Http2Stream localHttp2Stream = requireStream(paramInt1);
      paramInt1 = 2.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[localHttp2Stream.state().ordinal()];
      if ((paramInt1 != 1) && (paramInt1 != 2))
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        paramChannelHandlerContext = new java/lang/StringBuilder;
        paramChannelHandlerContext.<init>();
        paramChannelHandlerContext.append("Stream ");
        paramChannelHandlerContext.append(localHttp2Stream.id());
        paramChannelHandlerContext.append(" in unexpected state ");
        paramChannelHandlerContext.append(localHttp2Stream.state());
        localIllegalStateException.<init>(paramChannelHandlerContext.toString());
        throw localIllegalStateException;
      }
      flowController().addFlowControlled(localHttp2Stream, new FlowControlledData(localHttp2Stream, paramByteBuf, paramInt2, paramBoolean, paramChannelPromise));
      return paramChannelPromise;
    }
    finally
    {
      paramByteBuf.release();
    }
    return paramChannelPromise.setFailure(paramChannelHandlerContext);
  }
  
  public ChannelFuture writeFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    return this.frameWriter.writeFrame(paramChannelHandlerContext, paramByte, paramInt, paramHttp2Flags, paramByteBuf, paramChannelPromise);
  }
  
  public ChannelFuture writeGoAway(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    return this.lifecycleManager.goAway(paramChannelHandlerContext, paramInt, paramLong, paramByteBuf, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, ChannelPromise paramChannelPromise)
  {
    return writeHeaders0(paramChannelHandlerContext, paramInt1, paramHttp2Headers, true, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    return writeHeaders0(paramChannelHandlerContext, paramInt1, paramHttp2Headers, false, 0, (short)0, false, paramInt2, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writePing(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, long paramLong, ChannelPromise paramChannelPromise)
  {
    return this.frameWriter.writePing(paramChannelHandlerContext, paramBoolean, paramLong, paramChannelPromise);
  }
  
  public ChannelFuture writePriority(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    return this.frameWriter.writePriority(paramChannelHandlerContext, paramInt1, paramInt2, paramShort, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writePushPromise(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3, ChannelPromise paramChannelPromise)
  {
    try
    {
      if (!this.connection.goAwayReceived())
      {
        Http2Stream localHttp2Stream = requireStream(paramInt1);
        this.connection.local().reservePushStream(paramInt2, localHttp2Stream);
        ChannelPromise localChannelPromise = paramChannelPromise.unvoid();
        try
        {
          paramChannelPromise = this.frameWriter.writePushPromise(paramChannelHandlerContext, paramInt1, paramInt2, paramHttp2Headers, paramInt3, localChannelPromise);
          paramHttp2Headers = paramChannelPromise.cause();
          if (paramHttp2Headers == null)
          {
            localHttp2Stream.pushPromiseSent();
            if (!paramChannelPromise.isSuccess()) {
              notifyLifecycleManagerOnError(paramChannelPromise, paramChannelHandlerContext);
            }
          }
          else
          {
            this.lifecycleManager.onError(paramChannelHandlerContext, true, paramHttp2Headers);
          }
          return paramChannelPromise;
        }
        finally
        {
          paramChannelPromise = localChannelPromise;
          break label149;
        }
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Sending PUSH_PROMISE after GO_AWAY received.", new Object[0]);
    }
    finally
    {
      label149:
      this.lifecycleManager.onError(paramChannelHandlerContext, true, paramHttp2Headers);
      paramChannelPromise.tryFailure(paramHttp2Headers);
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture writeRstStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    return this.lifecycleManager.resetStream(paramChannelHandlerContext, paramInt, paramLong, paramChannelPromise);
  }
  
  public ChannelFuture writeSettings(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings, ChannelPromise paramChannelPromise)
  {
    this.outstandingLocalSettingsQueue.add(paramHttp2Settings);
    try
    {
      if ((paramHttp2Settings.pushEnabled() != null) && (this.connection.isServer())) {
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
      }
      return this.frameWriter.writeSettings(paramChannelHandlerContext, paramHttp2Settings, paramChannelPromise);
    }
    finally {}
    return paramChannelPromise.setFailure(paramChannelHandlerContext);
  }
  
  /* Error */
  public ChannelFuture writeSettingsAck(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 291	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:outstandingRemoteSettingsQueue	Ljava/util/Queue;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +15 -> 21
    //   9: aload_0
    //   10: getfield 59	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:frameWriter	Lio/netty/handler/codec/http2/Http2FrameWriter;
    //   13: aload_1
    //   14: aload_2
    //   15: invokeinterface 470 3 0
    //   20: areturn
    //   21: aload_3
    //   22: invokeinterface 308 1 0
    //   27: checkcast 310	io/netty/handler/codec/http2/Http2Settings
    //   30: astore_3
    //   31: aload_3
    //   32: ifnonnull +23 -> 55
    //   35: aload_2
    //   36: new 189	io/netty/handler/codec/http2/Http2Exception
    //   39: dup
    //   40: getstatic 473	io/netty/handler/codec/http2/Http2Error:INTERNAL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   43: ldc_w 475
    //   46: invokespecial 478	io/netty/handler/codec/http2/Http2Exception:<init>	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;)V
    //   49: invokeinterface 419 2 0
    //   54: areturn
    //   55: new 480	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator
    //   58: dup
    //   59: aload_2
    //   60: aload_1
    //   61: invokeinterface 486 1 0
    //   66: aload_1
    //   67: invokeinterface 490 1 0
    //   72: invokespecial 493	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:<init>	(Lio/netty/channel/ChannelPromise;Lio/netty/channel/Channel;Lio/netty/util/concurrent/EventExecutor;)V
    //   75: astore_2
    //   76: aload_0
    //   77: getfield 59	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:frameWriter	Lio/netty/handler/codec/http2/Http2FrameWriter;
    //   80: aload_1
    //   81: aload_2
    //   82: invokevirtual 496	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   85: invokeinterface 470 3 0
    //   90: pop
    //   91: aload_2
    //   92: invokevirtual 496	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   95: astore 4
    //   97: aload_0
    //   98: aload_3
    //   99: invokevirtual 498	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:remoteSettings	(Lio/netty/handler/codec/http2/Http2Settings;)V
    //   102: aload 4
    //   104: invokeinterface 501 1 0
    //   109: pop
    //   110: goto +25 -> 135
    //   113: astore_3
    //   114: aload 4
    //   116: aload_3
    //   117: invokeinterface 419 2 0
    //   122: pop
    //   123: aload_0
    //   124: getfield 82	io/netty/handler/codec/http2/DefaultHttp2ConnectionEncoder:lifecycleManager	Lio/netty/handler/codec/http2/Http2LifecycleManager;
    //   127: aload_1
    //   128: iconst_1
    //   129: aload_3
    //   130: invokeinterface 275 4 0
    //   135: aload_2
    //   136: invokevirtual 504	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   139: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	DefaultHttp2ConnectionEncoder
    //   0	140	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	140	2	paramChannelPromise	ChannelPromise
    //   4	95	3	localObject	Object
    //   113	17	3	localThrowable	Throwable
    //   95	20	4	localChannelPromise	ChannelPromise
    // Exception table:
    //   from	to	target	type
    //   97	110	113	finally
  }
  
  public ChannelFuture writeWindowUpdate(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, ChannelPromise paramChannelPromise)
  {
    return paramChannelPromise.setFailure(new UnsupportedOperationException("Use the Http2[Inbound|Outbound]FlowController objects to control window sizes"));
  }
  
  public abstract class FlowControlledBase
    implements Http2RemoteFlowController.FlowControlled, ChannelFutureListener
  {
    protected boolean endOfStream;
    protected int padding;
    protected ChannelPromise promise;
    protected final Http2Stream stream;
    
    FlowControlledBase(Http2Stream paramHttp2Stream, int paramInt, boolean paramBoolean, ChannelPromise paramChannelPromise)
    {
      ObjectUtil.checkPositiveOrZero(paramInt, "padding");
      this.padding = paramInt;
      this.endOfStream = paramBoolean;
      this.stream = paramHttp2Stream;
      this.promise = paramChannelPromise;
    }
    
    public void operationComplete(ChannelFuture paramChannelFuture)
      throws Exception
    {
      if (!paramChannelFuture.isSuccess()) {
        error(DefaultHttp2ConnectionEncoder.this.flowController().channelHandlerContext(), paramChannelFuture.cause());
      }
    }
    
    public void writeComplete()
    {
      if (this.endOfStream) {
        DefaultHttp2ConnectionEncoder.this.lifecycleManager.closeStreamLocal(this.stream, this.promise);
      }
    }
  }
  
  private final class FlowControlledData
    extends DefaultHttp2ConnectionEncoder.FlowControlledBase
  {
    private int dataSize;
    private final CoalescingBufferQueue queue;
    
    FlowControlledData(Http2Stream paramHttp2Stream, ByteBuf paramByteBuf, int paramInt, boolean paramBoolean, ChannelPromise paramChannelPromise)
    {
      super(paramHttp2Stream, paramInt, paramBoolean, paramChannelPromise);
      this$1 = new CoalescingBufferQueue(paramChannelPromise.channel());
      this.queue = DefaultHttp2ConnectionEncoder.this;
      DefaultHttp2ConnectionEncoder.this.add(paramByteBuf, paramChannelPromise);
      this.dataSize = DefaultHttp2ConnectionEncoder.this.readableBytes();
    }
    
    public void error(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    {
      this.queue.releaseAndFailAll(paramThrowable);
      DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(paramChannelHandlerContext, true, paramThrowable);
    }
    
    public boolean merge(ChannelHandlerContext paramChannelHandlerContext, Http2RemoteFlowController.FlowControlled paramFlowControlled)
    {
      if (FlowControlledData.class == paramFlowControlled.getClass())
      {
        paramChannelHandlerContext = (FlowControlledData)paramFlowControlled;
        if (Integer.MAX_VALUE - paramChannelHandlerContext.size() >= size())
        {
          paramChannelHandlerContext.queue.copyTo(this.queue);
          this.dataSize = this.queue.readableBytes();
          this.padding = Math.max(this.padding, paramChannelHandlerContext.padding);
          this.endOfStream = paramChannelHandlerContext.endOfStream;
          return true;
        }
      }
      return false;
    }
    
    public int size()
    {
      return this.dataSize + this.padding;
    }
    
    public void write(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
    {
      int i = this.queue.readableBytes();
      if (!this.endOfStream)
      {
        if (i == 0)
        {
          if (this.queue.isEmpty())
          {
            this.dataSize = 0;
            this.padding = 0;
          }
          else
          {
            localChannelPromise = paramChannelHandlerContext.newPromise().addListener(this);
            paramChannelHandlerContext.write(this.queue.remove(0, localChannelPromise), localChannelPromise);
          }
          return;
        }
        if (paramInt == 0) {
          return;
        }
      }
      i = Math.min(i, paramInt);
      ChannelPromise localChannelPromise = paramChannelHandlerContext.newPromise().addListener(this);
      ByteBuf localByteBuf = this.queue.remove(i, localChannelPromise);
      this.dataSize = this.queue.readableBytes();
      i = Math.min(paramInt - i, this.padding);
      this.padding -= i;
      Http2FrameWriter localHttp2FrameWriter = DefaultHttp2ConnectionEncoder.this.frameWriter();
      paramInt = this.stream.id();
      boolean bool;
      if ((this.endOfStream) && (size() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      localHttp2FrameWriter.writeData(paramChannelHandlerContext, paramInt, localByteBuf, i, bool, localChannelPromise);
    }
  }
  
  private final class FlowControlledHeaders
    extends DefaultHttp2ConnectionEncoder.FlowControlledBase
  {
    private final boolean exclusive;
    private final boolean hasPriorty;
    private final Http2Headers headers;
    private final int streamDependency;
    private final short weight;
    
    FlowControlledHeaders(Http2Stream paramHttp2Stream, Http2Headers paramHttp2Headers, boolean paramBoolean1, int paramInt1, short paramShort, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, ChannelPromise paramChannelPromise)
    {
      super(paramHttp2Stream, paramInt2, paramBoolean3, paramChannelPromise.unvoid());
      this.headers = paramHttp2Headers;
      this.hasPriorty = paramBoolean1;
      this.streamDependency = paramInt1;
      this.weight = ((short)paramShort);
      this.exclusive = paramBoolean2;
    }
    
    public void error(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    {
      if (paramChannelHandlerContext != null) {
        DefaultHttp2ConnectionEncoder.this.lifecycleManager.onError(paramChannelHandlerContext, true, paramThrowable);
      }
      this.promise.tryFailure(paramThrowable);
    }
    
    public boolean merge(ChannelHandlerContext paramChannelHandlerContext, Http2RemoteFlowController.FlowControlled paramFlowControlled)
    {
      return false;
    }
    
    public int size()
    {
      return 0;
    }
    
    public void write(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
    {
      boolean bool = DefaultHttp2ConnectionEncoder.validateHeadersSentState(this.stream, this.headers, DefaultHttp2ConnectionEncoder.this.connection.isServer(), this.endOfStream);
      this.promise.addListener(this);
      if (DefaultHttp2ConnectionEncoder.sendHeaders(DefaultHttp2ConnectionEncoder.this.frameWriter, paramChannelHandlerContext, this.stream.id(), this.headers, this.hasPriorty, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise).cause() == null) {
        this.stream.headersSent(bool);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2ConnectionEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
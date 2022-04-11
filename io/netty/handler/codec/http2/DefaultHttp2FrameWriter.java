package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCounted;
import io.netty.util.collection.CharObjectHashMap;
import io.netty.util.collection.CharObjectMap.PrimitiveEntry;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;

public class DefaultHttp2FrameWriter
  implements Http2FrameWriter, Http2FrameSizePolicy, Http2FrameWriter.Configuration
{
  private static final String STREAM_DEPENDENCY = "Stream Dependency";
  private static final String STREAM_ID = "Stream ID";
  private static final ByteBuf ZERO_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(255).writeZero(255)).asReadOnly();
  private final Http2HeadersEncoder headersEncoder;
  private int maxFrameSize;
  
  public DefaultHttp2FrameWriter()
  {
    this(new DefaultHttp2HeadersEncoder());
  }
  
  public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
  {
    this(new DefaultHttp2HeadersEncoder(paramSensitivityDetector));
  }
  
  public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector, boolean paramBoolean)
  {
    this(new DefaultHttp2HeadersEncoder(paramSensitivityDetector, paramBoolean));
  }
  
  public DefaultHttp2FrameWriter(Http2HeadersEncoder paramHttp2HeadersEncoder)
  {
    this.headersEncoder = paramHttp2HeadersEncoder;
    this.maxFrameSize = 16384;
  }
  
  private static int paddingBytes(int paramInt)
  {
    return paramInt - 1;
  }
  
  private static void verifyErrorCode(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong <= 4294967295L)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid errorCode: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void verifyPingPayload(ByteBuf paramByteBuf)
  {
    if ((paramByteBuf != null) && (paramByteBuf.readableBytes() == 8)) {
      return;
    }
    throw new IllegalArgumentException("Opaque data must be 8 bytes");
  }
  
  private static void verifyStreamId(int paramInt, String paramString)
  {
    ObjectUtil.checkPositive(paramInt, "streamId");
  }
  
  private static void verifyStreamOrConnectionId(int paramInt, String paramString)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "streamId");
  }
  
  private static void verifyWeight(short paramShort)
  {
    if ((paramShort >= 1) && (paramShort <= 256)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid weight: ");
    localStringBuilder.append(paramShort);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void verifyWindowSizeIncrement(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "windowSizeIncrement");
  }
  
  private ChannelFuture writeContinuationFrames(ChannelHandlerContext paramChannelHandlerContext, int paramInt, ByteBuf paramByteBuf, Http2CodecUtil.SimpleChannelPromiseAggregator paramSimpleChannelPromiseAggregator)
  {
    Http2Flags localHttp2Flags = new Http2Flags();
    if (paramByteBuf.isReadable())
    {
      int i = Math.min(paramByteBuf.readableBytes(), this.maxFrameSize);
      ByteBuf localByteBuf1 = paramChannelHandlerContext.alloc().buffer(10);
      Http2CodecUtil.writeFrameHeaderInternal(localByteBuf1, i, (byte)9, localHttp2Flags, paramInt);
      do
      {
        i = Math.min(paramByteBuf.readableBytes(), this.maxFrameSize);
        ByteBuf localByteBuf2 = paramByteBuf.readRetainedSlice(i);
        if (paramByteBuf.isReadable())
        {
          paramChannelHandlerContext.write(localByteBuf1.retain(), paramSimpleChannelPromiseAggregator.newPromise());
        }
        else
        {
          localHttp2Flags = localHttp2Flags.endOfHeaders(true);
          localByteBuf1.release();
          localByteBuf1 = paramChannelHandlerContext.alloc().buffer(10);
          Http2CodecUtil.writeFrameHeaderInternal(localByteBuf1, i, (byte)9, localHttp2Flags, paramInt);
          paramChannelHandlerContext.write(localByteBuf1, paramSimpleChannelPromiseAggregator.newPromise());
        }
        paramChannelHandlerContext.write(localByteBuf2, paramSimpleChannelPromiseAggregator.newPromise());
      } while (paramByteBuf.isReadable());
    }
    return paramSimpleChannelPromiseAggregator;
  }
  
  /* Error */
  private ChannelFuture writeHeadersInternal(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, short paramShort, boolean paramBoolean3, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: new 166	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator
    //   3: dup
    //   4: aload 10
    //   6: aload_1
    //   7: invokeinterface 193 1 0
    //   12: aload_1
    //   13: invokeinterface 197 1 0
    //   18: invokespecial 200	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:<init>	(Lio/netty/channel/ChannelPromise;Lio/netty/channel/Channel;Lio/netty/util/concurrent/EventExecutor;)V
    //   21: astore 11
    //   23: aconst_null
    //   24: astore 12
    //   26: aconst_null
    //   27: astore 13
    //   29: aload 13
    //   31: astore 10
    //   33: aload 12
    //   35: astore 14
    //   37: iload_2
    //   38: ldc 17
    //   40: invokestatic 202	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyStreamId	(ILjava/lang/String;)V
    //   43: iload 6
    //   45: ifeq +44 -> 89
    //   48: aload 13
    //   50: astore 10
    //   52: aload 12
    //   54: astore 14
    //   56: iload 7
    //   58: ldc 14
    //   60: invokestatic 204	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyStreamOrConnectionId	(ILjava/lang/String;)V
    //   63: aload 13
    //   65: astore 10
    //   67: aload 12
    //   69: astore 14
    //   71: iload 4
    //   73: invokestatic 207	io/netty/handler/codec/http2/Http2CodecUtil:verifyPadding	(I)V
    //   76: aload 13
    //   78: astore 10
    //   80: aload 12
    //   82: astore 14
    //   84: iload 8
    //   86: invokestatic 209	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyWeight	(S)V
    //   89: aload 13
    //   91: astore 10
    //   93: aload 12
    //   95: astore 14
    //   97: aload_1
    //   98: invokeinterface 147 1 0
    //   103: invokeinterface 211 1 0
    //   108: astore 13
    //   110: aload 13
    //   112: astore 10
    //   114: aload 13
    //   116: astore 14
    //   118: aload_0
    //   119: getfield 64	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:headersEncoder	Lio/netty/handler/codec/http2/Http2HeadersEncoder;
    //   122: iload_2
    //   123: aload_3
    //   124: aload 13
    //   126: invokeinterface 217 4 0
    //   131: aload 13
    //   133: astore 10
    //   135: aload 13
    //   137: astore 14
    //   139: new 130	io/netty/handler/codec/http2/Http2Flags
    //   142: astore_3
    //   143: aload 13
    //   145: astore 10
    //   147: aload 13
    //   149: astore 14
    //   151: aload_3
    //   152: invokespecial 131	io/netty/handler/codec/http2/Http2Flags:<init>	()V
    //   155: aload 13
    //   157: astore 10
    //   159: aload 13
    //   161: astore 14
    //   163: aload_3
    //   164: iload 5
    //   166: invokevirtual 220	io/netty/handler/codec/http2/Http2Flags:endOfStream	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   169: iload 6
    //   171: invokevirtual 223	io/netty/handler/codec/http2/Http2Flags:priorityPresent	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   174: astore_3
    //   175: iload 4
    //   177: ifle +9 -> 186
    //   180: iconst_1
    //   181: istore 5
    //   183: goto +6 -> 189
    //   186: iconst_0
    //   187: istore 5
    //   189: aload 13
    //   191: astore 10
    //   193: aload 13
    //   195: astore 14
    //   197: aload_3
    //   198: iload 5
    //   200: invokevirtual 226	io/netty/handler/codec/http2/Http2Flags:paddingPresent	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   203: astore 12
    //   205: aload 13
    //   207: astore 10
    //   209: aload 13
    //   211: astore 14
    //   213: aload 12
    //   215: invokevirtual 229	io/netty/handler/codec/http2/Http2Flags:getNumPriorityBytes	()I
    //   218: iload 4
    //   220: iadd
    //   221: istore 15
    //   223: aload 13
    //   225: astore 10
    //   227: aload 13
    //   229: astore 14
    //   231: aload_0
    //   232: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   235: istore 16
    //   237: aload 13
    //   239: astore 10
    //   241: aload 13
    //   243: astore 14
    //   245: aload 13
    //   247: aload 13
    //   249: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   252: iload 16
    //   254: iload 15
    //   256: isub
    //   257: invokestatic 141	java/lang/Math:min	(II)I
    //   260: invokevirtual 161	io/netty/buffer/ByteBuf:readRetainedSlice	(I)Lio/netty/buffer/ByteBuf;
    //   263: astore 17
    //   265: aload 13
    //   267: astore 10
    //   269: aload 13
    //   271: astore 14
    //   273: aload 13
    //   275: invokevirtual 135	io/netty/buffer/ByteBuf:isReadable	()Z
    //   278: ifne +9 -> 287
    //   281: iconst_1
    //   282: istore 5
    //   284: goto +6 -> 290
    //   287: iconst_0
    //   288: istore 5
    //   290: aload 13
    //   292: astore 10
    //   294: aload 13
    //   296: astore 14
    //   298: aload 12
    //   300: iload 5
    //   302: invokevirtual 180	io/netty/handler/codec/http2/Http2Flags:endOfHeaders	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   305: pop
    //   306: aload 13
    //   308: astore 10
    //   310: aload 13
    //   312: astore 14
    //   314: aload 17
    //   316: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   319: istore 16
    //   321: aload 13
    //   323: astore 10
    //   325: aload 13
    //   327: astore 14
    //   329: aload_1
    //   330: invokeinterface 147 1 0
    //   335: bipush 15
    //   337: invokeinterface 152 2 0
    //   342: astore_3
    //   343: aload 13
    //   345: astore 10
    //   347: aload 13
    //   349: astore 14
    //   351: aload_3
    //   352: iload 16
    //   354: iload 15
    //   356: iadd
    //   357: iconst_1
    //   358: aload 12
    //   360: iload_2
    //   361: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   364: aload 13
    //   366: astore 10
    //   368: aload 13
    //   370: astore 14
    //   372: aload_3
    //   373: iload 4
    //   375: invokestatic 233	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:writePaddingLength	(Lio/netty/buffer/ByteBuf;I)V
    //   378: iload 6
    //   380: ifeq +54 -> 434
    //   383: iload 7
    //   385: istore 15
    //   387: iload 9
    //   389: ifeq +13 -> 402
    //   392: iload 7
    //   394: i2l
    //   395: ldc2_w 234
    //   398: lor
    //   399: l2i
    //   400: istore 15
    //   402: aload 13
    //   404: astore 10
    //   406: aload 13
    //   408: astore 14
    //   410: aload_3
    //   411: iload 15
    //   413: invokevirtual 238	io/netty/buffer/ByteBuf:writeInt	(I)Lio/netty/buffer/ByteBuf;
    //   416: pop
    //   417: aload 13
    //   419: astore 10
    //   421: aload 13
    //   423: astore 14
    //   425: aload_3
    //   426: iload 8
    //   428: iconst_1
    //   429: isub
    //   430: invokevirtual 241	io/netty/buffer/ByteBuf:writeByte	(I)Lio/netty/buffer/ByteBuf;
    //   433: pop
    //   434: aload 13
    //   436: astore 10
    //   438: aload 13
    //   440: astore 14
    //   442: aload_1
    //   443: aload_3
    //   444: aload 11
    //   446: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   449: invokeinterface 176 3 0
    //   454: pop
    //   455: aload 13
    //   457: astore 10
    //   459: aload 13
    //   461: astore 14
    //   463: aload_1
    //   464: aload 17
    //   466: aload 11
    //   468: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   471: invokeinterface 176 3 0
    //   476: pop
    //   477: aload 13
    //   479: astore 10
    //   481: aload 13
    //   483: astore 14
    //   485: iload 4
    //   487: invokestatic 243	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:paddingBytes	(I)I
    //   490: ifle +35 -> 525
    //   493: aload 13
    //   495: astore 10
    //   497: aload 13
    //   499: astore 14
    //   501: aload_1
    //   502: getstatic 46	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:ZERO_BUFFER	Lio/netty/buffer/ByteBuf;
    //   505: iconst_0
    //   506: iload 4
    //   508: invokestatic 243	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:paddingBytes	(I)I
    //   511: invokevirtual 247	io/netty/buffer/ByteBuf:slice	(II)Lio/netty/buffer/ByteBuf;
    //   514: aload 11
    //   516: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   519: invokeinterface 176 3 0
    //   524: pop
    //   525: aload 13
    //   527: astore 10
    //   529: aload 13
    //   531: astore 14
    //   533: aload 13
    //   535: astore_3
    //   536: aload 12
    //   538: invokevirtual 249	io/netty/handler/codec/http2/Http2Flags:endOfHeaders	()Z
    //   541: ifne +85 -> 626
    //   544: aload 13
    //   546: astore 10
    //   548: aload 13
    //   550: astore 14
    //   552: aload_0
    //   553: aload_1
    //   554: iload_2
    //   555: aload 13
    //   557: aload 11
    //   559: invokespecial 251	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:writeContinuationFrames	(Lio/netty/channel/ChannelHandlerContext;ILio/netty/buffer/ByteBuf;Lio/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator;)Lio/netty/channel/ChannelFuture;
    //   562: pop
    //   563: aload 13
    //   565: astore_3
    //   566: goto +60 -> 626
    //   569: astore_3
    //   570: aload 10
    //   572: astore_1
    //   573: aload 11
    //   575: aload_3
    //   576: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   579: pop
    //   580: aload 10
    //   582: astore_1
    //   583: aload 11
    //   585: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   588: pop
    //   589: aload 10
    //   591: astore_1
    //   592: aload_3
    //   593: invokestatic 264	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   596: aload 10
    //   598: ifnull +35 -> 633
    //   601: aload 10
    //   603: astore_3
    //   604: goto +22 -> 626
    //   607: astore_3
    //   608: aload 14
    //   610: astore_1
    //   611: aload 11
    //   613: aload_3
    //   614: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   617: pop
    //   618: aload 14
    //   620: ifnull +13 -> 633
    //   623: aload 14
    //   625: astore_3
    //   626: aload_3
    //   627: invokeinterface 185 1 0
    //   632: pop
    //   633: aload 11
    //   635: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   638: areturn
    //   639: astore_3
    //   640: aload_1
    //   641: ifnull +10 -> 651
    //   644: aload_1
    //   645: invokeinterface 185 1 0
    //   650: pop
    //   651: aload_3
    //   652: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	DefaultHttp2FrameWriter
    //   0	653	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	653	2	paramInt1	int
    //   0	653	3	paramHttp2Headers	Http2Headers
    //   0	653	4	paramInt2	int
    //   0	653	5	paramBoolean1	boolean
    //   0	653	6	paramBoolean2	boolean
    //   0	653	7	paramInt3	int
    //   0	653	8	paramShort	short
    //   0	653	9	paramBoolean3	boolean
    //   0	653	10	paramChannelPromise	ChannelPromise
    //   21	613	11	localSimpleChannelPromiseAggregator	Http2CodecUtil.SimpleChannelPromiseAggregator
    //   24	513	12	localHttp2Flags	Http2Flags
    //   27	537	13	localByteBuf1	ByteBuf
    //   35	589	14	localObject	Object
    //   221	191	15	i	int
    //   235	122	16	j	int
    //   263	202	17	localByteBuf2	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   37	43	569	finally
    //   56	63	569	finally
    //   71	76	569	finally
    //   84	89	569	finally
    //   97	110	569	finally
    //   118	131	569	finally
    //   139	143	569	finally
    //   151	155	569	finally
    //   163	175	569	finally
    //   197	205	569	finally
    //   213	223	569	finally
    //   231	237	569	finally
    //   245	265	569	finally
    //   273	281	569	finally
    //   298	306	569	finally
    //   314	321	569	finally
    //   329	343	569	finally
    //   351	364	569	finally
    //   372	378	569	finally
    //   410	417	569	finally
    //   425	434	569	finally
    //   442	455	569	finally
    //   463	477	569	finally
    //   485	493	569	finally
    //   501	525	569	finally
    //   536	544	569	finally
    //   552	563	569	finally
    //   37	43	607	io/netty/handler/codec/http2/Http2Exception
    //   56	63	607	io/netty/handler/codec/http2/Http2Exception
    //   71	76	607	io/netty/handler/codec/http2/Http2Exception
    //   84	89	607	io/netty/handler/codec/http2/Http2Exception
    //   97	110	607	io/netty/handler/codec/http2/Http2Exception
    //   118	131	607	io/netty/handler/codec/http2/Http2Exception
    //   139	143	607	io/netty/handler/codec/http2/Http2Exception
    //   151	155	607	io/netty/handler/codec/http2/Http2Exception
    //   163	175	607	io/netty/handler/codec/http2/Http2Exception
    //   197	205	607	io/netty/handler/codec/http2/Http2Exception
    //   213	223	607	io/netty/handler/codec/http2/Http2Exception
    //   231	237	607	io/netty/handler/codec/http2/Http2Exception
    //   245	265	607	io/netty/handler/codec/http2/Http2Exception
    //   273	281	607	io/netty/handler/codec/http2/Http2Exception
    //   298	306	607	io/netty/handler/codec/http2/Http2Exception
    //   314	321	607	io/netty/handler/codec/http2/Http2Exception
    //   329	343	607	io/netty/handler/codec/http2/Http2Exception
    //   351	364	607	io/netty/handler/codec/http2/Http2Exception
    //   372	378	607	io/netty/handler/codec/http2/Http2Exception
    //   410	417	607	io/netty/handler/codec/http2/Http2Exception
    //   425	434	607	io/netty/handler/codec/http2/Http2Exception
    //   442	455	607	io/netty/handler/codec/http2/Http2Exception
    //   463	477	607	io/netty/handler/codec/http2/Http2Exception
    //   485	493	607	io/netty/handler/codec/http2/Http2Exception
    //   501	525	607	io/netty/handler/codec/http2/Http2Exception
    //   536	544	607	io/netty/handler/codec/http2/Http2Exception
    //   552	563	607	io/netty/handler/codec/http2/Http2Exception
    //   573	580	639	finally
    //   583	589	639	finally
    //   592	596	639	finally
    //   611	618	639	finally
  }
  
  private static void writePaddingLength(ByteBuf paramByteBuf, int paramInt)
  {
    if (paramInt > 0) {
      paramByteBuf.writeByte(paramInt - 1);
    }
  }
  
  public void close() {}
  
  public Http2FrameWriter.Configuration configuration()
  {
    return this;
  }
  
  public Http2FrameSizePolicy frameSizePolicy()
  {
    return this;
  }
  
  public Http2HeadersEncoder.Configuration headersConfiguration()
  {
    return this.headersEncoder.configuration();
  }
  
  public int maxFrameSize()
  {
    return this.maxFrameSize;
  }
  
  public void maxFrameSize(int paramInt)
    throws Http2Exception
  {
    if (Http2CodecUtil.isMaxFrameSizeValid(paramInt))
    {
      this.maxFrameSize = paramInt;
      return;
    }
    throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  /* Error */
  public ChannelFuture writeData(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 7
    //   3: new 166	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator
    //   6: dup
    //   7: aload 6
    //   9: aload_1
    //   10: invokeinterface 193 1 0
    //   15: aload_1
    //   16: invokeinterface 197 1 0
    //   21: invokespecial 200	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:<init>	(Lio/netty/channel/ChannelPromise;Lio/netty/channel/Channel;Lio/netty/util/concurrent/EventExecutor;)V
    //   24: astore 8
    //   26: iload_2
    //   27: ldc 17
    //   29: invokestatic 202	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyStreamId	(ILjava/lang/String;)V
    //   32: iload 4
    //   34: invokestatic 207	io/netty/handler/codec/http2/Http2CodecUtil:verifyPadding	(I)V
    //   37: aload_3
    //   38: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   41: istore 9
    //   43: new 130	io/netty/handler/codec/http2/Http2Flags
    //   46: astore 10
    //   48: aload 10
    //   50: invokespecial 131	io/netty/handler/codec/http2/Http2Flags:<init>	()V
    //   53: aload 10
    //   55: iconst_0
    //   56: invokevirtual 220	io/netty/handler/codec/http2/Http2Flags:endOfStream	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   59: pop
    //   60: aload 10
    //   62: iconst_0
    //   63: invokevirtual 226	io/netty/handler/codec/http2/Http2Flags:paddingPresent	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   66: pop
    //   67: iload 9
    //   69: aload_0
    //   70: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   73: if_icmple +116 -> 189
    //   76: aload_1
    //   77: invokeinterface 147 1 0
    //   82: bipush 9
    //   84: invokeinterface 152 2 0
    //   89: astore 6
    //   91: aload 6
    //   93: astore 11
    //   95: aload 6
    //   97: aload_0
    //   98: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   101: iconst_0
    //   102: aload 10
    //   104: iload_2
    //   105: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   108: aload 6
    //   110: astore 11
    //   112: aload_1
    //   113: aload 6
    //   115: invokevirtual 301	io/netty/buffer/ByteBuf:retainedSlice	()Lio/netty/buffer/ByteBuf;
    //   118: aload 8
    //   120: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   123: invokeinterface 176 3 0
    //   128: pop
    //   129: aload 6
    //   131: astore 11
    //   133: aload_1
    //   134: aload 7
    //   136: aload_0
    //   137: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   140: invokevirtual 161	io/netty/buffer/ByteBuf:readRetainedSlice	(I)Lio/netty/buffer/ByteBuf;
    //   143: aload 8
    //   145: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   148: invokeinterface 176 3 0
    //   153: pop
    //   154: aload 6
    //   156: astore 11
    //   158: aload_0
    //   159: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   162: istore 12
    //   164: iload 9
    //   166: iload 12
    //   168: isub
    //   169: istore 13
    //   171: iload 13
    //   173: istore 9
    //   175: iload 13
    //   177: iload 12
    //   179: if_icmpgt -71 -> 108
    //   182: iload 13
    //   184: istore 9
    //   186: goto +6 -> 192
    //   189: aconst_null
    //   190: astore 6
    //   192: iload 4
    //   194: ifne +121 -> 315
    //   197: aload 6
    //   199: astore_3
    //   200: aload 6
    //   202: ifnull +17 -> 219
    //   205: aload 6
    //   207: astore 11
    //   209: aload 6
    //   211: invokeinterface 185 1 0
    //   216: pop
    //   217: aconst_null
    //   218: astore_3
    //   219: aload_3
    //   220: astore 11
    //   222: aload_1
    //   223: invokeinterface 147 1 0
    //   228: bipush 9
    //   230: invokeinterface 152 2 0
    //   235: astore 6
    //   237: aload_3
    //   238: astore 11
    //   240: aload 10
    //   242: iload 5
    //   244: invokevirtual 220	io/netty/handler/codec/http2/Http2Flags:endOfStream	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   247: pop
    //   248: aload_3
    //   249: astore 11
    //   251: aload 6
    //   253: iload 9
    //   255: iconst_0
    //   256: aload 10
    //   258: iload_2
    //   259: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   262: aload_3
    //   263: astore 11
    //   265: aload_1
    //   266: aload 6
    //   268: aload 8
    //   270: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   273: invokeinterface 176 3 0
    //   278: pop
    //   279: aload_3
    //   280: astore 11
    //   282: aload 7
    //   284: iload 9
    //   286: invokevirtual 304	io/netty/buffer/ByteBuf:readSlice	(I)Lio/netty/buffer/ByteBuf;
    //   289: astore 6
    //   291: aload_1
    //   292: aload 6
    //   294: aload 8
    //   296: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   299: invokeinterface 176 3 0
    //   304: pop
    //   305: goto +555 -> 860
    //   308: astore_1
    //   309: aconst_null
    //   310: astore 6
    //   312: goto +576 -> 888
    //   315: aload 6
    //   317: astore 11
    //   319: aload_0
    //   320: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   323: istore 13
    //   325: iload 9
    //   327: iload 13
    //   329: if_icmpeq +31 -> 360
    //   332: aload 6
    //   334: ifnull +20 -> 354
    //   337: aload 6
    //   339: astore 11
    //   341: aload 6
    //   343: invokeinterface 185 1 0
    //   348: pop
    //   349: aconst_null
    //   350: astore_3
    //   351: goto +6 -> 357
    //   354: aload 6
    //   356: astore_3
    //   357: goto +158 -> 515
    //   360: iload 9
    //   362: iload 13
    //   364: isub
    //   365: istore 9
    //   367: aload 6
    //   369: ifnonnull +42 -> 411
    //   372: aload 6
    //   374: astore 11
    //   376: aload_1
    //   377: invokeinterface 147 1 0
    //   382: bipush 9
    //   384: invokeinterface 152 2 0
    //   389: astore 14
    //   391: aload 6
    //   393: astore 11
    //   395: aload 14
    //   397: aload_0
    //   398: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   401: iconst_0
    //   402: aload 10
    //   404: iload_2
    //   405: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   408: goto +17 -> 425
    //   411: aload 6
    //   413: astore 11
    //   415: aload 6
    //   417: invokevirtual 306	io/netty/buffer/ByteBuf:slice	()Lio/netty/buffer/ByteBuf;
    //   420: astore 14
    //   422: aconst_null
    //   423: astore 6
    //   425: aload 6
    //   427: astore 11
    //   429: aload_1
    //   430: aload 14
    //   432: aload 8
    //   434: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   437: invokeinterface 176 3 0
    //   442: pop
    //   443: aload 6
    //   445: astore 11
    //   447: aload_3
    //   448: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   451: istore 13
    //   453: aload 6
    //   455: astore 11
    //   457: aload_0
    //   458: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   461: istore 12
    //   463: aload 7
    //   465: astore 11
    //   467: iload 13
    //   469: iload 12
    //   471: if_icmpeq +18 -> 489
    //   474: aload 6
    //   476: astore 11
    //   478: aload 7
    //   480: iload 12
    //   482: invokevirtual 304	io/netty/buffer/ByteBuf:readSlice	(I)Lio/netty/buffer/ByteBuf;
    //   485: astore_3
    //   486: aload_3
    //   487: astore 11
    //   489: aload 6
    //   491: astore_3
    //   492: aload_1
    //   493: aload 11
    //   495: aload 8
    //   497: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   500: invokeinterface 176 3 0
    //   505: pop
    //   506: aload 6
    //   508: astore_3
    //   509: aconst_null
    //   510: astore 7
    //   512: goto -155 -> 357
    //   515: aload 7
    //   517: astore 6
    //   519: iload 9
    //   521: aload_0
    //   522: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   525: invokestatic 141	java/lang/Math:min	(II)I
    //   528: istore 15
    //   530: aload 7
    //   532: astore 6
    //   534: aload_0
    //   535: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   538: istore 13
    //   540: iconst_1
    //   541: istore 16
    //   543: aload 7
    //   545: astore 6
    //   547: iload 4
    //   549: iconst_0
    //   550: iload 13
    //   552: iconst_1
    //   553: isub
    //   554: iload 15
    //   556: isub
    //   557: invokestatic 309	java/lang/Math:max	(II)I
    //   560: invokestatic 141	java/lang/Math:min	(II)I
    //   563: istore 17
    //   565: iload 4
    //   567: iload 17
    //   569: isub
    //   570: istore 13
    //   572: iload 9
    //   574: iload 15
    //   576: isub
    //   577: istore 12
    //   579: aload 7
    //   581: astore 6
    //   583: aload_1
    //   584: invokeinterface 147 1 0
    //   589: bipush 10
    //   591: invokeinterface 152 2 0
    //   596: astore 11
    //   598: iload 5
    //   600: ifeq +19 -> 619
    //   603: iload 12
    //   605: ifne +14 -> 619
    //   608: iload 13
    //   610: ifne +9 -> 619
    //   613: iconst_1
    //   614: istore 18
    //   616: goto +6 -> 622
    //   619: iconst_0
    //   620: istore 18
    //   622: aload 7
    //   624: astore 6
    //   626: aload 10
    //   628: iload 18
    //   630: invokevirtual 220	io/netty/handler/codec/http2/Http2Flags:endOfStream	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   633: pop
    //   634: iload 17
    //   636: ifle +10 -> 646
    //   639: iload 16
    //   641: istore 18
    //   643: goto +6 -> 649
    //   646: iconst_0
    //   647: istore 18
    //   649: aload 7
    //   651: astore 6
    //   653: aload 10
    //   655: iload 18
    //   657: invokevirtual 226	io/netty/handler/codec/http2/Http2Flags:paddingPresent	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   660: pop
    //   661: aload 7
    //   663: astore 6
    //   665: aload 11
    //   667: iload 17
    //   669: iload 15
    //   671: iadd
    //   672: iconst_0
    //   673: aload 10
    //   675: iload_2
    //   676: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   679: aload 7
    //   681: astore 6
    //   683: aload 11
    //   685: iload 17
    //   687: invokestatic 233	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:writePaddingLength	(Lio/netty/buffer/ByteBuf;I)V
    //   690: aload 7
    //   692: astore 6
    //   694: aload_1
    //   695: aload 11
    //   697: aload 8
    //   699: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   702: invokeinterface 176 3 0
    //   707: pop
    //   708: aload 7
    //   710: astore 11
    //   712: iload 15
    //   714: ifeq +72 -> 786
    //   717: iload 12
    //   719: ifne +40 -> 759
    //   722: aload 7
    //   724: astore 6
    //   726: aload 7
    //   728: iload 15
    //   730: invokevirtual 304	io/netty/buffer/ByteBuf:readSlice	(I)Lio/netty/buffer/ByteBuf;
    //   733: astore 7
    //   735: aload_1
    //   736: aload 7
    //   738: aload 8
    //   740: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   743: invokeinterface 176 3 0
    //   748: pop
    //   749: aconst_null
    //   750: astore 11
    //   752: goto +34 -> 786
    //   755: astore_1
    //   756: goto -447 -> 309
    //   759: aload 7
    //   761: astore 6
    //   763: aload_1
    //   764: aload 7
    //   766: iload 15
    //   768: invokevirtual 161	io/netty/buffer/ByteBuf:readRetainedSlice	(I)Lio/netty/buffer/ByteBuf;
    //   771: aload 8
    //   773: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   776: invokeinterface 176 3 0
    //   781: pop
    //   782: aload 7
    //   784: astore 11
    //   786: aload 11
    //   788: astore 6
    //   790: iload 17
    //   792: invokestatic 243	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:paddingBytes	(I)I
    //   795: ifle +31 -> 826
    //   798: aload 11
    //   800: astore 6
    //   802: aload_1
    //   803: getstatic 46	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:ZERO_BUFFER	Lio/netty/buffer/ByteBuf;
    //   806: iconst_0
    //   807: iload 17
    //   809: invokestatic 243	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:paddingBytes	(I)I
    //   812: invokevirtual 247	io/netty/buffer/ByteBuf:slice	(II)Lio/netty/buffer/ByteBuf;
    //   815: aload 8
    //   817: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   820: invokeinterface 176 3 0
    //   825: pop
    //   826: aload 11
    //   828: astore 7
    //   830: iload 13
    //   832: istore 4
    //   834: iload 12
    //   836: istore 9
    //   838: iload 12
    //   840: ifne -325 -> 515
    //   843: aload 11
    //   845: astore 7
    //   847: iload 13
    //   849: istore 4
    //   851: iload 12
    //   853: istore 9
    //   855: iload 13
    //   857: ifne -342 -> 515
    //   860: aload 8
    //   862: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   865: areturn
    //   866: astore_1
    //   867: goto +21 -> 888
    //   870: astore_1
    //   871: aload 11
    //   873: astore_3
    //   874: aload 7
    //   876: astore 6
    //   878: goto +10 -> 888
    //   881: astore_1
    //   882: aconst_null
    //   883: astore_3
    //   884: aload 7
    //   886: astore 6
    //   888: aload_3
    //   889: ifnull +10 -> 899
    //   892: aload_3
    //   893: invokeinterface 185 1 0
    //   898: pop
    //   899: aload 6
    //   901: ifnull +30 -> 931
    //   904: aload 6
    //   906: invokeinterface 185 1 0
    //   911: pop
    //   912: goto +19 -> 931
    //   915: astore_3
    //   916: aload 8
    //   918: aload_1
    //   919: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   922: pop
    //   923: aload 8
    //   925: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   928: pop
    //   929: aload_3
    //   930: athrow
    //   931: aload 8
    //   933: aload_1
    //   934: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   937: pop
    //   938: aload 8
    //   940: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   943: pop
    //   944: aload 8
    //   946: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	this	DefaultHttp2FrameWriter
    //   0	947	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	947	2	paramInt1	int
    //   0	947	3	paramByteBuf	ByteBuf
    //   0	947	4	paramInt2	int
    //   0	947	5	paramBoolean	boolean
    //   0	947	6	paramChannelPromise	ChannelPromise
    //   1	884	7	localObject1	Object
    //   24	921	8	localSimpleChannelPromiseAggregator	Http2CodecUtil.SimpleChannelPromiseAggregator
    //   41	813	9	i	int
    //   46	628	10	localHttp2Flags	Http2Flags
    //   93	779	11	localObject2	Object
    //   162	690	12	j	int
    //   169	687	13	k	int
    //   389	42	14	localByteBuf	ByteBuf
    //   528	239	15	m	int
    //   541	99	16	bool1	boolean
    //   563	245	17	n	int
    //   614	42	18	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   291	305	308	finally
    //   492	506	308	finally
    //   735	749	755	finally
    //   519	530	866	finally
    //   534	540	866	finally
    //   547	565	866	finally
    //   583	598	866	finally
    //   626	634	866	finally
    //   653	661	866	finally
    //   665	679	866	finally
    //   683	690	866	finally
    //   694	708	866	finally
    //   726	735	866	finally
    //   763	782	866	finally
    //   790	798	866	finally
    //   802	826	866	finally
    //   95	108	870	finally
    //   112	129	870	finally
    //   133	154	870	finally
    //   158	164	870	finally
    //   209	217	870	finally
    //   222	237	870	finally
    //   240	248	870	finally
    //   251	262	870	finally
    //   265	279	870	finally
    //   282	291	870	finally
    //   319	325	870	finally
    //   341	349	870	finally
    //   376	391	870	finally
    //   395	408	870	finally
    //   415	422	870	finally
    //   429	443	870	finally
    //   447	453	870	finally
    //   457	463	870	finally
    //   478	486	870	finally
    //   26	91	881	finally
    //   904	912	915	finally
  }
  
  /* Error */
  public ChannelFuture writeFrame(ChannelHandlerContext paramChannelHandlerContext, byte paramByte, int paramInt, Http2Flags paramHttp2Flags, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: new 166	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator
    //   3: dup
    //   4: aload 6
    //   6: aload_1
    //   7: invokeinterface 193 1 0
    //   12: aload_1
    //   13: invokeinterface 197 1 0
    //   18: invokespecial 200	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:<init>	(Lio/netty/channel/ChannelPromise;Lio/netty/channel/Channel;Lio/netty/util/concurrent/EventExecutor;)V
    //   21: astore 6
    //   23: iload_3
    //   24: ldc 17
    //   26: invokestatic 204	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyStreamOrConnectionId	(ILjava/lang/String;)V
    //   29: aload_1
    //   30: invokeinterface 147 1 0
    //   35: bipush 9
    //   37: invokeinterface 152 2 0
    //   42: astore 7
    //   44: aload 7
    //   46: aload 5
    //   48: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   51: iload_2
    //   52: aload 4
    //   54: iload_3
    //   55: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   58: aload_1
    //   59: aload 7
    //   61: aload 6
    //   63: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   66: invokeinterface 176 3 0
    //   71: pop
    //   72: aload_1
    //   73: aload 5
    //   75: aload 6
    //   77: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   80: invokeinterface 176 3 0
    //   85: pop
    //   86: goto +11 -> 97
    //   89: astore_1
    //   90: aload 6
    //   92: aload_1
    //   93: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   96: pop
    //   97: aload 6
    //   99: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   102: areturn
    //   103: astore_1
    //   104: aload 5
    //   106: invokeinterface 185 1 0
    //   111: pop
    //   112: aload 6
    //   114: aload_1
    //   115: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   118: pop
    //   119: aload 6
    //   121: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   124: pop
    //   125: aload 6
    //   127: areturn
    //   128: astore 4
    //   130: aload 6
    //   132: aload_1
    //   133: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   136: pop
    //   137: aload 6
    //   139: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   142: pop
    //   143: aload 4
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	DefaultHttp2FrameWriter
    //   0	146	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	146	2	paramByte	byte
    //   0	146	3	paramInt	int
    //   0	146	4	paramHttp2Flags	Http2Flags
    //   0	146	5	paramByteBuf	ByteBuf
    //   0	146	6	paramChannelPromise	ChannelPromise
    //   42	18	7	localByteBuf	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   72	86	89	finally
    //   23	72	103	finally
    //   104	112	128	finally
  }
  
  /* Error */
  public ChannelFuture writeGoAway(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ByteBuf paramByteBuf, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: new 166	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator
    //   3: dup
    //   4: aload 6
    //   6: aload_1
    //   7: invokeinterface 193 1 0
    //   12: aload_1
    //   13: invokeinterface 197 1 0
    //   18: invokespecial 200	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:<init>	(Lio/netty/channel/ChannelPromise;Lio/netty/channel/Channel;Lio/netty/util/concurrent/EventExecutor;)V
    //   21: astore 6
    //   23: iload_2
    //   24: ldc_w 315
    //   27: invokestatic 204	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyStreamOrConnectionId	(ILjava/lang/String;)V
    //   30: lload_3
    //   31: invokestatic 317	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyErrorCode	(J)V
    //   34: aload 5
    //   36: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   39: istore 7
    //   41: aload_1
    //   42: invokeinterface 147 1 0
    //   47: bipush 17
    //   49: invokeinterface 152 2 0
    //   54: astore 8
    //   56: new 130	io/netty/handler/codec/http2/Http2Flags
    //   59: astore 9
    //   61: aload 9
    //   63: invokespecial 131	io/netty/handler/codec/http2/Http2Flags:<init>	()V
    //   66: aload 8
    //   68: iload 7
    //   70: bipush 8
    //   72: iadd
    //   73: bipush 7
    //   75: aload 9
    //   77: iconst_0
    //   78: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   81: aload 8
    //   83: iload_2
    //   84: invokevirtual 238	io/netty/buffer/ByteBuf:writeInt	(I)Lio/netty/buffer/ByteBuf;
    //   87: pop
    //   88: aload 8
    //   90: lload_3
    //   91: l2i
    //   92: invokevirtual 238	io/netty/buffer/ByteBuf:writeInt	(I)Lio/netty/buffer/ByteBuf;
    //   95: pop
    //   96: aload_1
    //   97: aload 8
    //   99: aload 6
    //   101: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   104: invokeinterface 176 3 0
    //   109: pop
    //   110: aload_1
    //   111: aload 5
    //   113: aload 6
    //   115: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   118: invokeinterface 176 3 0
    //   123: pop
    //   124: goto +11 -> 135
    //   127: astore_1
    //   128: aload 6
    //   130: aload_1
    //   131: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   134: pop
    //   135: aload 6
    //   137: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   140: areturn
    //   141: astore_1
    //   142: aload 5
    //   144: invokeinterface 185 1 0
    //   149: pop
    //   150: aload 6
    //   152: aload_1
    //   153: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   156: pop
    //   157: aload 6
    //   159: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   162: pop
    //   163: aload 6
    //   165: areturn
    //   166: astore 5
    //   168: aload 6
    //   170: aload_1
    //   171: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   174: pop
    //   175: aload 6
    //   177: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   180: pop
    //   181: aload 5
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	DefaultHttp2FrameWriter
    //   0	184	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	184	2	paramInt	int
    //   0	184	3	paramLong	long
    //   0	184	5	paramByteBuf	ByteBuf
    //   0	184	6	paramChannelPromise	ChannelPromise
    //   39	34	7	i	int
    //   54	44	8	localByteBuf	ByteBuf
    //   59	17	9	localHttp2Flags	Http2Flags
    // Exception table:
    //   from	to	target	type
    //   110	124	127	finally
    //   23	110	141	finally
    //   142	150	166	finally
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, ChannelPromise paramChannelPromise)
  {
    return writeHeadersInternal(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt3, paramBoolean2, true, paramInt2, paramShort, paramBoolean1, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    return writeHeadersInternal(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramBoolean, false, 0, (short)0, false, paramChannelPromise);
  }
  
  public ChannelFuture writePing(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean, long paramLong, ChannelPromise paramChannelPromise)
  {
    Http2Flags localHttp2Flags;
    if (paramBoolean) {
      localHttp2Flags = new Http2Flags().ack(true);
    } else {
      localHttp2Flags = new Http2Flags();
    }
    ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer(17);
    Http2CodecUtil.writeFrameHeaderInternal(localByteBuf, 8, (byte)6, localHttp2Flags, 0);
    localByteBuf.writeLong(paramLong);
    return paramChannelHandlerContext.write(localByteBuf, paramChannelPromise);
  }
  
  public ChannelFuture writePriority(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, short paramShort, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    try
    {
      verifyStreamId(paramInt1, "Stream ID");
      verifyStreamId(paramInt2, "Stream Dependency");
      verifyWeight(paramShort);
      ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer(14);
      Http2Flags localHttp2Flags = new io/netty/handler/codec/http2/Http2Flags;
      localHttp2Flags.<init>();
      Http2CodecUtil.writeFrameHeaderInternal(localByteBuf, 5, (byte)2, localHttp2Flags, paramInt1);
      paramInt1 = paramInt2;
      if (paramBoolean) {
        paramInt1 = (int)(paramInt2 | 0x80000000);
      }
      localByteBuf.writeInt(paramInt1);
      localByteBuf.writeByte(paramShort - 1);
      paramChannelHandlerContext = paramChannelHandlerContext.write(localByteBuf, paramChannelPromise);
      return paramChannelHandlerContext;
    }
    finally {}
    return paramChannelPromise.setFailure(paramChannelHandlerContext);
  }
  
  /* Error */
  public ChannelFuture writePushPromise(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, Http2Headers paramHttp2Headers, int paramInt3, ChannelPromise paramChannelPromise)
  {
    // Byte code:
    //   0: new 166	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator
    //   3: dup
    //   4: aload 6
    //   6: aload_1
    //   7: invokeinterface 193 1 0
    //   12: aload_1
    //   13: invokeinterface 197 1 0
    //   18: invokespecial 200	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:<init>	(Lio/netty/channel/ChannelPromise;Lio/netty/channel/Channel;Lio/netty/util/concurrent/EventExecutor;)V
    //   21: astore 7
    //   23: aconst_null
    //   24: astore 8
    //   26: aconst_null
    //   27: astore 9
    //   29: aload 9
    //   31: astore 10
    //   33: aload 8
    //   35: astore 6
    //   37: iload_2
    //   38: ldc 17
    //   40: invokestatic 202	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyStreamId	(ILjava/lang/String;)V
    //   43: aload 9
    //   45: astore 10
    //   47: aload 8
    //   49: astore 6
    //   51: iload_3
    //   52: ldc_w 340
    //   55: invokestatic 202	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:verifyStreamId	(ILjava/lang/String;)V
    //   58: aload 9
    //   60: astore 10
    //   62: aload 8
    //   64: astore 6
    //   66: iload 5
    //   68: invokestatic 207	io/netty/handler/codec/http2/Http2CodecUtil:verifyPadding	(I)V
    //   71: aload 9
    //   73: astore 10
    //   75: aload 8
    //   77: astore 6
    //   79: aload_1
    //   80: invokeinterface 147 1 0
    //   85: invokeinterface 211 1 0
    //   90: astore 9
    //   92: aload 9
    //   94: astore 10
    //   96: aload 9
    //   98: astore 6
    //   100: aload_0
    //   101: getfield 64	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:headersEncoder	Lio/netty/handler/codec/http2/Http2HeadersEncoder;
    //   104: iload_2
    //   105: aload 4
    //   107: aload 9
    //   109: invokeinterface 217 4 0
    //   114: aload 9
    //   116: astore 10
    //   118: aload 9
    //   120: astore 6
    //   122: new 130	io/netty/handler/codec/http2/Http2Flags
    //   125: astore 4
    //   127: aload 9
    //   129: astore 10
    //   131: aload 9
    //   133: astore 6
    //   135: aload 4
    //   137: invokespecial 131	io/netty/handler/codec/http2/Http2Flags:<init>	()V
    //   140: iconst_1
    //   141: istore 11
    //   143: iload 5
    //   145: ifle +9 -> 154
    //   148: iconst_1
    //   149: istore 12
    //   151: goto +6 -> 157
    //   154: iconst_0
    //   155: istore 12
    //   157: aload 9
    //   159: astore 10
    //   161: aload 9
    //   163: astore 6
    //   165: aload 4
    //   167: iload 12
    //   169: invokevirtual 226	io/netty/handler/codec/http2/Http2Flags:paddingPresent	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   172: astore 8
    //   174: iload 5
    //   176: iconst_4
    //   177: iadd
    //   178: istore 13
    //   180: aload 9
    //   182: astore 10
    //   184: aload 9
    //   186: astore 6
    //   188: aload_0
    //   189: getfield 66	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:maxFrameSize	I
    //   192: istore 14
    //   194: aload 9
    //   196: astore 10
    //   198: aload 9
    //   200: astore 6
    //   202: aload 9
    //   204: aload 9
    //   206: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   209: iload 14
    //   211: iload 13
    //   213: isub
    //   214: invokestatic 141	java/lang/Math:min	(II)I
    //   217: invokevirtual 161	io/netty/buffer/ByteBuf:readRetainedSlice	(I)Lio/netty/buffer/ByteBuf;
    //   220: astore 15
    //   222: aload 9
    //   224: astore 10
    //   226: aload 9
    //   228: astore 6
    //   230: aload 9
    //   232: invokevirtual 135	io/netty/buffer/ByteBuf:isReadable	()Z
    //   235: ifne +10 -> 245
    //   238: iload 11
    //   240: istore 12
    //   242: goto +6 -> 248
    //   245: iconst_0
    //   246: istore 12
    //   248: aload 9
    //   250: astore 10
    //   252: aload 9
    //   254: astore 6
    //   256: aload 8
    //   258: iload 12
    //   260: invokevirtual 180	io/netty/handler/codec/http2/Http2Flags:endOfHeaders	(Z)Lio/netty/handler/codec/http2/Http2Flags;
    //   263: pop
    //   264: aload 9
    //   266: astore 10
    //   268: aload 9
    //   270: astore 6
    //   272: aload 15
    //   274: invokevirtual 99	io/netty/buffer/ByteBuf:readableBytes	()I
    //   277: istore 14
    //   279: aload 9
    //   281: astore 10
    //   283: aload 9
    //   285: astore 6
    //   287: aload_1
    //   288: invokeinterface 147 1 0
    //   293: bipush 14
    //   295: invokeinterface 152 2 0
    //   300: astore 4
    //   302: aload 9
    //   304: astore 10
    //   306: aload 9
    //   308: astore 6
    //   310: aload 4
    //   312: iload 14
    //   314: iload 13
    //   316: iadd
    //   317: iconst_5
    //   318: aload 8
    //   320: iload_2
    //   321: invokestatic 158	io/netty/handler/codec/http2/Http2CodecUtil:writeFrameHeaderInternal	(Lio/netty/buffer/ByteBuf;IBLio/netty/handler/codec/http2/Http2Flags;I)V
    //   324: aload 9
    //   326: astore 10
    //   328: aload 9
    //   330: astore 6
    //   332: aload 4
    //   334: iload 5
    //   336: invokestatic 233	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:writePaddingLength	(Lio/netty/buffer/ByteBuf;I)V
    //   339: aload 9
    //   341: astore 10
    //   343: aload 9
    //   345: astore 6
    //   347: aload 4
    //   349: iload_3
    //   350: invokevirtual 238	io/netty/buffer/ByteBuf:writeInt	(I)Lio/netty/buffer/ByteBuf;
    //   353: pop
    //   354: aload 9
    //   356: astore 10
    //   358: aload 9
    //   360: astore 6
    //   362: aload_1
    //   363: aload 4
    //   365: aload 7
    //   367: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   370: invokeinterface 176 3 0
    //   375: pop
    //   376: aload 9
    //   378: astore 10
    //   380: aload 9
    //   382: astore 6
    //   384: aload_1
    //   385: aload 15
    //   387: aload 7
    //   389: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   392: invokeinterface 176 3 0
    //   397: pop
    //   398: aload 9
    //   400: astore 10
    //   402: aload 9
    //   404: astore 6
    //   406: iload 5
    //   408: invokestatic 243	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:paddingBytes	(I)I
    //   411: ifle +35 -> 446
    //   414: aload 9
    //   416: astore 10
    //   418: aload 9
    //   420: astore 6
    //   422: aload_1
    //   423: getstatic 46	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:ZERO_BUFFER	Lio/netty/buffer/ByteBuf;
    //   426: iconst_0
    //   427: iload 5
    //   429: invokestatic 243	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:paddingBytes	(I)I
    //   432: invokevirtual 247	io/netty/buffer/ByteBuf:slice	(II)Lio/netty/buffer/ByteBuf;
    //   435: aload 7
    //   437: invokevirtual 170	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:newPromise	()Lio/netty/channel/ChannelPromise;
    //   440: invokeinterface 176 3 0
    //   445: pop
    //   446: aload 9
    //   448: astore 10
    //   450: aload 9
    //   452: astore 6
    //   454: aload 9
    //   456: astore 4
    //   458: aload 8
    //   460: invokevirtual 249	io/netty/handler/codec/http2/Http2Flags:endOfHeaders	()Z
    //   463: ifne +93 -> 556
    //   466: aload 9
    //   468: astore 10
    //   470: aload 9
    //   472: astore 6
    //   474: aload_0
    //   475: aload_1
    //   476: iload_2
    //   477: aload 9
    //   479: aload 7
    //   481: invokespecial 251	io/netty/handler/codec/http2/DefaultHttp2FrameWriter:writeContinuationFrames	(Lio/netty/channel/ChannelHandlerContext;ILio/netty/buffer/ByteBuf;Lio/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator;)Lio/netty/channel/ChannelFuture;
    //   484: pop
    //   485: aload 9
    //   487: astore 4
    //   489: goto +67 -> 556
    //   492: astore 4
    //   494: aload 10
    //   496: astore_1
    //   497: aload 7
    //   499: aload 4
    //   501: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   504: pop
    //   505: aload 10
    //   507: astore_1
    //   508: aload 7
    //   510: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   513: pop
    //   514: aload 10
    //   516: astore_1
    //   517: aload 4
    //   519: invokestatic 264	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   522: aload 10
    //   524: ifnull +40 -> 564
    //   527: aload 10
    //   529: astore 4
    //   531: goto +25 -> 556
    //   534: astore 4
    //   536: aload 6
    //   538: astore_1
    //   539: aload 7
    //   541: aload 4
    //   543: invokevirtual 255	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:setFailure	(Ljava/lang/Throwable;)Lio/netty/channel/ChannelPromise;
    //   546: pop
    //   547: aload 6
    //   549: ifnull +15 -> 564
    //   552: aload 6
    //   554: astore 4
    //   556: aload 4
    //   558: invokeinterface 185 1 0
    //   563: pop
    //   564: aload 7
    //   566: invokevirtual 258	io/netty/handler/codec/http2/Http2CodecUtil$SimpleChannelPromiseAggregator:doneAllocatingPromises	()Lio/netty/channel/ChannelPromise;
    //   569: areturn
    //   570: astore 4
    //   572: aload_1
    //   573: ifnull +10 -> 583
    //   576: aload_1
    //   577: invokeinterface 185 1 0
    //   582: pop
    //   583: aload 4
    //   585: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	DefaultHttp2FrameWriter
    //   0	586	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	586	2	paramInt1	int
    //   0	586	3	paramInt2	int
    //   0	586	4	paramHttp2Headers	Http2Headers
    //   0	586	5	paramInt3	int
    //   0	586	6	paramChannelPromise	ChannelPromise
    //   21	544	7	localSimpleChannelPromiseAggregator	Http2CodecUtil.SimpleChannelPromiseAggregator
    //   24	435	8	localHttp2Flags	Http2Flags
    //   27	459	9	localByteBuf1	ByteBuf
    //   31	497	10	localByteBuf2	ByteBuf
    //   141	98	11	bool1	boolean
    //   149	110	12	bool2	boolean
    //   178	139	13	i	int
    //   192	125	14	j	int
    //   220	166	15	localByteBuf3	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   37	43	492	finally
    //   51	58	492	finally
    //   66	71	492	finally
    //   79	92	492	finally
    //   100	114	492	finally
    //   122	127	492	finally
    //   135	140	492	finally
    //   165	174	492	finally
    //   188	194	492	finally
    //   202	222	492	finally
    //   230	238	492	finally
    //   256	264	492	finally
    //   272	279	492	finally
    //   287	302	492	finally
    //   310	324	492	finally
    //   332	339	492	finally
    //   347	354	492	finally
    //   362	376	492	finally
    //   384	398	492	finally
    //   406	414	492	finally
    //   422	446	492	finally
    //   458	466	492	finally
    //   474	485	492	finally
    //   37	43	534	io/netty/handler/codec/http2/Http2Exception
    //   51	58	534	io/netty/handler/codec/http2/Http2Exception
    //   66	71	534	io/netty/handler/codec/http2/Http2Exception
    //   79	92	534	io/netty/handler/codec/http2/Http2Exception
    //   100	114	534	io/netty/handler/codec/http2/Http2Exception
    //   122	127	534	io/netty/handler/codec/http2/Http2Exception
    //   135	140	534	io/netty/handler/codec/http2/Http2Exception
    //   165	174	534	io/netty/handler/codec/http2/Http2Exception
    //   188	194	534	io/netty/handler/codec/http2/Http2Exception
    //   202	222	534	io/netty/handler/codec/http2/Http2Exception
    //   230	238	534	io/netty/handler/codec/http2/Http2Exception
    //   256	264	534	io/netty/handler/codec/http2/Http2Exception
    //   272	279	534	io/netty/handler/codec/http2/Http2Exception
    //   287	302	534	io/netty/handler/codec/http2/Http2Exception
    //   310	324	534	io/netty/handler/codec/http2/Http2Exception
    //   332	339	534	io/netty/handler/codec/http2/Http2Exception
    //   347	354	534	io/netty/handler/codec/http2/Http2Exception
    //   362	376	534	io/netty/handler/codec/http2/Http2Exception
    //   384	398	534	io/netty/handler/codec/http2/Http2Exception
    //   406	414	534	io/netty/handler/codec/http2/Http2Exception
    //   422	446	534	io/netty/handler/codec/http2/Http2Exception
    //   458	466	534	io/netty/handler/codec/http2/Http2Exception
    //   474	485	534	io/netty/handler/codec/http2/Http2Exception
    //   497	505	570	finally
    //   508	514	570	finally
    //   517	522	570	finally
    //   539	547	570	finally
  }
  
  public ChannelFuture writeRstStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    try
    {
      verifyStreamId(paramInt, "Stream ID");
      verifyErrorCode(paramLong);
      ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer(13);
      Http2Flags localHttp2Flags = new io/netty/handler/codec/http2/Http2Flags;
      localHttp2Flags.<init>();
      Http2CodecUtil.writeFrameHeaderInternal(localByteBuf, 4, (byte)3, localHttp2Flags, paramInt);
      localByteBuf.writeInt((int)paramLong);
      paramChannelHandlerContext = paramChannelHandlerContext.write(localByteBuf, paramChannelPromise);
      return paramChannelHandlerContext;
    }
    finally {}
    return paramChannelPromise.setFailure(paramChannelHandlerContext);
  }
  
  public ChannelFuture writeSettings(ChannelHandlerContext paramChannelHandlerContext, Http2Settings paramHttp2Settings, ChannelPromise paramChannelPromise)
  {
    try
    {
      ObjectUtil.checkNotNull(paramHttp2Settings, "settings");
      int i = paramHttp2Settings.size();
      ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer(paramHttp2Settings.size() * 6 + 9);
      Object localObject = new io/netty/handler/codec/http2/Http2Flags;
      ((Http2Flags)localObject).<init>();
      Http2CodecUtil.writeFrameHeaderInternal(localByteBuf, i * 6, (byte)4, (Http2Flags)localObject, 0);
      paramHttp2Settings = paramHttp2Settings.entries().iterator();
      while (paramHttp2Settings.hasNext())
      {
        localObject = (CharObjectMap.PrimitiveEntry)paramHttp2Settings.next();
        localByteBuf.writeChar(((CharObjectMap.PrimitiveEntry)localObject).key());
        localByteBuf.writeInt(((Long)((CharObjectMap.PrimitiveEntry)localObject).value()).intValue());
      }
      paramChannelHandlerContext = paramChannelHandlerContext.write(localByteBuf, paramChannelPromise);
      return paramChannelHandlerContext;
    }
    finally {}
    return paramChannelPromise.setFailure(paramChannelHandlerContext);
  }
  
  public ChannelFuture writeSettingsAck(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    try
    {
      ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer(9);
      Http2Flags localHttp2Flags = new io/netty/handler/codec/http2/Http2Flags;
      localHttp2Flags.<init>();
      Http2CodecUtil.writeFrameHeaderInternal(localByteBuf, 0, (byte)4, localHttp2Flags.ack(true), 0);
      paramChannelHandlerContext = paramChannelHandlerContext.write(localByteBuf, paramChannelPromise);
      return paramChannelHandlerContext;
    }
    finally {}
    return paramChannelPromise.setFailure(paramChannelHandlerContext);
  }
  
  public ChannelFuture writeWindowUpdate(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, int paramInt2, ChannelPromise paramChannelPromise)
  {
    try
    {
      verifyStreamOrConnectionId(paramInt1, "Stream ID");
      verifyWindowSizeIncrement(paramInt2);
      ByteBuf localByteBuf = paramChannelHandlerContext.alloc().buffer(13);
      Http2Flags localHttp2Flags = new io/netty/handler/codec/http2/Http2Flags;
      localHttp2Flags.<init>();
      Http2CodecUtil.writeFrameHeaderInternal(localByteBuf, 4, (byte)8, localHttp2Flags, paramInt1);
      localByteBuf.writeInt(paramInt2);
      paramChannelHandlerContext = paramChannelHandlerContext.write(localByteBuf, paramChannelPromise);
      return paramChannelHandlerContext;
    }
    finally {}
    return paramChannelPromise.setFailure(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2FrameWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
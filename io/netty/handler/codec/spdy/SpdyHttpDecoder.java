package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SpdyHttpDecoder
  extends MessageToMessageDecoder<a>
{
  private final int maxContentLength;
  private final Map<Integer, FullHttpMessage> messageMap;
  private final int spdyVersion;
  private final boolean validateHeaders;
  
  public SpdyHttpDecoder(SpdyVersion paramSpdyVersion, int paramInt)
  {
    this(paramSpdyVersion, paramInt, new HashMap(), true);
  }
  
  protected SpdyHttpDecoder(SpdyVersion paramSpdyVersion, int paramInt, Map<Integer, FullHttpMessage> paramMap)
  {
    this(paramSpdyVersion, paramInt, paramMap, true);
  }
  
  protected SpdyHttpDecoder(SpdyVersion paramSpdyVersion, int paramInt, Map<Integer, FullHttpMessage> paramMap, boolean paramBoolean)
  {
    this.spdyVersion = ((SpdyVersion)ObjectUtil.checkNotNull(paramSpdyVersion, "version")).getVersion();
    this.maxContentLength = ObjectUtil.checkPositive(paramInt, "maxContentLength");
    this.messageMap = paramMap;
    this.validateHeaders = paramBoolean;
  }
  
  public SpdyHttpDecoder(SpdyVersion paramSpdyVersion, int paramInt, boolean paramBoolean)
  {
    this(paramSpdyVersion, paramInt, new HashMap(), paramBoolean);
  }
  
  private static FullHttpRequest createHttpRequest(SpdyHeadersFrame paramSpdyHeadersFrame, ByteBufAllocator paramByteBufAllocator)
    throws Exception
  {
    Object localObject1 = paramSpdyHeadersFrame.headers();
    AsciiString localAsciiString1 = SpdyHeaders.HttpNames.METHOD;
    Object localObject2 = HttpMethod.valueOf(((SpdyHeaders)localObject1).getAsString(localAsciiString1));
    Object localObject3 = SpdyHeaders.HttpNames.PATH;
    String str = ((SpdyHeaders)localObject1).getAsString((CharSequence)localObject3);
    AsciiString localAsciiString2 = SpdyHeaders.HttpNames.VERSION;
    Object localObject4 = HttpVersion.valueOf(((SpdyHeaders)localObject1).getAsString(localAsciiString2));
    ((Headers)localObject1).remove(localAsciiString1);
    ((Headers)localObject1).remove(localObject3);
    ((Headers)localObject1).remove(localAsciiString2);
    paramByteBufAllocator = paramByteBufAllocator.buffer();
    try
    {
      localObject3 = new io/netty/handler/codec/http/DefaultFullHttpRequest;
      ((DefaultFullHttpRequest)localObject3).<init>((HttpVersion)localObject4, (HttpMethod)localObject2, str, paramByteBufAllocator);
      ((Headers)localObject1).remove(SpdyHeaders.HttpNames.SCHEME);
      localObject4 = SpdyHeaders.HttpNames.HOST;
      localObject2 = (CharSequence)((Headers)localObject1).get(localObject4);
      ((Headers)localObject1).remove(localObject4);
      ((HttpMessage)localObject3).headers().set(HttpHeaderNames.HOST, localObject2);
      paramSpdyHeadersFrame = paramSpdyHeadersFrame.headers().iterator();
      while (paramSpdyHeadersFrame.hasNext())
      {
        localObject1 = (Map.Entry)paramSpdyHeadersFrame.next();
        ((HttpMessage)localObject3).headers().add((CharSequence)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
      }
      HttpUtil.setKeepAlive((HttpMessage)localObject3, true);
      return (FullHttpRequest)localObject3;
    }
    finally
    {
      paramByteBufAllocator.release();
    }
  }
  
  private static FullHttpResponse createHttpResponse(SpdyHeadersFrame paramSpdyHeadersFrame, ByteBufAllocator paramByteBufAllocator, boolean paramBoolean)
    throws Exception
  {
    Object localObject1 = paramSpdyHeadersFrame.headers();
    AsciiString localAsciiString1 = SpdyHeaders.HttpNames.STATUS;
    HttpResponseStatus localHttpResponseStatus = HttpResponseStatus.parseLine((CharSequence)((Headers)localObject1).get(localAsciiString1));
    AsciiString localAsciiString2 = SpdyHeaders.HttpNames.VERSION;
    Object localObject2 = HttpVersion.valueOf(((SpdyHeaders)localObject1).getAsString(localAsciiString2));
    ((Headers)localObject1).remove(localAsciiString1);
    ((Headers)localObject1).remove(localAsciiString2);
    paramByteBufAllocator = paramByteBufAllocator.buffer();
    try
    {
      localObject1 = new io/netty/handler/codec/http/DefaultFullHttpResponse;
      ((DefaultFullHttpResponse)localObject1).<init>((HttpVersion)localObject2, localHttpResponseStatus, paramByteBufAllocator, paramBoolean);
      localObject2 = paramSpdyHeadersFrame.headers().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramSpdyHeadersFrame = (Map.Entry)((Iterator)localObject2).next();
        ((HttpMessage)localObject1).headers().add((CharSequence)paramSpdyHeadersFrame.getKey(), paramSpdyHeadersFrame.getValue());
      }
      HttpUtil.setKeepAlive((HttpMessage)localObject1, true);
      ((HttpMessage)localObject1).headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
      return (FullHttpResponse)localObject1;
    }
    finally
    {
      paramByteBufAllocator.release();
    }
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    Iterator localIterator = this.messageMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ReferenceCountUtil.safeRelease(((Map.Entry)localIterator.next()).getValue());
    }
    this.messageMap.clear();
    super.channelInactive(paramChannelHandlerContext);
  }
  
  /* Error */
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, a parama, java.util.List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 229
    //   4: ifeq +413 -> 417
    //   7: aload_2
    //   8: checkcast 229	io/netty/handler/codec/spdy/SpdySynStreamFrame
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface 234 1 0
    //   18: istore 4
    //   20: iload 4
    //   22: invokestatic 240	io/netty/handler/codec/spdy/SpdyCodecUtil:isServerId	(I)Z
    //   25: ifeq +193 -> 218
    //   28: aload_2
    //   29: invokeinterface 243 1 0
    //   34: istore 5
    //   36: iload 5
    //   38: ifne +23 -> 61
    //   41: aload_1
    //   42: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   45: dup
    //   46: iload 4
    //   48: getstatic 251	io/netty/handler/codec/spdy/SpdyStreamStatus:INVALID_STREAM	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   51: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   54: invokeinterface 260 2 0
    //   59: pop
    //   60: return
    //   61: aload_2
    //   62: invokeinterface 263 1 0
    //   67: ifeq +23 -> 90
    //   70: aload_1
    //   71: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   74: dup
    //   75: iload 4
    //   77: getstatic 266	io/netty/handler/codec/spdy/SpdyStreamStatus:PROTOCOL_ERROR	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   80: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   83: invokeinterface 260 2 0
    //   88: pop
    //   89: return
    //   90: aload_2
    //   91: invokeinterface 269 1 0
    //   96: ifeq +23 -> 119
    //   99: aload_1
    //   100: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   103: dup
    //   104: iload 4
    //   106: getstatic 272	io/netty/handler/codec/spdy/SpdyStreamStatus:INTERNAL_ERROR	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   109: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   112: invokeinterface 260 2 0
    //   117: pop
    //   118: return
    //   119: aload_2
    //   120: aload_1
    //   121: invokeinterface 278 1 0
    //   126: invokestatic 280	io/netty/handler/codec/spdy/SpdyHttpDecoder:createHttpRequest	(Lio/netty/handler/codec/spdy/SpdyHeadersFrame;Lio/netty/buffer/ByteBufAllocator;)Lio/netty/handler/codec/http/FullHttpRequest;
    //   129: astore 6
    //   131: aload 6
    //   133: invokeinterface 130 1 0
    //   138: getstatic 285	io/netty/handler/codec/spdy/SpdyHttpHeaders$Names:STREAM_ID	Lio/netty/util/AsciiString;
    //   141: iload 4
    //   143: invokevirtual 289	io/netty/handler/codec/http/HttpHeaders:setInt	(Ljava/lang/CharSequence;I)Lio/netty/handler/codec/http/HttpHeaders;
    //   146: pop
    //   147: aload 6
    //   149: invokeinterface 130 1 0
    //   154: getstatic 292	io/netty/handler/codec/spdy/SpdyHttpHeaders$Names:ASSOCIATED_TO_STREAM_ID	Lio/netty/util/AsciiString;
    //   157: iload 5
    //   159: invokevirtual 289	io/netty/handler/codec/http/HttpHeaders:setInt	(Ljava/lang/CharSequence;I)Lio/netty/handler/codec/http/HttpHeaders;
    //   162: pop
    //   163: aload 6
    //   165: invokeinterface 130 1 0
    //   170: getstatic 295	io/netty/handler/codec/spdy/SpdyHttpHeaders$Names:PRIORITY	Lio/netty/util/AsciiString;
    //   173: aload_2
    //   174: invokeinterface 299 1 0
    //   179: invokevirtual 289	io/netty/handler/codec/http/HttpHeaders:setInt	(Ljava/lang/CharSequence;I)Lio/netty/handler/codec/http/HttpHeaders;
    //   182: pop
    //   183: aload_3
    //   184: aload 6
    //   186: invokeinterface 303 2 0
    //   191: pop
    //   192: goto +849 -> 1041
    //   195: astore_2
    //   196: aload_1
    //   197: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   200: dup
    //   201: iload 4
    //   203: getstatic 266	io/netty/handler/codec/spdy/SpdyStreamStatus:PROTOCOL_ERROR	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   206: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   209: invokeinterface 260 2 0
    //   214: pop
    //   215: goto +826 -> 1041
    //   218: aload_2
    //   219: invokeinterface 269 1 0
    //   224: ifeq +66 -> 290
    //   227: new 305	io/netty/handler/codec/spdy/DefaultSpdySynReplyFrame
    //   230: dup
    //   231: iload 4
    //   233: invokespecial 308	io/netty/handler/codec/spdy/DefaultSpdySynReplyFrame:<init>	(I)V
    //   236: astore_3
    //   237: aload_3
    //   238: iconst_1
    //   239: invokeinterface 314 2 0
    //   244: pop
    //   245: aload_3
    //   246: invokeinterface 67 1 0
    //   251: astore_2
    //   252: aload_2
    //   253: getstatic 187	io/netty/handler/codec/spdy/SpdyHeaders$HttpNames:STATUS	Lio/netty/util/AsciiString;
    //   256: getstatic 318	io/netty/handler/codec/http/HttpResponseStatus:REQUEST_HEADER_FIELDS_TOO_LARGE	Lio/netty/handler/codec/http/HttpResponseStatus;
    //   259: invokevirtual 321	io/netty/handler/codec/http/HttpResponseStatus:code	()I
    //   262: invokeinterface 324 3 0
    //   267: pop
    //   268: aload_2
    //   269: getstatic 91	io/netty/handler/codec/spdy/SpdyHeaders$HttpNames:VERSION	Lio/netty/util/AsciiString;
    //   272: getstatic 328	io/netty/handler/codec/http/HttpVersion:HTTP_1_0	Lio/netty/handler/codec/http/HttpVersion;
    //   275: invokeinterface 332 3 0
    //   280: pop
    //   281: aload_1
    //   282: aload_3
    //   283: invokeinterface 260 2 0
    //   288: pop
    //   289: return
    //   290: aload_2
    //   291: aload_1
    //   292: invokeinterface 278 1 0
    //   297: invokestatic 280	io/netty/handler/codec/spdy/SpdyHttpDecoder:createHttpRequest	(Lio/netty/handler/codec/spdy/SpdyHeadersFrame;Lio/netty/buffer/ByteBufAllocator;)Lio/netty/handler/codec/http/FullHttpRequest;
    //   300: astore 6
    //   302: aload 6
    //   304: invokeinterface 130 1 0
    //   309: getstatic 285	io/netty/handler/codec/spdy/SpdyHttpHeaders$Names:STREAM_ID	Lio/netty/util/AsciiString;
    //   312: iload 4
    //   314: invokevirtual 289	io/netty/handler/codec/http/HttpHeaders:setInt	(Ljava/lang/CharSequence;I)Lio/netty/handler/codec/http/HttpHeaders;
    //   317: pop
    //   318: aload_2
    //   319: invokeinterface 263 1 0
    //   324: ifeq +15 -> 339
    //   327: aload_3
    //   328: aload 6
    //   330: invokeinterface 303 2 0
    //   335: pop
    //   336: goto +705 -> 1041
    //   339: aload_0
    //   340: iload 4
    //   342: aload 6
    //   344: invokevirtual 336	io/netty/handler/codec/spdy/SpdyHttpDecoder:putMessage	(ILio/netty/handler/codec/http/FullHttpMessage;)Lio/netty/handler/codec/http/FullHttpMessage;
    //   347: pop
    //   348: goto +693 -> 1041
    //   351: astore_2
    //   352: new 305	io/netty/handler/codec/spdy/DefaultSpdySynReplyFrame
    //   355: dup
    //   356: iload 4
    //   358: invokespecial 308	io/netty/handler/codec/spdy/DefaultSpdySynReplyFrame:<init>	(I)V
    //   361: astore_3
    //   362: aload_3
    //   363: iconst_1
    //   364: invokeinterface 314 2 0
    //   369: pop
    //   370: aload_3
    //   371: invokeinterface 67 1 0
    //   376: astore_2
    //   377: aload_2
    //   378: getstatic 187	io/netty/handler/codec/spdy/SpdyHeaders$HttpNames:STATUS	Lio/netty/util/AsciiString;
    //   381: getstatic 339	io/netty/handler/codec/http/HttpResponseStatus:BAD_REQUEST	Lio/netty/handler/codec/http/HttpResponseStatus;
    //   384: invokevirtual 321	io/netty/handler/codec/http/HttpResponseStatus:code	()I
    //   387: invokeinterface 324 3 0
    //   392: pop
    //   393: aload_2
    //   394: getstatic 91	io/netty/handler/codec/spdy/SpdyHeaders$HttpNames:VERSION	Lio/netty/util/AsciiString;
    //   397: getstatic 328	io/netty/handler/codec/http/HttpVersion:HTTP_1_0	Lio/netty/handler/codec/http/HttpVersion;
    //   400: invokeinterface 332 3 0
    //   405: pop
    //   406: aload_1
    //   407: aload_3
    //   408: invokeinterface 260 2 0
    //   413: pop
    //   414: goto +627 -> 1041
    //   417: aload_2
    //   418: instanceof 310
    //   421: ifeq +139 -> 560
    //   424: aload_2
    //   425: checkcast 310	io/netty/handler/codec/spdy/SpdySynReplyFrame
    //   428: astore 6
    //   430: aload 6
    //   432: invokeinterface 234 1 0
    //   437: istore 4
    //   439: aload 6
    //   441: invokeinterface 269 1 0
    //   446: ifeq +23 -> 469
    //   449: aload_1
    //   450: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   453: dup
    //   454: iload 4
    //   456: getstatic 272	io/netty/handler/codec/spdy/SpdyStreamStatus:INTERNAL_ERROR	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   459: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   462: invokeinterface 260 2 0
    //   467: pop
    //   468: return
    //   469: aload 6
    //   471: aload_1
    //   472: invokeinterface 278 1 0
    //   477: aload_0
    //   478: getfield 55	io/netty/handler/codec/spdy/SpdyHttpDecoder:validateHeaders	Z
    //   481: invokestatic 341	io/netty/handler/codec/spdy/SpdyHttpDecoder:createHttpResponse	(Lio/netty/handler/codec/spdy/SpdyHeadersFrame;Lio/netty/buffer/ByteBufAllocator;Z)Lio/netty/handler/codec/http/FullHttpResponse;
    //   484: astore_2
    //   485: aload_2
    //   486: invokeinterface 130 1 0
    //   491: getstatic 285	io/netty/handler/codec/spdy/SpdyHttpHeaders$Names:STREAM_ID	Lio/netty/util/AsciiString;
    //   494: iload 4
    //   496: invokevirtual 289	io/netty/handler/codec/http/HttpHeaders:setInt	(Ljava/lang/CharSequence;I)Lio/netty/handler/codec/http/HttpHeaders;
    //   499: pop
    //   500: aload 6
    //   502: invokeinterface 263 1 0
    //   507: ifeq +19 -> 526
    //   510: aload_2
    //   511: lconst_0
    //   512: invokestatic 345	io/netty/handler/codec/http/HttpUtil:setContentLength	(Lio/netty/handler/codec/http/HttpMessage;J)V
    //   515: aload_3
    //   516: aload_2
    //   517: invokeinterface 303 2 0
    //   522: pop
    //   523: goto +518 -> 1041
    //   526: aload_0
    //   527: iload 4
    //   529: aload_2
    //   530: invokevirtual 336	io/netty/handler/codec/spdy/SpdyHttpDecoder:putMessage	(ILio/netty/handler/codec/http/FullHttpMessage;)Lio/netty/handler/codec/http/FullHttpMessage;
    //   533: pop
    //   534: goto +507 -> 1041
    //   537: astore_2
    //   538: aload_1
    //   539: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   542: dup
    //   543: iload 4
    //   545: getstatic 266	io/netty/handler/codec/spdy/SpdyStreamStatus:PROTOCOL_ERROR	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   548: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   551: invokeinterface 260 2 0
    //   556: pop
    //   557: goto +484 -> 1041
    //   560: aload_2
    //   561: instanceof 63
    //   564: ifeq +274 -> 838
    //   567: aload_2
    //   568: checkcast 63	io/netty/handler/codec/spdy/SpdyHeadersFrame
    //   571: astore_2
    //   572: aload_2
    //   573: invokeinterface 234 1 0
    //   578: istore 4
    //   580: aload_0
    //   581: iload 4
    //   583: invokevirtual 349	io/netty/handler/codec/spdy/SpdyHttpDecoder:getMessage	(I)Lio/netty/handler/codec/http/FullHttpMessage;
    //   586: astore 6
    //   588: aload 6
    //   590: ifnonnull +132 -> 722
    //   593: iload 4
    //   595: invokestatic 240	io/netty/handler/codec/spdy/SpdyCodecUtil:isServerId	(I)Z
    //   598: ifeq +123 -> 721
    //   601: aload_2
    //   602: invokeinterface 269 1 0
    //   607: ifeq +23 -> 630
    //   610: aload_1
    //   611: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   614: dup
    //   615: iload 4
    //   617: getstatic 272	io/netty/handler/codec/spdy/SpdyStreamStatus:INTERNAL_ERROR	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   620: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   623: invokeinterface 260 2 0
    //   628: pop
    //   629: return
    //   630: aload_2
    //   631: aload_1
    //   632: invokeinterface 278 1 0
    //   637: aload_0
    //   638: getfield 55	io/netty/handler/codec/spdy/SpdyHttpDecoder:validateHeaders	Z
    //   641: invokestatic 341	io/netty/handler/codec/spdy/SpdyHttpDecoder:createHttpResponse	(Lio/netty/handler/codec/spdy/SpdyHeadersFrame;Lio/netty/buffer/ByteBufAllocator;Z)Lio/netty/handler/codec/http/FullHttpResponse;
    //   644: astore 6
    //   646: aload 6
    //   648: invokeinterface 130 1 0
    //   653: getstatic 285	io/netty/handler/codec/spdy/SpdyHttpHeaders$Names:STREAM_ID	Lio/netty/util/AsciiString;
    //   656: iload 4
    //   658: invokevirtual 289	io/netty/handler/codec/http/HttpHeaders:setInt	(Ljava/lang/CharSequence;I)Lio/netty/handler/codec/http/HttpHeaders;
    //   661: pop
    //   662: aload_2
    //   663: invokeinterface 263 1 0
    //   668: ifeq +21 -> 689
    //   671: aload 6
    //   673: lconst_0
    //   674: invokestatic 345	io/netty/handler/codec/http/HttpUtil:setContentLength	(Lio/netty/handler/codec/http/HttpMessage;J)V
    //   677: aload_3
    //   678: aload 6
    //   680: invokeinterface 303 2 0
    //   685: pop
    //   686: goto +35 -> 721
    //   689: aload_0
    //   690: iload 4
    //   692: aload 6
    //   694: invokevirtual 336	io/netty/handler/codec/spdy/SpdyHttpDecoder:putMessage	(ILio/netty/handler/codec/http/FullHttpMessage;)Lio/netty/handler/codec/http/FullHttpMessage;
    //   697: pop
    //   698: goto +23 -> 721
    //   701: astore_2
    //   702: aload_1
    //   703: new 245	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame
    //   706: dup
    //   707: iload 4
    //   709: getstatic 266	io/netty/handler/codec/spdy/SpdyStreamStatus:PROTOCOL_ERROR	Lio/netty/handler/codec/spdy/SpdyStreamStatus;
    //   712: invokespecial 254	io/netty/handler/codec/spdy/DefaultSpdyRstStreamFrame:<init>	(ILio/netty/handler/codec/spdy/SpdyStreamStatus;)V
    //   715: invokeinterface 260 2 0
    //   720: pop
    //   721: return
    //   722: aload_2
    //   723: invokeinterface 269 1 0
    //   728: ifne +66 -> 794
    //   731: aload_2
    //   732: invokeinterface 67 1 0
    //   737: invokeinterface 143 1 0
    //   742: astore 7
    //   744: aload 7
    //   746: invokeinterface 149 1 0
    //   751: ifeq +43 -> 794
    //   754: aload 7
    //   756: invokeinterface 153 1 0
    //   761: checkcast 155	java/util/Map$Entry
    //   764: astore_1
    //   765: aload 6
    //   767: invokeinterface 130 1 0
    //   772: aload_1
    //   773: invokeinterface 158 1 0
    //   778: checkcast 125	java/lang/CharSequence
    //   781: aload_1
    //   782: invokeinterface 161 1 0
    //   787: invokevirtual 164	io/netty/handler/codec/http/HttpHeaders:add	(Ljava/lang/CharSequence;Ljava/lang/Object;)Lio/netty/handler/codec/http/HttpHeaders;
    //   790: pop
    //   791: goto -47 -> 744
    //   794: aload_2
    //   795: invokeinterface 263 1 0
    //   800: ifeq +241 -> 1041
    //   803: aload 6
    //   805: aload 6
    //   807: invokeinterface 354 1 0
    //   812: invokevirtual 359	io/netty/buffer/ByteBuf:readableBytes	()I
    //   815: i2l
    //   816: invokestatic 345	io/netty/handler/codec/http/HttpUtil:setContentLength	(Lio/netty/handler/codec/http/HttpMessage;J)V
    //   819: aload_0
    //   820: iload 4
    //   822: invokevirtual 362	io/netty/handler/codec/spdy/SpdyHttpDecoder:removeMessage	(I)Lio/netty/handler/codec/http/FullHttpMessage;
    //   825: pop
    //   826: aload_3
    //   827: aload 6
    //   829: invokeinterface 303 2 0
    //   834: pop
    //   835: goto +206 -> 1041
    //   838: aload_2
    //   839: instanceof 364
    //   842: ifeq +178 -> 1020
    //   845: aload_2
    //   846: checkcast 364	io/netty/handler/codec/spdy/SpdyDataFrame
    //   849: astore_1
    //   850: aload_1
    //   851: invokeinterface 234 1 0
    //   856: istore 4
    //   858: aload_0
    //   859: iload 4
    //   861: invokevirtual 349	io/netty/handler/codec/spdy/SpdyHttpDecoder:getMessage	(I)Lio/netty/handler/codec/http/FullHttpMessage;
    //   864: astore 7
    //   866: aload 7
    //   868: ifnonnull +4 -> 872
    //   871: return
    //   872: aload 7
    //   874: invokeinterface 354 1 0
    //   879: astore_2
    //   880: aload_2
    //   881: invokevirtual 359	io/netty/buffer/ByteBuf:readableBytes	()I
    //   884: aload_0
    //   885: getfield 51	io/netty/handler/codec/spdy/SpdyHttpDecoder:maxContentLength	I
    //   888: aload_1
    //   889: invokeinterface 365 1 0
    //   894: invokevirtual 359	io/netty/buffer/ByteBuf:readableBytes	()I
    //   897: isub
    //   898: if_icmpgt +70 -> 968
    //   901: aload_1
    //   902: invokeinterface 365 1 0
    //   907: astore 6
    //   909: aload 6
    //   911: invokevirtual 359	io/netty/buffer/ByteBuf:readableBytes	()I
    //   914: istore 5
    //   916: aload_2
    //   917: aload 6
    //   919: aload 6
    //   921: invokevirtual 368	io/netty/buffer/ByteBuf:readerIndex	()I
    //   924: iload 5
    //   926: invokevirtual 372	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;II)Lio/netty/buffer/ByteBuf;
    //   929: pop
    //   930: aload_1
    //   931: invokeinterface 263 1 0
    //   936: ifeq +105 -> 1041
    //   939: aload 7
    //   941: aload_2
    //   942: invokevirtual 359	io/netty/buffer/ByteBuf:readableBytes	()I
    //   945: i2l
    //   946: invokestatic 345	io/netty/handler/codec/http/HttpUtil:setContentLength	(Lio/netty/handler/codec/http/HttpMessage;J)V
    //   949: aload_0
    //   950: iload 4
    //   952: invokevirtual 362	io/netty/handler/codec/spdy/SpdyHttpDecoder:removeMessage	(I)Lio/netty/handler/codec/http/FullHttpMessage;
    //   955: pop
    //   956: aload_3
    //   957: aload 7
    //   959: invokeinterface 303 2 0
    //   964: pop
    //   965: goto +76 -> 1041
    //   968: aload_0
    //   969: iload 4
    //   971: invokevirtual 362	io/netty/handler/codec/spdy/SpdyHttpDecoder:removeMessage	(I)Lio/netty/handler/codec/http/FullHttpMessage;
    //   974: pop
    //   975: new 374	java/lang/StringBuilder
    //   978: dup
    //   979: invokespecial 375	java/lang/StringBuilder:<init>	()V
    //   982: astore_1
    //   983: aload_1
    //   984: ldc_w 377
    //   987: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: pop
    //   991: aload_1
    //   992: aload_0
    //   993: getfield 51	io/netty/handler/codec/spdy/SpdyHttpDecoder:maxContentLength	I
    //   996: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: aload_1
    //   1001: ldc_w 386
    //   1004: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: new 388	io/netty/handler/codec/TooLongFrameException
    //   1011: dup
    //   1012: aload_1
    //   1013: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: invokespecial 395	io/netty/handler/codec/TooLongFrameException:<init>	(Ljava/lang/String;)V
    //   1019: athrow
    //   1020: aload_2
    //   1021: instanceof 397
    //   1024: ifeq +17 -> 1041
    //   1027: aload_0
    //   1028: aload_2
    //   1029: checkcast 397	io/netty/handler/codec/spdy/SpdyRstStreamFrame
    //   1032: invokeinterface 234 1 0
    //   1037: invokevirtual 362	io/netty/handler/codec/spdy/SpdyHttpDecoder:removeMessage	(I)Lio/netty/handler/codec/http/FullHttpMessage;
    //   1040: pop
    //   1041: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1042	0	this	SpdyHttpDecoder
    //   0	1042	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	1042	2	parama	a
    //   0	1042	3	paramList	java.util.List<Object>
    //   18	952	4	i	int
    //   34	891	5	j	int
    //   129	791	6	localObject1	Object
    //   742	216	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   119	192	195	finally
    //   290	336	351	finally
    //   339	348	351	finally
    //   469	523	537	finally
    //   526	534	537	finally
    //   630	686	701	finally
    //   689	698	701	finally
  }
  
  protected FullHttpMessage getMessage(int paramInt)
  {
    return (FullHttpMessage)this.messageMap.get(Integer.valueOf(paramInt));
  }
  
  protected FullHttpMessage putMessage(int paramInt, FullHttpMessage paramFullHttpMessage)
  {
    return (FullHttpMessage)this.messageMap.put(Integer.valueOf(paramInt), paramFullHttpMessage);
  }
  
  protected FullHttpMessage removeMessage(int paramInt)
  {
    return (FullHttpMessage)this.messageMap.remove(Integer.valueOf(paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHttpDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
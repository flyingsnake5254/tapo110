package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

public class DefaultHttp2HeadersDecoder
  implements Http2HeadersDecoder, Http2HeadersDecoder.Configuration
{
  private static final float HEADERS_COUNT_WEIGHT_HISTORICAL = 0.8F;
  private static final float HEADERS_COUNT_WEIGHT_NEW = 0.2F;
  private float headerArraySizeAccumulator = 8.0F;
  private final HpackDecoder hpackDecoder;
  private long maxHeaderListSizeGoAway;
  private final boolean validateHeaders;
  
  public DefaultHttp2HeadersDecoder()
  {
    this(true);
  }
  
  public DefaultHttp2HeadersDecoder(boolean paramBoolean)
  {
    this(paramBoolean, 8192L);
  }
  
  public DefaultHttp2HeadersDecoder(boolean paramBoolean, long paramLong)
  {
    this(paramBoolean, paramLong, -1);
  }
  
  public DefaultHttp2HeadersDecoder(boolean paramBoolean, long paramLong, @Deprecated int paramInt)
  {
    this(paramBoolean, new HpackDecoder(paramLong));
  }
  
  DefaultHttp2HeadersDecoder(boolean paramBoolean, HpackDecoder paramHpackDecoder)
  {
    this.hpackDecoder = ((HpackDecoder)ObjectUtil.checkNotNull(paramHpackDecoder, "hpackDecoder"));
    this.validateHeaders = paramBoolean;
    this.maxHeaderListSizeGoAway = Http2CodecUtil.calculateMaxHeaderListSizeGoAway(paramHpackDecoder.getMaxHeaderListSize());
  }
  
  public Http2HeadersDecoder.Configuration configuration()
  {
    return this;
  }
  
  /* Error */
  public Http2Headers decodeHeaders(int paramInt, io.netty.buffer.ByteBuf paramByteBuf)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	io/netty/handler/codec/http2/DefaultHttp2HeadersDecoder:newHeaders	()Lio/netty/handler/codec/http2/Http2Headers;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 58	io/netty/handler/codec/http2/DefaultHttp2HeadersDecoder:hpackDecoder	Lio/netty/handler/codec/http2/HpackDecoder;
    //   9: iload_1
    //   10: aload_2
    //   11: aload_3
    //   12: aload_0
    //   13: getfield 60	io/netty/handler/codec/http2/DefaultHttp2HeadersDecoder:validateHeaders	Z
    //   16: invokevirtual 86	io/netty/handler/codec/http2/HpackDecoder:decode	(ILio/netty/buffer/ByteBuf;Lio/netty/handler/codec/http2/Http2Headers;Z)V
    //   19: aload_0
    //   20: aload_3
    //   21: invokeinterface 92 1 0
    //   26: i2f
    //   27: ldc 13
    //   29: fmul
    //   30: aload_0
    //   31: getfield 49	io/netty/handler/codec/http2/DefaultHttp2HeadersDecoder:headerArraySizeAccumulator	F
    //   34: ldc 11
    //   36: fmul
    //   37: fadd
    //   38: putfield 49	io/netty/handler/codec/http2/DefaultHttp2HeadersDecoder:headerArraySizeAccumulator	F
    //   41: aload_3
    //   42: areturn
    //   43: astore_2
    //   44: getstatic 98	io/netty/handler/codec/http2/Http2Error:COMPRESSION_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   47: aload_2
    //   48: aload_2
    //   49: invokevirtual 104	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 108	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   59: athrow
    //   60: astore_2
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	DefaultHttp2HeadersDecoder
    //   0	63	1	paramInt	int
    //   0	63	2	paramByteBuf	io.netty.buffer.ByteBuf
    //   4	38	3	localHttp2Headers	Http2Headers
    // Exception table:
    //   from	to	target	type
    //   0	41	43	finally
    //   0	41	60	io/netty/handler/codec/http2/Http2Exception
  }
  
  public long maxHeaderListSize()
  {
    return this.hpackDecoder.getMaxHeaderListSize();
  }
  
  public void maxHeaderListSize(long paramLong1, long paramLong2)
    throws Http2Exception
  {
    if ((paramLong2 >= paramLong1) && (paramLong2 >= 0L))
    {
      this.hpackDecoder.setMaxHeaderListSize(paramLong1);
      this.maxHeaderListSizeGoAway = paramLong2;
      return;
    }
    throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Header List Size GO_AWAY %d must be non-negative and >= %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
  }
  
  public long maxHeaderListSizeGoAway()
  {
    return this.maxHeaderListSizeGoAway;
  }
  
  public long maxHeaderTableSize()
  {
    return this.hpackDecoder.getMaxHeaderTableSize();
  }
  
  public void maxHeaderTableSize(long paramLong)
    throws Http2Exception
  {
    this.hpackDecoder.setMaxHeaderTableSize(paramLong);
  }
  
  protected Http2Headers newHeaders()
  {
    return new DefaultHttp2Headers(this.validateHeaders, (int)this.headerArraySizeAccumulator);
  }
  
  protected final int numberOfHeadersGuess()
  {
    return (int)this.headerArraySizeAccumulator;
  }
  
  protected final boolean validateHeaders()
  {
    return this.validateHeaders;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2HeadersDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
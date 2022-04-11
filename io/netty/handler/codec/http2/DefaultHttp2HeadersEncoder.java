package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

public class DefaultHttp2HeadersEncoder
  implements Http2HeadersEncoder, Http2HeadersEncoder.Configuration
{
  private final HpackEncoder hpackEncoder;
  private final Http2HeadersEncoder.SensitivityDetector sensitivityDetector;
  private final ByteBuf tableSizeChangeOutput = Unpooled.buffer();
  
  public DefaultHttp2HeadersEncoder()
  {
    this(Http2HeadersEncoder.NEVER_SENSITIVE);
  }
  
  public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
  {
    this(paramSensitivityDetector, new HpackEncoder());
  }
  
  DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector, HpackEncoder paramHpackEncoder)
  {
    this.sensitivityDetector = ((Http2HeadersEncoder.SensitivityDetector)ObjectUtil.checkNotNull(paramSensitivityDetector, "sensitiveDetector"));
    this.hpackEncoder = ((HpackEncoder)ObjectUtil.checkNotNull(paramHpackEncoder, "hpackEncoder"));
  }
  
  public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector, boolean paramBoolean)
  {
    this(paramSensitivityDetector, new HpackEncoder(paramBoolean));
  }
  
  public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector, boolean paramBoolean, int paramInt)
  {
    this(paramSensitivityDetector, paramBoolean, paramInt, 512);
  }
  
  public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this(paramSensitivityDetector, new HpackEncoder(paramBoolean, paramInt1, paramInt2));
  }
  
  public Http2HeadersEncoder.Configuration configuration()
  {
    return this;
  }
  
  /* Error */
  public void encodeHeaders(int paramInt, Http2Headers paramHttp2Headers, ByteBuf paramByteBuf)
    throws Http2Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	io/netty/handler/codec/http2/DefaultHttp2HeadersEncoder:tableSizeChangeOutput	Lio/netty/buffer/ByteBuf;
    //   4: invokevirtual 77	io/netty/buffer/ByteBuf:isReadable	()Z
    //   7: ifeq +20 -> 27
    //   10: aload_3
    //   11: aload_0
    //   12: getfield 39	io/netty/handler/codec/http2/DefaultHttp2HeadersEncoder:tableSizeChangeOutput	Lio/netty/buffer/ByteBuf;
    //   15: invokevirtual 81	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   18: pop
    //   19: aload_0
    //   20: getfield 39	io/netty/handler/codec/http2/DefaultHttp2HeadersEncoder:tableSizeChangeOutput	Lio/netty/buffer/ByteBuf;
    //   23: invokevirtual 84	io/netty/buffer/ByteBuf:clear	()Lio/netty/buffer/ByteBuf;
    //   26: pop
    //   27: aload_0
    //   28: getfield 54	io/netty/handler/codec/http2/DefaultHttp2HeadersEncoder:hpackEncoder	Lio/netty/handler/codec/http2/HpackEncoder;
    //   31: iload_1
    //   32: aload_3
    //   33: aload_2
    //   34: aload_0
    //   35: getfield 51	io/netty/handler/codec/http2/DefaultHttp2HeadersEncoder:sensitivityDetector	Lio/netty/handler/codec/http2/Http2HeadersEncoder$SensitivityDetector;
    //   38: invokevirtual 87	io/netty/handler/codec/http2/HpackEncoder:encodeHeaders	(ILio/netty/buffer/ByteBuf;Lio/netty/handler/codec/http2/Http2Headers;Lio/netty/handler/codec/http2/Http2HeadersEncoder$SensitivityDetector;)V
    //   41: return
    //   42: astore_2
    //   43: getstatic 93	io/netty/handler/codec/http2/Http2Error:COMPRESSION_ERROR	Lio/netty/handler/codec/http2/Http2Error;
    //   46: aload_2
    //   47: ldc 95
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: invokevirtual 101	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 105	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
    //   63: athrow
    //   64: astore_2
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	DefaultHttp2HeadersEncoder
    //   0	67	1	paramInt	int
    //   0	67	2	paramHttp2Headers	Http2Headers
    //   0	67	3	paramByteBuf	ByteBuf
    // Exception table:
    //   from	to	target	type
    //   0	27	42	finally
    //   27	41	42	finally
    //   0	27	64	io/netty/handler/codec/http2/Http2Exception
    //   27	41	64	io/netty/handler/codec/http2/Http2Exception
  }
  
  public long maxHeaderListSize()
  {
    return this.hpackEncoder.getMaxHeaderListSize();
  }
  
  public void maxHeaderListSize(long paramLong)
    throws Http2Exception
  {
    this.hpackEncoder.setMaxHeaderListSize(paramLong);
  }
  
  public long maxHeaderTableSize()
  {
    return this.hpackEncoder.getMaxHeaderTableSize();
  }
  
  public void maxHeaderTableSize(long paramLong)
    throws Http2Exception
  {
    this.hpackEncoder.setMaxHeaderTableSize(this.tableSizeChangeOutput, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2HeadersEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
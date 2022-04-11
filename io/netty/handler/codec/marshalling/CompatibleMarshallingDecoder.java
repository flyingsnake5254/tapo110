package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;

public class CompatibleMarshallingDecoder
  extends ReplayingDecoder<Void>
{
  private boolean discardingTooLongFrame;
  protected final int maxObjectSize;
  protected final UnmarshallerProvider provider;
  
  public CompatibleMarshallingDecoder(UnmarshallerProvider paramUnmarshallerProvider, int paramInt)
  {
    this.provider = paramUnmarshallerProvider;
    this.maxObjectSize = paramInt;
  }
  
  /* Error */
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	io/netty/handler/codec/marshalling/CompatibleMarshallingDecoder:discardingTooLongFrame	Z
    //   4: ifeq +17 -> 21
    //   7: aload_2
    //   8: aload_0
    //   9: invokevirtual 35	io/netty/handler/codec/ByteToMessageDecoder:actualReadableBytes	()I
    //   12: invokevirtual 41	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   15: pop
    //   16: aload_0
    //   17: invokevirtual 44	io/netty/handler/codec/ReplayingDecoder:checkpoint	()V
    //   20: return
    //   21: aload_0
    //   22: getfield 18	io/netty/handler/codec/marshalling/CompatibleMarshallingDecoder:provider	Lio/netty/handler/codec/marshalling/UnmarshallerProvider;
    //   25: aload_1
    //   26: invokeinterface 50 2 0
    //   31: astore 4
    //   33: new 52	io/netty/handler/codec/marshalling/ChannelBufferByteInput
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 55	io/netty/handler/codec/marshalling/ChannelBufferByteInput:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 20	io/netty/handler/codec/marshalling/CompatibleMarshallingDecoder:maxObjectSize	I
    //   48: ldc 56
    //   50: if_icmpeq +17 -> 67
    //   53: new 58	io/netty/handler/codec/marshalling/LimitingByteInput
    //   56: dup
    //   57: aload_2
    //   58: aload_0
    //   59: getfield 20	io/netty/handler/codec/marshalling/CompatibleMarshallingDecoder:maxObjectSize	I
    //   62: i2l
    //   63: invokespecial 61	io/netty/handler/codec/marshalling/LimitingByteInput:<init>	(Lorg/jboss/marshalling/ByteInput;J)V
    //   66: astore_1
    //   67: aload 4
    //   69: aload_1
    //   70: invokeinterface 67 2 0
    //   75: aload 4
    //   77: invokeinterface 71 1 0
    //   82: astore_1
    //   83: aload 4
    //   85: invokeinterface 74 1 0
    //   90: aload_3
    //   91: aload_1
    //   92: invokeinterface 80 2 0
    //   97: pop
    //   98: aload 4
    //   100: invokeinterface 83 1 0
    //   105: return
    //   106: astore_1
    //   107: goto +19 -> 126
    //   110: astore_1
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 29	io/netty/handler/codec/marshalling/CompatibleMarshallingDecoder:discardingTooLongFrame	Z
    //   116: new 85	io/netty/handler/codec/TooLongFrameException
    //   119: astore_1
    //   120: aload_1
    //   121: invokespecial 86	io/netty/handler/codec/TooLongFrameException:<init>	()V
    //   124: aload_1
    //   125: athrow
    //   126: aload 4
    //   128: invokeinterface 83 1 0
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	CompatibleMarshallingDecoder
    //   0	135	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	135	2	paramByteBuf	ByteBuf
    //   0	135	3	paramList	List<Object>
    //   31	96	4	localUnmarshaller	org.jboss.marshalling.Unmarshaller
    // Exception table:
    //   from	to	target	type
    //   67	98	106	finally
    //   111	126	106	finally
    //   67	98	110	io/netty/handler/codec/marshalling/LimitingByteInput$TooBigObjectException
  }
  
  protected void decodeLast(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.readableBytes();
    if (i != 0)
    {
      if ((i == 1) && (paramByteBuf.getByte(paramByteBuf.readerIndex()) == 121))
      {
        paramByteBuf.skipBytes(1);
        return;
      }
      decode(paramChannelHandlerContext, paramByteBuf, paramList);
    }
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if ((paramThrowable instanceof TooLongFrameException)) {
      paramChannelHandlerContext.close();
    } else {
      super.exceptionCaught(paramChannelHandlerContext, paramThrowable);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\marshalling\CompatibleMarshallingDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
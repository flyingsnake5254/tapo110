package io.netty.handler.codec.serialization;

import io.netty.channel.ChannelHandler.a;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.Serializable;

@ChannelHandler.a
public class ObjectEncoder
  extends MessageToByteEncoder<Serializable>
{
  private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
  
  /* Error */
  protected void encode(io.netty.channel.ChannelHandlerContext paramChannelHandlerContext, Serializable paramSerializable, io.netty.buffer.ByteBuf paramByteBuf)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 26	io/netty/buffer/ByteBuf:writerIndex	()I
    //   4: istore 4
    //   6: new 28	io/netty/buffer/ByteBufOutputStream
    //   9: dup
    //   10: aload_3
    //   11: invokespecial 31	io/netty/buffer/ByteBufOutputStream:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   14: astore 5
    //   16: aconst_null
    //   17: astore 6
    //   19: aload 5
    //   21: getstatic 12	io/netty/handler/codec/serialization/ObjectEncoder:LENGTH_PLACEHOLDER	[B
    //   24: invokevirtual 35	io/netty/buffer/ByteBufOutputStream:write	([B)V
    //   27: new 37	io/netty/handler/codec/serialization/CompactObjectOutputStream
    //   30: astore 7
    //   32: aload 7
    //   34: aload 5
    //   36: invokespecial 40	io/netty/handler/codec/serialization/CompactObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: aload 7
    //   41: aload_2
    //   42: invokevirtual 46	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   45: aload 7
    //   47: invokevirtual 49	java/io/ObjectOutputStream:flush	()V
    //   50: aload 7
    //   52: invokevirtual 52	java/io/ObjectOutputStream:close	()V
    //   55: aload_3
    //   56: iload 4
    //   58: aload_3
    //   59: invokevirtual 26	io/netty/buffer/ByteBuf:writerIndex	()I
    //   62: iload 4
    //   64: isub
    //   65: iconst_4
    //   66: isub
    //   67: invokevirtual 56	io/netty/buffer/ByteBuf:setInt	(II)Lio/netty/buffer/ByteBuf;
    //   70: pop
    //   71: return
    //   72: astore_1
    //   73: aload 7
    //   75: astore_2
    //   76: goto +7 -> 83
    //   79: astore_1
    //   80: aload 6
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +10 -> 94
    //   87: aload_2
    //   88: invokevirtual 52	java/io/ObjectOutputStream:close	()V
    //   91: goto +8 -> 99
    //   94: aload 5
    //   96: invokevirtual 59	java/io/OutputStream:close	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ObjectEncoder
    //   0	101	1	paramChannelHandlerContext	io.netty.channel.ChannelHandlerContext
    //   0	101	2	paramSerializable	Serializable
    //   0	101	3	paramByteBuf	io.netty.buffer.ByteBuf
    //   4	61	4	i	int
    //   14	81	5	localByteBufOutputStream	io.netty.buffer.ByteBufOutputStream
    //   17	64	6	localObject	Object
    //   30	44	7	localCompactObjectOutputStream	CompactObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   39	50	72	finally
    //   19	39	79	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\ObjectEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
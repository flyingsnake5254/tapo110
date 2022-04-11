package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class MessageToMessageDecoder<I>
  extends ChannelInboundHandlerAdapter
{
  private final TypeParameterMatcher matcher;
  
  protected MessageToMessageDecoder()
  {
    this.matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");
  }
  
  protected MessageToMessageDecoder(Class<? extends I> paramClass)
  {
    this.matcher = TypeParameterMatcher.get(paramClass);
  }
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    return this.matcher.match(paramObject);
  }
  
  /* Error */
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    // Byte code:
    //   0: invokestatic 47	io/netty/handler/codec/CodecOutputList:newInstance	()Lio/netty/handler/codec/CodecOutputList;
    //   3: astore_3
    //   4: iconst_0
    //   5: istore 4
    //   7: iconst_0
    //   8: istore 5
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 49	io/netty/handler/codec/MessageToMessageDecoder:acceptInboundMessage	(Ljava/lang/Object;)Z
    //   15: istore 6
    //   17: iload 6
    //   19: ifeq +28 -> 47
    //   22: aload_0
    //   23: aload_1
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 53	io/netty/handler/codec/MessageToMessageDecoder:decode	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;Ljava/util/List;)V
    //   29: aload_2
    //   30: invokestatic 58	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: goto +19 -> 53
    //   37: astore 7
    //   39: aload_2
    //   40: invokestatic 58	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload 7
    //   46: athrow
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 61	io/netty/handler/codec/CodecOutputList:add	(Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_3
    //   54: invokevirtual 65	io/netty/handler/codec/CodecOutputList:size	()I
    //   57: istore 4
    //   59: iload 5
    //   61: iload 4
    //   63: if_icmpge +22 -> 85
    //   66: aload_1
    //   67: aload_3
    //   68: iload 5
    //   70: invokevirtual 69	io/netty/handler/codec/CodecOutputList:getUnsafe	(I)Ljava/lang/Object;
    //   73: invokeinterface 75 2 0
    //   78: pop
    //   79: iinc 5 1
    //   82: goto -23 -> 59
    //   85: aload_3
    //   86: invokevirtual 78	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   89: return
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 78	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_2
    //   98: goto +21 -> 119
    //   101: astore_2
    //   102: new 41	io/netty/handler/codec/DecoderException
    //   105: astore 7
    //   107: aload 7
    //   109: aload_2
    //   110: invokespecial 81	io/netty/handler/codec/DecoderException:<init>	(Ljava/lang/Throwable;)V
    //   113: aload 7
    //   115: athrow
    //   116: astore_2
    //   117: aload_2
    //   118: athrow
    //   119: aload_3
    //   120: invokevirtual 65	io/netty/handler/codec/CodecOutputList:size	()I
    //   123: istore 8
    //   125: iload 4
    //   127: istore 5
    //   129: iload 5
    //   131: iload 8
    //   133: if_icmpge +22 -> 155
    //   136: aload_1
    //   137: aload_3
    //   138: iload 5
    //   140: invokevirtual 69	io/netty/handler/codec/CodecOutputList:getUnsafe	(I)Ljava/lang/Object;
    //   143: invokeinterface 75 2 0
    //   148: pop
    //   149: iinc 5 1
    //   152: goto -23 -> 129
    //   155: aload_3
    //   156: invokevirtual 78	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   159: aload_2
    //   160: athrow
    //   161: astore_1
    //   162: aload_3
    //   163: invokevirtual 78	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	MessageToMessageDecoder
    //   0	168	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	168	2	paramObject	Object
    //   3	160	3	localCodecOutputList	CodecOutputList
    //   5	121	4	i	int
    //   8	142	5	j	int
    //   15	3	6	bool	boolean
    //   37	8	7	localObject	Object
    //   105	9	7	localDecoderException	DecoderException
    //   123	11	8	k	int
    // Exception table:
    //   from	to	target	type
    //   22	29	37	finally
    //   53	59	90	finally
    //   66	79	90	finally
    //   10	17	97	finally
    //   29	34	97	finally
    //   39	47	97	finally
    //   47	53	97	finally
    //   102	116	97	finally
    //   117	119	97	finally
    //   10	17	101	java/lang/Exception
    //   29	34	101	java/lang/Exception
    //   39	47	101	java/lang/Exception
    //   47	53	101	java/lang/Exception
    //   10	17	116	io/netty/handler/codec/DecoderException
    //   29	34	116	io/netty/handler/codec/DecoderException
    //   39	47	116	io/netty/handler/codec/DecoderException
    //   47	53	116	io/netty/handler/codec/DecoderException
    //   119	125	161	finally
    //   136	149	161	finally
  }
  
  protected abstract void decode(ChannelHandlerContext paramChannelHandlerContext, I paramI, List<Object> paramList)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\MessageToMessageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
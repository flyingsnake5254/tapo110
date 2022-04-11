package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class MessageToByteEncoder<I>
  extends ChannelOutboundHandlerAdapter
{
  private final TypeParameterMatcher matcher;
  private final boolean preferDirect;
  
  protected MessageToByteEncoder()
  {
    this(true);
  }
  
  protected MessageToByteEncoder(Class<? extends I> paramClass)
  {
    this(paramClass, true);
  }
  
  protected MessageToByteEncoder(Class<? extends I> paramClass, boolean paramBoolean)
  {
    this.matcher = TypeParameterMatcher.get(paramClass);
    this.preferDirect = paramBoolean;
  }
  
  protected MessageToByteEncoder(boolean paramBoolean)
  {
    this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
    this.preferDirect = paramBoolean;
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    return this.matcher.match(paramObject);
  }
  
  protected ByteBuf allocateBuffer(ChannelHandlerContext paramChannelHandlerContext, I paramI, boolean paramBoolean)
    throws Exception
  {
    if (paramBoolean) {
      return paramChannelHandlerContext.alloc().ioBuffer();
    }
    return paramChannelHandlerContext.alloc().heapBuffer();
  }
  
  protected abstract void encode(ChannelHandlerContext paramChannelHandlerContext, I paramI, ByteBuf paramByteBuf)
    throws Exception;
  
  protected boolean isPreferDirect()
  {
    return this.preferDirect;
  }
  
  /* Error */
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, io.netty.channel.ChannelPromise paramChannelPromise)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore 6
    //   10: aload 4
    //   12: astore 7
    //   14: aload_0
    //   15: aload_2
    //   16: invokevirtual 76	io/netty/handler/codec/MessageToByteEncoder:acceptOutboundMessage	(Ljava/lang/Object;)Z
    //   19: ifeq +143 -> 162
    //   22: aload 5
    //   24: astore 6
    //   26: aload 4
    //   28: astore 7
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 33	io/netty/handler/codec/MessageToByteEncoder:preferDirect	Z
    //   37: invokevirtual 78	io/netty/handler/codec/MessageToByteEncoder:allocateBuffer	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;Z)Lio/netty/buffer/ByteBuf;
    //   40: astore 5
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: aload 5
    //   47: invokevirtual 80	io/netty/handler/codec/MessageToByteEncoder:encode	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;Lio/netty/buffer/ByteBuf;)V
    //   50: aload 5
    //   52: astore 6
    //   54: aload 5
    //   56: astore 7
    //   58: aload_2
    //   59: invokestatic 85	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   62: pop
    //   63: aload 5
    //   65: astore 6
    //   67: aload 5
    //   69: astore 7
    //   71: aload 5
    //   73: invokevirtual 90	io/netty/buffer/ByteBuf:isReadable	()Z
    //   76: ifeq +24 -> 100
    //   79: aload 5
    //   81: astore 6
    //   83: aload 5
    //   85: astore 7
    //   87: aload_1
    //   88: aload 5
    //   90: aload_3
    //   91: invokeinterface 95 3 0
    //   96: pop
    //   97: goto +82 -> 179
    //   100: aload 5
    //   102: astore 6
    //   104: aload 5
    //   106: astore 7
    //   108: aload 5
    //   110: invokeinterface 99 1 0
    //   115: pop
    //   116: aload 5
    //   118: astore 6
    //   120: aload 5
    //   122: astore 7
    //   124: aload_1
    //   125: getstatic 105	io/netty/buffer/Unpooled:EMPTY_BUFFER	Lio/netty/buffer/ByteBuf;
    //   128: aload_3
    //   129: invokeinterface 95 3 0
    //   134: pop
    //   135: goto +44 -> 179
    //   138: astore_1
    //   139: aload 5
    //   141: astore 6
    //   143: aload 5
    //   145: astore 7
    //   147: aload_2
    //   148: invokestatic 85	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   151: pop
    //   152: aload 5
    //   154: astore 6
    //   156: aload 5
    //   158: astore 7
    //   160: aload_1
    //   161: athrow
    //   162: aload 5
    //   164: astore 6
    //   166: aload 4
    //   168: astore 7
    //   170: aload_1
    //   171: aload_2
    //   172: aload_3
    //   173: invokeinterface 95 3 0
    //   178: pop
    //   179: return
    //   180: astore_1
    //   181: aload 6
    //   183: astore 7
    //   185: new 74	io/netty/handler/codec/EncoderException
    //   188: astore_2
    //   189: aload 6
    //   191: astore 7
    //   193: aload_2
    //   194: aload_1
    //   195: invokespecial 108	io/netty/handler/codec/EncoderException:<init>	(Ljava/lang/Throwable;)V
    //   198: aload 6
    //   200: astore 7
    //   202: aload_2
    //   203: athrow
    //   204: astore_1
    //   205: aload_1
    //   206: athrow
    //   207: astore_1
    //   208: aload 7
    //   210: ifnull +11 -> 221
    //   213: aload 7
    //   215: invokeinterface 99 1 0
    //   220: pop
    //   221: aload_1
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	MessageToByteEncoder
    //   0	223	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	223	2	paramObject	Object
    //   0	223	3	paramChannelPromise	io.netty.channel.ChannelPromise
    //   1	166	4	localObject1	Object
    //   4	159	5	localByteBuf1	ByteBuf
    //   8	191	6	localByteBuf2	ByteBuf
    //   12	202	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	50	138	finally
    //   14	22	180	finally
    //   30	42	180	finally
    //   58	63	180	finally
    //   71	79	180	finally
    //   87	97	180	finally
    //   108	116	180	finally
    //   124	135	180	finally
    //   147	152	180	finally
    //   160	162	180	finally
    //   170	179	180	finally
    //   14	22	204	io/netty/handler/codec/EncoderException
    //   30	42	204	io/netty/handler/codec/EncoderException
    //   58	63	204	io/netty/handler/codec/EncoderException
    //   71	79	204	io/netty/handler/codec/EncoderException
    //   87	97	204	io/netty/handler/codec/EncoderException
    //   108	116	204	io/netty/handler/codec/EncoderException
    //   124	135	204	io/netty/handler/codec/EncoderException
    //   147	152	204	io/netty/handler/codec/EncoderException
    //   160	162	204	io/netty/handler/codec/EncoderException
    //   170	179	204	io/netty/handler/codec/EncoderException
    //   185	189	207	finally
    //   193	198	207	finally
    //   202	204	207	finally
    //   205	207	207	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\MessageToByteEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
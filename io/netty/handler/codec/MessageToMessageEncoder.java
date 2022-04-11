package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class MessageToMessageEncoder<I>
  extends ChannelOutboundHandlerAdapter
{
  private final TypeParameterMatcher matcher;
  
  protected MessageToMessageEncoder()
  {
    this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
  }
  
  protected MessageToMessageEncoder(Class<? extends I> paramClass)
  {
    this.matcher = TypeParameterMatcher.get(paramClass);
  }
  
  private static void writePromiseCombiner(ChannelHandlerContext paramChannelHandlerContext, CodecOutputList paramCodecOutputList, ChannelPromise paramChannelPromise)
  {
    PromiseCombiner localPromiseCombiner = new PromiseCombiner(paramChannelHandlerContext.executor());
    for (int i = 0; i < paramCodecOutputList.size(); i++) {
      localPromiseCombiner.add(paramChannelHandlerContext.write(paramCodecOutputList.getUnsafe(i)));
    }
    localPromiseCombiner.finish(paramChannelPromise);
  }
  
  private static void writeVoidPromise(ChannelHandlerContext paramChannelHandlerContext, CodecOutputList paramCodecOutputList)
  {
    ChannelPromise localChannelPromise = paramChannelHandlerContext.voidPromise();
    for (int i = 0; i < paramCodecOutputList.size(); i++) {
      paramChannelHandlerContext.write(paramCodecOutputList.getUnsafe(i), localChannelPromise);
    }
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    return this.matcher.match(paramObject);
  }
  
  protected abstract void encode(ChannelHandlerContext paramChannelHandlerContext, I paramI, List<Object> paramList)
    throws Exception;
  
  /* Error */
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 4
    //   11: astore 7
    //   13: aload 5
    //   15: astore 8
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual 90	io/netty/handler/codec/MessageToMessageEncoder:acceptOutboundMessage	(Ljava/lang/Object;)Z
    //   22: ifeq +181 -> 203
    //   25: aload 4
    //   27: astore 7
    //   29: aload 5
    //   31: astore 8
    //   33: invokestatic 94	io/netty/handler/codec/CodecOutputList:newInstance	()Lio/netty/handler/codec/CodecOutputList;
    //   36: astore 6
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: aload 6
    //   43: invokevirtual 96	io/netty/handler/codec/MessageToMessageEncoder:encode	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;Ljava/util/List;)V
    //   46: aload 6
    //   48: astore 7
    //   50: aload 6
    //   52: astore 8
    //   54: aload_2
    //   55: invokestatic 101	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: aload 6
    //   61: astore 7
    //   63: aload 6
    //   65: astore 8
    //   67: aload 6
    //   69: invokevirtual 107	java/util/AbstractList:isEmpty	()Z
    //   72: ifne +6 -> 78
    //   75: goto +145 -> 220
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: new 88	io/netty/handler/codec/EncoderException
    //   89: astore_2
    //   90: aload 6
    //   92: astore 7
    //   94: aload 6
    //   96: astore 8
    //   98: new 109	java/lang/StringBuilder
    //   101: astore 4
    //   103: aload 6
    //   105: astore 7
    //   107: aload 6
    //   109: astore 8
    //   111: aload 4
    //   113: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   116: aload 6
    //   118: astore 7
    //   120: aload 6
    //   122: astore 8
    //   124: aload 4
    //   126: aload_0
    //   127: invokestatic 116	io/netty/util/internal/StringUtil:simpleClassName	(Ljava/lang/Object;)Ljava/lang/String;
    //   130: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: astore 7
    //   138: aload 6
    //   140: astore 8
    //   142: aload 4
    //   144: ldc 122
    //   146: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 6
    //   152: astore 7
    //   154: aload 6
    //   156: astore 8
    //   158: aload_2
    //   159: aload 4
    //   161: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokespecial 129	io/netty/handler/codec/EncoderException:<init>	(Ljava/lang/String;)V
    //   167: aload 6
    //   169: astore 7
    //   171: aload 6
    //   173: astore 8
    //   175: aload_2
    //   176: athrow
    //   177: astore 4
    //   179: aload 6
    //   181: astore 7
    //   183: aload 6
    //   185: astore 8
    //   187: aload_2
    //   188: invokestatic 101	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   191: pop
    //   192: aload 6
    //   194: astore 7
    //   196: aload 6
    //   198: astore 8
    //   200: aload 4
    //   202: athrow
    //   203: aload 4
    //   205: astore 7
    //   207: aload 5
    //   209: astore 8
    //   211: aload_1
    //   212: aload_2
    //   213: aload_3
    //   214: invokeinterface 75 3 0
    //   219: pop
    //   220: aload 6
    //   222: ifnull +81 -> 303
    //   225: aload 6
    //   227: invokevirtual 48	io/netty/handler/codec/CodecOutputList:size	()I
    //   230: iconst_1
    //   231: isub
    //   232: istore 9
    //   234: iload 9
    //   236: ifne +20 -> 256
    //   239: aload_1
    //   240: aload 6
    //   242: iconst_0
    //   243: invokevirtual 52	io/netty/handler/codec/CodecOutputList:getUnsafe	(I)Ljava/lang/Object;
    //   246: aload_3
    //   247: invokeinterface 75 3 0
    //   252: pop
    //   253: goto +34 -> 287
    //   256: iload 9
    //   258: ifle +29 -> 287
    //   261: aload_3
    //   262: aload_1
    //   263: invokeinterface 72 1 0
    //   268: if_acmpne +12 -> 280
    //   271: aload_1
    //   272: aload 6
    //   274: invokestatic 131	io/netty/handler/codec/MessageToMessageEncoder:writeVoidPromise	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;)V
    //   277: goto +10 -> 287
    //   280: aload_1
    //   281: aload 6
    //   283: aload_3
    //   284: invokestatic 133	io/netty/handler/codec/MessageToMessageEncoder:writePromiseCombiner	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;Lio/netty/channel/ChannelPromise;)V
    //   287: aload 6
    //   289: invokevirtual 136	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   292: goto +11 -> 303
    //   295: astore_1
    //   296: aload 6
    //   298: invokevirtual 136	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   301: aload_1
    //   302: athrow
    //   303: return
    //   304: astore 6
    //   306: aload 7
    //   308: astore 8
    //   310: new 88	io/netty/handler/codec/EncoderException
    //   313: astore_2
    //   314: aload 7
    //   316: astore 8
    //   318: aload_2
    //   319: aload 6
    //   321: invokespecial 139	io/netty/handler/codec/EncoderException:<init>	(Ljava/lang/Throwable;)V
    //   324: aload 7
    //   326: astore 8
    //   328: aload_2
    //   329: athrow
    //   330: astore_2
    //   331: aload_2
    //   332: athrow
    //   333: astore_2
    //   334: aload 8
    //   336: ifnull +81 -> 417
    //   339: aload 8
    //   341: invokevirtual 48	io/netty/handler/codec/CodecOutputList:size	()I
    //   344: iconst_1
    //   345: isub
    //   346: istore 9
    //   348: iload 9
    //   350: ifeq +37 -> 387
    //   353: iload 9
    //   355: ifle +46 -> 401
    //   358: aload_3
    //   359: aload_1
    //   360: invokeinterface 72 1 0
    //   365: if_acmpne +12 -> 377
    //   368: aload_1
    //   369: aload 8
    //   371: invokestatic 131	io/netty/handler/codec/MessageToMessageEncoder:writeVoidPromise	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;)V
    //   374: goto +27 -> 401
    //   377: aload_1
    //   378: aload 8
    //   380: aload_3
    //   381: invokestatic 133	io/netty/handler/codec/MessageToMessageEncoder:writePromiseCombiner	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;Lio/netty/channel/ChannelPromise;)V
    //   384: goto +17 -> 401
    //   387: aload_1
    //   388: aload 8
    //   390: iconst_0
    //   391: invokevirtual 52	io/netty/handler/codec/CodecOutputList:getUnsafe	(I)Ljava/lang/Object;
    //   394: aload_3
    //   395: invokeinterface 75 3 0
    //   400: pop
    //   401: aload 8
    //   403: invokevirtual 136	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   406: goto +11 -> 417
    //   409: astore_1
    //   410: aload 8
    //   412: invokevirtual 136	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   415: aload_1
    //   416: athrow
    //   417: aload_2
    //   418: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	MessageToMessageEncoder
    //   0	419	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	419	2	paramObject	Object
    //   0	419	3	paramChannelPromise	ChannelPromise
    //   1	159	4	localStringBuilder	StringBuilder
    //   177	27	4	localObject1	Object
    //   4	204	5	localObject2	Object
    //   7	290	6	localCodecOutputList	CodecOutputList
    //   304	16	6	localThrowable	Throwable
    //   11	314	7	localObject3	Object
    //   15	396	8	localObject4	Object
    //   232	122	9	i	int
    // Exception table:
    //   from	to	target	type
    //   38	46	177	finally
    //   225	234	295	finally
    //   239	253	295	finally
    //   261	277	295	finally
    //   280	287	295	finally
    //   17	25	304	finally
    //   33	38	304	finally
    //   54	59	304	finally
    //   67	75	304	finally
    //   86	90	304	finally
    //   98	103	304	finally
    //   111	116	304	finally
    //   124	134	304	finally
    //   142	150	304	finally
    //   158	167	304	finally
    //   175	177	304	finally
    //   187	192	304	finally
    //   200	203	304	finally
    //   211	220	304	finally
    //   17	25	330	io/netty/handler/codec/EncoderException
    //   33	38	330	io/netty/handler/codec/EncoderException
    //   54	59	330	io/netty/handler/codec/EncoderException
    //   67	75	330	io/netty/handler/codec/EncoderException
    //   86	90	330	io/netty/handler/codec/EncoderException
    //   98	103	330	io/netty/handler/codec/EncoderException
    //   111	116	330	io/netty/handler/codec/EncoderException
    //   124	134	330	io/netty/handler/codec/EncoderException
    //   142	150	330	io/netty/handler/codec/EncoderException
    //   158	167	330	io/netty/handler/codec/EncoderException
    //   175	177	330	io/netty/handler/codec/EncoderException
    //   187	192	330	io/netty/handler/codec/EncoderException
    //   200	203	330	io/netty/handler/codec/EncoderException
    //   211	220	330	io/netty/handler/codec/EncoderException
    //   310	314	333	finally
    //   318	324	333	finally
    //   328	330	333	finally
    //   331	333	333	finally
    //   339	348	409	finally
    //   358	374	409	finally
    //   377	384	409	finally
    //   387	401	409	finally
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\MessageToMessageEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
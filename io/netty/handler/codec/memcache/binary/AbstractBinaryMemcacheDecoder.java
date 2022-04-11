package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.DecoderResultProvider;
import io.netty.handler.codec.memcache.AbstractMemcacheObjectDecoder;
import io.netty.handler.codec.memcache.DefaultLastMemcacheContent;
import io.netty.handler.codec.memcache.MemcacheContent;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public abstract class AbstractBinaryMemcacheDecoder<M extends BinaryMemcacheMessage>
  extends AbstractMemcacheObjectDecoder
{
  public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
  private int alreadyReadChunkSize;
  private final int chunkSize;
  private M currentMessage;
  private State state = State.READ_HEADER;
  
  protected AbstractBinaryMemcacheDecoder()
  {
    this(8192);
  }
  
  protected AbstractBinaryMemcacheDecoder(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "chunkSize");
    this.chunkSize = paramInt;
  }
  
  private MemcacheContent invalidChunk(Exception paramException)
  {
    this.state = State.BAD_MESSAGE;
    DefaultLastMemcacheContent localDefaultLastMemcacheContent = new DefaultLastMemcacheContent(Unpooled.EMPTY_BUFFER);
    localDefaultLastMemcacheContent.setDecoderResult(DecoderResult.failure(paramException));
    return localDefaultLastMemcacheContent;
  }
  
  private M invalidMessage(Exception paramException)
  {
    this.state = State.BAD_MESSAGE;
    BinaryMemcacheMessage localBinaryMemcacheMessage = buildInvalidMessage();
    localBinaryMemcacheMessage.setDecoderResult(DecoderResult.failure(paramException));
    return localBinaryMemcacheMessage;
  }
  
  protected abstract M buildInvalidMessage();
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.channelInactive(paramChannelHandlerContext);
    resetDecoder();
  }
  
  /* Error */
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, java.util.List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: getstatic 96	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$1:$SwitchMap$io$netty$handler$codec$memcache$binary$AbstractBinaryMemcacheDecoder$State	[I
    //   3: aload_0
    //   4: getfield 33	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:state	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   7: invokevirtual 102	java/lang/Enum:ordinal	()I
    //   10: iaload
    //   11: istore 4
    //   13: iload 4
    //   15: iconst_1
    //   16: if_icmpeq +73 -> 89
    //   19: iload 4
    //   21: iconst_2
    //   22: if_icmpeq +97 -> 119
    //   25: iload 4
    //   27: iconst_3
    //   28: if_icmpeq +140 -> 168
    //   31: iload 4
    //   33: iconst_4
    //   34: if_icmpeq +199 -> 233
    //   37: iload 4
    //   39: iconst_5
    //   40: if_icmpne +13 -> 53
    //   43: aload_2
    //   44: aload_0
    //   45: invokevirtual 105	io/netty/handler/codec/ByteToMessageDecoder:actualReadableBytes	()I
    //   48: invokevirtual 111	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   51: pop
    //   52: return
    //   53: new 113	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   60: astore_1
    //   61: aload_1
    //   62: ldc 116
    //   64: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 33	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:state	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   73: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new 125	java/lang/Error
    //   80: dup
    //   81: aload_1
    //   82: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 132	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: aload_2
    //   90: invokevirtual 135	io/netty/buffer/ByteBuf:readableBytes	()I
    //   93: bipush 24
    //   95: if_icmpge +4 -> 99
    //   98: return
    //   99: aload_0
    //   100: invokevirtual 89	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:resetDecoder	()V
    //   103: aload_0
    //   104: aload_0
    //   105: aload_2
    //   106: invokevirtual 139	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:decodeHeader	(Lio/netty/buffer/ByteBuf;)Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   109: putfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   112: aload_0
    //   113: getstatic 144	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State:READ_EXTRAS	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   116: putfield 33	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:state	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   119: aload_0
    //   120: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   123: invokeinterface 150 1 0
    //   128: istore 4
    //   130: iload 4
    //   132: ifle +29 -> 161
    //   135: aload_2
    //   136: invokevirtual 135	io/netty/buffer/ByteBuf:readableBytes	()I
    //   139: iload 4
    //   141: if_icmpge +4 -> 145
    //   144: return
    //   145: aload_0
    //   146: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   149: aload_2
    //   150: iload 4
    //   152: invokevirtual 153	io/netty/buffer/ByteBuf:readRetainedSlice	(I)Lio/netty/buffer/ByteBuf;
    //   155: invokeinterface 156 2 0
    //   160: pop
    //   161: aload_0
    //   162: getstatic 159	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State:READ_KEY	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   165: putfield 33	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:state	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   168: aload_0
    //   169: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   172: invokeinterface 163 1 0
    //   177: istore 4
    //   179: iload 4
    //   181: ifle +29 -> 210
    //   184: aload_2
    //   185: invokevirtual 135	io/netty/buffer/ByteBuf:readableBytes	()I
    //   188: iload 4
    //   190: if_icmpge +4 -> 194
    //   193: return
    //   194: aload_0
    //   195: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   198: aload_2
    //   199: iload 4
    //   201: invokevirtual 153	io/netty/buffer/ByteBuf:readRetainedSlice	(I)Lio/netty/buffer/ByteBuf;
    //   204: invokeinterface 166 2 0
    //   209: pop
    //   210: aload_3
    //   211: aload_0
    //   212: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   215: invokeinterface 169 1 0
    //   220: invokeinterface 175 2 0
    //   225: pop
    //   226: aload_0
    //   227: getstatic 178	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State:READ_CONTENT	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   230: putfield 33	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:state	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   233: aload_0
    //   234: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   237: invokeinterface 181 1 0
    //   242: aload_0
    //   243: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   246: invokeinterface 163 1 0
    //   251: isub
    //   252: aload_0
    //   253: getfield 141	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:currentMessage	Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   256: invokeinterface 150 1 0
    //   261: isub
    //   262: istore 5
    //   264: aload_2
    //   265: invokevirtual 135	io/netty/buffer/ByteBuf:readableBytes	()I
    //   268: istore 6
    //   270: iload 5
    //   272: ifle +122 -> 394
    //   275: iload 6
    //   277: ifne +4 -> 281
    //   280: return
    //   281: aload_0
    //   282: getfield 42	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:chunkSize	I
    //   285: istore 7
    //   287: iload 6
    //   289: istore 4
    //   291: iload 6
    //   293: iload 7
    //   295: if_icmple +7 -> 302
    //   298: iload 7
    //   300: istore 4
    //   302: iload 5
    //   304: aload_0
    //   305: getfield 183	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:alreadyReadChunkSize	I
    //   308: isub
    //   309: istore 7
    //   311: iload 4
    //   313: istore 6
    //   315: iload 4
    //   317: iload 7
    //   319: if_icmple +7 -> 326
    //   322: iload 7
    //   324: istore 6
    //   326: aload_2
    //   327: iload 6
    //   329: invokevirtual 153	io/netty/buffer/ByteBuf:readRetainedSlice	(I)Lio/netty/buffer/ByteBuf;
    //   332: astore_2
    //   333: aload_0
    //   334: getfield 183	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:alreadyReadChunkSize	I
    //   337: iload 6
    //   339: iadd
    //   340: istore 4
    //   342: aload_0
    //   343: iload 4
    //   345: putfield 183	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:alreadyReadChunkSize	I
    //   348: iload 4
    //   350: iload 5
    //   352: if_icmplt +15 -> 367
    //   355: new 49	io/netty/handler/codec/memcache/DefaultLastMemcacheContent
    //   358: astore_1
    //   359: aload_1
    //   360: aload_2
    //   361: invokespecial 58	io/netty/handler/codec/memcache/DefaultLastMemcacheContent:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   364: goto +12 -> 376
    //   367: new 185	io/netty/handler/codec/memcache/DefaultMemcacheContent
    //   370: dup
    //   371: aload_2
    //   372: invokespecial 186	io/netty/handler/codec/memcache/DefaultMemcacheContent:<init>	(Lio/netty/buffer/ByteBuf;)V
    //   375: astore_1
    //   376: aload_3
    //   377: aload_1
    //   378: invokeinterface 175 2 0
    //   383: pop
    //   384: aload_0
    //   385: getfield 183	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:alreadyReadChunkSize	I
    //   388: iload 5
    //   390: if_icmpge +14 -> 404
    //   393: return
    //   394: aload_3
    //   395: getstatic 192	io/netty/handler/codec/memcache/LastMemcacheContent:EMPTY_LAST_CONTENT	Lio/netty/handler/codec/memcache/LastMemcacheContent;
    //   398: invokeinterface 175 2 0
    //   403: pop
    //   404: aload_0
    //   405: invokevirtual 89	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:resetDecoder	()V
    //   408: aload_0
    //   409: getstatic 31	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State:READ_HEADER	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   412: putfield 33	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:state	Lio/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder$State;
    //   415: return
    //   416: astore_1
    //   417: aload_0
    //   418: invokevirtual 89	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:resetDecoder	()V
    //   421: aload_3
    //   422: aload_0
    //   423: aload_1
    //   424: invokespecial 194	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:invalidChunk	(Ljava/lang/Exception;)Lio/netty/handler/codec/memcache/MemcacheContent;
    //   427: invokeinterface 175 2 0
    //   432: pop
    //   433: return
    //   434: astore_1
    //   435: aload_0
    //   436: invokevirtual 89	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:resetDecoder	()V
    //   439: aload_3
    //   440: aload_0
    //   441: aload_1
    //   442: invokespecial 196	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:invalidMessage	(Ljava/lang/Exception;)Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   445: invokeinterface 175 2 0
    //   450: pop
    //   451: return
    //   452: astore_1
    //   453: aload_0
    //   454: invokevirtual 89	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:resetDecoder	()V
    //   457: aload_3
    //   458: aload_0
    //   459: aload_1
    //   460: invokespecial 196	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:invalidMessage	(Ljava/lang/Exception;)Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   463: invokeinterface 175 2 0
    //   468: pop
    //   469: return
    //   470: astore_1
    //   471: aload_0
    //   472: invokevirtual 89	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:resetDecoder	()V
    //   475: aload_3
    //   476: aload_0
    //   477: aload_1
    //   478: invokespecial 196	io/netty/handler/codec/memcache/binary/AbstractBinaryMemcacheDecoder:invalidMessage	(Ljava/lang/Exception;)Lio/netty/handler/codec/memcache/binary/BinaryMemcacheMessage;
    //   481: invokeinterface 175 2 0
    //   486: pop
    //   487: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	AbstractBinaryMemcacheDecoder
    //   0	488	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	488	2	paramByteBuf	ByteBuf
    //   0	488	3	paramList	java.util.List<Object>
    //   11	342	4	i	int
    //   262	129	5	j	int
    //   268	72	6	k	int
    //   285	38	7	m	int
    // Exception table:
    //   from	to	target	type
    //   233	270	416	java/lang/Exception
    //   281	287	416	java/lang/Exception
    //   302	311	416	java/lang/Exception
    //   326	348	416	java/lang/Exception
    //   355	364	416	java/lang/Exception
    //   367	376	416	java/lang/Exception
    //   376	393	416	java/lang/Exception
    //   394	404	416	java/lang/Exception
    //   404	415	416	java/lang/Exception
    //   168	179	434	java/lang/Exception
    //   184	193	434	java/lang/Exception
    //   194	210	434	java/lang/Exception
    //   210	233	434	java/lang/Exception
    //   119	130	452	java/lang/Exception
    //   135	144	452	java/lang/Exception
    //   145	161	452	java/lang/Exception
    //   161	168	452	java/lang/Exception
    //   89	98	470	java/lang/Exception
    //   99	119	470	java/lang/Exception
  }
  
  protected abstract M decodeHeader(ByteBuf paramByteBuf);
  
  protected void resetDecoder()
  {
    BinaryMemcacheMessage localBinaryMemcacheMessage = this.currentMessage;
    if (localBinaryMemcacheMessage != null)
    {
      localBinaryMemcacheMessage.release();
      this.currentMessage = null;
    }
    this.alreadyReadChunkSize = 0;
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("READ_HEADER", 0);
      READ_HEADER = localState1;
      State localState2 = new State("READ_EXTRAS", 1);
      READ_EXTRAS = localState2;
      State localState3 = new State("READ_KEY", 2);
      READ_KEY = localState3;
      State localState4 = new State("READ_CONTENT", 3);
      READ_CONTENT = localState4;
      State localState5 = new State("BAD_MESSAGE", 4);
      BAD_MESSAGE = localState5;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\memcache\binary\AbstractBinaryMemcacheDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;

public abstract class ByteToMessageDecoder
  extends ChannelInboundHandlerAdapter
{
  public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator()
  {
    /* Error */
    public ByteBuf cumulate(ByteBufAllocator paramAnonymousByteBufAllocator, ByteBuf paramAnonymousByteBuf1, ByteBuf paramAnonymousByteBuf2)
    {
      // Byte code:
      //   0: aload_2
      //   1: invokevirtual 21	io/netty/buffer/ByteBuf:isReadable	()Z
      //   4: ifne +12 -> 16
      //   7: aload_2
      //   8: invokeinterface 26 1 0
      //   13: pop
      //   14: aload_3
      //   15: areturn
      //   16: aconst_null
      //   17: astore 4
      //   19: aload 4
      //   21: astore 5
      //   23: aload_2
      //   24: instanceof 28
      //   27: ifeq +64 -> 91
      //   30: aload 4
      //   32: astore 5
      //   34: aload_2
      //   35: invokeinterface 32 1 0
      //   40: iconst_1
      //   41: if_icmpne +50 -> 91
      //   44: aload 4
      //   46: astore 5
      //   48: aload_2
      //   49: checkcast 28	io/netty/buffer/CompositeByteBuf
      //   52: astore 4
      //   54: aload 4
      //   56: astore_1
      //   57: aload 4
      //   59: invokevirtual 37	io/netty/buffer/AbstractByteBuf:writerIndex	()I
      //   62: aload 4
      //   64: invokevirtual 40	io/netty/buffer/CompositeByteBuf:capacity	()I
      //   67: if_icmpeq +42 -> 109
      //   70: aload 4
      //   72: aload 4
      //   74: invokevirtual 37	io/netty/buffer/AbstractByteBuf:writerIndex	()I
      //   77: invokevirtual 43	io/netty/buffer/CompositeByteBuf:capacity	(I)Lio/netty/buffer/CompositeByteBuf;
      //   80: pop
      //   81: aload 4
      //   83: astore_1
      //   84: goto +25 -> 109
      //   87: astore_1
      //   88: goto +38 -> 126
      //   91: aload 4
      //   93: astore 5
      //   95: aload_1
      //   96: ldc 44
      //   98: invokeinterface 49 2 0
      //   103: iconst_1
      //   104: aload_2
      //   105: invokevirtual 53	io/netty/buffer/CompositeByteBuf:addFlattenedComponents	(ZLio/netty/buffer/ByteBuf;)Lio/netty/buffer/CompositeByteBuf;
      //   108: astore_1
      //   109: aload_1
      //   110: astore 5
      //   112: aload_1
      //   113: iconst_1
      //   114: aload_3
      //   115: invokevirtual 53	io/netty/buffer/CompositeByteBuf:addFlattenedComponents	(ZLio/netty/buffer/ByteBuf;)Lio/netty/buffer/CompositeByteBuf;
      //   118: pop
      //   119: aload_1
      //   120: areturn
      //   121: astore_1
      //   122: aload 5
      //   124: astore 4
      //   126: aload_3
      //   127: ifnull +27 -> 154
      //   130: aload_3
      //   131: invokeinterface 26 1 0
      //   136: pop
      //   137: aload 4
      //   139: ifnull +15 -> 154
      //   142: aload 4
      //   144: aload_2
      //   145: if_acmpeq +9 -> 154
      //   148: aload 4
      //   150: invokevirtual 56	io/netty/buffer/AbstractReferenceCountedByteBuf:release	()Z
      //   153: pop
      //   154: aload_1
      //   155: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	2
      //   0	156	1	paramAnonymousByteBufAllocator	ByteBufAllocator
      //   0	156	2	paramAnonymousByteBuf1	ByteBuf
      //   0	156	3	paramAnonymousByteBuf2	ByteBuf
      //   17	132	4	localObject1	Object
      //   21	102	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   57	81	87	finally
      //   23	30	121	finally
      //   34	44	121	finally
      //   48	54	121	finally
      //   95	109	121	finally
      //   112	119	121	finally
    }
  };
  public static final Cumulator MERGE_CUMULATOR = new Cumulator()
  {
    public ByteBuf cumulate(ByteBufAllocator paramAnonymousByteBufAllocator, ByteBuf paramAnonymousByteBuf1, ByteBuf paramAnonymousByteBuf2)
    {
      if ((!paramAnonymousByteBuf1.isReadable()) && (paramAnonymousByteBuf2.isContiguous()))
      {
        paramAnonymousByteBuf1.release();
        return paramAnonymousByteBuf2;
      }
      try
      {
        int i = paramAnonymousByteBuf2.readableBytes();
        if ((i <= paramAnonymousByteBuf1.maxWritableBytes()) && ((i <= paramAnonymousByteBuf1.maxFastWritableBytes()) || (paramAnonymousByteBuf1.refCnt() <= 1)) && (!paramAnonymousByteBuf1.isReadOnly()))
        {
          paramAnonymousByteBuf1.writeBytes(paramAnonymousByteBuf2, paramAnonymousByteBuf2.readerIndex(), i);
          paramAnonymousByteBuf2.readerIndex(paramAnonymousByteBuf2.writerIndex());
          return paramAnonymousByteBuf1;
        }
        paramAnonymousByteBufAllocator = ByteToMessageDecoder.expandCumulation(paramAnonymousByteBufAllocator, paramAnonymousByteBuf1, paramAnonymousByteBuf2);
        return paramAnonymousByteBufAllocator;
      }
      finally
      {
        paramAnonymousByteBuf2.release();
      }
    }
  };
  private static final byte STATE_CALLING_CHILD_DECODE = 1;
  private static final byte STATE_HANDLER_REMOVED_PENDING = 2;
  private static final byte STATE_INIT = 0;
  ByteBuf cumulation;
  private Cumulator cumulator = MERGE_CUMULATOR;
  private byte decodeState = (byte)0;
  private int discardAfterReads = 16;
  private boolean firedChannelRead;
  private boolean first;
  private int numReads;
  private boolean singleDecode;
  
  protected ByteToMessageDecoder()
  {
    ensureNotSharable();
  }
  
  /* Error */
  private void channelInputClosed(ChannelHandlerContext paramChannelHandlerContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 67	io/netty/handler/codec/CodecOutputList:newInstance	()Lio/netty/handler/codec/CodecOutputList;
    //   3: astore_3
    //   4: aload_0
    //   5: aload_1
    //   6: aload_3
    //   7: invokevirtual 70	io/netty/handler/codec/ByteToMessageDecoder:channelInputClosed	(Lio/netty/channel/ChannelHandlerContext;Ljava/util/List;)V
    //   10: aload_0
    //   11: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnull +16 -> 34
    //   21: aload 4
    //   23: invokeinterface 78 1 0
    //   28: pop
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   34: aload_3
    //   35: invokevirtual 82	io/netty/handler/codec/CodecOutputList:size	()I
    //   38: istore 5
    //   40: aload_1
    //   41: aload_3
    //   42: iload 5
    //   44: invokestatic 86	io/netty/handler/codec/ByteToMessageDecoder:fireChannelRead	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;I)V
    //   47: iload 5
    //   49: ifle +10 -> 59
    //   52: aload_1
    //   53: invokeinterface 92 1 0
    //   58: pop
    //   59: iload_2
    //   60: ifeq +10 -> 70
    //   63: aload_1
    //   64: invokeinterface 95 1 0
    //   69: pop
    //   70: aload_3
    //   71: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   74: return
    //   75: astore_1
    //   76: aload_3
    //   77: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   80: aload_1
    //   81: athrow
    //   82: astore 6
    //   84: goto +25 -> 109
    //   87: astore 4
    //   89: new 59	io/netty/handler/codec/DecoderException
    //   92: astore 6
    //   94: aload 6
    //   96: aload 4
    //   98: invokespecial 101	io/netty/handler/codec/DecoderException:<init>	(Ljava/lang/Throwable;)V
    //   101: aload 6
    //   103: athrow
    //   104: astore 4
    //   106: aload 4
    //   108: athrow
    //   109: aload_0
    //   110: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   113: astore 4
    //   115: aload 4
    //   117: ifnull +16 -> 133
    //   120: aload 4
    //   122: invokeinterface 78 1 0
    //   127: pop
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   133: aload_3
    //   134: invokevirtual 82	io/netty/handler/codec/CodecOutputList:size	()I
    //   137: istore 5
    //   139: aload_1
    //   140: aload_3
    //   141: iload 5
    //   143: invokestatic 86	io/netty/handler/codec/ByteToMessageDecoder:fireChannelRead	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;I)V
    //   146: iload 5
    //   148: ifle +10 -> 158
    //   151: aload_1
    //   152: invokeinterface 92 1 0
    //   157: pop
    //   158: iload_2
    //   159: ifeq +10 -> 169
    //   162: aload_1
    //   163: invokeinterface 95 1 0
    //   168: pop
    //   169: aload_3
    //   170: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   173: aload 6
    //   175: athrow
    //   176: astore_1
    //   177: aload_3
    //   178: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   181: aload_1
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	ByteToMessageDecoder
    //   0	183	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	183	2	paramBoolean	boolean
    //   3	175	3	localCodecOutputList	CodecOutputList
    //   14	8	4	localByteBuf1	ByteBuf
    //   87	10	4	localException	Exception
    //   104	3	4	localDecoderException1	DecoderException
    //   113	8	4	localByteBuf2	ByteBuf
    //   38	109	5	i	int
    //   82	1	6	localObject	Object
    //   92	82	6	localDecoderException2	DecoderException
    // Exception table:
    //   from	to	target	type
    //   10	16	75	finally
    //   21	34	75	finally
    //   34	47	75	finally
    //   52	59	75	finally
    //   63	70	75	finally
    //   4	10	82	finally
    //   89	104	82	finally
    //   106	109	82	finally
    //   4	10	87	java/lang/Exception
    //   4	10	104	io/netty/handler/codec/DecoderException
    //   109	115	176	finally
    //   120	133	176	finally
    //   133	146	176	finally
    //   151	158	176	finally
    //   162	169	176	finally
  }
  
  static ByteBuf expandCumulation(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    int i = paramByteBuf1.readableBytes();
    int j = paramByteBuf2.readableBytes();
    int k = i + j;
    paramByteBufAllocator = paramByteBufAllocator.buffer(paramByteBufAllocator.calculateNewCapacity(k, Integer.MAX_VALUE));
    try
    {
      paramByteBufAllocator.setBytes(0, paramByteBuf1, paramByteBuf1.readerIndex(), i).setBytes(i, paramByteBuf2, paramByteBuf2.readerIndex(), j).writerIndex(k);
      paramByteBuf2.readerIndex(paramByteBuf2.writerIndex());
      return paramByteBufAllocator;
    }
    finally
    {
      paramByteBufAllocator.release();
    }
  }
  
  static void fireChannelRead(ChannelHandlerContext paramChannelHandlerContext, CodecOutputList paramCodecOutputList, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      paramChannelHandlerContext.fireChannelRead(paramCodecOutputList.getUnsafe(i));
    }
  }
  
  static void fireChannelRead(ChannelHandlerContext paramChannelHandlerContext, List<Object> paramList, int paramInt)
  {
    if ((paramList instanceof CodecOutputList)) {
      fireChannelRead(paramChannelHandlerContext, (CodecOutputList)paramList, paramInt);
    } else {
      for (int i = 0; i < paramInt; i++) {
        paramChannelHandlerContext.fireChannelRead(paramList.get(i));
      }
    }
  }
  
  protected int actualReadableBytes()
  {
    return internalBuffer().readableBytes();
  }
  
  protected void callDecode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
  {
    try
    {
      while (paramByteBuf.isReadable())
      {
        int i = paramList.size();
        int j = i;
        if (i > 0)
        {
          fireChannelRead(paramChannelHandlerContext, paramList, i);
          paramList.clear();
          if (!paramChannelHandlerContext.isRemoved()) {
            j = 0;
          }
        }
        else
        {
          i = paramByteBuf.readableBytes();
          decodeRemovalReentryProtection(paramChannelHandlerContext, paramByteBuf, paramList);
          if (!paramChannelHandlerContext.isRemoved()) {
            if (j == paramList.size())
            {
              if (i == paramByteBuf.readableBytes()) {
                break;
              }
            }
            else if (i != paramByteBuf.readableBytes())
            {
              if (isSingleDecode()) {
                break;
              }
            }
            else
            {
              paramChannelHandlerContext = new io/netty/handler/codec/DecoderException;
              paramByteBuf = new java/lang/StringBuilder;
              paramByteBuf.<init>();
              paramByteBuf.append(StringUtil.simpleClassName(getClass()));
              paramByteBuf.append(".decode() did not read anything but decoded a message.");
              paramChannelHandlerContext.<init>(paramByteBuf.toString());
              throw paramChannelHandlerContext;
            }
          }
        }
      }
      return;
    }
    catch (Exception paramChannelHandlerContext)
    {
      throw new DecoderException(paramChannelHandlerContext);
    }
    catch (DecoderException paramChannelHandlerContext)
    {
      throw paramChannelHandlerContext;
    }
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    channelInputClosed(paramChannelHandlerContext, true);
  }
  
  void channelInputClosed(ChannelHandlerContext paramChannelHandlerContext, List<Object> paramList)
    throws Exception
  {
    ByteBuf localByteBuf = this.cumulation;
    if (localByteBuf != null)
    {
      callDecode(paramChannelHandlerContext, localByteBuf, paramList);
      decodeLast(paramChannelHandlerContext, this.cumulation, paramList);
    }
    else
    {
      decodeLast(paramChannelHandlerContext, Unpooled.EMPTY_BUFFER, paramList);
    }
  }
  
  /* Error */
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 105
    //   4: ifeq +340 -> 344
    //   7: invokestatic 67	io/netty/handler/codec/CodecOutputList:newInstance	()Lio/netty/handler/codec/CodecOutputList;
    //   10: astore_3
    //   11: aload_0
    //   12: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   15: ifnonnull +9 -> 24
    //   18: iconst_1
    //   19: istore 4
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 4
    //   27: aload_0
    //   28: iload 4
    //   30: putfield 222	io/netty/handler/codec/ByteToMessageDecoder:first	Z
    //   33: aload_0
    //   34: getfield 46	io/netty/handler/codec/ByteToMessageDecoder:cumulator	Lio/netty/handler/codec/ByteToMessageDecoder$Cumulator;
    //   37: astore 5
    //   39: aload_1
    //   40: invokeinterface 226 1 0
    //   45: astore 6
    //   47: aload_0
    //   48: getfield 222	io/netty/handler/codec/ByteToMessageDecoder:first	Z
    //   51: ifeq +11 -> 62
    //   54: getstatic 217	io/netty/buffer/Unpooled:EMPTY_BUFFER	Lio/netty/buffer/ByteBuf;
    //   57: astore 7
    //   59: goto +9 -> 68
    //   62: aload_0
    //   63: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   66: astore 7
    //   68: aload 5
    //   70: aload 6
    //   72: aload 7
    //   74: aload_2
    //   75: checkcast 105	io/netty/buffer/ByteBuf
    //   78: invokeinterface 229 4 0
    //   83: astore_2
    //   84: aload_0
    //   85: aload_2
    //   86: putfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   89: aload_0
    //   90: aload_1
    //   91: aload_2
    //   92: aload_3
    //   93: invokevirtual 209	io/netty/handler/codec/ByteToMessageDecoder:callDecode	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Ljava/util/List;)V
    //   96: aload_0
    //   97: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   100: astore_2
    //   101: aload_2
    //   102: ifnull +33 -> 135
    //   105: aload_2
    //   106: invokevirtual 158	io/netty/buffer/ByteBuf:isReadable	()Z
    //   109: ifne +26 -> 135
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   117: aload_0
    //   118: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   121: invokeinterface 78 1 0
    //   126: pop
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   132: goto +35 -> 167
    //   135: aload_0
    //   136: getfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   139: iconst_1
    //   140: iadd
    //   141: istore 8
    //   143: aload_0
    //   144: iload 8
    //   146: putfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   149: iload 8
    //   151: aload_0
    //   152: getfield 50	io/netty/handler/codec/ByteToMessageDecoder:discardAfterReads	I
    //   155: if_icmplt +12 -> 167
    //   158: aload_0
    //   159: iconst_0
    //   160: putfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   163: aload_0
    //   164: invokevirtual 234	io/netty/handler/codec/ByteToMessageDecoder:discardSomeReadBytes	()V
    //   167: aload_3
    //   168: invokevirtual 82	io/netty/handler/codec/CodecOutputList:size	()I
    //   171: istore 8
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 236	io/netty/handler/codec/ByteToMessageDecoder:firedChannelRead	Z
    //   178: aload_3
    //   179: invokevirtual 239	io/netty/handler/codec/CodecOutputList:insertSinceRecycled	()Z
    //   182: ior
    //   183: putfield 236	io/netty/handler/codec/ByteToMessageDecoder:firedChannelRead	Z
    //   186: aload_1
    //   187: aload_3
    //   188: iload 8
    //   190: invokestatic 86	io/netty/handler/codec/ByteToMessageDecoder:fireChannelRead	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;I)V
    //   193: aload_3
    //   194: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   197: goto +155 -> 352
    //   200: astore_1
    //   201: aload_3
    //   202: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   205: aload_1
    //   206: athrow
    //   207: astore_2
    //   208: goto +20 -> 228
    //   211: astore 7
    //   213: new 59	io/netty/handler/codec/DecoderException
    //   216: astore_2
    //   217: aload_2
    //   218: aload 7
    //   220: invokespecial 101	io/netty/handler/codec/DecoderException:<init>	(Ljava/lang/Throwable;)V
    //   223: aload_2
    //   224: athrow
    //   225: astore_2
    //   226: aload_2
    //   227: athrow
    //   228: aload_0
    //   229: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   232: astore 7
    //   234: aload 7
    //   236: ifnull +37 -> 273
    //   239: aload 7
    //   241: invokevirtual 158	io/netty/buffer/ByteBuf:isReadable	()Z
    //   244: ifeq +6 -> 250
    //   247: goto +26 -> 273
    //   250: aload_0
    //   251: iconst_0
    //   252: putfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   255: aload_0
    //   256: getfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   259: invokeinterface 78 1 0
    //   264: pop
    //   265: aload_0
    //   266: aconst_null
    //   267: putfield 72	io/netty/handler/codec/ByteToMessageDecoder:cumulation	Lio/netty/buffer/ByteBuf;
    //   270: goto +35 -> 305
    //   273: aload_0
    //   274: getfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   277: iconst_1
    //   278: iadd
    //   279: istore 8
    //   281: aload_0
    //   282: iload 8
    //   284: putfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   287: iload 8
    //   289: aload_0
    //   290: getfield 50	io/netty/handler/codec/ByteToMessageDecoder:discardAfterReads	I
    //   293: if_icmplt +12 -> 305
    //   296: aload_0
    //   297: iconst_0
    //   298: putfield 231	io/netty/handler/codec/ByteToMessageDecoder:numReads	I
    //   301: aload_0
    //   302: invokevirtual 234	io/netty/handler/codec/ByteToMessageDecoder:discardSomeReadBytes	()V
    //   305: aload_3
    //   306: invokevirtual 82	io/netty/handler/codec/CodecOutputList:size	()I
    //   309: istore 8
    //   311: aload_0
    //   312: aload_0
    //   313: getfield 236	io/netty/handler/codec/ByteToMessageDecoder:firedChannelRead	Z
    //   316: aload_3
    //   317: invokevirtual 239	io/netty/handler/codec/CodecOutputList:insertSinceRecycled	()Z
    //   320: ior
    //   321: putfield 236	io/netty/handler/codec/ByteToMessageDecoder:firedChannelRead	Z
    //   324: aload_1
    //   325: aload_3
    //   326: iload 8
    //   328: invokestatic 86	io/netty/handler/codec/ByteToMessageDecoder:fireChannelRead	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/handler/codec/CodecOutputList;I)V
    //   331: aload_3
    //   332: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   335: aload_2
    //   336: athrow
    //   337: astore_1
    //   338: aload_3
    //   339: invokevirtual 98	io/netty/handler/codec/CodecOutputList:recycle	()V
    //   342: aload_1
    //   343: athrow
    //   344: aload_1
    //   345: aload_2
    //   346: invokeinterface 140 2 0
    //   351: pop
    //   352: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	ByteToMessageDecoder
    //   0	353	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	353	2	paramObject	Object
    //   10	329	3	localCodecOutputList	CodecOutputList
    //   19	10	4	bool	boolean
    //   37	32	5	localCumulator	Cumulator
    //   45	26	6	localByteBufAllocator	ByteBufAllocator
    //   57	16	7	localByteBuf1	ByteBuf
    //   211	8	7	localException	Exception
    //   232	8	7	localByteBuf2	ByteBuf
    //   141	186	8	i	int
    // Exception table:
    //   from	to	target	type
    //   96	101	200	finally
    //   105	132	200	finally
    //   135	167	200	finally
    //   167	193	200	finally
    //   11	18	207	finally
    //   27	59	207	finally
    //   62	68	207	finally
    //   68	96	207	finally
    //   213	225	207	finally
    //   226	228	207	finally
    //   11	18	211	java/lang/Exception
    //   27	59	211	java/lang/Exception
    //   62	68	211	java/lang/Exception
    //   68	96	211	java/lang/Exception
    //   11	18	225	io/netty/handler/codec/DecoderException
    //   27	59	225	io/netty/handler/codec/DecoderException
    //   62	68	225	io/netty/handler/codec/DecoderException
    //   68	96	225	io/netty/handler/codec/DecoderException
    //   228	234	337	finally
    //   239	247	337	finally
    //   250	270	337	finally
    //   273	305	337	finally
    //   305	331	337	finally
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.numReads = 0;
    discardSomeReadBytes();
    if ((!this.firedChannelRead) && (!paramChannelHandlerContext.channel().config().isAutoRead())) {
      paramChannelHandlerContext.read();
    }
    this.firedChannelRead = false;
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  protected abstract void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception;
  
  protected void decodeLast(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (paramByteBuf.isReadable()) {
      decodeRemovalReentryProtection(paramChannelHandlerContext, paramByteBuf, paramList);
    }
  }
  
  final void decodeRemovalReentryProtection(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = 1;
    int j = 1;
    this.decodeState = ((byte)1);
    try
    {
      decode(paramChannelHandlerContext, paramByteBuf, paramList);
      if (this.decodeState != 2) {
        j = 0;
      }
      this.decodeState = ((byte)0);
      if (j != 0)
      {
        fireChannelRead(paramChannelHandlerContext, paramList, paramList.size());
        paramList.clear();
        handlerRemoved(paramChannelHandlerContext);
      }
      return;
    }
    finally
    {
      if (this.decodeState == 2) {
        j = i;
      } else {
        j = 0;
      }
      this.decodeState = ((byte)0);
      if (j != 0)
      {
        fireChannelRead(paramChannelHandlerContext, paramList, paramList.size());
        paramList.clear();
        handlerRemoved(paramChannelHandlerContext);
      }
    }
  }
  
  protected final void discardSomeReadBytes()
  {
    ByteBuf localByteBuf = this.cumulation;
    if ((localByteBuf != null) && (!this.first) && (localByteBuf.refCnt() == 1)) {
      this.cumulation.discardSomeReadBytes();
    }
  }
  
  public final void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.decodeState == 1)
    {
      this.decodeState = ((byte)2);
      return;
    }
    ByteBuf localByteBuf = this.cumulation;
    if (localByteBuf != null)
    {
      this.cumulation = null;
      this.numReads = 0;
      if (localByteBuf.readableBytes() > 0)
      {
        paramChannelHandlerContext.fireChannelRead(localByteBuf);
        paramChannelHandlerContext.fireChannelReadComplete();
      }
      else
      {
        localByteBuf.release();
      }
    }
    handlerRemoved0(paramChannelHandlerContext);
  }
  
  protected void handlerRemoved0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {}
  
  protected ByteBuf internalBuffer()
  {
    ByteBuf localByteBuf = this.cumulation;
    if (localByteBuf != null) {
      return localByteBuf;
    }
    return Unpooled.EMPTY_BUFFER;
  }
  
  public boolean isSingleDecode()
  {
    return this.singleDecode;
  }
  
  public void setCumulator(Cumulator paramCumulator)
  {
    this.cumulator = ((Cumulator)ObjectUtil.checkNotNull(paramCumulator, "cumulator"));
  }
  
  public void setDiscardAfterReads(int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "discardAfterReads");
    this.discardAfterReads = paramInt;
  }
  
  public void setSingleDecode(boolean paramBoolean)
  {
    this.singleDecode = paramBoolean;
  }
  
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof ChannelInputShutdownEvent)) {
      channelInputClosed(paramChannelHandlerContext, false);
    }
    super.userEventTriggered(paramChannelHandlerContext, paramObject);
  }
  
  public static abstract interface Cumulator
  {
    public abstract ByteBuf cumulate(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\ByteToMessageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
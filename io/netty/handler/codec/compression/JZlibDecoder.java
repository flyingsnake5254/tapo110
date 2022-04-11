package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

public class JZlibDecoder
  extends ZlibDecoder
{
  private byte[] dictionary;
  private volatile boolean finished;
  private final Inflater z;
  
  public JZlibDecoder()
  {
    this(ZlibWrapper.ZLIB, 0);
  }
  
  public JZlibDecoder(int paramInt)
  {
    this(ZlibWrapper.ZLIB, paramInt);
  }
  
  public JZlibDecoder(ZlibWrapper paramZlibWrapper)
  {
    this(paramZlibWrapper, 0);
  }
  
  public JZlibDecoder(ZlibWrapper paramZlibWrapper, int paramInt)
  {
    super(paramInt);
    Inflater localInflater = new Inflater();
    this.z = localInflater;
    ObjectUtil.checkNotNull(paramZlibWrapper, "wrapper");
    paramInt = localInflater.init(ZlibUtil.convertWrapperType(paramZlibWrapper));
    if (paramInt != 0) {
      ZlibUtil.fail(localInflater, "initialization failure", paramInt);
    }
  }
  
  public JZlibDecoder(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public JZlibDecoder(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramInt);
    Inflater localInflater = new Inflater();
    this.z = localInflater;
    this.dictionary = ((byte[])ObjectUtil.checkNotNull(paramArrayOfByte, "dictionary"));
    paramInt = localInflater.inflateInit(JZlib.W_ZLIB);
    if (paramInt != 0) {
      ZlibUtil.fail(localInflater, "initialization failure", paramInt);
    }
  }
  
  /* Error */
  protected void decode(io.netty.channel.ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, java.util.List<Object> paramList)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	io/netty/handler/codec/compression/JZlibDecoder:finished	Z
    //   4: ifeq +13 -> 17
    //   7: aload_2
    //   8: aload_2
    //   9: invokevirtual 85	io/netty/buffer/ByteBuf:readableBytes	()I
    //   12: invokevirtual 89	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   15: pop
    //   16: return
    //   17: aload_2
    //   18: invokevirtual 85	io/netty/buffer/ByteBuf:readableBytes	()I
    //   21: istore 4
    //   23: iload 4
    //   25: ifne +4 -> 29
    //   28: return
    //   29: aload_0
    //   30: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   33: iload 4
    //   35: putfield 93	com/jcraft/jzlib/Inflater:avail_in	I
    //   38: aload_2
    //   39: invokevirtual 97	io/netty/buffer/ByteBuf:hasArray	()Z
    //   42: ifeq +33 -> 75
    //   45: aload_0
    //   46: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   49: aload_2
    //   50: invokevirtual 101	io/netty/buffer/ByteBuf:array	()[B
    //   53: putfield 104	com/jcraft/jzlib/Inflater:next_in	[B
    //   56: aload_0
    //   57: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   60: aload_2
    //   61: invokevirtual 107	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   64: aload_2
    //   65: invokevirtual 110	io/netty/buffer/ByteBuf:readerIndex	()I
    //   68: iadd
    //   69: putfield 113	com/jcraft/jzlib/Inflater:next_in_index	I
    //   72: goto +37 -> 109
    //   75: iload 4
    //   77: newarray <illegal type>
    //   79: astore 5
    //   81: aload_2
    //   82: aload_2
    //   83: invokevirtual 110	io/netty/buffer/ByteBuf:readerIndex	()I
    //   86: aload 5
    //   88: invokevirtual 117	io/netty/buffer/ByteBuf:getBytes	(I[B)Lio/netty/buffer/ByteBuf;
    //   91: pop
    //   92: aload_0
    //   93: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   96: aload 5
    //   98: putfield 104	com/jcraft/jzlib/Inflater:next_in	[B
    //   101: aload_0
    //   102: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   105: iconst_0
    //   106: putfield 113	com/jcraft/jzlib/Inflater:next_in_index	I
    //   109: aload_0
    //   110: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   113: getfield 113	com/jcraft/jzlib/Inflater:next_in_index	I
    //   116: istore 6
    //   118: aload_0
    //   119: aload_1
    //   120: aconst_null
    //   121: iload 4
    //   123: iconst_1
    //   124: ishl
    //   125: invokevirtual 121	io/netty/handler/codec/compression/ZlibDecoder:prepareDecompressBuffer	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;I)Lio/netty/buffer/ByteBuf;
    //   128: astore 5
    //   130: aload 5
    //   132: astore 7
    //   134: aload_0
    //   135: aload_1
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   142: getfield 93	com/jcraft/jzlib/Inflater:avail_in	I
    //   145: iconst_1
    //   146: ishl
    //   147: invokevirtual 121	io/netty/handler/codec/compression/ZlibDecoder:prepareDecompressBuffer	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;I)Lio/netty/buffer/ByteBuf;
    //   150: astore 8
    //   152: aload 8
    //   154: astore 7
    //   156: aload_0
    //   157: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   160: aload 8
    //   162: invokevirtual 124	io/netty/buffer/ByteBuf:writableBytes	()I
    //   165: putfield 127	com/jcraft/jzlib/Inflater:avail_out	I
    //   168: aload 8
    //   170: astore 7
    //   172: aload_0
    //   173: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   176: aload 8
    //   178: invokevirtual 101	io/netty/buffer/ByteBuf:array	()[B
    //   181: putfield 130	com/jcraft/jzlib/Inflater:next_out	[B
    //   184: aload 8
    //   186: astore 7
    //   188: aload_0
    //   189: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   192: aload 8
    //   194: invokevirtual 107	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   197: aload 8
    //   199: invokevirtual 133	io/netty/buffer/ByteBuf:writerIndex	()I
    //   202: iadd
    //   203: putfield 136	com/jcraft/jzlib/Inflater:next_out_index	I
    //   206: aload 8
    //   208: astore 7
    //   210: aload_0
    //   211: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   214: getfield 136	com/jcraft/jzlib/Inflater:next_out_index	I
    //   217: istore 9
    //   219: aload 8
    //   221: astore 7
    //   223: aload_0
    //   224: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   227: iconst_2
    //   228: invokevirtual 140	com/jcraft/jzlib/Inflater:inflate	(I)I
    //   231: istore 4
    //   233: aload 8
    //   235: astore 7
    //   237: aload_0
    //   238: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   241: getfield 136	com/jcraft/jzlib/Inflater:next_out_index	I
    //   244: iload 9
    //   246: isub
    //   247: istore 9
    //   249: iload 9
    //   251: ifle +21 -> 272
    //   254: aload 8
    //   256: astore 7
    //   258: aload 8
    //   260: aload 8
    //   262: invokevirtual 133	io/netty/buffer/ByteBuf:writerIndex	()I
    //   265: iload 9
    //   267: iadd
    //   268: invokevirtual 142	io/netty/buffer/ByteBuf:writerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   271: pop
    //   272: iload 4
    //   274: bipush -5
    //   276: if_icmpeq +156 -> 432
    //   279: aload 8
    //   281: astore 5
    //   283: iload 4
    //   285: ifeq -155 -> 130
    //   288: iload 4
    //   290: iconst_1
    //   291: if_icmpeq +117 -> 408
    //   294: iload 4
    //   296: iconst_2
    //   297: if_icmpeq +25 -> 322
    //   300: aload 8
    //   302: astore 7
    //   304: aload_0
    //   305: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   308: ldc -112
    //   310: iload 4
    //   312: invokestatic 56	io/netty/handler/codec/compression/ZlibUtil:fail	(Lcom/jcraft/jzlib/Inflater;Ljava/lang/String;I)V
    //   315: aload 8
    //   317: astore 5
    //   319: goto -189 -> 130
    //   322: aload 8
    //   324: astore 7
    //   326: aload_0
    //   327: getfield 64	io/netty/handler/codec/compression/JZlibDecoder:dictionary	[B
    //   330: astore 5
    //   332: aload 5
    //   334: ifnonnull +25 -> 359
    //   337: aload 8
    //   339: astore 7
    //   341: aload_0
    //   342: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   345: ldc -112
    //   347: iload 4
    //   349: invokestatic 56	io/netty/handler/codec/compression/ZlibUtil:fail	(Lcom/jcraft/jzlib/Inflater;Ljava/lang/String;I)V
    //   352: aload 8
    //   354: astore 5
    //   356: goto -226 -> 130
    //   359: aload 8
    //   361: astore 7
    //   363: aload_0
    //   364: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   367: aload 5
    //   369: aload 5
    //   371: arraylength
    //   372: invokevirtual 148	com/jcraft/jzlib/Inflater:inflateSetDictionary	([BI)I
    //   375: istore 4
    //   377: aload 8
    //   379: astore 5
    //   381: iload 4
    //   383: ifeq -253 -> 130
    //   386: aload 8
    //   388: astore 7
    //   390: aload_0
    //   391: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   394: ldc -106
    //   396: iload 4
    //   398: invokestatic 56	io/netty/handler/codec/compression/ZlibUtil:fail	(Lcom/jcraft/jzlib/Inflater;Ljava/lang/String;I)V
    //   401: aload 8
    //   403: astore 5
    //   405: goto -275 -> 130
    //   408: aload 8
    //   410: astore 7
    //   412: aload_0
    //   413: iconst_1
    //   414: putfield 79	io/netty/handler/codec/compression/JZlibDecoder:finished	Z
    //   417: aload 8
    //   419: astore 7
    //   421: aload_0
    //   422: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   425: invokevirtual 153	com/jcraft/jzlib/Inflater:inflateEnd	()I
    //   428: pop
    //   429: goto +25 -> 454
    //   432: aload 8
    //   434: astore 7
    //   436: aload_0
    //   437: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   440: getfield 93	com/jcraft/jzlib/Inflater:avail_in	I
    //   443: istore 4
    //   445: aload 8
    //   447: astore 5
    //   449: iload 4
    //   451: ifgt -321 -> 130
    //   454: aload_2
    //   455: aload_0
    //   456: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   459: getfield 113	com/jcraft/jzlib/Inflater:next_in_index	I
    //   462: iload 6
    //   464: isub
    //   465: invokevirtual 89	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   468: pop
    //   469: aload 8
    //   471: invokevirtual 156	io/netty/buffer/ByteBuf:isReadable	()Z
    //   474: ifeq +15 -> 489
    //   477: aload_3
    //   478: aload 8
    //   480: invokeinterface 162 2 0
    //   485: pop
    //   486: goto +11 -> 497
    //   489: aload 8
    //   491: invokeinterface 167 1 0
    //   496: pop
    //   497: aload_0
    //   498: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   501: aconst_null
    //   502: putfield 104	com/jcraft/jzlib/Inflater:next_in	[B
    //   505: aload_0
    //   506: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   509: aconst_null
    //   510: putfield 130	com/jcraft/jzlib/Inflater:next_out	[B
    //   513: return
    //   514: astore_1
    //   515: aload_2
    //   516: aload_0
    //   517: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   520: getfield 113	com/jcraft/jzlib/Inflater:next_in_index	I
    //   523: iload 6
    //   525: isub
    //   526: invokevirtual 89	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   529: pop
    //   530: aload 7
    //   532: invokevirtual 156	io/netty/buffer/ByteBuf:isReadable	()Z
    //   535: ifeq +15 -> 550
    //   538: aload_3
    //   539: aload 7
    //   541: invokeinterface 162 2 0
    //   546: pop
    //   547: goto +11 -> 558
    //   550: aload 7
    //   552: invokeinterface 167 1 0
    //   557: pop
    //   558: aload_1
    //   559: athrow
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   565: aconst_null
    //   566: putfield 104	com/jcraft/jzlib/Inflater:next_in	[B
    //   569: aload_0
    //   570: getfield 32	io/netty/handler/codec/compression/JZlibDecoder:z	Lcom/jcraft/jzlib/Inflater;
    //   573: aconst_null
    //   574: putfield 130	com/jcraft/jzlib/Inflater:next_out	[B
    //   577: aload_1
    //   578: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	JZlibDecoder
    //   0	579	1	paramChannelHandlerContext	io.netty.channel.ChannelHandlerContext
    //   0	579	2	paramByteBuf	ByteBuf
    //   0	579	3	paramList	java.util.List<Object>
    //   21	429	4	i	int
    //   79	369	5	localObject1	Object
    //   116	410	6	j	int
    //   132	419	7	localObject2	Object
    //   150	340	8	localByteBuf	ByteBuf
    //   217	51	9	k	int
    // Exception table:
    //   from	to	target	type
    //   134	152	514	finally
    //   156	168	514	finally
    //   172	184	514	finally
    //   188	206	514	finally
    //   210	219	514	finally
    //   223	233	514	finally
    //   237	249	514	finally
    //   258	272	514	finally
    //   304	315	514	finally
    //   326	332	514	finally
    //   341	352	514	finally
    //   363	377	514	finally
    //   390	401	514	finally
    //   412	417	514	finally
    //   421	429	514	finally
    //   436	445	514	finally
    //   29	72	560	finally
    //   75	109	560	finally
    //   109	130	560	finally
    //   454	486	560	finally
    //   489	497	560	finally
    //   515	547	560	finally
    //   550	558	560	finally
    //   558	560	560	finally
  }
  
  protected void decompressionBufferExhausted(ByteBuf paramByteBuf)
  {
    this.finished = true;
  }
  
  public boolean isClosed()
  {
    return this.finished;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\JZlibDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

public class Lz4FrameDecoder
  extends ByteToMessageDecoder
{
  private int blockType;
  private ByteBufChecksum checksum;
  private int compressedLength;
  private int currentChecksum;
  private State currentState = State.INIT_BLOCK;
  private int decompressedLength;
  private LZ4FastDecompressor decompressor;
  
  public Lz4FrameDecoder()
  {
    this(false);
  }
  
  public Lz4FrameDecoder(LZ4Factory paramLZ4Factory, Checksum paramChecksum)
  {
    this.decompressor = ((LZ4Factory)ObjectUtil.checkNotNull(paramLZ4Factory, "factory")).fastDecompressor();
    if (paramChecksum == null) {
      paramLZ4Factory = null;
    } else {
      paramLZ4Factory = ByteBufChecksum.wrapChecksum(paramChecksum);
    }
    this.checksum = paramLZ4Factory;
  }
  
  public Lz4FrameDecoder(LZ4Factory paramLZ4Factory, boolean paramBoolean)
  {
    this(paramLZ4Factory, localLz4XXHash32);
  }
  
  public Lz4FrameDecoder(boolean paramBoolean)
  {
    this(LZ4Factory.fastestInstance(), paramBoolean);
  }
  
  /* Error */
  protected void decode(io.netty.channel.ChannelHandlerContext paramChannelHandlerContext, io.netty.buffer.ByteBuf paramByteBuf, java.util.List<Object> paramList)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: getstatic 83	io/netty/handler/codec/compression/Lz4FrameDecoder$1:$SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State	[I
    //   3: aload_0
    //   4: getfield 34	io/netty/handler/codec/compression/Lz4FrameDecoder:currentState	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   7: invokevirtual 89	java/lang/Enum:ordinal	()I
    //   10: iaload
    //   11: istore 4
    //   13: aconst_null
    //   14: astore 5
    //   16: aconst_null
    //   17: astore 6
    //   19: iload 4
    //   21: iconst_1
    //   22: if_icmpeq +46 -> 68
    //   25: iload 4
    //   27: iconst_2
    //   28: if_icmpeq +290 -> 318
    //   31: iload 4
    //   33: iconst_3
    //   34: if_icmpeq +22 -> 56
    //   37: iload 4
    //   39: iconst_4
    //   40: if_icmpne +6 -> 46
    //   43: goto +13 -> 56
    //   46: new 91	java/lang/IllegalStateException
    //   49: astore_1
    //   50: aload_1
    //   51: invokespecial 92	java/lang/IllegalStateException:<init>	()V
    //   54: aload_1
    //   55: athrow
    //   56: aload_2
    //   57: aload_2
    //   58: invokevirtual 97	io/netty/buffer/ByteBuf:readableBytes	()I
    //   61: invokevirtual 101	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   64: pop
    //   65: goto +519 -> 584
    //   68: aload_2
    //   69: invokevirtual 97	io/netty/buffer/ByteBuf:readableBytes	()I
    //   72: bipush 21
    //   74: if_icmpge +6 -> 80
    //   77: goto +507 -> 584
    //   80: aload_2
    //   81: invokevirtual 105	io/netty/buffer/ByteBuf:readLong	()J
    //   84: ldc2_w 106
    //   87: lcmp
    //   88: ifne +610 -> 698
    //   91: aload_2
    //   92: invokevirtual 111	io/netty/buffer/ByteBuf:readByte	()B
    //   95: istore 7
    //   97: iload 7
    //   99: sipush 240
    //   102: iand
    //   103: istore 4
    //   105: aload_2
    //   106: invokevirtual 114	io/netty/buffer/ByteBuf:readInt	()I
    //   109: invokestatic 120	java/lang/Integer:reverseBytes	(I)I
    //   112: istore 8
    //   114: iload 8
    //   116: iflt +547 -> 663
    //   119: iload 8
    //   121: ldc 121
    //   123: if_icmpgt +540 -> 663
    //   126: aload_2
    //   127: invokevirtual 114	io/netty/buffer/ByteBuf:readInt	()I
    //   130: invokestatic 120	java/lang/Integer:reverseBytes	(I)I
    //   133: istore 9
    //   135: iconst_1
    //   136: iload 7
    //   138: bipush 15
    //   140: iand
    //   141: bipush 10
    //   143: iadd
    //   144: ishl
    //   145: istore 7
    //   147: iload 9
    //   149: iflt +479 -> 628
    //   152: iload 9
    //   154: iload 7
    //   156: if_icmpgt +472 -> 628
    //   159: iload 9
    //   161: ifne +8 -> 169
    //   164: iload 8
    //   166: ifne +30 -> 196
    //   169: iload 9
    //   171: ifeq +8 -> 179
    //   174: iload 8
    //   176: ifeq +20 -> 196
    //   179: iload 4
    //   181: bipush 16
    //   183: if_icmpne +48 -> 231
    //   186: iload 9
    //   188: iload 8
    //   190: if_icmpne +6 -> 196
    //   193: goto +38 -> 231
    //   196: new 123	io/netty/handler/codec/compression/DecompressionException
    //   199: astore_1
    //   200: aload_1
    //   201: ldc 125
    //   203: iconst_2
    //   204: anewarray 127	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: iload 8
    //   211: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: iload 9
    //   219: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: invokestatic 137	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   226: invokespecial 140	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;)V
    //   229: aload_1
    //   230: athrow
    //   231: aload_2
    //   232: invokevirtual 114	io/netty/buffer/ByteBuf:readInt	()I
    //   235: invokestatic 120	java/lang/Integer:reverseBytes	(I)I
    //   238: istore 7
    //   240: iload 9
    //   242: ifne +45 -> 287
    //   245: iload 8
    //   247: ifne +40 -> 287
    //   250: iload 7
    //   252: ifne +23 -> 275
    //   255: aload_0
    //   256: getstatic 143	io/netty/handler/codec/compression/Lz4FrameDecoder$State:FINISHED	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   259: putfield 34	io/netty/handler/codec/compression/Lz4FrameDecoder:currentState	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   262: aload_0
    //   263: aconst_null
    //   264: putfield 50	io/netty/handler/codec/compression/Lz4FrameDecoder:decompressor	Lnet/jpountz/lz4/LZ4FastDecompressor;
    //   267: aload_0
    //   268: aconst_null
    //   269: putfield 58	io/netty/handler/codec/compression/Lz4FrameDecoder:checksum	Lio/netty/handler/codec/compression/ByteBufChecksum;
    //   272: goto +312 -> 584
    //   275: new 123	io/netty/handler/codec/compression/DecompressionException
    //   278: astore_1
    //   279: aload_1
    //   280: ldc -111
    //   282: invokespecial 140	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;)V
    //   285: aload_1
    //   286: athrow
    //   287: aload_0
    //   288: iload 4
    //   290: putfield 147	io/netty/handler/codec/compression/Lz4FrameDecoder:blockType	I
    //   293: aload_0
    //   294: iload 8
    //   296: putfield 149	io/netty/handler/codec/compression/Lz4FrameDecoder:compressedLength	I
    //   299: aload_0
    //   300: iload 9
    //   302: putfield 151	io/netty/handler/codec/compression/Lz4FrameDecoder:decompressedLength	I
    //   305: aload_0
    //   306: iload 7
    //   308: putfield 153	io/netty/handler/codec/compression/Lz4FrameDecoder:currentChecksum	I
    //   311: aload_0
    //   312: getstatic 156	io/netty/handler/codec/compression/Lz4FrameDecoder$State:DECOMPRESS_DATA	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   315: putfield 34	io/netty/handler/codec/compression/Lz4FrameDecoder:currentState	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   318: aload_0
    //   319: getfield 147	io/netty/handler/codec/compression/Lz4FrameDecoder:blockType	I
    //   322: istore 9
    //   324: aload_0
    //   325: getfield 149	io/netty/handler/codec/compression/Lz4FrameDecoder:compressedLength	I
    //   328: istore 4
    //   330: aload_0
    //   331: getfield 151	io/netty/handler/codec/compression/Lz4FrameDecoder:decompressedLength	I
    //   334: istore 8
    //   336: aload_0
    //   337: getfield 153	io/netty/handler/codec/compression/Lz4FrameDecoder:currentChecksum	I
    //   340: istore 7
    //   342: aload_2
    //   343: invokevirtual 97	io/netty/buffer/ByteBuf:readableBytes	()I
    //   346: iload 4
    //   348: if_icmpge +6 -> 354
    //   351: goto +233 -> 584
    //   354: aload_0
    //   355: getfield 58	io/netty/handler/codec/compression/Lz4FrameDecoder:checksum	Lio/netty/handler/codec/compression/ByteBufChecksum;
    //   358: astore 10
    //   360: iload 9
    //   362: bipush 16
    //   364: if_icmpeq +148 -> 512
    //   367: iload 9
    //   369: bipush 32
    //   371: if_icmpne +86 -> 457
    //   374: aload 6
    //   376: astore 11
    //   378: aload_1
    //   379: invokeinterface 162 1 0
    //   384: iload 8
    //   386: iload 8
    //   388: invokeinterface 168 3 0
    //   393: astore_1
    //   394: aload_1
    //   395: astore 12
    //   397: aload_1
    //   398: astore 11
    //   400: aload_0
    //   401: getfield 50	io/netty/handler/codec/compression/Lz4FrameDecoder:decompressor	Lnet/jpountz/lz4/LZ4FastDecompressor;
    //   404: aload_2
    //   405: invokestatic 174	io/netty/handler/codec/compression/CompressionUtil:safeNioBuffer	(Lio/netty/buffer/ByteBuf;)Ljava/nio/ByteBuffer;
    //   408: aload_1
    //   409: aload_1
    //   410: invokevirtual 177	io/netty/buffer/ByteBuf:writerIndex	()I
    //   413: iload 8
    //   415: invokevirtual 181	io/netty/buffer/ByteBuf:internalNioBuffer	(II)Ljava/nio/ByteBuffer;
    //   418: invokevirtual 187	net/jpountz/lz4/LZ4FastDecompressor:decompress	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)V
    //   421: aload_1
    //   422: astore 12
    //   424: aload_1
    //   425: astore 11
    //   427: aload_1
    //   428: aload_1
    //   429: invokevirtual 177	io/netty/buffer/ByteBuf:writerIndex	()I
    //   432: iload 8
    //   434: iadd
    //   435: invokevirtual 189	io/netty/buffer/ByteBuf:writerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   438: pop
    //   439: goto +88 -> 527
    //   442: astore_1
    //   443: aload 12
    //   445: astore 11
    //   447: goto +166 -> 613
    //   450: astore_2
    //   451: aload 11
    //   453: astore_1
    //   454: goto +139 -> 593
    //   457: aload 6
    //   459: astore 11
    //   461: new 123	io/netty/handler/codec/compression/DecompressionException
    //   464: astore_1
    //   465: aload 6
    //   467: astore 11
    //   469: aload_1
    //   470: ldc -65
    //   472: iconst_3
    //   473: anewarray 127	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: iload 9
    //   480: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: aastore
    //   484: dup
    //   485: iconst_1
    //   486: bipush 16
    //   488: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: aastore
    //   492: dup
    //   493: iconst_2
    //   494: bipush 32
    //   496: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: invokestatic 137	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   503: invokespecial 140	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;)V
    //   506: aload 6
    //   508: astore 11
    //   510: aload_1
    //   511: athrow
    //   512: aload 6
    //   514: astore 11
    //   516: aload_2
    //   517: aload_2
    //   518: invokevirtual 194	io/netty/buffer/ByteBuf:readerIndex	()I
    //   521: iload 8
    //   523: invokevirtual 197	io/netty/buffer/ByteBuf:retainedSlice	(II)Lio/netty/buffer/ByteBuf;
    //   526: astore_1
    //   527: aload_1
    //   528: astore 12
    //   530: aload_1
    //   531: astore 11
    //   533: aload_2
    //   534: iload 4
    //   536: invokevirtual 101	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   539: pop
    //   540: aload 10
    //   542: ifnull +17 -> 559
    //   545: aload_1
    //   546: astore 12
    //   548: aload_1
    //   549: astore 11
    //   551: aload 10
    //   553: aload_1
    //   554: iload 7
    //   556: invokestatic 201	io/netty/handler/codec/compression/CompressionUtil:checkChecksum	(Lio/netty/handler/codec/compression/ByteBufChecksum;Lio/netty/buffer/ByteBuf;I)V
    //   559: aload_1
    //   560: astore 12
    //   562: aload_1
    //   563: astore 11
    //   565: aload_3
    //   566: aload_1
    //   567: invokeinterface 207 2 0
    //   572: pop
    //   573: aload 6
    //   575: astore 11
    //   577: aload_0
    //   578: getstatic 32	io/netty/handler/codec/compression/Lz4FrameDecoder$State:INIT_BLOCK	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   581: putfield 34	io/netty/handler/codec/compression/Lz4FrameDecoder:currentState	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   584: return
    //   585: astore_1
    //   586: goto +27 -> 613
    //   589: astore_2
    //   590: aload 5
    //   592: astore_1
    //   593: aload_1
    //   594: astore 11
    //   596: new 123	io/netty/handler/codec/compression/DecompressionException
    //   599: astore_3
    //   600: aload_1
    //   601: astore 11
    //   603: aload_3
    //   604: aload_2
    //   605: invokespecial 210	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/Throwable;)V
    //   608: aload_1
    //   609: astore 11
    //   611: aload_3
    //   612: athrow
    //   613: aload 11
    //   615: ifnull +11 -> 626
    //   618: aload 11
    //   620: invokeinterface 216 1 0
    //   625: pop
    //   626: aload_1
    //   627: athrow
    //   628: new 123	io/netty/handler/codec/compression/DecompressionException
    //   631: astore_1
    //   632: aload_1
    //   633: ldc -38
    //   635: iconst_2
    //   636: anewarray 127	java/lang/Object
    //   639: dup
    //   640: iconst_0
    //   641: iload 9
    //   643: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   646: aastore
    //   647: dup
    //   648: iconst_1
    //   649: iload 7
    //   651: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   654: aastore
    //   655: invokestatic 137	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   658: invokespecial 140	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;)V
    //   661: aload_1
    //   662: athrow
    //   663: new 123	io/netty/handler/codec/compression/DecompressionException
    //   666: astore_1
    //   667: aload_1
    //   668: ldc -36
    //   670: iconst_2
    //   671: anewarray 127	java/lang/Object
    //   674: dup
    //   675: iconst_0
    //   676: iload 8
    //   678: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   681: aastore
    //   682: dup
    //   683: iconst_1
    //   684: ldc 121
    //   686: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   689: aastore
    //   690: invokestatic 137	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   693: invokespecial 140	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;)V
    //   696: aload_1
    //   697: athrow
    //   698: new 123	io/netty/handler/codec/compression/DecompressionException
    //   701: astore_1
    //   702: aload_1
    //   703: ldc -34
    //   705: invokespecial 140	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;)V
    //   708: aload_1
    //   709: athrow
    //   710: astore_1
    //   711: aload_0
    //   712: getstatic 225	io/netty/handler/codec/compression/Lz4FrameDecoder$State:CORRUPTED	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   715: putfield 34	io/netty/handler/codec/compression/Lz4FrameDecoder:currentState	Lio/netty/handler/codec/compression/Lz4FrameDecoder$State;
    //   718: aload_1
    //   719: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	this	Lz4FrameDecoder
    //   0	720	1	paramChannelHandlerContext	io.netty.channel.ChannelHandlerContext
    //   0	720	2	paramByteBuf	io.netty.buffer.ByteBuf
    //   0	720	3	paramList	java.util.List<Object>
    //   11	524	4	i	int
    //   14	577	5	localObject1	Object
    //   17	557	6	localObject2	Object
    //   95	555	7	j	int
    //   112	565	8	k	int
    //   133	509	9	m	int
    //   358	194	10	localByteBufChecksum	ByteBufChecksum
    //   376	243	11	localObject3	Object
    //   395	166	12	localChannelHandlerContext	io.netty.channel.ChannelHandlerContext
    // Exception table:
    //   from	to	target	type
    //   400	421	442	finally
    //   427	439	442	finally
    //   533	540	442	finally
    //   551	559	442	finally
    //   565	573	442	finally
    //   400	421	450	net/jpountz/lz4/LZ4Exception
    //   427	439	450	net/jpountz/lz4/LZ4Exception
    //   533	540	450	net/jpountz/lz4/LZ4Exception
    //   551	559	450	net/jpountz/lz4/LZ4Exception
    //   565	573	450	net/jpountz/lz4/LZ4Exception
    //   378	394	585	finally
    //   461	465	585	finally
    //   469	506	585	finally
    //   510	512	585	finally
    //   516	527	585	finally
    //   577	584	585	finally
    //   596	600	585	finally
    //   603	608	585	finally
    //   611	613	585	finally
    //   378	394	589	net/jpountz/lz4/LZ4Exception
    //   461	465	589	net/jpountz/lz4/LZ4Exception
    //   469	506	589	net/jpountz/lz4/LZ4Exception
    //   510	512	589	net/jpountz/lz4/LZ4Exception
    //   516	527	589	net/jpountz/lz4/LZ4Exception
    //   577	584	589	net/jpountz/lz4/LZ4Exception
    //   0	13	710	java/lang/Exception
    //   46	56	710	java/lang/Exception
    //   56	65	710	java/lang/Exception
    //   68	77	710	java/lang/Exception
    //   80	97	710	java/lang/Exception
    //   105	114	710	java/lang/Exception
    //   126	135	710	java/lang/Exception
    //   196	231	710	java/lang/Exception
    //   231	240	710	java/lang/Exception
    //   255	272	710	java/lang/Exception
    //   275	287	710	java/lang/Exception
    //   287	318	710	java/lang/Exception
    //   318	351	710	java/lang/Exception
    //   354	360	710	java/lang/Exception
    //   618	626	710	java/lang/Exception
    //   626	628	710	java/lang/Exception
    //   628	663	710	java/lang/Exception
    //   663	698	710	java/lang/Exception
    //   698	710	710	java/lang/Exception
  }
  
  public boolean isClosed()
  {
    boolean bool;
    if (this.currentState == State.FINISHED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("INIT_BLOCK", 0);
      INIT_BLOCK = localState1;
      State localState2 = new State("DECOMPRESS_DATA", 1);
      DECOMPRESS_DATA = localState2;
      State localState3 = new State("FINISHED", 2);
      FINISHED = localState3;
      State localState4 = new State("CORRUPTED", 3);
      CORRUPTED = localState4;
      $VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\Lz4FrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
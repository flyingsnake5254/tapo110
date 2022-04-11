package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.util.zip.Inflater;

public class JdkZlibDecoder
  extends ZlibDecoder
{
  private static final int FCOMMENT = 16;
  private static final int FEXTRA = 4;
  private static final int FHCRC = 2;
  private static final int FNAME = 8;
  private static final int FRESERVED = 224;
  private final ByteBufChecksum crc;
  private boolean decideZlibOrNone;
  private final boolean decompressConcatenated;
  private final byte[] dictionary;
  private volatile boolean finished;
  private int flags = -1;
  private GzipState gzipState = GzipState.HEADER_START;
  private Inflater inflater;
  private int xlen = -1;
  
  public JdkZlibDecoder()
  {
    this(ZlibWrapper.ZLIB, null, false, 0);
  }
  
  public JdkZlibDecoder(int paramInt)
  {
    this(ZlibWrapper.ZLIB, null, false, paramInt);
  }
  
  public JdkZlibDecoder(ZlibWrapper paramZlibWrapper)
  {
    this(paramZlibWrapper, null, false, 0);
  }
  
  public JdkZlibDecoder(ZlibWrapper paramZlibWrapper, int paramInt)
  {
    this(paramZlibWrapper, null, false, paramInt);
  }
  
  public JdkZlibDecoder(ZlibWrapper paramZlibWrapper, boolean paramBoolean)
  {
    this(paramZlibWrapper, null, paramBoolean, 0);
  }
  
  public JdkZlibDecoder(ZlibWrapper paramZlibWrapper, boolean paramBoolean, int paramInt)
  {
    this(paramZlibWrapper, null, paramBoolean, paramInt);
  }
  
  private JdkZlibDecoder(ZlibWrapper paramZlibWrapper, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    super(paramInt);
    ObjectUtil.checkNotNull(paramZlibWrapper, "wrapper");
    this.decompressConcatenated = paramBoolean;
    paramInt = 1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[paramZlibWrapper.ordinal()];
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            this.decideZlibOrNone = true;
            this.crc = null;
          }
          else
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("Only GZIP or ZLIB is supported, but you used ");
            paramArrayOfByte.append(paramZlibWrapper);
            throw new IllegalArgumentException(paramArrayOfByte.toString());
          }
        }
        else
        {
          this.inflater = new Inflater();
          this.crc = null;
        }
      }
      else
      {
        this.inflater = new Inflater(true);
        this.crc = null;
      }
    }
    else
    {
      this.inflater = new Inflater(true);
      this.crc = ByteBufChecksum.wrapChecksum(new CRC32());
    }
    this.dictionary = paramArrayOfByte;
  }
  
  public JdkZlibDecoder(boolean paramBoolean)
  {
    this(ZlibWrapper.GZIP, null, paramBoolean, 0);
  }
  
  public JdkZlibDecoder(boolean paramBoolean, int paramInt)
  {
    this(ZlibWrapper.GZIP, null, paramBoolean, paramInt);
  }
  
  public JdkZlibDecoder(byte[] paramArrayOfByte)
  {
    this(ZlibWrapper.ZLIB, paramArrayOfByte, false, 0);
  }
  
  public JdkZlibDecoder(byte[] paramArrayOfByte, int paramInt)
  {
    this(ZlibWrapper.ZLIB, paramArrayOfByte, false, paramInt);
  }
  
  private static boolean looksLikeZlib(short paramShort)
  {
    boolean bool;
    if (((paramShort & 0x7800) == 30720) && (paramShort % 31 == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean readGZIPFooter(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    int j = 0;
    if (i < 8) {
      return false;
    }
    verifyCrc(paramByteBuf);
    i = 0;
    while (j < 4)
    {
      i |= paramByteBuf.readUnsignedByte() << j * 8;
      j++;
    }
    j = this.inflater.getTotalOut();
    if (i == j) {
      return true;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("Number of bytes mismatch. Expected: ");
    paramByteBuf.append(i);
    paramByteBuf.append(", Got: ");
    paramByteBuf.append(j);
    throw new DecompressionException(paramByteBuf.toString());
  }
  
  private boolean readGZIPHeader(ByteBuf paramByteBuf)
  {
    int i;
    int j;
    switch (1.$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[this.gzipState.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 2: 
      if (paramByteBuf.readableBytes() < 10) {
        return false;
      }
      i = paramByteBuf.readByte();
      j = paramByteBuf.readByte();
      if (i != 31) {
        break label537;
      }
      this.crc.update(i);
      this.crc.update(j);
      j = paramByteBuf.readUnsignedByte();
      if (j != 8) {
        break label497;
      }
      this.crc.update(j);
      j = paramByteBuf.readUnsignedByte();
      this.flags = j;
      this.crc.update(j);
      if ((this.flags & 0xE0) == 0)
      {
        this.crc.update(paramByteBuf, paramByteBuf.readerIndex(), 4);
        paramByteBuf.skipBytes(4);
        this.crc.update(paramByteBuf.readUnsignedByte());
        this.crc.update(paramByteBuf.readUnsignedByte());
        this.gzipState = GzipState.FLG_READ;
      }
      break;
    case 3: 
      if ((this.flags & 0x4) != 0)
      {
        if (paramByteBuf.readableBytes() < 2) {
          return false;
        }
        i = paramByteBuf.readUnsignedByte();
        j = paramByteBuf.readUnsignedByte();
        this.crc.update(i);
        this.crc.update(j);
        this.xlen = (i << 8 | j | this.xlen);
      }
      this.gzipState = GzipState.XLEN_READ;
    case 4: 
      if (this.xlen != -1)
      {
        if (paramByteBuf.readableBytes() < this.xlen) {
          return false;
        }
        this.crc.update(paramByteBuf, paramByteBuf.readerIndex(), this.xlen);
        paramByteBuf.skipBytes(this.xlen);
      }
      this.gzipState = GzipState.SKIP_FNAME;
    case 5: 
      if ((this.flags & 0x8) != 0)
      {
        if (!paramByteBuf.isReadable()) {
          return false;
        }
        do
        {
          j = paramByteBuf.readUnsignedByte();
          this.crc.update(j);
        } while ((j != 0) && (paramByteBuf.isReadable()));
      }
      this.gzipState = GzipState.SKIP_COMMENT;
    case 6: 
      if ((this.flags & 0x10) != 0)
      {
        if (!paramByteBuf.isReadable()) {
          return false;
        }
        do
        {
          j = paramByteBuf.readUnsignedByte();
          this.crc.update(j);
        } while ((j != 0) && (paramByteBuf.isReadable()));
      }
      this.gzipState = GzipState.PROCESS_FHCRC;
    case 7: 
      if ((this.flags & 0x2) != 0)
      {
        if (paramByteBuf.readableBytes() < 4) {
          return false;
        }
        verifyCrc(paramByteBuf);
      }
      this.crc.reset();
      this.gzipState = GzipState.HEADER_END;
    case 8: 
      return true;
    }
    throw new DecompressionException("Reserved flags are set in the GZIP header");
    label497:
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("Unsupported compression method ");
    paramByteBuf.append(j);
    paramByteBuf.append(" in the GZIP header");
    throw new DecompressionException(paramByteBuf.toString());
    label537:
    throw new DecompressionException("Input is not in the GZIP format");
  }
  
  private void verifyCrc(ByteBuf paramByteBuf)
  {
    long l1 = 0L;
    for (int i = 0; i < 4; i++) {
      l1 |= paramByteBuf.readUnsignedByte() << i * 8;
    }
    long l2 = this.crc.getValue();
    if (l1 == l2) {
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("CRC value mismatch. Expected: ");
    paramByteBuf.append(l1);
    paramByteBuf.append(", Got: ");
    paramByteBuf.append(l2);
    throw new DecompressionException(paramByteBuf.toString());
  }
  
  /* Error */
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, java.util.List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 239	io/netty/handler/codec/compression/JdkZlibDecoder:finished	Z
    //   4: ifeq +13 -> 17
    //   7: aload_2
    //   8: aload_2
    //   9: invokevirtual 142	io/netty/buffer/ByteBuf:readableBytes	()I
    //   12: invokevirtual 189	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   15: pop
    //   16: return
    //   17: aload_2
    //   18: invokevirtual 142	io/netty/buffer/ByteBuf:readableBytes	()I
    //   21: istore 4
    //   23: iload 4
    //   25: ifne +4 -> 29
    //   28: return
    //   29: aload_0
    //   30: getfield 84	io/netty/handler/codec/compression/JdkZlibDecoder:decideZlibOrNone	Z
    //   33: istore 5
    //   35: iconst_0
    //   36: istore 6
    //   38: iload 5
    //   40: ifeq +39 -> 79
    //   43: iload 4
    //   45: iconst_2
    //   46: if_icmpge +4 -> 50
    //   49: return
    //   50: aload_0
    //   51: new 110	java/util/zip/Inflater
    //   54: dup
    //   55: aload_2
    //   56: aload_2
    //   57: invokevirtual 182	io/netty/buffer/ByteBuf:readerIndex	()I
    //   60: invokevirtual 243	io/netty/buffer/ByteBuf:getShort	(I)S
    //   63: invokestatic 245	io/netty/handler/codec/compression/JdkZlibDecoder:looksLikeZlib	(S)Z
    //   66: iconst_1
    //   67: ixor
    //   68: invokespecial 116	java/util/zip/Inflater:<init>	(Z)V
    //   71: putfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 84	io/netty/handler/codec/compression/JdkZlibDecoder:decideZlibOrNone	Z
    //   79: aload_0
    //   80: getfield 86	io/netty/handler/codec/compression/JdkZlibDecoder:crc	Lio/netty/handler/codec/compression/ByteBufChecksum;
    //   83: ifnull +60 -> 143
    //   86: getstatic 167	io/netty/handler/codec/compression/JdkZlibDecoder$1:$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState	[I
    //   89: aload_0
    //   90: getfield 58	io/netty/handler/codec/compression/JdkZlibDecoder:gzipState	Lio/netty/handler/codec/compression/JdkZlibDecoder$GzipState;
    //   93: invokevirtual 82	java/lang/Enum:ordinal	()I
    //   96: iaload
    //   97: iconst_1
    //   98: if_icmpeq +31 -> 129
    //   101: aload_0
    //   102: getfield 58	io/netty/handler/codec/compression/JdkZlibDecoder:gzipState	Lio/netty/handler/codec/compression/JdkZlibDecoder$GzipState;
    //   105: getstatic 214	io/netty/handler/codec/compression/JdkZlibDecoder$GzipState:HEADER_END	Lio/netty/handler/codec/compression/JdkZlibDecoder$GzipState;
    //   108: if_acmpeq +12 -> 120
    //   111: aload_0
    //   112: aload_2
    //   113: invokespecial 247	io/netty/handler/codec/compression/JdkZlibDecoder:readGZIPHeader	(Lio/netty/buffer/ByteBuf;)Z
    //   116: ifne +4 -> 120
    //   119: return
    //   120: aload_2
    //   121: invokevirtual 142	io/netty/buffer/ByteBuf:readableBytes	()I
    //   124: istore 4
    //   126: goto +17 -> 143
    //   129: aload_0
    //   130: aload_2
    //   131: invokespecial 249	io/netty/handler/codec/compression/JdkZlibDecoder:readGZIPFooter	(Lio/netty/buffer/ByteBuf;)Z
    //   134: ifeq +8 -> 142
    //   137: aload_0
    //   138: iconst_1
    //   139: putfield 239	io/netty/handler/codec/compression/JdkZlibDecoder:finished	Z
    //   142: return
    //   143: aload_2
    //   144: invokevirtual 252	io/netty/buffer/ByteBuf:hasArray	()Z
    //   147: ifeq +28 -> 175
    //   150: aload_0
    //   151: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   154: aload_2
    //   155: invokevirtual 256	io/netty/buffer/ByteBuf:array	()[B
    //   158: aload_2
    //   159: invokevirtual 259	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   162: aload_2
    //   163: invokevirtual 182	io/netty/buffer/ByteBuf:readerIndex	()I
    //   166: iadd
    //   167: iload 4
    //   169: invokevirtual 263	java/util/zip/Inflater:setInput	([BII)V
    //   172: goto +29 -> 201
    //   175: iload 4
    //   177: newarray <illegal type>
    //   179: astore 7
    //   181: aload_2
    //   182: aload_2
    //   183: invokevirtual 182	io/netty/buffer/ByteBuf:readerIndex	()I
    //   186: aload 7
    //   188: invokevirtual 267	io/netty/buffer/ByteBuf:getBytes	(I[B)Lio/netty/buffer/ByteBuf;
    //   191: pop
    //   192: aload_0
    //   193: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   196: aload 7
    //   198: invokevirtual 269	java/util/zip/Inflater:setInput	([B)V
    //   201: aload_0
    //   202: aload_1
    //   203: aconst_null
    //   204: aload_0
    //   205: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   208: invokevirtual 272	java/util/zip/Inflater:getRemaining	()I
    //   211: iconst_1
    //   212: ishl
    //   213: invokevirtual 276	io/netty/handler/codec/compression/ZlibDecoder:prepareDecompressBuffer	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;I)Lio/netty/buffer/ByteBuf;
    //   216: astore 7
    //   218: aload_0
    //   219: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   222: invokevirtual 279	java/util/zip/Inflater:needsInput	()Z
    //   225: ifne +190 -> 415
    //   228: aload 7
    //   230: invokevirtual 256	io/netty/buffer/ByteBuf:array	()[B
    //   233: astore 8
    //   235: aload 7
    //   237: invokevirtual 282	io/netty/buffer/ByteBuf:writerIndex	()I
    //   240: istore 9
    //   242: aload 7
    //   244: invokevirtual 259	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   247: iload 9
    //   249: iadd
    //   250: istore 10
    //   252: aload_0
    //   253: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   256: aload 8
    //   258: iload 10
    //   260: aload 7
    //   262: invokevirtual 285	io/netty/buffer/ByteBuf:writableBytes	()I
    //   265: invokevirtual 289	java/util/zip/Inflater:inflate	([BII)I
    //   268: istore 11
    //   270: iload 11
    //   272: ifle +41 -> 313
    //   275: aload 7
    //   277: iload 9
    //   279: iload 11
    //   281: iadd
    //   282: invokevirtual 291	io/netty/buffer/ByteBuf:writerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   285: pop
    //   286: aload_0
    //   287: getfield 86	io/netty/handler/codec/compression/JdkZlibDecoder:crc	Lio/netty/handler/codec/compression/ByteBufChecksum;
    //   290: astore 12
    //   292: aload 12
    //   294: ifnull +65 -> 359
    //   297: aload 12
    //   299: aload 8
    //   301: iload 10
    //   303: iload 11
    //   305: invokeinterface 293 4 0
    //   310: goto +49 -> 359
    //   313: aload_0
    //   314: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   317: invokevirtual 296	java/util/zip/Inflater:needsDictionary	()Z
    //   320: ifeq +39 -> 359
    //   323: aload_0
    //   324: getfield 127	io/netty/handler/codec/compression/JdkZlibDecoder:dictionary	[B
    //   327: astore 8
    //   329: aload 8
    //   331: ifnull +15 -> 346
    //   334: aload_0
    //   335: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   338: aload 8
    //   340: invokevirtual 299	java/util/zip/Inflater:setDictionary	([B)V
    //   343: goto +16 -> 359
    //   346: new 162	io/netty/handler/codec/compression/DecompressionException
    //   349: astore_1
    //   350: aload_1
    //   351: ldc_w 301
    //   354: invokespecial 163	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;)V
    //   357: aload_1
    //   358: athrow
    //   359: aload_0
    //   360: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   363: invokevirtual 303	java/util/zip/Inflater:finished	()Z
    //   366: ifeq +24 -> 390
    //   369: aload_0
    //   370: getfield 86	io/netty/handler/codec/compression/JdkZlibDecoder:crc	Lio/netty/handler/codec/compression/ByteBufChecksum;
    //   373: ifnonnull +11 -> 384
    //   376: aload_0
    //   377: iconst_1
    //   378: putfield 239	io/netty/handler/codec/compression/JdkZlibDecoder:finished	Z
    //   381: goto +34 -> 415
    //   384: iconst_1
    //   385: istore 9
    //   387: goto +31 -> 418
    //   390: aload_0
    //   391: aload_1
    //   392: aload 7
    //   394: aload_0
    //   395: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   398: invokevirtual 272	java/util/zip/Inflater:getRemaining	()I
    //   401: iconst_1
    //   402: ishl
    //   403: invokevirtual 276	io/netty/handler/codec/compression/ZlibDecoder:prepareDecompressBuffer	(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;I)Lio/netty/buffer/ByteBuf;
    //   406: astore 8
    //   408: aload 8
    //   410: astore 7
    //   412: goto -194 -> 218
    //   415: iconst_0
    //   416: istore 9
    //   418: aload_2
    //   419: iload 4
    //   421: aload_0
    //   422: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   425: invokevirtual 272	java/util/zip/Inflater:getRemaining	()I
    //   428: isub
    //   429: invokevirtual 189	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   432: pop
    //   433: iload 9
    //   435: ifeq +64 -> 499
    //   438: aload_0
    //   439: getstatic 306	io/netty/handler/codec/compression/JdkZlibDecoder$GzipState:FOOTER_START	Lio/netty/handler/codec/compression/JdkZlibDecoder$GzipState;
    //   442: putfield 58	io/netty/handler/codec/compression/JdkZlibDecoder:gzipState	Lio/netty/handler/codec/compression/JdkZlibDecoder$GzipState;
    //   445: aload_0
    //   446: aload_2
    //   447: invokespecial 249	io/netty/handler/codec/compression/JdkZlibDecoder:readGZIPFooter	(Lio/netty/buffer/ByteBuf;)Z
    //   450: ifeq +49 -> 499
    //   453: aload_0
    //   454: getfield 72	io/netty/handler/codec/compression/JdkZlibDecoder:decompressConcatenated	Z
    //   457: ifne +6 -> 463
    //   460: iconst_1
    //   461: istore 6
    //   463: aload_0
    //   464: iload 6
    //   466: putfield 239	io/netty/handler/codec/compression/JdkZlibDecoder:finished	Z
    //   469: aload_0
    //   470: getfield 239	io/netty/handler/codec/compression/JdkZlibDecoder:finished	Z
    //   473: ifne +26 -> 499
    //   476: aload_0
    //   477: getfield 113	io/netty/handler/codec/compression/JdkZlibDecoder:inflater	Ljava/util/zip/Inflater;
    //   480: invokevirtual 307	java/util/zip/Inflater:reset	()V
    //   483: aload_0
    //   484: getfield 86	io/netty/handler/codec/compression/JdkZlibDecoder:crc	Lio/netty/handler/codec/compression/ByteBufChecksum;
    //   487: invokeinterface 211 1 0
    //   492: aload_0
    //   493: getstatic 56	io/netty/handler/codec/compression/JdkZlibDecoder$GzipState:HEADER_START	Lio/netty/handler/codec/compression/JdkZlibDecoder$GzipState;
    //   496: putfield 58	io/netty/handler/codec/compression/JdkZlibDecoder:gzipState	Lio/netty/handler/codec/compression/JdkZlibDecoder$GzipState;
    //   499: aload 7
    //   501: invokevirtual 202	io/netty/buffer/ByteBuf:isReadable	()Z
    //   504: ifeq +15 -> 519
    //   507: aload_3
    //   508: aload 7
    //   510: invokeinterface 313 2 0
    //   515: pop
    //   516: goto +11 -> 527
    //   519: aload 7
    //   521: invokeinterface 318 1 0
    //   526: pop
    //   527: return
    //   528: astore_1
    //   529: goto +18 -> 547
    //   532: astore_2
    //   533: new 162	io/netty/handler/codec/compression/DecompressionException
    //   536: astore_1
    //   537: aload_1
    //   538: ldc_w 320
    //   541: aload_2
    //   542: invokespecial 323	io/netty/handler/codec/compression/DecompressionException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   545: aload_1
    //   546: athrow
    //   547: aload 7
    //   549: invokevirtual 202	io/netty/buffer/ByteBuf:isReadable	()Z
    //   552: ifeq +15 -> 567
    //   555: aload_3
    //   556: aload 7
    //   558: invokeinterface 313 2 0
    //   563: pop
    //   564: goto +11 -> 575
    //   567: aload 7
    //   569: invokeinterface 318 1 0
    //   574: pop
    //   575: aload_1
    //   576: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	JdkZlibDecoder
    //   0	577	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	577	2	paramByteBuf	ByteBuf
    //   0	577	3	paramList	java.util.List<Object>
    //   21	408	4	i	int
    //   33	6	5	bool1	boolean
    //   36	429	6	bool2	boolean
    //   179	389	7	localObject1	Object
    //   233	176	8	localObject2	Object
    //   240	194	9	j	int
    //   250	52	10	k	int
    //   268	36	11	m	int
    //   290	8	12	localByteBufChecksum	ByteBufChecksum
    // Exception table:
    //   from	to	target	type
    //   218	270	528	finally
    //   275	292	528	finally
    //   297	310	528	finally
    //   313	329	528	finally
    //   334	343	528	finally
    //   346	359	528	finally
    //   359	381	528	finally
    //   390	408	528	finally
    //   418	433	528	finally
    //   438	453	528	finally
    //   453	460	528	finally
    //   463	499	528	finally
    //   533	547	528	finally
    //   218	270	532	java/util/zip/DataFormatException
    //   275	292	532	java/util/zip/DataFormatException
    //   297	310	532	java/util/zip/DataFormatException
    //   313	329	532	java/util/zip/DataFormatException
    //   334	343	532	java/util/zip/DataFormatException
    //   346	359	532	java/util/zip/DataFormatException
    //   359	381	532	java/util/zip/DataFormatException
    //   390	408	532	java/util/zip/DataFormatException
    //   418	433	532	java/util/zip/DataFormatException
    //   438	453	532	java/util/zip/DataFormatException
    //   453	460	532	java/util/zip/DataFormatException
    //   463	499	532	java/util/zip/DataFormatException
  }
  
  protected void decompressionBufferExhausted(ByteBuf paramByteBuf)
  {
    this.finished = true;
  }
  
  protected void handlerRemoved0(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.handlerRemoved0(paramChannelHandlerContext);
    paramChannelHandlerContext = this.inflater;
    if (paramChannelHandlerContext != null) {
      paramChannelHandlerContext.end();
    }
  }
  
  public boolean isClosed()
  {
    return this.finished;
  }
  
  private static enum GzipState
  {
    static
    {
      GzipState localGzipState1 = new GzipState("HEADER_START", 0);
      HEADER_START = localGzipState1;
      GzipState localGzipState2 = new GzipState("HEADER_END", 1);
      HEADER_END = localGzipState2;
      GzipState localGzipState3 = new GzipState("FLG_READ", 2);
      FLG_READ = localGzipState3;
      GzipState localGzipState4 = new GzipState("XLEN_READ", 3);
      XLEN_READ = localGzipState4;
      GzipState localGzipState5 = new GzipState("SKIP_FNAME", 4);
      SKIP_FNAME = localGzipState5;
      GzipState localGzipState6 = new GzipState("SKIP_COMMENT", 5);
      SKIP_COMMENT = localGzipState6;
      GzipState localGzipState7 = new GzipState("PROCESS_FHCRC", 6);
      PROCESS_FHCRC = localGzipState7;
      GzipState localGzipState8 = new GzipState("FOOTER_START", 7);
      FOOTER_START = localGzipState8;
      $VALUES = new GzipState[] { localGzipState1, localGzipState2, localGzipState3, localGzipState4, localGzipState5, localGzipState6, localGzipState7, localGzipState8 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\JdkZlibDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
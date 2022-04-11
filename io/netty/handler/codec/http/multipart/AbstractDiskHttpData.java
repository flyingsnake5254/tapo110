package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public abstract class AbstractDiskHttpData
  extends AbstractHttpData
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractDiskHttpData.class);
  private File file;
  private FileChannel fileChannel;
  private boolean isRenamed;
  
  protected AbstractDiskHttpData(String paramString, Charset paramCharset, long paramLong)
  {
    super(paramString, paramCharset, paramLong);
  }
  
  private static byte[] readFrom(File paramFile)
    throws IOException
  {
    long l = paramFile.length();
    if (l <= 2147483647L)
    {
      paramFile = new RandomAccessFile(paramFile, "r");
      byte[] arrayOfByte = new byte[(int)l];
      try
      {
        FileChannel localFileChannel = paramFile.getChannel();
        ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
        int i = 0;
        while (i < l)
        {
          int j = localFileChannel.read(localByteBuffer);
          i += j;
        }
        return arrayOfByte;
      }
      finally
      {
        paramFile.close();
      }
    }
    throw new IllegalArgumentException("File too big to be loaded in memory");
  }
  
  private File tempFile()
    throws IOException
  {
    String str = getDiskFilename();
    Object localObject;
    if (str != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('_');
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = getPostfix();
    }
    if (getBaseDirectory() == null) {
      localObject = File.createTempFile(getPrefix(), (String)localObject);
    } else {
      localObject = File.createTempFile(getPrefix(), (String)localObject, new File(getBaseDirectory()));
    }
    if (deleteOnExit()) {
      ((File)localObject).deleteOnExit();
    }
    return (File)localObject;
  }
  
  public void addContent(ByteBuf paramByteBuf, boolean paramBoolean)
    throws IOException
  {
    if (paramByteBuf != null) {
      try
      {
        int i = paramByteBuf.readableBytes();
        long l1 = this.size;
        long l2 = i;
        checkSize(l1 + l2);
        l1 = this.definedSize;
        if ((l1 > 0L) && (l1 < this.size + l2))
        {
          localObject1 = new java/io/IOException;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Out of size: ");
          localStringBuilder.append(this.size + l2);
          localStringBuilder.append(" > ");
          localStringBuilder.append(this.definedSize);
          ((IOException)localObject1).<init>(localStringBuilder.toString());
          throw ((Throwable)localObject1);
        }
        if (this.file == null) {
          this.file = tempFile();
        }
        if (this.fileChannel == null)
        {
          localObject1 = new java/io/RandomAccessFile;
          ((RandomAccessFile)localObject1).<init>(this.file, "rw");
          this.fileChannel = ((RandomAccessFile)localObject1).getChannel();
        }
        int j = paramByteBuf.readerIndex();
        Object localObject1 = this.fileChannel;
        paramByteBuf.getBytes(j, (FileChannel)localObject1, ((FileChannel)localObject1).position(), i);
        this.size += l2;
        paramByteBuf.readerIndex(paramByteBuf.readerIndex() + 0);
      }
      finally
      {
        paramByteBuf.release();
      }
    }
    if (paramBoolean)
    {
      if (this.file == null) {
        this.file = tempFile();
      }
      if (this.fileChannel == null) {
        this.fileChannel = new RandomAccessFile(this.file, "rw").getChannel();
      }
    }
    try
    {
      this.fileChannel.force(false);
      this.fileChannel.close();
      this.fileChannel = null;
      setCompleted();
    }
    finally
    {
      this.fileChannel.close();
    }
  }
  
  /* Error */
  public void delete()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 149	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:fileChannel	Ljava/nio/channels/FileChannel;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +88 -> 94
    //   9: aload_1
    //   10: iconst_0
    //   11: invokevirtual 173	java/nio/channels/FileChannel:force	(Z)V
    //   14: aload_0
    //   15: getfield 149	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:fileChannel	Ljava/nio/channels/FileChannel;
    //   18: invokevirtual 174	java/nio/channels/FileChannel:close	()V
    //   21: goto +41 -> 62
    //   24: astore_1
    //   25: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   28: ldc -68
    //   30: aload_1
    //   31: invokeinterface 194 3 0
    //   36: goto +26 -> 62
    //   39: astore_1
    //   40: goto +30 -> 70
    //   43: astore_1
    //   44: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   47: ldc -60
    //   49: aload_1
    //   50: invokeinterface 194 3 0
    //   55: aload_0
    //   56: getfield 149	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:fileChannel	Ljava/nio/channels/FileChannel;
    //   59: invokevirtual 174	java/nio/channels/FileChannel:close	()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 149	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:fileChannel	Ljava/nio/channels/FileChannel;
    //   67: goto +27 -> 94
    //   70: aload_0
    //   71: getfield 149	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:fileChannel	Ljava/nio/channels/FileChannel;
    //   74: invokevirtual 174	java/nio/channels/FileChannel:close	()V
    //   77: goto +15 -> 92
    //   80: astore_2
    //   81: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   84: ldc -68
    //   86: aload_2
    //   87: invokeinterface 194 3 0
    //   92: aload_1
    //   93: athrow
    //   94: aload_0
    //   95: getfield 198	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:isRenamed	Z
    //   98: ifne +48 -> 146
    //   101: aload_0
    //   102: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +34 -> 141
    //   110: aload_1
    //   111: invokevirtual 201	java/io/File:exists	()Z
    //   114: ifeq +27 -> 141
    //   117: aload_0
    //   118: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   121: invokevirtual 203	java/io/File:delete	()Z
    //   124: ifne +17 -> 141
    //   127: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   130: ldc -51
    //   132: aload_0
    //   133: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   136: invokeinterface 208 3 0
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   146: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	AbstractDiskHttpData
    //   4	6	1	localFileChannel	FileChannel
    //   24	7	1	localIOException1	IOException
    //   39	1	1	localObject	Object
    //   43	50	1	localIOException2	IOException
    //   105	6	1	localFile	File
    //   80	7	2	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   14	21	24	java/io/IOException
    //   55	62	24	java/io/IOException
    //   9	14	39	finally
    //   44	55	39	finally
    //   9	14	43	java/io/IOException
    //   70	77	80	java/io/IOException
  }
  
  protected abstract boolean deleteOnExit();
  
  public byte[] get()
    throws IOException
  {
    File localFile = this.file;
    if (localFile == null) {
      return EmptyArrays.EMPTY_BYTES;
    }
    return readFrom(localFile);
  }
  
  protected abstract String getBaseDirectory();
  
  public ByteBuf getByteBuf()
    throws IOException
  {
    File localFile = this.file;
    if (localFile == null) {
      return Unpooled.EMPTY_BUFFER;
    }
    return Unpooled.wrappedBuffer(readFrom(localFile));
  }
  
  public ByteBuf getChunk(int paramInt)
    throws IOException
  {
    if ((this.file != null) && (paramInt != 0))
    {
      if (this.fileChannel == null) {
        this.fileChannel = new RandomAccessFile(this.file, "r").getChannel();
      }
      ByteBuffer localByteBuffer1 = ByteBuffer.allocate(paramInt);
      int i = 0;
      for (;;)
      {
        if (i < paramInt) {}
        try
        {
          int j = this.fileChannel.read(localByteBuffer1);
          if (j != -1) {
            i += j;
          }
        }
        finally
        {
          this.fileChannel.close();
          this.fileChannel = null;
        }
      }
      if (i == 0) {
        return Unpooled.EMPTY_BUFFER;
      }
      localByteBuffer2.flip();
      ByteBuf localByteBuf = Unpooled.wrappedBuffer(localByteBuffer2);
      localByteBuf.readerIndex(0);
      localByteBuf.writerIndex(i);
      return localByteBuf;
    }
    return Unpooled.EMPTY_BUFFER;
  }
  
  protected abstract String getDiskFilename();
  
  public File getFile()
    throws IOException
  {
    return this.file;
  }
  
  protected abstract String getPostfix();
  
  protected abstract String getPrefix();
  
  public String getString()
    throws IOException
  {
    return getString(HttpConstants.DEFAULT_CHARSET);
  }
  
  public String getString(Charset paramCharset)
    throws IOException
  {
    File localFile = this.file;
    if (localFile == null) {
      return "";
    }
    if (paramCharset == null) {
      return new String(readFrom(localFile), HttpConstants.DEFAULT_CHARSET.name());
    }
    return new String(readFrom(localFile), paramCharset.name());
  }
  
  public boolean isInMemory()
  {
    return false;
  }
  
  /* Error */
  public boolean renameTo(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 273
    //   4: invokestatic 185	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_0
    //   9: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +468 -> 482
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 275	java/io/File:renameTo	(Ljava/io/File;)Z
    //   22: ifne +448 -> 470
    //   25: ldc2_w 276
    //   28: lstore_3
    //   29: lconst_0
    //   30: lstore 5
    //   32: aconst_null
    //   33: astore 7
    //   35: aconst_null
    //   36: astore_2
    //   37: new 41	java/io/RandomAccessFile
    //   40: astore 8
    //   42: aload 8
    //   44: aload_0
    //   45: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   48: ldc 43
    //   50: invokespecial 46	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   53: new 41	java/io/RandomAccessFile
    //   56: astore 9
    //   58: aload 9
    //   60: aload_1
    //   61: ldc -105
    //   63: invokespecial 46	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: lload 5
    //   68: lstore 10
    //   70: aload 8
    //   72: invokevirtual 50	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   75: astore 12
    //   77: lload 5
    //   79: lstore 10
    //   81: aload 9
    //   83: invokevirtual 50	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   86: astore 13
    //   88: lload 5
    //   90: lstore 10
    //   92: aload_0
    //   93: getfield 128	io/netty/handler/codec/http/multipart/AbstractHttpData:size	J
    //   96: lstore 14
    //   98: lload 5
    //   100: lload 14
    //   102: lcmp
    //   103: ifge +51 -> 154
    //   106: lload_3
    //   107: lstore 16
    //   109: lload_3
    //   110: lload 14
    //   112: lload 5
    //   114: lsub
    //   115: lcmp
    //   116: ifge +10 -> 126
    //   119: lload 14
    //   121: lload 5
    //   123: lsub
    //   124: lstore 16
    //   126: lload 5
    //   128: lstore 10
    //   130: aload 12
    //   132: lload 5
    //   134: lload 16
    //   136: aload 13
    //   138: invokevirtual 281	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   141: lstore_3
    //   142: lload 5
    //   144: lload_3
    //   145: ladd
    //   146: lstore 5
    //   148: lload 16
    //   150: lstore_3
    //   151: goto -63 -> 88
    //   154: aload 8
    //   156: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   159: goto +4 -> 163
    //   162: astore_2
    //   163: aload 9
    //   165: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   168: lload 5
    //   170: lstore 10
    //   172: goto +226 -> 398
    //   175: astore 8
    //   177: aload 8
    //   179: astore 7
    //   181: lload 5
    //   183: lstore 10
    //   185: aload_2
    //   186: astore 9
    //   188: aload_2
    //   189: ifnonnull +13 -> 202
    //   192: aload 8
    //   194: astore_2
    //   195: lload 5
    //   197: lstore 10
    //   199: goto +199 -> 398
    //   202: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   205: ldc_w 283
    //   208: aload 7
    //   210: invokeinterface 194 3 0
    //   215: aload 9
    //   217: astore_2
    //   218: goto +180 -> 398
    //   221: astore_1
    //   222: aload 9
    //   224: astore_2
    //   225: goto +39 -> 264
    //   228: astore_2
    //   229: lload 10
    //   231: lstore 5
    //   233: aload 8
    //   235: astore 7
    //   237: goto +92 -> 329
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_2
    //   243: goto +21 -> 264
    //   246: astore_2
    //   247: aconst_null
    //   248: astore 9
    //   250: aload 8
    //   252: astore 7
    //   254: goto +75 -> 329
    //   257: astore_1
    //   258: aconst_null
    //   259: astore 8
    //   261: aload 8
    //   263: astore_2
    //   264: aload 7
    //   266: astore 9
    //   268: aload 8
    //   270: ifnull +17 -> 287
    //   273: aload 8
    //   275: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   278: aload 7
    //   280: astore 9
    //   282: goto +5 -> 287
    //   285: astore 9
    //   287: aload_2
    //   288: ifnull +31 -> 319
    //   291: aload_2
    //   292: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   295: goto +24 -> 319
    //   298: astore_2
    //   299: aload 9
    //   301: ifnonnull +6 -> 307
    //   304: goto +15 -> 319
    //   307: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   310: ldc_w 283
    //   313: aload_2
    //   314: invokeinterface 194 3 0
    //   319: aload_1
    //   320: athrow
    //   321: astore_2
    //   322: aconst_null
    //   323: astore 7
    //   325: aload 7
    //   327: astore 9
    //   329: aload_2
    //   330: astore 8
    //   332: aload 7
    //   334: ifnull +24 -> 358
    //   337: aload 7
    //   339: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   342: goto +16 -> 358
    //   345: astore_2
    //   346: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   349: ldc_w 283
    //   352: aload_2
    //   353: invokeinterface 194 3 0
    //   358: lload 5
    //   360: lstore 10
    //   362: aload 8
    //   364: astore_2
    //   365: aload 9
    //   367: ifnull +31 -> 398
    //   370: aload 9
    //   372: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   375: lload 5
    //   377: lstore 10
    //   379: aload 8
    //   381: astore_2
    //   382: goto +16 -> 398
    //   385: astore 7
    //   387: lload 5
    //   389: lstore 10
    //   391: aload 8
    //   393: astore 9
    //   395: goto -193 -> 202
    //   398: aload_2
    //   399: ifnonnull +69 -> 468
    //   402: lload 10
    //   404: aload_0
    //   405: getfield 128	io/netty/handler/codec/http/multipart/AbstractHttpData:size	J
    //   408: lcmp
    //   409: ifne +39 -> 448
    //   412: aload_0
    //   413: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   416: invokevirtual 203	java/io/File:delete	()Z
    //   419: ifne +17 -> 436
    //   422: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   425: ldc -51
    //   427: aload_0
    //   428: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   431: invokeinterface 208 3 0
    //   436: aload_0
    //   437: aload_1
    //   438: putfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   441: aload_0
    //   442: iconst_1
    //   443: putfield 198	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:isRenamed	Z
    //   446: iconst_1
    //   447: ireturn
    //   448: aload_1
    //   449: invokevirtual 203	java/io/File:delete	()Z
    //   452: ifne +14 -> 466
    //   455: getstatic 22	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   458: ldc -51
    //   460: aload_1
    //   461: invokeinterface 208 3 0
    //   466: iconst_0
    //   467: ireturn
    //   468: aload_2
    //   469: athrow
    //   470: aload_0
    //   471: aload_1
    //   472: putfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   475: aload_0
    //   476: iconst_1
    //   477: putfield 198	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:isRenamed	Z
    //   480: iconst_1
    //   481: ireturn
    //   482: new 31	java/io/IOException
    //   485: dup
    //   486: ldc_w 285
    //   489: invokespecial 143	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   492: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	AbstractDiskHttpData
    //   0	493	1	paramFile	File
    //   12	25	2	localFile	File
    //   162	27	2	localIOException1	IOException
    //   194	31	2	localObject1	Object
    //   228	1	2	localIOException2	IOException
    //   242	1	2	localObject2	Object
    //   246	1	2	localIOException3	IOException
    //   263	29	2	localObject3	Object
    //   298	16	2	localIOException4	IOException
    //   321	9	2	localIOException5	IOException
    //   345	8	2	localIOException6	IOException
    //   364	105	2	localObject4	Object
    //   28	123	3	l1	long
    //   30	358	5	l2	long
    //   33	305	7	localObject5	Object
    //   385	1	7	localIOException7	IOException
    //   40	115	8	localRandomAccessFile	RandomAccessFile
    //   175	76	8	localIOException8	IOException
    //   259	133	8	localIOException9	IOException
    //   56	225	9	localObject6	Object
    //   285	15	9	localIOException10	IOException
    //   327	67	9	localObject7	Object
    //   68	335	10	l3	long
    //   75	56	12	localFileChannel1	FileChannel
    //   86	51	13	localFileChannel2	FileChannel
    //   96	24	14	l4	long
    //   107	42	16	l5	long
    // Exception table:
    //   from	to	target	type
    //   154	159	162	java/io/IOException
    //   163	168	175	java/io/IOException
    //   70	77	221	finally
    //   81	88	221	finally
    //   92	98	221	finally
    //   130	142	221	finally
    //   70	77	228	java/io/IOException
    //   81	88	228	java/io/IOException
    //   92	98	228	java/io/IOException
    //   130	142	228	java/io/IOException
    //   53	66	240	finally
    //   53	66	246	java/io/IOException
    //   37	53	257	finally
    //   273	278	285	java/io/IOException
    //   291	295	298	java/io/IOException
    //   37	53	321	java/io/IOException
    //   337	342	345	java/io/IOException
    //   370	375	385	java/io/IOException
  }
  
  /* Error */
  public void setContent(ByteBuf paramByteBuf)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -77
    //   3: invokestatic 185	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_1
    //   8: invokevirtual 124	io/netty/buffer/ByteBuf:readableBytes	()I
    //   11: i2l
    //   12: lstore_2
    //   13: aload_0
    //   14: lload_2
    //   15: putfield 128	io/netty/handler/codec/http/multipart/AbstractHttpData:size	J
    //   18: aload_0
    //   19: lload_2
    //   20: invokevirtual 132	io/netty/handler/codec/http/multipart/AbstractHttpData:checkSize	(J)V
    //   23: aload_0
    //   24: getfield 135	io/netty/handler/codec/http/multipart/AbstractHttpData:definedSize	J
    //   27: lstore_2
    //   28: lload_2
    //   29: lconst_0
    //   30: lcmp
    //   31: ifle +79 -> 110
    //   34: lload_2
    //   35: aload_0
    //   36: getfield 128	io/netty/handler/codec/http/multipart/AbstractHttpData:size	J
    //   39: lcmp
    //   40: iflt +6 -> 46
    //   43: goto +67 -> 110
    //   46: new 31	java/io/IOException
    //   49: astore 4
    //   51: new 81	java/lang/StringBuilder
    //   54: astore 5
    //   56: aload 5
    //   58: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   61: aload 5
    //   63: ldc -119
    //   65: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 5
    //   71: aload_0
    //   72: getfield 128	io/netty/handler/codec/http/multipart/AbstractHttpData:size	J
    //   75: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: ldc -114
    //   83: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 5
    //   89: aload_0
    //   90: getfield 135	io/netty/handler/codec/http/multipart/AbstractHttpData:definedSize	J
    //   93: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: aload 5
    //   101: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 143	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   107: aload 4
    //   109: athrow
    //   110: aload_0
    //   111: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   114: ifnonnull +11 -> 125
    //   117: aload_0
    //   118: aload_0
    //   119: invokespecial 147	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:tempFile	()Ljava/io/File;
    //   122: putfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   125: aload_1
    //   126: invokevirtual 124	io/netty/buffer/ByteBuf:readableBytes	()I
    //   129: ifne +113 -> 242
    //   132: aload_0
    //   133: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   136: invokevirtual 290	java/io/File:createNewFile	()Z
    //   139: ifne +95 -> 234
    //   142: aload_0
    //   143: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   146: invokevirtual 37	java/io/File:length	()J
    //   149: lstore_2
    //   150: lload_2
    //   151: lconst_0
    //   152: lcmp
    //   153: ifne +11 -> 164
    //   156: aload_1
    //   157: invokeinterface 169 1 0
    //   162: pop
    //   163: return
    //   164: aload_0
    //   165: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   168: invokevirtual 203	java/io/File:delete	()Z
    //   171: ifeq +16 -> 187
    //   174: aload_0
    //   175: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   178: invokevirtual 290	java/io/File:createNewFile	()Z
    //   181: ifeq +6 -> 187
    //   184: goto +50 -> 234
    //   187: new 31	java/io/IOException
    //   190: astore 5
    //   192: new 81	java/lang/StringBuilder
    //   195: astore 4
    //   197: aload 4
    //   199: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   202: aload 4
    //   204: ldc_w 292
    //   207: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 4
    //   213: aload_0
    //   214: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   217: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 5
    //   223: aload 4
    //   225: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 143	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   231: aload 5
    //   233: athrow
    //   234: aload_1
    //   235: invokeinterface 169 1 0
    //   240: pop
    //   241: return
    //   242: new 41	java/io/RandomAccessFile
    //   245: astore 5
    //   247: aload 5
    //   249: aload_0
    //   250: getfield 145	io/netty/handler/codec/http/multipart/AbstractDiskHttpData:file	Ljava/io/File;
    //   253: ldc -105
    //   255: invokespecial 46	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   258: aload 5
    //   260: lconst_0
    //   261: invokevirtual 298	java/io/RandomAccessFile:setLength	(J)V
    //   264: aload 5
    //   266: invokevirtual 50	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   269: astore 6
    //   271: aload_1
    //   272: invokevirtual 302	io/netty/buffer/ByteBuf:nioBuffer	()Ljava/nio/ByteBuffer;
    //   275: astore 4
    //   277: iconst_0
    //   278: istore 7
    //   280: iload 7
    //   282: i2l
    //   283: aload_0
    //   284: getfield 128	io/netty/handler/codec/http/multipart/AbstractHttpData:size	J
    //   287: lcmp
    //   288: ifge +18 -> 306
    //   291: iload 7
    //   293: aload 6
    //   295: aload 4
    //   297: invokevirtual 305	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   300: iadd
    //   301: istore 7
    //   303: goto -23 -> 280
    //   306: aload_1
    //   307: aload_1
    //   308: invokevirtual 154	io/netty/buffer/ByteBuf:readerIndex	()I
    //   311: iload 7
    //   313: iadd
    //   314: invokevirtual 164	io/netty/buffer/ByteBuf:readerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   317: pop
    //   318: aload 6
    //   320: iconst_0
    //   321: invokevirtual 173	java/nio/channels/FileChannel:force	(Z)V
    //   324: aload 5
    //   326: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   329: aload_0
    //   330: invokevirtual 177	io/netty/handler/codec/http/multipart/AbstractHttpData:setCompleted	()V
    //   333: aload_1
    //   334: invokeinterface 169 1 0
    //   339: pop
    //   340: return
    //   341: astore 4
    //   343: aload 5
    //   345: invokevirtual 65	java/io/RandomAccessFile:close	()V
    //   348: aload 4
    //   350: athrow
    //   351: astore 5
    //   353: aload_1
    //   354: invokeinterface 169 1 0
    //   359: pop
    //   360: aload 5
    //   362: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	AbstractDiskHttpData
    //   0	363	1	paramByteBuf	ByteBuf
    //   12	139	2	l	long
    //   49	247	4	localObject1	Object
    //   341	8	4	localObject2	Object
    //   54	290	5	localObject3	Object
    //   351	10	5	localObject4	Object
    //   269	50	6	localFileChannel	FileChannel
    //   278	36	7	i	int
    // Exception table:
    //   from	to	target	type
    //   258	277	341	finally
    //   280	303	341	finally
    //   306	324	341	finally
    //   7	28	351	finally
    //   34	43	351	finally
    //   46	110	351	finally
    //   110	125	351	finally
    //   125	150	351	finally
    //   164	184	351	finally
    //   187	234	351	finally
    //   242	258	351	finally
    //   324	333	351	finally
    //   343	351	351	finally
  }
  
  public void setContent(File paramFile)
    throws IOException
  {
    long l = paramFile.length();
    checkSize(l);
    this.size = l;
    if (this.file != null) {
      delete();
    }
    this.file = paramFile;
    this.isRenamed = true;
    setCompleted();
  }
  
  public void setContent(InputStream paramInputStream)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramInputStream, "inputStream");
    if (this.file != null) {
      delete();
    }
    this.file = tempFile();
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.file, "rw");
    try
    {
      localRandomAccessFile.setLength(0L);
      FileChannel localFileChannel = localRandomAccessFile.getChannel();
      byte[] arrayOfByte = new byte['䀀'];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      int i = paramInputStream.read(arrayOfByte);
      int j = 0;
      while (i > 0)
      {
        localByteBuffer.position(i).flip();
        j += localFileChannel.write(localByteBuffer);
        checkSize(j);
        i = paramInputStream.read(arrayOfByte);
      }
      localFileChannel.force(false);
      localRandomAccessFile.close();
      long l1 = j;
      this.size = l1;
      long l2 = this.definedSize;
      if ((l2 > 0L) && (l2 < l1))
      {
        if (!this.file.delete()) {
          logger.warn("Failed to delete: {}", this.file);
        }
        this.file = null;
        paramInputStream = new StringBuilder();
        paramInputStream.append("Out of size: ");
        paramInputStream.append(this.size);
        paramInputStream.append(" > ");
        paramInputStream.append(this.definedSize);
        throw new IOException(paramInputStream.toString());
      }
      this.isRenamed = true;
      return;
    }
    finally
    {
      localRandomAccessFile.close();
    }
  }
  
  public HttpData touch()
  {
    return this;
  }
  
  public HttpData touch(Object paramObject)
  {
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\AbstractDiskHttpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
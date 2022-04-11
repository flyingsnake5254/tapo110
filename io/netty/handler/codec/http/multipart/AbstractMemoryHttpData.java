package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public abstract class AbstractMemoryHttpData
  extends AbstractHttpData
{
  private ByteBuf byteBuf;
  private int chunkPosition;
  
  protected AbstractMemoryHttpData(String paramString, Charset paramCharset, long paramLong)
  {
    super(paramString, paramCharset, paramLong);
  }
  
  public void addContent(ByteBuf paramByteBuf, boolean paramBoolean)
    throws IOException
  {
    if (paramByteBuf != null)
    {
      long l1 = paramByteBuf.readableBytes();
      checkSize(this.size + l1);
      long l2 = this.definedSize;
      if ((l2 > 0L) && (l2 < this.size + l1))
      {
        paramByteBuf = new StringBuilder();
        paramByteBuf.append("Out of size: ");
        paramByteBuf.append(this.size + l1);
        paramByteBuf.append(" > ");
        paramByteBuf.append(this.definedSize);
        throw new IOException(paramByteBuf.toString());
      }
      this.size += l1;
      Object localObject = this.byteBuf;
      if (localObject == null)
      {
        this.byteBuf = paramByteBuf;
      }
      else if ((localObject instanceof CompositeByteBuf))
      {
        ((CompositeByteBuf)localObject).addComponent(true, paramByteBuf);
      }
      else
      {
        localObject = Unpooled.compositeBuffer(Integer.MAX_VALUE);
        ((CompositeByteBuf)localObject).addComponents(true, new ByteBuf[] { this.byteBuf, paramByteBuf });
        this.byteBuf = ((ByteBuf)localObject);
      }
    }
    if (paramBoolean) {
      setCompleted();
    } else {
      ObjectUtil.checkNotNull(paramByteBuf, "buffer");
    }
  }
  
  public void delete()
  {
    ByteBuf localByteBuf = this.byteBuf;
    if (localByteBuf != null)
    {
      localByteBuf.release();
      this.byteBuf = null;
    }
  }
  
  public byte[] get()
  {
    ByteBuf localByteBuf = this.byteBuf;
    if (localByteBuf == null) {
      return Unpooled.EMPTY_BUFFER.array();
    }
    byte[] arrayOfByte = new byte[localByteBuf.readableBytes()];
    localByteBuf = this.byteBuf;
    localByteBuf.getBytes(localByteBuf.readerIndex(), arrayOfByte);
    return arrayOfByte;
  }
  
  public ByteBuf getByteBuf()
  {
    return this.byteBuf;
  }
  
  public ByteBuf getChunk(int paramInt)
    throws IOException
  {
    ByteBuf localByteBuf = this.byteBuf;
    if ((localByteBuf != null) && (paramInt != 0) && (localByteBuf.readableBytes() != 0))
    {
      int i = this.byteBuf.readableBytes();
      int j = this.chunkPosition;
      int k = i - j;
      if (k == 0)
      {
        this.chunkPosition = 0;
        return Unpooled.EMPTY_BUFFER;
      }
      i = paramInt;
      if (k < paramInt) {
        i = k;
      }
      localByteBuf = this.byteBuf.retainedSlice(j, i);
      this.chunkPosition += i;
      return localByteBuf;
    }
    this.chunkPosition = 0;
    return Unpooled.EMPTY_BUFFER;
  }
  
  public File getFile()
    throws IOException
  {
    throw new IOException("Not represented by a file");
  }
  
  public String getString()
  {
    return getString(HttpConstants.DEFAULT_CHARSET);
  }
  
  public String getString(Charset paramCharset)
  {
    ByteBuf localByteBuf = this.byteBuf;
    if (localByteBuf == null) {
      return "";
    }
    Charset localCharset = paramCharset;
    if (paramCharset == null) {
      localCharset = HttpConstants.DEFAULT_CHARSET;
    }
    return localByteBuf.toString(localCharset);
  }
  
  public boolean isInMemory()
  {
    return true;
  }
  
  /* Error */
  public boolean renameTo(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -113
    //   3: invokestatic 87	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 59	io/netty/handler/codec/http/multipart/AbstractMemoryHttpData:byteBuf	Lio/netty/buffer/ByteBuf;
    //   11: astore_2
    //   12: iconst_1
    //   13: istore_3
    //   14: aload_2
    //   15: ifnonnull +45 -> 60
    //   18: aload_1
    //   19: invokevirtual 148	java/io/File:createNewFile	()Z
    //   22: ifeq +5 -> 27
    //   25: iconst_1
    //   26: ireturn
    //   27: new 36	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   34: astore_2
    //   35: aload_2
    //   36: ldc -106
    //   38: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: aload_1
    //   44: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: new 17	java/io/IOException
    //   51: dup
    //   52: aload_2
    //   53: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 57	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_2
    //   61: invokevirtual 23	io/netty/buffer/ByteBuf:readableBytes	()I
    //   64: istore 4
    //   66: new 155	java/io/RandomAccessFile
    //   69: dup
    //   70: aload_1
    //   71: ldc -99
    //   73: invokespecial 160	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 164	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   81: astore_2
    //   82: aload_0
    //   83: getfield 59	io/netty/handler/codec/http/multipart/AbstractMemoryHttpData:byteBuf	Lio/netty/buffer/ByteBuf;
    //   86: invokevirtual 167	io/netty/buffer/ByteBuf:nioBufferCount	()I
    //   89: iconst_1
    //   90: if_icmpne +40 -> 130
    //   93: aload_0
    //   94: getfield 59	io/netty/handler/codec/http/multipart/AbstractMemoryHttpData:byteBuf	Lio/netty/buffer/ByteBuf;
    //   97: invokevirtual 171	io/netty/buffer/ByteBuf:nioBuffer	()Ljava/nio/ByteBuffer;
    //   100: astore 5
    //   102: iconst_0
    //   103: istore 6
    //   105: iload 6
    //   107: istore 7
    //   109: iload 6
    //   111: iload 4
    //   113: if_icmpge +56 -> 169
    //   116: iload 6
    //   118: aload_2
    //   119: aload 5
    //   121: invokevirtual 177	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   124: iadd
    //   125: istore 6
    //   127: goto -22 -> 105
    //   130: aload_0
    //   131: getfield 59	io/netty/handler/codec/http/multipart/AbstractMemoryHttpData:byteBuf	Lio/netty/buffer/ByteBuf;
    //   134: invokevirtual 181	io/netty/buffer/ByteBuf:nioBuffers	()[Ljava/nio/ByteBuffer;
    //   137: astore 5
    //   139: iconst_0
    //   140: istore 6
    //   142: iload 6
    //   144: istore 7
    //   146: iload 6
    //   148: iload 4
    //   150: if_icmpge +19 -> 169
    //   153: iload 6
    //   155: i2l
    //   156: aload_2
    //   157: aload 5
    //   159: invokevirtual 184	java/nio/channels/FileChannel:write	([Ljava/nio/ByteBuffer;)J
    //   162: ladd
    //   163: l2i
    //   164: istore 6
    //   166: goto -24 -> 142
    //   169: aload_2
    //   170: iconst_0
    //   171: invokevirtual 188	java/nio/channels/FileChannel:force	(Z)V
    //   174: aload_2
    //   175: invokevirtual 191	java/nio/channels/FileChannel:close	()V
    //   178: aload_1
    //   179: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   182: iload 7
    //   184: iload 4
    //   186: if_icmpne +6 -> 192
    //   189: goto +5 -> 194
    //   192: iconst_0
    //   193: istore_3
    //   194: iload_3
    //   195: ireturn
    //   196: astore 5
    //   198: aload_2
    //   199: invokevirtual 191	java/nio/channels/FileChannel:close	()V
    //   202: aload 5
    //   204: athrow
    //   205: astore_2
    //   206: aload_1
    //   207: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   210: aload_2
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	AbstractMemoryHttpData
    //   0	212	1	paramFile	File
    //   11	188	2	localObject1	Object
    //   205	6	2	localObject2	Object
    //   13	182	3	bool	boolean
    //   64	123	4	i	int
    //   100	58	5	localObject3	Object
    //   196	7	5	localObject4	Object
    //   103	62	6	j	int
    //   107	80	7	k	int
    // Exception table:
    //   from	to	target	type
    //   82	102	196	finally
    //   116	127	196	finally
    //   130	139	196	finally
    //   153	166	196	finally
    //   169	174	196	finally
    //   77	82	205	finally
    //   174	178	205	finally
    //   198	205	205	finally
  }
  
  public void setContent(ByteBuf paramByteBuf)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramByteBuf, "buffer");
    long l1 = paramByteBuf.readableBytes();
    checkSize(l1);
    long l2 = this.definedSize;
    if ((l2 > 0L) && (l2 < l1))
    {
      paramByteBuf = new StringBuilder();
      paramByteBuf.append("Out of size: ");
      paramByteBuf.append(l1);
      paramByteBuf.append(" > ");
      paramByteBuf.append(this.definedSize);
      throw new IOException(paramByteBuf.toString());
    }
    ByteBuf localByteBuf = this.byteBuf;
    if (localByteBuf != null) {
      localByteBuf.release();
    }
    this.byteBuf = paramByteBuf;
    this.size = l1;
    setCompleted();
  }
  
  public void setContent(File paramFile)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramFile, "file");
    long l = paramFile.length();
    if (l <= 2147483647L)
    {
      checkSize(l);
      paramFile = new RandomAccessFile(paramFile, "r");
      try
      {
        FileChannel localFileChannel = paramFile.getChannel();
        int i = (int)l;
        try
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[i]);
          i = 0;
          while (i < l)
          {
            int j = localFileChannel.read(localByteBuffer);
            i += j;
          }
          localFileChannel.close();
          paramFile.close();
          localByteBuffer.flip();
          paramFile = this.byteBuf;
          if (paramFile != null) {
            paramFile.release();
          }
          this.byteBuf = Unpooled.wrappedBuffer(Integer.MAX_VALUE, new ByteBuffer[] { localByteBuffer });
          this.size = l;
          return;
        }
        finally {}
        throw new IllegalArgumentException("File too big to be loaded in memory");
      }
      finally
      {
        paramFile.close();
      }
    }
  }
  
  public void setContent(InputStream paramInputStream)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramInputStream, "inputStream");
    byte[] arrayOfByte = new byte['䀀'];
    ByteBuf localByteBuf = Unpooled.buffer();
    try
    {
      int i = paramInputStream.read(arrayOfByte);
      int j = 0;
      while (i > 0)
      {
        localByteBuf.writeBytes(arrayOfByte, 0, i);
        j += i;
        checkSize(j);
        i = paramInputStream.read(arrayOfByte);
      }
      long l1 = j;
      this.size = l1;
      long l2 = this.definedSize;
      if ((l2 > 0L) && (l2 < l1))
      {
        localByteBuf.release();
        paramInputStream = new StringBuilder();
        paramInputStream.append("Out of size: ");
        paramInputStream.append(this.size);
        paramInputStream.append(" > ");
        paramInputStream.append(this.definedSize);
        throw new IOException(paramInputStream.toString());
      }
      paramInputStream = this.byteBuf;
      if (paramInputStream != null) {
        paramInputStream.release();
      }
      this.byteBuf = localByteBuf;
      setCompleted();
      return;
    }
    catch (IOException paramInputStream)
    {
      localByteBuf.release();
      throw paramInputStream;
    }
  }
  
  public HttpData touch()
  {
    return touch(null);
  }
  
  public HttpData touch(Object paramObject)
  {
    ByteBuf localByteBuf = this.byteBuf;
    if (localByteBuf != null) {
      localByteBuf.touch(paramObject);
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\multipart\AbstractMemoryHttpData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
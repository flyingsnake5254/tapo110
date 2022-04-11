package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChunkedFile
  implements ChunkedInput<ByteBuf>
{
  private final int chunkSize;
  private final long endOffset;
  private final RandomAccessFile file;
  private long offset;
  private final long startOffset;
  
  public ChunkedFile(File paramFile)
    throws IOException
  {
    this(paramFile, 8192);
  }
  
  public ChunkedFile(File paramFile, int paramInt)
    throws IOException
  {
    this(new RandomAccessFile(paramFile, "r"), paramInt);
  }
  
  public ChunkedFile(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    this(paramRandomAccessFile, 8192);
  }
  
  public ChunkedFile(RandomAccessFile paramRandomAccessFile, int paramInt)
    throws IOException
  {
    this(paramRandomAccessFile, 0L, paramRandomAccessFile.length(), paramInt);
  }
  
  public ChunkedFile(RandomAccessFile paramRandomAccessFile, long paramLong1, long paramLong2, int paramInt)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramRandomAccessFile, "file");
    ObjectUtil.checkPositiveOrZero(paramLong1, "offset");
    ObjectUtil.checkPositiveOrZero(paramLong2, "length");
    ObjectUtil.checkPositive(paramInt, "chunkSize");
    this.file = paramRandomAccessFile;
    this.startOffset = paramLong1;
    this.offset = paramLong1;
    this.endOffset = (paramLong2 + paramLong1);
    this.chunkSize = paramInt;
    paramRandomAccessFile.seek(paramLong1);
  }
  
  public void close()
    throws Exception
  {
    this.file.close();
  }
  
  public long currentOffset()
  {
    return this.offset;
  }
  
  public long endOffset()
  {
    return this.endOffset;
  }
  
  public boolean isEndOfInput()
    throws Exception
  {
    boolean bool;
    if ((this.offset < this.endOffset) && (this.file.getChannel().isOpen())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public long length()
  {
    return this.endOffset - this.startOffset;
  }
  
  public long progress()
  {
    return this.offset - this.startOffset;
  }
  
  public ByteBuf readChunk(ByteBufAllocator paramByteBufAllocator)
    throws Exception
  {
    long l1 = this.offset;
    long l2 = this.endOffset;
    if (l1 >= l2) {
      return null;
    }
    int i = (int)Math.min(this.chunkSize, l2 - l1);
    paramByteBufAllocator = paramByteBufAllocator.heapBuffer(i);
    try
    {
      this.file.readFully(paramByteBufAllocator.array(), paramByteBufAllocator.arrayOffset(), i);
      paramByteBufAllocator.writerIndex(i);
      this.offset = (l1 + i);
      return paramByteBufAllocator;
    }
    finally
    {
      paramByteBufAllocator.release();
    }
  }
  
  @Deprecated
  public ByteBuf readChunk(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    return readChunk(paramChannelHandlerContext.alloc());
  }
  
  public long startOffset()
  {
    return this.startOffset;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\stream\ChunkedFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
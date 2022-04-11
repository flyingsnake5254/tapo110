package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;

public class ChunkedNioFile
  implements ChunkedInput<ByteBuf>
{
  private final int chunkSize;
  private final long endOffset;
  private final FileChannel in;
  private long offset;
  private final long startOffset;
  
  public ChunkedNioFile(File paramFile)
    throws IOException
  {
    this(new RandomAccessFile(paramFile, "r").getChannel());
  }
  
  public ChunkedNioFile(File paramFile, int paramInt)
    throws IOException
  {
    this(new RandomAccessFile(paramFile, "r").getChannel(), paramInt);
  }
  
  public ChunkedNioFile(FileChannel paramFileChannel)
    throws IOException
  {
    this(paramFileChannel, 8192);
  }
  
  public ChunkedNioFile(FileChannel paramFileChannel, int paramInt)
    throws IOException
  {
    this(paramFileChannel, 0L, paramFileChannel.size(), paramInt);
  }
  
  public ChunkedNioFile(FileChannel paramFileChannel, long paramLong1, long paramLong2, int paramInt)
    throws IOException
  {
    ObjectUtil.checkNotNull(paramFileChannel, "in");
    ObjectUtil.checkPositiveOrZero(paramLong1, "offset");
    ObjectUtil.checkPositiveOrZero(paramLong2, "length");
    ObjectUtil.checkPositive(paramInt, "chunkSize");
    if (paramFileChannel.isOpen())
    {
      this.in = paramFileChannel;
      this.chunkSize = paramInt;
      this.startOffset = paramLong1;
      this.offset = paramLong1;
      this.endOffset = (paramLong1 + paramLong2);
      return;
    }
    throw new ClosedChannelException();
  }
  
  public void close()
    throws Exception
  {
    this.in.close();
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
    if ((this.offset < this.endOffset) && (this.in.isOpen())) {
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
    ByteBuf localByteBuf = paramByteBufAllocator.buffer(i);
    int j = 0;
    try
    {
      int k;
      do
      {
        k = localByteBuf.writeBytes(this.in, j + l1, i - j);
        if (k < 0) {
          break;
        }
        k = j + k;
        j = k;
      } while (k != i);
      j = k;
      this.offset += j;
      return localByteBuf;
    }
    finally
    {
      localByteBuf.release();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\stream\ChunkedNioFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
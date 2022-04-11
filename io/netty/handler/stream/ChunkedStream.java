package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class ChunkedStream
  implements ChunkedInput<ByteBuf>
{
  static final int DEFAULT_CHUNK_SIZE = 8192;
  private final int chunkSize;
  private boolean closed;
  private final PushbackInputStream in;
  private long offset;
  
  public ChunkedStream(InputStream paramInputStream)
  {
    this(paramInputStream, 8192);
  }
  
  public ChunkedStream(InputStream paramInputStream, int paramInt)
  {
    ObjectUtil.checkNotNull(paramInputStream, "in");
    ObjectUtil.checkPositive(paramInt, "chunkSize");
    if ((paramInputStream instanceof PushbackInputStream)) {
      this.in = ((PushbackInputStream)paramInputStream);
    } else {
      this.in = new PushbackInputStream(paramInputStream);
    }
    this.chunkSize = paramInt;
  }
  
  public void close()
    throws Exception
  {
    this.closed = true;
    this.in.close();
  }
  
  public boolean isEndOfInput()
    throws Exception
  {
    if (this.closed) {
      return true;
    }
    int i = this.in.read();
    if (i < 0) {
      return true;
    }
    this.in.unread(i);
    return false;
  }
  
  public long length()
  {
    return -1L;
  }
  
  public long progress()
  {
    return this.offset;
  }
  
  public ByteBuf readChunk(ByteBufAllocator paramByteBufAllocator)
    throws Exception
  {
    if (isEndOfInput()) {
      return null;
    }
    int i;
    if (this.in.available() <= 0) {
      i = this.chunkSize;
    } else {
      i = Math.min(this.chunkSize, this.in.available());
    }
    ByteBuf localByteBuf = paramByteBufAllocator.buffer(i);
    try
    {
      this.offset += localByteBuf.writeBytes(this.in, i);
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
  
  public long transferredBytes()
  {
    return this.offset;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\stream\ChunkedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
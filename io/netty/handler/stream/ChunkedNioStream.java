package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public class ChunkedNioStream
  implements ChunkedInput<ByteBuf>
{
  private final ByteBuffer byteBuffer;
  private final int chunkSize;
  private final ReadableByteChannel in;
  private long offset;
  
  public ChunkedNioStream(ReadableByteChannel paramReadableByteChannel)
  {
    this(paramReadableByteChannel, 8192);
  }
  
  public ChunkedNioStream(ReadableByteChannel paramReadableByteChannel, int paramInt)
  {
    ObjectUtil.checkNotNull(paramReadableByteChannel, "in");
    if (paramInt > 0)
    {
      this.in = paramReadableByteChannel;
      this.offset = 0L;
      this.chunkSize = paramInt;
      this.byteBuffer = ByteBuffer.allocate(paramInt);
      return;
    }
    paramReadableByteChannel = new StringBuilder();
    paramReadableByteChannel.append("chunkSize: ");
    paramReadableByteChannel.append(paramInt);
    paramReadableByteChannel.append(" (expected: a positive integer)");
    throw new IllegalArgumentException(paramReadableByteChannel.toString());
  }
  
  public void close()
    throws Exception
  {
    this.in.close();
  }
  
  public boolean isEndOfInput()
    throws Exception
  {
    if (this.byteBuffer.position() > 0) {
      return false;
    }
    if (this.in.isOpen())
    {
      int i = this.in.read(this.byteBuffer);
      if (i < 0) {
        return true;
      }
      this.offset += i;
      return false;
    }
    return true;
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
    int i = this.byteBuffer.position();
    int k;
    do
    {
      int j = this.in.read(this.byteBuffer);
      if (j < 0) {
        break;
      }
      k = i + j;
      this.offset += j;
      i = k;
    } while (k != this.chunkSize);
    this.byteBuffer.flip();
    ByteBuf localByteBuf = paramByteBufAllocator.buffer(this.byteBuffer.remaining());
    try
    {
      localByteBuf.writeBytes(this.byteBuffer);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\stream\ChunkedNioStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
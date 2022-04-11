package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public abstract class ZlibDecoder
  extends ByteToMessageDecoder
{
  protected final int maxAllocation;
  
  public ZlibDecoder()
  {
    this(0);
  }
  
  public ZlibDecoder(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.maxAllocation = paramInt;
      return;
    }
    throw new IllegalArgumentException("maxAllocation must be >= 0");
  }
  
  protected void decompressionBufferExhausted(ByteBuf paramByteBuf) {}
  
  public abstract boolean isClosed();
  
  protected ByteBuf prepareDecompressBuffer(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt)
  {
    if (paramByteBuf == null)
    {
      if (this.maxAllocation == 0) {
        return paramChannelHandlerContext.alloc().heapBuffer(paramInt);
      }
      return paramChannelHandlerContext.alloc().heapBuffer(Math.min(paramInt, this.maxAllocation), this.maxAllocation);
    }
    if (paramByteBuf.ensureWritable(paramInt, true) != 1) {
      return paramByteBuf;
    }
    decompressionBufferExhausted(paramByteBuf.duplicate());
    paramByteBuf.skipBytes(paramByteBuf.readableBytes());
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("Decompression buffer has reached maximum size: ");
    paramChannelHandlerContext.append(paramByteBuf.maxCapacity());
    throw new DecompressionException(paramChannelHandlerContext.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\ZlibDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
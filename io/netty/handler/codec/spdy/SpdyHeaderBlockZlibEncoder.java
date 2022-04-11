package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.zip.Deflater;

class SpdyHeaderBlockZlibEncoder
  extends SpdyHeaderBlockRawEncoder
{
  private final Deflater compressor;
  private boolean finished;
  
  SpdyHeaderBlockZlibEncoder(SpdyVersion paramSpdyVersion, int paramInt)
  {
    super(paramSpdyVersion);
    if ((paramInt >= 0) && (paramInt <= 9))
    {
      paramSpdyVersion = new Deflater(paramInt);
      this.compressor = paramSpdyVersion;
      paramSpdyVersion.setDictionary(SpdyCodecUtil.SPDY_DICT);
      return;
    }
    paramSpdyVersion = new StringBuilder();
    paramSpdyVersion.append("compressionLevel: ");
    paramSpdyVersion.append(paramInt);
    paramSpdyVersion.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramSpdyVersion.toString());
  }
  
  @SuppressJava6Requirement(reason="Guarded by java version check")
  private boolean compressInto(ByteBuf paramByteBuf)
  {
    byte[] arrayOfByte = paramByteBuf.array();
    int i = paramByteBuf.arrayOffset() + paramByteBuf.writerIndex();
    int j = paramByteBuf.writableBytes();
    if (PlatformDependent.javaVersion() >= 7) {
      i = this.compressor.deflate(arrayOfByte, i, j, 2);
    } else {
      i = this.compressor.deflate(arrayOfByte, i, j);
    }
    paramByteBuf.writerIndex(paramByteBuf.writerIndex() + i);
    boolean bool;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private ByteBuf encode(ByteBufAllocator paramByteBufAllocator, int paramInt)
  {
    paramByteBufAllocator = paramByteBufAllocator.heapBuffer(paramInt);
    try
    {
      while (compressInto(paramByteBufAllocator)) {
        paramByteBufAllocator.ensureWritable(paramByteBufAllocator.capacity() << 1);
      }
      return paramByteBufAllocator;
    }
    finally
    {
      paramByteBufAllocator.release();
    }
  }
  
  private int setInput(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    if (paramByteBuf.hasArray())
    {
      this.compressor.setInput(paramByteBuf.array(), paramByteBuf.arrayOffset() + paramByteBuf.readerIndex(), i);
    }
    else
    {
      byte[] arrayOfByte = new byte[i];
      paramByteBuf.getBytes(paramByteBuf.readerIndex(), arrayOfByte);
      this.compressor.setInput(arrayOfByte, 0, i);
    }
    return i;
  }
  
  public ByteBuf encode(ByteBufAllocator paramByteBufAllocator, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    if (paramSpdyHeadersFrame != null)
    {
      if (this.finished) {
        return Unpooled.EMPTY_BUFFER;
      }
      paramSpdyHeadersFrame = super.encode(paramByteBufAllocator, paramSpdyHeadersFrame);
      try
      {
        if (!paramSpdyHeadersFrame.isReadable())
        {
          paramByteBufAllocator = Unpooled.EMPTY_BUFFER;
          return paramByteBufAllocator;
        }
        paramByteBufAllocator = encode(paramByteBufAllocator, setInput(paramSpdyHeadersFrame));
        return paramByteBufAllocator;
      }
      finally
      {
        paramSpdyHeadersFrame.release();
      }
    }
    throw new IllegalArgumentException("frame");
  }
  
  public void end()
  {
    if (this.finished) {
      return;
    }
    this.finished = true;
    this.compressor.end();
    super.end();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeaderBlockZlibEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
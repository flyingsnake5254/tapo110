package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCounted;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

final class SpdyHeaderBlockZlibDecoder
  extends SpdyHeaderBlockRawDecoder
{
  private static final int DEFAULT_BUFFER_CAPACITY = 4096;
  private static final SpdyProtocolException INVALID_HEADER_BLOCK = new SpdyProtocolException("Invalid Header Block");
  private ByteBuf decompressed;
  private final Inflater decompressor = new Inflater();
  
  SpdyHeaderBlockZlibDecoder(SpdyVersion paramSpdyVersion, int paramInt)
  {
    super(paramSpdyVersion, paramInt);
  }
  
  private int decompress(ByteBufAllocator paramByteBufAllocator, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    ensureBuffer(paramByteBufAllocator);
    paramByteBufAllocator = this.decompressed.array();
    int i = this.decompressed.arrayOffset() + this.decompressed.writerIndex();
    try
    {
      int j = this.decompressor.inflate(paramByteBufAllocator, i, this.decompressed.writableBytes());
      int k = j;
      if (j == 0)
      {
        boolean bool = this.decompressor.needsDictionary();
        k = j;
        if (bool) {
          try
          {
            this.decompressor.setDictionary(SpdyCodecUtil.SPDY_DICT);
            k = this.decompressor.inflate(paramByteBufAllocator, i, this.decompressed.writableBytes());
          }
          catch (IllegalArgumentException paramByteBufAllocator)
          {
            throw INVALID_HEADER_BLOCK;
          }
        }
      }
      if (paramSpdyHeadersFrame != null)
      {
        paramByteBufAllocator = this.decompressed;
        paramByteBufAllocator.writerIndex(paramByteBufAllocator.writerIndex() + k);
        decodeHeaderBlock(this.decompressed, paramSpdyHeadersFrame);
        this.decompressed.discardReadBytes();
      }
      return k;
    }
    catch (DataFormatException paramByteBufAllocator)
    {
      throw new SpdyProtocolException("Received invalid header block", paramByteBufAllocator);
    }
  }
  
  private void ensureBuffer(ByteBufAllocator paramByteBufAllocator)
  {
    if (this.decompressed == null) {
      this.decompressed = paramByteBufAllocator.heapBuffer(4096);
    }
    this.decompressed.ensureWritable(1);
  }
  
  private void releaseBuffer()
  {
    ByteBuf localByteBuf = this.decompressed;
    if (localByteBuf != null)
    {
      localByteBuf.release();
      this.decompressed = null;
    }
  }
  
  private int setInput(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    if (paramByteBuf.hasArray())
    {
      this.decompressor.setInput(paramByteBuf.array(), paramByteBuf.arrayOffset() + paramByteBuf.readerIndex(), i);
    }
    else
    {
      byte[] arrayOfByte = new byte[i];
      paramByteBuf.getBytes(paramByteBuf.readerIndex(), arrayOfByte);
      this.decompressor.setInput(arrayOfByte, 0, i);
    }
    return i;
  }
  
  void decode(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    int i = setInput(paramByteBuf);
    while (decompress(paramByteBufAllocator, paramSpdyHeadersFrame) > 0) {}
    if (this.decompressor.getRemaining() == 0)
    {
      paramByteBuf.skipBytes(i);
      return;
    }
    throw INVALID_HEADER_BLOCK;
  }
  
  public void end()
  {
    super.end();
    releaseBuffer();
    this.decompressor.end();
  }
  
  void endHeaderBlock(SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    super.endHeaderBlock(paramSpdyHeadersFrame);
    releaseBuffer();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeaderBlockZlibDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
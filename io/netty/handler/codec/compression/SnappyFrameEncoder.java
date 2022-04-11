package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SnappyFrameEncoder
  extends MessageToByteEncoder<ByteBuf>
{
  private static final int MIN_COMPRESSIBLE_LENGTH = 18;
  private static final byte[] STREAM_START = { -1, 6, 0, 0, 115, 78, 97, 80, 112, 89 };
  private final Snappy snappy = new Snappy();
  private boolean started;
  
  private static void calculateAndWriteChecksum(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
  {
    paramByteBuf2.writeIntLE(Snappy.calculateChecksum(paramByteBuf1));
  }
  
  private static void setChunkLength(ByteBuf paramByteBuf, int paramInt)
  {
    int i = paramByteBuf.writerIndex() - paramInt - 3;
    if (i >>> 24 == 0)
    {
      paramByteBuf.setMediumLE(paramInt, i);
      return;
    }
    paramByteBuf = new StringBuilder();
    paramByteBuf.append("compressed data too large: ");
    paramByteBuf.append(i);
    throw new CompressionException(paramByteBuf.toString());
  }
  
  private static void writeChunkLength(ByteBuf paramByteBuf, int paramInt)
  {
    paramByteBuf.writeMediumLE(paramInt);
  }
  
  private static void writeUnencodedChunk(ByteBuf paramByteBuf1, ByteBuf paramByteBuf2, int paramInt)
  {
    paramByteBuf2.writeByte(1);
    writeChunkLength(paramByteBuf2, paramInt + 4);
    calculateAndWriteChecksum(paramByteBuf1, paramByteBuf2);
    paramByteBuf2.writeBytes(paramByteBuf1, paramInt);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
    throws Exception
  {
    if (!paramByteBuf1.isReadable()) {
      return;
    }
    if (!this.started)
    {
      this.started = true;
      paramByteBuf2.writeBytes(STREAM_START);
    }
    int i = paramByteBuf1.readableBytes();
    if (i > 18)
    {
      int j;
      for (;;)
      {
        j = paramByteBuf2.writerIndex() + 1;
        if (i < 18)
        {
          writeUnencodedChunk(paramByteBuf1.readSlice(i), paramByteBuf2, i);
          return;
        }
        paramByteBuf2.writeInt(0);
        if (i <= 32767) {
          break;
        }
        paramChannelHandlerContext = paramByteBuf1.readSlice(32767);
        calculateAndWriteChecksum(paramChannelHandlerContext, paramByteBuf2);
        this.snappy.encode(paramChannelHandlerContext, paramByteBuf2, 32767);
        setChunkLength(paramByteBuf2, j);
        i -= 32767;
      }
      paramChannelHandlerContext = paramByteBuf1.readSlice(i);
      calculateAndWriteChecksum(paramChannelHandlerContext, paramByteBuf2);
      this.snappy.encode(paramChannelHandlerContext, paramByteBuf2, i);
      setChunkLength(paramByteBuf2, j);
    }
    else
    {
      writeUnencodedChunk(paramByteBuf1, paramByteBuf2, i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\SnappyFrameEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
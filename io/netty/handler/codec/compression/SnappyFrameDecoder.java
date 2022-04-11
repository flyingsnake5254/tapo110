package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCounted;
import java.util.List;

public class SnappyFrameDecoder
  extends ByteToMessageDecoder
{
  private static final int MAX_UNCOMPRESSED_DATA_SIZE = 65540;
  private static final int SNAPPY_IDENTIFIER_LEN = 6;
  private boolean corrupted;
  private final Snappy snappy = new Snappy();
  private boolean started;
  private final boolean validateChecksums;
  
  public SnappyFrameDecoder()
  {
    this(false);
  }
  
  public SnappyFrameDecoder(boolean paramBoolean)
  {
    this.validateChecksums = paramBoolean;
  }
  
  private static void checkByte(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 == paramByte2) {
      return;
    }
    throw new DecompressionException("Unexpected stream identifier contents. Mismatched snappy protocol version?");
  }
  
  private static ChunkType mapChunkType(byte paramByte)
  {
    if (paramByte == 0) {
      return ChunkType.COMPRESSED_DATA;
    }
    if (paramByte == 1) {
      return ChunkType.UNCOMPRESSED_DATA;
    }
    if (paramByte == -1) {
      return ChunkType.STREAM_IDENTIFIER;
    }
    if ((paramByte & 0x80) == 128) {
      return ChunkType.RESERVED_SKIPPABLE;
    }
    return ChunkType.RESERVED_UNSKIPPABLE;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (this.corrupted)
    {
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
      return;
    }
    try
    {
      int i = paramByteBuf.readerIndex();
      int j = paramByteBuf.readableBytes();
      if (j < 4) {
        return;
      }
      int k = paramByteBuf.getUnsignedByte(i);
      ChunkType localChunkType = mapChunkType((byte)k);
      i = paramByteBuf.getUnsignedMediumLE(i + 1);
      int m = 1.$SwitchMap$io$netty$handler$codec$compression$SnappyFrameDecoder$ChunkType[localChunkType.ordinal()];
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4)
            {
              if (m == 5)
              {
                if (this.started)
                {
                  if (j < i + 4) {
                    return;
                  }
                  paramByteBuf.skipBytes(4);
                  k = paramByteBuf.readIntLE();
                  paramChannelHandlerContext = paramChannelHandlerContext.alloc().buffer();
                  try
                  {
                    if (this.validateChecksums) {
                      j = paramByteBuf.writerIndex();
                    }
                    try
                    {
                      paramByteBuf.writerIndex(paramByteBuf.readerIndex() + i - 4);
                      this.snappy.decode(paramByteBuf, paramChannelHandlerContext);
                      paramByteBuf.writerIndex(j);
                      Snappy.validateChecksum(k, paramChannelHandlerContext, 0, paramChannelHandlerContext.writerIndex());
                    }
                    finally
                    {
                      paramByteBuf.writerIndex(j);
                    }
                    paramList.add(paramChannelHandlerContext);
                    this.snappy.reset();
                  }
                  finally
                  {
                    if (paramChannelHandlerContext != null) {
                      paramChannelHandlerContext.release();
                    }
                  }
                }
                paramChannelHandlerContext = new io/netty/handler/codec/compression/DecompressionException;
                paramChannelHandlerContext.<init>("Received COMPRESSED_DATA tag before STREAM_IDENTIFIER");
                throw paramChannelHandlerContext;
              }
            }
            else if (this.started)
            {
              if (i <= 65540)
              {
                if (j < i + 4) {
                  return;
                }
                paramByteBuf.skipBytes(4);
                if (this.validateChecksums) {
                  Snappy.validateChecksum(paramByteBuf.readIntLE(), paramByteBuf, paramByteBuf.readerIndex(), i - 4);
                } else {
                  paramByteBuf.skipBytes(4);
                }
                paramList.add(paramByteBuf.readRetainedSlice(i - 4));
              }
              else
              {
                paramChannelHandlerContext = new io/netty/handler/codec/compression/DecompressionException;
                paramChannelHandlerContext.<init>("Received UNCOMPRESSED_DATA larger than 65540 bytes");
                throw paramChannelHandlerContext;
              }
            }
            else
            {
              paramChannelHandlerContext = new io/netty/handler/codec/compression/DecompressionException;
              paramChannelHandlerContext.<init>("Received UNCOMPRESSED_DATA tag before STREAM_IDENTIFIER");
              throw paramChannelHandlerContext;
            }
          }
          else
          {
            paramByteBuf = new io/netty/handler/codec/compression/DecompressionException;
            paramChannelHandlerContext = new java/lang/StringBuilder;
            paramChannelHandlerContext.<init>();
            paramChannelHandlerContext.append("Found reserved unskippable chunk type: 0x");
            paramChannelHandlerContext.append(Integer.toHexString(k));
            paramByteBuf.<init>(paramChannelHandlerContext.toString());
            throw paramByteBuf;
          }
        }
        else if (this.started)
        {
          i += 4;
          if (j < i) {
            return;
          }
          paramByteBuf.skipBytes(i);
        }
        else
        {
          paramChannelHandlerContext = new io/netty/handler/codec/compression/DecompressionException;
          paramChannelHandlerContext.<init>("Received RESERVED_SKIPPABLE tag before STREAM_IDENTIFIER");
          throw paramChannelHandlerContext;
        }
      }
      else
      {
        if (i != 6) {
          break label591;
        }
        if (j >= 10)
        {
          paramByteBuf.skipBytes(4);
          j = paramByteBuf.readerIndex();
          paramByteBuf.skipBytes(6);
          i = j + 1;
          checkByte(paramByteBuf.getByte(j), (byte)115);
          j = i + 1;
          checkByte(paramByteBuf.getByte(i), (byte)78);
          i = j + 1;
          checkByte(paramByteBuf.getByte(j), (byte)97);
          j = i + 1;
          checkByte(paramByteBuf.getByte(i), (byte)80);
          checkByte(paramByteBuf.getByte(j), (byte)112);
          checkByte(paramByteBuf.getByte(j + 1), (byte)89);
          this.started = true;
        }
      }
      return;
      label591:
      paramByteBuf = new io/netty/handler/codec/compression/DecompressionException;
      paramChannelHandlerContext = new java/lang/StringBuilder;
      paramChannelHandlerContext.<init>();
      paramChannelHandlerContext.append("Unexpected length of stream identifier: ");
      paramChannelHandlerContext.append(i);
      paramByteBuf.<init>(paramChannelHandlerContext.toString());
      throw paramByteBuf;
    }
    catch (Exception paramChannelHandlerContext)
    {
      this.corrupted = true;
      throw paramChannelHandlerContext;
    }
  }
  
  private static enum ChunkType
  {
    static
    {
      ChunkType localChunkType1 = new ChunkType("STREAM_IDENTIFIER", 0);
      STREAM_IDENTIFIER = localChunkType1;
      ChunkType localChunkType2 = new ChunkType("COMPRESSED_DATA", 1);
      COMPRESSED_DATA = localChunkType2;
      ChunkType localChunkType3 = new ChunkType("UNCOMPRESSED_DATA", 2);
      UNCOMPRESSED_DATA = localChunkType3;
      ChunkType localChunkType4 = new ChunkType("RESERVED_UNSKIPPABLE", 3);
      RESERVED_UNSKIPPABLE = localChunkType4;
      ChunkType localChunkType5 = new ChunkType("RESERVED_SKIPPABLE", 4);
      RESERVED_SKIPPABLE = localChunkType5;
      $VALUES = new ChunkType[] { localChunkType1, localChunkType2, localChunkType3, localChunkType4, localChunkType5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\SnappyFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
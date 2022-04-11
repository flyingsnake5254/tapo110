package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

public class FastLzFrameEncoder
  extends MessageToByteEncoder<ByteBuf>
{
  private final Checksum checksum;
  private final int level;
  
  public FastLzFrameEncoder()
  {
    this(0, null);
  }
  
  public FastLzFrameEncoder(int paramInt)
  {
    this(paramInt, null);
  }
  
  public FastLzFrameEncoder(int paramInt, Checksum paramChecksum)
  {
    super(false);
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException(String.format("level: %d (expected: %d or %d or %d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }));
    }
    this.level = paramInt;
    this.checksum = paramChecksum;
  }
  
  public FastLzFrameEncoder(boolean paramBoolean)
  {
    this(0, localAdler32);
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
    throws Exception
  {
    Checksum localChecksum = this.checksum;
    for (;;)
    {
      if (!paramByteBuf1.isReadable()) {
        return;
      }
      int i = paramByteBuf1.readerIndex();
      int j = Math.min(paramByteBuf1.readableBytes(), 65535);
      int k = paramByteBuf2.writerIndex();
      paramByteBuf2.setMedium(k, 4607066);
      int m = k + 4;
      if (localChecksum != null) {
        n = 4;
      } else {
        n = 0;
      }
      int n = m + n;
      byte[] arrayOfByte;
      int i1;
      if (j < 32)
      {
        paramByteBuf2.ensureWritable(n + 2 + j);
        arrayOfByte = paramByteBuf2.array();
        i1 = paramByteBuf2.arrayOffset() + n + 2;
        if (localChecksum != null)
        {
          if (paramByteBuf1.hasArray())
          {
            paramChannelHandlerContext = paramByteBuf1.array();
            i = paramByteBuf1.arrayOffset() + i;
          }
          else
          {
            paramChannelHandlerContext = new byte[j];
            paramByteBuf1.getBytes(i, paramChannelHandlerContext);
            i = 0;
          }
          localChecksum.reset();
          localChecksum.update(paramChannelHandlerContext, i, j);
          paramByteBuf2.setInt(m, (int)localChecksum.getValue());
          System.arraycopy(paramChannelHandlerContext, i, arrayOfByte, i1, j);
        }
        else
        {
          paramByteBuf1.getBytes(i, arrayOfByte, i1, j);
        }
      }
      for (;;)
      {
        m = j;
        i = 0;
        break;
        if (paramByteBuf1.hasArray())
        {
          paramChannelHandlerContext = paramByteBuf1.array();
          i1 = paramByteBuf1.arrayOffset();
          i = i1 + i;
        }
        else
        {
          paramChannelHandlerContext = new byte[j];
          paramByteBuf1.getBytes(i, paramChannelHandlerContext);
          i = 0;
        }
        if (localChecksum != null)
        {
          localChecksum.reset();
          localChecksum.update(paramChannelHandlerContext, i, j);
          paramByteBuf2.setInt(m, (int)localChecksum.getValue());
        }
        paramByteBuf2.ensureWritable(n + 4 + FastLz.calculateOutputBufferLength(j));
        arrayOfByte = paramByteBuf2.array();
        i1 = paramByteBuf2.arrayOffset() + n + 4;
        m = FastLz.compress(paramChannelHandlerContext, i, j, arrayOfByte, i1, this.level);
        if (m < j)
        {
          i = 1;
          paramByteBuf2.setShort(n, m);
          n += 2;
          break;
        }
        System.arraycopy(paramChannelHandlerContext, i, arrayOfByte, i1 - 2, j);
      }
      paramByteBuf2.setShort(n, j);
      if (localChecksum != null) {
        i1 = 16;
      } else {
        i1 = 0;
      }
      paramByteBuf2.setByte(k + 3, i | i1);
      paramByteBuf2.writerIndex(n + 2 + m);
      paramByteBuf1.skipBytes(j);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\FastLzFrameEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
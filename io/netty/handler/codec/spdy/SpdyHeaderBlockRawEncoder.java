package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.Headers;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SpdyHeaderBlockRawEncoder
  extends SpdyHeaderBlockEncoder
{
  private final int version;
  
  public SpdyHeaderBlockRawEncoder(SpdyVersion paramSpdyVersion)
  {
    this.version = ((SpdyVersion)ObjectUtil.checkNotNull(paramSpdyVersion, "version")).getVersion();
  }
  
  private static void setLengthField(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    paramByteBuf.setInt(paramInt1, paramInt2);
  }
  
  private static void writeLengthField(ByteBuf paramByteBuf, int paramInt)
  {
    paramByteBuf.writeInt(paramInt);
  }
  
  public ByteBuf encode(ByteBufAllocator paramByteBufAllocator, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    Object localObject = paramSpdyHeadersFrame.headers().names();
    int i = ((Set)localObject).size();
    if (i == 0) {
      return Unpooled.EMPTY_BUFFER;
    }
    if (i <= 65535)
    {
      ByteBuf localByteBuf = paramByteBufAllocator.heapBuffer();
      writeLengthField(localByteBuf, i);
      Iterator localIterator1 = ((Set)localObject).iterator();
      while (localIterator1.hasNext())
      {
        paramByteBufAllocator = (CharSequence)localIterator1.next();
        writeLengthField(localByteBuf, paramByteBufAllocator.length());
        ByteBufUtil.writeAscii(localByteBuf, paramByteBufAllocator);
        int j = localByteBuf.writerIndex();
        writeLengthField(localByteBuf, 0);
        Iterator localIterator2 = paramSpdyHeadersFrame.headers().getAll(paramByteBufAllocator).iterator();
        i = 0;
        while (localIterator2.hasNext())
        {
          localObject = (CharSequence)localIterator2.next();
          k = ((CharSequence)localObject).length();
          if (k > 0)
          {
            ByteBufUtil.writeAscii(localByteBuf, (CharSequence)localObject);
            localByteBuf.writeByte(0);
            i += k + 1;
          }
        }
        int k = i;
        if (i != 0) {
          k = i - 1;
        }
        if (k <= 65535)
        {
          if (k > 0)
          {
            setLengthField(localByteBuf, j, k);
            localByteBuf.writerIndex(localByteBuf.writerIndex() - 1);
          }
        }
        else
        {
          paramSpdyHeadersFrame = new StringBuilder();
          paramSpdyHeadersFrame.append("header exceeds allowable length: ");
          paramSpdyHeadersFrame.append(paramByteBufAllocator);
          throw new IllegalArgumentException(paramSpdyHeadersFrame.toString());
        }
      }
      return localByteBuf;
    }
    throw new IllegalArgumentException("header block contains too many headers");
  }
  
  void end() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeaderBlockRawEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
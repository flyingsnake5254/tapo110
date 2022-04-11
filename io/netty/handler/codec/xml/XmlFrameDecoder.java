package io.netty.handler.codec.xml;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;

public class XmlFrameDecoder
  extends ByteToMessageDecoder
{
  private final int maxFrameLength;
  
  public XmlFrameDecoder(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.maxFrameLength = paramInt;
      return;
    }
    throw new IllegalArgumentException("maxFrameLength must be a positive int");
  }
  
  private static ByteBuf extractFrame(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return paramByteBuf.copy(paramInt1, paramInt2);
  }
  
  private void fail(long paramLong)
  {
    if (paramLong > 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("frame length exceeds ");
      localStringBuilder.append(this.maxFrameLength);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" - discarded");
      throw new TooLongFrameException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("frame length exceeds ");
    localStringBuilder.append(this.maxFrameLength);
    localStringBuilder.append(" - discarding");
    throw new TooLongFrameException(localStringBuilder.toString());
  }
  
  private static void fail(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext.fireExceptionCaught(new CorruptedFrameException("frame contains content before the xml starts"));
  }
  
  private static boolean isCDATABlockStart(ByteBuf paramByteBuf, int paramInt)
  {
    boolean bool;
    if ((paramInt < paramByteBuf.writerIndex() - 8) && (paramByteBuf.getByte(paramInt + 2) == 91) && (paramByteBuf.getByte(paramInt + 3) == 67) && (paramByteBuf.getByte(paramInt + 4) == 68) && (paramByteBuf.getByte(paramInt + 5) == 65) && (paramByteBuf.getByte(paramInt + 6) == 84) && (paramByteBuf.getByte(paramInt + 7) == 65) && (paramByteBuf.getByte(paramInt + 8) == 91)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isCommentBlockStart(ByteBuf paramByteBuf, int paramInt)
  {
    boolean bool;
    if ((paramInt < paramByteBuf.writerIndex() - 3) && (paramByteBuf.getByte(paramInt + 2) == 45) && (paramByteBuf.getByte(paramInt + 3) == 45)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isValidStartCharForXmlElement(byte paramByte)
  {
    boolean bool;
    if (((paramByte < 97) || (paramByte > 122)) && ((paramByte < 65) || (paramByte > 90)) && (paramByte != 58) && (paramByte != 95)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.writerIndex();
    if (i > this.maxFrameLength)
    {
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
      fail(i);
      return;
    }
    int j = paramByteBuf.readerIndex();
    int k = 0;
    int m = 0;
    int n = 0;
    long l1 = 0L;
    int i1 = 0;
    long l2;
    int i3;
    int i8;
    for (int i2 = 0;; i2 = i8)
    {
      l2 = l1;
      i3 = i1;
      if (j >= i) {
        break;
      }
      i3 = paramByteBuf.getByte(j);
      int i4;
      int i5;
      int i6;
      long l3;
      int i7;
      if ((k == 0) && (Character.isWhitespace(i3)))
      {
        i4 = m + 1;
        i5 = k;
        i6 = n;
        l3 = l1;
        i7 = i1;
        i8 = i2;
      }
      else
      {
        if ((k == 0) && (i3 != 60))
        {
          fail(paramChannelHandlerContext);
          paramByteBuf.skipBytes(paramByteBuf.readableBytes());
          return;
        }
        if ((n == 0) && (i3 == 60))
        {
          i3 = i - 1;
          i6 = n;
          l2 = l1;
          k = i2;
          if (j < i3)
          {
            byte b = paramByteBuf.getByte(j + 1);
            if (b == 47) {
              for (i5 = j + 2;; i5++)
              {
                i6 = n;
                l2 = l1;
                k = i2;
                if (i5 > i3) {
                  break;
                }
                if (paramByteBuf.getByte(i5) == 62)
                {
                  l2 = l1 - 1L;
                  i6 = n;
                  k = i2;
                  break;
                }
              }
            }
            if (isValidStartCharForXmlElement(b))
            {
              l2 = l1 + 1L;
              k = 1;
              i6 = n;
            }
            else
            {
              if (b == 33)
              {
                if (!isCommentBlockStart(paramByteBuf, j))
                {
                  i6 = n;
                  l2 = l1;
                  k = i2;
                  if (!isCDATABlockStart(paramByteBuf, j)) {
                    break label373;
                  }
                  l2 = l1 + 1L;
                  i6 = 1;
                  k = i2;
                  break label373;
                }
              }
              else
              {
                i6 = n;
                l2 = l1;
                k = i2;
                if (b != 63) {
                  break label373;
                }
              }
              l2 = l1 + 1L;
              k = i2;
              i6 = n;
            }
          }
          label373:
          i5 = 1;
          i4 = m;
          l3 = l2;
          i7 = i1;
          i8 = k;
        }
        else if ((n == 0) && (i3 == 47))
        {
          i5 = k;
          i4 = m;
          i6 = n;
          l3 = l1;
          i7 = i1;
          i8 = i2;
          if (j < i - 1)
          {
            i5 = k;
            i4 = m;
            i6 = n;
            l3 = l1;
            i7 = i1;
            i8 = i2;
            if (paramByteBuf.getByte(j + 1) == 62)
            {
              l3 = l1 - 1L;
              i5 = k;
              i4 = m;
              i6 = n;
              i7 = i1;
              i8 = i2;
            }
          }
        }
        else
        {
          i5 = k;
          i4 = m;
          i6 = n;
          l3 = l1;
          i7 = i1;
          i8 = i2;
          if (i3 == 62)
          {
            i3 = j + 1;
            i6 = j - 1;
            i1 = n;
            l2 = l1;
            if (i6 > -1)
            {
              i6 = paramByteBuf.getByte(i6);
              if (n == 0)
              {
                if (i6 == 63) {}
                for (;;)
                {
                  l2 = l1 - 1L;
                  i1 = n;
                  break;
                  i1 = n;
                  l2 = l1;
                  if (i6 != 45) {
                    break;
                  }
                  i6 = j - 2;
                  i1 = n;
                  l2 = l1;
                  if (i6 <= -1) {
                    break;
                  }
                  i1 = n;
                  l2 = l1;
                  if (paramByteBuf.getByte(i6) != 45) {
                    break;
                  }
                }
              }
              i1 = n;
              l2 = l1;
              if (i6 == 93)
              {
                i6 = j - 2;
                i1 = n;
                l2 = l1;
                if (i6 > -1)
                {
                  i1 = n;
                  l2 = l1;
                  if (paramByteBuf.getByte(i6) == 93)
                  {
                    l2 = l1 - 1L;
                    i1 = 0;
                  }
                }
              }
            }
            i5 = k;
            i4 = m;
            i6 = i1;
            l3 = l2;
            i7 = i3;
            i8 = i2;
            if (i2 != 0)
            {
              i5 = k;
              i4 = m;
              i6 = i1;
              l3 = l2;
              i7 = i3;
              i8 = i2;
              if (l2 == 0L) {
                break;
              }
            }
          }
        }
      }
      j++;
      k = i5;
      m = i4;
      n = i6;
      l1 = l3;
      i1 = i7;
    }
    i1 = paramByteBuf.readerIndex();
    i2 = i3 - i1;
    if ((l2 == 0L) && (i2 > 0))
    {
      n = i2;
      if (i1 + i2 >= i) {
        n = paramByteBuf.readableBytes();
      }
      paramChannelHandlerContext = extractFrame(paramByteBuf, i1 + m, n - m);
      paramByteBuf.skipBytes(n);
      paramList.add(paramChannelHandlerContext);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.CharsetUtil;

final class DnsCodecUtil
{
  static String decodeDomainName(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.writerIndex();
    int j = paramByteBuf.readableBytes();
    if (j == 0) {
      return ".";
    }
    StringBuilder localStringBuilder = new StringBuilder(j << 1);
    int k = -1;
    j = 0;
    while (paramByteBuf.isReadable())
    {
      int m = paramByteBuf.readUnsignedByte();
      int n;
      if ((m & 0xC0) == 192) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0)
      {
        n = k;
        if (k == -1) {
          n = paramByteBuf.readerIndex() + 1;
        }
        if (paramByteBuf.isReadable())
        {
          k = (m & 0x3F) << 8 | paramByteBuf.readUnsignedByte();
          if (k < i)
          {
            paramByteBuf.readerIndex(k);
            j += 2;
            if (j < i) {
              k = n;
            } else {
              throw new CorruptedFrameException("name contains a loop.");
            }
          }
          else
          {
            throw new CorruptedFrameException("name has an out-of-range pointer");
          }
        }
        else
        {
          throw new CorruptedFrameException("truncated pointer in a name");
        }
      }
      else if (m != 0)
      {
        if (paramByteBuf.isReadable(m))
        {
          localStringBuilder.append(paramByteBuf.toString(paramByteBuf.readerIndex(), m, CharsetUtil.UTF_8));
          localStringBuilder.append('.');
          paramByteBuf.skipBytes(m);
        }
        else
        {
          throw new CorruptedFrameException("truncated label in a name");
        }
      }
    }
    if (k != -1) {
      paramByteBuf.readerIndex(k);
    }
    if (localStringBuilder.length() == 0) {
      return ".";
    }
    if (localStringBuilder.charAt(localStringBuilder.length() - 1) != '.') {
      localStringBuilder.append('.');
    }
    return localStringBuilder.toString();
  }
  
  static ByteBuf decompressDomainName(ByteBuf paramByteBuf)
  {
    String str = decodeDomainName(paramByteBuf);
    paramByteBuf = paramByteBuf.alloc().buffer(str.length() << 1);
    encodeDomainName(str, paramByteBuf);
    return paramByteBuf;
  }
  
  static void encodeDomainName(String paramString, ByteBuf paramByteBuf)
  {
    if (".".equals(paramString))
    {
      paramByteBuf.writeByte(0);
      return;
    }
    for (paramString : paramString.split("\\."))
    {
      int k = paramString.length();
      if (k == 0) {
        break;
      }
      paramByteBuf.writeByte(k);
      ByteBufUtil.writeAscii(paramByteBuf, paramString);
    }
    paramByteBuf.writeByte(0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsCodecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

public abstract interface Socks5AddressDecoder
{
  public static final Socks5AddressDecoder DEFAULT = new Socks5AddressDecoder()
  {
    private static final int IPv6_LEN = 16;
    
    public String decodeAddress(Socks5AddressType paramAnonymousSocks5AddressType, ByteBuf paramAnonymousByteBuf)
      throws Exception
    {
      if (paramAnonymousSocks5AddressType == Socks5AddressType.IPv4) {
        return NetUtil.intToIpAddress(paramAnonymousByteBuf.readInt());
      }
      int i;
      if (paramAnonymousSocks5AddressType == Socks5AddressType.DOMAIN)
      {
        i = paramAnonymousByteBuf.readUnsignedByte();
        paramAnonymousSocks5AddressType = paramAnonymousByteBuf.toString(paramAnonymousByteBuf.readerIndex(), i, CharsetUtil.US_ASCII);
        paramAnonymousByteBuf.skipBytes(i);
        return paramAnonymousSocks5AddressType;
      }
      if (paramAnonymousSocks5AddressType == Socks5AddressType.IPv6)
      {
        if (paramAnonymousByteBuf.hasArray())
        {
          i = paramAnonymousByteBuf.readerIndex();
          paramAnonymousByteBuf.readerIndex(i + 16);
          return NetUtil.bytesToIpAddress(paramAnonymousByteBuf.array(), paramAnonymousByteBuf.arrayOffset() + i, 16);
        }
        paramAnonymousSocks5AddressType = new byte[16];
        paramAnonymousByteBuf.readBytes(paramAnonymousSocks5AddressType);
        return NetUtil.bytesToIpAddress(paramAnonymousSocks5AddressType);
      }
      paramAnonymousByteBuf = new StringBuilder();
      paramAnonymousByteBuf.append("unsupported address type: ");
      paramAnonymousByteBuf.append(paramAnonymousSocks5AddressType.byteValue() & 0xFF);
      throw new DecoderException(paramAnonymousByteBuf.toString());
    }
  };
  
  public abstract String decodeAddress(Socks5AddressType paramSocks5AddressType, ByteBuf paramByteBuf)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5AddressDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
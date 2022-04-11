package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.EncoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

public abstract interface Socks5AddressEncoder
{
  public static final Socks5AddressEncoder DEFAULT = new Socks5AddressEncoder()
  {
    public void encodeAddress(Socks5AddressType paramAnonymousSocks5AddressType, String paramAnonymousString, ByteBuf paramAnonymousByteBuf)
      throws Exception
    {
      int i = paramAnonymousSocks5AddressType.byteValue();
      if (i == Socks5AddressType.IPv4.byteValue())
      {
        if (paramAnonymousString != null) {
          paramAnonymousByteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(paramAnonymousString));
        } else {
          paramAnonymousByteBuf.writeInt(0);
        }
      }
      else if (i == Socks5AddressType.DOMAIN.byteValue())
      {
        if (paramAnonymousString != null)
        {
          paramAnonymousByteBuf.writeByte(paramAnonymousString.length());
          paramAnonymousByteBuf.writeCharSequence(paramAnonymousString, CharsetUtil.US_ASCII);
        }
        else
        {
          paramAnonymousByteBuf.writeByte(0);
        }
      }
      else
      {
        if (i != Socks5AddressType.IPv6.byteValue()) {
          break label127;
        }
        if (paramAnonymousString != null)
        {
          paramAnonymousByteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(paramAnonymousString));
        }
        else
        {
          paramAnonymousByteBuf.writeLong(0L);
          paramAnonymousByteBuf.writeLong(0L);
        }
      }
      return;
      label127:
      paramAnonymousString = new StringBuilder();
      paramAnonymousString.append("unsupported addrType: ");
      paramAnonymousString.append(paramAnonymousSocks5AddressType.byteValue() & 0xFF);
      throw new EncoderException(paramAnonymousString.toString());
    }
  };
  
  public abstract void encodeAddress(Socks5AddressType paramSocks5AddressType, String paramString, ByteBuf paramByteBuf)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\Socks5AddressEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
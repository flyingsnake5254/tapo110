package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

final class SocksCommonUtils
{
  public static final SocksRequest UNKNOWN_SOCKS_REQUEST = new UnknownSocksRequest();
  public static final SocksResponse UNKNOWN_SOCKS_RESPONSE = new UnknownSocksResponse();
  private static final char ipv6hextetSeparator = ':';
  
  private static void appendHextet(StringBuilder paramStringBuilder, byte[] paramArrayOfByte, int paramInt)
  {
    StringUtil.toHexString(paramStringBuilder, paramArrayOfByte, paramInt << 1, 2);
  }
  
  public static String ipv6toStr(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(39);
    ipv6toStr(localStringBuilder, paramArrayOfByte, 0, 8);
    return localStringBuilder.toString();
  }
  
  private static void ipv6toStr(StringBuilder paramStringBuilder, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2 - 1)
    {
      appendHextet(paramStringBuilder, paramArrayOfByte, paramInt1);
      paramStringBuilder.append(':');
      paramInt1++;
    }
    appendHextet(paramStringBuilder, paramArrayOfByte, paramInt1);
  }
  
  static String readUsAscii(ByteBuf paramByteBuf, int paramInt)
  {
    String str = paramByteBuf.toString(paramByteBuf.readerIndex(), paramInt, CharsetUtil.US_ASCII);
    paramByteBuf.skipBytes(paramInt);
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socks\SocksCommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
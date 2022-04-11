package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

public final class DefaultSocks5CommandRequest
  extends AbstractSocks5Message
  implements Socks5CommandRequest
{
  private final String dstAddr;
  private final Socks5AddressType dstAddrType;
  private final int dstPort;
  private final Socks5CommandType type;
  
  public DefaultSocks5CommandRequest(Socks5CommandType paramSocks5CommandType, Socks5AddressType paramSocks5AddressType, String paramString, int paramInt)
  {
    this.type = ((Socks5CommandType)ObjectUtil.checkNotNull(paramSocks5CommandType, "type"));
    ObjectUtil.checkNotNull(paramSocks5AddressType, "dstAddrType");
    ObjectUtil.checkNotNull(paramString, "dstAddr");
    if (paramSocks5AddressType == Socks5AddressType.IPv4)
    {
      if (NetUtil.isValidIpV4Address(paramString))
      {
        paramSocks5CommandType = paramString;
      }
      else
      {
        paramSocks5CommandType = new StringBuilder();
        paramSocks5CommandType.append("dstAddr: ");
        paramSocks5CommandType.append(paramString);
        paramSocks5CommandType.append(" (expected: a valid IPv4 address)");
        throw new IllegalArgumentException(paramSocks5CommandType.toString());
      }
    }
    else if (paramSocks5AddressType == Socks5AddressType.DOMAIN)
    {
      paramSocks5CommandType = IDN.toASCII(paramString);
      if (paramSocks5CommandType.length() > 255)
      {
        paramSocks5AddressType = new StringBuilder();
        paramSocks5AddressType.append("dstAddr: ");
        paramSocks5AddressType.append(paramSocks5CommandType);
        paramSocks5AddressType.append(" (expected: less than 256 chars)");
        throw new IllegalArgumentException(paramSocks5AddressType.toString());
      }
    }
    else
    {
      paramSocks5CommandType = paramString;
      if (paramSocks5AddressType == Socks5AddressType.IPv6) {
        if (NetUtil.isValidIpV6Address(paramString))
        {
          paramSocks5CommandType = paramString;
        }
        else
        {
          paramSocks5CommandType = new StringBuilder();
          paramSocks5CommandType.append("dstAddr: ");
          paramSocks5CommandType.append(paramString);
          paramSocks5CommandType.append(" (expected: a valid IPv6 address");
          throw new IllegalArgumentException(paramSocks5CommandType.toString());
        }
      }
    }
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      this.dstAddrType = paramSocks5AddressType;
      this.dstAddr = paramSocks5CommandType;
      this.dstPort = paramInt;
      return;
    }
    paramSocks5CommandType = new StringBuilder();
    paramSocks5CommandType.append("dstPort: ");
    paramSocks5CommandType.append(paramInt);
    paramSocks5CommandType.append(" (expected: 0~65535)");
    throw new IllegalArgumentException(paramSocks5CommandType.toString());
  }
  
  public String dstAddr()
  {
    return this.dstAddr;
  }
  
  public Socks5AddressType dstAddrType()
  {
    return this.dstAddrType;
  }
  
  public int dstPort()
  {
    return this.dstPort;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    DecoderResult localDecoderResult = decoderResult();
    if (!localDecoderResult.isSuccess())
    {
      localStringBuilder.append("(decoderResult: ");
      localStringBuilder.append(localDecoderResult);
      localStringBuilder.append(", type: ");
    }
    else
    {
      localStringBuilder.append("(type: ");
    }
    localStringBuilder.append(type());
    localStringBuilder.append(", dstAddrType: ");
    localStringBuilder.append(dstAddrType());
    localStringBuilder.append(", dstAddr: ");
    localStringBuilder.append(dstAddr());
    localStringBuilder.append(", dstPort: ");
    localStringBuilder.append(dstPort());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public Socks5CommandType type()
  {
    return this.type;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\DefaultSocks5CommandRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
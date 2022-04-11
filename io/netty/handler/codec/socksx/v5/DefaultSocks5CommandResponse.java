package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

public final class DefaultSocks5CommandResponse
  extends AbstractSocks5Message
  implements Socks5CommandResponse
{
  private final String bndAddr;
  private final Socks5AddressType bndAddrType;
  private final int bndPort;
  private final Socks5CommandStatus status;
  
  public DefaultSocks5CommandResponse(Socks5CommandStatus paramSocks5CommandStatus, Socks5AddressType paramSocks5AddressType)
  {
    this(paramSocks5CommandStatus, paramSocks5AddressType, null, 0);
  }
  
  public DefaultSocks5CommandResponse(Socks5CommandStatus paramSocks5CommandStatus, Socks5AddressType paramSocks5AddressType, String paramString, int paramInt)
  {
    ObjectUtil.checkNotNull(paramSocks5CommandStatus, "status");
    ObjectUtil.checkNotNull(paramSocks5AddressType, "bndAddrType");
    String str = paramString;
    if (paramString != null) {
      if (paramSocks5AddressType == Socks5AddressType.IPv4)
      {
        if (NetUtil.isValidIpV4Address(paramString))
        {
          str = paramString;
        }
        else
        {
          paramSocks5CommandStatus = new StringBuilder();
          paramSocks5CommandStatus.append("bndAddr: ");
          paramSocks5CommandStatus.append(paramString);
          paramSocks5CommandStatus.append(" (expected: a valid IPv4 address)");
          throw new IllegalArgumentException(paramSocks5CommandStatus.toString());
        }
      }
      else if (paramSocks5AddressType == Socks5AddressType.DOMAIN)
      {
        str = IDN.toASCII(paramString);
        if (str.length() > 255)
        {
          paramSocks5CommandStatus = new StringBuilder();
          paramSocks5CommandStatus.append("bndAddr: ");
          paramSocks5CommandStatus.append(str);
          paramSocks5CommandStatus.append(" (expected: less than 256 chars)");
          throw new IllegalArgumentException(paramSocks5CommandStatus.toString());
        }
      }
      else
      {
        str = paramString;
        if (paramSocks5AddressType == Socks5AddressType.IPv6) {
          if (NetUtil.isValidIpV6Address(paramString))
          {
            str = paramString;
          }
          else
          {
            paramSocks5CommandStatus = new StringBuilder();
            paramSocks5CommandStatus.append("bndAddr: ");
            paramSocks5CommandStatus.append(paramString);
            paramSocks5CommandStatus.append(" (expected: a valid IPv6 address)");
            throw new IllegalArgumentException(paramSocks5CommandStatus.toString());
          }
        }
      }
    }
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      this.status = paramSocks5CommandStatus;
      this.bndAddrType = paramSocks5AddressType;
      this.bndAddr = str;
      this.bndPort = paramInt;
      return;
    }
    paramSocks5CommandStatus = new StringBuilder();
    paramSocks5CommandStatus.append("bndPort: ");
    paramSocks5CommandStatus.append(paramInt);
    paramSocks5CommandStatus.append(" (expected: 0~65535)");
    throw new IllegalArgumentException(paramSocks5CommandStatus.toString());
  }
  
  public String bndAddr()
  {
    return this.bndAddr;
  }
  
  public Socks5AddressType bndAddrType()
  {
    return this.bndAddrType;
  }
  
  public int bndPort()
  {
    return this.bndPort;
  }
  
  public Socks5CommandStatus status()
  {
    return this.status;
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
      localStringBuilder.append(", status: ");
    }
    else
    {
      localStringBuilder.append("(status: ");
    }
    localStringBuilder.append(status());
    localStringBuilder.append(", bndAddrType: ");
    localStringBuilder.append(bndAddrType());
    localStringBuilder.append(", bndAddr: ");
    localStringBuilder.append(bndAddr());
    localStringBuilder.append(", bndPort: ");
    localStringBuilder.append(bndPort());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\DefaultSocks5CommandResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
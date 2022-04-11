package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSocks4CommandResponse
  extends AbstractSocks4Message
  implements Socks4CommandResponse
{
  private final String dstAddr;
  private final int dstPort;
  private final Socks4CommandStatus status;
  
  public DefaultSocks4CommandResponse(Socks4CommandStatus paramSocks4CommandStatus)
  {
    this(paramSocks4CommandStatus, null, 0);
  }
  
  public DefaultSocks4CommandResponse(Socks4CommandStatus paramSocks4CommandStatus, String paramString, int paramInt)
  {
    if ((paramString != null) && (!NetUtil.isValidIpV4Address(paramString)))
    {
      paramSocks4CommandStatus = new StringBuilder();
      paramSocks4CommandStatus.append("dstAddr: ");
      paramSocks4CommandStatus.append(paramString);
      paramSocks4CommandStatus.append(" (expected: a valid IPv4 address)");
      throw new IllegalArgumentException(paramSocks4CommandStatus.toString());
    }
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      this.status = ((Socks4CommandStatus)ObjectUtil.checkNotNull(paramSocks4CommandStatus, "cmdStatus"));
      this.dstAddr = paramString;
      this.dstPort = paramInt;
      return;
    }
    paramSocks4CommandStatus = new StringBuilder();
    paramSocks4CommandStatus.append("dstPort: ");
    paramSocks4CommandStatus.append(paramInt);
    paramSocks4CommandStatus.append(" (expected: 0~65535)");
    throw new IllegalArgumentException(paramSocks4CommandStatus.toString());
  }
  
  public String dstAddr()
  {
    return this.dstAddr;
  }
  
  public int dstPort()
  {
    return this.dstPort;
  }
  
  public Socks4CommandStatus status()
  {
    return this.status;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(96);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    DecoderResult localDecoderResult = decoderResult();
    if (!localDecoderResult.isSuccess())
    {
      localStringBuilder.append("(decoderResult: ");
      localStringBuilder.append(localDecoderResult);
      localStringBuilder.append(", dstAddr: ");
    }
    else
    {
      localStringBuilder.append("(dstAddr: ");
    }
    localStringBuilder.append(dstAddr());
    localStringBuilder.append(", dstPort: ");
    localStringBuilder.append(dstPort());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\DefaultSocks4CommandResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
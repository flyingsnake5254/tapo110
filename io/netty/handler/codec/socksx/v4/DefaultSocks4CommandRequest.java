package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

public class DefaultSocks4CommandRequest
  extends AbstractSocks4Message
  implements Socks4CommandRequest
{
  private final String dstAddr;
  private final int dstPort;
  private final Socks4CommandType type;
  private final String userId;
  
  public DefaultSocks4CommandRequest(Socks4CommandType paramSocks4CommandType, String paramString, int paramInt)
  {
    this(paramSocks4CommandType, paramString, paramInt, "");
  }
  
  public DefaultSocks4CommandRequest(Socks4CommandType paramSocks4CommandType, String paramString1, int paramInt, String paramString2)
  {
    if ((paramInt > 0) && (paramInt < 65536))
    {
      this.type = ((Socks4CommandType)ObjectUtil.checkNotNull(paramSocks4CommandType, "type"));
      this.dstAddr = IDN.toASCII((String)ObjectUtil.checkNotNull(paramString1, "dstAddr"));
      this.userId = ((String)ObjectUtil.checkNotNull(paramString2, "userId"));
      this.dstPort = paramInt;
      return;
    }
    paramSocks4CommandType = new StringBuilder();
    paramSocks4CommandType.append("dstPort: ");
    paramSocks4CommandType.append(paramInt);
    paramSocks4CommandType.append(" (expected: 1~65535)");
    throw new IllegalArgumentException(paramSocks4CommandType.toString());
  }
  
  public String dstAddr()
  {
    return this.dstAddr;
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
    localStringBuilder.append(", dstAddr: ");
    localStringBuilder.append(dstAddr());
    localStringBuilder.append(", dstPort: ");
    localStringBuilder.append(dstPort());
    localStringBuilder.append(", userId: ");
    localStringBuilder.append(userId());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public Socks4CommandType type()
  {
    return this.type;
  }
  
  public String userId()
  {
    return this.userId;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v4\DefaultSocks4CommandRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
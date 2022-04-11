package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSocks5InitialResponse
  extends AbstractSocks5Message
  implements Socks5InitialResponse
{
  private final Socks5AuthMethod authMethod;
  
  public DefaultSocks5InitialResponse(Socks5AuthMethod paramSocks5AuthMethod)
  {
    this.authMethod = ((Socks5AuthMethod)ObjectUtil.checkNotNull(paramSocks5AuthMethod, "authMethod"));
  }
  
  public Socks5AuthMethod authMethod()
  {
    return this.authMethod;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    DecoderResult localDecoderResult = decoderResult();
    if (!localDecoderResult.isSuccess())
    {
      localStringBuilder.append("(decoderResult: ");
      localStringBuilder.append(localDecoderResult);
      localStringBuilder.append(", authMethod: ");
    }
    else
    {
      localStringBuilder.append("(authMethod: ");
    }
    localStringBuilder.append(authMethod());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\DefaultSocks5InitialResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
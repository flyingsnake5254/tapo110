package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSocks5PasswordAuthResponse
  extends AbstractSocks5Message
  implements Socks5PasswordAuthResponse
{
  private final Socks5PasswordAuthStatus status;
  
  public DefaultSocks5PasswordAuthResponse(Socks5PasswordAuthStatus paramSocks5PasswordAuthStatus)
  {
    this.status = ((Socks5PasswordAuthStatus)ObjectUtil.checkNotNull(paramSocks5PasswordAuthStatus, "status"));
  }
  
  public Socks5PasswordAuthStatus status()
  {
    return this.status;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
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
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\DefaultSocks5PasswordAuthResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
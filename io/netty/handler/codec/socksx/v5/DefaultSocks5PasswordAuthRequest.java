package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultSocks5PasswordAuthRequest
  extends AbstractSocks5Message
  implements Socks5PasswordAuthRequest
{
  private final String password;
  private final String username;
  
  public DefaultSocks5PasswordAuthRequest(String paramString1, String paramString2)
  {
    ObjectUtil.checkNotNull(paramString1, "username");
    ObjectUtil.checkNotNull(paramString2, "password");
    if (paramString1.length() <= 255)
    {
      if (paramString2.length() <= 255)
      {
        this.username = paramString1;
        this.password = paramString2;
        return;
      }
      throw new IllegalArgumentException("password: **** (expected: less than 256 chars)");
    }
    throw new IllegalArgumentException("username: **** (expected: less than 256 chars)");
  }
  
  public String password()
  {
    return this.password;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    DecoderResult localDecoderResult = decoderResult();
    if (!localDecoderResult.isSuccess())
    {
      localStringBuilder.append("(decoderResult: ");
      localStringBuilder.append(localDecoderResult);
      localStringBuilder.append(", username: ");
    }
    else
    {
      localStringBuilder.append("(username: ");
    }
    localStringBuilder.append(username());
    localStringBuilder.append(", password: ****)");
    return localStringBuilder.toString();
  }
  
  public String username()
  {
    return this.username;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\DefaultSocks5PasswordAuthRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
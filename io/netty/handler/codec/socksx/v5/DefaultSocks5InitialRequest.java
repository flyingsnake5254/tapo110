package io.netty.handler.codec.socksx.v5;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.socksx.AbstractSocksMessage;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DefaultSocks5InitialRequest
  extends AbstractSocks5Message
  implements Socks5InitialRequest
{
  private final List<Socks5AuthMethod> authMethods;
  
  public DefaultSocks5InitialRequest(Iterable<Socks5AuthMethod> paramIterable)
  {
    ObjectUtil.checkNotNull(paramIterable, "authSchemes");
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Socks5AuthMethod localSocks5AuthMethod = (Socks5AuthMethod)paramIterable.next();
      if (localSocks5AuthMethod == null) {
        break;
      }
      localArrayList.add(localSocks5AuthMethod);
    }
    if (!localArrayList.isEmpty())
    {
      this.authMethods = Collections.unmodifiableList(localArrayList);
      return;
    }
    throw new IllegalArgumentException("authMethods is empty");
  }
  
  public DefaultSocks5InitialRequest(Socks5AuthMethod... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "authMethods");
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Socks5AuthMethod localSocks5AuthMethod = paramVarArgs[j];
      if (localSocks5AuthMethod == null) {
        break;
      }
      localArrayList.add(localSocks5AuthMethod);
    }
    if (!localArrayList.isEmpty())
    {
      this.authMethods = Collections.unmodifiableList(localArrayList);
      return;
    }
    throw new IllegalArgumentException("authMethods is empty");
  }
  
  public List<Socks5AuthMethod> authMethods()
  {
    return this.authMethods;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(StringUtil.simpleClassName(this));
    DecoderResult localDecoderResult = decoderResult();
    if (!localDecoderResult.isSuccess())
    {
      localStringBuilder.append("(decoderResult: ");
      localStringBuilder.append(localDecoderResult);
      localStringBuilder.append(", authMethods: ");
    }
    else
    {
      localStringBuilder.append("(authMethods: ");
    }
    localStringBuilder.append(authMethods());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\socksx\v5\DefaultSocks5InitialRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
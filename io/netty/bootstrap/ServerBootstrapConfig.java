package io.netty.bootstrap;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.a;
import io.netty.util.AttributeKey;
import io.netty.util.internal.StringUtil;
import java.util.Map;

public final class ServerBootstrapConfig
  extends AbstractBootstrapConfig<ServerBootstrap, a>
{
  ServerBootstrapConfig(ServerBootstrap paramServerBootstrap)
  {
    super(paramServerBootstrap);
  }
  
  public Map<AttributeKey<?>, Object> childAttrs()
  {
    return ((ServerBootstrap)this.bootstrap).childAttrs();
  }
  
  public EventLoopGroup childGroup()
  {
    return ((ServerBootstrap)this.bootstrap).childGroup();
  }
  
  public ChannelHandler childHandler()
  {
    return ((ServerBootstrap)this.bootstrap).childHandler();
  }
  
  public Map<ChannelOption<?>, Object> childOptions()
  {
    return ((ServerBootstrap)this.bootstrap).childOptions();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    localStringBuilder.append(", ");
    Object localObject = childGroup();
    if (localObject != null)
    {
      localStringBuilder.append("childGroup: ");
      localStringBuilder.append(StringUtil.simpleClassName(localObject));
      localStringBuilder.append(", ");
    }
    localObject = childOptions();
    if (!((Map)localObject).isEmpty())
    {
      localStringBuilder.append("childOptions: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
    }
    localObject = childAttrs();
    if (!((Map)localObject).isEmpty())
    {
      localStringBuilder.append("childAttrs: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
    }
    localObject = childHandler();
    if (localObject != null)
    {
      localStringBuilder.append("childHandler: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
    }
    if (localStringBuilder.charAt(localStringBuilder.length() - 1) == '(')
    {
      localStringBuilder.append(')');
    }
    else
    {
      localStringBuilder.setCharAt(localStringBuilder.length() - 2, ')');
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\ServerBootstrapConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
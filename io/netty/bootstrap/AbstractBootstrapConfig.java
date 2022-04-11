package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.util.AttributeKey;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Map;

public abstract class AbstractBootstrapConfig<B extends AbstractBootstrap<B, C>, C extends Channel>
{
  protected final B bootstrap;
  
  protected AbstractBootstrapConfig(B paramB)
  {
    this.bootstrap = ((AbstractBootstrap)ObjectUtil.checkNotNull(paramB, "bootstrap"));
  }
  
  public final Map<AttributeKey<?>, Object> attrs()
  {
    return this.bootstrap.attrs();
  }
  
  public final ChannelFactory<? extends C> channelFactory()
  {
    return this.bootstrap.channelFactory();
  }
  
  public final EventLoopGroup group()
  {
    return this.bootstrap.group();
  }
  
  public final ChannelHandler handler()
  {
    return this.bootstrap.handler();
  }
  
  public final SocketAddress localAddress()
  {
    return this.bootstrap.localAddress();
  }
  
  public final Map<ChannelOption<?>, Object> options()
  {
    return this.bootstrap.options();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    Object localObject = group();
    if (localObject != null)
    {
      localStringBuilder.append("group: ");
      localStringBuilder.append(StringUtil.simpleClassName(localObject));
      localStringBuilder.append(", ");
    }
    localObject = channelFactory();
    if (localObject != null)
    {
      localStringBuilder.append("channelFactory: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
    }
    localObject = localAddress();
    if (localObject != null)
    {
      localStringBuilder.append("localAddress: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
    }
    localObject = options();
    if (!((Map)localObject).isEmpty())
    {
      localStringBuilder.append("options: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
    }
    localObject = attrs();
    if (!((Map)localObject).isEmpty())
    {
      localStringBuilder.append("attrs: ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", ");
    }
    localObject = handler();
    if (localObject != null)
    {
      localStringBuilder.append("handler: ");
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\bootstrap\AbstractBootstrapConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
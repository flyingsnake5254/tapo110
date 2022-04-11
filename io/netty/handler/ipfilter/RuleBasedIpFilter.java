package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;

@ChannelHandler.a
public class RuleBasedIpFilter
  extends AbstractRemoteAddressFilter<InetSocketAddress>
{
  private final IpFilterRule[] rules;
  
  public RuleBasedIpFilter(IpFilterRule... paramVarArgs)
  {
    this.rules = ((IpFilterRule[])ObjectUtil.checkNotNull(paramVarArgs, "rules"));
  }
  
  protected boolean accept(ChannelHandlerContext paramChannelHandlerContext, InetSocketAddress paramInetSocketAddress)
    throws Exception
  {
    paramChannelHandlerContext = this.rules;
    int i = paramChannelHandlerContext.length;
    boolean bool = false;
    for (int j = 0; j < i; j++)
    {
      Object localObject = paramChannelHandlerContext[j];
      if (localObject == null) {
        break;
      }
      if (((IpFilterRule)localObject).matches(paramInetSocketAddress))
      {
        if (((IpFilterRule)localObject).ruleType() == IpFilterRuleType.ACCEPT) {
          bool = true;
        }
        return bool;
      }
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ipfilter\RuleBasedIpFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
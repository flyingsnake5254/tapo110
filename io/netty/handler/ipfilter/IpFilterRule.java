package io.netty.handler.ipfilter;

import java.net.InetSocketAddress;

public abstract interface IpFilterRule
{
  public abstract boolean matches(InetSocketAddress paramInetSocketAddress);
  
  public abstract IpFilterRuleType ruleType();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ipfilter\IpFilterRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
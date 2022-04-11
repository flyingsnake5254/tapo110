package io.netty.handler.ipfilter;

public enum IpFilterRuleType
{
  static
  {
    IpFilterRuleType localIpFilterRuleType1 = new IpFilterRuleType("ACCEPT", 0);
    ACCEPT = localIpFilterRuleType1;
    IpFilterRuleType localIpFilterRuleType2 = new IpFilterRuleType("REJECT", 1);
    REJECT = localIpFilterRuleType2;
    $VALUES = new IpFilterRuleType[] { localIpFilterRuleType1, localIpFilterRuleType2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ipfilter\IpFilterRuleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
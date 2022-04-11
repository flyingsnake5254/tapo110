package io.netty.handler.ipfilter;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public final class IpSubnetFilterRule
  implements IpFilterRule
{
  private final IpFilterRule filterRule;
  
  public IpSubnetFilterRule(String paramString, int paramInt, IpFilterRuleType paramIpFilterRuleType)
  {
    try
    {
      this.filterRule = selectFilterRule(SocketUtils.addressByName(paramString), paramInt, paramIpFilterRuleType);
      return;
    }
    catch (UnknownHostException paramString)
    {
      throw new IllegalArgumentException("ipAddress", paramString);
    }
  }
  
  public IpSubnetFilterRule(InetAddress paramInetAddress, int paramInt, IpFilterRuleType paramIpFilterRuleType)
  {
    this.filterRule = selectFilterRule(paramInetAddress, paramInt, paramIpFilterRuleType);
  }
  
  private static IpFilterRule selectFilterRule(InetAddress paramInetAddress, int paramInt, IpFilterRuleType paramIpFilterRuleType)
  {
    ObjectUtil.checkNotNull(paramInetAddress, "ipAddress");
    ObjectUtil.checkNotNull(paramIpFilterRuleType, "ruleType");
    if ((paramInetAddress instanceof Inet4Address)) {
      return new Ip4SubnetFilterRule((Inet4Address)paramInetAddress, paramInt, paramIpFilterRuleType, null);
    }
    if ((paramInetAddress instanceof Inet6Address)) {
      return new Ip6SubnetFilterRule((Inet6Address)paramInetAddress, paramInt, paramIpFilterRuleType, null);
    }
    throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
  }
  
  public boolean matches(InetSocketAddress paramInetSocketAddress)
  {
    return this.filterRule.matches(paramInetSocketAddress);
  }
  
  public IpFilterRuleType ruleType()
  {
    return this.filterRule.ruleType();
  }
  
  private static final class Ip4SubnetFilterRule
    implements IpFilterRule
  {
    private final int networkAddress;
    private final IpFilterRuleType ruleType;
    private final int subnetMask;
    
    private Ip4SubnetFilterRule(Inet4Address paramInet4Address, int paramInt, IpFilterRuleType paramIpFilterRuleType)
    {
      if ((paramInt >= 0) && (paramInt <= 32))
      {
        paramInt = prefixToSubnetMask(paramInt);
        this.subnetMask = paramInt;
        this.networkAddress = (ipToInt(paramInet4Address) & paramInt);
        this.ruleType = paramIpFilterRuleType;
        return;
      }
      throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    
    private static int ipToInt(Inet4Address paramInet4Address)
    {
      paramInet4Address = paramInet4Address.getAddress();
      int i = paramInet4Address[0];
      int j = paramInet4Address[1];
      int k = paramInet4Address[2];
      return paramInet4Address[3] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
    }
    
    private static int prefixToSubnetMask(int paramInt)
    {
      return (int)(0xFFFFFFFFFFFFFFFF & -1L << 32 - paramInt);
    }
    
    public boolean matches(InetSocketAddress paramInetSocketAddress)
    {
      paramInetSocketAddress = paramInetSocketAddress.getAddress();
      boolean bool1 = paramInetSocketAddress instanceof Inet4Address;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        bool3 = bool2;
        if ((ipToInt((Inet4Address)paramInetSocketAddress) & this.subnetMask) == this.networkAddress) {
          bool3 = true;
        }
      }
      return bool3;
    }
    
    public IpFilterRuleType ruleType()
    {
      return this.ruleType;
    }
  }
  
  private static final class Ip6SubnetFilterRule
    implements IpFilterRule
  {
    private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1L);
    private final BigInteger networkAddress;
    private final IpFilterRuleType ruleType;
    private final BigInteger subnetMask;
    
    private Ip6SubnetFilterRule(Inet6Address paramInet6Address, int paramInt, IpFilterRuleType paramIpFilterRuleType)
    {
      if ((paramInt >= 0) && (paramInt <= 128))
      {
        BigInteger localBigInteger = prefixToSubnetMask(paramInt);
        this.subnetMask = localBigInteger;
        this.networkAddress = ipToInt(paramInet6Address).and(localBigInteger);
        this.ruleType = paramIpFilterRuleType;
        return;
      }
      throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    
    private static BigInteger ipToInt(Inet6Address paramInet6Address)
    {
      return new BigInteger(paramInet6Address.getAddress());
    }
    
    private static BigInteger prefixToSubnetMask(int paramInt)
    {
      return MINUS_ONE.shiftLeft(128 - paramInt);
    }
    
    public boolean matches(InetSocketAddress paramInetSocketAddress)
    {
      paramInetSocketAddress = paramInetSocketAddress.getAddress();
      if ((paramInetSocketAddress instanceof Inet6Address)) {
        return ipToInt((Inet6Address)paramInetSocketAddress).and(this.subnetMask).equals(this.networkAddress);
      }
      return false;
    }
    
    public IpFilterRuleType ruleType()
    {
      return this.ruleType;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ipfilter\IpSubnetFilterRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
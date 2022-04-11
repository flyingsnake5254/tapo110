package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

public abstract class AbstractDnsOptPseudoRrRecord
  extends AbstractDnsRecord
  implements DnsOptPseudoRecord
{
  protected AbstractDnsOptPseudoRrRecord(int paramInt)
  {
    super("", DnsRecordType.OPT, paramInt, 0L);
  }
  
  protected AbstractDnsOptPseudoRrRecord(int paramInt1, int paramInt2, int paramInt3)
  {
    super("", DnsRecordType.OPT, paramInt1, packIntoLong(paramInt2, paramInt3));
  }
  
  private static long packIntoLong(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & 0xFF) << 24 | (paramInt2 & 0xFF) << 16 | 0x0 | 0x0) & 0xFFFFFFFF;
  }
  
  public int extendedRcode()
  {
    return (short)((int)timeToLive() >> 24 & 0xFF);
  }
  
  public int flags()
  {
    return (short)((short)(int)timeToLive() & 0xFF);
  }
  
  public String toString()
  {
    return toStringBuilder().toString();
  }
  
  final StringBuilder toStringBuilder()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    localStringBuilder.append("OPT flags:");
    localStringBuilder.append(flags());
    localStringBuilder.append(" version:");
    localStringBuilder.append(version());
    localStringBuilder.append(" extendedRecode:");
    localStringBuilder.append(extendedRcode());
    localStringBuilder.append(" udp:");
    localStringBuilder.append(dnsClass());
    localStringBuilder.append(')');
    return localStringBuilder;
  }
  
  public int version()
  {
    return (short)((int)timeToLive() >> 16 & 0xFF);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\AbstractDnsOptPseudoRrRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
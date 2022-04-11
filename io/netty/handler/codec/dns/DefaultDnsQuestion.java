package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

public class DefaultDnsQuestion
  extends AbstractDnsRecord
  implements DnsQuestion
{
  public DefaultDnsQuestion(String paramString, DnsRecordType paramDnsRecordType)
  {
    super(paramString, paramDnsRecordType, 0L);
  }
  
  public DefaultDnsQuestion(String paramString, DnsRecordType paramDnsRecordType, int paramInt)
  {
    super(paramString, paramDnsRecordType, paramInt, 0L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(64);
    localStringBuilder1.append(StringUtil.simpleClassName(this));
    localStringBuilder1.append('(');
    localStringBuilder1.append(name());
    localStringBuilder1.append(' ');
    StringBuilder localStringBuilder2 = DnsMessageUtil.appendRecordClass(localStringBuilder1, dnsClass());
    localStringBuilder2.append(' ');
    localStringBuilder2.append(type().name());
    localStringBuilder2.append(')');
    return localStringBuilder1.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
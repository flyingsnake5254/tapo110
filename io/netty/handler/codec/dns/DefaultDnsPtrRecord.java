package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultDnsPtrRecord
  extends AbstractDnsRecord
  implements DnsPtrRecord
{
  private final String hostname;
  
  public DefaultDnsPtrRecord(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    super(paramString1, DnsRecordType.PTR, paramInt, paramLong);
    this.hostname = ((String)ObjectUtil.checkNotNull(paramString2, "hostname"));
  }
  
  public String hostname()
  {
    return this.hostname;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    DnsRecordType localDnsRecordType = type();
    if (name().isEmpty()) {
      localObject = "<root>";
    } else {
      localObject = name();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(' ');
    localStringBuilder.append(timeToLive());
    localStringBuilder.append(' ');
    Object localObject = DnsMessageUtil.appendRecordClass(localStringBuilder, dnsClass());
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(localDnsRecordType.name());
    localStringBuilder.append(' ');
    localStringBuilder.append(this.hostname);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsPtrRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
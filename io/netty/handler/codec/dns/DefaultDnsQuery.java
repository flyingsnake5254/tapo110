package io.netty.handler.codec.dns;

public class DefaultDnsQuery
  extends AbstractDnsMessage
  implements DnsQuery
{
  public DefaultDnsQuery(int paramInt)
  {
    super(paramInt);
  }
  
  public DefaultDnsQuery(int paramInt, DnsOpCode paramDnsOpCode)
  {
    super(paramInt, paramDnsOpCode);
  }
  
  public DnsQuery addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord)
  {
    return (DnsQuery)super.addRecord(paramDnsSection, paramInt, paramDnsRecord);
  }
  
  public DnsQuery addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DnsQuery)super.addRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DnsQuery clear()
  {
    return (DnsQuery)super.clear();
  }
  
  public DnsQuery clear(DnsSection paramDnsSection)
  {
    return (DnsQuery)super.clear(paramDnsSection);
  }
  
  public DnsQuery retain()
  {
    return (DnsQuery)super.retain();
  }
  
  public DnsQuery retain(int paramInt)
  {
    return (DnsQuery)super.retain(paramInt);
  }
  
  public DnsQuery setId(int paramInt)
  {
    return (DnsQuery)super.setId(paramInt);
  }
  
  public DnsQuery setOpCode(DnsOpCode paramDnsOpCode)
  {
    return (DnsQuery)super.setOpCode(paramDnsOpCode);
  }
  
  public DnsQuery setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DnsQuery)super.setRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DnsQuery setRecursionDesired(boolean paramBoolean)
  {
    return (DnsQuery)super.setRecursionDesired(paramBoolean);
  }
  
  public DnsQuery setZ(int paramInt)
  {
    return (DnsQuery)super.setZ(paramInt);
  }
  
  public String toString()
  {
    return DnsMessageUtil.appendQuery(new StringBuilder(128), this).toString();
  }
  
  public DnsQuery touch()
  {
    return (DnsQuery)super.touch();
  }
  
  public DnsQuery touch(Object paramObject)
  {
    return (DnsQuery)super.touch(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
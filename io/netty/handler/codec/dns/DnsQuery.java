package io.netty.handler.codec.dns;

public abstract interface DnsQuery
  extends DnsMessage
{
  public abstract DnsQuery addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord);
  
  public abstract DnsQuery addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord);
  
  public abstract DnsQuery clear();
  
  public abstract DnsQuery clear(DnsSection paramDnsSection);
  
  public abstract DnsQuery retain();
  
  public abstract DnsQuery retain(int paramInt);
  
  public abstract DnsQuery setId(int paramInt);
  
  public abstract DnsQuery setOpCode(DnsOpCode paramDnsOpCode);
  
  public abstract DnsQuery setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord);
  
  public abstract DnsQuery setRecursionDesired(boolean paramBoolean);
  
  public abstract DnsQuery setZ(int paramInt);
  
  public abstract DnsQuery touch();
  
  public abstract DnsQuery touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
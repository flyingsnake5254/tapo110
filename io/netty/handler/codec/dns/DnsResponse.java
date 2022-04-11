package io.netty.handler.codec.dns;

public abstract interface DnsResponse
  extends DnsMessage
{
  public abstract DnsResponse addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord);
  
  public abstract DnsResponse addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord);
  
  public abstract DnsResponse clear();
  
  public abstract DnsResponse clear(DnsSection paramDnsSection);
  
  public abstract DnsResponseCode code();
  
  public abstract boolean isAuthoritativeAnswer();
  
  public abstract boolean isRecursionAvailable();
  
  public abstract boolean isTruncated();
  
  public abstract DnsResponse retain();
  
  public abstract DnsResponse retain(int paramInt);
  
  public abstract DnsResponse setAuthoritativeAnswer(boolean paramBoolean);
  
  public abstract DnsResponse setCode(DnsResponseCode paramDnsResponseCode);
  
  public abstract DnsResponse setId(int paramInt);
  
  public abstract DnsResponse setOpCode(DnsOpCode paramDnsOpCode);
  
  public abstract DnsResponse setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord);
  
  public abstract DnsResponse setRecursionAvailable(boolean paramBoolean);
  
  public abstract DnsResponse setRecursionDesired(boolean paramBoolean);
  
  public abstract DnsResponse setTruncated(boolean paramBoolean);
  
  public abstract DnsResponse setZ(int paramInt);
  
  public abstract DnsResponse touch();
  
  public abstract DnsResponse touch(Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
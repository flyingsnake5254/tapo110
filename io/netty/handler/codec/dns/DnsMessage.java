package io.netty.handler.codec.dns;

import io.netty.util.ReferenceCounted;

public abstract interface DnsMessage
  extends ReferenceCounted
{
  public abstract DnsMessage addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord);
  
  public abstract DnsMessage addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord);
  
  public abstract DnsMessage clear();
  
  public abstract DnsMessage clear(DnsSection paramDnsSection);
  
  public abstract int count();
  
  public abstract int count(DnsSection paramDnsSection);
  
  public abstract int id();
  
  public abstract boolean isRecursionDesired();
  
  public abstract DnsOpCode opCode();
  
  public abstract <T extends DnsRecord> T recordAt(DnsSection paramDnsSection);
  
  public abstract <T extends DnsRecord> T recordAt(DnsSection paramDnsSection, int paramInt);
  
  public abstract <T extends DnsRecord> T removeRecord(DnsSection paramDnsSection, int paramInt);
  
  public abstract DnsMessage retain();
  
  public abstract DnsMessage retain(int paramInt);
  
  public abstract DnsMessage setId(int paramInt);
  
  public abstract DnsMessage setOpCode(DnsOpCode paramDnsOpCode);
  
  public abstract DnsMessage setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord);
  
  public abstract <T extends DnsRecord> T setRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord);
  
  public abstract DnsMessage setRecursionDesired(boolean paramBoolean);
  
  public abstract DnsMessage setZ(int paramInt);
  
  public abstract DnsMessage touch();
  
  public abstract DnsMessage touch(Object paramObject);
  
  public abstract int z();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DnsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;

public class DefaultDnsResponse
  extends AbstractDnsMessage
  implements DnsResponse
{
  private boolean authoritativeAnswer;
  private DnsResponseCode code;
  private boolean recursionAvailable;
  private boolean truncated;
  
  public DefaultDnsResponse(int paramInt)
  {
    this(paramInt, DnsOpCode.QUERY, DnsResponseCode.NOERROR);
  }
  
  public DefaultDnsResponse(int paramInt, DnsOpCode paramDnsOpCode)
  {
    this(paramInt, paramDnsOpCode, DnsResponseCode.NOERROR);
  }
  
  public DefaultDnsResponse(int paramInt, DnsOpCode paramDnsOpCode, DnsResponseCode paramDnsResponseCode)
  {
    super(paramInt, paramDnsOpCode);
    setCode(paramDnsResponseCode);
  }
  
  public DnsResponse addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord)
  {
    return (DnsResponse)super.addRecord(paramDnsSection, paramInt, paramDnsRecord);
  }
  
  public DnsResponse addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DnsResponse)super.addRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DnsResponse clear()
  {
    return (DnsResponse)super.clear();
  }
  
  public DnsResponse clear(DnsSection paramDnsSection)
  {
    return (DnsResponse)super.clear(paramDnsSection);
  }
  
  public DnsResponseCode code()
  {
    return this.code;
  }
  
  public boolean isAuthoritativeAnswer()
  {
    return this.authoritativeAnswer;
  }
  
  public boolean isRecursionAvailable()
  {
    return this.recursionAvailable;
  }
  
  public boolean isTruncated()
  {
    return this.truncated;
  }
  
  public DnsResponse retain()
  {
    return (DnsResponse)super.retain();
  }
  
  public DnsResponse retain(int paramInt)
  {
    return (DnsResponse)super.retain(paramInt);
  }
  
  public DnsResponse setAuthoritativeAnswer(boolean paramBoolean)
  {
    this.authoritativeAnswer = paramBoolean;
    return this;
  }
  
  public DnsResponse setCode(DnsResponseCode paramDnsResponseCode)
  {
    this.code = ((DnsResponseCode)ObjectUtil.checkNotNull(paramDnsResponseCode, "code"));
    return this;
  }
  
  public DnsResponse setId(int paramInt)
  {
    return (DnsResponse)super.setId(paramInt);
  }
  
  public DnsResponse setOpCode(DnsOpCode paramDnsOpCode)
  {
    return (DnsResponse)super.setOpCode(paramDnsOpCode);
  }
  
  public DnsResponse setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DnsResponse)super.setRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DnsResponse setRecursionAvailable(boolean paramBoolean)
  {
    this.recursionAvailable = paramBoolean;
    return this;
  }
  
  public DnsResponse setRecursionDesired(boolean paramBoolean)
  {
    return (DnsResponse)super.setRecursionDesired(paramBoolean);
  }
  
  public DnsResponse setTruncated(boolean paramBoolean)
  {
    this.truncated = paramBoolean;
    return this;
  }
  
  public DnsResponse setZ(int paramInt)
  {
    return (DnsResponse)super.setZ(paramInt);
  }
  
  public String toString()
  {
    return DnsMessageUtil.appendResponse(new StringBuilder(128), this).toString();
  }
  
  public DnsResponse touch()
  {
    return (DnsResponse)super.touch();
  }
  
  public DnsResponse touch(Object paramObject)
  {
    return (DnsResponse)super.touch(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
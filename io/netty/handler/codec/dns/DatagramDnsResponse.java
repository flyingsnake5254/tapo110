package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import java.net.InetSocketAddress;
import java.util.Objects;

public class DatagramDnsResponse
  extends DefaultDnsResponse
  implements AddressedEnvelope<DatagramDnsResponse, InetSocketAddress>
{
  private final InetSocketAddress recipient;
  private final InetSocketAddress sender;
  
  public DatagramDnsResponse(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, int paramInt)
  {
    this(paramInetSocketAddress1, paramInetSocketAddress2, paramInt, DnsOpCode.QUERY, DnsResponseCode.NOERROR);
  }
  
  public DatagramDnsResponse(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, int paramInt, DnsOpCode paramDnsOpCode)
  {
    this(paramInetSocketAddress1, paramInetSocketAddress2, paramInt, paramDnsOpCode, DnsResponseCode.NOERROR);
  }
  
  public DatagramDnsResponse(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, int paramInt, DnsOpCode paramDnsOpCode, DnsResponseCode paramDnsResponseCode)
  {
    super(paramInt, paramDnsOpCode, paramDnsResponseCode);
    if (paramInetSocketAddress2 == null) {
      Objects.requireNonNull(paramInetSocketAddress1, "recipient and sender");
    }
    this.sender = paramInetSocketAddress1;
    this.recipient = paramInetSocketAddress2;
  }
  
  public DatagramDnsResponse addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord)
  {
    return (DatagramDnsResponse)super.addRecord(paramDnsSection, paramInt, paramDnsRecord);
  }
  
  public DatagramDnsResponse addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DatagramDnsResponse)super.addRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DatagramDnsResponse clear()
  {
    return (DatagramDnsResponse)super.clear();
  }
  
  public DatagramDnsResponse clear(DnsSection paramDnsSection)
  {
    return (DatagramDnsResponse)super.clear(paramDnsSection);
  }
  
  public DatagramDnsResponse content()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    if (!(paramObject instanceof AddressedEnvelope)) {
      return false;
    }
    paramObject = (AddressedEnvelope)paramObject;
    if (sender() == null)
    {
      if (((AddressedEnvelope)paramObject).sender() != null) {
        return false;
      }
    }
    else if (!sender().equals(((AddressedEnvelope)paramObject).sender())) {
      return false;
    }
    if (recipient() == null)
    {
      if (((AddressedEnvelope)paramObject).recipient() != null) {
        return false;
      }
    }
    else if (!recipient().equals(((AddressedEnvelope)paramObject).recipient())) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    int j = i;
    if (sender() != null) {
      j = i * 31 + sender().hashCode();
    }
    i = j;
    if (recipient() != null) {
      i = j * 31 + recipient().hashCode();
    }
    return i;
  }
  
  public InetSocketAddress recipient()
  {
    return this.recipient;
  }
  
  public DatagramDnsResponse retain()
  {
    return (DatagramDnsResponse)super.retain();
  }
  
  public DatagramDnsResponse retain(int paramInt)
  {
    return (DatagramDnsResponse)super.retain(paramInt);
  }
  
  public InetSocketAddress sender()
  {
    return this.sender;
  }
  
  public DatagramDnsResponse setAuthoritativeAnswer(boolean paramBoolean)
  {
    return (DatagramDnsResponse)super.setAuthoritativeAnswer(paramBoolean);
  }
  
  public DatagramDnsResponse setCode(DnsResponseCode paramDnsResponseCode)
  {
    return (DatagramDnsResponse)super.setCode(paramDnsResponseCode);
  }
  
  public DatagramDnsResponse setId(int paramInt)
  {
    return (DatagramDnsResponse)super.setId(paramInt);
  }
  
  public DatagramDnsResponse setOpCode(DnsOpCode paramDnsOpCode)
  {
    return (DatagramDnsResponse)super.setOpCode(paramDnsOpCode);
  }
  
  public DatagramDnsResponse setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DatagramDnsResponse)super.setRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DatagramDnsResponse setRecursionAvailable(boolean paramBoolean)
  {
    return (DatagramDnsResponse)super.setRecursionAvailable(paramBoolean);
  }
  
  public DatagramDnsResponse setRecursionDesired(boolean paramBoolean)
  {
    return (DatagramDnsResponse)super.setRecursionDesired(paramBoolean);
  }
  
  public DatagramDnsResponse setTruncated(boolean paramBoolean)
  {
    return (DatagramDnsResponse)super.setTruncated(paramBoolean);
  }
  
  public DatagramDnsResponse setZ(int paramInt)
  {
    return (DatagramDnsResponse)super.setZ(paramInt);
  }
  
  public DatagramDnsResponse touch()
  {
    return (DatagramDnsResponse)super.touch();
  }
  
  public DatagramDnsResponse touch(Object paramObject)
  {
    return (DatagramDnsResponse)super.touch(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DatagramDnsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
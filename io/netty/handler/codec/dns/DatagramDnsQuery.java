package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import java.net.InetSocketAddress;
import java.util.Objects;

public class DatagramDnsQuery
  extends DefaultDnsQuery
  implements AddressedEnvelope<DatagramDnsQuery, InetSocketAddress>
{
  private final InetSocketAddress recipient;
  private final InetSocketAddress sender;
  
  public DatagramDnsQuery(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, int paramInt)
  {
    this(paramInetSocketAddress1, paramInetSocketAddress2, paramInt, DnsOpCode.QUERY);
  }
  
  public DatagramDnsQuery(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, int paramInt, DnsOpCode paramDnsOpCode)
  {
    super(paramInt, paramDnsOpCode);
    if (paramInetSocketAddress2 == null) {
      Objects.requireNonNull(paramInetSocketAddress1, "recipient and sender");
    }
    this.sender = paramInetSocketAddress1;
    this.recipient = paramInetSocketAddress2;
  }
  
  public DatagramDnsQuery addRecord(DnsSection paramDnsSection, int paramInt, DnsRecord paramDnsRecord)
  {
    return (DatagramDnsQuery)super.addRecord(paramDnsSection, paramInt, paramDnsRecord);
  }
  
  public DatagramDnsQuery addRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DatagramDnsQuery)super.addRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DatagramDnsQuery clear()
  {
    return (DatagramDnsQuery)super.clear();
  }
  
  public DatagramDnsQuery clear(DnsSection paramDnsSection)
  {
    return (DatagramDnsQuery)super.clear(paramDnsSection);
  }
  
  public DatagramDnsQuery content()
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
  
  public DatagramDnsQuery retain()
  {
    return (DatagramDnsQuery)super.retain();
  }
  
  public DatagramDnsQuery retain(int paramInt)
  {
    return (DatagramDnsQuery)super.retain(paramInt);
  }
  
  public InetSocketAddress sender()
  {
    return this.sender;
  }
  
  public DatagramDnsQuery setId(int paramInt)
  {
    return (DatagramDnsQuery)super.setId(paramInt);
  }
  
  public DatagramDnsQuery setOpCode(DnsOpCode paramDnsOpCode)
  {
    return (DatagramDnsQuery)super.setOpCode(paramDnsOpCode);
  }
  
  public DatagramDnsQuery setRecord(DnsSection paramDnsSection, DnsRecord paramDnsRecord)
  {
    return (DatagramDnsQuery)super.setRecord(paramDnsSection, paramDnsRecord);
  }
  
  public DatagramDnsQuery setRecursionDesired(boolean paramBoolean)
  {
    return (DatagramDnsQuery)super.setRecursionDesired(paramBoolean);
  }
  
  public DatagramDnsQuery setZ(int paramInt)
  {
    return (DatagramDnsQuery)super.setZ(paramInt);
  }
  
  public DatagramDnsQuery touch()
  {
    return (DatagramDnsQuery)super.touch();
  }
  
  public DatagramDnsQuery touch(Object paramObject)
  {
    return (DatagramDnsQuery)super.touch(paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DatagramDnsQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
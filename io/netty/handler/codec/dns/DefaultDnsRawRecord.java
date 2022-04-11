package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultDnsRawRecord
  extends AbstractDnsRecord
  implements DnsRawRecord
{
  private final ByteBuf content;
  
  public DefaultDnsRawRecord(String paramString, DnsRecordType paramDnsRecordType, int paramInt, long paramLong, ByteBuf paramByteBuf)
  {
    super(paramString, paramDnsRecordType, paramInt, paramLong);
    this.content = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "content"));
  }
  
  public DefaultDnsRawRecord(String paramString, DnsRecordType paramDnsRecordType, long paramLong, ByteBuf paramByteBuf)
  {
    this(paramString, paramDnsRecordType, 1, paramLong, paramByteBuf);
  }
  
  public ByteBuf content()
  {
    return this.content;
  }
  
  public DnsRawRecord copy()
  {
    return replace(content().copy());
  }
  
  public DnsRawRecord duplicate()
  {
    return replace(content().duplicate());
  }
  
  public int refCnt()
  {
    return content().refCnt();
  }
  
  public boolean release()
  {
    return content().release();
  }
  
  public boolean release(int paramInt)
  {
    return content().release(paramInt);
  }
  
  public DnsRawRecord replace(ByteBuf paramByteBuf)
  {
    return new DefaultDnsRawRecord(name(), type(), dnsClass(), timeToLive(), paramByteBuf);
  }
  
  public DnsRawRecord retain()
  {
    content().retain();
    return this;
  }
  
  public DnsRawRecord retain(int paramInt)
  {
    content().retain(paramInt);
    return this;
  }
  
  public DnsRawRecord retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append('(');
    DnsRecordType localDnsRecordType = type();
    if (localDnsRecordType != DnsRecordType.OPT)
    {
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
    }
    else
    {
      localStringBuilder.append("OPT flags:");
      localStringBuilder.append(timeToLive());
      localStringBuilder.append(" udp:");
      localStringBuilder.append(dnsClass());
    }
    localStringBuilder.append(' ');
    localStringBuilder.append(content().readableBytes());
    localStringBuilder.append("B)");
    return localStringBuilder.toString();
  }
  
  public DnsRawRecord touch()
  {
    content().touch();
    return this;
  }
  
  public DnsRawRecord touch(Object paramObject)
  {
    content().touch(paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\DefaultDnsRawRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
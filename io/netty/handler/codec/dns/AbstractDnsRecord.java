package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

public abstract class AbstractDnsRecord
  implements DnsRecord
{
  private final short dnsClass;
  private int hashCode;
  private final String name;
  private final long timeToLive;
  private final DnsRecordType type;
  
  protected AbstractDnsRecord(String paramString, DnsRecordType paramDnsRecordType, int paramInt, long paramLong)
  {
    ObjectUtil.checkPositiveOrZero(paramLong, "timeToLive");
    this.name = appendTrailingDot(IDNtoASCII(paramString));
    this.type = ((DnsRecordType)ObjectUtil.checkNotNull(paramDnsRecordType, "type"));
    this.dnsClass = ((short)(short)paramInt);
    this.timeToLive = paramLong;
  }
  
  protected AbstractDnsRecord(String paramString, DnsRecordType paramDnsRecordType, long paramLong)
  {
    this(paramString, paramDnsRecordType, 1, paramLong);
  }
  
  private static String IDNtoASCII(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "name");
    if ((PlatformDependent.isAndroid()) && (".".equals(paramString))) {
      return paramString;
    }
    return IDN.toASCII(paramString);
  }
  
  private static String appendTrailingDot(String paramString)
  {
    Object localObject = paramString;
    if (paramString.length() > 0)
    {
      localObject = paramString;
      if (paramString.charAt(paramString.length() - 1) != '.')
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append('.');
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return (String)localObject;
  }
  
  public int dnsClass()
  {
    return this.dnsClass & 0xFFFF;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DnsRecord)) {
      return false;
    }
    paramObject = (DnsRecord)paramObject;
    int i = this.hashCode;
    if ((i != 0) && (i != paramObject.hashCode())) {
      return false;
    }
    if ((type().intValue() != ((DnsRecord)paramObject).type().intValue()) || (dnsClass() != ((DnsRecord)paramObject).dnsClass()) || (!name().equals(((DnsRecord)paramObject).name()))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    i = this.name.hashCode() * 31 + type().intValue() * 31 + dnsClass();
    this.hashCode = i;
    return i;
  }
  
  public String name()
  {
    return this.name;
  }
  
  public long timeToLive()
  {
    return this.timeToLive;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(64);
    localStringBuilder1.append(StringUtil.simpleClassName(this));
    localStringBuilder1.append('(');
    localStringBuilder1.append(name());
    localStringBuilder1.append(' ');
    localStringBuilder1.append(timeToLive());
    localStringBuilder1.append(' ');
    StringBuilder localStringBuilder2 = DnsMessageUtil.appendRecordClass(localStringBuilder1, dnsClass());
    localStringBuilder2.append(' ');
    localStringBuilder2.append(type().name());
    localStringBuilder2.append(')');
    return localStringBuilder1.toString();
  }
  
  public DnsRecordType type()
  {
    return this.type;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\dns\AbstractDnsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
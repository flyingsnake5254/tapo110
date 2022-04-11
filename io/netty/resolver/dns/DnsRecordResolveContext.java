package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;
import java.net.UnknownHostException;
import java.util.List;

final class DnsRecordResolveContext
  extends DnsResolveContext<DnsRecord>
{
  DnsRecordResolveContext(DnsNameResolver paramDnsNameResolver, Promise<?> paramPromise, DnsQuestion paramDnsQuestion, DnsRecord[] paramArrayOfDnsRecord, DnsServerAddressStream paramDnsServerAddressStream)
  {
    this(paramDnsNameResolver, paramPromise, paramDnsQuestion.name(), paramDnsQuestion.dnsClass(), new DnsRecordType[] { paramDnsQuestion.type() }, paramArrayOfDnsRecord, paramDnsServerAddressStream);
  }
  
  private DnsRecordResolveContext(DnsNameResolver paramDnsNameResolver, Promise<?> paramPromise, String paramString, int paramInt, DnsRecordType[] paramArrayOfDnsRecordType, DnsRecord[] paramArrayOfDnsRecord, DnsServerAddressStream paramDnsServerAddressStream)
  {
    super(paramDnsNameResolver, paramPromise, paramString, paramInt, paramArrayOfDnsRecordType, paramArrayOfDnsRecord, paramDnsServerAddressStream);
  }
  
  void cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, DnsRecord paramDnsRecord1, DnsRecord paramDnsRecord2) {}
  
  void cache(String paramString, DnsRecord[] paramArrayOfDnsRecord, UnknownHostException paramUnknownHostException) {}
  
  DnsRecord convertRecord(DnsRecord paramDnsRecord, String paramString, DnsRecord[] paramArrayOfDnsRecord, EventLoop paramEventLoop)
  {
    return (DnsRecord)ReferenceCountUtil.retain(paramDnsRecord);
  }
  
  List<DnsRecord> filterResults(List<DnsRecord> paramList)
  {
    return paramList;
  }
  
  boolean isCompleteEarly(DnsRecord paramDnsRecord)
  {
    return false;
  }
  
  boolean isDuplicateAllowed()
  {
    return true;
  }
  
  DnsResolveContext<DnsRecord> newResolverContext(DnsNameResolver paramDnsNameResolver, Promise<?> paramPromise, String paramString, int paramInt, DnsRecordType[] paramArrayOfDnsRecordType, DnsRecord[] paramArrayOfDnsRecord, DnsServerAddressStream paramDnsServerAddressStream)
  {
    return new DnsRecordResolveContext(paramDnsNameResolver, paramPromise, paramString, paramInt, paramArrayOfDnsRecordType, paramArrayOfDnsRecord, paramDnsServerAddressStream);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsRecordResolveContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
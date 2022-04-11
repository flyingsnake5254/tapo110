package io.netty.resolver.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.handler.codec.dns.DatagramDnsQuery;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.util.concurrent.Promise;
import java.net.InetSocketAddress;

final class DatagramDnsQueryContext
  extends DnsQueryContext
{
  DatagramDnsQueryContext(DnsNameResolver paramDnsNameResolver, InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, DnsRecord[] paramArrayOfDnsRecord, Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> paramPromise)
  {
    super(paramDnsNameResolver, paramInetSocketAddress, paramDnsQuestion, paramArrayOfDnsRecord, paramPromise);
  }
  
  protected Channel channel()
  {
    return parent().ch;
  }
  
  protected DnsQuery newQuery(int paramInt)
  {
    return new DatagramDnsQuery(null, nameServerAddr(), paramInt);
  }
  
  protected String protocol()
  {
    return "UDP";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DatagramDnsQueryContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import java.net.InetSocketAddress;
import java.util.List;

final class NoopDnsQueryLifecycleObserver
  implements DnsQueryLifecycleObserver
{
  static final NoopDnsQueryLifecycleObserver INSTANCE = new NoopDnsQueryLifecycleObserver();
  
  public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion paramDnsQuestion)
  {
    return this;
  }
  
  public void queryCancelled(int paramInt) {}
  
  public void queryFailed(Throwable paramThrowable) {}
  
  public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode paramDnsResponseCode)
  {
    return this;
  }
  
  public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> paramList)
  {
    return this;
  }
  
  public void querySucceed() {}
  
  public void queryWritten(InetSocketAddress paramInetSocketAddress, ChannelFuture paramChannelFuture) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\NoopDnsQueryLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
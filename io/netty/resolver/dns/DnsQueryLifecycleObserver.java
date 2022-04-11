package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import java.net.InetSocketAddress;
import java.util.List;

public abstract interface DnsQueryLifecycleObserver
{
  public abstract DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion paramDnsQuestion);
  
  public abstract void queryCancelled(int paramInt);
  
  public abstract void queryFailed(Throwable paramThrowable);
  
  public abstract DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode paramDnsResponseCode);
  
  public abstract DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> paramList);
  
  public abstract void querySucceed();
  
  public abstract void queryWritten(InetSocketAddress paramInetSocketAddress, ChannelFuture paramChannelFuture);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsQueryLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
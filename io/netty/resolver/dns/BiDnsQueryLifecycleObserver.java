package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

public final class BiDnsQueryLifecycleObserver
  implements DnsQueryLifecycleObserver
{
  private final DnsQueryLifecycleObserver a;
  private final DnsQueryLifecycleObserver b;
  
  public BiDnsQueryLifecycleObserver(DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver1, DnsQueryLifecycleObserver paramDnsQueryLifecycleObserver2)
  {
    this.a = ((DnsQueryLifecycleObserver)ObjectUtil.checkNotNull(paramDnsQueryLifecycleObserver1, "a"));
    this.b = ((DnsQueryLifecycleObserver)ObjectUtil.checkNotNull(paramDnsQueryLifecycleObserver2, "b"));
  }
  
  public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion paramDnsQuestion)
  {
    try
    {
      this.a.queryCNAMEd(paramDnsQuestion);
      return this;
    }
    finally
    {
      this.b.queryCNAMEd(paramDnsQuestion);
    }
  }
  
  public void queryCancelled(int paramInt)
  {
    try
    {
      this.a.queryCancelled(paramInt);
      return;
    }
    finally
    {
      this.b.queryCancelled(paramInt);
    }
  }
  
  public void queryFailed(Throwable paramThrowable)
  {
    try
    {
      this.a.queryFailed(paramThrowable);
      return;
    }
    finally
    {
      this.b.queryFailed(paramThrowable);
    }
  }
  
  public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode paramDnsResponseCode)
  {
    try
    {
      this.a.queryNoAnswer(paramDnsResponseCode);
      return this;
    }
    finally
    {
      this.b.queryNoAnswer(paramDnsResponseCode);
    }
  }
  
  public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> paramList)
  {
    try
    {
      this.a.queryRedirected(paramList);
      return this;
    }
    finally
    {
      this.b.queryRedirected(paramList);
    }
  }
  
  public void querySucceed()
  {
    try
    {
      this.a.querySucceed();
      return;
    }
    finally
    {
      this.b.querySucceed();
    }
  }
  
  public void queryWritten(InetSocketAddress paramInetSocketAddress, ChannelFuture paramChannelFuture)
  {
    try
    {
      this.a.queryWritten(paramInetSocketAddress, paramChannelFuture);
      return;
    }
    finally
    {
      this.b.queryWritten(paramInetSocketAddress, paramChannelFuture);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\BiDnsQueryLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
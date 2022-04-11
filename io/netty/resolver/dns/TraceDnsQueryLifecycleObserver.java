package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetSocketAddress;
import java.util.List;

final class TraceDnsQueryLifecycleObserver
  implements DnsQueryLifecycleObserver
{
  private InetSocketAddress dnsServerAddress;
  private final InternalLogLevel level;
  private final InternalLogger logger;
  private final DnsQuestion question;
  
  TraceDnsQueryLifecycleObserver(DnsQuestion paramDnsQuestion, InternalLogger paramInternalLogger, InternalLogLevel paramInternalLogLevel)
  {
    this.question = ((DnsQuestion)ObjectUtil.checkNotNull(paramDnsQuestion, "question"));
    this.logger = ((InternalLogger)ObjectUtil.checkNotNull(paramInternalLogger, "logger"));
    this.level = ((InternalLogLevel)ObjectUtil.checkNotNull(paramInternalLogLevel, "level"));
  }
  
  public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion paramDnsQuestion)
  {
    this.logger.log(this.level, "from {} : {} CNAME question {}", new Object[] { this.dnsServerAddress, this.question, paramDnsQuestion });
    return this;
  }
  
  public void queryCancelled(int paramInt)
  {
    InetSocketAddress localInetSocketAddress = this.dnsServerAddress;
    if (localInetSocketAddress != null) {
      this.logger.log(this.level, "from {} : {} cancelled with {} queries remaining", new Object[] { localInetSocketAddress, this.question, Integer.valueOf(paramInt) });
    } else {
      this.logger.log(this.level, "{} query never written and cancelled with {} queries remaining", this.question, Integer.valueOf(paramInt));
    }
  }
  
  public void queryFailed(Throwable paramThrowable)
  {
    InetSocketAddress localInetSocketAddress = this.dnsServerAddress;
    if (localInetSocketAddress != null) {
      this.logger.log(this.level, "from {} : {} failure", new Object[] { localInetSocketAddress, this.question, paramThrowable });
    } else {
      this.logger.log(this.level, "{} query never written and failed", this.question, paramThrowable);
    }
  }
  
  public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode paramDnsResponseCode)
  {
    this.logger.log(this.level, "from {} : {} no answer {}", new Object[] { this.dnsServerAddress, this.question, paramDnsResponseCode });
    return this;
  }
  
  public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> paramList)
  {
    this.logger.log(this.level, "from {} : {} redirected", this.dnsServerAddress, this.question);
    return this;
  }
  
  public void querySucceed() {}
  
  public void queryWritten(InetSocketAddress paramInetSocketAddress, ChannelFuture paramChannelFuture)
  {
    this.dnsServerAddress = paramInetSocketAddress;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\TraceDnsQueryLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
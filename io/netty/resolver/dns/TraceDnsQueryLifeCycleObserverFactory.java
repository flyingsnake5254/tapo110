package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

final class TraceDnsQueryLifeCycleObserverFactory
  implements DnsQueryLifecycleObserverFactory
{
  private static final InternalLogLevel DEFAULT_LEVEL = InternalLogLevel.DEBUG;
  private static final InternalLogger DEFAULT_LOGGER = InternalLoggerFactory.getInstance(TraceDnsQueryLifeCycleObserverFactory.class);
  private final InternalLogLevel level;
  private final InternalLogger logger;
  
  TraceDnsQueryLifeCycleObserverFactory()
  {
    this(DEFAULT_LOGGER, DEFAULT_LEVEL);
  }
  
  TraceDnsQueryLifeCycleObserverFactory(InternalLogger paramInternalLogger, InternalLogLevel paramInternalLogLevel)
  {
    this.logger = ((InternalLogger)ObjectUtil.checkNotNull(paramInternalLogger, "logger"));
    this.level = ((InternalLogLevel)ObjectUtil.checkNotNull(paramInternalLogLevel, "level"));
  }
  
  public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion paramDnsQuestion)
  {
    return new TraceDnsQueryLifecycleObserver(paramDnsQuestion, this.logger, this.level);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\TraceDnsQueryLifeCycleObserverFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
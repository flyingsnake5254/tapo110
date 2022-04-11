package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;

public final class NoopDnsQueryLifecycleObserverFactory
  implements DnsQueryLifecycleObserverFactory
{
  public static final NoopDnsQueryLifecycleObserverFactory INSTANCE = new NoopDnsQueryLifecycleObserverFactory();
  
  public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion paramDnsQuestion)
  {
    return NoopDnsQueryLifecycleObserver.INSTANCE;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\NoopDnsQueryLifecycleObserverFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
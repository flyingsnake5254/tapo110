package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.util.internal.ObjectUtil;

public final class BiDnsQueryLifecycleObserverFactory
  implements DnsQueryLifecycleObserverFactory
{
  private final DnsQueryLifecycleObserverFactory a;
  private final DnsQueryLifecycleObserverFactory b;
  
  public BiDnsQueryLifecycleObserverFactory(DnsQueryLifecycleObserverFactory paramDnsQueryLifecycleObserverFactory1, DnsQueryLifecycleObserverFactory paramDnsQueryLifecycleObserverFactory2)
  {
    this.a = ((DnsQueryLifecycleObserverFactory)ObjectUtil.checkNotNull(paramDnsQueryLifecycleObserverFactory1, "a"));
    this.b = ((DnsQueryLifecycleObserverFactory)ObjectUtil.checkNotNull(paramDnsQueryLifecycleObserverFactory2, "b"));
  }
  
  public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion paramDnsQuestion)
  {
    return new BiDnsQueryLifecycleObserver(this.a.newDnsQueryLifecycleObserver(paramDnsQuestion), this.b.newDnsQueryLifecycleObserver(paramDnsQuestion));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\BiDnsQueryLifecycleObserverFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
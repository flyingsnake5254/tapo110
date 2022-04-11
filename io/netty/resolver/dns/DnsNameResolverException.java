package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;

public class DnsNameResolverException
  extends RuntimeException
{
  private static final long serialVersionUID = -8826717909627131850L;
  private final DnsQuestion question;
  private final InetSocketAddress remoteAddress;
  
  public DnsNameResolverException(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, String paramString)
  {
    super(paramString);
    this.remoteAddress = validateRemoteAddress(paramInetSocketAddress);
    this.question = validateQuestion(paramDnsQuestion);
  }
  
  public DnsNameResolverException(InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.remoteAddress = validateRemoteAddress(paramInetSocketAddress);
    this.question = validateQuestion(paramDnsQuestion);
  }
  
  private static DnsQuestion validateQuestion(DnsQuestion paramDnsQuestion)
  {
    return (DnsQuestion)ObjectUtil.checkNotNull(paramDnsQuestion, "question");
  }
  
  private static InetSocketAddress validateRemoteAddress(InetSocketAddress paramInetSocketAddress)
  {
    return (InetSocketAddress)ObjectUtil.checkNotNull(paramInetSocketAddress, "remoteAddress");
  }
  
  public Throwable fillInStackTrace()
  {
    setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
    return this;
  }
  
  public DnsQuestion question()
  {
    return this.question;
  }
  
  public InetSocketAddress remoteAddress()
  {
    return this.remoteAddress;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsNameResolverException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
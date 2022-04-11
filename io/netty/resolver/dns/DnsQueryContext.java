package io.netty.resolver.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.dns.AbstractDnsOptPseudoRrRecord;
import io.netty.handler.codec.dns.DnsMessage;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.concurrent.c;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

abstract class DnsQueryContext
  implements a<AddressedEnvelope<DnsResponse, InetSocketAddress>>
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsQueryContext.class);
  private final DnsRecord[] additionals;
  private final int id;
  private final InetSocketAddress nameServerAddr;
  private final DnsRecord optResource;
  private final DnsNameResolver parent;
  private final Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise;
  private final DnsQuestion question;
  private final boolean recursionDesired;
  private volatile c<?> timeoutFuture;
  
  DnsQueryContext(DnsNameResolver paramDnsNameResolver, InetSocketAddress paramInetSocketAddress, DnsQuestion paramDnsQuestion, DnsRecord[] paramArrayOfDnsRecord, Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> paramPromise)
  {
    this.parent = ((DnsNameResolver)ObjectUtil.checkNotNull(paramDnsNameResolver, "parent"));
    this.nameServerAddr = ((InetSocketAddress)ObjectUtil.checkNotNull(paramInetSocketAddress, "nameServerAddr"));
    this.question = ((DnsQuestion)ObjectUtil.checkNotNull(paramDnsQuestion, "question"));
    this.additionals = ((DnsRecord[])ObjectUtil.checkNotNull(paramArrayOfDnsRecord, "additionals"));
    this.promise = ((Promise)ObjectUtil.checkNotNull(paramPromise, "promise"));
    this.recursionDesired = paramDnsNameResolver.isRecursionDesired();
    this.id = paramDnsNameResolver.queryContextManager.add(this);
    paramPromise.addListener(this);
    if (paramDnsNameResolver.isOptResourceEnabled()) {
      this.optResource = new AbstractDnsOptPseudoRrRecord(paramDnsNameResolver.maxPayloadSize(), 0, 0) {};
    } else {
      this.optResource = null;
    }
  }
  
  private void onQueryWriteCompletion(ChannelFuture paramChannelFuture)
  {
    if (!paramChannelFuture.isSuccess())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to send a query via ");
      localStringBuilder.append(protocol());
      tryFailure(localStringBuilder.toString(), paramChannelFuture.cause(), false);
      return;
    }
    final long l = this.parent.queryTimeoutMillis();
    if (l > 0L) {
      this.timeoutFuture = this.parent.ch.eventLoop().schedule(new Runnable()
      {
        public void run()
        {
          if (DnsQueryContext.this.promise.isDone()) {
            return;
          }
          DnsQueryContext localDnsQueryContext = DnsQueryContext.this;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("query via ");
          localStringBuilder.append(DnsQueryContext.this.protocol());
          localStringBuilder.append(" timed out after ");
          localStringBuilder.append(l);
          localStringBuilder.append(" milliseconds");
          localDnsQueryContext.tryFailure(localStringBuilder.toString(), null, true);
        }
      }, l, TimeUnit.MILLISECONDS);
    }
  }
  
  private void sendQuery(final DnsQuery paramDnsQuery, boolean paramBoolean, final ChannelPromise paramChannelPromise)
  {
    if (this.parent.channelFuture.isDone()) {
      writeQuery(paramDnsQuery, paramBoolean, paramChannelPromise);
    } else {
      this.parent.channelFuture.addListener(new GenericFutureListener()
      {
        public void operationComplete(io.netty.util.concurrent.Future<? super Channel> paramAnonymousFuture)
        {
          if (paramAnonymousFuture.isSuccess())
          {
            DnsQueryContext.this.writeQuery(paramDnsQuery, true, paramChannelPromise);
          }
          else
          {
            paramAnonymousFuture = paramAnonymousFuture.cause();
            DnsQueryContext.this.promise.tryFailure(paramAnonymousFuture);
            paramChannelPromise.setFailure(paramAnonymousFuture);
          }
        }
      });
    }
  }
  
  private boolean trySuccess(AddressedEnvelope<? extends DnsResponse, InetSocketAddress> paramAddressedEnvelope)
  {
    return this.promise.trySuccess(paramAddressedEnvelope);
  }
  
  private void writeQuery(final DnsQuery paramDnsQuery, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    if (paramBoolean) {
      paramDnsQuery = channel().writeAndFlush(paramDnsQuery, paramChannelPromise);
    } else {
      paramDnsQuery = channel().write(paramDnsQuery, paramChannelPromise);
    }
    if (paramDnsQuery.isDone()) {
      onQueryWriteCompletion(paramDnsQuery);
    } else {
      paramDnsQuery.addListener(new ChannelFutureListener()
      {
        public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        {
          DnsQueryContext.this.onQueryWriteCompletion(paramDnsQuery);
        }
      });
    }
  }
  
  protected abstract Channel channel();
  
  void finish(AddressedEnvelope<? extends DnsResponse, InetSocketAddress> paramAddressedEnvelope)
  {
    DnsResponse localDnsResponse = (DnsResponse)paramAddressedEnvelope.content();
    DnsSection localDnsSection = DnsSection.QUESTION;
    if (localDnsResponse.count(localDnsSection) != 1) {
      logger.warn("Received a DNS response with invalid number of questions: {}", paramAddressedEnvelope);
    } else if (!question().equals(localDnsResponse.recordAt(localDnsSection))) {
      logger.warn("Received a mismatching DNS response: {}", paramAddressedEnvelope);
    } else if (trySuccess(paramAddressedEnvelope)) {
      return;
    }
    paramAddressedEnvelope.release();
  }
  
  InetSocketAddress nameServerAddr()
  {
    return this.nameServerAddr;
  }
  
  protected abstract DnsQuery newQuery(int paramInt);
  
  public void operationComplete(io.netty.util.concurrent.Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> paramFuture)
  {
    paramFuture = this.timeoutFuture;
    if (paramFuture != null)
    {
      this.timeoutFuture = null;
      paramFuture.cancel(false);
    }
    this.parent.queryContextManager.remove(this.nameServerAddr, this.id);
  }
  
  DnsNameResolver parent()
  {
    return this.parent;
  }
  
  protected abstract String protocol();
  
  void query(boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    DnsQuestion localDnsQuestion = question();
    InetSocketAddress localInetSocketAddress = nameServerAddr();
    DnsQuery localDnsQuery = newQuery(this.id);
    localDnsQuery.setRecursionDesired(this.recursionDesired);
    localDnsQuery.addRecord(DnsSection.QUESTION, localDnsQuestion);
    for (localObject : this.additionals) {
      localDnsQuery.addRecord(DnsSection.ADDITIONAL, (DnsRecord)localObject);
    }
    Object localObject = this.optResource;
    if (localObject != null) {
      localDnsQuery.addRecord(DnsSection.ADDITIONAL, (DnsRecord)localObject);
    }
    localObject = logger;
    if (((InternalLogger)localObject).isDebugEnabled()) {
      ((InternalLogger)localObject).debug("{} WRITE: {}, [{}: {}], {}", new Object[] { channel(), protocol(), Integer.valueOf(this.id), localInetSocketAddress, localDnsQuestion });
    }
    sendQuery(localDnsQuery, paramBoolean, paramChannelPromise);
  }
  
  DnsQuestion question()
  {
    return this.question;
  }
  
  boolean tryFailure(String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    if (this.promise.isDone()) {
      return false;
    }
    InetSocketAddress localInetSocketAddress = nameServerAddr();
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 64);
    localStringBuilder.append('[');
    localStringBuilder.append(localInetSocketAddress);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (no stack trace available)");
    if (paramBoolean) {
      paramString = new DnsNameResolverTimeoutException(localInetSocketAddress, question(), localStringBuilder.toString());
    } else {
      paramString = new DnsNameResolverException(localInetSocketAddress, question(), localStringBuilder.toString(), paramThrowable);
    }
    return this.promise.tryFailure(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\DnsQueryContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
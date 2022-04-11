package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import java.util.function.Function;
import java.util.function.Predicate;
import reactor.blockhound.BlockHound.Builder;
import reactor.blockhound.integration.BlockHoundIntegration;

class Hidden
{
  @SuppressJava6Requirement(reason="BlockHound is Java 8+, but this class is only loaded by it's SPI")
  public static final class NettyBlockHoundIntegration
    implements BlockHoundIntegration
  {
    public void applyTo(BlockHound.Builder paramBuilder)
    {
      paramBuilder.allowBlockingCallsInside("io.netty.channel.nio.NioEventLoop", "handleLoopException");
      paramBuilder.allowBlockingCallsInside("io.netty.channel.kqueue.KQueueEventLoop", "handleLoopException");
      paramBuilder.allowBlockingCallsInside("io.netty.channel.epoll.EpollEventLoop", "handleLoopException");
      paramBuilder.allowBlockingCallsInside("io.netty.util.HashedWheelTimer$Worker", "waitForNextTick");
      paramBuilder.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "confirmShutdown");
      paramBuilder.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "handshake");
      paramBuilder.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "runAllDelegatedTasks");
      paramBuilder.allowBlockingCallsInside("io.netty.util.concurrent.GlobalEventExecutor", "takeTask");
      paramBuilder.allowBlockingCallsInside("io.netty.util.concurrent.GlobalEventExecutor", "addTask");
      paramBuilder.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "takeTask");
      paramBuilder.allowBlockingCallsInside("io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$ExtendedTrustManagerVerifyCallback", "verify");
      paramBuilder.nonBlockingThreadPredicate(new Function()
      {
        public Predicate<Thread> apply(final Predicate<Thread> paramAnonymousPredicate)
        {
          new Predicate()
          {
            @SuppressJava6Requirement(reason="Predicate#test")
            public boolean test(Thread paramAnonymous2Thread)
            {
              boolean bool;
              if ((!paramAnonymousPredicate.test(paramAnonymous2Thread)) && (!(paramAnonymous2Thread instanceof FastThreadLocalThread))) {
                bool = false;
              } else {
                bool = true;
              }
              return bool;
            }
          };
        }
      });
    }
    
    public int compareTo(BlockHoundIntegration paramBlockHoundIntegration)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\Hidden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
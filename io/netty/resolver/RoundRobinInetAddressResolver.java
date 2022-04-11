package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RoundRobinInetAddressResolver
  extends InetNameResolver
{
  private final NameResolver<InetAddress> nameResolver;
  
  public RoundRobinInetAddressResolver(EventExecutor paramEventExecutor, NameResolver<InetAddress> paramNameResolver)
  {
    super(paramEventExecutor);
    this.nameResolver = paramNameResolver;
  }
  
  private static int randomIndex(int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 0;
    } else {
      paramInt = PlatformDependent.threadLocalRandom().nextInt(paramInt);
    }
    return paramInt;
  }
  
  public void close()
  {
    this.nameResolver.close();
  }
  
  protected void doResolve(final String paramString, final Promise<InetAddress> paramPromise)
    throws Exception
  {
    this.nameResolver.resolveAll(paramString).addListener(new a()
    {
      public void operationComplete(Future<List<InetAddress>> paramAnonymousFuture)
        throws Exception
      {
        if (paramAnonymousFuture.isSuccess())
        {
          paramAnonymousFuture = (List)paramAnonymousFuture.getNow();
          int i = paramAnonymousFuture.size();
          if (i > 0) {
            paramPromise.setSuccess(paramAnonymousFuture.get(RoundRobinInetAddressResolver.randomIndex(i)));
          } else {
            paramPromise.setFailure(new UnknownHostException(paramString));
          }
        }
        else
        {
          paramPromise.setFailure(paramAnonymousFuture.cause());
        }
      }
    });
  }
  
  protected void doResolveAll(String paramString, final Promise<List<InetAddress>> paramPromise)
    throws Exception
  {
    this.nameResolver.resolveAll(paramString).addListener(new a()
    {
      public void operationComplete(Future<List<InetAddress>> paramAnonymousFuture)
        throws Exception
      {
        if (paramAnonymousFuture.isSuccess())
        {
          List localList = (List)paramAnonymousFuture.getNow();
          if (!localList.isEmpty())
          {
            paramAnonymousFuture = new ArrayList(localList);
            Collections.rotate(paramAnonymousFuture, RoundRobinInetAddressResolver.randomIndex(localList.size()));
            paramPromise.setSuccess(paramAnonymousFuture);
          }
          else
          {
            paramPromise.setSuccess(localList);
          }
        }
        else
        {
          paramPromise.setFailure(paramAnonymousFuture.cause());
        }
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\RoundRobinInetAddressResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
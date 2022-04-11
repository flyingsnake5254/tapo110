package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InetSocketAddressResolver
  extends AbstractAddressResolver<InetSocketAddress>
{
  final NameResolver<InetAddress> nameResolver;
  
  public InetSocketAddressResolver(EventExecutor paramEventExecutor, NameResolver<InetAddress> paramNameResolver)
  {
    super(paramEventExecutor, InetSocketAddress.class);
    this.nameResolver = paramNameResolver;
  }
  
  public void close()
  {
    this.nameResolver.close();
  }
  
  protected boolean doIsResolved(InetSocketAddress paramInetSocketAddress)
  {
    return paramInetSocketAddress.isUnresolved() ^ true;
  }
  
  protected void doResolve(final InetSocketAddress paramInetSocketAddress, final Promise<InetSocketAddress> paramPromise)
    throws Exception
  {
    this.nameResolver.resolve(paramInetSocketAddress.getHostName()).addListener(new a()
    {
      public void operationComplete(Future<InetAddress> paramAnonymousFuture)
        throws Exception
      {
        if (paramAnonymousFuture.isSuccess()) {
          paramPromise.setSuccess(new InetSocketAddress((InetAddress)paramAnonymousFuture.getNow(), paramInetSocketAddress.getPort()));
        } else {
          paramPromise.setFailure(paramAnonymousFuture.cause());
        }
      }
    });
  }
  
  protected void doResolveAll(final InetSocketAddress paramInetSocketAddress, final Promise<List<InetSocketAddress>> paramPromise)
    throws Exception
  {
    this.nameResolver.resolveAll(paramInetSocketAddress.getHostName()).addListener(new a()
    {
      public void operationComplete(Future<List<InetAddress>> paramAnonymousFuture)
        throws Exception
      {
        if (paramAnonymousFuture.isSuccess())
        {
          Object localObject = (List)paramAnonymousFuture.getNow();
          paramAnonymousFuture = new ArrayList(((List)localObject).size());
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramAnonymousFuture.add(new InetSocketAddress((InetAddress)((Iterator)localObject).next(), paramInetSocketAddress.getPort()));
          }
          paramPromise.setSuccess(paramAnonymousFuture);
        }
        else
        {
          paramPromise.setFailure(paramAnonymousFuture.cause());
        }
      }
    });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\InetSocketAddressResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
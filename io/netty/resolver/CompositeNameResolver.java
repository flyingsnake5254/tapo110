package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.List;

public final class CompositeNameResolver<T>
  extends SimpleNameResolver<T>
{
  private final NameResolver<T>[] resolvers;
  
  public CompositeNameResolver(EventExecutor paramEventExecutor, NameResolver<T>... paramVarArgs)
  {
    super(paramEventExecutor);
    ObjectUtil.checkNotNull(paramVarArgs, "resolvers");
    for (int i = 0; i < paramVarArgs.length; i++)
    {
      NameResolver<T> localNameResolver = paramVarArgs[i];
      paramEventExecutor = new StringBuilder();
      paramEventExecutor.append("resolvers[");
      paramEventExecutor.append(i);
      paramEventExecutor.append(']');
      ObjectUtil.checkNotNull(localNameResolver, paramEventExecutor.toString());
    }
    if (paramVarArgs.length >= 2)
    {
      this.resolvers = ((NameResolver[])paramVarArgs.clone());
      return;
    }
    paramEventExecutor = new StringBuilder();
    paramEventExecutor.append("resolvers: ");
    paramEventExecutor.append(Arrays.asList(paramVarArgs));
    paramEventExecutor.append(" (expected: at least 2 resolvers)");
    throw new IllegalArgumentException(paramEventExecutor.toString());
  }
  
  private void doResolveAllRec(final String paramString, final Promise<List<T>> paramPromise, final int paramInt, Throwable paramThrowable)
    throws Exception
  {
    NameResolver[] arrayOfNameResolver = this.resolvers;
    if (paramInt >= arrayOfNameResolver.length) {
      paramPromise.setFailure(paramThrowable);
    } else {
      arrayOfNameResolver[paramInt].resolveAll(paramString).addListener(new a()
      {
        public void operationComplete(Future<List<T>> paramAnonymousFuture)
          throws Exception
        {
          if (paramAnonymousFuture.isSuccess()) {
            paramPromise.setSuccess(paramAnonymousFuture.getNow());
          } else {
            CompositeNameResolver.this.doResolveAllRec(paramString, paramPromise, paramInt + 1, paramAnonymousFuture.cause());
          }
        }
      });
    }
  }
  
  private void doResolveRec(final String paramString, final Promise<T> paramPromise, final int paramInt, Throwable paramThrowable)
    throws Exception
  {
    NameResolver[] arrayOfNameResolver = this.resolvers;
    if (paramInt >= arrayOfNameResolver.length) {
      paramPromise.setFailure(paramThrowable);
    } else {
      arrayOfNameResolver[paramInt].resolve(paramString).addListener(new a()
      {
        public void operationComplete(Future<T> paramAnonymousFuture)
          throws Exception
        {
          if (paramAnonymousFuture.isSuccess()) {
            paramPromise.setSuccess(paramAnonymousFuture.getNow());
          } else {
            CompositeNameResolver.this.doResolveRec(paramString, paramPromise, paramInt + 1, paramAnonymousFuture.cause());
          }
        }
      });
    }
  }
  
  protected void doResolve(String paramString, Promise<T> paramPromise)
    throws Exception
  {
    doResolveRec(paramString, paramPromise, 0, null);
  }
  
  protected void doResolveAll(String paramString, Promise<List<T>> paramPromise)
    throws Exception
  {
    doResolveAllRec(paramString, paramPromise, 0, null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\CompositeNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
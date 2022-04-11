package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Deprecated
public class PromiseAggregator<V, F extends Future<V>>
  implements GenericFutureListener<F>
{
  private final Promise<?> aggregatePromise;
  private final boolean failPending;
  private Set<Promise<V>> pendingPromises;
  
  public PromiseAggregator(Promise<Void> paramPromise)
  {
    this(paramPromise, true);
  }
  
  public PromiseAggregator(Promise<Void> paramPromise, boolean paramBoolean)
  {
    this.aggregatePromise = ((Promise)ObjectUtil.checkNotNull(paramPromise, "aggregatePromise"));
    this.failPending = paramBoolean;
  }
  
  @SafeVarargs
  public final PromiseAggregator<V, F> add(Promise<V>... paramVarArgs)
  {
    ObjectUtil.checkNotNull(paramVarArgs, "promises");
    if (paramVarArgs.length == 0) {
      return this;
    }
    try
    {
      Object localObject;
      if (this.pendingPromises == null)
      {
        if (paramVarArgs.length > 1) {
          i = paramVarArgs.length;
        } else {
          i = 2;
        }
        localObject = new java/util/LinkedHashSet;
        ((LinkedHashSet)localObject).<init>(i);
        this.pendingPromises = ((Set)localObject);
      }
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++)
      {
        localObject = paramVarArgs[i];
        if (localObject != null)
        {
          this.pendingPromises.add(localObject);
          ((Promise)localObject).addListener(this);
        }
      }
      return this;
    }
    finally {}
  }
  
  public void operationComplete(F paramF)
    throws Exception
  {
    try
    {
      Object localObject = this.pendingPromises;
      if (localObject == null)
      {
        this.aggregatePromise.setSuccess(null);
      }
      else
      {
        ((Set)localObject).remove(paramF);
        if (!paramF.isSuccess())
        {
          localObject = paramF.cause();
          this.aggregatePromise.setFailure((Throwable)localObject);
          if (this.failPending)
          {
            paramF = this.pendingPromises.iterator();
            while (paramF.hasNext()) {
              ((Promise)paramF.next()).setFailure((Throwable)localObject);
            }
          }
        }
        else if (this.pendingPromises.isEmpty())
        {
          this.aggregatePromise.setSuccess(null);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\PromiseAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

class OptionalProvider<T>
  implements Provider<T>, Deferred<T>
{
  private static final Provider<Object> EMPTY_PROVIDER = l.a;
  private static final Deferred.DeferredHandler<Object> NOOP_HANDLER = m.a;
  private volatile Provider<T> delegate;
  @GuardedBy("this")
  private Deferred.DeferredHandler<T> handler;
  
  private OptionalProvider(Deferred.DeferredHandler<T> paramDeferredHandler, Provider<T> paramProvider)
  {
    this.handler = paramDeferredHandler;
    this.delegate = paramProvider;
  }
  
  static <T> OptionalProvider<T> empty()
  {
    return new OptionalProvider(NOOP_HANDLER, EMPTY_PROVIDER);
  }
  
  static <T> OptionalProvider<T> of(Provider<T> paramProvider)
  {
    return new OptionalProvider(null, paramProvider);
  }
  
  public T get()
  {
    return (T)this.delegate.get();
  }
  
  void set(Provider<T> paramProvider)
  {
    if (this.delegate == EMPTY_PROVIDER) {
      try
      {
        Deferred.DeferredHandler localDeferredHandler = this.handler;
        this.handler = null;
        this.delegate = paramProvider;
        localDeferredHandler.handle(paramProvider);
        return;
      }
      finally {}
    }
    throw new IllegalStateException("provide() can be called only once.");
  }
  
  public void whenAvailable(@NonNull Deferred.DeferredHandler<T> paramDeferredHandler)
  {
    Object localObject1 = this.delegate;
    Object localObject2 = EMPTY_PROVIDER;
    if (localObject1 != localObject2)
    {
      paramDeferredHandler.handle((Provider)localObject1);
      return;
    }
    localObject1 = null;
    try
    {
      Provider localProvider = this.delegate;
      if (localProvider != localObject2)
      {
        localObject1 = localProvider;
      }
      else
      {
        Deferred.DeferredHandler localDeferredHandler = this.handler;
        localObject2 = new com/google/firebase/components/n;
        ((n)localObject2).<init>(localDeferredHandler, paramDeferredHandler);
        this.handler = ((Deferred.DeferredHandler)localObject2);
      }
      if (localObject1 != null) {
        paramDeferredHandler.handle(localProvider);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\OptionalProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
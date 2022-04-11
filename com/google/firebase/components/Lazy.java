package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

public class Lazy<T>
  implements Provider<T>
{
  private static final Object UNINITIALIZED = new Object();
  private volatile Object instance = UNINITIALIZED;
  private volatile Provider<T> provider;
  
  public Lazy(Provider<T> paramProvider)
  {
    this.provider = paramProvider;
  }
  
  Lazy(T paramT)
  {
    this.instance = paramT;
  }
  
  public T get()
  {
    Object localObject1 = this.instance;
    Object localObject2 = UNINITIALIZED;
    Object localObject3 = localObject1;
    if (localObject1 == localObject2) {
      try
      {
        localObject1 = this.instance;
        localObject3 = localObject1;
        if (localObject1 == localObject2)
        {
          localObject3 = this.provider.get();
          this.instance = localObject3;
          this.provider = null;
        }
      }
      finally {}
    }
    return ?;
  }
  
  @VisibleForTesting
  boolean isInitialized()
  {
    boolean bool;
    if (this.instance != UNINITIALIZED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\components\Lazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.firebase.inject;

import androidx.annotation.NonNull;
import com.google.firebase.annotations.DeferredApi;

public abstract interface Deferred<T>
{
  public abstract void whenAvailable(@NonNull DeferredHandler<T> paramDeferredHandler);
  
  public static abstract interface DeferredHandler<T>
  {
    @DeferredApi
    public abstract void handle(Provider<T> paramProvider);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\inject\Deferred.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
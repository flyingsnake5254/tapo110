package com.tplink.libtpnetwork.cameranetwork.lifecycleutils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

public class EventObserver<T>
  implements Observer<a<T>>
{
  @NonNull
  private final Observer<T> a;
  
  public EventObserver(@NonNull Observer<T> paramObserver)
  {
    this.a = paramObserver;
  }
  
  public void a(@Nullable a<T> parama)
  {
    if (parama != null)
    {
      parama = parama.a();
      if (parama != null) {
        this.a.onChanged(parama);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\lifecycleutils\EventObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
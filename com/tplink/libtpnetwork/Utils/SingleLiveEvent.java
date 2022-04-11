package com.tplink.libtpnetwork.Utils;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.w.c.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T>
  extends MediatorLiveData<T>
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  @MainThread
  public void observe(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull final Observer<? super T> paramObserver)
  {
    if (hasActiveObservers()) {
      a.n("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
    }
    super.observe(paramLifecycleOwner, new a(paramObserver));
  }
  
  @MainThread
  public void setValue(@Nullable T paramT)
  {
    this.a.set(true);
    super.setValue(paramT);
  }
  
  class a
    implements Observer<T>
  {
    a(Observer paramObserver) {}
    
    public void onChanged(@Nullable T paramT)
    {
      if (SingleLiveEvent.a(SingleLiveEvent.this).compareAndSet(true, false)) {
        paramObserver.onChanged(paramT);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\SingleLiveEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
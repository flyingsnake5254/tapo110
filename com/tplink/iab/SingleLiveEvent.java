package com.tplink.iab;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T>
  extends MutableLiveData<T>
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  @MainThread
  public void observe(LifecycleOwner paramLifecycleOwner, Observer<? super T> paramObserver)
  {
    if (hasActiveObservers()) {
      Log.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
    }
    super.observe(paramLifecycleOwner, new a(this, paramObserver));
  }
  
  @MainThread
  public void setValue(@Nullable T paramT)
  {
    this.a.set(true);
    super.setValue(paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iab\SingleLiveEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
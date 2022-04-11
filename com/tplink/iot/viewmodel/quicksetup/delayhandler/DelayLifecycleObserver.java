package com.tplink.iot.viewmodel.quicksetup.delayhandler;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public abstract interface DelayLifecycleObserver
  extends LifecycleObserver
{
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public abstract void onDestroy(@NonNull LifecycleOwner paramLifecycleOwner);
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public abstract void onResume(@NonNull LifecycleOwner paramLifecycleOwner);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\delayhandler\DelayLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
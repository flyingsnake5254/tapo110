package com.tplink.iot.devicecommon.feature;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import b.d.w.c.a;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import io.reactivex.q;
import kotlin.f;
import kotlin.t.c;

public final class LedStatusFeature
  implements LifecycleObserver
{
  public static final a d = new a(null);
  private final c f;
  private final f q;
  
  private final IoTCommonFeatureRepository a()
  {
    return (IoTCommonFeatureRepository)this.f.b(this, c[0]);
  }
  
  private final boolean b()
  {
    return ((Boolean)this.q.getValue()).booleanValue();
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    a.n("LedStatusFeature", "onResume");
    if (b()) {
      a().a1().F0();
    }
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\feature\LedStatusFeature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
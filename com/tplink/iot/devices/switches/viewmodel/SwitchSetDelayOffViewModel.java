package com.tplink.iot.devices.switches.viewmodel;

import android.app.Application;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.g0.g;
import kotlin.t.c;

public final class SwitchSetDelayOffViewModel
  extends AndroidViewModel
{
  private final c b;
  private final LiveData<DelayActionInfoBean> c;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> d;
  private final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> e;
  private final ObservableBoolean f;
  
  public SwitchSetDelayOffViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = new a(paramThingContext);
    this.c = i().l4();
    paramApplication = new MutableLiveData();
    this.d = paramApplication;
    this.e = paramApplication;
    this.f = new ObservableBoolean(false);
  }
  
  private final SwitchRepository i()
  {
    return (SwitchRepository)this.b.b(this, a[0]);
  }
  
  public final LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> g()
  {
    return this.e;
  }
  
  public final LiveData<DelayActionInfoBean> h()
  {
    return this.c;
  }
  
  public final ObservableBoolean j()
  {
    return this.f;
  }
  
  public final void k(DelayActionInfoBean paramDelayActionInfoBean)
  {
    kotlin.jvm.internal.j.e(paramDelayActionInfoBean, "info");
    i().q4(paramDelayActionInfoBean).i(new b(this)).j(new c(this)).y();
  }
  
  public static final class a
    implements c<Object, SwitchRepository>
  {
    private final SwitchRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, SwitchRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public SwitchRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(SwitchSetDelayOffViewModel paramSwitchSetDelayOffViewModel) {}
    
    public final void run()
    {
      SwitchSetDelayOffViewModel.f(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(SwitchSetDelayOffViewModel paramSwitchSetDelayOffViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      SwitchSetDelayOffViewModel.f(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\viewmodel\SwitchSetDelayOffViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
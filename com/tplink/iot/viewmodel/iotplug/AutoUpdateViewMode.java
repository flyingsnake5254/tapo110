package com.tplink.iot.viewmodel.iotplug;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.q;

public class AutoUpdateViewMode
  extends AndroidViewModel
{
  private AbstractThingRepository a;
  private AbstractSubThingRepository b;
  private MediatorLiveData<AutoUpdateBean> c = new MediatorLiveData();
  private SingleLiveEvent<Integer> d = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private io.reactivex.e0.b f = new io.reactivex.e0.b();
  public AutoUpdateBean g;
  
  public AutoUpdateViewMode(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = com.tplink.libtpnetwork.IoTNetwork.util.c.a(paramThingContext);
    if ((paramApplication instanceof AbstractThingRepository)) {
      this.a = ((AbstractThingRepository)paramApplication);
    } else if ((paramApplication instanceof AbstractSubThingRepository)) {
      this.b = ((AbstractSubThingRepository)paramApplication);
    } else {
      this.a = ((AbstractThingRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, PlugRepository.class));
    }
  }
  
  public void f()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((AbstractThingRepository)localObject).E1();
    }
    else
    {
      localObject = this.b;
      if (localObject != null) {
        localObject = ((AbstractSubThingRepository)localObject).o1();
      } else {
        localObject = q.I();
      }
    }
    localObject = ((q)localObject).F(new c(this)).y(new b(this)).H0(new a(this), g.c);
    this.f.b((io.reactivex.e0.c)localObject);
  }
  
  public LiveData<AutoUpdateBean> g()
  {
    return this.c;
  }
  
  public SingleLiveEvent<Boolean> h()
  {
    return this.e;
  }
  
  public SingleLiveEvent<Integer> i()
  {
    return this.d;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.f.dispose();
  }
  
  public void z(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = new AutoUpdateBean(paramBoolean, paramInt, 120);
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      localObject1 = ((AbstractThingRepository)localObject2).S4((AutoUpdateBean)localObject1);
    }
    else
    {
      localObject2 = this.b;
      if (localObject2 != null) {
        localObject1 = ((AbstractSubThingRepository)localObject2).b4((AutoUpdateBean)localObject1);
      } else {
        localObject1 = io.reactivex.a.e();
      }
    }
    localObject1 = ((io.reactivex.a)localObject1).r(io.reactivex.d0.b.a.a()).l(new d(this)).h(new e(this)).A(new f(this), new h(this));
    this.f.b((io.reactivex.e0.c)localObject1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\AutoUpdateViewMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
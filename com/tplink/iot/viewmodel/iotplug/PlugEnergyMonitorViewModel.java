package com.tplink.iot.viewmodel.iotplug;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.q;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class PlugEnergyMonitorViewModel
  extends AndroidViewModel
{
  private final f a;
  
  public PlugEnergyMonitorViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = h.b(new a(paramThingContext));
  }
  
  private final PlugRepository g()
  {
    return (PlugRepository)this.a.getValue();
  }
  
  public final void f()
  {
    if (h().getValue() == null)
    {
      PlugRepository localPlugRepository = g();
      j.d(localPlugRepository, "mPlugRepository");
      localPlugRepository.f5().F0();
    }
  }
  
  public final LiveData<EnergyUsageResult> h()
  {
    Object localObject = g();
    j.d(localObject, "mPlugRepository");
    localObject = ((PlugRepository)localObject).g5();
    j.d(localObject, "mPlugRepository.energyUsageLiveData");
    return (LiveData<EnergyUsageResult>)localObject;
  }
  
  static final class a
    extends Lambda
    implements a<PlugRepository>
  {
    a(ThingContext paramThingContext)
    {
      super();
    }
    
    public final PlugRepository a()
    {
      return (PlugRepository)e.a(this.c, PlugRepository.class);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\PlugEnergyMonitorViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
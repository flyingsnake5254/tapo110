package com.tplink.iot.viewmodel.iotplug;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.d;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumPowerOnState;
import io.reactivex.g0.g;
import kotlin.jvm.internal.j;

public final class PlugPowerOnAgainViewModel
  extends AndroidViewModel
{
  private final PlugRepository a;
  private final SingleLiveEvent<Boolean> b;
  
  public PlugPowerOnAgainViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = e.f(paramThingContext).a(paramThingContext, PlugRepository.class);
    j.d(paramApplication, "IoTDeviceRepositoryProvi…ugRepository::class.java)");
    this.a = ((PlugRepository)paramApplication);
    this.b = new SingleLiveEvent();
  }
  
  public final LiveData<EnumPowerOnState> f()
  {
    LiveData localLiveData = Transformations.map(this.a.e5(), a.a);
    j.d(localLiveData, "Transformations.map(mPlu…ate.LAST_STATES\n        }");
    return localLiveData;
  }
  
  public final SingleLiveEvent<Boolean> g()
  {
    return this.b;
  }
  
  public final void h(EnumPowerOnState paramEnumPowerOnState)
  {
    j.e(paramEnumPowerOnState, "powerOnState");
    DefaultStatesBean localDefaultStatesBean = new DefaultStatesBean();
    localDefaultStatesBean.setType(paramEnumPowerOnState.getType());
    if (j.a(paramEnumPowerOnState.getType(), "custom"))
    {
      LightStateBean localLightStateBean = new LightStateBean();
      boolean bool;
      if (paramEnumPowerOnState == EnumPowerOnState.ALWAYS_ON) {
        bool = true;
      } else {
        bool = false;
      }
      localLightStateBean.setOn(bool);
      localDefaultStatesBean.setLightState(localLightStateBean);
    }
    paramEnumPowerOnState = new StringBuilder();
    paramEnumPowerOnState.append("setPowerOnState: ");
    paramEnumPowerOnState.append(i.j(localDefaultStatesBean));
    b.d.w.c.a.h(paramEnumPowerOnState.toString());
    this.a.m5(localDefaultStatesBean).r(io.reactivex.d0.b.a.a()).j(new b(this)).i(new c(this)).y();
  }
  
  static final class a<I, O>
    implements Function<IoTPlugDevice, EnumPowerOnState>
  {
    public static final a a = new a();
    
    public final EnumPowerOnState a(IoTPlugDevice paramIoTPlugDevice)
    {
      if (paramIoTPlugDevice != null)
      {
        paramIoTPlugDevice = paramIoTPlugDevice.getDefaultStates();
        if (paramIoTPlugDevice != null)
        {
          if ((!j.a(paramIoTPlugDevice.getType(), "last_states")) && (paramIoTPlugDevice.getLightState() != null))
          {
            paramIoTPlugDevice = paramIoTPlugDevice.getLightState();
            j.d(paramIoTPlugDevice, "lightState");
            if (paramIoTPlugDevice.isOn()) {
              paramIoTPlugDevice = EnumPowerOnState.ALWAYS_ON;
            } else {
              paramIoTPlugDevice = EnumPowerOnState.ALWAYS_OFF;
            }
          }
          else
          {
            paramIoTPlugDevice = EnumPowerOnState.LAST_STATES;
          }
          if (paramIoTPlugDevice != null) {
            return paramIoTPlugDevice;
          }
        }
      }
      paramIoTPlugDevice = EnumPowerOnState.LAST_STATES;
      return paramIoTPlugDevice;
    }
  }
  
  static final class b<T>
    implements g<Throwable>
  {
    b(PlugPowerOnAgainViewModel paramPlugPowerOnAgainViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.g().setValue(Boolean.FALSE);
    }
  }
  
  static final class c
    implements io.reactivex.g0.a
  {
    c(PlugPowerOnAgainViewModel paramPlugPowerOnAgainViewModel) {}
    
    public final void run()
    {
      this.a.g().setValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\PlugPowerOnAgainViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
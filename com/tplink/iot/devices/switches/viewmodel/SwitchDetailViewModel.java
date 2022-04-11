package com.tplink.iot.devices.switches.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.devicecommon.feature.NextEventFeature.b;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.BatteryDetectInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<*>;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;
import kotlin.t.c;

public final class SwitchDetailViewModel
  extends IoTDetailBaseViewModel
{
  private final c s;
  private final LiveData<IoTSubDevice> t;
  private final LiveData<ThingUsage> u;
  private final ObservableBoolean v;
  private final MediatorLiveData<Boolean> w;
  private final LiveData<Boolean> x;
  private final LiveData<Integer> y;
  private final NextEventFeature.b z;
  
  public SwitchDetailViewModel(Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
    this.s = new a(paramThingContext);
    paramApplication = Transformations.map(i(), d.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…ce as? IoTSubDevice\n    }");
    this.t = paramApplication;
    Object localObject = S().d1();
    kotlin.jvm.internal.j.d(localObject, "mSwitchRepository.deviceUsageLiveData");
    this.u = ((LiveData)localObject);
    localObject = (IoTSubDevice)paramApplication.getValue();
    boolean bool;
    if (localObject != null) {
      bool = ((LocalIoTBaseDevice)localObject).isDeviceOn();
    } else {
      bool = false;
    }
    this.v = new ObservableBoolean(bool);
    localObject = new MediatorLiveData();
    this.w = ((MediatorLiveData)localObject);
    this.x = ((LiveData)localObject);
    this.y = S().j4();
    this.z = new e(this, paramThingContext);
    ((MediatorLiveData)localObject).addSource(S().U0(), new b(this));
    ((MediatorLiveData)localObject).addSource(paramApplication, new c(this));
  }
  
  private final void P()
  {
    S().Z0().F0();
  }
  
  private final SwitchRepository S()
  {
    return (SwitchRepository)this.s.b(this, r[0]);
  }
  
  private final void T()
  {
    S().l1().F0();
  }
  
  public void E()
  {
    P();
  }
  
  public void F()
  {
    o().addSource(S().h1(), new h(this));
  }
  
  public final LiveData<IoTSubDevice> O()
  {
    return this.t;
  }
  
  public final void Q()
  {
    S().c1().L0(io.reactivex.l0.a.c()).F0();
  }
  
  public final LiveData<ThingUsage> R()
  {
    return this.u;
  }
  
  public final NextEventFeature.b U()
  {
    return this.z;
  }
  
  public final LiveData<Integer> V()
  {
    return this.y;
  }
  
  public final LiveData<Boolean> W()
  {
    return this.x;
  }
  
  public final ObservableBoolean X()
  {
    return this.v;
  }
  
  public final void Y(boolean paramBoolean)
  {
    this.v.set(paramBoolean);
    final long l = System.currentTimeMillis();
    S().i(paramBoolean).r(io.reactivex.d0.b.a.a()).i(new f(this, l)).j(new g(this, l)).y();
  }
  
  public final void Z(boolean paramBoolean)
  {
    S().s4(paramBoolean);
  }
  
  public q<CloudConnectStateResult> j()
  {
    q localq = S().V0();
    kotlin.jvm.internal.j.d(localq, "mSwitchRepository.cloudConnectState");
    return localq;
  }
  
  public ThingBaseRepository r()
  {
    return S();
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
  
  static final class b<T>
    implements Observer<BatteryDetectInfoResult>
  {
    b(SwitchDetailViewModel paramSwitchDetailViewModel) {}
    
    public final void a(BatteryDetectInfoResult paramBatteryDetectInfoResult)
    {
      MediatorLiveData localMediatorLiveData = SwitchDetailViewModel.K(this.a);
      boolean bool;
      if (paramBatteryDetectInfoResult != null) {
        bool = paramBatteryDetectInfoResult.isLow();
      } else {
        bool = false;
      }
      localMediatorLiveData.postValue(Boolean.valueOf(bool));
    }
  }
  
  static final class c<T>
    implements Observer<IoTSubDevice>
  {
    c(SwitchDetailViewModel paramSwitchDetailViewModel) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      MediatorLiveData localMediatorLiveData = SwitchDetailViewModel.K(this.a);
      boolean bool;
      if (paramIoTSubDevice != null) {
        bool = paramIoTSubDevice.isAtLowBattery();
      } else {
        bool = false;
      }
      localMediatorLiveData.postValue(Boolean.valueOf(bool));
    }
  }
  
  static final class d<I, O>
    implements Function<BaseALIoTDevice<?>, IoTSubDevice>
  {
    public static final d a = new d();
    
    public final IoTSubDevice a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      Object localObject = null;
      if (paramBaseALIoTDevice != null) {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getLocalIoTDevice();
      } else {
        paramBaseALIoTDevice = null;
      }
      if (!(paramBaseALIoTDevice instanceof IoTSubDevice)) {
        paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject;
      }
      return (IoTSubDevice)paramBaseALIoTDevice;
    }
  }
  
  public static final class e
    implements NextEventFeature.b
  {
    e(ThingContext paramThingContext) {}
    
    public void a()
    {
      SwitchDetailViewModel.I(this.a);
    }
    
    public LiveData<NextEvent> b()
    {
      LiveData localLiveData = Transformations.map(SwitchDetailViewModel.M(this.a).m1(), a.a);
      kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(mSwi…xtEvent(it)\n            }");
      return localLiveData;
    }
    
    public void c()
    {
      SwitchDetailViewModel.N(this.a);
    }
    
    public String d()
    {
      Object localObject = (ALIoTDevice)paramThingContext.getIoTDevice();
      if (localObject != null)
      {
        localObject = ((ALIoTDevice)localObject).getLocalIoTDevice();
        if (localObject != null) {
          return ((LocalIoTBaseDevice)localObject).getRegion();
        }
      }
      localObject = null;
      return (String)localObject;
    }
    
    static final class a<I, O>
      implements Function<NextEvent, NextEvent>
    {
      public static final a a = new a();
      
      public final NextEvent a(NextEvent paramNextEvent)
      {
        return new PlugNextEvent(paramNextEvent);
      }
    }
  }
  
  static final class f
    implements io.reactivex.g0.a
  {
    f(SwitchDetailViewModel paramSwitchDetailViewModel, long paramLong) {}
    
    public final void run()
    {
      com.tplink.iot.Utils.x0.j.c(SwitchDetailViewModel.J(this.a), System.currentTimeMillis() - l, true);
    }
  }
  
  static final class g<T>
    implements g<Throwable>
  {
    g(SwitchDetailViewModel paramSwitchDetailViewModel, long paramLong) {}
    
    public final void a(Throwable paramThrowable)
    {
      com.tplink.iot.Utils.x0.j.c(SwitchDetailViewModel.J(this.c), System.currentTimeMillis() - l, false);
    }
  }
  
  static final class h<T>
    implements Observer<ThingFirmware>
  {
    h(SwitchDetailViewModel paramSwitchDetailViewModel) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      MediatorLiveData localMediatorLiveData = SwitchDetailViewModel.L(this.a);
      boolean bool = true;
      if ((paramThingFirmware == null) || (paramThingFirmware.isNeedToUpgrade() != true)) {
        bool = false;
      }
      localMediatorLiveData.postValue(Boolean.valueOf(bool));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\viewmodel\SwitchDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
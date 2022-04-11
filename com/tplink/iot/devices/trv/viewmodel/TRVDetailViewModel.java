package com.tplink.iot.devices.trv.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.w0.b;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.devicecommon.feature.NextEventFeature.b;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.SubDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVTemperatureRecordsResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<*>;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import io.reactivex.q;
import kotlin.t.c;

public final class TRVDetailViewModel
  extends IoTDetailBaseViewModel
{
  private final boolean A;
  private final boolean B;
  private final c s;
  private final LiveData<IoTSubDevice> t;
  private final LiveData<ChildProtectionBean> u;
  private final LiveData<TRVTemperatureRecordsResult> v;
  private final LiveData<FrostProtectionBean> w;
  private final com.tplink.libtpnetwork.IoTNetwork.util.a x;
  private final LiveData<Integer> y;
  private final NextEventFeature.b z;
  
  public TRVDetailViewModel(Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
    this.s = new a(paramThingContext);
    paramApplication = Transformations.map(i(), d.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…ce as? IoTSubDevice\n    }");
    this.t = paramApplication;
    this.u = S().s4();
    this.v = S().F4();
    this.w = S().w4();
    paramApplication = new com.tplink.libtpnetwork.IoTNetwork.util.a();
    this.x = paramApplication;
    this.y = paramApplication.c();
    this.z = new b(this, paramThingContext);
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
    if (paramApplication != null) {
      paramApplication = paramApplication.getLocalIoTDevice();
    } else {
      paramApplication = null;
    }
    this.A = b.a(paramApplication, EnumIoTComponent.CHILD_PROTECTION);
    this.B = b.a(paramApplication, EnumIoTComponent.FROST_PROTECTION);
  }
  
  private final void P()
  {
    S().Z0().F0();
  }
  
  private final TRVRepository S()
  {
    return (TRVRepository)this.s.b(this, r[0]);
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
    o().addSource(S().h1(), new c(this));
  }
  
  public final void M()
  {
    S().r4().F0();
  }
  
  public final LiveData<ChildProtectionBean> N()
  {
    return this.u;
  }
  
  public final LiveData<Integer> O()
  {
    return this.y;
  }
  
  public final void Q()
  {
    S().v4().F0();
  }
  
  public final LiveData<FrostProtectionBean> R()
  {
    return this.w;
  }
  
  public final NextEventFeature.b U()
  {
    return this.z;
  }
  
  public final void V()
  {
    S().E4().F0();
  }
  
  public final LiveData<TRVTemperatureRecordsResult> W()
  {
    return this.v;
  }
  
  public final LiveData<IoTSubDevice> X()
  {
    return this.t;
  }
  
  public final boolean Y()
  {
    return this.A;
  }
  
  public final void Z(boolean paramBoolean)
  {
    SubDeviceInfoParams localSubDeviceInfoParams = new SubDeviceInfoParams();
    localSubDeviceInfoParams.setFrostProtectionOn(Boolean.valueOf(paramBoolean));
    S().L4(localSubDeviceInfoParams).f(this.x.b()).y();
  }
  
  public final void a0(int paramInt, EnumTemperatureUnit paramEnumTemperatureUnit)
  {
    kotlin.jvm.internal.j.e(paramEnumTemperatureUnit, "unit");
    SubDeviceInfoParams localSubDeviceInfoParams = new SubDeviceInfoParams();
    localSubDeviceInfoParams.setTargetTemp(Integer.valueOf(paramInt));
    localSubDeviceInfoParams.setTempUnit(paramEnumTemperatureUnit.getValue());
    localSubDeviceInfoParams.setFrostProtectionOn(Boolean.FALSE);
    S().L4(localSubDeviceInfoParams).f(this.x.b()).y();
  }
  
  public q<CloudConnectStateResult> j()
  {
    q localq = S().V0();
    kotlin.jvm.internal.j.d(localq, "mTRVRepository.cloudConnectState");
    return localq;
  }
  
  public ThingBaseRepository r()
  {
    return S();
  }
  
  public static final class a
    implements c<Object, TRVRepository>
  {
    private final TRVRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, TRVRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public TRVRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  public static final class b
    implements NextEventFeature.b
  {
    b(ThingContext paramThingContext) {}
    
    public void a()
    {
      TRVDetailViewModel.I(this.a);
    }
    
    public LiveData<NextEvent> b()
    {
      LiveData localLiveData = Transformations.map(TRVDetailViewModel.K(this.a).m1(), a.a);
      kotlin.jvm.internal.j.d(localLiveData, "Transformations.map(mTRV…ata) { TRVNextEvent(it) }");
      return localLiveData;
    }
    
    public void c()
    {
      TRVDetailViewModel.L(this.a);
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
        return new TRVNextEvent(paramNextEvent);
      }
    }
  }
  
  static final class c<T>
    implements Observer<ThingFirmware>
  {
    c(TRVDetailViewModel paramTRVDetailViewModel) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      MediatorLiveData localMediatorLiveData = TRVDetailViewModel.J(this.a);
      boolean bool = true;
      if ((paramThingFirmware == null) || (paramThingFirmware.isNeedToUpgrade() != true)) {
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\viewmodel\TRVDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
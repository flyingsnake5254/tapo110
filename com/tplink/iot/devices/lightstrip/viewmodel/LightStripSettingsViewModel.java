package com.tplink.iot.devices.lightstrip.viewmodel;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.DeviceSegmentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumLightStripAvatarType.a;
import io.reactivex.q;

public final class LightStripSettingsViewModel
  extends IoTSettingsBaseViewModel
{
  private final kotlin.t.c p;
  private final LiveData<IoTLightStripDevice> q;
  private final LiveData<Boolean> r;
  private final LiveData<Boolean> s;
  private final boolean t;
  private final LiveData<Integer> u;
  
  public LightStripSettingsViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication, paramThingContext);
    this.p = new a(paramThingContext);
    paramApplication = Transformations.map(D().j1(), b.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mLig…IoTLightStripDevice\n    }");
    this.q = paramApplication;
    paramApplication = Transformations.map(paramApplication, d.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(devi…GRADUALLY) ?: false\n    }");
    this.r = paramApplication;
    paramApplication = Transformations.map(D().y5(), c.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mLig…?.isEnable ?: false\n    }");
    this.s = paramApplication;
    this.t = com.tplink.iot.Utils.w0.a.g(paramThingContext.getDeviceIdMD5(), EnumIoTComponent.SEGMENT);
    this.u = D().s5();
  }
  
  private final LightStripRepository D()
  {
    return (LightStripRepository)this.p.b(this, o[0]);
  }
  
  public final LiveData<IoTLightStripDevice> A()
  {
    return this.q;
  }
  
  public final void B()
  {
    D().r5().F0();
  }
  
  public final LiveData<Integer> C()
  {
    return this.u;
  }
  
  public final void E()
  {
    D().x5().F0();
  }
  
  public final LiveData<Boolean> F()
  {
    return this.s;
  }
  
  public final LiveData<Boolean> G()
  {
    return this.r;
  }
  
  public final boolean H()
  {
    return this.t;
  }
  
  public final void I(DefaultStatesBean paramDefaultStatesBean)
  {
    kotlin.jvm.internal.j.e(paramDefaultStatesBean, "defaultStates");
    D().E5(paramDefaultStatesBean).y();
  }
  
  public final io.reactivex.a J(int paramInt)
  {
    return D().F5(new DeviceSegmentBean(paramInt));
  }
  
  public final void K(boolean paramBoolean)
  {
    D().L5(new OnOffGraduallyBean(paramBoolean)).F0();
  }
  
  public int l(String paramString)
  {
    return com.tplink.iot.g.b.c.c.c(EnumLightStripAvatarType.Companion.a(paramString));
  }
  
  public void m()
  {
    D().p1().F0();
  }
  
  public void o()
  {
    D().v1().F0();
  }
  
  public LiveData<ThingFirmware> p()
  {
    LiveData localLiveData = D().w1();
    kotlin.jvm.internal.j.d(localLiveData, "mLightStripRepository.firmwareLatestInfoData");
    return localLiveData;
  }
  
  public static final class a
    implements kotlin.t.c<Object, LightStripRepository>
  {
    private final LightStripRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, LightStripRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public LightStripRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class b<I, O>
    implements Function<LocalIoTBaseDevice, IoTLightStripDevice>
  {
    public static final b a = new b();
    
    public final IoTLightStripDevice a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      LocalIoTBaseDevice localLocalIoTBaseDevice = paramLocalIoTBaseDevice;
      if (!(paramLocalIoTBaseDevice instanceof IoTLightStripDevice)) {
        localLocalIoTBaseDevice = null;
      }
      return (IoTLightStripDevice)localLocalIoTBaseDevice;
    }
  }
  
  static final class c<I, O>
    implements Function<OnOffGraduallyBean, Boolean>
  {
    public static final c a = new c();
    
    public final Boolean a(OnOffGraduallyBean paramOnOffGraduallyBean)
    {
      boolean bool;
      if (paramOnOffGraduallyBean != null) {
        bool = paramOnOffGraduallyBean.isEnable();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class d<I, O>
    implements Function<IoTLightStripDevice, Boolean>
  {
    public static final d a = new d();
    
    public final Boolean a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      boolean bool;
      if (paramIoTLightStripDevice != null) {
        bool = paramIoTLightStripDevice.isSupportComponent(EnumIoTComponent.ON_OFF_GRADUALLY);
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\viewmodel\LightStripSettingsViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
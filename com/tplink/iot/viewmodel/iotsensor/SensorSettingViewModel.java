package com.tplink.iot.viewmodel.iotsensor;

import android.app.Application;
import androidx.arch.core.util.Function;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import b.d.b.f.b;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SensorSettingViewModel
  extends AndroidViewModel
{
  private final TPIoTClientManager a;
  private final SensorRepository b;
  private final String c;
  private final MediatorLiveData<BaseALIoTDevice<?>> d;
  private final LiveData<BaseALIoTDevice<?>> e;
  private final LiveData<IoTSubDevice> f;
  private final MediatorLiveData<Boolean> g;
  private final MediatorLiveData<Boolean> h;
  private final MutableLiveData<i<p>> i;
  private final LiveData<i<p>> j;
  private final MutableLiveData<i<CloudResult<p>>> k;
  private final LiveData<i<CloudResult<p>>> l;
  private final LiveData<Boolean> m;
  private final LiveData<String> n;
  private final LiveData<Integer> o;
  private final LiveData<String> p;
  private final LiveData<String> q;
  private final ObservableBoolean r;
  private final LiveData<Integer> s;
  private LiveData<Boolean> t;
  private final LiveData<String> u;
  private final LiveData<ThingFirmware> v;
  
  public SensorSettingViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    Object localObject1 = (TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.a = ((TPIoTClientManager)localObject1);
    Object localObject2 = e.a(paramThingContext, SensorRepository.class);
    j.d(localObject2, "IoTDeviceRepositoryProvi…orRepository::class.java)");
    localObject2 = (SensorRepository)localObject2;
    this.b = ((SensorRepository)localObject2);
    this.c = paramThingContext.getDeviceIdMD5();
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    this.d = localMediatorLiveData;
    this.e = localMediatorLiveData;
    LiveData localLiveData = ((SensorRepository)localObject2).i4();
    this.f = localLiveData;
    Object localObject3 = new MediatorLiveData();
    this.g = ((MediatorLiveData)localObject3);
    this.h = ((MediatorLiveData)localObject3);
    localObject3 = new MutableLiveData();
    this.i = ((MutableLiveData)localObject3);
    this.j = ((LiveData)localObject3);
    localObject3 = new MutableLiveData();
    this.k = ((MutableLiveData)localObject3);
    this.l = ((LiveData)localObject3);
    j.d(localObject1, "mTPIoTClientManager");
    localMediatorLiveData.addSource(((TPIoTClientManager)localObject1).C1(), new a(this));
    localObject1 = Transformations.map(localMediatorLiveData, h.a);
    j.d(localObject1, "Transformations.map(alIo…ypeDevice\n        }\n    }");
    this.m = ((LiveData)localObject1);
    paramApplication = Transformations.map(localMediatorLiveData, new f(paramApplication));
    j.d(paramApplication, "Transformations.map(alIo…e, it?.deviceModel)\n    }");
    this.n = paramApplication;
    paramApplication = Transformations.map(localLiveData, d.a);
    j.d(paramApplication, "Transformations.map(devi….avatar, it?.model)\n    }");
    this.o = paramApplication;
    paramApplication = Transformations.map(localMediatorLiveData, e.a);
    j.d(paramApplication, "Transformations.map(alIo…getRoomLocation(it)\n    }");
    this.p = paramApplication;
    this.q = ((SensorRepository)localObject2).n4();
    paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
    if (paramApplication != null)
    {
      paramApplication = paramApplication.getLocalIoTDevice();
      if (paramApplication != null)
      {
        bool = paramApplication.isSupportComponent(EnumIoTComponent.SENSITIVITY);
        break label321;
      }
    }
    boolean bool = false;
    label321:
    this.r = new ObservableBoolean(bool);
    this.s = ((SensorRepository)localObject2).l4();
    paramApplication = Transformations.map(localLiveData, i.a);
    j.d(paramApplication, "Transformations.map(devi…rtFirmware ?: false\n    }");
    this.t = paramApplication;
    paramApplication = Transformations.map(localMediatorLiveData, g.a);
    j.d(paramApplication, "Transformations.map(alIo…{ it?.deviceFwVer ?: \"\" }");
    this.u = paramApplication;
    paramApplication = ((AbstractSubThingRepository)localObject2).h1();
    j.d(paramApplication, "mSensorRepository.firmwareLatestInfoData");
    this.v = paramApplication;
  }
  
  public final ObservableBoolean A()
  {
    return this.r;
  }
  
  public final LiveData<Boolean> B()
  {
    return this.m;
  }
  
  public final LiveData<Boolean> C()
  {
    return this.t;
  }
  
  public final void D(String paramString)
  {
    j.e(paramString, "deviceIdMD5");
    this.a.n1(paramString).L0(io.reactivex.l0.a.c()).E(new j(this)).C(new k(this)).F0();
  }
  
  public final void f(String paramString)
  {
    j.e(paramString, "deviceIdMD5");
    this.a.w(kotlin.collections.l.b(paramString)).i(new b(this)).j(new c(this)).y();
  }
  
  public final LiveData<i<CloudResult<p>>> k()
  {
    return this.l;
  }
  
  public final LiveData<BaseALIoTDevice<?>> l()
  {
    return this.e;
  }
  
  public final LiveData<Integer> m()
  {
    return this.o;
  }
  
  public final LiveData<String> n()
  {
    return this.p;
  }
  
  public final LiveData<String> o()
  {
    return this.n;
  }
  
  public final void p()
  {
    this.b.Z0().F0();
  }
  
  public final int r()
  {
    Object localObject = (BaseALIoTDevice)this.e.getValue();
    if (localObject != null)
    {
      localObject = ((BaseALIoTDevice)localObject).getDeviceManagerInfo();
      if (localObject != null)
      {
        localObject = ((DeviceManagerInfoBean)localObject).getUserInfo();
        if (localObject != null)
        {
          i1 = ((List)localObject).size();
          break label45;
        }
      }
    }
    int i1 = 1;
    label45:
    return i1 - 1;
  }
  
  public final void s()
  {
    this.b.g1().F0();
  }
  
  public final LiveData<ThingFirmware> t()
  {
    return this.v;
  }
  
  public final LiveData<String> u()
  {
    return this.u;
  }
  
  public final LiveData<Integer> v()
  {
    return this.s;
  }
  
  public final void w()
  {
    this.b.m4().F0();
  }
  
  public final LiveData<String> x()
  {
    return this.q;
  }
  
  public final LiveData<i<p>> y()
  {
    return this.j;
  }
  
  public final boolean z()
  {
    BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)this.d.getValue();
    boolean bool;
    if (localBaseALIoTDevice != null) {
      bool = localBaseALIoTDevice.isUserRoleTypeDevice();
    } else {
      bool = false;
    }
    return bool;
  }
  
  static final class a<T>
    implements Observer<List<BaseALIoTDevice<TDPIoTDevice>>>
  {
    a(SensorSettingViewModel paramSensorSettingViewModel) {}
    
    public final void a(List<BaseALIoTDevice<TDPIoTDevice>> paramList)
    {
      MediatorLiveData localMediatorLiveData = SensorSettingViewModel.g(this.a);
      Object localObject1 = null;
      Object localObject2 = null;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        BaseALIoTDevice localBaseALIoTDevice;
        do
        {
          paramList = (List<BaseALIoTDevice<TDPIoTDevice>>)localObject2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramList = ((Iterator)localObject1).next();
          localBaseALIoTDevice = (BaseALIoTDevice)paramList;
          j.d(localBaseALIoTDevice, "device");
        } while (!j.a(localBaseALIoTDevice.getDeviceIdMD5(), SensorSettingViewModel.i(this.a)));
        localObject1 = (BaseALIoTDevice)paramList;
      }
      localMediatorLiveData.postValue(localObject1);
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(SensorSettingViewModel paramSensorSettingViewModel) {}
    
    public final void run()
    {
      SensorSettingViewModel.h(this.a).postValue(new i(0, null));
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(SensorSettingViewModel paramSensorSettingViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof CloudException)) {
        SensorSettingViewModel.h(this.c).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
      } else {
        SensorSettingViewModel.h(this.c).postValue(new i(1, null));
      }
    }
  }
  
  static final class d<I, O>
    implements Function<IoTSubDevice, Integer>
  {
    public static final d a = new d();
    
    public final Integer a(IoTSubDevice paramIoTSubDevice)
    {
      String str1 = null;
      String str2;
      if (paramIoTSubDevice != null) {
        str2 = paramIoTSubDevice.getAvatar();
      } else {
        str2 = null;
      }
      if (paramIoTSubDevice != null) {
        str1 = paramIoTSubDevice.getModel();
      }
      return Integer.valueOf(r.f(str2, str1));
    }
  }
  
  static final class e<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    public static final e a = new e();
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      return com.tplink.iot.Utils.z0.l.h(paramBaseALIoTDevice);
    }
  }
  
  static final class f<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    f(Application paramApplication) {}
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      Application localApplication = this.a;
      String str1 = null;
      String str2;
      if (paramBaseALIoTDevice != null) {
        str2 = paramBaseALIoTDevice.getDeviceType();
      } else {
        str2 = null;
      }
      String str3;
      if (paramBaseALIoTDevice != null) {
        str3 = paramBaseALIoTDevice.getDeviceName();
      } else {
        str3 = null;
      }
      if (paramBaseALIoTDevice != null) {
        str1 = paramBaseALIoTDevice.getDeviceModel();
      }
      return com.tplink.iot.Utils.z0.l.e(localApplication, str2, str3, str1);
    }
  }
  
  static final class g<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    public static final g a = new g();
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      if (paramBaseALIoTDevice != null)
      {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceFwVer();
        if (paramBaseALIoTDevice != null) {}
      }
      else
      {
        paramBaseALIoTDevice = "";
      }
      return paramBaseALIoTDevice;
    }
  }
  
  static final class h<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final h a = new h();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool1 = true;
      boolean bool2;
      if (paramBaseALIoTDevice == null)
      {
        bool2 = bool1;
      }
      else
      {
        bool2 = bool1;
        if (paramBaseALIoTDevice.isSupportIoTCloud()) {
          if (paramBaseALIoTDevice.isUserRoleTypeDevice()) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
      }
      return Boolean.valueOf(bool2);
    }
  }
  
  static final class i<I, O>
    implements Function<IoTSubDevice, Boolean>
  {
    public static final i a = new i();
    
    public final Boolean a(IoTSubDevice paramIoTSubDevice)
    {
      boolean bool;
      if (paramIoTSubDevice != null) {
        bool = paramIoTSubDevice.isSupportFirmware();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class j<T>
    implements g<Boolean>
  {
    j(SensorSettingViewModel paramSensorSettingViewModel) {}
    
    public final void a(Boolean paramBoolean)
    {
      SensorSettingViewModel.j(this.c).postValue(new i(0, p.a));
    }
  }
  
  static final class k<T>
    implements g<Throwable>
  {
    k(SensorSettingViewModel paramSensorSettingViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof CloudException)) {
        SensorSettingViewModel.j(this.c).postValue(new i(((CloudException)paramThrowable).getErrCode(), p.a));
      } else {
        SensorSettingViewModel.j(this.c).postValue(new i(1, p.a));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotsensor\SensorSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
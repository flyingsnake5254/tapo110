package com.tplink.iot.devicecommon.viewmodel;

import android.app.Application;
import androidx.annotation.DrawableRes;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import b.d.b.f.b;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<*>;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import kotlin.p;

public abstract class IoTSettingsBaseViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b;
  private final String c;
  private final kotlin.t.c d;
  private final SingleLiveEvent<i<p>> e;
  private final LiveData<i<p>> f;
  private final SingleLiveEvent<i<CloudResult<Void>>> g;
  private final LiveData<i<CloudResult<Void>>> h;
  private final LiveData<Boolean> i;
  private final LiveData<Integer> j;
  private final LiveData<String> k;
  private final LiveData<String> l;
  private LiveData<Boolean> m;
  private final LiveData<String> n;
  
  public IoTSettingsBaseViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = new a(paramThingContext);
    paramApplication = paramThingContext.getDeviceIdMD5();
    if (paramApplication == null) {
      paramApplication = "";
    }
    this.c = paramApplication;
    this.d = com.tplink.iot.Utils.extension.c.a(paramThingContext);
    paramApplication = new SingleLiveEvent();
    this.e = paramApplication;
    this.f = paramApplication;
    paramApplication = new SingleLiveEvent();
    this.g = paramApplication;
    this.h = paramApplication;
    paramApplication = Transformations.map(j(), f.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…ypeDevice\n        }\n    }");
    this.i = paramApplication;
    paramApplication = Transformations.map(j(), new d(this));
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…Res(it?.deviceIcon)\n    }");
    this.j = paramApplication;
    paramApplication = Transformations.map(j(), new h(this));
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…e, it?.deviceModel)\n    }");
    this.k = paramApplication;
    paramApplication = Transformations.map(j(), i.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…getRoomLocation(it)\n    }");
    this.l = paramApplication;
    paramApplication = Transformations.map(j(), g.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…rtFirmware ?: false\n    }");
    this.m = paramApplication;
    paramApplication = Transformations.map(j(), e.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…{ it?.deviceFwVer ?: \"\" }");
    this.n = paramApplication;
  }
  
  public final void f(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
    s().w(kotlin.collections.l.b(paramString)).r(io.reactivex.d0.b.a.a()).i(new b(this)).j(new c(this)).y();
  }
  
  public final LiveData<i<CloudResult<Void>>> i()
  {
    return this.h;
  }
  
  public final LiveData<BaseALIoTDevice<?>> j()
  {
    return (LiveData)this.d.b(this, a[1]);
  }
  
  public final LiveData<Integer> k()
  {
    return this.j;
  }
  
  @DrawableRes
  public abstract int l(String paramString);
  
  public abstract void m();
  
  public final int n()
  {
    Object localObject = (BaseALIoTDevice)j().getValue();
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
  
  public abstract void o();
  
  public abstract LiveData<ThingFirmware> p();
  
  public final LiveData<String> r()
  {
    return this.n;
  }
  
  protected final TPIoTClientManager s()
  {
    return (TPIoTClientManager)this.b.b(this, a[0]);
  }
  
  public final LiveData<String> t()
  {
    return this.k;
  }
  
  public final LiveData<String> u()
  {
    return this.l;
  }
  
  public final LiveData<i<p>> v()
  {
    return this.f;
  }
  
  public final boolean w()
  {
    BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)j().getValue();
    boolean bool;
    if (localBaseALIoTDevice != null) {
      bool = localBaseALIoTDevice.isUserRoleTypeDevice();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public LiveData<Boolean> x()
  {
    return this.i;
  }
  
  public final LiveData<Boolean> y()
  {
    return this.m;
  }
  
  public final void z(String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "deviceIdMD5");
    s().n1(paramString).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new j(this)).C(new k(this)).F0();
  }
  
  public static final class a
    implements kotlin.t.c<Object, TPIoTClientManager>
  {
    private final TPIoTClientManager a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
      kotlin.jvm.internal.j.d(paramThingContext, "CloudRepositoryProviders…ontext, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public TPIoTClientManager c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class b
    implements io.reactivex.g0.a
  {
    b(IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel) {}
    
    public final void run()
    {
      IoTSettingsBaseViewModel.g(this.a).setValue(new i(0, null));
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof CloudException)) {
        IoTSettingsBaseViewModel.g(this.c).setValue(new i(((CloudException)paramThrowable).getErrCode(), null));
      } else {
        IoTSettingsBaseViewModel.g(this.c).setValue(new i(1, null));
      }
    }
  }
  
  static final class d<I, O>
    implements Function<BaseALIoTDevice<?>, Integer>
  {
    d(IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel) {}
    
    public final Integer a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      IoTSettingsBaseViewModel localIoTSettingsBaseViewModel = this.a;
      if (paramBaseALIoTDevice != null) {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceIcon();
      } else {
        paramBaseALIoTDevice = null;
      }
      return Integer.valueOf(localIoTSettingsBaseViewModel.l(paramBaseALIoTDevice));
    }
  }
  
  static final class e<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    public static final e a = new e();
    
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
  
  static final class f<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final f a = new f();
    
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
  
  static final class g<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final g a = new g();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      Object localObject = null;
      if (paramBaseALIoTDevice != null) {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getLocalIoTDevice();
      } else {
        paramBaseALIoTDevice = null;
      }
      if (!(paramBaseALIoTDevice instanceof LocalIoTBaseDevice)) {
        paramBaseALIoTDevice = (BaseALIoTDevice<?>)localObject;
      }
      paramBaseALIoTDevice = (LocalIoTBaseDevice)paramBaseALIoTDevice;
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isSupportFirmware();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class h<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    h(IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel) {}
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      Application localApplication = this.a.getApplication();
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
  
  static final class i<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    public static final i a = new i();
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      return com.tplink.iot.Utils.z0.l.h(paramBaseALIoTDevice);
    }
  }
  
  static final class j<T>
    implements g<Boolean>
  {
    j(IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel) {}
    
    public final void a(Boolean paramBoolean)
    {
      IoTSettingsBaseViewModel.h(this.c).setValue(new i(0, null));
    }
  }
  
  static final class k<T>
    implements g<Throwable>
  {
    k(IoTSettingsBaseViewModel paramIoTSettingsBaseViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof CloudException)) {
        IoTSettingsBaseViewModel.h(this.c).setValue(new i(((CloudException)paramThrowable).getErrCode(), null));
      } else {
        IoTSettingsBaseViewModel.h(this.c).setValue(new i(1, null));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\viewmodel\IoTSettingsBaseViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.iot.devicecommon.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import b.d.b.f.b;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class IoTDetailBaseViewModel
  extends AndroidViewModel
{
  private final kotlin.t.c b;
  private final String c;
  private final kotlin.t.c d;
  private final MutableLiveData<i<CloudConnectStateResult>> e;
  private final LiveData<i<CloudConnectStateResult>> f;
  private boolean g;
  private final MediatorLiveData<Boolean> h;
  private io.reactivex.e0.c i;
  private final LiveData<String> j;
  private final LiveData<String> k;
  private final LiveData<Boolean> l;
  private final LiveData<Boolean> m;
  private final LiveData<Boolean> n;
  private final LiveData<Integer> o;
  private final LiveData<Boolean> p;
  private final LiveData<Boolean> q;
  
  public IoTDetailBaseViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.b = new a(paramThingContext);
    paramApplication = paramThingContext.getDeviceIdMD5();
    if (paramApplication == null) {
      paramApplication = "";
    }
    this.c = paramApplication;
    this.d = com.tplink.iot.Utils.extension.c.a(paramThingContext);
    paramApplication = new MutableLiveData();
    this.e = paramApplication;
    this.f = paramApplication;
    this.h = new MediatorLiveData();
    paramApplication = Transformations.map(i(), new j(this));
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…e, it?.deviceModel)\n    }");
    this.j = paramApplication;
    paramApplication = Transformations.map(i(), k.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…getRoomLocation(it)\n    }");
    this.k = paramApplication;
    paramApplication = Transformations.map(paramApplication, g.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(room…xtUtils.isEmpty(it)\n    }");
    this.l = paramApplication;
    paramApplication = Transformations.map(i(), e.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo….isCommonDevice ?: true }");
    this.m = paramApplication;
    paramApplication = Transformations.map(i(), f.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…upportIoTCloud ?: false }");
    this.n = paramApplication;
    paramApplication = Transformations.map(i(), d.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo….size ?: 1) - 1, 0)\n    }");
    this.o = paramApplication;
    paramApplication = Transformations.map(i(), i.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…TypeDevice ?: false\n    }");
    this.p = paramApplication;
    paramApplication = Transformations.map(i(), h.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(alIo…e\n        } ?: true\n    }");
    this.q = paramApplication;
  }
  
  public final LiveData<Boolean> A()
  {
    return this.p;
  }
  
  public final boolean B()
  {
    return com.tplink.iot.Utils.w0.a.d(this.c);
  }
  
  public final boolean C()
  {
    return com.tplink.iot.Utils.w0.a.i(this.c);
  }
  
  public final boolean D()
  {
    Object localObject = TPIoTClientManager.k2(this.c);
    if (localObject != null)
    {
      localObject = (ALIoTDevice)((TPBaseDeviceContext)localObject).getIoTDevice();
      if (localObject != null) {
        return ((BaseALIoTDevice)localObject).isUserRoleTypeDevice();
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public abstract void E();
  
  public abstract void F();
  
  public final void G()
  {
    H();
    if (!r().D())
    {
      E();
      return;
    }
    this.i = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new l(this));
  }
  
  public final void H()
  {
    io.reactivex.e0.c localc = this.i;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public final void g(boolean paramBoolean)
  {
    r().J0(paramBoolean).y();
  }
  
  public final void h()
  {
    j().E(new b(this)).C(new c(this)).F0();
  }
  
  public final LiveData<BaseALIoTDevice<?>> i()
  {
    return (LiveData)this.d.b(this, a[1]);
  }
  
  public abstract q<CloudConnectStateResult> j();
  
  public final LiveData<i<CloudConnectStateResult>> k()
  {
    return this.f;
  }
  
  public final LiveData<Integer> l()
  {
    return this.o;
  }
  
  protected final MutableLiveData<i<CloudConnectStateResult>> m()
  {
    return this.e;
  }
  
  protected final String n()
  {
    return this.c;
  }
  
  protected final MediatorLiveData<Boolean> o()
  {
    return this.h;
  }
  
  protected final TPIoTClientManager p()
  {
    return (TPIoTClientManager)this.b.b(this, a[0]);
  }
  
  public abstract ThingBaseRepository r();
  
  public final LiveData<String> s()
  {
    return this.j;
  }
  
  public final LiveData<String> t()
  {
    return this.k;
  }
  
  public final LiveData<Boolean> u()
  {
    if (!this.g)
    {
      this.g = true;
      F();
    }
    return this.h;
  }
  
  public final LiveData<Boolean> v()
  {
    return this.m;
  }
  
  public final LiveData<Boolean> w()
  {
    return this.n;
  }
  
  public final LiveData<Boolean> x()
  {
    return this.l;
  }
  
  public final boolean y()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.c);
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (localALIoTDevice != null)
    {
      if (localALIoTDevice.isSupportIoTCloudComponent())
      {
        if (localALIoTDevice.getThingDevice() == null) {
          return bool1;
        }
      }
      else if (localALIoTDevice.getCloudIoTDevice() == null) {
        return bool1;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public final LiveData<Boolean> z()
  {
    return this.q;
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
  
  static final class b<T>
    implements g<CloudConnectStateResult>
  {
    b(IoTDetailBaseViewModel paramIoTDetailBaseViewModel) {}
    
    public final void a(CloudConnectStateResult paramCloudConnectStateResult)
    {
      this.c.m().postValue(new i(0, paramCloudConnectStateResult));
    }
  }
  
  static final class c<T>
    implements g<Throwable>
  {
    c(IoTDetailBaseViewModel paramIoTDetailBaseViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.m().postValue(new i(1, null));
    }
  }
  
  static final class d<I, O>
    implements Function<BaseALIoTDevice<?>, Integer>
  {
    public static final d a = new d();
    
    public final Integer a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      if (paramBaseALIoTDevice != null)
      {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceManagerInfo();
        if (paramBaseALIoTDevice != null)
        {
          paramBaseALIoTDevice = paramBaseALIoTDevice.getUserInfo();
          if (paramBaseALIoTDevice != null)
          {
            i = paramBaseALIoTDevice.size();
            break label34;
          }
        }
      }
      int i = 1;
      label34:
      return Integer.valueOf(Math.max(i - 1, 0));
    }
  }
  
  static final class e<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final e a = new e();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isCommonDevice();
      } else {
        bool = true;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class f<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final f a = new f();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isSupportIoTCloud();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class g<I, O>
    implements Function<String, Boolean>
  {
    public static final g a = new g();
    
    public final Boolean a(String paramString)
    {
      return Boolean.valueOf(TextUtils.isEmpty(paramString) ^ true);
    }
  }
  
  static final class h<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final h a = new h();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (paramBaseALIoTDevice != null) {
        if (!paramBaseALIoTDevice.isSupportIoTCloud())
        {
          bool2 = bool1;
          if (paramBaseALIoTDevice.getCloudIoTDevice() == null) {}
        }
        else if (paramBaseALIoTDevice.isUserRoleTypeDevice())
        {
          bool2 = bool1;
        }
        else
        {
          bool2 = false;
        }
      }
      return Boolean.valueOf(bool2);
    }
  }
  
  static final class i<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final i a = new i();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isUserRoleTypeDevice();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class j<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    j(IoTDetailBaseViewModel paramIoTDetailBaseViewModel) {}
    
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
      return l.e(localApplication, str2, str3, str1);
    }
  }
  
  static final class k<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    public static final k a = new k();
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      return l.h(paramBaseALIoTDevice);
    }
  }
  
  static final class l<T>
    implements g<Long>
  {
    l(IoTDetailBaseViewModel paramIoTDetailBaseViewModel) {}
    
    public final void a(Long paramLong)
    {
      if (this.c.r().D())
      {
        this.c.E();
      }
      else
      {
        paramLong = IoTDetailBaseViewModel.f(this.c);
        if (paramLong != null) {
          paramLong.dispose();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\viewmodel\IoTDetailBaseViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
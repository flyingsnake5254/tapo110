package com.tplink.iot.viewmodel.iotplug;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import b.d.b.f.b;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.x0.j;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PlugDetailViewModel
  extends AndroidViewModel
{
  private PlugRepository a;
  private MediatorLiveData<BaseALIoTDevice> b = new MediatorLiveData();
  private SingleLiveEvent<Boolean> c = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> d = new SingleLiveEvent();
  private MutableLiveData<Boolean> e = new MutableLiveData();
  private MutableLiveData<i<CloudConnectStateResult>> f = new MutableLiveData();
  private io.reactivex.e0.c g;
  private io.reactivex.e0.c h;
  private boolean i;
  private boolean j;
  private String k;
  private String l;
  
  public PlugDetailViewModel(@NonNull Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    boolean bool = false;
    this.i = false;
    this.j = false;
    this.l = paramThingContext.getDeviceIdMD5();
    this.a = ((PlugRepository)e.a(paramThingContext, PlugRepository.class));
    paramApplication = (TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.c.addSource(this.a.w1(), new c());
    this.b.addSource(paramApplication.C1(), new d(paramThingContext));
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null))
    {
      paramApplication = ((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice();
      if (paramApplication.getComponentVersion(EnumIoTComponent.DEVICE) >= 2) {
        bool = true;
      }
      this.i = bool;
      this.j = paramApplication.isSupportComponent(EnumIoTComponent.ENERGY_MONITORING);
      this.k = paramApplication.getRegion();
    }
  }
  
  private BaseALIoTDevice p(String paramString, List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (BaseALIoTDevice)localIterator.next();
        if (paramList.getDeviceIdMD5().equals(paramString)) {
          return paramList;
        }
      }
    }
    return null;
  }
  
  public void A()
  {
    this.a.f5().L0(io.reactivex.l0.a.c()).F0();
  }
  
  public LiveData<EnergyUsageResult> B()
  {
    return this.a.g5();
  }
  
  public void C()
  {
    this.a.x1().F0();
  }
  
  public LiveData<PlugNextEvent> D()
  {
    return Transformations.map(this.a.y1(), new e());
  }
  
  public LiveData<Boolean> E()
  {
    return this.c;
  }
  
  public boolean F()
  {
    return this.i;
  }
  
  public boolean G()
  {
    return this.j;
  }
  
  @SuppressLint({"CheckResult"})
  public void H()
  {
    q.e0(1L, 3L, 0L, 2L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new j());
  }
  
  public void I(boolean paramBoolean)
  {
    final long l1 = System.currentTimeMillis();
    this.a.i(paramBoolean).r(io.reactivex.d0.b.a.a()).A(new f(l1), new g(l1));
  }
  
  public void J()
  {
    L();
    this.h = q.e0(1L, 2L, 0L, 3L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new i());
  }
  
  public void K()
  {
    io.reactivex.e0.c localc = this.g;
    if (localc != null) {
      localc.dispose();
    }
    if (!this.a.D())
    {
      x();
      return;
    }
    this.g = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new h());
  }
  
  public void L()
  {
    io.reactivex.e0.c localc = this.h;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void M()
  {
    io.reactivex.e0.c localc = this.g;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void o(final boolean paramBoolean)
  {
    this.a.J0(paramBoolean).i(new k(paramBoolean)).y();
  }
  
  public LiveData<BaseALIoTDevice> r()
  {
    return this.b;
  }
  
  public LiveData<i<CloudConnectStateResult>> s()
  {
    return this.f;
  }
  
  public void t()
  {
    this.a.b1().E(new b()).C(new a()).F0();
  }
  
  public LiveData<IoTPlugDevice> u()
  {
    return this.a.e5();
  }
  
  public String v()
  {
    if ((this.a.b() != null) && (((ThingContext)this.a.b()).getIoTDevice() != null)) {
      return ((ALIoTDevice)((ThingContext)this.a.b()).getIoTDevice()).getDeviceName();
    }
    return "";
  }
  
  public String w()
  {
    return this.k;
  }
  
  public void x()
  {
    this.a.k1().F0();
  }
  
  public void y()
  {
    this.a.s1().L0(io.reactivex.l0.a.c()).F0();
  }
  
  public LiveData<ThingUsage> z()
  {
    return this.a.t1();
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      PlugDetailViewModel.n(PlugDetailViewModel.this).postValue(new i(1, null));
    }
  }
  
  class b
    implements g<CloudConnectStateResult>
  {
    b() {}
    
    public void a(CloudConnectStateResult paramCloudConnectStateResult)
      throws Exception
    {
      PlugDetailViewModel.n(PlugDetailViewModel.this).postValue(new i(0, paramCloudConnectStateResult));
    }
  }
  
  class c
    implements Observer<ThingFirmware>
  {
    c() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      SingleLiveEvent localSingleLiveEvent = PlugDetailViewModel.f(PlugDetailViewModel.this);
      boolean bool;
      if ((paramThingFirmware != null) && (paramThingFirmware.isNeedToUpgrade())) {
        bool = true;
      } else {
        bool = false;
      }
      localSingleLiveEvent.postValue(Boolean.valueOf(bool));
    }
  }
  
  class d
    implements Observer<List<BaseALIoTDevice>>
  {
    d(ThingContext paramThingContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      PlugDetailViewModel.h(PlugDetailViewModel.this).postValue(PlugDetailViewModel.g(PlugDetailViewModel.this, paramThingContext.getDeviceIdMD5(), paramList));
    }
  }
  
  class e
    implements Function<NextEvent, PlugNextEvent>
  {
    e() {}
    
    public PlugNextEvent a(NextEvent paramNextEvent)
    {
      return new PlugNextEvent(paramNextEvent);
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f(long paramLong) {}
    
    public void run()
      throws Exception
    {
      SingleLiveEvent localSingleLiveEvent = PlugDetailViewModel.i(PlugDetailViewModel.this);
      Boolean localBoolean;
      if (PlugDetailViewModel.i(PlugDetailViewModel.this).getValue() != null) {
        localBoolean = Boolean.valueOf(((Boolean)PlugDetailViewModel.i(PlugDetailViewModel.this).getValue()).booleanValue() ^ true);
      } else {
        localBoolean = null;
      }
      localSingleLiveEvent.postValue(localBoolean);
      j.c(PlugDetailViewModel.j(PlugDetailViewModel.this), System.currentTimeMillis() - l1, true);
    }
  }
  
  class g
    implements g<Throwable>
  {
    g(long paramLong) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        w.f();
      }
      j.c(PlugDetailViewModel.j(PlugDetailViewModel.this), System.currentTimeMillis() - l1, false);
    }
  }
  
  class h
    implements g<Long>
  {
    h() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (PlugDetailViewModel.k(PlugDetailViewModel.this).D()) {
        PlugDetailViewModel.this.x();
      } else if (PlugDetailViewModel.l(PlugDetailViewModel.this) != null) {
        PlugDetailViewModel.l(PlugDetailViewModel.this).dispose();
      }
    }
  }
  
  class i
    implements g<Long>
  {
    i() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      PlugDetailViewModel.this.C();
    }
  }
  
  class j
    implements g<Long>
  {
    j() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      PlugDetailViewModel.this.C();
      PlugDetailViewModel.this.x();
    }
  }
  
  class k
    implements io.reactivex.g0.a
  {
    k(boolean paramBoolean) {}
    
    public void run()
      throws Exception
    {
      PlugDetailViewModel.m(PlugDetailViewModel.this).postValue(Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\PlugDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
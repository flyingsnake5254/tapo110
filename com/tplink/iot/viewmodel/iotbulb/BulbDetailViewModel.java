package com.tplink.iot.viewmodel.iotbulb;

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
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BulbDetailViewModel
  extends AndroidViewModel
{
  private BulbRepository a;
  private MediatorLiveData<BaseALIoTDevice> b = new MediatorLiveData();
  private MediatorLiveData<IoTBulbDevice> c = new MediatorLiveData();
  private MediatorLiveData<ThingUsage> d = new MediatorLiveData();
  private MutableLiveData<i<CloudConnectStateResult>> e = new MutableLiveData();
  private MutableLiveData<Boolean> f = new MutableLiveData();
  private boolean g = false;
  private String h;
  private String i;
  private c j;
  private c k;
  
  public BulbDetailViewModel(@NonNull Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    this.i = paramThingContext.getDeviceIdMD5();
    this.a = ((BulbRepository)e.a(paramThingContext, BulbRepository.class));
    paramApplication = (TPIoTClientManager)b.d.b.f.b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.b.addSource(paramApplication.C1(), new b(paramThingContext));
    this.c.addSource(this.a.r5(), new c());
    this.d.addSource(this.a.t1(), new d());
    this.g = com.tplink.iot.Utils.w0.a.j(paramThingContext.getDeviceIdMD5());
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null)) {
      this.h = ((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice().getRegion();
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
  
  @SuppressLint({"CheckResult"})
  public void A()
  {
    this.a.n1().L0(io.reactivex.l0.a.c()).F0();
  }
  
  public void B()
  {
    this.a.s1().L0(io.reactivex.l0.a.c()).F0();
  }
  
  public LiveData<ThingUsage> C()
  {
    return this.d;
  }
  
  public LiveData<ThingFirmware> D()
  {
    return this.a.w1();
  }
  
  public void E()
  {
    this.a.x1().L0(io.reactivex.l0.a.c()).F0();
  }
  
  public LiveData<BulbNextEvent> F()
  {
    return Transformations.map(this.a.y1(), new e());
  }
  
  public void G()
  {
    this.a.p5().F0();
  }
  
  public boolean H()
  {
    return this.g;
  }
  
  @SuppressLint({"CheckResult"})
  public void M()
  {
    q.e0(1L, 3L, 0L, 2L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new f());
  }
  
  public void N(AutoLightBean paramAutoLightBean)
  {
    this.a.W5(paramAutoLightBean).y();
  }
  
  public void O(int paramInt)
  {
    this.a.X5(paramInt).y();
  }
  
  public void P(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    this.a.i(paramBoolean).i(new b(this, l)).j(new a(this, l)).y();
  }
  
  public void Q(LightStateBean paramLightStateBean)
  {
    this.a.b6(paramLightStateBean).y();
  }
  
  public void R()
  {
    T();
    this.k = q.e0(1L, 2L, 0L, 3L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new i());
  }
  
  public void S()
  {
    c localc = this.j;
    if (localc != null) {
      localc.dispose();
    }
    if (!this.a.D())
    {
      A();
      return;
    }
    this.j = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new h());
  }
  
  public void T()
  {
    c localc = this.k;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void U()
  {
    c localc = this.j;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void n(final boolean paramBoolean)
  {
    this.a.J0(paramBoolean).i(new g(paramBoolean)).y();
  }
  
  public void o(EditPresetRule paramEditPresetRule)
  {
    this.a.j5(paramEditPresetRule).y();
  }
  
  public LiveData<BaseALIoTDevice> r()
  {
    return this.b;
  }
  
  public void s()
  {
    if (this.a.D()) {
      this.a.m5().F0();
    }
  }
  
  public LiveData<List<Integer>> t()
  {
    return this.a.o5();
  }
  
  public LiveData<IoTBulbDevice> u()
  {
    return this.c;
  }
  
  public LiveData<Boolean> v()
  {
    return this.a.d1();
  }
  
  public LiveData<i<CloudConnectStateResult>> w()
  {
    return this.e;
  }
  
  public void x()
  {
    this.a.b1().E(new a()).C(new j()).F0();
  }
  
  public LiveData<List<LightStateBean>> y()
  {
    return this.a.q5();
  }
  
  public String z()
  {
    return this.h;
  }
  
  class a
    implements g<CloudConnectStateResult>
  {
    a() {}
    
    public void a(CloudConnectStateResult paramCloudConnectStateResult)
      throws Exception
    {
      BulbDetailViewModel.m(BulbDetailViewModel.this).postValue(new i(0, paramCloudConnectStateResult));
    }
  }
  
  class b
    implements Observer<List<BaseALIoTDevice>>
  {
    b(ThingContext paramThingContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      BulbDetailViewModel.g(BulbDetailViewModel.this).postValue(BulbDetailViewModel.f(BulbDetailViewModel.this, paramThingContext.getDeviceIdMD5(), paramList));
    }
  }
  
  class c
    implements Observer<IoTBulbDevice>
  {
    c() {}
    
    public void a(@Nullable IoTBulbDevice paramIoTBulbDevice)
    {
      BulbDetailViewModel.h(BulbDetailViewModel.this).postValue(paramIoTBulbDevice);
    }
  }
  
  class d
    implements Observer<ThingUsage>
  {
    d() {}
    
    public void a(@Nullable ThingUsage paramThingUsage)
    {
      BulbDetailViewModel.i(BulbDetailViewModel.this).postValue(paramThingUsage);
    }
  }
  
  class e
    implements Function<NextEvent, BulbNextEvent>
  {
    e() {}
    
    public BulbNextEvent a(NextEvent paramNextEvent)
    {
      return new BulbNextEvent(paramNextEvent);
    }
  }
  
  class f
    implements g<Long>
  {
    f() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      BulbDetailViewModel.this.E();
      BulbDetailViewModel.this.A();
    }
  }
  
  class g
    implements io.reactivex.g0.a
  {
    g(boolean paramBoolean) {}
    
    public void run()
      throws Exception
    {
      BulbDetailViewModel.j(BulbDetailViewModel.this).postValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  class h
    implements g<Long>
  {
    h() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (BulbDetailViewModel.k(BulbDetailViewModel.this).D()) {
        BulbDetailViewModel.this.A();
      } else if (BulbDetailViewModel.l(BulbDetailViewModel.this) != null) {
        BulbDetailViewModel.l(BulbDetailViewModel.this).dispose();
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
      BulbDetailViewModel.this.E();
    }
  }
  
  class j
    implements g<Throwable>
  {
    j() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      BulbDetailViewModel.m(BulbDetailViewModel.this).postValue(new i(1, null));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotbulb\BulbDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
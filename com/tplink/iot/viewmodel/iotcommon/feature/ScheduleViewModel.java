package com.tplink.iot.viewmodel.iotcommon.feature;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.y;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ScheduleViewModel
  extends AndroidViewModel
{
  private IoTCommonFeatureRepository a;
  private String b;
  private ThingContext c;
  private MediatorLiveData<Integer> d = new MediatorLiveData();
  private MediatorLiveData<Integer> e = new MediatorLiveData();
  private MediatorLiveData<com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean>> f = new MediatorLiveData();
  private MediatorLiveData<Boolean> g = new MediatorLiveData();
  private MediatorLiveData<Integer> h = new MediatorLiveData();
  private boolean i;
  private String j;
  private boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public BaseALIoTDevice s;
  
  public ScheduleViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    boolean bool = false;
    this.i = false;
    this.l = false;
    this.m = false;
    this.n = false;
    this.o = false;
    this.p = false;
    this.q = false;
    this.r = false;
    this.c = paramThingContext;
    this.b = paramThingContext.getDeviceIdMD5();
    this.a = ((IoTCommonFeatureRepository)e.a(paramThingContext, IoTCommonFeatureRepository.class));
    this.s = paramThingContext.getIoTDevice();
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null))
    {
      paramApplication = ((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice();
      if (paramApplication.getComponentVersion(EnumIoTComponent.SCHEDULE) >= 2) {
        bool = true;
      }
      this.k = bool;
      this.i = paramApplication.isSupportComponent(EnumIoTComponent.DEVICE_LOCAL_TIME);
      this.j = paramApplication.getRegion();
      this.l = paramApplication.isSupportComponent(EnumIoTComponent.BRIGHTNESS);
      this.m = paramApplication.isSupportColorAndColorTemp();
      this.n = paramApplication.isSupportComponent(EnumIoTComponent.AUTO_LIGHT);
      this.o = ((ALIoTDevice)paramThingContext.getIoTDevice()).isLightStrip();
      this.p = paramApplication.isSupportComponent(EnumIoTComponent.TEMP_CONTROL);
      this.q = paramApplication.isSupportComponent(EnumIoTComponent.FROST_PROTECTION);
      this.r = paramApplication.isSupportComponent(EnumIoTComponent.EARLY_START);
    }
  }
  
  @SuppressLint({"CheckResult"})
  private void n()
  {
    this.a.f1().l0(io.reactivex.d0.b.a.a()).C(new b()).F0();
  }
  
  public LiveData<com.tplink.iot.viewmodel.quicksetup.i<ScheduleRuleBean>> A()
  {
    return this.f;
  }
  
  public LiveData<List<ScheduleRuleBean>> B()
  {
    return Transformations.map(this.a.e1(), new a());
  }
  
  public LiveData<? extends LocalIoTBaseDevice> C()
  {
    if ((this.c.getIoTDevice() != null) && (b.k(this.c.getIoTDevice()))) {
      return ((TRVRepository)e.a(this.c, TRVRepository.class)).Y0();
    }
    return new MutableLiveData();
  }
  
  public boolean D()
  {
    return this.k;
  }
  
  public boolean E()
  {
    return this.i;
  }
  
  public void F(String paramString, ScheduleRuleBean paramScheduleRuleBean)
  {
    com.tplink.iot.Utils.x0.i.i(paramString, paramScheduleRuleBean);
  }
  
  public void G()
  {
    n();
  }
  
  @SuppressLint({"CheckResult"})
  public void H(final ScheduleRuleBean paramScheduleRuleBean)
  {
    this.a.w2(false, Arrays.asList(new String[] { paramScheduleRuleBean.getId() })).r(io.reactivex.d0.b.a.a()).A(new g(), new h(paramScheduleRuleBean));
  }
  
  @SuppressLint({"CheckResult"})
  public void k(ScheduleRuleBean paramScheduleRuleBean)
  {
    this.a.Q0(paramScheduleRuleBean.toThingRuleSchedule()).l0(io.reactivex.d0.b.a.a()).H0(new c(), new d());
  }
  
  public void l(ScheduleRuleBean paramScheduleRuleBean)
  {
    m(paramScheduleRuleBean, false);
  }
  
  @SuppressLint({"CheckResult"})
  public void m(ScheduleRuleBean paramScheduleRuleBean, final boolean paramBoolean)
  {
    this.a.T0(paramScheduleRuleBean.toThingRuleSchedule()).l0(io.reactivex.d0.b.a.a()).H0(new e(paramBoolean), new f(paramBoolean));
  }
  
  public String o()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isBulb()))
    {
      if (((ALIoTDevice)this.c.getIoTDevice()).isLightStrip()) {
        return ((LightStripRepository)e.a(this.c, LightStripRepository.class)).q5();
      }
      return ((BulbRepository)e.a(this.c, BulbRepository.class)).n5();
    }
    return null;
  }
  
  public LiveData<List<Integer>> p()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isBulb())) {
      return ((BulbRepository)e.a(this.c, BulbRepository.class)).o5();
    }
    return new MutableLiveData();
  }
  
  public LiveData<List<LightStateBean>> r()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isBulb())) {
      return ((BulbRepository)e.a(this.c, BulbRepository.class)).q5();
    }
    return new MutableLiveData();
  }
  
  public int s(int paramInt)
  {
    return p0.b(paramInt, this.i, this.j);
  }
  
  public String t()
  {
    return this.j;
  }
  
  public int u(int paramInt)
  {
    return p0.c(paramInt, this.i, this.j);
  }
  
  public LiveData<Boolean> v()
  {
    return this.g;
  }
  
  public LiveData<List<LightStateBean>> w()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isLightStrip())) {
      return ((LightStripRepository)e.a(this.c, LightStripRepository.class)).u5();
    }
    return new MutableLiveData();
  }
  
  public LiveData<Integer> x()
  {
    return this.d;
  }
  
  public LiveData<Integer> y()
  {
    return this.e;
  }
  
  public int z()
  {
    return this.a.d1();
  }
  
  class a
    implements Function<List<ThingRuleSchedule>, List<ScheduleRuleBean>>
  {
    a() {}
    
    public List<ScheduleRuleBean> a(List<ThingRuleSchedule> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localArrayList.add(new ScheduleRuleBean((ThingRuleSchedule)paramList.next()));
        }
      }
      return localArrayList;
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (!IoTTransportException.isCancelException(paramThrowable)) {
        ScheduleViewModel.f(ScheduleViewModel.this).postValue(Boolean.TRUE);
      }
    }
  }
  
  class c
    implements g<ThingRuleUpdateResult>
  {
    c() {}
    
    public void a(ThingRuleUpdateResult paramThingRuleUpdateResult)
      throws Exception
    {
      ScheduleViewModel.this.G();
      if (paramThingRuleUpdateResult.getConflictId() == null) {
        ScheduleViewModel.g(ScheduleViewModel.this).setValue(Integer.valueOf(0));
      } else {
        ScheduleViewModel.g(ScheduleViewModel.this).setValue(Integer.valueOf(10000));
      }
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable))
      {
        ScheduleViewModel.g(ScheduleViewModel.this).setValue(Integer.valueOf(64524));
        return;
      }
      ScheduleViewModel.g(ScheduleViewModel.this).setValue(Integer.valueOf(y.a(paramThrowable)));
    }
  }
  
  class e
    implements g<ThingRuleUpdateResult>
  {
    e(boolean paramBoolean) {}
    
    public void a(ThingRuleUpdateResult paramThingRuleUpdateResult)
      throws Exception
    {
      ScheduleViewModel.this.G();
      if (paramThingRuleUpdateResult.getConflictId() == null) {
        ScheduleViewModel.h(ScheduleViewModel.this).setValue(Integer.valueOf(0));
      } else {
        ScheduleViewModel.h(ScheduleViewModel.this).setValue(Integer.valueOf(10000));
      }
      if (paramBoolean) {
        com.tplink.iot.Utils.x0.i.B(ScheduleViewModel.i(ScheduleViewModel.this), true);
      }
    }
  }
  
  class f
    implements g<Throwable>
  {
    f(boolean paramBoolean) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        ScheduleViewModel.h(ScheduleViewModel.this).setValue(Integer.valueOf(64524));
      } else {
        ScheduleViewModel.h(ScheduleViewModel.this).setValue(Integer.valueOf(y.a(paramThrowable)));
      }
      if (paramBoolean) {
        com.tplink.iot.Utils.x0.i.B(ScheduleViewModel.i(ScheduleViewModel.this), false);
      }
    }
  }
  
  class g
    implements io.reactivex.g0.a
  {
    g() {}
    
    public void run()
      throws Exception
    {
      ScheduleViewModel.this.G();
      ScheduleViewModel.j(ScheduleViewModel.this).setValue(new com.tplink.iot.viewmodel.quicksetup.i(0, null));
    }
  }
  
  class h
    implements g<Throwable>
  {
    h(ScheduleRuleBean paramScheduleRuleBean) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        ScheduleViewModel.j(ScheduleViewModel.this).setValue(new com.tplink.iot.viewmodel.quicksetup.i(64524, paramScheduleRuleBean));
      } else {
        ScheduleViewModel.j(ScheduleViewModel.this).setValue(new com.tplink.iot.viewmodel.quicksetup.i(-1, paramScheduleRuleBean));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\feature\ScheduleViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
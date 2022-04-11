package com.tplink.iot.viewmodel.iotcommon.feature;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.w;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.iot.g.d.a.b;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CountdownRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.d0.b.a;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;

public class TimerViewModel
  extends AndroidViewModel
{
  private IoTCommonFeatureRepository a;
  private MutableLiveData<Integer> b = new MutableLiveData();
  private ThingContext c;
  private boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  
  public TimerViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    boolean bool = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = false;
    this.j = false;
    this.c = paramThingContext;
    this.a = ((IoTCommonFeatureRepository)e.a(paramThingContext, IoTCommonFeatureRepository.class));
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null))
    {
      paramApplication = ((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice();
      if (paramApplication.getComponentVersion(EnumIoTComponent.COUNTDOWN) >= 2) {
        bool = true;
      }
      this.d = bool;
      this.e = paramApplication.isSupportComponent(EnumIoTComponent.BRIGHTNESS);
      this.f = paramApplication.isSupportColorAndColorTemp();
      this.g = paramApplication.isSupportComponent(EnumIoTComponent.AUTO_LIGHT);
      this.h = ((ALIoTDevice)paramThingContext.getIoTDevice()).isLightStrip();
      this.i = paramApplication.isSupportComponent(EnumIoTComponent.TEMP_CONTROL);
      this.j = paramApplication.isSupportComponent(EnumIoTComponent.FROST_PROTECTION);
    }
  }
  
  @SuppressLint({"CheckResult"})
  public void g(CountdownRuleBean paramCountdownRuleBean)
  {
    this.b.postValue(Integer.valueOf(1));
    this.a.P0(paramCountdownRuleBean).l0(a.a()).H0(new b(), new c());
  }
  
  public String h()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isBulb()))
    {
      if (((ALIoTDevice)this.c.getIoTDevice()).isLightStrip()) {
        return ((LightStripRepository)e.a(this.c, LightStripRepository.class)).q5();
      }
      ((BulbRepository)e.a(this.c, BulbRepository.class)).n5();
    }
    return null;
  }
  
  public LiveData<List<Integer>> i()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isBulb())) {
      return ((BulbRepository)e.a(this.c, BulbRepository.class)).o5();
    }
    return new MutableLiveData();
  }
  
  public LiveData<List<LightStateBean>> j()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isBulb())) {
      return ((BulbRepository)e.a(this.c, BulbRepository.class)).q5();
    }
    return new MutableLiveData();
  }
  
  public LiveData<CountdownRuleBean> k()
  {
    return Transformations.map(this.a.Y0(), new a());
  }
  
  public void l()
  {
    this.a.Z0().F0();
  }
  
  public int m()
  {
    Integer localInteger = (Integer)this.a.i1().getValue();
    int k;
    if (localInteger == null) {
      k = 0;
    } else {
      k = localInteger.intValue();
    }
    return k;
  }
  
  public boolean n()
  {
    Object localObject = (ThingContext)this.a.b();
    if ((localObject != null) && (((TPBaseDeviceContext)localObject).getIoTDevice() != null))
    {
      localObject = ((ALIoTDevice)((TPBaseDeviceContext)localObject).getIoTDevice()).getLocalIoTDevice();
      if (localObject != null) {
        return ((LocalIoTBaseDevice)localObject).isDeviceOn();
      }
    }
    return false;
  }
  
  public LiveData<List<LightStateBean>> o()
  {
    if ((this.c.getIoTDevice() != null) && (((ALIoTDevice)this.c.getIoTDevice()).isLightStrip())) {
      return ((LightStripRepository)e.a(this.c, LightStripRepository.class)).u5();
    }
    return new MutableLiveData();
  }
  
  public LiveData<Integer> p()
  {
    return this.b;
  }
  
  public LiveData<? extends LocalIoTBaseDevice> r()
  {
    if ((this.c.getIoTDevice() != null) && (b.k(this.c.getIoTDevice()))) {
      return ((TRVRepository)e.a(this.c, TRVRepository.class)).Y0();
    }
    return new MutableLiveData();
  }
  
  public boolean s()
  {
    return this.a.k1();
  }
  
  public boolean t()
  {
    return this.d;
  }
  
  public void u(CountdownRuleBean paramCountdownRuleBean)
  {
    this.a.S0(paramCountdownRuleBean).C(new d()).F0();
  }
  
  class a
    implements Function<ThingRuleTimer, CountdownRuleBean>
  {
    a() {}
    
    public CountdownRuleBean a(ThingRuleTimer paramThingRuleTimer)
    {
      return new CountdownRuleBean(paramThingRuleTimer);
    }
  }
  
  class b
    implements g<ThingRuleUpdateResult>
  {
    b() {}
    
    public void a(ThingRuleUpdateResult paramThingRuleUpdateResult)
      throws Exception
    {
      if (!TextUtils.isEmpty(paramThingRuleUpdateResult.getId()))
      {
        if (paramThingRuleUpdateResult.getConflictId() == null) {
          TimerViewModel.f(TimerViewModel.this).postValue(Integer.valueOf(0));
        } else {
          TimerViewModel.f(TimerViewModel.this).postValue(Integer.valueOf(10000));
        }
      }
      else {
        TimerViewModel.f(TimerViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        TimerViewModel.f(TimerViewModel.this).postValue(Integer.valueOf(64524));
      } else {
        TimerViewModel.f(TimerViewModel.this).postValue(Integer.valueOf(-1));
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
      if (w.d(paramThrowable)) {
        TimerViewModel.f(TimerViewModel.this).postValue(Integer.valueOf(64524));
      } else {
        TimerViewModel.f(TimerViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\feature\TimerViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.iot.viewmodel.iotcommon.feature;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.d0.b.a;
import io.reactivex.g0.g;
import io.reactivex.q;

public class AwayModeViewModel
  extends AndroidViewModel
{
  private IoTCommonFeatureRepository a;
  private boolean b = false;
  private String c;
  private SingleLiveEvent<Integer> d = new SingleLiveEvent();
  
  public AwayModeViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((IoTCommonFeatureRepository)e.a(paramThingContext, IoTCommonFeatureRepository.class));
    if (paramThingContext.getIoTDevice() != null)
    {
      paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
      this.b = paramApplication.isSupportDeviceLocalTime();
      if (paramApplication.getLocalIoTDevice() != null) {
        this.c = paramApplication.getLocalIoTDevice().getRegion();
      }
    }
  }
  
  @SuppressLint({"CheckResult"})
  public void g(ThingRuleAwayMode paramThingRuleAwayMode)
  {
    this.d.postValue(Integer.valueOf(1));
    this.a.O0(paramThingRuleAwayMode).l0(a.a()).H0(new a(), new b());
  }
  
  public LiveData<ThingRuleAwayMode> h()
  {
    return this.a.W0();
  }
  
  public void i()
  {
    this.a.X0().F0();
  }
  
  public int j(int paramInt)
  {
    return p0.b(paramInt, this.b, this.c);
  }
  
  public String k()
  {
    return this.c;
  }
  
  public int l(int paramInt)
  {
    return p0.c(paramInt, this.b, this.c);
  }
  
  public SingleLiveEvent<Integer> m()
  {
    return this.d;
  }
  
  public boolean n()
  {
    return this.a.j1();
  }
  
  public boolean o()
  {
    return this.b;
  }
  
  public void p(ThingRuleAwayMode paramThingRuleAwayMode)
  {
    this.a.R0(paramThingRuleAwayMode).C(new c()).F0();
  }
  
  class a
    implements g<ThingRuleUpdateResult>
  {
    a() {}
    
    public void a(ThingRuleUpdateResult paramThingRuleUpdateResult)
      throws Exception
    {
      if (!TextUtils.isEmpty(paramThingRuleUpdateResult.getId()))
      {
        if (paramThingRuleUpdateResult.getConflictId() == null) {
          AwayModeViewModel.f(AwayModeViewModel.this).postValue(Integer.valueOf(0));
        } else {
          AwayModeViewModel.f(AwayModeViewModel.this).postValue(Integer.valueOf(10000));
        }
      }
      else {
        AwayModeViewModel.f(AwayModeViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if (w.d(paramThrowable)) {
        AwayModeViewModel.f(AwayModeViewModel.this).postValue(Integer.valueOf(64524));
      } else {
        AwayModeViewModel.f(AwayModeViewModel.this).postValue(Integer.valueOf(-1));
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
        AwayModeViewModel.f(AwayModeViewModel.this).postValue(Integer.valueOf(64524));
      } else {
        AwayModeViewModel.f(AwayModeViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\feature\AwayModeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
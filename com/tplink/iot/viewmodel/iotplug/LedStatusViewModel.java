package com.tplink.iot.viewmodel.iotplug;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.w;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;

public class LedStatusViewModel
  extends AndroidViewModel
{
  private IoTCommonFeatureRepository a;
  private MediatorLiveData<LedInfoBean> b = new MediatorLiveData();
  private MediatorLiveData<Integer> c = new MediatorLiveData();
  private boolean d = false;
  private String e;
  @Nullable
  private BaseALIoTDevice f;
  
  public LedStatusViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = (IoTCommonFeatureRepository)e.a(paramThingContext, IoTCommonFeatureRepository.class);
    this.a = paramApplication;
    this.b.addSource(paramApplication.c1(), new a());
    if (paramThingContext.getIoTDevice() != null)
    {
      paramApplication = (ALIoTDevice)paramThingContext.getIoTDevice();
      this.d = paramApplication.isSupportDeviceLocalTime();
      if (paramApplication.getLocalIoTDevice() != null) {
        this.e = paramApplication.getLocalIoTDevice().getRegion();
      }
    }
    this.f = paramThingContext.getIoTDevice();
  }
  
  @Nullable
  public BaseALIoTDevice h()
  {
    return this.f;
  }
  
  public int i(int paramInt)
  {
    return p0.b(paramInt, this.d, this.e);
  }
  
  public int j(int paramInt)
  {
    return p0.c(paramInt, this.d, this.e);
  }
  
  public LiveData<LedInfoBean> k()
  {
    return this.b;
  }
  
  public LiveData<Integer> l()
  {
    return this.c;
  }
  
  @SuppressLint({"CheckResult"})
  public void m(LedInfoBean paramLedInfoBean)
  {
    this.a.x2(paramLedInfoBean).H0(new b(), new c());
  }
  
  class a
    implements Observer<LedInfoBean>
  {
    a() {}
    
    public void a(@Nullable LedInfoBean paramLedInfoBean)
    {
      LedStatusViewModel.f(LedStatusViewModel.this).postValue(paramLedInfoBean);
    }
  }
  
  class b
    implements g<Boolean>
  {
    b() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      LedStatusViewModel.g(LedStatusViewModel.this).postValue(Integer.valueOf(0));
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
        LedStatusViewModel.g(LedStatusViewModel.this).postValue(Integer.valueOf(64524));
      } else {
        LedStatusViewModel.g(LedStatusViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\LedStatusViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.iot.viewmodel.iotplug;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.w;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import io.reactivex.g0.g;

public class PlugSettingLocationViewModel
  extends AndroidViewModel
{
  private PlugRepository a;
  private SingleLiveEvent<Integer> b = new SingleLiveEvent();
  
  public PlugSettingLocationViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((PlugRepository)e.a(paramThingContext, PlugRepository.class));
  }
  
  public String g()
  {
    LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)this.a.j1().getValue();
    if (localLocalIoTBaseDevice != null) {
      return localLocalIoTBaseDevice.getLocation();
    }
    return "";
  }
  
  public SingleLiveEvent<Integer> h()
  {
    return this.b;
  }
  
  @SuppressLint({"CheckResult"})
  public void i(String paramString)
  {
    this.a.n5(paramString).r(io.reactivex.d0.b.a.a()).A(new a(), new b());
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      PlugSettingLocationViewModel.f(PlugSettingLocationViewModel.this).postValue(Integer.valueOf(0));
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
        w.f();
      } else {
        PlugSettingLocationViewModel.f(PlugSettingLocationViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\PlugSettingLocationViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
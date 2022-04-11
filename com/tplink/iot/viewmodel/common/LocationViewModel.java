package com.tplink.iot.viewmodel.common;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.w;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import io.reactivex.g0.g;
import io.reactivex.q;

public class LocationViewModel
  extends AndroidViewModel
{
  private MediatorLiveData<Integer> a = new MediatorLiveData();
  private AbstractThingRepository b;
  private AbstractSubThingRepository c;
  
  public LocationViewModel(@NonNull Application paramApplication, @NonNull ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = com.tplink.libtpnetwork.IoTNetwork.util.c.c(paramThingContext);
    if ((paramApplication instanceof AbstractThingRepository)) {
      this.b = ((AbstractThingRepository)paramApplication);
    } else if ((paramApplication instanceof AbstractSubThingRepository)) {
      this.c = ((AbstractSubThingRepository)paramApplication);
    } else {
      this.b = ((AbstractThingRepository)e.a(paramThingContext, PlugRepository.class));
    }
  }
  
  public void g()
  {
    com.tplink.iot.view.quicksetup.base.f.c.h().g(15000L).E(new b()).C(new a()).F0();
  }
  
  public LiveData<Integer> h()
  {
    return this.a;
  }
  
  @SuppressLint({"CheckResult"})
  public void i(int paramInt1, int paramInt2)
  {
    io.reactivex.a locala = io.reactivex.a.m(new Throwable("Null Device Repository"));
    Object localObject = this.b;
    if (localObject != null)
    {
      locala = ((AbstractThingRepository)localObject).N4(paramInt1, paramInt2);
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        locala = ((AbstractSubThingRepository)localObject).Z3(paramInt1, paramInt2);
      }
    }
    locala.r(io.reactivex.d0.b.a.a()).A(new c(), new d());
  }
  
  class a
    implements g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      LocationViewModel.f(LocationViewModel.this).postValue(Integer.valueOf(30));
    }
  }
  
  class b
    implements g<DeviceLocationInfo>
  {
    b() {}
    
    public void a(DeviceLocationInfo paramDeviceLocationInfo)
      throws Exception
    {
      Integer localInteger = Integer.valueOf(30);
      if ((paramDeviceLocationInfo != null) && (paramDeviceLocationInfo.getLatitude() != null) && (paramDeviceLocationInfo.getLongitude() != null))
      {
        int i = paramDeviceLocationInfo.getLatitude().intValue();
        int j = paramDeviceLocationInfo.getLongitude().intValue();
        if (d.P(Integer.valueOf(j), Integer.valueOf(i))) {
          LocationViewModel.this.i(j, i);
        } else {
          LocationViewModel.f(LocationViewModel.this).postValue(localInteger);
        }
      }
      else
      {
        LocationViewModel.f(LocationViewModel.this).postValue(localInteger);
      }
    }
  }
  
  class c
    implements io.reactivex.g0.a
  {
    c() {}
    
    public void run()
      throws Exception
    {
      LocationViewModel.f(LocationViewModel.this).postValue(Integer.valueOf(0));
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
        LocationViewModel.f(LocationViewModel.this).postValue(Integer.valueOf(64524));
      } else {
        LocationViewModel.f(LocationViewModel.this).postValue(Integer.valueOf(-1));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\common\LocationViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
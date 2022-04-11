package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.GuardModeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HubDetailViewModel
  extends AndroidViewModel
{
  private HubRepository a;
  private MediatorLiveData<BaseALIoTDevice> b = new MediatorLiveData();
  private SingleLiveEvent<Boolean> c = new SingleLiveEvent();
  private MutableLiveData<Boolean> d = new MutableLiveData();
  private MutableLiveData<i<CloudConnectStateResult>> e = new MutableLiveData();
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f = new MutableLiveData();
  private io.reactivex.e0.c g;
  
  public HubDetailViewModel(@NonNull Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((HubRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, HubRepository.class));
    paramApplication = (TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.c.addSource(this.a.w1(), new a());
    this.b.addSource(paramApplication.C1(), new b(paramThingContext));
  }
  
  private BaseALIoTDevice o(String paramString, List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
        if (localBaseALIoTDevice.getDeviceIdMD5().equals(paramString)) {
          return localBaseALIoTDevice;
        }
      }
    }
    return null;
  }
  
  public void D(String paramString, boolean paramBoolean)
  {
    paramString = new GuardModeParams(paramBoolean, paramString);
    this.a.M6(paramString).y();
  }
  
  public void E()
  {
    io.reactivex.e0.c localc = this.g;
    if (localc != null) {
      localc.dispose();
    }
    if (!this.a.D())
    {
      v();
      return;
    }
    this.g = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new c());
  }
  
  public void F()
  {
    this.a.P6().y();
  }
  
  public void G()
  {
    io.reactivex.e0.c localc = this.g;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public void m(final boolean paramBoolean)
  {
    this.a.J0(paramBoolean).i(new d(paramBoolean)).y();
  }
  
  public void n()
  {
    if (this.a.l5().getValue() != null)
    {
      Object localObject = (List)this.a.l5().getValue();
      boolean bool1 = true;
      localObject = ((List)localObject).iterator();
      do
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((GuardModeConfigBean)((Iterator)localObject).next()).getDeviceIdList().isEmpty());
      boolean bool2 = false;
      this.f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.valueOf(bool2)));
    }
    else
    {
      this.a.m5().E(new f(this)).C(new e(this)).F0();
    }
  }
  
  public LiveData<BaseALIoTDevice> p()
  {
    return this.b;
  }
  
  public LiveData<i<CloudConnectStateResult>> r()
  {
    return this.e;
  }
  
  public void s()
  {
    this.a.b1().E(new f()).C(new e()).F0();
  }
  
  public LiveData<IoTHubDevice> t()
  {
    return this.a.h5();
  }
  
  public String u()
  {
    if ((this.a.b() != null) && (((ThingContext)this.a.b()).getIoTDevice() != null)) {
      return ((ALIoTDevice)((ThingContext)this.a.b()).getIoTDevice()).getDeviceName();
    }
    return "";
  }
  
  public void v()
  {
    this.a.k1().F0();
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> w()
  {
    return this.f;
  }
  
  public LiveData<Boolean> x()
  {
    return this.c;
  }
  
  public void y()
  {
    if (this.a.q5().getValue() == null) {
      this.a.p5().F0();
    }
  }
  
  class a
    implements Observer<ThingFirmware>
  {
    a() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      SingleLiveEvent localSingleLiveEvent = HubDetailViewModel.f(HubDetailViewModel.this);
      boolean bool;
      if ((paramThingFirmware != null) && (paramThingFirmware.isNeedToUpgrade())) {
        bool = true;
      } else {
        bool = false;
      }
      localSingleLiveEvent.postValue(Boolean.valueOf(bool));
    }
  }
  
  class b
    implements Observer<List<BaseALIoTDevice>>
  {
    b(ThingContext paramThingContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      HubDetailViewModel.h(HubDetailViewModel.this).postValue(HubDetailViewModel.g(HubDetailViewModel.this, paramThingContext.getDeviceIdMD5(), paramList));
    }
  }
  
  class c
    implements g<Long>
  {
    c() {}
    
    public void a(Long paramLong)
      throws Exception
    {
      if (HubDetailViewModel.i(HubDetailViewModel.this).D()) {
        HubDetailViewModel.this.v();
      } else if (HubDetailViewModel.j(HubDetailViewModel.this) != null) {
        HubDetailViewModel.j(HubDetailViewModel.this).dispose();
      }
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d(boolean paramBoolean) {}
    
    public void run()
      throws Exception
    {
      HubDetailViewModel.k(HubDetailViewModel.this).postValue(Boolean.valueOf(paramBoolean));
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      HubDetailViewModel.l(HubDetailViewModel.this).postValue(new i(1, null));
    }
  }
  
  class f
    implements g<CloudConnectStateResult>
  {
    f() {}
    
    public void a(CloudConnectStateResult paramCloudConnectStateResult)
      throws Exception
    {
      HubDetailViewModel.l(HubDetailViewModel.this).postValue(new i(0, paramCloudConnectStateResult));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iothub\HubDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
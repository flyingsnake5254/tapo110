package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HubSettingViewModel
  extends AndroidViewModel
{
  private HubRepository a;
  private IoTCommonFeatureRepository b;
  private TPIoTClientManager c;
  private MediatorLiveData<BaseALIoTDevice> d = new MediatorLiveData();
  private MutableLiveData<i<CloudResult<Void>>> e = new MutableLiveData();
  private MutableLiveData<i<Void>> f = new MutableLiveData();
  private MediatorLiveData<LedInfoBean> g = new MediatorLiveData();
  public ObservableBoolean h = new ObservableBoolean(false);
  
  public HubSettingViewModel(@NonNull Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((HubRepository)e.a(paramThingContext, HubRepository.class));
    this.b = ((IoTCommonFeatureRepository)e.a(paramThingContext, IoTCommonFeatureRepository.class));
    paramApplication = (TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.c = paramApplication;
    this.d.addSource(paramApplication.C1(), new a(paramThingContext));
    this.g.addSource(this.b.c1(), new b());
    this.h.set(false);
  }
  
  private BaseALIoTDevice l(String paramString, List<BaseALIoTDevice> paramList)
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
  
  public void f(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    this.c.w(localArrayList).i(new f()).j(new e()).y();
  }
  
  public LiveData<i<CloudResult<Void>>> m()
  {
    return this.e;
  }
  
  public LiveData<BaseALIoTDevice> n()
  {
    return this.d;
  }
  
  public void o()
  {
    if (this.a.D()) {
      this.a.i5().F0();
    }
  }
  
  public String p()
  {
    if ((this.a.b() != null) && (((ThingContext)this.a.b()).getIoTDevice() != null)) {
      return ((ALIoTDevice)((ThingContext)this.a.b()).getIoTDevice()).getDeviceName();
    }
    return "";
  }
  
  public void r()
  {
    this.a.p1().F0();
  }
  
  public void s()
  {
    this.a.v1().F0();
  }
  
  public LiveData<ThingFirmware> t()
  {
    return this.a.w1();
  }
  
  public LiveData<IoTHubDevice> u()
  {
    return this.a.h5();
  }
  
  public void v()
  {
    this.b.a1().F0();
  }
  
  public LiveData<LedInfoBean> w()
  {
    return this.g;
  }
  
  public LiveData<LoadInfoBean> x()
  {
    return this.a.n5();
  }
  
  public LiveData<i<Void>> y()
  {
    return this.f;
  }
  
  public void z(String paramString)
  {
    this.c.n1(paramString).L0(io.reactivex.l0.a.c()).E(new d()).C(new c()).F0();
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a(ThingContext paramThingContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      HubSettingViewModel.h(HubSettingViewModel.this).postValue(HubSettingViewModel.g(HubSettingViewModel.this, paramThingContext.getDeviceIdMD5(), paramList));
    }
  }
  
  class b
    implements Observer<LedInfoBean>
  {
    b() {}
    
    public void a(@Nullable LedInfoBean paramLedInfoBean)
    {
      HubSettingViewModel.i(HubSettingViewModel.this).postValue(paramLedInfoBean);
    }
  }
  
  class c
    implements g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        HubSettingViewModel.j(HubSettingViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      HubSettingViewModel.j(HubSettingViewModel.this).postValue(new i(1, null));
    }
  }
  
  class d
    implements g<Boolean>
  {
    d() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      HubSettingViewModel.j(HubSettingViewModel.this).postValue(new i(0, null));
    }
  }
  
  class e
    implements g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException))
      {
        HubSettingViewModel.k(HubSettingViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      HubSettingViewModel.k(HubSettingViewModel.this).postValue(new i(1, null));
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f() {}
    
    public void run()
      throws Exception
    {
      HubSettingViewModel.k(HubSettingViewModel.this).postValue(new i(0, null));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iothub\HubSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
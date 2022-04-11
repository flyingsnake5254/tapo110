package com.tplink.iot.viewmodel.iotplug;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.x0.o;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.LedInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlugSettingViewModel
  extends AndroidViewModel
{
  private PlugRepository a;
  private IoTCommonFeatureRepository b;
  private TPIoTClientManager c;
  private MediatorLiveData<BaseALIoTDevice> d = new MediatorLiveData();
  private MutableLiveData<i<CloudResult<Void>>> e = new MutableLiveData();
  private MutableLiveData<i<Void>> f = new MutableLiveData();
  private MediatorLiveData<LedInfoBean> g = new MediatorLiveData();
  public int h;
  
  public PlugSettingViewModel(@NonNull Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    this.a = ((PlugRepository)e.a(paramThingContext, PlugRepository.class));
    this.b = ((IoTCommonFeatureRepository)e.a(paramThingContext, IoTCommonFeatureRepository.class));
    paramApplication = (TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.c = paramApplication;
    this.d.addSource(paramApplication.C1(), new a(paramThingContext));
    this.g.addSource(this.b.c1(), new b());
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null)) {
      this.h = ((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice().getComponentVersion(EnumIoTComponent.DEVICE);
    }
  }
  
  private BaseALIoTDevice l(String paramString, List<BaseALIoTDevice> paramList)
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
  
  public String o()
  {
    if ((this.a.b() != null) && (((ThingContext)this.a.b()).getIoTDevice() != null)) {
      return ((ALIoTDevice)((ThingContext)this.a.b()).getIoTDevice()).getDeviceName();
    }
    return "";
  }
  
  public void p()
  {
    this.a.p1().F0();
  }
  
  public void r()
  {
    this.a.v1().F0();
  }
  
  public LiveData<ThingFirmware> s()
  {
    return this.a.w1();
  }
  
  public void t()
  {
    this.b.a1().F0();
  }
  
  public LiveData<LedInfoBean> u()
  {
    return this.g;
  }
  
  public LiveData<IoTPlugDevice> v()
  {
    return this.a.e5();
  }
  
  public LiveData<i<Void>> w()
  {
    return this.f;
  }
  
  public void x(String paramString)
  {
    o.u((BaseALIoTDevice)this.d.getValue());
    this.c.n1(paramString).L0(io.reactivex.l0.a.c()).E(new d()).C(new c()).F0();
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a(ThingContext paramThingContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      PlugSettingViewModel.h(PlugSettingViewModel.this).postValue(PlugSettingViewModel.g(PlugSettingViewModel.this, paramThingContext.getDeviceIdMD5(), paramList));
    }
  }
  
  class b
    implements Observer<LedInfoBean>
  {
    b() {}
    
    public void a(@Nullable LedInfoBean paramLedInfoBean)
    {
      PlugSettingViewModel.i(PlugSettingViewModel.this).postValue(paramLedInfoBean);
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
        PlugSettingViewModel.j(PlugSettingViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      PlugSettingViewModel.j(PlugSettingViewModel.this).postValue(new i(1, null));
    }
  }
  
  class d
    implements g<Boolean>
  {
    d() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      PlugSettingViewModel.j(PlugSettingViewModel.this).postValue(new i(0, null));
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
        PlugSettingViewModel.k(PlugSettingViewModel.this).postValue(new i(((CloudException)paramThrowable).getErrCode(), null));
        return;
      }
      PlugSettingViewModel.k(PlugSettingViewModel.this).postValue(new i(1, null));
    }
  }
  
  class f
    implements io.reactivex.g0.a
  {
    f() {}
    
    public void run()
      throws Exception
    {
      PlugSettingViewModel.k(PlugSettingViewModel.this).postValue(new i(0, null));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotplug\PlugSettingViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
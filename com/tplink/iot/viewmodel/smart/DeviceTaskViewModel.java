package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingService;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DeviceTaskViewModel
  extends AndroidViewModel
{
  private MediatorLiveData<List<Integer>> a = new MediatorLiveData();
  private MediatorLiveData<List<LightStateBean>> b = new MediatorLiveData();
  private MediatorLiveData<List<LightStateBean>> c = new MediatorLiveData();
  private BulbRepository d;
  private LightStripRepository e;
  private ThingCloudRepository f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private ThingContext p;
  
  public DeviceTaskViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    boolean bool1 = false;
    this.g = false;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = false;
    this.l = false;
    this.m = false;
    this.n = false;
    this.o = false;
    this.p = paramThingContext;
    this.f = ((ThingCloudRepository)b.a(b.d.s.a.a.f(), ThingCloudRepository.class));
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).isLightStrip()))
    {
      paramApplication = (LightStripRepository)e.a(paramThingContext, LightStripRepository.class);
      this.e = paramApplication;
      this.c.addSource(paramApplication.u5(), new f(this));
    }
    else if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).isBulb()))
    {
      paramApplication = (BulbRepository)e.a(paramThingContext, BulbRepository.class);
      this.d = paramApplication;
      this.a.addSource(paramApplication.o5(), new g(this));
      this.b.addSource(this.d.q5(), new a());
    }
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null)) {
      this.g = ((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice().isSupportComponent(EnumIoTComponent.AUTO_LIGHT);
    }
    paramApplication = l();
    if ((paramApplication != null) && (paramApplication.getProperties() != null))
    {
      if (paramApplication.getThingProperty("on") != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.h = bool2;
      boolean bool2 = bool1;
      if (paramApplication.getThingProperty("lighting_effect") != null) {
        bool2 = true;
      }
      this.i = bool2;
    }
    HashMap localHashMap = new HashMap();
    if ((paramApplication != null) && (paramApplication.getServices() != null))
    {
      paramThingContext = paramApplication.getServices().iterator();
      while (paramThingContext.hasNext()) {
        localHashMap.put(((ThingService)paramThingContext.next()).getId(), Boolean.TRUE);
      }
      this.j = localHashMap.containsKey("reverseStatus");
      this.k = localHashMap.containsKey("increaseBrightness");
      this.l = localHashMap.containsKey("decreaseBrightness");
      this.m = localHashMap.containsKey("increaseCCT");
      this.n = localHashMap.containsKey("decreaseCCT");
      this.o = localHashMap.containsKey("randomColor");
    }
    paramThingContext = new StringBuilder();
    paramThingContext.append("ThingModel of ");
    paramThingContext.append(this.p.getDeviceIdMD5());
    paramThingContext.append(" ");
    paramThingContext.append(i.j(paramApplication));
    b.d.w.c.a.n("Smart", paramThingContext.toString());
  }
  
  private ThingModel l()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      if (((ThingContext)localObject).getThingModel() != null) {
        return this.p.getThingModel();
      }
      localObject = this.p.getThingDevice();
      if (localObject != null)
      {
        ThingCloudRepository localThingCloudRepository = this.f;
        if (localThingCloudRepository != null) {
          return localThingCloudRepository.m0(((ThingDevice)localObject).getThingModelId());
        }
      }
    }
    return null;
  }
  
  public String g()
  {
    Object localObject = this.e;
    if (localObject != null) {
      return ((LightStripRepository)localObject).q5();
    }
    localObject = this.d;
    if (localObject != null) {
      return ((BulbRepository)localObject).n5();
    }
    return null;
  }
  
  public MediatorLiveData<List<Integer>> h()
  {
    return this.a;
  }
  
  public MediatorLiveData<List<LightStateBean>> i()
  {
    return this.b;
  }
  
  public MediatorLiveData<List<LightStateBean>> j()
  {
    return this.c;
  }
  
  public void k()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((LightStripRepository)localObject).w5().F0();
    }
    localObject = this.d;
    if (localObject != null) {
      ((BulbRepository)localObject).p5().F0();
    }
  }
  
  public boolean m()
  {
    return this.g;
  }
  
  public boolean n()
  {
    return this.h;
  }
  
  public boolean o()
  {
    return this.l;
  }
  
  public boolean p()
  {
    return this.n;
  }
  
  public boolean r()
  {
    return this.k;
  }
  
  public boolean s()
  {
    return this.m;
  }
  
  public boolean t()
  {
    return this.o;
  }
  
  public boolean u()
  {
    return this.j;
  }
  
  class a
    implements Observer<List<LightStateBean>>
  {
    a() {}
    
    public void a(@Nullable List<LightStateBean> paramList)
    {
      DeviceTaskViewModel.f(DeviceTaskViewModel.this).postValue(paramList);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\smart\DeviceTaskViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
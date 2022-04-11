package com.tplink.iot.viewmodel.quicksetup.subg;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.b.f.b;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportCategory;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.Utils.i;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SubGHubListViewModel
  extends SubGBaseViewModel
{
  private final TPIoTClientManager a;
  private final Map<String, com.tplink.iot.model.iot.e> b = new HashMap();
  private final MediatorLiveData<List<com.tplink.iot.model.iot.e>> c;
  
  public SubGHubListViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = new MediatorLiveData();
    this.c = paramApplication;
    TPIoTClientManager localTPIoTClientManager = (TPIoTClientManager)b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
    this.a = localTPIoTClientManager;
    paramApplication.addSource(localTPIoTClientManager.C1(), new c(this));
  }
  
  private HubRepository i(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    return (HubRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), HubRepository.class);
  }
  
  private void l(List<BaseALIoTDevice> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
      if (localBaseALIoTDevice.isHub())
      {
        if ((localBaseALIoTDevice.isOnline()) && (!localBaseALIoTDevice.isUserRoleTypeDevice())) {
          localArrayList.add(localBaseALIoTDevice);
        }
        t(localBaseALIoTDevice);
      }
    }
    s();
    k(localArrayList);
  }
  
  private void s()
  {
    this.c.postValue(new ArrayList(this.b.values()));
  }
  
  private void t(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    com.tplink.iot.model.iot.e locale = (com.tplink.iot.model.iot.e)this.b.get(paramBaseALIoTDevice.getDeviceIdMD5());
    if (locale == null)
    {
      locale = new com.tplink.iot.model.iot.e(paramBaseALIoTDevice);
      this.b.put(paramBaseALIoTDevice.getDeviceIdMD5(), locale);
    }
    else
    {
      locale.f(paramBaseALIoTDevice);
    }
  }
  
  private void u(@NonNull BaseALIoTDevice paramBaseALIoTDevice, @NonNull LoadInfoBean paramLoadInfoBean)
  {
    com.tplink.iot.model.iot.e locale = (com.tplink.iot.model.iot.e)this.b.get(paramBaseALIoTDevice.getDeviceIdMD5());
    if (locale == null)
    {
      paramLoadInfoBean = new com.tplink.iot.model.iot.e(paramBaseALIoTDevice, paramLoadInfoBean, null);
      this.b.put(paramBaseALIoTDevice.getDeviceIdMD5(), paramLoadInfoBean);
    }
    else
    {
      locale.g(paramLoadInfoBean);
    }
  }
  
  private void v(@NonNull BaseALIoTDevice paramBaseALIoTDevice, @NonNull ThingFirmware paramThingFirmware)
  {
    com.tplink.iot.model.iot.e locale = (com.tplink.iot.model.iot.e)this.b.get(paramBaseALIoTDevice.getDeviceIdMD5());
    if (locale == null)
    {
      paramThingFirmware = new com.tplink.iot.model.iot.e(paramBaseALIoTDevice, null, paramThingFirmware);
      this.b.put(paramBaseALIoTDevice.getDeviceIdMD5(), paramThingFirmware);
    }
    else
    {
      locale.e(paramThingFirmware);
    }
  }
  
  public boolean f(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    return p.a(paramBaseALIoTDevice, (List)this.a.C1().getValue());
  }
  
  public MediatorLiveData<List<com.tplink.iot.model.iot.e>> g()
  {
    return this.c;
  }
  
  public q<ThingFirmware> h(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    return i(paramBaseALIoTDevice).v1();
  }
  
  public q<ThingSupportCategory> j(@NonNull BaseALIoTDevice paramBaseALIoTDevice)
  {
    HubRepository localHubRepository = i(paramBaseALIoTDevice);
    List localList = (List)localHubRepository.s5().getValue();
    String str1 = paramBaseALIoTDevice.getDeviceFwVer();
    String str2 = localHubRepository.k5();
    int i;
    if ((localList != null) && (!localList.isEmpty()) && (TextUtils.equals(str1, str2))) {
      i = 1;
    } else {
      i = 0;
    }
    paramBaseALIoTDevice = new StringBuilder();
    paramBaseALIoTDevice.append("currentFwVer: [");
    paramBaseALIoTDevice.append(str1);
    paramBaseALIoTDevice.append("] fwVerOfSupportCategories: [");
    paramBaseALIoTDevice.append(str2);
    paramBaseALIoTDevice.append("]");
    b.d.w.c.a.d(paramBaseALIoTDevice.toString());
    if (i != 0)
    {
      paramBaseALIoTDevice = new StringBuilder();
      paramBaseALIoTDevice.append("Use Cache SupportSubCategoryList: ");
      paramBaseALIoTDevice.append(i.f(localList));
      b.d.w.c.a.d(paramBaseALIoTDevice.toString());
      paramBaseALIoTDevice = new ThingSupportCategory();
      paramBaseALIoTDevice.setDeviceCategoryList(localList);
      return q.f0(paramBaseALIoTDevice);
    }
    b.d.w.c.a.d("SupportSubCategoryList: null or empty. Request from hub.");
    return localHubRepository.r5();
  }
  
  public void k(@NonNull List<BaseALIoTDevice> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList.next();
      HubRepository localHubRepository = i(localBaseALIoTDevice);
      Object localObject = (LoadInfoBean)localHubRepository.n5().getValue();
      if (localObject != null) {
        u(localBaseALIoTDevice, (LoadInfoBean)localObject);
      } else {
        localHubRepository.j5().E(new e(this, localBaseALIoTDevice)).F0();
      }
      localObject = (ThingFirmware)localHubRepository.w1().getValue();
      if (localObject != null) {
        v(localBaseALIoTDevice, (ThingFirmware)localObject);
      } else {
        localHubRepository.v1().E(new d(this, localBaseALIoTDevice)).F0();
      }
    }
    s();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\quicksetup\subg\SubGHubListViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
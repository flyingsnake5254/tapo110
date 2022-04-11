package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceIdBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.params.DeviceIdListParams;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HubChildDeviceViewModel
  extends AndroidViewModel
{
  private TPIoTClientManager a;
  private HubRepository b;
  private String c;
  private SingleLiveEvent<Integer> d = new SingleLiveEvent();
  private BaseALIoTDevice e;
  
  public HubChildDeviceViewModel(@NonNull Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    this.c = paramThingContext.getDeviceIdMD5();
    this.e = paramThingContext.getIoTDevice();
    this.a = ((TPIoTClientManager)b.d.b.f.b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class));
    this.b = ((HubRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(paramThingContext, HubRepository.class));
  }
  
  public boolean f()
  {
    List localList = (List)this.a.C1().getValue();
    return p.a(this.e, localList);
  }
  
  public q<Boolean> g()
  {
    ThingFirmware localThingFirmware = (ThingFirmware)this.b.w1().getValue();
    if (localThingFirmware != null) {
      return q.f0(Boolean.valueOf(localThingFirmware.isNeedToUpgrade()));
    }
    return this.b.v1().g0(a.c);
  }
  
  public MutableLiveData<List<com.tplink.iot.model.home.e>> h()
  {
    return (MutableLiveData)Transformations.map(this.a.C1(), new c(this));
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<BaseALIoTDevice>> i()
  {
    return this.a.T1();
  }
  
  public SingleLiveEvent<Integer> j()
  {
    return this.d;
  }
  
  public void k()
  {
    this.b.r5().F0();
  }
  
  public void s(List<BaseALIoTDevice> paramList)
  {
    Object localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((List)localObject).add(new DeviceIdBean(((BaseALIoTDevice)localIterator.next()).getDeviceId()));
    }
    localObject = new DeviceIdListParams((List)localObject);
    q.f0(Boolean.TRUE).F(new b(this, paramList, (DeviceIdListParams)localObject)).y(new d(this)).L0(io.reactivex.l0.a.c()).F0();
  }
  
  public void t(@NonNull BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean)
  {
    if (paramBaseALIoTDevice.isSwitch()) {
      ((SwitchRepository)com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(paramBaseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class)).i(paramBoolean).y();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iothub\HubChildDeviceViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
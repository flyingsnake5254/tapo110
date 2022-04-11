package com.tplink.iot.viewmodel.iotcommon;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.DeviceTimeInfo;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;

public class IoTDeviceInfoViewModel
  extends AndroidViewModel
{
  public final ObservableInt a;
  private AbstractThingRepository b;
  private TPIoTClientManager c;
  private MediatorLiveData<BaseALIoTDevice> d;
  
  public IoTDeviceInfoViewModel(@NonNull Application paramApplication, final ThingContext paramThingContext)
  {
    super(paramApplication);
    paramApplication = new ObservableInt(1);
    this.a = paramApplication;
    this.d = new MediatorLiveData();
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice() != null)) {
      paramApplication.set(((ALIoTDevice)paramThingContext.getIoTDevice()).getLocalIoTDevice().getComponentVersion(EnumIoTComponent.DEVICE));
    }
    this.c = ((TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class));
    if ((paramThingContext.getIoTDevice() != null) && (((ALIoTDevice)paramThingContext.getIoTDevice()).isBulb())) {
      this.b = ((AbstractThingRepository)e.a(paramThingContext, BulbRepository.class));
    } else {
      this.b = ((AbstractThingRepository)e.a(paramThingContext, PlugRepository.class));
    }
    this.d.addSource(this.c.C1(), new a(paramThingContext));
  }
  
  private BaseALIoTDevice h(String paramString, List<BaseALIoTDevice> paramList)
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
  
  public LiveData<BaseALIoTDevice> i()
  {
    return this.d;
  }
  
  public LiveData<DeviceTimeInfo> j()
  {
    return this.b.r1();
  }
  
  public void k()
  {
    if (this.a.get() == 1) {
      this.b.q1().F0();
    }
  }
  
  class a
    implements Observer<List<BaseALIoTDevice>>
  {
    a(ThingContext paramThingContext) {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      IoTDeviceInfoViewModel.g(IoTDeviceInfoViewModel.this).postValue(IoTDeviceInfoViewModel.f(IoTDeviceInfoViewModel.this, paramThingContext.getDeviceIdMD5(), paramList));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotcommon\IoTDeviceInfoViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
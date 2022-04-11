package com.tplink.iot.Utils.extension;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static final kotlin.t.c<Object, LiveData<BaseALIoTDevice<?>>> a(ThingContext paramThingContext)
  {
    kotlin.jvm.internal.j.e(paramThingContext, "$this$baseALIoTDeviceLiveData");
    return new a(paramThingContext);
  }
  
  public static final class a
    implements kotlin.t.c<Object, LiveData<BaseALIoTDevice<?>>>
  {
    private final MediatorLiveData<BaseALIoTDevice<?>> a;
    
    a(ThingContext paramThingContext)
    {
      MediatorLiveData localMediatorLiveData = new MediatorLiveData();
      this.a = localMediatorLiveData;
      paramThingContext = (TPIoTClientManager)b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
      kotlin.jvm.internal.j.d(paramThingContext, "tpIoTClientManager");
      localMediatorLiveData.addSource(paramThingContext.C1(), new a(this));
    }
    
    public LiveData<BaseALIoTDevice<?>> d(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
    
    static final class a<T>
      implements Observer<List<BaseALIoTDevice<TDPIoTDevice>>>
    {
      a(c.a parama) {}
      
      public final void a(List<BaseALIoTDevice<TDPIoTDevice>> paramList)
      {
        if (paramList != null)
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            paramList = localIterator.next();
            BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList;
            kotlin.jvm.internal.j.d(localBaseALIoTDevice, "it");
            if (kotlin.jvm.internal.j.a(localBaseALIoTDevice.getDeviceIdMD5(), this.a.b.getDeviceIdMD5())) {
              break label63;
            }
          }
          paramList = null;
          label63:
          paramList = (BaseALIoTDevice)paramList;
          if (paramList != null) {
            c.a.c(this.a).postValue(paramList);
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\extension\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.iot.viewmodel.iothub;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.adapter.iothub.a.b;
import com.tplink.iot.core.AppContext;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.HubAlarmLog;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.HubRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.j;

public final class HubAlarmLogViewModel
  extends AndroidViewModel
{
  private final HubRepository a;
  private final TPIoTClientManager b;
  private final String c;
  private final MediatorLiveData<List<com.tplink.iot.adapter.iothub.a>> d;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> e;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f;
  
  public HubAlarmLogViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    HubRepository localHubRepository = (HubRepository)e.a(paramThingContext, HubRepository.class);
    this.a = localHubRepository;
    this.b = ((TPIoTClientManager)b.d.b.f.b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class));
    paramApplication = paramThingContext.getDeviceIdMD5();
    if (paramApplication == null) {
      paramApplication = "";
    }
    this.c = paramApplication;
    paramThingContext = new MediatorLiveData();
    this.d = paramThingContext;
    paramApplication = new MutableLiveData();
    this.e = paramApplication;
    this.f = paramApplication;
    j.d(localHubRepository, "mHubRepository");
    paramThingContext.addSource(localHubRepository.f5(), new a(this));
  }
  
  private final List<BaseALIoTDevice<?>> j()
  {
    Object localObject1 = this.b;
    j.d(localObject1, "mTPIoTClientManager");
    localObject1 = ((TPIoTClientManager)localObject1).C1();
    j.d(localObject1, "mTPIoTClientManager.allIoTDeviceLiveData");
    localObject1 = (List)((LiveData)localObject1).getValue();
    if (localObject1 != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      for (;;)
      {
        localObject1 = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = localIterator.next();
        localObject1 = (BaseALIoTDevice)localObject2;
        j.d(localObject1, "it");
        int i;
        if ((((BaseALIoTDevice)localObject1).isSubDevice()) && (j.a(((BaseALIoTDevice)localObject1).getParentDeviceIDMD5(), this.c))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          localArrayList.add(localObject2);
        }
      }
    }
    localObject1 = null;
    return (List<BaseALIoTDevice<?>>)localObject1;
  }
  
  private final String l(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      if (paramString1 == null) {
        paramString1 = "";
      }
      return paramString1;
    }
    Object localObject1 = j();
    Object localObject2 = null;
    Object localObject3 = null;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        localObject2 = localObject3;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
      } while (!j.a(((BaseALIoTDevice)localObject2).getDeviceId(), paramString2));
      localObject2 = (BaseALIoTDevice)localObject2;
    }
    if (localObject2 != null)
    {
      paramString1 = com.tplink.iot.Utils.z0.l.c(getApplication(), (BaseALIoTDevice)localObject2);
      j.d(paramString1, "DeviceCommonUtils.getDev…getApplication(), device)");
    }
    else if (paramString1 == null)
    {
      paramString1 = "";
    }
    return paramString1;
  }
  
  private final BaseALIoTDevice<?> n()
  {
    return this.b.Z1(this.c);
  }
  
  private final void r(List<HubAlarmLog> paramList)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1 = n();
    if (localObject1 != null) {
      localObject1 = ((BaseALIoTDevice)localObject1).getDeviceRegion();
    } else {
      localObject1 = null;
    }
    localObject1 = p0.d((String)localObject1);
    paramList = paramList.iterator();
    Object localObject3;
    long l;
    while (paramList.hasNext())
    {
      localObject2 = (HubAlarmLog)paramList.next();
      localObject3 = b.a;
      l = com.tplink.iot.Utils.extension.b.e(((HubAlarmLog)localObject2).getTimestamp());
      j.d(localObject1, "deviceTimeZone");
      l = ((b)localObject3).c(l, (TimeZone)localObject1);
      localObject3 = (List)localLinkedHashMap.get(Long.valueOf(l));
      if (localObject3 == null) {
        localLinkedHashMap.put(Long.valueOf(l), kotlin.collections.l.h(new HubAlarmLog[] { localObject2 }));
      } else {
        ((List)localObject3).add(localObject2);
      }
    }
    Object localObject2 = kotlin.collections.l.N(localLinkedHashMap.keySet());
    paramList = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      l = ((Number)((Iterator)localObject2).next()).longValue();
      localObject3 = b.a;
      j.d(localObject1, "deviceTimeZone");
      paramList.add(new com.tplink.iot.adapter.iothub.a(1, ((b)localObject3).b(l, (TimeZone)localObject1), null, 4, null));
      localObject3 = (List)localLinkedHashMap.get(Long.valueOf(l));
      if (localObject3 != null)
      {
        Iterator localIterator = ((Iterable)localObject3).iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (HubAlarmLog)localIterator.next();
          paramList.add(new com.tplink.iot.adapter.iothub.a(2, null, new a.b(b.a.a(com.tplink.iot.Utils.extension.b.e(((HubAlarmLog)localObject3).getTimestamp()), (TimeZone)localObject1), ((HubAlarmLog)localObject3).getEnumGuardMode(), l(((HubAlarmLog)localObject3).getNickname(), ((HubAlarmLog)localObject3).getDeviceId())), 2, null));
        }
      }
    }
    this.d.postValue(paramList);
  }
  
  public final io.reactivex.a h()
  {
    io.reactivex.a locala = this.a.G6();
    j.d(locala, "mHubRepository.removeAllAlarmLogs()");
    return locala;
  }
  
  public final LiveData<List<com.tplink.iot.adapter.iothub.a>> i()
  {
    return this.d;
  }
  
  public final LiveData<Boolean> k()
  {
    Object localObject = this.a;
    j.d(localObject, "mHubRepository");
    localObject = ((HubRepository)localObject).g5();
    j.d(localObject, "mHubRepository.canLoadMoreLiveData");
    return (LiveData<Boolean>)localObject;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> m()
  {
    return this.f;
  }
  
  public final void o()
  {
    this.a.w6();
  }
  
  public final void p()
  {
    this.a.x6().j(new c(this)).i(new d(this)).y();
  }
  
  public final void s()
  {
    this.a.D6().j(new e(this)).i(new f(this)).y();
  }
  
  static final class a<T>
    implements Observer<List<HubAlarmLog>>
  {
    a(HubAlarmLogViewModel paramHubAlarmLogViewModel) {}
    
    public final void a(List<HubAlarmLog> paramList)
    {
      if (paramList != null) {
        HubAlarmLogViewModel.g(this.a, paramList);
      }
    }
  }
  
  private static final class b
  {
    public static final b a = new b();
    
    public final String a(long paramLong, TimeZone paramTimeZone)
    {
      j.e(paramTimeZone, "timeZone");
      return com.tplink.iot.Utils.extension.g.b(new Date(paramLong), AppContext.c, paramTimeZone, null, 4, null);
    }
    
    public final String b(long paramLong, TimeZone paramTimeZone)
    {
      j.e(paramTimeZone, "timeZone");
      return com.tplink.iot.Utils.extension.b.d(new Date(paramLong), "MM.dd EEEE", paramTimeZone, null, 4, null);
    }
    
    public final long c(long paramLong, TimeZone paramTimeZone)
    {
      j.e(paramTimeZone, "timeZone");
      Date localDate = new Date(paramLong);
      paramTimeZone = Calendar.getInstance(paramTimeZone);
      paramTimeZone.setTime(localDate);
      paramTimeZone.set(11, 0);
      paramTimeZone.set(12, 0);
      paramTimeZone.set(13, 0);
      paramTimeZone.set(14, 0);
      j.d(paramTimeZone, "calendar.apply {\n       …ISECOND, 0)\n            }");
      paramTimeZone = paramTimeZone.getTime();
      j.d(paramTimeZone, "calendar.apply {\n       …ND, 0)\n            }.time");
      return paramTimeZone.getTime();
    }
  }
  
  static final class c<T>
    implements io.reactivex.g0.g<Throwable>
  {
    c(HubAlarmLogViewModel paramHubAlarmLogViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      HubAlarmLogViewModel.f(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  static final class d
    implements io.reactivex.g0.a
  {
    d(HubAlarmLogViewModel paramHubAlarmLogViewModel) {}
    
    public final void run()
    {
      HubAlarmLogViewModel.f(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class e<T>
    implements io.reactivex.g0.g<Throwable>
  {
    e(HubAlarmLogViewModel paramHubAlarmLogViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      HubAlarmLogViewModel.f(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  static final class f
    implements io.reactivex.g0.a
  {
    f(HubAlarmLogViewModel paramHubAlarmLogViewModel) {}
    
    public final void run()
    {
      HubAlarmLogViewModel.f(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iothub\HubAlarmLogViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
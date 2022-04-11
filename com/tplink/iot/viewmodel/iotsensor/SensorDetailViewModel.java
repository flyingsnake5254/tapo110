package com.tplink.iot.viewmodel.iotsensor;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.cloud.bean.thing.common.ThingEventLog;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.BatteryDetectInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractSubThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.ThingEventLogRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class SensorDetailViewModel
  extends AndroidViewModel
{
  private final LiveData<Boolean> A;
  private final LiveData<Boolean> B;
  private final LiveData<Integer> C;
  private final LiveData<Boolean> D;
  private final LiveData<Boolean> E;
  private io.reactivex.e0.c F;
  private final TPIoTClientManager b;
  private final SensorRepository c;
  private final String d;
  private final kotlin.t.c e;
  private final String f;
  private final MediatorLiveData<BaseALIoTDevice<?>> g;
  private final LiveData<BaseALIoTDevice<?>> h;
  private final LiveData<IoTSubDevice> i;
  private final MediatorLiveData<Boolean> j;
  private final MediatorLiveData<Boolean> k;
  private final MutableLiveData<i<CloudConnectStateResult>> l;
  private final LiveData<i<CloudConnectStateResult>> m;
  private final MediatorLiveData<List<com.tplink.iot.adapter.iotsensor.a>> n;
  private final HashMap<Long, List<TriggerLog>> o;
  private final LiveData<List<com.tplink.iot.adapter.iotsensor.a>> p;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> q;
  private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> r;
  private final LiveData<String> s;
  private final LiveData<String> t;
  private final LiveData<Boolean> u;
  private final LiveData<Integer> v;
  private final MediatorLiveData<Boolean> w;
  private final LiveData<Boolean> x;
  private final boolean y;
  private final LiveData<Boolean> z;
  
  public SensorDetailViewModel(Application paramApplication, ThingContext paramThingContext)
  {
    super(paramApplication);
    TPIoTClientManager localTPIoTClientManager = (TPIoTClientManager)b.d.b.f.b.a(paramThingContext.getAccountContext(), TPIoTClientManager.class);
    this.b = localTPIoTClientManager;
    Object localObject = e.a(paramThingContext, SensorRepository.class);
    kotlin.jvm.internal.j.d(localObject, "IoTDeviceRepositoryProvi…orRepository::class.java)");
    SensorRepository localSensorRepository = (SensorRepository)localObject;
    this.c = localSensorRepository;
    this.d = paramThingContext.getDeviceIdMD5();
    this.e = new a(paramThingContext);
    localObject = A();
    if (localObject != null)
    {
      localObject = ((BaseALIoTDevice)localObject).getDeviceModel();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.f = ((String)localObject);
    MediatorLiveData localMediatorLiveData1 = new MediatorLiveData();
    this.g = localMediatorLiveData1;
    this.h = localMediatorLiveData1;
    localObject = localSensorRepository.i4();
    this.i = ((LiveData)localObject);
    MediatorLiveData localMediatorLiveData2 = new MediatorLiveData();
    this.j = localMediatorLiveData2;
    this.k = localMediatorLiveData2;
    MutableLiveData localMutableLiveData = new MutableLiveData();
    this.l = localMutableLiveData;
    this.m = localMutableLiveData;
    MediatorLiveData localMediatorLiveData3 = new MediatorLiveData();
    this.n = localMediatorLiveData3;
    this.o = new HashMap();
    this.p = localMediatorLiveData3;
    localMutableLiveData = new MutableLiveData();
    this.q = localMutableLiveData;
    this.r = localMutableLiveData;
    kotlin.jvm.internal.j.d(localTPIoTClientManager, "mTPIoTClientManager");
    localMediatorLiveData1.addSource(localTPIoTClientManager.C1(), new b(this));
    localMediatorLiveData3.addSource(B().Q0(), new c(this));
    localMediatorLiveData2.addSource(localSensorRepository.h1(), new d(this));
    B().d1("sub_trigger_log_cache_list");
    paramApplication = Transformations.map(localMediatorLiveData1, new i(paramApplication));
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mALI…e, it?.deviceModel)\n    }");
    this.s = paramApplication;
    paramApplication = Transformations.map(localMediatorLiveData1, g.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mALI…getRoomLocation(it)\n    }");
    this.t = paramApplication;
    paramApplication = Transformations.map(paramApplication, h.a);
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(devi…xtUtils.isEmpty(it)\n    }");
    this.u = paramApplication;
    paramApplication = Transformations.map(localMediatorLiveData1, new u(this));
    kotlin.jvm.internal.j.d(paramApplication, "Transformations.map(mALI…sensor_on\n        }\n    }");
    this.v = paramApplication;
    paramApplication = new MediatorLiveData();
    this.w = paramApplication;
    this.x = paramApplication;
    paramThingContext = (ALIoTDevice)paramThingContext.getIoTDevice();
    if (paramThingContext != null)
    {
      paramThingContext = paramThingContext.getLocalIoTDevice();
      if (paramThingContext != null)
      {
        bool = paramThingContext.isSupportComponent(EnumIoTComponent.BATTERY_DETECT);
        break label466;
      }
    }
    boolean bool = false;
    label466:
    this.y = bool;
    paramThingContext = Transformations.map(localMediatorLiveData1, p.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(mALI…rtIoTCloud ?: false\n    }");
    this.z = paramThingContext;
    paramThingContext = Transformations.map(localMediatorLiveData1, l.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(mALI….isCommonDevice ?: true }");
    this.A = paramThingContext;
    paramThingContext = Transformations.map(localMediatorLiveData1, m.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(mALI…upportIoTCloud ?: false }");
    this.B = paramThingContext;
    paramThingContext = Transformations.map(localMediatorLiveData1, j.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(alIo….size ?: 1) - 1, 0)\n    }");
    this.C = paramThingContext;
    paramThingContext = Transformations.map(localMediatorLiveData1, o.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(alIo…TypeDevice ?: false\n    }");
    this.D = paramThingContext;
    paramThingContext = Transformations.map(localMediatorLiveData1, n.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(alIo…e\n        } ?: true\n    }");
    this.E = paramThingContext;
    paramApplication.addSource(localSensorRepository.U0(), new e(this));
    paramApplication.addSource((LiveData)localObject, new f(this));
  }
  
  private final BaseALIoTDevice<?> A()
  {
    return this.b.Z1(this.d);
  }
  
  private final ThingEventLogRepository B()
  {
    return (ThingEventLogRepository)this.e.b(this, a[0]);
  }
  
  private final Comparator<TriggerLog> E()
  {
    return k.c;
  }
  
  private final void S(List<TriggerLog> paramList)
  {
    Object localObject1 = A();
    if (localObject1 != null) {
      localObject1 = ((BaseALIoTDevice)localObject1).getDeviceRegion();
    } else {
      localObject1 = null;
    }
    localObject1 = p0.d((String)localObject1);
    this.o.clear();
    paramList = paramList.iterator();
    long l1;
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (TriggerLog)paramList.next();
      l1 = com.tplink.iot.Utils.extension.b.e(((TriggerLog)localObject2).getTimestamp());
      kotlin.jvm.internal.j.d(localObject1, "deviceTimeZone");
      l1 = Y(l1, (TimeZone)localObject1);
      localObject3 = (List)this.o.get(Long.valueOf(l1));
      if (localObject3 == null)
      {
        localObject2 = kotlin.collections.l.h(new TriggerLog[] { localObject2 });
        this.o.put(Long.valueOf(l1), localObject2);
      }
      else
      {
        ((List)localObject3).add(localObject2);
      }
    }
    paramList = this.o.keySet();
    kotlin.jvm.internal.j.d(paramList, "mCachedTriggerLogMap.keys");
    Object localObject2 = kotlin.collections.l.N(paramList);
    localObject1 = new ArrayList();
    paramList = E();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      l1 = ((Number)((Iterator)localObject2).next()).longValue();
      ((List)localObject1).add(new com.tplink.iot.adapter.iotsensor.a(1, Long.valueOf(l1), null, 4, null));
      localObject3 = (List)this.o.get(Long.valueOf(l1));
      if (localObject3 != null)
      {
        localObject3 = kotlin.collections.l.O((Iterable)localObject3, paramList);
        if (localObject3 != null)
        {
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((List)localObject1).add(new com.tplink.iot.adapter.iotsensor.a(2, null, (TriggerLog)((Iterator)localObject3).next(), 2, null));
          }
        }
      }
    }
    this.n.postValue(localObject1);
  }
  
  private final void T()
  {
    x();
  }
  
  private final long Y(long paramLong, TimeZone paramTimeZone)
  {
    Date localDate = new Date(paramLong);
    paramTimeZone = Calendar.getInstance(paramTimeZone);
    paramTimeZone.setTime(localDate);
    paramTimeZone.set(11, 0);
    paramTimeZone.set(12, 0);
    paramTimeZone.set(13, 0);
    paramTimeZone.set(14, 0);
    kotlin.jvm.internal.j.d(paramTimeZone, "calendar.apply {\n       …MILLISECOND, 0)\n        }");
    paramTimeZone = paramTimeZone.getTime();
    kotlin.jvm.internal.j.d(paramTimeZone, "calendar.apply {\n       …SECOND, 0)\n        }.time");
    return paramTimeZone.getTime();
  }
  
  private final void x()
  {
    this.c.Z0().F0();
  }
  
  public final LiveData<Integer> C()
  {
    return this.v;
  }
  
  public final MediatorLiveData<Boolean> D()
  {
    return this.k;
  }
  
  public final LiveData<List<com.tplink.iot.adapter.iotsensor.a>> F()
  {
    return this.p;
  }
  
  public final LiveData<Boolean> G()
  {
    return this.A;
  }
  
  public final LiveData<Boolean> H()
  {
    return this.B;
  }
  
  public final LiveData<Boolean> I()
  {
    return this.x;
  }
  
  public final boolean J()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.d);
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (localALIoTDevice != null)
    {
      if (localALIoTDevice.isSupportIoTCloudComponent())
      {
        if (localALIoTDevice.getThingDevice() == null) {
          return bool1;
        }
      }
      else if (localALIoTDevice.getCloudIoTDevice() == null) {
        return bool1;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  public final LiveData<Boolean> K()
  {
    return this.E;
  }
  
  public final LiveData<Boolean> L()
  {
    return this.D;
  }
  
  public final LiveData<Boolean> M()
  {
    return this.z;
  }
  
  public final boolean N()
  {
    return com.tplink.iot.Utils.w0.a.i(this.d);
  }
  
  public final boolean O()
  {
    Object localObject = TPIoTClientManager.k2(this.d);
    if (localObject != null)
    {
      localObject = (ALIoTDevice)((TPBaseDeviceContext)localObject).getIoTDevice();
      if (localObject != null) {
        return ((BaseALIoTDevice)localObject).isUserRoleTypeDevice();
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public final void P()
  {
    B().T0();
  }
  
  public final void Q()
  {
    B().U0().j(new q(this)).i(new r(this)).y();
  }
  
  public final void R()
  {
    this.c.o4();
  }
  
  public final void U()
  {
    B().Y0().j(new s(this)).i(new t(this)).y();
  }
  
  @DrawableRes
  public final int V()
  {
    Object localObject = (List)B().Q0().getValue();
    if (localObject != null) {
      localObject = (ThingEventLog)kotlin.collections.l.y((List)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((ThingEventLog)localObject).getName();
      if (localObject != null) {}
    }
    else
    {
      localObject = "close";
    }
    int i1;
    if ((!kotlin.jvm.internal.j.a(localObject, "open")) && (!kotlin.jvm.internal.j.a(localObject, "keepOpen"))) {
      i1 = 2131231509;
    } else {
      i1 = 2131231510;
    }
    return i1;
  }
  
  public final void W()
  {
    io.reactivex.e0.c localc = this.F;
    if (localc != null) {
      localc.dispose();
    }
    if (!this.c.D())
    {
      T();
      return;
    }
    this.F = q.a0(0L, 20L, TimeUnit.SECONDS).G0(new v(this));
  }
  
  public final void X()
  {
    io.reactivex.e0.c localc = this.F;
    if (localc != null) {
      localc.dispose();
    }
  }
  
  public final void o(boolean paramBoolean)
  {
    this.c.J0(paramBoolean).y();
  }
  
  public final LiveData<BaseALIoTDevice<?>> p()
  {
    return this.h;
  }
  
  public final LiveData<Boolean> r()
  {
    return B().P0();
  }
  
  public final LiveData<i<CloudConnectStateResult>> s()
  {
    return this.m;
  }
  
  public final LiveData<String> t()
  {
    return this.t;
  }
  
  public final LiveData<Boolean> u()
  {
    return this.u;
  }
  
  public final String v()
  {
    return this.f;
  }
  
  public final LiveData<String> w()
  {
    return this.s;
  }
  
  public final LiveData<Integer> y()
  {
    return this.C;
  }
  
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> z()
  {
    return this.r;
  }
  
  public static final class a
    implements kotlin.t.c<Object, ThingEventLogRepository>
  {
    private final ThingEventLogRepository a;
    
    public a(ThingContext paramThingContext)
    {
      paramThingContext = e.a(paramThingContext, ThingEventLogRepository.class);
      kotlin.jvm.internal.j.d(paramThingContext, "IoTDeviceRepositoryProvi…sitory, REPO::class.java)");
      this.a = paramThingContext;
    }
    
    public ThingEventLogRepository c(Object paramObject, kotlin.reflect.j<?> paramj)
    {
      kotlin.jvm.internal.j.e(paramObject, "thisRef");
      kotlin.jvm.internal.j.e(paramj, "property");
      return this.a;
    }
  }
  
  static final class b<T>
    implements Observer<List<BaseALIoTDevice<TDPIoTDevice>>>
  {
    b(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(List<BaseALIoTDevice<TDPIoTDevice>> paramList)
    {
      kotlin.jvm.internal.j.d(paramList, "deviceList");
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = localIterator.next();
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)paramList;
        kotlin.jvm.internal.j.d(localBaseALIoTDevice, "device");
        if (kotlin.jvm.internal.j.a(localBaseALIoTDevice.getDeviceIdMD5(), SensorDetailViewModel.g(this.a))) {
          break label62;
        }
      }
      paramList = null;
      label62:
      paramList = (BaseALIoTDevice)paramList;
      if (paramList != null) {
        SensorDetailViewModel.f(this.a).postValue(paramList);
      }
    }
  }
  
  static final class c<T>
    implements Observer<List<? extends ThingEventLog>>
  {
    c(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(List<? extends ThingEventLog> paramList)
    {
      if (paramList != null)
      {
        localObject = new ArrayList(kotlin.collections.l.l(paramList, 10));
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          ((Collection)localObject).add(new TriggerLog((ThingEventLog)localIterator.next()));
        }
        SensorDetailViewModel.m(this.a, (List)localObject);
      }
      Object localObject = null;
      if (paramList != null) {
        paramList = (ThingEventLog)kotlin.collections.l.y(paramList);
      } else {
        paramList = null;
      }
      if (paramList != null) {
        localObject = new TriggerLog(paramList);
      }
      SensorDetailViewModel.j(this.a).k1().postValue(localObject);
    }
  }
  
  static final class d<T>
    implements Observer<ThingFirmware>
  {
    d(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      MediatorLiveData localMediatorLiveData = SensorDetailViewModel.k(this.a);
      boolean bool = true;
      if ((paramThingFirmware == null) || (paramThingFirmware.isNeedToUpgrade() != true)) {
        bool = false;
      }
      localMediatorLiveData.postValue(Boolean.valueOf(bool));
    }
  }
  
  static final class e<T>
    implements Observer<BatteryDetectInfoResult>
  {
    e(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(BatteryDetectInfoResult paramBatteryDetectInfoResult)
    {
      MediatorLiveData localMediatorLiveData = SensorDetailViewModel.h(this.a);
      boolean bool;
      if (paramBatteryDetectInfoResult != null) {
        bool = paramBatteryDetectInfoResult.isLow();
      } else {
        bool = false;
      }
      localMediatorLiveData.postValue(Boolean.valueOf(bool));
    }
  }
  
  static final class f<T>
    implements Observer<IoTSubDevice>
  {
    f(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(IoTSubDevice paramIoTSubDevice)
    {
      MediatorLiveData localMediatorLiveData = SensorDetailViewModel.h(this.a);
      boolean bool;
      if (paramIoTSubDevice != null) {
        bool = paramIoTSubDevice.isAtLowBattery();
      } else {
        bool = false;
      }
      localMediatorLiveData.postValue(Boolean.valueOf(bool));
    }
  }
  
  static final class g<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    public static final g a = new g();
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      return com.tplink.iot.Utils.z0.l.h(paramBaseALIoTDevice);
    }
  }
  
  static final class h<I, O>
    implements Function<String, Boolean>
  {
    public static final h a = new h();
    
    public final Boolean a(String paramString)
    {
      return Boolean.valueOf(TextUtils.isEmpty(paramString) ^ true);
    }
  }
  
  static final class i<I, O>
    implements Function<BaseALIoTDevice<?>, String>
  {
    i(Application paramApplication) {}
    
    public final String a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      Application localApplication = this.a;
      String str1 = null;
      String str2;
      if (paramBaseALIoTDevice != null) {
        str2 = paramBaseALIoTDevice.getDeviceType();
      } else {
        str2 = null;
      }
      String str3;
      if (paramBaseALIoTDevice != null) {
        str3 = paramBaseALIoTDevice.getDeviceName();
      } else {
        str3 = null;
      }
      if (paramBaseALIoTDevice != null) {
        str1 = paramBaseALIoTDevice.getDeviceModel();
      }
      return com.tplink.iot.Utils.z0.l.e(localApplication, str2, str3, str1);
    }
  }
  
  static final class j<I, O>
    implements Function<BaseALIoTDevice<?>, Integer>
  {
    public static final j a = new j();
    
    public final Integer a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      if (paramBaseALIoTDevice != null)
      {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceManagerInfo();
        if (paramBaseALIoTDevice != null)
        {
          paramBaseALIoTDevice = paramBaseALIoTDevice.getUserInfo();
          if (paramBaseALIoTDevice != null)
          {
            i = paramBaseALIoTDevice.size();
            break label34;
          }
        }
      }
      int i = 1;
      label34:
      return Integer.valueOf(Math.max(i - 1, 0));
    }
  }
  
  static final class k<T>
    implements Comparator<TriggerLog>
  {
    public static final k c = new k();
    
    public final int a(TriggerLog paramTriggerLog1, TriggerLog paramTriggerLog2)
    {
      int i;
      if (paramTriggerLog1.getTimestamp() != paramTriggerLog2.getTimestamp()) {
        i = (int)(paramTriggerLog2.getTimestamp() - paramTriggerLog1.getTimestamp());
      } else {
        i = paramTriggerLog2.getId() - paramTriggerLog1.getId();
      }
      return i;
    }
  }
  
  static final class l<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final l a = new l();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isCommonDevice();
      } else {
        bool = true;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class m<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final m a = new m();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isSupportIoTCloud();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class n<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final n a = new n();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (paramBaseALIoTDevice != null) {
        if (!paramBaseALIoTDevice.isSupportIoTCloud())
        {
          bool2 = bool1;
          if (paramBaseALIoTDevice.getCloudIoTDevice() == null) {}
        }
        else if (paramBaseALIoTDevice.isUserRoleTypeDevice())
        {
          bool2 = bool1;
        }
        else
        {
          bool2 = false;
        }
      }
      return Boolean.valueOf(bool2);
    }
  }
  
  static final class o<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final o a = new o();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isUserRoleTypeDevice();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class p<I, O>
    implements Function<BaseALIoTDevice<?>, Boolean>
  {
    public static final p a = new p();
    
    public final Boolean a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      boolean bool;
      if (paramBaseALIoTDevice != null) {
        bool = paramBaseALIoTDevice.isSupportIoTCloud();
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  static final class q<T>
    implements g<Throwable>
  {
    q(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      SensorDetailViewModel.i(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  static final class r
    implements io.reactivex.g0.a
  {
    r(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void run()
    {
      SensorDetailViewModel.i(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class s<T>
    implements g<Throwable>
  {
    s(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(Throwable paramThrowable)
    {
      SensorDetailViewModel.i(this.c).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.FALSE));
    }
  }
  
  static final class t
    implements io.reactivex.g0.a
  {
    t(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void run()
    {
      SensorDetailViewModel.i(this.a).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Boolean.TRUE));
    }
  }
  
  static final class u<I, O>
    implements Function<BaseALIoTDevice<?>, Integer>
  {
    u(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final Integer a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      if (paramBaseALIoTDevice != null) {
        paramBaseALIoTDevice = paramBaseALIoTDevice.getDeviceModel();
      } else {
        paramBaseALIoTDevice = null;
      }
      int i = 2131231502;
      if (paramBaseALIoTDevice != null)
      {
        int j = paramBaseALIoTDevice.hashCode();
        if (j != 2551069)
        {
          if (j != 2551100)
          {
            if ((j == 78189475) && (paramBaseALIoTDevice.equals("S200B"))) {
              i = 2131231300;
            }
          }
          else if (paramBaseALIoTDevice.equals("T110")) {
            i = this.a.V();
          }
        }
        else {
          paramBaseALIoTDevice.equals("T100");
        }
      }
      return Integer.valueOf(i);
    }
  }
  
  static final class v<T>
    implements g<Long>
  {
    v(SensorDetailViewModel paramSensorDetailViewModel) {}
    
    public final void a(Long paramLong)
    {
      if (SensorDetailViewModel.j(this.c).D())
      {
        SensorDetailViewModel.n(this.c);
      }
      else
      {
        paramLong = SensorDetailViewModel.l(this.c);
        if (paramLong != null) {
          paramLong.dispose();
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\iotsensor\SensorDetailViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
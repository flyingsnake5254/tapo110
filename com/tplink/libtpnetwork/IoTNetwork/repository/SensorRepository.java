package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.SensitivityInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.BatteryDetectInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.SubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.Objects;

public final class SensorRepository
  extends AbstractSubThingRepository
{
  public static final a C = new a(null);
  private final MutableLiveData<String> D;
  private final LiveData<String> E;
  private final MutableLiveData<Integer> F;
  private final LiveData<Integer> G;
  private final LiveData<IoTSubDevice> H;
  
  public SensorRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTSubDevice.class, SubDeviceRunningInfoResult.class);
    MutableLiveData localMutableLiveData = new MutableLiveData();
    this.D = localMutableLiveData;
    this.E = localMutableLiveData;
    localMutableLiveData = new MutableLiveData();
    this.F = localMutableLiveData;
    this.G = localMutableLiveData;
    paramThingContext = (ALIoTDevice)paramThingContext.getIoTDevice();
    if (paramThingContext != null) {
      paramThingContext = paramThingContext.getLocalIoTDevice();
    } else {
      paramThingContext = null;
    }
    if ((paramThingContext instanceof IoTSubDevice)) {
      this.n.postValue(paramThingContext);
    } else {
      this.n.postValue(new IoTSubDevice());
    }
    paramThingContext = Transformations.map(this.n, b.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(supe… it as IoTSubDevice\n    }");
    this.H = paramThingContext;
  }
  
  public final LiveData<IoTSubDevice> i4()
  {
    return this.H;
  }
  
  public final TriggerLog j4()
  {
    MutableLiveData localMutableLiveData = k1();
    kotlin.jvm.internal.j.d(localMutableLiveData, "latestTriggerLogLiveData");
    return (TriggerLog)localMutableLiveData.getValue();
  }
  
  public final boolean k4()
  {
    Object localObject = (IoTSubDevice)this.H.getValue();
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((IoTSubDevice)localObject).isAtLowBattery());
    }
    else
    {
      localObject = U0();
      kotlin.jvm.internal.j.d(localObject, "batteryDetectInfoLiveData");
      localObject = (BatteryDetectInfoResult)((LiveData)localObject).getValue();
      if (localObject != null) {
        localObject = Boolean.valueOf(((BatteryDetectInfoResult)localObject).isLow());
      } else {
        localObject = null;
      }
    }
    boolean bool;
    if (localObject != null) {
      bool = ((Boolean)localObject).booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final LiveData<Integer> l4()
  {
    return this.G;
  }
  
  public final q<SensitivityInfoBean> m4()
  {
    q localq = y0("get_sensitivity_info", null, SensitivityInfoBean.class).o0(new c(this)).E(new d(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…TERVAL)\n                }");
    return localq;
  }
  
  public final LiveData<String> n4()
  {
    return this.E;
  }
  
  public final void o4()
  {
    ThingCloudRepository localThingCloudRepository = this.d;
    TPBaseDeviceContext localTPBaseDeviceContext = this.a;
    kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
    String str = ((ThingContext)localTPBaseDeviceContext).getThingUrl();
    localTPBaseDeviceContext = this.a;
    kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
    localThingCloudRepository.U0(str, ((ThingContext)localTPBaseDeviceContext).getThingName(), new String[] { EnumNotificationMsgType.TAPO_SENSOR_FREQUENTLY_TRIGGERED.getName() }).y();
  }
  
  public final io.reactivex.a p4(final int paramInt)
  {
    final Object localObject = (String)this.D.getValue();
    if (localObject == null) {
      localObject = "";
    }
    localObject = new SensitivityInfoBean((String)localObject, Integer.valueOf(paramInt));
    localObject = y0("set_sensitivity_info", localObject, Boolean.class).o0(new e(this, (SensitivityInfoBean)localObject)).z(new f(this, paramInt)).Z();
    kotlin.jvm.internal.j.d(localObject, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return (io.reactivex.a)localObject;
  }
  
  public final io.reactivex.a q4(final String paramString)
  {
    kotlin.jvm.internal.j.e(paramString, "sensitivity");
    final SensitivityInfoBean localSensitivityInfoBean = new SensitivityInfoBean(paramString, (Integer)this.F.getValue());
    paramString = y0("set_sensitivity_info", localSensitivityInfoBean, Boolean.class).o0(new g(this, localSensitivityInfoBean)).z(new h(this, paramString)).Z();
    kotlin.jvm.internal.j.d(paramString, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramString;
  }
  
  public static final class a {}
  
  static final class b<I, O>
    implements Function<LocalIoTBaseDevice, IoTSubDevice>
  {
    public static final b a = new b();
    
    public final IoTSubDevice a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Sensor deviceInfoData: ");
      String str;
      if (paramLocalIoTBaseDevice != null) {
        str = l.i(paramLocalIoTBaseDevice);
      } else {
        str = null;
      }
      localStringBuilder.append(str);
      b.d.w.c.a.a(localStringBuilder.toString());
      Objects.requireNonNull(paramLocalIoTBaseDevice, "null cannot be cast to non-null type com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice");
      return (IoTSubDevice)paramLocalIoTBaseDevice;
    }
  }
  
  static final class c<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends SensitivityInfoBean>>
  {
    c(SensorRepository paramSensorRepository) {}
    
    public final t<? extends SensitivityInfoBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.t(EnumFeatureType.TRIGGER_CONFIG.getName()).g0(a.c);
      }
      return q.J(paramThrowable);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, SensitivityInfoBean>
    {
      public static final a c = new a();
      
      public final SensitivityInfoBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (SensitivityInfoBean)com.tplink.libtpnetwork.Utils.i.a(parami, SensitivityInfoBean.class);
      }
    }
  }
  
  static final class d<T>
    implements g<SensitivityInfoBean>
  {
    d(SensorRepository paramSensorRepository) {}
    
    public final void a(SensitivityInfoBean paramSensitivityInfoBean)
    {
      MutableLiveData localMutableLiveData = SensorRepository.h4(this.c);
      if (paramSensitivityInfoBean != null)
      {
        localObject = paramSensitivityInfoBean.getSensitivity();
        if (localObject != null) {}
      }
      else
      {
        localObject = "";
      }
      localMutableLiveData.postValue(localObject);
      Object localObject = SensorRepository.g4(this.c);
      if (paramSensitivityInfoBean != null)
      {
        paramSensitivityInfoBean = paramSensitivityInfoBean.getReportInterval();
        if (paramSensitivityInfoBean != null)
        {
          i = paramSensitivityInfoBean.intValue();
          break label66;
        }
      }
      int i = 8;
      label66:
      ((MutableLiveData)localObject).postValue(Integer.valueOf(i));
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    e(SensorRepository paramSensorRepository, SensitivityInfoBean paramSensitivityInfoBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.L0(EnumFeatureType.TRIGGER_CONFIG.getName(), localObject).g0(a.c);
      }
      return q.J(paramThrowable);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, Boolean>
    {
      public static final a c = new a();
      
      public final Boolean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return Boolean.TRUE;
      }
    }
  }
  
  static final class f
    implements io.reactivex.g0.a
  {
    f(SensorRepository paramSensorRepository, int paramInt) {}
    
    public final void run()
    {
      SensorRepository.g4(this.a).postValue(Integer.valueOf(paramInt));
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    g(SensorRepository paramSensorRepository, SensitivityInfoBean paramSensitivityInfoBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.L0(EnumFeatureType.TRIGGER_CONFIG.getName(), localSensitivityInfoBean).g0(a.c);
      }
      return q.J(paramThrowable);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, Boolean>
    {
      public static final a c = new a();
      
      public final Boolean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return Boolean.TRUE;
      }
    }
  }
  
  static final class h
    implements io.reactivex.g0.a
  {
    h(SensorRepository paramSensorRepository, String paramString) {}
    
    public final void run()
    {
      SensorRepository.h4(this.a).postValue(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\SensorRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DoubleClickInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.BatteryDetectInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.SubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import kotlin.p;

public final class SwitchRepository
  extends AbstractSubThingRepository
{
  private boolean C = true;
  private final MutableLiveData<DelayActionInfoBean> D;
  private final LiveData<DelayActionInfoBean> E;
  private final MutableLiveData<DoubleClickInfoBean> F;
  private final LiveData<DoubleClickInfoBean> G;
  private final com.tplink.libtpnetwork.IoTNetwork.util.a H;
  private final LiveData<Integer> I;
  
  public SwitchRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTSubDevice.class, SubDeviceRunningInfoResult.class);
    Object localObject = new MutableLiveData();
    this.D = ((MutableLiveData)localObject);
    this.E = ((LiveData)localObject);
    localObject = new MutableLiveData();
    this.F = ((MutableLiveData)localObject);
    this.G = ((LiveData)localObject);
    localObject = new com.tplink.libtpnetwork.IoTNetwork.util.a();
    this.H = ((com.tplink.libtpnetwork.IoTNetwork.util.a)localObject);
    this.I = ((com.tplink.libtpnetwork.IoTNetwork.util.a)localObject).c();
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
  }
  
  private final void p4()
  {
    int i = this.H.d();
    if ((this.C) && (i >= 3)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      TPIoTClientManager localTPIoTClientManager = this.b;
      TPBaseDeviceContext localTPBaseDeviceContext = this.a;
      kotlin.jvm.internal.j.d(localTPBaseDeviceContext, "mThingContext");
      localTPIoTClientManager.J3(((ThingContext)localTPBaseDeviceContext).getIoTDevice());
    }
    else
    {
      this.b.a1();
    }
  }
  
  public io.reactivex.a i(boolean paramBoolean)
  {
    Object localObject = new DeviceInfoParams();
    ((DeviceInfoParams)localObject).setDeviceOn(Boolean.valueOf(paramBoolean));
    p localp = p.a;
    localObject = X3((DeviceInfoParams)localObject).f(this.H.b()).h(new g(this));
    kotlin.jvm.internal.j.d(localObject, "setDeviceShadow(DeviceIn…FailCount()\n            }");
    return (io.reactivex.a)localObject;
  }
  
  public final LiveData<Integer> j4()
  {
    return this.I;
  }
  
  public final q<DelayActionInfoBean> k4()
  {
    q localq = x0("get_delay_action_info", DelayActionInfoBean.class).o0(new a(this)).E(new b(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…stValue(it)\n            }");
    return localq;
  }
  
  public final LiveData<DelayActionInfoBean> l4()
  {
    return this.E;
  }
  
  public final q<DoubleClickInfoBean> m4()
  {
    q localq = x0("get_double_click_info", DoubleClickInfoBean.class).o0(new c(this)).E(new d(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…stValue(it)\n            }");
    return localq;
  }
  
  public final LiveData<DoubleClickInfoBean> n4()
  {
    return this.G;
  }
  
  public final boolean o4()
  {
    Object localObject1 = this.n;
    kotlin.jvm.internal.j.d(localObject1, "mDeviceInfoLiveData");
    localObject1 = ((LiveData)localObject1).getValue();
    boolean bool = localObject1 instanceof IoTSubDevice;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    localObject1 = (IoTSubDevice)localObject1;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((IoTSubDevice)localObject1).isAtLowBattery());
    }
    else
    {
      localObject1 = U0();
      kotlin.jvm.internal.j.d(localObject1, "batteryDetectInfoLiveData");
      BatteryDetectInfoResult localBatteryDetectInfoResult = (BatteryDetectInfoResult)((LiveData)localObject1).getValue();
      localObject1 = localObject2;
      if (localBatteryDetectInfoResult != null) {
        localObject1 = Boolean.valueOf(localBatteryDetectInfoResult.isLow());
      }
    }
    if (localObject1 != null) {
      bool = ((Boolean)localObject1).booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final io.reactivex.a q4(final DelayActionInfoBean paramDelayActionInfoBean)
  {
    kotlin.jvm.internal.j.e(paramDelayActionInfoBean, "info");
    paramDelayActionInfoBean = y0("set_delay_action_info", paramDelayActionInfoBean, Boolean.class).o0(new e(this, paramDelayActionInfoBean)).Z().i(new f(this, paramDelayActionInfoBean));
    kotlin.jvm.internal.j.d(paramDelayActionInfoBean, "postRequest(IoTNetworkDe…Value(info)\n            }");
    return paramDelayActionInfoBean;
  }
  
  public final io.reactivex.a r4(final DoubleClickInfoBean paramDoubleClickInfoBean)
  {
    kotlin.jvm.internal.j.e(paramDoubleClickInfoBean, "info");
    paramDoubleClickInfoBean = y0("set_double_click_info", paramDoubleClickInfoBean, Boolean.class).o0(new h(this, paramDoubleClickInfoBean)).Z().i(new i(this, paramDoubleClickInfoBean));
    kotlin.jvm.internal.j.d(paramDoubleClickInfoBean, "postRequest(IoTNetworkDe…Value(info)\n            }");
    return paramDoubleClickInfoBean;
  }
  
  public final void s4(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  static final class a<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends DelayActionInfoBean>>
  {
    a(SwitchRepository paramSwitchRepository) {}
    
    public final t<? extends DelayActionInfoBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.t(EnumFeatureType.ON_OFF_DELAY.getName()).g0(a.c);
      }
      return q.J(paramThrowable);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, DelayActionInfoBean>
    {
      public static final a c = new a();
      
      public final DelayActionInfoBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (DelayActionInfoBean)com.tplink.libtpnetwork.Utils.i.a(parami, DelayActionInfoBean.class);
      }
    }
  }
  
  static final class b<T>
    implements g<DelayActionInfoBean>
  {
    b(SwitchRepository paramSwitchRepository) {}
    
    public final void a(DelayActionInfoBean paramDelayActionInfoBean)
    {
      SwitchRepository.g4(this.c).postValue(paramDelayActionInfoBean);
    }
  }
  
  static final class c<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends DoubleClickInfoBean>>
  {
    c(SwitchRepository paramSwitchRepository) {}
    
    public final t<? extends DoubleClickInfoBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.t(EnumFeatureType.DOUBLE_CLICK_CONFIG.getName()).g0(a.c);
      }
      return q.J(paramThrowable);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, DoubleClickInfoBean>
    {
      public static final a c = new a();
      
      public final DoubleClickInfoBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (DoubleClickInfoBean)com.tplink.libtpnetwork.Utils.i.a(parami, DoubleClickInfoBean.class);
      }
    }
  }
  
  static final class d<T>
    implements g<DoubleClickInfoBean>
  {
    d(SwitchRepository paramSwitchRepository) {}
    
    public final void a(DoubleClickInfoBean paramDoubleClickInfoBean)
    {
      SwitchRepository.h4(this.c).postValue(paramDoubleClickInfoBean);
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    e(SwitchRepository paramSwitchRepository, DelayActionInfoBean paramDelayActionInfoBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.L0(EnumFeatureType.ON_OFF_DELAY.getName(), paramDelayActionInfoBean).g0(a.c);
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
    f(SwitchRepository paramSwitchRepository, DelayActionInfoBean paramDelayActionInfoBean) {}
    
    public final void run()
    {
      SwitchRepository.g4(this.a).postValue(paramDelayActionInfoBean);
    }
  }
  
  static final class g
    implements io.reactivex.g0.a
  {
    g(SwitchRepository paramSwitchRepository) {}
    
    public final void run()
    {
      SwitchRepository.i4(this.a);
    }
  }
  
  static final class h<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    h(SwitchRepository paramSwitchRepository, DoubleClickInfoBean paramDoubleClickInfoBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.L0(EnumFeatureType.DOUBLE_CLICK_CONFIG.getName(), paramDoubleClickInfoBean).g0(a.c);
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
  
  static final class i
    implements io.reactivex.g0.a
  {
    i(SwitchRepository paramSwitchRepository, DoubleClickInfoBean paramDoubleClickInfoBean) {}
    
    public final void run()
    {
      SwitchRepository.h4(this.a).postValue(paramDoubleClickInfoBean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\SwitchRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
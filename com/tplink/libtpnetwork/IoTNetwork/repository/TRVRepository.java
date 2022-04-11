package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.k;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ThingServiceExecResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.SubDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.SubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.RemoveScaleInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ShutdownInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.TRVEarlyStartBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.WindowOpenDetectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureOffsetParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureRangeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureUnitParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.ProgressCalibrationInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.RemoveScaleStatusResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVTemperatureRecordsResult;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import com.tplink.libtpnetwork.enumerate.EnumTRVState.a;
import io.reactivex.e;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.l;

public final class TRVRepository
  extends AbstractSubThingRepository
{
  private final MutableLiveData<TRVEarlyStartBean> C = new MutableLiveData();
  private final MutableLiveData<ChildProtectionBean> D = new MutableLiveData();
  private final MutableLiveData<FrostProtectionBean> E = new MutableLiveData();
  private final MutableLiveData<ShutdownInfoBean> F = new MutableLiveData();
  private final MutableLiveData<TRVTemperatureRecordsResult> G = new MutableLiveData();
  private final MutableLiveData<WindowOpenDetectionBean> H = new MutableLiveData();
  private final MutableLiveData<RemoveScaleInfoBean> I;
  private final LiveData<RemoveScaleInfoBean> J;
  private final MutableLiveData<RemoveScaleStatusResult> K;
  private final LiveData<RemoveScaleStatusResult> L;
  private final MutableLiveData<ProgressCalibrationInfoResult> M;
  private final LiveData<ProgressCalibrationInfoResult> N;
  
  public TRVRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTSubDevice.class, SubDeviceRunningInfoResult.class);
    paramThingContext = new MutableLiveData();
    this.I = paramThingContext;
    this.J = paramThingContext;
    paramThingContext = new MutableLiveData();
    this.K = paramThingContext;
    this.L = paramThingContext;
    paramThingContext = new MutableLiveData();
    this.M = paramThingContext;
    this.N = paramThingContext;
  }
  
  private final List<EnumTRVState> J4(ThingShadowResult paramThingShadowResult)
  {
    paramThingShadowResult = paramThingShadowResult.getState();
    Object localObject1 = null;
    if (paramThingShadowResult != null)
    {
      paramThingShadowResult = paramThingShadowResult.getReported();
      if (paramThingShadowResult != null)
      {
        paramThingShadowResult = paramThingShadowResult.get("trv_states");
        break label34;
      }
    }
    paramThingShadowResult = null;
    label34:
    if (!(paramThingShadowResult instanceof ArrayList)) {
      paramThingShadowResult = (ThingShadowResult)localObject1;
    }
    localObject1 = (ArrayList)paramThingShadowResult;
    if (localObject1 != null)
    {
      paramThingShadowResult = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof String))
        {
          localObject2 = EnumTRVState.Companion.a((String)localObject2);
          if (localObject2 != null) {
            paramThingShadowResult.add(localObject2);
          }
        }
      }
      return paramThingShadowResult;
    }
    return l.d();
  }
  
  public final q<RemoveScaleStatusResult> A4()
  {
    q localq = x0("get_remove_scale_status", RemoveScaleStatusResult.class).o0(new k(this)).E(new l(this)).C(new m(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…tusResult.STATUS_IDLE)) }");
    return localq;
  }
  
  public final LiveData<RemoveScaleStatusResult> B4()
  {
    return this.L;
  }
  
  public final q<ShutdownInfoBean> C4()
  {
    q localq = x0("get_shutdown_info", ShutdownInfoBean.class).o0(new n(this)).E(new o(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…oLiveData.postValue(it) }");
    return localq;
  }
  
  public final LiveData<ShutdownInfoBean> D4()
  {
    return this.F;
  }
  
  public final q<TRVTemperatureRecordsResult> E4()
  {
    q localq = x0("get_temperature_records", TRVTemperatureRecordsResult.class).o0(new p(this)).E(new q(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…sLiveData.postValue(it) }");
    return localq;
  }
  
  public final LiveData<TRVTemperatureRecordsResult> F4()
  {
    return this.G;
  }
  
  public final q<WindowOpenDetectionBean> G4()
  {
    q localq = x0("get_window_open_detection", WindowOpenDetectionBean.class).o0(new r(this)).E(new s(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…oLiveData.postValue(it) }");
    return localq;
  }
  
  public final LiveData<WindowOpenDetectionBean> H4()
  {
    return this.H;
  }
  
  public final io.reactivex.a I4()
  {
    io.reactivex.a locala = y0("remove_scale", null, Boolean.class).o0(new t(this)).Z().j(new u(this));
    kotlin.jvm.internal.j.d(locala, "postRequest(IoTNetworkDe…:postValue)\n            }");
    return locala;
  }
  
  public final io.reactivex.a K4(final ChildProtectionBean paramChildProtectionBean)
  {
    kotlin.jvm.internal.j.e(paramChildProtectionBean, "params");
    final ChildProtectionBean localChildProtectionBean = (ChildProtectionBean)this.D.getValue();
    paramChildProtectionBean = y0("set_child_protection", paramChildProtectionBean, Boolean.class).o0(new v(this, paramChildProtectionBean)).F(new w(this, paramChildProtectionBean)).C(new x(this, localChildProtectionBean)).Z();
    kotlin.jvm.internal.j.d(paramChildProtectionBean, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramChildProtectionBean;
  }
  
  public final io.reactivex.a L4(SubDeviceInfoParams paramSubDeviceInfoParams)
  {
    kotlin.jvm.internal.j.e(paramSubDeviceInfoParams, "params");
    paramSubDeviceInfoParams = X3(paramSubDeviceInfoParams);
    kotlin.jvm.internal.j.d(paramSubDeviceInfoParams, "setDeviceShadow(params)");
    return paramSubDeviceInfoParams;
  }
  
  public final io.reactivex.a M4(final TRVEarlyStartBean paramTRVEarlyStartBean)
  {
    kotlin.jvm.internal.j.e(paramTRVEarlyStartBean, "params");
    final TRVEarlyStartBean localTRVEarlyStartBean = (TRVEarlyStartBean)this.C.getValue();
    paramTRVEarlyStartBean = y0("set_early_start", paramTRVEarlyStartBean, Boolean.class).o0(new y(this, paramTRVEarlyStartBean)).F(new z(this, paramTRVEarlyStartBean)).C(new a0(this, localTRVEarlyStartBean)).Z();
    kotlin.jvm.internal.j.d(paramTRVEarlyStartBean, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramTRVEarlyStartBean;
  }
  
  public final io.reactivex.a N4(final FrostProtectionBean paramFrostProtectionBean)
  {
    kotlin.jvm.internal.j.e(paramFrostProtectionBean, "params");
    final FrostProtectionBean localFrostProtectionBean = (FrostProtectionBean)this.E.getValue();
    paramFrostProtectionBean = y0("set_frost_protection", paramFrostProtectionBean, Boolean.class).o0(new b0(this, paramFrostProtectionBean)).F(new c0(this, paramFrostProtectionBean)).C(new d0(this, localFrostProtectionBean)).Z();
    kotlin.jvm.internal.j.d(paramFrostProtectionBean, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramFrostProtectionBean;
  }
  
  public final io.reactivex.a O4(final RemoveScaleInfoBean paramRemoveScaleInfoBean)
  {
    kotlin.jvm.internal.j.e(paramRemoveScaleInfoBean, "params");
    final RemoveScaleInfoBean localRemoveScaleInfoBean = (RemoveScaleInfoBean)this.I.getValue();
    paramRemoveScaleInfoBean = y0("set_remove_scale_info", paramRemoveScaleInfoBean, Boolean.class).o0(new e0(this, paramRemoveScaleInfoBean)).Z().l(new f0(this, paramRemoveScaleInfoBean)).j(new g0(this, localRemoveScaleInfoBean));
    kotlin.jvm.internal.j.d(paramRemoveScaleInfoBean, "postRequest(IoTNetworkDe…nfoLiveData::postValue) }");
    return paramRemoveScaleInfoBean;
  }
  
  public final io.reactivex.a P4(final ShutdownInfoBean paramShutdownInfoBean)
  {
    kotlin.jvm.internal.j.e(paramShutdownInfoBean, "params");
    final ShutdownInfoBean localShutdownInfoBean = (ShutdownInfoBean)this.F.getValue();
    paramShutdownInfoBean = y0("set_shutdown_info", paramShutdownInfoBean, Boolean.class).o0(new h0(this, paramShutdownInfoBean)).F(new i0(this, paramShutdownInfoBean)).z(new j0(this, paramShutdownInfoBean)).C(new k0(this, localShutdownInfoBean)).Z();
    kotlin.jvm.internal.j.d(paramShutdownInfoBean, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramShutdownInfoBean;
  }
  
  public final io.reactivex.a Q4(TemperatureOffsetParams paramTemperatureOffsetParams)
  {
    kotlin.jvm.internal.j.e(paramTemperatureOffsetParams, "params");
    final SubDeviceInfoParams localSubDeviceInfoParams = new SubDeviceInfoParams();
    localSubDeviceInfoParams.setTempUnit(paramTemperatureOffsetParams.getTempUnit());
    localSubDeviceInfoParams.setTempOffset(Integer.valueOf(paramTemperatureOffsetParams.getOffset()));
    paramTemperatureOffsetParams = y0("set_temperature_offset", paramTemperatureOffsetParams, Boolean.class).Z().u(new l0(this, localSubDeviceInfoParams)).i(new m0(this, localSubDeviceInfoParams));
    kotlin.jvm.internal.j.d(paramTemperatureOffsetParams, "postRequest(IoTNetworkDe…InfoParams)\n            }");
    return paramTemperatureOffsetParams;
  }
  
  public final io.reactivex.a R4(TemperatureRangeParams paramTemperatureRangeParams)
  {
    kotlin.jvm.internal.j.e(paramTemperatureRangeParams, "params");
    final SubDeviceInfoParams localSubDeviceInfoParams = new SubDeviceInfoParams();
    localSubDeviceInfoParams.setTempUnit(paramTemperatureRangeParams.getTempUnit());
    localSubDeviceInfoParams.setMinControlTemp(Integer.valueOf(paramTemperatureRangeParams.getMinControlTemp()));
    localSubDeviceInfoParams.setMaxControlTemp(Integer.valueOf(paramTemperatureRangeParams.getMaxControlTemp()));
    paramTemperatureRangeParams = y0("set_temperature_range", paramTemperatureRangeParams, Boolean.class).Z().u(new n0(this, localSubDeviceInfoParams)).i(new o0(this, localSubDeviceInfoParams));
    kotlin.jvm.internal.j.d(paramTemperatureRangeParams, "postRequest(IoTNetworkDe…InfoParams)\n            }");
    return paramTemperatureRangeParams;
  }
  
  public final io.reactivex.a S4(TemperatureUnitParams paramTemperatureUnitParams)
  {
    kotlin.jvm.internal.j.e(paramTemperatureUnitParams, "params");
    final SubDeviceInfoParams localSubDeviceInfoParams = new SubDeviceInfoParams();
    localSubDeviceInfoParams.setTempUnit(paramTemperatureUnitParams.getTempUnit());
    paramTemperatureUnitParams = y0("set_temperature_unit", paramTemperatureUnitParams, Boolean.class).Z().u(new p0(this, localSubDeviceInfoParams)).l(new q0(this, localSubDeviceInfoParams)).j(new r0(this));
    kotlin.jvm.internal.j.d(paramTemperatureUnitParams, "postRequest(IoTNetworkDe…lbackDeviceInfoData(it) }");
    return paramTemperatureUnitParams;
  }
  
  public final io.reactivex.a T4(final WindowOpenDetectionBean paramWindowOpenDetectionBean)
  {
    kotlin.jvm.internal.j.e(paramWindowOpenDetectionBean, "params");
    final WindowOpenDetectionBean localWindowOpenDetectionBean = (WindowOpenDetectionBean)this.H.getValue();
    paramWindowOpenDetectionBean = y0("set_window_open_detection", paramWindowOpenDetectionBean, Boolean.class).o0(new s0(this, paramWindowOpenDetectionBean)).F(new t0(this, paramWindowOpenDetectionBean)).C(new u0(this, localWindowOpenDetectionBean)).Z();
    kotlin.jvm.internal.j.d(paramWindowOpenDetectionBean, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return paramWindowOpenDetectionBean;
  }
  
  public final io.reactivex.a U4()
  {
    io.reactivex.a locala = y0("progress_calibration", null, Boolean.class).o0(new v0(this)).z(new w0(this)).Z();
    kotlin.jvm.internal.j.d(locala, "postRequest(IoTNetworkDe…        .ignoreElements()");
    return locala;
  }
  
  public final q<ChildProtectionBean> r4()
  {
    q localq = x0("get_child_protection", ChildProtectionBean.class).o0(new a(this)).E(new b(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…nLiveData.postValue(it) }");
    return localq;
  }
  
  public final LiveData<ChildProtectionBean> s4()
  {
    return this.D;
  }
  
  public final q<TRVEarlyStartBean> t4()
  {
    q localq = x0("get_early_start", TRVEarlyStartBean.class).o0(new c(this)).E(new d(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…tLiveData.postValue(it) }");
    return localq;
  }
  
  public final LiveData<TRVEarlyStartBean> u4()
  {
    return this.C;
  }
  
  public final q<FrostProtectionBean> v4()
  {
    q localq = x0("get_frost_protection", FrostProtectionBean.class).o0(new e(this)).E(new f(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…nLiveData.postValue(it) }");
    return localq;
  }
  
  public final LiveData<FrostProtectionBean> w4()
  {
    return this.E;
  }
  
  public final q<ProgressCalibrationInfoResult> x4()
  {
    q localq = x0("get_progress_calibration_info", ProgressCalibrationInfoResult.class).N(new g(this)).o0(new h(this)).E(new i(this)).C(new j(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…nfoResult.STATUS_IDLE)) }");
    return localq;
  }
  
  public final LiveData<ProgressCalibrationInfoResult> y4()
  {
    return this.N;
  }
  
  public final LiveData<RemoveScaleInfoBean> z4()
  {
    return this.J;
  }
  
  static final class a<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends ChildProtectionBean>>
  {
    a(TRVRepository paramTRVRepository) {}
    
    public final t<? extends ChildProtectionBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.t(EnumFeatureType.CHILD_PROTECTION_MODE.getValue()).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, ChildProtectionBean>
    {
      public static final a c = new a();
      
      public final ChildProtectionBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (ChildProtectionBean)com.tplink.libtpnetwork.Utils.i.a(parami, ChildProtectionBean.class);
      }
    }
  }
  
  static final class a0<T>
    implements g<Throwable>
  {
    a0(TRVRepository paramTRVRepository, TRVEarlyStartBean paramTRVEarlyStartBean) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = localTRVEarlyStartBean;
      if (paramThrowable != null) {
        TRVRepository.h4(this.c).postValue(paramThrowable);
      }
    }
  }
  
  static final class b<T>
    implements g<ChildProtectionBean>
  {
    b(TRVRepository paramTRVRepository) {}
    
    public final void a(ChildProtectionBean paramChildProtectionBean)
    {
      TRVRepository.g4(this.c).postValue(paramChildProtectionBean);
    }
  }
  
  static final class b0<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    b0(TRVRepository paramTRVRepository, FrostProtectionBean paramFrostProtectionBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L0(EnumFeatureType.FROST_PROTECTION_CONFIG.getValue(), paramFrostProtectionBean).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
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
  
  static final class c<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends TRVEarlyStartBean>>
  {
    c(TRVRepository paramTRVRepository) {}
    
    public final t<? extends TRVEarlyStartBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.t(EnumFeatureType.EARLY_START.getValue()).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, TRVEarlyStartBean>
    {
      public static final a c = new a();
      
      public final TRVEarlyStartBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (TRVEarlyStartBean)com.tplink.libtpnetwork.Utils.i.a(parami, TRVEarlyStartBean.class);
      }
    }
  }
  
  static final class c0<T>
    implements g<c>
  {
    c0(TRVRepository paramTRVRepository, FrostProtectionBean paramFrostProtectionBean) {}
    
    public final void a(c paramc)
    {
      TRVRepository.i4(this.c).postValue(paramFrostProtectionBean);
    }
  }
  
  static final class d<T>
    implements g<TRVEarlyStartBean>
  {
    d(TRVRepository paramTRVRepository) {}
    
    public final void a(TRVEarlyStartBean paramTRVEarlyStartBean)
    {
      TRVRepository.h4(this.c).postValue(paramTRVEarlyStartBean);
    }
  }
  
  static final class d0<T>
    implements g<Throwable>
  {
    d0(TRVRepository paramTRVRepository, FrostProtectionBean paramFrostProtectionBean) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = localFrostProtectionBean;
      if (paramThrowable != null) {
        TRVRepository.i4(this.c).postValue(paramThrowable);
      }
    }
  }
  
  static final class e<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends FrostProtectionBean>>
  {
    e(TRVRepository paramTRVRepository) {}
    
    public final t<? extends FrostProtectionBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.t(EnumFeatureType.FROST_PROTECTION_CONFIG.getValue()).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, FrostProtectionBean>
    {
      public static final a c = new a();
      
      public final FrostProtectionBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (FrostProtectionBean)com.tplink.libtpnetwork.Utils.i.a(parami, FrostProtectionBean.class);
      }
    }
  }
  
  static final class e0<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    e0(TRVRepository paramTRVRepository, RemoveScaleInfoBean paramRemoveScaleInfoBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L0(EnumFeatureType.AUTO_REMOVE_SCALE.getValue(), paramRemoveScaleInfoBean).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
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
  
  static final class f<T>
    implements g<FrostProtectionBean>
  {
    f(TRVRepository paramTRVRepository) {}
    
    public final void a(FrostProtectionBean paramFrostProtectionBean)
    {
      TRVRepository.i4(this.c).postValue(paramFrostProtectionBean);
    }
  }
  
  static final class f0<T>
    implements g<c>
  {
    f0(TRVRepository paramTRVRepository, RemoveScaleInfoBean paramRemoveScaleInfoBean) {}
    
    public final void a(c paramc)
    {
      TRVRepository.k4(this.c).postValue(paramRemoveScaleInfoBean);
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<ProgressCalibrationInfoResult, t<? extends ProgressCalibrationInfoResult>>
  {
    g(TRVRepository paramTRVRepository) {}
    
    public final t<? extends ProgressCalibrationInfoResult> a(ProgressCalibrationInfoResult paramProgressCalibrationInfoResult)
    {
      kotlin.jvm.internal.j.e(paramProgressCalibrationInfoResult, "progressCalibrationInfo");
      if (paramProgressCalibrationInfoResult.getStatus() == 0) {
        paramProgressCalibrationInfoResult = this.c.Z0().g0(new a(paramProgressCalibrationInfoResult)).q0(paramProgressCalibrationInfoResult);
      } else {
        paramProgressCalibrationInfoResult = q.f0(paramProgressCalibrationInfoResult);
      }
      return paramProgressCalibrationInfoResult;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<DeviceRunningInfoResult, ProgressCalibrationInfoResult>
    {
      a(ProgressCalibrationInfoResult paramProgressCalibrationInfoResult) {}
      
      public final ProgressCalibrationInfoResult a(DeviceRunningInfoResult paramDeviceRunningInfoResult)
      {
        kotlin.jvm.internal.j.e(paramDeviceRunningInfoResult, "it");
        int i = this.c.getStatus();
        int j = i;
        if ((paramDeviceRunningInfoResult instanceof SubDeviceRunningInfoResult))
        {
          paramDeviceRunningInfoResult = ((SubDeviceRunningInfoResult)paramDeviceRunningInfoResult).getTrvStates();
          j = i;
          if (paramDeviceRunningInfoResult != null)
          {
            j = i;
            if (paramDeviceRunningInfoResult.contains(EnumTRVState.DEVICE_ERROR) == true) {
              j = -1;
            }
          }
        }
        return new ProgressCalibrationInfoResult(j);
      }
    }
  }
  
  static final class g0<T>
    implements g<Throwable>
  {
    g0(TRVRepository paramTRVRepository, RemoveScaleInfoBean paramRemoveScaleInfoBean) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = localRemoveScaleInfoBean;
      if (paramThrowable != null) {
        TRVRepository.k4(this.c).postValue(paramThrowable);
      }
    }
  }
  
  static final class h<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends ProgressCalibrationInfoResult>>
  {
    h(TRVRepository paramTRVRepository) {}
    
    public final t<? extends ProgressCalibrationInfoResult> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = this.c;
        ThingContext localThingContext = TRVRepository.o4(paramThrowable);
        kotlin.jvm.internal.j.d(localThingContext, "mThingContext");
        String str = localThingContext.getThingUrl();
        localThingContext = TRVRepository.o4(this.c);
        kotlin.jvm.internal.j.d(localThingContext, "mThingContext");
        paramThrowable = paramThrowable.C(str, localThingContext.getThingName()).g0(new a(this));
      }
      else
      {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<ThingShadowResult, ProgressCalibrationInfoResult>
    {
      a(TRVRepository.h paramh) {}
      
      public final ProgressCalibrationInfoResult a(ThingShadowResult paramThingShadowResult)
      {
        kotlin.jvm.internal.j.e(paramThingShadowResult, "it");
        paramThingShadowResult = TRVRepository.q4(this.c.c, paramThingShadowResult);
        int i;
        if (paramThingShadowResult.contains(EnumTRVState.PROGRESS_CALIBRATION)) {
          i = 1;
        } else if (paramThingShadowResult.contains(EnumTRVState.DEVICE_ERROR)) {
          i = -1;
        } else {
          i = 0;
        }
        return new ProgressCalibrationInfoResult(i);
      }
    }
  }
  
  static final class h0<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    h0(TRVRepository paramTRVRepository, ShutdownInfoBean paramShutdownInfoBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L0(EnumFeatureType.SHUTDOWN_MODE.getValue(), paramShutdownInfoBean).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
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
  
  static final class i<T>
    implements g<ProgressCalibrationInfoResult>
  {
    i(TRVRepository paramTRVRepository) {}
    
    public final void a(ProgressCalibrationInfoResult paramProgressCalibrationInfoResult)
    {
      TRVRepository.j4(this.c).postValue(paramProgressCalibrationInfoResult);
    }
  }
  
  static final class i0<T>
    implements g<c>
  {
    i0(TRVRepository paramTRVRepository, ShutdownInfoBean paramShutdownInfoBean) {}
    
    public final void a(c paramc)
    {
      TRVRepository.m4(this.c).postValue(paramShutdownInfoBean);
    }
  }
  
  static final class j<T>
    implements g<Throwable>
  {
    j(TRVRepository paramTRVRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      TRVRepository.j4(this.c).postValue(new ProgressCalibrationInfoResult(0));
    }
  }
  
  static final class j0
    implements io.reactivex.g0.a
  {
    j0(TRVRepository paramTRVRepository, ShutdownInfoBean paramShutdownInfoBean) {}
    
    public final void run()
    {
      TRVRepository.m4(this.a).postValue(paramShutdownInfoBean);
    }
  }
  
  static final class k<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends RemoveScaleStatusResult>>
  {
    k(TRVRepository paramTRVRepository) {}
    
    public final t<? extends RemoveScaleStatusResult> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = this.c;
        Object localObject = TRVRepository.o4(paramThrowable);
        kotlin.jvm.internal.j.d(localObject, "mThingContext");
        localObject = ((ThingContext)localObject).getThingUrl();
        ThingContext localThingContext = TRVRepository.o4(this.c);
        kotlin.jvm.internal.j.d(localThingContext, "mThingContext");
        paramThrowable = paramThrowable.C((String)localObject, localThingContext.getThingName()).g0(new a(this));
      }
      else
      {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<ThingShadowResult, RemoveScaleStatusResult>
    {
      a(TRVRepository.k paramk) {}
      
      public final RemoveScaleStatusResult a(ThingShadowResult paramThingShadowResult)
      {
        kotlin.jvm.internal.j.e(paramThingShadowResult, "it");
        return new RemoveScaleStatusResult(TRVRepository.q4(this.c.c, paramThingShadowResult).contains(EnumTRVState.REMOVING_SCALE));
      }
    }
  }
  
  static final class k0<T>
    implements g<Throwable>
  {
    k0(TRVRepository paramTRVRepository, ShutdownInfoBean paramShutdownInfoBean) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = localShutdownInfoBean;
      if (paramThrowable != null) {
        TRVRepository.m4(this.c).postValue(paramThrowable);
      }
    }
  }
  
  static final class l<T>
    implements g<RemoveScaleStatusResult>
  {
    l(TRVRepository paramTRVRepository) {}
    
    public final void a(RemoveScaleStatusResult paramRemoveScaleStatusResult)
    {
      TRVRepository.l4(this.c).postValue(paramRemoveScaleStatusResult);
    }
  }
  
  static final class l0<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    l0(TRVRepository paramTRVRepository, SubDeviceInfoParams paramSubDeviceInfoParams) {}
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = this.c;
        paramThrowable = paramThrowable.h.B(paramThrowable.o(localSubDeviceInfoParams));
      }
      else
      {
        paramThrowable = io.reactivex.a.m(paramThrowable);
      }
      return paramThrowable;
    }
  }
  
  static final class m<T>
    implements g<Throwable>
  {
    m(TRVRepository paramTRVRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      TRVRepository.l4(this.c).postValue(new RemoveScaleStatusResult(0));
    }
  }
  
  static final class m0
    implements io.reactivex.g0.a
  {
    m0(TRVRepository paramTRVRepository, SubDeviceInfoParams paramSubDeviceInfoParams) {}
    
    public final void run()
    {
      this.a.R3(localSubDeviceInfoParams);
    }
  }
  
  static final class n<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends ShutdownInfoBean>>
  {
    n(TRVRepository paramTRVRepository) {}
    
    public final t<? extends ShutdownInfoBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.t(EnumFeatureType.SHUTDOWN_MODE.getValue()).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, ShutdownInfoBean>
    {
      public static final a c = new a();
      
      public final ShutdownInfoBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (ShutdownInfoBean)com.tplink.libtpnetwork.Utils.i.a(parami, ShutdownInfoBean.class);
      }
    }
  }
  
  static final class n0<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    n0(TRVRepository paramTRVRepository, SubDeviceInfoParams paramSubDeviceInfoParams) {}
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = this.c;
        paramThrowable = paramThrowable.h.B(paramThrowable.o(localSubDeviceInfoParams));
      }
      else
      {
        paramThrowable = io.reactivex.a.m(paramThrowable);
      }
      return paramThrowable;
    }
  }
  
  static final class o<T>
    implements g<ShutdownInfoBean>
  {
    o(TRVRepository paramTRVRepository) {}
    
    public final void a(ShutdownInfoBean paramShutdownInfoBean)
    {
      TRVRepository.m4(this.c).postValue(paramShutdownInfoBean);
    }
  }
  
  static final class o0
    implements io.reactivex.g0.a
  {
    o0(TRVRepository paramTRVRepository, SubDeviceInfoParams paramSubDeviceInfoParams) {}
    
    public final void run()
    {
      this.a.R3(localSubDeviceInfoParams);
    }
  }
  
  static final class p<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends TRVTemperatureRecordsResult>>
  {
    p(TRVRepository paramTRVRepository) {}
    
    public final t<? extends TRVTemperatureRecordsResult> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        Object localObject = this.c;
        paramThrowable = ((ThingBaseRepository)localObject).d;
        localObject = TRVRepository.o4((TRVRepository)localObject);
        kotlin.jvm.internal.j.d(localObject, "mThingContext");
        localObject = ((ThingContext)localObject).getThingUrl();
        ThingContext localThingContext = TRVRepository.o4(this.c);
        kotlin.jvm.internal.j.d(localThingContext, "mThingContext");
        paramThrowable = paramThrowable.v0((String)localObject, localThingContext.getThingName()).N(a.c);
      }
      else
      {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<ThingUsage, t<? extends TRVTemperatureRecordsResult>>
    {
      public static final a c = new a();
      
      public final t<? extends TRVTemperatureRecordsResult> a(ThingUsage paramThingUsage)
      {
        kotlin.jvm.internal.j.e(paramThingUsage, "it");
        if (paramThingUsage.getTemperatureRecords() != null)
        {
          paramThingUsage = paramThingUsage.getTemperatureRecords();
          kotlin.jvm.internal.j.d(paramThingUsage, "it.temperatureRecords");
          paramThingUsage = q.f0(new TRVTemperatureRecordsResult(paramThingUsage));
        }
        else
        {
          paramThingUsage = q.J(new Throwable("Temperature Records is null."));
        }
        return paramThingUsage;
      }
    }
  }
  
  static final class p0<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    p0(TRVRepository paramTRVRepository, SubDeviceInfoParams paramSubDeviceInfoParams) {}
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = this.c;
        paramThrowable = paramThrowable.h.B(paramThrowable.o(localSubDeviceInfoParams));
      }
      else
      {
        paramThrowable = io.reactivex.a.m(paramThrowable);
      }
      return paramThrowable;
    }
  }
  
  static final class q<T>
    implements g<TRVTemperatureRecordsResult>
  {
    q(TRVRepository paramTRVRepository) {}
    
    public final void a(TRVTemperatureRecordsResult paramTRVTemperatureRecordsResult)
    {
      TRVRepository.n4(this.c).postValue(paramTRVTemperatureRecordsResult);
    }
  }
  
  static final class q0<T>
    implements g<c>
  {
    q0(TRVRepository paramTRVRepository, SubDeviceInfoParams paramSubDeviceInfoParams) {}
    
    public final void a(c paramc)
    {
      this.c.R3(localSubDeviceInfoParams);
    }
  }
  
  static final class r<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends WindowOpenDetectionBean>>
  {
    r(TRVRepository paramTRVRepository) {}
    
    public final t<? extends WindowOpenDetectionBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.t(EnumFeatureType.WINDOW_OPEN_DETECTION.getValue()).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, WindowOpenDetectionBean>
    {
      public static final a c = new a();
      
      public final WindowOpenDetectionBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (WindowOpenDetectionBean)com.tplink.libtpnetwork.Utils.i.a(parami, WindowOpenDetectionBean.class);
      }
    }
  }
  
  static final class r0<T>
    implements g<Throwable>
  {
    r0(TRVRepository paramTRVRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.S3(paramThrowable);
    }
  }
  
  static final class s<T>
    implements g<WindowOpenDetectionBean>
  {
    s(TRVRepository paramTRVRepository) {}
    
    public final void a(WindowOpenDetectionBean paramWindowOpenDetectionBean)
    {
      TRVRepository.p4(this.c).postValue(paramWindowOpenDetectionBean);
    }
  }
  
  static final class s0<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    s0(TRVRepository paramTRVRepository, WindowOpenDetectionBean paramWindowOpenDetectionBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L0(EnumFeatureType.WINDOW_OPEN_DETECTION.getValue(), paramWindowOpenDetectionBean).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
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
  
  static final class t<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    t(TRVRepository paramTRVRepository) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = new ThingServiceParams("removeScale", new k());
        Object localObject1 = this.c;
        ThingCloudRepository localThingCloudRepository = ((ThingBaseRepository)localObject1).d;
        localObject1 = TRVRepository.o4((TRVRepository)localObject1);
        kotlin.jvm.internal.j.d(localObject1, "mThingContext");
        localObject1 = ((ThingContext)localObject1).getThingUrl();
        Object localObject2 = TRVRepository.o4(this.c);
        kotlin.jvm.internal.j.d(localObject2, "mThingContext");
        localObject2 = ((ThingContext)localObject2).getThingName();
        ThingContext localThingContext = TRVRepository.o4(this.c);
        kotlin.jvm.internal.j.d(localThingContext, "mThingContext");
        paramThrowable = localThingCloudRepository.P((String)localObject1, (String)localObject2, localThingContext.getThingGatewayUrlV2(), paramThrowable).g0(a.c);
      }
      else
      {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<ThingServiceExecResult, Boolean>
    {
      public static final a c = new a();
      
      public final Boolean a(ThingServiceExecResult paramThingServiceExecResult)
      {
        kotlin.jvm.internal.j.e(paramThingServiceExecResult, "it");
        return Boolean.TRUE;
      }
    }
  }
  
  static final class t0<T>
    implements g<c>
  {
    t0(TRVRepository paramTRVRepository, WindowOpenDetectionBean paramWindowOpenDetectionBean) {}
    
    public final void a(c paramc)
    {
      TRVRepository.p4(this.c).postValue(paramWindowOpenDetectionBean);
    }
  }
  
  static final class u<T>
    implements g<Throwable>
  {
    u(TRVRepository paramTRVRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = (RemoveScaleStatusResult)TRVRepository.l4(this.c).getValue();
      if (paramThrowable != null)
      {
        paramThrowable = paramThrowable.copy(0);
        if (paramThrowable != null) {
          TRVRepository.l4(this.c).postValue(paramThrowable);
        }
      }
    }
  }
  
  static final class u0<T>
    implements g<Throwable>
  {
    u0(TRVRepository paramTRVRepository, WindowOpenDetectionBean paramWindowOpenDetectionBean) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = localWindowOpenDetectionBean;
      if (paramThrowable != null) {
        TRVRepository.p4(this.c).postValue(paramThrowable);
      }
    }
  }
  
  static final class v<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    v(TRVRepository paramTRVRepository, ChildProtectionBean paramChildProtectionBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L0(EnumFeatureType.CHILD_PROTECTION_MODE.getValue(), paramChildProtectionBean).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
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
  
  static final class v0<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    v0(TRVRepository paramTRVRepository) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = new ThingServiceParams("progressCalibration", new k());
        Object localObject1 = this.c;
        ThingCloudRepository localThingCloudRepository = ((ThingBaseRepository)localObject1).d;
        localObject1 = TRVRepository.o4((TRVRepository)localObject1);
        kotlin.jvm.internal.j.d(localObject1, "mThingContext");
        localObject1 = ((ThingContext)localObject1).getThingUrl();
        Object localObject2 = TRVRepository.o4(this.c);
        kotlin.jvm.internal.j.d(localObject2, "mThingContext");
        localObject2 = ((ThingContext)localObject2).getThingName();
        ThingContext localThingContext = TRVRepository.o4(this.c);
        kotlin.jvm.internal.j.d(localThingContext, "mThingContext");
        paramThrowable = localThingCloudRepository.P((String)localObject1, (String)localObject2, localThingContext.getThingGatewayUrlV2(), paramThrowable).g0(a.c);
      }
      else
      {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<ThingServiceExecResult, Boolean>
    {
      public static final a c = new a();
      
      public final Boolean a(ThingServiceExecResult paramThingServiceExecResult)
      {
        kotlin.jvm.internal.j.e(paramThingServiceExecResult, "it");
        return Boolean.TRUE;
      }
    }
  }
  
  static final class w<T>
    implements g<c>
  {
    w(TRVRepository paramTRVRepository, ChildProtectionBean paramChildProtectionBean) {}
    
    public final void a(c paramc)
    {
      TRVRepository.g4(this.c).postValue(paramChildProtectionBean);
    }
  }
  
  static final class w0
    implements io.reactivex.g0.a
  {
    w0(TRVRepository paramTRVRepository) {}
    
    public final void run()
    {
      TRVRepository.j4(this.a).postValue(new ProgressCalibrationInfoResult(1));
    }
  }
  
  static final class x<T>
    implements g<Throwable>
  {
    x(TRVRepository paramTRVRepository, ChildProtectionBean paramChildProtectionBean) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = localChildProtectionBean;
      if (paramThrowable != null) {
        TRVRepository.g4(this.c).postValue(paramThrowable);
      }
    }
  }
  
  static final class y<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    y(TRVRepository paramTRVRepository, TRVEarlyStartBean paramTRVEarlyStartBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L0(EnumFeatureType.EARLY_START.getValue(), paramTRVEarlyStartBean).g0(a.c);
      } else {
        paramThrowable = q.J(paramThrowable);
      }
      return paramThrowable;
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
  
  static final class z<T>
    implements g<c>
  {
    z(TRVRepository paramTRVRepository, TRVEarlyStartBean paramTRVEarlyStartBean) {}
    
    public final void a(c paramc)
    {
      TRVRepository.h4(this.c).postValue(paramTRVEarlyStartBean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\TRVRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
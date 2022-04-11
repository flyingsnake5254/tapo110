package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean.PresetBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.DeviceSegmentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightStripDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.result.LightStripDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import io.reactivex.e;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.p;

public final class LightStripRepository
  extends AbstractThingRepository
{
  public static final b C = new b(null);
  private final MutableLiveData<OnOffGraduallyBean> D;
  private final LiveData<OnOffGraduallyBean> E;
  private final MutableLiveData<Integer> F;
  private final LiveData<Integer> G;
  private final MediatorLiveData<LightingEffectData> H;
  private final MutableLiveData<BrightnessPresetsBean> I;
  private final LiveData<BrightnessPresetsBean> J;
  private final LiveData<List<LightStateBean>> K;
  
  public LightStripRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTLightStripDevice.class, LightStripDeviceRunningInfoResult.class);
    paramThingContext = new MutableLiveData();
    this.D = paramThingContext;
    this.E = paramThingContext;
    paramThingContext = new MutableLiveData();
    this.F = paramThingContext;
    this.G = paramThingContext;
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    this.H = localMediatorLiveData;
    paramThingContext = new MutableLiveData();
    this.I = paramThingContext;
    this.J = paramThingContext;
    paramThingContext = Transformations.map(paramThingContext, j.a);
    kotlin.jvm.internal.j.d(paramThingContext, "Transformations.map(mPre…it).toMutableList()\n    }");
    this.K = paramThingContext;
    paramThingContext = this.a;
    kotlin.jvm.internal.j.d(paramThingContext, "mThingContext");
    paramThingContext = (ALIoTDevice)((ThingContext)paramThingContext).getIoTDevice();
    Object localObject = null;
    if (paramThingContext != null) {
      paramThingContext = paramThingContext.getLocalIoTDevice();
    } else {
      paramThingContext = null;
    }
    if (!(paramThingContext instanceof IoTLightStripDevice)) {
      paramThingContext = (ThingContext)localObject;
    }
    paramThingContext = (IoTLightStripDevice)paramThingContext;
    if (paramThingContext != null) {
      this.n.postValue(paramThingContext);
    } else {
      this.n.postValue(new IoTLightStripDevice());
    }
    localMediatorLiveData.addSource(this.n, new a(this));
  }
  
  private final void A5(LightingEffectData paramLightingEffectData)
  {
    n5(new k(paramLightingEffectData));
  }
  
  private final io.reactivex.a J5(final LightingEffectData paramLightingEffectData)
  {
    paramLightingEffectData = y0("set_lighting_effect", paramLightingEffectData, Boolean.class).Z().u(new c0(this, paramLightingEffectData));
    kotlin.jvm.internal.j.d(paramLightingEffectData, "postRequest(IoTNetworkDe…          }\n            }");
    return paramLightingEffectData;
  }
  
  private final void K5(final int paramInt)
  {
    n5(new d0(this, paramInt));
  }
  
  private final void M5(final EditPresetRule paramEditPresetRule)
  {
    y0("edit_preset_rules", paramEditPresetRule, Boolean.class).o0(new g0(this, paramEditPresetRule)).F0();
  }
  
  private final void N5(List<? extends LightStateBean> paramList)
  {
    BrightnessPresetsBean.PresetBean localPresetBean = new BrightnessPresetsBean.PresetBean();
    localPresetBean.setStates(paramList);
    c5(localPresetBean).i(new h0(this)).y();
  }
  
  private final void n5(kotlin.jvm.b.l<? super IoTLightStripDevice, p> paraml)
  {
    Object localObject1 = this.a;
    kotlin.jvm.internal.j.d(localObject1, "mThingContext");
    localObject1 = (ALIoTDevice)((ThingContext)localObject1).getIoTDevice();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ALIoTDevice)localObject1).getLocalIoTDevice();
    } else {
      localObject1 = null;
    }
    if (!(localObject1 instanceof IoTLightStripDevice)) {
      localObject1 = localObject2;
    }
    localObject1 = (IoTLightStripDevice)localObject1;
    if (localObject1 != null)
    {
      paraml.invoke(localObject1);
      this.n.postValue(localObject1);
    }
    this.b.L3();
  }
  
  private final IoTLightStripDevice t5()
  {
    Object localObject1 = this.a;
    kotlin.jvm.internal.j.d(localObject1, "mThingContext");
    localObject1 = (ALIoTDevice)((ThingContext)localObject1).getIoTDevice();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ALIoTDevice)localObject1).getLocalIoTDevice();
    } else {
      localObject1 = null;
    }
    if (!(localObject1 instanceof IoTLightStripDevice)) {
      localObject1 = localObject2;
    }
    return (IoTLightStripDevice)localObject1;
  }
  
  private final void z5(int paramInt)
  {
    this.F.postValue(Integer.valueOf(paramInt));
    IoTLightStripDevice localIoTLightStripDevice = t5();
    if (localIoTLightStripDevice != null) {
      localIoTLightStripDevice.setSegments(paramInt);
    }
  }
  
  public final io.reactivex.a B5(LightStateBean paramLightStateBean)
  {
    kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
    paramLightStateBean = J4(new LightStripDeviceInfoParams(paramLightStateBean));
    kotlin.jvm.internal.j.d(paramLightStateBean, "setDeviceShadow(LightStr…ceInfoParams(lightState))");
    return paramLightStateBean;
  }
  
  public final io.reactivex.a C5(final AutoLightBean paramAutoLightBean)
  {
    kotlin.jvm.internal.j.e(paramAutoLightBean, "autoLight");
    final Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    Object localObject1 = null;
    localObjectRef.element = null;
    Object localObject2 = this.n;
    kotlin.jvm.internal.j.d(localObject2, "mDeviceInfoLiveData");
    localObject2 = ((LiveData)localObject2).getValue();
    if ((localObject2 instanceof IoTLightStripDevice)) {
      localObject1 = localObject2;
    }
    localObject1 = (IoTLightStripDevice)localObject1;
    if (localObject1 != null)
    {
      localObjectRef.element = ((IoTLightStripDevice)localObject1).getAutoMode();
      ((IoTLightStripDevice)localObject1).setAutoMode(paramAutoLightBean.getMode());
    }
    paramAutoLightBean = y0("set_auto_light_info", paramAutoLightBean, Boolean.class).Z().u(new l(this, paramAutoLightBean)).j(new m(this, localObjectRef));
    kotlin.jvm.internal.j.d(paramAutoLightBean, "postRequest(IoTNetworkDe…oldAutoMode\n            }");
    return paramAutoLightBean;
  }
  
  public final io.reactivex.a D5(int paramInt, boolean paramBoolean)
  {
    io.reactivex.a locala = K4(new LightStripDeviceInfoParams(Integer.valueOf(paramInt)), paramBoolean);
    kotlin.jvm.internal.j.d(locala, "setDeviceShadow(LightStr…ghtness), isDataRollback)");
    return locala;
  }
  
  public final io.reactivex.a E5(DefaultStatesBean paramDefaultStatesBean)
  {
    kotlin.jvm.internal.j.e(paramDefaultStatesBean, "defaultStates");
    paramDefaultStatesBean = G4(new LightStripDeviceInfoParams(paramDefaultStatesBean));
    kotlin.jvm.internal.j.d(paramDefaultStatesBean, "setDeviceInfo(LightStrip…nfoParams(defaultStates))");
    return paramDefaultStatesBean;
  }
  
  public final io.reactivex.a F5(final DeviceSegmentBean paramDeviceSegmentBean)
  {
    kotlin.jvm.internal.j.e(paramDeviceSegmentBean, "segmentBean");
    paramDeviceSegmentBean = y0("set_device_segment", paramDeviceSegmentBean, Boolean.class).o0(new s(this, paramDeviceSegmentBean)).Z().i(new t(this, paramDeviceSegmentBean));
    kotlin.jvm.internal.j.d(paramDeviceSegmentBean, "postRequest(IoTNetworkDe…an.segment)\n            }");
    return paramDeviceSegmentBean;
  }
  
  public final io.reactivex.a G5(final LightStateBean paramLightStateBean)
  {
    kotlin.jvm.internal.j.e(paramLightStateBean, "lightState");
    LightStripDeviceInfoParams localLightStripDeviceInfoParams = new LightStripDeviceInfoParams(paramLightStateBean);
    localLightStripDeviceInfoParams.setDeviceOn(Boolean.TRUE);
    paramLightStateBean = t5();
    if (paramLightStateBean != null)
    {
      paramLightStateBean = paramLightStateBean.getLightingEffectData();
      if (paramLightStateBean != null)
      {
        paramLightStateBean = paramLightStateBean.enable;
        break label51;
      }
    }
    paramLightStateBean = null;
    label51:
    paramLightStateBean = J4(localLightStripDeviceInfoParams).l(new u(this)).i(new v(this)).j(new w(this, paramLightStateBean));
    kotlin.jvm.internal.j.d(paramLightStateBean, "setDeviceShadow(params)\n…ectEnabled)\n            }");
    return paramLightStateBean;
  }
  
  public final io.reactivex.a H5(final int paramInt, final boolean paramBoolean)
  {
    final LightingEffectData localLightingEffectData = new LightingEffectData();
    localLightingEffectData.brightness = Integer.valueOf(paramInt);
    final Object localObject = Integer.valueOf(1);
    localLightingEffectData.bAdjusted = ((Integer)localObject);
    localLightingEffectData.enable = ((Integer)localObject);
    localObject = t5();
    if (localObject != null)
    {
      localObject = ((IoTLightStripDevice)localObject).getLightingEffectData();
      if (localObject != null)
      {
        localObject = ((LightingEffectData)localObject).brightness;
        break label70;
      }
    }
    localObject = null;
    label70:
    localObject = y0("set_lighting_effect", localLightingEffectData, Boolean.class).Z().u(new x(this, localLightingEffectData)).l(new y(this, paramBoolean, paramInt)).j(new z(this, paramBoolean, (Integer)localObject));
    kotlin.jvm.internal.j.d(localObject, "postRequest(IoTNetworkDe…          }\n            }");
    return (io.reactivex.a)localObject;
  }
  
  public final io.reactivex.a I5(final LightingEffectData paramLightingEffectData)
  {
    kotlin.jvm.internal.j.e(paramLightingEffectData, "effectData");
    final Object localObject = t5();
    if (localObject != null) {
      localObject = ((IoTLightStripDevice)localObject).getLightingEffectData();
    } else {
      localObject = null;
    }
    paramLightingEffectData = J5(paramLightingEffectData).l(new a0(this, paramLightingEffectData)).j(new b0(this, (LightingEffectData)localObject));
    kotlin.jvm.internal.j.d(paramLightingEffectData, "setLightingEffectDataInt…ta(oldData)\n            }");
    return paramLightingEffectData;
  }
  
  public final q<Boolean> L5(final OnOffGraduallyBean paramOnOffGraduallyBean)
  {
    kotlin.jvm.internal.j.e(paramOnOffGraduallyBean, "onOffGraduallyBean");
    paramOnOffGraduallyBean = P4(paramOnOffGraduallyBean).z(new e0(this, paramOnOffGraduallyBean)).C(new f0(this, paramOnOffGraduallyBean));
    kotlin.jvm.internal.j.d(paramOnOffGraduallyBean, "setOnOffGradually(onOffG…an(status))\n            }");
    return paramOnOffGraduallyBean;
  }
  
  public io.reactivex.a i(boolean paramBoolean)
  {
    final LightStripDeviceInfoParams localLightStripDeviceInfoParams = new LightStripDeviceInfoParams(Boolean.valueOf(paramBoolean));
    final Object localObject1 = this.a;
    kotlin.jvm.internal.j.d(localObject1, "mThingContext");
    localObject1 = (ALIoTDevice)((ThingContext)localObject1).getIoTDevice();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ALIoTDevice)localObject1).getLocalIoTDevice();
    } else {
      localObject1 = null;
    }
    Object localObject3 = localObject1;
    if (!(localObject1 instanceof IoTLightStripDevice)) {
      localObject3 = null;
    }
    localObject3 = (IoTLightStripDevice)localObject3;
    if (localObject3 != null)
    {
      localObject1 = ((LocalIoTBaseDevice)localObject3).getDefaultStates();
      if (localObject1 != null)
      {
        localObject1 = ((DefaultStatesBean)localObject1).getType();
        break label96;
      }
    }
    localObject1 = null;
    label96:
    boolean bool = kotlin.jvm.internal.j.a(localObject1, "custom");
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      Object localObject4 = ((LocalIoTBaseDevice)localObject3).getDefaultStates();
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject4 = ((DefaultStatesBean)localObject4).getLightState();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((LightStateBean)localObject4).getLightingEffectData();
        }
      }
    }
    if ((paramBoolean) && (bool) && (localObject3 != null))
    {
      localObject3 = ((LocalIoTBaseDevice)localObject3).getDefaultStates();
      if (localObject3 != null)
      {
        localObject3 = ((DefaultStatesBean)localObject3).getLightState();
        if (localObject3 != null)
        {
          localLightStripDeviceInfoParams.setHue(Integer.valueOf(((LightStateBean)localObject3).getHue()));
          localLightStripDeviceInfoParams.setSaturation(Integer.valueOf(((LightStateBean)localObject3).getSaturation()));
          localLightStripDeviceInfoParams.setColorTemp(Integer.valueOf(((LightStateBean)localObject3).getColorTemp()));
          localLightStripDeviceInfoParams.setBrightness(Integer.valueOf(((LightStateBean)localObject3).getBrightness()));
          localLightStripDeviceInfoParams.setLightingEffect(((LightStateBean)localObject3).getLightingEffectData());
        }
      }
    }
    if (paramBoolean)
    {
      if (bool)
      {
        if (localObject1 != null)
        {
          ((LightingEffectData)localObject1).enable = Integer.valueOf(1);
          localObject1 = y0("set_lighting_effect", localObject1, Boolean.class).Z().u(new n(this, localLightStripDeviceInfoParams)).l(new o(this, localLightStripDeviceInfoParams)).j(new p(this));
          kotlin.jvm.internal.j.d(localObject1, "postRequest(IoTNetworkDe…                        }");
          return (io.reactivex.a)localObject1;
        }
        localObject1 = J4(localLightStripDeviceInfoParams).l(new q(this));
        kotlin.jvm.internal.j.d(localObject1, "setDeviceShadow(params)\n…                        }");
        return (io.reactivex.a)localObject1;
      }
      localObject1 = J4(localLightStripDeviceInfoParams).l(new r(this, (LightingEffectData)localObject1));
      kotlin.jvm.internal.j.d(localObject1, "setDeviceShadow(params)\n…  }\n                    }");
      return (io.reactivex.a)localObject1;
    }
    localObject1 = J4(localLightStripDeviceInfoParams);
    kotlin.jvm.internal.j.d(localObject1, "setDeviceShadow(params)");
    return (io.reactivex.a)localObject1;
  }
  
  public final io.reactivex.a o5(EditPresetRule paramEditPresetRule)
  {
    kotlin.jvm.internal.j.e(paramEditPresetRule, "editPresetRule");
    Object localObject1 = (BrightnessPresetsBean)this.I.getValue();
    boolean bool;
    if (localObject1 != null) {
      bool = ((BrightnessPresetsBean)localObject1).isSet();
    } else {
      bool = false;
    }
    List localList = (List)this.K.getValue();
    int i;
    int j;
    if (localList != null)
    {
      i = localList.size();
      j = paramEditPresetRule.getIndex();
      if ((j >= 0) && (i > j))
      {
        i = paramEditPresetRule.getIndex();
        localObject2 = paramEditPresetRule.getState();
        kotlin.jvm.internal.j.d(localObject2, "editPresetRule.state");
        localList.set(i, localObject2);
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new BrightnessPresetsBean();
    }
    localObject1 = new BrightnessPresetsBean.PresetBean();
    ((BrightnessPresetsBean.PresetBean)localObject1).setStates(localList);
    ((BrightnessPresetsBean)localObject2).setPresets((BrightnessPresetsBean.PresetBean)localObject1);
    this.I.postValue(localObject2);
    if ((bool) && (localList != null))
    {
      j = localList.size();
      i = paramEditPresetRule.getIndex();
      if ((i >= 0) && (j > i))
      {
        M5(paramEditPresetRule);
        break label209;
      }
    }
    N5(localList);
    label209:
    paramEditPresetRule = io.reactivex.a.e();
    kotlin.jvm.internal.j.d(paramEditPresetRule, "Completable.complete()");
    return paramEditPresetRule;
  }
  
  public final q<AutoLightBean> p5()
  {
    q localq = x0("get_auto_light_info", AutoLightBean.class).E(new c(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…          }\n            }");
    return localq;
  }
  
  public final String q5()
  {
    Object localObject1 = this.n;
    kotlin.jvm.internal.j.d(localObject1, "mDeviceInfoLiveData");
    localObject1 = ((LiveData)localObject1).getValue();
    boolean bool = localObject1 instanceof IoTLightStripDevice;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    IoTLightStripDevice localIoTLightStripDevice = (IoTLightStripDevice)localObject1;
    localObject1 = localObject2;
    if (localIoTLightStripDevice != null) {
      localObject1 = localIoTLightStripDevice.getAutoMode();
    }
    return (String)localObject1;
  }
  
  public final q<DeviceSegmentBean> r5()
  {
    q localq = x0("get_device_segment", DeviceSegmentBean.class).o0(new d(this)).E(new e(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…it.segment)\n            }");
    return localq;
  }
  
  public final LiveData<Integer> s5()
  {
    return this.G;
  }
  
  public final LiveData<List<LightStateBean>> u5()
  {
    return this.K;
  }
  
  public final q<LightingEffectData> v5()
  {
    q localq = x0("get_lighting_effect", LightingEffectData.class).E(new f(this));
    kotlin.jvm.internal.j.d(localq, "postRequest(IoTNetworkDe…ectData(it)\n            }");
    return localq;
  }
  
  public final q<BrightnessPresetsBean> w5()
  {
    q localq = A1().g0(g.c).E(new h(this));
    kotlin.jvm.internal.j.d(localq, "presets\n            .map…stValue(it)\n            }");
    return localq;
  }
  
  public final q<OnOffGraduallyBean> x5()
  {
    q localq = z1().E(new i(this));
    kotlin.jvm.internal.j.d(localq, "onOffGradually.doOnNext …a.postValue(it)\n        }");
    return localq;
  }
  
  public final LiveData<OnOffGraduallyBean> y5()
  {
    return this.E;
  }
  
  static final class a<T>
    implements Observer<LocalIoTBaseDevice>
  {
    a(LightStripRepository paramLightStripRepository) {}
    
    public final void a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      boolean bool = paramLocalIoTBaseDevice instanceof IoTLightStripDevice;
      Object localObject = null;
      if (!bool) {
        paramLocalIoTBaseDevice = null;
      }
      IoTLightStripDevice localIoTLightStripDevice = (IoTLightStripDevice)paramLocalIoTBaseDevice;
      paramLocalIoTBaseDevice = (LocalIoTBaseDevice)localObject;
      if (localIoTLightStripDevice != null) {
        paramLocalIoTBaseDevice = localIoTLightStripDevice.getLightingEffectData();
      }
      LightStripRepository.g5(this.a).postValue(paramLocalIoTBaseDevice);
    }
  }
  
  static final class a0<T>
    implements g<io.reactivex.e0.c>
  {
    a0(LightStripRepository paramLightStripRepository, LightingEffectData paramLightingEffectData) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      LightStripRepository.l5(this.c, paramLightingEffectData);
    }
  }
  
  public static final class b {}
  
  static final class b0<T>
    implements g<Throwable>
  {
    b0(LightStripRepository paramLightStripRepository, LightingEffectData paramLightingEffectData) {}
    
    public final void a(Throwable paramThrowable)
    {
      LightStripRepository.l5(this.c, localObject);
    }
  }
  
  static final class c<T>
    implements g<AutoLightBean>
  {
    c(LightStripRepository paramLightStripRepository) {}
    
    public final void a(AutoLightBean paramAutoLightBean)
    {
      Object localObject1 = this.c.n;
      kotlin.jvm.internal.j.d(localObject1, "mDeviceInfoLiveData");
      Object localObject2 = ((LiveData)localObject1).getValue();
      localObject1 = localObject2;
      if (!(localObject2 instanceof IoTLightStripDevice)) {
        localObject1 = null;
      }
      localObject1 = (IoTLightStripDevice)localObject1;
      if (localObject1 != null)
      {
        kotlin.jvm.internal.j.d(paramAutoLightBean, "it");
        ((IoTLightStripDevice)localObject1).setAutoMode(paramAutoLightBean.getMode());
        ((IoTLightStripDevice)localObject1).setAutoEnable(paramAutoLightBean.isEnable());
      }
    }
  }
  
  static final class c0<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    c0(LightStripRepository paramLightStripRepository, LightingEffectData paramLightingEffectData) {}
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L4(new LightStripDeviceInfoParams(paramLightingEffectData), false);
      } else {
        paramThrowable = io.reactivex.a.m(paramThrowable);
      }
      return paramThrowable;
    }
  }
  
  static final class d<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends DeviceSegmentBean>>
  {
    d(LightStripRepository paramLightStripRepository) {}
    
    public final t<? extends DeviceSegmentBean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.t(EnumFeatureType.SEGMENT_CONFIG.getValue()).g0(a.c);
      }
      return q.J(paramThrowable);
    }
    
    static final class a<T, R>
      implements io.reactivex.g0.j<com.google.gson.i, DeviceSegmentBean>
    {
      public static final a c = new a();
      
      public final DeviceSegmentBean a(com.google.gson.i parami)
      {
        kotlin.jvm.internal.j.e(parami, "it");
        return (DeviceSegmentBean)com.tplink.libtpnetwork.Utils.i.a(parami, DeviceSegmentBean.class);
      }
    }
  }
  
  static final class d0
    extends Lambda
    implements kotlin.jvm.b.l<IoTLightStripDevice, p>
  {
    d0(LightStripRepository paramLightStripRepository, int paramInt)
    {
      super();
    }
    
    public final void a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      kotlin.jvm.internal.j.e(paramIoTLightStripDevice, "$receiver");
      Object localObject = paramIoTLightStripDevice.getLightingEffectData();
      if (localObject != null) {
        ((LightingEffectData)localObject).enable = Integer.valueOf(paramInt);
      }
      localObject = LightStripRepository.j5(this.c);
      kotlin.jvm.internal.j.d(localObject, "mThingContext");
      localObject = ((ThingContext)localObject).getThingShadow();
      if (localObject != null)
      {
        localObject = ((ThingShadow)localObject).getState();
        if (localObject != null)
        {
          localObject = ((ThingShadowState)localObject).getDesired();
          if (localObject != null) {
            ((Map)localObject).put("lighting_effect", paramIoTLightStripDevice.getLightingEffectData());
          }
        }
      }
    }
  }
  
  static final class e<T>
    implements g<DeviceSegmentBean>
  {
    e(LightStripRepository paramLightStripRepository) {}
    
    public final void a(DeviceSegmentBean paramDeviceSegmentBean)
    {
      LightStripRepository.k5(this.c, paramDeviceSegmentBean.getSegment());
    }
  }
  
  static final class e0
    implements io.reactivex.g0.a
  {
    e0(LightStripRepository paramLightStripRepository, OnOffGraduallyBean paramOnOffGraduallyBean) {}
    
    public final void run()
    {
      LightStripRepository.h5(this.a).postValue(paramOnOffGraduallyBean);
    }
  }
  
  static final class f<T>
    implements g<LightingEffectData>
  {
    f(LightStripRepository paramLightStripRepository) {}
    
    public final void a(LightingEffectData paramLightingEffectData)
    {
      LightStripRepository.l5(this.c, paramLightingEffectData);
    }
  }
  
  static final class f0<T>
    implements g<Throwable>
  {
    f0(LightStripRepository paramLightStripRepository, OnOffGraduallyBean paramOnOffGraduallyBean) {}
    
    public final void a(Throwable paramThrowable)
    {
      boolean bool = paramOnOffGraduallyBean.isEnable();
      LightStripRepository.h5(this.c).postValue(new OnOffGraduallyBean(bool ^ true));
    }
  }
  
  static final class g<T, R>
    implements io.reactivex.g0.j<com.google.gson.i, BrightnessPresetsBean>
  {
    public static final g c = new g();
    
    public final BrightnessPresetsBean a(com.google.gson.i parami)
    {
      kotlin.jvm.internal.j.e(parami, "it");
      return (BrightnessPresetsBean)com.tplink.libtpnetwork.Utils.i.a(parami, BrightnessPresetsBean.class);
    }
  }
  
  static final class g0<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    g0(LightStripRepository paramLightStripRepository, EditPresetRule paramEditPresetRule) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable))
      {
        paramThrowable = new BrightnessPresetsBean.PresetBean();
        paramThrowable.setStates(kotlin.collections.l.b(paramEditPresetRule.getState()));
        this.c.b5(Integer.valueOf(paramEditPresetRule.getIndex()), paramThrowable).y();
        return q.f0(Boolean.TRUE);
      }
      return q.J(paramThrowable);
    }
  }
  
  static final class h<T>
    implements g<BrightnessPresetsBean>
  {
    h(LightStripRepository paramLightStripRepository) {}
    
    public final void a(BrightnessPresetsBean paramBrightnessPresetsBean)
    {
      LightStripRepository.i5(this.c).postValue(paramBrightnessPresetsBean);
    }
  }
  
  static final class h0
    implements io.reactivex.g0.a
  {
    h0(LightStripRepository paramLightStripRepository) {}
    
    public final void run()
    {
      BrightnessPresetsBean localBrightnessPresetsBean = (BrightnessPresetsBean)LightStripRepository.i5(this.a).getValue();
      if (localBrightnessPresetsBean != null)
      {
        kotlin.jvm.internal.j.d(localBrightnessPresetsBean, "mPresetsLiveData.value ?: return@doOnComplete");
        localBrightnessPresetsBean.setSet(true);
        LightStripRepository.i5(this.a).postValue(localBrightnessPresetsBean);
      }
    }
  }
  
  static final class i<T>
    implements g<OnOffGraduallyBean>
  {
    i(LightStripRepository paramLightStripRepository) {}
    
    public final void a(OnOffGraduallyBean paramOnOffGraduallyBean)
    {
      LightStripRepository.h5(this.c).postValue(paramOnOffGraduallyBean);
    }
  }
  
  static final class j<I, O>
    implements Function<BrightnessPresetsBean, List<LightStateBean>>
  {
    public static final j a = new j();
    
    public final List<LightStateBean> a(BrightnessPresetsBean paramBrightnessPresetsBean)
    {
      paramBrightnessPresetsBean = com.tplink.libtpnetwork.Utils.c.b(paramBrightnessPresetsBean);
      kotlin.jvm.internal.j.d(paramBrightnessPresetsBean, "BulbPresetUtils.getColorPresetList(it)");
      return kotlin.collections.l.U(paramBrightnessPresetsBean);
    }
  }
  
  static final class k
    extends Lambda
    implements kotlin.jvm.b.l<IoTLightStripDevice, p>
  {
    k(LightingEffectData paramLightingEffectData)
    {
      super();
    }
    
    public final void a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      kotlin.jvm.internal.j.e(paramIoTLightStripDevice, "$receiver");
      paramIoTLightStripDevice.setLightingEffectData(this.c);
    }
  }
  
  static final class l<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    l(LightStripRepository paramLightStripRepository, AutoLightBean paramAutoLightBean) {}
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "it");
      if (this.c.F0(paramThrowable)) {
        return this.c.J4(new LightStripDeviceInfoParams(paramAutoLightBean));
      }
      return io.reactivex.a.m(paramThrowable);
    }
  }
  
  static final class m<T>
    implements g<Throwable>
  {
    m(LightStripRepository paramLightStripRepository, Ref.ObjectRef paramObjectRef) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = this.c.n;
      kotlin.jvm.internal.j.d(paramThrowable, "mDeviceInfoLiveData");
      Object localObject = paramThrowable.getValue();
      paramThrowable = (Throwable)localObject;
      if (!(localObject instanceof IoTLightStripDevice)) {
        paramThrowable = null;
      }
      paramThrowable = (IoTLightStripDevice)paramThrowable;
      if (paramThrowable != null) {
        paramThrowable.setAutoMode((String)localObjectRef.element);
      }
    }
  }
  
  static final class n<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    n(LightStripRepository paramLightStripRepository, LightStripDeviceInfoParams paramLightStripDeviceInfoParams) {}
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "it");
      return this.c.L4(localLightStripDeviceInfoParams, false);
    }
  }
  
  static final class o<T>
    implements g<io.reactivex.e0.c>
  {
    o(LightStripRepository paramLightStripRepository, LightStripDeviceInfoParams paramLightStripDeviceInfoParams) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      this.c.B4(localLightStripDeviceInfoParams);
    }
  }
  
  static final class p<T>
    implements g<Throwable>
  {
    p(LightStripRepository paramLightStripRepository) {}
    
    public final void a(Throwable paramThrowable)
    {
      this.c.E4(paramThrowable);
    }
  }
  
  static final class q<T>
    implements g<io.reactivex.e0.c>
  {
    q(LightStripRepository paramLightStripRepository) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      LightStripRepository.m5(this.c, 0);
    }
  }
  
  static final class r<T>
    implements g<io.reactivex.e0.c>
  {
    r(LightStripRepository paramLightStripRepository, LightingEffectData paramLightingEffectData) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      paramc = localObject1;
      if (paramc != null) {
        paramc = paramc.enable;
      } else {
        paramc = null;
      }
      if ((paramc != null) && (paramc.intValue() == 1)) {
        LightStripRepository.l5(this.c, localObject1);
      }
    }
  }
  
  static final class s<T, R>
    implements io.reactivex.g0.j<Throwable, t<? extends Boolean>>
  {
    s(LightStripRepository paramLightStripRepository, DeviceSegmentBean paramDeviceSegmentBean) {}
    
    public final t<? extends Boolean> a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        return this.c.L0(EnumFeatureType.SEGMENT_CONFIG.getValue(), paramDeviceSegmentBean).g0(a.c);
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
  
  static final class t
    implements io.reactivex.g0.a
  {
    t(LightStripRepository paramLightStripRepository, DeviceSegmentBean paramDeviceSegmentBean) {}
    
    public final void run()
    {
      LightStripRepository.k5(this.a, paramDeviceSegmentBean.getSegment());
    }
  }
  
  static final class u<T>
    implements g<io.reactivex.e0.c>
  {
    u(LightStripRepository paramLightStripRepository) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      LightStripRepository.m5(this.c, 0);
    }
  }
  
  static final class v
    implements io.reactivex.g0.a
  {
    v(LightStripRepository paramLightStripRepository) {}
    
    public final void run()
    {
      Object localObject = LightStripRepository.f5(this.a);
      if (localObject != null)
      {
        localObject = ((LocalIoTBaseDevice)localObject).getDefaultStates();
        if (localObject != null)
        {
          localObject = ((DefaultStatesBean)localObject).getLightState();
          if (localObject != null)
          {
            localObject = ((LightStateBean)localObject).getLightingEffectData();
            if (localObject != null) {
              ((LightingEffectData)localObject).enable = Integer.valueOf(0);
            }
          }
        }
      }
    }
  }
  
  static final class w<T>
    implements g<Throwable>
  {
    w(LightStripRepository paramLightStripRepository, Integer paramInteger) {}
    
    public final void a(Throwable paramThrowable)
    {
      paramThrowable = paramLightStateBean;
      if (paramThrowable != null) {
        LightStripRepository.m5(this.c, paramThrowable.intValue());
      }
    }
  }
  
  static final class x<T, R>
    implements io.reactivex.g0.j<Throwable, e>
  {
    x(LightStripRepository paramLightStripRepository, LightingEffectData paramLightingEffectData) {}
    
    public final e a(Throwable paramThrowable)
    {
      kotlin.jvm.internal.j.e(paramThrowable, "throwable");
      if (this.c.F0(paramThrowable)) {
        paramThrowable = this.c.L4(new LightStripDeviceInfoParams(localLightingEffectData), false);
      } else {
        paramThrowable = io.reactivex.a.m(paramThrowable);
      }
      return paramThrowable;
    }
  }
  
  static final class y<T>
    implements g<io.reactivex.e0.c>
  {
    y(LightStripRepository paramLightStripRepository, boolean paramBoolean, int paramInt) {}
    
    public final void a(io.reactivex.e0.c paramc)
    {
      if (paramBoolean) {
        LightStripRepository.e5(this.c, new a(this));
      }
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<IoTLightStripDevice, p>
    {
      a(LightStripRepository.y paramy)
      {
        super();
      }
      
      public final void a(IoTLightStripDevice paramIoTLightStripDevice)
      {
        kotlin.jvm.internal.j.e(paramIoTLightStripDevice, "$receiver");
        paramIoTLightStripDevice = paramIoTLightStripDevice.getLightingEffectData();
        if (paramIoTLightStripDevice != null) {
          paramIoTLightStripDevice.brightness = Integer.valueOf(this.c.f);
        }
      }
    }
  }
  
  static final class z<T>
    implements g<Throwable>
  {
    z(LightStripRepository paramLightStripRepository, boolean paramBoolean, Integer paramInteger) {}
    
    public final void a(Throwable paramThrowable)
    {
      if ((paramBoolean) && (localObject != null)) {
        LightStripRepository.e5(this.c, new a(this));
      }
    }
    
    static final class a
      extends Lambda
      implements kotlin.jvm.b.l<IoTLightStripDevice, p>
    {
      a(LightStripRepository.z paramz)
      {
        super();
      }
      
      public final void a(IoTLightStripDevice paramIoTLightStripDevice)
      {
        kotlin.jvm.internal.j.e(paramIoTLightStripDevice, "$receiver");
        paramIoTLightStripDevice = paramIoTLightStripDevice.getLightingEffectData();
        if (paramIoTLightStripDevice != null) {
          paramIoTLightStripDevice.brightness = this.c.f;
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\LightStripRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
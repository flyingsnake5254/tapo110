package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean.PresetBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean.BrightnessBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.params.BulbDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightEffectEnableBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.RulePageParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.LightEffectRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.b;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.c;
import com.tplink.libtpnetwork.IoTNetwork.x;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import io.reactivex.e;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BulbRepository
  extends AbstractThingRepository
{
  private MutableLiveData<BrightnessPresetsBean> C = new MutableLiveData();
  private MutableLiveData<List<LightStateBean>> D = new MutableLiveData();
  private MutableLiveData<OnOffGraduallyBean> E = new MutableLiveData();
  private String F;
  private MutableLiveData<List<ThingRuleLightEffect>> G = new MutableLiveData();
  private Map<String, ThingRuleLightEffect> H = new LinkedHashMap();
  
  public BulbRepository(ThingContext paramThingContext)
  {
    super(paramThingContext, IoTBulbDevice.class, BulbDeviceRunningInfoResult.class);
    paramThingContext = (ALIoTDevice)paramThingContext.getIoTDevice();
    if ((paramThingContext != null) && ((paramThingContext.getLocalIoTDevice() instanceof IoTBulbDevice)))
    {
      paramThingContext = (IoTBulbDevice)paramThingContext.getLocalIoTDevice();
      this.n.postValue(paramThingContext);
    }
    else
    {
      this.n.postValue(new IoTBulbDevice());
    }
  }
  
  private void d6()
  {
    Object localObject = ((ThingContext)this.a).getThingModel();
    if ((localObject != null) && (((ThingModel)localObject).getThingProperty("on") != null))
    {
      localObject = ((ThingContext)this.a).getThingShadow();
      if ((localObject != null) && (((ThingShadow)localObject).getState() != null) && (((ThingShadow)localObject).getState().getDesired() != null))
      {
        localObject = ((ThingShadow)localObject).getState().getDesired();
        if (localObject != null) {
          ((Map)localObject).put("on", Boolean.TRUE);
        }
      }
    }
  }
  
  private void h5()
  {
    Object localObject = ((ThingContext)this.a).getThingModel();
    if ((localObject != null) && (((ThingModel)localObject).getThingProperty("dynamic_light_effect_enable") != null))
    {
      localObject = ((ThingContext)this.a).getThingShadow();
      if ((localObject != null) && (((ThingShadow)localObject).getState() != null) && (((ThingShadow)localObject).getState().getDesired() != null))
      {
        localObject = ((ThingShadow)localObject).getState().getDesired();
        if (localObject != null) {
          ((Map)localObject).put("dynamic_light_effect_enable", Boolean.FALSE);
        }
      }
    }
  }
  
  private q<List<ThingRuleLightEffect>> k5(RulePageParams paramRulePageParams)
  {
    ArrayList localArrayList = new ArrayList();
    return v5(paramRulePageParams).g0(new c5(localArrayList, paramRulePageParams)).w0(v4.c);
  }
  
  private q<LightEffectRuleResult> u5(RulePageParams paramRulePageParams)
  {
    return y0("get_dynamic_light_effect_rules", paramRulePageParams, LightEffectRuleResult.class);
  }
  
  private q<ThingRuleListResult<ThingRuleLightEffect>> v5(RulePageParams paramRulePageParams)
  {
    return q.f0(paramRulePageParams).N(new f5(this, paramRulePageParams));
  }
  
  public io.reactivex.a W5(final AutoLightBean paramAutoLightBean)
  {
    Object localObject = (LocalIoTBaseDevice)this.n.getValue();
    if ((localObject instanceof IoTBulbDevice))
    {
      localObject = (IoTBulbDevice)localObject;
      this.F = ((IoTBulbDevice)localObject).getAutoMode();
      ((IoTBulbDevice)localObject).setAutoMode(paramAutoLightBean.getMode());
    }
    return y0("set_auto_light_info", paramAutoLightBean, Boolean.class).Z().u(new e(paramAutoLightBean)).j(new d());
  }
  
  public io.reactivex.a X5(int paramInt)
  {
    return J4(new BulbDeviceInfoParams(Integer.valueOf(paramInt)));
  }
  
  public io.reactivex.a Y5(List<Integer> paramList)
  {
    BrightnessPresetsBean.PresetBean localPresetBean = new BrightnessPresetsBean.PresetBean();
    localPresetBean.setBrightness(paramList);
    return c5(localPresetBean);
  }
  
  public io.reactivex.a Z5(DefaultStatesBean paramDefaultStatesBean)
  {
    return G4(new BulbDeviceInfoParams(paramDefaultStatesBean));
  }
  
  public io.reactivex.a a6(LightEffectEnableBean paramLightEffectEnableBean)
  {
    if ((this.n.getValue() instanceof IoTBulbDevice))
    {
      IoTBulbDevice localIoTBulbDevice = (IoTBulbDevice)this.n.getValue();
      this.i = localIoTBulbDevice.getDeviceInfoParams();
      if (paramLightEffectEnableBean.isEnable()) {
        localIoTBulbDevice.setDeviceOn(true);
      }
      localIoTBulbDevice.setDynamicLightEffectEnable(paramLightEffectEnableBean.isEnable());
      localIoTBulbDevice.setDynamicLightEffectId(paramLightEffectEnableBean.getId());
      this.n.postValue(localIoTBulbDevice);
      this.b.L3();
    }
    return y0("set_dynamic_light_effect_rule_enable", paramLightEffectEnableBean, Boolean.class).Z().u(new y4(this, paramLightEffectEnableBean)).j(new a5(this));
  }
  
  public io.reactivex.a b6(LightStateBean paramLightStateBean)
  {
    return J4(new BulbDeviceInfoParams(paramLightStateBean));
  }
  
  public q<Boolean> c6(final OnOffGraduallyBean paramOnOffGraduallyBean)
  {
    return P4(paramOnOffGraduallyBean).z(new b(paramOnOffGraduallyBean)).C(new a(paramOnOffGraduallyBean));
  }
  
  protected void e()
  {
    this.c.l();
    super.e();
  }
  
  public q<Boolean> h()
  {
    D4().L0(io.reactivex.l0.a.c()).q0(Boolean.FALSE).F0();
    return super.h();
  }
  
  public io.reactivex.a i(boolean paramBoolean)
  {
    BulbDeviceInfoParams localBulbDeviceInfoParams = new BulbDeviceInfoParams(Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      Object localObject = this.a;
      if ((localObject != null) && (((ThingContext)localObject).getIoTDevice() != null) && ((((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice() instanceof IoTBulbDevice)))
      {
        localObject = (IoTBulbDevice)((ALIoTDevice)((ThingContext)this.a).getIoTDevice()).getLocalIoTDevice();
        if ((((LocalIoTBaseDevice)localObject).getDefaultStates() != null) && (((LocalIoTBaseDevice)localObject).getDefaultStates().getBrightness() != null) && (TextUtils.equals(((LocalIoTBaseDevice)localObject).getDefaultStates().getBrightness().getType(), "custom")))
        {
          localBulbDeviceInfoParams.setBrightness(Integer.valueOf(((LocalIoTBaseDevice)localObject).getDefaultStates().getBrightness().getValue()));
        }
        else if ((((LocalIoTBaseDevice)localObject).getDefaultStates() != null) && (TextUtils.equals(((LocalIoTBaseDevice)localObject).getDefaultStates().getType(), "custom")))
        {
          localObject = ((LocalIoTBaseDevice)localObject).getDefaultStates().getLightState();
          if (localObject != null)
          {
            localBulbDeviceInfoParams.setBrightness(Integer.valueOf(((LightStateBean)localObject).getBrightness()));
            localBulbDeviceInfoParams.setColorTemp(Integer.valueOf(((LightStateBean)localObject).getColorTemp()));
            localBulbDeviceInfoParams.setHue(Integer.valueOf(((LightStateBean)localObject).getHue()));
            localBulbDeviceInfoParams.setSaturation(Integer.valueOf(((LightStateBean)localObject).getSaturation()));
          }
        }
      }
    }
    return K4(localBulbDeviceInfoParams, false).l(new z4(this, localBulbDeviceInfoParams)).j(new fb(this));
  }
  
  public q<ThingRuleUpdateResult> i5(ThingRuleLightEffect paramThingRuleLightEffect)
  {
    return y0("edit_dynamic_light_effect_rule", paramThingRuleLightEffect, ThingRuleUpdateResult.class).o0(new e5(this, paramThingRuleLightEffect)).E(new h5(this, paramThingRuleLightEffect));
  }
  
  public io.reactivex.a j5(final EditPresetRule paramEditPresetRule)
  {
    Object localObject1 = (BrightnessPresetsBean)this.C.getValue();
    int i;
    if ((localObject1 != null) && (((BrightnessPresetsBean)localObject1).isSet())) {
      i = 1;
    } else {
      i = 0;
    }
    List localList = (List)this.D.getValue();
    if ((localList != null) && (paramEditPresetRule.getIndex() < localList.size())) {
      localList.set(paramEditPresetRule.getIndex(), paramEditPresetRule.getState());
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new BrightnessPresetsBean();
    }
    localObject1 = new BrightnessPresetsBean.PresetBean();
    ((BrightnessPresetsBean.PresetBean)localObject1).setStates(localList);
    ((BrightnessPresetsBean)localObject2).setPresets((BrightnessPresetsBean.PresetBean)localObject1);
    this.C.postValue(localObject2);
    if ((i != 0) && (localList != null) && (paramEditPresetRule.getIndex() < localList.size()))
    {
      y0("edit_preset_rules", paramEditPresetRule, Boolean.class).o0(new i(paramEditPresetRule)).F0();
    }
    else
    {
      paramEditPresetRule = new BrightnessPresetsBean.PresetBean();
      paramEditPresetRule.setStates(localList);
      c5(paramEditPresetRule).i(new j()).y();
    }
    return io.reactivex.a.e();
  }
  
  public q<List<ThingRuleLightEffect>> l5(RulePageParams paramRulePageParams)
  {
    ArrayList localArrayList = new ArrayList();
    return u5(paramRulePageParams).g0(new d5(localArrayList, paramRulePageParams)).w0(b5.c);
  }
  
  public q<AutoLightBean> m5()
  {
    return y0("get_auto_light_info", null, AutoLightBean.class).E(new f());
  }
  
  public String n5()
  {
    if ((this.n.getValue() instanceof IoTBulbDevice)) {
      return ((IoTBulbDevice)this.n.getValue()).getAutoMode();
    }
    return null;
  }
  
  public LiveData<List<Integer>> o5()
  {
    return Transformations.map(z5(), a.a);
  }
  
  public q<BrightnessPresetsBean> p5()
  {
    return A1().g0(new h()).E(new g());
  }
  
  public LiveData<List<LightStateBean>> q5()
  {
    return Transformations.map(z5(), new w4(this));
  }
  
  public LiveData<IoTBulbDevice> r5()
  {
    return Transformations.map(super.j1(), new c());
  }
  
  public ThingRuleLightEffect s5(String paramString)
  {
    return (ThingRuleLightEffect)this.H.get(paramString);
  }
  
  public q<List<ThingRuleLightEffect>> t5()
  {
    return l5(new RulePageParams(0)).o0(new x4(this)).E(new g5(this));
  }
  
  public LiveData<List<ThingRuleLightEffect>> w5()
  {
    return this.G;
  }
  
  public q<OnOffGraduallyBean> x5()
  {
    return z1().E(new k());
  }
  
  public LiveData<OnOffGraduallyBean> y5()
  {
    return this.E;
  }
  
  public LiveData<BrightnessPresetsBean> z5()
  {
    return this.C;
  }
  
  class a
    implements g<Throwable>
  {
    a(OnOffGraduallyBean paramOnOffGraduallyBean) {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      boolean bool = paramOnOffGraduallyBean.isEnable();
      BulbRepository.g5(BulbRepository.this).postValue(new OnOffGraduallyBean(bool ^ true));
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b(OnOffGraduallyBean paramOnOffGraduallyBean) {}
    
    public void run()
      throws Exception
    {
      BulbRepository.g5(BulbRepository.this).postValue(paramOnOffGraduallyBean);
    }
  }
  
  class c
    implements Function<LocalIoTBaseDevice, IoTBulbDevice>
  {
    c() {}
    
    public IoTBulbDevice a(LocalIoTBaseDevice paramLocalIoTBaseDevice)
    {
      if ((paramLocalIoTBaseDevice instanceof IoTBulbDevice)) {
        return (IoTBulbDevice)paramLocalIoTBaseDevice;
      }
      return null;
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable = (LocalIoTBaseDevice)BulbRepository.this.n.getValue();
      if ((paramThrowable instanceof IoTBulbDevice)) {
        ((IoTBulbDevice)paramThrowable).setAutoMode(BulbRepository.e5(BulbRepository.this));
      }
    }
  }
  
  class e
    implements j<Throwable, e>
  {
    e(AutoLightBean paramAutoLightBean) {}
    
    public e a(Throwable paramThrowable)
      throws Exception
    {
      if (BulbRepository.this.F0(paramThrowable)) {
        return BulbRepository.this.J4(new BulbDeviceInfoParams(paramAutoLightBean));
      }
      return io.reactivex.a.m(paramThrowable);
    }
  }
  
  class f
    implements g<AutoLightBean>
  {
    f() {}
    
    public void a(AutoLightBean paramAutoLightBean)
      throws Exception
    {
      LocalIoTBaseDevice localLocalIoTBaseDevice = (LocalIoTBaseDevice)BulbRepository.this.n.getValue();
      if ((localLocalIoTBaseDevice instanceof IoTBulbDevice)) {
        ((IoTBulbDevice)localLocalIoTBaseDevice).setAutoMode(paramAutoLightBean.getMode());
      }
    }
  }
  
  class g
    implements g<BrightnessPresetsBean>
  {
    g() {}
    
    public void a(BrightnessPresetsBean paramBrightnessPresetsBean)
      throws Exception
    {
      BulbRepository.f5(BulbRepository.this).postValue(paramBrightnessPresetsBean);
    }
  }
  
  class h
    implements j<com.google.gson.i, BrightnessPresetsBean>
  {
    h() {}
    
    public BrightnessPresetsBean a(com.google.gson.i parami)
      throws Exception
    {
      return (BrightnessPresetsBean)com.tplink.libtpnetwork.Utils.i.a(parami, BrightnessPresetsBean.class);
    }
  }
  
  class i
    implements j<Throwable, t<? extends Boolean>>
  {
    i(EditPresetRule paramEditPresetRule) {}
    
    public t<? extends Boolean> a(Throwable paramThrowable)
      throws Exception
    {
      if (BulbRepository.this.F0(paramThrowable))
      {
        BrightnessPresetsBean.PresetBean localPresetBean = new BrightnessPresetsBean.PresetBean();
        paramThrowable = new ArrayList();
        paramThrowable.add(paramEditPresetRule.getState());
        localPresetBean.setStates(paramThrowable);
        BulbRepository.this.b5(Integer.valueOf(paramEditPresetRule.getIndex()), localPresetBean).y();
        return q.f0(Boolean.TRUE);
      }
      return q.J(paramThrowable);
    }
  }
  
  class j
    implements io.reactivex.g0.a
  {
    j() {}
    
    public void run()
      throws Exception
    {
      if (BulbRepository.f5(BulbRepository.this).getValue() != null)
      {
        BrightnessPresetsBean localBrightnessPresetsBean = (BrightnessPresetsBean)BulbRepository.f5(BulbRepository.this).getValue();
        localBrightnessPresetsBean.setSet(true);
        BulbRepository.f5(BulbRepository.this).postValue(localBrightnessPresetsBean);
      }
    }
  }
  
  class k
    implements g<OnOffGraduallyBean>
  {
    k() {}
    
    public void a(OnOffGraduallyBean paramOnOffGraduallyBean)
      throws Exception
    {
      BulbRepository.g5(BulbRepository.this).postValue(paramOnOffGraduallyBean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\repository\BulbRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
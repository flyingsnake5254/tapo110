package com.tplink.iot.g.b.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.BackgroundSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.BackgroundSetting.BackgroundSettingBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ColorSequence;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta.LightingEffectMetaBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings.LightingEffectSettingsBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
{
  private static final e a = new e();
  
  public static LightStripLightingEffect a(@NonNull LightingEffectData paramLightingEffectData)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = Integer.valueOf(1);
    Object localObject2 = a;
    ColorHSBAttributeValue localColorHSBAttributeValue = ((e)localObject2).h(paramLightingEffectData.hue_range, paramLightingEffectData.saturation_range, paramLightingEffectData.brightness_range, paramLightingEffectData.brightness);
    Object localObject3 = c(localColorHSBAttributeValue, localArrayList, (Integer)localObject1);
    Object localObject4 = paramLightingEffectData.backgrounds;
    if ((localObject4 == null) && (paramLightingEffectData.fadeoff == null))
    {
      localObject5 = null;
    }
    else
    {
      localObject5 = ((e)localObject2).b((Integer[][])localObject4);
      localObject4 = localObject3;
      if (localObject5 != null) {
        localObject4 = d(((ColorSequence)localObject5).getSeq(), localArrayList, (Integer)localObject3);
      }
      localObject6 = BackgroundSetting.builder().colors((ColorSequence)localObject5).build();
      localObject3 = localObject4;
      localObject5 = localObject6;
      if (paramLightingEffectData.fadeoff != null)
      {
        ((BackgroundSetting)localObject6).setFadeOff(LongAttributeValue.builder().absolute(Long.valueOf(paramLightingEffectData.fadeoff.intValue())).build());
        localObject5 = localObject6;
        localObject3 = localObject4;
      }
    }
    Object localObject6 = ((e)localObject2).J(paramLightingEffectData.segments, paramLightingEffectData.init_states, paramLightingEffectData.segment_length);
    localObject4 = localObject3;
    if (localObject6 != null)
    {
      localObject2 = ((List)localObject6).iterator();
      for (;;)
      {
        localObject4 = localObject3;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject4 = (Segment)((Iterator)localObject2).next();
        if (((Segment)localObject4).getInitialState() != null) {
          localObject3 = c(((Segment)localObject4).getInitialState().getColor(), localArrayList, (Integer)localObject3);
        }
      }
    }
    localObject2 = a;
    localObject3 = ((e)localObject2).L(paramLightingEffectData.sequence);
    if (localObject3 != null)
    {
      if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.r(paramLightingEffectData))
      {
        localArrayList.clear();
        localObject4 = localObject1;
      }
      d(((ColorSequence)localObject3).getSeq(), localArrayList, (Integer)localObject4);
    }
    localObject1 = ((e)localObject2).R(paramLightingEffectData.transition, paramLightingEffectData.transition_range);
    localObject4 = LightingEffectMeta.builder().alias(paramLightingEffectData.name).build();
    Object localObject5 = LightingEffectSettings.builder().direction(((e)localObject2).o(paramLightingEffectData.direction)).colorSequence((ColorSequence)localObject3).repeat(((e)localObject2).G(paramLightingEffectData.repeat_times)).transition((LongAttributeValue)localObject1).color(localColorHSBAttributeValue).background((BackgroundSetting)localObject5).spread(paramLightingEffectData.spread).build();
    if (paramLightingEffectData.duration != null) {
      ((LightingEffectSettings)localObject5).setDelay(LongAttributeValue.builder().absolute(Long.valueOf(paramLightingEffectData.duration.intValue())).build());
    }
    if (paramLightingEffectData.random_seed != null) {
      ((LightingEffectSettings)localObject5).setRandomSeed(IntegerAttributeValue.builder().absolute(paramLightingEffectData.random_seed).build());
    }
    localObject3 = ExpansionStrategy.REPEAT;
    localObject1 = paramLightingEffectData.expansion_strategy;
    if (localObject1 != null) {
      localObject3 = ((e)localObject2).q((Integer)localObject1);
    }
    return LightStripLightingEffect.builder().onOff(paramLightingEffectData.enable).id(paramLightingEffectData.id).colorRegistry(localArrayList).expansionStrategy((ExpansionStrategy)localObject3).sourceType(((e)localObject2).m(paramLightingEffectData.custom)).type(((e)localObject2).U(paramLightingEffectData.type)).settings((LightingEffectSettings)localObject5).segments((List)localObject6).meta((LightingEffectMeta)localObject4).build();
  }
  
  public static LightingEffectData b(@NonNull LightStripLightingEffect paramLightStripLightingEffect)
  {
    LightingEffectData localLightingEffectData = new LightingEffectData();
    List localList = paramLightStripLightingEffect.getColorRegistry();
    Object localObject1 = paramLightStripLightingEffect.getSegments();
    Object localObject2 = paramLightStripLightingEffect.getSettings();
    Object localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = LightingEffectSettings.builder().build();
    }
    e locale = a;
    localObject2 = locale.K((List)localObject1);
    if (localObject2 != null) {
      localLightingEffectData.segments = ((Integer[])localObject2);
    }
    if (localObject2 == null) {
      localLightingEffectData.segment_length = locale.I((List)localObject1);
    }
    localObject2 = locale.w(locale.W((List)localObject1), localList);
    if (localObject2 != null) {
      localLightingEffectData.init_states = ((Integer[][])localObject2);
    }
    localObject2 = locale.N(((LightingEffectSettings)localObject3).getColorSequence(), localList);
    if (localObject2 != null) {
      localLightingEffectData.sequence = ((Integer[][])localObject2);
    }
    if (paramLightStripLightingEffect.getId() != null) {
      localLightingEffectData.id = paramLightStripLightingEffect.getId();
    }
    if (!TextUtils.isEmpty(paramLightStripLightingEffect.getSourceType())) {
      localLightingEffectData.custom = locale.l(paramLightStripLightingEffect.getSourceType());
    }
    localLightingEffectData.name = locale.D(paramLightStripLightingEffect.getMeta());
    if (paramLightStripLightingEffect.getType() != null) {
      localLightingEffectData.type = paramLightStripLightingEffect.getType().name().toLowerCase();
    }
    if (paramLightStripLightingEffect.getOnOff() != null) {
      localLightingEffectData.enable = paramLightStripLightingEffect.getOnOff();
    }
    if (((LightingEffectSettings)localObject3).getDirection() != null) {
      localLightingEffectData.direction = locale.p(((LightingEffectSettings)localObject3).getDirection());
    }
    if (((LightingEffectSettings)localObject3).getDelay() != null) {
      localLightingEffectData.duration = locale.n(((LightingEffectSettings)localObject3).getDelay());
    }
    if (((LightingEffectSettings)localObject3).getSpread() != null) {
      localLightingEffectData.spread = ((LightingEffectSettings)localObject3).getSpread();
    }
    if (((LightingEffectSettings)localObject3).getRepeat() != null) {
      localLightingEffectData.repeat_times = locale.F(((LightingEffectSettings)localObject3).getRepeat());
    }
    if (((LightingEffectSettings)localObject3).getRandomSeed() != null) {
      localLightingEffectData.random_seed = locale.E(((LightingEffectSettings)localObject3).getRandomSeed());
    }
    localLightingEffectData.expansion_strategy = locale.r(paramLightStripLightingEffect.getExpansionStrategy());
    localObject1 = ((LightingEffectSettings)localObject3).getBackground();
    localObject2 = null;
    if (localObject1 != null) {
      paramLightStripLightingEffect = locale.c(((BackgroundSetting)localObject1).getColors(), localList);
    } else {
      paramLightStripLightingEffect = null;
    }
    localLightingEffectData.backgrounds = paramLightStripLightingEffect;
    paramLightStripLightingEffect = (LightStripLightingEffect)localObject2;
    if (localObject1 != null)
    {
      paramLightStripLightingEffect = (LightStripLightingEffect)localObject2;
      if (((BackgroundSetting)localObject1).getFadeOff() != null) {
        paramLightStripLightingEffect = locale.s(((BackgroundSetting)localObject1).getFadeOff());
      }
    }
    localLightingEffectData.fadeoff = paramLightStripLightingEffect;
    paramLightStripLightingEffect = ((LightingEffectSettings)localObject3).getTransition();
    localLightingEffectData.transition = locale.S(paramLightStripLightingEffect);
    localLightingEffectData.transition_range = locale.T(paramLightStripLightingEffect);
    paramLightStripLightingEffect = ((LightingEffectSettings)localObject3).getColor();
    localLightingEffectData.hue_range = locale.u(paramLightStripLightingEffect, localList);
    localLightingEffectData.saturation_range = locale.H(paramLightStripLightingEffect, localList);
    localLightingEffectData.brightness_range = locale.f(paramLightStripLightingEffect, localList);
    return localLightingEffectData;
  }
  
  private static Integer c(ColorHSBAttributeValue paramColorHSBAttributeValue, List<ColorHSBAttributeValue> paramList, Integer paramInteger)
  {
    return a.X(paramColorHSBAttributeValue, paramList, paramInteger);
  }
  
  private static Integer d(List<ColorHSBAttributeValue> paramList1, List<ColorHSBAttributeValue> paramList2, Integer paramInteger)
  {
    return a.Y(paramList1, paramList2, paramInteger);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
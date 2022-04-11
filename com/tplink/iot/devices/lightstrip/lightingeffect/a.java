package com.tplink.iot.devices.lightstrip.lightingeffect;

import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter.a;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.a.b;
import com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.e;
import com.tplink.iot.g.b.b.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect.CustomizedEffectBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta.LightingEffectMetaBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect.PredefinedEffectBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.LightingEffectRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.j;

public final class a
{
  private static final IntegerAttributeValue a;
  public static final a b = new a();
  
  static
  {
    IntegerAttributeValue localIntegerAttributeValue = new IntegerAttributeValue();
    localIntegerAttributeValue.setAbsolute(Integer.valueOf(50));
    a = localIntegerAttributeValue;
  }
  
  private final boolean e(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) && (j.a("Lightning", paramString))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private final void h(CustomizedEffect paramCustomizedEffect, String paramString)
  {
    paramCustomizedEffect.setMeta(LightingEffectMeta.builder().alias(paramString).build());
  }
  
  public final void a(boolean paramBoolean, CustomizedEffect paramCustomizedEffect)
  {
    j.e(paramCustomizedEffect, "effect");
    b.d.b.f.a locala = b.d.b.f.b.a(b.d.s.a.a.f(), LightingEffectRepository.class);
    j.d(locala, "CloudRepositoryProviders…ctRepository::class.java)");
    b(paramBoolean, paramCustomizedEffect, new a((LightingEffectRepository)locala));
  }
  
  public final void b(boolean paramBoolean, CustomizedEffect paramCustomizedEffect, kotlin.jvm.b.l<? super String, ? extends PredefinedEffect> paraml)
  {
    j.e(paramCustomizedEffect, "effect");
    j.e(paraml, "predefinedEffectGetter");
    Object localObject1 = paramCustomizedEffect.getPredefinedEffectId();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = (PredefinedEffect)paraml.invoke(localObject1);
    } else {
      localObject1 = null;
    }
    paraml = (kotlin.jvm.b.l<? super String, ? extends PredefinedEffect>)localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((AbstractLightingEffect)localObject1).getMeta();
      paraml = (kotlin.jvm.b.l<? super String, ? extends PredefinedEffect>)localObject2;
      if (localObject1 != null) {
        paraml = ((LightingEffectMeta)localObject1).getAlias();
      }
    }
    if (e(paramBoolean, paraml))
    {
      paramCustomizedEffect = paramCustomizedEffect.getSettings();
      if (paramCustomizedEffect != null) {
        paramCustomizedEffect.setRandomSeed(a);
      }
    }
  }
  
  public final void c(boolean paramBoolean, PredefinedEffect paramPredefinedEffect)
  {
    j.e(paramPredefinedEffect, "effect");
    Object localObject = paramPredefinedEffect.getMeta();
    if (localObject != null) {
      localObject = ((LightingEffectMeta)localObject).getAlias();
    } else {
      localObject = null;
    }
    if (e(paramBoolean, (String)localObject))
    {
      paramPredefinedEffect = paramPredefinedEffect.getSettings();
      if (paramPredefinedEffect != null) {
        paramPredefinedEffect.setRandomSeed(a);
      }
    }
  }
  
  public final CustomizedEffect d(String paramString, List<ColorPaintingSegment> paramList)
  {
    j.e(paramString, "effectName");
    j.e(paramList, "segments");
    Object localObject = new ArrayList(kotlin.collections.l.l(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((Collection)localObject).add(((ColorPaintingSegment)paramList.next()).e());
    }
    paramList = com.tplink.iot.devices.lightstrip.lightingeffect.common.a.a().h(Integer.valueOf(1)).g((List)localObject).f();
    paramList = new e().Q(paramList);
    localObject = CustomizedEffect.builder();
    j.d(paramList, "effect");
    paramList = ((CustomizedEffect.CustomizedEffectBuilder)localObject).colorRegistry(paramList.getColorRegistry()).customization(paramList.getCustomization()).expansionStrategy(paramList.getExpansionStrategy()).segments(paramList.getSegments()).type(paramList.getType()).settings(paramList.getSettings()).build();
    j.d(paramList, "customEffect");
    h(paramList, paramString);
    com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.E(paramList, true);
    paramString = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.s(paramList);
    Objects.requireNonNull(paramString, "null cannot be cast to non-null type com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect");
    return (CustomizedEffect)paramString;
  }
  
  public final List<com.tplink.iot.g.b.b.e.a> f(List<? extends LightStateBean> paramList)
  {
    j.e(paramList, "presets");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (LightStateBean)paramList.next();
      Object localObject2 = ((LightStateBean)localObject1).getLightingEffectData();
      if (localObject2 != null)
      {
        Object localObject3 = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.t((LightingEffectData)localObject2);
        Object localObject4;
        if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.r((LightingEffectData)localObject2))
        {
          localObject3 = g((List)localObject3);
          localObject1 = (List)((Pair)localObject3).component1();
          localObject4 = (List)((Pair)localObject3).component2();
          localObject3 = CustomizedEffect.builder().id(((LightingEffectData)localObject2).id).build();
          localObject1 = new com.tplink.iot.g.b.b.a("", kotlin.collections.l.U((Collection)localObject1), kotlin.collections.l.U((Collection)localObject4), (CustomizedEffect)localObject3);
          ((com.tplink.iot.g.b.b.a)localObject1).i((LightingEffectData)localObject2);
          localArrayList.add(localObject1);
        }
        else
        {
          localObject1 = PredefinedEffectsAdapter.h.b(((LightingEffectData)localObject2).name);
          localObject4 = ((LightingEffectData)localObject2).custom;
          if ((localObject4 != null) && (((Integer)localObject4).intValue() == 0) && (localObject1 != null))
          {
            localObject3 = PredefinedEffect.builder().id(((LightingEffectData)localObject2).id).build();
            localObject1 = new com.tplink.iot.g.b.b.d(((com.tplink.iot.g.b.b.d)localObject1).h(), ((com.tplink.iot.g.b.b.d)localObject1).d(), (PredefinedEffect)localObject3);
            ((com.tplink.iot.g.b.b.d)localObject1).m((LightingEffectData)localObject2);
            localArrayList.add(localObject1);
          }
          else
          {
            localObject1 = CustomizedEffect.builder().id(((LightingEffectData)localObject2).id).build();
            localObject1 = new com.tplink.iot.g.b.b.b("", kotlin.collections.l.U((Collection)localObject3), (CustomizedEffect)localObject1);
            ((com.tplink.iot.g.b.b.b)localObject1).h((LightingEffectData)localObject2);
            localArrayList.add(localObject1);
          }
        }
      }
      else
      {
        localObject2 = new LightStateBean(((LightStateBean)localObject1).getHue(), ((LightStateBean)localObject1).getSaturation(), ((LightStateBean)localObject1).getColorTemp(), ((LightStateBean)localObject1).getBrightness());
        localArrayList.add(new c(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.v((LightStateBean)localObject2), (LightStateBean)localObject2));
      }
    }
    return localArrayList;
  }
  
  public final Pair<List<Integer>, List<Integer>> g(List<Integer> paramList)
  {
    j.e(paramList, "colorList");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Number)localIterator.next()).intValue();
      if ((paramList == null) || (j != paramList.intValue()))
      {
        localArrayList1.add(Integer.valueOf(j));
        if (paramList != null) {
          localArrayList2.add(Integer.valueOf(i));
        }
        paramList = Integer.valueOf(j);
        i = 1;
      }
      else
      {
        i++;
      }
    }
    localArrayList2.add(Integer.valueOf(i));
    return new Pair(localArrayList1, localArrayList2);
  }
  
  public final CustomizedEffect i(String paramString, CustomizedEffect paramCustomizedEffect, List<ColorPaintingSegment> paramList)
  {
    j.e(paramString, "effectName");
    j.e(paramCustomizedEffect, "originEffect");
    j.e(paramList, "newColorSegments");
    Object localObject = new ArrayList(kotlin.collections.l.l(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((Collection)localObject).add(((ColorPaintingSegment)paramList.next()).e());
    }
    paramList = com.tplink.iot.devices.lightstrip.lightingeffect.common.a.a().h(Integer.valueOf(1)).g((List)localObject).f();
    LightStripLightingEffect localLightStripLightingEffect = new e().Q(paramList);
    j.d(localLightStripLightingEffect, "updatedEffect");
    paramCustomizedEffect.setColorRegistry(localLightStripLightingEffect.getColorRegistry());
    localObject = paramCustomizedEffect.getSettings();
    if (localObject != null)
    {
      paramList = localLightStripLightingEffect.getSettings();
      if (paramList != null) {
        paramList = paramList.getColorSequence();
      } else {
        paramList = null;
      }
      ((LightingEffectSettings)localObject).setColorSequence(paramList);
    }
    paramCustomizedEffect.setSegments(localLightStripLightingEffect.getSegments());
    com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.E(paramCustomizedEffect, false);
    b.h(paramCustomizedEffect, paramString);
    paramString = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.s(paramCustomizedEffect);
    Objects.requireNonNull(paramString, "null cannot be cast to non-null type com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect");
    return (CustomizedEffect)paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
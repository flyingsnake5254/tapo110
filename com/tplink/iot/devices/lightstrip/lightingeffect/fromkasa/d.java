package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

import androidx.annotation.ColorInt;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.LEColor;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.PredefinedEffectsTemplateInput;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.PredefinedEffectsTemplateInputKt;
import com.tplink.iot.devices.lightstrip.lightingeffect.template.Speed;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue.ColorHSBAttributeValueBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ColorSequence;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ColorSequence.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizationSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect.CustomizedEffectBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings.LightingEffectSettingsBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect.PredefinedEffectBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment.SegmentBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.b0;
import kotlin.jvm.internal.j;
import kotlin.n;
import kotlin.text.m;
import kotlin.u.c.a;

public final class d
{
  public static final LightStripLightingEffect A(PredefinedEffect paramPredefinedEffect)
  {
    j.e(paramPredefinedEffect, "$this$transform");
    paramPredefinedEffect = LightStripLightingEffect.builder().sourceType(LightingEffectType.PREDEFINED.getValue()).onOff(Integer.valueOf(1)).id(paramPredefinedEffect.getId()).createdOn(paramPredefinedEffect.getCreatedOn()).updatedOn(paramPredefinedEffect.getUpdatedOn()).expansionStrategy(paramPredefinedEffect.getExpansionStrategy()).meta(paramPredefinedEffect.getMeta()).settings(paramPredefinedEffect.getSettings()).type(paramPredefinedEffect.getType()).segments(paramPredefinedEffect.getSegments()).colorRegistry(paramPredefinedEffect.getColorRegistry()).customization(paramPredefinedEffect.getCustomization()).animationType(paramPredefinedEffect.getAnimationType()).version(paramPredefinedEffect.getVersion()).build();
    j.d(paramPredefinedEffect, "LightStripLightingEffect…ion)\n            .build()");
    return paramPredefinedEffect;
  }
  
  public static final LightingEffectData B(CustomizedEffect paramCustomizedEffect)
  {
    j.e(paramCustomizedEffect, "$this$transformIntoData");
    int i = j(paramCustomizedEffect);
    LightingEffectData localLightingEffectData = com.tplink.iot.g.b.c.d.b(z(paramCustomizedEffect));
    localLightingEffectData.display_colors = m(paramCustomizedEffect);
    localLightingEffectData.brightness = Integer.valueOf(i);
    j.d(localLightingEffectData, "LightingEffectUtils.conv…= overallBrightness\n    }");
    return localLightingEffectData;
  }
  
  public static final LightingEffectData C(PredefinedEffect paramPredefinedEffect)
  {
    j.e(paramPredefinedEffect, "$this$transformIntoData");
    int i = k(paramPredefinedEffect);
    LightingEffectData localLightingEffectData = com.tplink.iot.g.b.c.d.b(A(paramPredefinedEffect));
    localLightingEffectData.display_colors = m(paramPredefinedEffect);
    localLightingEffectData.brightness = Integer.valueOf(i);
    j.d(localLightingEffectData, "LightingEffectUtils.conv…= overallBrightness\n    }");
    return localLightingEffectData;
  }
  
  public static final LightStripLightingEffect D(LightingEffectData paramLightingEffectData)
  {
    j.e(paramLightingEffectData, "$this$transformIntoEffect");
    paramLightingEffectData = com.tplink.iot.g.b.c.d.a(paramLightingEffectData);
    j.d(paramLightingEffectData, "LightingEffectUtils.convert(this)");
    return paramLightingEffectData;
  }
  
  public static final void E(CustomizedEffect paramCustomizedEffect, boolean paramBoolean)
  {
    j.e(paramCustomizedEffect, "$this$updateTimeInfo");
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      paramCustomizedEffect.setCreatedOn(Long.valueOf(l));
      paramCustomizedEffect.setUpdatedOn(Long.valueOf(l));
    }
    else
    {
      paramCustomizedEffect.setUpdatedOn(Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public static final CustomizedEffect a(CustomizedEffect paramCustomizedEffect, boolean paramBoolean)
  {
    j.e(paramCustomizedEffect, "$this$adjustIfNeed");
    com.tplink.iot.devices.lightstrip.lightingeffect.a.b.a(paramBoolean, paramCustomizedEffect);
    return paramCustomizedEffect;
  }
  
  public static final CustomizedEffect b(CustomizedEffect paramCustomizedEffect, boolean paramBoolean, kotlin.jvm.b.l<? super String, ? extends PredefinedEffect> paraml)
  {
    j.e(paramCustomizedEffect, "$this$adjustIfNeed");
    j.e(paraml, "predefinedEffectGetter");
    com.tplink.iot.devices.lightstrip.lightingeffect.a.b.b(paramBoolean, paramCustomizedEffect, paraml);
    return paramCustomizedEffect;
  }
  
  public static final PredefinedEffect c(PredefinedEffect paramPredefinedEffect, boolean paramBoolean)
  {
    j.e(paramPredefinedEffect, "$this$adjustIfNeed");
    com.tplink.iot.devices.lightstrip.lightingeffect.a.b.c(paramBoolean, paramPredefinedEffect);
    return paramPredefinedEffect;
  }
  
  public static final AbstractLightingEffect d(AbstractLightingEffect paramAbstractLightingEffect)
  {
    j.e(paramAbstractLightingEffect, "$this$copy");
    if ((paramAbstractLightingEffect instanceof CustomizedEffect))
    {
      localObject1 = CustomizedEffect.builder();
      paramAbstractLightingEffect = (CustomizedEffect)paramAbstractLightingEffect;
      localObject2 = ((CustomizedEffect.CustomizedEffectBuilder)localObject1).id(paramAbstractLightingEffect.getId()).accountId(paramAbstractLightingEffect.getAccountId()).predefinedEffectId(paramAbstractLightingEffect.getPredefinedEffectId()).templateInput(paramAbstractLightingEffect.getTemplateInput()).createdOn(paramAbstractLightingEffect.getCreatedOn()).updatedOn(paramAbstractLightingEffect.getUpdatedOn()).expansionStrategy(paramAbstractLightingEffect.getExpansionStrategy()).meta(paramAbstractLightingEffect.getMeta());
      localObject1 = paramAbstractLightingEffect.getSettings();
      j.d(localObject1, "settings");
      paramAbstractLightingEffect = ((CustomizedEffect.CustomizedEffectBuilder)localObject2).settings(f((LightingEffectSettings)localObject1)).type(paramAbstractLightingEffect.getType()).segments(paramAbstractLightingEffect.getSegments()).colorRegistry(paramAbstractLightingEffect.getColorRegistry()).customization(paramAbstractLightingEffect.getCustomization()).animationType(paramAbstractLightingEffect.getAnimationType()).version(paramAbstractLightingEffect.getVersion()).build();
      j.d(paramAbstractLightingEffect, "CustomizedEffect.builder…                 .build()");
      return paramAbstractLightingEffect;
    }
    if ((paramAbstractLightingEffect instanceof PredefinedEffect))
    {
      localObject1 = PredefinedEffect.builder();
      paramAbstractLightingEffect = (PredefinedEffect)paramAbstractLightingEffect;
      localObject2 = ((PredefinedEffect.PredefinedEffectBuilder)localObject1).id(paramAbstractLightingEffect.getId()).createdOn(paramAbstractLightingEffect.getCreatedOn()).updatedOn(paramAbstractLightingEffect.getUpdatedOn()).expansionStrategy(paramAbstractLightingEffect.getExpansionStrategy()).meta(paramAbstractLightingEffect.getMeta());
      localObject1 = paramAbstractLightingEffect.getSettings();
      j.d(localObject1, "settings");
      paramAbstractLightingEffect = ((PredefinedEffect.PredefinedEffectBuilder)localObject2).settings(f((LightingEffectSettings)localObject1)).type(paramAbstractLightingEffect.getType()).segments(paramAbstractLightingEffect.getSegments()).colorRegistry(paramAbstractLightingEffect.getColorRegistry()).customization(paramAbstractLightingEffect.getCustomization()).animationType(paramAbstractLightingEffect.getAnimationType()).version(paramAbstractLightingEffect.getVersion()).active(paramAbstractLightingEffect.getActive()).build();
      j.d(paramAbstractLightingEffect, "PredefinedEffect.builder…                 .build()");
      return paramAbstractLightingEffect;
    }
    Object localObject1 = y(paramAbstractLightingEffect);
    Object localObject2 = LightStripLightingEffect.builder().sourceType(((LightStripLightingEffect)localObject1).getSourceType()).onOff(((LightStripLightingEffect)localObject1).getOnOff()).id(((AbstractLightingEffect)localObject1).getId()).createdOn(((AbstractLightingEffect)localObject1).getCreatedOn()).updatedOn(((AbstractLightingEffect)localObject1).getUpdatedOn()).expansionStrategy(((AbstractLightingEffect)localObject1).getExpansionStrategy()).meta(((AbstractLightingEffect)localObject1).getMeta());
    paramAbstractLightingEffect = ((AbstractLightingEffect)localObject1).getSettings();
    j.d(paramAbstractLightingEffect, "deviceEffect.settings");
    paramAbstractLightingEffect = ((LightStripLightingEffect.Builder)localObject2).settings(f(paramAbstractLightingEffect)).type(((AbstractLightingEffect)localObject1).getType()).segments(((AbstractLightingEffect)localObject1).getSegments()).colorRegistry(((AbstractLightingEffect)localObject1).getColorRegistry()).customization(((AbstractLightingEffect)localObject1).getCustomization()).animationType(((AbstractLightingEffect)localObject1).getAnimationType()).version(((AbstractLightingEffect)localObject1).getVersion()).build();
    j.d(paramAbstractLightingEffect, "LightStripLightingEffect…                 .build()");
    return paramAbstractLightingEffect;
  }
  
  private static final ColorSequence e(ColorSequence paramColorSequence)
  {
    paramColorSequence = ColorSequence.builder().sortBy(paramColorSequence.getSortBy()).order(paramColorSequence.getOrder()).seq(paramColorSequence.getSeq()).build();
    j.d(paramColorSequence, "ColorSequence.builder()\n…seq)\n            .build()");
    return paramColorSequence;
  }
  
  private static final LightingEffectSettings f(LightingEffectSettings paramLightingEffectSettings)
  {
    LightingEffectSettings.LightingEffectSettingsBuilder localLightingEffectSettingsBuilder = LightingEffectSettings.builder().transition(paramLightingEffectSettings.getTransition()).delay(paramLightingEffectSettings.getDelay()).color(paramLightingEffectSettings.getColor()).randomSeed(paramLightingEffectSettings.getRandomSeed()).background(paramLightingEffectSettings.getBackground());
    ColorSequence localColorSequence = paramLightingEffectSettings.getColorSequence();
    j.d(localColorSequence, "this.colorSequence");
    paramLightingEffectSettings = localLightingEffectSettingsBuilder.colorSequence(e(localColorSequence)).spread(paramLightingEffectSettings.getSpread()).repeat(paramLightingEffectSettings.getRepeat()).direction(paramLightingEffectSettings.getDirection()).build();
    j.d(paramLightingEffectSettings, "LightingEffectSettings.b…ion)\n            .build()");
    return paramLightingEffectSettings;
  }
  
  private static final AbstractLightingEffect g(int paramInt, AbstractLightingEffect paramAbstractLightingEffect)
  {
    List localList1 = paramAbstractLightingEffect.getSegments();
    int i = localList1.size();
    Object localObject1 = paramAbstractLightingEffect.getSettings();
    j.d(localObject1, "lightingEffect.settings");
    localObject1 = ((LightingEffectSettings)localObject1).getColorSequence();
    j.d(localObject1, "lightingEffect.settings.colorSequence");
    List localList2 = ((ColorSequence)localObject1).getSeq();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    Object localObject2 = (ColorHSBAttributeValue)localList2.get(0);
    localObject1 = (Segment)localList1.get(0);
    j.d(localObject1, "repeatSegment");
    Integer localInteger = ((Segment)localObject1).getStart();
    localObject1 = ((Segment)localObject1).getEnd();
    while (localInteger.intValue() < paramInt)
    {
      ColorHSBAttributeValue.ColorHSBAttributeValueBuilder localColorHSBAttributeValueBuilder = ColorHSBAttributeValue.builder();
      j.d(localObject2, "repeatColorSequence");
      localObject2 = localColorHSBAttributeValueBuilder.id(((ColorHSBAttributeValue)localObject2).getId()).h(((ColorHSBAttributeValue)localObject2).getH()).s(((ColorHSBAttributeValue)localObject2).getS()).b(((ColorHSBAttributeValue)localObject2).getB()).build();
      j.d(localObject2, "newColorSequence");
      localArrayList2.add(localObject2);
      localObject2 = new Segment();
      localArrayList1.add(localObject2);
      ((Segment)localObject2).setStart(localInteger);
      if (((Integer)localObject1).intValue() < paramInt)
      {
        ((Segment)localObject2).setEnd((Integer)localObject1);
        j = (j + 1) % i;
        localObject2 = (Segment)localList1.get(j);
        localInteger = Integer.valueOf(((Integer)localObject1).intValue() + 1);
        int k = localInteger.intValue();
        j.d(localObject2, "repeatSegment");
        localObject1 = ((Segment)localObject2).getEnd();
        j.d(localObject1, "repeatSegment.end");
        int m = ((Integer)localObject1).intValue();
        localObject1 = ((Segment)localObject2).getStart();
        j.d(localObject1, "repeatSegment.start");
        localObject1 = Integer.valueOf(k + m - ((Integer)localObject1).intValue());
        localObject2 = (ColorHSBAttributeValue)localList2.get(j);
      }
      else
      {
        ((Segment)localObject2).setEnd(Integer.valueOf(paramInt - 1));
      }
    }
    paramAbstractLightingEffect.setSegments(localArrayList1);
    localObject1 = paramAbstractLightingEffect.getSettings();
    j.d(localObject1, "lightingEffect.settings");
    localObject1 = ((LightingEffectSettings)localObject1).getColorSequence();
    j.d(localObject1, "lightingEffect.settings.colorSequence");
    ((ColorSequence)localObject1).setSeq(localArrayList2);
    return paramAbstractLightingEffect;
  }
  
  public static final AbstractLightingEffect h(AbstractLightingEffect paramAbstractLightingEffect, int paramInt, ExpansionStrategy paramExpansionStrategy)
  {
    j.e(paramAbstractLightingEffect, "$this$expandColorPaintingEffect");
    j.e(paramExpansionStrategy, "expansionStrategy");
    if (c.a[paramExpansionStrategy.ordinal()] == 1) {
      paramAbstractLightingEffect = g(paramInt, paramAbstractLightingEffect);
    }
    return paramAbstractLightingEffect;
  }
  
  private static final int i(PredefinedEffectsTemplateInput paramPredefinedEffectsTemplateInput)
  {
    if (paramPredefinedEffectsTemplateInput != null)
    {
      paramPredefinedEffectsTemplateInput = paramPredefinedEffectsTemplateInput.getColors();
      if (paramPredefinedEffectsTemplateInput != null)
      {
        Iterator localIterator = paramPredefinedEffectsTemplateInput.iterator();
        while (localIterator.hasNext())
        {
          paramPredefinedEffectsTemplateInput = localIterator.next();
          if (((LEColor)paramPredefinedEffectsTemplateInput).getB() != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            break label62;
          }
        }
        paramPredefinedEffectsTemplateInput = null;
        label62:
        paramPredefinedEffectsTemplateInput = (LEColor)paramPredefinedEffectsTemplateInput;
        if (paramPredefinedEffectsTemplateInput != null)
        {
          paramPredefinedEffectsTemplateInput = paramPredefinedEffectsTemplateInput.getB();
          if (paramPredefinedEffectsTemplateInput != null) {
            return paramPredefinedEffectsTemplateInput.intValue();
          }
        }
      }
    }
    int i = 100;
    return i;
  }
  
  public static final int j(CustomizedEffect paramCustomizedEffect)
  {
    j.e(paramCustomizedEffect, "$this$findOverallBrightness");
    int i;
    if (q(paramCustomizedEffect))
    {
      paramCustomizedEffect = paramCustomizedEffect.getColorRegistry();
      if (paramCustomizedEffect != null)
      {
        Iterator localIterator = paramCustomizedEffect.iterator();
        Object localObject2;
        do
        {
          boolean bool = localIterator.hasNext();
          paramCustomizedEffect = null;
          Object localObject1 = null;
          if (!bool) {
            break;
          }
          localObject2 = localIterator.next();
          paramCustomizedEffect = (ColorHSBAttributeValue)localObject2;
          j.d(paramCustomizedEffect, "it");
          IntegerAttributeValue localIntegerAttributeValue = paramCustomizedEffect.getB();
          paramCustomizedEffect = (CustomizedEffect)localObject1;
          if (localIntegerAttributeValue != null) {
            paramCustomizedEffect = localIntegerAttributeValue.getAbsolute();
          }
          if (paramCustomizedEffect != null) {
            i = 1;
          } else {
            i = 0;
          }
        } while (i == 0);
        paramCustomizedEffect = (CustomizedEffect)localObject2;
        paramCustomizedEffect = (ColorHSBAttributeValue)paramCustomizedEffect;
        if (paramCustomizedEffect != null)
        {
          paramCustomizedEffect = paramCustomizedEffect.getB();
          if (paramCustomizedEffect != null)
          {
            paramCustomizedEffect = paramCustomizedEffect.getAbsolute();
            if (paramCustomizedEffect != null)
            {
              i = paramCustomizedEffect.intValue();
              break label158;
            }
          }
        }
      }
      i = 100;
    }
    else
    {
      i = i(w(paramCustomizedEffect));
    }
    label158:
    return i;
  }
  
  public static final int k(PredefinedEffect paramPredefinedEffect)
  {
    j.e(paramPredefinedEffect, "$this$findOverallBrightness");
    return i(w(paramPredefinedEffect));
  }
  
  private static final PredefinedEffectsTemplateInput l(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList(paramInt);
    for (int i = 0; i < paramInt; i++) {
      localArrayList1.add(Integer.valueOf(kotlin.u.c.b.d(0, 360)));
    }
    ArrayList localArrayList2 = new ArrayList(paramInt);
    for (i = 0; i < paramInt; i++) {
      localArrayList2.add(Integer.valueOf(kotlin.u.c.b.d(0, 100)));
    }
    ArrayList localArrayList3 = new ArrayList();
    for (i = 0; i < paramInt; i++) {
      localArrayList3.add(new LEColor(Integer.valueOf(((Number)localArrayList1.get(i)).intValue()), Integer.valueOf(((Number)localArrayList2.get(i)).intValue()), null));
    }
    return new PredefinedEffectsTemplateInput(localArrayList3, new Speed(Integer.valueOf(kotlin.u.c.b.d(0, 100))), 0, 4, null);
  }
  
  private static final Integer[][] m(AbstractLightingEffect paramAbstractLightingEffect)
  {
    Integer localInteger;
    label76:
    Object localObject2;
    label104:
    Object localObject3;
    if (q(paramAbstractLightingEffect))
    {
      ArrayList localArrayList = new ArrayList();
      paramAbstractLightingEffect = paramAbstractLightingEffect.getColorRegistry();
      if (paramAbstractLightingEffect != null)
      {
        Iterator localIterator = paramAbstractLightingEffect.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (ColorHSBAttributeValue)localIterator.next();
          localInteger = null;
          if (localObject1 != null)
          {
            paramAbstractLightingEffect = ((ColorHSBAttributeValue)localObject1).getH();
            if (paramAbstractLightingEffect != null)
            {
              paramAbstractLightingEffect = paramAbstractLightingEffect.getAbsolute();
              break label76;
            }
          }
          paramAbstractLightingEffect = null;
          if (localObject1 != null)
          {
            localObject2 = ((ColorHSBAttributeValue)localObject1).getS();
            if (localObject2 != null)
            {
              localObject2 = ((IntegerAttributeValue)localObject2).getAbsolute();
              break label104;
            }
          }
          localObject2 = null;
          localObject3 = localInteger;
          if (localObject1 != null)
          {
            localObject1 = ((ColorHSBAttributeValue)localObject1).getB();
            localObject3 = localInteger;
            if (localObject1 != null) {
              localObject3 = ((IntegerAttributeValue)localObject1).getAbsolute();
            }
          }
          if ((paramAbstractLightingEffect != null) && (localObject2 != null) && (localObject3 != null)) {
            localArrayList.add(new Integer[] { paramAbstractLightingEffect, localObject2, localObject3 });
          }
        }
      }
      paramAbstractLightingEffect = kotlin.collections.l.P(localArrayList, 4).toArray(new Integer[0][]);
      Objects.requireNonNull(paramAbstractLightingEffect, "null cannot be cast to non-null type kotlin.Array<T>");
      return (Integer[][])paramAbstractLightingEffect;
    }
    paramAbstractLightingEffect = w(paramAbstractLightingEffect);
    if (paramAbstractLightingEffect != null)
    {
      localObject2 = paramAbstractLightingEffect.getColors();
      if (localObject2 != null)
      {
        paramAbstractLightingEffect = new ArrayList(kotlin.collections.l.l((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (LEColor)((Iterator)localObject2).next();
          localInteger = ((LEColor)localObject3).getH();
          int i;
          if (localInteger != null) {
            i = localInteger.intValue();
          } else {
            i = 0;
          }
          localInteger = ((LEColor)localObject3).getS();
          int j;
          if (localInteger != null) {
            j = localInteger.intValue();
          } else {
            j = 0;
          }
          localObject3 = ((LEColor)localObject3).getB();
          int k;
          if (localObject3 != null) {
            k = ((Integer)localObject3).intValue();
          } else {
            k = 100;
          }
          paramAbstractLightingEffect.add(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
        }
        paramAbstractLightingEffect = paramAbstractLightingEffect.toArray(new Integer[0][]);
        Objects.requireNonNull(paramAbstractLightingEffect, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Integer[][])paramAbstractLightingEffect;
      }
    }
    paramAbstractLightingEffect = new Integer[0][];
    return paramAbstractLightingEffect;
  }
  
  private static final List<Integer> n(ColorSequence paramColorSequence, List<? extends ColorHSBAttributeValue> paramList)
  {
    new ArrayList();
    Integer[][] arrayOfInteger = new e().N(paramColorSequence, paramList);
    paramList = new ArrayList();
    if (arrayOfInteger != null)
    {
      int i = arrayOfInteger.length;
      for (int j = 0; j < i; j++)
      {
        paramColorSequence = arrayOfInteger[j];
        paramList.add(Integer.valueOf(PredefinedEffectsTemplateInputKt.toColorInt(new LEColor(paramColorSequence[0], paramColorSequence[1], Integer.valueOf(100)))));
      }
    }
    return paramList;
  }
  
  public static final List<Integer> o(CustomizedEffect paramCustomizedEffect)
  {
    j.e(paramCustomizedEffect, "$this$getColorsForCustomIcon");
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (q(paramCustomizedEffect))
    {
      localObject = x(paramCustomizedEffect);
      paramCustomizedEffect = ((AbstractLightingEffect)localObject).getSettings();
      j.d(paramCustomizedEffect, "splitSegmentEffect.settings");
      paramCustomizedEffect = paramCustomizedEffect.getColorSequence();
      j.d(paramCustomizedEffect, "splitSegmentEffect.settings.colorSequence");
      localObject = ((AbstractLightingEffect)localObject).getColorRegistry();
      j.d(localObject, "splitSegmentEffect.colorRegistry");
      localArrayList.addAll(n(paramCustomizedEffect, (List)localObject));
    }
    else
    {
      paramCustomizedEffect = w(paramCustomizedEffect);
      localObject = null;
      if (paramCustomizedEffect != null) {
        paramCustomizedEffect = paramCustomizedEffect.getColors();
      } else {
        paramCustomizedEffect = null;
      }
      if (paramCustomizedEffect != null) {
        localObject = kotlin.collections.l.O(paramCustomizedEffect, new a());
      }
      if (localObject != null)
      {
        paramCustomizedEffect = ((Iterable)localObject).iterator();
        while (paramCustomizedEffect.hasNext()) {
          localArrayList.add(Integer.valueOf(PredefinedEffectsTemplateInputKt.toColorInt(LEColor.copy$default((LEColor)paramCustomizedEffect.next(), null, null, Integer.valueOf(100), 3, null))));
        }
      }
    }
    return localArrayList;
  }
  
  public static final int p(LightingEffectData paramLightingEffectData)
  {
    j.e(paramLightingEffectData, "$this$getOverallBrightness");
    paramLightingEffectData = paramLightingEffectData.brightness;
    int i;
    if (paramLightingEffectData != null) {
      i = paramLightingEffectData.intValue();
    } else {
      i = 100;
    }
    return i;
  }
  
  public static final boolean q(AbstractLightingEffect paramAbstractLightingEffect)
  {
    j.e(paramAbstractLightingEffect, "$this$isColorPaintingEffect");
    String str = Type.STATIC.toString();
    paramAbstractLightingEffect = paramAbstractLightingEffect.getType();
    if (paramAbstractLightingEffect != null) {
      paramAbstractLightingEffect = paramAbstractLightingEffect.toString();
    } else {
      paramAbstractLightingEffect = null;
    }
    return j.a(str, paramAbstractLightingEffect);
  }
  
  public static final boolean r(LightingEffectData paramLightingEffectData)
  {
    j.e(paramLightingEffectData, "$this$isColorPaintingEffect");
    return m.q(paramLightingEffectData.type, Type.STATIC.toString(), true);
  }
  
  public static final AbstractLightingEffect s(AbstractLightingEffect paramAbstractLightingEffect)
  {
    Object localObject1 = paramAbstractLightingEffect;
    j.e(localObject1, "$this$mergeColorPaintingSegments");
    Object localObject2 = paramAbstractLightingEffect.getSegments();
    Object localObject3 = paramAbstractLightingEffect.getSettings();
    if (localObject3 != null)
    {
      localObject3 = ((LightingEffectSettings)localObject3).getColorSequence();
      if (localObject3 != null)
      {
        localObject3 = ((ColorSequence)localObject3).getSeq();
        break label42;
      }
    }
    localObject3 = null;
    label42:
    int i;
    if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject4 = localObject1;
    if (i == 0)
    {
      if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        localObject4 = localObject1;
      }
      else
      {
        localObject4 = paramAbstractLightingEffect.getColorRegistry();
        j.d(localObject4, "colorRegistry");
        localObject1 = new ArrayList(kotlin.collections.l.l((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ColorHSBAttributeValue)((Iterator)localObject4).next();
          j.d(localObject5, "it");
          ((Collection)localObject1).add(n.a(((ColorHSBAttributeValue)localObject5).getId(), localObject5));
        }
        Map localMap = b0.k((Iterable)localObject1);
        b localb = b.c;
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject5 = (Segment)kotlin.collections.l.x((List)localObject2);
        localObject1 = (ColorHSBAttributeValue)kotlin.collections.l.x((List)localObject3);
        localObject4 = Segment.builder();
        j.d(localObject5, "firstSeg");
        localObject5 = ((Segment.SegmentBuilder)localObject4).start(((Segment)localObject5).getStart()).end(((Segment)localObject5).getEnd()).build();
        localObject4 = ColorHSBAttributeValue.builder();
        j.d(localObject1, "firstColor");
        localObject4 = ((ColorHSBAttributeValue.ColorHSBAttributeValueBuilder)localObject4).id(((ColorHSBAttributeValue)localObject1).getId()).h(((ColorHSBAttributeValue)localObject1).getH()).s(((ColorHSBAttributeValue)localObject1).getS()).b(((ColorHSBAttributeValue)localObject1).getB()).build();
        j.d(localObject5, "curSegment");
        localArrayList1.add(localObject5);
        j.d(localObject4, "curColor");
        localArrayList2.add(localObject4);
        int j = ((List)localObject2).size();
        i = 1;
        localObject1 = localObject2;
        while (i < j)
        {
          Segment localSegment = (Segment)((List)localObject1).get(i);
          localObject2 = (ColorHSBAttributeValue)((List)localObject3).get(i);
          Object localObject6 = localMap.get(((ColorHSBAttributeValue)localObject4).getId());
          j.d(localObject2, "color");
          int k;
          if (localb.compare(localObject6, localMap.get(((ColorHSBAttributeValue)localObject2).getId())) == 0) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0)
          {
            j.d(localSegment, "seg");
            ((Segment)localObject5).setEnd(localSegment.getEnd());
          }
          else
          {
            localObject4 = Segment.builder();
            j.d(localSegment, "seg");
            localObject5 = ((Segment.SegmentBuilder)localObject4).start(localSegment.getStart()).end(localSegment.getEnd()).build();
            j.d(localObject5, "curSegment");
            localArrayList1.add(localObject5);
            localObject4 = ColorHSBAttributeValue.builder().id(((ColorHSBAttributeValue)localObject2).getId()).h(((ColorHSBAttributeValue)localObject2).getH()).s(((ColorHSBAttributeValue)localObject2).getS()).b(((ColorHSBAttributeValue)localObject2).getB()).build();
            j.d(localObject4, "curColor");
            localArrayList2.add(localObject4);
          }
          i++;
        }
        localObject4 = d(paramAbstractLightingEffect);
        ((AbstractLightingEffect)localObject4).setSegments(localArrayList1);
        paramAbstractLightingEffect = ((AbstractLightingEffect)localObject4).getSettings();
        j.d(paramAbstractLightingEffect, "copy.settings");
        paramAbstractLightingEffect = paramAbstractLightingEffect.getColorSequence();
        j.d(paramAbstractLightingEffect, "copy.settings.colorSequence");
        paramAbstractLightingEffect.setSeq(localArrayList2);
      }
    }
    return (AbstractLightingEffect)localObject4;
  }
  
  public static final List<Integer> t(LightingEffectData paramLightingEffectData)
  {
    j.e(paramLightingEffectData, "$this$resolveDisplayColorsFully");
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    int k;
    int m;
    if (r(paramLightingEffectData))
    {
      localObject1 = paramLightingEffectData.segments;
      if (localObject1 == null) {
        localObject1 = new Integer[0];
      }
      paramLightingEffectData = paramLightingEffectData.sequence;
      if (paramLightingEffectData == null) {
        paramLightingEffectData = new Integer[0][];
      }
      if (localObject1.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject1 = new ArrayList(paramLightingEffectData.length);
        j = paramLightingEffectData.length;
        for (i = 0; i < j; i++)
        {
          localObject2 = paramLightingEffectData[i];
          localObject3 = localObject2[0];
          j.d(localObject3, "it[0]");
          k = ((Integer)localObject3).intValue();
          localObject3 = localObject2[1];
          j.d(localObject3, "it[1]");
          m = ((Integer)localObject3).intValue();
          localObject2 = localObject2[2];
          j.d(localObject2, "it[2]");
          ((Collection)localObject1).add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(k, m, ((Integer)localObject2).intValue()).g()));
        }
        localArrayList.addAll((Collection)localObject1);
      }
      else
      {
        if (paramLightingEffectData.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0)
        {
          k = localObject1.length;
          i = 0;
          j = 0;
          while (i < k)
          {
            m = paramLightingEffectData.length;
            if ((i < 0) || (m <= i)) {
              break;
            }
            localObject2 = localObject1[i];
            localObject3 = paramLightingEffectData[i];
            Object localObject4 = localObject3[0];
            j.d(localObject4, "it[0]");
            m = ((Integer)localObject4).intValue();
            localObject4 = localObject3[1];
            j.d(localObject4, "it[1]");
            int n = ((Integer)localObject4).intValue();
            localObject3 = localObject3[2];
            j.d(localObject3, "it[2]");
            n = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(m, n, ((Integer)localObject3).intValue()).g();
            int i1 = ((Integer)localObject2).intValue();
            for (m = 0; m < i1 - j + 1; m++) {
              localArrayList.add(Integer.valueOf(n));
            }
            j = ((Integer)localObject2).intValue() + 1;
            i++;
          }
        }
      }
    }
    else
    {
      localObject2 = paramLightingEffectData.display_colors;
      if (localObject2 != null)
      {
        localObject1 = new ArrayList(localObject2.length);
        j = localObject2.length;
        for (i = 0;; i++)
        {
          paramLightingEffectData = (LightingEffectData)localObject1;
          if (i >= j) {
            break;
          }
          paramLightingEffectData = localObject2[i];
          localObject3 = paramLightingEffectData[0];
          j.d(localObject3, "it[0]");
          k = ((Integer)localObject3).intValue();
          localObject3 = paramLightingEffectData[1];
          j.d(localObject3, "it[1]");
          m = ((Integer)localObject3).intValue();
          paramLightingEffectData = paramLightingEffectData[2];
          j.d(paramLightingEffectData, "it[2]");
          ((Collection)localObject1).add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(k, m, paramLightingEffectData.intValue()).g()));
        }
      }
      paramLightingEffectData = kotlin.collections.l.d();
      localArrayList.addAll(paramLightingEffectData);
    }
    return localArrayList;
  }
  
  public static final List<Integer> u(LightingEffectData paramLightingEffectData)
  {
    j.e(paramLightingEffectData, "$this$resolveDisplayColorsShortly");
    Object localObject1 = D(paramLightingEffectData);
    ArrayList localArrayList1 = new ArrayList();
    int i;
    label62:
    int j;
    Object localObject2;
    Object localObject3;
    int k;
    int m;
    if (q((AbstractLightingEffect)localObject1))
    {
      paramLightingEffectData = paramLightingEffectData.display_colors;
      if (paramLightingEffectData != null)
      {
        if (paramLightingEffectData.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          i = 0;
          break label62;
        }
      }
      i = 1;
      if (i == 0)
      {
        j.d(paramLightingEffectData, "display_colors");
        localObject1 = new ArrayList(paramLightingEffectData.length);
        j = paramLightingEffectData.length;
        for (i = 0; i < j; i++)
        {
          localObject2 = paramLightingEffectData[i];
          localObject3 = localObject2[0];
          j.d(localObject3, "it[0]");
          k = ((Integer)localObject3).intValue();
          localObject3 = localObject2[1];
          j.d(localObject3, "it[1]");
          m = ((Integer)localObject3).intValue();
          localObject2 = localObject2[2];
          j.d(localObject2, "it[2]");
          ((Collection)localObject1).add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(k, m, ((Integer)localObject2).intValue()).g()));
        }
        localArrayList1.addAll((Collection)localObject1);
      }
      else
      {
        ArrayList localArrayList2 = new ArrayList();
        paramLightingEffectData = ((AbstractLightingEffect)localObject1).getColorRegistry();
        if (paramLightingEffectData != null)
        {
          Iterator localIterator = paramLightingEffectData.iterator();
          while (localIterator.hasNext())
          {
            Object localObject4 = (ColorHSBAttributeValue)localIterator.next();
            localObject3 = null;
            if (localObject4 != null)
            {
              paramLightingEffectData = ((ColorHSBAttributeValue)localObject4).getH();
              if (paramLightingEffectData != null)
              {
                paramLightingEffectData = paramLightingEffectData.getAbsolute();
                break label278;
              }
            }
            paramLightingEffectData = null;
            label278:
            if (localObject4 != null)
            {
              localObject1 = ((ColorHSBAttributeValue)localObject4).getS();
              if (localObject1 != null)
              {
                localObject1 = ((IntegerAttributeValue)localObject1).getAbsolute();
                break label303;
              }
            }
            localObject1 = null;
            label303:
            localObject2 = localObject3;
            if (localObject4 != null)
            {
              localObject4 = ((ColorHSBAttributeValue)localObject4).getB();
              localObject2 = localObject3;
              if (localObject4 != null) {
                localObject2 = ((IntegerAttributeValue)localObject4).getAbsolute();
              }
            }
            if ((paramLightingEffectData != null) && (localObject1 != null) && (localObject2 != null)) {
              localArrayList2.add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(paramLightingEffectData.intValue(), ((Integer)localObject1).intValue(), ((Integer)localObject2).intValue()).g()));
            }
          }
        }
        localArrayList1.addAll(kotlin.collections.l.P(localArrayList2, 4));
      }
    }
    else
    {
      localObject2 = paramLightingEffectData.display_colors;
      if (localObject2 != null)
      {
        localObject1 = new ArrayList(localObject2.length);
        j = localObject2.length;
        for (i = 0;; i++)
        {
          paramLightingEffectData = (LightingEffectData)localObject1;
          if (i >= j) {
            break;
          }
          paramLightingEffectData = localObject2[i];
          localObject3 = paramLightingEffectData[0];
          j.d(localObject3, "it[0]");
          k = ((Integer)localObject3).intValue();
          localObject3 = paramLightingEffectData[1];
          j.d(localObject3, "it[1]");
          m = ((Integer)localObject3).intValue();
          paramLightingEffectData = paramLightingEffectData[2];
          j.d(paramLightingEffectData, "it[2]");
          ((Collection)localObject1).add(Integer.valueOf(new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(k, m, paramLightingEffectData.intValue()).g()));
        }
      }
      paramLightingEffectData = kotlin.collections.l.d();
      localArrayList1.addAll(paramLightingEffectData);
    }
    return localArrayList1;
  }
  
  @ColorInt
  public static final int v(LightStateBean paramLightStateBean)
  {
    j.e(paramLightStateBean, "$this$resolveNormalColor");
    int i;
    if (paramLightStateBean.getColorTemp() != 0) {
      i = -1;
    } else {
      i = new com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c(paramLightStateBean.getHue(), paramLightStateBean.getSaturation(), paramLightStateBean.getBrightness()).g();
    }
    return i;
  }
  
  public static final PredefinedEffectsTemplateInput w(AbstractLightingEffect paramAbstractLightingEffect)
  {
    j.e(paramAbstractLightingEffect, "$this$resolveTemplateInput");
    if ((paramAbstractLightingEffect instanceof PredefinedEffect))
    {
      paramAbstractLightingEffect = (PredefinedEffect)paramAbstractLightingEffect;
      Object localObject = paramAbstractLightingEffect.getCustomization();
      int i = 1;
      int j = 1;
      if (localObject != null)
      {
        localObject = ((CustomizationSettings)localObject).getInitialValues();
        if (localObject != null) {
          try
          {
            localObject = (PredefinedEffectsTemplateInput)com.tplink.libtpnetwork.Utils.i.a((com.google.gson.i)localObject, PredefinedEffectsTemplateInput.class);
            return (PredefinedEffectsTemplateInput)localObject;
          }
          catch (Exception localException)
          {
            b.d.w.c.a.e("LightingEffectExt", localException.toString());
            paramAbstractLightingEffect = paramAbstractLightingEffect.getCustomization();
            k = j;
            if (paramAbstractLightingEffect != null)
            {
              paramAbstractLightingEffect = paramAbstractLightingEffect.getColors();
              k = j;
              if (paramAbstractLightingEffect != null)
              {
                paramAbstractLightingEffect = paramAbstractLightingEffect.getAbsolute();
                k = j;
                if (paramAbstractLightingEffect != null) {
                  k = paramAbstractLightingEffect.intValue();
                }
              }
            }
            return l(k);
          }
        }
      }
      paramAbstractLightingEffect = paramAbstractLightingEffect.getCustomization();
      int k = i;
      if (paramAbstractLightingEffect != null)
      {
        paramAbstractLightingEffect = paramAbstractLightingEffect.getColors();
        k = i;
        if (paramAbstractLightingEffect != null)
        {
          paramAbstractLightingEffect = paramAbstractLightingEffect.getAbsolute();
          k = i;
          if (paramAbstractLightingEffect != null) {
            k = paramAbstractLightingEffect.intValue();
          }
        }
      }
      return l(k);
    }
    if ((paramAbstractLightingEffect instanceof CustomizedEffect)) {
      return (PredefinedEffectsTemplateInput)com.tplink.libtpnetwork.Utils.i.c(((CustomizedEffect)paramAbstractLightingEffect).getTemplateInput(), PredefinedEffectsTemplateInput.class);
    }
    return null;
  }
  
  public static final AbstractLightingEffect x(AbstractLightingEffect paramAbstractLightingEffect)
  {
    j.e(paramAbstractLightingEffect, "$this$splitColorPaintingSegments");
    List localList = paramAbstractLightingEffect.getSegments();
    Object localObject1 = paramAbstractLightingEffect.getSettings();
    if (localObject1 != null)
    {
      localObject1 = ((LightingEffectSettings)localObject1).getColorSequence();
      if (localObject1 != null)
      {
        localObject1 = ((ColorSequence)localObject1).getSeq();
        break label40;
      }
    }
    localObject1 = null;
    label40:
    int i = 0;
    int j = 1;
    int k;
    if ((localList != null) && (!localList.isEmpty())) {
      k = 0;
    } else {
      k = 1;
    }
    Object localObject2 = paramAbstractLightingEffect;
    if (k == 0)
    {
      k = j;
      if (localObject1 != null) {
        if (((Collection)localObject1).isEmpty()) {
          k = j;
        } else {
          k = 0;
        }
      }
      if (k != 0)
      {
        localObject2 = paramAbstractLightingEffect;
      }
      else
      {
        if (localList.size() != ((List)localObject1).size()) {
          return paramAbstractLightingEffect;
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        j = localList.size();
        for (k = i; k < j; k++)
        {
          Object localObject3 = (Segment)localList.get(k);
          localObject2 = (ColorHSBAttributeValue)((List)localObject1).get(k);
          j.d(localObject3, "seg");
          i = ((Segment)localObject3).getStart().intValue();
          localObject3 = ((Segment)localObject3).getEnd();
          j.d(localObject3, "seg.end");
          int m = ((Integer)localObject3).intValue();
          if (i <= m) {
            for (;;)
            {
              localObject3 = Segment.builder().start(Integer.valueOf(i)).end(Integer.valueOf(i)).build();
              j.d(localObject3, "curSegment");
              localArrayList1.add(localObject3);
              localObject3 = ColorHSBAttributeValue.builder();
              j.d(localObject2, "color");
              localObject3 = ((ColorHSBAttributeValue.ColorHSBAttributeValueBuilder)localObject3).id(((ColorHSBAttributeValue)localObject2).getId()).h(((ColorHSBAttributeValue)localObject2).getH()).s(((ColorHSBAttributeValue)localObject2).getS()).b(((ColorHSBAttributeValue)localObject2).getB()).build();
              j.d(localObject3, "curColor");
              localArrayList2.add(localObject3);
              if (i == m) {
                break;
              }
              i++;
            }
          }
        }
        localObject2 = d(paramAbstractLightingEffect);
        ((AbstractLightingEffect)localObject2).setSegments(localArrayList1);
        paramAbstractLightingEffect = ((AbstractLightingEffect)localObject2).getSettings();
        j.d(paramAbstractLightingEffect, "copy.settings");
        paramAbstractLightingEffect = paramAbstractLightingEffect.getColorSequence();
        j.d(paramAbstractLightingEffect, "copy.settings.colorSequence");
        paramAbstractLightingEffect.setSeq(localArrayList2);
      }
    }
    return (AbstractLightingEffect)localObject2;
  }
  
  public static final LightStripLightingEffect y(AbstractLightingEffect paramAbstractLightingEffect)
  {
    j.e(paramAbstractLightingEffect, "$this$transform");
    String str;
    if ((paramAbstractLightingEffect instanceof PredefinedEffect)) {
      str = LightingEffectType.PREDEFINED.getValue();
    } else if ((paramAbstractLightingEffect instanceof CustomizedEffect)) {
      str = LightingEffectType.CUSTOM.getValue();
    } else if ((paramAbstractLightingEffect instanceof LightStripLightingEffect)) {
      str = ((LightStripLightingEffect)paramAbstractLightingEffect).getSourceType();
    } else {
      str = LightingEffectType.UNKNOWN.getValue();
    }
    paramAbstractLightingEffect = LightStripLightingEffect.builder().sourceType(str).onOff(Integer.valueOf(1)).id(paramAbstractLightingEffect.getId()).createdOn(paramAbstractLightingEffect.getCreatedOn()).updatedOn(paramAbstractLightingEffect.getUpdatedOn()).expansionStrategy(paramAbstractLightingEffect.getExpansionStrategy()).meta(paramAbstractLightingEffect.getMeta()).settings(paramAbstractLightingEffect.getSettings()).type(paramAbstractLightingEffect.getType()).segments(paramAbstractLightingEffect.getSegments()).colorRegistry(paramAbstractLightingEffect.getColorRegistry()).customization(paramAbstractLightingEffect.getCustomization()).animationType(paramAbstractLightingEffect.getAnimationType()).version(paramAbstractLightingEffect.getVersion()).build();
    j.d(paramAbstractLightingEffect, "LightStripLightingEffect…ion)\n            .build()");
    return paramAbstractLightingEffect;
  }
  
  public static final LightStripLightingEffect z(CustomizedEffect paramCustomizedEffect)
  {
    j.e(paramCustomizedEffect, "$this$transform");
    paramCustomizedEffect = LightStripLightingEffect.builder().sourceType(LightingEffectType.CUSTOM.getValue()).onOff(Integer.valueOf(1)).id(paramCustomizedEffect.getId()).createdOn(paramCustomizedEffect.getCreatedOn()).updatedOn(paramCustomizedEffect.getUpdatedOn()).expansionStrategy(paramCustomizedEffect.getExpansionStrategy()).meta(paramCustomizedEffect.getMeta()).settings(paramCustomizedEffect.getSettings()).type(paramCustomizedEffect.getType()).segments(paramCustomizedEffect.getSegments()).colorRegistry(paramCustomizedEffect.getColorRegistry()).customization(paramCustomizedEffect.getCustomization()).animationType(paramCustomizedEffect.getAnimationType()).version(paramCustomizedEffect.getVersion()).build();
    j.d(paramCustomizedEffect, "LightStripLightingEffect…ion)\n            .build()");
    return paramCustomizedEffect;
  }
  
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      return kotlin.q.a.a(((LEColor)paramT1).getH(), ((LEColor)paramT2).getH());
    }
  }
  
  static final class b<T>
    implements Comparator<ColorHSBAttributeValue>
  {
    public static final b c = new b();
    
    public final int a(ColorHSBAttributeValue paramColorHSBAttributeValue1, ColorHSBAttributeValue paramColorHSBAttributeValue2)
    {
      org.apache.commons.lang.builder.a locala = new org.apache.commons.lang.builder.a();
      j.d(paramColorHSBAttributeValue1, "lhs");
      Object localObject = paramColorHSBAttributeValue1.getH();
      j.d(localObject, "lhs.h");
      localObject = ((IntegerAttributeValue)localObject).getAbsolute();
      j.d(localObject, "lhs.h.absolute");
      int i = ((Integer)localObject).intValue();
      j.d(paramColorHSBAttributeValue2, "rhs");
      localObject = paramColorHSBAttributeValue2.getH();
      j.d(localObject, "rhs.h");
      localObject = ((IntegerAttributeValue)localObject).getAbsolute();
      j.d(localObject, "rhs.h.absolute");
      locala.e(i, ((Integer)localObject).intValue());
      localObject = paramColorHSBAttributeValue1.getS();
      j.d(localObject, "lhs.s");
      localObject = ((IntegerAttributeValue)localObject).getAbsolute();
      j.d(localObject, "lhs.s.absolute");
      i = ((Integer)localObject).intValue();
      localObject = paramColorHSBAttributeValue2.getS();
      j.d(localObject, "rhs.s");
      localObject = ((IntegerAttributeValue)localObject).getAbsolute();
      j.d(localObject, "rhs.s.absolute");
      locala.e(i, ((Integer)localObject).intValue());
      paramColorHSBAttributeValue1 = paramColorHSBAttributeValue1.getB();
      j.d(paramColorHSBAttributeValue1, "lhs.b");
      paramColorHSBAttributeValue1 = paramColorHSBAttributeValue1.getAbsolute();
      j.d(paramColorHSBAttributeValue1, "lhs.b.absolute");
      i = paramColorHSBAttributeValue1.intValue();
      paramColorHSBAttributeValue1 = paramColorHSBAttributeValue2.getB();
      j.d(paramColorHSBAttributeValue1, "rhs.b");
      paramColorHSBAttributeValue1 = paramColorHSBAttributeValue1.getAbsolute();
      j.d(paramColorHSBAttributeValue1, "rhs.b.absolute");
      locala.e(i, paramColorHSBAttributeValue1.intValue());
      return locala.t();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\fromkasa\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
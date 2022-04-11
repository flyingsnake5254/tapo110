package com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState;
import com.tplink.iot.devices.lightstrip.lightingeffect.common.KasaLightState.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.LightStripLightingEffect.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue.ColorHSBAttributeValueBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerRange;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerRange.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongRange;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongRange.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ColorSequence;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ColorSequence.Builder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Direction;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings.LightingEffectSettingsBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment.SegmentBuilder;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  private ColorSequence A(List<KasaLightState> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = k(paramList);
    return ColorSequence.builder().seq(paramList).build();
  }
  
  private Integer[] B(LongAttributeValue paramLongAttributeValue)
  {
    if (paramLongAttributeValue == null) {
      return null;
    }
    Object localObject = paramLongAttributeValue.getRange();
    if (localObject == null) {
      return null;
    }
    paramLongAttributeValue = ((LongRange)localObject).getFrom();
    localObject = ((LongRange)localObject).getTo();
    if ((paramLongAttributeValue != null) && (localObject != null)) {
      return new Integer[] { Integer.valueOf(paramLongAttributeValue.intValue()), Integer.valueOf(((Long)localObject).intValue()) };
    }
    return null;
  }
  
  private Integer C(LongAttributeValue paramLongAttributeValue)
  {
    if (paramLongAttributeValue == null) {
      return null;
    }
    if (paramLongAttributeValue.getAbsolute() == null) {
      return null;
    }
    return Integer.valueOf(paramLongAttributeValue.getAbsolute().intValue());
  }
  
  private List<ColorHSBAttributeValue> M(Integer[][] paramArrayOfInteger)
  {
    return i(paramArrayOfInteger);
  }
  
  private Integer[][] O(List<ColorHSBAttributeValue> paramList1, List<ColorHSBAttributeValue> paramList2)
  {
    return j(paramList1, paramList2);
  }
  
  private List<KasaLightState> P(List<Segment> paramList, ColorSequence paramColorSequence, List<ColorHSBAttributeValue> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Segment)localIterator.next();
      localArrayList.add(KasaLightState.builder().t(paramList.getStart()).p(paramList.getEnd()).o());
    }
    if ((paramColorSequence != null) && (paramColorSequence.getSeq() != null) && (!paramColorSequence.getSeq().isEmpty()))
    {
      paramColorSequence = j(paramColorSequence.getSeq(), paramList1);
      for (int i = 0; i < localArrayList.size(); i++)
      {
        paramList = g(paramColorSequence[i]);
        paramList1 = (KasaLightState)localArrayList.get(i);
        paramList1.setHue(paramList.getH().getAbsolute());
        paramList1.setSaturation(paramList.getS().getAbsolute());
        paramList1.setBrightness(paramList.getB().getAbsolute());
      }
    }
    return localArrayList;
  }
  
  private ColorHSBAttributeValue V(String paramString, List<ColorHSBAttributeValue> paramList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (ColorHSBAttributeValue)localIterator.next();
        String str = paramList.getId();
        if ((!TextUtils.isEmpty(str)) && (paramString.equals(str))) {
          return paramList;
        }
      }
    }
    return null;
  }
  
  private boolean a(ColorHSBAttributeValue paramColorHSBAttributeValue1, ColorHSBAttributeValue paramColorHSBAttributeValue2)
  {
    org.apache.commons.lang.builder.a locala = new org.apache.commons.lang.builder.a();
    if ((paramColorHSBAttributeValue1.getH() != null) && (paramColorHSBAttributeValue2.getH() != null))
    {
      locala.g(paramColorHSBAttributeValue1.getH().getAbsolute(), paramColorHSBAttributeValue2.getH().getAbsolute());
      if ((paramColorHSBAttributeValue1.getH().getRange() != null) && (paramColorHSBAttributeValue2.getH().getRange() != null))
      {
        locala.g(paramColorHSBAttributeValue1.getH().getRange().getFrom(), paramColorHSBAttributeValue2.getH().getRange().getFrom());
        locala.g(paramColorHSBAttributeValue1.getH().getRange().getTo(), paramColorHSBAttributeValue2.getH().getRange().getTo());
      }
    }
    if ((paramColorHSBAttributeValue1.getS() != null) && (paramColorHSBAttributeValue2.getS() != null))
    {
      locala.g(paramColorHSBAttributeValue1.getS().getAbsolute(), paramColorHSBAttributeValue2.getS().getAbsolute());
      if ((paramColorHSBAttributeValue1.getS().getRange() != null) && (paramColorHSBAttributeValue2.getS().getRange() != null))
      {
        locala.g(paramColorHSBAttributeValue1.getS().getRange().getFrom(), paramColorHSBAttributeValue2.getS().getRange().getFrom());
        locala.g(paramColorHSBAttributeValue1.getS().getRange().getTo(), paramColorHSBAttributeValue2.getS().getRange().getTo());
      }
    }
    if ((paramColorHSBAttributeValue1.getB() != null) && (paramColorHSBAttributeValue2.getB() != null))
    {
      locala.g(paramColorHSBAttributeValue1.getB().getAbsolute(), paramColorHSBAttributeValue2.getB().getAbsolute());
      if ((paramColorHSBAttributeValue1.getB().getRange() != null) && (paramColorHSBAttributeValue2.getB().getRange() != null))
      {
        locala.g(paramColorHSBAttributeValue1.getB().getRange().getFrom(), paramColorHSBAttributeValue2.getB().getRange().getFrom());
        locala.g(paramColorHSBAttributeValue1.getB().getRange().getTo(), paramColorHSBAttributeValue2.getB().getRange().getTo());
      }
    }
    boolean bool;
    if (locala.t() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private Integer[][] d(List<ColorHSBAttributeValue> paramList1, List<ColorHSBAttributeValue> paramList2)
  {
    return j(paramList1, paramList2);
  }
  
  private List<ColorHSBAttributeValue> e(Integer[][] paramArrayOfInteger)
  {
    return i(paramArrayOfInteger);
  }
  
  private ColorHSBAttributeValue g(Integer[] paramArrayOfInteger)
  {
    if (paramArrayOfInteger == null) {
      return null;
    }
    Integer localInteger1 = paramArrayOfInteger[0];
    Integer localInteger2 = paramArrayOfInteger[1];
    paramArrayOfInteger = paramArrayOfInteger[2];
    return ColorHSBAttributeValue.builder().h(IntegerAttributeValue.builder().absolute(localInteger1).build()).s(IntegerAttributeValue.builder().absolute(localInteger2).build()).b(IntegerAttributeValue.builder().absolute(paramArrayOfInteger).build()).build();
  }
  
  private List<ColorHSBAttributeValue> i(Integer[][] paramArrayOfInteger)
  {
    if ((paramArrayOfInteger != null) && (paramArrayOfInteger.length > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      int i = paramArrayOfInteger.length;
      for (int j = 0;; j++)
      {
        localArrayList2 = localArrayList1;
        if (j >= i) {
          break;
        }
        localArrayList1.add(g(paramArrayOfInteger[j]));
      }
    }
    ArrayList localArrayList2 = null;
    return localArrayList2;
  }
  
  @Nullable
  private Integer[][] j(List<ColorHSBAttributeValue> paramList1, List<ColorHSBAttributeValue> paramList2)
  {
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      Integer[][] arrayOfInteger = new Integer[paramList1.size()][3];
      for (int i = 0; i < paramList1.size(); i++)
      {
        ColorHSBAttributeValue localColorHSBAttributeValue1 = (ColorHSBAttributeValue)paramList1.get(i);
        if (localColorHSBAttributeValue1 != null)
        {
          ColorHSBAttributeValue localColorHSBAttributeValue2 = V(localColorHSBAttributeValue1.getId(), paramList2);
          if ((localColorHSBAttributeValue2 != null) && (localColorHSBAttributeValue2.getH() != null) && (localColorHSBAttributeValue2.getH().getAbsolute() != null)) {
            arrayOfInteger[i][0] = y(localColorHSBAttributeValue2.getH());
          } else if ((localColorHSBAttributeValue1.getH() != null) && (localColorHSBAttributeValue1.getH().getAbsolute() != null)) {
            arrayOfInteger[i][0] = y(localColorHSBAttributeValue1.getH());
          }
          if ((localColorHSBAttributeValue2 != null) && (localColorHSBAttributeValue2.getS() != null) && (localColorHSBAttributeValue2.getS().getAbsolute() != null)) {
            arrayOfInteger[i][1] = y(localColorHSBAttributeValue2.getS());
          } else if ((localColorHSBAttributeValue1.getS() != null) && (localColorHSBAttributeValue1.getS().getAbsolute() != null)) {
            arrayOfInteger[i][1] = localColorHSBAttributeValue1.getS().getAbsolute();
          }
          if ((localColorHSBAttributeValue2 != null) && (localColorHSBAttributeValue2.getB() != null) && (localColorHSBAttributeValue2.getB().getAbsolute() != null)) {
            arrayOfInteger[i][2] = y(localColorHSBAttributeValue2.getB());
          } else if ((localColorHSBAttributeValue1.getB() != null) && (localColorHSBAttributeValue1.getB().getAbsolute() != null)) {
            arrayOfInteger[i][2] = localColorHSBAttributeValue1.getB().getAbsolute();
          }
        }
      }
      return arrayOfInteger;
    }
    return null;
  }
  
  private List<ColorHSBAttributeValue> k(List<KasaLightState> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.isEmpty()) {
      return null;
    }
    Integer[][] arrayOfInteger = new Integer[paramList.size()][];
    for (int i = 0; i < paramList.size(); i++)
    {
      KasaLightState localKasaLightState = (KasaLightState)paramList.get(i);
      arrayOfInteger[i] = { localKasaLightState.getHue(), localKasaLightState.getSaturation(), localKasaLightState.getBrightness() };
    }
    return M(arrayOfInteger);
  }
  
  private LightingEffectSettings v(Integer[] paramArrayOfInteger)
  {
    if ((paramArrayOfInteger != null) && (paramArrayOfInteger.length > 0))
    {
      paramArrayOfInteger = g(paramArrayOfInteger);
      paramArrayOfInteger = LightingEffectSettings.builder().color(paramArrayOfInteger).build();
    }
    else
    {
      paramArrayOfInteger = null;
    }
    return paramArrayOfInteger;
  }
  
  private Integer[] x(IntegerAttributeValue paramIntegerAttributeValue)
  {
    Object localObject = null;
    if (paramIntegerAttributeValue == null) {
      return null;
    }
    paramIntegerAttributeValue = paramIntegerAttributeValue.getRange();
    if (paramIntegerAttributeValue == null) {
      return null;
    }
    Integer localInteger1 = paramIntegerAttributeValue.getFrom();
    Integer localInteger2 = paramIntegerAttributeValue.getTo();
    paramIntegerAttributeValue = (IntegerAttributeValue)localObject;
    if (localInteger1 != null) {
      if (localInteger2 == null)
      {
        paramIntegerAttributeValue = (IntegerAttributeValue)localObject;
      }
      else
      {
        paramIntegerAttributeValue = new Integer[2];
        paramIntegerAttributeValue[0] = localInteger1;
        paramIntegerAttributeValue[1] = localInteger2;
      }
    }
    return paramIntegerAttributeValue;
  }
  
  private Integer y(IntegerAttributeValue paramIntegerAttributeValue)
  {
    if (paramIntegerAttributeValue == null) {
      return null;
    }
    if (paramIntegerAttributeValue.getAbsolute() == null) {
      return null;
    }
    return paramIntegerAttributeValue.getAbsolute();
  }
  
  private List<Segment> z(List<KasaLightState> paramList)
  {
    if (paramList == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (KasaLightState)localIterator.next();
      localArrayList.add(Segment.builder().start(paramList.getStartIndex()).end(paramList.getEndIndex()).build());
    }
    return localArrayList;
  }
  
  public String D(LightingEffectMeta paramLightingEffectMeta)
  {
    if (paramLightingEffectMeta == null) {
      return null;
    }
    return paramLightingEffectMeta.getAlias();
  }
  
  public Integer E(IntegerAttributeValue paramIntegerAttributeValue)
  {
    return y(paramIntegerAttributeValue);
  }
  
  public Integer F(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString.hashCode();
    if (!paramString.equals("always")) {
      return Integer.valueOf(Integer.parseInt(paramString));
    }
    return Integer.valueOf(0);
  }
  
  @Nullable
  public String G(Integer paramInteger)
  {
    if (paramInteger == null) {
      return null;
    }
    if (paramInteger.intValue() != 0) {
      return String.valueOf(paramInteger);
    }
    return "always";
  }
  
  @Nullable
  public Integer[] H(ColorHSBAttributeValue paramColorHSBAttributeValue, List<ColorHSBAttributeValue> paramList)
  {
    if (paramColorHSBAttributeValue == null) {
      return null;
    }
    paramList = V(paramColorHSBAttributeValue.getId(), paramList);
    if ((paramList != null) && (paramList.getS() != null) && (paramList.getS().getRange() != null)) {
      return x(paramList.getS());
    }
    if ((paramColorHSBAttributeValue.getS() != null) && (paramColorHSBAttributeValue.getS().getRange() != null)) {
      return x(paramColorHSBAttributeValue.getS());
    }
    return null;
  }
  
  @Nullable
  public Integer I(List<Segment> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Segment localSegment = (Segment)paramList.get(0);
      if (paramList.size() == 1) {
        return Integer.valueOf(localSegment.getEnd().intValue() + 1);
      }
    }
    return null;
  }
  
  public List<Segment> J(Integer[] paramArrayOfInteger, Integer[][] paramArrayOfInteger1, Integer paramInteger)
  {
    int i = 0;
    Object localObject;
    if ((paramArrayOfInteger != null) && (paramArrayOfInteger.length > 0))
    {
      paramInteger = new ArrayList();
      for (int j = 0; j < paramArrayOfInteger.length; j++)
      {
        localObject = Segment.builder();
        int k;
        if (j > 0) {
          k = paramArrayOfInteger[(j - 1)].intValue() + 1;
        } else {
          k = 0;
        }
        paramInteger.add(((Segment.SegmentBuilder)localObject).start(Integer.valueOf(k)).end(paramArrayOfInteger[j]).build());
      }
      paramArrayOfInteger = paramInteger;
      if (paramArrayOfInteger1 != null)
      {
        paramArrayOfInteger = paramInteger;
        if (paramArrayOfInteger1.length > 0) {
          for (j = i;; j++)
          {
            paramArrayOfInteger = paramInteger;
            if (j >= paramArrayOfInteger1.length) {
              break;
            }
            paramArrayOfInteger = v(paramArrayOfInteger1[j]);
            ((Segment)paramInteger.get(j)).setInitialState(paramArrayOfInteger);
          }
        }
      }
    }
    else if (paramInteger != null)
    {
      localObject = Segment.builder().start(Integer.valueOf(0)).end(Integer.valueOf(paramInteger.intValue() - 1)).build();
      paramInteger = new ArrayList();
      paramInteger.add(localObject);
      paramArrayOfInteger = paramInteger;
      if (paramArrayOfInteger1 != null)
      {
        paramArrayOfInteger = paramInteger;
        if (paramArrayOfInteger1.length > 0)
        {
          ((Segment)localObject).setInitialState(v(paramArrayOfInteger1[0]));
          paramArrayOfInteger = paramInteger;
        }
      }
    }
    else
    {
      paramArrayOfInteger = null;
    }
    return paramArrayOfInteger;
  }
  
  @Nullable
  public Integer[] K(List<Segment> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Integer[] arrayOfInteger = new Integer[paramList.size()];
      for (int i = 0; i < paramList.size(); i++) {
        arrayOfInteger[i] = ((Segment)paramList.get(i)).getEnd();
      }
      return arrayOfInteger;
    }
    return null;
  }
  
  public ColorSequence L(Integer[][] paramArrayOfInteger)
  {
    paramArrayOfInteger = M(paramArrayOfInteger);
    if (paramArrayOfInteger == null) {
      return null;
    }
    return ColorSequence.builder().seq(paramArrayOfInteger).build();
  }
  
  public Integer[][] N(ColorSequence paramColorSequence, List<ColorHSBAttributeValue> paramList)
  {
    if (paramColorSequence == null) {
      return null;
    }
    return O(paramColorSequence.getSeq(), paramList);
  }
  
  public LightStripLightingEffect Q(com.tplink.iot.devices.lightstrip.lightingeffect.common.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = parama.b();
    Object localObject = A(localList);
    if (localObject != null) {
      Y(((ColorSequence)localObject).getSeq(), localArrayList, Integer.valueOf(1));
    }
    localList = z(localList);
    localObject = LightingEffectSettings.builder().colorSequence((ColorSequence)localObject).build();
    return LightStripLightingEffect.builder().onOff(parama.c()).expansionStrategy(ExpansionStrategy.REPEAT).colorRegistry(localArrayList).type(Type.STATIC).settings((LightingEffectSettings)localObject).segments(localList).build();
  }
  
  @Nullable
  public LongAttributeValue R(Integer paramInteger, Integer[] paramArrayOfInteger)
  {
    if (paramArrayOfInteger != null)
    {
      paramInteger = paramArrayOfInteger[0];
      paramArrayOfInteger = paramArrayOfInteger[1];
      paramInteger = LongAttributeValue.builder().range(LongRange.builder().from(Long.valueOf(paramInteger.longValue())).to(Long.valueOf(paramArrayOfInteger.longValue())).build()).build();
    }
    else if (paramInteger != null)
    {
      long l = paramInteger.longValue();
      paramInteger = LongAttributeValue.builder().absolute(Long.valueOf(l)).build();
    }
    else
    {
      paramInteger = null;
    }
    return paramInteger;
  }
  
  @Nullable
  public Integer S(LongAttributeValue paramLongAttributeValue)
  {
    return C(paramLongAttributeValue);
  }
  
  @Nullable
  public Integer[] T(LongAttributeValue paramLongAttributeValue)
  {
    return B(paramLongAttributeValue);
  }
  
  public Type U(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return Type.SEQUENCE;
    }
    Type localType1 = Type.SEQUENCE;
    Type[] arrayOfType = Type.values();
    int i = arrayOfType.length;
    Type localType2;
    for (int j = 0;; j++)
    {
      localType2 = localType1;
      if (j >= i) {
        break;
      }
      localType2 = arrayOfType[j];
      if (localType2.toString().equalsIgnoreCase(paramString)) {
        break;
      }
    }
    return localType2;
  }
  
  public List<ColorHSBAttributeValue> W(List<Segment> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = ((Segment)localIterator.next()).getInitialState();
        if ((paramList != null) && (paramList.getColor() != null)) {
          localArrayList.add(paramList.getColor());
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public Integer X(ColorHSBAttributeValue paramColorHSBAttributeValue, List<ColorHSBAttributeValue> paramList, Integer paramInteger)
  {
    if (paramColorHSBAttributeValue != null)
    {
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ColorHSBAttributeValue)((Iterator)localObject1).next();
        if (a((ColorHSBAttributeValue)localObject2, paramColorHSBAttributeValue))
        {
          paramColorHSBAttributeValue.setId(((ColorHSBAttributeValue)localObject2).getId());
          paramColorHSBAttributeValue.setH(null);
          paramColorHSBAttributeValue.setS(null);
          paramColorHSBAttributeValue.setB(null);
          return paramInteger;
        }
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("color");
      ((StringBuilder)localObject2).append(String.valueOf(paramInteger));
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = ColorHSBAttributeValue.builder().id((String)localObject1).h(paramColorHSBAttributeValue.getH()).s(paramColorHSBAttributeValue.getS()).b(paramColorHSBAttributeValue.getB()).build();
      paramColorHSBAttributeValue.setId((String)localObject1);
      paramColorHSBAttributeValue.setH(null);
      paramColorHSBAttributeValue.setS(null);
      paramColorHSBAttributeValue.setB(null);
      paramList.add(localObject2);
      return Integer.valueOf(paramInteger.intValue() + 1);
    }
    return paramInteger;
  }
  
  public Integer Y(List<ColorHSBAttributeValue> paramList1, List<ColorHSBAttributeValue> paramList2, Integer paramInteger)
  {
    if (paramList1 == null) {
      return paramInteger;
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      paramInteger = X((ColorHSBAttributeValue)paramList1.next(), paramList2, paramInteger);
    }
    return paramInteger;
  }
  
  public ColorSequence b(Integer[][] paramArrayOfInteger)
  {
    paramArrayOfInteger = e(paramArrayOfInteger);
    if (paramArrayOfInteger == null) {
      return null;
    }
    return ColorSequence.builder().seq(paramArrayOfInteger).build();
  }
  
  public Integer[][] c(ColorSequence paramColorSequence, List<ColorHSBAttributeValue> paramList)
  {
    if (paramColorSequence == null) {
      return null;
    }
    return d(paramColorSequence.getSeq(), paramList);
  }
  
  @Nullable
  public Integer[] f(ColorHSBAttributeValue paramColorHSBAttributeValue, List<ColorHSBAttributeValue> paramList)
  {
    if (paramColorHSBAttributeValue == null) {
      return null;
    }
    paramList = V(paramColorHSBAttributeValue.getId(), paramList);
    if ((paramList != null) && (paramList.getB() != null) && (paramList.getB().getRange() != null)) {
      return x(paramList.getB());
    }
    if ((paramColorHSBAttributeValue.getB() != null) && (paramColorHSBAttributeValue.getB().getRange() != null)) {
      return x(paramColorHSBAttributeValue.getB());
    }
    return null;
  }
  
  @Nullable
  public ColorHSBAttributeValue h(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Integer[] paramArrayOfInteger3, Integer paramInteger)
  {
    Object localObject;
    if (paramArrayOfInteger1 != null)
    {
      localObject = paramArrayOfInteger1[0];
      paramArrayOfInteger1 = paramArrayOfInteger1[1];
      paramArrayOfInteger1 = IntegerAttributeValue.builder().range(IntegerRange.builder().from((Integer)localObject).to(paramArrayOfInteger1).build()).build();
    }
    else
    {
      paramArrayOfInteger1 = null;
    }
    if (paramArrayOfInteger2 != null)
    {
      localObject = paramArrayOfInteger2[0];
      paramArrayOfInteger2 = paramArrayOfInteger2[1];
      paramArrayOfInteger2 = IntegerAttributeValue.builder().range(IntegerRange.builder().from((Integer)localObject).to(paramArrayOfInteger2).build()).build();
    }
    else
    {
      paramArrayOfInteger2 = null;
    }
    if ((paramArrayOfInteger3 == null) && (paramInteger == null))
    {
      paramArrayOfInteger3 = null;
    }
    else
    {
      localObject = IntegerAttributeValue.builder().build();
      if (paramArrayOfInteger3 != null)
      {
        Integer localInteger = paramArrayOfInteger3[0];
        paramArrayOfInteger3 = paramArrayOfInteger3[1];
        ((IntegerAttributeValue)localObject).setRange(IntegerRange.builder().from(localInteger).to(paramArrayOfInteger3).build());
      }
      paramArrayOfInteger3 = (Integer[])localObject;
      if (paramInteger != null)
      {
        ((IntegerAttributeValue)localObject).setAbsolute(paramInteger);
        paramArrayOfInteger3 = (Integer[])localObject;
      }
    }
    if ((paramArrayOfInteger1 == null) && (paramArrayOfInteger2 == null) && (paramArrayOfInteger3 == null)) {
      return null;
    }
    return ColorHSBAttributeValue.builder().h(paramArrayOfInteger1).s(paramArrayOfInteger2).b(paramArrayOfInteger3).build();
  }
  
  public Integer l(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("predefined".equalsIgnoreCase(paramString)) {
      return Integer.valueOf(0);
    }
    if ("custom".equalsIgnoreCase(paramString)) {
      return Integer.valueOf(1);
    }
    return null;
  }
  
  public String m(Integer paramInteger)
  {
    if (paramInteger == null) {
      return null;
    }
    if (paramInteger.intValue() != 1) {
      return "predefined";
    }
    return "custom";
  }
  
  public Integer n(LongAttributeValue paramLongAttributeValue)
  {
    return C(paramLongAttributeValue);
  }
  
  @Nullable
  public Direction o(Integer paramInteger)
  {
    if (paramInteger == null) {
      return null;
    }
    int i = paramInteger.intValue();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return Direction.RANDOM;
        }
        return Direction.PINGPONG;
      }
      return Direction.BACKWARD;
    }
    return Direction.FORWARD;
  }
  
  @Nullable
  public Integer p(Direction paramDirection)
  {
    if (paramDirection == null) {
      return null;
    }
    int i = a.a[paramDirection.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return Integer.valueOf(4);
        }
        return Integer.valueOf(3);
      }
      return Integer.valueOf(2);
    }
    return Integer.valueOf(1);
  }
  
  public ExpansionStrategy q(Integer paramInteger)
  {
    if (paramInteger == null) {
      return ExpansionStrategy.REPEAT;
    }
    int i = paramInteger.intValue();
    if (i != 1)
    {
      if (i != 2) {
        return ExpansionStrategy.REPEAT;
      }
      return ExpansionStrategy.STRETCH;
    }
    return ExpansionStrategy.REPEAT;
  }
  
  public Integer r(ExpansionStrategy paramExpansionStrategy)
  {
    Integer localInteger = Integer.valueOf(1);
    if (paramExpansionStrategy == null) {
      return localInteger;
    }
    int i = a.b[paramExpansionStrategy.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return localInteger;
      }
      return Integer.valueOf(2);
    }
    return localInteger;
  }
  
  public Integer s(LongAttributeValue paramLongAttributeValue)
  {
    return C(paramLongAttributeValue);
  }
  
  public com.tplink.iot.devices.lightstrip.lightingeffect.common.a t(LightStripLightingEffect paramLightStripLightingEffect)
  {
    com.tplink.iot.devices.lightstrip.lightingeffect.common.a locala = new com.tplink.iot.devices.lightstrip.lightingeffect.common.a();
    locala.g(paramLightStripLightingEffect.getOnOff());
    List localList1 = paramLightStripLightingEffect.getColorRegistry();
    List localList2 = paramLightStripLightingEffect.getSegments();
    LightingEffectSettings localLightingEffectSettings = paramLightStripLightingEffect.getSettings();
    paramLightStripLightingEffect = localLightingEffectSettings;
    if (localLightingEffectSettings == null) {
      paramLightStripLightingEffect = LightingEffectSettings.builder().build();
    }
    locala.h(S(paramLightStripLightingEffect.getTransition()));
    locala.e(P(localList2, paramLightStripLightingEffect.getColorSequence(), localList1));
    return locala;
  }
  
  @Nullable
  public Integer[] u(ColorHSBAttributeValue paramColorHSBAttributeValue, List<ColorHSBAttributeValue> paramList)
  {
    if (paramColorHSBAttributeValue == null) {
      return null;
    }
    paramList = V(paramColorHSBAttributeValue.getId(), paramList);
    if ((paramList != null) && (paramList.getH() != null) && (paramList.getH().getRange() != null)) {
      return x(paramList.getH());
    }
    if ((paramColorHSBAttributeValue.getH() != null) && (paramColorHSBAttributeValue.getH().getRange() != null)) {
      return x(paramColorHSBAttributeValue.getH());
    }
    return null;
  }
  
  @Nullable
  public Integer[][] w(List<ColorHSBAttributeValue> paramList1, List<ColorHSBAttributeValue> paramList2)
  {
    return j(paramList1, paramList2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\fromkasa\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
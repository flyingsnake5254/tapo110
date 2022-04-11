package com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb;

import com.google.gson.r.a;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LightEffectRuleBean
  extends ThingRuleLightEffect
{
  private transient List<LightStateBean> statusList = new ArrayList();
  
  public LightEffectRuleBean() {}
  
  public LightEffectRuleBean(ThingRuleLightEffect paramThingRuleLightEffect)
  {
    if (paramThingRuleLightEffect == null) {
      return;
    }
    setId(paramThingRuleLightEffect.getId());
    setSceneName(paramThingRuleLightEffect.getSceneName());
    setChangeMode(paramThingRuleLightEffect.getChangeMode());
    setChangeTime(paramThingRuleLightEffect.getChangeTime());
    paramThingRuleLightEffect = paramThingRuleLightEffect.getColorStatusList();
    if (paramThingRuleLightEffect != null) {
      this.statusList = transformFromJsonElement(paramThingRuleLightEffect);
    }
  }
  
  private static com.google.gson.i covertToJsonElement(List<LightStateBean> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (LightStateBean)localIterator.next();
        localArrayList.add(Arrays.asList(new Integer[] { Integer.valueOf(paramList.getBrightness()), Integer.valueOf(paramList.getHue()), Integer.valueOf(paramList.getSaturation()), Integer.valueOf(paramList.getColorTemp()) }));
      }
    }
    return (com.google.gson.i)com.tplink.libtpnetwork.Utils.i.a(com.tplink.libtpnetwork.Utils.i.i(localArrayList), com.google.gson.i.class);
  }
  
  private static List<LightStateBean> transformFromJsonElement(com.google.gson.i parami)
  {
    Object localObject = (List)JsonUtils.a(com.tplink.libtpnetwork.Utils.i.f(parami), new a() {}.getType());
    parami = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)((Iterator)localObject).next();
        if ((localList != null) && (localList.size() == 4)) {
          parami.add(new LightStateBean(localList));
        }
      }
    }
    return parami;
  }
  
  public List<LightStateBean> getStatusList()
  {
    return this.statusList;
  }
  
  public void setStatusList(List<LightStateBean> paramList)
  {
    this.statusList = paramList;
    setColorStatusList(covertToJsonElement(paramList));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\colorbulb\LightEffectRuleBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
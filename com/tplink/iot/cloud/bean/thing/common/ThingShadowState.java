package com.tplink.iot.cloud.bean.thing.common;

import androidx.annotation.NonNull;
import com.google.gson.f;
import com.google.gson.m;
import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ThingShadowState
{
  @b(MapJsonAdapter.class)
  private Map<String, Object> desired;
  @b(MapJsonAdapter.class)
  private Map<String, Object> reported;
  
  public ThingShadowState() {}
  
  public ThingShadowState(Map<String, Object> paramMap)
  {
    this.desired = paramMap;
  }
  
  public ThingShadowState(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    this.desired = paramMap1;
    this.reported = paramMap2;
  }
  
  private Object getFormattedValue(Map<String, Object> paramMap, @NonNull ThingProperty paramThingProperty)
  {
    String str = paramThingProperty.getDataType();
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramMap != null)
    {
      localObject2 = localObject1;
      if (str != null)
      {
        Object localObject3 = paramMap.get(paramThingProperty.getId());
        ThingPropertySpec localThingPropertySpec = paramThingProperty.getSpecs();
        int i = -1;
        switch (str.hashCode())
        {
        default: 
          break;
        case 93090393: 
          if (str.equals("array")) {
            i = 8;
          }
          break;
        case 3556653: 
          if (str.equals("text")) {
            i = 7;
          }
          break;
        case 3327612: 
          if (str.equals("long")) {
            i = 6;
          }
          break;
        case 3118337: 
          if (str.equals("enum")) {
            i = 5;
          }
          break;
        case 3076014: 
          if (str.equals("date")) {
            i = 4;
          }
          break;
        case 3029738: 
          if (str.equals("bool")) {
            i = 3;
          }
          break;
        case 104431: 
          if (str.equals("int")) {
            i = 2;
          }
          break;
        case -1023368385: 
          if (str.equals("object")) {
            i = 1;
          }
          break;
        case -1325958191: 
          if (str.equals("double")) {
            i = 0;
          }
          break;
        }
        switch (i)
        {
        default: 
          localObject2 = localObject1;
          break;
        case 8: 
          if (localThingPropertySpec == null)
          {
            localObject2 = localObject1;
          }
          else if ((localObject3 instanceof String[]))
          {
            paramMap = (Map<String, Object>)localObject3;
            if (!"text".equals(localThingPropertySpec.getItemType()))
            {
              paramMap = (Map<String, Object>)localObject3;
              if (!"enum".equals(localThingPropertySpec.getItemType()))
              {
                localObject2 = localObject1;
                break label1253;
              }
            }
          }
          else if ((localObject3 instanceof Number[]))
          {
            paramMap = (Map<String, Object>)localObject3;
            if (!"int".equals(localThingPropertySpec.getItemType()))
            {
              paramMap = (Map<String, Object>)localObject3;
              if (!"long".equals(localThingPropertySpec.getItemType()))
              {
                paramMap = (Map<String, Object>)localObject3;
                if (!"double".equals(localThingPropertySpec.getItemType()))
                {
                  localObject2 = localObject1;
                  break label1253;
                }
              }
            }
          }
          else
          {
            localObject2 = localObject1;
            if (!(localObject3 instanceof ArrayList)) {
              break label1253;
            }
            if ((!"text".equals(localThingPropertySpec.getItemType())) && (!"enum".equals(localThingPropertySpec.getItemType())))
            {
              if ((!"int".equals(localThingPropertySpec.getItemType())) && (!"long".equals(localThingPropertySpec.getItemType())))
              {
                localObject2 = localObject1;
                if (!"double".equals(localThingPropertySpec.getItemType())) {}
              }
              else
              {
                paramMap = new ArrayList();
                localObject2 = ((ArrayList)localObject3).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  paramThingProperty = ((Iterator)localObject2).next();
                  if ((paramThingProperty instanceof Number)) {
                    paramMap.add((Number)paramThingProperty);
                  }
                }
                localObject2 = paramMap.toArray(new Number[0]);
              }
            }
            else
            {
              paramMap = new ArrayList();
              paramThingProperty = ((ArrayList)localObject3).iterator();
              while (paramThingProperty.hasNext())
              {
                localObject2 = paramThingProperty.next();
                if ((localObject2 instanceof String)) {
                  paramMap.add((String)localObject2);
                }
              }
              localObject2 = paramMap.toArray(new String[0]);
            }
          }
          break;
        case 7: 
          paramMap = (Map<String, Object>)localObject3;
          if (!(localObject3 instanceof String)) {
            localObject2 = localObject1;
          }
          break;
        case 5: 
          localObject2 = localObject1;
          if (!(localObject3 instanceof String)) {
            break label1253;
          }
          localObject2 = localObject1;
          if (localThingPropertySpec == null) {
            break label1253;
          }
          localObject2 = localObject1;
          if (localThingPropertySpec.getValues() == null) {
            break label1253;
          }
          paramMap = (Map<String, Object>)localObject3;
          if (!localThingPropertySpec.getValues().contains(localObject3)) {
            localObject2 = localObject1;
          }
          break;
        case 4: 
        case 6: 
          if ((localObject3 instanceof Number))
          {
            localObject2 = (Number)localObject3;
            paramThingProperty = Long.valueOf(((Number)localObject2).longValue());
            paramMap = paramThingProperty;
            if (localThingPropertySpec != null) {
              if (localThingPropertySpec.getWhiteList() != null)
              {
                paramMap = paramThingProperty;
                if (localThingPropertySpec.getWhiteList().l(new m((Number)localObject2))) {
                  break;
                }
              }
              else if (paramThingProperty.longValue() > localThingPropertySpec.getMax())
              {
                paramMap = Long.valueOf(localThingPropertySpec.getMax());
              }
              else
              {
                paramMap = paramThingProperty;
                if (paramThingProperty.longValue() < localThingPropertySpec.getMin()) {
                  paramMap = Long.valueOf(localThingPropertySpec.getMin());
                }
              }
            }
          }
          break;
        case 3: 
        case 2: 
          do
          {
            do
            {
              do
              {
                localObject2 = paramMap;
                break label1253;
                if (localThingPropertySpec != null)
                {
                  paramMap = Long.valueOf(localThingPropertySpec.getMin());
                  break label1109;
                }
                paramMap = Long.valueOf(0L);
                break label1109;
                paramMap = (Map<String, Object>)localObject3;
                if ((localObject3 instanceof Boolean)) {
                  break label1109;
                }
                localObject2 = localObject1;
                break label1253;
                if (!(localObject3 instanceof Number)) {
                  break;
                }
                localObject2 = (Number)localObject3;
                paramThingProperty = Integer.valueOf(((Number)localObject2).intValue());
                paramMap = paramThingProperty;
              } while (localThingPropertySpec == null);
              if (localThingPropertySpec.getWhiteList() == null) {
                break;
              }
              paramMap = paramThingProperty;
            } while (localThingPropertySpec.getWhiteList().l(new m((Number)localObject2)));
            if (paramThingProperty.intValue() > localThingPropertySpec.getMax())
            {
              paramMap = Integer.valueOf((int)localThingPropertySpec.getMax());
              break label1109;
            }
            paramMap = paramThingProperty;
          } while (paramThingProperty.intValue() >= localThingPropertySpec.getMin());
          paramMap = Integer.valueOf((int)localThingPropertySpec.getMin());
          break label1109;
          if (localThingPropertySpec != null) {
            paramMap = Integer.valueOf((int)localThingPropertySpec.getMin());
          } else {
            paramMap = Integer.valueOf(0);
          }
          break;
        case 1: 
          paramMap = (Map<String, Object>)localObject3;
          if (!(localObject3 instanceof Map)) {
            localObject2 = localObject1;
          }
          break;
        }
        for (;;)
        {
          label1109:
          localObject2 = paramMap;
          break label1253;
          if ((localObject3 instanceof Number))
          {
            localObject2 = (Number)localObject3;
            paramThingProperty = Double.valueOf(((Number)localObject2).doubleValue());
            paramMap = paramThingProperty;
            if (localThingPropertySpec == null) {
              break;
            }
            if (localThingPropertySpec.getWhiteList() != null)
            {
              paramMap = paramThingProperty;
              if (localThingPropertySpec.getWhiteList().l(new m((Number)localObject2))) {
                break;
              }
            }
            if (paramThingProperty.doubleValue() > localThingPropertySpec.getMax())
            {
              paramMap = Double.valueOf(localThingPropertySpec.getMax());
              continue;
            }
            paramMap = paramThingProperty;
            if (paramThingProperty.doubleValue() >= localThingPropertySpec.getMin()) {
              break;
            }
            paramMap = Double.valueOf(localThingPropertySpec.getMin());
            continue;
          }
          if (localThingPropertySpec != null) {
            paramMap = Double.valueOf(localThingPropertySpec.getMin());
          } else {
            paramMap = Double.valueOf(0.0D);
          }
        }
      }
    }
    label1253:
    return localObject2;
  }
  
  public Map<String, Object> getDesired()
  {
    return this.desired;
  }
  
  public Object getDesiredValue(@NonNull ThingProperty paramThingProperty)
  {
    return getFormattedValue(this.desired, paramThingProperty);
  }
  
  public Map<String, Object> getReported()
  {
    return this.reported;
  }
  
  public Object getReportedValue(@NonNull ThingProperty paramThingProperty)
  {
    return getFormattedValue(this.reported, paramThingProperty);
  }
  
  public void setDesired(Map<String, Object> paramMap)
  {
    this.desired = paramMap;
  }
  
  public void setReported(Map<String, Object> paramMap)
  {
    this.reported = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingShadowState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
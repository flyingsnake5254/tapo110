package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class NightVisionCapability
{
  @c("night_vision_mode_range")
  private final List<String> nightVisionModeRange;
  @c("supplement_lamp_type")
  private final List<String> supplementLampType;
  
  public NightVisionCapability(List<String> paramList1, List<String> paramList2)
  {
    this.supplementLampType = paramList1;
    this.nightVisionModeRange = paramList2;
  }
  
  public final List<String> component1()
  {
    return this.supplementLampType;
  }
  
  public final List<String> component2()
  {
    return this.nightVisionModeRange;
  }
  
  public final NightVisionCapability copy(List<String> paramList1, List<String> paramList2)
  {
    return new NightVisionCapability(paramList1, paramList2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NightVisionCapability))
      {
        paramObject = (NightVisionCapability)paramObject;
        if ((j.a(this.supplementLampType, ((NightVisionCapability)paramObject).supplementLampType)) && (j.a(this.nightVisionModeRange, ((NightVisionCapability)paramObject).nightVisionModeRange))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<String> getNightVisionModeRange()
  {
    return this.nightVisionModeRange;
  }
  
  public final List<NightVisionModeType> getNightVisionModeTypes()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.nightVisionModeRange;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = NightVisionModeType.Companion.fromString((String)localObject2);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  public final List<String> getSupplementLampType()
  {
    return this.supplementLampType;
  }
  
  public int hashCode()
  {
    List localList = this.supplementLampType;
    int i = 0;
    int j;
    if (localList != null) {
      j = localList.hashCode();
    } else {
      j = 0;
    }
    localList = this.nightVisionModeRange;
    if (localList != null) {
      i = localList.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NightVisionCapability(supplementLampType=");
    localStringBuilder.append(this.supplementLampType);
    localStringBuilder.append(", nightVisionModeRange=");
    localStringBuilder.append(this.nightVisionModeRange);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\NightVisionCapability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
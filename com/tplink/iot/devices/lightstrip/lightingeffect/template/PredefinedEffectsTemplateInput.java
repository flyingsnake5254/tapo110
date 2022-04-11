package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import java.util.List;
import kotlin.jvm.internal.j;

public final class PredefinedEffectsTemplateInput
{
  private final List<LEColor> colors;
  private final Speed speed;
  private final int version;
  
  public PredefinedEffectsTemplateInput(List<LEColor> paramList, Speed paramSpeed, int paramInt)
  {
    this.colors = paramList;
    this.speed = paramSpeed;
    this.version = paramInt;
  }
  
  public final List<LEColor> component1()
  {
    return this.colors;
  }
  
  public final Speed component2()
  {
    return this.speed;
  }
  
  public final int component3()
  {
    return this.version;
  }
  
  public final PredefinedEffectsTemplateInput copy(List<LEColor> paramList, Speed paramSpeed, int paramInt)
  {
    j.e(paramList, "colors");
    j.e(paramSpeed, "speed");
    return new PredefinedEffectsTemplateInput(paramList, paramSpeed, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PredefinedEffectsTemplateInput))
      {
        paramObject = (PredefinedEffectsTemplateInput)paramObject;
        if ((j.a(this.colors, ((PredefinedEffectsTemplateInput)paramObject).colors)) && (j.a(this.speed, ((PredefinedEffectsTemplateInput)paramObject).speed)) && (this.version == ((PredefinedEffectsTemplateInput)paramObject).version)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<LEColor> getColors()
  {
    return this.colors;
  }
  
  public final Speed getSpeed()
  {
    return this.speed;
  }
  
  public final int getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    Object localObject = this.colors;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.speed;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + i) * 31 + this.version;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PredefinedEffectsTemplateInput(colors=");
    localStringBuilder.append(this.colors);
    localStringBuilder.append(", speed=");
    localStringBuilder.append(this.speed);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\template\PredefinedEffectsTemplateInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
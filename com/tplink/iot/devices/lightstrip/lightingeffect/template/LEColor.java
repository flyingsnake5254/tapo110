package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c.a;
import kotlin.jvm.internal.j;

public final class LEColor
{
  public static final Companion Companion = new Companion(null);
  private final Integer b;
  private final Integer h;
  private final Integer s;
  
  public LEColor(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    this.h = paramInteger1;
    this.s = paramInteger2;
    this.b = paramInteger3;
  }
  
  public final Integer component1()
  {
    return this.h;
  }
  
  public final Integer component2()
  {
    return this.s;
  }
  
  public final Integer component3()
  {
    return this.b;
  }
  
  public final LEColor copy(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    return new LEColor(paramInteger1, paramInteger2, paramInteger3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LEColor))
      {
        paramObject = (LEColor)paramObject;
        if ((j.a(this.h, ((LEColor)paramObject).h)) && (j.a(this.s, ((LEColor)paramObject).s)) && (j.a(this.b, ((LEColor)paramObject).b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final Integer getB()
  {
    return this.b;
  }
  
  public final Integer getH()
  {
    return this.h;
  }
  
  public final Integer getS()
  {
    return this.s;
  }
  
  public int hashCode()
  {
    Integer localInteger = this.h;
    int i = 0;
    int j;
    if (localInteger != null) {
      j = localInteger.hashCode();
    } else {
      j = 0;
    }
    localInteger = this.s;
    int k;
    if (localInteger != null) {
      k = localInteger.hashCode();
    } else {
      k = 0;
    }
    localInteger = this.b;
    if (localInteger != null) {
      i = localInteger.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public final c toHSB()
  {
    Integer localInteger = this.h;
    int i = 0;
    int j;
    if (localInteger != null) {
      j = localInteger.intValue();
    } else {
      j = 0;
    }
    localInteger = this.s;
    if (localInteger != null) {
      i = localInteger.intValue();
    }
    localInteger = this.b;
    int k;
    if (localInteger != null) {
      k = localInteger.intValue();
    } else {
      k = 100;
    }
    return new c(j, i, k);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LEColor(h=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", s=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", b=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
  {
    public final LEColor fromHSB(c paramc)
    {
      j.e(paramc, "hsb");
      return new LEColor(Integer.valueOf(paramc.b()), Integer.valueOf(paramc.c()), Integer.valueOf(paramc.a()));
    }
    
    public final LEColor random()
    {
      c localc = c.b.a();
      return new LEColor(Integer.valueOf(localc.b()), Integer.valueOf(localc.c()), Integer.valueOf(localc.a()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\template\LEColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
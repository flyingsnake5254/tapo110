package com.tplink.iot.g.b.b;

import com.tplink.iot.g.b.b.e.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import kotlin.jvm.internal.j;

public final class c
  extends a
{
  private int b;
  private LightStateBean c;
  
  public c(int paramInt, LightStateBean paramLightStateBean)
  {
    super(false);
    this.b = paramInt;
    this.c = paramLightStateBean;
  }
  
  public final String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.getHue());
    localStringBuilder.append('-');
    localStringBuilder.append(this.c.getSaturation());
    localStringBuilder.append('-');
    localStringBuilder.append(this.c.getBrightness());
    localStringBuilder.append('-');
    localStringBuilder.append(this.c.getColorTemp());
    return localStringBuilder.toString();
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final LightStateBean e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.b == ((c)paramObject).b) && (j.a(this.c, ((c)paramObject).c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = this.b;
    LightStateBean localLightStateBean = this.c;
    int j;
    if (localLightStateBean != null) {
      j = localLightStateBean.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NormalColorItem(color=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", lightStateBean=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
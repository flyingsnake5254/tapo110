package com.tplink.iot.g.b.b;

import com.tplink.iot.g.b.b.e.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.PredefinedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import kotlin.jvm.internal.j;

public final class d
  extends a
{
  public static final a b = new a(null);
  private LightingEffectData c;
  private boolean d;
  private LightStateBean e;
  private String f;
  private final int g;
  private PredefinedEffect h;
  
  public d(String paramString, int paramInt, PredefinedEffect paramPredefinedEffect)
  {
    super(false);
    this.f = paramString;
    this.g = paramInt;
    this.h = paramPredefinedEffect;
  }
  
  public final LightStateBean c()
  {
    return this.e;
  }
  
  public final int d()
  {
    return this.g;
  }
  
  public final PredefinedEffect e()
  {
    return this.h;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((j.a(this.f, ((d)paramObject).f)) && (this.g == ((d)paramObject).g) && (j.a(this.h, ((d)paramObject).h))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String f()
  {
    Object localObject = this.h;
    if (localObject != null) {
      localObject = ((AbstractLightingEffect)localObject).getId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public final LightingEffectData g()
  {
    return this.c;
  }
  
  public final String h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    Object localObject = this.f;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    int k = this.g;
    localObject = this.h;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public final boolean i()
  {
    return this.d;
  }
  
  public final void j(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void k(LightStateBean paramLightStateBean)
  {
    this.e = paramLightStateBean;
  }
  
  public final void l(PredefinedEffect paramPredefinedEffect)
  {
    this.h = paramPredefinedEffect;
  }
  
  public final void m(LightingEffectData paramLightingEffectData)
  {
    this.c = paramLightingEffectData;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PredefinedEffectsItem(title=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", imgId=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", predefinedEffect=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
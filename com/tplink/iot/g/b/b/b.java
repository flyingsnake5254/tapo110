package com.tplink.iot.g.b.b;

import com.tplink.iot.g.b.b.e.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.List;
import kotlin.jvm.internal.j;

public final class b
  extends a
{
  private LightingEffectData b;
  private String c;
  private final List<Integer> d;
  private CustomizedEffect e;
  
  public b(String paramString, List<Integer> paramList, CustomizedEffect paramCustomizedEffect)
  {
    super(false);
    this.c = paramString;
    this.d = paramList;
    this.e = paramCustomizedEffect;
  }
  
  public final List<Integer> c()
  {
    return this.d;
  }
  
  public final CustomizedEffect d()
  {
    return this.e;
  }
  
  public final String e()
  {
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((AbstractLightingEffect)localObject).getId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((j.a(this.c, ((b)paramObject).c)) && (j.a(this.d, ((b)paramObject).d)) && (j.a(this.e, ((b)paramObject).e))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final LightingEffectData f()
  {
    return this.b;
  }
  
  public final String g()
  {
    return this.c;
  }
  
  public final void h(LightingEffectData paramLightingEffectData)
  {
    this.b = paramLightingEffectData;
  }
  
  public int hashCode()
  {
    Object localObject = this.c;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.d;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.e;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomizedEffectsItem(title=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", colors=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", customizedEffect=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
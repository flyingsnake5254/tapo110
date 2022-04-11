package com.tplink.iot.g.b.b;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizedEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import java.util.List;
import kotlin.jvm.internal.j;

public final class a
  extends com.tplink.iot.g.b.b.e.a
{
  private LightingEffectData b;
  private String c;
  private final List<Integer> d;
  private final List<Integer> e;
  private CustomizedEffect f;
  
  public a(String paramString, List<Integer> paramList1, List<Integer> paramList2, CustomizedEffect paramCustomizedEffect)
  {
    super(false);
    this.c = paramString;
    this.d = paramList1;
    this.e = paramList2;
    this.f = paramCustomizedEffect;
  }
  
  public final List<Integer> c()
  {
    return this.d;
  }
  
  public final CustomizedEffect d()
  {
    return this.f;
  }
  
  public final String e()
  {
    Object localObject = this.f;
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
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((j.a(this.c, ((a)paramObject).c)) && (j.a(this.d, ((a)paramObject).d)) && (j.a(this.e, ((a)paramObject).e)) && (j.a(this.f, ((a)paramObject).f))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final List<Integer> f()
  {
    return this.e;
  }
  
  public final LightingEffectData g()
  {
    return this.b;
  }
  
  public final String h()
  {
    return this.c;
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
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.f;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public final void i(LightingEffectData paramLightingEffectData)
  {
    this.b = paramLightingEffectData;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ColorPaintingItem(title=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", colors=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", parts=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", customizedEffect=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\g\b\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
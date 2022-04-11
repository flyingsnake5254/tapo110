package com.tplink.iot.model.iot;

import androidx.annotation.DrawableRes;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import kotlin.jvm.internal.j;

public final class b
{
  private final int a;
  private final String b;
  private final EnumIoTCategory c;
  private final String d;
  
  public b(@DrawableRes int paramInt, String paramString1, EnumIoTCategory paramEnumIoTCategory, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramEnumIoTCategory;
    this.d = paramString2;
  }
  
  public final EnumIoTCategory a()
  {
    return this.c;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.a == ((b)paramObject).a) && (j.a(this.b, ((b)paramObject).b)) && (j.a(this.c, ((b)paramObject).c)) && (j.a(this.d, ((b)paramObject).d))) {}
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
    int i = this.a;
    Object localObject = this.b;
    int j = 0;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.c;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((i * 31 + k) * 31 + m) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DevicePlaceholder(iconRes=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", category=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\iot\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
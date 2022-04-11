package com.tplink.iot.Utils.x0;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

final class k
{
  private final String a;
  private final String b;
  @c("device_id")
  private final String c;
  
  public k(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((j.a(this.a, ((k)paramObject).a)) && (j.a(this.b, ((k)paramObject).b)) && (j.a(this.c, ((k)paramObject).c))) {}
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
    String str = this.a;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.b;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.c;
    if (str != null) {
      i = str.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceInfo(type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", deviceId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.iot.Utils.x0;

import kotlin.jvm.internal.j;

public final class l
{
  private final String a;
  private final Object b;
  
  public l(String paramString, Object paramObject)
  {
    this.a = paramString;
    this.b = paramObject;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final Object b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof l))
      {
        paramObject = (l)paramObject;
        if ((j.a(this.a, ((l)paramObject).a)) && (j.a(this.b, ((l)paramObject).b))) {}
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
    Object localObject = this.a;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventValuePair(key=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\x0\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
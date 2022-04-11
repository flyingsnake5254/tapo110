package com.tplink.iot.model.smart;

import kotlin.jvm.internal.j;

public final class a
{
  private String a;
  private String b;
  private Object c;
  private boolean d;
  private String e;
  
  public a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramObject;
    this.d = paramBoolean;
    this.e = paramString3;
  }
  
  public final Object a()
  {
    return this.c;
  }
  
  public final boolean b()
  {
    return this.d;
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final String d()
  {
    return this.a;
  }
  
  public final String e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((j.a(this.a, ((a)paramObject).a)) && (j.a(this.b, ((a)paramObject).b)) && (j.a(this.c, ((a)paramObject).c)) && (this.d == ((a)paramObject).d) && (j.a(this.e, ((a)paramObject).e))) {}
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
    int n = this.d;
    int i1 = n;
    if (n != 0) {
      i1 = 1;
    }
    localObject = this.e;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + i1) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceTriggerSingleChoiceBean(triggerId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", triggerText=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", enabled=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", subTitle=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\smart\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
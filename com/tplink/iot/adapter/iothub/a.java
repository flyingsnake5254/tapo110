package com.tplink.iot.adapter.iothub;

import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import kotlin.jvm.internal.j;

public final class a
{
  public static final a a = new a(null);
  private final int b;
  private String c;
  private b d;
  
  public a(int paramInt, String paramString, b paramb)
  {
    this.b = paramInt;
    this.c = paramString;
    this.d = paramb;
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final b b()
  {
    return this.d;
  }
  
  public final boolean c()
  {
    int i = this.b;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.b == ((a)paramObject).b) && (j.a(this.c, ((a)paramObject).c)) && (j.a(this.d, ((a)paramObject).d))) {}
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
    Object localObject = this.c;
    int j = 0;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HubAlarmLogItemBean(type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", date=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", logContent=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class a {}
  
  public static final class b
  {
    private final String a;
    private final EnumGuardMode b;
    private final String c;
    
    public b(String paramString1, EnumGuardMode paramEnumGuardMode, String paramString2)
    {
      this.a = paramString1;
      this.b = paramEnumGuardMode;
      this.c = paramString2;
    }
    
    public final String a()
    {
      return this.c;
    }
    
    public final EnumGuardMode b()
    {
      return this.b;
    }
    
    public final String c()
    {
      return this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((j.a(this.a, ((b)paramObject).a)) && (j.a(this.b, ((b)paramObject).b)) && (j.a(this.c, ((b)paramObject).c))) {}
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
      if (localObject != null) {
        i = localObject.hashCode();
      }
      return (j * 31 + k) * 31 + i;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LogContent(time=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", guardMode=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", deviceName=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\iothub\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
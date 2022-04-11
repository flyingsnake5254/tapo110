package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class Wrapper<T>
{
  private final T data;
  private final String module;
  private final String section;
  
  public Wrapper(Module paramModule, Section paramSection, T paramT)
  {
    this(paramModule.getValue(), paramSection.getValue(), paramT);
  }
  
  public Wrapper(String paramString1, String paramString2, T paramT)
  {
    this.module = paramString1;
    this.section = paramString2;
    this.data = paramT;
  }
  
  public final String component1()
  {
    return this.module;
  }
  
  public final String component2()
  {
    return this.section;
  }
  
  public final T component3()
  {
    return (T)this.data;
  }
  
  public final Wrapper<T> copy(String paramString1, String paramString2, T paramT)
  {
    j.e(paramString1, "module");
    j.e(paramString2, "section");
    return new Wrapper(paramString1, paramString2, paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Wrapper))
      {
        paramObject = (Wrapper)paramObject;
        if ((j.a(this.module, ((Wrapper)paramObject).module)) && (j.a(this.section, ((Wrapper)paramObject).section)) && (j.a(this.data, ((Wrapper)paramObject).data))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final T getData()
  {
    return (T)this.data;
  }
  
  public final String getModule()
  {
    return this.module;
  }
  
  public final String getSection()
  {
    return this.section;
  }
  
  public int hashCode()
  {
    Object localObject = this.module;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.section;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.data;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrapper(module=");
    localStringBuilder.append(this.module);
    localStringBuilder.append(", section=");
    localStringBuilder.append(this.section);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.data);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Wrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
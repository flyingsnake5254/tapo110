package com.tplink.tdp.tlv.adapter;

import java.lang.reflect.Type;

public class e<T>
{
  private final Class<? super T> a;
  private final int b;
  private final Type[] c;
  
  public e(Class paramClass, Type paramType)
  {
    this.a = paramClass;
    this.c = f.d(paramType);
    this.b = paramClass.hashCode();
  }
  
  public e(Type paramType)
  {
    this.a = f.b(paramType);
    this.c = f.d(paramType);
    this.b = paramType.hashCode();
  }
  
  public Class<? super T> a()
  {
    return this.a;
  }
  
  public Type[] b()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof e)) && (f.a(this, (e)paramObject))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TypeToken");
    localStringBuilder.append("\n");
    localStringBuilder.append("rawType:");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append("\n");
    Type[] arrayOfType = this.c;
    if (arrayOfType != null)
    {
      int i = arrayOfType.length;
      for (int j = 0; j < i; j++)
      {
        Type localType = arrayOfType[j];
        localStringBuilder.append("typeArgs:");
        localStringBuilder.append(localType.toString());
        localStringBuilder.append("\t");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\tlv\adapter\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
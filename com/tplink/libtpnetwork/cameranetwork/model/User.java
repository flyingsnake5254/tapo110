package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class User
{
  private final int age;
  private final String name;
  
  public User(String paramString, int paramInt)
  {
    this.name = paramString;
    this.age = paramInt;
  }
  
  public final String component1()
  {
    return this.name;
  }
  
  public final int component2()
  {
    return this.age;
  }
  
  public final User copy(String paramString, int paramInt)
  {
    j.e(paramString, "name");
    return new User(paramString, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof User))
      {
        paramObject = (User)paramObject;
        if ((j.a(this.name, ((User)paramObject).name)) && (this.age == ((User)paramObject).age)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getAge()
  {
    return this.age;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    String str = this.name;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.age;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("User(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.age);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
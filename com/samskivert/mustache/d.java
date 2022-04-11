package com.samskivert.mustache;

import java.util.List;
import kotlin.jvm.internal.j;

public final class d
{
  private final String a;
  private final List<Object> b;
  
  public d(String paramString, List<? extends Object> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final List<Object> b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((j.a(this.a, ((d)paramObject).a)) && (j.a(this.b, ((d)paramObject).b))) {}
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
    localStringBuilder.append("FunctionExpression(functionName=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
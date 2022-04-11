package com.tplink.iot.Utils;

import java.util.HashMap;
import kotlin.jvm.internal.j;

final class g
{
  private final boolean a;
  private final HashMap<String, Integer> b;
  
  public g()
  {
    this(false, null, 3, null);
  }
  
  public g(boolean paramBoolean, HashMap<String, Integer> paramHashMap)
  {
    this.a = paramBoolean;
    this.b = paramHashMap;
  }
  
  public final HashMap<String, Integer> a()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((this.a == ((g)paramObject).a) && (j.a(this.b, ((g)paramObject).b))) {}
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
    boolean bool1 = this.a;
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = true;
    }
    HashMap localHashMap = this.b;
    int i;
    if (localHashMap != null) {
      i = localHashMap.hashCode();
    } else {
      i = 0;
    }
    return bool2 * true + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraLiveConfig(singleScreen=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mapping=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class h<T>
{
  @Nullable
  T a;
  @Nullable
  T b;
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void b(T paramT1, T paramT2)
  {
    this.a = paramT1;
    this.b = paramT2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Pair;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (Pair)paramObject;
    bool1 = bool2;
    if (a(((Pair)paramObject).first, this.a))
    {
      bool1 = bool2;
      if (a(((Pair)paramObject).second, this.b)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = localObject.hashCode();
    }
    localObject = this.b;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j ^ i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Pair{");
    localStringBuilder.append(String.valueOf(this.a));
    localStringBuilder.append(" ");
    localStringBuilder.append(String.valueOf(this.b));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
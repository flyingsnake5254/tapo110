package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.j;

public final class Triple<A, B, C>
  implements Serializable
{
  private final A first;
  private final B second;
  private final C third;
  
  public Triple(A paramA, B paramB, C paramC)
  {
    this.first = paramA;
    this.second = paramB;
    this.third = paramC;
  }
  
  public final A component1()
  {
    return (A)this.first;
  }
  
  public final B component2()
  {
    return (B)this.second;
  }
  
  public final C component3()
  {
    return (C)this.third;
  }
  
  public final Triple<A, B, C> copy(A paramA, B paramB, C paramC)
  {
    return new Triple(paramA, paramB, paramC);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Triple))
      {
        paramObject = (Triple)paramObject;
        if ((j.a(this.first, ((Triple)paramObject).first)) && (j.a(this.second, ((Triple)paramObject).second)) && (j.a(this.third, ((Triple)paramObject).third))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final A getFirst()
  {
    return (A)this.first;
  }
  
  public final B getSecond()
  {
    return (B)this.second;
  }
  
  public final C getThird()
  {
    return (C)this.third;
  }
  
  public int hashCode()
  {
    Object localObject = this.first;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.second;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.third;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append(this.first);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.second);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.third);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\Triple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
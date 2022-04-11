package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.j;

public final class Pair<A, B>
  implements Serializable
{
  private final A first;
  private final B second;
  
  public Pair(A paramA, B paramB)
  {
    this.first = paramA;
    this.second = paramB;
  }
  
  public final A component1()
  {
    return (A)this.first;
  }
  
  public final B component2()
  {
    return (B)this.second;
  }
  
  public final Pair<A, B> copy(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        if ((j.a(this.first, ((Pair)paramObject).first)) && (j.a(this.second, ((Pair)paramObject).second))) {}
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
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append(this.first);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.second);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
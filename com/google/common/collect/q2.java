package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class q2<T>
  extends a2<T>
  implements Serializable
{
  final a2<? super T> c;
  
  q2(a2<? super T> parama2)
  {
    this.c = ((a2)n.o(parama2));
  }
  
  public int compare(T paramT1, T paramT2)
  {
    return this.c.compare(paramT2, paramT1);
  }
  
  public <E extends T> E d(E paramE1, E paramE2)
  {
    return (E)this.c.f(paramE1, paramE2);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof q2))
    {
      paramObject = (q2)paramObject;
      return this.c.equals(((q2)paramObject).c);
    }
    return false;
  }
  
  public <E extends T> E f(E paramE1, E paramE2)
  {
    return (E)this.c.d(paramE1, paramE2);
  }
  
  public int hashCode()
  {
    return -this.c.hashCode();
  }
  
  public <S extends T> a2<S> j()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(".reverse()");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\q2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
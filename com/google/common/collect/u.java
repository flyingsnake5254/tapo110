package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class u<F, T>
  extends a2<F>
  implements Serializable
{
  final h<F, ? extends T> c;
  final a2<T> d;
  
  u(h<F, ? extends T> paramh, a2<T> parama2)
  {
    this.c = ((h)n.o(paramh));
    this.d = ((a2)n.o(parama2));
  }
  
  public int compare(F paramF1, F paramF2)
  {
    return this.d.compare(this.c.apply(paramF1), this.c.apply(paramF2));
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof u))
    {
      paramObject = (u)paramObject;
      if ((!this.c.equals(((u)paramObject).c)) || (!this.d.equals(((u)paramObject).d))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { this.c, this.d });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(".onResultOf(");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
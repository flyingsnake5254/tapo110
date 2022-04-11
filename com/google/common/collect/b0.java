package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class b0<T>
  extends a2<T>
  implements Serializable
{
  final Comparator<T> c;
  
  b0(Comparator<T> paramComparator)
  {
    this.c = ((Comparator)n.o(paramComparator));
  }
  
  public int compare(T paramT1, T paramT2)
  {
    return this.c.compare(paramT1, paramT2);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof b0))
    {
      paramObject = (b0)paramObject;
      return this.c.equals(((b0)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    return this.c.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
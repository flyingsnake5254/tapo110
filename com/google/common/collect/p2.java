package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;

final class p2
  extends a2<Comparable>
  implements Serializable
{
  static final p2 c = new p2();
  
  public <S extends Comparable> a2<S> j()
  {
    return a2.g();
  }
  
  public int k(Comparable paramComparable1, Comparable paramComparable2)
  {
    n.o(paramComparable1);
    if (paramComparable1 == paramComparable2) {
      return 0;
    }
    return paramComparable2.compareTo(paramComparable1);
  }
  
  public <E extends Comparable> E l(E paramE1, E paramE2)
  {
    return (Comparable)w1.c.f(paramE1, paramE2);
  }
  
  public <E extends Comparable> E m(E paramE1, E paramE2)
  {
    return (Comparable)w1.c.d(paramE1, paramE2);
  }
  
  public String toString()
  {
    return "Ordering.natural().reverse()";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\p2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
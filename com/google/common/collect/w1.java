package com.google.common.collect;

import com.google.common.base.n;
import java.io.Serializable;

final class w1
  extends a2<Comparable>
  implements Serializable
{
  static final w1 c = new w1();
  
  public <S extends Comparable> a2<S> j()
  {
    return p2.c;
  }
  
  public int k(Comparable paramComparable1, Comparable paramComparable2)
  {
    n.o(paramComparable1);
    n.o(paramComparable2);
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public String toString()
  {
    return "Ordering.natural()";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\w1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
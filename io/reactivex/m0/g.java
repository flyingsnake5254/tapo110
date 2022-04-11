package io.reactivex.m0;

import io.reactivex.q;
import io.reactivex.v;

public abstract class g<T>
  extends q<T>
  implements v<T>
{
  public abstract boolean j1();
  
  public abstract boolean k1();
  
  public final g<T> l1()
  {
    if ((this instanceof f)) {
      return this;
    }
    return new f(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\m0\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
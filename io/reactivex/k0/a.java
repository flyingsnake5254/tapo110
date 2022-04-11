package io.reactivex.k0;

import io.reactivex.h;
import io.reactivex.k;

public abstract class a<T>
  extends h<T>
  implements k<T>
{
  public final a<T> M()
  {
    if ((this instanceof b)) {
      return this;
    }
    return new b(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\k0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
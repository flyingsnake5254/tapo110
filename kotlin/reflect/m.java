package kotlin.reflect;

import kotlin.jvm.b.p;

public abstract interface m<D, E, V>
  extends j<V>, p<D, E, V>
{
  public abstract Object getDelegate(D paramD, E paramE);
  
  public abstract a<D, E, V> getGetter();
  
  public static abstract interface a<D, E, V>
    extends j.a<V>, p<D, E, V>
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\reflect\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
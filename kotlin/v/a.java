package kotlin.v;

import kotlin.jvm.internal.j;

public abstract interface a<T extends Comparable<? super T>>
{
  public abstract T getEndInclusive();
  
  public abstract T getStart();
  
  public static final class a
  {
    public static <T extends Comparable<? super T>> boolean a(a<T> parama, T paramT)
    {
      j.e(paramT, "value");
      boolean bool;
      if ((paramT.compareTo(parama.getStart()) >= 0) && (paramT.compareTo(parama.getEndInclusive()) <= 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public static <T extends Comparable<? super T>> boolean b(a<T> parama)
    {
      boolean bool;
      if (parama.getStart().compareTo(parama.getEndInclusive()) > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\v\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
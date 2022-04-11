package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;
import kotlin.v.a;
import kotlin.v.a.a;

public final class RangeKt
{
  @RequiresApi(21)
  public static final <T extends Comparable<? super T>> Range<T> and(Range<T> paramRange1, Range<T> paramRange2)
  {
    j.f(paramRange1, "$this$and");
    j.f(paramRange2, "other");
    paramRange1 = paramRange1.intersect(paramRange2);
    j.b(paramRange1, "intersect(other)");
    return paramRange1;
  }
  
  @RequiresApi(21)
  public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> paramRange1, Range<T> paramRange2)
  {
    j.f(paramRange1, "$this$plus");
    j.f(paramRange2, "other");
    paramRange1 = paramRange1.extend(paramRange2);
    j.b(paramRange1, "extend(other)");
    return paramRange1;
  }
  
  @RequiresApi(21)
  public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> paramRange, T paramT)
  {
    j.f(paramRange, "$this$plus");
    j.f(paramT, "value");
    paramRange = paramRange.extend(paramT);
    j.b(paramRange, "extend(value)");
    return paramRange;
  }
  
  @RequiresApi(21)
  public static final <T extends Comparable<? super T>> Range<T> rangeTo(T paramT1, T paramT2)
  {
    j.f(paramT1, "$this$rangeTo");
    j.f(paramT2, "that");
    return new Range(paramT1, paramT2);
  }
  
  @RequiresApi(21)
  public static final <T extends Comparable<? super T>> a<T> toClosedRange(Range<T> paramRange)
  {
    j.f(paramRange, "$this$toClosedRange");
    new a()
    {
      public boolean contains(T paramAnonymousT)
      {
        j.f(paramAnonymousT, "value");
        return a.a.a(this, paramAnonymousT);
      }
      
      public T getEndInclusive()
      {
        return this.$this_toClosedRange.getUpper();
      }
      
      public T getStart()
      {
        return this.$this_toClosedRange.getLower();
      }
      
      public boolean isEmpty()
      {
        return a.a.b(this);
      }
    };
  }
  
  @RequiresApi(21)
  public static final <T extends Comparable<? super T>> Range<T> toRange(a<T> parama)
  {
    j.f(parama, "$this$toRange");
    return new Range(parama.getStart(), parama.getEndInclusive());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\RangeKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
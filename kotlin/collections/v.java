package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.j;
import kotlin.q.a;
import kotlin.sequences.f;
import kotlin.text.m;

class v
  extends u
{
  public static final <T> int A(Iterable<? extends T> paramIterable, T paramT)
  {
    j.e(paramIterable, "$this$indexOf");
    if ((paramIterable instanceof List)) {
      return ((List)paramIterable).indexOf(paramT);
    }
    int i = 0;
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = localIterator.next();
      if (i < 0) {
        l.k();
      }
      if (j.a(paramT, paramIterable)) {
        return i;
      }
      i++;
    }
    return -1;
  }
  
  public static final <T, A extends Appendable> A B(Iterable<? extends T> paramIterable, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, kotlin.jvm.b.l<? super T, ? extends CharSequence> paraml)
  {
    j.e(paramIterable, "$this$joinTo");
    j.e(paramA, "buffer");
    j.e(paramCharSequence1, "separator");
    j.e(paramCharSequence2, "prefix");
    j.e(paramCharSequence3, "postfix");
    j.e(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    paramCharSequence2 = paramIterable.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!paramCharSequence2.hasNext()) {
        break;
      }
      paramIterable = paramCharSequence2.next();
      i++;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        j = i;
        if (i > paramInt) {
          break;
        }
      }
      m.a(paramA, paramIterable, paraml);
    }
    if ((paramInt >= 0) && (j > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  public static final <T> String D(Iterable<? extends T> paramIterable, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, kotlin.jvm.b.l<? super T, ? extends CharSequence> paraml)
  {
    j.e(paramIterable, "$this$joinToString");
    j.e(paramCharSequence1, "separator");
    j.e(paramCharSequence2, "prefix");
    j.e(paramCharSequence3, "postfix");
    j.e(paramCharSequence4, "truncated");
    paramIterable = ((StringBuilder)B(paramIterable, new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paraml)).toString();
    j.d(paramIterable, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramIterable;
  }
  
  public static <T> T F(List<? extends T> paramList)
  {
    j.e(paramList, "$this$last");
    if (!paramList.isEmpty()) {
      return (T)paramList.get(l.f(paramList));
    }
    throw new NoSuchElementException("List is empty.");
  }
  
  public static <T> T G(List<? extends T> paramList)
  {
    j.e(paramList, "$this$lastOrNull");
    if (paramList.isEmpty()) {
      paramList = null;
    } else {
      paramList = paramList.get(paramList.size() - 1);
    }
    return paramList;
  }
  
  public static Float H(Iterable<Float> paramIterable)
  {
    j.e(paramIterable, "$this$maxOrNull");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return null;
    }
    for (float f = ((Number)paramIterable.next()).floatValue(); paramIterable.hasNext(); f = Math.max(f, ((Number)paramIterable.next()).floatValue())) {}
    return Float.valueOf(f);
  }
  
  public static <T extends Comparable<? super T>> T I(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$minOrNull");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      return null;
    }
    paramIterable = (Comparable)localIterator.next();
    while (localIterator.hasNext())
    {
      Comparable localComparable = (Comparable)localIterator.next();
      if (paramIterable.compareTo(localComparable) > 0) {
        paramIterable = localComparable;
      }
    }
    return paramIterable;
  }
  
  public static Float J(Iterable<Float> paramIterable)
  {
    j.e(paramIterable, "$this$minOrNull");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return null;
    }
    for (float f = ((Number)paramIterable.next()).floatValue(); paramIterable.hasNext(); f = Math.min(f, ((Number)paramIterable.next()).floatValue())) {}
    return Float.valueOf(f);
  }
  
  public static <T> T K(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$single");
    if ((paramIterable instanceof List)) {
      return (T)L((List)paramIterable);
    }
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      paramIterable = localIterator.next();
      if (!localIterator.hasNext()) {
        return paramIterable;
      }
      throw new IllegalArgumentException("Collection has more than one element.");
    }
    throw new NoSuchElementException("Collection is empty.");
  }
  
  public static final <T> T L(List<? extends T> paramList)
  {
    j.e(paramList, "$this$single");
    int i = paramList.size();
    if (i != 0)
    {
      if (i == 1) {
        return (T)paramList.get(0);
      }
      throw new IllegalArgumentException("List has more than one element.");
    }
    throw new NoSuchElementException("List is empty.");
  }
  
  public static <T extends Comparable<? super T>> List<T> M(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$sorted");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      if (localCollection.size() <= 1) {
        return l.S(paramIterable);
      }
      paramIterable = localCollection.toArray(new Comparable[0]);
      Objects.requireNonNull(paramIterable, "null cannot be cast to non-null type kotlin.Array<T>");
      paramIterable = (Comparable[])paramIterable;
      h.g(paramIterable);
      return e.b(paramIterable);
    }
    paramIterable = T(paramIterable);
    l.n(paramIterable);
    return paramIterable;
  }
  
  public static <T extends Comparable<? super T>> List<T> N(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$sortedDescending");
    return l.O(paramIterable, a.b());
  }
  
  public static <T> List<T> O(Iterable<? extends T> paramIterable, Comparator<? super T> paramComparator)
  {
    j.e(paramIterable, "$this$sortedWith");
    j.e(paramComparator, "comparator");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      if (localCollection.size() <= 1) {
        return l.S(paramIterable);
      }
      paramIterable = localCollection.toArray(new Object[0]);
      Objects.requireNonNull(paramIterable, "null cannot be cast to non-null type kotlin.Array<T>");
      h.h(paramIterable, paramComparator);
      return e.b(paramIterable);
    }
    paramIterable = T(paramIterable);
    l.o(paramIterable, paramComparator);
    return paramIterable;
  }
  
  public static <T> List<T> P(Iterable<? extends T> paramIterable, int paramInt)
  {
    j.e(paramIterable, "$this$take");
    int i = 0;
    int j;
    if (paramInt >= 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      if (paramInt == 0) {
        return l.d();
      }
      if ((paramIterable instanceof Collection))
      {
        if (paramInt >= ((Collection)paramIterable).size()) {
          return l.S(paramIterable);
        }
        if (paramInt == 1) {
          return l.b(l.w(paramIterable));
        }
      }
      ArrayList localArrayList = new ArrayList(paramInt);
      paramIterable = paramIterable.iterator();
      j = i;
      do
      {
        if (!paramIterable.hasNext()) {
          break;
        }
        localArrayList.add(paramIterable.next());
        i = j + 1;
        j = i;
      } while (i != paramInt);
      return l.i(localArrayList);
    }
    paramIterable = new StringBuilder();
    paramIterable.append("Requested element count ");
    paramIterable.append(paramInt);
    paramIterable.append(" is less than zero.");
    throw new IllegalArgumentException(paramIterable.toString().toString());
  }
  
  public static final <T, C extends Collection<? super T>> C Q(Iterable<? extends T> paramIterable, C paramC)
  {
    j.e(paramIterable, "$this$toCollection");
    j.e(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    return paramC;
  }
  
  public static int[] R(Collection<Integer> paramCollection)
  {
    j.e(paramCollection, "$this$toIntArray");
    int[] arrayOfInt = new int[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    for (int i = 0; paramCollection.hasNext(); i++) {
      arrayOfInt[i] = ((Number)paramCollection.next()).intValue();
    }
    return arrayOfInt;
  }
  
  public static <T> List<T> S(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$toList");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      int i = localCollection.size();
      if (i != 0)
      {
        if (i != 1)
        {
          paramIterable = l.U(localCollection);
        }
        else
        {
          if ((paramIterable instanceof List)) {
            paramIterable = ((List)paramIterable).get(0);
          } else {
            paramIterable = paramIterable.iterator().next();
          }
          paramIterable = l.b(paramIterable);
        }
      }
      else {
        paramIterable = l.d();
      }
      return paramIterable;
    }
    return l.i(T(paramIterable));
  }
  
  public static final <T> List<T> T(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$toMutableList");
    if ((paramIterable instanceof Collection)) {
      return l.U((Collection)paramIterable);
    }
    return (List)Q(paramIterable, new ArrayList());
  }
  
  public static <T> List<T> U(Collection<? extends T> paramCollection)
  {
    j.e(paramCollection, "$this$toMutableList");
    return new ArrayList(paramCollection);
  }
  
  public static <T> Set<T> V(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$toSet");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      int i = localCollection.size();
      if (i != 0)
      {
        if (i != 1)
        {
          paramIterable = (Set)Q(paramIterable, new LinkedHashSet(b0.a(localCollection.size())));
        }
        else
        {
          if ((paramIterable instanceof List)) {
            paramIterable = ((List)paramIterable).get(0);
          } else {
            paramIterable = paramIterable.iterator().next();
          }
          paramIterable = g0.a(paramIterable);
        }
      }
      else {
        paramIterable = h0.b();
      }
      return paramIterable;
    }
    return h0.c((Set)Q(paramIterable, new LinkedHashSet()));
  }
  
  public static <T> f<T> t(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$asSequence");
    return new a(paramIterable);
  }
  
  public static double u(Iterable<Integer> paramIterable)
  {
    j.e(paramIterable, "$this$average");
    paramIterable = paramIterable.iterator();
    double d1 = 0.0D;
    int i = 0;
    while (paramIterable.hasNext())
    {
      double d2 = d1 + ((Number)paramIterable.next()).intValue();
      int j = i + 1;
      d1 = d2;
      i = j;
      if (j < 0)
      {
        l.j();
        d1 = d2;
        i = j;
      }
    }
    if (i == 0) {
      d1 = NaN.0D;
    } else {
      d1 /= i;
    }
    return d1;
  }
  
  public static <T> boolean v(Iterable<? extends T> paramIterable, T paramT)
  {
    j.e(paramIterable, "$this$contains");
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).contains(paramT);
    }
    boolean bool;
    if (A(paramIterable, paramT) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static <T> T w(Iterable<? extends T> paramIterable)
  {
    j.e(paramIterable, "$this$first");
    if ((paramIterable instanceof List)) {
      return (T)l.x((List)paramIterable);
    }
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext()) {
      return (T)paramIterable.next();
    }
    throw new NoSuchElementException("Collection is empty.");
  }
  
  public static <T> T x(List<? extends T> paramList)
  {
    j.e(paramList, "$this$first");
    if (!paramList.isEmpty()) {
      return (T)paramList.get(0);
    }
    throw new NoSuchElementException("List is empty.");
  }
  
  public static <T> T y(List<? extends T> paramList)
  {
    j.e(paramList, "$this$firstOrNull");
    if (paramList.isEmpty()) {
      paramList = null;
    } else {
      paramList = paramList.get(0);
    }
    return paramList;
  }
  
  public static <T> T z(List<? extends T> paramList, int paramInt)
  {
    j.e(paramList, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= l.f(paramList))) {
      paramList = paramList.get(paramInt);
    } else {
      paramList = null;
    }
    return paramList;
  }
  
  public static final class a
    implements f<T>
  {
    public a(Iterable paramIterable) {}
    
    public Iterator<T> iterator()
    {
      return this.a.iterator();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
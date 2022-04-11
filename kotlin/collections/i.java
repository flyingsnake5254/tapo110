package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

class i
  extends h
{
  public static boolean i(int[] paramArrayOfInt, int paramInt)
  {
    j.e(paramArrayOfInt, "$this$contains");
    boolean bool;
    if (m(paramArrayOfInt, paramInt) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static <T> boolean j(T[] paramArrayOfT, T paramT)
  {
    j.e(paramArrayOfT, "$this$contains");
    boolean bool;
    if (n(paramArrayOfT, paramT) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final <T> int k(T[] paramArrayOfT)
  {
    j.e(paramArrayOfT, "$this$lastIndex");
    return paramArrayOfT.length - 1;
  }
  
  public static <T> T l(T[] paramArrayOfT, int paramInt)
  {
    j.e(paramArrayOfT, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= k(paramArrayOfT))) {
      paramArrayOfT = paramArrayOfT[paramInt];
    } else {
      paramArrayOfT = null;
    }
    return paramArrayOfT;
  }
  
  public static final int m(int[] paramArrayOfInt, int paramInt)
  {
    j.e(paramArrayOfInt, "$this$indexOf");
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      if (paramInt == paramArrayOfInt[j]) {
        return j;
      }
    }
    return -1;
  }
  
  public static final <T> int n(T[] paramArrayOfT, T paramT)
  {
    j.e(paramArrayOfT, "$this$indexOf");
    int i = 0;
    int j = 0;
    if (paramT == null)
    {
      i = paramArrayOfT.length;
      while (j < i)
      {
        if (paramArrayOfT[j] == null) {
          return j;
        }
        j++;
      }
    }
    int k = paramArrayOfT.length;
    for (j = i; j < k; j++) {
      if (j.a(paramT, paramArrayOfT[j])) {
        return j;
      }
    }
    return -1;
  }
  
  public static final <A extends Appendable> A o(int[] paramArrayOfInt, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, l<? super Integer, ? extends CharSequence> paraml)
  {
    j.e(paramArrayOfInt, "$this$joinTo");
    j.e(paramA, "buffer");
    j.e(paramCharSequence1, "separator");
    j.e(paramCharSequence2, "prefix");
    j.e(paramCharSequence3, "postfix");
    j.e(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = paramArrayOfInt.length;
    int j = 0;
    int k = 0;
    int m;
    for (;;)
    {
      m = k;
      if (j >= i) {
        break;
      }
      int n = paramArrayOfInt[j];
      k++;
      if (k > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        m = k;
        if (k > paramInt) {
          break;
        }
      }
      if (paraml != null) {
        paramA.append((CharSequence)paraml.invoke(Integer.valueOf(n)));
      } else {
        paramA.append(String.valueOf(n));
      }
      j++;
    }
    if ((paramInt >= 0) && (m > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  public static final String p(int[] paramArrayOfInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, l<? super Integer, ? extends CharSequence> paraml)
  {
    j.e(paramArrayOfInt, "$this$joinToString");
    j.e(paramCharSequence1, "separator");
    j.e(paramCharSequence2, "prefix");
    j.e(paramCharSequence3, "postfix");
    j.e(paramCharSequence4, "truncated");
    paramArrayOfInt = ((StringBuilder)o(paramArrayOfInt, new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paraml)).toString();
    j.d(paramArrayOfInt, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramArrayOfInt;
  }
  
  public static char r(char[] paramArrayOfChar)
  {
    j.e(paramArrayOfChar, "$this$single");
    int i = paramArrayOfChar.length;
    if (i != 0)
    {
      if (i == 1) {
        return paramArrayOfChar[0];
      }
      throw new IllegalArgumentException("Array has more than one element.");
    }
    throw new NoSuchElementException("Array is empty.");
  }
  
  public static <T> T s(T[] paramArrayOfT)
  {
    j.e(paramArrayOfT, "$this$singleOrNull");
    if (paramArrayOfT.length == 1) {
      paramArrayOfT = paramArrayOfT[0];
    } else {
      paramArrayOfT = null;
    }
    return paramArrayOfT;
  }
  
  public static int[] t(int[] paramArrayOfInt)
  {
    j.e(paramArrayOfInt, "$this$sortedArray");
    int i;
    if (paramArrayOfInt.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramArrayOfInt;
    }
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    j.d(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    h.f(paramArrayOfInt);
    return paramArrayOfInt;
  }
  
  public static final <T> T[] u(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    j.e(paramArrayOfT, "$this$sortedArrayWith");
    j.e(paramComparator, "comparator");
    int i;
    if (paramArrayOfT.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length);
    j.d(paramArrayOfT, "java.util.Arrays.copyOf(this, size)");
    h.h(paramArrayOfT, paramComparator);
    return paramArrayOfT;
  }
  
  public static <T> List<T> v(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    j.e(paramArrayOfT, "$this$sortedWith");
    j.e(paramComparator, "comparator");
    return e.b(u(paramArrayOfT, paramComparator));
  }
  
  public static float w(Float[] paramArrayOfFloat)
  {
    j.e(paramArrayOfFloat, "$this$sum");
    int i = paramArrayOfFloat.length;
    float f = 0.0F;
    for (int j = 0; j < i; j++) {
      f += paramArrayOfFloat[j].floatValue();
    }
    return f;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\collections\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
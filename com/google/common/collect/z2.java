package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.n;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class z2
{
  public static <E, K extends Comparable> int a(List<E> paramList, h<? super E, K> paramh, @NullableDecl K paramK, c paramc, b paramb)
  {
    return b(paramList, paramh, paramK, a2.g(), paramc, paramb);
  }
  
  public static <E, K> int b(List<E> paramList, h<? super E, K> paramh, @NullableDecl K paramK, Comparator<? super K> paramComparator, c paramc, b paramb)
  {
    return c(n1.m(paramList, paramh), paramK, paramComparator, paramc, paramb);
  }
  
  public static <E> int c(List<? extends E> paramList, @NullableDecl E paramE, Comparator<? super E> paramComparator, c paramc, b paramb)
  {
    n.o(paramComparator);
    n.o(paramList);
    n.o(paramc);
    n.o(paramb);
    Object localObject = paramList;
    if (!(paramList instanceof RandomAccess)) {
      localObject = n1.i(paramList);
    }
    int i = 0;
    int j = ((List)localObject).size() - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = paramComparator.compare(paramE, ((List)localObject).get(k));
      if (m < 0) {
        j = k - 1;
      } else if (m > 0) {
        i = k + 1;
      } else {
        return i + paramc.a(paramComparator, paramE, ((List)localObject).subList(i, j + 1), k - i);
      }
    }
    return paramb.a(i);
  }
  
  static abstract enum b
  {
    static
    {
      a locala = new a("NEXT_LOWER", 0);
      c = locala;
      b localb = new b("NEXT_HIGHER", 1);
      d = localb;
      c localc = new c("INVERTED_INSERTION_INDEX", 2);
      f = localc;
      q = new b[] { locala, localb, localc };
    }
    
    abstract int a(int paramInt);
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      int a(int paramInt)
      {
        return paramInt - 1;
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      public int a(int paramInt)
      {
        return paramInt;
      }
    }
    
    static enum c
    {
      c()
      {
        super(paramInt, null);
      }
      
      public int a(int paramInt)
      {
        return paramInt ^ 0xFFFFFFFF;
      }
    }
  }
  
  static abstract enum c
  {
    static
    {
      a locala = new a("ANY_PRESENT", 0);
      c = locala;
      b localb = new b("LAST_PRESENT", 1);
      d = localb;
      c localc = new c("FIRST_PRESENT", 2);
      f = localc;
      d locald = new d("FIRST_AFTER", 3);
      q = locald;
      e locale = new e("LAST_BEFORE", 4);
      x = locale;
      y = new c[] { locala, localb, localc, locald, locale };
    }
    
    abstract <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt);
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
      {
        return paramInt;
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
      {
        int i = paramList.size() - 1;
        while (paramInt < i)
        {
          int j = paramInt + i + 1 >>> 1;
          if (paramComparator.compare(paramList.get(j), paramE) > 0) {
            i = j - 1;
          } else {
            paramInt = j;
          }
        }
        return paramInt;
      }
    }
    
    static enum c
    {
      c()
      {
        super(paramInt, null);
      }
      
      <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
      {
        int i = 0;
        while (i < paramInt)
        {
          int j = i + paramInt >>> 1;
          if (paramComparator.compare(paramList.get(j), paramE) < 0) {
            i = j + 1;
          } else {
            paramInt = j;
          }
        }
        return i;
      }
    }
    
    static enum d
    {
      d()
      {
        super(paramInt, null);
      }
      
      public <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
      {
        return z2.c.d.a(paramComparator, paramE, paramList, paramInt) + 1;
      }
    }
    
    static enum e
    {
      e()
      {
        super(paramInt, null);
      }
      
      public <E> int a(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
      {
        return z2.c.f.a(paramComparator, paramE, paramList, paramInt) - 1;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\z2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
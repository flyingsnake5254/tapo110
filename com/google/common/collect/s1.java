package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.base.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class s1<K0, V0>
{
  public static e<Object> a()
  {
    return b(8);
  }
  
  public static e<Object> b(int paramInt)
  {
    v.b(paramInt, "expectedKeys");
    return new a(paramInt);
  }
  
  public static e<Comparable> c()
  {
    return d(a2.g());
  }
  
  public static <K0> e<K0> d(Comparator<K0> paramComparator)
  {
    n.o(paramComparator);
    return new b(paramComparator);
  }
  
  static final class a
    extends s1.e<Object>
  {
    a(int paramInt) {}
    
    <K, V> Map<K, Collection<V>> c()
    {
      return c2.c(this.a);
    }
  }
  
  static final class b
    extends s1.e<K0>
  {
    b(Comparator paramComparator) {}
    
    <K extends K0, V> Map<K, Collection<V>> c()
    {
      return new TreeMap(this.a);
    }
  }
  
  private static final class c<V>
    implements t<List<V>>, Serializable
  {
    private final int c;
    
    c(int paramInt)
    {
      this.c = v.b(paramInt, "expectedValuesPerKey");
    }
    
    public List<V> a()
    {
      return new ArrayList(this.c);
    }
  }
  
  public static abstract class d<K0, V0>
    extends s1<K0, V0>
  {
    d()
    {
      super();
    }
    
    public abstract <K extends K0, V extends V0> m1<K, V> e();
  }
  
  public static abstract class e<K0>
  {
    public s1.d<K0, Object> a()
    {
      return b(2);
    }
    
    public s1.d<K0, Object> b(final int paramInt)
    {
      v.b(paramInt, "expectedValuesPerKey");
      return new a(paramInt);
    }
    
    abstract <K extends K0, V> Map<K, Collection<V>> c();
    
    class a
      extends s1.d<K0, Object>
    {
      a(int paramInt) {}
      
      public <K extends K0, V> m1<K, V> e()
      {
        return t1.b(s1.e.this.c(), new s1.c(paramInt));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\s1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
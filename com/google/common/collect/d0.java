package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.primitives.a;
import java.io.Serializable;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class d0<C extends Comparable>
  implements Comparable<d0<C>>, Serializable
{
  @NullableDecl
  final C c;
  
  d0(@NullableDecl C paramC)
  {
    this.c = paramC;
  }
  
  static <C extends Comparable> d0<C> a()
  {
    return b.s();
  }
  
  static <C extends Comparable> d0<C> b(C paramC)
  {
    return new c(paramC);
  }
  
  static <C extends Comparable> d0<C> d()
  {
    return d.s();
  }
  
  static <C extends Comparable> d0<C> f(C paramC)
  {
    return new e(paramC);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d0;
    bool2 = false;
    bool3 = bool2;
    if (bool1) {
      paramObject = (d0)paramObject;
    }
    try
    {
      int i = h((d0)paramObject);
      bool3 = bool2;
      if (i == 0) {
        bool3 = true;
      }
    }
    catch (ClassCastException paramObject)
    {
      for (;;)
      {
        bool3 = bool2;
      }
    }
    return bool3;
  }
  
  d0<C> g(i0<C> parami0)
  {
    return this;
  }
  
  public int h(d0<C> paramd0)
  {
    if (paramd0 == d()) {
      return 1;
    }
    if (paramd0 == a()) {
      return -1;
    }
    int i = Range.compareOrThrow(this.c, paramd0.c);
    if (i != 0) {
      return i;
    }
    return a.a(this instanceof c, paramd0 instanceof c);
  }
  
  public abstract int hashCode();
  
  abstract void i(StringBuilder paramStringBuilder);
  
  abstract void j(StringBuilder paramStringBuilder);
  
  C k()
  {
    return this.c;
  }
  
  abstract C l(i0<C> parami0);
  
  abstract boolean m(C paramC);
  
  abstract C n(i0<C> parami0);
  
  abstract BoundType o();
  
  abstract BoundType p();
  
  abstract d0<C> q(BoundType paramBoundType, i0<C> parami0);
  
  abstract d0<C> r(BoundType paramBoundType, i0<C> parami0);
  
  private static final class b
    extends d0<Comparable<?>>
  {
    private static final b d = new b();
    
    private b()
    {
      super();
    }
    
    public int h(d0<Comparable<?>> paramd0)
    {
      int i;
      if (paramd0 == this) {
        i = 0;
      } else {
        i = 1;
      }
      return i;
    }
    
    public int hashCode()
    {
      return System.identityHashCode(this);
    }
    
    void i(StringBuilder paramStringBuilder)
    {
      throw new AssertionError();
    }
    
    void j(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("+∞)");
    }
    
    Comparable<?> k()
    {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    Comparable<?> l(i0<Comparable<?>> parami0)
    {
      return parami0.f();
    }
    
    boolean m(Comparable<?> paramComparable)
    {
      return false;
    }
    
    Comparable<?> n(i0<Comparable<?>> parami0)
    {
      throw new AssertionError();
    }
    
    BoundType o()
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    BoundType p()
    {
      throw new IllegalStateException();
    }
    
    d0<Comparable<?>> q(BoundType paramBoundType, i0<Comparable<?>> parami0)
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    d0<Comparable<?>> r(BoundType paramBoundType, i0<Comparable<?>> parami0)
    {
      throw new IllegalStateException();
    }
    
    public String toString()
    {
      return "+∞";
    }
  }
  
  private static final class c<C extends Comparable>
    extends d0<C>
  {
    c(C paramC)
    {
      super();
    }
    
    d0<C> g(i0<C> parami0)
    {
      parami0 = n(parami0);
      if (parami0 != null) {
        parami0 = d0.f(parami0);
      } else {
        parami0 = d0.a();
      }
      return parami0;
    }
    
    public int hashCode()
    {
      return this.c.hashCode() ^ 0xFFFFFFFF;
    }
    
    void i(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append('(');
      paramStringBuilder.append(this.c);
    }
    
    void j(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.c);
      paramStringBuilder.append(']');
    }
    
    C l(i0<C> parami0)
    {
      return this.c;
    }
    
    boolean m(C paramC)
    {
      boolean bool;
      if (Range.compareOrThrow(this.c, paramC) < 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    C n(i0<C> parami0)
    {
      return parami0.h(this.c);
    }
    
    BoundType o()
    {
      return BoundType.OPEN;
    }
    
    BoundType p()
    {
      return BoundType.CLOSED;
    }
    
    d0<C> q(BoundType paramBoundType, i0<C> parami0)
    {
      int i = d0.a.a[paramBoundType.ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return this;
        }
        throw new AssertionError();
      }
      paramBoundType = parami0.h(this.c);
      if (paramBoundType == null) {
        paramBoundType = d0.d();
      } else {
        paramBoundType = d0.f(paramBoundType);
      }
      return paramBoundType;
    }
    
    d0<C> r(BoundType paramBoundType, i0<C> parami0)
    {
      int i = d0.a.a[paramBoundType.ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          paramBoundType = parami0.h(this.c);
          if (paramBoundType == null) {
            paramBoundType = d0.a();
          } else {
            paramBoundType = d0.f(paramBoundType);
          }
          return paramBoundType;
        }
        throw new AssertionError();
      }
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      localStringBuilder.append(this.c);
      localStringBuilder.append("\\");
      return localStringBuilder.toString();
    }
  }
  
  private static final class d
    extends d0<Comparable<?>>
  {
    private static final d d = new d();
    
    private d()
    {
      super();
    }
    
    d0<Comparable<?>> g(i0<Comparable<?>> parami0)
    {
      try
      {
        parami0 = d0.f(parami0.g());
        return parami0;
      }
      catch (NoSuchElementException parami0) {}
      return this;
    }
    
    public int h(d0<Comparable<?>> paramd0)
    {
      int i;
      if (paramd0 == this) {
        i = 0;
      } else {
        i = -1;
      }
      return i;
    }
    
    public int hashCode()
    {
      return System.identityHashCode(this);
    }
    
    void i(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("(-∞");
    }
    
    void j(StringBuilder paramStringBuilder)
    {
      throw new AssertionError();
    }
    
    Comparable<?> k()
    {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    Comparable<?> l(i0<Comparable<?>> parami0)
    {
      throw new AssertionError();
    }
    
    boolean m(Comparable<?> paramComparable)
    {
      return true;
    }
    
    Comparable<?> n(i0<Comparable<?>> parami0)
    {
      return parami0.g();
    }
    
    BoundType o()
    {
      throw new IllegalStateException();
    }
    
    BoundType p()
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    d0<Comparable<?>> q(BoundType paramBoundType, i0<Comparable<?>> parami0)
    {
      throw new IllegalStateException();
    }
    
    d0<Comparable<?>> r(BoundType paramBoundType, i0<Comparable<?>> parami0)
    {
      throw new AssertionError("this statement should be unreachable");
    }
    
    public String toString()
    {
      return "-∞";
    }
  }
  
  private static final class e<C extends Comparable>
    extends d0<C>
  {
    e(C paramC)
    {
      super();
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
    
    void i(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append('[');
      paramStringBuilder.append(this.c);
    }
    
    void j(StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.c);
      paramStringBuilder.append(')');
    }
    
    C l(i0<C> parami0)
    {
      return parami0.j(this.c);
    }
    
    boolean m(C paramC)
    {
      boolean bool;
      if (Range.compareOrThrow(this.c, paramC) <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    C n(i0<C> parami0)
    {
      return this.c;
    }
    
    BoundType o()
    {
      return BoundType.CLOSED;
    }
    
    BoundType p()
    {
      return BoundType.OPEN;
    }
    
    d0<C> q(BoundType paramBoundType, i0<C> parami0)
    {
      int i = d0.a.a[paramBoundType.ordinal()];
      if (i != 1)
      {
        if (i == 2)
        {
          paramBoundType = parami0.j(this.c);
          if (paramBoundType == null) {
            paramBoundType = d0.d();
          } else {
            paramBoundType = new d0.c(paramBoundType);
          }
          return paramBoundType;
        }
        throw new AssertionError();
      }
      return this;
    }
    
    d0<C> r(BoundType paramBoundType, i0<C> parami0)
    {
      int i = d0.a.a[paramBoundType.ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          return this;
        }
        throw new AssertionError();
      }
      paramBoundType = parami0.j(this.c);
      if (paramBoundType == null) {
        paramBoundType = d0.a();
      } else {
        paramBoundType = new d0.c(paramBoundType);
      }
      return paramBoundType;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\");
      localStringBuilder.append(this.c);
      localStringBuilder.append("/");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
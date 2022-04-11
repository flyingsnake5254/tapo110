package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class w0<T>
  implements Serializable
{
  private final Comparator<? super T> c;
  private final boolean d;
  @NullableDecl
  private final T f;
  private final BoundType q;
  private final boolean x;
  @NullableDecl
  private final T y;
  private final BoundType z;
  
  private w0(Comparator<? super T> paramComparator, boolean paramBoolean1, @NullableDecl T paramT1, BoundType paramBoundType1, boolean paramBoolean2, @NullableDecl T paramT2, BoundType paramBoundType2)
  {
    this.c = ((Comparator)n.o(paramComparator));
    this.d = paramBoolean1;
    this.x = paramBoolean2;
    this.f = paramT1;
    this.q = ((BoundType)n.o(paramBoundType1));
    this.y = paramT2;
    this.z = ((BoundType)n.o(paramBoundType2));
    if (paramBoolean1) {
      paramComparator.compare(paramT1, paramT1);
    }
    if (paramBoolean2) {
      paramComparator.compare(paramT2, paramT2);
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      int i = paramComparator.compare(paramT1, paramT2);
      int j = 1;
      if (i <= 0) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      n.k(paramBoolean1, "lowerEndpoint (%s) > upperEndpoint (%s)", paramT1, paramT2);
      if (i == 0)
      {
        paramComparator = BoundType.OPEN;
        if (paramBoundType1 != paramComparator) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramBoundType2 == paramComparator) {
          j = 0;
        }
        n.d(i | j);
      }
    }
  }
  
  static <T> w0<T> a(Comparator<? super T> paramComparator)
  {
    BoundType localBoundType = BoundType.OPEN;
    return new w0(paramComparator, false, null, localBoundType, false, null, localBoundType);
  }
  
  static <T> w0<T> f(Comparator<? super T> paramComparator, @NullableDecl T paramT, BoundType paramBoundType)
  {
    return new w0(paramComparator, true, paramT, paramBoundType, false, null, BoundType.OPEN);
  }
  
  static <T> w0<T> p(Comparator<? super T> paramComparator, @NullableDecl T paramT, BoundType paramBoundType)
  {
    return new w0(paramComparator, false, null, BoundType.OPEN, true, paramT, paramBoundType);
  }
  
  Comparator<? super T> b()
  {
    return this.c;
  }
  
  boolean d(@NullableDecl T paramT)
  {
    boolean bool;
    if ((!o(paramT)) && (!n(paramT))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    boolean bool1 = paramObject instanceof w0;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (w0)paramObject;
      bool3 = bool2;
      if (this.c.equals(((w0)paramObject).c))
      {
        bool3 = bool2;
        if (this.d == ((w0)paramObject).d)
        {
          bool3 = bool2;
          if (this.x == ((w0)paramObject).x)
          {
            bool3 = bool2;
            if (g().equals(((w0)paramObject).g()))
            {
              bool3 = bool2;
              if (i().equals(((w0)paramObject).i()))
              {
                bool3 = bool2;
                if (k.a(h(), ((w0)paramObject).h()))
                {
                  bool3 = bool2;
                  if (k.a(j(), ((w0)paramObject).j())) {
                    bool3 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool3;
  }
  
  BoundType g()
  {
    return this.q;
  }
  
  T h()
  {
    return (T)this.f;
  }
  
  public int hashCode()
  {
    return k.b(new Object[] { this.c, h(), g(), j(), i() });
  }
  
  BoundType i()
  {
    return this.z;
  }
  
  T j()
  {
    return (T)this.y;
  }
  
  boolean k()
  {
    return this.d;
  }
  
  boolean l()
  {
    return this.x;
  }
  
  w0<T> m(w0<T> paramw0)
  {
    n.o(paramw0);
    n.d(this.c.equals(paramw0.c));
    boolean bool1 = this.d;
    Object localObject1 = h();
    Object localObject2 = g();
    boolean bool2;
    Object localObject3;
    Object localObject4;
    int i;
    if (!k())
    {
      bool2 = paramw0.d;
      localObject3 = paramw0.h();
      localObject4 = paramw0.g();
    }
    else
    {
      bool2 = bool1;
      localObject3 = localObject1;
      localObject4 = localObject2;
      if (paramw0.k())
      {
        i = this.c.compare(h(), paramw0.h());
        if (i >= 0)
        {
          bool2 = bool1;
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (i == 0)
          {
            bool2 = bool1;
            localObject3 = localObject1;
            localObject4 = localObject2;
            if (paramw0.g() != BoundType.OPEN) {}
          }
        }
        else
        {
          localObject3 = paramw0.h();
          localObject4 = paramw0.g();
          bool2 = bool1;
        }
      }
    }
    boolean bool3 = this.x;
    Object localObject5 = j();
    BoundType localBoundType = i();
    if (!l())
    {
      bool1 = paramw0.x;
      localObject2 = paramw0.j();
      localObject1 = paramw0.i();
    }
    else
    {
      bool1 = bool3;
      localObject2 = localObject5;
      localObject1 = localBoundType;
      if (paramw0.l())
      {
        i = this.c.compare(j(), paramw0.j());
        if (i <= 0)
        {
          bool1 = bool3;
          localObject2 = localObject5;
          localObject1 = localBoundType;
          if (i == 0)
          {
            bool1 = bool3;
            localObject2 = localObject5;
            localObject1 = localBoundType;
            if (paramw0.i() != BoundType.OPEN) {}
          }
        }
        else
        {
          localObject2 = paramw0.j();
          localObject1 = paramw0.i();
          bool1 = bool3;
        }
      }
    }
    if ((bool2) && (bool1))
    {
      i = this.c.compare(localObject3, localObject2);
      if (i <= 0)
      {
        if (i == 0)
        {
          paramw0 = BoundType.OPEN;
          if ((localObject4 != paramw0) || (localObject1 != paramw0)) {}
        }
      }
      else
      {
        localObject4 = BoundType.OPEN;
        paramw0 = BoundType.CLOSED;
        localObject3 = localObject2;
        break label357;
      }
    }
    paramw0 = (w0<T>)localObject1;
    label357:
    return new w0(this.c, bool2, localObject3, (BoundType)localObject4, bool1, localObject2, paramw0);
  }
  
  boolean n(@NullableDecl T paramT)
  {
    boolean bool = l();
    int i = 0;
    if (!bool) {
      return false;
    }
    Object localObject = j();
    int j = this.c.compare(paramT, localObject);
    int k;
    if (j > 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (j == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (i() == BoundType.OPEN) {
      i = 1;
    }
    return j & i | k;
  }
  
  boolean o(@NullableDecl T paramT)
  {
    boolean bool = k();
    int i = 0;
    if (!bool) {
      return false;
    }
    Object localObject = h();
    int j = this.c.compare(paramT, localObject);
    int k;
    if (j < 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (j == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (g() == BoundType.OPEN) {
      i = 1;
    }
    return j & i | k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(":");
    Object localObject = this.q;
    BoundType localBoundType = BoundType.CLOSED;
    char c1;
    char c2;
    if (localObject == localBoundType)
    {
      c1 = '[';
      c2 = c1;
    }
    else
    {
      c1 = '(';
      c2 = c1;
    }
    localStringBuilder.append(c2);
    if (this.d) {
      localObject = this.f;
    } else {
      localObject = "-∞";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(',');
    if (this.x) {
      localObject = this.y;
    } else {
      localObject = "∞";
    }
    localStringBuilder.append(localObject);
    if (this.z == localBoundType)
    {
      c1 = ']';
      c2 = c1;
    }
    else
    {
      c1 = ')';
      c2 = c1;
    }
    localStringBuilder.append(c2);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\w0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
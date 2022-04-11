package com.google.common.collect;

import com.google.common.primitives.a;
import com.google.common.primitives.d;
import com.google.common.primitives.e;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class c0
{
  private static final c0 a = new a();
  private static final c0 b = new b(-1);
  private static final c0 c = new b(1);
  
  public static c0 k()
  {
    return a;
  }
  
  public abstract c0 d(int paramInt1, int paramInt2);
  
  public abstract c0 e(long paramLong1, long paramLong2);
  
  public abstract c0 f(Comparable<?> paramComparable1, Comparable<?> paramComparable2);
  
  public abstract <T> c0 g(@NullableDecl T paramT1, @NullableDecl T paramT2, Comparator<T> paramComparator);
  
  public abstract c0 h(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract c0 i(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract int j();
  
  static final class a
    extends c0
  {
    a()
    {
      super();
    }
    
    public c0 d(int paramInt1, int paramInt2)
    {
      return l(d.d(paramInt1, paramInt2));
    }
    
    public c0 e(long paramLong1, long paramLong2)
    {
      return l(e.c(paramLong1, paramLong2));
    }
    
    public c0 f(Comparable paramComparable1, Comparable paramComparable2)
    {
      return l(paramComparable1.compareTo(paramComparable2));
    }
    
    public <T> c0 g(@NullableDecl T paramT1, @NullableDecl T paramT2, Comparator<T> paramComparator)
    {
      return l(paramComparator.compare(paramT1, paramT2));
    }
    
    public c0 h(boolean paramBoolean1, boolean paramBoolean2)
    {
      return l(a.a(paramBoolean1, paramBoolean2));
    }
    
    public c0 i(boolean paramBoolean1, boolean paramBoolean2)
    {
      return l(a.a(paramBoolean2, paramBoolean1));
    }
    
    public int j()
    {
      return 0;
    }
    
    c0 l(int paramInt)
    {
      c0 localc0;
      if (paramInt < 0) {
        localc0 = c0.a();
      } else if (paramInt > 0) {
        localc0 = c0.b();
      } else {
        localc0 = c0.c();
      }
      return localc0;
    }
  }
  
  private static final class b
    extends c0
  {
    final int d;
    
    b(int paramInt)
    {
      super();
      this.d = paramInt;
    }
    
    public c0 d(int paramInt1, int paramInt2)
    {
      return this;
    }
    
    public c0 e(long paramLong1, long paramLong2)
    {
      return this;
    }
    
    public c0 f(@NullableDecl Comparable paramComparable1, @NullableDecl Comparable paramComparable2)
    {
      return this;
    }
    
    public <T> c0 g(@NullableDecl T paramT1, @NullableDecl T paramT2, @NullableDecl Comparator<T> paramComparator)
    {
      return this;
    }
    
    public c0 h(boolean paramBoolean1, boolean paramBoolean2)
    {
      return this;
    }
    
    public c0 i(boolean paramBoolean1, boolean paramBoolean2)
    {
      return this;
    }
    
    public int j()
    {
      return this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\c0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class p
{
  public static <T> o<T> a()
  {
    return f.c.a();
  }
  
  public static <A, B> o<A> b(o<B> paramo, h<A, ? extends B> paramh)
  {
    return new b(paramo, paramh, null);
  }
  
  public static <T> o<T> c(@NullableDecl T paramT)
  {
    if (paramT == null) {
      paramT = e();
    } else {
      paramT = new d(paramT, null);
    }
    return paramT;
  }
  
  public static <T> o<T> d(Collection<? extends T> paramCollection)
  {
    return new c(paramCollection, null);
  }
  
  public static <T> o<T> e()
  {
    return f.f.a();
  }
  
  public static <T> o<T> f(o<T> paramo)
  {
    return new e(paramo);
  }
  
  private static class b<A, B>
    implements o<A>, Serializable
  {
    final o<B> c;
    final h<A, ? extends B> d;
    
    private b(o<B> paramo, h<A, ? extends B> paramh)
    {
      this.c = ((o)n.o(paramo));
      this.d = ((h)n.o(paramh));
    }
    
    public boolean apply(@NullableDecl A paramA)
    {
      return this.c.apply(this.d.apply(paramA));
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      boolean bool1 = paramObject instanceof b;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (b)paramObject;
        bool3 = bool2;
        if (this.d.equals(((b)paramObject).d))
        {
          bool3 = bool2;
          if (this.c.equals(((b)paramObject).c)) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      return this.d.hashCode() ^ this.c.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  private static class c<T>
    implements o<T>, Serializable
  {
    private final Collection<?> c;
    
    private c(Collection<?> paramCollection)
    {
      this.c = ((Collection)n.o(paramCollection));
    }
    
    public boolean apply(@NullableDecl T paramT)
    {
      try
      {
        boolean bool = this.c.contains(paramT);
        return bool;
      }
      catch (NullPointerException|ClassCastException paramT) {}
      return false;
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        return this.c.equals(((c)paramObject).c);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Predicates.in(");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  private static class d<T>
    implements o<T>, Serializable
  {
    private final T c;
    
    private d(T paramT)
    {
      this.c = paramT;
    }
    
    public boolean apply(T paramT)
    {
      return this.c.equals(paramT);
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        return this.c.equals(((d)paramObject).c);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.c.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Predicates.equalTo(");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  private static class e<T>
    implements o<T>, Serializable
  {
    final o<T> c;
    
    e(o<T> paramo)
    {
      this.c = ((o)n.o(paramo));
    }
    
    public boolean apply(@NullableDecl T paramT)
    {
      return this.c.apply(paramT) ^ true;
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        return this.c.equals(((e)paramObject).c);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.c.hashCode() ^ 0xFFFFFFFF;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Predicates.not(");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  static abstract enum f
    implements o<Object>
  {
    static
    {
      a locala = new a("ALWAYS_TRUE", 0);
      c = locala;
      b localb = new b("ALWAYS_FALSE", 1);
      d = localb;
      c localc = new c("IS_NULL", 2);
      f = localc;
      d locald = new d("NOT_NULL", 3);
      q = locald;
      x = new f[] { locala, localb, localc, locald };
    }
    
    <T> o<T> a()
    {
      return this;
    }
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      public boolean apply(@NullableDecl Object paramObject)
      {
        return true;
      }
      
      public String toString()
      {
        return "Predicates.alwaysTrue()";
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      public boolean apply(@NullableDecl Object paramObject)
      {
        return false;
      }
      
      public String toString()
      {
        return "Predicates.alwaysFalse()";
      }
    }
    
    static enum c
    {
      c()
      {
        super(paramInt, null);
      }
      
      public boolean apply(@NullableDecl Object paramObject)
      {
        boolean bool;
        if (paramObject == null) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public String toString()
      {
        return "Predicates.isNull()";
      }
    }
    
    static enum d
    {
      d()
      {
        super(paramInt, null);
      }
      
      public boolean apply(@NullableDecl Object paramObject)
      {
        boolean bool;
        if (paramObject != null) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public String toString()
      {
        return "Predicates.notNull()";
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
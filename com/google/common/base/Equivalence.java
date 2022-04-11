package com.google.common.base;

import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Equivalence<T>
{
  public static Equivalence<Object> d()
  {
    return b.c;
  }
  
  public static Equivalence<Object> h()
  {
    return c.c;
  }
  
  @ForOverride
  protected abstract boolean a(T paramT1, T paramT2);
  
  @ForOverride
  protected abstract int b(T paramT);
  
  public final boolean f(@NullableDecl T paramT1, @NullableDecl T paramT2)
  {
    if (paramT1 == paramT2) {
      return true;
    }
    if ((paramT1 != null) && (paramT2 != null)) {
      return a(paramT1, paramT2);
    }
    return false;
  }
  
  public final int g(@NullableDecl T paramT)
  {
    if (paramT == null) {
      return 0;
    }
    return b(paramT);
  }
  
  public static final class Wrapper<T>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Equivalence<? super T> equivalence;
    @NullableDecl
    private final T reference;
    
    private Wrapper(Equivalence<? super T> paramEquivalence, @NullableDecl T paramT)
    {
      this.equivalence = ((Equivalence)n.o(paramEquivalence));
      this.reference = paramT;
    }
    
    public boolean equals(@NullableDecl Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if ((paramObject instanceof Wrapper))
      {
        paramObject = (Wrapper)paramObject;
        if (this.equivalence.equals(((Wrapper)paramObject).equivalence)) {
          return this.equivalence.f(this.reference, ((Wrapper)paramObject).reference);
        }
      }
      return false;
    }
    
    @NullableDecl
    public T get()
    {
      return (T)this.reference;
    }
    
    public int hashCode()
    {
      return this.equivalence.g(this.reference);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.equivalence);
      localStringBuilder.append(".wrap(");
      localStringBuilder.append(this.reference);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends Equivalence<Object>
    implements Serializable
  {
    static final b c = new b();
    
    protected boolean a(Object paramObject1, Object paramObject2)
    {
      return paramObject1.equals(paramObject2);
    }
    
    protected int b(Object paramObject)
    {
      return paramObject.hashCode();
    }
  }
  
  static final class c
    extends Equivalence<Object>
    implements Serializable
  {
    static final c c = new c();
    
    protected boolean a(Object paramObject1, Object paramObject2)
    {
      return false;
    }
    
    protected int b(Object paramObject)
    {
      return System.identityHashCode(paramObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\Equivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
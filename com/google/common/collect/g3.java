package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.k;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class g3
{
  private static final h<? extends Map<?, ?>, ? extends Map<?, ?>> a = new a();
  
  static boolean a(f3<?, ?, ?> paramf3, @NullableDecl Object paramObject)
  {
    if (paramObject == paramf3) {
      return true;
    }
    if ((paramObject instanceof f3))
    {
      paramObject = (f3)paramObject;
      return paramf3.cellSet().equals(((f3)paramObject).cellSet());
    }
    return false;
  }
  
  public static <R, C, V> f3.a<R, C, V> b(@NullableDecl R paramR, @NullableDecl C paramC, @NullableDecl V paramV)
  {
    return new c(paramR, paramC, paramV);
  }
  
  static final class a
    implements h<Map<Object, Object>, Map<Object, Object>>
  {
    public Map<Object, Object> a(Map<Object, Object> paramMap)
    {
      return Collections.unmodifiableMap(paramMap);
    }
  }
  
  static abstract class b<R, C, V>
    implements f3.a<R, C, V>
  {
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {
        return true;
      }
      if ((paramObject instanceof f3.a))
      {
        paramObject = (f3.a)paramObject;
        if ((!k.a(a(), ((f3.a)paramObject).a())) || (!k.a(b(), ((f3.a)paramObject).b())) || (!k.a(getValue(), ((f3.a)paramObject).getValue()))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return k.b(new Object[] { a(), b(), getValue() });
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(a());
      localStringBuilder.append(",");
      localStringBuilder.append(b());
      localStringBuilder.append(")=");
      localStringBuilder.append(getValue());
      return localStringBuilder.toString();
    }
  }
  
  static final class c<R, C, V>
    extends g3.b<R, C, V>
    implements Serializable
  {
    @NullableDecl
    private final R c;
    @NullableDecl
    private final C d;
    @NullableDecl
    private final V f;
    
    c(@NullableDecl R paramR, @NullableDecl C paramC, @NullableDecl V paramV)
    {
      this.c = paramR;
      this.d = paramC;
      this.f = paramV;
    }
    
    public R a()
    {
      return (R)this.c;
    }
    
    public C b()
    {
      return (C)this.d;
    }
    
    public V getValue()
    {
      return (V)this.f;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\g3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
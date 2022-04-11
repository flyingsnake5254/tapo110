package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class f<A, B>
  implements h<A, B>
{
  private final boolean c;
  
  protected f()
  {
    this(true);
  }
  
  f(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  @NullableDecl
  @CanIgnoreReturnValue
  public final B a(@NullableDecl A paramA)
  {
    return (B)b(paramA);
  }
  
  @Deprecated
  @NullableDecl
  @CanIgnoreReturnValue
  public final B apply(@NullableDecl A paramA)
  {
    return (B)a(paramA);
  }
  
  @NullableDecl
  B b(@NullableDecl A paramA)
  {
    if (this.c)
    {
      if (paramA == null) {
        paramA = null;
      } else {
        paramA = n.o(d(paramA));
      }
      return paramA;
    }
    return (B)d(paramA);
  }
  
  @ForOverride
  protected abstract B d(A paramA);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
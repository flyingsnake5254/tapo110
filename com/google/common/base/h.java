package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract interface h<F, T>
{
  @NullableDecl
  @CanIgnoreReturnValue
  public abstract T apply(@NullableDecl F paramF);
  
  public abstract boolean equals(@NullableDecl Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
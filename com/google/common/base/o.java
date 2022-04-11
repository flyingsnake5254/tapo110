package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract interface o<T>
{
  @CanIgnoreReturnValue
  public abstract boolean apply(@NullableDecl T paramT);
  
  public abstract boolean equals(@NullableDecl Object paramObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\base\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
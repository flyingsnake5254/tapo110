package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

@CanIgnoreReturnValue
abstract class b
  implements g
{
  public <T> g a(T paramT, Funnel<? super T> paramFunnel)
  {
    paramFunnel.funnel(paramT, this);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
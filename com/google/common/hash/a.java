package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;

@Immutable
abstract class a
  implements f
{
  public <T> e b(T paramT, Funnel<? super T> paramFunnel)
  {
    return a().a(paramT, paramFunnel).hash();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
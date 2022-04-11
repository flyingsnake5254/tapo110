package com.google.common.hash;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

@CanIgnoreReturnValue
public abstract interface g
  extends m
{
  public abstract <T> g a(T paramT, Funnel<? super T> paramFunnel);
  
  public abstract e hash();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
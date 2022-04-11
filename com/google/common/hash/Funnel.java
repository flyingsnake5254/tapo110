package com.google.common.hash;

import java.io.Serializable;

public abstract interface Funnel<T>
  extends Serializable
{
  public abstract void funnel(T paramT, m paramm);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\hash\Funnel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
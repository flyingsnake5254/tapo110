package com.google.android.gms.common.data;

public abstract interface Freezable<T>
{
  public abstract T freeze();
  
  public abstract boolean isDataValid();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\data\Freezable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
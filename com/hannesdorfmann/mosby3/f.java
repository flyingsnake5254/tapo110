package com.hannesdorfmann.mosby3;

import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;

public abstract interface f<V extends b, P extends d<V, ?>>
{
  @NonNull
  public abstract P D();
  
  @NonNull
  public abstract V getMvpView();
  
  public abstract void setRestoringViewState(boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.hannesdorfmann.mosby3;

import android.content.Context;
import android.os.Parcelable;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;

public abstract interface i<V extends b, P extends d<V, ?>>
  extends f<V, P>
{
  public abstract Context getContext();
  
  public abstract void n0(Parcelable paramParcelable);
  
  public abstract Parcelable r();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
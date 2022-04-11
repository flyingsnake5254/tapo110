package com.hannesdorfmann.mosby3;

import android.os.Parcelable;
import com.hannesdorfmann.mosby3.k.a;
import com.hannesdorfmann.mosby3.k.b;

public abstract interface h<V extends b, P extends a<V>>
{
  public abstract void onAttachedToWindow();
  
  public abstract void onDetachedFromWindow();
  
  public abstract void onRestoreInstanceState(Parcelable paramParcelable);
  
  public abstract Parcelable onSaveInstanceState();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
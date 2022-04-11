package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.NonNull;

abstract interface ViewGroupOverlayImpl
  extends ViewOverlayImpl
{
  public abstract void add(@NonNull View paramView);
  
  public abstract void remove(@NonNull View paramView);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ViewGroupOverlayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
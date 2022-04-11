package com.google.android.material.slider;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface BaseOnSliderTouchListener<S>
{
  public abstract void onStartTrackingTouch(@NonNull S paramS);
  
  public abstract void onStopTrackingTouch(@NonNull S paramS);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\slider\BaseOnSliderTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
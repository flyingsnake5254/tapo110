package com.google.android.material.slider;

import androidx.annotation.NonNull;

public abstract interface LabelFormatter
{
  public static final int LABEL_FLOATING = 0;
  public static final int LABEL_GONE = 2;
  public static final int LABEL_WITHIN_BOUNDS = 1;
  
  @NonNull
  public abstract String getFormattedValue(float paramFloat);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\slider\LabelFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface ViewOverlayImpl
{
  public abstract void add(@NonNull Drawable paramDrawable);
  
  public abstract void remove(@NonNull Drawable paramDrawable);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ViewOverlayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class TextAppearanceFontCallback
{
  public abstract void onFontRetrievalFailed(int paramInt);
  
  public abstract void onFontRetrieved(Typeface paramTypeface, boolean paramBoolean);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\resources\TextAppearanceFontCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
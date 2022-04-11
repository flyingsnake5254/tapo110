package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback
  extends TextAppearanceFontCallback
{
  private final ApplyFont applyFont;
  private boolean cancelled;
  private final Typeface fallbackFont;
  
  public CancelableFontCallback(ApplyFont paramApplyFont, Typeface paramTypeface)
  {
    this.fallbackFont = paramTypeface;
    this.applyFont = paramApplyFont;
  }
  
  private void updateIfNotCancelled(Typeface paramTypeface)
  {
    if (!this.cancelled) {
      this.applyFont.apply(paramTypeface);
    }
  }
  
  public void cancel()
  {
    this.cancelled = true;
  }
  
  public void onFontRetrievalFailed(int paramInt)
  {
    updateIfNotCancelled(this.fallbackFont);
  }
  
  public void onFontRetrieved(Typeface paramTypeface, boolean paramBoolean)
  {
    updateIfNotCancelled(paramTypeface);
  }
  
  public static abstract interface ApplyFont
  {
    public abstract void apply(Typeface paramTypeface);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\resources\CancelableFontCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
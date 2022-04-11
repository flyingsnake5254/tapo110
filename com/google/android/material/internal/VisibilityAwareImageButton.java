package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

@SuppressLint({"AppCompatCustomView"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class VisibilityAwareImageButton
  extends ImageButton
{
  private int userSetVisibility = getVisibility();
  
  public VisibilityAwareImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final int getUserSetVisibility()
  {
    return this.userSetVisibility;
  }
  
  public final void internalSetVisibility(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean) {
      this.userSetVisibility = paramInt;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    internalSetVisibility(paramInt, true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\VisibilityAwareImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
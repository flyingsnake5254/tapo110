package com.google.android.material.textfield;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate
{
  Context context;
  CheckableImageButton endIconView;
  TextInputLayout textInputLayout;
  
  EndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    this.textInputLayout = paramTextInputLayout;
    this.context = paramTextInputLayout.getContext();
    this.endIconView = paramTextInputLayout.getEndIconView();
  }
  
  abstract void initialize();
  
  boolean isBoxBackgroundModeSupported(int paramInt)
  {
    return true;
  }
  
  void onSuffixVisibilityChanged(boolean paramBoolean) {}
  
  boolean shouldTintIconOnError()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\EndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
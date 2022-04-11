package com.google.android.material.textfield;

import androidx.annotation.NonNull;

class NoEndIconDelegate
  extends EndIconDelegate
{
  NoEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  void initialize()
  {
    this.textInputLayout.setEndIconOnClickListener(null);
    this.textInputLayout.setEndIconDrawable(null);
    this.textInputLayout.setEndIconContentDescription(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\NoEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
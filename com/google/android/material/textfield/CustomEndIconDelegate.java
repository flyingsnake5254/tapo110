package com.google.android.material.textfield;

import androidx.annotation.NonNull;

class CustomEndIconDelegate
  extends EndIconDelegate
{
  CustomEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  void initialize()
  {
    this.textInputLayout.setEndIconOnClickListener(null);
    this.textInputLayout.setEndIconOnLongClickListener(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\textfield\CustomEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
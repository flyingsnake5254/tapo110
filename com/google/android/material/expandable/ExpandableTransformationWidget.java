package com.google.android.material.expandable;

import androidx.annotation.IdRes;

public abstract interface ExpandableTransformationWidget
  extends ExpandableWidget
{
  @IdRes
  public abstract int getExpandedComponentIdHint();
  
  public abstract void setExpandedComponentIdHint(@IdRes int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\expandable\ExpandableTransformationWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
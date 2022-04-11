package com.google.android.material.animation;

import android.view.View;

public abstract interface TransformationCallback<T extends View>
{
  public abstract void onScaleChanged(T paramT);
  
  public abstract void onTranslationChanged(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\animation\TransformationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
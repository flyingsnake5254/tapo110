package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface VisibilityAnimatorProvider
{
  @Nullable
  public abstract Animator createAppear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView);
  
  @Nullable
  public abstract Animator createDisappear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\VisibilityAnimatorProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
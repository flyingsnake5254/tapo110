package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import java.util.List;

abstract interface MotionStrategy
{
  public abstract void addAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener);
  
  public abstract AnimatorSet createAnimator();
  
  public abstract MotionSpec getCurrentMotionSpec();
  
  @AnimatorRes
  public abstract int getDefaultMotionSpecResource();
  
  public abstract List<Animator.AnimatorListener> getListeners();
  
  @Nullable
  public abstract MotionSpec getMotionSpec();
  
  public abstract void onAnimationCancel();
  
  public abstract void onAnimationEnd();
  
  public abstract void onAnimationStart(Animator paramAnimator);
  
  public abstract void onChange(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback);
  
  public abstract void performNow();
  
  public abstract void removeAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener);
  
  public abstract void setMotionSpec(@Nullable MotionSpec paramMotionSpec);
  
  public abstract boolean shouldCancel();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\floatingactionbutton\MotionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
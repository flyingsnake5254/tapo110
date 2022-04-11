package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy
  implements MotionStrategy
{
  private final Context context;
  @Nullable
  private MotionSpec defaultMotionSpec;
  @NonNull
  private final ExtendedFloatingActionButton fab;
  private final ArrayList<Animator.AnimatorListener> listeners = new ArrayList();
  @Nullable
  private MotionSpec motionSpec;
  private final AnimatorTracker tracker;
  
  BaseMotionStrategy(@NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker)
  {
    this.fab = paramExtendedFloatingActionButton;
    this.context = paramExtendedFloatingActionButton.getContext();
    this.tracker = paramAnimatorTracker;
  }
  
  public final void addAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    this.listeners.add(paramAnimatorListener);
  }
  
  public AnimatorSet createAnimator()
  {
    return createAnimator(getCurrentMotionSpec());
  }
  
  @NonNull
  AnimatorSet createAnimator(@NonNull MotionSpec paramMotionSpec)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMotionSpec.hasPropertyValues("opacity")) {
      localArrayList.add(paramMotionSpec.getAnimator("opacity", this.fab, View.ALPHA));
    }
    if (paramMotionSpec.hasPropertyValues("scale"))
    {
      localArrayList.add(paramMotionSpec.getAnimator("scale", this.fab, View.SCALE_Y));
      localArrayList.add(paramMotionSpec.getAnimator("scale", this.fab, View.SCALE_X));
    }
    if (paramMotionSpec.hasPropertyValues("width")) {
      localArrayList.add(paramMotionSpec.getAnimator("width", this.fab, ExtendedFloatingActionButton.WIDTH));
    }
    if (paramMotionSpec.hasPropertyValues("height")) {
      localArrayList.add(paramMotionSpec.getAnimator("height", this.fab, ExtendedFloatingActionButton.HEIGHT));
    }
    paramMotionSpec = new AnimatorSet();
    AnimatorSetCompat.playTogether(paramMotionSpec, localArrayList);
    return paramMotionSpec;
  }
  
  public final MotionSpec getCurrentMotionSpec()
  {
    MotionSpec localMotionSpec = this.motionSpec;
    if (localMotionSpec != null) {
      return localMotionSpec;
    }
    if (this.defaultMotionSpec == null) {
      this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
    }
    return (MotionSpec)Preconditions.checkNotNull(this.defaultMotionSpec);
  }
  
  @NonNull
  public final List<Animator.AnimatorListener> getListeners()
  {
    return this.listeners;
  }
  
  @Nullable
  public MotionSpec getMotionSpec()
  {
    return this.motionSpec;
  }
  
  @CallSuper
  public void onAnimationCancel()
  {
    this.tracker.clear();
  }
  
  @CallSuper
  public void onAnimationEnd()
  {
    this.tracker.clear();
  }
  
  @CallSuper
  public void onAnimationStart(Animator paramAnimator)
  {
    this.tracker.onNextAnimationStart(paramAnimator);
  }
  
  public final void removeAnimationListener(@NonNull Animator.AnimatorListener paramAnimatorListener)
  {
    this.listeners.remove(paramAnimatorListener);
  }
  
  public final void setMotionSpec(@Nullable MotionSpec paramMotionSpec)
  {
    this.motionSpec = paramMotionSpec;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\floatingactionbutton\BaseMotionStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
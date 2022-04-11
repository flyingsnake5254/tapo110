package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  @Nullable
  private AnimatorSet currentAnimation;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected abstract AnimatorSet onCreateExpandedStateChangeAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  @CallSuper
  protected boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AnimatorSet localAnimatorSet = this.currentAnimation;
    boolean bool;
    if (localAnimatorSet != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      localAnimatorSet.cancel();
    }
    paramView1 = onCreateExpandedStateChangeAnimation(paramView1, paramView2, paramBoolean1, bool);
    this.currentAnimation = paramView1;
    paramView1.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ExpandableTransformationBehavior.access$002(ExpandableTransformationBehavior.this, null);
      }
    });
    this.currentAnimation.start();
    if (!paramBoolean2) {
      this.currentAnimation.end();
    }
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transformation\ExpandableTransformationBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class FadeThroughProvider
  implements VisibilityAnimatorProvider
{
  static final float PROGRESS_THRESHOLD = 0.35F;
  
  private static Animator createFadeThroughAnimator(View paramView, final float paramFloat1, final float paramFloat2, @FloatRange(from=0.0D, to=1.0D) final float paramFloat3, @FloatRange(from=0.0D, to=1.0D) final float paramFloat4)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        this.val$view.setAlpha(TransitionUtils.lerp(paramFloat1, paramFloat2, paramFloat3, paramFloat4, f));
      }
    });
    return localValueAnimator;
  }
  
  @Nullable
  public Animator createAppear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    return createFadeThroughAnimator(paramView, 0.0F, 1.0F, 0.35F, 1.0F);
  }
  
  @Nullable
  public Animator createDisappear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    return createFadeThroughAnimator(paramView, 1.0F, 0.0F, 0.0F, 0.35F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\FadeThroughProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider>
  extends Visibility
{
  private final P primaryAnimatorProvider;
  @Nullable
  private VisibilityAnimatorProvider secondaryAnimatorProvider;
  
  protected MaterialVisibility(P paramP, @Nullable VisibilityAnimatorProvider paramVisibilityAnimatorProvider)
  {
    this.primaryAnimatorProvider = paramP;
    this.secondaryAnimatorProvider = paramVisibilityAnimatorProvider;
    setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
  }
  
  private Animator createAnimator(ViewGroup paramViewGroup, View paramView, boolean paramBoolean)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localObject = this.primaryAnimatorProvider.createAppear(paramViewGroup, paramView);
    } else {
      localObject = this.primaryAnimatorProvider.createDisappear(paramViewGroup, paramView);
    }
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    Object localObject = this.secondaryAnimatorProvider;
    if (localObject != null)
    {
      if (paramBoolean) {
        paramViewGroup = ((VisibilityAnimatorProvider)localObject).createAppear(paramViewGroup, paramView);
      } else {
        paramViewGroup = ((VisibilityAnimatorProvider)localObject).createDisappear(paramViewGroup, paramView);
      }
      if (paramViewGroup != null) {
        localArrayList.add(paramViewGroup);
      }
    }
    AnimatorSetCompat.playTogether(localAnimatorSet, localArrayList);
    return localAnimatorSet;
  }
  
  @NonNull
  public P getPrimaryAnimatorProvider()
  {
    return this.primaryAnimatorProvider;
  }
  
  @Nullable
  public VisibilityAnimatorProvider getSecondaryAnimatorProvider()
  {
    return this.secondaryAnimatorProvider;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return createAnimator(paramViewGroup, paramView, true);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return createAnimator(paramViewGroup, paramView, false);
  }
  
  public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider paramVisibilityAnimatorProvider)
  {
    this.secondaryAnimatorProvider = paramVisibilityAnimatorProvider;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\MaterialVisibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
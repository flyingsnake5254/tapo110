package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.dimen;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
public final class SlideDistanceProvider
  implements VisibilityAnimatorProvider
{
  private static final int DEFAULT_DISTANCE = -1;
  @Px
  private int slideDistance = -1;
  private int slideEdge;
  
  public SlideDistanceProvider(int paramInt)
  {
    this.slideEdge = paramInt;
  }
  
  private static Animator createTranslationAppearAnimator(View paramView1, View paramView2, int paramInt1, @Px int paramInt2)
  {
    if (paramInt1 != 3)
    {
      if (paramInt1 != 5)
      {
        if (paramInt1 != 48)
        {
          if (paramInt1 != 80)
          {
            float f;
            if (paramInt1 != 8388611)
            {
              if (paramInt1 == 8388613)
              {
                if (isRtl(paramView1)) {
                  f = -paramInt2;
                } else {
                  f = paramInt2;
                }
                return createTranslationXAnimator(paramView2, f, 0.0F);
              }
              paramView1 = new StringBuilder();
              paramView1.append("Invalid slide direction: ");
              paramView1.append(paramInt1);
              throw new IllegalArgumentException(paramView1.toString());
            }
            if (isRtl(paramView1)) {
              f = paramInt2;
            } else {
              f = -paramInt2;
            }
            return createTranslationXAnimator(paramView2, f, 0.0F);
          }
          return createTranslationYAnimator(paramView2, paramInt2, 0.0F);
        }
        return createTranslationYAnimator(paramView2, -paramInt2, 0.0F);
      }
      return createTranslationXAnimator(paramView2, -paramInt2, 0.0F);
    }
    return createTranslationXAnimator(paramView2, paramInt2, 0.0F);
  }
  
  private static Animator createTranslationDisappearAnimator(View paramView1, View paramView2, int paramInt1, @Px int paramInt2)
  {
    if (paramInt1 != 3)
    {
      if (paramInt1 != 5)
      {
        if (paramInt1 != 48)
        {
          if (paramInt1 != 80)
          {
            float f;
            if (paramInt1 != 8388611)
            {
              if (paramInt1 == 8388613)
              {
                if (isRtl(paramView1)) {
                  f = paramInt2;
                } else {
                  f = -paramInt2;
                }
                return createTranslationXAnimator(paramView2, 0.0F, f);
              }
              paramView1 = new StringBuilder();
              paramView1.append("Invalid slide direction: ");
              paramView1.append(paramInt1);
              throw new IllegalArgumentException(paramView1.toString());
            }
            if (isRtl(paramView1)) {
              f = -paramInt2;
            } else {
              f = paramInt2;
            }
            return createTranslationXAnimator(paramView2, 0.0F, f);
          }
          return createTranslationYAnimator(paramView2, 0.0F, -paramInt2);
        }
        return createTranslationYAnimator(paramView2, 0.0F, paramInt2);
      }
      return createTranslationXAnimator(paramView2, 0.0F, paramInt2);
    }
    return createTranslationXAnimator(paramView2, 0.0F, -paramInt2);
  }
  
  private static Animator createTranslationXAnimator(View paramView, float paramFloat1, float paramFloat2)
  {
    return ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[] { paramFloat1, paramFloat2 }) });
  }
  
  private static Animator createTranslationYAnimator(View paramView, float paramFloat1, float paramFloat2)
  {
    return ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[] { paramFloat1, paramFloat2 }) });
  }
  
  private int getSlideDistanceOrDefault(Context paramContext)
  {
    int i = this.slideDistance;
    if (i != -1) {
      return i;
    }
    return paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
  }
  
  private static boolean isRtl(View paramView)
  {
    int i = ViewCompat.getLayoutDirection(paramView);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  public Animator createAppear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    return createTranslationAppearAnimator(paramViewGroup, paramView, this.slideEdge, getSlideDistanceOrDefault(paramView.getContext()));
  }
  
  @Nullable
  public Animator createDisappear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    return createTranslationDisappearAnimator(paramViewGroup, paramView, this.slideEdge, getSlideDistanceOrDefault(paramView.getContext()));
  }
  
  @Px
  public int getSlideDistance()
  {
    return this.slideDistance;
  }
  
  public int getSlideEdge()
  {
    return this.slideEdge;
  }
  
  public void setSlideDistance(@Px int paramInt)
  {
    if (paramInt >= 0)
    {
      this.slideDistance = paramInt;
      return;
    }
    throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
  }
  
  public void setSlideEdge(int paramInt)
  {
    this.slideEdge = paramInt;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface GravityFlag {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\SlideDistanceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
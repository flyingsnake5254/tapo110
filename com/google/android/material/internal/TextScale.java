package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale
  extends Transition
{
  private static final String PROPNAME_SCALE = "android:textscale:scale";
  
  private void captureValues(@NonNull TransitionValues paramTransitionValues)
  {
    Object localObject = paramTransitionValues.view;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      paramTransitionValues.values.put("android:textscale:scale", Float.valueOf(((TextView)localObject).getScaleX()));
    }
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }
  
  public Animator createAnimator(@NonNull ViewGroup paramViewGroup, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    final TextView localTextView = null;
    paramViewGroup = localTextView;
    if (paramTransitionValues1 != null)
    {
      paramViewGroup = localTextView;
      if (paramTransitionValues2 != null)
      {
        paramViewGroup = localTextView;
        if ((paramTransitionValues1.view instanceof TextView))
        {
          paramViewGroup = paramTransitionValues2.view;
          if (!(paramViewGroup instanceof TextView))
          {
            paramViewGroup = localTextView;
          }
          else
          {
            localTextView = (TextView)paramViewGroup;
            paramViewGroup = paramTransitionValues1.values;
            paramTransitionValues2 = paramTransitionValues2.values;
            paramTransitionValues1 = paramViewGroup.get("android:textscale:scale");
            float f1 = 1.0F;
            float f2;
            if (paramTransitionValues1 != null) {
              f2 = ((Float)paramViewGroup.get("android:textscale:scale")).floatValue();
            } else {
              f2 = 1.0F;
            }
            if (paramTransitionValues2.get("android:textscale:scale") != null) {
              f1 = ((Float)paramTransitionValues2.get("android:textscale:scale")).floatValue();
            }
            if (f2 == f1) {
              return null;
            }
            paramViewGroup = ValueAnimator.ofFloat(new float[] { f2, f1 });
            paramViewGroup.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public void onAnimationUpdate(@NonNull ValueAnimator paramAnonymousValueAnimator)
              {
                float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
                localTextView.setScaleX(f);
                localTextView.setScaleY(f);
              }
            });
          }
        }
      }
    }
    return paramViewGroup;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\TextScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
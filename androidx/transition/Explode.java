package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import java.util.Map;

public class Explode
  extends Visibility
{
  private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
  private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
  private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
  private int[] mTempLoc = new int[2];
  
  public Explode()
  {
    setPropagation(new CircularPropagation());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setPropagation(new CircularPropagation());
  }
  
  private static float calculateDistance(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private static float calculateMaxDistance(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return calculateDistance(paramInt1, paramInt2);
  }
  
  private void calculateOut(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    paramView.getLocationOnScreen(this.mTempLoc);
    Object localObject = this.mTempLoc;
    int i = localObject[0];
    int j = localObject[1];
    localObject = getEpicenter();
    int k;
    int m;
    if (localObject == null)
    {
      k = paramView.getWidth() / 2 + i + Math.round(paramView.getTranslationX());
      m = paramView.getHeight() / 2 + j + Math.round(paramView.getTranslationY());
    }
    else
    {
      k = ((Rect)localObject).centerX();
      m = ((Rect)localObject).centerY();
    }
    int n = paramRect.centerX();
    int i1 = paramRect.centerY();
    float f1 = n - k;
    float f2 = i1 - m;
    float f3 = f1;
    float f4 = f2;
    if (f1 == 0.0F)
    {
      f3 = f1;
      f4 = f2;
      if (f2 == 0.0F)
      {
        f3 = (float)(Math.random() * 2.0D) - 1.0F;
        f4 = (float)(Math.random() * 2.0D) - 1.0F;
      }
    }
    f1 = calculateDistance(f3, f4);
    f3 /= f1;
    f1 = f4 / f1;
    f4 = calculateMaxDistance(paramView, k - i, m - j);
    paramArrayOfInt[0] = Math.round(f3 * f4);
    paramArrayOfInt[1] = Math.round(f4 * f1);
  }
  
  private void captureValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    localView.getLocationOnScreen(this.mTempLoc);
    int[] arrayOfInt = this.mTempLoc;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramTransitionValues.values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  public void captureEndValues(@NonNull TransitionValues paramTransitionValues)
  {
    super.captureEndValues(paramTransitionValues);
    captureValues(paramTransitionValues);
  }
  
  public void captureStartValues(@NonNull TransitionValues paramTransitionValues)
  {
    super.captureStartValues(paramTransitionValues);
    captureValues(paramTransitionValues);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues2 == null) {
      return null;
    }
    paramTransitionValues1 = (Rect)paramTransitionValues2.values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    calculateOut(paramViewGroup, paramTransitionValues1, this.mTempLoc);
    paramViewGroup = this.mTempLoc;
    float f3 = paramViewGroup[0];
    float f4 = paramViewGroup[1];
    return TranslationAnimationCreator.createAnimation(paramView, paramTransitionValues2, paramTransitionValues1.left, paramTransitionValues1.top, f1 + f3, f2 + f4, f1, f2, sDecelerate, this);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if (paramTransitionValues1 == null) {
      return null;
    }
    paramTransitionValues2 = (Rect)paramTransitionValues1.values.get("android:explode:screenBounds");
    int i = paramTransitionValues2.left;
    int j = paramTransitionValues2.top;
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramTransitionValues1.view.getTag(R.id.transition_position);
    float f3;
    float f4;
    if (arrayOfInt != null)
    {
      f3 = arrayOfInt[0] - paramTransitionValues2.left + f1;
      f4 = arrayOfInt[1] - paramTransitionValues2.top + f2;
      paramTransitionValues2.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    }
    else
    {
      f3 = f1;
      f4 = f2;
    }
    calculateOut(paramViewGroup, paramTransitionValues2, this.mTempLoc);
    paramViewGroup = this.mTempLoc;
    return TranslationAnimationCreator.createAnimation(paramView, paramTransitionValues1, i, j, f1, f2, f3 + paramViewGroup[0], f4 + paramViewGroup[1], sAccelerate, this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\Explode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
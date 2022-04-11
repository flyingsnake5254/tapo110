package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

public class SidePropagation
  extends VisibilityPropagation
{
  private float mPropagationSpeed = 3.0F;
  private int mSide = 80;
  
  private int distance(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = this.mSide;
    int j = 0;
    int k = 1;
    int m = 1;
    if (i == 8388611)
    {
      if (ViewCompat.getLayoutDirection(paramView) != 1) {
        m = 0;
      }
      if (m != 0)
      {
        m = 5;
        break label90;
      }
    }
    for (;;)
    {
      m = 3;
      break label90;
      m = i;
      if (i != 8388613) {
        break label90;
      }
      if (ViewCompat.getLayoutDirection(paramView) == 1) {
        m = k;
      } else {
        m = 0;
      }
      if (m == 0) {
        break;
      }
    }
    label90:
    if (m != 3)
    {
      if (m != 5)
      {
        if (m != 48)
        {
          if (m != 80) {
            paramInt1 = j;
          } else {
            paramInt1 = paramInt2 - paramInt6 + Math.abs(paramInt3 - paramInt1);
          }
        }
        else {
          paramInt1 = paramInt8 - paramInt2 + Math.abs(paramInt3 - paramInt1);
        }
      }
      else {
        paramInt1 = paramInt1 - paramInt5 + Math.abs(paramInt4 - paramInt2);
      }
    }
    else {
      paramInt1 = paramInt7 - paramInt1 + Math.abs(paramInt4 - paramInt2);
    }
    return paramInt1;
  }
  
  private int getMaxDistance(ViewGroup paramViewGroup)
  {
    int i = this.mSide;
    if ((i != 3) && (i != 5) && (i != 8388611) && (i != 8388613)) {
      return paramViewGroup.getHeight();
    }
    return paramViewGroup.getWidth();
  }
  
  public long getStartDelay(ViewGroup paramViewGroup, Transition paramTransition, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) && (paramTransitionValues2 == null)) {
      return 0L;
    }
    Rect localRect = paramTransition.getEpicenter();
    int i;
    if ((paramTransitionValues2 != null) && (getViewVisibility(paramTransitionValues1) != 0))
    {
      paramTransitionValues1 = paramTransitionValues2;
      i = 1;
    }
    else
    {
      i = -1;
    }
    int j = getViewX(paramTransitionValues1);
    int k = getViewY(paramTransitionValues1);
    paramTransitionValues1 = new int[2];
    paramViewGroup.getLocationOnScreen(paramTransitionValues1);
    int m = paramTransitionValues1[0] + Math.round(paramViewGroup.getTranslationX());
    int n = paramTransitionValues1[1] + Math.round(paramViewGroup.getTranslationY());
    int i1 = m + paramViewGroup.getWidth();
    int i2 = n + paramViewGroup.getHeight();
    int i3;
    int i4;
    if (localRect != null)
    {
      i3 = localRect.centerX();
      i4 = localRect.centerY();
    }
    else
    {
      i3 = (m + i1) / 2;
      i4 = (n + i2) / 2;
    }
    float f = distance(paramViewGroup, j, k, i3, i4, m, n, i1, i2) / getMaxDistance(paramViewGroup);
    long l1 = paramTransition.getDuration();
    long l2 = l1;
    if (l1 < 0L) {
      l2 = 300L;
    }
    return Math.round((float)(l2 * i) / this.mPropagationSpeed * f);
  }
  
  public void setPropagationSpeed(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      this.mPropagationSpeed = paramFloat;
      return;
    }
    throw new IllegalArgumentException("propagationSpeed may not be 0");
  }
  
  public void setSide(int paramInt)
  {
    this.mSide = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\SidePropagation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.material.transition;

import android.graphics.RectF;

class FitModeEvaluators
{
  private static final FitModeEvaluator HEIGHT = new FitModeEvaluator()
  {
    public void applyMask(RectF paramAnonymousRectF, float paramAnonymousFloat, FitModeResult paramAnonymousFitModeResult)
    {
      float f1 = Math.abs(paramAnonymousFitModeResult.currentEndWidth - paramAnonymousFitModeResult.currentStartWidth);
      float f2 = paramAnonymousRectF.left;
      paramAnonymousFloat = f1 / 2.0F * paramAnonymousFloat;
      paramAnonymousRectF.left = (f2 + paramAnonymousFloat);
      paramAnonymousRectF.right -= paramAnonymousFloat;
    }
    
    public FitModeResult evaluate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4, float paramAnonymousFloat5, float paramAnonymousFloat6, float paramAnonymousFloat7)
    {
      paramAnonymousFloat1 = TransitionUtils.lerp(paramAnonymousFloat5, paramAnonymousFloat7, paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat1);
      paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousFloat5;
      paramAnonymousFloat3 = paramAnonymousFloat1 / paramAnonymousFloat7;
      return new FitModeResult(paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat4 * paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousFloat6 * paramAnonymousFloat3, paramAnonymousFloat1);
    }
    
    public boolean shouldMaskStartBounds(FitModeResult paramAnonymousFitModeResult)
    {
      boolean bool;
      if (paramAnonymousFitModeResult.currentStartWidth > paramAnonymousFitModeResult.currentEndWidth) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  };
  private static final FitModeEvaluator WIDTH = new FitModeEvaluator()
  {
    public void applyMask(RectF paramAnonymousRectF, float paramAnonymousFloat, FitModeResult paramAnonymousFitModeResult)
    {
      float f = Math.abs(paramAnonymousFitModeResult.currentEndHeight - paramAnonymousFitModeResult.currentStartHeight);
      paramAnonymousRectF.bottom -= f * paramAnonymousFloat;
    }
    
    public FitModeResult evaluate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4, float paramAnonymousFloat5, float paramAnonymousFloat6, float paramAnonymousFloat7)
    {
      paramAnonymousFloat1 = TransitionUtils.lerp(paramAnonymousFloat4, paramAnonymousFloat6, paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat1);
      paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousFloat4;
      paramAnonymousFloat3 = paramAnonymousFloat1 / paramAnonymousFloat6;
      return new FitModeResult(paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat1, paramAnonymousFloat5 * paramAnonymousFloat2, paramAnonymousFloat1, paramAnonymousFloat7 * paramAnonymousFloat3);
    }
    
    public boolean shouldMaskStartBounds(FitModeResult paramAnonymousFitModeResult)
    {
      boolean bool;
      if (paramAnonymousFitModeResult.currentStartHeight > paramAnonymousFitModeResult.currentEndHeight) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  };
  
  static FitModeEvaluator get(int paramInt, boolean paramBoolean, RectF paramRectF1, RectF paramRectF2)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return HEIGHT;
        }
        paramRectF1 = new StringBuilder();
        paramRectF1.append("Invalid fit mode: ");
        paramRectF1.append(paramInt);
        throw new IllegalArgumentException(paramRectF1.toString());
      }
      return WIDTH;
    }
    if (shouldAutoFitToWidth(paramBoolean, paramRectF1, paramRectF2)) {
      paramRectF1 = WIDTH;
    } else {
      paramRectF1 = HEIGHT;
    }
    return paramRectF1;
  }
  
  private static boolean shouldAutoFitToWidth(boolean paramBoolean, RectF paramRectF1, RectF paramRectF2)
  {
    float f1 = paramRectF1.width();
    float f2 = paramRectF1.height();
    float f3 = paramRectF2.width();
    float f4 = paramRectF2.height();
    float f5 = f4 * f1 / f3;
    f1 = f3 * f2 / f1;
    boolean bool = true;
    if (paramBoolean)
    {
      if (f5 >= f2) {
        return bool;
      }
    }
    else if (f1 >= f4) {
      return bool;
    }
    paramBoolean = false;
    return paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\FitModeEvaluators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
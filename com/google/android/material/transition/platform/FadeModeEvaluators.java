package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FadeModeEvaluators
{
  private static final FadeModeEvaluator CROSS = new FadeModeEvaluator()
  {
    public FadeModeResult evaluate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
    {
      return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat1), TransitionUtils.lerp(0, 255, paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat1));
    }
  };
  private static final FadeModeEvaluator IN = new FadeModeEvaluator()
  {
    public FadeModeResult evaluate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
    {
      return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat1));
    }
  };
  private static final FadeModeEvaluator OUT = new FadeModeEvaluator()
  {
    public FadeModeResult evaluate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
    {
      return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, paramAnonymousFloat2, paramAnonymousFloat3, paramAnonymousFloat1), 255);
    }
  };
  private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator()
  {
    public FadeModeResult evaluate(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
    {
      float f = (paramAnonymousFloat3 - paramAnonymousFloat2) * 0.35F + paramAnonymousFloat2;
      return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, paramAnonymousFloat2, f, paramAnonymousFloat1), TransitionUtils.lerp(0, 255, f, paramAnonymousFloat3, paramAnonymousFloat1));
    }
  };
  
  static FadeModeEvaluator get(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return THROUGH;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid fade mode: ");
          ((StringBuilder)localObject).append(paramInt);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        return CROSS;
      }
      if (paramBoolean) {
        localObject = OUT;
      } else {
        localObject = IN;
      }
      return (FadeModeEvaluator)localObject;
    }
    if (paramBoolean) {
      localObject = IN;
    } else {
      localObject = OUT;
    }
    return (FadeModeEvaluator)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\transition\platform\FadeModeEvaluators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
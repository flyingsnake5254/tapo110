package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RequiresApi;

@RequiresApi(11)
public class Easing
{
  private static final float DOUBLE_PI = 6.2831855F;
  public static final EasingFunction EaseInBack;
  public static final EasingFunction EaseInBounce;
  public static final EasingFunction EaseInCirc;
  public static final EasingFunction EaseInCubic;
  public static final EasingFunction EaseInElastic;
  public static final EasingFunction EaseInExpo;
  public static final EasingFunction EaseInOutBack;
  public static final EasingFunction EaseInOutBounce = new EasingFunction()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      if (paramAnonymousFloat < 0.5F) {
        return Easing.EaseInBounce.getInterpolation(paramAnonymousFloat * 2.0F) * 0.5F;
      }
      return Easing.EaseOutBounce.getInterpolation(paramAnonymousFloat * 2.0F - 1.0F) * 0.5F + 0.5F;
    }
  };
  public static final EasingFunction EaseInOutCirc;
  public static final EasingFunction EaseInOutCubic;
  public static final EasingFunction EaseInOutElastic;
  public static final EasingFunction EaseInOutExpo;
  public static final EasingFunction EaseInOutQuad;
  public static final EasingFunction EaseInOutQuart;
  public static final EasingFunction EaseInOutSine;
  public static final EasingFunction EaseInQuad;
  public static final EasingFunction EaseInQuart;
  public static final EasingFunction EaseInSine;
  public static final EasingFunction EaseOutBack;
  public static final EasingFunction EaseOutBounce;
  public static final EasingFunction EaseOutCirc;
  public static final EasingFunction EaseOutCubic;
  public static final EasingFunction EaseOutElastic;
  public static final EasingFunction EaseOutExpo;
  public static final EasingFunction EaseOutQuad;
  public static final EasingFunction EaseOutQuart;
  public static final EasingFunction EaseOutSine;
  public static final EasingFunction Linear = new EasingFunction()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      return paramAnonymousFloat;
    }
  };
  
  static
  {
    EaseInQuad = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    EaseOutQuad = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return -paramAnonymousFloat * (paramAnonymousFloat - 2.0F);
      }
    };
    EaseInOutQuad = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat *= 2.0F;
        if (paramAnonymousFloat < 1.0F) {
          return 0.5F * paramAnonymousFloat * paramAnonymousFloat;
        }
        paramAnonymousFloat -= 1.0F;
        return (paramAnonymousFloat * (paramAnonymousFloat - 2.0F) - 1.0F) * -0.5F;
      }
    };
    EaseInCubic = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)Math.pow(paramAnonymousFloat, 3.0D);
      }
    };
    EaseOutCubic = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)Math.pow(paramAnonymousFloat - 1.0F, 3.0D) + 1.0F;
      }
    };
    EaseInOutCubic = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat *= 2.0F;
        if (paramAnonymousFloat < 1.0F) {}
        for (paramAnonymousFloat = (float)Math.pow(paramAnonymousFloat, 3.0D);; paramAnonymousFloat = (float)Math.pow(paramAnonymousFloat - 2.0F, 3.0D) + 2.0F) {
          return paramAnonymousFloat * 0.5F;
        }
      }
    };
    EaseInQuart = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)Math.pow(paramAnonymousFloat, 4.0D);
      }
    };
    EaseOutQuart = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return -((float)Math.pow(paramAnonymousFloat - 1.0F, 4.0D) - 1.0F);
      }
    };
    EaseInOutQuart = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat *= 2.0F;
        if (paramAnonymousFloat < 1.0F) {
          return (float)Math.pow(paramAnonymousFloat, 4.0D) * 0.5F;
        }
        return ((float)Math.pow(paramAnonymousFloat - 2.0F, 4.0D) - 2.0F) * -0.5F;
      }
    };
    EaseInSine = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return -(float)Math.cos(paramAnonymousFloat * 1.5707963267948966D) + 1.0F;
      }
    };
    EaseOutSine = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return (float)Math.sin(paramAnonymousFloat * 1.5707963267948966D);
      }
    };
    EaseInOutSine = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return ((float)Math.cos(paramAnonymousFloat * 3.141592653589793D) - 1.0F) * -0.5F;
      }
    };
    EaseInExpo = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        float f = 0.0F;
        if (paramAnonymousFloat == 0.0F) {
          paramAnonymousFloat = f;
        } else {
          paramAnonymousFloat = (float)Math.pow(2.0D, (paramAnonymousFloat - 1.0F) * 10.0F);
        }
        return paramAnonymousFloat;
      }
    };
    EaseOutExpo = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        float f = 1.0F;
        if (paramAnonymousFloat == 1.0F) {
          paramAnonymousFloat = f;
        } else {
          paramAnonymousFloat = -(float)Math.pow(2.0D, (paramAnonymousFloat + 1.0F) * -10.0F);
        }
        return paramAnonymousFloat;
      }
    };
    EaseInOutExpo = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat == 0.0F) {
          return 0.0F;
        }
        if (paramAnonymousFloat == 1.0F) {
          return 1.0F;
        }
        paramAnonymousFloat *= 2.0F;
        if (paramAnonymousFloat < 1.0F) {}
        for (paramAnonymousFloat = (float)Math.pow(2.0D, (paramAnonymousFloat - 1.0F) * 10.0F);; paramAnonymousFloat = -(float)Math.pow(2.0D, (paramAnonymousFloat - 1.0F) * -10.0F) + 2.0F) {
          return paramAnonymousFloat * 0.5F;
        }
      }
    };
    EaseInCirc = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return -((float)Math.sqrt(1.0F - paramAnonymousFloat * paramAnonymousFloat) - 1.0F);
      }
    };
    EaseOutCirc = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return (float)Math.sqrt(1.0F - paramAnonymousFloat * paramAnonymousFloat);
      }
    };
    EaseInOutCirc = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat *= 2.0F;
        if (paramAnonymousFloat < 1.0F) {
          return ((float)Math.sqrt(1.0F - paramAnonymousFloat * paramAnonymousFloat) - 1.0F) * -0.5F;
        }
        paramAnonymousFloat -= 2.0F;
        return ((float)Math.sqrt(1.0F - paramAnonymousFloat * paramAnonymousFloat) + 1.0F) * 0.5F;
      }
    };
    EaseInElastic = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat == 0.0F) {
          return 0.0F;
        }
        if (paramAnonymousFloat == 1.0F) {
          return 1.0F;
        }
        float f = (float)Math.asin(1.0D);
        paramAnonymousFloat -= 1.0F;
        return -((float)Math.pow(2.0D, 10.0F * paramAnonymousFloat) * (float)Math.sin((paramAnonymousFloat - 0.047746483F * f) * 6.2831855F / 0.3F));
      }
    };
    EaseOutElastic = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat == 0.0F) {
          return 0.0F;
        }
        if (paramAnonymousFloat == 1.0F) {
          return 1.0F;
        }
        float f = (float)Math.asin(1.0D);
        return (float)Math.pow(2.0D, -10.0F * paramAnonymousFloat) * (float)Math.sin((paramAnonymousFloat - 0.047746483F * f) * 6.2831855F / 0.3F) + 1.0F;
      }
    };
    EaseInOutElastic = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat == 0.0F) {
          return 0.0F;
        }
        float f = paramAnonymousFloat * 2.0F;
        if (f == 2.0F) {
          return 1.0F;
        }
        paramAnonymousFloat = (float)Math.asin(1.0D) * 0.07161972F;
        if (f < 1.0F)
        {
          f -= 1.0F;
          return (float)Math.pow(2.0D, 10.0F * f) * (float)Math.sin((f * 1.0F - paramAnonymousFloat) * 6.2831855F * 2.2222223F) * -0.5F;
        }
        f -= 1.0F;
        return (float)Math.pow(2.0D, -10.0F * f) * 0.5F * (float)Math.sin((f * 1.0F - paramAnonymousFloat) * 6.2831855F * 2.2222223F) + 1.0F;
      }
    };
    EaseInBack = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * (paramAnonymousFloat * 2.70158F - 1.70158F);
      }
    };
    EaseOutBack = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * paramAnonymousFloat * (paramAnonymousFloat * 2.70158F + 1.70158F) + 1.0F;
      }
    };
    EaseInOutBack = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat *= 2.0F;
        if (paramAnonymousFloat < 1.0F) {
          return paramAnonymousFloat * paramAnonymousFloat * (3.5949094F * paramAnonymousFloat - 2.5949094F) * 0.5F;
        }
        paramAnonymousFloat -= 2.0F;
        return (paramAnonymousFloat * paramAnonymousFloat * (3.5949094F * paramAnonymousFloat + 2.5949094F) + 2.0F) * 0.5F;
      }
    };
    EaseInBounce = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return 1.0F - Easing.EaseOutBounce.getInterpolation(1.0F - paramAnonymousFloat);
      }
    };
    EaseOutBounce = new EasingFunction()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat < 0.36363637F) {
          return 7.5625F * paramAnonymousFloat * paramAnonymousFloat;
        }
        if (paramAnonymousFloat < 0.72727275F)
        {
          paramAnonymousFloat -= 0.54545456F;
          return 7.5625F * paramAnonymousFloat * paramAnonymousFloat + 0.75F;
        }
        if (paramAnonymousFloat < 0.90909094F)
        {
          paramAnonymousFloat -= 0.8181818F;
          return 7.5625F * paramAnonymousFloat * paramAnonymousFloat + 0.9375F;
        }
        paramAnonymousFloat -= 0.95454544F;
        return 7.5625F * paramAnonymousFloat * paramAnonymousFloat + 0.984375F;
      }
    };
  }
  
  public static abstract interface EasingFunction
    extends TimeInterpolator
  {
    public abstract float getInterpolation(float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\animation\Easing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.airbnb.lottie.v;

public class b
{
  private static float a(float paramFloat)
  {
    if (paramFloat <= 0.04045F) {
      paramFloat /= 12.92F;
    } else {
      paramFloat = (float)Math.pow((paramFloat + 0.055F) / 1.055F, 2.4000000953674316D);
    }
    return paramFloat;
  }
  
  private static float b(float paramFloat)
  {
    if (paramFloat <= 0.0031308F) {
      paramFloat *= 12.92F;
    } else {
      paramFloat = (float)(Math.pow(paramFloat, 0.4166666567325592D) * 1.0549999475479126D - 0.054999999701976776D);
    }
    return paramFloat;
  }
  
  public static int c(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramInt1;
    }
    float f1 = (paramInt1 >> 24 & 0xFF) / 255.0F;
    float f2 = (paramInt1 >> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt1 >> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt1 & 0xFF) / 255.0F;
    float f5 = (paramInt2 >> 24 & 0xFF) / 255.0F;
    float f6 = (paramInt2 >> 16 & 0xFF) / 255.0F;
    float f7 = (paramInt2 >> 8 & 0xFF) / 255.0F;
    float f8 = (paramInt2 & 0xFF) / 255.0F;
    f2 = a(f2);
    f3 = a(f3);
    f4 = a(f4);
    f6 = a(f6);
    f7 = a(f7);
    f8 = a(f8);
    f2 = b(f2 + (f6 - f2) * paramFloat);
    f3 = b(f3 + (f7 - f3) * paramFloat);
    f8 = b(f4 + paramFloat * (f8 - f4));
    paramInt1 = Math.round((f1 + (f5 - f1) * paramFloat) * 255.0F);
    return Math.round(f2 * 255.0F) << 16 | paramInt1 << 24 | Math.round(f3 * 255.0F) << 8 | Math.round(f8 * 255.0F);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\v\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
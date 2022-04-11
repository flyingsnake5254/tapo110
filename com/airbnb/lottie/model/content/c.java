package com.airbnb.lottie.model.content;

import com.airbnb.lottie.v.b;
import com.airbnb.lottie.v.g;

public class c
{
  private final float[] a;
  private final int[] b;
  
  public c(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    this.a = paramArrayOfFloat;
    this.b = paramArrayOfInt;
  }
  
  public int[] a()
  {
    return this.b;
  }
  
  public float[] b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.b.length;
  }
  
  public void d(c paramc1, c paramc2, float paramFloat)
  {
    if (paramc1.b.length == paramc2.b.length)
    {
      for (int i = 0; i < paramc1.b.length; i++)
      {
        this.a[i] = g.j(paramc1.a[i], paramc2.a[i], paramFloat);
        this.b[i] = b.c(paramFloat, paramc1.b[i], paramc2.b[i]);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot interpolate between gradients. Lengths vary (");
    localStringBuilder.append(paramc1.b.length);
    localStringBuilder.append(" vs ");
    localStringBuilder.append(paramc2.b.length);
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
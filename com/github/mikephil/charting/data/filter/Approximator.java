package com.github.mikephil.charting.data.filter;

import android.annotation.TargetApi;
import java.util.Arrays;

public class Approximator
{
  float[] concat(float[]... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += paramVarArgs[j].length;
      j++;
    }
    float[] arrayOfFloat1 = new float[k];
    int m = paramVarArgs.length;
    j = 0;
    k = 0;
    while (j < m)
    {
      float[] arrayOfFloat2 = paramVarArgs[j];
      int n = arrayOfFloat2.length;
      for (i = 0; i < n; i++)
      {
        arrayOfFloat1[k] = arrayOfFloat2[i];
        k++;
      }
      j++;
    }
    return arrayOfFloat1;
  }
  
  @TargetApi(9)
  public float[] reduceWithDouglasPeucker(float[] paramArrayOfFloat, float paramFloat)
  {
    Object localObject = new Line(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[(paramArrayOfFloat.length - 2)], paramArrayOfFloat[(paramArrayOfFloat.length - 1)]);
    float f1 = 0.0F;
    int i = 2;
    int j = 0;
    while (i < paramArrayOfFloat.length - 2)
    {
      float f2 = ((Line)localObject).distance(paramArrayOfFloat[i], paramArrayOfFloat[(i + 1)]);
      float f3 = f1;
      if (f2 > f1)
      {
        j = i;
        f3 = f2;
      }
      i += 2;
      f1 = f3;
    }
    if (f1 > paramFloat)
    {
      localObject = reduceWithDouglasPeucker(Arrays.copyOfRange(paramArrayOfFloat, 0, j + 2), paramFloat);
      paramArrayOfFloat = reduceWithDouglasPeucker(Arrays.copyOfRange(paramArrayOfFloat, j, paramArrayOfFloat.length), paramFloat);
      return concat(new float[][] { localObject, Arrays.copyOfRange(paramArrayOfFloat, 2, paramArrayOfFloat.length) });
    }
    return ((Line)localObject).getPoints();
  }
  
  private class Line
  {
    private float dx;
    private float dy;
    private float exsy;
    private float length;
    private float[] points;
    private float sxey;
    
    public Line(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      float f1 = paramFloat1 - paramFloat3;
      this.dx = f1;
      float f2 = paramFloat2 - paramFloat4;
      this.dy = f2;
      this.sxey = (paramFloat1 * paramFloat4);
      this.exsy = (paramFloat3 * paramFloat2);
      this.length = ((float)Math.sqrt(f1 * f1 + f2 * f2));
      this.points = new float[] { paramFloat1, paramFloat2, paramFloat3, paramFloat4 };
    }
    
    public float distance(float paramFloat1, float paramFloat2)
    {
      return Math.abs(this.dy * paramFloat1 - this.dx * paramFloat2 + this.sxey - this.exsy) / this.length;
    }
    
    public float[] getPoints()
    {
      return this.points;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\filter\Approximator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
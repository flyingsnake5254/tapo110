package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorApi14
  implements Interpolator
{
  private static final float PRECISION = 0.002F;
  private final float[] mX;
  private final float[] mY;
  
  PathInterpolatorApi14(float paramFloat1, float paramFloat2)
  {
    this(createQuad(paramFloat1, paramFloat2));
  }
  
  PathInterpolatorApi14(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(createCubic(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  PathInterpolatorApi14(Path paramPath)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f = localPathMeasure.getLength();
    int i = (int)(f / 0.002F) + 1;
    this.mX = new float[i];
    this.mY = new float[i];
    paramPath = new float[2];
    for (int j = 0; j < i; j++)
    {
      localPathMeasure.getPosTan(j * f / (i - 1), paramPath, null);
      this.mX[j] = paramPath[0];
      this.mY[j] = paramPath[1];
    }
  }
  
  private static Path createCubic(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    return localPath;
  }
  
  private static Path createQuad(float paramFloat1, float paramFloat2)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    return localPath;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int i = 0;
    int j = this.mX.length - 1;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < this.mX[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float[] arrayOfFloat = this.mX;
    float f = arrayOfFloat[j] - arrayOfFloat[i];
    if (f == 0.0F) {
      return this.mY[i];
    }
    paramFloat = (paramFloat - arrayOfFloat[i]) / f;
    arrayOfFloat = this.mY;
    f = arrayOfFloat[i];
    return f + paramFloat * (arrayOfFloat[j] - f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\animation\PathInterpolatorApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
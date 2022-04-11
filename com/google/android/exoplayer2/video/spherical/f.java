package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.k0;

final class f
{
  private final float[] a = new float[16];
  private final float[] b = new float[16];
  private final k0<float[]> c = new k0();
  private boolean d;
  
  public static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    Matrix.setIdentityM(paramArrayOfFloat1, 0);
    float f = (float)Math.sqrt(paramArrayOfFloat2[10] * paramArrayOfFloat2[10] + paramArrayOfFloat2[8] * paramArrayOfFloat2[8]);
    paramArrayOfFloat1[0] = (paramArrayOfFloat2[10] / f);
    paramArrayOfFloat1[2] = (paramArrayOfFloat2[8] / f);
    paramArrayOfFloat1[8] = (-paramArrayOfFloat2[8] / f);
    paramArrayOfFloat2[10] /= f;
  }
  
  private static void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat2[0];
    float f2 = -paramArrayOfFloat2[1];
    float f3 = -paramArrayOfFloat2[2];
    float f4 = Matrix.length(f1, f2, f3);
    if (f4 != 0.0F) {
      Matrix.setRotateM(paramArrayOfFloat1, 0, (float)Math.toDegrees(f4), f1 / f4, f2 / f4, f3 / f4);
    } else {
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
  }
  
  public boolean c(float[] paramArrayOfFloat, long paramLong)
  {
    float[] arrayOfFloat = (float[])this.c.j(paramLong);
    if (arrayOfFloat == null) {
      return false;
    }
    b(this.b, arrayOfFloat);
    if (!this.d)
    {
      a(this.a, this.b);
      this.d = true;
    }
    Matrix.multiplyMM(paramArrayOfFloat, 0, this.a, 0, this.b, 0);
    return true;
  }
  
  public void d()
  {
    this.c.c();
    this.d = false;
  }
  
  public void e(long paramLong, float[] paramArrayOfFloat)
  {
    this.c.a(paramLong, paramArrayOfFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;

final class g
  implements SensorEventListener
{
  private final float[] a = new float[16];
  private final float[] b = new float[16];
  private final float[] c = new float[16];
  private final float[] d = new float[3];
  private final Display e;
  private final a[] f;
  private boolean g;
  
  public g(Display paramDisplay, a... paramVarArgs)
  {
    this.e = paramDisplay;
    this.f = paramVarArgs;
  }
  
  private float a(float[] paramArrayOfFloat)
  {
    SensorManager.remapCoordinateSystem(paramArrayOfFloat, 1, 131, this.b);
    SensorManager.getOrientation(this.b, this.d);
    return this.d[2];
  }
  
  private void b(float[] paramArrayOfFloat, float paramFloat)
  {
    a[] arrayOfa = this.f;
    int i = arrayOfa.length;
    for (int j = 0; j < i; j++) {
      arrayOfa[j].a(paramArrayOfFloat, paramFloat);
    }
  }
  
  private void c(float[] paramArrayOfFloat)
  {
    if (!this.g)
    {
      f.a(this.c, paramArrayOfFloat);
      this.g = true;
    }
    float[] arrayOfFloat = this.b;
    System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
    Matrix.multiplyMM(paramArrayOfFloat, 0, this.b, 0, this.c, 0);
  }
  
  private void d(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramInt != 0)
    {
      int i = 130;
      int j = 129;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            j = 1;
            paramInt = i;
            i = j;
          }
          else
          {
            throw new IllegalStateException();
          }
        }
        else
        {
          paramInt = 129;
          i = 130;
        }
      }
      else
      {
        paramInt = 2;
        i = j;
      }
      float[] arrayOfFloat = this.b;
      System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
      SensorManager.remapCoordinateSystem(this.b, paramInt, i, paramArrayOfFloat);
    }
  }
  
  private static void e(float[] paramArrayOfFloat)
  {
    Matrix.rotateM(paramArrayOfFloat, 0, 90.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  @BinderThread
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    SensorManager.getRotationMatrixFromVector(this.a, paramSensorEvent.values);
    d(this.a, this.e.getRotation());
    float f1 = a(this.a);
    e(this.a);
    c(this.a);
    b(this.a, f1);
  }
  
  public static abstract interface a
  {
    public abstract void a(float[] paramArrayOfFloat, float paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
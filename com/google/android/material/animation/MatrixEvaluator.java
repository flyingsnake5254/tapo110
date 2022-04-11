package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class MatrixEvaluator
  implements TypeEvaluator<Matrix>
{
  private final float[] tempEndValues = new float[9];
  private final Matrix tempMatrix = new Matrix();
  private final float[] tempStartValues = new float[9];
  
  @NonNull
  public Matrix evaluate(float paramFloat, @NonNull Matrix paramMatrix1, @NonNull Matrix paramMatrix2)
  {
    paramMatrix1.getValues(this.tempStartValues);
    paramMatrix2.getValues(this.tempEndValues);
    for (int i = 0; i < 9; i++)
    {
      paramMatrix2 = this.tempEndValues;
      float f1 = paramMatrix2[i];
      paramMatrix1 = this.tempStartValues;
      float f2 = paramMatrix1[i];
      paramMatrix1[i] += (f1 - f2) * paramFloat;
    }
    this.tempMatrix.setValues(this.tempEndValues);
    return this.tempMatrix;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\animation\MatrixEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
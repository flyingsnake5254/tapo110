package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.jvm.internal.j;

public final class MatrixKt
{
  public static final Matrix rotationMatrix(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramFloat1, paramFloat2, paramFloat3);
    return localMatrix;
  }
  
  public static final Matrix scaleMatrix(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(paramFloat1, paramFloat2);
    return localMatrix;
  }
  
  public static final Matrix times(Matrix paramMatrix1, Matrix paramMatrix2)
  {
    j.f(paramMatrix1, "$this$times");
    j.f(paramMatrix2, "m");
    paramMatrix1 = new Matrix(paramMatrix1);
    paramMatrix1.preConcat(paramMatrix2);
    return paramMatrix1;
  }
  
  public static final Matrix translationMatrix(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(paramFloat1, paramFloat2);
    return localMatrix;
  }
  
  public static final float[] values(Matrix paramMatrix)
  {
    j.f(paramMatrix, "$this$values");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    return arrayOfFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\MatrixKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package androidx.transition;

import android.animation.TypeEvaluator;

class FloatArrayEvaluator
  implements TypeEvaluator<float[]>
{
  private float[] mArray;
  
  FloatArrayEvaluator(float[] paramArrayOfFloat)
  {
    this.mArray = paramArrayOfFloat;
  }
  
  public float[] evaluate(float paramFloat, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat1 = this.mArray;
    float[] arrayOfFloat2 = arrayOfFloat1;
    if (arrayOfFloat1 == null) {
      arrayOfFloat2 = new float[paramArrayOfFloat1.length];
    }
    for (int i = 0; i < arrayOfFloat2.length; i++)
    {
      float f = paramArrayOfFloat1[i];
      arrayOfFloat2[i] = (f + (paramArrayOfFloat2[i] - f) * paramFloat);
    }
    return arrayOfFloat2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\FloatArrayEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
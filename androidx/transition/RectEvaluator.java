package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class RectEvaluator
  implements TypeEvaluator<Rect>
{
  private Rect mRect;
  
  RectEvaluator() {}
  
  RectEvaluator(Rect paramRect)
  {
    this.mRect = paramRect;
  }
  
  public Rect evaluate(float paramFloat, Rect paramRect1, Rect paramRect2)
  {
    int i = paramRect1.left;
    i += (int)((paramRect2.left - i) * paramFloat);
    int j = paramRect1.top;
    j += (int)((paramRect2.top - j) * paramFloat);
    int k = paramRect1.right;
    k += (int)((paramRect2.right - k) * paramFloat);
    int m = paramRect1.bottom;
    m += (int)((paramRect2.bottom - m) * paramFloat);
    paramRect1 = this.mRect;
    if (paramRect1 == null) {
      return new Rect(i, j, k, m);
    }
    paramRect1.set(i, j, k, m);
    return this.mRect;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\RectEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
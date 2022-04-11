package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.f;

public class d
  extends a
{
  d(f paramf, Layer paramLayer)
  {
    super(paramf, paramLayer);
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.e(paramRectF, paramMatrix, paramBoolean);
    paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  void t(Canvas paramCanvas, Matrix paramMatrix, int paramInt) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
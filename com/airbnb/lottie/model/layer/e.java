package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.j;
import java.util.Collections;
import java.util.List;

public class e
  extends a
{
  private final com.airbnb.lottie.s.b.d x;
  
  e(f paramf, Layer paramLayer)
  {
    super(paramf, paramLayer);
    paramf = new com.airbnb.lottie.s.b.d(paramf, this, new j("__container", paramLayer.l(), false));
    this.x = paramf;
    paramf.b(Collections.emptyList(), Collections.emptyList());
  }
  
  protected void D(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    this.x.d(paramd1, paramInt, paramList, paramd2);
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.e(paramRectF, paramMatrix, paramBoolean);
    this.x.e(paramRectF, this.m, paramBoolean);
  }
  
  void t(@NonNull Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.x.g(paramCanvas, paramMatrix, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
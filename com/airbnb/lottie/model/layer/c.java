package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.v.h;

public class c
  extends a
{
  @Nullable
  private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> A;
  private final Paint x = new com.airbnb.lottie.s.a(3);
  private final Rect y = new Rect();
  private final Rect z = new Rect();
  
  c(f paramf, Layer paramLayer)
  {
    super(paramf, paramLayer);
  }
  
  @Nullable
  private Bitmap J()
  {
    String str = this.o.k();
    return this.n.q(str);
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    super.c(paramT, paramc);
    if (paramT == k.C) {
      if (paramc == null) {
        this.A = null;
      } else {
        this.A = new p(paramc);
      }
    }
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.e(paramRectF, paramMatrix, paramBoolean);
    paramMatrix = J();
    if (paramMatrix != null)
    {
      paramRectF.set(0.0F, 0.0F, paramMatrix.getWidth() * h.e(), paramMatrix.getHeight() * h.e());
      this.m.mapRect(paramRectF);
    }
  }
  
  public void t(@NonNull Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    Bitmap localBitmap = J();
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      float f = h.e();
      this.x.setAlpha(paramInt);
      com.airbnb.lottie.s.c.a locala = this.A;
      if (locala != null) {
        this.x.setColorFilter((ColorFilter)locala.h());
      }
      paramCanvas.save();
      paramCanvas.concat(paramMatrix);
      this.y.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      this.z.set(0, 0, (int)(localBitmap.getWidth() * f), (int)(localBitmap.getHeight() * f));
      paramCanvas.drawBitmap(localBitmap, this.y, this.z, this.x);
      paramCanvas.restore();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
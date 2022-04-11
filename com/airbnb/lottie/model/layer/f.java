package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.w.c;

public class f
  extends a
{
  private final Path A;
  private final Layer B;
  @Nullable
  private com.airbnb.lottie.s.c.a<ColorFilter, ColorFilter> C;
  private final RectF x = new RectF();
  private final Paint y;
  private final float[] z;
  
  f(com.airbnb.lottie.f paramf, Layer paramLayer)
  {
    super(paramf, paramLayer);
    paramf = new com.airbnb.lottie.s.a();
    this.y = paramf;
    this.z = new float[8];
    this.A = new Path();
    this.B = paramLayer;
    paramf.setAlpha(0);
    paramf.setStyle(Paint.Style.FILL);
    paramf.setColor(paramLayer.m());
  }
  
  public <T> void c(T paramT, @Nullable c<T> paramc)
  {
    super.c(paramT, paramc);
    if (paramT == k.C) {
      if (paramc == null) {
        this.C = null;
      } else {
        this.C = new p(paramc);
      }
    }
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.e(paramRectF, paramMatrix, paramBoolean);
    this.x.set(0.0F, 0.0F, this.B.o(), this.B.n());
    this.m.mapRect(this.x);
    paramRectF.set(this.x);
  }
  
  public void t(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    int i = Color.alpha(this.B.m());
    if (i == 0) {
      return;
    }
    int j;
    if (this.v.h() == null) {
      j = 100;
    } else {
      j = ((Integer)this.v.h().h()).intValue();
    }
    paramInt = (int)(paramInt / 255.0F * (i / 255.0F * j / 100.0F) * 255.0F);
    this.y.setAlpha(paramInt);
    Object localObject = this.C;
    if (localObject != null) {
      this.y.setColorFilter((ColorFilter)((com.airbnb.lottie.s.c.a)localObject).h());
    }
    if (paramInt > 0)
    {
      localObject = this.z;
      localObject[0] = 0.0F;
      localObject[1] = 0.0F;
      localObject[2] = this.B.o();
      localObject = this.z;
      localObject[3] = 0.0F;
      localObject[4] = this.B.o();
      this.z[5] = this.B.n();
      localObject = this.z;
      localObject[6] = 0.0F;
      localObject[7] = this.B.n();
      paramMatrix.mapPoints(this.z);
      this.A.reset();
      paramMatrix = this.A;
      localObject = this.z;
      paramMatrix.moveTo(localObject[0], localObject[1]);
      paramMatrix = this.A;
      localObject = this.z;
      paramMatrix.lineTo(localObject[2], localObject[3]);
      paramMatrix = this.A;
      localObject = this.z;
      paramMatrix.lineTo(localObject[4], localObject[5]);
      localObject = this.A;
      paramMatrix = this.z;
      ((Path)localObject).lineTo(paramMatrix[6], paramMatrix[7]);
      paramMatrix = this.A;
      localObject = this.z;
      paramMatrix.lineTo(localObject[0], localObject[1]);
      this.A.close();
      paramCanvas.drawPath(this.A, this.y);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
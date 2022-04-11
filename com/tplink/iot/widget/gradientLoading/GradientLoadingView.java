package com.tplink.iot.widget.gradientLoading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class GradientLoadingView
  extends View
{
  private LinearGradient c = null;
  private Matrix d;
  private Paint f = null;
  private float[] p0;
  private int p1 = 0;
  private boolean p2 = true;
  private int q;
  private int x;
  private RectF y;
  private int[] z;
  
  public GradientLoadingView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GradientLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public GradientLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.f = new Paint();
    this.d = new Matrix();
    int i = paramContext.getResources().getColor(2131099947);
    int j = paramContext.getResources().getColor(2131099946);
    this.z = new int[] { j, i, j };
    this.p0 = new float[] { 0.0F, 0.5F, 1.0F };
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.p2) {
      return;
    }
    int i = this.p1 + 20;
    this.p1 = i;
    if (i > this.x * 2) {
      this.p1 = 0;
    }
    this.d.setTranslate(this.p1, 0.0F);
    this.c.setLocalMatrix(this.d);
    this.f.setShader(this.c);
    this.f.setAntiAlias(true);
    i = this.q;
    RectF localRectF = this.y;
    float f1 = i * 2;
    paramCanvas.drawRoundRect(localRectF, f1, f1, this.f);
    postInvalidateDelayed(10L);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.x = (paramInt3 - paramInt1);
    this.q = (paramInt4 - paramInt2);
    this.c = new LinearGradient(-this.x, 0.0F, 0.0F, 0.0F, this.z, this.p0, Shader.TileMode.CLAMP);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.y = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.p2 = bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\gradientLoading\GradientLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
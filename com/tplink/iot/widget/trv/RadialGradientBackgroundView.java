package com.tplink.iot.widget.trv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class RadialGradientBackgroundView
  extends View
{
  private boolean c;
  private int d = (int)4294113018L;
  private final Paint f;
  
  public RadialGradientBackgroundView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public RadialGradientBackgroundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public RadialGradientBackgroundView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramAttributeSet = p.a;
    this.f = paramContext;
  }
  
  private final int[] a(int paramInt)
  {
    paramInt &= 0xFFFFFF;
    return new int[] { paramInt | (int)2583691264L, paramInt | 0xD000000 };
  }
  
  private final void c()
  {
    if (!this.c)
    {
      this.c = true;
      Paint localPaint = this.f;
      float f1 = getWidth() / 2.0F;
      float f2 = getHeight() / 2.0F;
      float f3 = getWidth() / 2.0F;
      float f4 = getHeight() / 2.0F;
      localPaint.setShader(new RadialGradient(f1, f2, (float)Math.hypot(f3, f4), a(this.d), null, Shader.TileMode.CLAMP));
    }
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
    this.c = false;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    c();
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.f);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\trv\RadialGradientBackgroundView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
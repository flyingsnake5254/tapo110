package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SelectableColorPointView
  extends LightingEffectBaseView
{
  private final int M3 = (int)e(48);
  private final float N3;
  private final Paint O3;
  private int P3;
  private final Paint Q3;
  
  public SelectableColorPointView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public SelectableColorPointView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public SelectableColorPointView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = e(2);
    this.N3 = f;
    paramAttributeSet = new Paint(1);
    paramAttributeSet.setStyle(Paint.Style.STROKE);
    paramAttributeSet.setStrokeWidth(f);
    paramAttributeSet.setColor(536870912);
    paramContext = p.a;
    this.O3 = paramAttributeSet;
    this.P3 = -1;
    this.Q3 = new Paint(1);
  }
  
  public void c(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    this.Q3.setColor(this.P3);
    paramCanvas.drawCircle(f1, f2, f1 - getMHaloWidth() - getMGapWidth(), this.Q3);
    f2 = (getWidth() - this.N3) / 2.0F;
    f1 = getMHaloWidth();
    float f3 = getMGapWidth();
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f2 - f1 - f3, this.O3);
  }
  
  protected int getMDefaultSize()
  {
    return this.M3;
  }
  
  public final void setColor(@ColorInt int paramInt)
  {
    this.P3 = paramInt;
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\SelectableColorPointView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class AutoLightFeaturePointView
  extends LightingEffectBaseView
{
  private final int M3 = (int)e(48);
  private final float N3;
  private final Paint O3;
  private int P3;
  private final Paint Q3;
  private final String R3;
  private final TextPaint S3;
  
  public AutoLightFeaturePointView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public AutoLightFeaturePointView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public AutoLightFeaturePointView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = e(2);
    this.N3 = f;
    paramContext = new Paint(1);
    paramContext.setStyle(Paint.Style.STROKE);
    paramContext.setStrokeWidth(f);
    paramContext.setColor(536870912);
    paramAttributeSet = p.a;
    this.O3 = paramContext;
    this.P3 = -1;
    this.Q3 = new Paint(1);
    this.R3 = "Auto";
    paramContext = new TextPaint(1);
    paramContext.setColor((int)4281746507L);
    paramContext.setTextSize(k(12));
    paramContext.setTextAlign(Paint.Align.CENTER);
    this.S3 = paramContext;
  }
  
  private final float k(int paramInt)
  {
    float f = paramInt;
    Object localObject = getContext();
    j.d(localObject, "context");
    localObject = ((Context)localObject).getResources();
    j.d(localObject, "context.resources");
    return TypedValue.applyDimension(2, f, ((Resources)localObject).getDisplayMetrics());
  }
  
  public void c(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    this.Q3.setColor(this.P3);
    paramCanvas.drawCircle(f1, f2, f1 - getMHaloWidth() - getMGapWidth(), this.Q3);
    float f3 = (getWidth() - this.N3) / 2.0F;
    f2 = getMHaloWidth();
    float f4 = getMGapWidth();
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f3 - f2 - f4, this.O3);
    Paint.FontMetrics localFontMetrics = this.S3.getFontMetrics();
    f4 = getHeight();
    f3 = localFontMetrics.descent;
    f2 = localFontMetrics.ascent;
    f3 = (f4 - (f3 - f2)) / 2;
    paramCanvas.drawText(this.R3, f1, f3 - f2, this.S3);
  }
  
  protected int getMDefaultSize()
  {
    return this.M3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\AutoLightFeaturePointView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
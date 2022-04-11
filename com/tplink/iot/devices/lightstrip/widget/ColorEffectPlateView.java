package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ColorEffectPlateView
  extends LightingEffectBaseView
{
  private final float M3;
  private final RectF N3;
  private final Paint O3;
  private final Paint P3;
  private final List<Integer> Q3;
  
  public ColorEffectPlateView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public ColorEffectPlateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public ColorEffectPlateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = e(2);
    this.M3 = f;
    this.N3 = new RectF();
    this.O3 = new Paint(1);
    paramAttributeSet = new Paint(1);
    paramAttributeSet.setStyle(Paint.Style.STROKE);
    paramAttributeSet.setStrokeWidth(f);
    paramAttributeSet.setColor(536870912);
    paramContext = p.a;
    this.P3 = paramAttributeSet;
    this.Q3 = new ArrayList();
  }
  
  private final void l()
  {
    float f = getMHaloWidth() + getMGapWidth();
    this.N3.set(f, f, getWidth() - f, getHeight() - f);
  }
  
  public void c(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    l();
    if ((this.Q3.isEmpty() ^ true))
    {
      f1 = 360.0F / this.Q3.size();
      int i = 0;
      int j = this.Q3.size();
      while (i < j)
      {
        f2 = i;
        this.O3.setColor(((Number)this.Q3.get(i)).intValue());
        paramCanvas.drawArc(this.N3, f2 * f1 - 90.0F, f1, true, this.O3);
        i++;
      }
    }
    float f1 = (getWidth() - this.M3) / 2.0F;
    float f3 = getMHaloWidth();
    float f2 = getMGapWidth();
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1 - f3 - f2, this.P3);
  }
  
  public final void k(List<Integer> paramList)
  {
    j.e(paramList, "colors");
    this.Q3.clear();
    if ((paramList.isEmpty() ^ true)) {
      this.Q3.addAll(paramList);
    } else {
      this.Q3.add(Integer.valueOf(-1));
    }
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\ColorEffectPlateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
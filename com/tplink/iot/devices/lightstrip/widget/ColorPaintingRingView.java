package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tplink.iot.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ColorPaintingRingView
  extends LightingEffectBaseView
{
  private float M3 = e(10);
  private final float N3;
  private final RectF O3;
  private final Paint P3;
  private final Paint Q3;
  private final List<Pair<Integer, Float>> R3;
  
  public ColorPaintingRingView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public ColorPaintingRingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public ColorPaintingRingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = e(2);
    this.N3 = f;
    this.O3 = new RectF();
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(this.M3);
    localPaint.setStrokeCap(Paint.Cap.BUTT);
    Object localObject = p.a;
    this.P3 = localPaint;
    localObject = new Paint(1);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setStrokeWidth(f);
    ((Paint)localObject).setColor(369098752);
    this.Q3 = ((Paint)localObject);
    this.R3 = new ArrayList();
    setLayerType(1, null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.ColorPaintingRingView);
    this.M3 = paramContext.getDimension(0, this.M3);
    paramContext.recycle();
  }
  
  private final void l()
  {
    float f = this.M3 / 2.0F + getMHaloWidth() + getMGapWidth();
    this.O3.set(f, f, getWidth() - f, getHeight() - f);
  }
  
  public void c(Canvas paramCanvas)
  {
    j.e(paramCanvas, "canvas");
    l();
    this.P3.setStrokeWidth(this.M3);
    Iterator localIterator = this.R3.iterator();
    for (float f1 = -90.0F; localIterator.hasNext(); f1 += f2)
    {
      Object localObject = (Pair)localIterator.next();
      f2 = ((Number)((Pair)localObject).getSecond()).floatValue() * 360.0F;
      RectF localRectF = this.O3;
      Paint localPaint = this.P3;
      localPaint.setColor(((Number)((Pair)localObject).getFirst()).intValue());
      localObject = p.a;
      paramCanvas.drawArc(localRectF, f1, f2, false, localPaint);
    }
    f1 = (getWidth() - this.N3) / 2.0F;
    float f3 = getMHaloWidth();
    float f2 = getMGapWidth();
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f1 - f3 - f2, this.Q3);
    f2 = (getWidth() + this.N3) / 2.0F;
    f3 = getMHaloWidth();
    f1 = getMGapWidth();
    float f4 = this.M3;
    paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, f2 - f3 - f1 - f4, this.Q3);
  }
  
  public final float getRingWidth()
  {
    return this.M3;
  }
  
  public final void k(List<Integer> paramList1, List<Integer> paramList2)
  {
    j.e(paramList1, "colors");
    j.e(paramList2, "parts");
    if ((!paramList1.isEmpty()) && (!paramList2.isEmpty()))
    {
      this.R3.clear();
      int i = Math.min(paramList1.size(), paramList2.size());
      int j = 0;
      Iterator localIterator = paramList2.subList(0, i).iterator();
      if (localIterator.hasNext())
      {
        for (Object localObject = localIterator.next(); localIterator.hasNext(); localObject = Integer.valueOf(((Number)localObject).intValue() + k)) {
          k = ((Number)localIterator.next()).intValue();
        }
        int k = ((Number)localObject).intValue();
        while (j < i)
        {
          localObject = new Pair(paramList1.get(j), Float.valueOf(((Number)paramList2.get(j)).floatValue() / k));
          this.R3.add(localObject);
          j++;
        }
        invalidate();
        return;
      }
      throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
  }
  
  public final void setRingWidth(float paramFloat)
  {
    this.M3 = paramFloat;
    invalidate();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\ColorPaintingRingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
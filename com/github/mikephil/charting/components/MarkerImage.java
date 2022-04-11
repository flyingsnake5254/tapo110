package com.github.mikephil.charting.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerImage
  implements IMarker
{
  private Context mContext;
  private Drawable mDrawable;
  private Rect mDrawableBoundsCache = new Rect();
  private MPPointF mOffset = new MPPointF();
  private MPPointF mOffset2 = new MPPointF();
  private FSize mSize = new FSize();
  private WeakReference<Chart> mWeakChart;
  
  public MarkerImage(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    if (Build.VERSION.SDK_INT >= 21) {
      this.mDrawable = paramContext.getResources().getDrawable(paramInt, null);
    } else {
      this.mDrawable = paramContext.getResources().getDrawable(paramInt);
    }
  }
  
  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    if (this.mDrawable == null) {
      return;
    }
    MPPointF localMPPointF = getOffsetForDrawingAtPoint(paramFloat1, paramFloat2);
    Object localObject = this.mSize;
    float f1 = ((FSize)localObject).width;
    float f2 = ((FSize)localObject).height;
    float f3 = f1;
    if (f1 == 0.0F) {
      f3 = this.mDrawable.getIntrinsicWidth();
    }
    f1 = f2;
    if (f2 == 0.0F) {
      f1 = this.mDrawable.getIntrinsicHeight();
    }
    this.mDrawable.copyBounds(this.mDrawableBoundsCache);
    Drawable localDrawable = this.mDrawable;
    localObject = this.mDrawableBoundsCache;
    int i = ((Rect)localObject).left;
    int j = ((Rect)localObject).top;
    localDrawable.setBounds(i, j, (int)f3 + i, (int)f1 + j);
    i = paramCanvas.save();
    paramCanvas.translate(paramFloat1 + localMPPointF.x, paramFloat2 + localMPPointF.y);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    this.mDrawable.setBounds(this.mDrawableBoundsCache);
  }
  
  public Chart getChartView()
  {
    Object localObject = this.mWeakChart;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Chart)((WeakReference)localObject).get();
    }
    return (Chart)localObject;
  }
  
  public MPPointF getOffset()
  {
    return this.mOffset;
  }
  
  public MPPointF getOffsetForDrawingAtPoint(float paramFloat1, float paramFloat2)
  {
    Object localObject1 = getOffset();
    Object localObject2 = this.mOffset2;
    ((MPPointF)localObject2).x = ((MPPointF)localObject1).x;
    ((MPPointF)localObject2).y = ((MPPointF)localObject1).y;
    localObject1 = getChartView();
    localObject2 = this.mSize;
    float f1 = ((FSize)localObject2).width;
    float f2 = ((FSize)localObject2).height;
    float f3 = f1;
    if (f1 == 0.0F)
    {
      localObject2 = this.mDrawable;
      f3 = f1;
      if (localObject2 != null) {
        f3 = ((Drawable)localObject2).getIntrinsicWidth();
      }
    }
    f1 = f2;
    if (f2 == 0.0F)
    {
      localObject2 = this.mDrawable;
      f1 = f2;
      if (localObject2 != null) {
        f1 = ((Drawable)localObject2).getIntrinsicHeight();
      }
    }
    localObject2 = this.mOffset2;
    f2 = ((MPPointF)localObject2).x;
    if (paramFloat1 + f2 < 0.0F) {
      ((MPPointF)localObject2).x = (-paramFloat1);
    } else if ((localObject1 != null) && (paramFloat1 + f3 + f2 > ((ViewGroup)localObject1).getWidth())) {
      this.mOffset2.x = (((ViewGroup)localObject1).getWidth() - paramFloat1 - f3);
    }
    localObject2 = this.mOffset2;
    paramFloat1 = ((MPPointF)localObject2).y;
    if (paramFloat2 + paramFloat1 < 0.0F) {
      ((MPPointF)localObject2).y = (-paramFloat2);
    } else if ((localObject1 != null) && (paramFloat2 + f1 + paramFloat1 > ((ViewGroup)localObject1).getHeight())) {
      this.mOffset2.y = (((ViewGroup)localObject1).getHeight() - paramFloat2 - f1);
    }
    return this.mOffset2;
  }
  
  public FSize getSize()
  {
    return this.mSize;
  }
  
  public void refreshContent(Entry paramEntry, Highlight paramHighlight) {}
  
  public void setChartView(Chart paramChart)
  {
    this.mWeakChart = new WeakReference(paramChart);
  }
  
  public void setOffset(float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = this.mOffset;
    localMPPointF.x = paramFloat1;
    localMPPointF.y = paramFloat2;
  }
  
  public void setOffset(MPPointF paramMPPointF)
  {
    this.mOffset = paramMPPointF;
    if (paramMPPointF == null) {
      this.mOffset = new MPPointF();
    }
  }
  
  public void setSize(FSize paramFSize)
  {
    this.mSize = paramFSize;
    if (paramFSize == null) {
      this.mSize = new FSize();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\MarkerImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
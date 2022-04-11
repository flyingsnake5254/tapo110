package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerView
  extends RelativeLayout
  implements IMarker
{
  private MPPointF mOffset = new MPPointF();
  private MPPointF mOffset2 = new MPPointF();
  private WeakReference<Chart> mWeakChart;
  
  public MarkerView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setupLayoutResource(paramInt);
  }
  
  private void setupLayoutResource(int paramInt)
  {
    View localView = LayoutInflater.from(getContext()).inflate(paramInt, this);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = getOffsetForDrawingAtPoint(paramFloat1, paramFloat2);
    int i = paramCanvas.save();
    paramCanvas.translate(paramFloat1 + localMPPointF.x, paramFloat2 + localMPPointF.y);
    draw(paramCanvas);
    paramCanvas.restoreToCount(i);
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
    MPPointF localMPPointF = getOffset();
    Object localObject = this.mOffset2;
    ((MPPointF)localObject).x = localMPPointF.x;
    ((MPPointF)localObject).y = localMPPointF.y;
    localObject = getChartView();
    float f1 = getWidth();
    float f2 = getHeight();
    localMPPointF = this.mOffset2;
    float f3 = localMPPointF.x;
    if (paramFloat1 + f3 < 0.0F) {
      localMPPointF.x = (-paramFloat1);
    } else if ((localObject != null) && (paramFloat1 + f1 + f3 > ((ViewGroup)localObject).getWidth())) {
      this.mOffset2.x = (((ViewGroup)localObject).getWidth() - paramFloat1 - f1);
    }
    localMPPointF = this.mOffset2;
    paramFloat1 = localMPPointF.y;
    if (paramFloat2 + paramFloat1 < 0.0F) {
      localMPPointF.y = (-paramFloat2);
    } else if ((localObject != null) && (paramFloat2 + f2 + paramFloat1 > ((ViewGroup)localObject).getHeight())) {
      this.mOffset2.y = (((ViewGroup)localObject).getHeight() - paramFloat2 - f2);
    }
    return this.mOffset2;
  }
  
  public void refreshContent(Entry paramEntry, Highlight paramHighlight)
  {
    measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
  }
  
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\MarkerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
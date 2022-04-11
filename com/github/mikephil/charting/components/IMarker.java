package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

public abstract interface IMarker
{
  public abstract void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2);
  
  public abstract MPPointF getOffset();
  
  public abstract MPPointF getOffsetForDrawingAtPoint(float paramFloat1, float paramFloat2);
  
  public abstract void refreshContent(Entry paramEntry, Highlight paramHighlight);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\IMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
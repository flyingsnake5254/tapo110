package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

public abstract class ChartTouchListener<T extends Chart<?>>
  extends GestureDetector.SimpleOnGestureListener
  implements View.OnTouchListener
{
  protected static final int DRAG = 1;
  protected static final int NONE = 0;
  protected static final int PINCH_ZOOM = 4;
  protected static final int POST_ZOOM = 5;
  protected static final int ROTATE = 6;
  protected static final int X_ZOOM = 2;
  protected static final int Y_ZOOM = 3;
  protected T mChart;
  protected GestureDetector mGestureDetector;
  protected ChartGesture mLastGesture = ChartGesture.NONE;
  protected Highlight mLastHighlighted;
  protected int mTouchMode = 0;
  
  public ChartTouchListener(T paramT)
  {
    this.mChart = paramT;
    this.mGestureDetector = new GestureDetector(paramT.getContext(), this);
  }
  
  protected static float distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat2;
    paramFloat2 = paramFloat3 - paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public void endAction(MotionEvent paramMotionEvent)
  {
    OnChartGestureListener localOnChartGestureListener = this.mChart.getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartGestureEnd(paramMotionEvent, this.mLastGesture);
    }
  }
  
  public ChartGesture getLastGesture()
  {
    return this.mLastGesture;
  }
  
  public int getTouchMode()
  {
    return this.mTouchMode;
  }
  
  protected void performHighlight(Highlight paramHighlight, MotionEvent paramMotionEvent)
  {
    if ((paramHighlight != null) && (!paramHighlight.equalTo(this.mLastHighlighted)))
    {
      this.mChart.highlightValue(paramHighlight, true);
      this.mLastHighlighted = paramHighlight;
    }
    else
    {
      this.mChart.highlightValue(null, true);
      this.mLastHighlighted = null;
    }
  }
  
  public void setLastHighlighted(Highlight paramHighlight)
  {
    this.mLastHighlighted = paramHighlight;
  }
  
  public void startAction(MotionEvent paramMotionEvent)
  {
    OnChartGestureListener localOnChartGestureListener = this.mChart.getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartGestureStart(paramMotionEvent, this.mLastGesture);
    }
  }
  
  public static enum ChartGesture
  {
    static
    {
      ChartGesture localChartGesture1 = new ChartGesture("NONE", 0);
      NONE = localChartGesture1;
      ChartGesture localChartGesture2 = new ChartGesture("DRAG", 1);
      DRAG = localChartGesture2;
      ChartGesture localChartGesture3 = new ChartGesture("X_ZOOM", 2);
      X_ZOOM = localChartGesture3;
      ChartGesture localChartGesture4 = new ChartGesture("Y_ZOOM", 3);
      Y_ZOOM = localChartGesture4;
      ChartGesture localChartGesture5 = new ChartGesture("PINCH_ZOOM", 4);
      PINCH_ZOOM = localChartGesture5;
      ChartGesture localChartGesture6 = new ChartGesture("ROTATE", 5);
      ROTATE = localChartGesture6;
      ChartGesture localChartGesture7 = new ChartGesture("SINGLE_TAP", 6);
      SINGLE_TAP = localChartGesture7;
      ChartGesture localChartGesture8 = new ChartGesture("DOUBLE_TAP", 7);
      DOUBLE_TAP = localChartGesture8;
      ChartGesture localChartGesture9 = new ChartGesture("LONG_PRESS", 8);
      LONG_PRESS = localChartGesture9;
      ChartGesture localChartGesture10 = new ChartGesture("FLING", 9);
      FLING = localChartGesture10;
      $VALUES = new ChartGesture[] { localChartGesture1, localChartGesture2, localChartGesture3, localChartGesture4, localChartGesture5, localChartGesture6, localChartGesture7, localChartGesture8, localChartGesture9, localChartGesture10 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\listener\ChartTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
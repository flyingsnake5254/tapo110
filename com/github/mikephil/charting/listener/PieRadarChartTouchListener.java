package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

public class PieRadarChartTouchListener
  extends ChartTouchListener<PieRadarChartBase<?>>
{
  private ArrayList<AngularVelocitySample> _velocitySamples = new ArrayList();
  private float mDecelerationAngularVelocity = 0.0F;
  private long mDecelerationLastTime = 0L;
  private float mStartAngle = 0.0F;
  private MPPointF mTouchStartPoint = MPPointF.getInstance(0.0F, 0.0F);
  
  public PieRadarChartTouchListener(PieRadarChartBase<?> paramPieRadarChartBase)
  {
    super(paramPieRadarChartBase);
  }
  
  private float calculateVelocity()
  {
    if (this._velocitySamples.isEmpty()) {
      return 0.0F;
    }
    Object localObject = this._velocitySamples;
    int i = 0;
    AngularVelocitySample localAngularVelocitySample1 = (AngularVelocitySample)((ArrayList)localObject).get(0);
    localObject = this._velocitySamples;
    AngularVelocitySample localAngularVelocitySample2 = (AngularVelocitySample)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    int j = this._velocitySamples.size() - 1;
    localObject = localAngularVelocitySample1;
    while (j >= 0)
    {
      localObject = (AngularVelocitySample)this._velocitySamples.get(j);
      if (((AngularVelocitySample)localObject).angle != localAngularVelocitySample2.angle) {
        break;
      }
      j--;
    }
    float f1 = (float)(localAngularVelocitySample2.time - localAngularVelocitySample1.time) / 1000.0F;
    float f2 = f1;
    if (f1 == 0.0F) {
      f2 = 0.1F;
    }
    f1 = localAngularVelocitySample2.angle;
    float f3 = ((AngularVelocitySample)localObject).angle;
    j = i;
    if (f1 >= f3) {
      j = 1;
    }
    i = j;
    if (Math.abs(f1 - f3) > 270.0D) {
      i = j ^ 0x1;
    }
    f1 = localAngularVelocitySample2.angle;
    f3 = localAngularVelocitySample1.angle;
    if (f1 - f3 > 180.0D) {
      localAngularVelocitySample1.angle = ((float)(f3 + 360.0D));
    } else if (f3 - f1 > 180.0D) {
      localAngularVelocitySample2.angle = ((float)(f1 + 360.0D));
    }
    f1 = Math.abs((localAngularVelocitySample2.angle - localAngularVelocitySample1.angle) / f2);
    f2 = f1;
    if (i == 0) {
      f2 = -f1;
    }
    return f2;
  }
  
  private void resetVelocity()
  {
    this._velocitySamples.clear();
  }
  
  private void sampleVelocity(float paramFloat1, float paramFloat2)
  {
    long l = AnimationUtils.currentAnimationTimeMillis();
    this._velocitySamples.add(new AngularVelocitySample(l, ((PieRadarChartBase)this.mChart).getAngleForPoint(paramFloat1, paramFloat2)));
    for (int i = this._velocitySamples.size(); (i - 2 > 0) && (l - ((AngularVelocitySample)this._velocitySamples.get(0)).time > 1000L); i--) {
      this._velocitySamples.remove(0);
    }
  }
  
  public void computeScroll()
  {
    if (this.mDecelerationAngularVelocity == 0.0F) {
      return;
    }
    long l = AnimationUtils.currentAnimationTimeMillis();
    this.mDecelerationAngularVelocity *= ((PieRadarChartBase)this.mChart).getDragDecelerationFrictionCoef();
    float f = (float)(l - this.mDecelerationLastTime) / 1000.0F;
    Chart localChart = this.mChart;
    ((PieRadarChartBase)localChart).setRotationAngle(((PieRadarChartBase)localChart).getRotationAngle() + this.mDecelerationAngularVelocity * f);
    this.mDecelerationLastTime = l;
    if (Math.abs(this.mDecelerationAngularVelocity) >= 0.001D) {
      Utils.postInvalidateOnAnimation(this.mChart);
    } else {
      stopDeceleration();
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
    OnChartGestureListener localOnChartGestureListener = ((PieRadarChartBase)this.mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartLongPressed(paramMotionEvent);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
    OnChartGestureListener localOnChartGestureListener = ((PieRadarChartBase)this.mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartSingleTapped(paramMotionEvent);
    }
    if (!((PieRadarChartBase)this.mChart).isHighlightPerTapEnabled()) {
      return false;
    }
    performHighlight(((PieRadarChartBase)this.mChart).getHighlightByTouchPoint(paramMotionEvent.getX(), paramMotionEvent.getY()), paramMotionEvent);
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    if (((PieRadarChartBase)this.mChart).isRotationEnabled())
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            if (((PieRadarChartBase)this.mChart).isDragDecelerationEnabled()) {
              sampleVelocity(f1, f2);
            }
            if (this.mTouchMode == 0)
            {
              paramView = this.mTouchStartPoint;
              if (ChartTouchListener.distance(f1, paramView.x, f2, paramView.y) > Utils.convertDpToPixel(8.0F))
              {
                this.mLastGesture = ChartTouchListener.ChartGesture.ROTATE;
                this.mTouchMode = 6;
                ((PieRadarChartBase)this.mChart).disableScroll();
                break label170;
              }
            }
            if (this.mTouchMode == 6)
            {
              updateGestureRotation(f1, f2);
              ((PieRadarChartBase)this.mChart).invalidate();
            }
            label170:
            endAction(paramMotionEvent);
          }
        }
        else
        {
          if (((PieRadarChartBase)this.mChart).isDragDecelerationEnabled())
          {
            stopDeceleration();
            sampleVelocity(f1, f2);
            f1 = calculateVelocity();
            this.mDecelerationAngularVelocity = f1;
            if (f1 != 0.0F)
            {
              this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
              Utils.postInvalidateOnAnimation(this.mChart);
            }
          }
          ((PieRadarChartBase)this.mChart).enableScroll();
          this.mTouchMode = 0;
          endAction(paramMotionEvent);
        }
      }
      else
      {
        startAction(paramMotionEvent);
        stopDeceleration();
        resetVelocity();
        if (((PieRadarChartBase)this.mChart).isDragDecelerationEnabled()) {
          sampleVelocity(f1, f2);
        }
        setGestureStartAngle(f1, f2);
        paramView = this.mTouchStartPoint;
        paramView.x = f1;
        paramView.y = f2;
      }
    }
    return true;
  }
  
  public void setGestureStartAngle(float paramFloat1, float paramFloat2)
  {
    this.mStartAngle = (((PieRadarChartBase)this.mChart).getAngleForPoint(paramFloat1, paramFloat2) - ((PieRadarChartBase)this.mChart).getRawRotationAngle());
  }
  
  public void stopDeceleration()
  {
    this.mDecelerationAngularVelocity = 0.0F;
  }
  
  public void updateGestureRotation(float paramFloat1, float paramFloat2)
  {
    Chart localChart = this.mChart;
    ((PieRadarChartBase)localChart).setRotationAngle(((PieRadarChartBase)localChart).getAngleForPoint(paramFloat1, paramFloat2) - this.mStartAngle);
  }
  
  private class AngularVelocitySample
  {
    public float angle;
    public long time;
    
    public AngularVelocitySample(long paramLong, float paramFloat)
    {
      this.time = paramLong;
      this.angle = paramFloat;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\listener\PieRadarChartTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
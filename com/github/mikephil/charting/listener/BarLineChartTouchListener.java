package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarLineChartTouchListener
  extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>>
{
  private IDataSet mClosestDataSetToTouch;
  private MPPointF mDecelerationCurrentPoint = MPPointF.getInstance(0.0F, 0.0F);
  private long mDecelerationLastTime = 0L;
  private MPPointF mDecelerationVelocity = MPPointF.getInstance(0.0F, 0.0F);
  private float mDragTriggerDist;
  private Matrix mMatrix = new Matrix();
  private float mMinScalePointerDistance;
  private float mSavedDist = 1.0F;
  private Matrix mSavedMatrix = new Matrix();
  private float mSavedXDist = 1.0F;
  private float mSavedYDist = 1.0F;
  private MPPointF mTouchPointCenter = MPPointF.getInstance(0.0F, 0.0F);
  private MPPointF mTouchStartPoint = MPPointF.getInstance(0.0F, 0.0F);
  private VelocityTracker mVelocityTracker;
  
  public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> paramBarLineChartBase, Matrix paramMatrix, float paramFloat)
  {
    super(paramBarLineChartBase);
    this.mMatrix = paramMatrix;
    this.mDragTriggerDist = Utils.convertDpToPixel(paramFloat);
    this.mMinScalePointerDistance = Utils.convertDpToPixel(3.5F);
  }
  
  private static float getXDist(MotionEvent paramMotionEvent)
  {
    return Math.abs(paramMotionEvent.getX(0) - paramMotionEvent.getX(1));
  }
  
  private static float getYDist(MotionEvent paramMotionEvent)
  {
    return Math.abs(paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
  }
  
  private boolean inverted()
  {
    if ((this.mClosestDataSetToTouch != null) || (!((BarLineChartBase)this.mChart).isAnyAxisInverted()))
    {
      IDataSet localIDataSet = this.mClosestDataSetToTouch;
      if ((localIDataSet == null) || (!((BarLineChartBase)this.mChart).isInverted(localIDataSet.getAxisDependency()))) {}
    }
    else
    {
      return true;
    }
    boolean bool = false;
    return bool;
  }
  
  private static void midPoint(MPPointF paramMPPointF, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getX(1);
    float f3 = paramMotionEvent.getY(0);
    float f4 = paramMotionEvent.getY(1);
    paramMPPointF.x = ((f1 + f2) / 2.0F);
    paramMPPointF.y = ((f3 + f4) / 2.0F);
  }
  
  private void performDrag(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
    this.mMatrix.set(this.mSavedMatrix);
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (inverted()) {
      if ((this.mChart instanceof HorizontalBarChart))
      {
        f1 = -paramFloat1;
        f2 = paramFloat2;
      }
      else
      {
        f2 = -paramFloat2;
        f1 = paramFloat1;
      }
    }
    this.mMatrix.postTranslate(f1, f2);
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartTranslate(paramMotionEvent, f1, f2);
    }
  }
  
  private void performHighlightDrag(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = ((BarLineChartBase)this.mChart).getHighlightByTouchPoint(paramMotionEvent.getX(), paramMotionEvent.getY());
    if ((paramMotionEvent != null) && (!paramMotionEvent.equalTo(this.mLastHighlighted)))
    {
      this.mLastHighlighted = paramMotionEvent;
      ((BarLineChartBase)this.mChart).highlightValue(paramMotionEvent, true);
    }
  }
  
  private void performZoom(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() >= 2)
    {
      OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
      float f1 = spacing(paramMotionEvent);
      if (f1 > this.mMinScalePointerDistance)
      {
        MPPointF localMPPointF = this.mTouchPointCenter;
        localMPPointF = getTrans(localMPPointF.x, localMPPointF.y);
        ViewPortHandler localViewPortHandler = ((BarLineChartBase)this.mChart).getViewPortHandler();
        int i = this.mTouchMode;
        int j = 1;
        int k = 1;
        int m = 1;
        float f2 = 1.0F;
        boolean bool1;
        if (i == 4)
        {
          this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
          f1 /= this.mSavedDist;
          if (f1 >= 1.0F) {
            m = 0;
          }
          if (m != 0) {
            bool1 = localViewPortHandler.canZoomOutMoreX();
          } else {
            bool1 = localViewPortHandler.canZoomInMoreX();
          }
          boolean bool2;
          if (m != 0) {
            bool2 = localViewPortHandler.canZoomOutMoreY();
          } else {
            bool2 = localViewPortHandler.canZoomInMoreY();
          }
          float f3;
          if (((BarLineChartBase)this.mChart).isScaleXEnabled()) {
            f3 = f1;
          } else {
            f3 = 1.0F;
          }
          if (((BarLineChartBase)this.mChart).isScaleYEnabled()) {
            f2 = f1;
          }
          if ((bool2) || (bool1))
          {
            this.mMatrix.set(this.mSavedMatrix);
            this.mMatrix.postScale(f3, f2, localMPPointF.x, localMPPointF.y);
            if (localOnChartGestureListener != null) {
              localOnChartGestureListener.onChartScale(paramMotionEvent, f3, f2);
            }
          }
        }
        else if ((i == 2) && (((BarLineChartBase)this.mChart).isScaleXEnabled()))
        {
          this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
          f1 = getXDist(paramMotionEvent) / this.mSavedXDist;
          if (f1 < 1.0F) {
            m = j;
          } else {
            m = 0;
          }
          if (m != 0) {
            bool1 = localViewPortHandler.canZoomOutMoreX();
          } else {
            bool1 = localViewPortHandler.canZoomInMoreX();
          }
          if (bool1)
          {
            this.mMatrix.set(this.mSavedMatrix);
            this.mMatrix.postScale(f1, 1.0F, localMPPointF.x, localMPPointF.y);
            if (localOnChartGestureListener != null) {
              localOnChartGestureListener.onChartScale(paramMotionEvent, f1, 1.0F);
            }
          }
        }
        else if ((this.mTouchMode == 3) && (((BarLineChartBase)this.mChart).isScaleYEnabled()))
        {
          this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
          f1 = getYDist(paramMotionEvent) / this.mSavedYDist;
          if (f1 < 1.0F) {
            m = k;
          } else {
            m = 0;
          }
          if (m != 0) {
            bool1 = localViewPortHandler.canZoomOutMoreY();
          } else {
            bool1 = localViewPortHandler.canZoomInMoreY();
          }
          if (bool1)
          {
            this.mMatrix.set(this.mSavedMatrix);
            this.mMatrix.postScale(1.0F, f1, localMPPointF.x, localMPPointF.y);
            if (localOnChartGestureListener != null) {
              localOnChartGestureListener.onChartScale(paramMotionEvent, 1.0F, f1);
            }
          }
        }
        MPPointF.recycleInstance(localMPPointF);
      }
    }
  }
  
  private void saveTouchStart(MotionEvent paramMotionEvent)
  {
    this.mSavedMatrix.set(this.mMatrix);
    this.mTouchStartPoint.x = paramMotionEvent.getX();
    this.mTouchStartPoint.y = paramMotionEvent.getY();
    this.mClosestDataSetToTouch = ((BarLineChartBase)this.mChart).getDataSetByTouchPoint(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  private static float spacing(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public void computeScroll()
  {
    Object localObject = this.mDecelerationVelocity;
    float f1 = ((MPPointF)localObject).x;
    float f2 = 0.0F;
    if ((f1 == 0.0F) && (((MPPointF)localObject).y == 0.0F)) {
      return;
    }
    long l = AnimationUtils.currentAnimationTimeMillis();
    localObject = this.mDecelerationVelocity;
    ((MPPointF)localObject).x *= ((BarLineChartBase)this.mChart).getDragDecelerationFrictionCoef();
    localObject = this.mDecelerationVelocity;
    ((MPPointF)localObject).y *= ((BarLineChartBase)this.mChart).getDragDecelerationFrictionCoef();
    float f3 = (float)(l - this.mDecelerationLastTime) / 1000.0F;
    localObject = this.mDecelerationVelocity;
    float f4 = ((MPPointF)localObject).x;
    f1 = ((MPPointF)localObject).y;
    localObject = this.mDecelerationCurrentPoint;
    f4 = ((MPPointF)localObject).x + f4 * f3;
    ((MPPointF)localObject).x = f4;
    f1 = ((MPPointF)localObject).y + f1 * f3;
    ((MPPointF)localObject).y = f1;
    localObject = MotionEvent.obtain(l, l, 2, f4, f1, 0);
    if (((BarLineChartBase)this.mChart).isDragXEnabled()) {
      f1 = this.mDecelerationCurrentPoint.x - this.mTouchStartPoint.x;
    } else {
      f1 = 0.0F;
    }
    if (((BarLineChartBase)this.mChart).isDragYEnabled()) {
      f2 = this.mDecelerationCurrentPoint.y - this.mTouchStartPoint.y;
    }
    performDrag((MotionEvent)localObject, f1, f2);
    ((MotionEvent)localObject).recycle();
    this.mMatrix = ((BarLineChartBase)this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
    this.mDecelerationLastTime = l;
    if ((Math.abs(this.mDecelerationVelocity.x) < 0.01D) && (Math.abs(this.mDecelerationVelocity.y) < 0.01D))
    {
      ((BarLineChartBase)this.mChart).calculateOffsets();
      ((BarLineChartBase)this.mChart).postInvalidate();
      stopDeceleration();
    }
    else
    {
      Utils.postInvalidateOnAnimation(this.mChart);
    }
  }
  
  public Matrix getMatrix()
  {
    return this.mMatrix;
  }
  
  public MPPointF getTrans(float paramFloat1, float paramFloat2)
  {
    ViewPortHandler localViewPortHandler = ((BarLineChartBase)this.mChart).getViewPortHandler();
    float f = localViewPortHandler.offsetLeft();
    if (inverted()) {
      paramFloat2 = -(paramFloat2 - localViewPortHandler.offsetTop());
    } else {
      paramFloat2 = -(((BarLineChartBase)this.mChart).getMeasuredHeight() - paramFloat2 - localViewPortHandler.offsetBottom());
    }
    return MPPointF.getInstance(paramFloat1 - f, paramFloat2);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
    Object localObject1 = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
    if (localObject1 != null) {
      ((OnChartGestureListener)localObject1).onChartDoubleTapped(paramMotionEvent);
    }
    if ((((BarLineChartBase)this.mChart).isDoubleTapToZoomEnabled()) && (((BarLineScatterCandleBubbleData)((BarLineChartBase)this.mChart).getData()).getEntryCount() > 0))
    {
      localObject1 = getTrans(paramMotionEvent.getX(), paramMotionEvent.getY());
      Object localObject2 = this.mChart;
      BarLineChartBase localBarLineChartBase = (BarLineChartBase)localObject2;
      boolean bool = ((BarLineChartBase)localObject2).isScaleXEnabled();
      float f1 = 1.4F;
      float f2;
      if (bool) {
        f2 = 1.4F;
      } else {
        f2 = 1.0F;
      }
      if (!((BarLineChartBase)this.mChart).isScaleYEnabled()) {
        f1 = 1.0F;
      }
      localBarLineChartBase.zoom(f2, f1, ((MPPointF)localObject1).x, ((MPPointF)localObject1).y);
      if (((BarLineChartBase)this.mChart).isLogEnabled())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Double-Tap, Zooming In, x: ");
        ((StringBuilder)localObject2).append(((MPPointF)localObject1).x);
        ((StringBuilder)localObject2).append(", y: ");
        ((StringBuilder)localObject2).append(((MPPointF)localObject1).y);
        Log.i("BarlineChartTouch", ((StringBuilder)localObject2).toString());
      }
      MPPointF.recycleInstance((MPPointF)localObject1);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartLongPressed(paramMotionEvent);
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)this.mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartSingleTapped(paramMotionEvent);
    }
    if (!((BarLineChartBase)this.mChart).isHighlightPerTapEnabled()) {
      return false;
    }
    performHighlight(((BarLineChartBase)this.mChart).getHighlightByTouchPoint(paramMotionEvent.getX(), paramMotionEvent.getY()), paramMotionEvent);
    return super.onSingleTapUp(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    int j = 3;
    if (i == 3)
    {
      paramView = this.mVelocityTracker;
      if (paramView != null)
      {
        paramView.recycle();
        this.mVelocityTracker = null;
      }
    }
    if (this.mTouchMode == 0) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    if ((!((BarLineChartBase)this.mChart).isDragEnabled()) && (!((BarLineChartBase)this.mChart).isScaleXEnabled()) && (!((BarLineChartBase)this.mChart).isScaleYEnabled())) {
      return true;
    }
    int k = paramMotionEvent.getAction() & 0xFF;
    if (k != 0)
    {
      i = 0;
      float f1;
      float f2;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 5)
            {
              if (k == 6)
              {
                Utils.velocityTrackerPointerUpCleanUpIfNecessary(paramMotionEvent, this.mVelocityTracker);
                this.mTouchMode = 5;
              }
            }
            else if (paramMotionEvent.getPointerCount() >= 2)
            {
              ((BarLineChartBase)this.mChart).disableScroll();
              saveTouchStart(paramMotionEvent);
              this.mSavedXDist = getXDist(paramMotionEvent);
              this.mSavedYDist = getYDist(paramMotionEvent);
              f1 = spacing(paramMotionEvent);
              this.mSavedDist = f1;
              if (f1 > 10.0F) {
                if (((BarLineChartBase)this.mChart).isPinchZoomEnabled())
                {
                  this.mTouchMode = 4;
                }
                else if (((BarLineChartBase)this.mChart).isScaleXEnabled() != ((BarLineChartBase)this.mChart).isScaleYEnabled())
                {
                  if (((BarLineChartBase)this.mChart).isScaleXEnabled()) {
                    j = 2;
                  }
                  this.mTouchMode = j;
                }
                else
                {
                  if (this.mSavedXDist > this.mSavedYDist) {
                    j = 2;
                  }
                  this.mTouchMode = j;
                }
              }
              midPoint(this.mTouchPointCenter, paramMotionEvent);
            }
          }
          else
          {
            this.mTouchMode = 0;
            endAction(paramMotionEvent);
          }
        }
        else
        {
          j = this.mTouchMode;
          if (j == 1)
          {
            ((BarLineChartBase)this.mChart).disableScroll();
            boolean bool = ((BarLineChartBase)this.mChart).isDragXEnabled();
            f2 = 0.0F;
            if (bool) {
              f1 = paramMotionEvent.getX() - this.mTouchStartPoint.x;
            } else {
              f1 = 0.0F;
            }
            if (((BarLineChartBase)this.mChart).isDragYEnabled()) {
              f2 = paramMotionEvent.getY() - this.mTouchStartPoint.y;
            }
            performDrag(paramMotionEvent, f1, f2);
          }
          else if ((j != 2) && (j != 3) && (j != 4))
          {
            if ((j == 0) && (Math.abs(ChartTouchListener.distance(paramMotionEvent.getX(), this.mTouchStartPoint.x, paramMotionEvent.getY(), this.mTouchStartPoint.y)) > this.mDragTriggerDist) && (((BarLineChartBase)this.mChart).isDragEnabled()))
            {
              if (((BarLineChartBase)this.mChart).isFullyZoomedOut())
              {
                j = i;
                if (((BarLineChartBase)this.mChart).hasNoDragOffset()) {}
              }
              else
              {
                j = 1;
              }
              if (j != 0)
              {
                f2 = Math.abs(paramMotionEvent.getX() - this.mTouchStartPoint.x);
                f1 = Math.abs(paramMotionEvent.getY() - this.mTouchStartPoint.y);
                if (((((BarLineChartBase)this.mChart).isDragXEnabled()) || (f1 >= f2)) && ((((BarLineChartBase)this.mChart).isDragYEnabled()) || (f1 <= f2)))
                {
                  this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                  this.mTouchMode = 1;
                }
              }
              else if (((BarLineChartBase)this.mChart).isHighlightPerDragEnabled())
              {
                this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                if (((BarLineChartBase)this.mChart).isHighlightPerDragEnabled()) {
                  performHighlightDrag(paramMotionEvent);
                }
              }
            }
          }
          else
          {
            ((BarLineChartBase)this.mChart).disableScroll();
            if ((((BarLineChartBase)this.mChart).isScaleXEnabled()) || (((BarLineChartBase)this.mChart).isScaleYEnabled())) {
              performZoom(paramMotionEvent);
            }
          }
        }
      }
      else
      {
        paramView = this.mVelocityTracker;
        j = paramMotionEvent.getPointerId(0);
        paramView.computeCurrentVelocity(1000, Utils.getMaximumFlingVelocity());
        f1 = paramView.getYVelocity(j);
        f2 = paramView.getXVelocity(j);
        if (((Math.abs(f2) > Utils.getMinimumFlingVelocity()) || (Math.abs(f1) > Utils.getMinimumFlingVelocity())) && (this.mTouchMode == 1) && (((BarLineChartBase)this.mChart).isDragDecelerationEnabled()))
        {
          stopDeceleration();
          this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
          this.mDecelerationCurrentPoint.x = paramMotionEvent.getX();
          this.mDecelerationCurrentPoint.y = paramMotionEvent.getY();
          paramView = this.mDecelerationVelocity;
          paramView.x = f2;
          paramView.y = f1;
          Utils.postInvalidateOnAnimation(this.mChart);
        }
        j = this.mTouchMode;
        if ((j == 2) || (j == 3) || (j == 4) || (j == 5))
        {
          ((BarLineChartBase)this.mChart).calculateOffsets();
          ((BarLineChartBase)this.mChart).postInvalidate();
        }
        this.mTouchMode = 0;
        ((BarLineChartBase)this.mChart).enableScroll();
        paramView = this.mVelocityTracker;
        if (paramView != null)
        {
          paramView.recycle();
          this.mVelocityTracker = null;
        }
        endAction(paramMotionEvent);
      }
    }
    else
    {
      startAction(paramMotionEvent);
      stopDeceleration();
      saveTouchStart(paramMotionEvent);
    }
    this.mMatrix = ((BarLineChartBase)this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
    return true;
  }
  
  public void setDragTriggerDist(float paramFloat)
  {
    this.mDragTriggerDist = Utils.convertDpToPixel(paramFloat);
  }
  
  public void stopDeceleration()
  {
    MPPointF localMPPointF = this.mDecelerationVelocity;
    localMPPointF.x = 0.0F;
    localMPPointF.y = 0.0F;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\listener\BarLineChartTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
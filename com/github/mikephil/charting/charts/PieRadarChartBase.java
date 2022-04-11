package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.github.mikephil.charting.animation.Easing.EasingFunction;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend.LegendVerticalAlignment;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>>
  extends Chart<T>
{
  protected float mMinOffset = 0.0F;
  private float mRawRotationAngle = 270.0F;
  protected boolean mRotateEnabled = true;
  private float mRotationAngle = 270.0F;
  
  public PieRadarChartBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public PieRadarChartBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PieRadarChartBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void calcMinMax() {}
  
  public void calculateOffsets()
  {
    Object localObject = this.mLegend;
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f5 = 0.0F;
    if ((localObject != null) && (((ComponentBase)localObject).isEnabled()) && (!this.mLegend.isDrawInsideEnabled()))
    {
      f6 = Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent());
      int i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mLegend.getOrientation().ordinal()];
      if (i != 1) {
        if (i != 2)
        {
          f1 = f5;
        }
        else if (this.mLegend.getVerticalAlignment() != Legend.LegendVerticalAlignment.TOP)
        {
          f1 = f5;
          if (this.mLegend.getVerticalAlignment() != Legend.LegendVerticalAlignment.BOTTOM) {}
        }
        else
        {
          f6 = getRequiredLegendOffset();
          f1 = Math.min(this.mLegend.mNeededHeight + f6, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
          i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
          f6 = f1;
          if (i == 1) {
            break label224;
          }
          f6 = f1;
          if (i == 2) {
            break label212;
          }
          f1 = f5;
        }
      }
      for (;;)
      {
        f6 = 0.0F;
        label204:
        f3 = 0.0F;
        for (;;)
        {
          f2 = 0.0F;
          break;
          label212:
          f3 = f6;
          f6 = 0.0F;
          f1 = f2;
        }
        for (;;)
        {
          label224:
          f2 = f6;
          f6 = 0.0F;
          f5 = 0.0F;
          f1 = f3;
          f3 = f5;
          break label638;
          if ((this.mLegend.getHorizontalAlignment() != Legend.LegendHorizontalAlignment.LEFT) && (this.mLegend.getHorizontalAlignment() != Legend.LegendHorizontalAlignment.RIGHT))
          {
            f6 = 0.0F;
          }
          else if (this.mLegend.getVerticalAlignment() == Legend.LegendVerticalAlignment.CENTER)
          {
            f6 += Utils.convertDpToPixel(13.0F);
          }
          else
          {
            f4 = f6 + Utils.convertDpToPixel(8.0F);
            localObject = this.mLegend;
            f7 = ((Legend)localObject).mNeededHeight;
            f8 = ((Legend)localObject).mTextHeightMax;
            MPPointF localMPPointF = getCenter();
            if (this.mLegend.getHorizontalAlignment() == Legend.LegendHorizontalAlignment.RIGHT) {
              f6 = getWidth() - f4 + 15.0F;
            } else {
              f6 = f4 - 15.0F;
            }
            f8 = f7 + f8 + 15.0F;
            f7 = distanceToCenter(f6, f8);
            localObject = getPosition(localMPPointF, getRadius(), getAngleForPoint(f6, f8));
            float f9 = distanceToCenter(((MPPointF)localObject).x, ((MPPointF)localObject).y);
            f6 = Utils.convertDpToPixel(5.0F);
            if ((f8 >= localMPPointF.y) && (getHeight() - f4 > getWidth())) {
              f6 = f4;
            } else if (f7 < f9) {
              f6 += f9 - f7;
            } else {
              f6 = 0.0F;
            }
            MPPointF.recycleInstance(localMPPointF);
            MPPointF.recycleInstance((MPPointF)localObject);
          }
          i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.getHorizontalAlignment().ordinal()];
          if (i == 1) {
            break label632;
          }
          if (i == 2) {
            break label204;
          }
          if (i == 3)
          {
            i = 2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
            if (i == 1) {
              break label602;
            }
            if (i == 2) {}
          }
          else
          {
            f1 = f5;
            break;
          }
          f6 = Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
          break label212;
          label602:
          f6 = Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
        }
        label632:
        f1 = f6;
      }
      label638:
      f5 = f1 + getRequiredBaseOffset();
      f1 = f6 + getRequiredBaseOffset();
      f4 = f2 + getRequiredBaseOffset();
      f6 = f3 + getRequiredBaseOffset();
      f2 = f5;
      f3 = f4;
    }
    else
    {
      f1 = 0.0F;
      f6 = 0.0F;
      f3 = 0.0F;
      f2 = f4;
    }
    f4 = Utils.convertDpToPixel(this.mMinOffset);
    f5 = f4;
    if ((this instanceof RadarChart))
    {
      localObject = getXAxis();
      f5 = f4;
      if (((ComponentBase)localObject).isEnabled())
      {
        f5 = f4;
        if (((AxisBase)localObject).isDrawLabelsEnabled()) {
          f5 = Math.max(f4, ((XAxis)localObject).mLabelRotatedWidth);
        }
      }
    }
    float f7 = getExtraTopOffset();
    float f8 = getExtraRightOffset();
    f4 = getExtraBottomOffset();
    f2 = Math.max(f5, f2 + getExtraLeftOffset());
    f3 = Math.max(f5, f3 + f7);
    f1 = Math.max(f5, f1 + f8);
    float f6 = Math.max(f5, Math.max(getRequiredBaseOffset(), f6 + f4));
    this.mViewPortHandler.restrainViewPort(f2, f3, f1, f6);
    if (this.mLogEnabled)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("offsetLeft: ");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append(", offsetTop: ");
      ((StringBuilder)localObject).append(f3);
      ((StringBuilder)localObject).append(", offsetRight: ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", offsetBottom: ");
      ((StringBuilder)localObject).append(f6);
      Log.i("MPAndroidChart", ((StringBuilder)localObject).toString());
    }
  }
  
  public void computeScroll()
  {
    ChartTouchListener localChartTouchListener = this.mChartTouchListener;
    if ((localChartTouchListener instanceof PieRadarChartTouchListener)) {
      ((PieRadarChartTouchListener)localChartTouchListener).computeScroll();
    }
  }
  
  public float distanceToCenter(float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = getCenterOffsets();
    float f = localMPPointF.x;
    if (paramFloat1 > f) {
      paramFloat1 -= f;
    } else {
      paramFloat1 = f - paramFloat1;
    }
    f = localMPPointF.y;
    if (paramFloat2 > f) {
      paramFloat2 -= f;
    } else {
      paramFloat2 = f - paramFloat2;
    }
    paramFloat1 = (float)Math.sqrt(Math.pow(paramFloat1, 2.0D) + Math.pow(paramFloat2, 2.0D));
    MPPointF.recycleInstance(localMPPointF);
    return paramFloat1;
  }
  
  public float getAngleForPoint(float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = getCenterOffsets();
    double d1 = paramFloat1 - localMPPointF.x;
    double d2 = paramFloat2 - localMPPointF.y;
    float f = (float)Math.toDegrees(Math.acos(d2 / Math.sqrt(d1 * d1 + d2 * d2)));
    paramFloat2 = f;
    if (paramFloat1 > localMPPointF.x) {
      paramFloat2 = 360.0F - f;
    }
    paramFloat2 += 90.0F;
    paramFloat1 = paramFloat2;
    if (paramFloat2 > 360.0F) {
      paramFloat1 = paramFloat2 - 360.0F;
    }
    MPPointF.recycleInstance(localMPPointF);
    return paramFloat1;
  }
  
  public float getDiameter()
  {
    RectF localRectF = this.mViewPortHandler.getContentRect();
    localRectF.left += getExtraLeftOffset();
    localRectF.top += getExtraTopOffset();
    localRectF.right -= getExtraRightOffset();
    localRectF.bottom -= getExtraBottomOffset();
    return Math.min(localRectF.width(), localRectF.height());
  }
  
  public abstract int getIndexForAngle(float paramFloat);
  
  public int getMaxVisibleCount()
  {
    return this.mData.getEntryCount();
  }
  
  public float getMinOffset()
  {
    return this.mMinOffset;
  }
  
  public MPPointF getPosition(MPPointF paramMPPointF, float paramFloat1, float paramFloat2)
  {
    MPPointF localMPPointF = MPPointF.getInstance(0.0F, 0.0F);
    getPosition(paramMPPointF, paramFloat1, paramFloat2, localMPPointF);
    return localMPPointF;
  }
  
  public void getPosition(MPPointF paramMPPointF1, float paramFloat1, float paramFloat2, MPPointF paramMPPointF2)
  {
    double d1 = paramMPPointF1.x;
    double d2 = paramFloat1;
    double d3 = paramFloat2;
    paramMPPointF2.x = ((float)(d1 + Math.cos(Math.toRadians(d3)) * d2));
    paramMPPointF2.y = ((float)(paramMPPointF1.y + d2 * Math.sin(Math.toRadians(d3))));
  }
  
  public abstract float getRadius();
  
  public float getRawRotationAngle()
  {
    return this.mRawRotationAngle;
  }
  
  protected abstract float getRequiredBaseOffset();
  
  protected abstract float getRequiredLegendOffset();
  
  public float getRotationAngle()
  {
    return this.mRotationAngle;
  }
  
  public float getYChartMax()
  {
    return 0.0F;
  }
  
  public float getYChartMin()
  {
    return 0.0F;
  }
  
  protected void init()
  {
    super.init();
    this.mChartTouchListener = new PieRadarChartTouchListener(this);
  }
  
  public boolean isRotationEnabled()
  {
    return this.mRotateEnabled;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.mData == null) {
      return;
    }
    calcMinMax();
    if (this.mLegend != null) {
      this.mLegendRenderer.computeLegend(this.mData);
    }
    calculateOffsets();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mTouchEnabled)
    {
      ChartTouchListener localChartTouchListener = this.mChartTouchListener;
      if (localChartTouchListener != null) {
        return localChartTouchListener.onTouch(this, paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMinOffset(float paramFloat)
  {
    this.mMinOffset = paramFloat;
  }
  
  public void setRotationAngle(float paramFloat)
  {
    this.mRawRotationAngle = paramFloat;
    this.mRotationAngle = Utils.getNormalizedAngle(paramFloat);
  }
  
  public void setRotationEnabled(boolean paramBoolean)
  {
    this.mRotateEnabled = paramBoolean;
  }
  
  @SuppressLint({"NewApi"})
  public void spin(int paramInt, float paramFloat1, float paramFloat2, Easing.EasingFunction paramEasingFunction)
  {
    setRotationAngle(paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "rotationAngle", new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(paramInt);
    localObjectAnimator.setInterpolator(paramEasingFunction);
    localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        PieRadarChartBase.this.postInvalidate();
      }
    });
    localObjectAnimator.start();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\PieRadarChartBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
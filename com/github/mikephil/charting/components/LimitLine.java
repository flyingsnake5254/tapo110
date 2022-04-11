package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.utils.Utils;

public class LimitLine
  extends ComponentBase
{
  private DashPathEffect mDashPathEffect = null;
  private String mLabel = "";
  private LimitLabelPosition mLabelPosition = LimitLabelPosition.RIGHT_TOP;
  private float mLimit = 0.0F;
  private int mLineColor = Color.rgb(237, 91, 91);
  private float mLineWidth = 2.0F;
  private Paint.Style mTextStyle = Paint.Style.FILL_AND_STROKE;
  
  public LimitLine(float paramFloat)
  {
    this.mLimit = paramFloat;
  }
  
  public LimitLine(float paramFloat, String paramString)
  {
    this.mLimit = paramFloat;
    this.mLabel = paramString;
  }
  
  public void disableDashedLine()
  {
    this.mDashPathEffect = null;
  }
  
  public void enableDashedLine(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mDashPathEffect = new DashPathEffect(new float[] { paramFloat1, paramFloat2 }, paramFloat3);
  }
  
  public DashPathEffect getDashPathEffect()
  {
    return this.mDashPathEffect;
  }
  
  public String getLabel()
  {
    return this.mLabel;
  }
  
  public LimitLabelPosition getLabelPosition()
  {
    return this.mLabelPosition;
  }
  
  public float getLimit()
  {
    return this.mLimit;
  }
  
  public int getLineColor()
  {
    return this.mLineColor;
  }
  
  public float getLineWidth()
  {
    return this.mLineWidth;
  }
  
  public Paint.Style getTextStyle()
  {
    return this.mTextStyle;
  }
  
  public boolean isDashedLineEnabled()
  {
    boolean bool;
    if (this.mDashPathEffect == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setLabel(String paramString)
  {
    this.mLabel = paramString;
  }
  
  public void setLabelPosition(LimitLabelPosition paramLimitLabelPosition)
  {
    this.mLabelPosition = paramLimitLabelPosition;
  }
  
  public void setLineColor(int paramInt)
  {
    this.mLineColor = paramInt;
  }
  
  public void setLineWidth(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.2F) {
      f = 0.2F;
    }
    paramFloat = f;
    if (f > 12.0F) {
      paramFloat = 12.0F;
    }
    this.mLineWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setTextStyle(Paint.Style paramStyle)
  {
    this.mTextStyle = paramStyle;
  }
  
  public static enum LimitLabelPosition
  {
    static
    {
      LimitLabelPosition localLimitLabelPosition1 = new LimitLabelPosition("LEFT_TOP", 0);
      LEFT_TOP = localLimitLabelPosition1;
      LimitLabelPosition localLimitLabelPosition2 = new LimitLabelPosition("LEFT_BOTTOM", 1);
      LEFT_BOTTOM = localLimitLabelPosition2;
      LimitLabelPosition localLimitLabelPosition3 = new LimitLabelPosition("RIGHT_TOP", 2);
      RIGHT_TOP = localLimitLabelPosition3;
      LimitLabelPosition localLimitLabelPosition4 = new LimitLabelPosition("RIGHT_BOTTOM", 3);
      RIGHT_BOTTOM = localLimitLabelPosition4;
      $VALUES = new LimitLabelPosition[] { localLimitLabelPosition1, localLimitLabelPosition2, localLimitLabelPosition3, localLimitLabelPosition4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\LimitLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
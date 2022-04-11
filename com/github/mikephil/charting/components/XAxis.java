package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

public class XAxis
  extends AxisBase
{
  private boolean mAvoidFirstLastClipping = false;
  public int mLabelHeight = 1;
  public int mLabelRotatedHeight = 1;
  public int mLabelRotatedWidth = 1;
  protected float mLabelRotationAngle = 0.0F;
  public int mLabelWidth = 1;
  private XAxisPosition mPosition = XAxisPosition.TOP;
  
  public XAxis()
  {
    this.mYOffset = Utils.convertDpToPixel(4.0F);
  }
  
  public float getLabelRotationAngle()
  {
    return this.mLabelRotationAngle;
  }
  
  public XAxisPosition getPosition()
  {
    return this.mPosition;
  }
  
  public boolean isAvoidFirstLastClippingEnabled()
  {
    return this.mAvoidFirstLastClipping;
  }
  
  public void setAvoidFirstLastClipping(boolean paramBoolean)
  {
    this.mAvoidFirstLastClipping = paramBoolean;
  }
  
  public void setLabelRotationAngle(float paramFloat)
  {
    this.mLabelRotationAngle = paramFloat;
  }
  
  public void setPosition(XAxisPosition paramXAxisPosition)
  {
    this.mPosition = paramXAxisPosition;
  }
  
  public static enum XAxisPosition
  {
    static
    {
      XAxisPosition localXAxisPosition1 = new XAxisPosition("TOP", 0);
      TOP = localXAxisPosition1;
      XAxisPosition localXAxisPosition2 = new XAxisPosition("BOTTOM", 1);
      BOTTOM = localXAxisPosition2;
      XAxisPosition localXAxisPosition3 = new XAxisPosition("BOTH_SIDED", 2);
      BOTH_SIDED = localXAxisPosition3;
      XAxisPosition localXAxisPosition4 = new XAxisPosition("TOP_INSIDE", 3);
      TOP_INSIDE = localXAxisPosition4;
      XAxisPosition localXAxisPosition5 = new XAxisPosition("BOTTOM_INSIDE", 4);
      BOTTOM_INSIDE = localXAxisPosition5;
      $VALUES = new XAxisPosition[] { localXAxisPosition1, localXAxisPosition2, localXAxisPosition3, localXAxisPosition4, localXAxisPosition5 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\components\XAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet
  extends DataSet<PieEntry>
  implements IPieDataSet
{
  private boolean mAutomaticallyDisableSliceSpacing;
  private float mShift = 18.0F;
  private float mSliceSpace = 0.0F;
  private boolean mUsingSliceColorAsValueLineColor;
  private int mValueLineColor;
  private float mValueLinePart1Length;
  private float mValueLinePart1OffsetPercentage;
  private float mValueLinePart2Length;
  private boolean mValueLineVariableLength;
  private float mValueLineWidth;
  private ValuePosition mXValuePosition;
  private ValuePosition mYValuePosition;
  
  public PieDataSet(List<PieEntry> paramList, String paramString)
  {
    super(paramList, paramString);
    paramList = ValuePosition.INSIDE_SLICE;
    this.mXValuePosition = paramList;
    this.mYValuePosition = paramList;
    this.mUsingSliceColorAsValueLineColor = false;
    this.mValueLineColor = -16777216;
    this.mValueLineWidth = 1.0F;
    this.mValueLinePart1OffsetPercentage = 75.0F;
    this.mValueLinePart1Length = 0.3F;
    this.mValueLinePart2Length = 0.4F;
    this.mValueLineVariableLength = true;
  }
  
  protected void calcMinMax(PieEntry paramPieEntry)
  {
    if (paramPieEntry == null) {
      return;
    }
    calcMinMaxY(paramPieEntry);
  }
  
  public DataSet<PieEntry> copy()
  {
    Object localObject = new ArrayList();
    for (int i = 0; i < this.mValues.size(); i++) {
      ((List)localObject).add(((PieEntry)this.mValues.get(i)).copy());
    }
    localObject = new PieDataSet((List)localObject, getLabel());
    copy((PieDataSet)localObject);
    return (DataSet<PieEntry>)localObject;
  }
  
  protected void copy(PieDataSet paramPieDataSet)
  {
    super.copy(paramPieDataSet);
  }
  
  public float getSelectionShift()
  {
    return this.mShift;
  }
  
  public float getSliceSpace()
  {
    return this.mSliceSpace;
  }
  
  public int getValueLineColor()
  {
    return this.mValueLineColor;
  }
  
  public float getValueLinePart1Length()
  {
    return this.mValueLinePart1Length;
  }
  
  public float getValueLinePart1OffsetPercentage()
  {
    return this.mValueLinePart1OffsetPercentage;
  }
  
  public float getValueLinePart2Length()
  {
    return this.mValueLinePart2Length;
  }
  
  public float getValueLineWidth()
  {
    return this.mValueLineWidth;
  }
  
  public ValuePosition getXValuePosition()
  {
    return this.mXValuePosition;
  }
  
  public ValuePosition getYValuePosition()
  {
    return this.mYValuePosition;
  }
  
  public boolean isAutomaticallyDisableSliceSpacingEnabled()
  {
    return this.mAutomaticallyDisableSliceSpacing;
  }
  
  public boolean isUsingSliceColorAsValueLineColor()
  {
    return this.mUsingSliceColorAsValueLineColor;
  }
  
  public boolean isValueLineVariableLength()
  {
    return this.mValueLineVariableLength;
  }
  
  public void setAutomaticallyDisableSliceSpacing(boolean paramBoolean)
  {
    this.mAutomaticallyDisableSliceSpacing = paramBoolean;
  }
  
  public void setSelectionShift(float paramFloat)
  {
    this.mShift = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setSliceSpace(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 20.0F) {
      f = 20.0F;
    }
    paramFloat = f;
    if (f < 0.0F) {
      paramFloat = 0.0F;
    }
    this.mSliceSpace = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setUsingSliceColorAsValueLineColor(boolean paramBoolean)
  {
    this.mUsingSliceColorAsValueLineColor = paramBoolean;
  }
  
  public void setValueLineColor(int paramInt)
  {
    this.mValueLineColor = paramInt;
  }
  
  public void setValueLinePart1Length(float paramFloat)
  {
    this.mValueLinePart1Length = paramFloat;
  }
  
  public void setValueLinePart1OffsetPercentage(float paramFloat)
  {
    this.mValueLinePart1OffsetPercentage = paramFloat;
  }
  
  public void setValueLinePart2Length(float paramFloat)
  {
    this.mValueLinePart2Length = paramFloat;
  }
  
  public void setValueLineVariableLength(boolean paramBoolean)
  {
    this.mValueLineVariableLength = paramBoolean;
  }
  
  public void setValueLineWidth(float paramFloat)
  {
    this.mValueLineWidth = paramFloat;
  }
  
  public void setXValuePosition(ValuePosition paramValuePosition)
  {
    this.mXValuePosition = paramValuePosition;
  }
  
  public void setYValuePosition(ValuePosition paramValuePosition)
  {
    this.mYValuePosition = paramValuePosition;
  }
  
  public static enum ValuePosition
  {
    static
    {
      ValuePosition localValuePosition1 = new ValuePosition("INSIDE_SLICE", 0);
      INSIDE_SLICE = localValuePosition1;
      ValuePosition localValuePosition2 = new ValuePosition("OUTSIDE_SLICE", 1);
      OUTSIDE_SLICE = localValuePosition2;
      $VALUES = new ValuePosition[] { localValuePosition1, localValuePosition2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\PieDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
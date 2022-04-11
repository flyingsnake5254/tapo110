package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

public class StackedValueFormatter
  extends ValueFormatter
{
  private boolean mDrawWholeStack;
  private DecimalFormat mFormat;
  private String mSuffix;
  
  public StackedValueFormatter(boolean paramBoolean, String paramString, int paramInt)
  {
    this.mDrawWholeStack = paramBoolean;
    this.mSuffix = paramString;
    paramString = new StringBuffer();
    for (int i = 0; i < paramInt; i++)
    {
      if (i == 0) {
        paramString.append(".");
      }
      paramString.append("0");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("###,###,###,##0");
    localStringBuilder.append(paramString.toString());
    this.mFormat = new DecimalFormat(localStringBuilder.toString());
  }
  
  public String getBarStackedLabel(float paramFloat, BarEntry paramBarEntry)
  {
    if (!this.mDrawWholeStack)
    {
      Object localObject = paramBarEntry.getYVals();
      if (localObject != null)
      {
        if (localObject[(localObject.length - 1)] == paramFloat)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.mFormat.format(paramBarEntry.getY()));
          ((StringBuilder)localObject).append(this.mSuffix);
          return ((StringBuilder)localObject).toString();
        }
        return "";
      }
    }
    paramBarEntry = new StringBuilder();
    paramBarEntry.append(this.mFormat.format(paramFloat));
    paramBarEntry.append(this.mSuffix);
    return paramBarEntry.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\StackedValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class DefaultAxisValueFormatter
  extends ValueFormatter
{
  protected int digits;
  protected DecimalFormat mFormat;
  
  public DefaultAxisValueFormatter(int paramInt)
  {
    this.digits = paramInt;
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramInt; i++)
    {
      if (i == 0) {
        localStringBuffer.append(".");
      }
      localStringBuffer.append("0");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("###,###,###,##0");
    localStringBuilder.append(localStringBuffer.toString());
    this.mFormat = new DecimalFormat(localStringBuilder.toString());
  }
  
  public int getDecimalDigits()
  {
    return this.digits;
  }
  
  public String getFormattedValue(float paramFloat)
  {
    return this.mFormat.format(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\DefaultAxisValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
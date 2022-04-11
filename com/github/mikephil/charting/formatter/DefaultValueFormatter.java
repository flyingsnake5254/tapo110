package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class DefaultValueFormatter
  extends ValueFormatter
{
  protected int mDecimalDigits;
  protected DecimalFormat mFormat;
  
  public DefaultValueFormatter(int paramInt)
  {
    setup(paramInt);
  }
  
  public int getDecimalDigits()
  {
    return this.mDecimalDigits;
  }
  
  public String getFormattedValue(float paramFloat)
  {
    return this.mFormat.format(paramFloat);
  }
  
  public void setup(int paramInt)
  {
    this.mDecimalDigits = paramInt;
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\DefaultValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
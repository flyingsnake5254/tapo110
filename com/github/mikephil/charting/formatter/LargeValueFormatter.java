package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class LargeValueFormatter
  extends ValueFormatter
{
  private DecimalFormat mFormat = new DecimalFormat("###E00");
  private int mMaxLength = 5;
  private String[] mSuffix = { "", "k", "m", "b", "t" };
  private String mText = "";
  
  public LargeValueFormatter() {}
  
  public LargeValueFormatter(String paramString)
  {
    this();
    this.mText = paramString;
  }
  
  private String makePretty(double paramDouble)
  {
    String str = this.mFormat.format(paramDouble);
    int i = Character.getNumericValue(str.charAt(str.length() - 1));
    int j = Character.getNumericValue(str.charAt(str.length() - 2));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(j);
    localStringBuilder.append("");
    localStringBuilder.append(i);
    j = Integer.valueOf(localStringBuilder.toString()).intValue();
    for (str = str.replaceAll("E[0-9][0-9]", this.mSuffix[(j / 3)]);; str = localStringBuilder.toString())
    {
      if ((str.length() <= this.mMaxLength) && (!str.matches("[0-9]+\\.[a-z]"))) {
        return str;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.substring(0, str.length() - 2));
      localStringBuilder.append(str.substring(str.length() - 1));
    }
  }
  
  public int getDecimalDigits()
  {
    return 0;
  }
  
  public String getFormattedValue(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(makePretty(paramFloat));
    localStringBuilder.append(this.mText);
    return localStringBuilder.toString();
  }
  
  public void setAppendix(String paramString)
  {
    this.mText = paramString;
  }
  
  public void setMaxLength(int paramInt)
  {
    this.mMaxLength = paramInt;
  }
  
  public void setSuffix(String[] paramArrayOfString)
  {
    this.mSuffix = paramArrayOfString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\LargeValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
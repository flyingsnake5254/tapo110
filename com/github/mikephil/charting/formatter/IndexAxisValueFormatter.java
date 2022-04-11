package com.github.mikephil.charting.formatter;

import java.util.Collection;

public class IndexAxisValueFormatter
  extends ValueFormatter
{
  private int mValueCount = 0;
  private String[] mValues = new String[0];
  
  public IndexAxisValueFormatter() {}
  
  public IndexAxisValueFormatter(Collection<String> paramCollection)
  {
    if (paramCollection != null) {
      setValues((String[])paramCollection.toArray(new String[paramCollection.size()]));
    }
  }
  
  public IndexAxisValueFormatter(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {
      setValues(paramArrayOfString);
    }
  }
  
  public String getFormattedValue(float paramFloat)
  {
    int i = Math.round(paramFloat);
    if ((i >= 0) && (i < this.mValueCount) && (i == (int)paramFloat)) {
      return this.mValues[i];
    }
    return "";
  }
  
  public String[] getValues()
  {
    return this.mValues;
  }
  
  public void setValues(String[] paramArrayOfString)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString == null) {
      arrayOfString = new String[0];
    }
    this.mValues = arrayOfString;
    this.mValueCount = arrayOfString.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\formatter\IndexAxisValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
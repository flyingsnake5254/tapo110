package com.github.mikephil.charting.model;

public class GradientColor
{
  private int endColor;
  private int startColor;
  
  public GradientColor(int paramInt1, int paramInt2)
  {
    this.startColor = paramInt1;
    this.endColor = paramInt2;
  }
  
  public int getEndColor()
  {
    return this.endColor;
  }
  
  public int getStartColor()
  {
    return this.startColor;
  }
  
  public void setEndColor(int paramInt)
  {
    this.endColor = paramInt;
  }
  
  public void setStartColor(int paramInt)
  {
    this.startColor = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\model\GradientColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
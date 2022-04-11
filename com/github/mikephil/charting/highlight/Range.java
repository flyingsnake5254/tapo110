package com.github.mikephil.charting.highlight;

public final class Range
{
  public float from;
  public float to;
  
  public Range(float paramFloat1, float paramFloat2)
  {
    this.from = paramFloat1;
    this.to = paramFloat2;
  }
  
  public boolean contains(float paramFloat)
  {
    return (paramFloat > this.from) && (paramFloat <= this.to);
  }
  
  public boolean isLarger(float paramFloat)
  {
    boolean bool;
    if (paramFloat > this.to) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSmaller(float paramFloat)
  {
    boolean bool;
    if (paramFloat < this.from) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\highlight\Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
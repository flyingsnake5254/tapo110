package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;

@SuppressLint({"ParcelCreator"})
public class RadarEntry
  extends Entry
{
  public RadarEntry(float paramFloat)
  {
    super(0.0F, paramFloat);
  }
  
  public RadarEntry(float paramFloat, Object paramObject)
  {
    super(0.0F, paramFloat, paramObject);
  }
  
  public RadarEntry copy()
  {
    return new RadarEntry(getY(), getData());
  }
  
  public float getValue()
  {
    return getY();
  }
  
  @Deprecated
  public float getX()
  {
    return super.getX();
  }
  
  @Deprecated
  public void setX(float paramFloat)
  {
    super.setX(paramFloat);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\RadarEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.util.Log;

@SuppressLint({"ParcelCreator"})
public class PieEntry
  extends Entry
{
  private String label;
  
  public PieEntry(float paramFloat)
  {
    super(0.0F, paramFloat);
  }
  
  public PieEntry(float paramFloat, Drawable paramDrawable)
  {
    super(0.0F, paramFloat, paramDrawable);
  }
  
  public PieEntry(float paramFloat, Drawable paramDrawable, Object paramObject)
  {
    super(0.0F, paramFloat, paramDrawable, paramObject);
  }
  
  public PieEntry(float paramFloat, Object paramObject)
  {
    super(0.0F, paramFloat, paramObject);
  }
  
  public PieEntry(float paramFloat, String paramString)
  {
    super(0.0F, paramFloat);
    this.label = paramString;
  }
  
  public PieEntry(float paramFloat, String paramString, Drawable paramDrawable)
  {
    super(0.0F, paramFloat, paramDrawable);
    this.label = paramString;
  }
  
  public PieEntry(float paramFloat, String paramString, Drawable paramDrawable, Object paramObject)
  {
    super(0.0F, paramFloat, paramDrawable, paramObject);
    this.label = paramString;
  }
  
  public PieEntry(float paramFloat, String paramString, Object paramObject)
  {
    super(0.0F, paramFloat, paramObject);
    this.label = paramString;
  }
  
  public PieEntry copy()
  {
    return new PieEntry(getY(), this.label, getData());
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public float getValue()
  {
    return getY();
  }
  
  @Deprecated
  public float getX()
  {
    Log.i("DEPRECATED", "Pie entries do not have x values");
    return super.getX();
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  @Deprecated
  public void setX(float paramFloat)
  {
    super.setX(paramFloat);
    Log.i("DEPRECATED", "Pie entries do not have x values");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\PieEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public abstract class BaseEntry
{
  private Object mData = null;
  private Drawable mIcon = null;
  private float y = 0.0F;
  
  public BaseEntry() {}
  
  public BaseEntry(float paramFloat)
  {
    this.y = paramFloat;
  }
  
  public BaseEntry(float paramFloat, Drawable paramDrawable)
  {
    this(paramFloat);
    this.mIcon = paramDrawable;
  }
  
  public BaseEntry(float paramFloat, Drawable paramDrawable, Object paramObject)
  {
    this(paramFloat);
    this.mIcon = paramDrawable;
    this.mData = paramObject;
  }
  
  public BaseEntry(float paramFloat, Object paramObject)
  {
    this(paramFloat);
    this.mData = paramObject;
  }
  
  public Object getData()
  {
    return this.mData;
  }
  
  public Drawable getIcon()
  {
    return this.mIcon;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
  }
  
  public void setY(float paramFloat)
  {
    this.y = paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\BaseEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
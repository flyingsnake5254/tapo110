package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.List;

public abstract interface Text
{
  public abstract Rect getBoundingBox();
  
  public abstract List<? extends Text> getComponents();
  
  public abstract Point[] getCornerPoints();
  
  public abstract String getLanguage();
  
  public abstract String getValue();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\text\Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
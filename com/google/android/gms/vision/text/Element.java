package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzao;
import java.util.ArrayList;
import java.util.List;

public class Element
  implements Text
{
  private zzao zzef;
  
  Element(zzao paramzzao)
  {
    this.zzef = paramzzao;
  }
  
  public Rect getBoundingBox()
  {
    return zzc.zza(this);
  }
  
  public List<? extends Text> getComponents()
  {
    return new ArrayList();
  }
  
  public Point[] getCornerPoints()
  {
    return zzc.zza(this.zzef.zzeq);
  }
  
  public String getLanguage()
  {
    return this.zzef.zzek;
  }
  
  public String getValue()
  {
    return this.zzef.zzet;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\text\Element.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
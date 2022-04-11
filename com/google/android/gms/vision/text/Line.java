package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzao;
import java.util.ArrayList;
import java.util.List;

public class Line
  implements Text
{
  private zzah zzeg;
  private List<Element> zzeh;
  
  Line(zzah paramzzah)
  {
    this.zzeg = paramzzah;
  }
  
  public float getAngle()
  {
    return this.zzeg.zzeq.zzeo;
  }
  
  public Rect getBoundingBox()
  {
    return zzc.zza(this);
  }
  
  public List<? extends Text> getComponents()
  {
    int i = this.zzeg.zzep.length;
    int j = 0;
    if (i == 0) {
      return new ArrayList(0);
    }
    if (this.zzeh == null)
    {
      this.zzeh = new ArrayList(this.zzeg.zzep.length);
      zzao[] arrayOfzzao = this.zzeg.zzep;
      i = arrayOfzzao.length;
      while (j < i)
      {
        zzao localzzao = arrayOfzzao[j];
        this.zzeh.add(new Element(localzzao));
        j++;
      }
    }
    return this.zzeh;
  }
  
  public Point[] getCornerPoints()
  {
    return zzc.zza(this.zzeg.zzeq);
  }
  
  public String getLanguage()
  {
    return this.zzeg.zzek;
  }
  
  public String getValue()
  {
    return this.zzeg.zzet;
  }
  
  public boolean isVertical()
  {
    return this.zzeg.zzev;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\text\Line.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
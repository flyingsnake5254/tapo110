package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class TextBlock
  implements Text
{
  private Point[] cornerPoints;
  private zzah[] zzei;
  private List<Line> zzej;
  private String zzek;
  private Rect zzel;
  
  TextBlock(SparseArray<zzah> paramSparseArray)
  {
    this.zzei = new zzah[paramSparseArray.size()];
    for (int i = 0;; i++)
    {
      zzah[] arrayOfzzah = this.zzei;
      if (i >= arrayOfzzah.length) {
        break;
      }
      arrayOfzzah[i] = ((zzah)paramSparseArray.valueAt(i));
    }
  }
  
  public Rect getBoundingBox()
  {
    if (this.zzel == null) {
      this.zzel = zzc.zza(this);
    }
    return this.zzel;
  }
  
  public List<? extends Text> getComponents()
  {
    int i = this.zzei.length;
    int j = 0;
    if (i == 0) {
      return new ArrayList(0);
    }
    if (this.zzej == null)
    {
      this.zzej = new ArrayList(this.zzei.length);
      zzah[] arrayOfzzah = this.zzei;
      i = arrayOfzzah.length;
      while (j < i)
      {
        zzah localzzah = arrayOfzzah[j];
        this.zzej.add(new Line(localzzah));
        j++;
      }
    }
    return this.zzej;
  }
  
  public Point[] getCornerPoints()
  {
    Object localObject1 = this;
    if (((TextBlock)localObject1).cornerPoints == null) {
      if (((TextBlock)localObject1).zzei.length == 0)
      {
        ((TextBlock)localObject1).cornerPoints = new Point[0];
      }
      else
      {
        int i = Integer.MIN_VALUE;
        int j = Integer.MIN_VALUE;
        int k = Integer.MAX_VALUE;
        int m = Integer.MAX_VALUE;
        for (int n = 0;; n++)
        {
          localObject2 = this.zzei;
          if (n >= localObject2.length) {
            break;
          }
          localObject1 = localObject2[n].zzeq;
          localObject2 = localObject2[0].zzeq;
          i1 = -((zzab)localObject2).left;
          i2 = -((zzab)localObject2).top;
          d1 = Math.sin(Math.toRadians(((zzab)localObject2).zzeo));
          d2 = Math.cos(Math.toRadians(((zzab)localObject2).zzeo));
          localObject2 = new Point[4];
          localObject2[0] = new Point(((zzab)localObject1).left, ((zzab)localObject1).top);
          localObject2[0].offset(i1, i2);
          i2 = (int)(localObject2[0].x * d2 + localObject2[0].y * d1);
          i1 = (int)(-localObject2[0].x * d1 + localObject2[0].y * d2);
          localObject2[0].x = i2;
          localObject2[0].y = i1;
          localObject2[1] = new Point(((zzab)localObject1).width + i2, i1);
          localObject2[2] = new Point(((zzab)localObject1).width + i2, ((zzab)localObject1).height + i1);
          localObject2[3] = new Point(i2, i1 + ((zzab)localObject1).height);
          for (i2 = 0; i2 < 4; i2++)
          {
            localObject1 = localObject2[i2];
            k = Math.min(k, ((Point)localObject1).x);
            i = Math.max(i, ((Point)localObject1).x);
            m = Math.min(m, ((Point)localObject1).y);
            j = Math.max(j, ((Point)localObject1).y);
          }
        }
        localObject1 = localObject2[0].zzeq;
        int i2 = ((zzab)localObject1).left;
        int i1 = ((zzab)localObject1).top;
        double d1 = Math.sin(Math.toRadians(((zzab)localObject1).zzeo));
        double d2 = Math.cos(Math.toRadians(((zzab)localObject1).zzeo));
        localObject1 = new Point[4];
        Object localObject2 = new Point(k, m);
        n = 0;
        localObject1[0] = localObject2;
        localObject1[1] = new Point(i, m);
        localObject1[2] = new Point(i, j);
        localObject1[3] = new Point(k, j);
        for (j = n; j < 4; j++)
        {
          n = (int)(localObject1[j].x * d2 - localObject1[j].y * d1);
          k = (int)(localObject1[j].x * d1 + localObject1[j].y * d2);
          localObject1[j].x = n;
          localObject1[j].y = k;
          localObject1[j].offset(i2, i1);
        }
        this.cornerPoints = ((Point[])localObject1);
      }
    }
    return this.cornerPoints;
  }
  
  public String getLanguage()
  {
    Object localObject1 = this.zzek;
    if (localObject1 != null) {
      return (String)localObject1;
    }
    HashMap localHashMap = new HashMap();
    for (Object localObject2 : this.zzei)
    {
      int k;
      if (localHashMap.containsKey(((zzah)localObject2).zzek)) {
        k = ((Integer)localHashMap.get(((zzah)localObject2).zzek)).intValue();
      } else {
        k = 0;
      }
      localHashMap.put(((zzah)localObject2).zzek, Integer.valueOf(k + 1));
    }
    localObject1 = (String)((Map.Entry)Collections.max(localHashMap.entrySet(), new zza(this))).getKey();
    this.zzek = ((String)localObject1);
    if ((localObject1 == null) || (((String)localObject1).isEmpty())) {
      this.zzek = "und";
    }
    return this.zzek;
  }
  
  public String getValue()
  {
    Object localObject = this.zzei;
    if (localObject.length == 0) {
      return "";
    }
    localObject = new StringBuilder(localObject[0].zzet);
    for (int i = 1; i < this.zzei.length; i++)
    {
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(this.zzei[i].zzet);
    }
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\text\TextBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
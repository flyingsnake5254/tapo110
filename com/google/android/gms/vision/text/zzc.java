package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;

final class zzc
{
  static Rect zza(Text paramText)
  {
    Point[] arrayOfPoint = paramText.getCornerPoints();
    int i = arrayOfPoint.length;
    int j = Integer.MIN_VALUE;
    int k = Integer.MIN_VALUE;
    int m = Integer.MAX_VALUE;
    int n = Integer.MAX_VALUE;
    for (int i1 = 0; i1 < i; i1++)
    {
      paramText = arrayOfPoint[i1];
      m = Math.min(m, paramText.x);
      j = Math.max(j, paramText.x);
      n = Math.min(n, paramText.y);
      k = Math.max(k, paramText.y);
    }
    return new Rect(m, n, j, k);
  }
  
  static Point[] zza(zzab paramzzab)
  {
    Point[] arrayOfPoint = new Point[4];
    double d1 = Math.sin(Math.toRadians(paramzzab.zzeo));
    double d2 = Math.cos(Math.toRadians(paramzzab.zzeo));
    arrayOfPoint[0] = new Point(paramzzab.left, paramzzab.top);
    double d3 = paramzzab.left;
    int i = paramzzab.width;
    arrayOfPoint[1] = new Point((int)(d3 + i * d2), (int)(paramzzab.top + i * d1));
    d3 = arrayOfPoint[1].x;
    i = paramzzab.height;
    arrayOfPoint[2] = new Point((int)(d3 - i * d1), (int)(arrayOfPoint[1].y + i * d2));
    arrayOfPoint[3] = new Point(arrayOfPoint[0].x + (arrayOfPoint[2].x - arrayOfPoint[1].x), arrayOfPoint[0].y + (arrayOfPoint[2].y - arrayOfPoint[1].y));
    return arrayOfPoint;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\vision\text\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
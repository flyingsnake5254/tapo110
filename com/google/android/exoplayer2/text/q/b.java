package com.google.android.exoplayer2.text.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.common.base.c;

final class b
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  
  private b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
  }
  
  @Nullable
  public static b a(String paramString)
  {
    g.a(paramString.startsWith("Format:"));
    String[] arrayOfString = TextUtils.split(paramString.substring(7), ",");
    int i = 0;
    int j = -1;
    int k = -1;
    int m = -1;
    int n = -1;
    while (i < arrayOfString.length)
    {
      paramString = c.e(arrayOfString[i].trim());
      paramString.hashCode();
      switch (paramString.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              i1 = -1;
              break;
            } while (!paramString.equals("style"));
            i1 = 3;
            break;
          } while (!paramString.equals("start"));
          i1 = 2;
          break;
        } while (!paramString.equals("text"));
        i1 = 1;
        break;
      } while (!paramString.equals("end"));
      int i1 = 0;
      switch (i1)
      {
      default: 
        break;
      case 3: 
        m = i;
        break;
      case 2: 
        j = i;
        break;
      case 1: 
        n = i;
        break;
      case 0: 
        k = i;
      }
      i++;
    }
    if ((j != -1) && (k != -1) && (n != -1)) {
      paramString = new b(j, k, m, n, arrayOfString.length);
    } else {
      paramString = null;
    }
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\q\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
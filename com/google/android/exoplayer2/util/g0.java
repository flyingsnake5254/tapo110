package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class g0
{
  private static final Comparator<b> a = d.c;
  private static final Comparator<b> b = e.c;
  private final int c;
  private final ArrayList<b> d;
  private final b[] e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public g0(int paramInt)
  {
    this.c = paramInt;
    this.e = new b[5];
    this.d = new ArrayList();
    this.f = -1;
  }
  
  private void b()
  {
    if (this.f != 1)
    {
      Collections.sort(this.d, a);
      this.f = 1;
    }
  }
  
  private void c()
  {
    if (this.f != 0)
    {
      Collections.sort(this.d, b);
      this.f = 0;
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    b();
    int j = this.i;
    Object localObject;
    if (j > 0)
    {
      localObject = this.e;
      j--;
      this.i = j;
      localObject = localObject[j];
    }
    else
    {
      localObject = new b(null);
    }
    j = this.g;
    this.g = (j + 1);
    ((b)localObject).a = j;
    ((b)localObject).b = paramInt;
    ((b)localObject).c = paramFloat;
    this.d.add(localObject);
    this.h += paramInt;
    for (;;)
    {
      paramInt = this.h;
      j = this.c;
      if (paramInt <= j) {
        break;
      }
      j = paramInt - j;
      localObject = (b)this.d.get(0);
      paramInt = ((b)localObject).b;
      if (paramInt <= j)
      {
        this.h -= paramInt;
        this.d.remove(0);
        paramInt = this.i;
        if (paramInt < 5)
        {
          b[] arrayOfb = this.e;
          this.i = (paramInt + 1);
          arrayOfb[paramInt] = localObject;
        }
      }
      else
      {
        ((b)localObject).b = (paramInt - j);
        this.h -= j;
      }
    }
  }
  
  public float d(float paramFloat)
  {
    c();
    float f1 = this.h;
    int j = 0;
    int k = 0;
    Object localObject;
    while (j < this.d.size())
    {
      localObject = (b)this.d.get(j);
      k += ((b)localObject).b;
      if (k >= paramFloat * f1) {
        return ((b)localObject).c;
      }
      j++;
    }
    if (this.d.isEmpty())
    {
      paramFloat = NaN.0F;
    }
    else
    {
      localObject = this.d;
      paramFloat = ((b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).c;
    }
    return paramFloat;
  }
  
  public void g()
  {
    this.d.clear();
    this.f = -1;
    this.g = 0;
    this.h = 0;
  }
  
  private static class b
  {
    public int a;
    public int b;
    public float c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\g0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.zip.Inflater;

final class i
{
  @Nullable
  public static h a(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = new d0(paramArrayOfByte);
    try
    {
      if (c(paramArrayOfByte)) {
        paramArrayOfByte = f(paramArrayOfByte);
      } else {
        paramArrayOfByte = e(paramArrayOfByte);
      }
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
    {
      paramArrayOfByte = null;
    }
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = paramArrayOfByte.size();
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return new h((h.a)paramArrayOfByte.get(0), (h.a)paramArrayOfByte.get(1), paramInt);
    }
    return new h((h.a)paramArrayOfByte.get(0), paramInt);
  }
  
  private static int b(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >> 1;
  }
  
  private static boolean c(d0 paramd0)
  {
    paramd0.Q(4);
    int i = paramd0.n();
    boolean bool = false;
    paramd0.P(0);
    if (i == 1886547818) {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  private static h.a d(d0 paramd0)
  {
    int i = paramd0.n();
    if (i > 10000) {
      return null;
    }
    float[] arrayOfFloat1 = new float[i];
    for (int j = 0; j < i; j++) {
      arrayOfFloat1[j] = paramd0.m();
    }
    int k = paramd0.n();
    if (k > 32000) {
      return null;
    }
    double d = Math.log(2.0D);
    int m = (int)Math.ceil(Math.log(i * 2.0D) / d);
    c0 localc0 = new c0(paramd0.d());
    localc0.p(paramd0.e() * 8);
    paramd0 = new float[k * 5];
    Object localObject = new int[5];
    j = 0;
    int n = 0;
    int i1;
    int i2;
    while (j < k)
    {
      i1 = 0;
      while (i1 < 5)
      {
        i2 = localObject[i1] + b(localc0.h(m));
        if ((i2 < i) && (i2 >= 0))
        {
          paramd0[n] = arrayOfFloat1[i2];
          localObject[i1] = i2;
          i1++;
          n++;
        }
        else
        {
          return null;
        }
      }
      j++;
    }
    localc0.p(localc0.e() + 7 & 0xFFFFFFF8);
    i = localc0.h(32);
    localObject = new h.b[i];
    for (j = 0; j < i; j++)
    {
      int i3 = localc0.h(8);
      int i4 = localc0.h(8);
      m = localc0.h(32);
      if (m > 128000) {
        return null;
      }
      i2 = (int)Math.ceil(Math.log(k * 2.0D) / d);
      arrayOfFloat1 = new float[m * 3];
      float[] arrayOfFloat2 = new float[m * 2];
      n = 0;
      i1 = 0;
      while (n < m)
      {
        i1 += b(localc0.h(i2));
        if ((i1 >= 0) && (i1 < k))
        {
          int i5 = n * 3;
          int i6 = i1 * 5;
          arrayOfFloat1[i5] = paramd0[i6];
          arrayOfFloat1[(i5 + 1)] = paramd0[(i6 + 1)];
          arrayOfFloat1[(i5 + 2)] = paramd0[(i6 + 2)];
          i5 = n * 2;
          arrayOfFloat2[i5] = paramd0[(i6 + 3)];
          arrayOfFloat2[(i5 + 1)] = paramd0[(i6 + 4)];
          n++;
        }
        else
        {
          return null;
        }
      }
      localObject[j] = new h.b(i3, arrayOfFloat1, arrayOfFloat2, i4);
    }
    return new h.a((h.b[])localObject);
  }
  
  @Nullable
  private static ArrayList<h.a> e(d0 paramd0)
  {
    if (paramd0.D() != 0) {
      return null;
    }
    paramd0.Q(7);
    int i = paramd0.n();
    d0 locald0;
    Inflater localInflater;
    if (i == 1684433976)
    {
      locald0 = new d0();
      localInflater = new Inflater(true);
    }
    try
    {
      boolean bool = o0.i0(paramd0, locald0, localInflater);
      if (!bool) {
        return null;
      }
      localInflater.end();
      paramd0 = locald0;
    }
    finally
    {
      localInflater.end();
    }
    return null;
    return g(paramd0);
  }
  
  @Nullable
  private static ArrayList<h.a> f(d0 paramd0)
  {
    paramd0.Q(8);
    int i = paramd0.e();
    int j = paramd0.f();
    while (i < j)
    {
      int k = paramd0.n() + i;
      if ((k > i) && (k <= j))
      {
        i = paramd0.n();
        if ((i != 2037673328) && (i != 1836279920))
        {
          paramd0.P(k);
          i = k;
        }
        else
        {
          paramd0.O(k);
          return e(paramd0);
        }
      }
    }
    return null;
  }
  
  @Nullable
  private static ArrayList<h.a> g(d0 paramd0)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramd0.e();
    int j = paramd0.f();
    while (i < j)
    {
      int k = paramd0.n() + i;
      if ((k > i) && (k <= j))
      {
        if (paramd0.n() == 1835365224)
        {
          h.a locala = d(paramd0);
          if (locala == null) {
            return null;
          }
          localArrayList.add(locala);
        }
        paramd0.P(k);
        i = k;
      }
      else
      {
        return null;
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\spherical\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
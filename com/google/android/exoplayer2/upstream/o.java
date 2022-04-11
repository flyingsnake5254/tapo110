package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class o
  implements e
{
  private final boolean a;
  private final int b;
  @Nullable
  private final byte[] c;
  private final d[] d;
  private int e;
  private int f;
  private int g;
  private d[] h;
  
  public o(boolean paramBoolean, int paramInt)
  {
    this(paramBoolean, paramInt, 0);
  }
  
  public o(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.a = paramBoolean;
    this.b = paramInt1;
    this.g = paramInt2;
    this.h = new d[paramInt2 + 100];
    if (paramInt2 > 0)
    {
      this.c = new byte[paramInt2 * paramInt1];
      while (i < paramInt2)
      {
        this.h[i] = new d(this.c, i * paramInt1);
        i++;
      }
    }
    this.c = null;
    this.d = new d[1];
  }
  
  public d a()
  {
    try
    {
      this.f += 1;
      int i = this.g;
      Object localObject1;
      if (i > 0)
      {
        localObject1 = this.h;
        i--;
        this.g = i;
        localObject1 = (d)g.e(localObject1[i]);
        this.h[this.g] = null;
      }
      else
      {
        localObject1 = new d(new byte[this.b], 0);
      }
      return (d)localObject1;
    }
    finally {}
  }
  
  public void b(d[] paramArrayOfd)
  {
    try
    {
      int i = this.g;
      int j = paramArrayOfd.length;
      Object localObject = this.h;
      if (j + i >= localObject.length) {
        this.h = ((d[])Arrays.copyOf((Object[])localObject, Math.max(localObject.length * 2, i + paramArrayOfd.length)));
      }
      j = paramArrayOfd.length;
      for (i = 0; i < j; i++)
      {
        localObject = paramArrayOfd[i];
        d[] arrayOfd = this.h;
        int k = this.g;
        this.g = (k + 1);
        arrayOfd[k] = localObject;
      }
      this.f -= paramArrayOfd.length;
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void c(d paramd)
  {
    try
    {
      d[] arrayOfd = this.d;
      arrayOfd[0] = paramd;
      b(arrayOfd);
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      int i = o0.k(this.e, this.b);
      int j = this.f;
      int k = 0;
      j = Math.max(0, i - j);
      int m = this.g;
      if (j >= m) {
        return;
      }
      i = j;
      if (this.c != null)
      {
        i = m - 1;
        while (k <= i)
        {
          d locald1 = (d)g.e(this.h[k]);
          if (locald1.a == this.c)
          {
            k++;
          }
          else
          {
            d locald2 = (d)g.e(this.h[i]);
            if (locald2.a != this.c)
            {
              i--;
            }
            else
            {
              d[] arrayOfd = this.h;
              arrayOfd[k] = locald2;
              arrayOfd[i] = locald1;
              i--;
              k++;
            }
          }
        }
        k = Math.max(j, k);
        j = this.g;
        i = k;
        if (k >= j) {
          return;
        }
      }
      Arrays.fill(this.h, i, this.g, null);
      this.g = i;
      return;
    }
    finally {}
  }
  
  public int e()
  {
    return this.b;
  }
  
  public int f()
  {
    try
    {
      int i = this.f;
      int j = this.b;
      return i * j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void g()
  {
    try
    {
      if (this.a) {
        h(0);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void h(int paramInt)
  {
    try
    {
      int i;
      if (paramInt < this.e) {
        i = 1;
      } else {
        i = 0;
      }
      this.e = paramInt;
      if (i != 0) {
        d();
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
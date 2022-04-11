package com.google.android.exoplayer2.o2.k0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.m;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.util.Arrays;

final class e
{
  private final f a = new f();
  private final d0 b = new d0(new byte[65025], 0);
  private int c = -1;
  private int d;
  private boolean e;
  
  private int a(int paramInt)
  {
    int i = 0;
    this.d = 0;
    int j;
    int k;
    do
    {
      j = this.d;
      Object localObject = this.a;
      k = i;
      if (paramInt + j >= ((f)localObject).g) {
        break;
      }
      localObject = ((f)localObject).j;
      this.d = (j + 1);
      j = localObject[(j + paramInt)];
      k = i + j;
      i = k;
    } while (j == 255);
    return k;
  }
  
  public f b()
  {
    return this.a;
  }
  
  public d0 c()
  {
    return this.b;
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    boolean bool;
    if (paramk != null) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    if (this.e)
    {
      this.e = false;
      this.b.L(0);
    }
    while (!this.e)
    {
      Object localObject;
      if (this.c < 0) {
        if ((this.a.c(paramk)) && (this.a.a(paramk, true)))
        {
          localObject = this.a;
          i = ((f)localObject).h;
          if (((((f)localObject).b & 0x1) == 1) && (this.b.f() == 0))
          {
            i += a(0);
            j = this.d + 0;
          }
          else
          {
            j = 0;
          }
          if (!m.e(paramk, i)) {
            return false;
          }
          this.c = j;
        }
        else
        {
          return false;
        }
      }
      int i = a(this.c);
      int j = this.c + this.d;
      if (i > 0)
      {
        localObject = this.b;
        ((d0)localObject).c(((d0)localObject).f() + i);
        if (!m.d(paramk, this.b.d(), this.b.f(), i)) {
          return false;
        }
        localObject = this.b;
        ((d0)localObject).O(((d0)localObject).f() + i);
        if (this.a.j[(j - 1)] != 255) {
          bool = true;
        } else {
          bool = false;
        }
        this.e = bool;
      }
      i = j;
      if (j == this.a.g) {
        i = -1;
      }
      this.c = i;
    }
    return true;
  }
  
  public void e()
  {
    this.a.b();
    this.b.L(0);
    this.c = -1;
    this.e = false;
  }
  
  public void f()
  {
    if (this.b.d().length == 65025) {
      return;
    }
    d0 locald0 = this.b;
    locald0.N(Arrays.copyOf(locald0.d(), Math.max(65025, this.b.f())), this.b.f());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k0\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
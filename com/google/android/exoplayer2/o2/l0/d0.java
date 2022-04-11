package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;

public final class d0
  implements i0
{
  private final c0 a;
  private final com.google.android.exoplayer2.util.d0 b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  
  public d0(c0 paramc0)
  {
    this.a = paramc0;
    this.b = new com.google.android.exoplayer2.util.d0(32);
  }
  
  public void a(l0 paraml0, l paraml, i0.d paramd)
  {
    this.a.a(paraml0, paraml, paramd);
    this.f = true;
  }
  
  public void b(com.google.android.exoplayer2.util.d0 paramd0, int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i;
    if (paramInt != 0)
    {
      i = paramd0.D();
      i = paramd0.e() + i;
    }
    else
    {
      i = -1;
    }
    if (this.f)
    {
      if (paramInt == 0) {
        return;
      }
      this.f = false;
      paramd0.P(i);
      this.d = 0;
    }
    while (paramd0.a() > 0)
    {
      paramInt = this.d;
      if (paramInt < 3)
      {
        if (paramInt == 0)
        {
          paramInt = paramd0.D();
          paramd0.P(paramd0.e() - 1);
          if (paramInt == 255)
          {
            this.f = true;
            return;
          }
        }
        paramInt = Math.min(paramd0.a(), 3 - this.d);
        paramd0.j(this.b.d(), this.d, paramInt);
        paramInt = this.d + paramInt;
        this.d = paramInt;
        if (paramInt == 3)
        {
          this.b.P(0);
          this.b.O(3);
          this.b.Q(1);
          i = this.b.D();
          paramInt = this.b.D();
          boolean bool;
          if ((i & 0x80) != 0) {
            bool = true;
          } else {
            bool = false;
          }
          this.e = bool;
          this.c = (((i & 0xF) << 8 | paramInt) + 3);
          paramInt = this.b.b();
          i = this.c;
          if (paramInt < i)
          {
            paramInt = Math.min(4098, Math.max(i, this.b.b() * 2));
            this.b.c(paramInt);
          }
        }
      }
      else
      {
        paramInt = Math.min(paramd0.a(), this.c - this.d);
        paramd0.j(this.b.d(), this.d, paramInt);
        paramInt = this.d + paramInt;
        this.d = paramInt;
        i = this.c;
        if (paramInt == i)
        {
          if (this.e)
          {
            if (o0.s(this.b.d(), 0, this.c, -1) != 0)
            {
              this.f = true;
              return;
            }
            this.b.O(this.c - 4);
          }
          else
          {
            this.b.O(i);
          }
          this.b.P(0);
          this.a.b(this.b);
          this.d = 0;
        }
      }
    }
  }
  
  public void c()
  {
    this.f = true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\l0\d0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
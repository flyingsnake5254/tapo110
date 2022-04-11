package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

final class o1
{
  public final e0.a a;
  public final long b;
  public final long c;
  public final long d;
  public final long e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  
  o1(e0.a parama, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool1 = false;
    boolean bool2;
    if ((paramBoolean4) && (!paramBoolean2)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    g.a(bool2);
    if ((paramBoolean3) && (!paramBoolean2)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    g.a(bool2);
    if (paramBoolean1)
    {
      bool2 = bool1;
      if (!paramBoolean2)
      {
        bool2 = bool1;
        if (!paramBoolean3)
        {
          bool2 = bool1;
          if (paramBoolean4) {}
        }
      }
    }
    else
    {
      bool2 = true;
    }
    g.a(bool2);
    this.a = parama;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramLong3;
    this.e = paramLong4;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
  }
  
  public o1 a(long paramLong)
  {
    o1 localo1;
    if (paramLong == this.c) {
      localo1 = this;
    } else {
      localo1 = new o1(this.a, this.b, paramLong, this.d, this.e, this.f, this.g, this.h, this.i);
    }
    return localo1;
  }
  
  public o1 b(long paramLong)
  {
    o1 localo1;
    if (paramLong == this.b) {
      localo1 = this;
    } else {
      localo1 = new o1(this.a, paramLong, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }
    return localo1;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (o1.class == paramObject.getClass()))
    {
      paramObject = (o1)paramObject;
      if ((this.b != ((o1)paramObject).b) || (this.c != ((o1)paramObject).c) || (this.d != ((o1)paramObject).d) || (this.e != ((o1)paramObject).e) || (this.f != ((o1)paramObject).f) || (this.g != ((o1)paramObject).g) || (this.h != ((o1)paramObject).h) || (this.i != ((o1)paramObject).i) || (!o0.b(this.a, ((o1)paramObject).a))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((((((((527 + this.a.hashCode()) * 31 + (int)this.b) * 31 + (int)this.c) * 31 + (int)this.d) * 31 + (int)this.e) * 31 + this.f) * 31 + this.g) * 31 + this.h) * 31 + this.i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
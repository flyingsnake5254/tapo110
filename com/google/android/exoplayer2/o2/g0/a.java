package com.google.android.exoplayer2.o2.g0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

public final class a
  implements j
{
  private final d0 a = new d0(6);
  private l b;
  private int c;
  private int d;
  private int e;
  private long f = -1L;
  @Nullable
  private MotionPhotoMetadata g;
  private com.google.android.exoplayer2.o2.k h;
  private c i;
  @Nullable
  private com.google.android.exoplayer2.o2.j0.k j;
  
  private void a(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    this.a.L(2);
    paramk.n(this.a.d(), 0, 2);
    paramk.h(this.a.J() - 2);
  }
  
  private void f()
  {
    h(new Metadata.Entry[0]);
    ((l)g.e(this.b)).r();
    this.b.o(new y.b(-9223372036854775807L));
    this.c = 6;
  }
  
  @Nullable
  private static MotionPhotoMetadata g(String paramString, long paramLong)
    throws IOException
  {
    if (paramLong == -1L) {
      return null;
    }
    paramString = e.a(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.a(paramLong);
  }
  
  private void h(Metadata.Entry... paramVarArgs)
  {
    ((l)g.e(this.b)).t(1024, 4).d(new Format.b().K("image/jpeg").X(new Metadata(paramVarArgs)).E());
  }
  
  private int i(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    this.a.L(2);
    paramk.n(this.a.d(), 0, 2);
    return this.a.J();
  }
  
  private void j(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    this.a.L(2);
    paramk.readFully(this.a.d(), 0, 2);
    int k = this.a.J();
    this.d = k;
    if (k == 65498)
    {
      if (this.f != -1L) {
        this.c = 4;
      } else {
        f();
      }
    }
    else if (((k < 65488) || (k > 65497)) && (k != 65281)) {
      this.c = 1;
    }
  }
  
  private void k(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    if (this.d == 65505)
    {
      Object localObject = new d0(this.e);
      paramk.readFully(((d0)localObject).d(), 0, this.e);
      if ((this.g == null) && ("http://ns.adobe.com/xap/1.0/".equals(((d0)localObject).x())))
      {
        localObject = ((d0)localObject).x();
        if (localObject != null)
        {
          paramk = g((String)localObject, paramk.a());
          this.g = paramk;
          if (paramk != null) {
            this.f = paramk.q;
          }
        }
      }
    }
    else
    {
      paramk.l(this.e);
    }
    this.c = 0;
  }
  
  private void l(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    this.a.L(2);
    paramk.readFully(this.a.d(), 0, 2);
    this.e = (this.a.J() - 2);
    this.c = 2;
  }
  
  private void m(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    if (!paramk.c(this.a.d(), 0, 1, true))
    {
      f();
    }
    else
    {
      paramk.e();
      if (this.j == null) {
        this.j = new com.google.android.exoplayer2.o2.j0.k();
      }
      paramk = new c(paramk, this.f);
      this.i = paramk;
      if (this.j.d(paramk))
      {
        this.j.b(new d(this.f, (l)g.e(this.b)));
        n();
      }
      else
      {
        f();
      }
    }
  }
  
  private void n()
  {
    h(new Metadata.Entry[] { (Metadata.Entry)g.e(this.g) });
    this.c = 5;
  }
  
  public void b(l paraml)
  {
    this.b = paraml;
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L)
    {
      this.c = 0;
      this.j = null;
    }
    else if (this.c == 5)
    {
      ((com.google.android.exoplayer2.o2.j0.k)g.e(this.j)).c(paramLong1, paramLong2);
    }
  }
  
  public boolean d(com.google.android.exoplayer2.o2.k paramk)
    throws IOException
  {
    int k = i(paramk);
    boolean bool1 = false;
    if (k != 65496) {
      return false;
    }
    k = i(paramk);
    this.d = k;
    if (k == 65504)
    {
      a(paramk);
      this.d = i(paramk);
    }
    if (this.d != 65505) {
      return false;
    }
    paramk.h(2);
    this.a.L(6);
    paramk.n(this.a.d(), 0, 6);
    boolean bool2 = bool1;
    if (this.a.F() == 1165519206L)
    {
      bool2 = bool1;
      if (this.a.J() == 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public int e(com.google.android.exoplayer2.o2.k paramk, x paramx)
    throws IOException
  {
    int k = this.c;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k != 5)
            {
              if (k == 6) {
                return -1;
              }
              throw new IllegalStateException();
            }
            if ((this.i == null) || (paramk != this.h))
            {
              this.h = paramk;
              this.i = new c(paramk, this.f);
            }
            k = ((com.google.android.exoplayer2.o2.j0.k)g.e(this.j)).e(this.i, paramx);
            if (k == 1) {
              paramx.a += this.f;
            }
            return k;
          }
          long l1 = paramk.getPosition();
          long l2 = this.f;
          if (l1 != l2)
          {
            paramx.a = l2;
            return 1;
          }
          m(paramk);
          return 0;
        }
        k(paramk);
        return 0;
      }
      l(paramk);
      return 0;
    }
    j(paramk);
    return 0;
  }
  
  public void release()
  {
    com.google.android.exoplayer2.o2.j0.k localk = this.j;
    if (localk != null) {
      localk.release();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\g0\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.h0;
import com.google.android.exoplayer2.util.w;

final class b1
  implements w
{
  private final h0 c;
  private final a d;
  @Nullable
  private b2 f;
  @Nullable
  private w q;
  private boolean x;
  private boolean y;
  
  public b1(a parama, h paramh)
  {
    this.d = parama;
    this.c = new h0(paramh);
    this.x = true;
  }
  
  private boolean f(boolean paramBoolean)
  {
    b2 localb2 = this.f;
    if ((localb2 != null) && (!localb2.d()) && ((this.f.g()) || ((!paramBoolean) && (!this.f.i())))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private void j(boolean paramBoolean)
  {
    if (f(paramBoolean))
    {
      this.x = true;
      if (this.y) {
        this.c.b();
      }
      return;
    }
    Object localObject = (w)g.e(this.q);
    long l = ((w)localObject).p();
    if (this.x)
    {
      if (l < this.c.p())
      {
        this.c.d();
        return;
      }
      this.x = false;
      if (this.y) {
        this.c.b();
      }
    }
    this.c.a(l);
    localObject = ((w)localObject).c();
    if (!((t1)localObject).equals(this.c.c()))
    {
      this.c.e((t1)localObject);
      this.d.d((t1)localObject);
    }
  }
  
  public void a(b2 paramb2)
  {
    if (paramb2 == this.f)
    {
      this.q = null;
      this.f = null;
      this.x = true;
    }
  }
  
  public void b(b2 paramb2)
    throws ExoPlaybackException
  {
    w localw1 = paramb2.w();
    if (localw1 != null)
    {
      w localw2 = this.q;
      if (localw1 != localw2) {
        if (localw2 == null)
        {
          this.q = localw1;
          this.f = paramb2;
          localw1.e(this.c.c());
        }
        else
        {
          throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
      }
    }
  }
  
  public t1 c()
  {
    Object localObject = this.q;
    if (localObject != null) {
      localObject = ((w)localObject).c();
    } else {
      localObject = this.c.c();
    }
    return (t1)localObject;
  }
  
  public void d(long paramLong)
  {
    this.c.a(paramLong);
  }
  
  public void e(t1 paramt1)
  {
    w localw = this.q;
    t1 localt1 = paramt1;
    if (localw != null)
    {
      localw.e(paramt1);
      localt1 = this.q.c();
    }
    this.c.e(localt1);
  }
  
  public void g()
  {
    this.y = true;
    this.c.b();
  }
  
  public void h()
  {
    this.y = false;
    this.c.d();
  }
  
  public long i(boolean paramBoolean)
  {
    j(paramBoolean);
    return p();
  }
  
  public long p()
  {
    long l;
    if (this.x) {
      l = this.c.p();
    } else {
      l = ((w)g.e(this.q)).p();
    }
    return l;
  }
  
  public static abstract interface a
  {
    public abstract void d(t1 paramt1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\b1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
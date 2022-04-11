package com.google.android.exoplayer2.o2.g0;

import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.y.a;
import com.google.android.exoplayer2.o2.z;

public final class d
  implements l
{
  private final long c;
  private final l d;
  
  public d(long paramLong, l paraml)
  {
    this.c = paramLong;
    this.d = paraml;
  }
  
  public void o(final y paramy)
  {
    this.d.o(new a(paramy));
  }
  
  public void r()
  {
    this.d.r();
  }
  
  public b0 t(int paramInt1, int paramInt2)
  {
    return this.d.t(paramInt1, paramInt2);
  }
  
  class a
    implements y
  {
    a(y paramy) {}
    
    public y.a a(long paramLong)
    {
      Object localObject = paramy.a(paramLong);
      z localz = ((y.a)localObject).a;
      localz = new z(localz.b, localz.c + d.a(d.this));
      localObject = ((y.a)localObject).b;
      return new y.a(localz, new z(((z)localObject).b, ((z)localObject).c + d.a(d.this)));
    }
    
    public boolean g()
    {
      return paramy.g();
    }
    
    public long i()
    {
      return paramy.i();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\g0\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
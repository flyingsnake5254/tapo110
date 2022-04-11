package com.tplink.tpble;

import io.reactivex.l0.a;

public class o
  implements n
{
  private s a;
  private n b;
  private p c;
  
  public o(s params, n paramn)
  {
    this.a = params;
    this.b = paramn;
  }
  
  public void a(q paramq, EnumBLEStatus paramEnumBLEStatus)
  {
    n localn = this.b;
    if (localn != null) {
      localn.a(paramq, paramEnumBLEStatus);
    }
  }
  
  public void b()
  {
    this.a = null;
    this.b = null;
    p localp = this.c;
    if (localp != null)
    {
      localp.x();
      this.c = null;
    }
  }
  
  public io.reactivex.q<q> c()
  {
    p localp = new p(this.a, this);
    this.c = localp;
    return io.reactivex.q.f0(localp).N(l.c).l0(a.c());
  }
  
  public void d()
  {
    p localp = this.c;
    if (localp != null) {
      localp.G();
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    n localn = this.b;
    if (localn != null) {
      localn.e(paramArrayOfByte);
    }
  }
  
  public io.reactivex.q<q> f(byte[] paramArrayOfByte)
  {
    p localp = this.c;
    if (localp != null)
    {
      localp.K(paramArrayOfByte);
      return io.reactivex.q.f0(new q(0));
    }
    return io.reactivex.q.f0(new q(14));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tpble\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
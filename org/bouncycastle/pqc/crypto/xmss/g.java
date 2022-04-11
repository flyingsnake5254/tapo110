package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.f;

final class g
  extends l
{
  private final int e;
  private final int f;
  private final int g;
  
  private g(b paramb)
  {
    super(paramb);
    this.e = b.i(paramb);
    this.f = b.j(paramb);
    this.g = b.k(paramb);
  }
  
  protected byte[] d()
  {
    byte[] arrayOfByte = super.d();
    f.d(this.e, arrayOfByte, 16);
    f.d(this.f, arrayOfByte, 20);
    f.d(this.g, arrayOfByte, 24);
    return arrayOfByte;
  }
  
  protected int e()
  {
    return this.f;
  }
  
  protected int f()
  {
    return this.g;
  }
  
  protected int g()
  {
    return this.e;
  }
  
  protected static class b
    extends l.a<b>
  {
    private int e = 0;
    private int f = 0;
    private int g = 0;
    
    protected b()
    {
      super();
    }
    
    protected l l()
    {
      return new g(this, null);
    }
    
    protected b m()
    {
      return this;
    }
    
    protected b n(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
    
    protected b o(int paramInt)
    {
      this.g = paramInt;
      return this;
    }
    
    protected b p(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
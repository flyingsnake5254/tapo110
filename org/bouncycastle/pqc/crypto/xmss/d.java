package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.f;

final class d
  extends l
{
  private final int e = 0;
  private final int f;
  private final int g;
  
  private d(b paramb)
  {
    super(paramb);
    this.f = b.i(paramb);
    this.g = b.j(paramb);
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
  
  protected static class b
    extends l.a<b>
  {
    private int e = 0;
    private int f = 0;
    
    protected b()
    {
      super();
    }
    
    protected l k()
    {
      return new d(this, null);
    }
    
    protected b l()
    {
      return this;
    }
    
    protected b m(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    protected b n(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
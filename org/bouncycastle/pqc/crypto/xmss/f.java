package org.bouncycastle.pqc.crypto.xmss;

final class f
  extends l
{
  private final int e;
  private final int f;
  private final int g;
  
  private f(b paramb)
  {
    super(paramb);
    this.e = b.i(paramb);
    this.f = b.j(paramb);
    this.g = b.k(paramb);
  }
  
  protected byte[] d()
  {
    byte[] arrayOfByte = super.d();
    org.bouncycastle.util.f.d(this.e, arrayOfByte, 16);
    org.bouncycastle.util.f.d(this.f, arrayOfByte, 20);
    org.bouncycastle.util.f.d(this.g, arrayOfByte, 24);
    return arrayOfByte;
  }
  
  protected int e()
  {
    return this.e;
  }
  
  protected int f()
  {
    return this.f;
  }
  
  protected int g()
  {
    return this.g;
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
      return new f(this, null);
    }
    
    protected b m()
    {
      return this;
    }
    
    protected b n(int paramInt)
    {
      this.e = paramInt;
      return this;
    }
    
    protected b o(int paramInt)
    {
      this.f = paramInt;
      return this;
    }
    
    protected b p(int paramInt)
    {
      this.g = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
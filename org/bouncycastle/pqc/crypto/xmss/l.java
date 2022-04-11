package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.f;

public abstract class l
{
  private final int a;
  private final long b;
  private final int c;
  private final int d;
  
  protected l(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
  }
  
  public final int a()
  {
    return this.d;
  }
  
  protected final int b()
  {
    return this.a;
  }
  
  protected final long c()
  {
    return this.b;
  }
  
  protected byte[] d()
  {
    byte[] arrayOfByte = new byte[32];
    f.d(this.a, arrayOfByte, 0);
    f.l(this.b, arrayOfByte, 4);
    f.d(this.c, arrayOfByte, 12);
    f.d(this.d, arrayOfByte, 28);
    return arrayOfByte;
  }
  
  protected static abstract class a<T extends a>
  {
    private final int a;
    private int b = 0;
    private long c = 0L;
    private int d = 0;
    
    protected a(int paramInt)
    {
      this.a = paramInt;
    }
    
    protected abstract T e();
    
    protected T f(int paramInt)
    {
      this.d = paramInt;
      return e();
    }
    
    protected T g(int paramInt)
    {
      this.b = paramInt;
      return e();
    }
    
    protected T h(long paramLong)
    {
      this.c = paramLong;
      return e();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\crypto\xmss\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
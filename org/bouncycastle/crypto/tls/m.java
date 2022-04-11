package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.g;

class m
  implements v0
{
  protected p0 a;
  protected g b;
  protected g c;
  
  m()
  {
    this.b = m1.n((short)1);
    this.c = m1.n((short)2);
  }
  
  m(m paramm)
  {
    this.a = paramm.a;
    this.b = m1.l((short)1, paramm.b);
    this.c = m1.l((short)2, paramm.c);
  }
  
  public void a(p0 paramp0)
  {
    this.a = paramp0;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.b());
    localStringBuilder.append(" and ");
    localStringBuilder.append(this.c.b());
    return localStringBuilder.toString();
  }
  
  public void c(byte paramByte)
  {
    this.b.c(paramByte);
    this.c.c(paramByte);
  }
  
  public v0 d()
  {
    return new m(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = this.a;
    if ((localObject != null) && (m1.K((p0)localObject)))
    {
      g localg = this.b;
      byte[] arrayOfByte = z.a;
      localObject = z.b;
      m(localg, arrayOfByte, (byte[])localObject, 48);
      m(this.c, arrayOfByte, (byte[])localObject, 40);
    }
    int i = this.b.doFinal(paramArrayOfByte, paramInt);
    return i + this.c.doFinal(paramArrayOfByte, paramInt + i);
  }
  
  public int e()
  {
    return this.b.e() + this.c.e();
  }
  
  public g f()
  {
    return new m(this);
  }
  
  public v0 g()
  {
    return this;
  }
  
  public void h(short paramShort)
  {
    throw new IllegalStateException("CombinedHash only supports calculating the legacy PRF for handshake hash");
  }
  
  public byte[] i(short paramShort)
  {
    throw new IllegalStateException("CombinedHash doesn't support multiple hashes");
  }
  
  public void l() {}
  
  protected void m(g paramg, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    byte[] arrayOfByte = this.a.e().f;
    paramg.update(arrayOfByte, 0, arrayOfByte.length);
    paramg.update(paramArrayOfByte1, 0, paramInt);
    int i = paramg.e();
    paramArrayOfByte1 = new byte[i];
    paramg.doFinal(paramArrayOfByte1, 0);
    paramg.update(arrayOfByte, 0, arrayOfByte.length);
    paramg.update(paramArrayOfByte2, 0, paramInt);
    paramg.update(paramArrayOfByte1, 0, i);
  }
  
  public void reset()
  {
    this.b.reset();
    this.c.reset();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.b.update(paramArrayOfByte, paramInt1, paramInt2);
    this.c.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
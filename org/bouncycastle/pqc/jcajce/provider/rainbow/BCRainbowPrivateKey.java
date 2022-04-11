package org.bouncycastle.pqc.jcajce.provider.rainbow;

import e.a.c.a.e;
import e.a.c.a.g;
import e.a.c.b.d.d;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.v0;

public class BCRainbowPrivateKey
  implements PrivateKey
{
  private static final long serialVersionUID = 1L;
  private short[][] A1inv;
  private short[][] A2inv;
  private short[] b1;
  private short[] b2;
  private e.a.c.b.d.a[] layers;
  private int[] vi;
  
  public BCRainbowPrivateKey(d paramd) {}
  
  public BCRainbowPrivateKey(e.a.c.c.a.a parama)
  {
    this(parama.c(), parama.a(), parama.d(), parama.b(), parama.f(), parama.e());
  }
  
  public BCRainbowPrivateKey(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, e.a.c.b.d.a[] paramArrayOfa)
  {
    this.A1inv = paramArrayOfShort1;
    this.b1 = paramArrayOfShort2;
    this.A2inv = paramArrayOfShort3;
    this.b2 = paramArrayOfShort4;
    this.vi = paramArrayOfInt;
    this.layers = paramArrayOfa;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BCRainbowPrivateKey)))
    {
      paramObject = (BCRainbowPrivateKey)paramObject;
      if (e.a.c.b.d.f.a.j(this.A1inv, ((BCRainbowPrivateKey)paramObject).getInvA1())) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (e.a.c.b.d.f.a.j(this.A2inv, ((BCRainbowPrivateKey)paramObject).getInvA2()))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (e.a.c.b.d.f.a.i(this.b1, ((BCRainbowPrivateKey)paramObject).getB1()))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (e.a.c.b.d.f.a.i(this.b2, ((BCRainbowPrivateKey)paramObject).getB2()))) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool;
      if ((i != 0) && (Arrays.equals(this.vi, ((BCRainbowPrivateKey)paramObject).getVi()))) {
        bool = true;
      } else {
        bool = false;
      }
      if (this.layers.length != ((BCRainbowPrivateKey)paramObject).getLayers().length) {
        return false;
      }
      for (int i = this.layers.length - 1; i >= 0; i--) {
        bool &= this.layers[i].equals(paramObject.getLayers()[i]);
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "Rainbow";
  }
  
  public short[] getB1()
  {
    return this.b1;
  }
  
  public short[] getB2()
  {
    return this.b2;
  }
  
  public byte[] getEncoded()
  {
    g localg = new g(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
    Object localObject1 = null;
    try
    {
      Object localObject2 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject2).<init>(e.a, v0.c);
      h localh = new org/bouncycastle/asn1/n2/h;
      localh.<init>((org.bouncycastle.asn1.x509.a)localObject2, localg);
      localObject2 = localh.d();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return (byte[])localObject1;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public short[][] getInvA1()
  {
    return this.A1inv;
  }
  
  public short[][] getInvA2()
  {
    return this.A2inv;
  }
  
  public e.a.c.b.d.a[] getLayers()
  {
    return this.layers;
  }
  
  public int[] getVi()
  {
    return this.vi;
  }
  
  public int hashCode()
  {
    int i = ((((this.layers.length * 37 + org.bouncycastle.util.a.C(this.A1inv)) * 37 + org.bouncycastle.util.a.B(this.b1)) * 37 + org.bouncycastle.util.a.C(this.A2inv)) * 37 + org.bouncycastle.util.a.B(this.b2)) * 37 + org.bouncycastle.util.a.y(this.vi);
    for (int j = this.layers.length - 1; j >= 0; j--) {
      i = i * 37 + this.layers[j].hashCode();
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\BCRainbowPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
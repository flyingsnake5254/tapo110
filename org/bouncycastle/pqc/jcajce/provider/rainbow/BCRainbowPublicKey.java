package org.bouncycastle.pqc.jcajce.provider.rainbow;

import e.a.c.a.h;
import e.a.c.b.d.c;
import e.a.c.c.a.b;
import java.security.PublicKey;
import org.bouncycastle.asn1.v0;

public class BCRainbowPublicKey
  implements PublicKey
{
  private static final long serialVersionUID = 1L;
  private short[][] coeffquadratic;
  private short[] coeffscalar;
  private short[][] coeffsingular;
  private int docLength;
  private c rainbowParams;
  
  public BCRainbowPublicKey(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    this.docLength = paramInt;
    this.coeffquadratic = paramArrayOfShort1;
    this.coeffsingular = paramArrayOfShort2;
    this.coeffscalar = paramArrayOfShort;
  }
  
  public BCRainbowPublicKey(e.a.c.b.d.e parame) {}
  
  public BCRainbowPublicKey(b paramb)
  {
    this(paramb.d(), paramb.a(), paramb.c(), paramb.b());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof BCRainbowPublicKey))
      {
        bool2 = bool1;
      }
      else
      {
        paramObject = (BCRainbowPublicKey)paramObject;
        bool2 = bool1;
        if (this.docLength == ((BCRainbowPublicKey)paramObject).getDocLength())
        {
          bool2 = bool1;
          if (e.a.c.b.d.f.a.j(this.coeffquadratic, ((BCRainbowPublicKey)paramObject).getCoeffQuadratic()))
          {
            bool2 = bool1;
            if (e.a.c.b.d.f.a.j(this.coeffsingular, ((BCRainbowPublicKey)paramObject).getCoeffSingular()))
            {
              bool2 = bool1;
              if (e.a.c.b.d.f.a.i(this.coeffscalar, ((BCRainbowPublicKey)paramObject).getCoeffScalar())) {
                bool2 = true;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public final String getAlgorithm()
  {
    return "Rainbow";
  }
  
  public short[][] getCoeffQuadratic()
  {
    return this.coeffquadratic;
  }
  
  public short[] getCoeffScalar()
  {
    return org.bouncycastle.util.a.k(this.coeffscalar);
  }
  
  public short[][] getCoeffSingular()
  {
    short[][] arrayOfShort1 = new short[this.coeffsingular.length][];
    for (int i = 0;; i++)
    {
      short[][] arrayOfShort2 = this.coeffsingular;
      if (i == arrayOfShort2.length) {
        break;
      }
      arrayOfShort1[i] = org.bouncycastle.util.a.k(arrayOfShort2[i]);
    }
    return arrayOfShort1;
  }
  
  public int getDocLength()
  {
    return this.docLength;
  }
  
  public byte[] getEncoded()
  {
    h localh = new h(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar);
    return org.bouncycastle.pqc.jcajce.provider.a.a.a(new org.bouncycastle.asn1.x509.a(e.a.c.a.e.a, v0.c), localh);
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public int hashCode()
  {
    return ((this.docLength * 37 + org.bouncycastle.util.a.C(this.coeffquadratic)) * 37 + org.bouncycastle.util.a.C(this.coeffsingular)) * 37 + org.bouncycastle.util.a.B(this.coeffscalar);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\BCRainbowPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
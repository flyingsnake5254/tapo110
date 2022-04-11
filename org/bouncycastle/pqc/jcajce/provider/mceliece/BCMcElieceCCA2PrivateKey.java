package org.bouncycastle.pqc.jcajce.provider.mceliece;

import e.a.c.a.e;
import e.a.c.d.a.i;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.l;

public class BCMcElieceCCA2PrivateKey
  implements PrivateKey
{
  private static final long serialVersionUID = 1L;
  private e.a.c.b.b.b params;
  
  public BCMcElieceCCA2PrivateKey(e.a.c.b.b.b paramb)
  {
    this.params = paramb;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof BCMcElieceCCA2PrivateKey))
      {
        bool2 = bool1;
      }
      else
      {
        paramObject = (BCMcElieceCCA2PrivateKey)paramObject;
        bool2 = bool1;
        if (getN() == ((BCMcElieceCCA2PrivateKey)paramObject).getN())
        {
          bool2 = bool1;
          if (getK() == ((BCMcElieceCCA2PrivateKey)paramObject).getK())
          {
            bool2 = bool1;
            if (getField().equals(((BCMcElieceCCA2PrivateKey)paramObject).getField()))
            {
              bool2 = bool1;
              if (getGoppaPoly().equals(((BCMcElieceCCA2PrivateKey)paramObject).getGoppaPoly()))
              {
                bool2 = bool1;
                if (getP().equals(((BCMcElieceCCA2PrivateKey)paramObject).getP()))
                {
                  bool2 = bool1;
                  if (getH().equals(((BCMcElieceCCA2PrivateKey)paramObject).getH())) {
                    bool2 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public String getAlgorithm()
  {
    return "McEliece-CCA2";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      e.a.c.a.a locala = new e/a/c/a/a;
      locala.<init>(getN(), getK(), getField(), getGoppaPoly(), getP(), c.a(this.params.b()));
      org.bouncycastle.asn1.x509.a locala1 = new org/bouncycastle/asn1/x509/a;
      locala1.<init>(e.n);
      Object localObject = new org/bouncycastle/asn1/n2/h;
      ((org.bouncycastle.asn1.n2.h)localObject).<init>(locala1, locala);
      localObject = ((l)localObject).d();
      return (byte[])localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public e.a.c.d.a.b getField()
  {
    return this.params.c();
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public i getGoppaPoly()
  {
    return this.params.d();
  }
  
  public e.a.c.d.a.a getH()
  {
    return this.params.e();
  }
  
  public int getK()
  {
    return this.params.f();
  }
  
  org.bouncycastle.crypto.w.b getKeyParams()
  {
    return this.params;
  }
  
  public int getN()
  {
    return this.params.g();
  }
  
  public e.a.c.d.a.h getP()
  {
    return this.params.h();
  }
  
  public i[] getQInv()
  {
    return this.params.i();
  }
  
  public int getT()
  {
    return this.params.d().g();
  }
  
  public int hashCode()
  {
    return ((((this.params.f() * 37 + this.params.g()) * 37 + this.params.c().hashCode()) * 37 + this.params.d().hashCode()) * 37 + this.params.h().hashCode()) * 37 + this.params.e().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\BCMcElieceCCA2PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
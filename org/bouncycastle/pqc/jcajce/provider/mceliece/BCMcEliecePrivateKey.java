package org.bouncycastle.pqc.jcajce.provider.mceliece;

import e.a.c.a.c;
import e.a.c.b.b.f;
import e.a.c.d.a.i;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.l;

public class BCMcEliecePrivateKey
  implements org.bouncycastle.crypto.e, PrivateKey
{
  private static final long serialVersionUID = 1L;
  private f params;
  
  public BCMcEliecePrivateKey(f paramf)
  {
    this.params = paramf;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCMcEliecePrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCMcEliecePrivateKey)paramObject;
    bool1 = bool2;
    if (getN() == ((BCMcEliecePrivateKey)paramObject).getN())
    {
      bool1 = bool2;
      if (getK() == ((BCMcEliecePrivateKey)paramObject).getK())
      {
        bool1 = bool2;
        if (getField().equals(((BCMcEliecePrivateKey)paramObject).getField()))
        {
          bool1 = bool2;
          if (getGoppaPoly().equals(((BCMcEliecePrivateKey)paramObject).getGoppaPoly()))
          {
            bool1 = bool2;
            if (getSInv().equals(((BCMcEliecePrivateKey)paramObject).getSInv()))
            {
              bool1 = bool2;
              if (getP1().equals(((BCMcEliecePrivateKey)paramObject).getP1()))
              {
                bool1 = bool2;
                if (getP2().equals(((BCMcEliecePrivateKey)paramObject).getP2())) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "McEliece";
  }
  
  public byte[] getEncoded()
  {
    Object localObject1 = new c(this.params.f(), this.params.e(), this.params.b(), this.params.c(), this.params.g(), this.params.h(), this.params.j());
    Object localObject2 = null;
    try
    {
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      locala.<init>(e.a.c.a.e.m);
      org.bouncycastle.asn1.n2.h localh = new org/bouncycastle/asn1/n2/h;
      localh.<init>(locala, (org.bouncycastle.asn1.e)localObject1);
      localObject1 = localh.d();
      localObject2 = localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return (byte[])localObject2;
  }
  
  public e.a.c.d.a.b getField()
  {
    return this.params.b();
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public i getGoppaPoly()
  {
    return this.params.c();
  }
  
  public e.a.c.d.a.a getH()
  {
    return this.params.d();
  }
  
  public int getK()
  {
    return this.params.e();
  }
  
  org.bouncycastle.crypto.w.b getKeyParams()
  {
    return this.params;
  }
  
  public int getN()
  {
    return this.params.f();
  }
  
  public e.a.c.d.a.h getP1()
  {
    return this.params.g();
  }
  
  public e.a.c.d.a.h getP2()
  {
    return this.params.h();
  }
  
  public i[] getQInv()
  {
    return this.params.i();
  }
  
  public e.a.c.d.a.a getSInv()
  {
    return this.params.j();
  }
  
  public int hashCode()
  {
    return (((((this.params.e() * 37 + this.params.f()) * 37 + this.params.b().hashCode()) * 37 + this.params.c().hashCode()) * 37 + this.params.g().hashCode()) * 37 + this.params.h().hashCode()) * 37 + this.params.j().hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\BCMcEliecePrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
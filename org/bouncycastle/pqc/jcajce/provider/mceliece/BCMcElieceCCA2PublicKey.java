package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.x509.w;

public class BCMcElieceCCA2PublicKey
  implements org.bouncycastle.crypto.e, PublicKey
{
  private static final long serialVersionUID = 1L;
  private e.a.c.b.b.c params;
  
  public BCMcElieceCCA2PublicKey(e.a.c.b.b.c paramc)
  {
    this.params = paramc;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof BCMcElieceCCA2PublicKey))
      {
        bool2 = bool1;
      }
      else
      {
        paramObject = (BCMcElieceCCA2PublicKey)paramObject;
        bool2 = bool1;
        if (this.params.e() == ((BCMcElieceCCA2PublicKey)paramObject).getN())
        {
          bool2 = bool1;
          if (this.params.f() == ((BCMcElieceCCA2PublicKey)paramObject).getT())
          {
            bool2 = bool1;
            if (this.params.c().equals(((BCMcElieceCCA2PublicKey)paramObject).getG())) {
              bool2 = true;
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
    e.a.c.a.b localb = new e.a.c.a.b(this.params.e(), this.params.f(), this.params.c(), c.a(this.params.b()));
    org.bouncycastle.asn1.x509.a locala = new org.bouncycastle.asn1.x509.a(e.a.c.a.e.n);
    try
    {
      Object localObject = new org/bouncycastle/asn1/x509/w;
      ((w)localObject).<init>(locala, localb);
      localObject = ((l)localObject).d();
      return (byte[])localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public e.a.c.d.a.a getG()
  {
    return this.params.c();
  }
  
  public int getK()
  {
    return this.params.d();
  }
  
  org.bouncycastle.crypto.w.b getKeyParams()
  {
    return this.params;
  }
  
  public int getN()
  {
    return this.params.e();
  }
  
  public int getT()
  {
    return this.params.f();
  }
  
  public int hashCode()
  {
    return (this.params.e() + this.params.f() * 37) * 37 + this.params.c().hashCode();
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("McEliecePublicKey:\n");
    ((StringBuilder)localObject).append(" length of the code         : ");
    ((StringBuilder)localObject).append(this.params.e());
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" error correction capability: ");
    localStringBuilder.append(this.params.f());
    localStringBuilder.append("\n");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" generator matrix           : ");
    localStringBuilder.append(this.params.c().toString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\BCMcElieceCCA2PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.pqc.jcajce.provider.mceliece;

import e.a.c.a.d;
import e.a.c.a.e;
import e.a.c.b.b.g;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.b;

public class BCMcEliecePublicKey
  implements PublicKey
{
  private static final long serialVersionUID = 1L;
  private g params;
  
  public BCMcEliecePublicKey(g paramg)
  {
    this.params = paramg;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCMcEliecePublicKey;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (BCMcEliecePublicKey)paramObject;
      bool3 = bool2;
      if (this.params.d() == ((BCMcEliecePublicKey)paramObject).getN())
      {
        bool3 = bool2;
        if (this.params.e() == ((BCMcEliecePublicKey)paramObject).getT())
        {
          bool3 = bool2;
          if (this.params.b().equals(((BCMcEliecePublicKey)paramObject).getG())) {
            bool3 = true;
          }
        }
      }
    }
    return bool3;
  }
  
  public String getAlgorithm()
  {
    return "McEliece";
  }
  
  public byte[] getEncoded()
  {
    d locald = new d(this.params.d(), this.params.e(), this.params.b());
    Object localObject = new org.bouncycastle.asn1.x509.a(e.m);
    try
    {
      w localw = new org/bouncycastle/asn1/x509/w;
      localw.<init>((org.bouncycastle.asn1.x509.a)localObject, locald);
      localObject = localw.d();
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
    return this.params.b();
  }
  
  public int getK()
  {
    return this.params.c();
  }
  
  b getKeyParams()
  {
    return this.params;
  }
  
  public int getN()
  {
    return this.params.d();
  }
  
  public int getT()
  {
    return this.params.e();
  }
  
  public int hashCode()
  {
    return (this.params.d() + this.params.e() * 37) * 37 + this.params.b().hashCode();
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("McEliecePublicKey:\n");
    ((StringBuilder)localObject).append(" length of the code         : ");
    ((StringBuilder)localObject).append(this.params.d());
    ((StringBuilder)localObject).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" error correction capability: ");
    localStringBuilder.append(this.params.e());
    localStringBuilder.append("\n");
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" generator matrix           : ");
    localStringBuilder.append(this.params.b());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\BCMcEliecePublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
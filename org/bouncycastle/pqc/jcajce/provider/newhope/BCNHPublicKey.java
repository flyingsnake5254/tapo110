package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey;

public class BCNHPublicKey
  implements NHPublicKey
{
  private static final long serialVersionUID = 1L;
  private final e.a.c.b.c.b params;
  
  public BCNHPublicKey(e.a.c.b.c.b paramb)
  {
    this.params = paramb;
  }
  
  public BCNHPublicKey(w paramw)
  {
    this.params = new e.a.c.b.c.b(paramw.i().o());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BCNHPublicKey)))
    {
      paramObject = (BCNHPublicKey)paramObject;
      return org.bouncycastle.util.a.c(this.params.b(), ((BCNHPublicKey)paramObject).params.b());
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "NH";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject).<init>(e.a.c.a.e.v);
      w localw = new org/bouncycastle/asn1/x509/w;
      localw.<init>((org.bouncycastle.asn1.x509.a)localObject, this.params.b());
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
  
  org.bouncycastle.crypto.e getKeyParams()
  {
    return this.params;
  }
  
  public byte[] getPublicData()
  {
    return this.params.b();
  }
  
  public int hashCode()
  {
    return org.bouncycastle.util.a.w(this.params.b());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\newhope\BCNHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
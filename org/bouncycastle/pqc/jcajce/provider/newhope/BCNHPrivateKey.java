package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.pqc.jcajce.interfaces.NHPrivateKey;
import org.bouncycastle.util.f;

public class BCNHPrivateKey
  implements NHPrivateKey
{
  private static final long serialVersionUID = 1L;
  private final e.a.c.b.c.a params;
  
  public BCNHPrivateKey(e.a.c.b.c.a parama)
  {
    this.params = parama;
  }
  
  public BCNHPrivateKey(h paramh)
    throws IOException
  {
    this.params = new e.a.c.b.c.a(convert(n.m(paramh.i()).o()));
  }
  
  private static short[] convert(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length / 2;
    short[] arrayOfShort = new short[i];
    for (int j = 0; j != i; j++) {
      arrayOfShort[j] = f.k(paramArrayOfByte, j * 2);
    }
    return arrayOfShort;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof BCNHPrivateKey)))
    {
      paramObject = (BCNHPrivateKey)paramObject;
      return org.bouncycastle.util.a.f(this.params.b(), ((BCNHPrivateKey)paramObject).params.b());
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
      Object localObject1 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>(e.a.c.a.e.v);
      Object localObject2 = this.params.b();
      byte[] arrayOfByte = new byte[localObject2.length * 2];
      for (int i = 0; i != localObject2.length; i++) {
        f.r(localObject2[i], arrayOfByte, i * 2);
      }
      h localh = new org/bouncycastle/asn1/n2/h;
      localObject2 = new org/bouncycastle/asn1/x0;
      ((x0)localObject2).<init>(arrayOfByte);
      localh.<init>((org.bouncycastle.asn1.x509.a)localObject1, (org.bouncycastle.asn1.e)localObject2);
      localObject1 = localh.d();
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  org.bouncycastle.crypto.e getKeyParams()
  {
    return this.params;
  }
  
  public short[] getSecretData()
  {
    return this.params.b();
  }
  
  public int hashCode()
  {
    return org.bouncycastle.util.a.B(this.params.b());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\newhope\BCNHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.pqc.jcajce.provider.sphincs;

import e.a.c.a.i;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;

public class BCSphincs256PrivateKey
  implements PrivateKey, SPHINCSKey
{
  private static final long serialVersionUID = 1L;
  private final e.a.c.b.e.a params;
  private final m treeDigest;
  
  public BCSphincs256PrivateKey(m paramm, e.a.c.b.e.a parama)
  {
    this.treeDigest = paramm;
    this.params = parama;
  }
  
  public BCSphincs256PrivateKey(h paramh)
    throws IOException
  {
    this.treeDigest = i.f(paramh.h().i()).g().f();
    this.params = new e.a.c.b.e.a(n.m(paramh.i()).o());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BCSphincs256PrivateKey))
    {
      paramObject = (BCSphincs256PrivateKey)paramObject;
      if ((!this.treeDigest.equals(((BCSphincs256PrivateKey)paramObject).treeDigest)) || (!org.bouncycastle.util.a.c(this.params.b(), ((BCSphincs256PrivateKey)paramObject).params.b()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "SPHINCS-256";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject1 = new org/bouncycastle/asn1/x509/a;
      Object localObject2 = e.a.c.a.e.r;
      Object localObject3 = new e/a/c/a/i;
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      locala.<init>(this.treeDigest);
      ((i)localObject3).<init>(locala);
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>((m)localObject2, (org.bouncycastle.asn1.e)localObject3);
      localObject2 = new org/bouncycastle/asn1/n2/h;
      localObject3 = new org/bouncycastle/asn1/x0;
      ((x0)localObject3).<init>(this.params.b());
      ((h)localObject2).<init>((org.bouncycastle.asn1.x509.a)localObject1, (org.bouncycastle.asn1.e)localObject3);
      localObject1 = ((l)localObject2).d();
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public byte[] getKeyData()
  {
    return this.params.b();
  }
  
  org.bouncycastle.crypto.e getKeyParams()
  {
    return this.params;
  }
  
  public int hashCode()
  {
    return this.treeDigest.hashCode() + org.bouncycastle.util.a.w(this.params.b()) * 37;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\sphincs\BCSphincs256PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
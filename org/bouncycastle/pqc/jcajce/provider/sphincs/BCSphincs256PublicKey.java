package org.bouncycastle.pqc.jcajce.provider.sphincs;

import e.a.c.a.i;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;

public class BCSphincs256PublicKey
  implements PublicKey, SPHINCSKey
{
  private static final long serialVersionUID = 1L;
  private final e.a.c.b.e.b params;
  private final m treeDigest;
  
  public BCSphincs256PublicKey(m paramm, e.a.c.b.e.b paramb)
  {
    this.treeDigest = paramm;
    this.params = paramb;
  }
  
  public BCSphincs256PublicKey(w paramw)
  {
    this.treeDigest = i.f(paramw.f().i()).g().f();
    this.params = new e.a.c.b.e.b(paramw.i().o());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BCSphincs256PublicKey))
    {
      paramObject = (BCSphincs256PublicKey)paramObject;
      if ((!this.treeDigest.equals(((BCSphincs256PublicKey)paramObject).treeDigest)) || (!org.bouncycastle.util.a.c(this.params.b(), ((BCSphincs256PublicKey)paramObject).params.b()))) {
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
      m localm = e.a.c.a.e.r;
      i locali = new e/a/c/a/i;
      Object localObject2 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject2).<init>(this.treeDigest);
      locali.<init>((org.bouncycastle.asn1.x509.a)localObject2);
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>(localm, locali);
      localObject2 = new org/bouncycastle/asn1/x509/w;
      ((w)localObject2).<init>((org.bouncycastle.asn1.x509.a)localObject1, this.params.b());
      localObject1 = ((l)localObject2).d();
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\sphincs\BCSphincs256PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
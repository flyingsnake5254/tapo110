package org.bouncycastle.pqc.jcajce.provider.xmss;

import e.a.c.a.j;
import e.a.c.a.n;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.crypto.xmss.r;
import org.bouncycastle.pqc.crypto.xmss.t;
import org.bouncycastle.pqc.crypto.xmss.t.b;

public class BCXMSSPublicKey
  implements PublicKey
{
  private final t keyParams;
  private final m treeDigest;
  
  public BCXMSSPublicKey(m paramm, t paramt)
  {
    this.treeDigest = paramm;
    this.keyParams = paramt;
  }
  
  public BCXMSSPublicKey(w paramw)
    throws IOException
  {
    j localj = j.g(paramw.f().i());
    m localm = localj.h().f();
    this.treeDigest = localm;
    paramw = n.f(paramw.j());
    this.keyParams = new t.b(new r(localj.f(), a.a(localm))).f(paramw.g()).g(paramw.h()).e();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BCXMSSPublicKey))
    {
      paramObject = (BCXMSSPublicKey)paramObject;
      if ((!this.treeDigest.equals(((BCXMSSPublicKey)paramObject).treeDigest)) || (!org.bouncycastle.util.a.c(this.keyParams.e(), ((BCXMSSPublicKey)paramObject).keyParams.e()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "XMSS";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject1 = new org/bouncycastle/asn1/x509/a;
      Object localObject2 = e.a.c.a.e.w;
      j localj = new e/a/c/a/j;
      int i = this.keyParams.b().d();
      Object localObject3 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject3).<init>(this.treeDigest);
      localj.<init>(i, (org.bouncycastle.asn1.x509.a)localObject3);
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>((m)localObject2, localj);
      localObject2 = new org/bouncycastle/asn1/x509/w;
      localObject3 = new e/a/c/a/n;
      ((n)localObject3).<init>(this.keyParams.c(), this.keyParams.d());
      ((w)localObject2).<init>((org.bouncycastle.asn1.x509.a)localObject1, (org.bouncycastle.asn1.e)localObject3);
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
  
  public int getHeight()
  {
    return this.keyParams.b().d();
  }
  
  org.bouncycastle.crypto.e getKeyParams()
  {
    return this.keyParams;
  }
  
  public String getTreeDigest()
  {
    return a.b(this.treeDigest);
  }
  
  public int hashCode()
  {
    return this.treeDigest.hashCode() + org.bouncycastle.util.a.w(this.keyParams.e()) * 37;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\xmss\BCXMSSPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
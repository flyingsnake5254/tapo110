package org.bouncycastle.pqc.jcajce.provider.xmss;

import e.a.c.a.k;
import e.a.c.a.n;
import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.pqc.crypto.xmss.o;
import org.bouncycastle.pqc.crypto.xmss.o.b;

public class BCXMSSMTPublicKey
  implements PublicKey
{
  private final o keyParams;
  private final org.bouncycastle.asn1.m treeDigest;
  
  public BCXMSSMTPublicKey(org.bouncycastle.asn1.m paramm, o paramo)
  {
    this.treeDigest = paramm;
    this.keyParams = paramo;
  }
  
  public BCXMSSMTPublicKey(w paramw)
    throws IOException
  {
    k localk = k.g(paramw.f().i());
    org.bouncycastle.asn1.m localm = localk.i().f();
    this.treeDigest = localm;
    paramw = n.f(paramw.j());
    this.keyParams = new o.b(new org.bouncycastle.pqc.crypto.xmss.m(localk.f(), localk.h(), a.a(localm))).f(paramw.g()).g(paramw.h()).e();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BCXMSSMTPublicKey))
    {
      paramObject = (BCXMSSMTPublicKey)paramObject;
      if ((!this.treeDigest.equals(((BCXMSSMTPublicKey)paramObject).treeDigest)) || (!org.bouncycastle.util.a.c(this.keyParams.e(), ((BCXMSSMTPublicKey)paramObject).keyParams.e()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public final String getAlgorithm()
  {
    return "XMSSMT";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject1 = new org/bouncycastle/asn1/x509/a;
      org.bouncycastle.asn1.m localm = e.a.c.a.e.B;
      Object localObject2 = new e/a/c/a/k;
      int i = this.keyParams.b().c();
      int j = this.keyParams.b().d();
      Object localObject3 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject3).<init>(this.treeDigest);
      ((k)localObject2).<init>(i, j, (org.bouncycastle.asn1.x509.a)localObject3);
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>(localm, (org.bouncycastle.asn1.e)localObject2);
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
    return this.keyParams.b().c();
  }
  
  org.bouncycastle.crypto.e getKeyParams()
  {
    return this.keyParams;
  }
  
  public int getLayers()
  {
    return this.keyParams.b().d();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\xmss\BCXMSSMTPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
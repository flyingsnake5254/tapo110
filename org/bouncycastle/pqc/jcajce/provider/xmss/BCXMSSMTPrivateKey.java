package org.bouncycastle.pqc.jcajce.provider.xmss;

import e.a.c.a.k;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.n;
import org.bouncycastle.pqc.crypto.xmss.n.b;
import org.bouncycastle.pqc.crypto.xmss.u;

public class BCXMSSMTPrivateKey
  implements PrivateKey
{
  private final n keyParams;
  private final org.bouncycastle.asn1.m treeDigest;
  
  public BCXMSSMTPrivateKey(org.bouncycastle.asn1.m paramm, n paramn)
  {
    this.treeDigest = paramm;
    this.keyParams = paramn;
  }
  
  public BCXMSSMTPrivateKey(h paramh)
    throws IOException
  {
    k localk = k.g(paramh.h().i());
    Object localObject = localk.i().f();
    this.treeDigest = ((org.bouncycastle.asn1.m)localObject);
    paramh = e.a.c.a.m.h(paramh.i());
    try
    {
      n.b localb = new org/bouncycastle/pqc/crypto/xmss/n$b;
      org.bouncycastle.pqc.crypto.xmss.m localm = new org/bouncycastle/pqc/crypto/xmss/m;
      localm.<init>(localk.f(), localk.h(), a.a((org.bouncycastle.asn1.m)localObject));
      localb.<init>(localm);
      localObject = localb.l(paramh.g()).p(paramh.l()).o(paramh.k()).m(paramh.i()).n(paramh.j());
      if (paramh.f() != null) {
        ((n.b)localObject).k((BDSStateMap)u.f(paramh.f(), BDSStateMap.class));
      }
      this.keyParams = ((n.b)localObject).j();
      return;
    }
    catch (ClassNotFoundException paramh)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ClassNotFoundException processing BDS state: ");
      ((StringBuilder)localObject).append(paramh.getMessage());
      throw new IOException(((StringBuilder)localObject).toString());
    }
  }
  
  private e.a.c.a.l createKeyStructure()
  {
    byte[] arrayOfByte1 = this.keyParams.c();
    int i = this.keyParams.b().b();
    int j = this.keyParams.b().c();
    int k = (j + 7) / 8;
    int m = (int)u.a(arrayOfByte1, 0, k);
    if (u.l(j, m))
    {
      j = k + 0;
      byte[] arrayOfByte2 = u.g(arrayOfByte1, j, i);
      j += i;
      byte[] arrayOfByte3 = u.g(arrayOfByte1, j, i);
      j += i;
      byte[] arrayOfByte4 = u.g(arrayOfByte1, j, i);
      j += i;
      byte[] arrayOfByte5 = u.g(arrayOfByte1, j, i);
      i = j + i;
      return new e.a.c.a.l(m, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, u.g(arrayOfByte1, i, arrayOfByte1.length - i));
    }
    throw new IllegalArgumentException("index out of bounds");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BCXMSSMTPrivateKey))
    {
      paramObject = (BCXMSSMTPrivateKey)paramObject;
      if ((!this.treeDigest.equals(((BCXMSSMTPrivateKey)paramObject).treeDigest)) || (!org.bouncycastle.util.a.c(this.keyParams.c(), ((BCXMSSMTPrivateKey)paramObject).keyParams.c()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAlgorithm()
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
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      locala.<init>(this.treeDigest);
      ((k)localObject2).<init>(i, j, locala);
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>(localm, (org.bouncycastle.asn1.e)localObject2);
      localObject2 = new org/bouncycastle/asn1/n2/h;
      ((h)localObject2).<init>((org.bouncycastle.asn1.x509.a)localObject1, createKeyStructure());
      localObject1 = ((org.bouncycastle.asn1.l)localObject2).d();
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
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
  
  org.bouncycastle.asn1.m getTreeDigestOID()
  {
    return this.treeDigest;
  }
  
  public int hashCode()
  {
    return this.treeDigest.hashCode() + org.bouncycastle.util.a.w(this.keyParams.c()) * 37;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\xmss\BCXMSSMTPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
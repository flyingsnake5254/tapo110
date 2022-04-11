package org.bouncycastle.pqc.jcajce.provider.xmss;

import e.a.c.a.j;
import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.r;
import org.bouncycastle.pqc.crypto.xmss.s;
import org.bouncycastle.pqc.crypto.xmss.s.b;
import org.bouncycastle.pqc.crypto.xmss.u;

public class BCXMSSPrivateKey
  implements PrivateKey
{
  private final s keyParams;
  private final org.bouncycastle.asn1.m treeDigest;
  
  public BCXMSSPrivateKey(org.bouncycastle.asn1.m paramm, s params)
  {
    this.treeDigest = paramm;
    this.keyParams = params;
  }
  
  public BCXMSSPrivateKey(h paramh)
    throws IOException
  {
    j localj = j.g(paramh.h().i());
    Object localObject = localj.h().f();
    this.treeDigest = ((org.bouncycastle.asn1.m)localObject);
    paramh = e.a.c.a.m.h(paramh.i());
    try
    {
      s.b localb = new org/bouncycastle/pqc/crypto/xmss/s$b;
      r localr = new org/bouncycastle/pqc/crypto/xmss/r;
      localr.<init>(localj.f(), a.a((org.bouncycastle.asn1.m)localObject));
      localb.<init>(localr);
      localObject = localb.l(paramh.g()).p(paramh.l()).o(paramh.k()).m(paramh.i()).n(paramh.j());
      if (paramh.f() != null) {
        ((s.b)localObject).k((BDS)u.f(paramh.f(), BDS.class));
      }
      this.keyParams = ((s.b)localObject).j();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramh = new StringBuilder();
      paramh.append("ClassNotFoundException processing BDS state: ");
      paramh.append(localClassNotFoundException.getMessage());
      throw new IOException(paramh.toString());
    }
  }
  
  private e.a.c.a.m createKeyStructure()
  {
    byte[] arrayOfByte1 = this.keyParams.c();
    int i = this.keyParams.b().c();
    int j = this.keyParams.b().d();
    int k = (int)u.a(arrayOfByte1, 0, 4);
    if (u.l(j, k))
    {
      byte[] arrayOfByte2 = u.g(arrayOfByte1, 4, i);
      j = 4 + i;
      byte[] arrayOfByte3 = u.g(arrayOfByte1, j, i);
      j += i;
      byte[] arrayOfByte4 = u.g(arrayOfByte1, j, i);
      j += i;
      byte[] arrayOfByte5 = u.g(arrayOfByte1, j, i);
      i = j + i;
      return new e.a.c.a.m(k, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, u.g(arrayOfByte1, i, arrayOfByte1.length - i));
    }
    throw new IllegalArgumentException("index out of bounds");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BCXMSSPrivateKey))
    {
      paramObject = (BCXMSSPrivateKey)paramObject;
      if ((!this.treeDigest.equals(((BCXMSSPrivateKey)paramObject).treeDigest)) || (!org.bouncycastle.util.a.c(this.keyParams.c(), ((BCXMSSPrivateKey)paramObject).keyParams.c()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAlgorithm()
  {
    return "XMSS";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject1 = new org/bouncycastle/asn1/x509/a;
      org.bouncycastle.asn1.m localm = e.a.c.a.e.w;
      Object localObject2 = new e/a/c/a/j;
      int i = this.keyParams.b().d();
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      locala.<init>(this.treeDigest);
      ((j)localObject2).<init>(i, locala);
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>(localm, (org.bouncycastle.asn1.e)localObject2);
      localObject2 = new org/bouncycastle/asn1/n2/h;
      ((h)localObject2).<init>((org.bouncycastle.asn1.x509.a)localObject1, createKeyStructure());
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
  
  org.bouncycastle.asn1.m getTreeDigestOID()
  {
    return this.treeDigest;
  }
  
  public int hashCode()
  {
    return this.treeDigest.hashCode() + org.bouncycastle.util.a.w(this.keyParams.c()) * 37;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\xmss\BCXMSSPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
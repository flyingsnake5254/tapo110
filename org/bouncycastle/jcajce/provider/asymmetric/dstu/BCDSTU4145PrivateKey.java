package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r2.f;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BCDSTU4145PrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.b
{
  static final long serialVersionUID = 7245981689601667138L;
  private String algorithm = "DSTU4145";
  private transient org.bouncycastle.jcajce.provider.asymmetric.util.d attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  private transient BigInteger d;
  private transient ECParameterSpec ecSpec;
  private transient n0 publicKey;
  private boolean withCompression;
  
  protected BCDSTU4145PrivateKey() {}
  
  public BCDSTU4145PrivateKey(String paramString, r paramr)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    this.ecSpec = null;
  }
  
  public BCDSTU4145PrivateKey(String paramString, r paramr, BCDSTU4145PublicKey paramBCDSTU4145PublicKey, ECParameterSpec paramECParameterSpec)
  {
    n localn = paramr.b();
    this.algorithm = paramString;
    this.d = paramr.c();
    if (paramECParameterSpec == null) {
      this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(localn.b()), localn.e(), localn.c().intValue());
    } else {
      this.ecSpec = paramECParameterSpec;
    }
    this.publicKey = getPublicKeyDetails(paramBCDSTU4145PublicKey);
  }
  
  public BCDSTU4145PrivateKey(String paramString, r paramr, BCDSTU4145PublicKey paramBCDSTU4145PublicKey, org.bouncycastle.jce.spec.d paramd)
  {
    n localn = paramr.b();
    this.algorithm = paramString;
    this.d = paramr.c();
    if (paramd == null) {
      paramString = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(localn.b()), localn.e(), localn.c().intValue());
    } else {
      paramString = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramd.a(), paramd.e()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramd.b()), paramd.d(), paramd.c().intValue());
    }
    this.ecSpec = paramString;
    this.publicKey = getPublicKeyDetails(paramBCDSTU4145PublicKey);
  }
  
  public BCDSTU4145PrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
  }
  
  public BCDSTU4145PrivateKey(ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
  }
  
  BCDSTU4145PrivateKey(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    populateFromPrivKeyInfo(paramh);
  }
  
  public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey paramBCDSTU4145PrivateKey)
  {
    this.d = paramBCDSTU4145PrivateKey.d;
    this.ecSpec = paramBCDSTU4145PrivateKey.ecSpec;
    this.withCompression = paramBCDSTU4145PrivateKey.withCompression;
    this.attrCarrier = paramBCDSTU4145PrivateKey.attrCarrier;
    this.publicKey = paramBCDSTU4145PrivateKey.publicKey;
  }
  
  public BCDSTU4145PrivateKey(org.bouncycastle.jce.spec.e parame)
  {
    throw null;
  }
  
  private n0 getPublicKeyDetails(BCDSTU4145PublicKey paramBCDSTU4145PublicKey)
  {
    try
    {
      paramBCDSTU4145PublicKey = w.h(q.i(paramBCDSTU4145PublicKey.getEncoded())).i();
      return paramBCDSTU4145PublicKey;
    }
    catch (IOException paramBCDSTU4145PublicKey) {}
    return null;
  }
  
  private void populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    Object localObject1 = new org.bouncycastle.asn1.u2.h((q)paramh.h().i());
    if (((org.bouncycastle.asn1.u2.h)localObject1).i())
    {
      localObject1 = m.r(((org.bouncycastle.asn1.u2.h)localObject1).g());
      Object localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.b.g((m)localObject1);
      EllipticCurve localEllipticCurve;
      if (localObject2 == null)
      {
        localObject2 = org.bouncycastle.asn1.r2.c.a((m)localObject1);
        localEllipticCurve = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((n)localObject2).a(), ((n)localObject2).f());
        localObject1 = new org.bouncycastle.jce.spec.c(((m)localObject1).q(), localEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((n)localObject2).b()), ((n)localObject2).e(), ((n)localObject2).c());
      }
      else
      {
        localEllipticCurve = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.asn1.u2.j)localObject2).f(), ((org.bouncycastle.asn1.u2.j)localObject2).k());
        localObject1 = new org.bouncycastle.jce.spec.c(org.bouncycastle.jcajce.provider.asymmetric.util.b.d((m)localObject1), localEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.asn1.u2.j)localObject2).g()), ((org.bouncycastle.asn1.u2.j)localObject2).j(), ((org.bouncycastle.asn1.u2.j)localObject2).h());
      }
    }
    else
    {
      if (((org.bouncycastle.asn1.u2.h)localObject1).h())
      {
        this.ecSpec = null;
        break label202;
      }
      localObject1 = org.bouncycastle.asn1.u2.j.i(((org.bouncycastle.asn1.u2.h)localObject1).g());
      localObject1 = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.asn1.u2.j)localObject1).f(), ((org.bouncycastle.asn1.u2.j)localObject1).k()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.asn1.u2.j)localObject1).g()), ((org.bouncycastle.asn1.u2.j)localObject1).j(), ((org.bouncycastle.asn1.u2.j)localObject1).h().intValue());
    }
    this.ecSpec = ((ECParameterSpec)localObject1);
    label202:
    paramh = paramh.i();
    if ((paramh instanceof org.bouncycastle.asn1.j))
    {
      this.d = org.bouncycastle.asn1.j.m(paramh).p();
    }
    else
    {
      paramh = org.bouncycastle.asn1.p2.a.f(paramh);
      this.d = paramh.g();
      this.publicKey = paramh.j();
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h.g(q.i((byte[])paramObjectInputStream.readObject())));
    this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(getEncoded());
  }
  
  org.bouncycastle.jce.spec.d engineGetSpec()
  {
    ECParameterSpec localECParameterSpec = this.ecSpec;
    if (localECParameterSpec != null) {
      return org.bouncycastle.jcajce.provider.asymmetric.util.a.h(localECParameterSpec, this.withCompression);
    }
    return BouncyCastleProvider.CONFIGURATION.b();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCDSTU4145PrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCDSTU4145PrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((BCDSTU4145PrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCDSTU4145PrivateKey)paramObject).engineGetSpec())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  public org.bouncycastle.asn1.e getBagAttribute(m paramm)
  {
    return this.attrCarrier.getBagAttribute(paramm);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public BigInteger getD()
  {
    return this.d;
  }
  
  public byte[] getEncoded()
  {
    Object localObject1 = this.ecSpec;
    Object localObject2;
    if ((localObject1 instanceof org.bouncycastle.jce.spec.c))
    {
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(((org.bouncycastle.jce.spec.c)localObject1).a());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new m(((org.bouncycastle.jce.spec.c)this.ecSpec).a());
      }
      localObject1 = new org.bouncycastle.asn1.u2.h((m)localObject1);
    }
    else
    {
      if (localObject1 == null)
      {
        localObject1 = new org.bouncycastle.asn1.u2.h(v0.c);
        i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(BouncyCastleProvider.CONFIGURATION, null, getS());
        break label174;
      }
      localObject1 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject1).getCurve());
      localObject1 = new org.bouncycastle.asn1.u2.h(new org.bouncycastle.asn1.u2.j((e.a.b.a.d)localObject1, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject1, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
    }
    int i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
    label174:
    if (this.publicKey != null) {
      localObject2 = new org.bouncycastle.asn1.p2.a(i, getS(), this.publicKey, (org.bouncycastle.asn1.e)localObject1);
    } else {
      localObject2 = new org.bouncycastle.asn1.p2.a(i, getS(), (org.bouncycastle.asn1.e)localObject1);
    }
    try
    {
      Object localObject3;
      if (this.algorithm.equals("DSTU4145"))
      {
        localObject3 = new org/bouncycastle/asn1/n2/h;
        org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
        locala.<init>(f.c, ((org.bouncycastle.asn1.u2.h)localObject1).c());
        ((org.bouncycastle.asn1.n2.h)localObject3).<init>(locala, ((org.bouncycastle.asn1.p2.a)localObject2).c());
        localObject1 = localObject3;
      }
      else
      {
        localObject3 = new org/bouncycastle/asn1/x509/a;
        ((org.bouncycastle.asn1.x509.a)localObject3).<init>(org.bouncycastle.asn1.u2.p.B2, ((org.bouncycastle.asn1.u2.h)localObject1).c());
        localObject1 = new org.bouncycastle.asn1.n2.h((org.bouncycastle.asn1.x509.a)localObject3, ((org.bouncycastle.asn1.p2.a)localObject2).c());
      }
      localObject1 = ((l)localObject1).e("DER");
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public org.bouncycastle.jce.spec.d getParameters()
  {
    ECParameterSpec localECParameterSpec = this.ecSpec;
    if (localECParameterSpec == null) {
      return null;
    }
    return org.bouncycastle.jcajce.provider.asymmetric.util.a.h(localECParameterSpec, this.withCompression);
  }
  
  public ECParameterSpec getParams()
  {
    return this.ecSpec;
  }
  
  public BigInteger getS()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return getD().hashCode() ^ engineGetSpec().hashCode();
  }
  
  public void setBagAttribute(m paramm, org.bouncycastle.asn1.e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
  
  public void setPointFormat(String paramString)
  {
    this.withCompression = ("UNCOMPRESSED".equalsIgnoreCase(paramString) ^ true);
  }
  
  public String toString()
  {
    return org.bouncycastle.jcajce.provider.asymmetric.util.b.j(this.algorithm, this.d, engineGetSpec());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dstu\BCDSTU4145PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
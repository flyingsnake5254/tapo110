package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

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
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.p;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.c;

public class BCECGOST3410_2012PrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.b
{
  static final long serialVersionUID = 7245981689601667138L;
  private String algorithm = "ECGOST3410-2012";
  private transient org.bouncycastle.jcajce.provider.asymmetric.util.d attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  private transient BigInteger d;
  private transient ECParameterSpec ecSpec;
  private transient org.bouncycastle.asn1.d2.e gostParams;
  private transient n0 publicKey;
  private boolean withCompression;
  
  protected BCECGOST3410_2012PrivateKey() {}
  
  public BCECGOST3410_2012PrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    this.ecSpec = null;
  }
  
  public BCECGOST3410_2012PrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr, BCECGOST3410_2012PublicKey paramBCECGOST3410_2012PublicKey, ECParameterSpec paramECParameterSpec)
  {
    org.bouncycastle.crypto.w.n localn = paramr.b();
    this.algorithm = paramString;
    this.d = paramr.c();
    if (paramECParameterSpec == null) {
      this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(localn.b()), localn.e(), localn.c().intValue());
    } else {
      this.ecSpec = paramECParameterSpec;
    }
    this.gostParams = paramBCECGOST3410_2012PublicKey.getGostParams();
    this.publicKey = getPublicKeyDetails(paramBCECGOST3410_2012PublicKey);
  }
  
  public BCECGOST3410_2012PrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr, BCECGOST3410_2012PublicKey paramBCECGOST3410_2012PublicKey, org.bouncycastle.jce.spec.d paramd)
  {
    org.bouncycastle.crypto.w.n localn = paramr.b();
    this.algorithm = paramString;
    this.d = paramr.c();
    if (paramd == null) {
      paramString = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(localn.b()), localn.e(), localn.c().intValue());
    } else {
      paramString = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramd.a(), paramd.e()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramd.b()), paramd.d(), paramd.c().intValue());
    }
    this.ecSpec = paramString;
    this.gostParams = paramBCECGOST3410_2012PublicKey.getGostParams();
    this.publicKey = getPublicKeyDetails(paramBCECGOST3410_2012PublicKey);
  }
  
  public BCECGOST3410_2012PrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
  }
  
  public BCECGOST3410_2012PrivateKey(ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
  }
  
  BCECGOST3410_2012PrivateKey(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    populateFromPrivKeyInfo(paramh);
  }
  
  public BCECGOST3410_2012PrivateKey(BCECGOST3410_2012PrivateKey paramBCECGOST3410_2012PrivateKey)
  {
    this.d = paramBCECGOST3410_2012PrivateKey.d;
    this.ecSpec = paramBCECGOST3410_2012PrivateKey.ecSpec;
    this.withCompression = paramBCECGOST3410_2012PrivateKey.withCompression;
    this.attrCarrier = paramBCECGOST3410_2012PrivateKey.attrCarrier;
    this.publicKey = paramBCECGOST3410_2012PrivateKey.publicKey;
    this.gostParams = paramBCECGOST3410_2012PrivateKey.gostParams;
  }
  
  public BCECGOST3410_2012PrivateKey(org.bouncycastle.jce.spec.e parame)
  {
    throw null;
  }
  
  private void extractBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    int i = arrayOfByte.length;
    int j = 0;
    int k = j;
    paramBigInteger = arrayOfByte;
    if (i < paramInt1)
    {
      paramBigInteger = new byte[paramInt1];
      System.arraycopy(arrayOfByte, 0, paramBigInteger, paramInt1 - arrayOfByte.length, arrayOfByte.length);
    }
    for (k = j; k != paramInt1; k++) {
      paramArrayOfByte[(paramInt2 + k)] = ((byte)paramBigInteger[(paramBigInteger.length - 1 - k)]);
    }
  }
  
  private n0 getPublicKeyDetails(BCECGOST3410_2012PublicKey paramBCECGOST3410_2012PublicKey)
  {
    return w.h(paramBCECGOST3410_2012PublicKey.getEncoded()).i();
  }
  
  private void populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    Object localObject1 = paramh.h().i().c();
    Object localObject2;
    if (((localObject1 instanceof org.bouncycastle.asn1.r)) && ((org.bouncycastle.asn1.r.m(localObject1).size() == 2) || (org.bouncycastle.asn1.r.m(localObject1).size() == 3)))
    {
      localObject1 = org.bouncycastle.asn1.d2.e.h(paramh.h().i());
      this.gostParams = ((org.bouncycastle.asn1.d2.e)localObject1);
      localObject1 = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(((org.bouncycastle.asn1.d2.e)localObject1).i()));
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.jce.spec.d)localObject1).a(), ((org.bouncycastle.jce.spec.d)localObject1).e());
      this.ecSpec = new c(org.bouncycastle.asn1.d2.b.c(this.gostParams.i()), (EllipticCurve)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.jce.spec.d)localObject1).b()), ((org.bouncycastle.jce.spec.d)localObject1).d(), ((org.bouncycastle.jce.spec.d)localObject1).c());
      paramh = paramh.i();
      if ((paramh instanceof org.bouncycastle.asn1.j))
      {
        paramh = org.bouncycastle.asn1.j.m(paramh).o();
      }
      else
      {
        paramh = org.bouncycastle.asn1.n.m(paramh).o();
        localObject1 = new byte[paramh.length];
        for (int i = 0; i != paramh.length; i++) {
          localObject1[i] = ((byte)paramh[(paramh.length - 1 - i)]);
        }
        paramh = new BigInteger(1, (byte[])localObject1);
      }
    }
    else
    {
      localObject1 = org.bouncycastle.asn1.u2.h.f(paramh.h().i());
      if (((org.bouncycastle.asn1.u2.h)localObject1).i())
      {
        localObject1 = m.r(((org.bouncycastle.asn1.u2.h)localObject1).g());
        Object localObject3 = org.bouncycastle.jcajce.provider.asymmetric.util.b.g((m)localObject1);
        if (localObject3 == null)
        {
          localObject2 = org.bouncycastle.asn1.d2.b.b((m)localObject1);
          localObject3 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.crypto.w.n)localObject2).a(), ((org.bouncycastle.crypto.w.n)localObject2).f());
          localObject1 = new c(org.bouncycastle.asn1.d2.b.c((m)localObject1), (EllipticCurve)localObject3, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.crypto.w.n)localObject2).b()), ((org.bouncycastle.crypto.w.n)localObject2).e(), ((org.bouncycastle.crypto.w.n)localObject2).c());
        }
        else
        {
          localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.asn1.u2.j)localObject3).f(), ((org.bouncycastle.asn1.u2.j)localObject3).k());
          localObject1 = new c(org.bouncycastle.jcajce.provider.asymmetric.util.b.d((m)localObject1), (EllipticCurve)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.asn1.u2.j)localObject3).g()), ((org.bouncycastle.asn1.u2.j)localObject3).j(), ((org.bouncycastle.asn1.u2.j)localObject3).h());
        }
      }
      else
      {
        if (((org.bouncycastle.asn1.u2.h)localObject1).h())
        {
          this.ecSpec = null;
          break label397;
        }
        localObject1 = org.bouncycastle.asn1.u2.j.i(((org.bouncycastle.asn1.u2.h)localObject1).g());
        localObject1 = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.asn1.u2.j)localObject1).f(), ((org.bouncycastle.asn1.u2.j)localObject1).k()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.asn1.u2.j)localObject1).g()), ((org.bouncycastle.asn1.u2.j)localObject1).j(), ((org.bouncycastle.asn1.u2.j)localObject1).h().intValue());
      }
      this.ecSpec = ((ECParameterSpec)localObject1);
      label397:
      paramh = paramh.i();
      if (!(paramh instanceof org.bouncycastle.asn1.j)) {
        break label425;
      }
      paramh = org.bouncycastle.asn1.j.m(paramh).p();
    }
    this.d = paramh;
    return;
    label425:
    paramh = org.bouncycastle.asn1.p2.a.f(paramh);
    this.d = paramh.g();
    this.publicKey = paramh.j();
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
    boolean bool1 = paramObject instanceof BCECGOST3410_2012PrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECGOST3410_2012PrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((BCECGOST3410_2012PrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECGOST3410_2012PrivateKey)paramObject).engineGetSpec())) {
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
    if (this.d.bitLength() > 256) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1;
    if (i != 0) {
      localObject1 = org.bouncycastle.asn1.o2.a.h;
    } else {
      localObject1 = org.bouncycastle.asn1.o2.a.g;
    }
    if (i != 0) {
      i = 64;
    } else {
      i = 32;
    }
    Object localObject3;
    Object localObject4;
    if (this.gostParams != null)
    {
      byte[] arrayOfByte = new byte[i];
      extractBytes(arrayOfByte, i, 0, getS());
      try
      {
        localObject3 = new org/bouncycastle/asn1/n2/h;
        localObject4 = new org/bouncycastle/asn1/x509/a;
        ((org.bouncycastle.asn1.x509.a)localObject4).<init>((m)localObject1, this.gostParams);
        localObject1 = new org/bouncycastle/asn1/x0;
        ((x0)localObject1).<init>(arrayOfByte);
        ((org.bouncycastle.asn1.n2.h)localObject3).<init>((org.bouncycastle.asn1.x509.a)localObject4, (org.bouncycastle.asn1.e)localObject1);
        arrayOfByte = ((l)localObject3).e("DER");
        return arrayOfByte;
      }
      catch (IOException localIOException1)
      {
        return null;
      }
    }
    Object localObject2 = this.ecSpec;
    if ((localObject2 instanceof c))
    {
      localObject3 = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(((c)localObject2).a());
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new m(((c)this.ecSpec).a());
      }
      localObject2 = new org.bouncycastle.asn1.u2.h((m)localObject2);
    }
    else
    {
      if (localObject2 == null)
      {
        localObject2 = new org.bouncycastle.asn1.u2.h(v0.c);
        i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(BouncyCastleProvider.CONFIGURATION, null, getS());
        break label298;
      }
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject2).getCurve());
      localObject2 = new org.bouncycastle.asn1.u2.h(new org.bouncycastle.asn1.u2.j((e.a.b.a.d)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
    }
    int i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
    label298:
    if (this.publicKey != null) {
      localObject3 = new org.bouncycastle.asn1.p2.a(i, getS(), this.publicKey, (org.bouncycastle.asn1.e)localObject2);
    } else {
      localObject3 = new org.bouncycastle.asn1.p2.a(i, getS(), (org.bouncycastle.asn1.e)localObject2);
    }
    try
    {
      localObject4 = new org/bouncycastle/asn1/n2/h;
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      locala.<init>((m)localObject1, ((org.bouncycastle.asn1.u2.h)localObject2).c());
      ((org.bouncycastle.asn1.n2.h)localObject4).<init>(locala, ((org.bouncycastle.asn1.p2.a)localObject3).c());
      localObject2 = ((l)localObject4).e("DER");
      return (byte[])localObject2;
    }
    catch (IOException localIOException2) {}
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost12\BCECGOST3410_2012PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
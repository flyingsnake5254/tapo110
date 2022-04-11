package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

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

public class BCECGOST3410PrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.b
{
  static final long serialVersionUID = 7245981689601667138L;
  private String algorithm = "ECGOST3410";
  private transient org.bouncycastle.jcajce.provider.asymmetric.util.d attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  private transient BigInteger d;
  private transient ECParameterSpec ecSpec;
  private transient org.bouncycastle.asn1.e gostParams;
  private transient n0 publicKey;
  private boolean withCompression;
  
  protected BCECGOST3410PrivateKey() {}
  
  public BCECGOST3410PrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    this.ecSpec = null;
  }
  
  public BCECGOST3410PrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr, BCECGOST3410PublicKey paramBCECGOST3410PublicKey, ECParameterSpec paramECParameterSpec)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    paramString = paramECParameterSpec;
    if (paramECParameterSpec == null)
    {
      paramString = paramr.b();
      paramString = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramString.a(), paramString.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramString.b()), paramString.e(), paramString.c().intValue());
    }
    this.ecSpec = paramString;
    this.gostParams = paramBCECGOST3410PublicKey.getGostParams();
    this.publicKey = getPublicKeyDetails(paramBCECGOST3410PublicKey);
  }
  
  public BCECGOST3410PrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr, BCECGOST3410PublicKey paramBCECGOST3410PublicKey, org.bouncycastle.jce.spec.d paramd)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    if (paramd == null)
    {
      paramString = paramr.b();
      this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramString.a(), paramString.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramString.b()), paramString.e(), paramString.c().intValue());
    }
    else
    {
      this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramd.a(), paramd.e()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramd.b()), paramd.d(), paramd.c().intValue());
    }
    this.gostParams = paramBCECGOST3410PublicKey.getGostParams();
    this.publicKey = getPublicKeyDetails(paramBCECGOST3410PublicKey);
  }
  
  public BCECGOST3410PrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
  }
  
  public BCECGOST3410PrivateKey(ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
  }
  
  BCECGOST3410PrivateKey(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    populateFromPrivKeyInfo(paramh);
  }
  
  public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey paramBCECGOST3410PrivateKey)
  {
    this.d = paramBCECGOST3410PrivateKey.d;
    this.ecSpec = paramBCECGOST3410PrivateKey.ecSpec;
    this.withCompression = paramBCECGOST3410PrivateKey.withCompression;
    this.attrCarrier = paramBCECGOST3410PrivateKey.attrCarrier;
    this.publicKey = paramBCECGOST3410PrivateKey.publicKey;
    this.gostParams = paramBCECGOST3410PrivateKey.gostParams;
  }
  
  public BCECGOST3410PrivateKey(org.bouncycastle.jce.spec.e parame)
  {
    throw null;
  }
  
  private void extractBytes(byte[] paramArrayOfByte, int paramInt, BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    int i = arrayOfByte.length;
    int j = 0;
    int k = j;
    paramBigInteger = arrayOfByte;
    if (i < 32)
    {
      paramBigInteger = new byte[32];
      System.arraycopy(arrayOfByte, 0, paramBigInteger, 32 - arrayOfByte.length, arrayOfByte.length);
    }
    for (k = j; k != 32; k++) {
      paramArrayOfByte[(paramInt + k)] = ((byte)paramBigInteger[(paramBigInteger.length - 1 - k)]);
    }
  }
  
  private n0 getPublicKeyDetails(BCECGOST3410PublicKey paramBCECGOST3410PublicKey)
  {
    try
    {
      paramBCECGOST3410PublicKey = w.h(q.i(paramBCECGOST3410PublicKey.getEncoded())).i();
      return paramBCECGOST3410PublicKey;
    }
    catch (IOException paramBCECGOST3410PublicKey) {}
    return null;
  }
  
  private void populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    Object localObject1 = paramh.h().i();
    Object localObject2 = ((org.bouncycastle.asn1.e)localObject1).c();
    if (((localObject2 instanceof org.bouncycastle.asn1.r)) && ((org.bouncycastle.asn1.r.m(localObject2).size() == 2) || (org.bouncycastle.asn1.r.m(localObject2).size() == 3)))
    {
      org.bouncycastle.asn1.d2.e locale = org.bouncycastle.asn1.d2.e.h(localObject1);
      this.gostParams = locale;
      localObject1 = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(locale.i()));
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.jce.spec.d)localObject1).a(), ((org.bouncycastle.jce.spec.d)localObject1).e());
      this.ecSpec = new c(org.bouncycastle.asn1.d2.b.c(locale.i()), (EllipticCurve)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.jce.spec.d)localObject1).b()), ((org.bouncycastle.jce.spec.d)localObject1).d(), ((org.bouncycastle.jce.spec.d)localObject1).c());
      paramh = paramh.i();
      if ((paramh instanceof org.bouncycastle.asn1.j))
      {
        paramh = org.bouncycastle.asn1.j.m(paramh).o();
      }
      else
      {
        paramh = org.bouncycastle.asn1.n.m(paramh).o();
        localObject2 = new byte[paramh.length];
        for (int i = 0; i != paramh.length; i++) {
          localObject2[i] = ((byte)paramh[(paramh.length - 1 - i)]);
        }
        paramh = new BigInteger(1, (byte[])localObject2);
      }
    }
    else
    {
      localObject2 = org.bouncycastle.asn1.u2.h.f(localObject1);
      if (((org.bouncycastle.asn1.u2.h)localObject2).i())
      {
        localObject1 = m.r(((org.bouncycastle.asn1.u2.h)localObject2).g());
        localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.b.g((m)localObject1);
        if (localObject2 == null)
        {
          localObject2 = org.bouncycastle.asn1.d2.b.b((m)localObject1);
          localObject2 = new org.bouncycastle.asn1.u2.j(((org.bouncycastle.crypto.w.n)localObject2).a(), ((org.bouncycastle.crypto.w.n)localObject2).b(), ((org.bouncycastle.crypto.w.n)localObject2).e(), ((org.bouncycastle.crypto.w.n)localObject2).c(), ((org.bouncycastle.crypto.w.n)localObject2).f());
          localObject1 = org.bouncycastle.asn1.d2.b.c((m)localObject1);
        }
        else
        {
          localObject1 = org.bouncycastle.jcajce.provider.asymmetric.util.b.d((m)localObject1);
        }
        localObject2 = new c((String)localObject1, org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.asn1.u2.j)localObject2).f(), ((org.bouncycastle.asn1.u2.j)localObject2).k()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.asn1.u2.j)localObject2).g()), ((org.bouncycastle.asn1.u2.j)localObject2).j(), ((org.bouncycastle.asn1.u2.j)localObject2).h());
      }
      else
      {
        if (!((org.bouncycastle.asn1.u2.h)localObject2).h()) {
          break label324;
        }
        localObject2 = null;
      }
      this.ecSpec = ((ECParameterSpec)localObject2);
      break label372;
      label324:
      localObject2 = org.bouncycastle.asn1.u2.j.i(((org.bouncycastle.asn1.u2.h)localObject2).g());
      this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.asn1.u2.j)localObject2).f(), ((org.bouncycastle.asn1.u2.j)localObject2).k()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.asn1.u2.j)localObject2).g()), ((org.bouncycastle.asn1.u2.j)localObject2).j(), ((org.bouncycastle.asn1.u2.j)localObject2).h().intValue());
      label372:
      paramh = paramh.i();
      if (!(paramh instanceof org.bouncycastle.asn1.j)) {
        break label400;
      }
      paramh = org.bouncycastle.asn1.j.m(paramh).p();
    }
    this.d = paramh;
    return;
    label400:
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
    boolean bool1 = paramObject instanceof BCECGOST3410PrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECGOST3410PrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((BCECGOST3410PrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECGOST3410PrivateKey)paramObject).engineGetSpec())) {
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
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.gostParams != null)
    {
      localObject1 = new byte[32];
      extractBytes((byte[])localObject1, 0, getS());
      try
      {
        localObject2 = new org/bouncycastle/asn1/n2/h;
        localObject3 = new org/bouncycastle/asn1/x509/a;
        ((org.bouncycastle.asn1.x509.a)localObject3).<init>(org.bouncycastle.asn1.d2.a.m, this.gostParams);
        Object localObject4 = new org/bouncycastle/asn1/x0;
        ((x0)localObject4).<init>((byte[])localObject1);
        ((org.bouncycastle.asn1.n2.h)localObject2).<init>((org.bouncycastle.asn1.x509.a)localObject3, (org.bouncycastle.asn1.e)localObject4);
        localObject4 = ((l)localObject2).e("DER");
        return (byte[])localObject4;
      }
      catch (IOException localIOException1)
      {
        return null;
      }
    }
    Object localObject5 = this.ecSpec;
    if ((localObject5 instanceof c))
    {
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(((c)localObject5).a());
      localObject5 = localObject2;
      if (localObject2 == null) {
        localObject5 = new m(((c)this.ecSpec).a());
      }
      localObject5 = new org.bouncycastle.asn1.u2.h((m)localObject5);
    }
    else
    {
      if (localObject5 == null)
      {
        localObject5 = new org.bouncycastle.asn1.u2.h(v0.c);
        i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(BouncyCastleProvider.CONFIGURATION, null, getS());
        break label265;
      }
      localObject5 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject5).getCurve());
      localObject5 = new org.bouncycastle.asn1.u2.h(new org.bouncycastle.asn1.u2.j((e.a.b.a.d)localObject5, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject5, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
    }
    int i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
    label265:
    if (this.publicKey != null) {
      localObject2 = new org.bouncycastle.asn1.p2.a(i, getS(), this.publicKey, (org.bouncycastle.asn1.e)localObject5);
    } else {
      localObject2 = new org.bouncycastle.asn1.p2.a(i, getS(), (org.bouncycastle.asn1.e)localObject5);
    }
    try
    {
      localObject3 = new org/bouncycastle/asn1/n2/h;
      localObject1 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>(org.bouncycastle.asn1.d2.a.m, ((org.bouncycastle.asn1.u2.h)localObject5).c());
      ((org.bouncycastle.asn1.n2.h)localObject3).<init>((org.bouncycastle.asn1.x509.a)localObject1, ((org.bouncycastle.asn1.p2.a)localObject2).c());
      localObject5 = ((l)localObject3).e("DER");
      return (byte[])localObject5;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost\BCECGOST3410PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
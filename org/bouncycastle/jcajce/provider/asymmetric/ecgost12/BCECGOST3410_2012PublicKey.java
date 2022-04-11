package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.p;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.f;

public class BCECGOST3410_2012PublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey
{
  static final long serialVersionUID = 7026240464295649314L;
  private String algorithm = "ECGOST3410-2012";
  private transient s ecPublicKey;
  private transient ECParameterSpec ecSpec;
  private transient org.bouncycastle.asn1.d2.e gostParams;
  private boolean withCompression;
  
  public BCECGOST3410_2012PublicKey(String paramString, s params)
  {
    this.algorithm = paramString;
    this.ecPublicKey = params;
    this.ecSpec = null;
  }
  
  public BCECGOST3410_2012PublicKey(String paramString, s params, ECParameterSpec paramECParameterSpec)
  {
    org.bouncycastle.crypto.w.n localn = params.b();
    this.algorithm = paramString;
    this.ecPublicKey = params;
    if (paramECParameterSpec == null) {
      this.ecSpec = createSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), localn);
    } else {
      this.ecSpec = paramECParameterSpec;
    }
  }
  
  public BCECGOST3410_2012PublicKey(String paramString, s params, org.bouncycastle.jce.spec.d paramd)
  {
    org.bouncycastle.crypto.w.n localn = params.b();
    this.algorithm = paramString;
    this.ecPublicKey = params;
    if (paramd == null) {
      paramString = createSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), localn);
    } else {
      paramString = org.bouncycastle.jcajce.provider.asymmetric.util.a.g(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramd.a(), paramd.e()), paramd);
    }
    this.ecSpec = paramString;
  }
  
  public BCECGOST3410_2012PublicKey(java.security.interfaces.ECPublicKey paramECPublicKey)
  {
    this.algorithm = paramECPublicKey.getAlgorithm();
    ECParameterSpec localECParameterSpec = paramECPublicKey.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new s(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(localECParameterSpec, paramECPublicKey.getW(), false), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(null, paramECPublicKey.getParams()));
  }
  
  public BCECGOST3410_2012PublicKey(ECPublicKeySpec paramECPublicKeySpec)
  {
    ECParameterSpec localECParameterSpec = paramECPublicKeySpec.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new s(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(localECParameterSpec, paramECPublicKeySpec.getW(), false), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(null, paramECPublicKeySpec.getParams()));
  }
  
  BCECGOST3410_2012PublicKey(w paramw)
  {
    populateFromPubKeyInfo(paramw);
  }
  
  public BCECGOST3410_2012PublicKey(BCECGOST3410_2012PublicKey paramBCECGOST3410_2012PublicKey)
  {
    this.ecPublicKey = paramBCECGOST3410_2012PublicKey.ecPublicKey;
    this.ecSpec = paramBCECGOST3410_2012PublicKey.ecSpec;
    this.withCompression = paramBCECGOST3410_2012PublicKey.withCompression;
    this.gostParams = paramBCECGOST3410_2012PublicKey.gostParams;
  }
  
  public BCECGOST3410_2012PublicKey(f paramf, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    throw null;
  }
  
  private ECParameterSpec createSpec(EllipticCurve paramEllipticCurve, org.bouncycastle.crypto.w.n paramn)
  {
    return new ECParameterSpec(paramEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramn.b()), paramn.e(), paramn.c().intValue());
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
  
  private void populateFromPubKeyInfo(w paramw)
  {
    Object localObject1 = paramw.f().f();
    Object localObject2 = paramw.i();
    this.algorithm = "ECGOST3410-2012";
    try
    {
      localObject2 = (org.bouncycastle.asn1.n)q.i(((org.bouncycastle.asn1.b)localObject2).o());
      localObject2 = ((org.bouncycastle.asn1.n)localObject2).o();
      int i = 32;
      if (((q)localObject1).equals(org.bouncycastle.asn1.o2.a.h)) {
        i = 64;
      }
      int j = i * 2;
      localObject1 = new byte[j + 1];
      localObject1[0] = ((byte)4);
      for (int k = 1; k <= i; k++)
      {
        localObject1[k] = ((byte)localObject2[(i - k)]);
        localObject1[(k + i)] = ((byte)localObject2[(j - k)]);
      }
      paramw = org.bouncycastle.asn1.d2.e.h(paramw.f().i());
      this.gostParams = paramw;
      paramw = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(paramw.i()));
      localObject2 = paramw.a();
      EllipticCurve localEllipticCurve = org.bouncycastle.jcajce.provider.asymmetric.util.a.a((e.a.b.a.d)localObject2, paramw.e());
      this.ecPublicKey = new s(((e.a.b.a.d)localObject2).k((byte[])localObject1), org.bouncycastle.jcajce.provider.asymmetric.util.b.f(null, paramw));
      this.ecSpec = new org.bouncycastle.jce.spec.c(org.bouncycastle.asn1.d2.b.c(this.gostParams.i()), localEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramw.b()), paramw.d(), paramw.c());
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("error recovering public key");
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    populateFromPubKeyInfo(w.h(q.i((byte[])paramObjectInputStream.readObject())));
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(getEncoded());
  }
  
  s engineGetKeyParameters()
  {
    return this.ecPublicKey;
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
    boolean bool1 = paramObject instanceof BCECGOST3410_2012PublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECGOST3410_2012PublicKey)paramObject;
    bool1 = bool2;
    if (this.ecPublicKey.c().e(((BCECGOST3410_2012PublicKey)paramObject).ecPublicKey.c()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECGOST3410_2012PublicKey)paramObject).engineGetSpec())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  public byte[] getEncoded()
  {
    BigInteger localBigInteger = this.ecPublicKey.c().f().t();
    Object localObject1 = this.ecPublicKey.c().g().t();
    int i;
    if (localBigInteger.bitLength() > 256) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2 = getGostParams();
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.ecSpec;
      if ((localObject2 instanceof org.bouncycastle.jce.spec.c))
      {
        localObject3 = new org/bouncycastle/asn1/d2/e;
        localObject2 = org.bouncycastle.asn1.d2.b.d(((org.bouncycastle.jce.spec.c)localObject2).a());
        if (i != 0) {
          ((org.bouncycastle.asn1.d2.e)localObject3).<init>((m)localObject2, org.bouncycastle.asn1.o2.a.d);
        } else {
          ((org.bouncycastle.asn1.d2.e)localObject3).<init>((m)localObject2, org.bouncycastle.asn1.o2.a.c);
        }
      }
      else
      {
        localObject3 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject2).getCurve());
        localObject3 = new org.bouncycastle.asn1.u2.h(new j((e.a.b.a.d)localObject3, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject3, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
      }
    }
    int j = 64;
    if (i != 0)
    {
      localObject2 = org.bouncycastle.asn1.o2.a.h;
      i = 64;
      j = 128;
    }
    else
    {
      i = 32;
      localObject2 = org.bouncycastle.asn1.o2.a.g;
    }
    byte[] arrayOfByte = new byte[j];
    j /= 2;
    extractBytes(arrayOfByte, j, 0, localBigInteger);
    extractBytes(arrayOfByte, j, i, (BigInteger)localObject1);
    try
    {
      localObject1 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>((m)localObject2, (org.bouncycastle.asn1.e)localObject3);
      localObject3 = new org/bouncycastle/asn1/x0;
      ((x0)localObject3).<init>(arrayOfByte);
      localObject3 = new w((org.bouncycastle.asn1.x509.a)localObject1, (org.bouncycastle.asn1.e)localObject3);
      return org.bouncycastle.jcajce.provider.asymmetric.util.c.d((w)localObject3);
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public org.bouncycastle.asn1.d2.e getGostParams()
  {
    if ((this.gostParams == null) && ((this.ecSpec instanceof org.bouncycastle.jce.spec.c)))
    {
      int i;
      if (this.ecPublicKey.c().f().t().bitLength() > 256) {
        i = 1;
      } else {
        i = 0;
      }
      org.bouncycastle.asn1.d2.e locale;
      if (i != 0) {
        locale = new org.bouncycastle.asn1.d2.e(org.bouncycastle.asn1.d2.b.d(((org.bouncycastle.jce.spec.c)this.ecSpec).a()), org.bouncycastle.asn1.o2.a.d);
      } else {
        locale = new org.bouncycastle.asn1.d2.e(org.bouncycastle.asn1.d2.b.d(((org.bouncycastle.jce.spec.c)this.ecSpec).a()), org.bouncycastle.asn1.o2.a.c);
      }
      this.gostParams = locale;
    }
    return this.gostParams;
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
  
  public e.a.b.a.h getQ()
  {
    if (this.ecSpec == null) {
      return this.ecPublicKey.c().k();
    }
    return this.ecPublicKey.c();
  }
  
  public ECPoint getW()
  {
    return org.bouncycastle.jcajce.provider.asymmetric.util.a.d(this.ecPublicKey.c());
  }
  
  public int hashCode()
  {
    return this.ecPublicKey.c().hashCode() ^ engineGetSpec().hashCode();
  }
  
  public void setPointFormat(String paramString)
  {
    this.withCompression = ("UNCOMPRESSED".equalsIgnoreCase(paramString) ^ true);
  }
  
  public String toString()
  {
    return org.bouncycastle.jcajce.provider.asymmetric.util.b.k(this.algorithm, this.ecPublicKey.c(), engineGetSpec());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost12\BCECGOST3410_2012PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
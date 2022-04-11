package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

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

public class BCECGOST3410PublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey
{
  static final long serialVersionUID = 7026240464295649314L;
  private String algorithm = "ECGOST3410";
  private transient s ecPublicKey;
  private transient ECParameterSpec ecSpec;
  private transient org.bouncycastle.asn1.e gostParams;
  private boolean withCompression;
  
  public BCECGOST3410PublicKey(String paramString, s params)
  {
    this.algorithm = paramString;
    this.ecPublicKey = params;
    this.ecSpec = null;
  }
  
  public BCECGOST3410PublicKey(String paramString, s params, ECParameterSpec paramECParameterSpec)
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
  
  public BCECGOST3410PublicKey(String paramString, s params, org.bouncycastle.jce.spec.d paramd)
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
  
  public BCECGOST3410PublicKey(java.security.interfaces.ECPublicKey paramECPublicKey)
  {
    this.algorithm = paramECPublicKey.getAlgorithm();
    ECParameterSpec localECParameterSpec = paramECPublicKey.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new s(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(localECParameterSpec, paramECPublicKey.getW(), false), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(null, paramECPublicKey.getParams()));
  }
  
  public BCECGOST3410PublicKey(ECPublicKeySpec paramECPublicKeySpec)
  {
    ECParameterSpec localECParameterSpec = paramECPublicKeySpec.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new s(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(localECParameterSpec, paramECPublicKeySpec.getW(), false), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(null, paramECPublicKeySpec.getParams()));
  }
  
  BCECGOST3410PublicKey(w paramw)
  {
    populateFromPubKeyInfo(paramw);
  }
  
  public BCECGOST3410PublicKey(BCECGOST3410PublicKey paramBCECGOST3410PublicKey)
  {
    this.ecPublicKey = paramBCECGOST3410PublicKey.ecPublicKey;
    this.ecSpec = paramBCECGOST3410PublicKey.ecSpec;
    this.withCompression = paramBCECGOST3410PublicKey.withCompression;
    this.gostParams = paramBCECGOST3410PublicKey.gostParams;
  }
  
  public BCECGOST3410PublicKey(f paramf, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    throw null;
  }
  
  private ECParameterSpec createSpec(EllipticCurve paramEllipticCurve, org.bouncycastle.crypto.w.n paramn)
  {
    return new ECParameterSpec(paramEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramn.b()), paramn.e(), paramn.c().intValue());
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
  
  private void populateFromPubKeyInfo(w paramw)
  {
    Object localObject1 = paramw.i();
    this.algorithm = "ECGOST3410";
    try
    {
      localObject1 = (org.bouncycastle.asn1.n)q.i(((org.bouncycastle.asn1.b)localObject1).o());
      Object localObject2 = ((org.bouncycastle.asn1.n)localObject1).o();
      localObject1 = new byte[65];
      localObject1[0] = ((byte)4);
      for (int i = 1; i <= 32; i++)
      {
        localObject1[i] = ((byte)localObject2[(32 - i)]);
        localObject1[(i + 32)] = ((byte)localObject2[(64 - i)]);
      }
      boolean bool = paramw.f().i() instanceof m;
      paramw = paramw.f().i();
      if (bool)
      {
        paramw = m.r(paramw);
        this.gostParams = paramw;
      }
      else
      {
        paramw = org.bouncycastle.asn1.d2.e.h(paramw);
        this.gostParams = paramw;
        paramw = paramw.i();
      }
      org.bouncycastle.jce.spec.b localb = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(paramw));
      e.a.b.a.d locald = localb.a();
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(locald, localb.e());
      this.ecPublicKey = new s(locald.k((byte[])localObject1), org.bouncycastle.jcajce.provider.asymmetric.util.b.f(null, localb));
      this.ecSpec = new org.bouncycastle.jce.spec.c(org.bouncycastle.asn1.d2.b.c(paramw), (EllipticCurve)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(localb.b()), localb.d(), localb.c());
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
    boolean bool1 = paramObject instanceof BCECGOST3410PublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECGOST3410PublicKey)paramObject;
    bool1 = bool2;
    if (this.ecPublicKey.c().e(((BCECGOST3410PublicKey)paramObject).ecPublicKey.c()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECGOST3410PublicKey)paramObject).engineGetSpec())) {
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
    Object localObject1 = getGostParams();
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.ecSpec;
      if ((localObject2 instanceof org.bouncycastle.jce.spec.c))
      {
        localObject2 = new org.bouncycastle.asn1.d2.e(org.bouncycastle.asn1.d2.b.d(((org.bouncycastle.jce.spec.c)localObject2).a()), org.bouncycastle.asn1.d2.a.p);
      }
      else
      {
        localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject2).getCurve());
        localObject2 = new org.bouncycastle.asn1.u2.h(new j((e.a.b.a.d)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
      }
    }
    Object localObject3 = this.ecPublicKey.c().f().t();
    BigInteger localBigInteger = this.ecPublicKey.c().g().t();
    localObject1 = new byte[64];
    extractBytes((byte[])localObject1, 0, (BigInteger)localObject3);
    extractBytes((byte[])localObject1, 32, localBigInteger);
    try
    {
      localObject3 = new org/bouncycastle/asn1/x509/a;
      ((org.bouncycastle.asn1.x509.a)localObject3).<init>(org.bouncycastle.asn1.d2.a.m, (org.bouncycastle.asn1.e)localObject2);
      localObject2 = new org/bouncycastle/asn1/x0;
      ((x0)localObject2).<init>((byte[])localObject1);
      localObject2 = new w((org.bouncycastle.asn1.x509.a)localObject3, (org.bouncycastle.asn1.e)localObject2);
      return org.bouncycastle.jcajce.provider.asymmetric.util.c.d((w)localObject2);
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  org.bouncycastle.asn1.e getGostParams()
  {
    if (this.gostParams == null)
    {
      ECParameterSpec localECParameterSpec = this.ecSpec;
      if ((localECParameterSpec instanceof org.bouncycastle.jce.spec.c)) {
        this.gostParams = new org.bouncycastle.asn1.d2.e(org.bouncycastle.asn1.d2.b.d(((org.bouncycastle.jce.spec.c)localECParameterSpec).a()), org.bouncycastle.asn1.d2.a.p);
      }
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost\BCECGOST3410PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import e.a.b.a.d.e;
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
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.p;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BCDSTU4145PublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey
{
  static final long serialVersionUID = 7026240464295649314L;
  private String algorithm = "DSTU4145";
  private transient org.bouncycastle.asn1.r2.d dstuParams;
  private transient s ecPublicKey;
  private transient ECParameterSpec ecSpec;
  private boolean withCompression;
  
  public BCDSTU4145PublicKey(String paramString, s params)
  {
    this.algorithm = paramString;
    this.ecPublicKey = params;
    this.ecSpec = null;
  }
  
  public BCDSTU4145PublicKey(String paramString, s params, ECParameterSpec paramECParameterSpec)
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
  
  public BCDSTU4145PublicKey(String paramString, s params, org.bouncycastle.jce.spec.d paramd)
  {
    org.bouncycastle.crypto.w.n localn = params.b();
    this.algorithm = paramString;
    if (paramd == null) {
      paramString = createSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), localn);
    } else {
      paramString = org.bouncycastle.jcajce.provider.asymmetric.util.a.g(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramd.a(), paramd.e()), paramd);
    }
    this.ecSpec = paramString;
    this.ecPublicKey = params;
  }
  
  public BCDSTU4145PublicKey(ECPublicKeySpec paramECPublicKeySpec)
  {
    ECParameterSpec localECParameterSpec = paramECPublicKeySpec.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new s(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(localECParameterSpec, paramECPublicKeySpec.getW(), false), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(null, this.ecSpec));
  }
  
  BCDSTU4145PublicKey(w paramw)
  {
    populateFromPubKeyInfo(paramw);
  }
  
  public BCDSTU4145PublicKey(BCDSTU4145PublicKey paramBCDSTU4145PublicKey)
  {
    this.ecPublicKey = paramBCDSTU4145PublicKey.ecPublicKey;
    this.ecSpec = paramBCDSTU4145PublicKey.ecSpec;
    this.withCompression = paramBCDSTU4145PublicKey.withCompression;
    this.dstuParams = paramBCDSTU4145PublicKey.dstuParams;
  }
  
  public BCDSTU4145PublicKey(org.bouncycastle.jce.spec.f paramf, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    throw null;
  }
  
  private ECParameterSpec createSpec(EllipticCurve paramEllipticCurve, org.bouncycastle.crypto.w.n paramn)
  {
    return new ECParameterSpec(paramEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramn.b()), paramn.e(), paramn.c().intValue());
  }
  
  private void populateFromPubKeyInfo(w paramw)
  {
    Object localObject1 = paramw.i();
    this.algorithm = "DSTU4145";
    try
    {
      localObject1 = (org.bouncycastle.asn1.n)q.i(((org.bouncycastle.asn1.b)localObject1).o());
      localObject1 = ((org.bouncycastle.asn1.n)localObject1).o();
      Object localObject2 = paramw.f().f();
      Object localObject3 = org.bouncycastle.asn1.r2.f.b;
      if (((q)localObject2).equals(localObject3)) {
        reverseBytes((byte[])localObject1);
      }
      localObject2 = org.bouncycastle.asn1.r2.d.i((r)paramw.f().i());
      this.dstuParams = ((org.bouncycastle.asn1.r2.d)localObject2);
      if (((org.bouncycastle.asn1.r2.d)localObject2).k())
      {
        localObject3 = this.dstuParams.j();
        paramw = org.bouncycastle.asn1.r2.c.a((m)localObject3);
        paramw = new org.bouncycastle.jce.spec.b(((m)localObject3).q(), paramw.a(), paramw.b(), paramw.e(), paramw.c(), paramw.f());
      }
      else
      {
        localObject2 = this.dstuParams.h();
        byte[] arrayOfByte = ((org.bouncycastle.asn1.r2.b)localObject2).g();
        if (paramw.f().f().equals(localObject3)) {
          reverseBytes(arrayOfByte);
        }
        Object localObject4 = ((org.bouncycastle.asn1.r2.b)localObject2).h();
        localObject4 = new d.e(((org.bouncycastle.asn1.r2.a)localObject4).j(), ((org.bouncycastle.asn1.r2.a)localObject4).g(), ((org.bouncycastle.asn1.r2.a)localObject4).h(), ((org.bouncycastle.asn1.r2.a)localObject4).i(), ((org.bouncycastle.asn1.r2.b)localObject2).f(), new BigInteger(1, arrayOfByte));
        arrayOfByte = ((org.bouncycastle.asn1.r2.b)localObject2).i();
        if (paramw.f().f().equals(localObject3)) {
          reverseBytes(arrayOfByte);
        }
        paramw = new org.bouncycastle.jce.spec.d((e.a.b.a.d)localObject4, org.bouncycastle.asn1.r2.e.a((e.a.b.a.d)localObject4, arrayOfByte), ((org.bouncycastle.asn1.r2.b)localObject2).k());
      }
      localObject3 = paramw.a();
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a((e.a.b.a.d)localObject3, paramw.e());
      if (this.dstuParams.k()) {
        paramw = new org.bouncycastle.jce.spec.c(this.dstuParams.j().q(), (EllipticCurve)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramw.b()), paramw.d(), paramw.c());
      } else {
        paramw = new ECParameterSpec((EllipticCurve)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramw.b()), paramw.d(), paramw.c().intValue());
      }
      this.ecSpec = paramw;
      this.ecPublicKey = new s(org.bouncycastle.asn1.r2.e.a((e.a.b.a.d)localObject3, (byte[])localObject1), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(null, this.ecSpec));
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
  
  private void reverseBytes(byte[] paramArrayOfByte)
  {
    for (int i = 0; i < paramArrayOfByte.length / 2; i++)
    {
      int j = paramArrayOfByte[i];
      paramArrayOfByte[i] = ((byte)paramArrayOfByte[(paramArrayOfByte.length - 1 - i)]);
      paramArrayOfByte[(paramArrayOfByte.length - 1 - i)] = ((byte)j);
    }
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
    boolean bool1 = paramObject instanceof BCDSTU4145PublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCDSTU4145PublicKey)paramObject;
    bool1 = bool2;
    if (this.ecPublicKey.c().e(((BCDSTU4145PublicKey)paramObject).ecPublicKey.c()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCDSTU4145PublicKey)paramObject).engineGetSpec())) {
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
    Object localObject = this.dstuParams;
    if (localObject == null)
    {
      localObject = this.ecSpec;
      if ((localObject instanceof org.bouncycastle.jce.spec.c))
      {
        localObject = new org.bouncycastle.asn1.r2.d(new m(((org.bouncycastle.jce.spec.c)this.ecSpec).a()));
      }
      else
      {
        localObject = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject).getCurve());
        localObject = new org.bouncycastle.asn1.u2.h(new j((e.a.b.a.d)localObject, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
      }
    }
    byte[] arrayOfByte = org.bouncycastle.asn1.r2.e.b(this.ecPublicKey.c());
    try
    {
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      locala.<init>(org.bouncycastle.asn1.r2.f.c, (org.bouncycastle.asn1.e)localObject);
      localObject = new org/bouncycastle/asn1/x0;
      ((x0)localObject).<init>(arrayOfByte);
      localObject = new w(locala, (org.bouncycastle.asn1.e)localObject);
      return org.bouncycastle.jcajce.provider.asymmetric.util.c.d((w)localObject);
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
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
    e.a.b.a.h localh1 = this.ecPublicKey.c();
    e.a.b.a.h localh2 = localh1;
    if (this.ecSpec == null) {
      localh2 = localh1.k();
    }
    return localh2;
  }
  
  public byte[] getSbox()
  {
    org.bouncycastle.asn1.r2.d locald = this.dstuParams;
    if (locald != null) {
      return locald.f();
    }
    return org.bouncycastle.asn1.r2.d.g();
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dstu\BCDSTU4145PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
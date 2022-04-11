package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.l;
import org.bouncycastle.asn1.u2.o;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.f;

public class BCECPublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey
{
  static final long serialVersionUID = 2422789860422731812L;
  private String algorithm = "EC";
  private transient org.bouncycastle.jcajce.provider.config.b configuration;
  private transient s ecPublicKey;
  private transient ECParameterSpec ecSpec;
  private boolean withCompression;
  
  public BCECPublicKey(String paramString, ECPublicKeySpec paramECPublicKeySpec, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    paramString = paramECPublicKeySpec.getParams();
    this.ecSpec = paramString;
    this.ecPublicKey = new s(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(paramString, paramECPublicKeySpec.getW(), false), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(paramb, paramECPublicKeySpec.getParams()));
    this.configuration = paramb;
  }
  
  BCECPublicKey(String paramString, w paramw, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    this.configuration = paramb;
    populateFromPubKeyInfo(paramw);
  }
  
  public BCECPublicKey(String paramString, s params, ECParameterSpec paramECParameterSpec, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    org.bouncycastle.crypto.w.n localn = params.b();
    this.algorithm = paramString;
    this.ecPublicKey = params;
    if (paramECParameterSpec == null) {
      this.ecSpec = createSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), localn);
    } else {
      this.ecSpec = paramECParameterSpec;
    }
    this.configuration = paramb;
  }
  
  public BCECPublicKey(String paramString, s params, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    this.ecPublicKey = params;
    this.ecSpec = null;
    this.configuration = paramb;
  }
  
  public BCECPublicKey(String paramString, s params, org.bouncycastle.jce.spec.d paramd, org.bouncycastle.jcajce.provider.config.b paramb)
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
    this.configuration = paramb;
  }
  
  public BCECPublicKey(String paramString, BCECPublicKey paramBCECPublicKey)
  {
    this.algorithm = paramString;
    this.ecPublicKey = paramBCECPublicKey.ecPublicKey;
    this.ecSpec = paramBCECPublicKey.ecSpec;
    this.withCompression = paramBCECPublicKey.withCompression;
    this.configuration = paramBCECPublicKey.configuration;
  }
  
  public BCECPublicKey(String paramString, f paramf, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    throw null;
  }
  
  public BCECPublicKey(java.security.interfaces.ECPublicKey paramECPublicKey, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramECPublicKey.getAlgorithm();
    ECParameterSpec localECParameterSpec = paramECPublicKey.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new s(org.bouncycastle.jcajce.provider.asymmetric.util.a.e(localECParameterSpec, paramECPublicKey.getW(), false), org.bouncycastle.jcajce.provider.asymmetric.util.a.k(paramb, paramECPublicKey.getParams()));
  }
  
  private ECParameterSpec createSpec(EllipticCurve paramEllipticCurve, org.bouncycastle.crypto.w.n paramn)
  {
    return new ECParameterSpec(paramEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramn.b()), paramn.e(), paramn.c().intValue());
  }
  
  private void populateFromPubKeyInfo(w paramw)
  {
    org.bouncycastle.asn1.u2.h localh = org.bouncycastle.asn1.u2.h.f(paramw.f().i());
    e.a.b.a.d locald = org.bouncycastle.jcajce.provider.asymmetric.util.a.j(this.configuration, localh);
    this.ecSpec = org.bouncycastle.jcajce.provider.asymmetric.util.a.i(localh, locald);
    byte[] arrayOfByte = paramw.i().o();
    x0 localx0 = new x0(arrayOfByte);
    paramw = localx0;
    if (arrayOfByte[0] == 4)
    {
      paramw = localx0;
      if (arrayOfByte[1] == arrayOfByte.length - 2) {
        if (arrayOfByte[2] != 2)
        {
          paramw = localx0;
          if (arrayOfByte[2] != 3) {}
        }
        else
        {
          paramw = localx0;
          if (new o().a(locald) >= arrayOfByte.length - 3) {
            try
            {
              paramw = (org.bouncycastle.asn1.n)q.i(arrayOfByte);
            }
            catch (IOException paramw)
            {
              throw new IllegalArgumentException("error recovering public key");
            }
          }
        }
      }
    }
    this.ecPublicKey = new s(new l(locald, paramw).f(), org.bouncycastle.jcajce.provider.asymmetric.util.b.e(this.configuration, localh));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream = (byte[])paramObjectInputStream.readObject();
    this.configuration = BouncyCastleProvider.CONFIGURATION;
    populateFromPubKeyInfo(w.h(q.i(paramObjectInputStream)));
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
    return this.configuration.b();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCECPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECPublicKey)paramObject;
    bool1 = bool2;
    if (this.ecPublicKey.c().e(((BCECPublicKey)paramObject).ecPublicKey.c()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECPublicKey)paramObject).engineGetSpec())) {
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
    org.bouncycastle.asn1.u2.h localh = a.a(this.ecSpec, this.withCompression);
    org.bouncycastle.asn1.n localn = org.bouncycastle.asn1.n.m(new l(this.ecPublicKey.c(), this.withCompression).c());
    return c.d(new w(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.u2.p.B2, localh), localn.o()));
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
    return org.bouncycastle.jcajce.provider.asymmetric.util.b.k("EC", this.ecPublicKey.c(), engineGetSpec());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\BCECPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
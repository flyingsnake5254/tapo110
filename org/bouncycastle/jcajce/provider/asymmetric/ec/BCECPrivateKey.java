package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n0;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.crypto.w.r;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BCECPrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.b
{
  static final long serialVersionUID = 994553197664784084L;
  private String algorithm = "EC";
  private transient org.bouncycastle.jcajce.provider.asymmetric.util.d attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  private transient org.bouncycastle.jcajce.provider.config.b configuration;
  private transient BigInteger d;
  private transient ECParameterSpec ecSpec;
  private transient n0 publicKey;
  private boolean withCompression;
  
  protected BCECPrivateKey() {}
  
  public BCECPrivateKey(String paramString, ECPrivateKeySpec paramECPrivateKeySpec, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
    this.configuration = paramb;
  }
  
  BCECPrivateKey(String paramString, org.bouncycastle.asn1.n2.h paramh, org.bouncycastle.jcajce.provider.config.b paramb)
    throws IOException
  {
    this.algorithm = paramString;
    this.configuration = paramb;
    populateFromPrivKeyInfo(paramh);
  }
  
  public BCECPrivateKey(String paramString, r paramr, BCECPublicKey paramBCECPublicKey, ECParameterSpec paramECParameterSpec, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    this.configuration = paramb;
    paramString = paramECParameterSpec;
    if (paramECParameterSpec == null)
    {
      paramString = paramr.b();
      paramString = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramString.a(), paramString.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramString.b()), paramString.e(), paramString.c().intValue());
    }
    this.ecSpec = paramString;
    this.publicKey = getPublicKeyDetails(paramBCECPublicKey);
  }
  
  public BCECPrivateKey(String paramString, r paramr, BCECPublicKey paramBCECPublicKey, org.bouncycastle.jce.spec.d paramd, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    this.configuration = paramb;
    if (paramd == null)
    {
      paramString = paramr.b();
      this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramString.a(), paramString.f()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramString.b()), paramString.e(), paramString.c().intValue());
    }
    else
    {
      this.ecSpec = org.bouncycastle.jcajce.provider.asymmetric.util.a.g(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramd.a(), paramd.e()), paramd);
    }
    try
    {
      this.publicKey = getPublicKeyDetails(paramBCECPublicKey);
    }
    catch (Exception paramString)
    {
      this.publicKey = null;
    }
  }
  
  public BCECPrivateKey(String paramString, r paramr, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    this.ecSpec = null;
    this.configuration = paramb;
  }
  
  public BCECPrivateKey(String paramString, BCECPrivateKey paramBCECPrivateKey)
  {
    this.algorithm = paramString;
    this.d = paramBCECPrivateKey.d;
    this.ecSpec = paramBCECPrivateKey.ecSpec;
    this.withCompression = paramBCECPrivateKey.withCompression;
    this.attrCarrier = paramBCECPrivateKey.attrCarrier;
    this.publicKey = paramBCECPrivateKey.publicKey;
    this.configuration = paramBCECPrivateKey.configuration;
  }
  
  public BCECPrivateKey(String paramString, org.bouncycastle.jce.spec.e parame, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.algorithm = paramString;
    throw null;
  }
  
  public BCECPrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey, org.bouncycastle.jcajce.provider.config.b paramb)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
    this.configuration = paramb;
  }
  
  private e.a.b.a.h calculateQ(org.bouncycastle.jce.spec.d paramd)
  {
    return paramd.b().y(this.d).A();
  }
  
  private n0 getPublicKeyDetails(BCECPublicKey paramBCECPublicKey)
  {
    try
    {
      paramBCECPublicKey = w.h(q.i(paramBCECPublicKey.getEncoded())).i();
      return paramBCECPublicKey;
    }
    catch (IOException paramBCECPublicKey) {}
    return null;
  }
  
  private void populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    org.bouncycastle.asn1.u2.h localh = org.bouncycastle.asn1.u2.h.f(paramh.h().i());
    this.ecSpec = org.bouncycastle.jcajce.provider.asymmetric.util.a.i(localh, org.bouncycastle.jcajce.provider.asymmetric.util.a.j(this.configuration, localh));
    paramh = paramh.i();
    if ((paramh instanceof j))
    {
      this.d = j.m(paramh).p();
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
    paramObjectInputStream = (byte[])paramObjectInputStream.readObject();
    this.configuration = BouncyCastleProvider.CONFIGURATION;
    populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h.g(q.i(paramObjectInputStream)));
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
    return this.configuration.b();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCECPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECPrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((BCECPrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECPrivateKey)paramObject).engineGetSpec())) {
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
    org.bouncycastle.asn1.u2.h localh = a.a(this.ecSpec, this.withCompression);
    Object localObject = this.ecSpec;
    int i;
    if (localObject == null) {
      i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(this.configuration, null, getS());
    } else {
      i = org.bouncycastle.jcajce.provider.asymmetric.util.b.i(this.configuration, ((ECParameterSpec)localObject).getOrder(), getS());
    }
    if (this.publicKey != null) {
      localObject = new org.bouncycastle.asn1.p2.a(i, getS(), this.publicKey, localh);
    } else {
      localObject = new org.bouncycastle.asn1.p2.a(i, getS(), localh);
    }
    try
    {
      org.bouncycastle.asn1.n2.h localh1 = new org/bouncycastle/asn1/n2/h;
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      locala.<init>(org.bouncycastle.asn1.u2.p.B2, localh);
      localh1.<init>(locala, (org.bouncycastle.asn1.e)localObject);
      localObject = localh1.e("DER");
      return (byte[])localObject;
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
    return org.bouncycastle.jcajce.provider.asymmetric.util.b.j("EC", this.d, engineGetSpec());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\BCECPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
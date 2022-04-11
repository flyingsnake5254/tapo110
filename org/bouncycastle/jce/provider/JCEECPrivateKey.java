package org.bouncycastle.jce.provider;

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
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.n;
import org.bouncycastle.jce.spec.c;
import org.bouncycastle.util.i;

public class JCEECPrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.b
{
  private String algorithm = "EC";
  private org.bouncycastle.jcajce.provider.asymmetric.util.d attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  private BigInteger d;
  private ECParameterSpec ecSpec;
  private n0 publicKey;
  private boolean withCompression;
  
  protected JCEECPrivateKey() {}
  
  public JCEECPrivateKey(String paramString, ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.algorithm = paramString;
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
  }
  
  public JCEECPrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr)
  {
    this.algorithm = paramString;
    this.d = paramr.c();
    this.ecSpec = null;
  }
  
  public JCEECPrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr, JCEECPublicKey paramJCEECPublicKey, ECParameterSpec paramECParameterSpec)
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
    this.publicKey = getPublicKeyDetails(paramJCEECPublicKey);
  }
  
  public JCEECPrivateKey(String paramString, org.bouncycastle.crypto.w.r paramr, JCEECPublicKey paramJCEECPublicKey, org.bouncycastle.jce.spec.d paramd)
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
    this.publicKey = getPublicKeyDetails(paramJCEECPublicKey);
  }
  
  public JCEECPrivateKey(String paramString, JCEECPrivateKey paramJCEECPrivateKey)
  {
    this.algorithm = paramString;
    this.d = paramJCEECPrivateKey.d;
    this.ecSpec = paramJCEECPrivateKey.ecSpec;
    this.withCompression = paramJCEECPrivateKey.withCompression;
    this.attrCarrier = paramJCEECPrivateKey.attrCarrier;
    this.publicKey = paramJCEECPrivateKey.publicKey;
  }
  
  public JCEECPrivateKey(String paramString, org.bouncycastle.jce.spec.e parame)
  {
    this.algorithm = paramString;
    throw null;
  }
  
  public JCEECPrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
  }
  
  JCEECPrivateKey(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    populateFromPrivKeyInfo(paramh);
  }
  
  private n0 getPublicKeyDetails(JCEECPublicKey paramJCEECPublicKey)
  {
    try
    {
      paramJCEECPublicKey = w.h(q.i(paramJCEECPublicKey.getEncoded())).i();
      return paramJCEECPublicKey;
    }
    catch (IOException paramJCEECPublicKey) {}
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
        localObject2 = org.bouncycastle.asn1.d2.b.b((m)localObject1);
        localEllipticCurve = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((n)localObject2).a(), ((n)localObject2).f());
        localObject1 = new c(org.bouncycastle.asn1.d2.b.c((m)localObject1), localEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((n)localObject2).b()), ((n)localObject2).e(), ((n)localObject2).c());
      }
      else
      {
        localEllipticCurve = org.bouncycastle.jcajce.provider.asymmetric.util.a.a(((org.bouncycastle.asn1.u2.j)localObject2).f(), ((org.bouncycastle.asn1.u2.j)localObject2).k());
        localObject1 = new c(org.bouncycastle.jcajce.provider.asymmetric.util.b.d((m)localObject1), localEllipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((org.bouncycastle.asn1.u2.j)localObject2).g()), ((org.bouncycastle.asn1.u2.j)localObject2).j(), ((org.bouncycastle.asn1.u2.j)localObject2).h());
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
      paramh = new org.bouncycastle.asn1.p2.b((org.bouncycastle.asn1.r)paramh);
      this.d = paramh.f();
      this.publicKey = paramh.h();
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateFromPrivKeyInfo(org.bouncycastle.asn1.n2.h.g(q.i((byte[])paramObjectInputStream.readObject())));
    this.algorithm = ((String)paramObjectInputStream.readObject());
    this.withCompression = paramObjectInputStream.readBoolean();
    org.bouncycastle.jcajce.provider.asymmetric.util.d locald = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
    this.attrCarrier = locald;
    locald.a(paramObjectInputStream);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getEncoded());
    paramObjectOutputStream.writeObject(this.algorithm);
    paramObjectOutputStream.writeBoolean(this.withCompression);
    this.attrCarrier.b(paramObjectOutputStream);
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
    boolean bool1 = paramObject instanceof JCEECPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (JCEECPrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((JCEECPrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((JCEECPrivateKey)paramObject).engineGetSpec())) {
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
    if ((localObject1 instanceof c))
    {
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(((c)localObject1).a());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new m(((c)this.ecSpec).a());
      }
      localObject1 = new org.bouncycastle.asn1.u2.h((m)localObject1);
    }
    else if (localObject1 == null)
    {
      localObject1 = new org.bouncycastle.asn1.u2.h(v0.c);
    }
    else
    {
      localObject1 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject1).getCurve());
      localObject1 = new org.bouncycastle.asn1.u2.h(new org.bouncycastle.asn1.u2.j((e.a.b.a.d)localObject1, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject1, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
    }
    if (this.publicKey != null) {
      localObject2 = new org.bouncycastle.asn1.p2.b(getS(), this.publicKey, (org.bouncycastle.asn1.e)localObject1);
    } else {
      localObject2 = new org.bouncycastle.asn1.p2.b(getS(), (org.bouncycastle.asn1.e)localObject1);
    }
    try
    {
      Object localObject3;
      if (this.algorithm.equals("ECGOST3410"))
      {
        localObject3 = new org/bouncycastle/asn1/n2/h;
        org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
        locala.<init>(org.bouncycastle.asn1.d2.a.m, ((org.bouncycastle.asn1.u2.h)localObject1).c());
        ((org.bouncycastle.asn1.n2.h)localObject3).<init>(locala, ((org.bouncycastle.asn1.p2.b)localObject2).c());
        localObject1 = localObject3;
      }
      else
      {
        localObject3 = new org/bouncycastle/asn1/x509/a;
        ((org.bouncycastle.asn1.x509.a)localObject3).<init>(org.bouncycastle.asn1.u2.p.B2, ((org.bouncycastle.asn1.u2.h)localObject1).c());
        localObject1 = new org.bouncycastle.asn1.n2.h((org.bouncycastle.asn1.x509.a)localObject3, ((org.bouncycastle.asn1.p2.b)localObject2).c());
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
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    localStringBuffer.append("EC Private Key");
    localStringBuffer.append(str);
    localStringBuffer.append("             S: ");
    localStringBuffer.append(this.d.toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCEECPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
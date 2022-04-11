package org.bouncycastle.jce.provider;

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
import org.bouncycastle.asn1.u2.l;
import org.bouncycastle.asn1.u2.o;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.s;
import org.bouncycastle.jce.spec.f;
import org.bouncycastle.util.i;

public class JCEECPublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey
{
  private String algorithm = "EC";
  private ECParameterSpec ecSpec;
  private org.bouncycastle.asn1.d2.e gostParams;
  private e.a.b.a.h q;
  private boolean withCompression;
  
  public JCEECPublicKey(String paramString, ECPublicKeySpec paramECPublicKeySpec)
  {
    this.algorithm = paramString;
    paramString = paramECPublicKeySpec.getParams();
    this.ecSpec = paramString;
    this.q = org.bouncycastle.jcajce.provider.asymmetric.util.a.e(paramString, paramECPublicKeySpec.getW(), false);
  }
  
  public JCEECPublicKey(String paramString, s params)
  {
    this.algorithm = paramString;
    this.q = params.c();
    this.ecSpec = null;
  }
  
  public JCEECPublicKey(String paramString, s params, ECParameterSpec paramECParameterSpec)
  {
    org.bouncycastle.crypto.w.n localn = params.b();
    this.algorithm = paramString;
    this.q = params.c();
    if (paramECParameterSpec == null) {
      this.ecSpec = createSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), localn);
    } else {
      this.ecSpec = paramECParameterSpec;
    }
  }
  
  public JCEECPublicKey(String paramString, s params, org.bouncycastle.jce.spec.d paramd)
  {
    org.bouncycastle.crypto.w.n localn = params.b();
    this.algorithm = paramString;
    this.q = params.c();
    if (paramd == null) {
      paramString = createSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(localn.a(), localn.f()), localn);
    } else {
      paramString = org.bouncycastle.jcajce.provider.asymmetric.util.a.g(org.bouncycastle.jcajce.provider.asymmetric.util.a.a(paramd.a(), paramd.e()), paramd);
    }
    this.ecSpec = paramString;
  }
  
  public JCEECPublicKey(String paramString, JCEECPublicKey paramJCEECPublicKey)
  {
    this.algorithm = paramString;
    this.q = paramJCEECPublicKey.q;
    this.ecSpec = paramJCEECPublicKey.ecSpec;
    this.withCompression = paramJCEECPublicKey.withCompression;
    this.gostParams = paramJCEECPublicKey.gostParams;
  }
  
  public JCEECPublicKey(String paramString, f paramf)
  {
    this.algorithm = paramString;
    throw null;
  }
  
  public JCEECPublicKey(java.security.interfaces.ECPublicKey paramECPublicKey)
  {
    this.algorithm = paramECPublicKey.getAlgorithm();
    ECParameterSpec localECParameterSpec = paramECPublicKey.getParams();
    this.ecSpec = localECParameterSpec;
    this.q = org.bouncycastle.jcajce.provider.asymmetric.util.a.e(localECParameterSpec, paramECPublicKey.getW(), false);
  }
  
  JCEECPublicKey(w paramw)
  {
    populateFromPubKeyInfo(paramw);
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
    boolean bool = paramw.g().f().equals(org.bouncycastle.asn1.d2.a.m);
    int i = 1;
    if (bool)
    {
      localObject1 = paramw.i();
      this.algorithm = "ECGOST3410";
      try
      {
        localObject1 = (org.bouncycastle.asn1.n)q.i(((org.bouncycastle.asn1.b)localObject1).o());
        localObject2 = ((org.bouncycastle.asn1.n)localObject1).o();
        localObject1 = new byte[65];
        localObject1[0] = ((byte)4);
        while (i <= 32)
        {
          localObject1[i] = ((byte)localObject2[(32 - i)]);
          localObject1[(i + 32)] = ((byte)localObject2[(64 - i)]);
          i++;
        }
        paramw = new org.bouncycastle.asn1.d2.e((r)paramw.g().i());
        this.gostParams = paramw;
        paramw = e.a.a.a.a(org.bouncycastle.asn1.d2.b.c(paramw.i()));
        localObject2 = paramw.a();
        localObject3 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a((e.a.b.a.d)localObject2, paramw.e());
        this.q = ((e.a.b.a.d)localObject2).k((byte[])localObject1);
        this.ecSpec = new org.bouncycastle.jce.spec.c(org.bouncycastle.asn1.d2.b.c(this.gostParams.i()), (EllipticCurve)localObject3, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(paramw.b()), paramw.d(), paramw.c());
      }
      catch (IOException paramw)
      {
        throw new IllegalArgumentException("error recovering public key");
      }
    }
    Object localObject1 = new org.bouncycastle.asn1.u2.h((q)paramw.g().i());
    m localm;
    if (((org.bouncycastle.asn1.u2.h)localObject1).i())
    {
      localm = (m)((org.bouncycastle.asn1.u2.h)localObject1).g();
      localObject3 = org.bouncycastle.jcajce.provider.asymmetric.util.b.g(localm);
      localObject1 = ((j)localObject3).f();
      localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.a((e.a.b.a.d)localObject1, ((j)localObject3).k());
    }
    for (Object localObject2 = new org.bouncycastle.jce.spec.c(org.bouncycastle.jcajce.provider.asymmetric.util.b.d(localm), (EllipticCurve)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((j)localObject3).g()), ((j)localObject3).j(), ((j)localObject3).h());; localObject2 = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.a.a((e.a.b.a.d)localObject1, ((j)localObject2).k()), org.bouncycastle.jcajce.provider.asymmetric.util.a.d(((j)localObject2).g()), ((j)localObject2).j(), ((j)localObject2).h().intValue()))
    {
      this.ecSpec = ((ECParameterSpec)localObject2);
      break;
      if (((org.bouncycastle.asn1.u2.h)localObject1).h())
      {
        this.ecSpec = null;
        localObject1 = BouncyCastleProvider.CONFIGURATION.b().a();
        break;
      }
      localObject2 = j.i(((org.bouncycastle.asn1.u2.h)localObject1).g());
      localObject1 = ((j)localObject2).f();
    }
    Object localObject3 = paramw.i().o();
    localObject2 = new x0((byte[])localObject3);
    paramw = (w)localObject2;
    if (localObject3[0] == 4)
    {
      paramw = (w)localObject2;
      if (localObject3[1] == localObject3.length - 2) {
        if (localObject3[2] != 2)
        {
          paramw = (w)localObject2;
          if (localObject3[2] != 3) {}
        }
        else
        {
          paramw = (w)localObject2;
          if (new o().a((e.a.b.a.d)localObject1) >= localObject3.length - 3) {
            try
            {
              paramw = (org.bouncycastle.asn1.n)q.i((byte[])localObject3);
            }
            catch (IOException paramw)
            {
              throw new IllegalArgumentException("error recovering public key");
            }
          }
        }
      }
    }
    this.q = new l((e.a.b.a.d)localObject1, paramw).f();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateFromPubKeyInfo(w.h(q.i((byte[])paramObjectInputStream.readObject())));
    this.algorithm = ((String)paramObjectInputStream.readObject());
    this.withCompression = paramObjectInputStream.readBoolean();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getEncoded());
    paramObjectOutputStream.writeObject(this.algorithm);
    paramObjectOutputStream.writeBoolean(this.withCompression);
  }
  
  public e.a.b.a.h engineGetQ()
  {
    return this.q;
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
    boolean bool1 = paramObject instanceof JCEECPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (JCEECPublicKey)paramObject;
    bool1 = bool2;
    if (engineGetQ().e(((JCEECPublicKey)paramObject).engineGetQ()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((JCEECPublicKey)paramObject).engineGetSpec())) {
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
    Object localObject4;
    Object localObject2;
    if (this.algorithm.equals("ECGOST3410"))
    {
      Object localObject1 = this.gostParams;
      if (localObject1 == null)
      {
        localObject1 = this.ecSpec;
        if ((localObject1 instanceof org.bouncycastle.jce.spec.c))
        {
          localObject1 = new org.bouncycastle.asn1.d2.e(org.bouncycastle.asn1.d2.b.d(((org.bouncycastle.jce.spec.c)localObject1).a()), org.bouncycastle.asn1.d2.a.p);
        }
        else
        {
          localObject1 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject1).getCurve());
          localObject1 = new org.bouncycastle.asn1.u2.h(new j((e.a.b.a.d)localObject1, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject1, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        }
      }
      BigInteger localBigInteger = this.q.f().t();
      Object localObject3 = this.q.g().t();
      localObject4 = new byte[64];
      extractBytes((byte[])localObject4, 0, localBigInteger);
      extractBytes((byte[])localObject4, 32, (BigInteger)localObject3);
      try
      {
        localObject3 = new org/bouncycastle/asn1/x509/a;
        ((org.bouncycastle.asn1.x509.a)localObject3).<init>(org.bouncycastle.asn1.d2.a.m, (org.bouncycastle.asn1.e)localObject1);
        localObject1 = new org/bouncycastle/asn1/x0;
        ((x0)localObject1).<init>((byte[])localObject4);
        localObject1 = new w((org.bouncycastle.asn1.x509.a)localObject3, (org.bouncycastle.asn1.e)localObject1);
      }
      catch (IOException localIOException)
      {
        return null;
      }
    }
    else
    {
      localObject2 = this.ecSpec;
      if ((localObject2 instanceof org.bouncycastle.jce.spec.c))
      {
        localObject4 = org.bouncycastle.jcajce.provider.asymmetric.util.b.h(((org.bouncycastle.jce.spec.c)localObject2).a());
        localObject2 = localObject4;
        if (localObject4 == null) {
          localObject2 = new m(((org.bouncycastle.jce.spec.c)this.ecSpec).a());
        }
        localObject2 = new org.bouncycastle.asn1.u2.h((m)localObject2);
      }
      else if (localObject2 == null)
      {
        localObject2 = new org.bouncycastle.asn1.u2.h(v0.c);
      }
      else
      {
        localObject2 = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(((ECParameterSpec)localObject2).getCurve());
        localObject2 = new org.bouncycastle.asn1.u2.h(new j((e.a.b.a.d)localObject2, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((e.a.b.a.d)localObject2, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
      }
      localObject4 = (org.bouncycastle.asn1.n)new l(engineGetQ().i().h(getQ().f().t(), getQ().g().t(), this.withCompression)).c();
      localObject2 = new w(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.u2.p.B2, (org.bouncycastle.asn1.e)localObject2), ((org.bouncycastle.asn1.n)localObject4).o());
    }
    return org.bouncycastle.jcajce.provider.asymmetric.util.c.d((w)localObject2);
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
    if (this.ecSpec == null) {
      return this.q.k();
    }
    return this.q;
  }
  
  public ECPoint getW()
  {
    return org.bouncycastle.jcajce.provider.asymmetric.util.a.d(this.q);
  }
  
  public int hashCode()
  {
    return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
  }
  
  public void setPointFormat(String paramString)
  {
    this.withCompression = ("UNCOMPRESSED".equalsIgnoreCase(paramString) ^ true);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    localStringBuffer.append("EC Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            X: ");
    localStringBuffer.append(this.q.f().t().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("            Y: ");
    localStringBuffer.append(this.q.g().t().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCEECPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.jce.interfaces.b;

public class BCDHPrivateKey
  implements DHPrivateKey, b
{
  static final long serialVersionUID = 311058815616901812L;
  private transient org.bouncycastle.jcajce.provider.asymmetric.util.d attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  private transient org.bouncycastle.crypto.w.f dhPrivateKey;
  private transient DHParameterSpec dhSpec;
  private transient org.bouncycastle.asn1.n2.h info;
  private BigInteger x;
  
  protected BCDHPrivateKey() {}
  
  BCDHPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.dhSpec = paramDHPrivateKey.getParams();
  }
  
  BCDHPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.dhSpec = new DHParameterSpec(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  public BCDHPrivateKey(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    r localr = r.m(paramh.h().i());
    j localj = (j)paramh.i();
    m localm = paramh.h().f();
    this.info = paramh;
    this.x = localj.p();
    if (localm.equals(g.S))
    {
      paramh = org.bouncycastle.asn1.n2.e.g(localr);
      if (paramh.h() != null)
      {
        this.dhSpec = new DHParameterSpec(paramh.i(), paramh.f(), paramh.h().intValue());
        paramh = new org.bouncycastle.crypto.w.f(this.x, new org.bouncycastle.crypto.w.e(paramh.i(), paramh.f(), null, paramh.h().intValue()));
      }
      else
      {
        this.dhSpec = new DHParameterSpec(paramh.i(), paramh.f());
        paramh = new org.bouncycastle.crypto.w.f(this.x, new org.bouncycastle.crypto.w.e(paramh.i(), paramh.f()));
      }
    }
    else
    {
      if (!localm.equals(p.t3)) {
        break label278;
      }
      paramh = org.bouncycastle.asn1.u2.d.g(localr);
      this.dhSpec = new org.bouncycastle.jcajce.spec.a(paramh.j(), paramh.k(), paramh.f(), paramh.h(), 0);
      paramh = new org.bouncycastle.crypto.w.f(this.x, new org.bouncycastle.crypto.w.e(paramh.j(), paramh.f(), paramh.k(), paramh.h(), null));
    }
    this.dhPrivateKey = paramh;
    return;
    label278:
    paramh = new StringBuilder();
    paramh.append("unknown algorithm type: ");
    paramh.append(localm);
    throw new IllegalArgumentException(paramh.toString());
  }
  
  BCDHPrivateKey(org.bouncycastle.crypto.w.f paramf)
  {
    this.x = paramf.c();
    this.dhSpec = new org.bouncycastle.jcajce.spec.a(paramf.b());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
    this.info = null;
    this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
  }
  
  org.bouncycastle.crypto.w.f engineGetKeyParameters()
  {
    Object localObject = this.dhPrivateKey;
    if (localObject != null) {
      return (org.bouncycastle.crypto.w.f)localObject;
    }
    localObject = this.dhSpec;
    if ((localObject instanceof org.bouncycastle.jcajce.spec.a)) {
      return new org.bouncycastle.crypto.w.f(this.x, ((org.bouncycastle.jcajce.spec.a)localObject).a());
    }
    return new org.bouncycastle.crypto.w.f(this.x, new org.bouncycastle.crypto.w.e(((DHParameterSpec)localObject).getP(), this.dhSpec.getG(), null, this.dhSpec.getL()));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DHPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DHPrivateKey)paramObject;
    bool1 = bool2;
    if (getX().equals(((DHPrivateKey)paramObject).getX()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DHPrivateKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DHPrivateKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getL() == ((DHPrivateKey)paramObject).getParams().getL()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "DH";
  }
  
  public org.bouncycastle.asn1.e getBagAttribute(m paramm)
  {
    return this.attrCarrier.getBagAttribute(paramm);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public byte[] getEncoded()
  {
    localObject1 = null;
    try
    {
      localObject2 = this.info;
      if (localObject2 != null) {
        return ((l)localObject2).e("DER");
      }
      localObject2 = this.dhSpec;
      Object localObject4;
      Object localObject5;
      if (((localObject2 instanceof org.bouncycastle.jcajce.spec.a)) && (((org.bouncycastle.jcajce.spec.a)localObject2).b() != null))
      {
        localObject4 = ((org.bouncycastle.jcajce.spec.a)this.dhSpec).a();
        localObject5 = ((org.bouncycastle.crypto.w.e)localObject4).h();
        if (localObject5 == null)
        {
          localObject2 = new org/bouncycastle/asn1/u2/f;
          ((org.bouncycastle.asn1.u2.f)localObject2).<init>(((org.bouncycastle.crypto.w.h)localObject5).b(), ((org.bouncycastle.crypto.w.h)localObject5).a());
        }
        else
        {
          localObject2 = null;
        }
        localObject5 = new org/bouncycastle/asn1/n2/h;
        org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
        m localm = p.t3;
        org.bouncycastle.asn1.u2.d locald = new org/bouncycastle/asn1/u2/d;
        locald.<init>(((org.bouncycastle.crypto.w.e)localObject4).f(), ((org.bouncycastle.crypto.w.e)localObject4).b(), ((org.bouncycastle.crypto.w.e)localObject4).g(), ((org.bouncycastle.crypto.w.e)localObject4).c(), (org.bouncycastle.asn1.u2.f)localObject2);
        locala.<init>(localm, locald.c());
        localObject2 = new org/bouncycastle/asn1/j;
        ((j)localObject2).<init>(getX());
        ((org.bouncycastle.asn1.n2.h)localObject5).<init>(locala, (org.bouncycastle.asn1.e)localObject2);
        localObject2 = localObject5;
      }
      else
      {
        localObject2 = new org/bouncycastle/asn1/x509/a;
        localObject4 = g.S;
        localObject5 = new org/bouncycastle/asn1/n2/e;
        ((org.bouncycastle.asn1.n2.e)localObject5).<init>(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL());
        ((org.bouncycastle.asn1.x509.a)localObject2).<init>((m)localObject4, ((org.bouncycastle.asn1.n2.e)localObject5).c());
        localObject5 = new org/bouncycastle/asn1/j;
        ((j)localObject5).<init>(getX());
        localObject2 = new org.bouncycastle.asn1.n2.h((org.bouncycastle.asn1.x509.a)localObject2, (org.bouncycastle.asn1.e)localObject5);
      }
      localObject2 = ((l)localObject2).e("DER");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3 = localObject1;
      }
    }
    return (byte[])localObject2;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public DHParameterSpec getParams()
  {
    return this.dhSpec;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return getX().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
  }
  
  public void setBagAttribute(m paramm, org.bouncycastle.asn1.e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\BCDHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
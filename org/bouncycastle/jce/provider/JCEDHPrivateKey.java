package org.bouncycastle.jce.provider;

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
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.crypto.w.f;
import org.bouncycastle.jce.interfaces.b;

public class JCEDHPrivateKey
  implements DHPrivateKey, b
{
  static final long serialVersionUID = 311058815616901812L;
  private b attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.d();
  private DHParameterSpec dhSpec;
  private h info;
  BigInteger x;
  
  protected JCEDHPrivateKey() {}
  
  JCEDHPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.dhSpec = paramDHPrivateKey.getParams();
  }
  
  JCEDHPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.dhSpec = new DHParameterSpec(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  JCEDHPrivateKey(h paramh)
    throws IOException
  {
    r localr = r.m(paramh.f().i());
    j localj = j.m(paramh.i());
    m localm = paramh.f().f();
    this.info = paramh;
    this.x = localj.p();
    if (localm.equals(g.S))
    {
      paramh = org.bouncycastle.asn1.n2.e.g(localr);
      if (paramh.h() != null) {
        paramh = new DHParameterSpec(paramh.i(), paramh.f(), paramh.h().intValue());
      } else {
        paramh = new DHParameterSpec(paramh.i(), paramh.f());
      }
    }
    else
    {
      if (!localm.equals(p.t3)) {
        break label168;
      }
      paramh = org.bouncycastle.asn1.u2.a.g(localr);
      paramh = new DHParameterSpec(paramh.i().p(), paramh.f().p());
    }
    this.dhSpec = paramh;
    return;
    label168:
    paramh = new StringBuilder();
    paramh.append("unknown algorithm type: ");
    paramh.append(localm);
    throw new IllegalArgumentException(paramh.toString());
  }
  
  JCEDHPrivateKey(f paramf)
  {
    this.x = paramf.c();
    this.dhSpec = new DHParameterSpec(paramf.b().f(), paramf.b().b(), paramf.b().d());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.x = ((BigInteger)paramObjectInputStream.readObject());
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getX());
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
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
    try
    {
      Object localObject1 = this.info;
      if (localObject1 != null) {
        return ((l)localObject1).e("DER");
      }
      localObject1 = new org/bouncycastle/asn1/n2/h;
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      m localm = g.S;
      Object localObject2 = new org/bouncycastle/asn1/n2/e;
      ((org.bouncycastle.asn1.n2.e)localObject2).<init>(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL());
      locala.<init>(localm, (org.bouncycastle.asn1.e)localObject2);
      localObject2 = new org/bouncycastle/asn1/j;
      ((j)localObject2).<init>(getX());
      ((h)localObject1).<init>(locala, (org.bouncycastle.asn1.e)localObject2);
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
  
  public DHParameterSpec getParams()
  {
    return this.dhSpec;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public void setBagAttribute(m paramm, org.bouncycastle.asn1.e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCEDHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
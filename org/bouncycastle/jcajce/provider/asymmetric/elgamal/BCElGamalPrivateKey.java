package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.crypto.w.v;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.spec.i;

public class BCElGamalPrivateKey
  implements ElGamalPrivateKey, DHPrivateKey, org.bouncycastle.jce.interfaces.b
{
  static final long serialVersionUID = 4819350091141529678L;
  private transient d attrCarrier = new d();
  private transient org.bouncycastle.jce.spec.h elSpec;
  private BigInteger x;
  
  protected BCElGamalPrivateKey() {}
  
  BCElGamalPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.elSpec = new org.bouncycastle.jce.spec.h(paramDHPrivateKey.getParams().getP(), paramDHPrivateKey.getParams().getG());
  }
  
  BCElGamalPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.elSpec = new org.bouncycastle.jce.spec.h(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  BCElGamalPrivateKey(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    org.bouncycastle.asn1.m2.a locala = org.bouncycastle.asn1.m2.a.g(paramh.h().i());
    this.x = j.m(paramh.i()).p();
    this.elSpec = new org.bouncycastle.jce.spec.h(locala.h(), locala.f());
  }
  
  BCElGamalPrivateKey(v paramv)
  {
    throw null;
  }
  
  BCElGamalPrivateKey(ElGamalPrivateKey paramElGamalPrivateKey)
  {
    this.x = paramElGamalPrivateKey.getX();
    this.elSpec = paramElGamalPrivateKey.getParameters();
  }
  
  BCElGamalPrivateKey(i parami)
  {
    throw null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.elSpec = new org.bouncycastle.jce.spec.h((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
    this.attrCarrier = new d();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.elSpec.b());
    paramObjectOutputStream.writeObject(this.elSpec.a());
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
    return "ElGamal";
  }
  
  public e getBagAttribute(m paramm)
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
      org.bouncycastle.asn1.n2.h localh = new org/bouncycastle/asn1/n2/h;
      Object localObject1 = new org/bouncycastle/asn1/x509/a;
      m localm = org.bouncycastle.asn1.m2.b.l;
      Object localObject2 = new org/bouncycastle/asn1/m2/a;
      ((org.bouncycastle.asn1.m2.a)localObject2).<init>(this.elSpec.b(), this.elSpec.a());
      ((org.bouncycastle.asn1.x509.a)localObject1).<init>(localm, (e)localObject2);
      localObject2 = new org/bouncycastle/asn1/j;
      ((j)localObject2).<init>(getX());
      localh.<init>((org.bouncycastle.asn1.x509.a)localObject1, (e)localObject2);
      localObject1 = localh.e("DER");
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public org.bouncycastle.jce.spec.h getParameters()
  {
    return this.elSpec;
  }
  
  public DHParameterSpec getParams()
  {
    return new DHParameterSpec(this.elSpec.b(), this.elSpec.a());
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return getX().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
  }
  
  public void setBagAttribute(m paramm, e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\BCElGamalPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
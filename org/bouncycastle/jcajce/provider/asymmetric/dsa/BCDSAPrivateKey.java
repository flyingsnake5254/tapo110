package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.crypto.w.k;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.b;
import org.bouncycastle.util.i;

public class BCDSAPrivateKey
  implements DSAPrivateKey, b
{
  private static final long serialVersionUID = -4677259546958385734L;
  private transient d attrCarrier = new d();
  private transient DSAParams dsaSpec;
  private BigInteger x;
  
  protected BCDSAPrivateKey() {}
  
  BCDSAPrivateKey(DSAPrivateKey paramDSAPrivateKey)
  {
    this.x = paramDSAPrivateKey.getX();
    this.dsaSpec = paramDSAPrivateKey.getParams();
  }
  
  BCDSAPrivateKey(DSAPrivateKeySpec paramDSAPrivateKeySpec)
  {
    this.x = paramDSAPrivateKeySpec.getX();
    this.dsaSpec = new DSAParameterSpec(paramDSAPrivateKeySpec.getP(), paramDSAPrivateKeySpec.getQ(), paramDSAPrivateKeySpec.getG());
  }
  
  public BCDSAPrivateKey(h paramh)
    throws IOException
  {
    org.bouncycastle.asn1.x509.j localj = org.bouncycastle.asn1.x509.j.g(paramh.h().i());
    this.x = ((org.bouncycastle.asn1.j)paramh.i()).p();
    this.dsaSpec = new DSAParameterSpec(localj.h(), localj.i(), localj.f());
  }
  
  BCDSAPrivateKey(k paramk)
  {
    throw null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.dsaSpec = new DSAParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
    this.attrCarrier = new d();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.dsaSpec.getP());
    paramObjectOutputStream.writeObject(this.dsaSpec.getQ());
    paramObjectOutputStream.writeObject(this.dsaSpec.getG());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DSAPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DSAPrivateKey)paramObject;
    bool1 = bool2;
    if (getX().equals(((DSAPrivateKey)paramObject).getX()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DSAPrivateKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DSAPrivateKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getQ().equals(((DSAPrivateKey)paramObject).getParams().getQ())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "DSA";
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
    return c.b(new org.bouncycastle.asn1.x509.a(p.l3, new org.bouncycastle.asn1.x509.j(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).c()), new org.bouncycastle.asn1.j(getX()));
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public DSAParams getParams()
  {
    return this.dsaSpec;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return getX().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getQ().hashCode();
  }
  
  public void setBagAttribute(m paramm, e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    BigInteger localBigInteger = getParams().getG().modPow(this.x, getParams().getP());
    localStringBuffer.append("DSA Private Key [");
    localStringBuffer.append(a.a(localBigInteger, getParams()));
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    localStringBuffer.append("            y: ");
    localStringBuffer.append(localBigInteger.toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\BCDSAPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
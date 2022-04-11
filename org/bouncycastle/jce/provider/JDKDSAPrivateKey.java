package org.bouncycastle.jce.provider;

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
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.crypto.w.k;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.b;

public class JDKDSAPrivateKey
  implements DSAPrivateKey, b
{
  private static final long serialVersionUID = -4677259546958385734L;
  private d attrCarrier = new d();
  DSAParams dsaSpec;
  BigInteger x;
  
  protected JDKDSAPrivateKey() {}
  
  JDKDSAPrivateKey(DSAPrivateKey paramDSAPrivateKey)
  {
    this.x = paramDSAPrivateKey.getX();
    this.dsaSpec = paramDSAPrivateKey.getParams();
  }
  
  JDKDSAPrivateKey(DSAPrivateKeySpec paramDSAPrivateKeySpec)
  {
    this.x = paramDSAPrivateKeySpec.getX();
    this.dsaSpec = new DSAParameterSpec(paramDSAPrivateKeySpec.getP(), paramDSAPrivateKeySpec.getQ(), paramDSAPrivateKeySpec.getG());
  }
  
  JDKDSAPrivateKey(h paramh)
    throws IOException
  {
    org.bouncycastle.asn1.x509.j localj = org.bouncycastle.asn1.x509.j.g(paramh.h().i());
    this.x = org.bouncycastle.asn1.j.m(paramh.i()).p();
    this.dsaSpec = new DSAParameterSpec(localj.h(), localj.i(), localj.f());
  }
  
  JDKDSAPrivateKey(k paramk)
  {
    throw null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.x = ((BigInteger)paramObjectInputStream.readObject());
    this.dsaSpec = new DSAParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
    d locald = new d();
    this.attrCarrier = locald;
    locald.a(paramObjectInputStream);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this.x);
    paramObjectOutputStream.writeObject(this.dsaSpec.getP());
    paramObjectOutputStream.writeObject(this.dsaSpec.getQ());
    paramObjectOutputStream.writeObject(this.dsaSpec.getG());
    this.attrCarrier.b(paramObjectOutputStream);
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
    try
    {
      h localh = new org/bouncycastle/asn1/n2/h;
      Object localObject1 = new org/bouncycastle/asn1/x509/a;
      m localm = p.l3;
      Object localObject2 = new org/bouncycastle/asn1/x509/j;
      ((org.bouncycastle.asn1.x509.j)localObject2).<init>(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG());
      ((a)localObject1).<init>(localm, (e)localObject2);
      localObject2 = new org/bouncycastle/asn1/j;
      ((org.bouncycastle.asn1.j)localObject2).<init>(getX());
      localh.<init>((a)localObject1, (e)localObject2);
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JDKDSAPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
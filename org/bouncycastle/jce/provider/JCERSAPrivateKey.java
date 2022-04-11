package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.i;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.b;

public class JCERSAPrivateKey
  implements RSAPrivateKey, b
{
  private static BigInteger ZERO = BigInteger.valueOf(0L);
  static final long serialVersionUID = 5110188922551353628L;
  private transient d attrCarrier = new d();
  protected BigInteger modulus;
  protected BigInteger privateExponent;
  
  protected JCERSAPrivateKey() {}
  
  JCERSAPrivateKey(RSAPrivateKey paramRSAPrivateKey)
  {
    this.modulus = paramRSAPrivateKey.getModulus();
    this.privateExponent = paramRSAPrivateKey.getPrivateExponent();
  }
  
  JCERSAPrivateKey(RSAPrivateKeySpec paramRSAPrivateKeySpec)
  {
    this.modulus = paramRSAPrivateKeySpec.getModulus();
    this.privateExponent = paramRSAPrivateKeySpec.getPrivateExponent();
  }
  
  JCERSAPrivateKey(d0 paramd0)
  {
    this.modulus = paramd0.c();
    this.privateExponent = paramd0.b();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.modulus = ((BigInteger)paramObjectInputStream.readObject());
    d locald = new d();
    this.attrCarrier = locald;
    locald.a(paramObjectInputStream);
    this.privateExponent = ((BigInteger)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this.modulus);
    this.attrCarrier.b(paramObjectOutputStream);
    paramObjectOutputStream.writeObject(this.privateExponent);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof RSAPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (RSAPrivateKey)paramObject;
    bool1 = bool2;
    if (getModulus().equals(((RSAPrivateKey)paramObject).getModulus()))
    {
      bool1 = bool2;
      if (getPrivateExponent().equals(((RSAPrivateKey)paramObject).getPrivateExponent())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "RSA";
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
    a locala = new a(g.B, v0.c);
    BigInteger localBigInteger1 = getModulus();
    BigInteger localBigInteger2 = ZERO;
    BigInteger localBigInteger3 = getPrivateExponent();
    BigInteger localBigInteger4 = ZERO;
    return c.b(locala, new i(localBigInteger1, localBigInteger2, localBigInteger3, localBigInteger4, localBigInteger4, localBigInteger4, localBigInteger4, localBigInteger4));
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPrivateExponent()
  {
    return this.privateExponent;
  }
  
  public int hashCode()
  {
    return getModulus().hashCode() ^ getPrivateExponent().hashCode();
  }
  
  public void setBagAttribute(m paramm, e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCERSAPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
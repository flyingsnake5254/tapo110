package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.j;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.d0;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.util.i;

public class BCRSAPublicKey
  implements RSAPublicKey
{
  private static final org.bouncycastle.asn1.x509.a DEFAULT_ALGORITHM_IDENTIFIER = new org.bouncycastle.asn1.x509.a(g.B, v0.c);
  static final long serialVersionUID = 2675817738516720772L;
  private transient org.bouncycastle.asn1.x509.a algorithmIdentifier;
  private BigInteger modulus;
  private BigInteger publicExponent;
  
  BCRSAPublicKey(RSAPublicKey paramRSAPublicKey)
  {
    this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
    this.modulus = paramRSAPublicKey.getModulus();
    this.publicExponent = paramRSAPublicKey.getPublicExponent();
  }
  
  BCRSAPublicKey(RSAPublicKeySpec paramRSAPublicKeySpec)
  {
    this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
    this.modulus = paramRSAPublicKeySpec.getModulus();
    this.publicExponent = paramRSAPublicKeySpec.getPublicExponent();
  }
  
  BCRSAPublicKey(w paramw)
  {
    populateFromPublicKeyInfo(paramw);
  }
  
  BCRSAPublicKey(d0 paramd0)
  {
    this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
    this.modulus = paramd0.c();
    this.publicExponent = paramd0.b();
  }
  
  private void populateFromPublicKeyInfo(w paramw)
  {
    try
    {
      j localj = j.f(paramw.j());
      this.algorithmIdentifier = paramw.f();
      this.modulus = localj.g();
      this.publicExponent = localj.h();
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in RSA public key");
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    try
    {
      this.algorithmIdentifier = org.bouncycastle.asn1.x509.a.g(paramObjectInputStream.readObject());
    }
    catch (Exception paramObjectInputStream)
    {
      this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    if (!this.algorithmIdentifier.equals(DEFAULT_ALGORITHM_IDENTIFIER)) {
      paramObjectOutputStream.writeObject(this.algorithmIdentifier.d());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RSAPublicKey)) {
      return false;
    }
    paramObject = (RSAPublicKey)paramObject;
    if ((!getModulus().equals(((RSAPublicKey)paramObject).getModulus())) || (!getPublicExponent().equals(((RSAPublicKey)paramObject).getPublicExponent()))) {
      bool = false;
    }
    return bool;
  }
  
  public String getAlgorithm()
  {
    return "RSA";
  }
  
  public byte[] getEncoded()
  {
    return c.c(this.algorithmIdentifier, new j(getModulus(), getPublicExponent()));
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
  
  public int hashCode()
  {
    return getModulus().hashCode() ^ getPublicExponent().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    localStringBuffer.append("RSA Public Key [");
    localStringBuffer.append(a.a(getModulus(), getPublicExponent()));
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    localStringBuffer.append("            modulus: ");
    localStringBuffer.append(getModulus().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("    public exponent: ");
    localStringBuffer.append(getPublicExponent().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\BCRSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
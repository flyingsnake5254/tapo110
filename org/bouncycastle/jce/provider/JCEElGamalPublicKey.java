package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.crypto.w.t;
import org.bouncycastle.crypto.w.u;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.h;

public class JCEElGamalPublicKey
  implements ElGamalPublicKey, DHPublicKey
{
  static final long serialVersionUID = 8712728417091216948L;
  private h elSpec;
  private BigInteger y;
  
  JCEElGamalPublicKey(BigInteger paramBigInteger, h paramh)
  {
    this.y = paramBigInteger;
    this.elSpec = paramh;
  }
  
  JCEElGamalPublicKey(DHPublicKey paramDHPublicKey)
  {
    this.y = paramDHPublicKey.getY();
    this.elSpec = new h(paramDHPublicKey.getParams().getP(), paramDHPublicKey.getParams().getG());
  }
  
  JCEElGamalPublicKey(DHPublicKeySpec paramDHPublicKeySpec)
  {
    this.y = paramDHPublicKeySpec.getY();
    this.elSpec = new h(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG());
  }
  
  JCEElGamalPublicKey(org.bouncycastle.asn1.x509.w paramw)
  {
    org.bouncycastle.asn1.m2.a locala = org.bouncycastle.asn1.m2.a.g(paramw.f().i());
    try
    {
      paramw = (org.bouncycastle.asn1.j)paramw.j();
      this.y = paramw.p();
      this.elSpec = new h(locala.h(), locala.f());
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in DSA public key");
    }
  }
  
  JCEElGamalPublicKey(org.bouncycastle.crypto.w.w paramw)
  {
    this.y = paramw.c();
    this.elSpec = new h(paramw.b().c(), paramw.b().a());
  }
  
  JCEElGamalPublicKey(ElGamalPublicKey paramElGamalPublicKey)
  {
    this.y = paramElGamalPublicKey.getY();
    this.elSpec = paramElGamalPublicKey.getParameters();
  }
  
  JCEElGamalPublicKey(org.bouncycastle.jce.spec.j paramj)
  {
    throw null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.y = ((BigInteger)paramObjectInputStream.readObject());
    this.elSpec = new h((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getY());
    paramObjectOutputStream.writeObject(this.elSpec.b());
    paramObjectOutputStream.writeObject(this.elSpec.a());
  }
  
  public String getAlgorithm()
  {
    return "ElGamal";
  }
  
  public byte[] getEncoded()
  {
    return c.c(new org.bouncycastle.asn1.x509.a(b.l, new org.bouncycastle.asn1.m2.a(this.elSpec.b(), this.elSpec.a())), new org.bouncycastle.asn1.j(this.y));
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public h getParameters()
  {
    return this.elSpec;
  }
  
  public DHParameterSpec getParams()
  {
    return new DHParameterSpec(this.elSpec.b(), this.elSpec.a());
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCEElGamalPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
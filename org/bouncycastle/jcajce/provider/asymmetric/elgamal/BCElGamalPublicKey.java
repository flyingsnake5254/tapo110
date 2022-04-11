package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.m2.b;
import org.bouncycastle.crypto.w.t;
import org.bouncycastle.crypto.w.u;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.h;

public class BCElGamalPublicKey
  implements ElGamalPublicKey, DHPublicKey
{
  static final long serialVersionUID = 8712728417091216948L;
  private transient h elSpec;
  private BigInteger y;
  
  BCElGamalPublicKey(BigInteger paramBigInteger, h paramh)
  {
    this.y = paramBigInteger;
    this.elSpec = paramh;
  }
  
  BCElGamalPublicKey(DHPublicKey paramDHPublicKey)
  {
    this.y = paramDHPublicKey.getY();
    this.elSpec = new h(paramDHPublicKey.getParams().getP(), paramDHPublicKey.getParams().getG());
  }
  
  BCElGamalPublicKey(DHPublicKeySpec paramDHPublicKeySpec)
  {
    this.y = paramDHPublicKeySpec.getY();
    this.elSpec = new h(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG());
  }
  
  BCElGamalPublicKey(org.bouncycastle.asn1.x509.w paramw)
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
  
  BCElGamalPublicKey(org.bouncycastle.crypto.w.w paramw)
  {
    this.y = paramw.c();
    this.elSpec = new h(paramw.b().c(), paramw.b().a());
  }
  
  BCElGamalPublicKey(ElGamalPublicKey paramElGamalPublicKey)
  {
    this.y = paramElGamalPublicKey.getY();
    this.elSpec = paramElGamalPublicKey.getParameters();
  }
  
  BCElGamalPublicKey(org.bouncycastle.jce.spec.j paramj)
  {
    throw null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.elSpec = new h((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
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
    boolean bool1 = paramObject instanceof DHPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DHPublicKey)paramObject;
    bool1 = bool2;
    if (getY().equals(((DHPublicKey)paramObject).getY()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DHPublicKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DHPublicKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getL() == ((DHPublicKey)paramObject).getParams().getL()) {
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
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject1 = new org/bouncycastle/asn1/x509/w;
      org.bouncycastle.asn1.x509.a locala = new org/bouncycastle/asn1/x509/a;
      Object localObject2 = b.l;
      org.bouncycastle.asn1.m2.a locala1 = new org/bouncycastle/asn1/m2/a;
      locala1.<init>(this.elSpec.b(), this.elSpec.a());
      locala.<init>((m)localObject2, locala1);
      localObject2 = new org/bouncycastle/asn1/j;
      ((org.bouncycastle.asn1.j)localObject2).<init>(this.y);
      ((org.bouncycastle.asn1.x509.w)localObject1).<init>(locala, (e)localObject2);
      localObject1 = ((l)localObject1).e("DER");
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
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
  
  public int hashCode()
  {
    return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\BCElGamalPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
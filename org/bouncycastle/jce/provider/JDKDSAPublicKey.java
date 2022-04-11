package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.w;

public class JDKDSAPublicKey
  implements DSAPublicKey
{
  private static final long serialVersionUID = 1752452449903495175L;
  private DSAParams dsaSpec;
  private BigInteger y;
  
  JDKDSAPublicKey(BigInteger paramBigInteger, DSAParameterSpec paramDSAParameterSpec)
  {
    this.y = paramBigInteger;
    this.dsaSpec = paramDSAParameterSpec;
  }
  
  JDKDSAPublicKey(DSAPublicKey paramDSAPublicKey)
  {
    this.y = paramDSAPublicKey.getY();
    this.dsaSpec = paramDSAPublicKey.getParams();
  }
  
  JDKDSAPublicKey(DSAPublicKeySpec paramDSAPublicKeySpec)
  {
    this.y = paramDSAPublicKeySpec.getY();
    this.dsaSpec = new DSAParameterSpec(paramDSAPublicKeySpec.getP(), paramDSAPublicKeySpec.getQ(), paramDSAPublicKeySpec.getG());
  }
  
  JDKDSAPublicKey(w paramw)
  {
    try
    {
      org.bouncycastle.asn1.j localj = (org.bouncycastle.asn1.j)paramw.j();
      this.y = localj.p();
      if (isNotNull(paramw.f().i()))
      {
        paramw = org.bouncycastle.asn1.x509.j.g(paramw.f().i());
        this.dsaSpec = new DSAParameterSpec(paramw.h(), paramw.i(), paramw.f());
      }
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in DSA public key");
    }
  }
  
  JDKDSAPublicKey(org.bouncycastle.crypto.w.l paraml)
  {
    this.y = paraml.c();
    this.dsaSpec = new DSAParameterSpec(paraml.b().b(), paraml.b().c(), paraml.b().a());
  }
  
  private boolean isNotNull(e parame)
  {
    boolean bool;
    if ((parame != null) && (!v0.c.equals(parame))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.y = ((BigInteger)paramObjectInputStream.readObject());
    this.dsaSpec = new DSAParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this.y);
    paramObjectOutputStream.writeObject(this.dsaSpec.getP());
    paramObjectOutputStream.writeObject(this.dsaSpec.getQ());
    paramObjectOutputStream.writeObject(this.dsaSpec.getG());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DSAPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DSAPublicKey)paramObject;
    bool1 = bool2;
    if (getY().equals(((DSAPublicKey)paramObject).getY()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DSAPublicKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DSAPublicKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getQ().equals(((DSAPublicKey)paramObject).getParams().getQ())) {
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
  
  public byte[] getEncoded()
  {
    try
    {
      DSAParams localDSAParams = this.dsaSpec;
      if (localDSAParams == null)
      {
        localObject1 = new org/bouncycastle/asn1/x509/w;
        localObject2 = new org/bouncycastle/asn1/x509/a;
        ((a)localObject2).<init>(p.l3);
        localObject3 = new org/bouncycastle/asn1/j;
        ((org.bouncycastle.asn1.j)localObject3).<init>(this.y);
        ((w)localObject1).<init>((a)localObject2, (e)localObject3);
        return ((org.bouncycastle.asn1.l)localObject1).e("DER");
      }
      Object localObject2 = new org/bouncycastle/asn1/x509/w;
      Object localObject3 = new org/bouncycastle/asn1/x509/a;
      Object localObject1 = p.l3;
      org.bouncycastle.asn1.x509.j localj = new org/bouncycastle/asn1/x509/j;
      localj.<init>(localDSAParams.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG());
      ((a)localObject3).<init>((m)localObject1, localj);
      localObject1 = new org/bouncycastle/asn1/j;
      ((org.bouncycastle.asn1.j)localObject1).<init>(this.y);
      ((w)localObject2).<init>((a)localObject3, (e)localObject1);
      localObject3 = ((org.bouncycastle.asn1.l)localObject2).e("DER");
      return (byte[])localObject3;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public DSAParams getParams()
  {
    return this.dsaSpec;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getQ().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = org.bouncycastle.util.i.d();
    localStringBuffer.append("DSA Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            y: ");
    localStringBuffer.append(getY().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JDKDSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
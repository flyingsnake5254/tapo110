package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.l;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;

public class BCDSAPublicKey
  implements DSAPublicKey
{
  private static BigInteger ZERO = BigInteger.valueOf(0L);
  private static final long serialVersionUID = 1752452449903495175L;
  private transient DSAParams dsaSpec;
  private transient l lwKeyParams;
  private BigInteger y;
  
  BCDSAPublicKey(DSAPublicKey paramDSAPublicKey)
  {
    this.y = paramDSAPublicKey.getY();
    this.dsaSpec = paramDSAPublicKey.getParams();
    this.lwKeyParams = new l(this.y, a.b(this.dsaSpec));
  }
  
  BCDSAPublicKey(DSAPublicKeySpec paramDSAPublicKeySpec)
  {
    this.y = paramDSAPublicKeySpec.getY();
    this.dsaSpec = new DSAParameterSpec(paramDSAPublicKeySpec.getP(), paramDSAPublicKeySpec.getQ(), paramDSAPublicKeySpec.getG());
    this.lwKeyParams = new l(this.y, a.b(this.dsaSpec));
  }
  
  public BCDSAPublicKey(w paramw)
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
      else
      {
        this.dsaSpec = null;
      }
      this.lwKeyParams = new l(this.y, a.b(this.dsaSpec));
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in DSA public key");
    }
  }
  
  BCDSAPublicKey(l paraml)
  {
    this.y = paraml.c();
    this.dsaSpec = new DSAParameterSpec(paraml.b().b(), paraml.b().c(), paraml.b().a());
    this.lwKeyParams = paraml;
  }
  
  private boolean isNotNull(e parame)
  {
    boolean bool;
    if ((parame != null) && (!v0.c.equals(parame.c()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    BigInteger localBigInteger = (BigInteger)paramObjectInputStream.readObject();
    if (localBigInteger.equals(ZERO)) {
      this.dsaSpec = null;
    } else {
      this.dsaSpec = new DSAParameterSpec(localBigInteger, (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
    }
    this.lwKeyParams = new l(this.y, a.b(this.dsaSpec));
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Object localObject = this.dsaSpec;
    if (localObject == null)
    {
      localObject = ZERO;
    }
    else
    {
      paramObjectOutputStream.writeObject(((DSAParams)localObject).getP());
      paramObjectOutputStream.writeObject(this.dsaSpec.getQ());
      localObject = this.dsaSpec.getG();
    }
    paramObjectOutputStream.writeObject(localObject);
  }
  
  l engineGetKeyParameters()
  {
    return this.lwKeyParams;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DSAPublicKey;
    boolean bool2 = false;
    boolean bool3 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DSAPublicKey)paramObject;
    if (this.dsaSpec != null)
    {
      bool1 = bool3;
      if (getY().equals(((DSAPublicKey)paramObject).getY()))
      {
        bool1 = bool3;
        if (((DSAPublicKey)paramObject).getParams() != null)
        {
          bool1 = bool3;
          if (getParams().getG().equals(((DSAPublicKey)paramObject).getParams().getG()))
          {
            bool1 = bool3;
            if (getParams().getP().equals(((DSAPublicKey)paramObject).getParams().getP()))
            {
              bool1 = bool3;
              if (getParams().getQ().equals(((DSAPublicKey)paramObject).getParams().getQ())) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    bool1 = bool2;
    if (getY().equals(((DSAPublicKey)paramObject).getY()))
    {
      bool1 = bool2;
      if (((DSAPublicKey)paramObject).getParams() == null) {
        bool1 = true;
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
    DSAParams localDSAParams = this.dsaSpec;
    if (localDSAParams == null) {
      return c.c(new org.bouncycastle.asn1.x509.a(p.l3), new org.bouncycastle.asn1.j(this.y));
    }
    return c.c(new org.bouncycastle.asn1.x509.a(p.l3, new org.bouncycastle.asn1.x509.j(localDSAParams.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).c()), new org.bouncycastle.asn1.j(this.y));
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
    if (this.dsaSpec != null) {
      return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getQ().hashCode();
    }
    return getY().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = org.bouncycastle.util.i.d();
    localStringBuffer.append("DSA Public Key [");
    localStringBuffer.append(a.a(this.y, getParams()));
    localStringBuffer.append("]");
    localStringBuffer.append(str);
    localStringBuffer.append("            y: ");
    localStringBuffer.append(getY().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\BCDSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
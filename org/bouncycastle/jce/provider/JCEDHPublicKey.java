package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.d;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;

public class JCEDHPublicKey
  implements DHPublicKey
{
  static final long serialVersionUID = -216691575254424324L;
  private DHParameterSpec dhSpec;
  private w info;
  private BigInteger y;
  
  JCEDHPublicKey(BigInteger paramBigInteger, DHParameterSpec paramDHParameterSpec)
  {
    this.y = paramBigInteger;
    this.dhSpec = paramDHParameterSpec;
  }
  
  JCEDHPublicKey(DHPublicKey paramDHPublicKey)
  {
    this.y = paramDHPublicKey.getY();
    this.dhSpec = paramDHPublicKey.getParams();
  }
  
  JCEDHPublicKey(DHPublicKeySpec paramDHPublicKeySpec)
  {
    this.y = paramDHPublicKeySpec.getY();
    this.dhSpec = new DHParameterSpec(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG());
  }
  
  JCEDHPublicKey(w paramw)
  {
    this.info = paramw;
    try
    {
      Object localObject = (j)paramw.j();
      this.y = ((j)localObject).p();
      localObject = r.m(paramw.g().i());
      paramw = paramw.g().f();
      if ((!paramw.equals(org.bouncycastle.asn1.n2.g.S)) && (!isPKCSParam((r)localObject))) {
        if (paramw.equals(p.t3))
        {
          paramw = org.bouncycastle.asn1.u2.a.g(localObject);
          paramw = new DHParameterSpec(paramw.i().p(), paramw.f().p());
        }
      }
      for (;;)
      {
        this.dhSpec = paramw;
        break;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unknown algorithm type: ");
        ((StringBuilder)localObject).append(paramw);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        paramw = org.bouncycastle.asn1.n2.e.g(localObject);
        if (paramw.h() != null) {
          paramw = new DHParameterSpec(paramw.i(), paramw.f(), paramw.h().intValue());
        } else {
          paramw = new DHParameterSpec(paramw.i(), paramw.f());
        }
      }
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in DH public key");
    }
  }
  
  JCEDHPublicKey(org.bouncycastle.crypto.w.g paramg)
  {
    this.y = paramg.c();
    this.dhSpec = new DHParameterSpec(paramg.b().f(), paramg.b().b(), paramg.b().d());
  }
  
  private boolean isPKCSParam(r paramr)
  {
    if (paramr.size() == 2) {
      return true;
    }
    if (paramr.size() > 3) {
      return false;
    }
    j localj = j.m(paramr.p(2));
    paramr = j.m(paramr.p(0));
    return localj.p().compareTo(BigInteger.valueOf(paramr.p().bitLength())) <= 0;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.y = ((BigInteger)paramObjectInputStream.readObject());
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getY());
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
  }
  
  public String getAlgorithm()
  {
    return "DH";
  }
  
  public byte[] getEncoded()
  {
    w localw = this.info;
    if (localw != null) {
      return c.d(localw);
    }
    return c.c(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.n2.g.S, new org.bouncycastle.asn1.n2.e(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new j(this.y));
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public DHParameterSpec getParams()
  {
    return this.dhSpec;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\JCEDHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
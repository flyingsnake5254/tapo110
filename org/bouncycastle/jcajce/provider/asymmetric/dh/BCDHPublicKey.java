package org.bouncycastle.jcajce.provider.asymmetric.dh;

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
import org.bouncycastle.asn1.u2.f;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.h;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;

public class BCDHPublicKey
  implements DHPublicKey
{
  static final long serialVersionUID = -216691575254424324L;
  private transient org.bouncycastle.crypto.w.g dhPublicKey;
  private transient DHParameterSpec dhSpec;
  private transient w info;
  private BigInteger y;
  
  BCDHPublicKey(BigInteger paramBigInteger, DHParameterSpec paramDHParameterSpec)
  {
    this.y = paramBigInteger;
    this.dhSpec = paramDHParameterSpec;
    if ((paramDHParameterSpec instanceof org.bouncycastle.jcajce.spec.a)) {
      paramBigInteger = new org.bouncycastle.crypto.w.g(paramBigInteger, ((org.bouncycastle.jcajce.spec.a)paramDHParameterSpec).a());
    } else {
      paramBigInteger = new org.bouncycastle.crypto.w.g(paramBigInteger, new org.bouncycastle.crypto.w.e(paramDHParameterSpec.getP(), paramDHParameterSpec.getG()));
    }
    this.dhPublicKey = paramBigInteger;
  }
  
  BCDHPublicKey(DHPublicKey paramDHPublicKey)
  {
    this.y = paramDHPublicKey.getY();
    this.dhSpec = paramDHPublicKey.getParams();
    this.dhPublicKey = new org.bouncycastle.crypto.w.g(this.y, new org.bouncycastle.crypto.w.e(this.dhSpec.getP(), this.dhSpec.getG()));
  }
  
  BCDHPublicKey(DHPublicKeySpec paramDHPublicKeySpec)
  {
    this.y = paramDHPublicKeySpec.getY();
    this.dhSpec = new DHParameterSpec(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG());
    this.dhPublicKey = new org.bouncycastle.crypto.w.g(this.y, new org.bouncycastle.crypto.w.e(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG()));
  }
  
  public BCDHPublicKey(w paramw)
  {
    this.info = paramw;
    try
    {
      Object localObject = (j)paramw.j();
      this.y = ((j)localObject).p();
      localObject = r.m(paramw.f().i());
      paramw = paramw.f().f();
      if ((!paramw.equals(org.bouncycastle.asn1.n2.g.S)) && (!isPKCSParam((r)localObject)))
      {
        if (paramw.equals(p.t3))
        {
          paramw = org.bouncycastle.asn1.u2.d.g(localObject);
          localObject = paramw.l();
          if (localObject != null) {
            this.dhPublicKey = new org.bouncycastle.crypto.w.g(this.y, new org.bouncycastle.crypto.w.e(paramw.j(), paramw.f(), paramw.k(), paramw.h(), new h(((f)localObject).h(), ((f)localObject).g().intValue())));
          } else {
            this.dhPublicKey = new org.bouncycastle.crypto.w.g(this.y, new org.bouncycastle.crypto.w.e(paramw.j(), paramw.f(), paramw.k(), paramw.h(), null));
          }
          this.dhSpec = new org.bouncycastle.jcajce.spec.a(this.dhPublicKey.b());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("unknown algorithm type: ");
          ((StringBuilder)localObject).append(paramw);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        paramw = org.bouncycastle.asn1.n2.e.g(localObject);
        if (paramw.h() != null) {
          paramw = new DHParameterSpec(paramw.i(), paramw.f(), paramw.h().intValue());
        } else {
          paramw = new DHParameterSpec(paramw.i(), paramw.f());
        }
        this.dhSpec = paramw;
        this.dhPublicKey = new org.bouncycastle.crypto.w.g(this.y, new org.bouncycastle.crypto.w.e(this.dhSpec.getP(), this.dhSpec.getG()));
      }
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in DH public key");
    }
  }
  
  BCDHPublicKey(org.bouncycastle.crypto.w.g paramg)
  {
    this.y = paramg.c();
    this.dhSpec = new org.bouncycastle.jcajce.spec.a(paramg.b());
    this.dhPublicKey = paramg;
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
    paramObjectInputStream.defaultReadObject();
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
    this.info = null;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
  }
  
  public org.bouncycastle.crypto.w.g engineGetKeyParameters()
  {
    return this.dhPublicKey;
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
    return "DH";
  }
  
  public byte[] getEncoded()
  {
    Object localObject = this.info;
    if (localObject != null) {
      return c.d((w)localObject);
    }
    localObject = this.dhSpec;
    if (((localObject instanceof org.bouncycastle.jcajce.spec.a)) && (((org.bouncycastle.jcajce.spec.a)localObject).b() != null))
    {
      org.bouncycastle.crypto.w.e locale = ((org.bouncycastle.jcajce.spec.a)this.dhSpec).a();
      h localh = locale.h();
      localObject = null;
      if (localh == null) {
        localObject = new f(localh.b(), localh.a());
      }
      return c.c(new org.bouncycastle.asn1.x509.a(p.t3, new org.bouncycastle.asn1.u2.d(locale.f(), locale.b(), locale.g(), locale.c(), (f)localObject).c()), new j(this.y));
    }
    return c.c(new org.bouncycastle.asn1.x509.a(org.bouncycastle.asn1.n2.g.S, new org.bouncycastle.asn1.n2.e(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).c()), new j(this.y));
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
  
  public int hashCode()
  {
    return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\BCDHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
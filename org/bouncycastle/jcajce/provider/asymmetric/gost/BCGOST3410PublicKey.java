package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.crypto.w.z;
import org.bouncycastle.jcajce.provider.asymmetric.util.c;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.k;
import org.bouncycastle.util.i;

public class BCGOST3410PublicKey
  implements GOST3410PublicKey
{
  static final long serialVersionUID = -6251023343619275990L;
  private transient org.bouncycastle.jce.interfaces.a gost3410Spec;
  private BigInteger y;
  
  BCGOST3410PublicKey(BigInteger paramBigInteger, k paramk)
  {
    this.y = paramBigInteger;
    this.gost3410Spec = paramk;
  }
  
  BCGOST3410PublicKey(w paramw)
  {
    org.bouncycastle.asn1.d2.e locale = new org.bouncycastle.asn1.d2.e((r)paramw.g().i());
    try
    {
      Object localObject = ((x0)paramw.j()).o();
      paramw = new byte[localObject.length];
      for (int i = 0; i != localObject.length; i++) {
        paramw[i] = ((byte)localObject[(localObject.length - 1 - i)]);
      }
      localObject = new java/math/BigInteger;
      ((BigInteger)localObject).<init>(1, paramw);
      this.y = ((BigInteger)localObject);
      this.gost3410Spec = k.e(locale);
      return;
    }
    catch (IOException paramw)
    {
      throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
    }
  }
  
  BCGOST3410PublicKey(z paramz, k paramk)
  {
    throw null;
  }
  
  BCGOST3410PublicKey(GOST3410PublicKey paramGOST3410PublicKey)
  {
    this.y = paramGOST3410PublicKey.getY();
    this.gost3410Spec = paramGOST3410PublicKey.getParameters();
  }
  
  BCGOST3410PublicKey(org.bouncycastle.jce.spec.n paramn)
  {
    throw null;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    String str = (String)paramObjectInputStream.readObject();
    if (str != null)
    {
      this.gost3410Spec = new k(str, (String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
    }
    else
    {
      this.gost3410Spec = new k(new org.bouncycastle.jce.spec.m((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject()));
      paramObjectInputStream.readObject();
      paramObjectInputStream.readObject();
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Object localObject;
    if (this.gost3410Spec.c() != null)
    {
      localObject = this.gost3410Spec.c();
    }
    else
    {
      paramObjectOutputStream.writeObject(null);
      paramObjectOutputStream.writeObject(this.gost3410Spec.a().b());
      paramObjectOutputStream.writeObject(this.gost3410Spec.a().c());
      localObject = this.gost3410Spec.a().a();
    }
    paramObjectOutputStream.writeObject(localObject);
    paramObjectOutputStream.writeObject(this.gost3410Spec.d());
    paramObjectOutputStream.writeObject(this.gost3410Spec.b());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCGOST3410PublicKey;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (BCGOST3410PublicKey)paramObject;
      bool3 = bool2;
      if (this.y.equals(((BCGOST3410PublicKey)paramObject).y))
      {
        bool3 = bool2;
        if (this.gost3410Spec.equals(((BCGOST3410PublicKey)paramObject).gost3410Spec)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public String getAlgorithm()
  {
    return "GOST3410";
  }
  
  public byte[] getEncoded()
  {
    Object localObject1 = getY().toByteArray();
    int i = 0;
    if (localObject1[0] == 0) {
      j = localObject1.length - 1;
    } else {
      j = localObject1.length;
    }
    byte[] arrayOfByte = new byte[j];
    for (int j = i; j != arrayOfByte.length; j++) {
      arrayOfByte[j] = ((byte)localObject1[(localObject1.length - 1 - j)]);
    }
    try
    {
      localObject1 = this.gost3410Spec;
      Object localObject2;
      if ((localObject1 instanceof k))
      {
        Object localObject3;
        org.bouncycastle.asn1.m localm2;
        org.bouncycastle.asn1.m localm4;
        if (((org.bouncycastle.jce.interfaces.a)localObject1).b() != null)
        {
          localObject1 = new org/bouncycastle/asn1/x509/w;
          localObject2 = new org/bouncycastle/asn1/x509/a;
          org.bouncycastle.asn1.m localm1 = org.bouncycastle.asn1.d2.a.l;
          localObject3 = new org/bouncycastle/asn1/d2/e;
          localm2 = new org/bouncycastle/asn1/m;
          localm2.<init>(this.gost3410Spec.c());
          org.bouncycastle.asn1.m localm3 = new org/bouncycastle/asn1/m;
          localm3.<init>(this.gost3410Spec.d());
          localm4 = new org/bouncycastle/asn1/m;
          localm4.<init>(this.gost3410Spec.b());
          ((org.bouncycastle.asn1.d2.e)localObject3).<init>(localm2, localm3, localm4);
          ((org.bouncycastle.asn1.x509.a)localObject2).<init>(localm1, (org.bouncycastle.asn1.e)localObject3);
          localObject3 = new org/bouncycastle/asn1/x0;
          ((x0)localObject3).<init>(arrayOfByte);
          ((w)localObject1).<init>((org.bouncycastle.asn1.x509.a)localObject2, (org.bouncycastle.asn1.e)localObject3);
        }
        else
        {
          localObject1 = new org/bouncycastle/asn1/x509/a;
          localm2 = org.bouncycastle.asn1.d2.a.l;
          localObject3 = new org/bouncycastle/asn1/d2/e;
          localObject2 = new org/bouncycastle/asn1/m;
          ((org.bouncycastle.asn1.m)localObject2).<init>(this.gost3410Spec.c());
          localm4 = new org/bouncycastle/asn1/m;
          localm4.<init>(this.gost3410Spec.d());
          ((org.bouncycastle.asn1.d2.e)localObject3).<init>((org.bouncycastle.asn1.m)localObject2, localm4);
          ((org.bouncycastle.asn1.x509.a)localObject1).<init>(localm2, (org.bouncycastle.asn1.e)localObject3);
          localObject2 = new org/bouncycastle/asn1/x0;
          ((x0)localObject2).<init>(arrayOfByte);
          localObject1 = new w((org.bouncycastle.asn1.x509.a)localObject1, (org.bouncycastle.asn1.e)localObject2);
        }
      }
      else
      {
        localObject1 = new org/bouncycastle/asn1/x509/a;
        ((org.bouncycastle.asn1.x509.a)localObject1).<init>(org.bouncycastle.asn1.d2.a.l);
        localObject2 = new org/bouncycastle/asn1/x0;
        ((x0)localObject2).<init>(arrayOfByte);
        localObject1 = new w((org.bouncycastle.asn1.x509.a)localObject1, (org.bouncycastle.asn1.e)localObject2);
      }
      localObject1 = c.d((w)localObject1);
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public org.bouncycastle.jce.interfaces.a getParameters()
  {
    return this.gost3410Spec;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return this.y.hashCode() ^ this.gost3410Spec.hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = i.d();
    localStringBuffer.append("GOST3410 Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            y: ");
    localStringBuffer.append(getY().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\BCGOST3410PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.n;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x0;
import org.bouncycastle.crypto.w.y;
import org.bouncycastle.jcajce.provider.asymmetric.util.d;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.b;
import org.bouncycastle.jce.spec.k;

public class BCGOST3410PrivateKey
  implements GOST3410PrivateKey, b
{
  static final long serialVersionUID = 8581661527592305464L;
  private transient b attrCarrier = new d();
  private transient org.bouncycastle.jce.interfaces.a gost3410Spec;
  private BigInteger x;
  
  protected BCGOST3410PrivateKey() {}
  
  BCGOST3410PrivateKey(h paramh)
    throws IOException
  {
    org.bouncycastle.asn1.d2.e locale = org.bouncycastle.asn1.d2.e.h(paramh.h().i());
    Object localObject = paramh.i();
    if ((localObject instanceof j)) {}
    for (paramh = j.m(localObject).o();; paramh = new BigInteger(1, (byte[])localObject))
    {
      this.x = paramh;
      break;
      paramh = n.m(paramh.i()).o();
      localObject = new byte[paramh.length];
      for (int i = 0; i != paramh.length; i++) {
        localObject[i] = ((byte)paramh[(paramh.length - 1 - i)]);
      }
    }
    this.gost3410Spec = k.e(locale);
  }
  
  BCGOST3410PrivateKey(y paramy, k paramk)
  {
    throw null;
  }
  
  BCGOST3410PrivateKey(GOST3410PrivateKey paramGOST3410PrivateKey)
  {
    this.x = paramGOST3410PrivateKey.getX();
    this.gost3410Spec = paramGOST3410PrivateKey.getParameters();
  }
  
  BCGOST3410PrivateKey(org.bouncycastle.jce.spec.l paraml)
  {
    throw null;
  }
  
  private boolean compareObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 == null) {
      return false;
    }
    return paramObject1.equals(paramObject2);
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
    this.attrCarrier = new d();
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
    boolean bool1 = paramObject instanceof GOST3410PrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (GOST3410PrivateKey)paramObject;
    bool1 = bool2;
    if (getX().equals(((GOST3410PrivateKey)paramObject).getX()))
    {
      bool1 = bool2;
      if (getParameters().a().equals(((GOST3410PrivateKey)paramObject).getParameters().a()))
      {
        bool1 = bool2;
        if (getParameters().d().equals(((GOST3410PrivateKey)paramObject).getParameters().d()))
        {
          bool1 = bool2;
          if (compareObj(getParameters().b(), ((GOST3410PrivateKey)paramObject).getParameters().b())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "GOST3410";
  }
  
  public org.bouncycastle.asn1.e getBagAttribute(org.bouncycastle.asn1.m paramm)
  {
    return this.attrCarrier.getBagAttribute(paramm);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public byte[] getEncoded()
  {
    Object localObject1 = getX().toByteArray();
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
      org.bouncycastle.asn1.x509.a locala;
      if ((this.gost3410Spec instanceof k))
      {
        localObject1 = new org/bouncycastle/asn1/n2/h;
        locala = new org/bouncycastle/asn1/x509/a;
        org.bouncycastle.asn1.m localm1 = org.bouncycastle.asn1.d2.a.l;
        org.bouncycastle.asn1.d2.e locale = new org/bouncycastle/asn1/d2/e;
        Object localObject2 = new org/bouncycastle/asn1/m;
        ((org.bouncycastle.asn1.m)localObject2).<init>(this.gost3410Spec.c());
        org.bouncycastle.asn1.m localm2 = new org/bouncycastle/asn1/m;
        localm2.<init>(this.gost3410Spec.d());
        locale.<init>((org.bouncycastle.asn1.m)localObject2, localm2);
        locala.<init>(localm1, locale);
        localObject2 = new org/bouncycastle/asn1/x0;
        ((x0)localObject2).<init>(arrayOfByte);
        ((h)localObject1).<init>(locala, (org.bouncycastle.asn1.e)localObject2);
      }
      else
      {
        locala = new org/bouncycastle/asn1/x509/a;
        locala.<init>(org.bouncycastle.asn1.d2.a.l);
        localObject1 = new org/bouncycastle/asn1/x0;
        ((x0)localObject1).<init>(arrayOfByte);
        localObject1 = new h(locala, (org.bouncycastle.asn1.e)localObject1);
      }
      localObject1 = ((org.bouncycastle.asn1.l)localObject1).e("DER");
      return (byte[])localObject1;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public org.bouncycastle.jce.interfaces.a getParameters()
  {
    return this.gost3410Spec;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return getX().hashCode() ^ this.gost3410Spec.hashCode();
  }
  
  public void setBagAttribute(org.bouncycastle.asn1.m paramm, org.bouncycastle.asn1.e parame)
  {
    this.attrCarrier.setBagAttribute(paramm, parame);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\BCGOST3410PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
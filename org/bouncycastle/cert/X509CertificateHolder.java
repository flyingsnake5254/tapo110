package org.bouncycastle.cert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.x509.a;
import org.bouncycastle.asn1.x509.h;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.asn1.x509.y;
import org.bouncycastle.asn1.x509.z;
import org.bouncycastle.asn1.z0;

public class X509CertificateHolder
  implements Serializable
{
  private static final long serialVersionUID = 20170722001L;
  private transient org.bouncycastle.asn1.x509.m extensions;
  private transient h x509Certificate;
  
  public X509CertificateHolder(h paramh)
  {
    init(paramh);
  }
  
  public X509CertificateHolder(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private void init(h paramh)
  {
    this.x509Certificate = paramh;
    this.extensions = paramh.o().g();
  }
  
  private static h parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = h.g(c.i(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException localClassCastException)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("malformed data: ");
      paramArrayOfByte.append(localClassCastException.getMessage());
      throw new CertIOException(paramArrayOfByte.toString(), localClassCastException);
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    init(h.g(paramObjectInputStream.readObject()));
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(getEncoded());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof X509CertificateHolder)) {
      return false;
    }
    paramObject = (X509CertificateHolder)paramObject;
    return this.x509Certificate.equals(((X509CertificateHolder)paramObject).x509Certificate);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return c.e(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.x509Certificate.d();
  }
  
  public org.bouncycastle.asn1.x509.l getExtension(org.bouncycastle.asn1.m paramm)
  {
    org.bouncycastle.asn1.x509.m localm = this.extensions;
    if (localm != null) {
      return localm.g(paramm);
    }
    return null;
  }
  
  public List getExtensionOIDs()
  {
    return c.f(this.extensions);
  }
  
  public org.bouncycastle.asn1.x509.m getExtensions()
  {
    return this.extensions;
  }
  
  public org.bouncycastle.asn1.t2.c getIssuer()
  {
    return org.bouncycastle.asn1.t2.c.f(this.x509Certificate.h());
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return c.g(this.extensions);
  }
  
  public Date getNotAfter()
  {
    return this.x509Certificate.f().f();
  }
  
  public Date getNotBefore()
  {
    return this.x509Certificate.l().f();
  }
  
  public BigInteger getSerialNumber()
  {
    return this.x509Certificate.i().p();
  }
  
  public byte[] getSignature()
  {
    return this.x509Certificate.j().p();
  }
  
  public a getSignatureAlgorithm()
  {
    return this.x509Certificate.k();
  }
  
  public org.bouncycastle.asn1.t2.c getSubject()
  {
    return org.bouncycastle.asn1.t2.c.f(this.x509Certificate.m());
  }
  
  public w getSubjectPublicKeyInfo()
  {
    return this.x509Certificate.n();
  }
  
  public int getVersion()
  {
    return this.x509Certificate.p();
  }
  
  public int getVersionNumber()
  {
    return this.x509Certificate.p();
  }
  
  public boolean hasExtensions()
  {
    boolean bool;
    if (this.extensions != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.x509Certificate.hashCode();
  }
  
  public boolean isSignatureValid(org.bouncycastle.operator.c paramc)
    throws CertException
  {
    y localy = this.x509Certificate.o();
    if (c.h(localy.l(), this.x509Certificate.k())) {
      try
      {
        paramc = paramc.a(localy.l());
        OutputStream localOutputStream = paramc.getOutputStream();
        z0 localz0 = new org/bouncycastle/asn1/z0;
        localz0.<init>(localOutputStream);
        localz0.j(localy);
        localOutputStream.close();
        return paramc.verify(getSignature());
      }
      catch (Exception localException)
      {
        paramc = new StringBuilder();
        paramc.append("unable to process signature: ");
        paramc.append(localException.getMessage());
        throw new CertException(paramc.toString(), localException);
      }
    }
    throw new CertException("signature invalid - algorithm identifier mismatch");
  }
  
  public boolean isValidOn(Date paramDate)
  {
    boolean bool;
    if ((!paramDate.before(this.x509Certificate.l().f())) && (!paramDate.after(this.x509Certificate.f().f()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public h toASN1Structure()
  {
    return this.x509Certificate;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\X509CertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
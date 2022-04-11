package org.bouncycastle.cert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x509.d;
import org.bouncycastle.asn1.x509.e;
import org.bouncycastle.asn1.x509.f;
import org.bouncycastle.asn1.z0;

public class X509AttributeCertificateHolder
  implements Serializable
{
  private static d[] EMPTY_ARRAY = new d[0];
  private static final long serialVersionUID = 20170722001L;
  private transient e attrCert;
  private transient org.bouncycastle.asn1.x509.m extensions;
  
  public X509AttributeCertificateHolder(e parame)
  {
    init(parame);
  }
  
  public X509AttributeCertificateHolder(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private void init(e parame)
  {
    this.attrCert = parame;
    this.extensions = parame.f().h();
  }
  
  private static e parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = e.g(c.i(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    init(e.g(paramObjectInputStream.readObject()));
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
    if (!(paramObject instanceof X509AttributeCertificateHolder)) {
      return false;
    }
    paramObject = (X509AttributeCertificateHolder)paramObject;
    return this.attrCert.equals(((X509AttributeCertificateHolder)paramObject).attrCert);
  }
  
  public d[] getAttributes()
  {
    r localr = this.attrCert.f().g();
    d[] arrayOfd = new d[localr.size()];
    for (int i = 0; i != localr.size(); i++) {
      arrayOfd[i] = d.g(localr.p(i));
    }
    return arrayOfd;
  }
  
  public d[] getAttributes(org.bouncycastle.asn1.m paramm)
  {
    r localr = this.attrCert.f().g();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i != localr.size(); i++)
    {
      d locald = d.g(localr.p(i));
      if (locald.f().equals(paramm)) {
        localArrayList.add(locald);
      }
    }
    if (localArrayList.size() == 0) {
      return EMPTY_ARRAY;
    }
    return (d[])localArrayList.toArray(new d[localArrayList.size()]);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return c.e(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.attrCert.d();
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
  
  public a getHolder()
  {
    return new a((r)this.attrCert.f().i().c());
  }
  
  public b getIssuer()
  {
    return new b(this.attrCert.f().k());
  }
  
  public boolean[] getIssuerUniqueID()
  {
    return c.a(this.attrCert.f().l());
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return c.g(this.extensions);
  }
  
  public Date getNotAfter()
  {
    return c.j(this.attrCert.f().f().g());
  }
  
  public Date getNotBefore()
  {
    return c.j(this.attrCert.f().f().h());
  }
  
  public BigInteger getSerialNumber()
  {
    return this.attrCert.f().m().p();
  }
  
  public byte[] getSignature()
  {
    return this.attrCert.i().p();
  }
  
  public org.bouncycastle.asn1.x509.a getSignatureAlgorithm()
  {
    return this.attrCert.h();
  }
  
  public int getVersion()
  {
    return this.attrCert.f().o().p().intValue() + 1;
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
    return this.attrCert.hashCode();
  }
  
  public boolean isSignatureValid(org.bouncycastle.operator.c paramc)
    throws CertException
  {
    f localf = this.attrCert.f();
    if (c.h(localf.n(), this.attrCert.h())) {
      try
      {
        org.bouncycastle.operator.b localb = paramc.a(localf.n());
        OutputStream localOutputStream = localb.getOutputStream();
        paramc = new org/bouncycastle/asn1/z0;
        paramc.<init>(localOutputStream);
        paramc.j(localf);
        localOutputStream.close();
        return localb.verify(getSignature());
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
    org.bouncycastle.asn1.x509.c localc = this.attrCert.f().f();
    boolean bool;
    if ((!paramDate.before(c.j(localc.h()))) && (!paramDate.after(c.j(localc.g())))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public e toASN1Structure()
  {
    return this.attrCert;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\X509AttributeCertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
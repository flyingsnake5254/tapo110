package org.bouncycastle.cert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.x509.o;
import org.bouncycastle.asn1.x509.p;
import org.bouncycastle.asn1.x509.s;
import org.bouncycastle.asn1.x509.x;
import org.bouncycastle.asn1.x509.x.b;
import org.bouncycastle.asn1.z0;

public class X509CRLHolder
  implements Serializable
{
  private static final long serialVersionUID = 20170722001L;
  private transient org.bouncycastle.asn1.x509.m extensions;
  private transient boolean isIndirect;
  private transient p issuerName;
  private transient org.bouncycastle.asn1.x509.i x509CRL;
  
  public X509CRLHolder(InputStream paramInputStream)
    throws IOException
  {
    this(parseStream(paramInputStream));
  }
  
  public X509CRLHolder(org.bouncycastle.asn1.x509.i parami)
  {
    init(parami);
  }
  
  public X509CRLHolder(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseStream(new ByteArrayInputStream(paramArrayOfByte)));
  }
  
  private void init(org.bouncycastle.asn1.x509.i parami)
  {
    this.x509CRL = parami;
    org.bouncycastle.asn1.x509.m localm = parami.l().f();
    this.extensions = localm;
    this.isIndirect = isIndirectCRL(localm);
    this.issuerName = new p(new o(parami.g()));
  }
  
  private static boolean isIndirectCRL(org.bouncycastle.asn1.x509.m paramm)
  {
    boolean bool1 = false;
    if (paramm == null) {
      return false;
    }
    paramm = paramm.g(org.bouncycastle.asn1.x509.l.I3);
    boolean bool2 = bool1;
    if (paramm != null)
    {
      bool2 = bool1;
      if (s.h(paramm.j()).i()) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private static org.bouncycastle.asn1.x509.i parseStream(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      localObject = new org/bouncycastle/asn1/i;
      ((org.bouncycastle.asn1.i)localObject).<init>(paramInputStream, true);
      paramInputStream = ((org.bouncycastle.asn1.i)localObject).t();
      if (paramInputStream != null) {
        return org.bouncycastle.asn1.x509.i.f(paramInputStream);
      }
      paramInputStream = new java/io/IOException;
      paramInputStream.<init>("no content found");
      throw paramInputStream;
    }
    catch (IllegalArgumentException paramInputStream)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("malformed data: ");
      ((StringBuilder)localObject).append(paramInputStream.getMessage());
      throw new CertIOException(((StringBuilder)localObject).toString(), paramInputStream);
    }
    catch (ClassCastException localClassCastException)
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append("malformed data: ");
      paramInputStream.append(localClassCastException.getMessage());
      throw new CertIOException(paramInputStream.toString(), localClassCastException);
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    init(org.bouncycastle.asn1.x509.i.f(paramObjectInputStream.readObject()));
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
    if (!(paramObject instanceof X509CRLHolder)) {
      return false;
    }
    paramObject = (X509CRLHolder)paramObject;
    return this.x509CRL.equals(((X509CRLHolder)paramObject).x509CRL);
  }
  
  public Set getCriticalExtensionOIDs()
  {
    return c.e(this.extensions);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.x509CRL.d();
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
    return org.bouncycastle.asn1.t2.c.f(this.x509CRL.g());
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    return c.g(this.extensions);
  }
  
  public d getRevokedCertificate(BigInteger paramBigInteger)
  {
    p localp = this.issuerName;
    Enumeration localEnumeration = this.x509CRL.h();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (x.b)localEnumeration.nextElement();
      if (((x.b)localObject).h().p().equals(paramBigInteger)) {
        return new d((x.b)localObject, this.isIndirect, localp);
      }
      if ((this.isIndirect) && (((x.b)localObject).i()))
      {
        localObject = ((x.b)localObject).f().g(org.bouncycastle.asn1.x509.l.J3);
        if (localObject != null) {
          localp = p.f(((org.bouncycastle.asn1.x509.l)localObject).j());
        }
      }
    }
    return null;
  }
  
  public Collection getRevokedCertificates()
  {
    ArrayList localArrayList = new ArrayList(this.x509CRL.i().length);
    Object localObject = this.issuerName;
    Enumeration localEnumeration = this.x509CRL.h();
    while (localEnumeration.hasMoreElements())
    {
      localObject = new d((x.b)localEnumeration.nextElement(), this.isIndirect, (p)localObject);
      localArrayList.add(localObject);
      localObject = ((d)localObject).a();
    }
    return localArrayList;
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
    return this.x509CRL.hashCode();
  }
  
  public boolean isSignatureValid(org.bouncycastle.operator.c paramc)
    throws CertException
  {
    x localx = this.x509CRL.l();
    if (c.h(localx.k(), this.x509CRL.k())) {
      try
      {
        org.bouncycastle.operator.b localb = paramc.a(localx.k());
        OutputStream localOutputStream = localb.getOutputStream();
        paramc = new org/bouncycastle/asn1/z0;
        paramc.<init>(localOutputStream);
        paramc.j(localx);
        localOutputStream.close();
        return localb.verify(this.x509CRL.j().p());
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
  
  public org.bouncycastle.asn1.x509.i toASN1Structure()
  {
    return this.x509CRL;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\X509CRLHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.security.NoSuchProviderException;
import java.security.cert.CertPath;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.b1;
import org.bouncycastle.asn1.d1;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.i;
import org.bouncycastle.asn1.j;
import org.bouncycastle.asn1.n2.d;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.jcajce.a.a;
import org.bouncycastle.jcajce.a.c;
import org.bouncycastle.util.io.pem.b;

public class PKIXCertPath
  extends CertPath
{
  static final List certPathEncodings;
  private List certificates;
  private final c helper;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("PkiPath");
    localArrayList.add("PEM");
    localArrayList.add("PKCS7");
    certPathEncodings = Collections.unmodifiableList(localArrayList);
  }
  
  PKIXCertPath(InputStream paramInputStream, String paramString)
    throws CertificateException
  {
    super("X.509");
    Object localObject = new a();
    this.helper = ((c)localObject);
    try
    {
      if (paramString.equalsIgnoreCase("PkiPath"))
      {
        paramString = new org/bouncycastle/asn1/i;
        paramString.<init>(paramInputStream);
        paramInputStream = paramString.t();
        if ((paramInputStream instanceof r))
        {
          paramInputStream = ((r)paramInputStream).q();
          paramString = new java/util/ArrayList;
          paramString.<init>();
          this.certificates = paramString;
          localObject = ((c)localObject).a("X.509");
          while (paramInputStream.hasMoreElements())
          {
            byte[] arrayOfByte = ((e)paramInputStream.nextElement()).c().e("DER");
            paramString = this.certificates;
            ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
            localByteArrayInputStream.<init>(arrayOfByte);
            paramString.add(0, ((CertificateFactory)localObject).generateCertificate(localByteArrayInputStream));
          }
        }
        paramInputStream = new java/security/cert/CertificateException;
        paramInputStream.<init>("input stream does not contain a ASN1 SEQUENCE while reading PkiPath encoded data to load CertPath");
        throw paramInputStream;
      }
      if ((!paramString.equalsIgnoreCase("PKCS7")) && (!paramString.equalsIgnoreCase("PEM")))
      {
        localObject = new java/security/cert/CertificateException;
        paramInputStream = new java/lang/StringBuilder;
        paramInputStream.<init>();
        paramInputStream.append("unsupported encoding: ");
        paramInputStream.append(paramString);
        ((CertificateException)localObject).<init>(paramInputStream.toString());
        throw ((Throwable)localObject);
      }
      paramString = new java/io/BufferedInputStream;
      paramString.<init>(paramInputStream);
      paramInputStream = new java/util/ArrayList;
      paramInputStream.<init>();
      this.certificates = paramInputStream;
      paramInputStream = ((c)localObject).a("X.509");
      for (;;)
      {
        localObject = paramInputStream.generateCertificate(paramString);
        if (localObject == null) {
          break;
        }
        this.certificates.add(localObject);
      }
      this.certificates = sortCerts(this.certificates);
      return;
    }
    catch (NoSuchProviderException paramString)
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append("BouncyCastle provider not found while trying to get a CertificateFactory:\n");
      paramInputStream.append(paramString.toString());
      throw new CertificateException(paramInputStream.toString());
    }
    catch (IOException paramString)
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append("IOException throw while decoding CertPath:\n");
      paramInputStream.append(paramString.toString());
      throw new CertificateException(paramInputStream.toString());
    }
  }
  
  PKIXCertPath(List paramList)
  {
    super("X.509");
    this.helper = new a();
    this.certificates = sortCerts(new ArrayList(paramList));
  }
  
  private List sortCerts(List paramList)
  {
    if (paramList.size() < 2) {
      return paramList;
    }
    Object localObject = ((X509Certificate)paramList.get(0)).getIssuerX500Principal();
    int i = 1;
    while (i != paramList.size()) {
      if (((X500Principal)localObject).equals(((X509Certificate)paramList.get(i)).getSubjectX500Principal()))
      {
        localObject = ((X509Certificate)paramList.get(i)).getIssuerX500Principal();
        i++;
      }
      else
      {
        i = 0;
        break label85;
      }
    }
    i = 1;
    label85:
    if (i != 0) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    localObject = new ArrayList(paramList);
    X509Certificate localX509Certificate;
    X500Principal localX500Principal;
    int j;
    for (i = 0; i < paramList.size(); i++)
    {
      localX509Certificate = (X509Certificate)paramList.get(i);
      localX500Principal = localX509Certificate.getSubjectX500Principal();
      for (j = 0; j != paramList.size(); j++) {
        if (((X509Certificate)paramList.get(j)).getIssuerX500Principal().equals(localX500Principal))
        {
          j = 1;
          break label197;
        }
      }
      j = 0;
      label197:
      if (j == 0)
      {
        localArrayList.add(localX509Certificate);
        paramList.remove(i);
      }
    }
    if (localArrayList.size() > 1) {
      return (List)localObject;
    }
    for (i = 0; i != localArrayList.size(); i++)
    {
      localX500Principal = ((X509Certificate)localArrayList.get(i)).getIssuerX500Principal();
      for (j = 0; j < paramList.size(); j++)
      {
        localX509Certificate = (X509Certificate)paramList.get(j);
        if (localX500Principal.equals(localX509Certificate.getSubjectX500Principal()))
        {
          localArrayList.add(localX509Certificate);
          paramList.remove(j);
          break;
        }
      }
    }
    if (paramList.size() > 0) {
      return (List)localObject;
    }
    return localArrayList;
  }
  
  private q toASN1Object(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    try
    {
      i locali = new org/bouncycastle/asn1/i;
      locali.<init>(paramX509Certificate.getEncoded());
      paramX509Certificate = locali.t();
      return paramX509Certificate;
    }
    catch (Exception localException)
    {
      paramX509Certificate = new StringBuilder();
      paramX509Certificate.append("Exception while encoding certificate: ");
      paramX509Certificate.append(localException.toString());
      throw new CertificateEncodingException(paramX509Certificate.toString());
    }
  }
  
  private byte[] toDEREncoded(e parame)
    throws CertificateEncodingException
  {
    try
    {
      parame = parame.c().e("DER");
      return parame;
    }
    catch (IOException localIOException)
    {
      parame = new StringBuilder();
      parame.append("Exception thrown: ");
      parame.append(localIOException);
      throw new CertificateEncodingException(parame.toString());
    }
  }
  
  public List getCertificates()
  {
    return Collections.unmodifiableList(new ArrayList(this.certificates));
  }
  
  public byte[] getEncoded()
    throws CertificateEncodingException
  {
    Object localObject = getEncodings();
    if (((Iterator)localObject).hasNext())
    {
      localObject = ((Iterator)localObject).next();
      if ((localObject instanceof String)) {
        return getEncoded((String)localObject);
      }
    }
    return null;
  }
  
  public byte[] getEncoded(String paramString)
    throws CertificateEncodingException
  {
    if (paramString.equalsIgnoreCase("PkiPath"))
    {
      paramString = new org.bouncycastle.asn1.f();
      localObject = this.certificates;
      localObject = ((List)localObject).listIterator(((List)localObject).size());
      while (((ListIterator)localObject).hasPrevious()) {
        paramString.a(toASN1Object((X509Certificate)((ListIterator)localObject).previous()));
      }
      return toDEREncoded(new b1(paramString));
    }
    boolean bool = paramString.equalsIgnoreCase("PKCS7");
    int i = 0;
    int j = 0;
    if (bool)
    {
      paramString = new d(g.r0, null);
      localObject = new org.bouncycastle.asn1.f();
      while (j != this.certificates.size())
      {
        ((org.bouncycastle.asn1.f)localObject).a(toASN1Object((X509Certificate)this.certificates.get(j)));
        j++;
      }
      paramString = new org.bouncycastle.asn1.n2.l(new j(1L), new d1(), paramString, new d1((org.bouncycastle.asn1.f)localObject), null, new d1());
      return toDEREncoded(new d(g.s0, paramString));
    }
    if (paramString.equalsIgnoreCase("PEM"))
    {
      paramString = new ByteArrayOutputStream();
      localObject = new org.bouncycastle.util.io.pem.f(new OutputStreamWriter(paramString));
      j = i;
      try
      {
        while (j != this.certificates.size())
        {
          b localb = new org/bouncycastle/util/io/pem/b;
          localb.<init>("CERTIFICATE", ((X509Certificate)this.certificates.get(j)).getEncoded());
          ((org.bouncycastle.util.io.pem.f)localObject).c(localb);
          j++;
        }
        ((BufferedWriter)localObject).close();
        return paramString.toByteArray();
      }
      catch (Exception paramString)
      {
        throw new CertificateEncodingException("can't encode certificate for PEM encoded path");
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unsupported encoding: ");
    ((StringBuilder)localObject).append(paramString);
    throw new CertificateEncodingException(((StringBuilder)localObject).toString());
  }
  
  public Iterator getEncodings()
  {
    return certPathEncodings.iterator();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\x509\PKIXCertPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

final class OpenSslX509Certificate
  extends X509Certificate
{
  private final byte[] bytes;
  private X509Certificate wrapped;
  
  OpenSslX509Certificate(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  private X509Certificate unwrap()
  {
    Object localObject1 = this.wrapped;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        localObject1 = SslContext.X509_CERT_FACTORY;
        localObject2 = new java/io/ByteArrayInputStream;
        ((ByteArrayInputStream)localObject2).<init>(this.bytes);
        localObject2 = (X509Certificate)((CertificateFactory)localObject1).generateCertificate((InputStream)localObject2);
        this.wrapped = ((X509Certificate)localObject2);
      }
      catch (CertificateException localCertificateException)
      {
        throw new IllegalStateException(localCertificateException);
      }
    }
    return localCertificateException;
  }
  
  public void checkValidity()
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    unwrap().checkValidity();
  }
  
  public void checkValidity(Date paramDate)
    throws CertificateExpiredException, CertificateNotYetValidException
  {
    unwrap().checkValidity(paramDate);
  }
  
  public int getBasicConstraints()
  {
    return unwrap().getBasicConstraints();
  }
  
  public Set<String> getCriticalExtensionOIDs()
  {
    return unwrap().getCriticalExtensionOIDs();
  }
  
  public byte[] getEncoded()
  {
    return (byte[])this.bytes.clone();
  }
  
  public List<String> getExtendedKeyUsage()
    throws CertificateParsingException
  {
    return unwrap().getExtendedKeyUsage();
  }
  
  public byte[] getExtensionValue(String paramString)
  {
    return unwrap().getExtensionValue(paramString);
  }
  
  public Collection<List<?>> getIssuerAlternativeNames()
    throws CertificateParsingException
  {
    return unwrap().getSubjectAlternativeNames();
  }
  
  public Principal getIssuerDN()
  {
    return unwrap().getIssuerDN();
  }
  
  public boolean[] getIssuerUniqueID()
  {
    return unwrap().getIssuerUniqueID();
  }
  
  public X500Principal getIssuerX500Principal()
  {
    return unwrap().getIssuerX500Principal();
  }
  
  public boolean[] getKeyUsage()
  {
    return unwrap().getKeyUsage();
  }
  
  public Set<String> getNonCriticalExtensionOIDs()
  {
    return unwrap().getNonCriticalExtensionOIDs();
  }
  
  public Date getNotAfter()
  {
    return unwrap().getNotAfter();
  }
  
  public Date getNotBefore()
  {
    return unwrap().getNotBefore();
  }
  
  public PublicKey getPublicKey()
  {
    return unwrap().getPublicKey();
  }
  
  public BigInteger getSerialNumber()
  {
    return unwrap().getSerialNumber();
  }
  
  public String getSigAlgName()
  {
    return unwrap().getSigAlgName();
  }
  
  public String getSigAlgOID()
  {
    return unwrap().getSigAlgOID();
  }
  
  public byte[] getSigAlgParams()
  {
    return unwrap().getSigAlgParams();
  }
  
  public byte[] getSignature()
  {
    return unwrap().getSignature();
  }
  
  public Collection<List<?>> getSubjectAlternativeNames()
    throws CertificateParsingException
  {
    return unwrap().getSubjectAlternativeNames();
  }
  
  public Principal getSubjectDN()
  {
    return unwrap().getSubjectDN();
  }
  
  public boolean[] getSubjectUniqueID()
  {
    return unwrap().getSubjectUniqueID();
  }
  
  public X500Principal getSubjectX500Principal()
  {
    return unwrap().getSubjectX500Principal();
  }
  
  public byte[] getTBSCertificate()
    throws CertificateEncodingException
  {
    return unwrap().getTBSCertificate();
  }
  
  public int getVersion()
  {
    return unwrap().getVersion();
  }
  
  public boolean hasUnsupportedCriticalExtension()
  {
    return unwrap().hasUnsupportedCriticalExtension();
  }
  
  public String toString()
  {
    return unwrap().toString();
  }
  
  public void verify(PublicKey paramPublicKey)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    unwrap().verify(paramPublicKey);
  }
  
  public void verify(PublicKey paramPublicKey, String paramString)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException
  {
    unwrap().verify(paramPublicKey, paramString);
  }
  
  @SuppressJava6Requirement(reason="Can only be called from Java8 as class is package-private")
  public void verify(PublicKey paramPublicKey, Provider paramProvider)
    throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
  {
    unwrap().verify(paramPublicKey, paramProvider);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslX509Certificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
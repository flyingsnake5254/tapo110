package io.netty.handler.ssl;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Date;
import javax.security.cert.CertificateException;
import javax.security.cert.CertificateExpiredException;
import javax.security.cert.CertificateNotYetValidException;
import javax.security.cert.X509Certificate;

final class OpenSslJavaxX509Certificate
  extends X509Certificate
{
  private final byte[] bytes;
  private X509Certificate wrapped;
  
  OpenSslJavaxX509Certificate(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  private X509Certificate unwrap()
  {
    X509Certificate localX509Certificate1 = this.wrapped;
    X509Certificate localX509Certificate2 = localX509Certificate1;
    if (localX509Certificate1 == null) {
      try
      {
        localX509Certificate2 = X509Certificate.getInstance(this.bytes);
        this.wrapped = localX509Certificate2;
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
  
  public byte[] getEncoded()
  {
    return (byte[])this.bytes.clone();
  }
  
  public Principal getIssuerDN()
  {
    return unwrap().getIssuerDN();
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
  
  public Principal getSubjectDN()
  {
    return unwrap().getSubjectDN();
  }
  
  public int getVersion()
  {
    return unwrap().getVersion();
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslJavaxX509Certificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
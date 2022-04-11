package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;

public class c
{
  private a a = new b();
  
  public X509Certificate a(X509CertificateHolder paramX509CertificateHolder)
    throws CertificateException
  {
    try
    {
      CertificateFactory localCertificateFactory = this.a.b("X.509");
      localObject = new java/io/ByteArrayInputStream;
      ((ByteArrayInputStream)localObject).<init>(paramX509CertificateHolder.getEncoded());
      paramX509CertificateHolder = (X509Certificate)localCertificateFactory.generateCertificate((InputStream)localObject);
      return paramX509CertificateHolder;
    }
    catch (NoSuchProviderException paramX509CertificateHolder)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot find required provider:");
      ((StringBuilder)localObject).append(paramX509CertificateHolder.getMessage());
      throw new a(((StringBuilder)localObject).toString(), paramX509CertificateHolder);
    }
    catch (IOException localIOException)
    {
      paramX509CertificateHolder = new StringBuilder();
      paramX509CertificateHolder.append("exception parsing certificate: ");
      paramX509CertificateHolder.append(localIOException.getMessage());
      throw new b(paramX509CertificateHolder.toString(), localIOException);
    }
  }
  
  public c b(Provider paramProvider)
  {
    this.a = new e(paramProvider);
    return this;
  }
  
  private class a
    extends CertificateException
  {
    private Throwable c;
    
    public a(String paramString, Throwable paramThrowable)
    {
      super();
      this.c = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.c;
    }
  }
  
  private class b
    extends CertificateParsingException
  {
    private Throwable c;
    
    public b(String paramString, Throwable paramThrowable)
    {
      super();
      this.c = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.c;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\jcajce\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
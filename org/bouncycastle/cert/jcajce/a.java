package org.bouncycastle.cert.jcajce;

import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

abstract class a
{
  protected abstract CertificateFactory a(String paramString)
    throws CertificateException, NoSuchProviderException;
  
  public CertificateFactory b(String paramString)
    throws NoSuchProviderException, CertificateException
  {
    return a(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\jcajce\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.cert.jcajce;

import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

class e
  extends a
{
  private final Provider a;
  
  e(Provider paramProvider)
  {
    this.a = paramProvider;
  }
  
  protected CertificateFactory a(String paramString)
    throws CertificateException
  {
    return CertificateFactory.getInstance(paramString, this.a);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\jcajce\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
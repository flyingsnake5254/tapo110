package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.x509.h;
import org.bouncycastle.cert.X509CertificateHolder;

public class JcaX509CertificateHolder
  extends X509CertificateHolder
{
  public JcaX509CertificateHolder(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    super(h.g(paramX509Certificate.getEncoded()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\jcajce\JcaX509CertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
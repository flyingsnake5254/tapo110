package org.bouncycastle.jcajce.a;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class e
  implements c
{
  protected final Provider a;
  
  public e(Provider paramProvider)
  {
    this.a = paramProvider;
  }
  
  public CertificateFactory a(String paramString)
    throws CertificateException
  {
    return CertificateFactory.getInstance(paramString, this.a);
  }
  
  public Signature b(String paramString)
    throws NoSuchAlgorithmException
  {
    return Signature.getInstance(paramString, this.a);
  }
  
  public KeyFactory c(String paramString)
    throws NoSuchAlgorithmException
  {
    return KeyFactory.getInstance(paramString, this.a);
  }
  
  public MessageDigest d(String paramString)
    throws NoSuchAlgorithmException
  {
    return MessageDigest.getInstance(paramString, this.a);
  }
  
  public AlgorithmParameters e(String paramString)
    throws NoSuchAlgorithmException
  {
    return AlgorithmParameters.getInstance(paramString, this.a);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
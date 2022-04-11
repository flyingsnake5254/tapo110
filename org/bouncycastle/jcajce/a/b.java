package org.bouncycastle.jcajce.a;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class b
  implements c
{
  public CertificateFactory a(String paramString)
    throws CertificateException
  {
    return CertificateFactory.getInstance(paramString);
  }
  
  public Signature b(String paramString)
    throws NoSuchAlgorithmException
  {
    return Signature.getInstance(paramString);
  }
  
  public KeyFactory c(String paramString)
    throws NoSuchAlgorithmException
  {
    return KeyFactory.getInstance(paramString);
  }
  
  public MessageDigest d(String paramString)
    throws NoSuchAlgorithmException
  {
    return MessageDigest.getInstance(paramString);
  }
  
  public AlgorithmParameters e(String paramString)
    throws NoSuchAlgorithmException
  {
    return AlgorithmParameters.getInstance(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
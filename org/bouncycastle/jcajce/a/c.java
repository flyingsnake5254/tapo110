package org.bouncycastle.jcajce.a;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public abstract interface c
{
  public abstract CertificateFactory a(String paramString)
    throws NoSuchProviderException, CertificateException;
  
  public abstract Signature b(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException;
  
  public abstract KeyFactory c(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException;
  
  public abstract MessageDigest d(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException;
  
  public abstract AlgorithmParameters e(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
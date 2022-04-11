package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import javax.net.ssl.SSLEngine;

public abstract interface OpenSslPrivateKeyMethod
{
  public static final int SSL_SIGN_ECDSA_SECP256R1_SHA256;
  public static final int SSL_SIGN_ECDSA_SECP384R1_SHA384;
  public static final int SSL_SIGN_ECDSA_SECP521R1_SHA512;
  public static final int SSL_SIGN_ECDSA_SHA1;
  public static final int SSL_SIGN_ED25519 = SSLPrivateKeyMethod.SSL_SIGN_ED25519;
  public static final int SSL_SIGN_RSA_PKCS1_MD5_SHA1 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_MD5_SHA1;
  public static final int SSL_SIGN_RSA_PKCS1_SHA1 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA1;
  public static final int SSL_SIGN_RSA_PKCS1_SHA256 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA256;
  public static final int SSL_SIGN_RSA_PKCS1_SHA384 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA384;
  public static final int SSL_SIGN_RSA_PKCS1_SHA512 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PKCS1_SHA512;
  public static final int SSL_SIGN_RSA_PSS_RSAE_SHA256;
  public static final int SSL_SIGN_RSA_PSS_RSAE_SHA384;
  public static final int SSL_SIGN_RSA_PSS_RSAE_SHA512;
  
  static
  {
    SSL_SIGN_ECDSA_SHA1 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SHA1;
    SSL_SIGN_ECDSA_SECP256R1_SHA256 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SECP256R1_SHA256;
    SSL_SIGN_ECDSA_SECP384R1_SHA384 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SECP384R1_SHA384;
    SSL_SIGN_ECDSA_SECP521R1_SHA512 = SSLPrivateKeyMethod.SSL_SIGN_ECDSA_SECP521R1_SHA512;
    SSL_SIGN_RSA_PSS_RSAE_SHA256 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA256;
    SSL_SIGN_RSA_PSS_RSAE_SHA384 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA384;
    SSL_SIGN_RSA_PSS_RSAE_SHA512 = SSLPrivateKeyMethod.SSL_SIGN_RSA_PSS_RSAE_SHA512;
  }
  
  public abstract byte[] decrypt(SSLEngine paramSSLEngine, byte[] paramArrayOfByte)
    throws Exception;
  
  public abstract byte[] sign(SSLEngine paramSSLEngine, int paramInt, byte[] paramArrayOfByte)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslPrivateKeyMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.openssl.g;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.jcajce.a.b;
import org.bouncycastle.openssl.PEMException;

public class a
{
  private static final Map a;
  private org.bouncycastle.jcajce.a.c b = new b();
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(p.B2, "ECDSA");
    localHashMap.put(g.B, "RSA");
    localHashMap.put(p.l3, "DSA");
  }
  
  private KeyFactory a(org.bouncycastle.asn1.x509.a parama)
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    m localm = parama.f();
    Object localObject = (String)a.get(localm);
    parama = (org.bouncycastle.asn1.x509.a)localObject;
    if (localObject == null) {
      parama = localm.q();
    }
    try
    {
      localObject = this.b.c(parama);
      return (KeyFactory)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      if (parama.equals("ECDSA")) {
        return this.b.c("EC");
      }
      throw localNoSuchAlgorithmException;
    }
  }
  
  public KeyPair b(org.bouncycastle.openssl.c paramc)
    throws PEMException
  {
    try
    {
      KeyFactory localKeyFactory = a(paramc.a().h());
      Object localObject = new java/security/spec/X509EncodedKeySpec;
      ((X509EncodedKeySpec)localObject).<init>(paramc.b().d());
      PublicKey localPublicKey = localKeyFactory.generatePublic((KeySpec)localObject);
      localObject = new java/security/spec/PKCS8EncodedKeySpec;
      ((PKCS8EncodedKeySpec)localObject).<init>(paramc.a().d());
      paramc = new KeyPair(localPublicKey, localKeyFactory.generatePrivate((KeySpec)localObject));
      return paramc;
    }
    catch (Exception localException)
    {
      paramc = new StringBuilder();
      paramc.append("unable to convert key pair: ");
      paramc.append(localException.getMessage());
      throw new PEMException(paramc.toString(), localException);
    }
  }
  
  public PrivateKey c(h paramh)
    throws PEMException
  {
    try
    {
      localObject = a(paramh.h());
      PKCS8EncodedKeySpec localPKCS8EncodedKeySpec = new java/security/spec/PKCS8EncodedKeySpec;
      localPKCS8EncodedKeySpec.<init>(paramh.d());
      paramh = ((KeyFactory)localObject).generatePrivate(localPKCS8EncodedKeySpec);
      return paramh;
    }
    catch (Exception paramh)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to convert key pair: ");
      ((StringBuilder)localObject).append(paramh.getMessage());
      throw new PEMException(((StringBuilder)localObject).toString(), paramh);
    }
  }
  
  public PublicKey d(w paramw)
    throws PEMException
  {
    try
    {
      KeyFactory localKeyFactory = a(paramw.f());
      X509EncodedKeySpec localX509EncodedKeySpec = new java/security/spec/X509EncodedKeySpec;
      localX509EncodedKeySpec.<init>(paramw.d());
      paramw = localKeyFactory.generatePublic(localX509EncodedKeySpec);
      return paramw;
    }
    catch (Exception localException)
    {
      paramw = new StringBuilder();
      paramw.append("unable to convert key pair: ");
      paramw.append(localException.getMessage());
      throw new PEMException(paramw.toString(), localException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\openssl\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
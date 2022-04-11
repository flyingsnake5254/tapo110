package io.netty.handler.ssl.util;

import io.netty.util.internal.SuppressJava6Requirement;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Date;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

final class OpenJdkSelfSignedCertGenerator
{
  @SuppressJava6Requirement(reason="Usage guarded by dependency check")
  static String[] generate(String paramString1, KeyPair paramKeyPair, SecureRandom paramSecureRandom, Date paramDate1, Date paramDate2, String paramString2)
    throws Exception
  {
    PrivateKey localPrivateKey = paramKeyPair.getPrivate();
    X509CertInfo localX509CertInfo = new X509CertInfo();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CN=");
    ((StringBuilder)localObject).append(paramString1);
    localObject = new X500Name(((StringBuilder)localObject).toString());
    localX509CertInfo.set("version", new CertificateVersion(2));
    localX509CertInfo.set("serialNumber", new CertificateSerialNumber(new BigInteger(64, paramSecureRandom)));
    try
    {
      paramSecureRandom = new sun/security/x509/CertificateSubjectName;
      paramSecureRandom.<init>((X500Name)localObject);
      localX509CertInfo.set("subject", paramSecureRandom);
    }
    catch (CertificateException paramSecureRandom)
    {
      localX509CertInfo.set("subject", localObject);
    }
    try
    {
      paramSecureRandom = new sun/security/x509/CertificateIssuerName;
      paramSecureRandom.<init>((X500Name)localObject);
      localX509CertInfo.set("issuer", paramSecureRandom);
    }
    catch (CertificateException paramSecureRandom)
    {
      localX509CertInfo.set("issuer", localObject);
    }
    localX509CertInfo.set("validity", new CertificateValidity(paramDate1, paramDate2));
    localX509CertInfo.set("key", new CertificateX509Key(paramKeyPair.getPublic()));
    localX509CertInfo.set("algorithmID", new CertificateAlgorithmId(new AlgorithmId(AlgorithmId.sha256WithRSAEncryption_oid)));
    paramDate2 = new X509CertImpl(localX509CertInfo);
    boolean bool = paramString2.equalsIgnoreCase("EC");
    paramDate1 = "SHA256withECDSA";
    if (bool) {
      paramSecureRandom = "SHA256withECDSA";
    } else {
      paramSecureRandom = "SHA256withRSA";
    }
    paramDate2.sign(localPrivateKey, paramSecureRandom);
    localX509CertInfo.set("algorithmID.algorithm", paramDate2.get("x509.algorithm"));
    paramDate2 = new X509CertImpl(localX509CertInfo);
    if (paramString2.equalsIgnoreCase("EC")) {
      paramSecureRandom = paramDate1;
    } else {
      paramSecureRandom = "SHA256withRSA";
    }
    paramDate2.sign(localPrivateKey, paramSecureRandom);
    paramDate2.verify(paramKeyPair.getPublic());
    return SelfSignedCertificate.newSelfSignedCertificate(paramString1, localPrivateKey, paramDate2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\OpenJdkSelfSignedCertGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
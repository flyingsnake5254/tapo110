package io.netty.handler.ssl.util;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.cert.e;
import org.bouncycastle.cert.jcajce.d;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.e.a;

final class BouncyCastleSelfSignedCertGenerator
{
  private static final Provider PROVIDER = new BouncyCastleProvider();
  
  static String[] generate(String paramString1, KeyPair paramKeyPair, SecureRandom paramSecureRandom, Date paramDate1, Date paramDate2, String paramString2)
    throws Exception
  {
    PrivateKey localPrivateKey = paramKeyPair.getPrivate();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CN=");
    ((StringBuilder)localObject).append(paramString1);
    localObject = new org.bouncycastle.asn1.t2.c(((StringBuilder)localObject).toString());
    paramDate1 = new d((org.bouncycastle.asn1.t2.c)localObject, new BigInteger(64, paramSecureRandom), paramDate1, paramDate2, (org.bouncycastle.asn1.t2.c)localObject, paramKeyPair.getPublic());
    if (paramString2.equalsIgnoreCase("EC")) {
      paramSecureRandom = "SHA256withECDSA";
    } else {
      paramSecureRandom = "SHA256WithRSAEncryption";
    }
    paramSecureRandom = paramDate1.a(new a(paramSecureRandom).a(localPrivateKey));
    paramSecureRandom = new org.bouncycastle.cert.jcajce.c().b(PROVIDER).a(paramSecureRandom);
    paramSecureRandom.verify(paramKeyPair.getPublic());
    return SelfSignedCertificate.newSelfSignedCertificate(paramString1, localPrivateKey, paramSecureRandom);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\util\BouncyCastleSelfSignedCertGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
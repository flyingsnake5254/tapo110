package org.bouncycastle.cert.jcajce;

import java.math.BigInteger;
import java.security.PublicKey;
import java.util.Date;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.cert.e;

public class d
  extends e
{
  public d(c paramc1, BigInteger paramBigInteger, Date paramDate1, Date paramDate2, c paramc2, PublicKey paramPublicKey)
  {
    super(paramc1, paramBigInteger, paramDate1, paramDate2, paramc2, w.h(paramPublicKey.getEncoded()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\cert\jcajce\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
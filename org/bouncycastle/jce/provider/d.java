package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.n2.g;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.u2.p;
import org.bouncycastle.asn1.v0;

class d
{
  private static final org.bouncycastle.asn1.k a = v0.c;
  
  private static String a(m paramm)
  {
    if (g.j0.equals(paramm)) {
      return "MD5";
    }
    if (org.bouncycastle.asn1.m2.b.i.equals(paramm)) {
      return "SHA1";
    }
    if (org.bouncycastle.asn1.j2.b.f.equals(paramm)) {
      return "SHA224";
    }
    if (org.bouncycastle.asn1.j2.b.c.equals(paramm)) {
      return "SHA256";
    }
    if (org.bouncycastle.asn1.j2.b.d.equals(paramm)) {
      return "SHA384";
    }
    if (org.bouncycastle.asn1.j2.b.e.equals(paramm)) {
      return "SHA512";
    }
    if (org.bouncycastle.asn1.q2.b.c.equals(paramm)) {
      return "RIPEMD128";
    }
    if (org.bouncycastle.asn1.q2.b.b.equals(paramm)) {
      return "RIPEMD160";
    }
    if (org.bouncycastle.asn1.q2.b.d.equals(paramm)) {
      return "RIPEMD256";
    }
    if (org.bouncycastle.asn1.d2.a.b.equals(paramm)) {
      return "GOST3411";
    }
    return paramm.q();
  }
  
  static String b(org.bouncycastle.asn1.x509.a parama)
  {
    Object localObject = parama.i();
    if ((localObject != null) && (!a.equals(localObject)))
    {
      if (parama.f().equals(g.K))
      {
        parama = org.bouncycastle.asn1.n2.k.g(localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a(parama.f().f()));
        ((StringBuilder)localObject).append("withRSAandMGF1");
        return ((StringBuilder)localObject).toString();
      }
      if (parama.f().equals(p.C2))
      {
        parama = r.m(localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a(m.r(parama.p(0))));
        ((StringBuilder)localObject).append("withECDSA");
        return ((StringBuilder)localObject).toString();
      }
    }
    return parama.f().q();
  }
  
  static void c(Signature paramSignature, e parame)
    throws NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    if ((parame != null) && (!a.equals(parame)))
    {
      AlgorithmParameters localAlgorithmParameters = AlgorithmParameters.getInstance(paramSignature.getAlgorithm(), paramSignature.getProvider());
      try
      {
        localAlgorithmParameters.init(parame.c().d());
        if (paramSignature.getAlgorithm().endsWith("MGF1")) {
          try
          {
            paramSignature.setParameter(localAlgorithmParameters.getParameterSpec(PSSParameterSpec.class));
          }
          catch (GeneralSecurityException paramSignature)
          {
            parame = new StringBuilder();
            parame.append("Exception extracting parameters: ");
            parame.append(paramSignature.getMessage());
            throw new SignatureException(parame.toString());
          }
        }
        return;
      }
      catch (IOException paramSignature)
      {
        parame = new StringBuilder();
        parame.append("IOException decoding parameters: ");
        parame.append(paramSignature.getMessage());
        throw new SignatureException(parame.toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jce\provider\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
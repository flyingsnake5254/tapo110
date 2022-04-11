package org.bouncycastle.pqc.jcajce.provider.rainbow;

import e.a.c.a.g;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;

public class a
  extends KeyFactorySpi
  implements org.bouncycastle.jcajce.provider.util.b
{
  public PrivateKey a(org.bouncycastle.asn1.n2.h paramh)
    throws IOException
  {
    paramh = g.h(paramh.i());
    return new BCRainbowPrivateKey(paramh.i(), paramh.f(), paramh.j(), paramh.g(), paramh.l(), paramh.k());
  }
  
  public PublicKey b(w paramw)
    throws IOException
  {
    paramw = e.a.c.a.h.j(paramw.j());
    return new BCRainbowPublicKey(paramw.i(), paramw.f(), paramw.h(), paramw.g());
  }
  
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof e.a.c.c.a.a)) {
      return new BCRainbowPrivateKey((e.a.c.c.a.a)paramKeySpec);
    }
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = a(org.bouncycastle.asn1.n2.h.g(q.i(paramKeySpec)));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof e.a.c.c.a.b)) {
      return new BCRainbowPublicKey((e.a.c.c.a.b)paramKeySpec);
    }
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = b(w.h(paramKeySpec));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown key specification: ");
    localStringBuilder.append(paramKeySpec);
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public final KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramKey instanceof BCRainbowPrivateKey))
    {
      if (PKCS8EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new PKCS8EncodedKeySpec(paramKey.getEncoded());
      }
      if (e.a.c.c.a.a.class.isAssignableFrom(paramClass))
      {
        paramKey = (BCRainbowPrivateKey)paramKey;
        return new e.a.c.c.a.a(paramKey.getInvA1(), paramKey.getB1(), paramKey.getInvA2(), paramKey.getB2(), paramKey.getVi(), paramKey.getLayers());
      }
    }
    else
    {
      if (!(paramKey instanceof BCRainbowPublicKey)) {
        break label184;
      }
      if (X509EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new X509EncodedKeySpec(paramKey.getEncoded());
      }
      if (e.a.c.c.a.b.class.isAssignableFrom(paramClass))
      {
        paramKey = (BCRainbowPublicKey)paramKey;
        return new e.a.c.c.a.b(paramKey.getDocLength(), paramKey.getCoeffQuadratic(), paramKey.getCoeffSingular(), paramKey.getCoeffScalar());
      }
    }
    paramKey = new StringBuilder();
    paramKey.append("Unknown key specification: ");
    paramKey.append(paramClass);
    paramKey.append(".");
    throw new InvalidKeySpecException(paramKey.toString());
    label184:
    paramClass = new StringBuilder();
    paramClass.append("Unsupported key type: ");
    paramClass.append(paramKey.getClass());
    paramClass.append(".");
    throw new InvalidKeySpecException(paramClass.toString());
  }
  
  public final Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    if ((!(paramKey instanceof BCRainbowPrivateKey)) && (!(paramKey instanceof BCRainbowPublicKey))) {
      throw new InvalidKeyException("Unsupported key type");
    }
    return paramKey;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.pqc.jcajce.provider.xmss;

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
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.q;
import org.bouncycastle.asn1.x509.w;
import org.bouncycastle.jcajce.provider.util.b;

public class c
  extends KeyFactorySpi
  implements b
{
  public PrivateKey a(h paramh)
    throws IOException
  {
    return new BCXMSSMTPrivateKey(paramh);
  }
  
  public PublicKey b(w paramw)
    throws IOException
  {
    return new BCXMSSMTPublicKey(paramw);
  }
  
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = a(h.g(q.i(paramKeySpec)));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
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
    localStringBuilder.append("unknown key specification: ");
    localStringBuilder.append(paramKeySpec);
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public final KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramKey instanceof BCXMSSMTPrivateKey))
    {
      if (PKCS8EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new PKCS8EncodedKeySpec(paramKey.getEncoded());
      }
    }
    else
    {
      if (!(paramKey instanceof BCXMSSMTPublicKey)) {
        break label100;
      }
      if (X509EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new X509EncodedKeySpec(paramKey.getEncoded());
      }
    }
    paramKey = new StringBuilder();
    paramKey.append("unknown key specification: ");
    paramKey.append(paramClass);
    paramKey.append(".");
    throw new InvalidKeySpecException(paramKey.toString());
    label100:
    paramClass = new StringBuilder();
    paramClass.append("unsupported key type: ");
    paramClass.append(paramKey.getClass());
    paramClass.append(".");
    throw new InvalidKeySpecException(paramClass.toString());
  }
  
  public final Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    if ((!(paramKey instanceof BCXMSSMTPrivateKey)) && (!(paramKey instanceof BCXMSSMTPublicKey))) {
      throw new InvalidKeyException("unsupported key type");
    }
    return paramKey;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\xmss\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
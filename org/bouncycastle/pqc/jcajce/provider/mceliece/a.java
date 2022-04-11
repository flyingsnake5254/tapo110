package org.bouncycastle.pqc.jcajce.provider.mceliece;

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
import org.bouncycastle.crypto.g;

public class a
  extends KeyFactorySpi
  implements org.bouncycastle.jcajce.provider.util.b
{
  public PrivateKey a(h paramh)
    throws IOException
  {
    paramh = e.a.c.a.a.i(paramh.i().c());
    return new BCMcElieceCCA2PrivateKey(new e.a.c.b.b.b(paramh.k(), paramh.j(), paramh.g(), paramh.h(), paramh.l(), null));
  }
  
  public PublicKey b(w paramw)
    throws IOException
  {
    paramw = e.a.c.a.b.h(paramw.j());
    return new BCMcElieceCCA2PublicKey(new e.a.c.b.b.c(paramw.i(), paramw.j(), paramw.g(), c.b(paramw.f()).b()));
  }
  
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = h.g(q.i(paramKeySpec));
        try
        {
          if (e.a.c.a.e.n.equals(paramKeySpec.h().f()))
          {
            paramKeySpec = e.a.c.a.a.i(paramKeySpec.i());
            e.a.c.b.b.b localb = new e/a/c/b/b/b;
            localb.<init>(paramKeySpec.k(), paramKeySpec.j(), paramKeySpec.g(), paramKeySpec.h(), paramKeySpec.l(), c.b(paramKeySpec.f()).b());
            return new BCMcElieceCCA2PrivateKey(localb);
          }
          paramKeySpec = new java/security/spec/InvalidKeySpecException;
          paramKeySpec.<init>("Unable to recognise OID in McEliece public key");
          throw paramKeySpec;
        }
        catch (IOException paramKeySpec)
        {
          throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
        }
        localStringBuilder = new StringBuilder();
      }
      catch (IOException localIOException)
      {
        paramKeySpec = new StringBuilder();
        paramKeySpec.append("Unable to decode PKCS8EncodedKeySpec: ");
        paramKeySpec.append(localIOException);
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("Unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    Object localObject;
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = w.h(q.i(paramKeySpec));
        try
        {
          if (e.a.c.a.e.n.equals(paramKeySpec.f().f()))
          {
            paramKeySpec = e.a.c.a.b.h(paramKeySpec.j());
            localObject = new e/a/c/b/b/c;
            ((e.a.c.b.b.c)localObject).<init>(paramKeySpec.i(), paramKeySpec.j(), paramKeySpec.g(), c.b(paramKeySpec.f()).b());
            return new BCMcElieceCCA2PublicKey((e.a.c.b.b.c)localObject);
          }
          paramKeySpec = new java/security/spec/InvalidKeySpecException;
          paramKeySpec.<init>("Unable to recognise OID in McEliece private key");
          throw paramKeySpec;
        }
        catch (IOException paramKeySpec)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unable to decode X509EncodedKeySpec: ");
          ((StringBuilder)localObject).append(paramKeySpec.getMessage());
          throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
      }
      catch (IOException paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    ((StringBuilder)localObject).append("Unsupported key specification: ");
    ((StringBuilder)localObject).append(paramKeySpec.getClass());
    ((StringBuilder)localObject).append(".");
    throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    return null;
  }
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
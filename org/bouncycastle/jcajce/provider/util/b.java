package org.bouncycastle.jcajce.provider.util;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.asn1.n2.h;
import org.bouncycastle.asn1.x509.w;

public abstract interface b
{
  public abstract PrivateKey a(h paramh)
    throws IOException;
  
  public abstract PublicKey b(w paramw)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
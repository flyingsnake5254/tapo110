package org.bouncycastle.jcajce.a;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class a
  extends e
{
  private static volatile Provider b;
  
  public a()
  {
    super(f());
  }
  
  private static Provider f()
  {
    if (Security.getProvider("BC") != null) {
      return Security.getProvider("BC");
    }
    if (b != null) {
      return b;
    }
    b = new BouncyCastleProvider();
    return b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
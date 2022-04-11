package e.a.a;

import java.io.IOException;
import java.security.Principal;
import org.bouncycastle.asn1.l;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.t2.c;
import org.bouncycastle.asn1.x509.d0;

public class b
  extends d0
  implements Principal
{
  public b(c paramc)
  {
    super((r)paramc.c());
  }
  
  public byte[] d()
  {
    try
    {
      byte[] arrayOfByte = e("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.toString());
    }
  }
  
  public String getName()
  {
    return toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
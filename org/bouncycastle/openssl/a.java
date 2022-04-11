package org.bouncycastle.openssl;

import java.util.Enumeration;
import org.bouncycastle.asn1.e;
import org.bouncycastle.asn1.i1;
import org.bouncycastle.asn1.r;
import org.bouncycastle.asn1.x;

public class a
{
  private r a;
  private r b;
  private String c;
  
  a(byte[] paramArrayOfByte)
  {
    Enumeration localEnumeration = r.m(paramArrayOfByte).q();
    while (localEnumeration.hasMoreElements())
    {
      paramArrayOfByte = (e)localEnumeration.nextElement();
      if ((paramArrayOfByte instanceof r)) {
        this.a = r.m(paramArrayOfByte);
      } else if ((paramArrayOfByte instanceof x)) {
        this.b = r.n((x)paramArrayOfByte, false);
      } else if ((paramArrayOfByte instanceof i1)) {
        this.c = i1.m(paramArrayOfByte).getString();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\openssl\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class z
  extends a
{
  public z(int paramInt, f paramf)
  {
    super(true, paramInt, r(paramf));
  }
  
  private static byte[] r(f paramf)
  {
    Object localObject = new ByteArrayOutputStream();
    int i = 0;
    while (i != paramf.c()) {
      try
      {
        ((ByteArrayOutputStream)localObject).write(((l)paramf.b(i)).e("BER"));
        i++;
      }
      catch (IOException paramf)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("malformed object: ");
        ((StringBuilder)localObject).append(paramf);
        throw new ASN1ParsingException(((StringBuilder)localObject).toString(), paramf);
      }
    }
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  void g(p paramp)
    throws IOException
  {
    int i;
    if (this.c) {
      i = 96;
    } else {
      i = 64;
    }
    paramp.k(i, this.d);
    paramp.c(128);
    paramp.d(this.f);
    paramp.c(0);
    paramp.c(0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
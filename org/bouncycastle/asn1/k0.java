package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

class k0
  extends InputStream
{
  private final v c;
  private boolean d = true;
  private InputStream f;
  
  k0(v paramv)
  {
    this.c = paramv;
  }
  
  public int read()
    throws IOException
  {
    Object localObject;
    if (this.f == null)
    {
      if (!this.d) {
        return -1;
      }
      localObject = (o)this.c.b();
      if (localObject == null) {
        return -1;
      }
      this.d = false;
    }
    for (;;)
    {
      int i = this.f.read();
      if (i >= 0) {
        return i;
      }
      o localo = (o)this.c.b();
      localObject = localo;
      if (localo == null)
      {
        this.f = null;
        return -1;
      }
      this.f = ((o)localObject).a();
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject = this.f;
    int i = 0;
    int j = 0;
    int k = -1;
    if (localObject == null)
    {
      if (!this.d) {
        return -1;
      }
      localObject = (o)this.c.b();
      if (localObject == null) {
        return -1;
      }
      this.d = false;
    }
    o localo;
    do
    {
      this.f = ((o)localObject).a();
      i = j;
      do
      {
        j = this.f.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j < 0) {
          break;
        }
        j = i + j;
        i = j;
      } while (j != paramInt2);
      return j;
      localo = (o)this.c.b();
      localObject = localo;
      j = i;
    } while (localo != null);
    this.f = null;
    if (i < 1) {
      paramInt1 = k;
    } else {
      paramInt1 = i;
    }
    return paramInt1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\k0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
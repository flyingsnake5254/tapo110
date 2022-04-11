package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.io.InputStream;

public final class m
  extends InputStream
{
  private final l c;
  private final n d;
  private final byte[] f;
  private boolean q = false;
  private boolean x = false;
  private long y;
  
  public m(l paraml, n paramn)
  {
    this.c = paraml;
    this.d = paramn;
    this.f = new byte[1];
  }
  
  private void a()
    throws IOException
  {
    if (!this.q)
    {
      this.c.j(this.d);
      this.q = true;
    }
  }
  
  public void c()
    throws IOException
  {
    a();
  }
  
  public void close()
    throws IOException
  {
    if (!this.x)
    {
      this.c.close();
      this.x = true;
    }
  }
  
  public int read()
    throws IOException
  {
    int i = read(this.f);
    int j = -1;
    if (i != -1) {
      j = this.f[0] & 0xFF;
    }
    return j;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    g.g(this.x ^ true);
    a();
    paramInt1 = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == -1) {
      return -1;
    }
    this.y += paramInt1;
    return paramInt1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
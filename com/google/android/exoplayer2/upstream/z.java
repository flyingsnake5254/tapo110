package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class z
  implements l
{
  private final l b;
  private long c;
  private Uri d;
  private Map<String, List<String>> e;
  
  public z(l paraml)
  {
    this.b = ((l)g.e(paraml));
    this.d = Uri.EMPTY;
    this.e = Collections.emptyMap();
  }
  
  public void b(a0 parama0)
  {
    g.e(parama0);
    this.b.b(parama0);
  }
  
  public void close()
    throws IOException
  {
    this.b.close();
  }
  
  public Map<String, List<String>> d()
  {
    return this.b.d();
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.b.getUri();
  }
  
  public long j(n paramn)
    throws IOException
  {
    this.d = paramn.a;
    this.e = Collections.emptyMap();
    long l = this.b.j(paramn);
    this.d = ((Uri)g.e(getUri()));
    this.e = d();
    return l;
  }
  
  public long o()
  {
    return this.c;
  }
  
  public Uri p()
  {
    return this.d;
  }
  
  public Map<String, List<String>> q()
  {
    return this.e;
  }
  
  public void r()
  {
    this.c = 0L;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = this.b.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.c += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
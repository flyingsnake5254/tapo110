package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class t
  implements x
{
  private final int a;
  
  public t()
  {
    this(-1);
  }
  
  public t(int paramInt)
  {
    this.a = paramInt;
  }
  
  public long a(x.c paramc)
  {
    IOException localIOException = paramc.c;
    long l;
    if ((!(localIOException instanceof ParserException)) && (!(localIOException instanceof FileNotFoundException)) && (!(localIOException instanceof HttpDataSource.CleartextNotPermittedException)) && (!(localIOException instanceof Loader.UnexpectedLoaderException))) {
      l = Math.min((paramc.d - 1) * 1000, 5000);
    } else {
      l = -9223372036854775807L;
    }
    return l;
  }
  
  public int b(int paramInt)
  {
    int i = this.a;
    if (i == -1)
    {
      if (paramInt == 7) {
        paramInt = 6;
      } else {
        paramInt = 3;
      }
      return paramInt;
    }
    return i;
  }
  
  @Nullable
  public x.b c(x.a parama, x.c paramc)
  {
    if (!e(paramc.c)) {
      return null;
    }
    if (parama.a(1)) {
      return new x.b(1, 300000L);
    }
    if (parama.a(2)) {
      return new x.b(2, 60000L);
    }
    return null;
  }
  
  protected boolean e(IOException paramIOException)
  {
    boolean bool1 = paramIOException instanceof HttpDataSource.InvalidResponseCodeException;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    int i = ((HttpDataSource.InvalidResponseCodeException)paramIOException).responseCode;
    if ((i == 403) || (i == 404) || (i == 410) || (i == 416) || (i == 500) || (i == 503)) {
      bool2 = true;
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
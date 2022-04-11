package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface l
  extends i
{
  public abstract void b(a0 parama0);
  
  public abstract void close()
    throws IOException;
  
  public abstract Map<String, List<String>> d();
  
  @Nullable
  public abstract Uri getUri();
  
  public abstract long j(n paramn)
    throws IOException;
  
  public static abstract interface a
  {
    public abstract l a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
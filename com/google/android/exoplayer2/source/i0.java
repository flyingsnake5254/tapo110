package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.upstream.i;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface i0
{
  public abstract int a(x paramx)
    throws IOException;
  
  public abstract void b();
  
  public abstract void c(long paramLong1, long paramLong2);
  
  public abstract void d(i parami, Uri paramUri, Map<String, List<String>> paramMap, long paramLong1, long paramLong2, l paraml)
    throws IOException;
  
  public abstract long e();
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract i0 a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\i0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
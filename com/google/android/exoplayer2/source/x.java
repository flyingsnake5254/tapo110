package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.n;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class x
{
  private static final AtomicLong a = new AtomicLong();
  public final long b;
  public final n c;
  public final Uri d;
  public final Map<String, List<String>> e;
  public final long f;
  public final long g;
  public final long h;
  
  public x(long paramLong1, n paramn, long paramLong2)
  {
    this(paramLong1, paramn, paramn.a, Collections.emptyMap(), paramLong2, 0L, 0L);
  }
  
  public x(long paramLong1, n paramn, Uri paramUri, Map<String, List<String>> paramMap, long paramLong2, long paramLong3, long paramLong4)
  {
    this.b = paramLong1;
    this.c = paramn;
    this.d = paramUri;
    this.e = paramMap;
    this.f = paramLong2;
    this.g = paramLong3;
    this.h = paramLong4;
  }
  
  public static long a()
  {
    return a.getAndIncrement();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
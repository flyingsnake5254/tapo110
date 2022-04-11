package com.google.android.exoplayer2.text.s;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class h
  implements f
{
  private final d c;
  private final long[] d;
  private final Map<String, g> f;
  private final Map<String, e> q;
  private final Map<String, String> x;
  
  public h(d paramd, Map<String, g> paramMap, Map<String, e> paramMap1, Map<String, String> paramMap2)
  {
    this.c = paramd;
    this.q = paramMap1;
    this.x = paramMap2;
    if (paramMap != null) {
      paramMap = Collections.unmodifiableMap(paramMap);
    } else {
      paramMap = Collections.emptyMap();
    }
    this.f = paramMap;
    this.d = paramd.j();
  }
  
  public int a(long paramLong)
  {
    int i = o0.d(this.d, paramLong, false, false);
    if (i >= this.d.length) {
      i = -1;
    }
    return i;
  }
  
  public List<c> b(long paramLong)
  {
    return this.c.h(paramLong, this.f, this.q, this.x);
  }
  
  public long c(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public int d()
  {
    return this.d.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\s\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
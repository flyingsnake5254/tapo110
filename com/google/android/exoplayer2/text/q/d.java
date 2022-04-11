package com.google.android.exoplayer2.text.q;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;

final class d
  implements f
{
  private final List<List<c>> c;
  private final List<Long> d;
  
  public d(List<List<c>> paramList, List<Long> paramList1)
  {
    this.c = paramList;
    this.d = paramList1;
  }
  
  public int a(long paramLong)
  {
    int i = o0.c(this.d, Long.valueOf(paramLong), false, false);
    if (i >= this.d.size()) {
      i = -1;
    }
    return i;
  }
  
  public List<c> b(long paramLong)
  {
    int i = o0.f(this.d, Long.valueOf(paramLong), true, false);
    if (i == -1) {
      return Collections.emptyList();
    }
    return (List)this.c.get(i);
  }
  
  public long c(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    if (paramInt < this.d.size()) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    return ((Long)this.d.get(paramInt)).longValue();
  }
  
  public int d()
  {
    return this.d.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\q\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
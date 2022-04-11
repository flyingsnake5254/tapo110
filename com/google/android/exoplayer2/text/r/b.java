package com.google.android.exoplayer2.text.r;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Collections;
import java.util.List;

final class b
  implements f
{
  private final c[] c;
  private final long[] d;
  
  public b(c[] paramArrayOfc, long[] paramArrayOfLong)
  {
    this.c = paramArrayOfc;
    this.d = paramArrayOfLong;
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
    int i = o0.h(this.d, paramLong, true, false);
    if (i != -1)
    {
      c[] arrayOfc = this.c;
      if (arrayOfc[i] != c.a) {
        return Collections.singletonList(arrayOfc[i]);
      }
    }
    return Collections.emptyList();
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
    if (paramInt < this.d.length) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    g.a(bool2);
    return this.d[paramInt];
  }
  
  public int d()
  {
    return this.d.length;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\r\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
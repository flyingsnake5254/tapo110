package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;
import java.util.List;

final class d
  implements f
{
  private final List<c> c;
  
  public d(List<c> paramList)
  {
    this.c = Collections.unmodifiableList(paramList);
  }
  
  public int a(long paramLong)
  {
    int i;
    if (paramLong < 0L) {
      i = 0;
    } else {
      i = -1;
    }
    return i;
  }
  
  public List<c> b(long paramLong)
  {
    List localList;
    if (paramLong >= 0L) {
      localList = this.c;
    } else {
      localList = Collections.emptyList();
    }
    return localList;
  }
  
  public long c(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    return 0L;
  }
  
  public int d()
  {
    return 1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
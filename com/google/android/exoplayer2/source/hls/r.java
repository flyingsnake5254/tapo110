package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.l0;

public final class r
{
  private final SparseArray<l0> a = new SparseArray();
  
  public l0 a(int paramInt)
  {
    l0 locall01 = (l0)this.a.get(paramInt);
    l0 locall02 = locall01;
    if (locall01 == null)
    {
      locall02 = new l0(9223372036854775806L);
      this.a.put(paramInt, locall02);
    }
    return locall02;
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
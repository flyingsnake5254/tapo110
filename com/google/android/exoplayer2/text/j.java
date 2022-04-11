package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.util.g;
import java.util.List;

public abstract class j
  extends com.google.android.exoplayer2.decoder.f
  implements f
{
  @Nullable
  private f q;
  private long x;
  
  public int a(long paramLong)
  {
    return ((f)g.e(this.q)).a(paramLong - this.x);
  }
  
  public List<c> b(long paramLong)
  {
    return ((f)g.e(this.q)).b(paramLong - this.x);
  }
  
  public long c(int paramInt)
  {
    return ((f)g.e(this.q)).c(paramInt) + this.x;
  }
  
  public int d()
  {
    return ((f)g.e(this.q)).d();
  }
  
  public void f()
  {
    super.f();
    this.q = null;
  }
  
  public void o(long paramLong1, f paramf, long paramLong2)
  {
    this.d = paramLong1;
    this.q = paramf;
    if (paramLong2 != Long.MAX_VALUE) {
      paramLong1 = paramLong2;
    }
    this.x = paramLong1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
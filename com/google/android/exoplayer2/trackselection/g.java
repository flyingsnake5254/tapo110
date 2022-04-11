package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.e0.a;
import com.google.android.exoplayer2.source.u0.b;
import com.google.android.exoplayer2.source.u0.d;
import com.google.android.exoplayer2.source.u0.e;
import java.util.List;

public abstract interface g
  extends j
{
  public abstract void b();
  
  public abstract void c();
  
  public abstract int d();
  
  public abstract boolean e(int paramInt, long paramLong);
  
  public abstract boolean f(int paramInt, long paramLong);
  
  public abstract boolean g(long paramLong, b paramb, List<? extends d> paramList);
  
  public abstract void i(float paramFloat);
  
  @Nullable
  public abstract Object j();
  
  public abstract void k();
  
  public abstract void n(boolean paramBoolean);
  
  public abstract int o(long paramLong, List<? extends d> paramList);
  
  public abstract void q(long paramLong1, long paramLong2, long paramLong3, List<? extends d> paramList, e[] paramArrayOfe);
  
  public abstract int r();
  
  public abstract Format s();
  
  public abstract int t();
  
  public abstract void u();
  
  public static final class a
  {
    public final TrackGroup a;
    public final int[] b;
    public final int c;
    
    public a(TrackGroup paramTrackGroup, int... paramVarArgs)
    {
      this(paramTrackGroup, paramVarArgs, 0);
    }
    
    public a(TrackGroup paramTrackGroup, int[] paramArrayOfInt, int paramInt)
    {
      this.a = paramTrackGroup;
      this.b = paramArrayOfInt;
      this.c = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract g[] a(g.a[] paramArrayOfa, com.google.android.exoplayer2.upstream.g paramg, e0.a parama, j2 paramj2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
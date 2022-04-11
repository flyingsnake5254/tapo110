package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.u0.d;
import java.util.List;

public final class h
  extends e
{
  private final int h;
  @Nullable
  private final Object i;
  
  public h(TrackGroup paramTrackGroup, int paramInt1, int paramInt2)
  {
    this(paramTrackGroup, paramInt1, paramInt2, 0, null);
  }
  
  public h(TrackGroup paramTrackGroup, int paramInt1, int paramInt2, int paramInt3, @Nullable Object paramObject)
  {
    super(paramTrackGroup, new int[] { paramInt1 }, paramInt2);
    this.h = paramInt3;
    this.i = paramObject;
  }
  
  public int d()
  {
    return 0;
  }
  
  @Nullable
  public Object j()
  {
    return this.i;
  }
  
  public void q(long paramLong1, long paramLong2, long paramLong3, List<? extends d> paramList, com.google.android.exoplayer2.source.u0.e[] paramArrayOfe) {}
  
  public int t()
  {
    return this.h;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
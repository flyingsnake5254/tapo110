package com.google.android.exoplayer2;

public final class IllegalSeekPositionException
  extends IllegalStateException
{
  public final long positionMs;
  public final j2 timeline;
  public final int windowIndex;
  
  public IllegalSeekPositionException(j2 paramj2, int paramInt, long paramLong)
  {
    this.timeline = paramj2;
    this.windowIndex = paramInt;
    this.positionMs = paramLong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\IllegalSeekPositionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
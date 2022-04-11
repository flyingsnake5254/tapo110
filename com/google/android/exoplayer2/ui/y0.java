package com.google.android.exoplayer2.ui;

import androidx.annotation.Nullable;

public abstract interface y0
{
  public abstract void a(a parama);
  
  public abstract void b(@Nullable long[] paramArrayOfLong, @Nullable boolean[] paramArrayOfBoolean, int paramInt);
  
  public abstract long getPreferredUpdateDelay();
  
  public abstract void setBufferedPosition(long paramLong);
  
  public abstract void setDuration(long paramLong);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setPosition(long paramLong);
  
  public static abstract interface a
  {
    public abstract void b(y0 paramy0, long paramLong);
    
    public abstract void h(y0 paramy0, long paramLong, boolean paramBoolean);
    
    public abstract void i(y0 paramy0, long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\y0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
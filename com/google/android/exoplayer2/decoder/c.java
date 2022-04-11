package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;

public abstract interface c<I, O, E extends DecoderException>
{
  @Nullable
  public abstract O b()
    throws DecoderException;
  
  public abstract void c(I paramI)
    throws DecoderException;
  
  @Nullable
  public abstract I d()
    throws DecoderException;
  
  public abstract void flush();
  
  public abstract String getName();
  
  public abstract void release();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\decoder\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
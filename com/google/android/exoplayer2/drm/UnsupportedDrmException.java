package com.google.android.exoplayer2.drm;

public final class UnsupportedDrmException
  extends Exception
{
  public static final int REASON_INSTANTIATION_ERROR = 2;
  public static final int REASON_UNSUPPORTED_SCHEME = 1;
  public final int reason;
  
  public UnsupportedDrmException(int paramInt)
  {
    this.reason = paramInt;
  }
  
  public UnsupportedDrmException(int paramInt, Exception paramException)
  {
    super(paramException);
    this.reason = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\UnsupportedDrmException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
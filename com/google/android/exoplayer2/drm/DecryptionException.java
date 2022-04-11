package com.google.android.exoplayer2.drm;

public class DecryptionException
  extends Exception
{
  public final int errorCode;
  
  public DecryptionException(int paramInt, String paramString)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\DecryptionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
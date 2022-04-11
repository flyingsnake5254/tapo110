package com.tplink.libmediakit.media.audioprocess;

public class AudioProcessUtils
{
  static
  {
    System.loadLibrary("audio_proc");
  }
  
  public static short[] a(short[] paramArrayOfShort, int paramInt)
  {
    return nativeWatermark(paramArrayOfShort, paramInt);
  }
  
  private static native short[] nativeWatermark(short[] paramArrayOfShort, int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\AudioProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
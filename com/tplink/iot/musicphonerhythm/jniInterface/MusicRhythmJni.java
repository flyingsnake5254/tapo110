package com.tplink.iot.musicphonerhythm.jniInterface;

public class MusicRhythmJni
{
  static
  {
    System.loadLibrary("musicrhythm_process");
  }
  
  public static native float[] getAudioResult(float[] paramArrayOfFloat, int paramInt1, int paramInt2);
  
  public static native int init(int paramInt);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\jniInterface\MusicRhythmJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;

public class AGC<T extends d>
  extends NativeAudioProcessor<T>
{
  public AGC(c paramc)
  {
    super(paramc, 5);
    if (paramc.a == 8000) {
      this.d = 80;
    } else {
      this.d = 160;
    }
    if (paramc.d == null) {
      return;
    }
    throw null;
  }
  
  protected native long nativeConstruct();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\AGC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
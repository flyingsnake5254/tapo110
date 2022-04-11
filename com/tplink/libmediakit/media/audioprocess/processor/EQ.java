package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;

public class EQ<T extends d>
  extends NativeAudioProcessor<T>
{
  public EQ(c paramc)
  {
    super(paramc, 4);
    if (paramc.a == 8000) {
      this.d = 80;
    } else {
      this.d = 160;
    }
  }
  
  protected native long nativeConstruct();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\EQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
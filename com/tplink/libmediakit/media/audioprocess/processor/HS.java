package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import com.tplink.libmediakit.media.audioprocess.f;

public class HS<T extends d>
  extends NativeAudioProcessor<T>
{
  private boolean n = false;
  
  public HS(c paramc)
  {
    super(paramc, 6);
    this.d = 768;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sampleNumPerProcess:");
    localStringBuilder.append(this.d);
    g(localStringBuilder.toString());
    this.n = paramc.c;
    paramc = new StringBuilder();
    paramc.append("isUseAec:");
    paramc.append(this.n);
    g(paramc.toString());
    nativeSetUseAec(this.n, q());
  }
  
  private native void nativeSetUseAec(boolean paramBoolean, long paramLong);
  
  protected native long nativeConstruct();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\HS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
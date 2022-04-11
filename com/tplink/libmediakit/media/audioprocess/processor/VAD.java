package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import com.tplink.libmediakit.media.audioprocess.f;
import java.nio.ByteBuffer;

public class VAD<T extends d>
  extends NativeAudioProcessor<T>
{
  public VAD(c paramc)
  {
    super(paramc, 0);
    this.d = (paramc.a / 1000 * 30);
    paramc = new StringBuilder();
    paramc.append("sampleNumPerProcess:");
    paramc.append(this.d);
    g(paramc.toString());
  }
  
  protected void i(int paramInt, T paramT1, T paramT2)
  {
    super.i(paramInt, paramT1, paramT2);
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    paramT2.a(bool);
    paramT1 = paramT1.f().array();
    System.arraycopy(paramT1, 0, paramT2.f().array(), 0, paramT1.length);
    paramT1 = new StringBuilder();
    paramT1.append("Voice:");
    paramT1.append(paramInt);
    h("voiceDet", paramT1.toString());
  }
  
  protected native long nativeConstruct();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\VAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.libmediakit.media.audioprocess.processor;

import com.tplink.libmediakit.media.audioprocess.NativeAudioProcessor;
import com.tplink.libmediakit.media.audioprocess.c;
import com.tplink.libmediakit.media.audioprocess.d;
import com.tplink.libmediakit.media.audioprocess.f;

public class NS<T extends d>
  extends NativeAudioProcessor<T>
{
  private boolean n;
  
  public NS(c paramc)
  {
    super(paramc, 2);
    this.d = (paramc.a / 1000 * 10);
    paramc = new StringBuilder();
    paramc.append("sampleNumPerProcess:");
    paramc.append(this.d);
    g(paramc.toString());
    nativeSetAecStatus(this.n, q());
  }
  
  private native void nativeNotifyMotorStatus(boolean paramBoolean, long paramLong);
  
  private native void nativeSetAecStatus(boolean paramBoolean, long paramLong);
  
  protected boolean j()
  {
    c localc = this.b;
    boolean bool = false;
    if ((localc.a(0)) || (this.b.a(1))) {
      bool = true;
    }
    if (this.n != bool)
    {
      this.n = bool;
      nativeSetAecStatus(bool, q());
    }
    return super.j();
  }
  
  protected native long nativeConstruct();
  
  public void t(boolean paramBoolean)
  {
    nativeNotifyMotorStatus(paramBoolean, q());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libmediakit\media\audioprocess\processor\NS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
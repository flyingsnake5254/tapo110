package com.tplink.iot.Utils.hls;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.a0;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.drm.d0;

public class b
  extends a0<c>
{
  c d4;
  
  public b(@Nullable Handler paramHandler, @Nullable t paramt, AudioSink paramAudioSink)
  {
    super(paramHandler, paramt, paramAudioSink);
  }
  
  public b(@Nullable Handler paramHandler, @Nullable t paramt, AudioProcessor... paramVarArgs)
  {
    this(paramHandler, paramt, new DefaultAudioSink(null, paramVarArgs));
  }
  
  protected int c0(Format paramFormat)
  {
    int i;
    if ("audio/mpeg".equals(paramFormat.H3)) {
      i = 4;
    } else {
      i = 0;
    }
    return i;
  }
  
  protected c e0(Format paramFormat, d0 paramd0)
    throws Mp3DecoderException
  {
    paramFormat = new c(c.n);
    this.d4 = paramFormat;
    return paramFormat;
  }
  
  protected Format f0(c paramc)
  {
    return new Format.b().e0("audio/raw").H(paramc.x()).f0(paramc.z()).Y(paramc.y()).E();
  }
  
  public String getName()
  {
    return "ExoPlayerAudioRender";
  }
  
  public int s()
    throws ExoPlaybackException
  {
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\hls\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
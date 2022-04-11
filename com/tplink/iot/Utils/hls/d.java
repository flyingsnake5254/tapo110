package com.tplink.iot.Utils.hls;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.c1;
import com.google.android.exoplayer2.mediacodec.s;
import java.util.ArrayList;

public class d
  extends c1
{
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void b(Context paramContext, int paramInt, s params, boolean paramBoolean, AudioSink paramAudioSink, Handler paramHandler, t paramt, ArrayList<b2> paramArrayList)
  {
    super.b(paramContext, paramInt, params, paramBoolean, paramAudioSink, paramHandler, paramt, paramArrayList);
    if (paramInt == 0) {
      return;
    }
    int i = paramArrayList.size();
    if (paramInt == 2) {
      i = 0;
    }
    paramArrayList.add(i, new b(paramHandler, paramt, new AudioProcessor[0]));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\hls\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
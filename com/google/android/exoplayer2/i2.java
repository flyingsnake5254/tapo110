package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

final class i2
{
  private final Context a;
  private final Handler b;
  private final b c;
  private final AudioManager d;
  @Nullable
  private c e;
  private int f;
  private int g;
  private boolean h;
  
  public i2(Context paramContext, Handler paramHandler, b paramb)
  {
    paramContext = paramContext.getApplicationContext();
    this.a = paramContext;
    this.b = paramHandler;
    this.c = paramb;
    paramHandler = (AudioManager)g.i((AudioManager)paramContext.getSystemService("audio"));
    this.d = paramHandler;
    this.f = 3;
    this.g = f(paramHandler, 3);
    this.h = e(paramHandler, this.f);
    paramHandler = new c(null);
    paramb = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
    try
    {
      paramContext.registerReceiver(paramHandler, paramb);
      this.e = paramHandler;
    }
    catch (RuntimeException paramContext)
    {
      u.i("StreamVolumeManager", "Error registering stream volume receiver", paramContext);
    }
  }
  
  private static boolean e(AudioManager paramAudioManager, int paramInt)
  {
    if (o0.a >= 23) {
      return paramAudioManager.isStreamMute(paramInt);
    }
    boolean bool;
    if (f(paramAudioManager, paramInt) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static int f(AudioManager paramAudioManager, int paramInt)
  {
    try
    {
      int i = paramAudioManager.getStreamVolume(paramInt);
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder(60);
      localStringBuilder.append("Could not retrieve stream volume for stream type ");
      localStringBuilder.append(paramInt);
      u.i("StreamVolumeManager", localStringBuilder.toString(), localRuntimeException);
    }
    return paramAudioManager.getStreamMaxVolume(paramInt);
  }
  
  private void i()
  {
    int i = f(this.d, this.f);
    boolean bool = e(this.d, this.f);
    if ((this.g != i) || (this.h != bool))
    {
      this.g = i;
      this.h = bool;
      this.c.x(i, bool);
    }
  }
  
  public int c()
  {
    return this.d.getStreamMaxVolume(this.f);
  }
  
  public int d()
  {
    int i;
    if (o0.a >= 28) {
      i = this.d.getStreamMinVolume(this.f);
    } else {
      i = 0;
    }
    return i;
  }
  
  public void g()
  {
    c localc = this.e;
    if (localc != null)
    {
      try
      {
        this.a.unregisterReceiver(localc);
      }
      catch (RuntimeException localRuntimeException)
      {
        u.i("StreamVolumeManager", "Error unregistering stream volume receiver", localRuntimeException);
      }
      this.e = null;
    }
  }
  
  public void h(int paramInt)
  {
    if (this.f == paramInt) {
      return;
    }
    this.f = paramInt;
    i();
    this.c.l(paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void l(int paramInt);
    
    public abstract void x(int paramInt, boolean paramBoolean);
  }
  
  private final class c
    extends BroadcastReceiver
  {
    private c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      i2.a(i2.this).post(new l0(i2.this));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\i2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class r0
{
  private final Context a;
  private final a b;
  private boolean c;
  
  public r0(Context paramContext, Handler paramHandler, b paramb)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new a(paramHandler, paramb);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.c))
    {
      this.a.registerReceiver(this.b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
      this.c = true;
    }
    else if ((!paramBoolean) && (this.c))
    {
      this.a.unregisterReceiver(this.b);
      this.c = false;
    }
  }
  
  private final class a
    extends BroadcastReceiver
    implements Runnable
  {
    private final r0.b c;
    private final Handler d;
    
    public a(Handler paramHandler, r0.b paramb)
    {
      this.d = paramHandler;
      this.c = paramb;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction())) {
        this.d.post(this);
      }
    }
    
    public void run()
    {
      if (r0.a(r0.this)) {
        this.c.m();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void m();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
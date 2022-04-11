package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.u;

final class k2
{
  @Nullable
  private final PowerManager a;
  @Nullable
  private PowerManager.WakeLock b;
  private boolean c;
  private boolean d;
  
  public k2(Context paramContext)
  {
    this.a = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
  }
  
  @SuppressLint({"WakelockTimeout"})
  private void c()
  {
    PowerManager.WakeLock localWakeLock = this.b;
    if (localWakeLock == null) {
      return;
    }
    if ((this.c) && (this.d)) {
      localWakeLock.acquire();
    } else {
      localWakeLock.release();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.b == null))
    {
      Object localObject = this.a;
      if (localObject == null)
      {
        u.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
        return;
      }
      localObject = ((PowerManager)localObject).newWakeLock(1, "ExoPlayer:WakeLockManager");
      this.b = ((PowerManager.WakeLock)localObject);
      ((PowerManager.WakeLock)localObject).setReferenceCounted(false);
    }
    this.c = paramBoolean;
    c();
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\k2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
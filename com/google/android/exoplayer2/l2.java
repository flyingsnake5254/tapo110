package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.u;

final class l2
{
  @Nullable
  private final WifiManager a;
  @Nullable
  private WifiManager.WifiLock b;
  private boolean c;
  private boolean d;
  
  public l2(Context paramContext)
  {
    this.a = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi"));
  }
  
  private void c()
  {
    WifiManager.WifiLock localWifiLock = this.b;
    if (localWifiLock == null) {
      return;
    }
    if ((this.c) && (this.d)) {
      localWifiLock.acquire();
    } else {
      localWifiLock.release();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.b == null))
    {
      Object localObject = this.a;
      if (localObject == null)
      {
        u.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
        return;
      }
      localObject = ((WifiManager)localObject).createWifiLock(3, "ExoPlayer:WifiLockManager");
      this.b = ((WifiManager.WifiLock)localObject);
      ((WifiManager.WifiLock)localObject).setReferenceCounted(false);
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\l2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
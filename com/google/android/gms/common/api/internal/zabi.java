package com.google.android.gms.common.api.internal;

import android.os.Handler;

final class zabi
  implements BackgroundDetector.BackgroundStateChangeListener
{
  zabi(GoogleApiManager paramGoogleApiManager) {}
  
  public final void onBackgroundStateChanged(boolean paramBoolean)
  {
    GoogleApiManager.zaa(this.zaim).sendMessage(GoogleApiManager.zaa(this.zaim).obtainMessage(1, Boolean.valueOf(paramBoolean)));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zabi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
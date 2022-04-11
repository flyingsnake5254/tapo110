package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class zac
  extends DialogRedirect
{
  zac(Intent paramIntent, Activity paramActivity, int paramInt) {}
  
  public final void redirect()
  {
    Intent localIntent = this.zaoh;
    if (localIntent != null) {
      this.val$activity.startActivityForResult(localIntent, this.val$requestCode);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
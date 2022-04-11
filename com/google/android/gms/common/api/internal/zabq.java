package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zabq
  extends BroadcastReceiver
{
  private Context mContext;
  private final zabr zaji;
  
  public zabq(zabr paramzabr)
  {
    this.zaji = paramzabr;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getData();
    if (paramContext != null) {
      paramContext = paramContext.getSchemeSpecificPart();
    } else {
      paramContext = null;
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      this.zaji.zas();
      unregister();
    }
  }
  
  public final void unregister()
  {
    try
    {
      Context localContext = this.mContext;
      if (localContext != null) {
        localContext.unregisterReceiver(this);
      }
      this.mContext = null;
      return;
    }
    finally {}
  }
  
  public final void zac(Context paramContext)
  {
    this.mContext = paramContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zabq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
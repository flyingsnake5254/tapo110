package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

final class zabg
  extends zap
{
  zabg(zabe paramzabe, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        paramMessage = new StringBuilder(31);
        paramMessage.append("Unknown message id: ");
        paramMessage.append(i);
        Log.w("GACStateManager", paramMessage.toString());
        return;
      }
      throw ((RuntimeException)paramMessage.obj);
    }
    ((zabf)paramMessage.obj).zac(this.zahv);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zabg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import java.util.Map;

final class zaac
  implements PendingResult.StatusListener
{
  zaac(zaab paramzaab, BasePendingResult paramBasePendingResult) {}
  
  public final void onComplete(Status paramStatus)
  {
    zaab.zaa(this.zafn).remove(this.zafm);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
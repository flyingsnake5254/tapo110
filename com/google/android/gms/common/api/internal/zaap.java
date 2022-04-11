package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import javax.annotation.concurrent.GuardedBy;

final class zaap
  extends zabf
{
  zaap(zaan paramzaan, zabd paramzabd, BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    super(paramzabd);
  }
  
  @GuardedBy("mLock")
  public final void zaan()
  {
    this.zago.onReportServiceBinding(new ConnectionResult(16, null));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
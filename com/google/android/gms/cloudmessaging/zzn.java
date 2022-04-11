package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzn
  extends zzq<Void>
{
  zzn(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 2, paramBundle);
  }
  
  final void zza(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ack", false))
    {
      zza(null);
      return;
    }
    zza(new zzp(4, "Invalid response to one way request"));
  }
  
  final boolean zza()
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
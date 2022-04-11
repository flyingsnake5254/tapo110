package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzs
  extends zzq<Bundle>
{
  zzs(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super(paramInt1, 1, paramBundle);
  }
  
  final void zza(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle.getBundle("data");
    paramBundle = localBundle;
    if (localBundle == null) {
      paramBundle = Bundle.EMPTY;
    }
    zza(paramBundle);
  }
  
  final boolean zza()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
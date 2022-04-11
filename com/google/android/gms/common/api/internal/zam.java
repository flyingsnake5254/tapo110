package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

final class zam
{
  private final int zadh;
  private final ConnectionResult zadi;
  
  zam(ConnectionResult paramConnectionResult, int paramInt)
  {
    Preconditions.checkNotNull(paramConnectionResult);
    this.zadi = paramConnectionResult;
    this.zadh = paramInt;
  }
  
  final ConnectionResult getConnectionResult()
  {
    return this.zadi;
  }
  
  final int zar()
  {
    return this.zadh;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
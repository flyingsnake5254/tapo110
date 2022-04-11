package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException
  extends UserRecoverableException
{
  private final int zzag;
  
  public GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.zzag = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.zzag;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\GooglePlayServicesRepairableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
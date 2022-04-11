package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ApiException
  extends Exception
{
  protected final Status mStatus;
  
  public ApiException(@NonNull Status paramStatus)
  {
    super(localStringBuilder.toString());
    this.mStatus = paramStatus;
  }
  
  public int getStatusCode()
  {
    return this.mStatus.getStatusCode();
  }
  
  @Deprecated
  @Nullable
  public String getStatusMessage()
  {
    return this.mStatus.getStatusMessage();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\ApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
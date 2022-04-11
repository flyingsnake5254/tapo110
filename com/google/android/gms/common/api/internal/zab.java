package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.PlatformVersion;

public abstract class zab
{
  private final int type;
  
  public zab(int paramInt)
  {
    this.type = paramInt;
  }
  
  private static Status zaa(RemoteException paramRemoteException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((PlatformVersion.isAtLeastIceCreamSandwichMR1()) && ((paramRemoteException instanceof TransactionTooLargeException))) {
      localStringBuilder.append("TransactionTooLargeException: ");
    }
    localStringBuilder.append(paramRemoteException.getLocalizedMessage());
    return new Status(8, localStringBuilder.toString());
  }
  
  public abstract void zaa(@NonNull Status paramStatus);
  
  public abstract void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException;
  
  public abstract void zaa(@NonNull zaab paramzaab, boolean paramBoolean);
  
  public abstract void zaa(@NonNull RuntimeException paramRuntimeException);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
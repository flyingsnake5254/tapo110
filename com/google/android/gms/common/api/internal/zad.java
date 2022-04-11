package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T>
  extends zac
{
  protected final TaskCompletionSource<T> zacn;
  
  public zad(int paramInt, TaskCompletionSource<T> paramTaskCompletionSource)
  {
    super(paramInt);
    this.zacn = paramTaskCompletionSource;
  }
  
  public void zaa(@NonNull Status paramStatus)
  {
    this.zacn.trySetException(new ApiException(paramStatus));
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException
  {
    try
    {
      zad(paramzaa);
      return;
    }
    catch (RuntimeException paramzaa)
    {
      zaa(paramzaa);
      return;
    }
    catch (RemoteException paramzaa)
    {
      zaa(zab.zab(paramzaa));
      return;
    }
    catch (DeadObjectException paramzaa)
    {
      zaa(zab.zab(paramzaa));
      throw paramzaa;
    }
  }
  
  public void zaa(@NonNull zaab paramzaab, boolean paramBoolean) {}
  
  public void zaa(@NonNull RuntimeException paramRuntimeException)
  {
    this.zacn.trySetException(paramRuntimeException);
  }
  
  protected abstract void zad(GoogleApiManager.zaa<?> paramzaa)
    throws RemoteException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>>
  extends zab
{
  private final A zaco;
  
  public zae(int paramInt, A paramA)
  {
    super(paramInt);
    this.zaco = paramA;
  }
  
  public final void zaa(@NonNull Status paramStatus)
  {
    this.zaco.setFailedResult(paramStatus);
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException
  {
    try
    {
      this.zaco.run(paramzaa.zaab());
      return;
    }
    catch (RuntimeException paramzaa)
    {
      zaa(paramzaa);
    }
  }
  
  public final void zaa(@NonNull zaab paramzaab, boolean paramBoolean)
  {
    paramzaab.zaa(this.zaco, paramBoolean);
  }
  
  public final void zaa(@NonNull RuntimeException paramRuntimeException)
  {
    String str1 = paramRuntimeException.getClass().getSimpleName();
    String str2 = paramRuntimeException.getLocalizedMessage();
    paramRuntimeException = new StringBuilder(str1.length() + 2 + String.valueOf(str2).length());
    paramRuntimeException.append(str1);
    paramRuntimeException.append(": ");
    paramRuntimeException.append(str2);
    paramRuntimeException = new Status(10, paramRuntimeException.toString());
    this.zaco.setFailedResult(paramRuntimeException);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
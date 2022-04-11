package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zaf
  extends zaa
{
  private final BaseImplementation.ResultHolder<Status> mResultHolder;
  
  public zaf(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.mResultHolder = paramResultHolder;
  }
  
  public final void zaj(int paramInt)
    throws RemoteException
  {
    this.mResultHolder.setResult(new Status(paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\service\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
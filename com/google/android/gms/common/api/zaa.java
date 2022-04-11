package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

final class zaa
  implements PendingResult.StatusListener
{
  zaa(Batch paramBatch) {}
  
  public final void onComplete(Status paramStatus)
  {
    synchronized (Batch.zaa(this.zabd))
    {
      if (this.zabd.isCanceled()) {
        return;
      }
      if (paramStatus.isCanceled()) {
        Batch.zaa(this.zabd, true);
      } else if (!paramStatus.isSuccess()) {
        Batch.zab(this.zabd, true);
      }
      Batch.zab(this.zabd);
      if (Batch.zac(this.zabd) == 0) {
        if (Batch.zad(this.zabd))
        {
          Batch.zae(this.zabd);
        }
        else
        {
          if (Batch.zaf(this.zabd))
          {
            paramStatus = new com/google/android/gms/common/api/Status;
            paramStatus.<init>(13);
          }
          else
          {
            paramStatus = Status.RESULT_SUCCESS;
          }
          Batch localBatch = this.zabd;
          BatchResult localBatchResult = new com/google/android/gms/common/api/BatchResult;
          localBatchResult.<init>(paramStatus, Batch.zag(localBatch));
          localBatch.setResult(localBatchResult);
        }
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
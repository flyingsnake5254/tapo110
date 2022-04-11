package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends BasePendingResult<BatchResult>
{
  private final Object mLock = new Object();
  private int zaaz;
  private boolean zaba;
  private boolean zabb;
  private final PendingResult<?>[] zabc;
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    int i = paramList.size();
    this.zaaz = i;
    paramGoogleApiClient = new PendingResult[i];
    this.zabc = paramGoogleApiClient;
    if (paramList.isEmpty())
    {
      setResult(new BatchResult(Status.RESULT_SUCCESS, paramGoogleApiClient));
      return;
    }
    for (i = 0; i < paramList.size(); i++)
    {
      paramGoogleApiClient = (PendingResult)paramList.get(i);
      this.zabc[i] = paramGoogleApiClient;
      paramGoogleApiClient.addStatusListener(new zaa(this));
    }
  }
  
  public final void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zabc;
    int i = arrayOfPendingResult.length;
    for (int j = 0; j < i; j++) {
      arrayOfPendingResult[j].cancel();
    }
  }
  
  public final BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.zabc);
  }
  
  public static final class Builder
  {
    private List<PendingResult<?>> zabe = new ArrayList();
    private GoogleApiClient zabf;
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.zabf = paramGoogleApiClient;
    }
    
    public final <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.zabe.size());
      this.zabe.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public final Batch build()
    {
      return new Batch(this.zabe, this.zabf, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
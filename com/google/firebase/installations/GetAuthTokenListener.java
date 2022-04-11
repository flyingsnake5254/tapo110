package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class GetAuthTokenListener
  implements StateListener
{
  private final TaskCompletionSource<InstallationTokenResult> resultTaskCompletionSource;
  private final Utils utils;
  
  public GetAuthTokenListener(Utils paramUtils, TaskCompletionSource<InstallationTokenResult> paramTaskCompletionSource)
  {
    this.utils = paramUtils;
    this.resultTaskCompletionSource = paramTaskCompletionSource;
  }
  
  public boolean onException(Exception paramException)
  {
    this.resultTaskCompletionSource.trySetException(paramException);
    return true;
  }
  
  public boolean onStateReached(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    if ((paramPersistedInstallationEntry.isRegistered()) && (!this.utils.isAuthTokenExpired(paramPersistedInstallationEntry)))
    {
      this.resultTaskCompletionSource.setResult(InstallationTokenResult.builder().setToken(paramPersistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(paramPersistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(paramPersistedInstallationEntry.getTokenCreationEpochInSecs()).build());
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\GetAuthTokenListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
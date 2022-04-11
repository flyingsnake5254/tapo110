package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class GetIdListener
  implements StateListener
{
  final TaskCompletionSource<String> taskCompletionSource;
  
  public GetIdListener(TaskCompletionSource<String> paramTaskCompletionSource)
  {
    this.taskCompletionSource = paramTaskCompletionSource;
  }
  
  public boolean onException(Exception paramException)
  {
    return false;
  }
  
  public boolean onStateReached(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    if ((!paramPersistedInstallationEntry.isUnregistered()) && (!paramPersistedInstallationEntry.isRegistered()) && (!paramPersistedInstallationEntry.isErrored())) {
      return false;
    }
    this.taskCompletionSource.trySetResult(paramPersistedInstallationEntry.getFirebaseInstallationId());
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\GetIdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
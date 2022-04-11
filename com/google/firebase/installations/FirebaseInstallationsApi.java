package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

public abstract interface FirebaseInstallationsApi
{
  @NonNull
  public abstract Task<Void> delete();
  
  @NonNull
  public abstract Task<String> getId();
  
  @NonNull
  public abstract Task<InstallationTokenResult> getToken(boolean paramBoolean);
  
  @DeferredApi
  public abstract FidListenerHandle registerFidListener(@NonNull FidListener paramFidListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\FirebaseInstallationsApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
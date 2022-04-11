package com.google.firebase.iid.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

@KeepForSdk
public abstract interface FirebaseInstanceIdInternal
{
  @KeepForSdk
  public abstract void addNewTokenListener(NewTokenListener paramNewTokenListener);
  
  @KeepForSdk
  public abstract void deleteToken(@NonNull String paramString1, @NonNull String paramString2)
    throws IOException;
  
  @KeepForSdk
  public abstract String getId();
  
  @Nullable
  @KeepForSdk
  public abstract String getToken();
  
  @NonNull
  @KeepForSdk
  public abstract Task<String> getTokenTask();
  
  @KeepForSdk
  public static abstract interface NewTokenListener
  {
    @KeepForSdk
    public abstract void onNewToken(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\iid\internal\FirebaseInstanceIdInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
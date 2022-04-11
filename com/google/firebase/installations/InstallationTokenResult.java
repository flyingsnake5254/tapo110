package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class InstallationTokenResult
{
  @NonNull
  public static Builder builder()
  {
    return new AutoValue_InstallationTokenResult.Builder();
  }
  
  @NonNull
  public abstract String getToken();
  
  @NonNull
  public abstract long getTokenCreationTimestamp();
  
  @NonNull
  public abstract long getTokenExpirationTimestamp();
  
  @NonNull
  public abstract Builder toBuilder();
  
  @AutoValue.Builder
  public static abstract class Builder
  {
    @NonNull
    public abstract InstallationTokenResult build();
    
    @NonNull
    public abstract Builder setToken(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setTokenCreationTimestamp(long paramLong);
    
    @NonNull
    public abstract Builder setTokenExpirationTimestamp(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\InstallationTokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
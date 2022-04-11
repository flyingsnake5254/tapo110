package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class InstallationResponse
{
  @NonNull
  public static Builder builder()
  {
    return new AutoValue_InstallationResponse.Builder();
  }
  
  @Nullable
  public abstract TokenResult getAuthToken();
  
  @Nullable
  public abstract String getFid();
  
  @Nullable
  public abstract String getRefreshToken();
  
  @Nullable
  public abstract ResponseCode getResponseCode();
  
  @Nullable
  public abstract String getUri();
  
  @NonNull
  public abstract Builder toBuilder();
  
  @AutoValue.Builder
  public static abstract class Builder
  {
    @NonNull
    public abstract InstallationResponse build();
    
    @NonNull
    public abstract Builder setAuthToken(@NonNull TokenResult paramTokenResult);
    
    @NonNull
    public abstract Builder setFid(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setRefreshToken(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setResponseCode(@NonNull InstallationResponse.ResponseCode paramResponseCode);
    
    @NonNull
    public abstract Builder setUri(@NonNull String paramString);
  }
  
  public static enum ResponseCode
  {
    static
    {
      ResponseCode localResponseCode1 = new ResponseCode("OK", 0);
      OK = localResponseCode1;
      ResponseCode localResponseCode2 = new ResponseCode("BAD_CONFIG", 1);
      BAD_CONFIG = localResponseCode2;
      $VALUES = new ResponseCode[] { localResponseCode1, localResponseCode2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\remote\InstallationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
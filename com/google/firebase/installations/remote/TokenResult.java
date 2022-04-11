package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class TokenResult
{
  @NonNull
  public static Builder builder()
  {
    return new AutoValue_TokenResult.Builder().setTokenExpirationTimestamp(0L);
  }
  
  @Nullable
  public abstract ResponseCode getResponseCode();
  
  @Nullable
  public abstract String getToken();
  
  @NonNull
  public abstract long getTokenExpirationTimestamp();
  
  @NonNull
  public abstract Builder toBuilder();
  
  @AutoValue.Builder
  public static abstract class Builder
  {
    @NonNull
    public abstract TokenResult build();
    
    @NonNull
    public abstract Builder setResponseCode(@NonNull TokenResult.ResponseCode paramResponseCode);
    
    @NonNull
    public abstract Builder setToken(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setTokenExpirationTimestamp(long paramLong);
  }
  
  public static enum ResponseCode
  {
    static
    {
      ResponseCode localResponseCode1 = new ResponseCode("OK", 0);
      OK = localResponseCode1;
      ResponseCode localResponseCode2 = new ResponseCode("BAD_CONFIG", 1);
      BAD_CONFIG = localResponseCode2;
      ResponseCode localResponseCode3 = new ResponseCode("AUTH_ERROR", 2);
      AUTH_ERROR = localResponseCode3;
      $VALUES = new ResponseCode[] { localResponseCode1, localResponseCode2, localResponseCode3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\remote\TokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
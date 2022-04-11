package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class PersistedInstallationEntry
{
  @NonNull
  public static PersistedInstallationEntry INSTANCE = builder().build();
  
  @NonNull
  public static Builder builder()
  {
    return new AutoValue_PersistedInstallationEntry.Builder().setTokenCreationEpochInSecs(0L).setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).setExpiresInSecs(0L);
  }
  
  @Nullable
  public abstract String getAuthToken();
  
  public abstract long getExpiresInSecs();
  
  @Nullable
  public abstract String getFirebaseInstallationId();
  
  @Nullable
  public abstract String getFisError();
  
  @Nullable
  public abstract String getRefreshToken();
  
  @NonNull
  public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();
  
  public abstract long getTokenCreationEpochInSecs();
  
  public boolean isErrored()
  {
    boolean bool;
    if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isNotGenerated()
  {
    boolean bool;
    if ((getRegistrationStatus() != PersistedInstallation.RegistrationStatus.NOT_GENERATED) && (getRegistrationStatus() != PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRegistered()
  {
    boolean bool;
    if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isUnregistered()
  {
    boolean bool;
    if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean shouldAttemptMigration()
  {
    boolean bool;
    if (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @NonNull
  public abstract Builder toBuilder();
  
  @NonNull
  public PersistedInstallationEntry withAuthToken(@NonNull String paramString, long paramLong1, long paramLong2)
  {
    return toBuilder().setAuthToken(paramString).setExpiresInSecs(paramLong1).setTokenCreationEpochInSecs(paramLong2).build();
  }
  
  @NonNull
  public PersistedInstallationEntry withClearedAuthToken()
  {
    return toBuilder().setAuthToken(null).build();
  }
  
  @NonNull
  public PersistedInstallationEntry withFisError(@NonNull String paramString)
  {
    return toBuilder().setFisError(paramString).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
  }
  
  @NonNull
  public PersistedInstallationEntry withNoGeneratedFid()
  {
    return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
  }
  
  @NonNull
  public PersistedInstallationEntry withRegisteredFid(@NonNull String paramString1, @NonNull String paramString2, long paramLong1, @Nullable String paramString3, long paramLong2)
  {
    return toBuilder().setFirebaseInstallationId(paramString1).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(paramString3).setRefreshToken(paramString2).setExpiresInSecs(paramLong2).setTokenCreationEpochInSecs(paramLong1).build();
  }
  
  @NonNull
  public PersistedInstallationEntry withUnregisteredFid(@NonNull String paramString)
  {
    return toBuilder().setFirebaseInstallationId(paramString).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
  }
  
  @AutoValue.Builder
  public static abstract class Builder
  {
    @NonNull
    public abstract PersistedInstallationEntry build();
    
    @NonNull
    public abstract Builder setAuthToken(@Nullable String paramString);
    
    @NonNull
    public abstract Builder setExpiresInSecs(long paramLong);
    
    @NonNull
    public abstract Builder setFirebaseInstallationId(@NonNull String paramString);
    
    @NonNull
    public abstract Builder setFisError(@Nullable String paramString);
    
    @NonNull
    public abstract Builder setRefreshToken(@Nullable String paramString);
    
    @NonNull
    public abstract Builder setRegistrationStatus(@NonNull PersistedInstallation.RegistrationStatus paramRegistrationStatus);
    
    @NonNull
    public abstract Builder setTokenCreationEpochInSecs(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\local\PersistedInstallationEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

final class AutoValue_PersistedInstallationEntry
  extends PersistedInstallationEntry
{
  private final String authToken;
  private final long expiresInSecs;
  private final String firebaseInstallationId;
  private final String fisError;
  private final String refreshToken;
  private final PersistedInstallation.RegistrationStatus registrationStatus;
  private final long tokenCreationEpochInSecs;
  
  private AutoValue_PersistedInstallationEntry(@Nullable String paramString1, PersistedInstallation.RegistrationStatus paramRegistrationStatus, @Nullable String paramString2, @Nullable String paramString3, long paramLong1, long paramLong2, @Nullable String paramString4)
  {
    this.firebaseInstallationId = paramString1;
    this.registrationStatus = paramRegistrationStatus;
    this.authToken = paramString2;
    this.refreshToken = paramString3;
    this.expiresInSecs = paramLong1;
    this.tokenCreationEpochInSecs = paramLong2;
    this.fisError = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof PersistedInstallationEntry))
    {
      paramObject = (PersistedInstallationEntry)paramObject;
      String str = this.firebaseInstallationId;
      if ((str == null ? ((PersistedInstallationEntry)paramObject).getFirebaseInstallationId() == null : str.equals(((PersistedInstallationEntry)paramObject).getFirebaseInstallationId())) && (this.registrationStatus.equals(((PersistedInstallationEntry)paramObject).getRegistrationStatus())))
      {
        str = this.authToken;
        if (str == null ? ((PersistedInstallationEntry)paramObject).getAuthToken() == null : str.equals(((PersistedInstallationEntry)paramObject).getAuthToken()))
        {
          str = this.refreshToken;
          if ((str == null ? ((PersistedInstallationEntry)paramObject).getRefreshToken() == null : str.equals(((PersistedInstallationEntry)paramObject).getRefreshToken())) && (this.expiresInSecs == ((PersistedInstallationEntry)paramObject).getExpiresInSecs()) && (this.tokenCreationEpochInSecs == ((PersistedInstallationEntry)paramObject).getTokenCreationEpochInSecs()))
          {
            str = this.fisError;
            if (str == null ? ((PersistedInstallationEntry)paramObject).getFisError() == null : str.equals(((PersistedInstallationEntry)paramObject).getFisError())) {
              break label184;
            }
          }
        }
      }
      bool = false;
      label184:
      return bool;
    }
    return false;
  }
  
  @Nullable
  public String getAuthToken()
  {
    return this.authToken;
  }
  
  public long getExpiresInSecs()
  {
    return this.expiresInSecs;
  }
  
  @Nullable
  public String getFirebaseInstallationId()
  {
    return this.firebaseInstallationId;
  }
  
  @Nullable
  public String getFisError()
  {
    return this.fisError;
  }
  
  @Nullable
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  @NonNull
  public PersistedInstallation.RegistrationStatus getRegistrationStatus()
  {
    return this.registrationStatus;
  }
  
  public long getTokenCreationEpochInSecs()
  {
    return this.tokenCreationEpochInSecs;
  }
  
  public int hashCode()
  {
    String str = this.firebaseInstallationId;
    int i = 0;
    int j;
    if (str == null) {
      j = 0;
    } else {
      j = str.hashCode();
    }
    int k = this.registrationStatus.hashCode();
    str = this.authToken;
    int m;
    if (str == null) {
      m = 0;
    } else {
      m = str.hashCode();
    }
    str = this.refreshToken;
    int n;
    if (str == null) {
      n = 0;
    } else {
      n = str.hashCode();
    }
    long l = this.expiresInSecs;
    int i1 = (int)(l ^ l >>> 32);
    l = this.tokenCreationEpochInSecs;
    int i2 = (int)(l ^ l >>> 32);
    str = this.fisError;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ i;
  }
  
  public PersistedInstallationEntry.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PersistedInstallationEntry{firebaseInstallationId=");
    localStringBuilder.append(this.firebaseInstallationId);
    localStringBuilder.append(", registrationStatus=");
    localStringBuilder.append(this.registrationStatus);
    localStringBuilder.append(", authToken=");
    localStringBuilder.append(this.authToken);
    localStringBuilder.append(", refreshToken=");
    localStringBuilder.append(this.refreshToken);
    localStringBuilder.append(", expiresInSecs=");
    localStringBuilder.append(this.expiresInSecs);
    localStringBuilder.append(", tokenCreationEpochInSecs=");
    localStringBuilder.append(this.tokenCreationEpochInSecs);
    localStringBuilder.append(", fisError=");
    localStringBuilder.append(this.fisError);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends PersistedInstallationEntry.Builder
  {
    private String authToken;
    private Long expiresInSecs;
    private String firebaseInstallationId;
    private String fisError;
    private String refreshToken;
    private PersistedInstallation.RegistrationStatus registrationStatus;
    private Long tokenCreationEpochInSecs;
    
    Builder() {}
    
    private Builder(PersistedInstallationEntry paramPersistedInstallationEntry)
    {
      this.firebaseInstallationId = paramPersistedInstallationEntry.getFirebaseInstallationId();
      this.registrationStatus = paramPersistedInstallationEntry.getRegistrationStatus();
      this.authToken = paramPersistedInstallationEntry.getAuthToken();
      this.refreshToken = paramPersistedInstallationEntry.getRefreshToken();
      this.expiresInSecs = Long.valueOf(paramPersistedInstallationEntry.getExpiresInSecs());
      this.tokenCreationEpochInSecs = Long.valueOf(paramPersistedInstallationEntry.getTokenCreationEpochInSecs());
      this.fisError = paramPersistedInstallationEntry.getFisError();
    }
    
    public PersistedInstallationEntry build()
    {
      Object localObject1 = this.registrationStatus;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" registrationStatus");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = localObject2;
      if (this.expiresInSecs == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" expiresInSecs");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.tokenCreationEpochInSecs == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" tokenCreationEpochInSecs");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_PersistedInstallationEntry(this.firebaseInstallationId, this.registrationStatus, this.authToken, this.refreshToken, this.expiresInSecs.longValue(), this.tokenCreationEpochInSecs.longValue(), this.fisError, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public PersistedInstallationEntry.Builder setAuthToken(@Nullable String paramString)
    {
      this.authToken = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setExpiresInSecs(long paramLong)
    {
      this.expiresInSecs = Long.valueOf(paramLong);
      return this;
    }
    
    public PersistedInstallationEntry.Builder setFirebaseInstallationId(String paramString)
    {
      this.firebaseInstallationId = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setFisError(@Nullable String paramString)
    {
      this.fisError = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setRefreshToken(@Nullable String paramString)
    {
      this.refreshToken = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus paramRegistrationStatus)
    {
      Objects.requireNonNull(paramRegistrationStatus, "Null registrationStatus");
      this.registrationStatus = paramRegistrationStatus;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long paramLong)
    {
      this.tokenCreationEpochInSecs = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\local\AutoValue_PersistedInstallationEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
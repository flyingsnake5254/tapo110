package com.google.firebase.installations;

import androidx.annotation.NonNull;
import java.util.Objects;

final class AutoValue_InstallationTokenResult
  extends InstallationTokenResult
{
  private final String token;
  private final long tokenCreationTimestamp;
  private final long tokenExpirationTimestamp;
  
  private AutoValue_InstallationTokenResult(String paramString, long paramLong1, long paramLong2)
  {
    this.token = paramString;
    this.tokenExpirationTimestamp = paramLong1;
    this.tokenCreationTimestamp = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof InstallationTokenResult))
    {
      paramObject = (InstallationTokenResult)paramObject;
      if ((!this.token.equals(((InstallationTokenResult)paramObject).getToken())) || (this.tokenExpirationTimestamp != ((InstallationTokenResult)paramObject).getTokenExpirationTimestamp()) || (this.tokenCreationTimestamp != ((InstallationTokenResult)paramObject).getTokenCreationTimestamp())) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public String getToken()
  {
    return this.token;
  }
  
  @NonNull
  public long getTokenCreationTimestamp()
  {
    return this.tokenCreationTimestamp;
  }
  
  @NonNull
  public long getTokenExpirationTimestamp()
  {
    return this.tokenExpirationTimestamp;
  }
  
  public int hashCode()
  {
    int i = this.token.hashCode();
    long l = this.tokenExpirationTimestamp;
    int j = (int)(l ^ l >>> 32);
    l = this.tokenCreationTimestamp;
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public InstallationTokenResult.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InstallationTokenResult{token=");
    localStringBuilder.append(this.token);
    localStringBuilder.append(", tokenExpirationTimestamp=");
    localStringBuilder.append(this.tokenExpirationTimestamp);
    localStringBuilder.append(", tokenCreationTimestamp=");
    localStringBuilder.append(this.tokenCreationTimestamp);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends InstallationTokenResult.Builder
  {
    private String token;
    private Long tokenCreationTimestamp;
    private Long tokenExpirationTimestamp;
    
    Builder() {}
    
    private Builder(InstallationTokenResult paramInstallationTokenResult)
    {
      this.token = paramInstallationTokenResult.getToken();
      this.tokenExpirationTimestamp = Long.valueOf(paramInstallationTokenResult.getTokenExpirationTimestamp());
      this.tokenCreationTimestamp = Long.valueOf(paramInstallationTokenResult.getTokenCreationTimestamp());
    }
    
    public InstallationTokenResult build()
    {
      Object localObject1 = this.token;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" token");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.tokenExpirationTimestamp == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" tokenExpirationTimestamp");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.tokenCreationTimestamp == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" tokenCreationTimestamp");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_InstallationTokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.tokenCreationTimestamp.longValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public InstallationTokenResult.Builder setToken(String paramString)
    {
      Objects.requireNonNull(paramString, "Null token");
      this.token = paramString;
      return this;
    }
    
    public InstallationTokenResult.Builder setTokenCreationTimestamp(long paramLong)
    {
      this.tokenCreationTimestamp = Long.valueOf(paramLong);
      return this;
    }
    
    public InstallationTokenResult.Builder setTokenExpirationTimestamp(long paramLong)
    {
      this.tokenExpirationTimestamp = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\AutoValue_InstallationTokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
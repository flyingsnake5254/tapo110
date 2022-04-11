package com.google.firebase.installations.remote;

import androidx.annotation.Nullable;

final class AutoValue_InstallationResponse
  extends InstallationResponse
{
  private final TokenResult authToken;
  private final String fid;
  private final String refreshToken;
  private final InstallationResponse.ResponseCode responseCode;
  private final String uri;
  
  private AutoValue_InstallationResponse(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable TokenResult paramTokenResult, @Nullable InstallationResponse.ResponseCode paramResponseCode)
  {
    this.uri = paramString1;
    this.fid = paramString2;
    this.refreshToken = paramString3;
    this.authToken = paramTokenResult;
    this.responseCode = paramResponseCode;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof InstallationResponse))
    {
      paramObject = (InstallationResponse)paramObject;
      Object localObject = this.uri;
      if (localObject == null ? ((InstallationResponse)paramObject).getUri() == null : ((String)localObject).equals(((InstallationResponse)paramObject).getUri()))
      {
        localObject = this.fid;
        if (localObject == null ? ((InstallationResponse)paramObject).getFid() == null : ((String)localObject).equals(((InstallationResponse)paramObject).getFid()))
        {
          localObject = this.refreshToken;
          if (localObject == null ? ((InstallationResponse)paramObject).getRefreshToken() == null : ((String)localObject).equals(((InstallationResponse)paramObject).getRefreshToken()))
          {
            localObject = this.authToken;
            if (localObject == null ? ((InstallationResponse)paramObject).getAuthToken() == null : localObject.equals(((InstallationResponse)paramObject).getAuthToken()))
            {
              localObject = this.responseCode;
              if (localObject == null ? ((InstallationResponse)paramObject).getResponseCode() == null : ((Enum)localObject).equals(((InstallationResponse)paramObject).getResponseCode())) {
                break label176;
              }
            }
          }
        }
      }
      bool = false;
      label176:
      return bool;
    }
    return false;
  }
  
  @Nullable
  public TokenResult getAuthToken()
  {
    return this.authToken;
  }
  
  @Nullable
  public String getFid()
  {
    return this.fid;
  }
  
  @Nullable
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  @Nullable
  public InstallationResponse.ResponseCode getResponseCode()
  {
    return this.responseCode;
  }
  
  @Nullable
  public String getUri()
  {
    return this.uri;
  }
  
  public int hashCode()
  {
    Object localObject = this.uri;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = this.fid;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = ((String)localObject).hashCode();
    }
    localObject = this.refreshToken;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).hashCode();
    }
    localObject = this.authToken;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = localObject.hashCode();
    }
    localObject = this.responseCode;
    if (localObject != null) {
      i = ((Enum)localObject).hashCode();
    }
    return ((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i;
  }
  
  public InstallationResponse.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InstallationResponse{uri=");
    localStringBuilder.append(this.uri);
    localStringBuilder.append(", fid=");
    localStringBuilder.append(this.fid);
    localStringBuilder.append(", refreshToken=");
    localStringBuilder.append(this.refreshToken);
    localStringBuilder.append(", authToken=");
    localStringBuilder.append(this.authToken);
    localStringBuilder.append(", responseCode=");
    localStringBuilder.append(this.responseCode);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends InstallationResponse.Builder
  {
    private TokenResult authToken;
    private String fid;
    private String refreshToken;
    private InstallationResponse.ResponseCode responseCode;
    private String uri;
    
    Builder() {}
    
    private Builder(InstallationResponse paramInstallationResponse)
    {
      this.uri = paramInstallationResponse.getUri();
      this.fid = paramInstallationResponse.getFid();
      this.refreshToken = paramInstallationResponse.getRefreshToken();
      this.authToken = paramInstallationResponse.getAuthToken();
      this.responseCode = paramInstallationResponse.getResponseCode();
    }
    
    public InstallationResponse build()
    {
      return new AutoValue_InstallationResponse(this.uri, this.fid, this.refreshToken, this.authToken, this.responseCode, null);
    }
    
    public InstallationResponse.Builder setAuthToken(TokenResult paramTokenResult)
    {
      this.authToken = paramTokenResult;
      return this;
    }
    
    public InstallationResponse.Builder setFid(String paramString)
    {
      this.fid = paramString;
      return this;
    }
    
    public InstallationResponse.Builder setRefreshToken(String paramString)
    {
      this.refreshToken = paramString;
      return this;
    }
    
    public InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode paramResponseCode)
    {
      this.responseCode = paramResponseCode;
      return this;
    }
    
    public InstallationResponse.Builder setUri(String paramString)
    {
      this.uri = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\remote\AutoValue_InstallationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class AutoValue_TokenResult
  extends TokenResult
{
  private final TokenResult.ResponseCode responseCode;
  private final String token;
  private final long tokenExpirationTimestamp;
  
  private AutoValue_TokenResult(@Nullable String paramString, long paramLong, @Nullable TokenResult.ResponseCode paramResponseCode)
  {
    this.token = paramString;
    this.tokenExpirationTimestamp = paramLong;
    this.responseCode = paramResponseCode;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof TokenResult))
    {
      paramObject = (TokenResult)paramObject;
      Object localObject = this.token;
      if ((localObject == null ? ((TokenResult)paramObject).getToken() == null : ((String)localObject).equals(((TokenResult)paramObject).getToken())) && (this.tokenExpirationTimestamp == ((TokenResult)paramObject).getTokenExpirationTimestamp()))
      {
        localObject = this.responseCode;
        if (localObject == null ? ((TokenResult)paramObject).getResponseCode() == null : ((Enum)localObject).equals(((TokenResult)paramObject).getResponseCode())) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @Nullable
  public TokenResult.ResponseCode getResponseCode()
  {
    return this.responseCode;
  }
  
  @Nullable
  public String getToken()
  {
    return this.token;
  }
  
  @NonNull
  public long getTokenExpirationTimestamp()
  {
    return this.tokenExpirationTimestamp;
  }
  
  public int hashCode()
  {
    Object localObject = this.token;
    int i = 0;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    long l = this.tokenExpirationTimestamp;
    int k = (int)(l ^ l >>> 32);
    localObject = this.responseCode;
    if (localObject != null) {
      i = ((Enum)localObject).hashCode();
    }
    return ((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ i;
  }
  
  public TokenResult.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TokenResult{token=");
    localStringBuilder.append(this.token);
    localStringBuilder.append(", tokenExpirationTimestamp=");
    localStringBuilder.append(this.tokenExpirationTimestamp);
    localStringBuilder.append(", responseCode=");
    localStringBuilder.append(this.responseCode);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends TokenResult.Builder
  {
    private TokenResult.ResponseCode responseCode;
    private String token;
    private Long tokenExpirationTimestamp;
    
    Builder() {}
    
    private Builder(TokenResult paramTokenResult)
    {
      this.token = paramTokenResult.getToken();
      this.tokenExpirationTimestamp = Long.valueOf(paramTokenResult.getTokenExpirationTimestamp());
      this.responseCode = paramTokenResult.getResponseCode();
    }
    
    public TokenResult build()
    {
      Object localObject1 = this.tokenExpirationTimestamp;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" tokenExpirationTimestamp");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public TokenResult.Builder setResponseCode(TokenResult.ResponseCode paramResponseCode)
    {
      this.responseCode = paramResponseCode;
      return this;
    }
    
    public TokenResult.Builder setToken(String paramString)
    {
      this.token = paramString;
      return this;
    }
    
    public TokenResult.Builder setTokenExpirationTimestamp(long paramLong)
    {
      this.tokenExpirationTimestamp = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\remote\AutoValue_TokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
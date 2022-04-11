package com.google.android.datatransport.runtime.backends;

import java.util.Objects;

final class b
  extends BackendResponse
{
  private final BackendResponse.Status a;
  private final long b;
  
  b(BackendResponse.Status paramStatus, long paramLong)
  {
    Objects.requireNonNull(paramStatus, "Null status");
    this.a = paramStatus;
    this.b = paramLong;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public BackendResponse.Status c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BackendResponse))
    {
      paramObject = (BackendResponse)paramObject;
      if ((!this.a.equals(((BackendResponse)paramObject).c())) || (this.b != ((BackendResponse)paramObject).b())) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.a.hashCode();
    long l = this.b;
    return (i ^ 0xF4243) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackendResponse{status=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", nextRequestWaitMillis=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\backends\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
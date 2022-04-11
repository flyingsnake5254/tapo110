package com.google.android.datatransport.cct.internal;

final class h
  extends m
{
  private final long a;
  
  h(long paramLong)
  {
    this.a = paramLong;
  }
  
  public long c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof m))
    {
      paramObject = (m)paramObject;
      if (this.a != ((m)paramObject).c()) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    return 0xF4243 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LogResponse{nextRequestWaitMillis=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
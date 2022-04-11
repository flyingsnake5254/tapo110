package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;
import java.util.Objects;

final class d
  extends j
{
  private final List<l> a;
  
  d(List<l> paramList)
  {
    Objects.requireNonNull(paramList, "Null logRequests");
    this.a = paramList;
  }
  
  @Encodable.Field(name="logRequest")
  @NonNull
  public List<l> c()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      return this.a.equals(((j)paramObject).c());
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BatchedLogRequest{logRequests=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
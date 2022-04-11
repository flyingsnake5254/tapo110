package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public final class b
{
  private final String a;
  
  private b(@NonNull String paramString)
  {
    Objects.requireNonNull(paramString, "name is null");
    this.a = paramString;
  }
  
  public static b b(@NonNull String paramString)
  {
    return new b(paramString);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    return this.a.equals(((b)paramObject).a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode() ^ 0xF4243;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Encoding{name=\"");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
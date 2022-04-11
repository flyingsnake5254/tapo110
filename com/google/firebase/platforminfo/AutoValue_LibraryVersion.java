package com.google.firebase.platforminfo;

import java.util.Objects;
import javax.annotation.Nonnull;

final class AutoValue_LibraryVersion
  extends LibraryVersion
{
  private final String libraryName;
  private final String version;
  
  AutoValue_LibraryVersion(String paramString1, String paramString2)
  {
    Objects.requireNonNull(paramString1, "Null libraryName");
    this.libraryName = paramString1;
    Objects.requireNonNull(paramString2, "Null version");
    this.version = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof LibraryVersion))
    {
      paramObject = (LibraryVersion)paramObject;
      if ((!this.libraryName.equals(((LibraryVersion)paramObject).getLibraryName())) || (!this.version.equals(((LibraryVersion)paramObject).getVersion()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @Nonnull
  public String getLibraryName()
  {
    return this.libraryName;
  }
  
  @Nonnull
  public String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    return (this.libraryName.hashCode() ^ 0xF4243) * 1000003 ^ this.version.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LibraryVersion{libraryName=");
    localStringBuilder.append(this.libraryName);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\platforminfo\AutoValue_LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
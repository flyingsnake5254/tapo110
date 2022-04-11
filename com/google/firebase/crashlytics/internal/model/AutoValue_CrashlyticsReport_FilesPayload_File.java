package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;

final class AutoValue_CrashlyticsReport_FilesPayload_File
  extends CrashlyticsReport.FilesPayload.File
{
  private final byte[] contents;
  private final String filename;
  
  private AutoValue_CrashlyticsReport_FilesPayload_File(String paramString, byte[] paramArrayOfByte)
  {
    this.filename = paramString;
    this.contents = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.FilesPayload.File))
    {
      paramObject = (CrashlyticsReport.FilesPayload.File)paramObject;
      if (this.filename.equals(((CrashlyticsReport.FilesPayload.File)paramObject).getFilename()))
      {
        byte[] arrayOfByte = this.contents;
        if ((paramObject instanceof AutoValue_CrashlyticsReport_FilesPayload_File)) {
          paramObject = ((AutoValue_CrashlyticsReport_FilesPayload_File)paramObject).contents;
        } else {
          paramObject = ((CrashlyticsReport.FilesPayload.File)paramObject).getContents();
        }
        if (Arrays.equals(arrayOfByte, (byte[])paramObject)) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @NonNull
  public byte[] getContents()
  {
    return this.contents;
  }
  
  @NonNull
  public String getFilename()
  {
    return this.filename;
  }
  
  public int hashCode()
  {
    return (this.filename.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.contents);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("File{filename=");
    localStringBuilder.append(this.filename);
    localStringBuilder.append(", contents=");
    localStringBuilder.append(Arrays.toString(this.contents));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.FilesPayload.File.Builder
  {
    private byte[] contents;
    private String filename;
    
    public CrashlyticsReport.FilesPayload.File build()
    {
      Object localObject1 = this.filename;
      Object localObject2 = "";
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(" filename");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.contents == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" contents");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_FilesPayload_File(this.filename, this.contents, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.FilesPayload.File.Builder setContents(byte[] paramArrayOfByte)
    {
      Objects.requireNonNull(paramArrayOfByte, "Null contents");
      this.contents = paramArrayOfByte;
      return this;
    }
    
    public CrashlyticsReport.FilesPayload.File.Builder setFilename(String paramString)
    {
      Objects.requireNonNull(paramString, "Null filename");
      this.filename = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_FilesPayload_File.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
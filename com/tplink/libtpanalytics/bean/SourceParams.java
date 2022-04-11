package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;
import java.util.List;

public class SourceParams
{
  @c("cm")
  private String commitMethod;
  @c("evo")
  private List<EncryptionVersionOption> encryptVersionOption;
  @c("evoi")
  private String encryptVersionOptionId;
  @c("ec")
  private String encryptedContent;
  @c("ev")
  private int encryptedVersion;
  @c("lv")
  private int libraryVersion;
  
  public String getCommitMethod()
  {
    return this.commitMethod;
  }
  
  public List<EncryptionVersionOption> getEncryptVersionOption()
  {
    return this.encryptVersionOption;
  }
  
  public String getEncryptVersionOptionId()
  {
    return this.encryptVersionOptionId;
  }
  
  public String getEncryptedContent()
  {
    return this.encryptedContent;
  }
  
  public int getEncryptedVersion()
  {
    return this.encryptedVersion;
  }
  
  public int getLibraryVersion()
  {
    return this.libraryVersion;
  }
  
  public void setCommitMethod(String paramString)
  {
    this.commitMethod = paramString;
  }
  
  public void setEncryptVersionOption(List<EncryptionVersionOption> paramList)
  {
    this.encryptVersionOption = paramList;
  }
  
  public void setEncryptVersionOptionId(String paramString)
  {
    this.encryptVersionOptionId = paramString;
  }
  
  public void setEncryptedContent(String paramString)
  {
    this.encryptedContent = paramString;
  }
  
  public void setEncryptedVersion(int paramInt)
  {
    this.encryptedVersion = paramInt;
  }
  
  public void setLibraryVersion(int paramInt)
  {
    this.libraryVersion = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\SourceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
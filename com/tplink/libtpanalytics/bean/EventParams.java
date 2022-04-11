package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;

public class EventParams
{
  @c("eep")
  private String encryptedEventParam;
  @c("esrp")
  private String encryptedSourceParam;
  @c("ev")
  private int encryptedVersion;
  @c("evoi")
  private String encryptedVersionOptionId;
  @c("pep")
  private PlaintextEventParam plaintextEventParam;
  
  public String getEncryptedEventParam()
  {
    return this.encryptedEventParam;
  }
  
  public String getEncryptedSourceParam()
  {
    return this.encryptedSourceParam;
  }
  
  public int getEncryptedVersion()
  {
    return this.encryptedVersion;
  }
  
  public String getEncryptedVersionOptionId()
  {
    return this.encryptedVersionOptionId;
  }
  
  public PlaintextEventParam getPlaintextEventParam()
  {
    return this.plaintextEventParam;
  }
  
  public void setEncryptedEventParam(String paramString)
  {
    this.encryptedEventParam = paramString;
  }
  
  public void setEncryptedSourceParam(String paramString)
  {
    this.encryptedSourceParam = paramString;
  }
  
  public void setEncryptedVersion(int paramInt)
  {
    this.encryptedVersion = paramInt;
  }
  
  public void setEncryptedVersionOptionId(String paramString)
  {
    this.encryptedVersionOptionId = paramString;
  }
  
  public void setPlaintextEventParam(PlaintextEventParam paramPlaintextEventParam)
  {
    this.plaintextEventParam = paramPlaintextEventParam;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\EventParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
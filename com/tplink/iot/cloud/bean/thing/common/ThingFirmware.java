package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;

public class ThingFirmware
{
  @c("file_size")
  private int fileSize;
  @c("fw_ver")
  private String fwVer;
  @c("hw_id")
  private String hwId;
  @c("need_to_upgrade")
  private boolean needToUpgrade;
  @c("oem_id")
  private String oemId;
  @c("release_date")
  private String releaseDate;
  @c("release_note")
  private String releaseNote;
  private int type;
  
  public int getFileSize()
  {
    return this.fileSize;
  }
  
  public String getFwVer()
  {
    return this.fwVer;
  }
  
  public String getHwId()
  {
    return this.hwId;
  }
  
  public String getOemId()
  {
    return this.oemId;
  }
  
  public String getReleaseDate()
  {
    return this.releaseDate;
  }
  
  public String getReleaseNote()
  {
    return this.releaseNote;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public boolean isNeedToUpgrade()
  {
    return this.needToUpgrade;
  }
  
  public void setFileSize(int paramInt)
  {
    this.fileSize = paramInt;
  }
  
  public void setFwVer(String paramString)
  {
    this.fwVer = paramString;
  }
  
  public void setHwId(String paramString)
  {
    this.hwId = paramString;
  }
  
  public void setNeedToUpgrade(boolean paramBoolean)
  {
    this.needToUpgrade = paramBoolean;
  }
  
  public void setOemId(String paramString)
  {
    this.oemId = paramString;
  }
  
  public void setReleaseDate(String paramString)
  {
    this.releaseDate = paramString;
  }
  
  public void setReleaseNote(String paramString)
  {
    this.releaseNote = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingFirmware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
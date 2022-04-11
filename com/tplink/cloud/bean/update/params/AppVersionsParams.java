package com.tplink.cloud.bean.update.params;

public class AppVersionsParams
  extends AppVersionParams
{
  private int versionCode;
  
  public AppVersionsParams() {}
  
  public AppVersionsParams(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramString1, paramString2, paramString3);
    this.versionCode = paramInt;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\update\params\AppVersionsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
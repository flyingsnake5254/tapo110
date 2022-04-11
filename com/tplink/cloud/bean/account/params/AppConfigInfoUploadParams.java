package com.tplink.cloud.bean.account.params;

public class AppConfigInfoUploadParams
  extends AppConfigInfoParams
{
  private String featureInfo;
  private String token;
  
  public AppConfigInfoUploadParams() {}
  
  public AppConfigInfoUploadParams(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramString2);
    this.featureInfo = paramString3;
    this.token = paramString4;
  }
  
  public String getFeatureInfo()
  {
    return this.featureInfo;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setFeatureInfo(String paramString)
  {
    this.featureInfo = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\AppConfigInfoUploadParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
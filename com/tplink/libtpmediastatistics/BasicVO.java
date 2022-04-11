package com.tplink.libtpmediastatistics;

public class BasicVO
{
  private String appID;
  private String clientType;
  private String devID;
  private String devModel;
  private String firmwareVersion;
  private String networkType;
  private String streamType;
  
  public BasicVO clone()
  {
    BasicVO localBasicVO = new BasicVO();
    localBasicVO.setFirmwareVersion(this.firmwareVersion);
    localBasicVO.setStreamType(this.streamType);
    localBasicVO.setNetworkType(this.networkType);
    localBasicVO.setDevModel(this.devModel);
    localBasicVO.setAppID(this.appID);
    localBasicVO.setClientType(this.clientType);
    localBasicVO.setDevID(this.devID);
    return localBasicVO;
  }
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public String getClientType()
  {
    return this.clientType;
  }
  
  public String getDevID()
  {
    return this.devID;
  }
  
  public String getDevModel()
  {
    return this.devModel;
  }
  
  public String getFirmwareVersion()
  {
    return this.firmwareVersion;
  }
  
  public String getNetworkType()
  {
    return this.networkType;
  }
  
  public String getStreamType()
  {
    return this.streamType;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setClientType(String paramString)
  {
    this.clientType = paramString;
  }
  
  public void setDevID(String paramString)
  {
    this.devID = paramString;
  }
  
  public void setDevModel(String paramString)
  {
    this.devModel = paramString;
  }
  
  public void setFirmwareVersion(String paramString)
  {
    this.firmwareVersion = paramString;
  }
  
  public void setNetworkType(String paramString)
  {
    this.networkType = paramString;
  }
  
  public void setStreamType(String paramString)
  {
    this.streamType = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BasicVO{streamType='");
    localStringBuilder.append(this.streamType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", devID='");
    localStringBuilder.append(this.devID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appID='");
    localStringBuilder.append(this.appID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", clientType='");
    localStringBuilder.append(this.clientType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", networkType='");
    localStringBuilder.append(this.networkType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", devModel='");
    localStringBuilder.append(this.devModel);
    localStringBuilder.append('\'');
    localStringBuilder.append(", firmwareVersion='");
    localStringBuilder.append(this.firmwareVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediastatistics\BasicVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
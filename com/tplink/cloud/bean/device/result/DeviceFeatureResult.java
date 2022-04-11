package com.tplink.cloud.bean.device.result;

import com.google.gson.i;
import java.util.HashMap;
import java.util.Map;

public class DeviceFeatureResult
{
  private Map<String, i> featureInfo = new HashMap();
  
  public Map<String, i> getFeatureInfo()
  {
    return this.featureInfo;
  }
  
  public void setFeatureInfo(Map<String, i> paramMap)
  {
    this.featureInfo = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\device\result\DeviceFeatureResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
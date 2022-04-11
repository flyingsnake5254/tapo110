package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.HashMap;
import java.util.Map;

public enum SDCardFormatStatus
{
  private static Map<String, SDCardFormatStatus> map;
  private String value;
  
  static
  {
    int i = 0;
    SDCardFormatStatus localSDCardFormatStatus1 = new SDCardFormatStatus("SUCCESS", 0, "success");
    SUCCESS = localSDCardFormatStatus1;
    Object localObject = new SDCardFormatStatus("WAITING", 1, "waiting");
    WAITING = (SDCardFormatStatus)localObject;
    SDCardFormatStatus localSDCardFormatStatus2 = new SDCardFormatStatus("FAILED", 2, "failed");
    FAILED = localSDCardFormatStatus2;
    $VALUES = new SDCardFormatStatus[] { localSDCardFormatStatus1, localObject, localSDCardFormatStatus2 };
    map = new HashMap();
    localObject = values();
    int j = localObject.length;
    while (i < j)
    {
      localSDCardFormatStatus1 = localObject[i];
      map.put(localSDCardFormatStatus1.getValue(), localSDCardFormatStatus1);
      i++;
    }
  }
  
  private SDCardFormatStatus(String paramString)
  {
    this.value = paramString;
  }
  
  public static SDCardFormatStatus fromString(String paramString)
  {
    if (paramString != null) {
      paramString = (SDCardFormatStatus)map.get(paramString);
    } else {
      paramString = null;
    }
    return paramString;
  }
  
  public String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SDCardFormatStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
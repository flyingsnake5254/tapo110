package com.tplink.iot.viewmodel.ipcamera.play;

public enum VodPlayRate
{
  private String value;
  
  static
  {
    VodPlayRate localVodPlayRate1 = new VodPlayRate("RATE_1_16", 0, "1/16");
    RATE_1_16 = localVodPlayRate1;
    VodPlayRate localVodPlayRate2 = new VodPlayRate("RATE_1_8", 1, "1/8");
    RATE_1_8 = localVodPlayRate2;
    VodPlayRate localVodPlayRate3 = new VodPlayRate("RATE_1_4", 2, "1/4");
    RATE_1_4 = localVodPlayRate3;
    VodPlayRate localVodPlayRate4 = new VodPlayRate("RATE_1_2", 3, "1/2");
    RATE_1_2 = localVodPlayRate4;
    VodPlayRate localVodPlayRate5 = new VodPlayRate("RATE_1_1", 4, "1/1");
    RATE_1_1 = localVodPlayRate5;
    VodPlayRate localVodPlayRate6 = new VodPlayRate("RATE_2_1", 5, "2/1");
    RATE_2_1 = localVodPlayRate6;
    VodPlayRate localVodPlayRate7 = new VodPlayRate("RATE_4_1", 6, "4/1");
    RATE_4_1 = localVodPlayRate7;
    VodPlayRate localVodPlayRate8 = new VodPlayRate("RATE_8_1", 7, "8/1");
    RATE_8_1 = localVodPlayRate8;
    VodPlayRate localVodPlayRate9 = new VodPlayRate("RATE_16_1", 8, "16/1");
    RATE_16_1 = localVodPlayRate9;
    $VALUES = new VodPlayRate[] { localVodPlayRate1, localVodPlayRate2, localVodPlayRate3, localVodPlayRate4, localVodPlayRate5, localVodPlayRate6, localVodPlayRate7, localVodPlayRate8, localVodPlayRate9 };
  }
  
  private VodPlayRate(String paramString)
  {
    this.value = paramString;
  }
  
  public String getDisplayValue()
  {
    Object localObject1 = this.value;
    Object localObject2 = localObject1;
    if (((String)localObject1).endsWith("/1")) {
      localObject2 = ((String)localObject1).replace("/1", "");
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("x");
    return ((StringBuilder)localObject1).toString();
  }
  
  public int getFateFrameRate()
  {
    if (this.value.endsWith("/1")) {
      return 1;
    }
    return Integer.valueOf(this.value.replace("1/", "")).intValue();
  }
  
  public String getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\play\VodPlayRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
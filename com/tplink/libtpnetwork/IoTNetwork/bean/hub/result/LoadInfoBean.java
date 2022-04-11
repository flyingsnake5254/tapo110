package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LoadInfoBean
{
  @c("cur_load_num")
  private int curLoadNum;
  @c("load_level")
  private String loadLevel;
  @c("max_load_num")
  private int maxLoadNum;
  @c("memory_usage")
  private int memoryUsage;
  @c("total_memory")
  private int totalMemory;
  @c("used_memory")
  private int usedMemory;
  
  public LoadInfoBean() {}
  
  public LoadInfoBean(ThingRealTimeInfo paramThingRealTimeInfo)
  {
    if (paramThingRealTimeInfo != null)
    {
      this.usedMemory = getIntValueFromInteger(paramThingRealTimeInfo.getUsedMemory());
      this.totalMemory = getIntValueFromInteger(paramThingRealTimeInfo.getTotalMemory());
      this.maxLoadNum = getIntValueFromInteger(paramThingRealTimeInfo.getMaxLoadNum());
      this.curLoadNum = getIntValueFromInteger(paramThingRealTimeInfo.getCurLoadNum());
      this.loadLevel = paramThingRealTimeInfo.getLoadLevel();
    }
  }
  
  private static int getIntValueFromInteger(Integer paramInteger)
  {
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.intValue();
  }
  
  public static int getLoadLevelInt(String paramString)
  {
    if ("middle".equals(paramString)) {
      return 2;
    }
    if ("high".equals(paramString)) {
      return 3;
    }
    return 1;
  }
  
  public int getCurLoadNum()
  {
    return this.curLoadNum;
  }
  
  public String getLoadLevel()
  {
    return this.loadLevel;
  }
  
  public int getMaxLoadNum()
  {
    return this.maxLoadNum;
  }
  
  public int getMemoryUsage()
  {
    return this.memoryUsage;
  }
  
  public int getTotalMemory()
  {
    return this.totalMemory;
  }
  
  public int getUsedMemory()
  {
    return this.usedMemory;
  }
  
  public void setCurLoadNum(int paramInt)
  {
    this.curLoadNum = paramInt;
  }
  
  public void setLoadLevel(String paramString)
  {
    this.loadLevel = paramString;
  }
  
  public void setMaxLoadNum(int paramInt)
  {
    this.maxLoadNum = paramInt;
  }
  
  public void setMemoryUsage(int paramInt)
  {
    this.memoryUsage = paramInt;
  }
  
  public void setTotalMemory(int paramInt)
  {
    this.totalMemory = paramInt;
  }
  
  public void setUsedMemory(int paramInt)
  {
    this.usedMemory = paramInt;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LoadLevel
  {
    public static final String HIGH = "high";
    public static final String LIGHT = "light";
    public static final String MIDDLE = "middle";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\hub\result\LoadInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
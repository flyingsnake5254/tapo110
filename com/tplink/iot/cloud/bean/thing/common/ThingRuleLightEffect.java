package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.i;
import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ThingRuleLightEffect
{
  @c("change_mode")
  private String changeMode;
  @c("change_time")
  private long changeTime;
  @c("color_status_list")
  private i colorStatusList;
  private String id;
  @b(Base64TypeAdapter.class)
  @c("scene_name")
  private String sceneName;
  
  public String getChangeMode()
  {
    return this.changeMode;
  }
  
  public long getChangeTime()
  {
    return this.changeTime;
  }
  
  public i getColorStatusList()
  {
    return this.colorStatusList;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getSceneName()
  {
    return this.sceneName;
  }
  
  public void setChangeMode(String paramString)
  {
    this.changeMode = paramString;
  }
  
  public void setChangeTime(long paramLong)
  {
    this.changeTime = paramLong;
  }
  
  public void setColorStatusList(i parami)
  {
    this.colorStatusList = parami;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setSceneName(String paramString)
  {
    this.sceneName = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ChangeMode
  {
    public static final String MODE_BLN = "bln";
    public static final String MODE_DIRECT = "direct";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\bean\thing\common\ThingRuleLightEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
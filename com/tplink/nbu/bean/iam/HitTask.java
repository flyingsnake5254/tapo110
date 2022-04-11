package com.tplink.nbu.bean.iam;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class HitTask
{
  private String pushType;
  private List<Task> taskList;
  
  public String getPushType()
  {
    return this.pushType;
  }
  
  public List<Task> getTaskList()
  {
    return this.taskList;
  }
  
  public void setPushType(String paramString)
  {
    this.pushType = paramString;
  }
  
  public void setTaskList(List<Task> paramList)
  {
    this.taskList = paramList;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PushType
  {
    public static final String NOTIFICATION_WEB_PAGE = "notification+webpage";
    public static final String SPLASH = "splash";
    public static final String WEB_PAGE = "webpage";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\nbu\bean\iam\HitTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
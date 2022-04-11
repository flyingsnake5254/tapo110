package com.tplink.cloud.bean.push;

import com.google.gson.i;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NotificationMsgBean
{
  private i attachments;
  private String content;
  private String msgId;
  private String msgType;
  private boolean readFlag;
  private long time;
  private String title;
  
  public i getAttachments()
  {
    return this.attachments;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getMsgId()
  {
    return this.msgId;
  }
  
  public String getMsgType()
  {
    return this.msgType;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public boolean isReadFlag()
  {
    return this.readFlag;
  }
  
  public void setAttachments(i parami)
  {
    this.attachments = parami;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setMsgId(String paramString)
  {
    this.msgId = paramString;
  }
  
  public void setMsgType(String paramString)
  {
    this.msgType = paramString;
  }
  
  public void setReadFlag(boolean paramBoolean)
  {
    this.readFlag = paramBoolean;
  }
  
  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MsgType
  {
    public static final String AUDIO = "Audio";
    public static final String CRYING = "BabyCry";
    public static final String MOTION = "Motion";
    public static final String NEW_FIRMWARE = "tapoNewFirmware";
    public static final String PERSON_DETECTED = "PersonDetected";
    public static final String PERSON_ENHANCED = "PersonEnhanced";
    public static final String SHARE_LAUNCH = "tapoShareLaunch";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\NotificationMsgBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.cloud.bean.push.params;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class UnsubscribeMsgParams
{
  private List<String> msgTypes;
  
  public List<String> getMsgTypes()
  {
    return this.msgTypes;
  }
  
  public void setMsgTypes(List<String> paramList)
  {
    this.msgTypes = paramList;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MsgType
  {
    public static final String ANNOUNCEMENT = "announcement";
    public static final String BRAND_PROMOTION = "brandPromotion";
    public static final String MARKET_PROMOTION = "marketPromotion";
    public static final String OTHER = "other";
    public static final String USER_RESEARCH = "userResearch";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\push\params\UnsubscribeMsgParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
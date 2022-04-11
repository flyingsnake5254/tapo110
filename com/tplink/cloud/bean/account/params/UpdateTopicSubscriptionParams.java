package com.tplink.cloud.bean.account.params;

import java.util.Map;

public class UpdateTopicSubscriptionParams
  extends TopicSubscriptionParams
{
  private Map<String, Boolean> topicSubscription;
  
  public UpdateTopicSubscriptionParams() {}
  
  public UpdateTopicSubscriptionParams(String paramString1, String paramString2, Map<String, Boolean> paramMap)
  {
    super(paramString1, paramString2);
    this.topicSubscription = paramMap;
  }
  
  public Map<String, Boolean> getTopicSubscription()
  {
    return this.topicSubscription;
  }
  
  public void setTopicSubscription(Map<String, Boolean> paramMap)
  {
    this.topicSubscription = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\params\UpdateTopicSubscriptionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tplink.cloud.bean.account.result;

import java.util.HashMap;
import java.util.Map;

public class TopicSubscriptionResult
{
  private Map<String, Boolean> topicSubscription = new HashMap();
  
  public Map<String, Boolean> getTopicSubscription()
  {
    return this.topicSubscription;
  }
  
  public void setTopicSubscription(Map<String, Boolean> paramMap)
  {
    this.topicSubscription = paramMap;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\cloud\bean\account\result\TopicSubscriptionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
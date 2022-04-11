package com.tplink.iot.cloud.enumerate;

import com.google.gson.q.c;

public enum ThingRuleType
{
  static
  {
    ThingRuleType localThingRuleType1 = new ThingRuleType("SCHEDULE", 0);
    SCHEDULE = localThingRuleType1;
    ThingRuleType localThingRuleType2 = new ThingRuleType("TIMER", 1);
    TIMER = localThingRuleType2;
    ThingRuleType localThingRuleType3 = new ThingRuleType("AWAY_MODE", 2);
    AWAY_MODE = localThingRuleType3;
    ThingRuleType localThingRuleType4 = new ThingRuleType("DYNAMIC_LIGHT_EFFECT", 3);
    DYNAMIC_LIGHT_EFFECT = localThingRuleType4;
    $VALUES = new ThingRuleType[] { localThingRuleType1, localThingRuleType2, localThingRuleType3, localThingRuleType4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\enumerate\ThingRuleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
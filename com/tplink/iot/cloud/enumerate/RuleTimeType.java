package com.tplink.iot.cloud.enumerate;

import com.google.gson.q.c;

public enum RuleTimeType
{
  static
  {
    RuleTimeType localRuleTimeType1 = new RuleTimeType("NONE", 0);
    NONE = localRuleTimeType1;
    RuleTimeType localRuleTimeType2 = new RuleTimeType("NORMAL", 1);
    NORMAL = localRuleTimeType2;
    RuleTimeType localRuleTimeType3 = new RuleTimeType("SUNRISE", 2);
    SUNRISE = localRuleTimeType3;
    RuleTimeType localRuleTimeType4 = new RuleTimeType("SUNSET", 3);
    SUNSET = localRuleTimeType4;
    $VALUES = new RuleTimeType[] { localRuleTimeType1, localRuleTimeType2, localRuleTimeType3, localRuleTimeType4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\enumerate\RuleTimeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
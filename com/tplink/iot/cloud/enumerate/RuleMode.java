package com.tplink.iot.cloud.enumerate;

import com.google.gson.q.c;

public enum RuleMode
{
  static
  {
    RuleMode localRuleMode1 = new RuleMode("ONCE", 0);
    ONCE = localRuleMode1;
    RuleMode localRuleMode2 = new RuleMode("REPEAT", 1);
    REPEAT = localRuleMode2;
    $VALUES = new RuleMode[] { localRuleMode1, localRuleMode2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\enumerate\RuleMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
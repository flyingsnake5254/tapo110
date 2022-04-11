package b.d.s.b;

import java.util.HashMap;
import java.util.Map;

public class a
{
  public static final Map<Integer, String> a;
  public static final Map<String, Boolean> b;
  public static final Map<String, Boolean> c;
  public static final Map<String, String> d;
  public static final Map<String, String> e;
  
  static
  {
    HashMap localHashMap1 = new HashMap();
    a = localHashMap1;
    localHashMap1.put(Integer.valueOf(0), "ERR_SUCCESS");
    localHashMap1.put(Integer.valueOf(-1), "ERR_COMMON_FAILED");
    localHashMap1.put(Integer.valueOf(9999), "ERR_SESSION_TIMEOUT");
    localHashMap1.put(Integer.valueOf(1000), "ERR_NULL_TRANSPORT");
    localHashMap1.put(Integer.valueOf(1001), "ERR_CMD_COMMAND_CANCEL");
    localHashMap1.put(Integer.valueOf(1002), "ERR_TRANSPORT_NOT_AVAILABLE");
    localHashMap1.put(Integer.valueOf(1100), "ERR_HAND_SHAKE_FAILED");
    localHashMap1.put(Integer.valueOf(1111), "ERR_LOGIN_FAILED");
    localHashMap1.put(Integer.valueOf(1112), "ERR_HTTP_TRANSPORT_FAILED");
    localHashMap1.put(Integer.valueOf(1200), "ERR_MULTI_REQUEST_FAILED");
    localHashMap1.put(Integer.valueOf(64535), "ERR_UNSPECIFIC");
    localHashMap1.put(Integer.valueOf(64534), "ERR_UNKNOWN_METHOD");
    localHashMap1.put(Integer.valueOf(64533), "ERR_JSON_DECODE_FAIL");
    localHashMap1.put(Integer.valueOf(64532), "ERR_JSON_ENCODE_FAIL");
    localHashMap1.put(Integer.valueOf(64531), "ERR_AES_DECODE_FAIL");
    localHashMap1.put(Integer.valueOf(64530), "ERR_REQUEST_LEN_ERROR");
    localHashMap1.put(Integer.valueOf(64529), "ERR_CLOUD_FAILED");
    localHashMap1.put(Integer.valueOf(64528), "ERR_PARAMS");
    localHashMap1.put(Integer.valueOf(64435), "ERR_SESSION_PARAM");
    localHashMap1.put(Integer.valueOf(64335), "ERR_QUICK_SETUP");
    localHashMap1.put(Integer.valueOf(64235), "ERR_DEVICE");
    localHashMap1.put(Integer.valueOf(64234), "ERR_DEVICE_NEXT_EVENT");
    localHashMap1.put(Integer.valueOf(64135), "ERR_FIRMWARE");
    localHashMap1.put(Integer.valueOf(64134), "ERR_FIRMWARE_VER_ERROR");
    localHashMap1.put(Integer.valueOf(64035), "ERR_LOGIN");
    localHashMap1.put(Integer.valueOf(63935), "ERR_TIME");
    localHashMap1.put(Integer.valueOf(63934), "ERR_TIME_SYS");
    localHashMap1.put(Integer.valueOf(63933), "ERR_TIME_SAVE");
    localHashMap1.put(Integer.valueOf(63835), "ERR_WIRELESS");
    localHashMap1.put(Integer.valueOf(63834), "ERR_WIRELESS_UNSUPPORTED");
    localHashMap1.put(Integer.valueOf(63735), "ERR_SCHEDULE");
    localHashMap1.put(Integer.valueOf(63734), "ERR_SCHEDULE_FULL");
    localHashMap1.put(Integer.valueOf(63733), "ERR_SCHEDULE_CONFLICT");
    localHashMap1.put(Integer.valueOf(63732), "ERR_SCHEDULE_SAVE");
    localHashMap1.put(Integer.valueOf(63731), "ERR_SCHEDULE_INDEX");
    localHashMap1.put(Integer.valueOf(63635), "ERR_COUNTDOWN");
    localHashMap1.put(Integer.valueOf(63634), "ERR_COUNTDOWN_CONFLICT");
    localHashMap1.put(Integer.valueOf(63633), "ERR_COUNTDOWN_SAVE");
    localHashMap1.put(Integer.valueOf(63535), "ERR_ANTITHEFT");
    localHashMap1.put(Integer.valueOf(63534), "ERR_ANTITHEFT_CONFLICT");
    localHashMap1.put(Integer.valueOf(63533), "ERR_ANTITHEFT_SAVE");
    localHashMap1.put(Integer.valueOf(63435), "ERR_ACCOUNT");
    localHashMap1.put(Integer.valueOf(63335), "ERR_STAT");
    localHashMap1.put(Integer.valueOf(63334), "ERR_STAT_SAVE");
    localHashMap1.put(Integer.valueOf(63235), "ERR_DST");
    localHashMap1.put(Integer.valueOf(63234), "ERR_DST_SAVE");
    HashMap localHashMap2 = new HashMap();
    b = localHashMap2;
    HashMap localHashMap3 = new HashMap();
    c = localHashMap3;
    HashMap localHashMap4 = new HashMap();
    d = localHashMap4;
    localHashMap1 = new HashMap();
    e = localHashMap1;
    Boolean localBoolean = Boolean.TRUE;
    localHashMap2.put("get_device_info", localBoolean);
    localHashMap3.put("set_device_info", localBoolean);
    localHashMap4.put("get_device_infoset_device_info", "set_device_info");
    localHashMap1.put("set_device_infoget_device_info", "get_device_info");
    localHashMap2.put("get_device_running_info", localBoolean);
    localHashMap3.put("set_device_info", localBoolean);
    localHashMap4.put("get_device_running_infoset_device_info", "set_device_info");
    localHashMap1.put("set_device_infoget_device_running_info", "get_device_running_info");
    localHashMap2.put("get_device_time", localBoolean);
    localHashMap3.put("set_device_time", localBoolean);
    localHashMap4.put("get_device_timeset_device_time", "set_device_time");
    localHashMap1.put("set_device_timeget_device_time", "get_device_time");
    localHashMap2.put("get_schedule_rules", localBoolean);
    localHashMap3.put("add_schedule_rule", localBoolean);
    localHashMap4.put("get_schedule_rulesadd_schedule_rule", "add_schedule_rule");
    localHashMap1.put("add_schedule_ruleget_schedule_rules", "get_schedule_rules");
    localHashMap2.put("get_schedule_rules", localBoolean);
    localHashMap3.put("edit_schedule_rule", localBoolean);
    localHashMap4.put("get_schedule_rulesedit_schedule_rule", "edit_schedule_rule");
    localHashMap1.put("edit_schedule_ruleget_schedule_rules", "get_schedule_rules");
    localHashMap2.put("get_early_start", localBoolean);
    localHashMap3.put("set_early_start", localBoolean);
    localHashMap4.put("get_early_startset_early_start", "set_early_start");
    localHashMap1.put("set_early_startget_early_start", "get_early_start");
    localHashMap2.put("get_schedule_rules", localBoolean);
    localHashMap3.put("remove_schedule_rules", localBoolean);
    localHashMap4.put("get_schedule_rulesremove_schedule_rules", "remove_schedule_rules");
    localHashMap1.put("remove_schedule_rulesget_schedule_rules", "get_schedule_rules");
    localHashMap2.put("get_countdown_rules", localBoolean);
    localHashMap3.put("add_countdown_rule", localBoolean);
    localHashMap4.put("get_countdown_rulesadd_countdown_rule", "add_countdown_rule");
    localHashMap1.put("add_countdown_ruleget_countdown_rules", "get_countdown_rules");
    localHashMap2.put("get_countdown_rules", localBoolean);
    localHashMap3.put("edit_countdown_rule", localBoolean);
    localHashMap4.put("get_countdown_rulesedit_countdown_rule", "edit_countdown_rule");
    localHashMap1.put("edit_countdown_ruleget_countdown_rules", "get_countdown_rules");
    localHashMap2.put("get_countdown_rules", localBoolean);
    localHashMap3.put("remove_countdown_rules", localBoolean);
    localHashMap4.put("get_countdown_rulesremove_countdown_rules", "remove_countdown_rules");
    localHashMap1.put("remove_countdown_rulesget_countdown_rules", "get_countdown_rules");
    localHashMap2.put("get_antitheft_rules", localBoolean);
    localHashMap3.put("add_antitheft_rule", localBoolean);
    localHashMap4.put("get_antitheft_rulesadd_antitheft_rule", "add_antitheft_rule");
    localHashMap1.put("add_antitheft_ruleget_antitheft_rules", "get_antitheft_rules");
    localHashMap2.put("get_antitheft_rules", localBoolean);
    localHashMap3.put("edit_antitheft_rule", localBoolean);
    localHashMap4.put("get_antitheft_rulesedit_antitheft_rule", "edit_antitheft_rule");
    localHashMap1.put("edit_antitheft_ruleget_antitheft_rules", "get_antitheft_rules");
    localHashMap2.put("get_led_info", localBoolean);
    localHashMap3.put("set_led_info", localBoolean);
    localHashMap4.put("get_led_infoset_led_info", "set_led_info");
    localHashMap1.put("set_led_infoget_led_info", "get_led_info");
    localHashMap3.put("set_dynamic_light_effect_rule_enable", localBoolean);
    localHashMap4.put("get_device_running_infoset_dynamic_light_effect_rule_enable", "set_dynamic_light_effect_rule_enable");
    localHashMap3.put("set_guard_mode", localBoolean);
    localHashMap4.put("get_device_running_infoset_guard_mode", "set_guard_mode");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\s\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
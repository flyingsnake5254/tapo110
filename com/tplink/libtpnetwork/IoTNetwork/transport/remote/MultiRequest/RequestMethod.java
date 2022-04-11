package com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest;

import java.util.ArrayList;
import java.util.List;

public class RequestMethod
{
  private static final List<String> a;
  private static final List<String> b;
  private static final List<String> c;
  private static final List<String> d;
  
  static
  {
    ArrayList localArrayList1 = new ArrayList();
    a = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    b = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    c = localArrayList3;
    ArrayList localArrayList4 = new ArrayList();
    d = localArrayList4;
    localArrayList1.add("get_device_info");
    localArrayList1.add("get_device_running_info");
    localArrayList1.add("get_latest_fw");
    localArrayList1.add("get_fw_download_state");
    localArrayList1.add("component_nego");
    localArrayList1.add("qs_component_nego");
    localArrayList1.add("get_device_time");
    localArrayList1.add("get_wireless_scan_info");
    localArrayList1.add("get_schedule_rules");
    localArrayList1.add("get_schedule_next_action");
    localArrayList1.add("get_schedule_day_runtime");
    localArrayList1.add("get_schedule_month_runtime");
    localArrayList1.add("get_countdown_rules");
    localArrayList1.add("get_antitheft_rules");
    localArrayList2.add("set_device_info");
    localArrayList2.add("set_device_time");
    localArrayList2.add("set_schedule_all_enable");
    localArrayList2.add("set_antitheft_all_enable");
    localArrayList3.add("device_reset");
    localArrayList3.add("device_reboot");
    localArrayList3.add("fw_download");
    localArrayList3.add("login_device");
    localArrayList3.add("set_qs_info");
    localArrayList3.add("set_wireless_info");
    localArrayList3.add("add_schedule_rule");
    localArrayList3.add("edit_schedule_rule");
    localArrayList3.add("remove_schedule_rules");
    localArrayList3.add("remove_all_schedule_runtime");
    localArrayList3.add("add_countdown_rule");
    localArrayList3.add("edit_countdown_rule");
    localArrayList3.add("remove_countdown_rules");
    localArrayList3.add("add_antitheft_rule");
    localArrayList3.add("edit_antitheft _rule");
    localArrayList3.add("remove_antitheft _rules");
    localArrayList4.add("multipleRequest");
    localArrayList4.add("device_reset");
    localArrayList4.add("device_reboot");
    localArrayList4.add("fw_download");
    localArrayList4.add("login_device");
    localArrayList4.add("set_qs_info");
    localArrayList4.add("set_wireless_info");
    localArrayList4.add("get_schedule_rules");
  }
  
  public static RequestMethodType a(String paramString)
  {
    if (a.contains(paramString)) {
      return RequestMethodType.REPLACE_DIRECT_TYPE;
    }
    if (b.contains(paramString)) {
      return RequestMethodType.REPLACE_COMBINE_TYPE;
    }
    return RequestMethodType.NOT_REPLACE_TYPE;
  }
  
  public static boolean b(String paramString)
  {
    return d.contains(paramString) ^ true;
  }
  
  public static enum RequestMethodType
  {
    static
    {
      RequestMethodType localRequestMethodType1 = new RequestMethodType("REPLACE_DIRECT_TYPE", 0);
      REPLACE_DIRECT_TYPE = localRequestMethodType1;
      RequestMethodType localRequestMethodType2 = new RequestMethodType("REPLACE_COMBINE_TYPE", 1);
      REPLACE_COMBINE_TYPE = localRequestMethodType2;
      RequestMethodType localRequestMethodType3 = new RequestMethodType("NOT_REPLACE_TYPE", 2);
      NOT_REPLACE_TYPE = localRequestMethodType3;
      RequestMethodType localRequestMethodType4 = new RequestMethodType("NOT_MULTI_REQUEST_TYPE", 3);
      NOT_MULTI_REQUEST_TYPE = localRequestMethodType4;
      $VALUES = new RequestMethodType[] { localRequestMethodType1, localRequestMethodType2, localRequestMethodType3, localRequestMethodType4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\remote\MultiRequest\RequestMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
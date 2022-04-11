package com.tplink.iot.view.smart.a;

import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.List;
import kotlin.collections.l;

public final class a
{
  public static final List<EnumDeviceType> a;
  public static final List<String> b;
  public static final List<EnumDeviceType> c;
  public static final List<String> d;
  public static final a e = new a();
  
  static
  {
    EnumDeviceType localEnumDeviceType1 = EnumDeviceType.HUB;
    Object localObject = EnumDeviceType.SENSOR;
    EnumDeviceType localEnumDeviceType2 = EnumDeviceType.SWITCH;
    EnumDeviceType localEnumDeviceType3 = EnumDeviceType.ENERGY;
    EnumDeviceType localEnumDeviceType4 = EnumDeviceType.CAMERA;
    a = l.g(new EnumDeviceType[] { localEnumDeviceType1, localObject, localEnumDeviceType2, localEnumDeviceType3, localEnumDeviceType4 });
    EnumIoTCategory localEnumIoTCategory1 = EnumIoTCategory.HUB;
    String str1 = localEnumIoTCategory1.value();
    EnumIoTCategory localEnumIoTCategory2 = EnumIoTCategory.CAMERA;
    String str2 = localEnumIoTCategory2.value();
    String str3 = EnumIoTCategory.SUBG_TRIGGER_MOTION_SENSOR.value();
    localObject = EnumIoTCategory.SUBG_TRIGGER_CONTACT_SENSOR.value();
    String str4 = EnumIoTCategory.SUBG_TRIGGER_BUTTON.value();
    EnumIoTCategory localEnumIoTCategory3 = EnumIoTCategory.SUBG_PLUGSWITCH_SWITCH;
    String str5 = localEnumIoTCategory3.value();
    EnumIoTCategory localEnumIoTCategory4 = EnumIoTCategory.SUBG_TRV;
    b = l.g(new String[] { str1, str2, str3, localObject, str4, str5, localEnumIoTCategory4.value() });
    c = l.g(new EnumDeviceType[] { EnumDeviceType.PLUG, EnumDeviceType.BULB, localEnumDeviceType1, localEnumDeviceType2, localEnumDeviceType3, localEnumDeviceType4 });
    d = l.g(new String[] { EnumIoTCategory.PLUG.value(), EnumIoTCategory.LIGHT.value(), EnumIoTCategory.LIGHT_STRIP.value(), localEnumIoTCategory1.value(), localEnumIoTCategory3.value(), localEnumIoTCategory4.value(), localEnumIoTCategory2.value() });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
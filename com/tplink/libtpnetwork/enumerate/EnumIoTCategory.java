package com.tplink.libtpnetwork.enumerate;

import android.text.TextUtils;
import androidx.annotation.Nullable;

public enum EnumIoTCategory
{
  private final String value;
  
  static
  {
    EnumIoTCategory localEnumIoTCategory1 = new EnumIoTCategory("LIGHT", 0, "light");
    LIGHT = localEnumIoTCategory1;
    EnumIoTCategory localEnumIoTCategory2 = new EnumIoTCategory("LIGHT_STRIP", 1, "light.strip");
    LIGHT_STRIP = localEnumIoTCategory2;
    EnumIoTCategory localEnumIoTCategory3 = new EnumIoTCategory("PLUG", 2, "plug");
    PLUG = localEnumIoTCategory3;
    EnumIoTCategory localEnumIoTCategory4 = new EnumIoTCategory("HUB", 3, "hub");
    HUB = localEnumIoTCategory4;
    EnumIoTCategory localEnumIoTCategory5 = new EnumIoTCategory("HUB_PLUG", 4, "hub.plug");
    HUB_PLUG = localEnumIoTCategory5;
    EnumIoTCategory localEnumIoTCategory6 = new EnumIoTCategory("CAMERA", 5, "camera");
    CAMERA = localEnumIoTCategory6;
    EnumIoTCategory localEnumIoTCategory7 = new EnumIoTCategory("SUBG_PLUGSWITCH_PLUG", 6, "subg.plugswitch.plug");
    SUBG_PLUGSWITCH_PLUG = localEnumIoTCategory7;
    EnumIoTCategory localEnumIoTCategory8 = new EnumIoTCategory("SUBG_PLUGSWITCH_SWITCH", 7, "subg.plugswitch.switch");
    SUBG_PLUGSWITCH_SWITCH = localEnumIoTCategory8;
    EnumIoTCategory localEnumIoTCategory9 = new EnumIoTCategory("SUBG_TRIGGER_BUTTON", 8, "subg.trigger.button");
    SUBG_TRIGGER_BUTTON = localEnumIoTCategory9;
    EnumIoTCategory localEnumIoTCategory10 = new EnumIoTCategory("SUBG_TRIGGER_CONTACT_SENSOR", 9, "subg.trigger.contact-sensor");
    SUBG_TRIGGER_CONTACT_SENSOR = localEnumIoTCategory10;
    EnumIoTCategory localEnumIoTCategory11 = new EnumIoTCategory("SUBG_TRIGGER_MOTION_SENSOR", 10, "subg.trigger.motion-sensor");
    SUBG_TRIGGER_MOTION_SENSOR = localEnumIoTCategory11;
    EnumIoTCategory localEnumIoTCategory12 = new EnumIoTCategory("SUBG_TRV", 11, "subg.trv");
    SUBG_TRV = localEnumIoTCategory12;
    $VALUES = new EnumIoTCategory[] { localEnumIoTCategory1, localEnumIoTCategory2, localEnumIoTCategory3, localEnumIoTCategory4, localEnumIoTCategory5, localEnumIoTCategory6, localEnumIoTCategory7, localEnumIoTCategory8, localEnumIoTCategory9, localEnumIoTCategory10, localEnumIoTCategory11, localEnumIoTCategory12 };
  }
  
  private EnumIoTCategory(String paramString)
  {
    this.value = paramString;
  }
  
  @Nullable
  public static EnumIoTCategory fromString(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (EnumIoTCategory localEnumIoTCategory : values()) {
      if (localEnumIoTCategory.value().equalsIgnoreCase(paramString)) {
        return localEnumIoTCategory;
      }
    }
    return null;
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumIoTCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
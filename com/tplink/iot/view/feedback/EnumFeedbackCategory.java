package com.tplink.iot.view.feedback;

import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.jvm.internal.j;

public enum EnumFeedbackCategory
{
  public static final a Companion = new a(null);
  private final EnumDeviceType deviceType;
  private final String value;
  
  static
  {
    EnumFeedbackCategory localEnumFeedbackCategory1 = new EnumFeedbackCategory("CAMERA", 0, EnumDeviceType.CAMERA, null, 2, null);
    CAMERA = localEnumFeedbackCategory1;
    EnumFeedbackCategory localEnumFeedbackCategory2 = new EnumFeedbackCategory("PLUG", 1, EnumDeviceType.PLUG, null, 2, null);
    PLUG = localEnumFeedbackCategory2;
    Object localObject1 = EnumDeviceType.BULB;
    EnumFeedbackCategory localEnumFeedbackCategory3 = new EnumFeedbackCategory("BULB", 2, (EnumDeviceType)localObject1, null, 2, null);
    BULB = localEnumFeedbackCategory3;
    EnumFeedbackCategory localEnumFeedbackCategory4 = new EnumFeedbackCategory("LIGHT_STRIP", 3, (EnumDeviceType)localObject1, "FEEDBACK.LIGHT_STRIP");
    LIGHT_STRIP = localEnumFeedbackCategory4;
    localObject1 = new EnumFeedbackCategory("HUB", 4, EnumDeviceType.HUB, null, 2, null);
    HUB = (EnumFeedbackCategory)localObject1;
    Object localObject2 = EnumDeviceType.SENSOR;
    EnumFeedbackCategory localEnumFeedbackCategory5 = new EnumFeedbackCategory("MOTION_SENSOR", 5, (EnumDeviceType)localObject2, "FEEDBACK.MOTION_SENSOR");
    MOTION_SENSOR = localEnumFeedbackCategory5;
    EnumFeedbackCategory localEnumFeedbackCategory6 = new EnumFeedbackCategory("CONTACT_SENSOR", 6, (EnumDeviceType)localObject2, "FEEDBACK.CONTACT_SENSOR");
    CONTACT_SENSOR = localEnumFeedbackCategory6;
    EnumFeedbackCategory localEnumFeedbackCategory7 = new EnumFeedbackCategory("BUTTON", 7, (EnumDeviceType)localObject2, "FEEDBACK.BUTTON");
    BUTTON = localEnumFeedbackCategory7;
    EnumFeedbackCategory localEnumFeedbackCategory8 = new EnumFeedbackCategory("SWITCH", 8, EnumDeviceType.SWITCH, null, 2, null);
    SWITCH = localEnumFeedbackCategory8;
    localObject2 = new EnumFeedbackCategory("TRV", 9, EnumDeviceType.ENERGY, "FEEDBACK.TRV");
    TRV = (EnumFeedbackCategory)localObject2;
    EnumFeedbackCategory localEnumFeedbackCategory9 = new EnumFeedbackCategory("OTHER", 10, EnumDeviceType.UNKNOWN, null, 2, null);
    OTHER = localEnumFeedbackCategory9;
    $VALUES = new EnumFeedbackCategory[] { localEnumFeedbackCategory1, localEnumFeedbackCategory2, localEnumFeedbackCategory3, localEnumFeedbackCategory4, localObject1, localEnumFeedbackCategory5, localEnumFeedbackCategory6, localEnumFeedbackCategory7, localEnumFeedbackCategory8, localObject2, localEnumFeedbackCategory9 };
  }
  
  private EnumFeedbackCategory(EnumDeviceType paramEnumDeviceType, String paramString)
  {
    this.deviceType = paramEnumDeviceType;
    this.value = paramString;
  }
  
  public static final EnumFeedbackCategory fromCategory(String paramString)
  {
    return Companion.a(paramString);
  }
  
  public static final EnumFeedbackCategory fromDeviceType(String paramString)
  {
    return Companion.b(paramString);
  }
  
  public final EnumDeviceType getDeviceType()
  {
    return this.deviceType;
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public static final class a
  {
    public final EnumFeedbackCategory a(String paramString)
    {
      for (EnumFeedbackCategory localEnumFeedbackCategory : ) {
        if (j.a(localEnumFeedbackCategory.getValue(), paramString)) {
          return localEnumFeedbackCategory;
        }
      }
      return EnumFeedbackCategory.OTHER;
    }
    
    public final EnumFeedbackCategory b(String paramString)
    {
      paramString = EnumDeviceType.fromType(paramString);
      for (EnumFeedbackCategory localEnumFeedbackCategory : EnumFeedbackCategory.values()) {
        if (localEnumFeedbackCategory.getDeviceType() == paramString) {
          return localEnumFeedbackCategory;
        }
      }
      return EnumFeedbackCategory.OTHER;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\EnumFeedbackCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
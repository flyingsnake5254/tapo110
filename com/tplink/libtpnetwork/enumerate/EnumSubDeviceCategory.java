package com.tplink.libtpnetwork.enumerate;

public enum EnumSubDeviceCategory
{
  private final String deviceCategory;
  
  static
  {
    EnumSubDeviceCategory localEnumSubDeviceCategory1 = new EnumSubDeviceCategory("SUBG_TRIGGER", 0, "subg.trigger");
    SUBG_TRIGGER = localEnumSubDeviceCategory1;
    EnumSubDeviceCategory localEnumSubDeviceCategory2 = new EnumSubDeviceCategory("SUBG_PLUGSWITCH", 1, "subg.plugswitch");
    SUBG_PLUGSWITCH = localEnumSubDeviceCategory2;
    EnumSubDeviceCategory localEnumSubDeviceCategory3 = new EnumSubDeviceCategory("SUBG_TRV", 2, "subg.trv");
    SUBG_TRV = localEnumSubDeviceCategory3;
    $VALUES = new EnumSubDeviceCategory[] { localEnumSubDeviceCategory1, localEnumSubDeviceCategory2, localEnumSubDeviceCategory3 };
  }
  
  private EnumSubDeviceCategory(String paramString)
  {
    this.deviceCategory = paramString;
  }
  
  public String getCategory()
  {
    return this.deviceCategory;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumSubDeviceCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
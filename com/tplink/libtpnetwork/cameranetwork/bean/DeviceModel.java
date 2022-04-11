package com.tplink.libtpnetwork.cameranetwork.bean;

import java.io.Serializable;

public enum DeviceModel
  implements Serializable
{
  private Integer id;
  private String value;
  
  static
  {
    DeviceModel localDeviceModel1 = new DeviceModel("CAMERA_OTHER", 0, Integer.valueOf(0), "Other");
    CAMERA_OTHER = localDeviceModel1;
    DeviceModel localDeviceModel2 = new DeviceModel("CAMERA_C200", 1, Integer.valueOf(8), "C200");
    CAMERA_C200 = localDeviceModel2;
    DeviceModel localDeviceModel3 = new DeviceModel("CAMERA_C100", 2, Integer.valueOf(9), "C100");
    CAMERA_C100 = localDeviceModel3;
    DeviceModel localDeviceModel4 = new DeviceModel("CAMERA_C310", 3, Integer.valueOf(10), "C310");
    CAMERA_C310 = localDeviceModel4;
    DeviceModel localDeviceModel5 = new DeviceModel("CAMERA_TC60", 4, Integer.valueOf(11), "TC60");
    CAMERA_TC60 = localDeviceModel5;
    DeviceModel localDeviceModel6 = new DeviceModel("CAMERA_TC70", 5, Integer.valueOf(12), "TC70");
    CAMERA_TC70 = localDeviceModel6;
    DeviceModel localDeviceModel7 = new DeviceModel("CAMERA_C210", 6, Integer.valueOf(13), "C210");
    CAMERA_C210 = localDeviceModel7;
    DeviceModel localDeviceModel8 = new DeviceModel("CAMERA_C110", 7, Integer.valueOf(14), "C110");
    CAMERA_C110 = localDeviceModel8;
    DeviceModel localDeviceModel9 = new DeviceModel("CAMERA_C320WS", 8, Integer.valueOf(15), "C320WS");
    CAMERA_C320WS = localDeviceModel9;
    DeviceModel localDeviceModel10 = new DeviceModel("CAMERA_TC65", 9, Integer.valueOf(16), "TC65");
    CAMERA_TC65 = localDeviceModel10;
    $VALUES = new DeviceModel[] { localDeviceModel1, localDeviceModel2, localDeviceModel3, localDeviceModel4, localDeviceModel5, localDeviceModel6, localDeviceModel7, localDeviceModel8, localDeviceModel9, localDeviceModel10 };
  }
  
  private DeviceModel(Integer paramInteger, String paramString)
  {
    this.id = paramInteger;
    this.value = paramString;
  }
  
  public static DeviceModel fromId(int paramInt)
  {
    for (DeviceModel localDeviceModel : ) {
      if (localDeviceModel.id.intValue() == paramInt) {
        return localDeviceModel;
      }
    }
    return CAMERA_OTHER;
  }
  
  public static DeviceModel fromValue(String paramString)
  {
    if (paramString == null) {
      return CAMERA_OTHER;
    }
    boolean bool = paramString.matches(".*\\(.*\\)$");
    int i = 0;
    String str;
    if (bool)
    {
      str = paramString.substring(0, paramString.indexOf("("));
    }
    else
    {
      str = paramString;
      if (paramString.contains(" ")) {
        str = paramString.substring(0, paramString.indexOf(" "));
      }
    }
    paramString = values();
    int j = paramString.length;
    while (i < j)
    {
      DeviceModel localDeviceModel = paramString[i];
      if (localDeviceModel.value.equalsIgnoreCase(str)) {
        return localDeviceModel;
      }
      i++;
    }
    return CAMERA_OTHER;
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public String toString()
  {
    return value();
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\DeviceModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
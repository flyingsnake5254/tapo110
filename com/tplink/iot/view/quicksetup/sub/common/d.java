package com.tplink.iot.view.quicksetup.sub.common;

public class d
{
  public static int a(SubDeviceModel paramSubDeviceModel)
  {
    int i;
    if (SubDeviceModel.SENSOR_T100 == paramSubDeviceModel) {
      i = 2131689772;
    } else if (SubDeviceModel.SENSOR_T110 == paramSubDeviceModel) {
      i = 2131689773;
    } else if (SubDeviceModel.SWITCH_S220 == paramSubDeviceModel) {
      i = 2131689771;
    } else if (SubDeviceModel.BUTTON_S200B == paramSubDeviceModel) {
      i = 2131689769;
    } else if (SubDeviceModel.SWITCH_S210 == paramSubDeviceModel) {
      i = 2131689770;
    } else if (SubDeviceModel.TRV_E100 == paramSubDeviceModel) {
      i = 2131231653;
    } else {
      i = 2131231503;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\common\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
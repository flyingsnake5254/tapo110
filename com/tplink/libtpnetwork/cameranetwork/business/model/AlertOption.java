package com.tplink.libtpnetwork.cameranetwork.business.model;

public enum AlertOption
{
  static
  {
    AlertOption localAlertOption1 = new AlertOption("SOUND", 0);
    SOUND = localAlertOption1;
    AlertOption localAlertOption2 = new AlertOption("LIGHT", 1);
    LIGHT = localAlertOption2;
    AlertOption localAlertOption3 = new AlertOption("BOTH", 2);
    BOTH = localAlertOption3;
    $VALUES = new AlertOption[] { localAlertOption1, localAlertOption2, localAlertOption3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\model\AlertOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */